package constants;
import commandline.*;
import commandline.FoodCommands.*;
import commandline.KitchenShoppingListCommands.*;
import commandline.RecipeCommands.*;
import commandline.UserCommands.ChangeUserNameCmd;
import commandline.UserCommands.ChangeUserPassCmd;
import controllers.*;

import java.util.Hashtable;

public class Constants {
    public final Hashtable<String, CommandExecute> COMMANDS_DIC =
            new Hashtable<>();

    public final KitchenControlCentre kitchenControlCentre;
    public final UserDetailsController userDetailsController;
    public final RecipeControlCentre recipeControlCentre;
    public final FoodControlCentre foodControlCentre;

    public Constants(KitchenControlCentre kitchenControlCentre, UserDetailsController userDetailsController, RecipeControlCentre recipeControlCentre, FoodControlCentre foodControlCentre){
        this.kitchenControlCentre = kitchenControlCentre;
        this.userDetailsController = userDetailsController;
        this.recipeControlCentre = recipeControlCentre;
        this.foodControlCentre = foodControlCentre;
    }

    public void populateConstants(){
        //for UserControlCentre
        COMMANDS_DIC.put("change username", new ChangeUserNameCmd<>(this.userDetailsController));
        COMMANDS_DIC.put("change username", new ChangeUserPassCmd<>(this.userDetailsController));
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
        COMMANDS_DIC.put("display kitchen food", new DisplayKitchenFoodCmd<>(this.kitchenControlCentre));
        COMMANDS_DIC.put("display shopping list", new DisplayShoppingListCmd<>(this.kitchenControlCentre));
        COMMANDS_DIC.put("add from recipe", new AddFromRecipeCmd<>(this.kitchenControlCentre));
        COMMANDS_DIC.put("show kitchen recipes", new ShowKitchenRecipesCmd<>(this.kitchenControlCentre));
        COMMANDS_DIC.put("buy food from shopping list", new BuyFoodFromListCmd<>(this.kitchenControlCentre));


        //for RecipeControlCentre
        COMMANDS_DIC.put("crtRecipe", new CreateRecipeCmd<>(this.recipeControlCentre));
        COMMANDS_DIC.put("delRecipe", new DeleteRecipeCmd<>(this.recipeControlCentre));
        COMMANDS_DIC.put("dsplyRecipes", new DisplayRecipesCmd<>(this.recipeControlCentre));
        COMMANDS_DIC.put("showRecipe", new ShowRecipeCmd<>(this.recipeControlCentre));
        COMMANDS_DIC.put("editRecipe", new EditRecipeDetailsCmd<>(this.recipeControlCentre));


    }

}

