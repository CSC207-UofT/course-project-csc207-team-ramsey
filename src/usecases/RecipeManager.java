package usecases;

import constants.MealCountry;
import constants.MealTime;
import entities.Recipe;
import entities.User;
import recipe_filter.mealCountry.*;
import recipe_filter.mealTime.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A RecipeManager that Manages the Recipes and the User Recipe List
 */
public class RecipeManager {

    /**
     *
     * @param user a user of the program
     * @param servings the number of people the recipe serves
     * @param name the name of the recipe
     * @param time the time it takes to cook in minutes
     * @param steps the instructions of the recipe
     * @param ingredients the required ingredients and their quantities
     * @return boolean showing whether recipe was added
     */
    public boolean addNewRecipe(User user, int servings, String name, int time, String steps, HashMap<String, Float> ingredients, String categoryCountry, String categoryTime){

        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();

        for(Recipe recipe : curRecipes){
            if (recipe.getTitle().equals(name)){
                return false;
            }
        }
        Recipe newRecipe = new Recipe(servings, name, time, steps, ingredients, categoryCountry, categoryTime);
        user.getKitchen().getRecipes().add(newRecipe);
        return true;
    }


//    public boolean makeRecipe(User user, String recipeName){
//        ArrayList<Recipe> recipeList = user.getKitchen().getRecipes();
//        for (Recipe recipe : recipeList){
//            if (recipe.getTitle().equals(recipeName)){
//                if (checkEnoughFood(recipeName)){
//
//                } else {
//
//                }
//            }
//        }
//    }

    /**
     * remove a recipe from the user's kitchen
     * @param user a user of the program
     * @param name the name of the recipe
     * @return boolean showing whether recipes was removed
     */
    public boolean removeRecipe(User user, String name){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (int i =0; i < curRecipes.size(); i++){
            if (curRecipes.get(i).getTitle().equals(name)){
                curRecipes.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * check if a recipe with a specific name is in the user's recipe list
     * @param user a user of the program
     * @param name the name of the recipe
     * @return boolean for whether recipe is in list
     */
    public boolean checkInRecipeList(User user, String name){
        for(Recipe recipe: user.getKitchen().getRecipes()){
            if (recipe.getTitle().equals(name)){
                return true;
            }
        }
        return false;
    }

    /**
     * change Recipe name to a newName
     * @param user a user of the program
     * @param currName the name of the recipe
     * @param newName the new name of the recipe
     * @return boolean representing whether new name was set
     */
    public boolean changeRecipeName(User user, String currName, String newName) {
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(currName)) {
                curRecipe.setTitle(newName);
                return true;
            }
        }
        return false;
    }

    /**
     * change recipe servings
     * @param user a user of the program
     * @param recipeName the name of the recipe
     * @param newServings the new servings of the recipe
     * @return boolean value showing whether newServings was set
     */
    public boolean changeRecipeServings(User user, String recipeName, int newServings){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(recipeName)) {
                curRecipe.setServings(newServings);
                return true;
            }
        }
        return false;
    }

    /**
     * change recipe prepTime
     * @param user  a user of the program
     * @param recipeName the name of the recipe
     * @param newPrepTime the new preptime of the recipe
     * @return boolean value depending on whether recipe preptime is changed
     */
    public boolean changeRecipePrepTime(User user, String recipeName, int newPrepTime){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(recipeName)) {
                curRecipe.setPrepTime(newPrepTime);
                return true;
            }
        }
        return false;
    }

    /**
     * change recipe instructions
     * @param user a user of the program
     * @param recipeName the name of the recipe
     * @param newInstructions the new instructions of the recipe
     * @return boolean value depending on whether recipe instructions are changed
     */
    public boolean changeRecipeSteps(User user, String recipeName, String newInstructions){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(recipeName)) {
                curRecipe.setInstructions(newInstructions);
                return true;
            }
        }
        return false;
    }

    /**
     * change the ingredients of the recipe
     * @param user a user of the program
     * @param recipeName the name of the recipe
     * @param newIngredients the new ingredients of the recipe
     * @return boolean value depending on whether recipe ingredients is changed
     */
    public boolean changeIngredients(User user, String recipeName, HashMap<String, Float> newIngredients){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(recipeName)) {
                curRecipe.setIngredients(newIngredients);
                return true;
            }
        }
        return false;
    }

    /**
     * gets a user's list of Recipes
     * @param user a user of the program
     * @param category is a category of the Recipe (either MealTime or MealCountry)
     * @return either a full list of Recipes or a list or Recipes of a specific category
     */
    public List<Recipe> getRecipeList(User user, String category){
        if (category.equals("full")){
            return user.getKitchen().getRecipes();
        } else {
            if (category.equalsIgnoreCase("Breakfast")){
                BreakfastFilter breakfastFilter= new BreakfastFilter();
                return breakfastFilter.apply(user.getKitchen().getRecipes());
            }
            if (category.equalsIgnoreCase("Brunch")){
                BrunchFilter brunchFilter = new BrunchFilter();
                return brunchFilter.apply(user.getKitchen().getRecipes());
            }
            if (category.equalsIgnoreCase("Lunch")){
                LunchFilter lunchFilter = new LunchFilter();
                return lunchFilter.apply(user.getKitchen().getRecipes());
            }
            if (category.equalsIgnoreCase("Dinner")){
                DinnerFilter dinnerFilter = new DinnerFilter();
                return dinnerFilter.apply(user.getKitchen().getRecipes());
            }
            if (category.equalsIgnoreCase("Dessert")){
                DessertFilter dessertFilter = new DessertFilter();
                return dessertFilter.apply(user.getKitchen().getRecipes());
            }
            if (category.equalsIgnoreCase("American")){
                AmericanFilter americanFilter = new AmericanFilter();
                return americanFilter.apply(user.getKitchen().getRecipes());
            }
            if (category.equalsIgnoreCase("Italian")){
                ItalianFilter italianFilter = new ItalianFilter();
                return italianFilter.apply(user.getKitchen().getRecipes());
            }
            if (category.equalsIgnoreCase("French")){
                FrenchFilter frenchFilter = new FrenchFilter();
                return frenchFilter.apply(user.getKitchen().getRecipes());
            }
            if (category.equalsIgnoreCase("Mexican")){
                MexicanFilter mexicanFilter = new MexicanFilter();
                return mexicanFilter.apply(user.getKitchen().getRecipes());
            }
            if (category.equalsIgnoreCase("Chinese")){
                ChineseFilter chineseFilter = new ChineseFilter();
                return chineseFilter.apply(user.getKitchen().getRecipes());
            }
            if (category.equalsIgnoreCase("Korean")){
                KoreanFilter koreanFilter = new KoreanFilter();
                return koreanFilter.apply(user.getKitchen().getRecipes());
            }
            if (category.equalsIgnoreCase("Japanese")){
                JapaneseFilter japaneseFilter = new JapaneseFilter();
                return japaneseFilter.apply(user.getKitchen().getRecipes());
            }
        }
        return null;
    }

    /**
     * get a String that shows the information of a recipe
     * @param user is a user of the program
     * @param recipeName is the name of the recipe
     * @return the string representation of the recipe
     */
    public String showRecipe(User user, String recipeName){
        for (Recipe recipe: user.getKitchen().getRecipes()){
            if (recipe.getTitle().equals(recipeName)){
                return recipe.recToString()String();
            }
        }
        return null;
    }
}
