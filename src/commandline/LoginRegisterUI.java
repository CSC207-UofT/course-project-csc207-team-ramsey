package commandline;

import controllers.UserDetailsController;
import entities.User;
import usecases.UserManager;

import java.io.IOException;
import java.util.Scanner;

public class LoginRegisterUI {

    public User initiate() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose to <Login> or <Register> a new account, or <Exit> if you want to end the program");
        while (true){
            String order = scanner.next();
            switch (order) {
                case "Login" -> {
                    LoginSignInUI loginSignInUI = new LoginSignInUI();
                    try{
                        return loginSignInUI.initiate();
                    } catch (NullPointerException e){
                        System.out.println("your account with the associated username is not in our data, please reenter the command");
                    } catch (IOException e){
                        System.out.println("The data have some problems");
                    }
                }
                case "Register" -> {
                    CreateUserCmd createUserCmd = new CreateUserCmd();
                    return createUserCmd.execute();
                }
                case "Exit" -> System.exit(0);
                default -> System.out.println("Your command cannot be recognized, please reenter the command");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        LoginRegisterUI loginRegisterUI = new LoginRegisterUI();
        User user = loginRegisterUI.initiate();
        UserManager userManager = new UserManager();
        UserDetailsController userDetailsController = new UserDetailsController(user);
        userDetailsController.changeUserName("555");
        SaveUserChangeCmd saveUserChangeCmd = new SaveUserChangeCmd();
        saveUserChangeCmd.saveUserChanges(user);
    }
}

