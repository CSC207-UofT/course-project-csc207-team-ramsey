package commandline;

import controllers.ControlCentre;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RemoveFoodQuantity extends Command implements CommandExecute{


    public RemoveFoodQuantity(int maxArguments, int minArguments, ControlCentre receiver, User user) {
        super(maxArguments, minArguments, receiver);
    }

    @Override
    public String execute(ControlCentre receiver, List<String> arguments, User user) {
        return null;
    }

    public void removeFoodQuantityLineCall(Scanner s){
        do {
            System.out.println("What type of food is your food (grains, meats, fruitvegi, dairy)?: ");
            String foodType = s.nextLine();

            System.out.println("What is the name of your food?: ");
            String foodName = s.nextLine();

            System.out.println("What is the shelf life of your food?: ");
            String sl = s.nextLine();

            System.out.println("What is the unit (whole, ml, grams?: ");
            String unit = s.nextLine();

            System.out.println("What is the quantity? ");
            String quantity = s.nextLine();


            ArrayList<String> arguments = new ArrayList<String>();
            arguments.add(foodType);
            arguments.add(foodName);
            arguments.add(sl);
            arguments.add(quantity);
            arguments.add(unit);

        } while (!Objects.equals(s.nextLine(), "n"));
    }
}
