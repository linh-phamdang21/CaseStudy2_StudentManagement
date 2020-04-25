
package Controller;

import Model.Student;
import Service.ClassTableModel;
import Service.StudentService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
            this.jrdFemale.setSelected(false);
        } else {
            this.jrdFemale.setSelected(true);
            this.jrdMale.setSelected(false);
        }
        this.jtfPhoneNumber.setText(student.getTelephone());
        this.jtaAddress.setText(student.getAddress());
        this.jcbStatus.setSelected(student.isStatus());
    }
    
    public void addStudent(){
        
    }
    
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfName.getText().length() == 0){
                    jlbMsg.setText("Please enter the student's information");
                } 
                else{
                    student.setName(jtfName.getText());
                    student.setDateOfBirth(jdcDateOfBirth.getDate());
                    student.setTelephone(jtfPhoneNumber.getText());
                    student.setGender((jrdMale.isSelected() == true) ? true : false);
                    student.setAddress(jtaAddress.getText());
                    student.setStudentId("#" + jtfStudentID.getText());
                    student.setStatus(jcbStatus.isSelected());
                    jlbMsg.setText("Edited student successfully");
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
