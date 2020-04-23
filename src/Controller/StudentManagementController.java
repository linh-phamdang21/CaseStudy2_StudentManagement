
package Controller;

import Model.Student;
import Service.ClassTableModel;
import Service.StudentService;
import Service.StudentServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import view.StudentJFrame;

public class StudentManagementController {
    
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private JTextField jtfStudentID;
    private JTextField jtfName;
    private JDateChooser jdcDateOfBirth;
    private JRadioButton jrdMale;
    private JRadioButton jrdFemale;
    private JTextField jtfPhoneNumber;
    private JTextArea jtaAddress;
    private JCheckBox jcbStatus;
    private JLabel jlbMsg;
    private ClassTableModel classTableModel = null;
    private StudentService studentService = null;
    private String[] listColumn = {"ID", "Ordinal", "Name", "Date of Birth"
                                   , "Gender", "Phone Number", "Address", "Status"};
    
    private TableRowSorter<TableModel> rowSorter = null;
            
    public StudentManagementController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch){
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.classTableModel = new ClassTableModel();
        this.studentService = new StudentServiceImpl();
    }
    
    public void setDateToTable(){
        List<Student> listItem = studentService.getList();
        DefaultTableModel model = new ClassTableModel().setTableStudent(listItem, listColumn);
        JTable table = new JTable(model);
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                } else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                } else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
        
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    Student student = new Student();
                    student.setStudentId(model.getValueAt(selectedRowIndex, 0).toString());
                    student.setName(model.getValueAt(selectedRowIndex, 2).toString());
                    student.setDateOfBirth((Date) model.getValueAt(selectedRowIndex, 3));
                    student.setGender(model.getValueAt(selectedRowIndex, 4).toString().equalsIgnoreCase("Nam"));
                    student.setTelephone(model.getValueAt(selectedRowIndex, 5) != null ? 
                            model.getValueAt(selectedRowIndex, 5).toString() : " ");
                    student.setAddress(model.getValueAt(selectedRowIndex, 6) != null ?
                            model.getValueAt(selectedRowIndex, 6).toString() : " ");
                    student.setStatus((boolean) model.getValueAt(selectedRowIndex, 7));
                    
                    StudentJFrame frame = new StudentJFrame(student);
                    frame.setTitle("Student's Information");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
            
});
        
        table.getTableHeader().setFont(new Font("Arrial", Font.BOLD, 12));
        table.getTableHeader().setPreferredSize(new Dimension(80, 30));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(700, 300));
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }  
    
    public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StudentJFrame frame = new StudentJFrame(new Student());
                frame.setTitle("Student's Information");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0,200,83));                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(51,204,0));
            }
        });
    }
};
