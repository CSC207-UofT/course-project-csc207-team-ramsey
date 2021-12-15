package commandline;

import controllers.UserControlCentre;
import entities.User;

import java.io.IOException;
import java.util.Scanner;

public class DeleteUser {
    private UserControlCentre userControlCentre = new UserControlCentre();
    private Scanner scanner = new Scanner(System.in);

    public DeleteUser() throws Exception {}

    /**
     * Delete the user and save the changes. Exit the program after delete the user.
     * Throw Exception if there is an error during saving user's change
     * @param user user to delete
     * @throws Exception occur when save changed user list that delete user to file.
     */
    public void initiate(User user) throws Exception {
        System.out.println("Are you sure you want to delete your account?, Please enter Yes if you really want to delete your account");
        String check = scanner.next();
        if(check.equals("Yes")){
            System.out.println("1");
            // Does not throw Exception because user have to log in before delete the account
            try{
                userControlCentre.deleteUserAccount(user);
            } catch (IOException e){
                System.out.println("It has not been deleted.");
            }
            System.out.println("you have logged out and your account has been deleted");
            System.exit(0);
        } else{
            System.out.println("We didnt delete your account and thank you for keeping using our app");
        }
    }


    public static void main(String[] args) throws Exception {

        LoginRegisterUI loginRegisterUI = new LoginRegisterUI();
        User user = loginRegisterUI.initiate();
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.initiate(user);
    }
}