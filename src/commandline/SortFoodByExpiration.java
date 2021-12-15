package commandline;

import controllers.FoodControlCentre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * This class is that command that helps users sort their food expiration
 * @param <T> represents the type for the receiver
 */
public class SortFoodByExpiration<T> extends Command<T> implements CommandExecute {

    /**
     * the constructor for the command
     * @param receiver the control centre that receives the information
     */
    public SortFoodByExpiration(T receiver) {
        super(1, 1, receiver);
    }

    /**
     * this function executes the function in the control centre
     * @param arguments the values given by the user from the scanner s
     * @return the string that represents the list of foods sorted by expiration
     */
    @Override
    public String execute(List<String> arguments) {
        FoodControlCentre control = (FoodControlCentre) this.receiver;
        return control.sortByExpiration(control.getUser());
    }

    /**
     * This function shows what the user will see
     * @param s the scanner used to read each line
     */
    public void initiate(Scanner s){
        do {
            ArrayList<String> arguments = new ArrayList<String>();

            String response = execute(arguments);
            System.out.println(response);

            if (Objects.equals(response, "That category does not exist")) {
                System.out.println("Would you like to try again(y/n)");
            } else {
                System.out.println("Would you like to sort by another category(y/n)");
            }

        } while (!Objects.equals(s.nextLine(), "n"));
    }
}

