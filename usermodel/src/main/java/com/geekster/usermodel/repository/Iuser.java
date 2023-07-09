package com.geekster.usermodel.repository;

import com.geekster.usermodel.model.Order1;
import com.geekster.usermodel.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iuser extends CrudRepository<User,Integer> {
    @Query(value = "select * from user where user_id= :id" , nativeQuery = true)
    Order1 getuserbyId(Integer id);
}
