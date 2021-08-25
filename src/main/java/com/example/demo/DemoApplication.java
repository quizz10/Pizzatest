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
                pizzaRepository.save(new Pizza("Hawaii", 80, "Tomatsås, Ost, Skinka, Ananas"));
                pizzaRepository.save(new Pizza("Vesuvio", 80, "Tomatsås, Ost, Skinka"));
                pizzaRepository.save(new Pizza("Mama Mia", 85, "Tomatsås, Ost, Skinka, Räkor"));
                pizzaRepository.save(new Pizza("Quattro Stagioni", 100, "Tomatsås, Ost, Skinka, Champinjoner, Räkor, Kronärtskocka"));
                pizzaRepository.save(new Pizza("Mafia", 110, "Tomatsås, Ost, Oxfilé, Ägg, Bacon, Tabasco"));
                pizzaRepository.save(new Pizza("Super KebabPizza", 110, "Tomatsås, Ost, Kebab, Sås, Pommes, Jalapenos, Sallad"));
            }

        };
    }

}
