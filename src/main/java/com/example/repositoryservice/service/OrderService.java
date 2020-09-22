package com.example.repositoryservice.service;

import com.example.repositoryservice.viewObjects.OrderVO;

import java.util.List;

public interface OrderService {

    void createOrder(OrderVO orderVO);

    List<OrderVO> getOrdersByUserId(int id);

    List<OrderVO> getAllOrders();
}
