package com.codecool.shop.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        orderController = new OrderController();
    }

    @Test
    void testFirstNameIsNotContainingNumber() {
        String testedString = "Szilard56";
        assertThrows(IllegalArgumentException.class, () -> orderController.setLastName(testedString));
    }

    @Test
    void testLastNameIsNotContainingNumber() {
        String testedString = "Bognár56";
        assertThrows(IllegalArgumentException.class, () -> orderController.setLastName(testedString));
    }

}