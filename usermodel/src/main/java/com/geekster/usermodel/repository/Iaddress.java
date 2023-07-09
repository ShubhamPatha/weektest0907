package com.geekster.usermodel.repository;

import com.geekster.usermodel.model.Address;
import com.geekster.usermodel.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iaddress extends CrudRepository<Address,Integer> {
}
