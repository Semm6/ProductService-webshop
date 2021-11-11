package com.example.productserviceshop.productTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductAcceptanceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Disabled
    @Test
    void getProductById() throws Exception {

        mockMvc.perform(get("/api/product/" + 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void getAllProducts() throws Exception {

        mockMvc.perform(get("/api/products/"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
