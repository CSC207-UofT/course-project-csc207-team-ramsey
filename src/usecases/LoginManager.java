package usecases;

import commandline.UserWriteReader;
import controllers.LoginInputBoundary;
import entities.User;
import entities.UserList;

import java.io.IOException;

public class LoginManager implements LoginInputBoundary {
    // Can be improved by making UserList Final and static since users are used in other class.
    private UserList users;

    UserWriteReader readWriter = new UserWriteReader();

    /**
     * / The "output" of this use case.
     */
    public enum LoginResult {
        SUCCESS, FAILURE // Should we do NO_SUCH_USER as well as SUCCESS and FAILURE?
    }

    public LoginManager() {
        try {
            this.users = readWriter.readFromFile("users.ser");
        } catch (IOException e) {
            System.out.println("Cannot load user data, there is no user data in the file. Please signIn");
        } catch (ClassNotFoundException e) {
            System.out.println("The data from file does not match");
        }
    }

    public User getLogInUser(String username){
        return this.users.getUser(username);
    }

    /**
     * Run the login use case.
     * @param username the username
     * @param password the password attempt
     * @return whether the attempt matches the password associated with username
     */
    public LoginResult logIn(String username, String password) {
        User user = users.getUser(username);
        if (user.passwordMatches(password)) {
            return LoginResult.SUCCESS;
        } else {
            return LoginResult.FAILURE;
        }
        //need to add check same username
    }

    public UserList getUsers() {
        return users;
    }

    @Override
    public String toString(){
        return users.toString();
    }

    public static void main(String[] args) {
        LoginManager loginManager = new LoginManager();
        User user = new User("123","123","123","123");
        System.out.println(loginManager.users.getUser("123"));

//        User user = new User("123","123","123","123");
//        loginManager.saveChanges(user);
        loginManager.users.getUser("456");
    }
}