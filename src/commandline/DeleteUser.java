package commandline;

import controllers.UserControlCentre;
import entities.User;

import java.util.Scanner;

public class DeleteUser {
    private UserControlCentre userControlCentre = new UserControlCentre();
    private Scanner scanner = new Scanner(System.in);

    public DeleteUser() throws Exception {}

    public void initiate(User user) throws Exception {
        System.out.println("Are you sure you want to delete your account?, Please enter Yes if you really want to delete your account");
        String check = scanner.next();
        if(check.equals("Yes")){
            System.out.println("1");
            // Does not throw Exception because user have to log in before delete the account
            userControlCentre.deleteUserAccount(user);
            System.out.println("you have logged out and your account has been deleted");
            System.exit(0);
        } else{
            System.out.println("We didnt delete your account and thank you for keeping using our app");
        }
    }


    public static void main(String[] args) throws Exception {
        DeleteUser deleteUser = new DeleteUser();
        User user = deleteUser.userControlCentre.getSelectedUser("123");
        deleteUser.initiate(user);
    }
}