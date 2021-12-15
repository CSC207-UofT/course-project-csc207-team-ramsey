package usecases;

import commandline.UserCommands.UserWriteReader;
import controllers.LoginInputBoundary;
import entities.User;
import entities.UserList;

import java.io.IOException;

public class LoginManager implements LoginInputBoundary {
    // Can be improved by making UserList Final and static since users are used in other class.
    private final UserList users;

    final UserWriteReader readWriter = new UserWriteReader();

    /**
     * / The "output" of this use case.
     */
    public enum LoginResult {
        SUCCESS, FAILURE // Should we do NO_SUCH_USER as well as SUCCESS and FAILURE?
    }

    /**
     * Create a new Login Manager that get data from file, save to its users. Throw Exception when there are some problems
     * during reading data from file.
     * @throws Exception Class Exception when Class did not match (Actually not gonna happen) and IO Exception.
     *
     */
    public LoginManager() throws Exception {
        try {
            this.users = readWriter.readFromFile("users.ser");
        } catch (IOException e) {
            throw new IOException("Cannot load user data, Please contact us for helping, or try to Register new one");
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("The data from file does not match");
        }
    }

    /**
     * Get the login in user with the associated username
     * @param username associated username
     * @return User with associated username
     */
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

    /**
     * For test cases
     */
    @Override
    public String toString(){
        return users.toString();
    }

    /**
     * Test case, please ignore that
     */
    public static void main(String[] args) throws Exception {

        LoginManager loginManager = new LoginManager();
        User user = new User("123","123","123","123");
        System.out.println(loginManager.users.getUser("123"));
        loginManager.users.getUser("456");
    }
}