package com.example.softwaretechnik2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    public boolean setStreet(String street) {
        String regex = "\\d+";
        if (street.matches(regex)) {
            return false;
        } else {
            this.street = street;
        }
        return true;
    }

    public String getCity() {
        return city;
    }

    public boolean setCity(String city) {
        String regex = "\\d+";
        if (city.matches(regex)) {
            return false;
        } else {
            this.city = city;
        }
        return true;
    }

    public int getBuilding() {
        return building;
    }

    public boolean setBuilding(int building) {
        if (String.valueOf(building).matches("\\d+")) {
            this.building = building;
        } else {
            return false;
        }
        return true;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        String regex = "\\d+";
        if (email.matches(regex)) {
            return false;
        } else {
            this.email = email;
        }
        return true;
    }

    public String getPhone() {
        return phone;
    }

    public boolean setPhone(String phone) {
        String regex = "\\d+";
        if (phone.matches(regex)) {
            this.phone = phone;
        } else {
            return false;
        }
        return true;
    }

    public String getOpenHours() {
        return openHours;
    }

    public boolean setOpenHours(String openHours) {
        String regex = "\\d+";
        if (openHours.matches(regex)) {
            return false;
        } else {
            this.openHours = openHours;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        String regex = "\\d+";
        if (name.matches(regex)) {
            return false;
        } else {
            this.name = name;
        }
        return true;
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
