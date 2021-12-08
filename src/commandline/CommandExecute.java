package commandline;

import controllers.ControlCentre;
import entities.User;

import java.util.List;
import java.util.Scanner;

public interface CommandExecute {
    String execute(List<String> arguments);

    void initiate(Scanner s);
}
