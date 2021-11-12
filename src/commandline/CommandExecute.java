package commandline;

import controllers.ControlCentre;

import java.util.List;

public interface CommandExecute {
    String execute(ControlCentre receiver, List<String> arguments);

}
