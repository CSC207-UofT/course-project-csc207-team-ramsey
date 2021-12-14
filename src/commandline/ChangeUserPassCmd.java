package commandline;

import controllers.UserDetailsController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeUserPassCmd<T> extends Command<T> implements CommandExecute{
    public ChangeUserPassCmd(T receiver){super(1,1, receiver);}

    @Override
    public String execute(List<String> arguments){
        UserDetailsController userDetailsController = (UserDetailsController) this.receiver;
            userDetailsController.changeUserPassword(arguments.get(0));
            return ("your user password has changed successfully");
    }
    //execute the command

    public void initiate(Scanner S){
        System.out.println("Please enter the password you want to change");
        String password = S.next();
        List<String> input = new ArrayList<>();
        input.add(password);
    }
    // user input the command
}
