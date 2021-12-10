package constants;
import commandline.*;
import controllers.*;

import java.util.Hashtable;

public class Constants {
    public Hashtable<String, CommandExecute> COMMANDS_DIC =
            new Hashtable<String, CommandExecute>();

    public KitchenControlCentre kitchenControlCentre;
    public UserControlCentre userControlCentre;
    public RecipeControlCentre recipeControlCentre;

    public Constants(KitchenControlCentre kitchenControlCentre, UserControlCentre userControlCentre, RecipeControlCentre recipeControlCentre){
        this.kitchenControlCentre = kitchenControlCentre;
        this.userControlCentre = userControlCentre;
        this.recipeControlCentre = recipeControlCentre;
    }

    public void populateConstants(){
        //for LoginController


        //for UserControlCentre


        //for FoodControlCentre

        //for KitchenControlCentre


        //for RecipeControlCentre
        COMMANDS_DIC.put("crtRecipe", new CreateRecipeCmd<>(this.recipeControlCentre));
        COMMANDS_DIC.put("delRecipe", new DeleteRecipeCmd<>(this.recipeControlCentre));
        COMMANDS_DIC.put("dsplyRecipes", new DisplayRecipesCmd<>(this.recipeControlCentre));
        COMMANDS_DIC.put("showRecipe", new ShowRecipeCmd<>(this.recipeControlCentre));

    }

}

