package com.example.repositoryservice.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "product_history")
public class ProductHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "number_of_ordered_products")
    private int numberOfOrderedProducts;

    @Column(name = "changed_on")
    private Date changedOn = new Date();

    @Column(name = "type_of_change", length = 6)
    private String typeOfChange;

    public ProductHistory() {
    }

    public ProductHistory(int id, int productId, int userId, int numberOfOrderedProducts, Date changedOn, String typeOfChange) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.numberOfOrderedProducts = numberOfOrderedProducts;
        this.changedOn = changedOn;
        this.typeOfChange = typeOfChange;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNumberOfOrderedProducts() {
        return numberOfOrderedProducts;
    }

    public void setNumberOfOrderedProducts(int numberOfOrderedProducts) {
        this.numberOfOrderedProducts = numberOfOrderedProducts;
    }

    public Date getChangedOn() {
        return changedOn;
    }

    public void setChangedOn(Date changedOn) {
        this.changedOn = changedOn;
    }

    public String getTypeOfChange() {
        return typeOfChange;
    }

    public void setTypeOfChange(String typeOfChange) {
        this.typeOfChange = typeOfChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductHistory that = (ProductHistory) o;
        return id == that.id &&
                productId == that.productId &&
                userId == that.userId &&
                numberOfOrderedProducts == that.numberOfOrderedProducts &&
                Objects.equals(changedOn, that.changedOn) &&
                Objects.equals(typeOfChange, that.typeOfChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, userId, numberOfOrderedProducts, changedOn, typeOfChange);
    }
}