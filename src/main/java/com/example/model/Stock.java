package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "stocks")
public class Stock implements Serializable {

    private final static long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "emitent_name", nullable = false)
    private String emitent;
    @Column(name = "price")
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmitent() {
        return emitent;
    }

    public void setEmitent(String emitent) {
        this.emitent = emitent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;
        Stock stock = (Stock) o;
        return getId() == stock.getId() &&
                Double.compare(stock.getPrice(), getPrice()) == 0 &&
                getName().equals(stock.getName()) &&
                getEmitent().equals(stock.getEmitent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmitent(), getPrice());
    }
}
