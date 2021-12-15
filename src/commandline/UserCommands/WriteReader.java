package commandline.UserCommands;

import entities.UserList;

import java.io.IOException;

public interface WriteReader {

    void saveToFile(String filePath, Object users) throws IOException;

    UserList readFromFile(String filePath) throws IOException, ClassNotFoundException;
}
