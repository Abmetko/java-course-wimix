package com.javc.api;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JunitTest {

    @BeforeAll
    public void beforeAll() {
        System.out.println("this is our before all method");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("this is our before each method");
    }

    @Description("This method should check @Test annotation")
    @DisplayName("Test method #1")
    @Order(1)
    @Test
    public void testPrint1() {
        System.out.println("this is our test method 1");
    }

    @Disabled
    @DisplayName("Test method #2")
    @Order(2)
    @Test
    public void testPrint2() {
        System.out.println("this is our test method 2");
    }

    @AfterAll
    public void afterAll() {
        System.out.println("this is our after all method");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("this is our after each method");
    }
}