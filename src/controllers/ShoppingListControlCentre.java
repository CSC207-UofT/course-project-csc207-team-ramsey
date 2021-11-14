package controllers;

import entities.Kitchen;
import entities.Recipe;
import entities.User;
import entities.food.Food;
import usecases.FoodFactory;
import usecases.ShoppingListManager;
import java.util.ArrayList;


public class ShoppingListControlCentre extends ControlCentre {
    User user;
    ShoppingListManager shoppingListManager;

    public void createEntity(User user, ArrayList<Recipe> recipes, ArrayList<Food> shoppingList) {
        this.user = user;
        ShoppingListManager shoppingListManager = new ShoppingListManager();
    }

    public void createFoodForList(String foodType, String foodName, int sl, int quantity, String unit){
        Food add = FoodFactory.getFood(foodType, foodName, sl, quantity, unit);
        this.shoppingListManager.addFood(user, add);
    }

    public StringBuilder showKitchen(User user){
        StringBuilder returnString = new StringBuilder();
        returnString.append("Food: ").append(user.getKitchen().getFood()).append("\n").append("Recipes: ").append(user.getKitchen().getRecipes()).append("\n").append("Shopping List: ").append(user.getKitchen().getShoppingList());
        return returnString;
    }

    public StringBuilder showShoppingList(User user){
        ArrayList<Food> shoppingList = user.getKitchen().getShoppingList();
        StringBuilder returnString = new StringBuilder();
        returnString.append("Shopping List: ");

        for (Food food : shoppingList) {
            returnString.append(food.getName() + ": " + food.getQuantity() + " " + food.getUnit());
        }
        return returnString;
    }

}
