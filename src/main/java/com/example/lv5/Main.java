package com.example.lv5;

public class Main {
    public static void main(String[] args) {
        Menu burgerMenu = new Menu(
                FoodType.Burger,
                new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가, 토핑된, 치즈버거"),
                new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("BasicBurger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
        );

        Menu drinkMenu = new Menu(
                FoodType.Drink,
                new MenuItem("아메리카노", 5, "진하게 우려낸 아메리카노"),
                new MenuItem("아메리카노(아이스)", 5.5, "진하게 우려낸 아메리카노 - 아이스"),
                new MenuItem("제로 콜라", 2, "제로콜라(펩시)"),
                new MenuItem("콜라", 2, "콜라(펩시)")
        );

        Menu dessertMenu = new Menu(
                FoodType.Dessert,
                new MenuItem("민트초코 아이스크림", 6, "반 민초파도 좋아할 민트초코 아이스크림"),
                new MenuItem("벌꿀 아이스크림", 5.5, "꿀벌집이 그대로, 달달한 벌꿀 아이스크림"),
                new MenuItem("초코케이크", 2, "달달한 초코케이크"),
                new MenuItem("티라미수케익", 2, "커피향 가득 티라미수케익")
        );

        new Kiosk().start();

        clearAllMenu(drinkMenu, burgerMenu, dessertMenu);
    }

    private static void clearAllMenu(Menu drinkMenu, Menu burgerMenu, Menu dessertMenu) {
        drinkMenu.clearMenu();
        burgerMenu.clearMenu();
        dessertMenu.clearMenu();
    }
}
