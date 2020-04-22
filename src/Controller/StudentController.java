
package Controller;

import Model.Student;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentController {
    
    private JButton btnSubmit;
    private JTextField jtfStudentID;
    private JTextField jtfName;
    private JDateChooser jdcDateOfBirth;
    private JRadioButton jrdMale;
    private JRadioButton jrdFemale;
    private JTextField jtfPhoneNumber;
    private JTextArea jtaAddress;
    private JCheckBox jcbStatus;

    private Student student;
    
    public StudentController(JButton btnSubmit, JTextField jtfStudentID, JTextField jtfName, JDateChooser jdcDateOfBirth, JRadioButton jrdMale, JRadioButton jrdFemale, JTextField jtfPhoneNumber, JTextArea jtaAddress, JCheckBox jcbStatus) {
        this.btnSubmit = btnSubmit;
        this.jtfStudentID = jtfStudentID;
        this.jtfName = jtfName;
        this.jdcDateOfBirth = jdcDateOfBirth;
        this.jrdMale = jrdMale;
        this.jrdFemale = jrdFemale;
        this.jtfPhoneNumber = jtfPhoneNumber;
        this.jtaAddress = jtaAddress;
        this.jcbStatus = jcbStatus;
    }

    public void setView(Student student){
        this.student = student;
        jtfStudentID.setText("#" + student.getStudentId());
        jtfName.setText(student.getName());
        if (student.isGender()){
            jrdMale.setSelected(true);
            jrdFemale.setSelected(false);
        } else {
            jrdFemale.setSelected(true);
            jrdMale.setSelected(false);
        }
        jtfPhoneNumber.setText(student.getTelephone());
        jtaAddress.setText(student.getAddress());
        jcbStatus.setSelected(student.isStatus());
    }
    
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
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
