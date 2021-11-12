package commandline;

import controllers.ControlCentre;

import java.util.List;

public class RemoveFoodQuantity extends Command implements CommandExecute{


    public RemoveFoodQuantity(int maxArguments, int minArguments, ControlCentre receiver) {
        super(maxArguments, minArguments, receiver);
    }

    @Override
    public String execute(ControlCentre receiver, List<String> arguments) {
        return null;
    }
}
