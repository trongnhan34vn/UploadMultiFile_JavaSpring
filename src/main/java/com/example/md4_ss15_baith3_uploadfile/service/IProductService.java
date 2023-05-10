package com.example.md4_ss15_baith3_uploadfile.service;

import com.example.md4_ss15_baith3_uploadfile.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void remove(int id);
}
