package commandline;

import controllers.LoginController;
import entities.User;

import java.util.Scanner;

public class LoginSignInUI {

    private LoginController loginController;

    public LoginSignInUI() throws Exception{
        this.loginController = new LoginController();
    }

    public User initiate() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username");
        String username = scanner.next();
        System.out.println("Please enter your password");
        String password = scanner.next();
        loginController.runLogin(username, password);
        try {
            return loginController.returnUser(username);
        }
        catch(Exception e) {
            throw new Exception("You username and password does not match");
        }
    }

    public static void main(String[] args) throws Exception {
        LoginSignInUI loginSignInUI = new LoginSignInUI();
        loginSignInUI.initiate();
    }
}

