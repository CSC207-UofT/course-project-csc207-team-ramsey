package test.RecipeTests;

import commandline.RecipeCommands.DisplayRecipesCmd;
import controllers.RecipeControlCentre;
import entities.User;
import org.junit.Before;
import org.junit.Test;
import usecases.RecipeManager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestDisplayRecipesCmd {
    RecipeControlCentre recipeControlCentre;
    RecipeManager recipeManager;
    User user;
    String recipeInstructions;
    HashMap<String, Float> ingredients;
    DisplayRecipesCmd<RecipeControlCentre> displayRecipesCmd;

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
        displayRecipesCmd = new DisplayRecipesCmd<RecipeControlCentre>(recipeControlCentre);
    }

    @Test(timeout = 50)
    public void TestDisplayRecipesInitiate() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("full\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        displayRecipesCmd.initiate(new Scanner(System.in));

        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String[] lines = outputText.split("\\n");

        assertEquals(lines[lines.length-1].trim(), "-Curry");
    }
}

