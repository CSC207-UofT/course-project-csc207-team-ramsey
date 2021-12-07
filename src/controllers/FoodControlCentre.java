package controllers;

import entities.Kitchen;
import entities.User;
import entities.food.Food;
import usecases.FoodFactory;
import usecases.FoodManager;

import java.util.ArrayList;

public class FoodControlCentre extends ControlCentre {
    private final FoodManager foodManager;

    public FoodControlCentre(User user) {
        super(user);
        this.foodManager = new FoodManager();
    }


    public Food createEntity(String foodType, String foodName, int sl, int quantity, String unit){
        Food newFood = FoodFactory.getFood(foodType, foodName, sl, quantity, unit);
        this.getUser().getKitchen().addFoodtoList(newFood);
        return newFood;
    }

    @Override
    public String addFoodtoList(Food food, Kitchen kitchen){
        return this.foodManager.addFoodtoList(food, kitchen);
    }

    @Override
    public String showFood(Food food){
        return this.foodManager.getInfoQuantity(food);
    }

    @Override
    public String removeFoodQuantity(String foodName, String quantity, User user){
        return this.foodManager.removeQuantity(this.foodManager.findFood(foodName, user), quantity);
    }

    public Food findFood(String foodName, User user){
        return this.foodManager.findFood(foodName, user);
    }

    @Override
    public String updateFood(String foodName, String updateField, String updateItem, User user){
        return this.foodManager.updateFood(this.findFood(foodName, user), updateField, updateItem);
    }
    @Override
    public String addFoodQuantity(String foodName, String quantity, User user){
        return this.foodManager.addFoodQuantity(this.findFood(foodName, user), quantity);
    }

    public void deleteEntity() {

    }

    public void updateEntity() {

    }
}
