package com.example.demo;

import com.example.demo.entities.Pizza;
import com.example.demo.repositories.PizzaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(PizzaRepository pizzaRepository) {

        return args -> {
            if (pizzaRepository.count() == 0) {
                pizzaRepository.save(new Pizza("Hawaii", 80, "Tomatsås, ost, Skinka, Ananas"));
                pizzaRepository.save(new Pizza("Vesuvio", 80, "Tomatsås, ost, Skina"));
                pizzaRepository.save(new Pizza("Mama Mia", 85, "Tomatsås, ost, Skinka, räkor"));
                pizzaRepository.save(new Pizza("Quattro Staggioni", 100, "Tomatsås, ost, Skinka, Champinjoner, Räkor, Kronärtskocka"));
                pizzaRepository.save(new Pizza("Maffia", 110, "Tomatsås, Ost, Oxfilé, Ägg, Bacon, Tabasco"));
                pizzaRepository.save(new Pizza("SuperKebabPizza", 110, "Tomatsås, ost, Kebab, Sås, Pommes, Jalapenos, Sallad"));
            }

        };
    }

}
