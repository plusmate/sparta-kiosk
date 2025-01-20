package com.example.lv6_1;

public class Cart {
    private final MenuItem menuItem;
    private int quantity;
    private double price;

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void addOrder(double totalPrice) {
        this.quantity++;
        this.price = totalPrice;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Cart(MenuItem menuItem, int quantity, double price) {
        this.menuItem = menuItem;
        this.price = price;
        this.quantity = quantity;
    }
}
