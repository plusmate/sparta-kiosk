package com.example.my;

import java.util.List;

public class Kiosk {
    public static void showMenu() {
        List<MenuItem> menuList = Menu.getMenuList();

        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuList.size(); i++) {
            MenuItem menuItem = menuList.get(i);

            System.out.println(i+1 + ". " +
                    menuItem.getName() +
                    "   | W " + menuItem.getPrice() +
                    " | " + menuItem.getDescription());

            System.out.println("0. 종료      | 종료");
        }

    }
}
