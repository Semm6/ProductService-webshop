package com.example.productserviceshop.productTest;

import com.example.productserviceshop.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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

@SpringBootTest
@AutoConfigureMockMvc
public class ProductAcceptanceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getProductById() throws Exception {

        mockMvc.perform(get("/api/product/" + 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllProducts() throws Exception {

        mockMvc.perform(get("/api/products/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteProductById() throws Exception {

        mockMvc.perform(delete("/api/delete/" + 3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Product deleted" + 3)));
    }
}
