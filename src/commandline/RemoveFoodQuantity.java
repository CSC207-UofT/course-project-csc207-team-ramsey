package commandline;

import controllers.ControlCentre;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RemoveFoodQuantity extends Command implements CommandExecute{


    private final User user;

    public RemoveFoodQuantity(int maxArguments, int minArguments, ControlCentre receiver, User user) {
        super(maxArguments, minArguments, receiver);
        this.user = user;
    }

    @Override
    public String execute(List<String> arguments) {
        return receiver.removeFoodQuantity(arguments.get(0), arguments.get(1), user);
    }

    public void removeFoodQuantityLineCall(Scanner s){
        do {
            System.out.println("What is the name of the food you used?: ");
            String foodName = s.nextLine();

            System.out.println("How much of the food did you use? (Format: quantity units): ");
            String[] quantityData = s.nextLine().split(" ");

            String quantity = quantityData[0];
            String unit = quantityData[1];

            if ((receiver.findFood(foodName, user) != null) && (receiver.findFood(foodName, user).getUnit() == unit)){
                ArrayList<String> arguments = new ArrayList<String>();
                arguments.add(foodName);
                arguments.add(quantity);

                execute(arguments);
            }
        } while (!Objects.equals(s.nextLine(), "n"));
    }
}
