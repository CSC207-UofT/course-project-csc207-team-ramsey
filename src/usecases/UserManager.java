package usecases;

import commandline.UserWriteReader;
import commandline.WriteReader;
import entities.User;
import entities.UserList;

import java.io.IOException;

public class UserManager {
    private UserWriteReader readWriter = new UserWriteReader();
    private UserList users;

    public UserManager(){
        this.users = new LoginManager().getUsers();
    }

    public void deleteUser(User user){
        users.deleteUser(user);
    }

    public void changeUserPassword(String newPassword, User user){
        user.setPassword(newPassword);
    }

    public void changeUserName(String username, User user){
        user.setUserName(username);
    }

    public void saveUserChange(User user) throws Exception{
        if (users == null) {
            users = new UserList();
            users.add(user);
            try {
                this.readWriter.saveToFile("users.ser", users);
            } catch (IOException e) {
                System.out.println("Cannot save the changes, user's changes and new list did not save");
            }
        } else if (users.getUser(user.getUserName()) != null) {
            users.upDateUser(user);
            try {
                this.readWriter.saveToFile("users.ser", users);
            } catch (IOException e) {
                System.out.println("Cannot save the changes, user's changes and new list did not save");
            }
        } else {
            users.add(user);
            try {
                this.readWriter.saveToFile("users.ser", users);
            } catch (IOException e) {
                System.out.println("Cannot save the changes, user's changes and new list did not save");
            }
        }
    }


    public boolean checkUserNameAva(String username) {
        try {
            users.getUser(username).getUserName();
            return false;
        } catch (NullPointerException e){
            return true;
        }
    }

    public User createNewUser(String username, String password, String email, String name){
        User user = new User(name, username, email, password);
        users.add(user);
        return user;
    }


    public void saveChangesDeleteUser() throws Exception{
        // Test function
        // TODO: Check if it works if the empty userList can be saved
        try{
            this.readWriter.saveToFile("users.ser", users);
        } catch (IOException e) {
            System.out.println("Cannot save the changes, user's changes did not save");
        }
    }

    public User getSelectedUser(String username){
        // Test function
        return users.getUser(username);
    }

    public UserList getUsers() {
        return users;
    }

    public static void main(String[] args) throws Exception {
        UserManager userManager = new UserManager();
        User user = new User("456","456","123","123");
        userManager.saveUserChange(user);
        LoginManager loginManager = new LoginManager();
        User user1 = loginManager.getLogInUser("123");
        System.out.println(user1.getUserName());
    }

}