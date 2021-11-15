package controllers;


import entities.Recipe;
import entities.User;
import entities.food.Food;

import usecases.RecipeManager;

import java.util.HashMap;
import java.util.List;

public class RecipeControlCentre extends ControlCentre{
    User user;
    RecipeManager recipeManager;


    public RecipeControlCentre(User user) {
        this.user = user;
        this.recipeManager = new RecipeManager();
    }


    public void createEntity(int servings, String name, int time, String steps, HashMap<String, Float> ingredients, String categoryCountry, String categoryTime) {
        this.recipeManager.addNewRecipe(this.user, servings, name, time, steps, ingredients, categoryCountry, categoryTime);
    }

    public List<Recipe> getRecipeList(String category){
        return recipeManager.getRecipeList(this.user, category);
    }

    @Override
    public StringBuilder showFood(Food food) {
        return null;
    }
}
