package com.example.repositoryservice.controller;

import com.example.repositoryservice.service.OrderService;
import com.example.repositoryservice.viewObjects.OrderVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "Make a new order")
    @PostMapping
    public void createOrder(@RequestBody OrderVO orderVO){
        orderService.createOrder(orderVO);
    }

    @ApiOperation(value = "Get all orders by a specific user id")
    @GetMapping(value = "/users/{id}")
    public List<OrderVO> getOrders(@PathVariable("id") int id){

        return orderService.getOrdersByUserId(id);
    }

    @ApiOperation(value = "Get all orders")
    @GetMapping
    public List<OrderVO> getAllOrders(){

        return orderService.getAllOrders();
    }
}
