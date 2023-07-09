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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Address_id;
    private String Address_name;
    private String Address_landmark;
    private String Address_phoneNumber;
    private String Address_zipcode;
    private String Address_state;
//mappings
    @OneToOne
        @JoinColumn(name ="USER_ID_FK")
    User user;


}
