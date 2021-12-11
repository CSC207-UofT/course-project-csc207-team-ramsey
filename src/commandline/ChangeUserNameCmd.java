package commandline;

import controllers.UserDetailsController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeUserNameCmd<T> extends Command<T> implements CommandExecute{
    public ChangeUserNameCmd(T receiver){super(1,1, receiver);}

    @Override
    public String execute(List<String> arguments){
        UserDetailsController userDetailsController = (UserDetailsController) this.receiver;
        try{
            userDetailsController.changeUserName(arguments.get(0));
            return ("your user name has changed successfully");
        } catch (Exception e){
            return ("The username has already been registered");
        }
    }
    //execute the command

    public void initiate(Scanner S){
        System.out.println("Please enter the username you want to change");
        String username = S.next();
        List<String> input = new ArrayList<>();
        input.add(username);
    }
        // user input the command
}
