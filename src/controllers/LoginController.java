package controllers;

import com.sun.net.httpserver.Authenticator;
import commandline.CreateUserCmd;
import entities.User;
import usecases.LoginManager;
import usecases.UserManager;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    private final LoginInputBoundary loginInputBoundary;
    private final LoginManager loginManager;
    private LoginManager.LoginResult result = LoginManager.LoginResult.FAILURE;


    public LoginController(LoginInputBoundary loginInputBoundary) {
        this.loginInputBoundary = loginInputBoundary;
        this.loginManager = new LoginManager();
    }

    public void runLogin(String username, String password) {
        LoginManager.LoginResult result = loginInputBoundary.logIn(username, password);
        switch (result) {
            case SUCCESS:
                System.out.println("Login Successful");
                this.result = LoginManager.LoginResult.SUCCESS;
                break;
            case FAILURE:
                System.out.println("password did not match or account does not exist");
                break;
        }
    }

    public Object returnUser(String username){
        if (this.result.equals(LoginManager.LoginResult.SUCCESS)){
            return loginManager.getLogInUser(username);
        }else{
            return 0;
        }
    }

    public User runSignIn(String name, String username, String email, String password){
        CreateUserCmd cmd = new CreateUserCmd();
        List<String> userDetails = new ArrayList<>();
        userDetails.add(name);
        userDetails.add(username);
        userDetails.add(email);
        userDetails.add(password);
        User user = cmd.execute(userDetails);
        loginManager.saveChanges(user);
        return user;
    }

//    public User runSignIn(String name, String uName, String mail, String password){
//        LoginManager loginManager = new LoginManager();
//        User user = new User(name, uName, mail, password);
//        loginManager.saveChanges(user);
//        return user;
//    }

}
