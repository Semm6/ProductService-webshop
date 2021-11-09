package com.example.productserviceshop.productTest;

import com.example.productserviceshop.entity.Product;
import com.example.productserviceshop.repository.ProductRepository;
import com.example.productserviceshop.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.verify;

@DataJpaTest
public class ProductServiceTest {

    //testing mocked repo

    //mock = mocking is creating objects that simulate the behavior of real objects.
    //so this means that it simulate the behaviour of the repository for products which will get all the products from the database

    @Mock
    private ProductRepository productRepository;
    private AutoCloseable autoCloseable;
    private ProductService underTest;

    //before start of every test
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ProductService(productRepository);
    }

    //end of every test
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void saveProduct() {

        Product prod = new Product();
        //when
        underTest.saveProduct(prod);
        //then
        verify(productRepository).save(prod);
    }

    @Test
    void getProducts() {
        //when
        underTest.getProducts();
        //then
        verify(productRepository).findAll();
    }

    @Test
    void getProductById() {
        //when
        underTest.getProductById(1);
        //then
        verify(productRepository).findById(1);
    }

    @Test
    void deleteProduct() {
        //when
        underTest.deleteProduct(1);
        //then
        verify(productRepository).deleteById(1);
    }
}
