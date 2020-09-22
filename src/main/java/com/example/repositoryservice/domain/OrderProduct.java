package com.example.repositoryservice.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_product")
public class OrderProduct {

    @EmbeddedId
    private OrderProductId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JsonBackReference(value = "product")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("warehouseOrderId")
    @JsonBackReference(value = "order")
    private WarehouseOrder warehouseOrder;

    @Column(name = "number_of_ordered_products")
    private int numberOfOrderedProducts;


    public OrderProduct() {
    }

    public OrderProduct(OrderProductId id) {
        this.id = id;
    }

    public OrderProduct(Product product, WarehouseOrder warehouseOrder, int numberOfOrderedProducts) {
        this.product = product;
        this.warehouseOrder = warehouseOrder;
        this.numberOfOrderedProducts = numberOfOrderedProducts;
    }

    public OrderProductId getId() {
        return id;
    }

    public void setId(OrderProductId id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public WarehouseOrder getOrders() {
        return warehouseOrder;
    }

    public void setOrders(WarehouseOrder warehouseOrder) {
        this.warehouseOrder = warehouseOrder;
    }

    public WarehouseOrder getWarehouseOrder() {
        return warehouseOrder;
    }

    public void setWarehouseOrder(WarehouseOrder warehouseOrder) {
        this.warehouseOrder = warehouseOrder;
    }

    public int getNumberOfOrderedProducts() {
        return numberOfOrderedProducts;
    }

    public void setNumberOfOrderedProducts(int numberOfOrderedProducts) {
        this.numberOfOrderedProducts = numberOfOrderedProducts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProduct that = (OrderProduct) o;
        return numberOfOrderedProducts == that.numberOfOrderedProducts &&
                Objects.equals(id, that.id) &&
                Objects.equals(product, that.product) &&
                Objects.equals(warehouseOrder, that.warehouseOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, warehouseOrder, numberOfOrderedProducts);
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                ", warehouseOrder=" + warehouseOrder.getId() +
                '}';
    }
}
