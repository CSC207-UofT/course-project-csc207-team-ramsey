package commandline;

import entities.UserList;

import java.io.*;

public class UserWriteReader implements WriteReader {

    public void saveToFile(String filePath, Object users) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(users);
        output.close();
    }

        //传出信息，写入文本， 将一个新创建的user的信息写入文本

    //public userList readUser(){
     //从文本中读取信息，拉出文本写入userlist并且对userlist进行操作
    // }


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


