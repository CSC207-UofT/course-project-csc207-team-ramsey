package controllers;

import entities.User;

public abstract class ControlCentre {
    private final User user;

    public ControlCentre(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }
}
