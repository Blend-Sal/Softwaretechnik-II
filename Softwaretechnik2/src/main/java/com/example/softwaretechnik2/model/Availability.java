package com.example.softwaretechnik2.model;

// The Availability enum represents the different states of availability for an item
public enum Availability {
    EMPTY("Leer"),         // Represents an empty state
    LOW("Gering"),         // Represents a low availability state
    HALF("Hälfte noch da"), // Represents a half-filled state
    NEARLY_FULL("Nahezu voll"), // Represents a nearly full state
    FULL("Voll");          // Represents a full state

    // Field for holding the display value of each enum instance
    private final String displayValue;

    // Constructor for setting the display value of each enum instance
    private Availability(String displayValue) {
        this.displayValue = displayValue;
    }

    // Getter method for retrieving the display value of an enum instance
    public String getDisplayValue() {
        return displayValue;
    }
}
