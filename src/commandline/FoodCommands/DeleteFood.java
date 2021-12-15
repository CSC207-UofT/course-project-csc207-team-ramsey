package commandline.FoodCommands;

import commandline.Command;
import commandline.CommandExecute;
import controllers.FoodControlCentre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * This class deletes food object
 * @param <T> the receiver
 */

public class DeleteFood<T> extends Command<T> implements CommandExecute {


    /**
     * The constructor for this class
     * @param receiver food control centre
     */
    public DeleteFood(T receiver) {
        super(1, 1, receiver);
    }

    /**
     * Gets the arguments from initiate to give to the food controller
     * @param arguments the user inputs
     * @return a string for initiate to give back to the user
     */

    @Override
    public String execute(List<String> arguments) {
        FoodControlCentre control = (FoodControlCentre) this.receiver;
        return control.deleteEntity(arguments.get(0), control.getUser());
    }

    /**
     * a function that shows the users and gets inputs from the user
     * @param s the scanner that reads inputs
     */
    public void initiate(Scanner s){
        do {

            System.out.println("What food would you like to delete?");
            String foodName = s.nextLine();

            ArrayList<String> arguments = new ArrayList<String>();
            arguments.add(foodName);

            String response = execute(arguments);
            System.out.println(response);

            if (Objects.equals(response, "This food does not exist")) {
                System.out.println("Would you like to try again(y/n)");
            } else {
                System.out.println("Would you like to show another food(y/n)");
            }

        } while (!Objects.equals(s.nextLine(), "n"));
    }
}
