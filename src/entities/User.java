package entities;


import entities.food.Food;
import entities.Kitchen;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a user of the program
 */
public class User implements Serializable {

    private String name;
    private String userName;
    private String email;
    private Kitchen kitchen;
    private String password;
    private String previousUserName;

    /**
     *
     * Creates an instance of Entities.User
     * @param user name of user
     * @param uName user's username
     * @param mail user's email
     * @param password user's password
     */
    public User(String user, String uName, String mail, String password) {
        this.userName = uName;
        this.name = user;
        this.email = mail;
        this.kitchen = new Kitchen();
        this.password = password;
        this.previousUserName = "";
    }

    /**
     * @return current userName
     */
    public String getUserName(){
        return this.userName;
    }

    public void setPreviousUserName(){
        this.previousUserName = this.userName;
    }

    public String getPreviousUserName() {
        return previousUserName;
    }

    /**
     * @return current name
     */
    public String getName(){
        return this.name;
    }

    /**
     * @return current email
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * @return current Kitchen
     */
    public Kitchen getKitchen(){
        return this.kitchen;
    }

    /**
     *  set the userName
     * @param userName
     */
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean passwordMatches(String password) {
        return this.password.equals(password);
    }

    /**
     * set the name
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * set the email
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * @param newKitchen updated food list
     */
    public void setKitchen(Kitchen newKitchen) {
        this.kitchen = newKitchen;
    }


}
