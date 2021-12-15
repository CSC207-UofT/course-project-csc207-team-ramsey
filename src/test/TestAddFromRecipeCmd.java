package test;

import commandline.AddFromRecipeCmd;
import controllers.KitchenControlCentre;
import entities.Recipe;
import entities.User;
import entities.food.Food;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestAddFromRecipeCmd {
    KitchenControlCentre kitchenControl;
    User user;
    ArrayList<Recipe> recipes;
    ArrayList<Food> shoppingList;
    String instructions;
    HashMap<String, Float> ingredients;
    AddFromRecipeCmd<KitchenControlCentre> showAddFromRecipeCmd;

    @Before
    public void setUp() {
        user = new User("Guy", "CoolUserGuy", "cooluseremail@aaaaaa.ca", "pass");
        kitchenControl = new KitchenControlCentre(user);
        recipes = user.getKitchen().getRecipes();
        shoppingList = user.getKitchen().getShoppingList();
        ingredients = new HashMap<>();
        ingredients.put("great ingredient", 2.0F);
        ingredients.put("even better ingredient", 4.5F);
        Recipe newRecipe = new Recipe(1,"Good Recipe", 60, instructions, ingredients, "Italian", "Lunch");
        recipes.add(newRecipe);

        showAddFromRecipeCmd = new AddFromRecipeCmd<KitchenControlCentre>(kitchenControl);
    }

    @Test(timeout = 50)
    public void TestDisplayRecipesInitiate() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("full\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        showAddFromRecipeCmd.initiate(new Scanner(System.in));

        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String[] lines = outputText.split("\\n");

        assertEquals(lines[lines.length-1].trim(), "- great ingredient");
    }
}
