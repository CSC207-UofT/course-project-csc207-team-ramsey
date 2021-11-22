package controllers;

import entities.Kitchen;
import entities.User;
import entities.food.Food;
import usecases.FoodFactory;

import java.util.ArrayList;

public class FoodControlCentre extends ControlCentre implements FoodFactory {
    public FoodControlCentre(User user) {
        super(user);
    }

    public Food createEntity(String foodType, String foodName, int sl, int quantity, String unit){
        Food newFood = FoodFactory.getFood(foodType, foodName, sl, quantity, unit);
        this.getUser().getKitchen().addFoodtoList(newFood);
        return newFood;
    }

    public ArrayList<Food> addFoodtoList(Kitchen kitchen){
        return kitchen.getFood();
    }

    @Override
    public StringBuilder showFood(Food food){
        return food.getInfoQuantity();
    }

    public void deleteEntity() {

    }

    public void updateEntity() {

    }
}
