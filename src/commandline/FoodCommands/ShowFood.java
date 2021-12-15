package commandline.FoodCommands;

import commandline.Command;
import commandline.CommandExecute;
import controllers.FoodControlCentre;
import entities.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ShowFood<T> extends Command<T> implements CommandExecute {

    public ShowFood(T receiver) {
        super(1, 1, receiver);
    }

    @Override
    public String execute(List<String> arguments) {
        FoodControlCentre control = (FoodControlCentre) this.receiver;
        return control.showFood(arguments.get(0), control.getUser());
    }

    public void initiate(Scanner s){
        do {
            System.out.println("What is the of the food you want to see?");
            String foodName = s.nextLine();
            ArrayList<String> arguments = new ArrayList<String>();
            arguments.add(foodName);

            String response = execute(arguments);
            System.out.println(response);

            if (Objects.equals(response, "This food does not exist")) {
                System.out.println("Would you like to try again(y/n)");
            } else {
                System.out.println("Would you like to show another food(y/n)");
            }

        } while (!Objects.equals(s.nextLine(), "n"));
    }
}
