package commandline;

import controllers.ControlCentre;
import entities.User;
import entities.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ShowFood extends Command implements CommandExecute{


    public ShowFood(int maxArguments, int minArguments, ControlCentre receiver) {
        super(1, 1, receiver);
    }

    @Override
    public String execute(ControlCentre receiver, List<String> arguments) {
        ArrayList<Food> food = receiver.getUser().getKitchen().getFood();
        for (Food foodEntry : food){
            if (Objects.equals(foodEntry.getName(), arguments.get(0))){
                return receiver.showFood(foodEntry).toString();
            }
        }
        return "There is no food matching that name";
    }

    public void showFoodLineCall(Scanner s){
        do {
            System.out.println("What is the of the food you want to see?");
            String foodName = s.nextLine();
            ArrayList<String> arguments = new ArrayList<String>();
            arguments.add(foodName);

            String response = execute(this.receiver, arguments);
            System.out.println(response);

            if (Objects.equals(response, "There is no food matching that name")) {
                System.out.println("Would you like to try again(y/n)");
            } else {
                System.out.println("Would you like to show another food(y/n)");
            }

        } while (!Objects.equals(s.nextLine(), "n"));
    }
}
