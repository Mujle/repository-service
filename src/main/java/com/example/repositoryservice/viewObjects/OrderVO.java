package com.example.repositoryservice.viewObjects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderVO {

    private long orderId;

    private int userId;

    private Date orderDate;

    private List<OrderProductVO> orderProducts = new ArrayList<>();

    public OrderVO() {
    }

    public OrderVO(long orderId) {
        this.orderId = orderId;
    }

    public OrderVO(long orderId, int userId) {
        this.orderId = orderId;
        this.userId = userId;
    }

    public OrderVO(long orderId, int userId, Date orderDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
    }

    public OrderVO(int userId) {
        this.userId = userId;
    }

    public OrderVO(int userId, List<OrderProductVO> orderProducts) {
        this.userId = userId;
        this.orderProducts = orderProducts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<OrderProductVO> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductVO> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}

