package com.example.repositoryservice.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int price;

    private double mass;

    private double alcohol;

    private String picture;

    private int amount;

    @Column(name = "user_id")
    private Integer userId;

    @OneToMany(
            mappedBy = "warehouseOrder",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference(value = "product")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public Product() {
    }

    public Product(int id) {
        this.id = id;
    }

    public Product(int id, String name, int price, double mass, double alcohol, String picture, int amount, Integer userId, List<OrderProduct> orderProducts) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.mass = mass;
        this.alcohol = alcohol;
        this.picture = picture;
        this.amount = amount;
        this.userId = userId;
        this.orderProducts = orderProducts;
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                price == product.price &&
                Double.compare(product.mass, mass) == 0 &&
                Double.compare(product.alcohol, alcohol) == 0 &&
                amount == product.amount &&
                Objects.equals(name, product.name) &&
                Objects.equals(picture, product.picture) &&
                Objects.equals(userId, product.userId) &&
                Objects.equals(orderProducts, product.orderProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, mass, alcohol, picture, amount, userId, orderProducts);
    }
}
