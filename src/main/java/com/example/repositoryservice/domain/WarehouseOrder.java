package com.example.repositoryservice.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "warehouse_order")
public class WarehouseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_on")
    private Date createdOn = new Date();

    @OneToMany(
            mappedBy = "warehouseOrder",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference(value = "order")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @Column(name = "user_id")
    private Integer userId;

    public WarehouseOrder() {
    }

    public WarehouseOrder(Integer userId) {
        this.userId = userId;
    }

    public WarehouseOrder(int id, Date createdOn) {
        this.id = id;
        this.createdOn = createdOn;
    }

    public WarehouseOrder(Date createdOn) {
        this.createdOn = createdOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseOrder warehouseOrder = (WarehouseOrder) o;
        return id == warehouseOrder.id &&
                Objects.equals(createdOn, warehouseOrder.createdOn) &&
                Objects.equals(orderProducts, warehouseOrder.orderProducts) &&
                Objects.equals(userId, warehouseOrder.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdOn, orderProducts, userId);
    }
}

