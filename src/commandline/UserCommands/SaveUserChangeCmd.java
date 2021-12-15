package commandline.UserCommands;

import controllers.UserControlCentre;
import entities.User;

public class SaveUserChangeCmd {
    public SaveUserChangeCmd() {
    }

    /**
     * Save user's changes to file, throw exceptions when user's changes cannot be changed.
     * @param user chosen changed user that changed the details in it already.
     * @throws Exception when save to file has IO exception
     */
    public void saveUserChanges(User user) throws Exception {
        UserControlCentre userControlCentre = new UserControlCentre();
        userControlCentre.saveUserChanges(user);
    }

    public static void main(String[] args) throws Exception {
        LoginRegisterUI loginRegisterUI = new LoginRegisterUI();
        User user = loginRegisterUI.initiate();
        System.out.println(user.getEmail());
        user.setEmail("ABCDE");
        SaveUserChangeCmd saveUserChangeCmd = new SaveUserChangeCmd();
        saveUserChangeCmd.saveUserChanges(user);
    }
}
