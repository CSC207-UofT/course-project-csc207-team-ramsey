package commandline;

import controllers.ControlCentre;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AddFoodQuantity extends Command implements CommandExecute{


    private final User user;

    public AddFoodQuantity(int maxArguments, int minArguments, ControlCentre receiver, User user) {
        super(maxArguments, minArguments, receiver);
        this.user = user;
    }

    @Override
    public String execute(List<String> arguments) {
        return receiver.addFoodQuantity(arguments.get(0), arguments.get(1), user);
    }

    public void addFoodQuantityLineCall(Scanner s){
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

            if (Objects.equals(response, "There is no food matching that name")) {
                System.out.println("Would you like to try again(y/n)");
            } else {
                System.out.println("Would you like to show another food(y/n)");
            }

        } while (!Objects.equals(s.nextLine(), "n"));
    }
}
