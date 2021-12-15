package controllers;

import com.sun.net.httpserver.Authenticator;
import entities.User;
import usecases.LoginManager;
import usecases.UserManager;

import java.util.ArrayList;
import java.util.List;

public class LoginController {
    /** Login Controller, that stores the login result and Initiate a login manager for login
     *
     */
    private LoginManager loginManager;
    private LoginManager.LoginResult result = LoginManager.LoginResult.FAILURE;

    /**
     * Initiate Login Manager, throw Exception when reading file reporting an error
     * @throws Exception when reading file error
     */
    public LoginController() throws Exception{
        this.loginManager = new LoginManager();
    }

    /**
     * Run the login, and if the username, password, match with our data that read from the file, the login result in
     * this class become SUCCESS.
     * @param username inputted username
     * @param password inputted password
     */
    public void runLogin(String username, String password){
        LoginManager.LoginResult result = loginManager.logIn(username, password);
        switch (result) {
            case SUCCESS -> {
                System.out.println("Login Successful");
                this.result = LoginManager.LoginResult.SUCCESS;
            }
            case FAILURE -> {
            }
        }
    }

    /**
     * Return a User when Login Result is True, and reporting an error when the login result is false.
     * @param username
     * @return User
     * @throws Exception when login result is false. Inputted does not match our data.
     */
    public User returnUser(String username) throws Exception{
        if (this.result.equals(LoginManager.LoginResult.SUCCESS)){
            return loginManager.getLogInUser(username);
        }else{
            throw new Exception("you password or username is incorrect, please try again.");
        }
    }

//    public User runSignIn(String name, String username, String email, String password){
//        CreateUserCmd cmd = new CreateUserCmd();
//        List<String> userDetails = new ArrayList<>();
//        userDetails.add(name);
//        userDetails.add(username);
//        userDetails.add(email);
//        userDetails.add(password);
//        User user = cmd.execute(userDetails);
//        loginManager.saveChanges(user);
//        return user;
//    }
//
//    public User runSignIn(String name, String uName, String mail, String password){
//        LoginManager loginManager = new LoginManager();
//        User user = new User(name, uName, mail, password);
//        loginManager.saveChanges(user);
//        return user;
//    }

}
