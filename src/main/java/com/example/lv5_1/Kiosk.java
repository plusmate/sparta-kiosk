package com.example.lv5_1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);
    int chooseMain = -1;
    int chooseCart = -1;
    int chooseFood = -1;
    int chooseOrder = -1;
    Menu menu;
    MenuItem selectedItem;
    List<MenuItem> menuList;
    List<Cart> cartList =  new ArrayList<>();
    double totalPrice = 0;

    public void start() {
        List<Menu> allMenus = Menu.getAllMenus();
        int quantity = 0;
        double itemPrice = 0;

        while (true) {
            try {
                /* 음식 종류 선택 로직 (depth:1) */
                System.out.println("[ MAIN MENU ]");
                for (int i = 0; i < allMenus.size(); i++) {
                    System.out.println(i + 1 + ". " + allMenus.get(i).getFoodType());
                }
                System.out.println("0. 종료      | 종료");

                if (!cartList.isEmpty()) {
                    /* 장바구니 목록 출력 */
                    System.out.println("\n [ ORDER MENU ]");
                    System.out.println(allMenus.size()+1 + ". Orders       | 장바구니를 확인 후 주문합니다.");
                    System.out.println(allMenus.size()+2 + ". Cancel       | 진행중인 주문을 취소합니다.");
                }

                chooseMain = sc.nextInt();
                System.out.println();
                /* 음식 종류 선택 로직 */
                if (chooseMain == 0) {
                    /* 프로그램 종료 */
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                } else if (chooseMain <= allMenus.size()) {
                    /* 음식 종류 선택 완료 */
//                    while (chooseFood != 0) {
                    while (true) {
                        menu = allMenus.get(chooseMain - 1);
                        FoodType foodType = menu.getFoodType();
                        System.out.println(" [ " + foodType + " MENU ]");

                        menuList = menu.getMenuList();
                        for (int i = 0; i < allMenus.size(); i++) {
                            MenuItem food = menuList.get(i);
                            System.out.println(i + 1 + ". " +
                                    food.getName() + "   | W " +
                                    food.getPrice() + " | " +
                                    food.getDescription()
                            );
                        }
                        System.out.println("0. 뒤로가기");

                        sc.nextLine(); // 버퍼비우기
                        chooseFood = sc.nextInt();
                        System.out.println();
                        if (chooseFood == 0) {
                            break;
                        } else if (chooseFood <= menuList.size()) {
                            selectedItem = menuList.get(chooseFood - 1);
                            itemPrice = selectedItem.getPrice();
                            System.out.println("선택한 메뉴: " + selectedItem.getName() + " | W " +
                                    itemPrice + " | " +
                                    selectedItem.getDescription() + "\n"
                            );

                            /* 장바구니 로직 */
                            while (true) {
                                System.out.println(selectedItem.getName() + " | W " +
                                        itemPrice + " | " +
                                        selectedItem.getDescription()
                                );
                                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                                System.out.println("1. 확인        2. 취소");
                                sc.nextLine(); //버퍼비우기
                                chooseCart = sc.nextInt();
                                if (chooseCart == 1) {
                                    if (cartList.isEmpty()) {
                                        /* 장바구니에 처음 담는 경우 */
                                        addCart(selectedItem, 1, itemPrice);
                                    } else {
                                        /* 이미 장바구니에 상품이 있는 경우 */
                                        boolean isDuplicate = false; // 중복될 경우 활성화 될 boolean

                                        /* 중복되는 새 상품 주문 */
                                        for (Cart cart : cartList) {
                                            MenuItem cartItem = cart.getMenuItem();

                                            if (cartItem.getName() == selectedItem.getName()) {
                                                isDuplicate = true;
                                                totalPrice += itemPrice;
                                                cart.addOrder(totalPrice);
                                            }
                                        }

                                        /* 중복되지 않은 새 상품 주문 */
                                        if (!isDuplicate) {
                                            addCart(selectedItem, 1, itemPrice);
                                        }
                                    }
                                    System.out.println("장바구니에 " + selectedItem.getName() + " 상품이 추가되었습니다.");
                                    System.out.println("첫 주문 화면으로 이동합니다 \n");
                                    break;
                                } else if (chooseCart == 2) {
                                    /* 장바구니 입력 취소 로직 */
                                    System.out.println("장바구니를 취소합니다.");
//                                    System.out.println("장바구니에 " + selectedItem.getName() + "");
                                    System.out.println("첫 주문 화면으로 이동합니다.\n");
                                    break; // 두번째 while문(음식 선택 로직)으로 이동
                                } else {
                                    /* 예외처리) 장바구니 입력값 비정상 로직 */
                                    System.out.println("1 또는 2를 입력해주세요. \n");
                                }
                            }
                            break; // 첫 주문 화면으로 돌아감
                        } else {
                            System.out.println("숫자만 입력해주세요.");
                            System.out.println("음식 종류 결정 화면으로 이동합니다. \n");
                        }
                    }
                } else if (!cartList.isEmpty() && chooseMain == allMenus.size()+1) {
                    while (true) {
                        /* 장바구니 주문 로직 */
                        System.out.println("아래와 같이 주문 하시겠습니까?");
                        System.out.println("[ Orders ]");
                        for (Cart cart : cartList) {
                            MenuItem menuItem = cart.getMenuItem();
                            System.out.println(menuItem.getName() +
                                    " | W " + menuItem.getPrice() +
                                    " | " + menuItem.getDescription() +
                                    " x " + cart.getQuantity());
                        }

                        /* 총 합계 확인  */
                        System.out.println("\n [ Total ]");
                        System.out.println("W " + totalPrice + "\n");

                        /* 주문 확인 로직 */
                        System.out.println("1. 주문      2. 메뉴판");
                        sc.nextLine(); // 버퍼 제거
                        chooseOrder = sc.nextInt();
                        if (chooseOrder == 1) {
                            /* 주문 완료 로직 */
                            System.out.println("주문이 완료되었습니다. 금액은 W " + totalPrice + " 입니다.");
                            System.out.println("주문 완료된 장바구니를 초기화합니다.\n");
                            clearMenuList();
                            break;
                        } else if (chooseOrder == 2) {
                            /* 주문 취소 로직 */
                            System.out.println("메뉴판으로 이동합니다. \n");
                            break;
                        } else {
                            System.out.println("선택지의 숫자만 입력해주세요 \n");
                        }
                    }
                } else if (!cartList.isEmpty() && chooseMain == allMenus.size()+2) {
                    /* 주문 취소 로직 (장바구니 초기화) */
                    System.out.println("장바구니를 초기화합니다. \n");
                    clearMenuList();
                } else {
                    System.out.println("선택지의 숫자만 입력해주세요.");
                    System.out.println("첫 화면으로 이동합니다.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해 주세요. \n");
                sc.nextLine(); // 입력 버퍼를 비워줌
            } catch (IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException) 선택지의 숫자만 입력해주세요. \n");
            }
        }
    }

    private void clearMenuList() {
        cartList.clear();
        totalPrice = 0;
    }

    private void addCart(MenuItem selectedItem, int quantity, double price) {
        Cart cart = new Cart(selectedItem, quantity, price);
        cartList.add(cart);
        totalPrice += price;
    }
}
