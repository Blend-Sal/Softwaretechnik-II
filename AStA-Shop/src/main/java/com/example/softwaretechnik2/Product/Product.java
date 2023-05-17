package com.example.softwaretechnik2.Product;

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
    private String image;

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
    private Availability availability;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

    public void setHalal(boolean halal) {
        this.halal = halal;
    }

    public boolean isKosher() {
        return kosher;
    }

    public void setKosher(boolean kosher) {
        this.kosher = kosher;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
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

    public Product copy() {
        Product clone = new Product();
        clone.productName = this.productName;
        clone.category = this.category;
        clone.isBought = this.isBought;
        return clone;
    }
}
