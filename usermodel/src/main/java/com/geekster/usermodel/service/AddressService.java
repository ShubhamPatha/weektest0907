package com.geekster.usermodel.service;

import com.geekster.usermodel.model.Address;

import com.geekster.usermodel.repository.Iaddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    Iaddress iaddress;




    public void addAddresss(Address k) {
        iaddress.save(k);

    }
}
