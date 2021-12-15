package controllers;

import entities.User;
import usecases.UserManager;

public class UserDetailsController {
    /** Create a user details controller that could use to changes username and password.
     */
    private User user;
    private UserManager userManager;

    public UserDetailsController(User user) throws Exception {
        this.user = user;
        this.userManager = new UserManager(); //可以更好的优化 去做一个整体controller只initiate一个manager for Usercontroller
        //UserDetailsController
    }

    /**
     * Change the user's name with username. Throw Exception When the username is already used. And change the user's username
     * when the username is available.
     * @param username
     * @throws Exception
     */

    public void changeUserName(String username) throws Exception {
            Boolean result = userManager.checkUserNameAva(username);
            if(result.equals(Boolean.FALSE)){
                throw new Exception("The username has already been used");
            } else{
                userManager.changeUserName(username, user);
            }
    }

    /**
     * Change user's password to password
     * @param password
     */
    public void changeUserPassword(String password){
        userManager.changeUserPassword(password, user);
    }
}
