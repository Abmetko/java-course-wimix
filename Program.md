# **`Java`**

* Классы. Методы. Инструкции. Типы данных. Управляющие операторы `if`, `if else`, `else`.

* Создание объекта класса. Оператор `new`. Ссылка на объект. Конструктор. Garbage collector. Инструкция `.class`.

* Компиляция java класса в `.class` при помощи `javac`. Запуск `.class` с помощью `java`. Вывод байт-кода файла с расширением `class` с помощью `javap -c`. Набор инструкций байткода. `-cp` classpath.

* Цикл `for`. Оператор выхода из цикла `brake`. Оператор `switch`. Цикл `while`.

* Оператор `return`: возвращаемое значение, выход из метода (в том числе из цикла).

* Массивы.

* Методы класса `Object`. Перегрузка метода. Переопределение метода equals (для чего нужно). Авто генерация метода equals. String pool.

* Приведение типов. Автоупаковка и автораспаковка.

* Абстрактный класс.

* Интерфейс. Контракт. `implements` нескольких интерфейсов одним классом. Реализация не всех методов интерфейса - абстрактный класс. Интерфейсная ссылка на объект (доступ к методам только для типа ссылки, а не создаваемого объекта). Переменные интерфейсов.

* Статические методы. Статические поля. Оператор `static`. Статические блоки инициализации.

* Наследование. Очередность вызова конструкторов. Перегрузка конструкторов. Оператор: `super`.

* Полиморфизм. Переопределение метода.

* Инкапсуляция. Модификаторы доступа: `public`, `private`, `protected`.

* Коллекции. Иерархия. `List` (реализация `ArrayList`). `Set` (реализация `HashSet`). `Map` (реализация `HashMap`).

* Паттерн: singleton. Почему называют анти-паттерном?

* Паттерн: builder.

* Паттерн: factory.

* Паттерн: strategy.

* Паттерн: object pool.

* Ввод/вывод данных.

* Работа с CSV файлом. Библиотека [OpenCSV](http://opencsv.sourceforge.net/). Bean-Based сериализация и десериализация.

* Функциональный интерфейс. Лямбда выражения.

* Анонимный класс.

* Сериализация и десериализация объекта. Библиотека Jackson для работы с json объектами, класс [ObjectMapper](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind).

* Stream API: конвейерные методы, терминальные.

* Обработка исключений. Блоки: `try`, `catch`, `finally`. Операторы: `throw`, `throws`. Иерархия исключений (проверяемые, непроверяемые). Создание собственного класса исключения.

* Сортировка коллекций. Класс `Collections`. Интерфейсы `Comparable`, `Comparator`.

* Debug.

* Регулярные выражения.

* `Enum`. Применение перечислений.

* Комментарии: однострочные, многострочные. `TODO`, `FIXME`. `@`Аннотации. Создание собственных аннотаций.

* Обобщения.

* Wildcards.

* Variable Arguments.

* Внутренние классы. Статические вложенные классы.

* Рекурсия.

* Работа с датой и временем: `Date`, `SimpleDateFormat`, `DateTimeFormatter`, `LocalDateTime`, `ZonedDateTime`.

* Многопоточность. Интерфейс `Runnable`. Класс `Thread`.

* `synchronized` методы и синхронизированные блоки.

* Работа с файлами `.properties`.

* Логирование с помощью фасада `Slf4j` с `logback`. Уровни логирования.

* Сервис [Heroku](https://www.heroku.com). Работа с базой данных Postgresql.

# **`Maven`**

* Жизненный цикл Maven.

* pom.xml: `dependency`, `plugin`, `properties`.

* `groupId`.

* `artifactId`.

* Локальный репозиторий (.m2). [Maven central](https://mvnrepository.com/).

# **`Automation`**

* Автоматизация тестирования rest API с библиотекой [Restassured](https://rest-assured.io/). Сериализация/десериализация с помощью библиотеки [Jackson](https://mvnrepository.com/search?q=com.fasterxml.jackson.core). 
[POJO классы](https://json2csharp.com/json-to-pojo).

* TDD: [TestNG](https://testng.org/doc/). Аннотации. Настрока maven плагина. Создание и конфигурация testng.xml.

* TDD: [Junit5](https://junit.org/junit5/docs/current/user-guide/). Аннотации. Параллелизм. Конфигурирование.

* BDD: [Cucumber](https://cucumber.io/docs/installation/java/)

* Паттерны проектирования тестов: structural patterns, data patterns.

* Structural patterns: Page object

* Structural patterns: Available methods

* Structural patterns: Chain of invocations

* Structural patterns: Page factory

* Structural patterns: Page element/Composite

* Structural patterns: Loadable component

* Structural patterns: Strategy

* Data pattern: Value object

* Data pattern: Builder

* Data pattern: Assert Object/Matchers

* Data pattern: Data registry

* Data pattern: Object pool/Flyweight

* Data pattern: Data provider

* Тестирование web приложений с помощью фреймворка [Selenide](https://ru.selenide.org/).

* Тестирование mobile приложений с помощью [Appium](https://appium.io/).

# **`Git`**

* Работа с репозиторием. Сервис [Github](https://github.com/).