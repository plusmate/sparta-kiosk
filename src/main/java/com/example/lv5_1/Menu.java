package com.example.lv5_1;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuItem> menuList = new ArrayList<>();
    private static final List<Menu> allMenus = new ArrayList<>();
    FoodType foodType;

    public Menu(FoodType foodType, MenuItem... menu) {
        this.foodType = foodType;
        for (MenuItem menuItem : menu) {
            addMenu(menuItem);
        }

        allMenus.add(this);
    }

    private void addMenu(MenuItem menuItem) {
        menuList.add(menuItem);
    }

    public void clearMenu() {
        menuList.clear();
        allMenus.clear();
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public static List<Menu> getAllMenus() {
        return allMenus;
    }

}