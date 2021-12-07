package UI;

import constants.Constants;
import controllers.*;
import entities.Kitchen;
import entities.User;

import java.util.Objects;
import java.util.Scanner;

public class UI {
    public Scanner s;
    private FoodControlCentre foodControlCentre;
    private KitchenControlCentre kitchenControlCentre;
    private LoginController loginController;
    private UserControlCentre userControlCentre;
    private RecipeControlCentre recipeControlCentre;

    public UI(FoodControlCentre foodControlCentre, KitchenControlCentre kitchenControlCentre, LoginController loginController, UserControlCentre userControlCentre, RecipeControlCentre recipeControlCentre){
        this.foodControlCentre = foodControlCentre;
        this.kitchenControlCentre = kitchenControlCentre;
        this.loginController = loginController;
        this.userControlCentre = userControlCentre;
        this.recipeControlCentre = recipeControlCentre;
        this.s = new Scanner(System.in);
    }

    public User runLogin(){

    }

    public void receiveCommands(){
        do{
            String command = this.s.nextLine();
            for(String commandNames : Constants.COMMANDS_DIC.keySet()){
                if (command.equals(commandNames)){
                    Constants.COMMANDS_DIC.get(commandNames).initiate(this.s);
                }
            }
        } while(!Objects.equals(this.s.nextLine(), "exit"));
    }

    public void execute(){
        runLogin();
        System.out.println("");
        receiveCommands();
    }
}
