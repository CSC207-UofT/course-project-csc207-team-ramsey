package commandline;

import controllers.ControlCentre;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RemoveFoodQuantity extends Command implements CommandExecute{


    public RemoveFoodQuantity(int maxArguments, int minArguments, ControlCentre receiver, User user) {
        super(maxArguments, minArguments, receiver);
    }

    @Override
    public String execute(List<String> arguments) {
        return null;
    }

    public void removeFoodQuantityLineCall(Scanner s){
        do {
            System.out.println("What is the name of the food you used?: ");
            String foodName = s.nextLine();

            System.out.println("How much of the food did you use? (Format: quantity units): ");
            String quantityData = s.nextLine();


            ArrayList<String> arguments = new ArrayList<String>();
            arguments.add(foodName);

        } while (!Objects.equals(s.nextLine(), "n"));
    }
}
