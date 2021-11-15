package commandline;

import entities.UserList;

import java.io.IOException;

public interface WriteReader {

    public void saveToFile(String filePath, Object users) throws IOException;

    public UserList readFromFile(String filePath) throws IOException, ClassNotFoundException;
}
