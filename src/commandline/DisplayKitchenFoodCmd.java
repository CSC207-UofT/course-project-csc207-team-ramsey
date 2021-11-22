package commandline;

import controllers.ControlCentre;
import controllers.KitchenControlCentre;
import entities.User;
import entities.food.Food;

import java.util.*;

public class DisplayKitchenFoodCmd extends Command implements CommandExecute{

    public DisplayKitchenFoodCmd(ControlCentre receiver) {
        super(0, 0, receiver);
    }

    @Override
    public String execute(List<String> arguments) {
        ArrayList<Food> foodList = receiver.getUser().getKitchen().getFood();
        KitchenControlCentre kitchenControlCentre = (KitchenControlCentre) receiver;

        if (foodList == null || foodList.isEmpty()){
            return "You currently have no food in your kitchen.";
        } else {
            StringBuilder foods = new StringBuilder();
            foods.append("You currently have the following food in your kitchen: " + "\n");
            return kitchenControlCentre.getFoodList(receiver.getUser()).toString();
        }
    }
}
