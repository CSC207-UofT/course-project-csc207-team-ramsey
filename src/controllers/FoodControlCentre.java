package controllers;

import entities.Kitchen;
import entities.User;
import entities.food.Food;
import usecases.FoodFactory;
import usecases.FoodManager;

public class FoodControlCentre{
    private final FoodManager foodManager;
    private User user;

    public FoodControlCentre(User user) {
        this.user = user;
        this.foodManager = new FoodManager();
    }

    public User getUser(){
        return this.user;
    }
    public Food createEntity(String foodType, String foodName, int sl, int quantity, String unit){
        Food newFood = FoodFactory.getFood(foodType, foodName, sl, quantity, unit);
        this.getUser().getKitchen().addFoodtoList(newFood);
        return newFood;
    }

    public String addFoodtoList(Food food, Kitchen kitchen){
        return this.foodManager.addFoodtoList(food, kitchen);
    }

    public String showFood(Food food){
        return this.foodManager.getInfoQuantity(food);
    }

    public String removeFoodQuantity(String foodName, String quantity, User user){
        return this.foodManager.removeQuantity(this.foodManager.findFood(foodName, user), quantity);
    }

    public Food findFood(String foodName, User user){
        return this.foodManager.findFood(foodName, user);
    }

    public String updateFood(String foodName, String updateField, String updateItem, User user){
        return this.foodManager.updateFood(this.findFood(foodName, user), updateField, updateItem);
    }

    public String addFoodQuantity(String foodName, String quantity, User user){
        return this.foodManager.addFoodQuantity(this.findFood(foodName, user), quantity);
    }

    public String deleteEntity(String foodName, User user) {
        Food food = this.findFood(foodName, user);
        return this.foodManager.removeFoodfromList(food, user.getKitchen());
    }

}
