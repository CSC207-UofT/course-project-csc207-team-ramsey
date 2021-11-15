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


}
