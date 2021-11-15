package commandline;

import entities.User;
import usecases.LoginManager;
import usecases.UserManager;

import java.util.List;

public class CreateUserCmd {
    //add checke same username
    public User execute(List<String> detail) {
       String name = detail.get(0);
       String uName = detail.get(1);
       String email = detail.get(2);
       String password = detail.get(3);
       LoginManager loginManager = new LoginManager();
       User user = new User(name, uName, email, password);
       loginManager.saveChanges(user);
       return user;
    }
}