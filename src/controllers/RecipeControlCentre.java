package controllers;


import entities.Recipe;
import entities.User;
import usecases.RecipeManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * the controlCentre fo recipes
 */
public class RecipeControlCentre{
    User user;
    RecipeManager recipeManager;

    public RecipeControlCentre(User user) {
        this.user = user;
        this.recipeManager = new RecipeManager();
    }

    /**
     * create a Recipe using recipeManager
     * @param servings is the number of servings of the recipe
     * @param name is the name of the recipe
     * @param time is the amount of time in minutes to complete the recipe
     * @param steps is the instructions of the recipe
     * @param ingredients is the ingredients and quaintites of the recipe
     * @param categoryCountry  is the MealCountry category of the recipe
     * @param categoryTime is the MealTiem category of the recipe
     */
    public void createEntity(int servings, String name, int time, String steps, HashMap<String, Float> ingredients, String categoryCountry, String categoryTime) {
        this.recipeManager.addNewRecipe(this.user, servings, name, time, steps, ingredients, categoryCountry, categoryTime);
    }

    /**
     * get either the full recipe list from the user or a list of recipes from a specific category
     * @param category is the input recipe category
     * @return the user's recipe list
     */
    public List<Recipe> getListByCategory(String category){
        return this.recipeManager.getRecipeList(this.user, category);
    }

    /**
     * get the String representation of a recipe
     * @param recipeName is the name of the recipe
     * @return String
     */
    public String getRecipeString(String recipeName){
        return this.recipeManager.showRecipe(this.user, recipeName);
    }

    /**
     * remove a recipe from user's recipe list
     * @param recipeName is the name of the recipe
     * @return boolean for whether recipe was successfully removed
     */
    public boolean removeRecipe(String recipeName){
        return this.recipeManager.removeRecipe(this.user, recipeName);
    }


    /**
     * Checks if user's recipe list is not empty
     * @return boolean for whether recipe list is not empty
     */
    public boolean checkRecipesNotEmpty(){
        return !(this.user.getKitchen().getRecipes().isEmpty());
    }

    /**
     * checks if a recipe is in the user's kitchen
     * @param recipeName is the name of the recipe
     * @return boolean for whether the recipe is in the kitchen
     */
    public boolean checkInKitchen(String recipeName){
        for (Recipe recipe :this.user.getKitchen().getRecipes()){
            if (recipeName.equals(recipe.getTitle())){
                return true;
            }
        }
        return false;
    }

//    public boolean editRecipe(String recipeName, String variable, String change){
//        if (variable.equals("name")){
//            return recipeManager.changeRecipeName(this.user, recipeName, change);
//        }
//        if (variable.equals("servings")){
//            return recipeManager.changeRecipeServings(this.user, recipeName, Integer.parseInt(change));
//        }
//        if (variable.equals("prep time")){
//            return recipeManager.changeRecipePrepTime(this.user, recipeName, Integer.parseInt(change));
//        }
//        if (variable.equals("instructions")){
//            return recipeManager.changeRecipeSteps(this.user, recipeName, change);
//        }
//        if (variable.equals("ingredients")){
//            return recipeManager.changeIngredients(this.user);
//        }
//    }
//
//    public boolean editRecipe(String recipeName, String ingredient, String variable, String change){
//        if (variable.equals("ingredients")){
//            return recipeManager.changeIngredients(this.user);
//        }
//    }
}
