package controllers;

import entities.Kitchen;
import entities.Recipe;
import entities.User;
import entities.food.Food;
import usecases.FoodFactory;
import usecases.ShoppingListManager;

import java.util.HashMap;
import java.util.List;


public class KitchenControlCentre extends ControlCentre {
    private final ShoppingListManager shoppingListManager;


    public KitchenControlCentre(User user) {
        super(user);
        this.shoppingListManager = new ShoppingListManager();
    }

    public Food createFoodForList(String foodType, String foodName, int sl, int quantity, String unit) {
        Food add = FoodFactory.getFood(foodType, foodName, sl, quantity, unit);
        this.getUser().getKitchen().addFoodtoList(add);
        return add;
    }

    public StringBuilder getFoodList(User user){
        return user.getKitchen().showAllFood();
    }

    public StringBuilder getShoppingList(User user){
        return user.getKitchen().showShoppingList();
    }

    public StringBuilder getRecipeList(User user){
        return user.getKitchen().showRecipes();
    }

    public HashMap<String, Float> getRecipeIngredients(String recipeName, User user){
        Recipe recipe = shoppingListManager.getRecipeFromTitle(user, recipeName);
        return recipe.getIngredients();
    }

    @Override
    public String showFood(Food foodEntry) {
        return null;
    }

    @Override
    public Food createEntity(String s, String s1, int sl, int quantity, String s2) {
        return null;
    }

    @Override
    public Food findFood(String foodName, User user) {
        return null;
    }

    @Override
    public String removeFoodQuantity(String foodName, String quantity, User user) {
        return null;
    }

    @Override
    public String updateFood(String foodName, String updateField, String updateItem, User user) {
        return null;
    }

    @Override
    public String addFoodtoList(Food food, Kitchen kitchen) {
        return null;
    }

    @Override
    public String addFoodQuantity(String foodName, String quantity, User user) {
        return null;
    }


}
