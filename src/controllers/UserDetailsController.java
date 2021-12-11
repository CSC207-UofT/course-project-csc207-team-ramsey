package controllers;

import entities.User;
import usecases.UserManager;

public class UserDetailsController {

    private User user;
    private UserManager userManager;

    public UserDetailsController(User user){
        this.user = user;
    }

    public void changeUserName(String username) throws Exception {
        if(userManager.checkUserNameAva(username)){
            userManager.changeUserName(username, user);
        } else{
            throw new Exception("The username has already been used");
        }
    }

    public void changeUserPassword(String password){
        userManager.changeUserPassword(password, user);
    }
}
