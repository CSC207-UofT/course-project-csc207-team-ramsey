package commandline;

import controllers.ControlCentre;

import java.util.List;

public class UpdateFood extends Command implements CommandExecute{


    public UpdateFood(int maxArguments, int minArguments, ControlCentre receiver) {
        super(maxArguments, minArguments, receiver);
    }

    @Override
    public String execute(ControlCentre receiver, List<String> arguments) {
        return null;
    }
}
