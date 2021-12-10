package controllers;

import entities.User;
import entities.UserList;
import usecases.LoginManager;
import usecases.UserManager;

public class UserControlCentre {
    private UserManager userManager;

    public UserControlCentre(){
        this.userManager = new UserManager();
    }

    public User createNewUser(String username, String name, String email, String password) throws Exception {
        if (userManager.checkUserNameAva(username)) {
            return userManager.createNewUser(username, password, email, name);
        } else {
            throw new Exception("The username already exist, please change a username");
        }
    }

    public void changePassword(String password, User user){
        userManager.changeUserPassword(password, user);
    }

    public void deleteUserAccount(User user) throws Exception {
        userManager.deleteUser(user);
        try {
            userManager.saveChangesDeleteUser();
        } catch (Exception e){
            System.out.println("The User changes has not been saved.");
        }
    }

    public void saveUserChanges(User user) throws Exception {
        userManager.saveUserChange(user);
    }

    public User getSelectedUser(String username){
        return userManager.getSelectedUser(username);
    }
    public static void main(String[] args) throws Exception {
        UserControlCentre userControlCentre = new UserControlCentre();
        //userControlCentre.createNewUser("101112","123","123","123");
        //userControlCentre.userManager.saveChangesDeleteUser();
        User user = userControlCentre.userManager.getSelectedUser("101112");
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

