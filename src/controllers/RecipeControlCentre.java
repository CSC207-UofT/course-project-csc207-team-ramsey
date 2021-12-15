package controllers;


import entities.Recipe;
import entities.User;
import usecases.FoodManager;
import usecases.RecipeManager;

import java.util.HashMap;
import java.util.List;

/**
 * the controlCentre fo recipes
 */
public class RecipeControlCentre{
    User user;
    RecipeManager recipeManager;
    FoodManager foodManager;

    public RecipeControlCentre(User user) {
        this.user = user;
        this.recipeManager = new RecipeManager();
        this.foodManager = new FoodManager();
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
     * checks if ingredient is in a specific recipe of user
     * @param recipeName the recipe title
     * @param ingredient the input ingredient
     * @return boolean for whether ingredient is found
     */
    public boolean checkIsIngredient(String recipeName, String ingredient){
        return this.recipeManager.isIngredient(this.user, recipeName, ingredient);
    }

    /**
     * checks if a recipe is in the user's kitchen
     * @param recipeName is the name of the recipe
     * @return boolean for whether the recipe is in the kitchen
     */
    public boolean checkInKitchen(String recipeName){
        return this.recipeManager.checkInKitchen(this.user, recipeName);
    }


    public boolean editRecipe(String recipeName, String variable, String change){
        switch (variable) {
            case "name":
                recipeManager.changeRecipeName(this.user, recipeName, change);
                break;
            case "servings":
                recipeManager.changeRecipeServings(this.user, recipeName, Integer.parseInt(change));
                break;
            case "prep time":
                recipeManager.changeRecipePrepTime(this.user, recipeName, Integer.parseInt(change));
                break;
            case "instructions":
                recipeManager.changeRecipeSteps(this.user, recipeName, change);
                break;
            case "country category":
                recipeManager.changeCountryCategory(this.user, recipeName, change);
                break;
            case "meal time category":
                recipeManager.changeTimeCategory(this.user, recipeName, change);
                break;
            default:
                return false;
        }
        return true;
    }

    public boolean editRecipe(String recipeName,String variable, String originalIngr, String newIngredient, String newValue){
        if (variable.equals("ingredients")){
            recipeManager.changeIngredient(this.user, recipeName, originalIngr, newIngredient, newValue);
            return true;
        }
        return false;
    }

    /**
     * @param recipeName the name of the recipe to search
     * @return a HashMap of current ingredient of a recipe
     */
    public HashMap<String, Float> getIngredientMap(String recipeName){
        return this.recipeManager.getIngredientMap(this.user, recipeName);
    }

}

