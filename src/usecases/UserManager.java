package usecases;

import commandline.UserWriteReader;
import commandline.WriteReader;
import entities.User;
import entities.UserList;

import java.io.IOException;

public class UserManager {
    private UserWriteReader readWriter = new UserWriteReader();
    private UserList users;

    public UserManager() throws Exception{
        try {
            this.users = new LoginManager().getUsers();
        } catch (IOException e){
            this.users = new UserList();
        }
    }

    public void deleteUser(User user){
        users.deleteUser(user);
    }

    public void changeUserPassword(String newPassword, User user){
        user.setPassword(newPassword);
    }
    //改名这里需要更改design 不然的话存进user list里面的时候根据username指向的东西就变了，会存到另外一个地方，有bug.

    public void changeUserName(String username, User user){
        user.setPreviousUserName();
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
        } else {
            if (users.getUser(user.getUserName()) == null) {
                if (users.getUser(user.getPreviousUserName()) != null) {
                    users.deleteUserByString(user.getPreviousUserName()); // delete the user with the previous username, happen when the user's username change
                }
                users.add(user);
            }
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

    public void deleteUserOldUsername(){
        //
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