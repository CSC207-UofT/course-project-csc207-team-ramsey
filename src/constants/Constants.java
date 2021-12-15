package constants;
import commandline.*;
import commandline.FoodCommands.*;
import commandline.RecipeCommands.CreateRecipeCmd;
import commandline.RecipeCommands.DeleteRecipeCmd;
import commandline.RecipeCommands.DisplayRecipesCmd;
import commandline.RecipeCommands.*;
import controllers.*;

import java.util.Hashtable;

public class Constants {
    public Hashtable<String, CommandExecute> COMMANDS_DIC =
            new Hashtable<>();

    public KitchenControlCentre kitchenControlCentre;
    public UserDetailsController userDetailsController;
    public RecipeControlCentre recipeControlCentre;
    public FoodControlCentre foodControlCentre;

    public Constants(KitchenControlCentre kitchenControlCentre, UserDetailsController userDetailsController, RecipeControlCentre recipeControlCentre, FoodControlCentre foodControlCentre){
        this.kitchenControlCentre = kitchenControlCentre;
        this.userDetailsController = userDetailsController;
        this.recipeControlCentre = recipeControlCentre;
        this.foodControlCentre = foodControlCentre;
    }

    public void populateConstants(){
        //for LoginController


        //for UserControlCentre


        //for FoodControlCentre
        COMMANDS_DIC.put("create food", new CreateFoodCmd<>(this.foodControlCentre));
        COMMANDS_DIC.put("add quantity", new AddFoodQuantity<>(this.foodControlCentre));
        COMMANDS_DIC.put("delete food", new DeleteFood<>(this.foodControlCentre));
        COMMANDS_DIC.put("remove quantity", new RemoveFoodQuantity<>(this.foodControlCentre));
        COMMANDS_DIC.put("show food", new ShowFood<>(this.foodControlCentre));
        COMMANDS_DIC.put("sort food by category", new SortFoodByCategory<>(this.foodControlCentre));
        COMMANDS_DIC.put("sort food by expiration", new SortFoodByExpiration<>(this.foodControlCentre));
        COMMANDS_DIC.put("update food", new UpdateFood<>(this.foodControlCentre));


        //for KitchenControlCentre


        //for RecipeControlCentre
        COMMANDS_DIC.put("crtRecipe", new CreateRecipeCmd<>(this.recipeControlCentre));
        COMMANDS_DIC.put("delRecipe", new DeleteRecipeCmd<>(this.recipeControlCentre));
        COMMANDS_DIC.put("dsplyRecipes", new DisplayRecipesCmd<>(this.recipeControlCentre));
        COMMANDS_DIC.put("showRecipe", new ShowRecipeCmd<>(this.recipeControlCentre));
        COMMANDS_DIC.put("editRecipe", new EditRecipeDetailsCmd<>(this.recipeControlCentre));


    }

}

