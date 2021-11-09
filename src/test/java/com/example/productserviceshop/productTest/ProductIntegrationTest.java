package com.example.productserviceshop.productTest;

import com.example.productserviceshop.entity.Product;
import com.example.productserviceshop.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ProductIntegrationTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void getAllProducts() throws Exception {

        List<Product> product = new ArrayList<>();

        when(productService.getProducts())
                .thenReturn(product);
        mockMvc.perform(get("/api/products/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createProduct() throws Exception {

        mockMvc.perform(post("/api/addProduct/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(
                        new Product(1, "Fries", "nice fries", "20", "https://Niceimage.com")))
        ).andExpect(status().isOk());
    }

    @Test
    void deleteProductById() throws Exception {

        when(productService.deleteProduct(1))
                .thenReturn("Product deleted" + 1);
        mockMvc.perform(delete("/api/delete/" + 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Product deleted" + 1)));
    }

    @Test
    void getProductById() throws Exception {

        Product prod = new Product();

        when(productService.getProductById(1))
                .thenReturn(prod);
        mockMvc.perform(get("/api/product/" + 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateProduct() throws Exception {

        mockMvc.perform(put("/api/update/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(
                        new Product(1, "Fries", "nice fries", "20", "https://Niceimage.com")))
        ).andExpect(status().isOk());
    }
}
