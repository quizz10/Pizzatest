package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;
import com.example.demo.entities.Pizza;
import com.example.demo.repositories.PizzaRepository;

@Entity
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String phonenumber;
    private int price;
    private String order;

    //private PizzaRepository pizza;

    public Order() {
    }

    public Order(String phonenumber, String order) {
        this.phonenumber = phonenumber;
        this.order = order;
//        List<String> pizzaId = Arrays.asList(order.split(","));
//        for (int i = 0; i < pizzaId.size(); i++) {
//            for(String id: pizzaId){
//                price+=pizza.getById(Long.parseLong(id)).getPrice();
//            }
//        }
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;    }

    public String getPhonenumber() {return phonenumber;    }

    public void setPhonenumber(String phonenumber) {this.phonenumber = phonenumber;    }

    public int getPrice() {return price;    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrder() {return order;    }

    public void setOrder(String order) {
        this.order = order;
    }
}
