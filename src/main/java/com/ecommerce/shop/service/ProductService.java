package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    Product finById(Long id);

    void deleteById(Long id);

    List<Product> saveAll(List<Product> products);
}
