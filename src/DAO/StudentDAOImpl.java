
package DAO;

import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{
    List<Student> list;
    @Override
    public List<Student> getList(){
        try {
            List<Student> list = new ArrayList<>();
            Student student1 = new Student();
            student1.setStudentId(1);
            student1.setName("linh");
            list.add(student1);
            Iterator<Student> iterator = list.iterator();
            while (iterator.hasNext()) {
                Student student = new Student();
                student.setStudentId(student.getStudentId());
                student.setName(student.getName());
                student.setDateOfBirth(student.getDateOfBirth());
                student.setTelephone(student.getTelephone());
                student.setGender(student.isGender());
                student.setAddress(student.getAddress());
                student.setStatus(student.isStatus());
                list.add(student);
        }
        return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
    
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl();
        System.out.println(studentDAO.getList());
    }
}
