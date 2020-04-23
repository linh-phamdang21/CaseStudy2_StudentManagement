
package DAO;

import Model.Student;
import view.StudentJFrame;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentList extends Student{
    private JButton btnSubmit;
    private JTextField jtfStudentID;
    private JTextField jtfName;
    private JDateChooser jdcDateOfBirth;
    private JRadioButton jrdMale;
    private JRadioButton jrdFemale;
    private JTextField jtfPhoneNumber;
    private JTextArea jtaAddress;
    private JCheckBox jcbStatus;
    private JLabel jlbMsg;
    public static ArrayList<Student> students = new ArrayList<>();

    public StudentList() {
//        Student student = new Student();
//        student.setStudentId("1");
//        student.setName("Linh");
//        //student.setDateOfBirth(jdcDateOfBirth.getDate());
//        student.setGender(true);
//        student.setAddress("Ha noi");
//        student.setStatus(true);
//        students.add(student);
    }

    public void addStudent(){
        Student student = new Student();
        student.setStudentId(jtfStudentID.getText());
        student.setName(jtfName.getText());
        student.setDateOfBirth(jdcDateOfBirth.getDate());
        student.setGender((jrdMale.isSelected() == true) ? true : false);
        student.setAddress(jtaAddress.getText());
        student.setStatus(jcbStatus.isSelected());
        students.add(student);
        jlbMsg.setText("Added new student successfully");
    }
    
    public void removeStudent(){
        
    }
    
    public void editStudent(){
        
    }
}
