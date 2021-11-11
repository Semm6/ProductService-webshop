package com.example.productserviceshop.service;

import com.example.productserviceshop.entity.Product;
import com.example.productserviceshop.exception.RequestException;
import com.example.productserviceshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //post product
    public Product saveProduct(Product product) {
        try {
            return productRepository.save(product);
        }
        catch (Exception e) {
            throw new RequestException("Product cannot be created");
        }
    }

    //get products
    public List<Product> getProducts() {
        try {
            return productRepository.findAll();
        }
        catch (Exception e) {
            throw new RequestException("Cannot get all products");
        }
    }

    public Product getProductById (int id) {
        try {
            return productRepository.findById(id).orElse(null);
        }
        catch (Exception e) {
            throw new RequestException("Cannot get product by id");
        }
    }

    //delete product
    public String deleteProduct(int id) {
        try {
            productRepository.deleteById(id);
            return "Product deleted" + id;
        }
        catch (Exception e) {
            throw new RequestException("Cannot delete product");
        }
    }

    //update user
    public Product updateProduct(Product product) {
        try {
            Product existingProduct=productRepository.findById(product.getId()).orElse(null);
            existingProduct.setName(product.getName());
            return productRepository.save(existingProduct);
        }
        catch (Exception e) {
            throw new RequestException("Cannot edit product");
        }
    }
}
