package entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserList implements Serializable {
    private final Map<String, User> users = new HashMap<>();
    /**
     * Add user to this user list.
     * @param user the user to add in to the userList
     */
    public void add(User user){
        users.put(user.getUserName(), user);
    }

    /**
     * Retrun the User associated with username
     * @param username the username of the user to get.
     * @return choose the user
     */
    public User getUser(String username){
        return users.get(username);
    }

    /**
     * update the user in the userlist
     * @param user
     */
    public void upDateUser(User user){
        users.put(user.getUserName(), user);
    }
}
