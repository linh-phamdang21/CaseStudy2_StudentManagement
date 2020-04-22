
package Controller;

import Model.Student;
import Service.StudentService;
import Service.StudentServiceImpl;
import Utility.ClassTableModel;
import com.mysql.cj.xdevapi.Table;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView;

public class StudentManagementController {
    
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private StudentService studentService = null;
    
    private String[] listColumn = {"Ma hoc vien", "STT", "Ho va ten", "Ngay sinh"
                                   , "Gioi tinh", "So dien thoai", "Dia chi", "Tinh trang"};
    
    private TableRowSorter<TableModel> rowSorter = null;
            
    public StudentManagementController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch){
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
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
                    rowSorter.setRowFilter(RowFilter.regexFilter("?i" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                } else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("?i" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        table.getTableHeader().setFont(new Font("Arrial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1300, 400));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }       
};
