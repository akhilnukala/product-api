package com.ford.exercise.productapi.service;

import com.ford.exercise.productapi.repository.ProductRepository;
import com.ford.exercise.productapi.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(int id){
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
       return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<Product> findBySkuId(int skuId) {
        return productRepository.findBySkuId(skuId);
    }

    @Override
    public List<Product> findByAvailability(boolean available) {
        return productRepository.findByAvailable(available);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
