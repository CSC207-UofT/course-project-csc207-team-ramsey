package commandline;

import controllers.ControlCentre;

import java.util.Scanner;

public class MainMenu extends Command{
    public MainMenu(int maxArguments, int minArguments, ControlCentre receiver) {
        super(maxArguments, minArguments, receiver);
    }

    public void MainMenuLineCall(Scanner s){
        System.out.println("What would you like to do?");
    }
}
