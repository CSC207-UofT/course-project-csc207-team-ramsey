package commandline;

import controllers.ControlCentre;
import controllers.KitchenControlCentre;
import entities.User;
import entities.food.Food;

import java.util.*;

public class DisplayShoppingListCmd extends Command implements CommandExecute{

    public DisplayShoppingListCmd(ControlCentre receiver) {
        super(0, 0, receiver);
    }

    @Override
    public String execute(ControlCentre receiver, List<String> arguments, User user) {
        ArrayList<Food> shoppingList = user.getKitchen().getShoppingList();
        KitchenControlCentre kitchenControlCentre = (KitchenControlCentre) receiver;

        if (shoppingList == null || shoppingList.isEmpty()){
            return "You currently have no food in your shopping list.";
        } else {
            StringBuilder foods = new StringBuilder();
            foods.append("You currently have the following food in your shopping list: " + "\n");
            return kitchenControlCentre.getShoppingList(user).toString();
        }
    }
}