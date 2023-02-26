package com.byteworks.meal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealListTest {

    @Test
     void testAdd() {
        LinkedList<Meal> meals = new LinkedListImpl<>();
        MealList mealList = new MealList(meals);

        Meal meal1 = new Meal("Burger");
        Meal meal2 = new Meal("Pizza");
        Meal meal3 = new Meal("Taco");

        mealList.add(meal1);
        mealList.add(meal2);
        mealList.add(meal3);

        assertEquals(3, meals.size());
    }

    @Test
     void testRemove() {
        LinkedList<Meal> meals = new LinkedListImpl<>();
        MealList mealList = new MealList(meals);

        Meal meal1 = new Meal("Burger");
        Meal meal2 = new Meal("Pizza");
        Meal meal3 = new Meal("Taco");

        mealList.add(meal1);
        mealList.add(meal2);
        mealList.add(meal3);

        // Remove by index
        Meal removedMeal = mealList.remove(1);
        assertEquals(meal2, removedMeal);
        assertEquals(2, meals.size());

        // Remove by object
        removedMeal = mealList.remove(meal3);
        assertEquals(meal3, removedMeal);
        assertEquals(1, meals.size());

        // Try to remove non-existent object
        assertThrows(IllegalArgumentException.class, () -> mealList.remove(new Meal("Sushi")));
    }

    @Test
     void testFind() {
        LinkedList<Meal> meals = new LinkedListImpl<>();
        MealList mealList = new MealList(meals);

        Meal meal1 = new Meal("Burger");
        Meal meal2 = new Meal("Pizza");
        Meal meal3 = new Meal("Taco");

        mealList.add(meal1);
        mealList.add(meal2);
        mealList.add(meal3);

        // Find existing meal
        int index = mealList.find(meal2);
        assertEquals(1, index);

        // Try to find non-existent meal
        index = mealList.find(new Meal("Sushi"));
        assertEquals(-1, index);
    }

    @Test
     void testToString() {
        LinkedList<Meal> meals = new LinkedListImpl<>();
        MealList mealList = new MealList(meals);

        Meal meal1 = new Meal("Burger");
        Meal meal2 = new Meal("Pizza");
        Meal meal3 = new Meal("Taco");

        mealList.add(meal1);
        mealList.add(meal2);
        mealList.add(meal3);

        String expected = "Burger\nPizza\nTaco\n";
        String actual = mealList.toString();

        assertEquals(expected, actual);
    }
}