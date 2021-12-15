package test;


import commandline.RecipeCommands.DeleteRecipeCmd;
import controllers.RecipeControlCentre;
import entities.User;
import org.junit.Before;
import org.junit.Test;
import usecases.RecipeManager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestDeleteRecipeCmd {
    RecipeControlCentre recipeControlCentre;
    RecipeManager recipeManager;
    User user;
    String recipeInstructions;
    HashMap<String, Float> ingredients;
    DeleteRecipeCmd<RecipeControlCentre> deleteRecipeCmd;

    @Before
    public void setUp() {
        user = new User("Bob", "Bob", "bob@user.ca", "1234");
        recipeControlCentre = new RecipeControlCentre(user);
        recipeManager = new RecipeManager();
        recipeManager.addNewRecipe(user, 1,"Curry", 30, recipeInstructions, ingredients, "Chinese", "Dinner");

        recipeInstructions = "My awesome curry recipe!";
        ingredients = new HashMap<>();
        ingredients.put("apples", 1.0F);
        ingredients.put("Curry", 1.0F);
        deleteRecipeCmd = new DeleteRecipeCmd<>(recipeControlCentre);
    }

    @Test(timeout = 50)
    public void TestDeleteRecipeInitiate() {
        assertEquals(user.getKitchen().getRecipes().size(), 1);
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("Curry\nn\n".getBytes()));

        deleteRecipeCmd.initiate(new Scanner(System.in));

        System.setIn(stdin);

        assertEquals(user.getKitchen().getRecipes().size(), 0);
    }

}

