package com.example.md4_ss15_baith3_uploadfile.service;

import com.example.md4_ss15_baith3_uploadfile.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService {
    List<Product> products = new ArrayList<>();
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getId()) == null) {
            products.add(product);
        } else {
            products.set(products.indexOf(findById(product.getId())),product);
        }
    }

    @Override
    public Product findById(int id) {
        for (Product product:findAll()) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        products.remove(findById(id));
    }
}
