package usecases;

import entities.User;

public class UserManager {

    public User createNewUser(String name, String uName, String email, String password){
        User newUser = new User(name, uName, email, password);
        return newUser;
    }


}
