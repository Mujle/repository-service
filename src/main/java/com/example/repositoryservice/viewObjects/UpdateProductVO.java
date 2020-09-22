package com.example.repositoryservice.viewObjects;

public class UpdateProductVO {

    private int user;

    private int product;

    private int numberOfOrderedProducts;

    public UpdateProductVO() {
    }

    public UpdateProductVO(int user, int product, int numberOfOrderedProducts) {
        this.user = user;
        this.product = product;
        this.numberOfOrderedProducts = numberOfOrderedProducts;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getNumberOfOrderedProducts() {
        return numberOfOrderedProducts;
    }

    public void setNumberOfOrderedProducts(int numberOfOrderedProducts) {
        this.numberOfOrderedProducts = numberOfOrderedProducts;
    }
}
