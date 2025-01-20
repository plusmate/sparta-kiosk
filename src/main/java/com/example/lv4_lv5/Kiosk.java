package com.example.lv4_lv5;

import java.util.*;

public class Kiosk {
    Scanner sc = new Scanner(System.in);
    int selectMain;
    Menu menu;
    MenuItem menuItem;
    List<MenuItem> menuList;


    public void start() {
        while (true) {
            try {
                System.out.println("\n [ MAIN MENU ]");
                for (int i = 0; i < Menu.getAllMenus().size(); i++) {
                    System.out.println(i + 1 + ". " + Menu.getAllMenus().get(i).getFoodType());
                }
                System.out.println("0. 종료      | 종료");

                selectMain = sc.nextInt();
                if (selectMain == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                } else if (selectMain <= Menu.getAllMenus().size()) {
                    int selectedFoodNum = -1;
                    while (selectedFoodNum != 0) {
                        menu = Menu.getAllMenus().get(selectMain - 1);
                        FoodType foodType = menu.getFoodType();
                        System.out.println("\n [ " + foodType + " MENU ]");

                        menuList = menu.getMenuList();
                        for (int i = 0; i < Menu.getAllMenus().size(); i++) {
                            MenuItem food = menuList.get(i);
                            System.out.println(i + 1 + ". " +
                                    food.getName() + "   | W " +
                                    food.getPrice() + " | " +
                                    food.getDescription()
                            );
                        }
                        System.out.println("0. 뒤로가기");

                        sc.nextLine(); // 버퍼비우기
                        selectedFoodNum = sc.nextInt();
                        if (selectedFoodNum == 0) {
                            break;
                        } else if (selectedFoodNum <= menuList.size()) {
                            menuItem = menuList.get(selectedFoodNum - 1);
                            System.out.println("선택한 메뉴: " + menuItem.getName() + " | W " +
                                    menuItem.getPrice() + " | " +
                                    menuItem.getDescription()
                            );
                            break;
                        }
                    }
                } else {
                    System.out.println("선택지의 숫자만 입력해주세요. \n");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해 주세요. \n");
                sc.nextLine(); // 입력 버퍼를 비워줌
            } catch (IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException) 선택지의 숫자만 입력해주세요. \n");
            }
        }
    }
}
