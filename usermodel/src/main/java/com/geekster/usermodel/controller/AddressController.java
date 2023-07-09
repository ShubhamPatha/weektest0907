package com.geekster.usermodel.controller;

import com.geekster.usermodel.model.Address;
import com.geekster.usermodel.model.Product;
import com.geekster.usermodel.model.User;
import com.geekster.usermodel.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("Add_Address")
    public void AddAddress(@RequestBody Address address)
    {
        addressService.addAddresss(address);
    }


}
