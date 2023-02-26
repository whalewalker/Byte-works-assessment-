package com.byteworks.meal;

public class MealList {
    private final LinkedList<Meal> meals;

    public MealList(LinkedList<Meal> meals) {
        this.meals = meals;
    }

    /**
     * Adds a new meal to the list of meals.
     *
     * @param meal the meal to be added to the list.
     */
    public void add(Meal meal) {
        meals.add(meal);
    }

    /**
     * Removes the specified object from the list of meals.
     *
     * @param obj the object to be removed. If the object is an Integer, the method will remove the meal at the specified index. If the object is a Meal, the method will remove the specified meal.
     * @return the removed meal.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= meals.size()).
     * @throws IllegalArgumentException  if the argument type is not valid.
     * @throws IllegalArgumentException  if the specified meal is not found.
     */
    public Meal remove(Object obj) {
        if (obj instanceof Integer) {
            int index = (int) obj;
            if (index < 0 || index >= meals.size()) {
                throw new IndexOutOfBoundsException();
            }
            Node<Meal> node = meals.find(index);
            Meal meal = node.getValue();
            meals.removeNode(node);
            return meal;
        } else if (obj instanceof Meal) {
            Meal meal = (Meal) obj;
            Node<Meal> node = meals.findNode(meal);
            if (node == null) {
                throw new IllegalArgumentException("Meal not found");
            }
            meals.removeNode(node);
            return meal;
        } else {
            throw new IllegalArgumentException("Invalid argument type");
        }
    }

    /**
     * Finds the index of the specified meal in the list of meals.
     *
     * @param meal the meal to find the index of.
     * @return the index of the specified meal in the list of meals, or -1 if the meal is not found.
     */
    public int find(Meal meal) {
        Node<Meal> node = meals.findNode(meal);
        if (node == null) {
            return -1;
        } else {
            return meals.indexOf(node);
        }
    }

    /**
     * Returns a string representation of the list of meals.
     *
     * @return a string representation of the list of meals.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node<Meal> current = meals.getHead(); current != null; current = current.getNext()) {
            sb.append(current.getValue().getName()).append("\n");
        }
        return sb.toString();
    }


}
