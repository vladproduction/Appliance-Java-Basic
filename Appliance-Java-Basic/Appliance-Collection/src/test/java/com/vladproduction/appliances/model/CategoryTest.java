package com.vladproduction.appliances.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CategoryTest {
    private static List<?> constants;
    private static Class<?> clazz;

    @BeforeAll
    static void setup() throws ClassNotFoundException {
        clazz = Class.forName(TestConstants.CATEGORY_TYPE);
        constants = Arrays.asList(clazz.getEnumConstants());
    }

    @Test
    @DisplayName("Class " + TestConstants.CATEGORY_TYPE + " is Enum")
    void checkIsEnum() {
        final boolean actual = clazz.isEnum();
        assertTrue(actual);
    }

    @Test
    @DisplayName("There must be " + TestConstants.Category.ENUM_COUNT_CONSTANTS + " constants")
    void checkCountConstants() {
        int actual = constants.size();
        Assertions.assertEquals(TestConstants.Category.ENUM_COUNT_CONSTANTS, actual);
    }

    @Test
    @DisplayName("There must be constant with name " + TestConstants.Category.ENUM_CONSTANT_BIG)
    void checkEnumConstantBIG() {
        long actual = Arrays.stream(clazz.getDeclaredFields())
                .map(f -> f.getName())
                .filter(name -> name.equals(TestConstants.Category.ENUM_CONSTANT_BIG))
                .count();
        assertEquals(1, actual);
    }

    @Test
    @DisplayName("There must be constant with name " + TestConstants.Category.ENUM_CONSTANT_SMALL)
    void checkEnumConstantSMALL() {
        long actual = Arrays.stream(clazz.getDeclaredFields())
                .map(f -> f.getName())
                .filter(name -> name.equals(TestConstants.Category.ENUM_CONSTANT_SMALL))
                .count();
        assertEquals(1, actual);
    }
}