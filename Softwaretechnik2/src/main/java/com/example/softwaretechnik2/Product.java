package com.example.softwaretechnik2;

import javax.persistence.*;
import java.awt.color.ProfileDataException;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Product_ID")
    private Long id;

    @Column(name = "Productname")
    private String productName;

    @Column(name = "IsBought")
    private boolean isBought = false;

    @Column(name = "Category")
    private String category;

    public boolean isEqualTo(Product anotherProduct) {
        return this.productName.equals(anotherProduct.productName);
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", isBought=" + isBought +
                ", category='" + category + '\'' +
                '}';
    }

    public Product copy() {
        Product clone = new Product();
        clone.productName = this.productName;
        clone.category = this.category;
        clone.isBought = this.isBought;
        return clone;
    }
}
