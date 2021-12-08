package test;

import commandline.CreateRecipeCmd;
import controllers.RecipeControlCentre;
import entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usecases.RecipeManager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestCreateRecipeCmd {
    RecipeControlCentre recipeControlCentre;
    RecipeManager recipeManager;
    User user;
    String recipeInstructions;
    HashMap<String, Float> ingredients;
    CreateRecipeCmd createRecipeCmd;

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
        createRecipeCmd = new CreateRecipeCmd(recipeControlCentre);
    }

    @Test(timeout = 50)
    public void TestCreateRecipeInitiate() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("Dinner\nItalian\nLasagne\n15\n2\ntomato:2\nbeef:50\ndone\nmake lasagne\nn\n".getBytes()));

        createRecipeCmd.initiate(new Scanner(System.in));

        System.setIn(stdin);

        assertEquals(user.getKitchen().getRecipes().get(1).getTitle(), "Lasagne");
    }

}
