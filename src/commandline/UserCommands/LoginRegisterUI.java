package commandline.UserCommands;

import controllers.UserDetailsController;
import entities.User;
import usecases.UserManager;

import java.io.IOException;
import java.util.Scanner;

/**
 * A login UI for user to login
 */
public class LoginRegisterUI {


    /**
     * That initiate a scanner (can be optimized , but hard to change due to time limit) for user's inputted information.
     * -> Login or Register:
     *   -> Login:
     *      -> Initiate a LoginUI and run initiate to log in user for control
     *      -> catch three exception under three scenario. and output the reason.
     *   -> Register:
     *      -> Initiate a RegisterUI and run initiate to create user
     *      -> Catch Exception when the user's wanted username already in the data during creating a new user.
     * @return User that has been login or just registered
     * @throws Exception Catch* when there is no account with user's inputted username. when data have IO problem or when there are
     * no users in our data. when username and password does not match. Throw* when there is problem when initiate LoginuI
     * and initiate createUserCmd
     */

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
                        System.out.println("Your account with the associated username is not in our data, please reenter the command");
                    } catch (IOException e){
                        System.out.println("The data have some problems, or try to Register new one, there may be no user in data");
                    } catch(Exception e){
                        System.out.println("The username and the password does not match, please re-enter the command");
                    }
                }
                case "Register" -> {
                    CreateUserCmd createUserCmd = new CreateUserCmd();
                    try{
                        return createUserCmd.initiate();
                    } catch (Exception e){
                        System.out.println("The username has already been used, please reenter the command");
                    }
                }
                case "Exit" -> System.exit(0);
                default -> System.out.println("Your command cannot be recognized, please reenter the command");
            }
        }
    }

    /**
     * Test Cases
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        LoginRegisterUI loginRegisterUI = new LoginRegisterUI();
        User user = loginRegisterUI.initiate();
        UserManager userManager = new UserManager();
        UserDetailsController userDetailsController = new UserDetailsController(user);
        SaveUserChangeCmd saveUserChangeCmd = new SaveUserChangeCmd();
        saveUserChangeCmd.saveUserChanges(user);
    }
}

