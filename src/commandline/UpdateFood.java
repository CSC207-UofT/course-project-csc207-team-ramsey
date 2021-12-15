package commandline;

import controllers.FoodControlCentre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UpdateFood<T> extends Command<T> implements CommandExecute{


    public UpdateFood(T receiver) {
        super(3, 3, receiver);
    }

    @Override
    public String execute(List<String> arguments){
        FoodControlCentre control = (FoodControlCentre) this.receiver;
        return control.updateFood(arguments.get(0), arguments.get(1), arguments.get(2), control.getUser());
    }

    public void initiate(Scanner s){
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

            if (Objects.equals(response, "This food does not exist")){
                System.out.println("Would you like to try again(y/n)");
            } else {
                System.out.println("Would you like to show another food(y/n)");
            }

        } while (!Objects.equals(s.nextLine(), "n"));
    }
}
