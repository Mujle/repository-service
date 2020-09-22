package com.example.repositoryservice.repository;

import com.example.repositoryservice.domain.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {

    @Modifying
    @Query(value = "INSERT INTO order_product(product_id, warehouse_order_id, number_of_ordered_products) VALUES (:productId, :warehouseOrderId, :numberOfOrderedProducts)", nativeQuery = true)
    void saveOrderProduct(int productId, int warehouseOrderId, int numberOfOrderedProducts);

    List<OrderProduct> findByWarehouseOrderIdIn(List<Integer> id);
}
