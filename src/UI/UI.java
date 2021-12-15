package UI;

import commandline.UserCommands.DeleteUser;
import commandline.UserCommands.LoginRegisterUI;
import commandline.UserCommands.SaveUserChangeCmd;
import constants.Constants;
import controllers.*;
import entities.User;
import java.util.Scanner;

/**
 * UI class for user to input commands
 */

public class UI {
    public Scanner s;
    private final Constants constants;
    private LoginController loginController;
    User user;

    public UI() throws Exception {
        LoginRegisterUI loginRegisterUI = new LoginRegisterUI();
        this.user = loginRegisterUI.initiate();
        KitchenControlCentre kitchenControlCentre = new KitchenControlCentre(user);
        RecipeControlCentre recipeControlCentre = new RecipeControlCentre(user);
        FoodControlCentre foodControlCentre = new FoodControlCentre(user);
        UserDetailsController userDetailsController = new UserDetailsController(user);
        this.s = new Scanner(System.in);
        this.constants = new Constants(kitchenControlCentre, userDetailsController, recipeControlCentre, foodControlCentre);
        this.constants.populateConstants();
    }

    public void receiveCommands() throws Exception {
        // list out possible commands
        System.out.println("Please, input one of the following commands to continue:");
        System.out.println("\t- exit");
        for(String command: this.constants.COMMANDS_DIC.keySet()){
            System.out.println("\t- " + command);
        }
        while(true){
            boolean success = false;
            System.out.print("$ ");
            String command = this.s.nextLine();
            if (command.equals("showCommands")) {
                System.out.println("Please, input one of the following commands to continue:");
                System.out.println("\t- exit");
                for (String cmd : this.constants.COMMANDS_DIC.keySet()) {
                    System.out.println("\t- " + cmd);
                }
            }
            for(String commandNames : this.constants.COMMANDS_DIC.keySet()){
                if (command.equals(commandNames)){
                    this.constants.COMMANDS_DIC.get(commandNames).initiate(this.s);
                    success = true;
                }
            }
            if (command.equals("exit")){
                new SaveUserChangeCmd().saveUserChanges(user);
                break;
            } else if (command.equals("deleteAccount")){
                new DeleteUser().initiate(this.user);
            }
            else if (!success){
                System.out.println("inputted command does not exist.\n");
            }

        }
    }


}


