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
        try {
            return service.saveProduct(product);
        }
        catch (Exception e)
        {
            throw new RequestException("Not able to add product");
        }
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
        try {
            return service.getProductById(id);
        }
        catch (Exception e) {
            throw new RequestException("Cannot get product by id");
        }
    }

    @PutMapping(value = "/update")
    public Product updateProduct(@RequestBody Product product) {
        try {
            return service.updateProduct(product);
        }
        catch (Exception e) {
            throw new RequestException("Cannot update product");
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        try {
            return service.deleteProduct(id);
        }
        catch (Exception e) {
            throw new RequestException("Cannot delete product");
        }
    }
}