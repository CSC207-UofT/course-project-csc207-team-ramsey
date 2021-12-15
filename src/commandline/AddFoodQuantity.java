package commandline;

import controllers.FoodControlCentre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AddFoodQuantity<T> extends Command<T> implements CommandExecute{


    public AddFoodQuantity(T receiver) {
        super(2, 2, receiver);
    }

    @Override
    public String execute(List<String> arguments) {
        FoodControlCentre control = (FoodControlCentre) this.receiver;
        return control.addFoodQuantity(arguments.get(0), arguments.get(1), control.getUser());
    }

    public void initiate(Scanner s){
        do {
            System.out.println("What is the of the food you want add a entry for?");
            String foodName = s.nextLine();

            System.out.println("How much do you want to add?");
            String quantity = s.nextLine();

            ArrayList<String> arguments = new ArrayList<String>();
            arguments.add(foodName);
            arguments.add(quantity);

            String response = execute(arguments);
            System.out.println(response);

            if (Objects.equals(response, "This food does not exist")) {
                System.out.println("Would you like to try again(y/n)");
            } else {
                System.out.println("Would you like to add to another food(y/n)");
            }

        } while (!Objects.equals(s.nextLine(), "n"));
    }
}
