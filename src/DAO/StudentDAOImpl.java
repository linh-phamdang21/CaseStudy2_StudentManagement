
package DAO;

import Model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl{
    public static List<Student> list = new ArrayList<>();
   
    public List<Student> getList(){
            List<Student> list = new ArrayList<>();
            Student student1 = new Student();
            student1.setStudentId("1");
            student1.setName("Pham Dang Linh");
            student1.setAddress("Ha noi");
            student1.setTelephone("0356712635");
            //student1.setDateOfBirth();
            student1.setGender(true);
            student1.setStatus(true);
            list.add(student1);
            
            Student student2 = new Student();
            student2.setStudentId("2");
            student2.setName("Luong Minh Thu");
            student2.setAddress("Thai Binh");
            student2.setTelephone("0965224801");
            //student1.setDateOfBirth();
            student2.setGender(false);
            student2.setStatus(true);
            list.add(student2);
            
            Student student3 = new Student();
            student3.setStudentId("3");
            student3.setName("Vu Quang Nguyen");
            student3.setAddress("Hai Duong");
            student3.setTelephone("0983818806");
            //student1.setDateOfBirth();
            student3.setGender(true);
            student3.setStatus(true);
            list.add(student3);
            
            return list;
    } 
    
    public Student addStudent(){
        Student student = new Student();
        return student;
    }
    
    public static void main(String[] args) {
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        System.out.println(studentDAO.getList());
    }
}
