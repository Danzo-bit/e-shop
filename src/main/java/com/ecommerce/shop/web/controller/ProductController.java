package com.ecommerce.shop.web.controller;


import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

//    @Autowired
    ProductService productServiceImpl;

    //3 - ways to wire bean
    //1. field injection
    //2. constructor injection
    //3. setter injection.

    @Autowired
    public  ProductController(ProductService productServiceImpl){
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping("/")
    public List<Product > getAll(){
        return productServiceImpl.findAll();
    }

    @PostMapping("/")
    public Product save(@RequestBody Product product){
        log.info("Product request -> {}", product);
        return productServiceImpl.save(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productServiceImpl.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/saveAll")
    public List<Product> saveAll(@RequestBody List<Product> products){
        return productServiceImpl.saveAll(products);
    }
}
