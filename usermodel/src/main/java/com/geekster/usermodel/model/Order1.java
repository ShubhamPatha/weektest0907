package com.geekster.usermodel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order1 {
    @Id
    private Integer order_id;
    @OneToOne
    @JoinColumn(name="user_id")
    User user;


    @OneToOne
    @JoinColumn(name="product_id")
    Product product;


    @OneToOne
    @JoinColumn(name="Address_id")
    Address address;

   private Integer order_productQuantity;
}
