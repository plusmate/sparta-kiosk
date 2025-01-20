package com.example.lv6_2;

public enum DiscountType {
    NATIONAL_MERIT(0.1),
    SOLDIER(0.05),
    STUDENT(0.03),
    NORMAL(0);

    private final double discountRate;

    DiscountType(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
