package com.example.coffeeshop;

import javax.persistence.*;

@Entity
@Table
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String name;
    double price;
    public Coffee() {
    }
    public Coffee(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Coffee(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public void updateCoffee(Coffee c) {
        this.name = c.name;
        this.price = c.price;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Coffee [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}
