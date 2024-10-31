package com.vladproduction.appliances.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

import static com.vladproduction.appliances.collection.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    private static List<Field> allFields;
    private static List<Constructor<?>> allConstructors;
    private static List<Method> allMethods;

    @BeforeAll
    static void setup() throws ClassNotFoundException {
        final Class<?> clazz = Class.forName(USER_TYPE);
        allFields = Arrays.asList(clazz.getDeclaredFields());
        allConstructors = Arrays.asList(clazz.getConstructors());
        allMethods = Arrays.asList(clazz.getDeclaredMethods());
    }

    /*Tests for CONSTRUCTORS*/
    @Test
    @DisplayName("Count constructors have to be " + TestConstants.User.CLASS_COUNT_CONSTRUCTORS)
    void checkCountConstructors() {
        Assertions.assertEquals(TestConstants.User.CLASS_COUNT_CONSTRUCTORS, allConstructors.size());
    }

    @Test
    @DisplayName("Modifier constructors can be public")
    void checkModifiersConstructors() {
        boolean actual = allConstructors.stream()
                .allMatch(c -> Modifier.isPublic(c.getModifiers()));
        assertTrue(actual);
    }

    @Test
    @DisplayName(TestConstants.User.CLASS_NAME + " has to default constructor")
    void checkDefaultConstructor() {
        long count = allConstructors.stream()
                .filter(c -> c.getParameterCount() == 0)
                .count();
        assertEquals(1, count);
    }

    @Test
    @DisplayName(USER_TYPE + " has to constructor with " + TestConstants.User.PARAMETERS_IN_CONSTRUCTOR_WITH_PARAMETERS + " parameter")
    void checkConstructorWithParameter() {
        long count = allConstructors.stream()
                .filter(c -> c.getParameterCount() == TestConstants.User.PARAMETERS_IN_CONSTRUCTOR_WITH_PARAMETERS)
                .count();
        assertEquals(1, count);
    }

    @Test
    @DisplayName("Check parameter type in constructor with parameter")
    void checkParameterTypeForConstructorWithParameter() {
        final Constructor<?> constructor = allConstructors.stream()
                .filter(c -> c.getParameterCount() == TestConstants.User.PARAMETERS_IN_CONSTRUCTOR_WITH_PARAMETERS)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No constructor with " + TestConstants.User.PARAMETERS_IN_CONSTRUCTOR_WITH_PARAMETERS + " parameters"));

        final List<Parameter> parameters = Arrays.asList(constructor.getParameters());


        parameters.stream()
                .filter(p -> p.getType().getTypeName().equals(LONG_TYPE))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No parameter with type " + LONG_TYPE));

        final long countStringParameters = parameters.stream()
                .filter(p -> p.getType().getTypeName().equals(STRING_TYPE))
                .count();
        assertEquals(3, countStringParameters);
    }

    /* Tests for FIELDS */
    @Test
    @DisplayName("Check count fields")
    void checkCountFields() {
        Assertions.assertEquals(TestConstants.User.CLASS_COUNT_FIELDS, allFields.size());
    }

    @Test
    @DisplayName("Check count private fields")
    void checkAllFieldIsPrivate() {
        final long count = allFields.stream()
                .filter(p -> Modifier.isPrivate(p.getModifiers()))
                .count();
        Assertions.assertEquals(TestConstants.User.CLASS_COUNT_FIELDS, count);
    }

    @ParameterizedTest
    @CsvSource({"id,1",
            "name,1",
            "email,1",
            "password,1"
    })
    @DisplayName("To " + TestConstants.User.CLASS_NAME + " check fields name")
    void checkFieldNameName(String name, long expected) {
        final long count = allFields.stream()
                .filter(f -> f.getName().equals(name))
                .count();
        assertEquals(expected, count);
    }
}