package controllers;

import entities.Kitchen;
import entities.User;
import entities.food.Food;
import usecases.FoodManager;

import java.util.HashMap;


public abstract class ControlCentre {
    private final User user;

    public ControlCentre(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    public abstract String showFood(Food foodEntry);

    public abstract Food createEntity(String s, String s1, int sl, int quantity, String s2);

    public abstract Food findFood(String foodName, User user);

    public abstract String removeFoodQuantity(String foodName, String quantity, User user);

    public abstract String updateFood(String foodName, String updateField, String updateItem, User user);

    public abstract String addFoodtoList(Food food, Kitchen kitchen);

    public abstract String addFoodQuantity(String foodName, String quantity, User user);
}
