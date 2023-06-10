package com.example.softwaretechnik2.model;

public class ShopInformation {

    private String name;
    private String street;
    private String city;
    private int building;
    private String email;
    private int phone;
    private String openHours;

    public ShopInformation(String name, String street, String city, int building, String email, int phone, String openHours) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.building = building;
        this.email = email;
        this.phone = phone;
        this.openHours = openHours;
    }


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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
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


}
