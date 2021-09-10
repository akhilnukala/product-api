package com.ford.exercise.productapi.repository;

import com.ford.exercise.productapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.price > ?1 and p.price < ?2")
    List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findBySkuId(int skuId);

    List<Product> findByAvailable(boolean available);
}
