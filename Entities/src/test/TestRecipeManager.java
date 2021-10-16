package test;

import Entities.User;
import org.junit.Before;
import org.junit.Test;
import use_cases.RecipeManager;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TestRecipeManager {
    RecipeManager recipeManager;
    User user;

    @Before
    public void setUp() {
        user = new User("Bob", "Bob", "bob@user.ca");
        recipeManager = new RecipeManager();
    }

    @Test(timeout = 50)
    public void TestMakeNewRecipeInUser() {

        String recipeInstructions = "My awesome curry recipe!";
        HashMap<String, Float> ingredients = new HashMap<String, Float>();
        ingredients.put("apples", 1.0F);
        ingredients.put("Curry", 1.0F);
        recipeManager.addNewRecipe(user, 1,"Curry", 30, recipeInstructions, ingredients);
        assertEquals(user.getRecipes().get(0).getTitle(), "Curry");
        assertEquals(user.getRecipes().get(0).getServings(), "1");
    }
}
