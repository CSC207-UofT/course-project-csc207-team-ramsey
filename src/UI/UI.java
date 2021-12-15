package UI;

import constants.Constants;
import controllers.*;
import entities.User;
import java.util.Scanner;

public class UI {
    public Scanner s;

    private final Constants constants;
    private LoginController loginController;

    public UI(User user) throws Exception {

        KitchenControlCentre kitchenControlCentre = new KitchenControlCentre(user);
        UserControlCentre userControlCentre = new UserControlCentre();
        RecipeControlCentre recipeControlCentre = new RecipeControlCentre(user);
        this.s = new Scanner(System.in);
        this.constants = new Constants(kitchenControlCentre, userControlCentre, recipeControlCentre);
        this.constants.populateConstants();
    }

    public void receiveCommands(){

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
                break;
            } else if (!success){
                System.out.println("inputted command does not exist.\n");
            }

        }
    }


}


