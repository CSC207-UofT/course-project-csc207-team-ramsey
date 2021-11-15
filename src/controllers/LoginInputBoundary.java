package controllers;

import usecases.LoginManager;

public interface LoginInputBoundary {
    LoginManager.LoginResult logIn(String username, String password);
}
