package com.example.lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<MenuItem> menuList = new ArrayList<>();
        addMenu(menuList);
        Scanner sc = new Scanner(System.in);
        int inputNum;

        while (true) {
            try {
                System.out.println("[ SHAKESHACK MENU ]");
                for (int i = 0; i < menuList.size(); i++) {
                    MenuItem menuItem = menuList.get(i);
                    System.out.println(i + 1 + ". "
                            + menuItem.getName() +
                            "   | W " + menuItem.getPrice() +
                            " | " + menuItem.getDescription());
                }
                System.out.println("0. 종료      | 종료");
                System.out.print("메뉴를 선택해주세요. (숫자 입력) : ");

                inputNum = sc.nextInt();

                if (inputNum == 0) {
                    sc.close();
                    break;
                } else if (inputNum <= menuList.size()) {
                    MenuItem selectedItem = menuList.get(inputNum-1);
                    System.out.println("===================================");
                    System.out.println(inputNum + " 번 메뉴를 선택하셨습니다. ");
                    System.out.println("이름: " + selectedItem.getName() );
                    System.out.println("가격 : " + selectedItem.getPrice());
                    System.out.println("설명 : " + selectedItem.getDescription());
                    break;
                } else {
                    System.out.println("선택지에서 골라주세요. \n");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해 주세요. \n");
                sc.nextLine(); // 입력 버퍼를 비워줌
            } catch (IndexOutOfBoundsException e) {
                System.out.println("선택지의 숫자만 입력해주세요. \n");
            }
        }
    }

    private static void addMenu(ArrayList<MenuItem> menuList) {
        menuList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가, 토핑된, 치즈버거"));
        menuList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.add(new MenuItem("BasicBurger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }
}
