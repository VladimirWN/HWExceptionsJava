package Utils;

import Users.User;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToTxt {
    public void write(User user) throws IOException {
        String pathFile = "HomeWork/HW03/src/Files/" + user.getSurname() + ".txt";
        FileWriter fw = new FileWriter(pathFile, true);
        fw.write(user + "\n");
        fw.close();
    }
}