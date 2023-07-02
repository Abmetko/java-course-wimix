package com.javc.order_of_initialization;

@SuppressWarnings({"InstantiationOfUtilityClass", "ClassInitializerMayBeStatic"})
public class CheckOrderThird {

    static CheckOrderThird i = new CheckOrderThird();

    static {
        System.out.println("Статический блок");
    }

    public CheckOrderThird() {
        System.out.println("Конструктор");
    }

    {
        System.out.println("Динамический блок");
    }

    public static void main(String[] args) {
        /*
            Динамический блок
            Конструктор
            Статический блок

            Нельзя сказать что static блок вызывается перед динамическим блоком.
            Они вызываются при разных условиях. Static блок вызывается после загрузки класса class loader'oм,
            а динамический блок вызывается при создании экземпляра класса. То есть static - инициализация класса,
            dynamic - инициализация экземпляра класса. И динамический блок в нашем конкретном примере вызывается
            во время инициализиции экземляра CheckOrderThird в первой строчке, которая static поле.
        */
    }
}