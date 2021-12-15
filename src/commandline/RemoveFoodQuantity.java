package commandline;

import controllers.FoodControlCentre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RemoveFoodQuantity<T> extends Command<T> implements CommandExecute{


    public RemoveFoodQuantity(T receiver) {
        super(2, 2, receiver);
    }

    @Override
    public String execute(List<String> arguments) {
        FoodControlCentre control = (FoodControlCentre) this.receiver;
        return control.removeFoodQuantity(arguments.get(0), arguments.get(1), control.getUser());
    }

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
