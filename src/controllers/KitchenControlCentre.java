package controllers;

import entities.User;
import entities.food.Food;
import usecases.FoodFactory;
import usecases.ShoppingListManager;


public class KitchenControlCentre extends ControlCentre {
    User user;
    ShoppingListManager shoppingListManager;

    public KitchenControlCentre(User user) {
        this.user = user;
    }

    public void createFoodForList(String foodType, String foodName, int sl, int quantity, String unit) {
        Food add = FoodFactory.getFood(foodType, foodName, sl, quantity, unit);
        this.shoppingListManager.addFood(user, add);
    }

    public StringBuilder getFoodList(User user){
        return user.getKitchen().showAllFood();
    }

    public StringBuilder getShoppingList(User user){
        return user.getKitchen().showShoppingList();
    }

    @Override
    public StringBuilder showFood(Food food) {
        return null;
    }
}
