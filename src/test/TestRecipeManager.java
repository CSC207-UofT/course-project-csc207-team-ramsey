package test;

import entities.User;
import org.junit.Before;
import org.junit.Test;
import usecases.RecipeManager;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TestRecipeManager {
    RecipeManager recipeManager;
    User user;
    String recipeInstructions;
    HashMap<String, Float> ingredients;

    @Before
    public void setUp() {
        user = new User("Bob", "Bob", "bob@user.ca", "123");
        recipeManager = new RecipeManager();
        recipeManager.addNewRecipe(user, 1,"Curry", 30, recipeInstructions, ingredients, "Chinese", "Dinner");

        recipeInstructions = "My awesome curry recipe!";
        ingredients = new HashMap<>();
        ingredients.put("apples", 1.0F);
        ingredients.put("Curry", 1.0F);
    }

    @Test(timeout = 50)
    public void TestMakeNewRecipeInUser() {

        assertEquals(user.getKitchen().getRecipes().size(), 1);
        assertEquals(user.getKitchen().getRecipes().get(0).getTitle(), "Curry");
        assertEquals(user.getKitchen().getRecipes().get(0).getServings(), Integer.toString(1));
    }

    @Test(timeout = 50)
    public void TestRemoveRecipe(){

        assertEquals(user.getKitchen().getRecipes().size(), 2);
        recipeManager.removeRecipe(user, "Fried Rice");

        assertEquals(user.getKitchen().getRecipes().size(), 1);
    }

    @Test(timeout = 50)
    public void TestChangeRecipeName(){

        recipeManager.changeRecipeName(user, "Curry", "Good Curry");

        assertEquals(user.getKitchen().getRecipes().get(0).getTitle(), "Good Curry");
    }

    @Test(timeout = 50)
    public void TestChangeRecipeServings(){

        recipeManager.changeRecipeServings(user, "Curry", 2);
        assertEquals(user.getKitchen().getRecipes().get(0).getServings(), Integer.toString(2));
    }

    @Test(timeout = 50)
    public void TestChangeRecipePrepTime(){

        recipeManager. changeRecipePrepTime(user, "Curry", 45);
        assertEquals(user.getKitchen().getRecipes().get(0).getPrepTime(), 45);
    }

    @Test(timeout = 50)
    public void TestChangeRecipeSteps(){

        recipeManager.changeRecipeSteps(user, "Curry", "Cook the Curry!");

        assertEquals(user.getKitchen().getRecipes().get(0).getInstructions(), "Cook the Curry!");
    }

    @Test(timeout = 50)
    public void TestChangeIngredients(){
        HashMap<String, Float> newIngredients = new HashMap<>();
        newIngredients.put("curry powder", 50F);


        recipeManager.changeIngredients(user, "Curry", newIngredients);
        assertEquals(user.getKitchen().getRecipes().get(0).getIngredients(), newIngredients);
    }

}

