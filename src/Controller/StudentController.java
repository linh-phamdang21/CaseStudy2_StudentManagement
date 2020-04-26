
package Controller;

import DAO.StudentDAOImpl;
import Model.Student;
import Service.ClassTableModel;
import Service.StudentService;
import StudentIO.StudentIO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentController{
    
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
    private Student student;
    private StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
    private StudentIO studentIO = new StudentIO();
    
    public StudentController(JButton btnSubmit, JTextField jtfStudentID, JTextField jtfName, 
            JDateChooser jdcDateOfBirth, JRadioButton jrdMale, JRadioButton jrdFemale, JTextField jtfPhoneNumber, 
            JTextArea jtaAddress, JCheckBox jcbStatus, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfStudentID = jtfStudentID;
        this.jtfName = jtfName;
        this.jdcDateOfBirth = jdcDateOfBirth;
        this.jrdMale = jrdMale;
        this.jrdFemale = jrdFemale;
        this.jtfPhoneNumber = jtfPhoneNumber;
        this.jtaAddress = jtaAddress;
        this.jcbStatus = jcbStatus;
        this.jlbMsg = jlbMsg;
        //this.studentSirvice = new StudentServiceImpl() {};
    }

    public void setView(Student student){
        this.student = student;
        this.jtfStudentID.setText("#" + student.getStudentId());
        jtfName.setText(student.getName());
        if (student.isGender()){
            this.jrdMale.setSelected(true);
        } else {
            this.jrdFemale.setSelected(true);
        }
        this.jtfPhoneNumber.setText(student.getTelephone());
        this.jtaAddress.setText(student.getAddress());
        this.jcbStatus.setSelected(student.isStatus());
    }
    
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfName.getText().length() == 0 || jtfStudentID.getText().length() == 0 ||
                        jtfPhoneNumber.getText().length() == 0 || jtaAddress.getText().length() == 0 ||
                        jdcDateOfBirth.getDate() == null){
                    jlbMsg.setText("Please enter the student's information");
                } 
                else{
                    String name = jtfName.getText();
                    Date dateOfBirth = jdcDateOfBirth.getDate();
                    String telephone = jtfPhoneNumber.getText();
                    boolean gender = (jrdMale.isSelected() == true) ? true : false;
                    String address = jtaAddress.getText();
                    String studentId = jtfStudentID.getText();
                    boolean status = jcbStatus.isSelected();
                    studentDAOImpl.addStudent(studentId, name, telephone, address, dateOfBirth, gender, status);
                    jlbMsg.setText("Added student successfully");
                    studentIO.writeStudentFile(studentDAOImpl.getList());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0,200,83));                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(51,204,0));
            }
        });
    }
}
