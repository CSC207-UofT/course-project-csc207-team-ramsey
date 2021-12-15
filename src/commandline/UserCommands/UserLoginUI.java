package commandline.UserCommands;

import controllers.LoginController;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserLoginUI {

    public Object run(LoginController loginController) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter LogIn if you already have an account, or enter SignIn to create a new account");
        if(scanner.next().equals("LogIn")){
            System.out.println("Please enter your username");
            String username = scanner.next();
            System.out.println("Please enter your password");
            String password = scanner.next();
            loginController.runLogin(username, password);
            try {
                return (User) loginController.returnUser(username);
            }
            catch(Exception e){
                System.out.println("Please try again or SingIn ");
            }
            return null;
        }
        else if(scanner.next().equals("SingIn")){
            System.out.println("Please enter your user name you want");
            String username = scanner.next();
            System.out.println("Please enter your password");
            String password = scanner.next();
            System.out.println("Please enter your email");
            String email = scanner.next();
            System.out.println("Please enter your name");
            String name = scanner.next();
            // need to store the user into the list, write the user in file.
            // return user login it first
            return loginController.runSignIn(name, username, email, password);
        } else{
            System.out.println("The command does not recognized");
            return null;
        }
    }
}
