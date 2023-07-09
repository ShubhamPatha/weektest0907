package com.geekster.usermodel.controller;


import com.geekster.usermodel.model.Order1;
import com.geekster.usermodel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
 public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("create_order")
    public void createorder(@RequestBody Order1 order)
    {
        orderService.addOrder(order);
    }

    @GetMapping("order/{id}")
    public Order1 getOrderById(@PathVariable Integer id){
        return orderService.getorderbyid(id);
    }



}
