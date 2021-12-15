package controllers;

import entities.User;
import usecases.UserManager;

public class UserDetailsController {

    private User user;
    private UserManager userManager;

    public UserDetailsController(User user) throws Exception {
        this.user = user;
        this.userManager = new UserManager();
    }

    public void changeUserName(String username) throws Exception {
        try{
            Boolean result = userManager.checkUserNameAva(username);
            if(result.equals(Boolean.FALSE)){
                throw new Exception("The username has already been used");
            } else{
                userManager.changeUserName(username, user);
            }
        } catch (NullPointerException e){
            userManager.changeUserName(username, user);
        }
    }

    public void changeUserPassword(String password){
        userManager.changeUserPassword(password, user);
    }
}
