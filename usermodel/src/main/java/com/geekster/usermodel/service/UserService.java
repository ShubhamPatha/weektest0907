package com.geekster.usermodel.service;

import com.geekster.usermodel.model.Order1;
import com.geekster.usermodel.model.User;
import com.geekster.usermodel.repository.Iuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    Iuser iuser;


    public  void addUser(User user) {
        iuser.save(user);
    }

    public Order1 getuserbyid(Integer id) {
        return iuser.getuserbyId(id);
    }
}
