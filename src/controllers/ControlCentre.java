package controllers;

import entities.User;
import entities.food.Food;

public abstract class ControlCentre {
    private final User user;

    public ControlCentre(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }
    public abstract StringBuilder showFood(Food food);

    public abstract Food createEntity(String s, String s1, int sl, int quantity, String s2);
}
