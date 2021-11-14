package controllers;

import entities.Kitchen;
import entities.food.Food;
import usecases.FoodFactory;

import java.util.ArrayList;

public class FoodControlCentre extends ControlCentre implements FoodFactory {
    public Food createEntity(String foodType, String foodName, int sl, int quantity, String unit){
        return FoodFactory.getFood(foodType, foodName, sl, quantity, unit);
    }

    public ArrayList<Food> addFoodtoList(Kitchen kitchen){
        return kitchen.getFood();
    }

    public StringBuilder showFood(Food food){
        return food.getInfoQuantity();
    }

    public void deleteEntity() {

    }

    public void updateEntity() {

    }
}
