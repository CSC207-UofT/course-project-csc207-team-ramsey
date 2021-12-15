package controllers;

import entities.Recipe;
import entities.User;
import entities.food.Food;
import usecases.FoodFactory;
import usecases.ShoppingListManager;

import java.util.HashMap;


/**
 * the ControlCentre for handling Kitchen responsibilities
 */

public class KitchenControlCentre extends ControlCentre {
    ShoppingListManager shoppingListManager;
    User user;


    public KitchenControlCentre(User user) {
        super(user);
        this.shoppingListManager = new ShoppingListManager();
    }

    /**
     * Create a new food to add to the User's food list
     * @param foodType the type for the new food
     * @param foodName the name of the new food
     * @param sl the shelf life of the new food
     * @param quantity the quantity of the new food
     * @param unit the unit for the new food
     */
    public void createFoodForList(String foodType, String foodName, int sl, int quantity, String unit) {
        Food add = FoodFactory.getFood(foodType, foodName, sl, quantity, unit);
        this.getUser().getKitchen().addFoodtoList(add);
    }

    /**
     * Get the User's food list
     * @param user the user whose food is being accessed
     * @return StringBuilder food in the User's kitchen
     */
    public StringBuilder getFoodList(User user) {
        return user.getKitchen().showAllFood();
    }

    /**
     * Get the User's Shopping List
     * @param user the user whose shopping list is being accessed
     * @return StringBuilder food in the User's shopping list
     */
    public StringBuilder getShoppingList(User user) {
        return user.getKitchen().showShoppingList();
    }

    /**
     * Get the User's recipe list
     * @param user the user whose recipe list is being accessed
     * @return StringBuilder food in the User's recipe list
     */
    public StringBuilder getRecipeList(User user) {
        return user.getKitchen().showRecipes();
    }

    /**
     * Get the ingredients for a recipe in a User's recipe inventory
     * @param user the user whose recipe inventory is being accessed
     * @param recipeName the name of the recipe being accessed
     * @return HashMap<String, Float> ingredients and associated quantities for a recipe
     */
    public HashMap<String, Float> getRecipeIngredients(String recipeName, User user) {
        Recipe recipe = shoppingListManager.getRecipeFromTitle(user, recipeName);
        return recipe.getIngredients();
    }
}