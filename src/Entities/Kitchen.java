package Entities;

import java.util.ArrayList;

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


}
