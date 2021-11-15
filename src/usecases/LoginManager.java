package usecases;

import commandline.UserWriteReader;
import entities.User;
import entities.UserList;

import java.io.IOException;

public class LoginManager {

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
            System.out.println("Cannot load user data");
        } catch (ClassNotFoundException e) {
            System.out.println("The data from file does not match");
        }
    }

    public void saveChanges(User user){
        if(users == null){
            users = new UserList();
            users.add(user);
            try {
                readWriter.saveToFile("users.ser", users);
            }catch (IOException e){
                System.out.println("Cannot save the changes, user's changes and new list did not save");
            }
        } else if
        (this.users.getUser(user.getUserName()) != null){
            users.upDateUser(user);
        } else{
            users.add(user);
        }
        try {
            readWriter.saveToFile("users.ser", users);
        }catch (IOException e){
            System.out.println("Cannot save the changes, user's changes and new list did not save");
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

    @Override
    public String toString(){
        return users.toString();
    }


}