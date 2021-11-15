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
     * Getter to return food list
     * @return current food list
     */
    public ArrayList<Food> getFood(){
        return this.food;
    }

    /**
     * Getter to return recipe list
     * @return current recipe list
     */
    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }

    /**
     * Getter to return shopping list
     * @return current shopping list
     */
    public ArrayList<Food> getShoppingList(){
        return this.shoppingList;
    }

    /**
     * Setter to update food list
     * @param newFood updated food list
     */
    public void setFood(ArrayList<Food> newFood) {
        this.food = newFood;
    }
    /**
     * Setter to update recipes list
     * @param newRecipes updated recipes list
     */
    public void setRecipes(ArrayList<Recipe> newRecipes) {
        this.recipes = newRecipes;
    }

    /**
     * Setter to update shopping list
     * @param newList updated shopping list
     */
    public void setShoppingList(ArrayList<Food> newList) {
        this.shoppingList = newList;
    }

    public void addFoodtoList(Food newFood) {
        this.food.add(newFood);
    }

    /**
     * helper method that returns a StringBuilder representation of current food in kitchen (with amounts)
     * @return StringBuilder foods
     */
    public StringBuilder showAllFood() {
        StringBuilder foods = new StringBuilder();
        for (Food food : this.food) {
            foods.append("- " + food.getName() + ": " + food.getQuantity() + " " + food.getUnit() + "\n");
        }
        return foods;
    }

    /**
     * helper method that returns a StringBuilder representation of current recipes in kitchen
     * @return StringBuilder recipes
     */
    public StringBuilder showRecipes() {
        StringBuilder recipes = new StringBuilder();
        for (Recipe recipe : this.recipes) {
            recipes.append(recipe.getTitle() + "\n" + recipe.recToString());
        }
        return recipes;
    }

    /**
     * helper method that returns a StringBuilder representation of a shopping list
     * @return StringBuilder shoppingList
     */
    public StringBuilder showShoppingList() {
        StringBuilder shoppingList = new StringBuilder();
        for (Food food : this.shoppingList) {
            shoppingList.append(food.getName() + ": " + food.getQuantity() + " " + food.getUnit() + "\n");
        }
        return shoppingList;
    }

    /**
     * helper method that returns a StringBuilder representation of a kitchen
     * @return StringBuilder kitchen
     */
    public StringBuilder showKitchen(){
        StringBuilder kitchen = new StringBuilder();
        kitchen.append("Food in Kitchen: " + "\n" + this.showAllFood());
        kitchen.append("Recipes in Kitchen: " + "\n" + this.showRecipes());
        kitchen.append("Shopping List: " + "\n" + this.showShoppingList());
        return kitchen;
    }

    public void addRecipetoList(Recipe newRecipe){
        this.recipes.add(newRecipe);
    }
}