package commandline;

import controllers.ControlCentre;
import controllers.FoodControlCentre;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RemoveFoodQuantity<T> extends Command<T> implements CommandExecute{


    public RemoveFoodQuantity(T receiver) {
        super(2, 2, receiver);
    }

    @Override
    public String execute(List<String> arguments) {
        FoodControlCentre control = (FoodControlCentre) this.receiver;
        return control.removeFoodQuantity(arguments.get(0), arguments.get(1), control.getUser());
    }

    public void initiate(Scanner s){
        FoodControlCentre control = (FoodControlCentre) this.receiver;
        do {
            System.out.println("What is the name of the food you used?: ");
            String foodName = s.nextLine();

            System.out.println("How much of the food did you use? (Format: quantity units): ");
            String[] quantityData = s.nextLine().split(" ");

            String quantity = quantityData[0];
            String unit = quantityData[1];

            if ((control.findFood(foodName, control.getUser()) != null) && (Objects.equals(control.findFood(foodName, control.getUser()).getUnit(), unit))){
                ArrayList<String> arguments = new ArrayList<String>();
                arguments.add(foodName);
                arguments.add(quantity);

                execute(arguments);
            }
        } while (!Objects.equals(s.nextLine(), "n"));
    }
}
