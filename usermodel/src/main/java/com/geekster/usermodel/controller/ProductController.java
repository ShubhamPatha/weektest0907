package com.geekster.usermodel.controller;

import com.geekster.usermodel.model.Order1;
import com.geekster.usermodel.model.Product;
import com.geekster.usermodel.model.User;
import com.geekster.usermodel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PutMapping("product/{id}")
    public void deleteproduct(@PathVariable Integer id)
    {
        productService.removeproduct(id);
    }

    @PostMapping("Add_Product")
    public void AddProduct(@RequestBody Product product)
    {productService.addProduct(product);
    }

    @GetMapping("product")
    public Iterable<Product>  getAllproduct(@PathVariable Integer id){
        return productService.getAllproduct(id);
    }





}
