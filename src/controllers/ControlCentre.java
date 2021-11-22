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
}
