package com.javc.order_of_initialization;

@SuppressWarnings({"ClassInitializerMayBeStatic"})
public class CheckOrderSecond {

    int i;

    public CheckOrderSecond(int i) {
        this.i = i;
        System.out.println("Конструктор");
    }

    {
        System.out.println("Динамический блок");
    }

    static {
        System.out.println("Статический блок");
    }

    public static void main(String[] args) {
        new CheckOrderSecond(100);
    }
}