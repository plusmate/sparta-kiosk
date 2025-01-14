package com.example.lv2;

public class MenuItem {
    private String name;
    private double price;
    private String description;

    public MenuItem() {
    }

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
