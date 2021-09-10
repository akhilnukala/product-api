package com.ford.exercise.productapi.service;

import com.ford.exercise.productapi.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(int id);

    List<Product> findByName(String name);

    List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findBySkuId(int skuId);

    List<Product> findByAvailability(boolean available);

    Product updateProduct(Product product);
}
