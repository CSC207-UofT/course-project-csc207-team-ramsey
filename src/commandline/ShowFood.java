package commandline;

import controllers.ControlCentre;
import controllers.FoodControlCentre;
import entities.User;
import entities.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ShowFood<T> extends Command<T> implements CommandExecute{

    public ShowFood(T receiver) {
        super(1, 1, receiver);
    }

    @Override
    public String execute(List<String> arguments) {
        FoodControlCentre control = (FoodControlCentre) this.receiver;
        ArrayList<Food> food = control.getUser().getKitchen().getFood();
        for (Food foodEntry : food){
            if (Objects.equals(foodEntry.getName(), arguments.get(0))){
                return control.showFood(foodEntry);
            }
        }
        return "There is no food matching that name";
    }

    public void initiate(Scanner s){
        do {
            System.out.println("What is the of the food you want to see?");
            String foodName = s.nextLine();
            ArrayList<String> arguments = new ArrayList<String>();
            arguments.add(foodName);

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
