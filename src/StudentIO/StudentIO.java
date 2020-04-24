//
//package StudentIO;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//
//public class StudentIO {
//    
//    private static String studentFilePath = "StudentList.txt";
//    
//    public StudentIO(){
//        
//    }
//    
//    public 
//    
//    public void readStudentFile(){
//        File studentFile = new File(studentFilePath);       
//        FileInputStream fileInputStream;
//        ObjectInputStream objectInputStream = null;
//        
//        if (!studentFile.exists()){
//            try {
//                studentFile.createNewFile();
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//        } else {
//            try {
//                fileInputStream = new FileInputStream(studentFile);
//                objectInputStream = new ObjectInputStream(fileInputStream);
//                
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
//    
//    public void 
//}
