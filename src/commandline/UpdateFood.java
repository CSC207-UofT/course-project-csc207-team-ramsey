package commandline;

import controllers.ControlCentre;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UpdateFood extends Command implements CommandExecute{


    private final User user;

    public UpdateFood(int maxArguments, int minArguments, ControlCentre receiver, User user) {
        super(maxArguments, minArguments, receiver);
        this.user = user;
    }

    @Override
    public String execute(List<String> arguments) {
        return receiver.updateFood(arguments.get(0), arguments.get(1), arguments.get(2), this.user);
    }

    public void updateFoodLineCall(Scanner s){
        do {

            System.out.println("What food would you like to update?");
            String foodName = s.nextLine();

            System.out.println("What do you want to update?");
            String updateField = s.nextLine();


            System.out.println("What is the new " + updateField);
            String updateItem = s.nextLine();

            ArrayList<String> arguments = new ArrayList<String>();
            arguments.add(foodName);
            arguments.add(updateField);
            arguments.add(updateItem);

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
