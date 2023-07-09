package com.geekster.usermodel.repository;

import com.geekster.usermodel.model.Order1;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iorder extends CrudRepository<Order1,Integer> {

    @Query(value = "select * from order1 where order_id= :id" , nativeQuery = true)
    Order1 getorderbyId(Integer id);
}
