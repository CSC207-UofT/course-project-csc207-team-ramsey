package test;

import controllers.RecipeControlCentre;
import entities.Recipe;
import entities.User;
import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;


import static org.junit.Assert.assertEquals;

public class TestRecipeControlCentre {
    RecipeControlCentre recipeControlCentre;
    User user;
    String recipeInstructions;
    HashMap<String, Float> ingredients;

    @Before
    public void setUp() {
        user = new User("Bob", "Bob", "bob@user.ca", "1234");
        recipeControlCentre = new RecipeControlCentre(user);

        recipeInstructions = "My awesome curry recipe!";
        ingredients = new HashMap<>();
        ingredients.put("apples", 1.0F);
        ingredients.put("Curry", 1.0F);
        recipeControlCentre.createEntity(2, "Lasagne", 30, recipeInstructions, ingredients, "Italian", "Dinner");
    }

    @Test(timeout = 50)
    public void TestCreateEntity() {


        assertEquals(user.getKitchen().getRecipes().get(0).getTitle(), "Lasagne");
    }

    @Test(timeout = 50)
    public void TestGetListByCategory() {
        List<Recipe> theList = recipeControlCentre.getListByCategory("Italian");

        assertEquals(theList.size(), 1);
        assertEquals(theList.get(0).getTitle(), "Lasagne");
    }

    @Test(timeout = 50)
    public void TestGetRecipeString() {
        String theString = recipeControlCentre.getRecipeString("Lasagne");
        String[] result = theString.split("\n", 2);

        assertEquals(result[0].toString(), "Lasagne");
    }

    @Test(timeout = 50)
    public void TestRemoveRecipe() {
        recipeControlCentre.removeRecipe("Lasagne");

        assertEquals(user.getKitchen().getRecipes().size(), 0);
    }

    @Test(timeout = 50)
    public void TestCheckRecipesNotEmpty() {

        assertEquals(recipeControlCentre.checkRecipesNotEmpty(), true);
    }

    @Test(timeout = 50)
    public void TestCheckInKitchen() {

        assertEquals(recipeControlCentre.checkInKitchen("Lasagne"), true);
    }


}
