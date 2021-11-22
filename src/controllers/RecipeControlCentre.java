package controllers;


import entities.Recipe;
import entities.User;
import entities.food.Food;

import usecases.RecipeManager;

import java.util.HashMap;
import java.util.List;

/**
 * the controlCentre fo recipes
 */
public class RecipeControlCentre extends ControlCentre{
    User user;
    RecipeManager recipeManager;

    public RecipeControlCentre(User user) {
        super(user);
        this.recipeManager = new RecipeManager();
    }

    /**
     * create a Recipe using recipeManager
     * @param servings
     * @param name
     * @param time
     * @param steps
     * @param ingredients
     * @param categoryCountry
     * @param categoryTime
     */
    public void createEntity(int servings, String name, int time, String steps, HashMap<String, Float> ingredients, String categoryCountry, String categoryTime) {
        this.recipeManager.addNewRecipe(this.user, servings, name, time, steps, ingredients, categoryCountry, categoryTime);
    }

    /**
     * get either the full recipe list from the user or a list of recipes from a specific category
     * @param category
     * @return the user's recipe list
     */
    public List<Recipe> getRecipeList(String category){
        return this.recipeManager.getRecipeList(this.user, category);
    }

    /**
     * get the String representation of a recipe
     * @param recipeName
     * @return
     */
    public String getRecipe(String recipeName){
        return this.recipeManager.showRecipe(this.user, recipeName);
    }

    public void deleteRecipe(String recipeName){
        recipeManager.removeRecipe(this.user, recipeName);
    }

    public boolean checkRecipesNotEmpty(){
        return !(this.user.getKitchen().getRecipes().isEmpty());
    }

    public boolean checkInKitchen(String recipeName){
        for (Recipe recipe :this.user.getKitchen().getRecipes()){
            if (recipeName.equals(recipe.getTitle())){
                return true;
            }
        }
        return false;
    }
}
