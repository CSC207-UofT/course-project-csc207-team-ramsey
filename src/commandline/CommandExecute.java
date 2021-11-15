package commandline;

import controllers.ControlCentre;
import entities.User;

import java.util.List;

public interface CommandExecute {
    String execute(ControlCentre receiver, List<String> arguments, User user);

}
