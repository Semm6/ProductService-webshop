package com.example.productserviceshop.controller;

import com.example.productserviceshop.entity.Product;
import com.example.productserviceshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/")
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    //Get products
    @GetMapping(value = "/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    //Get products
    @GetMapping(value = "/product/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PutMapping(value = "/update")
    public Product updateProduct(@RequestBody Product user) {
        return service.updateProduct(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}