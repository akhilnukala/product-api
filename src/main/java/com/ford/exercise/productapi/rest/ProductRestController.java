package com.ford.exercise.productapi.rest;

import com.ford.exercise.productapi.entity.Product;
import com.ford.exercise.productapi.exception.ResourceNotFoundException;
import com.ford.exercise.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name) {
        return new ResponseEntity<>(productService.findByName(name), HttpStatus.OK);
    }

    @GetMapping(params = {"minprice", "maxprice"})
    public ResponseEntity<List<Product>> getProductsByPriceRange(@RequestParam BigDecimal minprice, @RequestParam BigDecimal maxprice) {
        return new ResponseEntity<>(productService.findByPriceRange(minprice, maxprice), HttpStatus.OK);
    }

    @GetMapping(params = "skuid")
    public ResponseEntity<List<Product>> getProductsBySkuId(@RequestParam int skuid) {
        return new ResponseEntity<>(productService.findBySkuId(skuid), HttpStatus.OK);
    }

    @GetMapping(params = "available")
    public ResponseEntity<List<Product>> getProductByAvailability(@RequestParam boolean available) {
        return new ResponseEntity<>(productService.findByAvailability(available), HttpStatus.OK);
    }

    @PostMapping(params = {"id", "price"})
    public ResponseEntity<Product> updatePriceById(@RequestParam int id, @RequestParam BigDecimal price) throws Exception {
        Product tempProduct = productService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));
        tempProduct.setPrice(price);
        return new ResponseEntity<>(productService.updateProduct(tempProduct), HttpStatus.OK);
    }

    @PostMapping(params = {"id", "available"})
    public ResponseEntity<Product> updateAvailabilityById(@RequestParam int id, @RequestParam boolean available) throws Exception {
        Product tempProduct = productService.findById(id).orElseThrow(() -> new Exception(""));;
        tempProduct.setAvailable(available);
        return new ResponseEntity<>(productService.updateProduct(tempProduct), HttpStatus.OK);
    }
}
