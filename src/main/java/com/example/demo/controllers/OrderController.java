package com.example.demo.controllers;

import com.example.demo.entities.CustomerOrder;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.PizzaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final PizzaRepository pizzaRepository;

    private final OrderRepository orderRepository;

    public OrderController(PizzaRepository pizzaRepository, OrderRepository orderRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
    }

    // Exempel: /orderpizza/telefonnummer-pizzaid,pizzaid,pizzaid
    @PostMapping(value = "/orderpizza/{pizzaOrder}")
    public void pizzaOrder(@PathVariable String pizzaOrder) {
        String[] urlSplit = pizzaOrder.split("-");
        String[] orderedPizzas = urlSplit[1].split(",");
        String[] pizzaArray = new String[orderedPizzas.length];
        StringBuffer pizza = new StringBuffer();
        int price = 0;
        for (int i = 0; i < orderedPizzas.length; i++) {
            price += pizzaRepository.getById(Long.parseLong(orderedPizzas[i])).getPrice();
            pizzaArray[i] = pizzaRepository.getById(Long.parseLong(orderedPizzas[i])).getName();
            pizza.append(pizzaArray[i] + ", ");
        }
        String pizzas = pizza.toString();
        orderRepository.save(new CustomerOrder(urlSplit[0], price, pizzas.substring(0, pizzas.length() - 2)));
    }

}
