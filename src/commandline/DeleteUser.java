package commandline;

import controllers.UserControlCentre;
import entities.User;

import java.util.Scanner;

public class DeleteUser {
    private UserControlCentre userControlCentre = new UserControlCentre();
    private Scanner scanner = new Scanner(System.in);

    public DeleteUser(){}

    public int initiate(User user) throws Exception {
        System.out.println("Are you sure you want to delete your account?, Please enter Yes if you really want to delete your account"
        );
        String check = scanner.next();
        if(check.equals("Yes")){
            System.out.println("1");
            userControlCentre.deleteUserAccount(user);
            return 1;
        } else{
            System.out.println("We didnt delete your account and thank you for keeping using our app");
            return 0;
        }
    }


    public static void main(String[] args) throws Exception {
        DeleteUser deleteUser = new DeleteUser();
        User user = deleteUser.userControlCentre.getSelectedUser("123");
        deleteUser.initiate(user);
    }
}