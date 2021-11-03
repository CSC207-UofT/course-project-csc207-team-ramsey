package controllers;

/**
 * Abstract class for FoodControlCentre, RecipeControlCentre,
 * UserControlCentre, and KitchenControlCentre
 */
abstract class ControlCentre {

    abstract public void createEntity();

    abstract public void deleteEntity();

    abstract public void updateEntity();

}
