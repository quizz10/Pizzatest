package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Order2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String phonenumber;
    private int price;
    private String orders;

    public Order2() {
    }

    public Order2(String phonenumber, int price, String orders) {
        this.phonenumber = phonenumber;
        this.price = price;
        this.orders = orders;
        this.id = id;
    }


    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String order) {
        this.orders = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order2 order2 = (Order2) o;
        return id == order2.id && price == order2.price && Objects.equals(phonenumber, order2.phonenumber) && Objects.equals(orders, order2.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phonenumber, price, orders);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", phonenumber='" + phonenumber + '\'' +
                ", price=" + price +
                ", order='" + orders + '\'' +
                '}';
    }
}
