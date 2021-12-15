package controllers;

import commandline.UserCommands.LoginRegisterUI;
import entities.User;
import usecases.UserManager;

import java.io.IOException;

public class UserControlCentre {
    private final UserManager userManager;

    /**
     * UserControlCentre for CreateNewUser, DeleteUserAccount,
     * Initiate User Control centre and throw exception when there is an error when initiating the UserManager.
     * @throws Exception IO Exception mostly
     */
    public UserControlCentre() throws Exception {
        this.userManager = new UserManager();
    }

    /**
     * Create New User and save the new user to the file, and return it for further Manipulating in the UI and CMD later.
     * throw an Exception when username already exist.
     * @param name user's password
     * @param email user's email
     * @param password user's password
     * @return User the user with all the details above
     * @throws Exception when username is already used
     */
    public User createNewUser(String username, String name, String email, String password) throws Exception {
        if (userManager.checkUserNameAva(username)) {
            User user = userManager.createNewUser(username, password, email, name);
            userManager.saveUserChange(user);
            return user;
        } else {
            throw new Exception("The username already exist, please change a username");
        }
    }

    public void changePassword(String password, User user){
        userManager.changeUserPassword(password, user);
    }

    /**
     * Delete user account and save the changes to the file
     * @param user deleted user
     */
    public void deleteUserAccount(User user) throws Exception {
        userManager.deleteUser(user);
        try {
            userManager.saveChangesDeleteUser();
        } catch (IOException e){
            //如果这里删除了user 在save changes里面会被重新加回来 所以也好像无所谓了 而且exit program的话不会保存。
            //actually will never be reached.
            throw new IOException("The User changes has not been saved.");
        }
    }

    /**
     * save the user's changes and rewrite the file.
     * @param user changed user
     * @throws Exception when there is an error when saving user
     */
    public void saveUserChanges(User user) throws Exception {
        userManager.saveUserChange(user);
    }

    /**
     * get the selected user associated with the username
     * @param username username
     * @return User
     */
    public User getSelectedUser(String username){
        return userManager.getSelectedUser(username);
    }

    /**
     * Test cases, please ignore
     */
    public static void main(String[] args) throws Exception {
        LoginRegisterUI loginRegisterUI = new LoginRegisterUI();
        User user = loginRegisterUI.initiate();
        UserControlCentre userControlCentre = new UserControlCentre();
        userControlCentre.deleteUserAccount(user);
    }
}

//    @Override
//    public void createEntity();
//
//    //implement UserWriterReader gateway 写入信息到user里面
//
//    @Override
//    public void deleteEntity();
//    //implements UserWriterReader gateway
//
//    @Override
//    public void updateEntity();

