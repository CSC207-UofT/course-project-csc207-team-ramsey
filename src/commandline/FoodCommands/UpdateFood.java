package commandline.FoodCommands;

import commandline.Command;
import commandline.CommandExecute;
import controllers.FoodControlCentre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
/**
 * This class updates a food object
 * @param <T> the receiver
 */
public class UpdateFood<T> extends Command<T> implements CommandExecute {

    /**
     * The constructor for this class
     * @param receiver food control centre
     */
    public UpdateFood(T receiver) {
        super(3, 3, receiver);
    }
    /**
     * Gets the arguments from initiate to give to the food controller
     * @param arguments the user inputs
     * @return a string for initiate to give back to the user
     */
    @Override
    public String execute(List<String> arguments){
        FoodControlCentre control = (FoodControlCentre) this.receiver;
        return control.updateFood(arguments.get(0), arguments.get(1), arguments.get(2), control.getUser());
    }

    /**
     * a function that shows the users and gets inputs from the user
     * @param s the scanner that reads inputs
     */
    public void initiate(Scanner s){
        do {

            System.out.println("What food would you like to update?");
            String foodName = s.nextLine();

            System.out.println("What do you want to update?");
            String updateField = s.nextLine();


            System.out.println("What is the new " + updateField);
            String updateItem = s.nextLine();

            ArrayList<String> arguments = new ArrayList<>();
            arguments.add(foodName);
            arguments.add(updateField);
            arguments.add(updateItem);

            String response = execute(arguments);
            System.out.println(response);

            if (Objects.equals(response, "This food does not exist")){
                System.out.println("Would you like to try again(y/n)");
            } else {
                System.out.println("Would you like to show another food(y/n)");
            }

        } while (!Objects.equals(s.nextLine(), "n"));
    }
}
