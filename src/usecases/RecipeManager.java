package usecases;


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
     */
    public void addNewRecipe(User user, int servings, String name, int time, String steps, HashMap<String, Float> ingredients, String categoryCountry, String categoryTime){

        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();

        for(Recipe recipe : curRecipes){
            if (recipe.getTitle().equals(name)){
                return;
            }
        }
        Recipe newRecipe = new Recipe(servings, name, time, steps, ingredients, categoryCountry, categoryTime);
        user.getKitchen().getRecipes().add(newRecipe);
    }

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
     */
    public void changeRecipeName(User user, String currName, String newName) {
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(currName)) {
                curRecipe.setTitle(newName);
                return;
            }
        }
    }

    /**
     * change recipe servings
     * @param user a user of the program
     * @param recipeName the name of the recipe
     * @param newServings the new servings of the recipe
     */
    public void changeRecipeServings(User user, String recipeName, int newServings){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(recipeName)) {
                curRecipe.setServings(newServings);
                return;
            }
        }
    }

    /**
     * change recipe prepTime
     * @param user  a user of the program
     * @param recipeName the name of the recipe
     * @param newPrepTime the new preptime of the recipe
     */
    public void changeRecipePrepTime(User user, String recipeName, int newPrepTime){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(recipeName)) {
                curRecipe.setPrepTime(newPrepTime);
                return;
            }
        }
    }

    /**
     * change recipe instructions
     * @param user a user of the program
     * @param recipeName the name of the recipe
     * @param newInstructions the new instructions of the recipe
     */
    public void changeRecipeSteps(User user, String recipeName, String newInstructions){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(recipeName)) {
                curRecipe.setInstructions(newInstructions);
                return;
            }
        }
    }

    /**
     * change the ingredients of the recipe
     * @param user a user of the program
     * @param recipeName the name of the recipe
     * @param newIngredients the new ingredients of the recipe
     */
    public void changeIngredients(User user, String recipeName, HashMap<String, Float> newIngredients){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(recipeName)) {
                curRecipe.setIngredients(newIngredients);
                return;
            }
        }
    }

    /**
     * change a specific ingredient for a recipe
     * @param user is a user of the program
     * @param recipeName is the name of a recipe
     * @param originalIngr is the original ingredient to be modified
     * @param newIngredient is the new ingredient name
     * @param newValue is the new value for the ingredient
     */
    public void changeIngredient(User user, String recipeName, String originalIngr, String newIngredient, String newValue){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(recipeName)) {
                HashMap<String, Float> shallowCopy = new HashMap<>(curRecipe.getIngredients());
                if (!newIngredient.equals(originalIngr)){
                    shallowCopy.remove(originalIngr);
                    shallowCopy.put(newIngredient, Float.parseFloat(newValue));
                } else{
                    shallowCopy.replace(originalIngr, Float.parseFloat(newValue));

                }
                return;
            }
        }
    }

    /**
     * change countryCategory of recipe
     * @param user is a user of the program
     * @param recipeName is the name of the recipe where change takes place
     * @param change is the inputted change for the category
     */
    public void changeCountryCategory(User user, String recipeName, String change){
        for (Recipe recipe : user.getKitchen().getRecipes()){
            if (recipe.getTitle().equals(recipeName)){
                recipe.setCategoryCountry(change);
                return;
            }
        }
    }

    /**
     * change categoryTime of recipe
     * @param user is a user of the program
     * @param recipeName is the name of the recipe where change takes place
     * @param change is the inputted change for the category
     */
    public void changeTimeCategory(User user, String recipeName, String change){
        for (Recipe recipe : user.getKitchen().getRecipes()){
            if (recipe.getTitle().equals(recipeName)){
                recipe.setCategoryTime(change);
                return;
            }
        }
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
                return recipe.recToString();
            }
        }
        return null;
    }

    /**
     * checks if ingredient is in a specific recipe of a user
     * @param user is a user of the program
     * @param recipeName is the name of the recipe
     * @param ingredient is an ingredient
     * @return boolean for whether ingredient is n the recipe of the user
     */
    public boolean isIngredient(User user, String recipeName, String ingredient){
        for(Recipe recipe : user.getKitchen().getRecipes()){
            if (recipeName.equals(recipe.getTitle())){
                for(String ingr: recipe.getIngredients().keySet()){
                    if (ingr.equals(ingredient)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * checks if a recipe is in the user's kitchen
     * @param recipeName is the name of the recipe
     * @return boolean for whether the recipe is in the kitchen
     */
    public boolean checkInKitchen(User user, String recipeName){
        for (Recipe recipe : user.getKitchen().getRecipes()){
            if (recipeName.equals(recipe.getTitle())){
                return true;
            }
        }
        return false;
    }

    /**
     * @param user is a user of the program
     * @param recipeName is the name of the inputted recipe search
     * @return a HashMap containing the user ingredient info
     */
    public HashMap<String, Float> getIngredientMap(User user, String recipeName){
        HashMap<String, Float> ingredients = null;
        for (Recipe recipe: user.getKitchen().getRecipes()){
            if (recipe.getTitle().equals(recipeName)){
                ingredients = recipe.getIngredients();
            }
        }
        return ingredients;
    }
}

