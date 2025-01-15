package com.example.lv3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItems;
    Scanner sc = new Scanner(System.in);
    int inputNum;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        while (true) {
            try {
                System.out.println("[ SHAKESHACK MENU ]");
                for (int i = 0; i < menuItems.size(); i++) {
                    MenuItem menuItem = menuItems.get(i);

                    System.out.println(i + 1 + ". "
                            + menuItem.getName() +
                            "   | W " + menuItem.getPrice() +
                            " | " + menuItem.getDescription());
                }
                System.out.println("0. 종료      | 종료");
                System.out.print("메뉴를 선택해주세요. (숫자 입력) : ");

                inputNum = sc.nextInt();

                if (inputNum == 0) {
                    System.out.println("===================================");
                    System.out.println("키오스크 종료");
                    sc.close();
                    break;
                } else if (inputNum <= menuItems.size()) {
                    MenuItem selectedItem = menuItems.get(inputNum-1);
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
}
