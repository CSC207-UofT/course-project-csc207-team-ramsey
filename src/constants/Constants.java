package constants;
import commandline.*;
import controllers.*;

import java.util.Hashtable;

public class Constants {
    public static Hashtable<String, CommandExecute> COMMANDS_DIC =
            new Hashtable<String, CommandExecute>();
    public FoodControlCentre foodControlCentre;
    public KitchenControlCentre kitchenControlCentre;
    public LoginController loginController;
    public UserControlCentre userControlCentre;
    public RecipeControlCentre recipeControlCentre;

    public Constants(FoodControlCentre foodControlCentre, KitchenControlCentre kitchenControlCentre, LoginController loginController, UserControlCentre userControlCentre, RecipeControlCentre recipeControlCentre){
        this.foodControlCentre = foodControlCentre;
        this.kitchenControlCentre = kitchenControlCentre;
        this.loginController = loginController;
        this.userControlCentre = userControlCentre;
        this.recipeControlCentre = recipeControlCentre;

    }

    public void populateConstants(){
        //for LoginController

        //for UserControlCentre

        //for FoodControlCentre
        COMMANDS_DIC.put("crtfood", new CreateFoodCmd(this.foodControlCentre));
        COMMANDS_DIC.put("srtfood", new SortFoodCmd(this.foodControlCentre));

        //for KitchenControlCentre


        //for RecipeControlCentre
        COMMANDS_DIC.put("crtrecipe", new CreateRecipeCmd(this.recipeControlCentre));
        COMMANDS_DIC.put("srtrecipes", new SortRecipeCmd(this.recipeControlCentre));
    }

}
