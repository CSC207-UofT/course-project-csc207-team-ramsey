package commandline;

import controllers.ControlCentre;
import entities.User;

import java.util.List;

public interface CommandExecute {
    String execute(List<String> arguments);
}
