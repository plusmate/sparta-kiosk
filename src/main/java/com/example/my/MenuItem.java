package com.example.my;

public class MenuItem {
    private final String name;
    private final double price;
    private final String description;

    public MenuItem(String name, double price, String description) {
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
