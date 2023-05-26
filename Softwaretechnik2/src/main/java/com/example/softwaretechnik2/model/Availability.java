package com.example.softwaretechnik2.model;

public enum Availability {
    EMPTY("Empty"),
    LOW("Low"),
    HALF("Half"),
    NEARLY_FULL("Nearly full"),
    FULL("Full");

    private final String displayValue;

    private Availability(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
