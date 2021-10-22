package com.example.productserviceshop.service;

import com.example.productserviceshop.entity.Product;
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
        return productRepository.save(product);
    }

    //get products
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById (int id) {
        return productRepository.findById(id).orElse(null);
    }

    //delete product
    public String deleteProduct(int id) {
        productRepository.deleteById(id);

        return "Product deleted" + id;
    }

    //update user
    public Product updateProduct(Product product) {
        Product existingProduct=productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());

        return productRepository.save(existingProduct);
    }
}
