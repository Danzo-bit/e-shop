package com.ecommerce.shop.data.repository;

import com.ecommerce.shop.data.model.Currency;
import com.ecommerce.shop.data.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/insert.sql"})
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepositoryImpl;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void createProductTest(){
        Product product = new Product();
        product.setName("Luxury Sofa");
        product.setPrice(400D);
        product.setCurrency(Currency.NGN);
        product.setDetails(" wings shield kinda sofa");

        assertThat(product).isNotNull();
        assertThat(product.getId()).isNull();
        log.info("product before saving -> {}", product);
        productRepositoryImpl.save(product);

        assertThat(product.getId()).isNotNull();
        log.info("product after saving -> {}", product);

    }

    @Test
    @Transactional
    public void whenFindAllProductIsCalledAndProductListIsReturnedTest(){

        List<Product> products = productRepositoryImpl.findAll();
        assertThat(products).hasSize(4);
        log.info("Product returned from database -> {}", products);
    }

    @Test
    public void findExistingProductById(){
       Product existingProduct = productRepositoryImpl.findById(110L).orElse(null);

       assertThat(existingProduct).isNotNull();
       log.info("Product -> {}",existingProduct);
    }
    @Test
    public void deleteExistingProductById(){
        assertThat(productRepositoryImpl.findById(110l).orElse(null)).isNotNull();
        productRepositoryImpl.deleteById(110l);
        assertThat(productRepositoryImpl.findById(110l).orElse(null)).isNull();


    }
}