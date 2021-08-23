package com.example.demo.controllers;

import com.example.demo.entities.CustomerOrder;
import com.example.demo.entities.Pizza;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.PizzaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController // Konverterar listan till jsondata så att det kan användas på webben
public class PizzaController {

    private final PizzaRepository pizzaRepository;

    private final OrderRepository orderRepository;


    public PizzaController(PizzaRepository pizzaRepository, OrderRepository orderRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
    }


    @GetMapping(value = "/pizzas/{id}")
    public @ResponseBody
    Optional<Pizza> getPizza(@PathVariable long id) {
        return pizzaRepository.findById(id);
    }

    @DeleteMapping(value = "/deletepizza/{id}")
    public void deletePizza(@PathVariable long id) {
        pizzaRepository.deleteById(id);
    }


    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public List<Pizza> pizzas() {
        return pizzaRepository.findAll();
    }



    @PutMapping(value = "/addpizza/{newPizza}")
    public void addPizza(@PathVariable String newPizza) {
        String[] split = newPizza.split("-");
        pizzaRepository.save(new Pizza(split[0], Integer.parseInt(split[1]), split[2]));
    }

    @GetMapping(value = "/search/{searchString}")
    public List<Pizza> searchInPizzas(@PathVariable String searchString) {

        return pizzaRepository.findAll().stream()
                .filter(p -> p.getIngredients().contains(searchString))
                .collect(Collectors.toList());
    }

    @PatchMapping(value = "/editpizza/{changeString}")
    public void changePizza(@PathVariable String changeString) {
        String[] urlSplit = changeString.split("-");
        Pizza modifiedPizza = pizzaRepository.getById(Long.parseLong(urlSplit[0]));

        String[] ingredientsSplit = modifiedPizza.getIngredients().split(",");

        StringBuffer ingredientsBuffer = new StringBuffer();

        for (int i = 0; i < ingredientsSplit.length; i++) {
            if (ingredientsSplit[i].contains(urlSplit[1])) {
                ingredientsSplit[i] = urlSplit[2];
            }
        }

        for (int i = 0; i < ingredientsSplit.length; i++) {
                ingredientsBuffer.append(ingredientsSplit[i]);
        }
        String newIngredients = ingredientsBuffer.toString();

        modifiedPizza.setIngredients(newIngredients);
        pizzaRepository.save(modifiedPizza);
    }

    @PostMapping(value = "/orderpizza/{pizzaOrder}")
    public void pizzaorder(@PathVariable String pizzaOrder){
        String[] urlSplit = pizzaOrder.split("-");
        String[] orderedPizzas = urlSplit[1].split(",");
        String[] pizzaArray = new String[orderedPizzas.length];
        StringBuffer pizza = new StringBuffer();
        int price = 0;
        for (int i = 0; i < orderedPizzas.length; i++) {
            price += pizzaRepository.getById(Long.parseLong(orderedPizzas[i])).getPrice();
            pizzaArray[i] = pizzaRepository.getById(Long.parseLong(orderedPizzas[i])).getName();
            pizza.append(pizzaArray[i]+", ");
        }
        String pizzas = pizza.toString();
        orderRepository.save(new CustomerOrder(urlSplit[0], price, pizzas.substring(0, pizzas.length()-2)));
    }
}

