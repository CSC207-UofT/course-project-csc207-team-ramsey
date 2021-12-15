package commandline.UserCommands;

import entities.UserList;

import java.io.*;

public class UserWriteReader implements WriteReader {
    /** File Reader and File writer



    /**
     *
     * @param filePath chose the file path
     * @param users users to save
     * @throws IOException when there is some problem during writing data
     */
    public void saveToFile(String filePath, Object users) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        output.writeObject(users);
        output.close();
    }




    public UserList readFromFile(String filePath) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        UserList users = (UserList) input.readObject();
        input.close();
        return users;
}
}


