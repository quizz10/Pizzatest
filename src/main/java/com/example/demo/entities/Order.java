package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String phonenumber;
    private int price;
    private String order;

    public Order(Order order) {
    }

    public Order(String phonenumber, int price, String order) {
        this.phonenumber = phonenumber;
        this.price = price;
        this.order = order;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;    }

    public String getPhonenumber() {return phonenumber;    }

    public void setPhonenumber(String phonenumber) {this.phonenumber = phonenumber;    }

    public int getPrice() {return price;    }

    public void setPrice(int price) {this.price = price;    }

    public String getOrder() {return order;    }

    public void setOrder(String order) {this.order = order;    }
}
