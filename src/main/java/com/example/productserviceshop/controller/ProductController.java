package com.example.productserviceshop.controller;

import com.example.productserviceshop.entity.Product;
import com.example.productserviceshop.exception.RequestException;
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
        try
        {
            return service.getProducts();
        }
        catch (Exception e)
        {
            throw new RequestException("Cannot get all students");
        }
    }

    //Get products
    @GetMapping(value = "/product/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PutMapping(value = "/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}