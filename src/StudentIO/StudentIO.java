
package StudentIO;

import Model.Student;
import Model.UserAccount;
import Service.AccountList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StudentIO {
    
    private static String loginFilePath = "StudentFile.txt";
    ArrayList<Student> userList = new ArrayList<>();
    
    public void readStudentFile() throws Exception {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(loginFilePath);
            objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Object> resultList = (ArrayList) objectInputStream.readObject();
            for (Object student : resultList){
                System.out.println(student.toString());
            }            
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null){
                    objectInputStream.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void writeStudentFile(ArrayList<Student> userList) {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(loginFilePath);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(userList);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (objectOutputStream != null){
                        objectOutputStream.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }
}
