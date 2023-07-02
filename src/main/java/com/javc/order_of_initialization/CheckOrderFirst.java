package com.javc.order_of_initialization;

@SuppressWarnings({"InstantiationOfUtilityClass", "ClassInitializerMayBeStatic"})
public class CheckOrderFirst {

    public CheckOrderFirst() {
        System.out.println("Конструктор");
    }

    {
        System.out.println("Динамический блок");
    }

    static {
        System.out.println("Статический блок");
    }

    public static void main(String[] args) {
        new CheckOrderFirst();
    }
}