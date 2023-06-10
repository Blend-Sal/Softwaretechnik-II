package com.example.softwaretechnik2.model;

public enum Availability {
    EMPTY("Leer"),
    LOW("Gering"),
    HALF("Hälfte noch da"),
    NEARLY_FULL("Nahezu voll"),
    FULL("Voll");

    private final String displayValue;

    private Availability(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
