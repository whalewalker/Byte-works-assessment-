package com.byteworks.meal;


public class Main {
    public static void main(String[] args) {
        // create some meals
        Meal meal1 = new Meal("Spaghetti Carbonara");
        Meal meal2 = new Meal("Chicken Tikka Masala");
        Meal meal3 = new Meal("Caesar Salad");

        // create a meal list and add some meals
        LinkedList<Meal> mealLinkedList = new LinkedListImpl<>();
        MealList mealList = new MealList(mealLinkedList);
        mealList.add(meal1);
        mealList.add(meal2);
        mealList.add(meal3);

        // find a meal in the meal list
        int foundMeal = mealList.find(meal2);
        if (foundMeal > -1) {
            System.out.println("Found meal index: " + foundMeal);
        } else {
            System.out.println("Meal not found.");
        }

        // remove a meal from the meal list
        Meal removedMeal = mealList.remove(0);
        System.out.println("Removed meal: " + removedMeal.getName());

        // print the updated meal list
        System.out.println(mealList);
    }
}
