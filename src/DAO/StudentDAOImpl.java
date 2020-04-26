
package DAO;

import Model.Student;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAOImpl{
    public static ArrayList<Student> list = new ArrayList<>();
   
    public ArrayList<Student> getList(){
            return list;
    } 
    
    public void addStudent(String studentId, String name, String telephone, String address, 
            Date dateOfBirthDate, boolean gender, boolean status){
        Student student = new Student(studentId, name, telephone, address, dateOfBirthDate, gender, status );
        list.add(student);
    }
    
    public void removeStudent(String id){
        for (int i = 0; i < this.list.size(); i++){
            if (list.get(i).getStudentId().equals(id)){
                list.remove(i);
            }
        }
    }
    
    public void editStudent(String id,String studentId, String name, String telephone, String address, 
            Date dateOfBirthDate, boolean gender, boolean status){
        for (int i = 0; i < this.list.size(); i++){
            if (list.get(i).getStudentId().equals(id)){
                list.get(i).setStudentId(studentId);
                list.get(i).setName(name);
                list.get(i).setTelephone(telephone);
                list.get(i).setAddress(address);
                list.get(i).setGender(gender);
                list.get(i).setStatus(status);
            }
        }
    }
    
    public static void main(String[] args) {
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        System.out.println(studentDAO.getList());
    }
}
