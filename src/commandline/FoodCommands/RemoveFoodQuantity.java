package commandline.FoodCommands;

import commandline.Command;
import commandline.CommandExecute;
import controllers.FoodControlCentre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * This class removes a quantity from food object
 * @param <T> the receiver
 */

public class RemoveFoodQuantity<T> extends Command<T> implements CommandExecute {

    /**
     * The constructor for this class
     * @param receiver food control centre
     */
    public RemoveFoodQuantity(T receiver) {
        super(2, 2, receiver);
    }

    /**
     * Gets the arguments from initiate to give to the food controller
     * @param arguments the user inputs
     * @return a string for initiate to give back to the user
     */
    @Override
    public String execute(List<String> arguments) {
        FoodControlCentre control = (FoodControlCentre) this.receiver;
        return control.removeFoodQuantity(arguments.get(0), arguments.get(1), control.getUser());
    }
    /**
     * a function that shows the users and gets inputs from the user
     * @param s the scanner that reads inputs
     */
    public void initiate(Scanner s){
        FoodControlCentre control = (FoodControlCentre) this.receiver;
        do {
            System.out.println("What is the name of the food you used?: ");
            String foodName = s.nextLine();

            System.out.println("How much of the food did you use? (Format: quantity units): ");
            String[] quantityData = s.nextLine().split(" ");

            String quantity = quantityData[0];
            String unit = quantityData[1];

            ArrayList<String> arguments = new ArrayList<String>();
            arguments.add(foodName);
            arguments.add(quantity);

            String response = execute(arguments);

            if (Objects.equals(response, "This food does not exist")) {
                System.out.println("Would you like to try again(y/n)");
            } else {
                System.out.println("Would you like to remove another food(y/n)");
            }

        } while (!Objects.equals(s.nextLine(), "n"));
    }
}
