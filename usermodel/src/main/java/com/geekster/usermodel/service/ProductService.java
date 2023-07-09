package com.geekster.usermodel.service;

import com.geekster.usermodel.model.Product;
import com.geekster.usermodel.repository.Iproduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    Iproduct iproduct ;

    public  void addProduct(Product product) {
        iproduct.save(product);
    }


    public Iterable<Product> getAllproduct(Integer id) {
        return iproduct.findAll();
    }

    public void removeproduct(Integer id) {
        iproduct.deleteById(id);
    }
}
