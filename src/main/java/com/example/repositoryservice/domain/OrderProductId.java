package com.example.repositoryservice.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderProductId implements Serializable {

    @Column(name = "product_id")
    private int productId;

    @Column(name = "warehouse_order_id")
    private int warehouseOrderId;

    public OrderProductId() {
    }

    public OrderProductId(int productId, int warehouseOrderId) {
        this.productId = productId;
        this.warehouseOrderId = warehouseOrderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getWarehouseOrderId() {
        return warehouseOrderId;
    }

    public void setWarehouseOrderId(int warehouseOrderId) {
        this.warehouseOrderId = warehouseOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductId that = (OrderProductId) o;
        return productId == that.productId &&
                warehouseOrderId == that.warehouseOrderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, warehouseOrderId);
    }
}