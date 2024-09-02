package com.example.web_store02.productsDAO;

import com.example.web_store02.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsDAO {
    private int ID;

    @Autowired
    private JpaRepository jpaRepository;


    public List<Products> getProductsList() {
        return jpaRepository.findAll();
    }

    public void saveProducts(Products products) {
        products.setId(++ID);
        jpaRepository.save(products);
    }

}
