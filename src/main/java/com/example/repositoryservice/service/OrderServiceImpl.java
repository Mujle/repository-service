package com.example.repositoryservice.service;

import com.example.repositoryservice.domain.OrderProduct;
import com.example.repositoryservice.domain.WarehouseOrder;
import com.example.repositoryservice.domain.Product;
import com.example.repositoryservice.repository.OrderProductRepository;
import com.example.repositoryservice.repository.OrderRepository;
import com.example.repositoryservice.repository.ProductRepository;
import com.example.repositoryservice.viewObjects.OrderProductVO;
import com.example.repositoryservice.viewObjects.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderProductRepository orderProductRepository;

    private final ProductRepository productRepository;

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderProductRepository orderProductRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.orderProductRepository = orderProductRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(OrderVO orderVO) {

        WarehouseOrder order = new WarehouseOrder(orderVO.getUserId());
        orderRepository.save(order);

        List<OrderProductVO> productVOS = orderVO.getOrderProducts();
        for (OrderProductVO p : productVOS) {

            Product product = productRepository.findById(p.getId()).orElse(new Product());
            product.setAmount(product.getAmount() - p.getNumberOfOrderedProducts());
            product.setUserId(orderVO.getUserId());
            productRepository.save(product);

            orderProductRepository.saveOrderProduct(
                    product.getId(),
                    order.getId(),
                    p.getNumberOfOrderedProducts());
        }
    }

    @Override
    public List<OrderVO> getOrdersByUserId(int id) {

        List<WarehouseOrder> warehouseOrders = orderRepository.findByUserId(id);
        return getOrders(warehouseOrders);
    }

    @Override
    public List<OrderVO> getAllOrders() {

        List<WarehouseOrder> warehouseOrder = orderRepository.findAll();
        return getOrders(warehouseOrder);
    }

    List<OrderVO> getOrders(List<WarehouseOrder> warehouseOrders) {

        List<Integer> listOfIds = warehouseOrders.stream()
                .map(WarehouseOrder::getId)
                .collect(Collectors.toList());

        List<OrderProduct> orderProduct = orderProductRepository.findByWarehouseOrderIdIn(listOfIds);

        Stack<OrderVO> orders = new Stack<>();

        for (OrderProduct op : orderProduct) {

            WarehouseOrder oro = orderRepository.findById(op.getOrders().getId()).orElse(new WarehouseOrder());
            OrderVO order = new OrderVO((long) oro.getId(), oro.getUserId(), oro.getCreatedOn());

            Product p = productRepository.findById(op.getProduct().getId()).orElse(new Product());

            OrderProductVO pVO = new OrderProductVO(p.getId(), p.getName(), op.getNumberOfOrderedProducts());

            if (orders.empty() || orders.peek().getOrderId() != order.getOrderId()) {
                order.getOrderProducts().add(pVO);
                orders.push(order);
            } else {
                OrderVO o = orders.pop();
                o.getOrderProducts().add(pVO);
                orders.push(o);
            }
        }
        return orders;
    }
}
