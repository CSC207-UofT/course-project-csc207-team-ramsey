package commandline;

import controllers.UserDetailsController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeUserPassCmd<T> extends Command<T> implements CommandExecute{
    public ChangeUserPassCmd(T receiver){super(1,1, receiver);}

    /**
     * Change username with the password that inputted by user
     * @param arguments
     * @return String, a String that indicating the user's changes result.
     */
    @Override
    public String execute(List<String> arguments){
        UserDetailsController userDetailsController = (UserDetailsController) this.receiver;
            userDetailsController.changeUserPassword(arguments.get(0));
            return ("your user password has changed successfully");
    }

    //execute the command
    /**
     * use scanner to scan the user's input and user it in execute.
     * @param S passed in scanner
     */
    public void initiate(Scanner S){
        System.out.println("Please enter the password you want to change");
        String password = S.next();
        List<String> input = new ArrayList<>();
        input.add(password);
    }
    // user input the command
}
