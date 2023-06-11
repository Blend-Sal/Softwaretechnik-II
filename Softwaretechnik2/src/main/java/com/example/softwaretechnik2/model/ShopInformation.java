package com.example.softwaretechnik2.model;

import javax.persistence.*;

@Entity
@Table(name = "shopinfo")
public class ShopInformation {

    @Id
    @Column(name = "Name", length = 191)
    private String name = "AStA-Shop";

    @Column(name = "Street")
    private String street = "Stephensonstraße 1-3";

    @Column(name = "City")
    private String city = "23562, Lübeck";

    @Column(name = "Building")
    private int building = 25;

    @Column(name = "Email")
    private String email = "info@asta.thl.de";

    @Column(name = "Phone")
    private String phone = "+49 451 300 - 5116";

    @Column(name = "OpenHours")
    private String openHours = "Mo-Fr ab 7:00 Uhr. Solange, bis alles alle ist.";

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ShopInformation{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", building=" + building +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", openHours='" + openHours + '\'' +
                '}';
    }
}
