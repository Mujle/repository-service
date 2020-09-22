package com.example.repositoryservice.serviceImplementations;

import com.example.repositoryservice.domain.OrderProduct;
import com.example.repositoryservice.domain.WarehouseOrder;
import com.example.repositoryservice.domain.Product;
import com.example.repositoryservice.repository.OrderProductRepository;
import com.example.repositoryservice.repository.OrderRepository;
import com.example.repositoryservice.repository.ProductRepository;
import com.example.repositoryservice.service.OrderServiceImpl;
import com.example.repositoryservice.viewObjects.OrderProductVO;
import com.example.repositoryservice.viewObjects.OrderVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class OrderServiceImplTest {


    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private OrderProductRepository orderProductRepository;

    @Mock
    private OrderRepository orderRepository;

    private Product productTest;
    private List<Product> productsTest;
    private String name = "beer";
    private WarehouseOrder warehouseOrder;
    private List<Integer> listOfIds = new ArrayList<>();

    private Optional<Product> optProductTest;
    private Optional<WarehouseOrder> optOrdersTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        OrderProduct op = new OrderProduct();
        List<OrderProduct> orderProductList = new ArrayList<>();
        orderProductList.add(op);

        productTest = new Product(1, name, 225, 1.5, 4.5,
                "picture", 46, 1, orderProductList);

        productsTest = new ArrayList<>();
        productsTest.add(productTest);

        warehouseOrder = new WarehouseOrder(1);

        optProductTest = Optional.of(productTest);
        optOrdersTest = Optional.of(warehouseOrder);

        listOfIds.add(1);
    }

    @Test
    void newOrder() {

        OrderProductVO productVO = new OrderProductVO(1, name, 53);
        OrderVO orderVO = new OrderVO();
        orderVO.getOrderProducts().add(productVO);
        orderRepository.save(warehouseOrder);

        when(productRepository.findById(anyInt())).thenReturn(optProductTest);

        orderService.createOrder(orderVO);

        verify(productRepository, times(1)).save(productTest);
        verify(orderRepository, times(1)).save(warehouseOrder);
        verify(orderProductRepository, times(1)).saveOrderProduct(1,0,53);

    }

    @Test
    void getOrdersByUser() {

        List<WarehouseOrder> warehouseOrderList = new ArrayList<>();
        warehouseOrderList.add(warehouseOrder);

        OrderProduct orderProductTest = new OrderProduct(productTest, warehouseOrder, 55);
        List<OrderProduct> orderProducts = new ArrayList<>();
        orderProducts.add(orderProductTest);


        when(orderRepository.findByUserId(anyInt())).thenReturn(warehouseOrderList);
        when(orderRepository.findById(anyInt())).thenReturn(optOrdersTest);
        when(productRepository.findById(anyInt())).thenReturn(optProductTest);
        when(orderProductRepository.findByWarehouseOrderIdIn(anyList())).thenReturn(orderProducts);

        List<OrderVO> orderVOS = orderService.getOrdersByUserId(1);

        assertEquals(orderVOS.get(0).getUserId(), warehouseOrder.getUserId());
    }

    @Test
    void getAllOrders() {

        List<WarehouseOrder> warehouseOrderList = new ArrayList<>();
        warehouseOrderList.add(warehouseOrder);

        OrderProduct orderProductTest = new OrderProduct(productTest, warehouseOrder, 55);
        List<OrderProduct> orderProducts = new ArrayList<>();
        orderProducts.add(orderProductTest);

        when(orderRepository.findAll()).thenReturn(warehouseOrderList);
        when(orderRepository.findById(anyInt())).thenReturn(optOrdersTest);
        when(productRepository.findById(anyInt())).thenReturn(optProductTest);
        when(orderProductRepository.findByWarehouseOrderIdIn(anyList())).thenReturn(orderProducts);

        List<OrderVO> orderVOS = orderService.getAllOrders();

        assertEquals(orderVOS.get(0).getUserId(), warehouseOrder.getUserId());
    }
}