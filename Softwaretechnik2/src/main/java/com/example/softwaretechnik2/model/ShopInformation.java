package com.example.softwaretechnik2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Define the class as an entity and map it to the "shopinfo" table in the database
@Entity
@Table(name = "shopinfo")
public class ShopInformation {

    // Fields for various shop information
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

    // Getter and setter methods for the fields

    public String getStreet() {
        return street;
    }

    // Set the street field if it doesn't match the regex (only digits)
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

    // Set the city field if it doesn't match the regex (only digits)
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

    // Set the building field if it matches the regex (only digits)
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

    // Set the email field if it doesn't match the regex (only digits)
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

    // Set the phone field if it matches the regex (only digits)
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

    // Set the openHours field if it doesn't match the regex (only digits)
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

    // Set the name field if it doesn't match the regex (only digits)
    public boolean setName(String name) {
        String regex = "\\d+";
        if (name.matches(regex)) {
            return false;
        } else {
            this.name = name;
        }
        return true;
    }

    // Override the toString method to return a formatted string of the object
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
