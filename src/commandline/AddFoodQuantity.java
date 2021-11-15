package commandline;

import controllers.ControlCentre;
import entities.User;

import java.util.List;

public class AddFoodQuantity extends Command implements CommandExecute{


    public AddFoodQuantity(int maxArguments, int minArguments, ControlCentre receiver, User user) {
        super(maxArguments, minArguments, receiver);
    }

    @Override
    public String execute(ControlCentre receiver, List<String> arguments, User user) {
        return null;
    }
}
