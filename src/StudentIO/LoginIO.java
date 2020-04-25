
package StudentIO;

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

public class LoginIO {
    
    private static String LoginFilePath = "LoginFile.txt";
    ArrayList<UserAccount>userList = new ArrayList<>();
    
    public void readUserFile() throws Exception {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(LoginFilePath);
            objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Object> resultList = (ArrayList) objectInputStream.readObject();
            for (Object user : resultList){
                System.out.println(user.toString());;
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

    public void writeUserFile(ArrayList<UserAccount> userList) {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(LoginFilePath);
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

//try {
//            fileOutputStream = new FileOutputStream(LoginFilePath);
//            objectOutput = new ObjectOutputStream(fileOutputStream);
//            objectOutput.writeObject(userList);
//        } catch (IOException e){
//            e.printStackTrace();
//        } finally {
//            try{
//                if (objectOutput != null){
//                    objectOutput.close();
//                }
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//        }
