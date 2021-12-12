package commandline;

import controllers.UserControlCentre;
import entities.User;

public class SaveUserChangeCmd {
    public SaveUserChangeCmd() {
    }
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
