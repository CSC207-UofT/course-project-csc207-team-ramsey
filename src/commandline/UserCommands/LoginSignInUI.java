package commandline.UserCommands;

import controllers.LoginController;
import entities.User;

import java.util.Scanner;

public class LoginSignInUI {

    private LoginController loginController;

    /**
     * LoginSignIn
     * @throws Exception when there is a problem when reading file (from very bottom)
     */
    public LoginSignInUI() throws Exception{
        this.loginController = new LoginController();
    }

    /**
     * Initiate a scanner and
     * -> Input username and password
     * -> run login with username and user, report null exception when there is no user in our data. When the username and
     * password match the information in our data, change the login result to SUCCESS and FAILURE if not.
     * -> return user if SUCCESS report error when false.
     * @return User if login success.
     * @throws Exception When login fail, username does not exist NullPointException and new Exception when username and
     * password does not match.
     */
    public User initiate() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username");
        String username = scanner.next();
        System.out.println("Please enter your password");
        String password = scanner.next();
        loginController.runLogin(username, password); // return null point exception
        try {
            return loginController.returnUser(username);
        }
        catch(Exception e) {
            throw new Exception("You username and password does not match");
        }
    }
    /**
     * Test cases
     */
    public static void main(String[] args) throws Exception {
        LoginSignInUI loginSignInUI = new LoginSignInUI();
        loginSignInUI.initiate();
    }
}

