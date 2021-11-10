package controllers;

import entities.food.Food;
import usecases.FoodFactory;

public class FoodControlCentre implements FoodFactory {
    public Food createEntity(String foodType, String foodName, int sl, int quantity, String unit){
        return getFood(foodType, foodName, sl, quantity, unit);
    }

    public void deleteEntity() {

    }

    public void updateEntity() {

    }
}
