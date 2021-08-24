package com.example.demo.controllers;

import com.example.demo.repositories.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {PizzaController.class})
public class PizzaControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PizzaRepository pizzaRepository;

    @Test
    void getAllPizzas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pizzas"))
                .andExpect(status().is(200));
    }
}
