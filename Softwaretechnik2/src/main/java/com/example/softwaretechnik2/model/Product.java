package com.example.softwaretechnik2.model;

import javax.persistence.*;
import java.util.List;
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

    @Column(name = "Image")
    @Lob
    byte[] image;
    @Column(name = "Allergens")
    private String allergens;

    @Column(name = "Vegan")
    private boolean vegan;

    @Column(name = "Vegetarian")
    private boolean vegetarian;

    @Column(name = "Halal")
    private boolean halal;

    @Column(name = "Kosher")
    private boolean kosher;

    @Column(name = "Availability")
    private String availability;

    @Column(name = "Price")
    private float price;

    @ElementCollection
    @Column(name = "Ingredients")
    private List<String> ingredients;

    public boolean isEqualTo(Product anotherProduct) {
        return this.productName.equals(anotherProduct.productName);
    }

    public String getCategory() {
        return category;
    }

    public boolean setCategory(String category) {
        if (category.matches("\\d+")) {
            return false;
        } else {
            this.category = category;
        }
        return true;
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

    public boolean setId(Long id) {
        if (id != null && String.valueOf(id).matches("\\d+" + "L")) {
            return false;
        } else {
            this.id = id;
        }
        return true;
    }

    public String getProductName() {
        return productName;
    }

    public boolean setProductName(String productName) {
        if (productName.matches("\\d+")) {
            return false;
        } else {
            this.productName = productName;
        }
        return true;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isHalal() {
        return halal;
    }

    public boolean setHalal(boolean halal) {
        if (!halal) {
            return false;
        } else {
            this.halal = halal;
        }
        return true;
    }

    public boolean isKosher() {
        return kosher;
    }

    public void setKosher(boolean kosher) {
        this.kosher = kosher;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability.getDisplayValue();
    }

    public float getPrice() {
        return price;
    }

    public boolean setPrice(float price) {
        if (id != null && String.valueOf(id).matches("\\d+")) {
            return false;
        } else {
            this.price = price;
        }
        return true;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public boolean setIngredients(List<String> ingredients) {
        String regex = "^[a-zA-ZäöüÄÖÜ,\\s]+$";
        if (!ingredients.stream().allMatch(ingredient -> ingredient.matches(regex))) {
            return false;
        } else {
            this.ingredients = ingredients;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", isBought=" + isBought +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", allergens='" + allergens + '\'' +
                ", vegan=" + vegan +
                ", vegetarian=" + vegetarian +
                ", halal=" + halal +
                ", kosher=" + kosher +
                ", availability=" + availability +
                ", price=" + price +
                ", ingredients=" + ingredients +
                '}';
    }
}
