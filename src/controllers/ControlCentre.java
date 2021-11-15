package controllers;

import entities.food.Food;

/**
 * Interface for FoodControlCentre, RecipeControlCentre,
 * UserControlCentre, and KitchenControlCentre
 */
public abstract class ControlCentre {
    public abstract StringBuilder showFood(Food food);
}
