package entities;

import java.util.ArrayList;
import entities.food.Food;

/**
 * This class represents a user's kitchen, where they would store a list of their
 * food, recipes, and shoppingList
 */
public class Kitchen {

    private ArrayList<Food> food;
    private ArrayList<Recipe> recipes;
    private ArrayList<Food> shoppingList;

    public Kitchen(){
        this.food = new ArrayList<Food>();
        this.recipes = new ArrayList<Recipe>();
        this.shoppingList = new ArrayList<Food>();
    }

    /**
     * @return current food list
     */
    public ArrayList<Food> getFood(){
        return this.food;
    }

    /**
     * @return current recipe list
     */
    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }

    /**
     * @return current shopping list
     */
    public ArrayList<Food> getShoppingList(){
        return this.shoppingList;
    }

    /**
     * @param newFood updated food list
     */
    public void setFood(ArrayList<Food> newFood) {
        this.food = newFood;
    }
    /**
     * @param newRecipes updated recipes list
     */
    public void setRecipes(ArrayList<Recipe> newRecipes) {
        this.recipes = newRecipes;
    }

    /**
     * @param newList updated shopping list
     */
    public void setShoppingList(ArrayList<Food> newList) {
        this.shoppingList = newList;
    }

    public void addFoodtoList(Food newFood) {
        this.food.add(newFood);
    }

    /**
     * helper method that returns a String representation of current food in kitchen (with amounta)
     * @return String foods
     */
    public String showAllFood() {
        StringBuilder foods = new StringBuilder();
        foods.append("Food in Kitchen: " + "\n");
        for (Food food : this.food) {
            foods.append(food.getName() + ": " + food.getQuantity() + " " + food.getUnit() + "\n");
        }
        return foods.toString();
    }

    public String showRecipes() {
        StringBuilder recipes = new StringBuilder();
        recipes.append("Recipes in Kitchen: " + "\n");
        for (Recipe recipe : this.recipes) {
            recipes.append(recipe.getTitle() + "\n" + recipe.toString());
        }
        return recipes.toString();
    }

    public String showShoppingList() {
        StringBuilder shoppingList = new StringBuilder();
        shoppingList.append("Shopping List: " + "\n");
        for (Food food : this.shoppingList) {
            shoppingList.append(food.getName() + ": " + food.getQuantity() + " " + food.getUnit() + "\n");
        }
        return shoppingList.toString();
    }

    public StringBuilder showKitchen(){
        StringBuilder kitchen = new StringBuilder();
        kitchen.append(this.showAllFood() + this.showRecipes() + this.showShoppingList());
        return kitchen;
    }

}