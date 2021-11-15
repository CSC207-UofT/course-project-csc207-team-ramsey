package commandline;

import controllers.ControlCentre;
import entities.User;
import entities.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ShowFood extends Command implements CommandExecute{


    public ShowFood(int maxArguments, int minArguments, ControlCentre receiver, User user) {
        super(1, 1, receiver);
    }

    @Override
    public String execute(ControlCentre receiver, List<String> arguments, User user) {
        ArrayList<Food> food = user.getKitchen().getFood();
        for (Food foodEntry : food){
            if (Objects.equals(foodEntry.getName(), arguments.get(0))){
                return receiver.showFood(foodEntry).toString();
            }
        }
        return "There is no food matching that name";
    }
}
