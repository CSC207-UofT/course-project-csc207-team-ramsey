package commandline;

import controllers.ControlCentre;
import entities.User;

import java.util.List;

public class UpdateFood extends Command implements CommandExecute{


    public UpdateFood(int maxArguments, int minArguments, ControlCentre receiver, User user) {
        super(maxArguments, minArguments, receiver);
    }

    @Override
    public String execute(List<String> arguments) {
        return null;
    }
}
