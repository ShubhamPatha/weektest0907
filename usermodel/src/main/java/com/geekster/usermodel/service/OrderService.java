package com.geekster.usermodel.service;

import com.geekster.usermodel.model.Order1;
import com.geekster.usermodel.repository.Iorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    Iorder iorder;

    public  void addOrder(Order1 order) {
        iorder.save(order);
    }


    public Order1 getorderbyid(Integer id) {
        return  iorder.getorderbyId(id);
    }
}
