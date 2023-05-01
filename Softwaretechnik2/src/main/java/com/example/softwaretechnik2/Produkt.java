package com.example.softwaretechnik2;

import javax.persistence.*;

@Entity
@Table(name = "produkt")
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Produkt_ID")
    private Long id;

    @Column(name = "Produktname")
    private String productName;

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
}
