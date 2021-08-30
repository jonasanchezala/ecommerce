package com.napptilus.ecommerce.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test1() throws Exception {
        this.mockMvc.perform(get("/api/price?dateApplied=2020-06-14-10.00.00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList", equalTo(1)))
                .andExpect(jsonPath("$.price", equalTo(35.5)))
        ;
    }

    @Test
    void test2() throws Exception {
        this.mockMvc.perform(get("/api/price?dateApplied=2020-06-14-16.00.00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList", equalTo(2)))
                .andExpect(jsonPath("$.price", equalTo(25.45)))
        ;
    }

    @Test
    void test3() throws Exception {
        this.mockMvc.perform(get("/api/price?dateApplied=2020-06-14-21.00.00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList", equalTo(1)))
                .andExpect(jsonPath("$.price", equalTo(35.5)))
        ;
    }

    @Test
    void test4() throws Exception {
        this.mockMvc.perform(get("/api/price?dateApplied=2020-06-15-10.00.00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList", equalTo(3)))
                .andExpect(jsonPath("$.price", equalTo(30.5)))
        ;
    }

    @Test
    void test5() throws Exception {
        this.mockMvc.perform(get("/api/price?dateApplied=2020-06-16-21.00.00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList", equalTo(4)))
                .andExpect(jsonPath("$.price", equalTo(38.95)))
        ;

    }
}