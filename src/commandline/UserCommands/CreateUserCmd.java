package commandline.UserCommands;

import controllers.UserControlCentre;
import entities.User;

import java.util.Scanner;

public class CreateUserCmd{
    private Scanner scanner = new Scanner(System.in);
    private UserControlCentre userControlCentre = new UserControlCentre();

    /**
     * Create a user with user inputted details.
     * @throws Exception When username already been registered
     */
    public CreateUserCmd() throws Exception {
    }

    public User initiate() throws Exception {
        System.out.println("Please enter the user name you want");
        String username = scanner.next();
        System.out.println("please enter the password you want");
        String password = scanner.next();
        System.out.println("please enter your email");
        String email = scanner.next();
        System.out.println("please enter your name");
        String name = scanner.next();
        try{
            return userControlCentre.createNewUser(username, name, email, password);
        } catch (Exception e){
            throw new Exception("Username has already registered");
        }
    }

    public static void main(String[] args) throws Exception {
        CreateUserCmd createUserCmd = new CreateUserCmd();
        createUserCmd.initiate();
        UserControlCentre userControlCentre = new UserControlCentre();
    }
}

//public class UserLoginUI {
//
//    public Object run(LoginController loginController) throws Exception{
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter LogIn if you already have an account, or enter SignIn to create a new account");
//        if(scanner.next().equals("LogIn")){
//            System.out.println("Please enter your username");
//            String username = scanner.next();
//            System.out.println("Please enter your password");
//            String password = scanner.next();
//            loginController.runLogin(username, password);
//            try {
//                return (User) loginController.returnUser(username);
//            }
//            catch(Exception e){
//                System.out.println("Please try again or SingIn ");
//            }
//            return null;
//        }
//    }
//}