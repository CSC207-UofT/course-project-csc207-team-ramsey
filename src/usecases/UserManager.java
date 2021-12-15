package usecases;

import commandline.UserCommands.UserWriteReader;
import entities.User;
import entities.UserList;

import java.io.IOException;

public class UserManager {
    private UserWriteReader readWriter = new UserWriteReader();
    private UserList users;

    public UserManager() throws Exception{
        try {
            this.users = new LoginManager().getUsers();
        } catch (IOException e){
            this.users = new UserList();
        }
    }


    public void deleteUser(User user){
        users.deleteUser(user);
    }

    public void changeUserPassword(String newPassword, User user){
        user.setPassword(newPassword);
    }

    //改名这里需要更改design 不然的话存进user list里面的时候根据username指向的东西就变了，会存到另外一个地方，有bug.

    /**
     * Will be implemented when user change its username, and we need to store the user's previous username.
     * @param username username user want to change
     * @param user user
     */
    public void changeUserName(String username, User user){
        user.setPreviousUserName();
        user.setUserName(username);
    }

    /**
     * Save user changes. input a user to the existing user list. if the user data empty, will be resolved later in the
     * Controller, CMD or UI. And if the user data is empty. We create new one and add this user in users and save to the data.
     * If the data is not empty, we check the if the username does not in our data, if the username is not in our data, we check
     * does the user's previous username (exist only when user changed username) in the data, if it does exist, delete that
     * user with previous username. And if user is already in the data or not in the user data, just add(also update) the
     * user into the userlist. then save the users to file.
     *
     * if there is no user in the data, Create a new users if the data is empty, And if the data
     * is not empty.
     * -> if empty data
     *    -> create new Userlist
     * -> not empty data
     *    -> dose the user username already in the data
     *      -> does user have a previous username
     *          if yes-> delete the user associated with user's previous username
     * -> update the user into the userlist
     * -> try to save the file
     * @param user
     * @throws Exception
     */
    public void saveUserChange(User user) throws Exception{
        if (users == null) {
            users = new UserList();
        } else {
            if (users.getUser(user.getUserName()) == null) {
                if (users.getUser(user.getPreviousUserName()) != null) {
                    users.deleteUserByString(user.getPreviousUserName()); // delete the user with the previous username, happen when the user's username change
                }
            }
        }
        users.add(user);
        try {
            this.readWriter.saveToFile("users.ser", users);
        } catch (IOException e) {
            System.out.println("Cannot save the changes, user's changes and new list did not save");
        }
    }

    /**
     * Check the username is available for changeUsername and CreateNewUser command line.
     * @param username user's username he wants to change or create a new account
     * @return Boolean false if username is already in the user data, catch the Null point Exception when username is not
     * in the data and return true indicating the username can be used.
     */
    public boolean checkUserNameAva(String username) {
        try {
            users.getUser(username).getUserName();
            return false;
        } catch (NullPointerException e){
            return true;
        }
    }

    /**
     * Create a new User with username, password, email, and return the user to that could be manipulated later in the control centre
     * @param username user's username
     * @param password user's password
     * @param email user's email
     * @param name user's name
     * @return user with associated username, password, email, name
     */
    public User createNewUser(String username, String password, String email, String name){
        User user = new User(name, username, email, password);
        users.add(user);
        return user;
    }

    /**
     * Save the change for deleting a user
     */

    public void saveChangesDeleteUser() throws Exception {
        // Test function
        this.readWriter.saveToFile("users.ser", users);
    }

    /**
     *
     * @param username
     * @return a selected user with associate username
     */

    public User getSelectedUser(String username){
        // Test function
        return users.getUser(username);
    }

    /**
     * Return the users in this usermanager. write this for the test cases.
     * @return the users in this usermanager
     */
    public UserList getUsers() {
        return users;
    }

    /**
     * some test cases. Please ignore it
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        UserManager userManager = new UserManager();
        System.out.println(userManager.checkUserNameAva("555"));
        User user = new User("456","456","123","123");
        userManager.saveUserChange(user);
        LoginManager loginManager = new LoginManager();
        User user1 = loginManager.getLogInUser("123");
    }

}