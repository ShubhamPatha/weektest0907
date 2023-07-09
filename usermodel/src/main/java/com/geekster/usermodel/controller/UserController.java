package com.geekster.usermodel.controller;

import com.geekster.usermodel.model.Order1;
import com.geekster.usermodel.model.User;
import com.geekster.usermodel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

@Autowired
UserService userService;
    @PostMapping("Create_User")
    public void createUser(@RequestBody User user)
    {
        userService.addUser(user);
    }
    @GetMapping("user/{id}")
    public Order1 getOrderById(@PathVariable Integer id){
        return userService.getuserbyid(id);
    }





}
