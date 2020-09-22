package com.example.repositoryservice.viewObjects;

public class OrderProductVO {

    private int id;

    private String name;

    private int numberOfOrderedProducts;

    public OrderProductVO() {
    }

    public OrderProductVO(int id, int numberOfOrderedProducts) {
        this.id = id;
        this.numberOfOrderedProducts = numberOfOrderedProducts;
    }

    public OrderProductVO(int id, String name, int numberOfOrderedProducts) {
        this.id = id;
        this.name = name;
        this.numberOfOrderedProducts = numberOfOrderedProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfOrderedProducts() {
        return numberOfOrderedProducts;
    }

    public void setNumberOfOrderedProducts(int numberOfOrderedProducts) {
        this.numberOfOrderedProducts = numberOfOrderedProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
