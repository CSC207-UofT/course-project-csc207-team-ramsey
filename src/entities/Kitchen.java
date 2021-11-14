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

    public void addRecipetoList(Recipe newRecipe){
        this.recipes.add(newRecipe);
    }
}