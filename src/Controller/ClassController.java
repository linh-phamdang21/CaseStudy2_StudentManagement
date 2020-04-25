
package Controller;

import Model.CurrentClass;
import Service.ClassModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClassController {
    private JPanel jpnView;
    private ClassModel classModel = null;
    CurrentClass currentClass = new CurrentClass();
    private String[] listColumn = {"Ordinal", "ID", "Name", "Course"
                                   , "Student Amount", "Registration Date", "Status"};
    
    public ClassController(JPanel jpnView){
        this.jpnView = jpnView;
    }
    
    
    
    public void setClassToTable(){
        List<CurrentClass> listItem = currentClass.getClassList();
        DefaultTableModel model = new ClassModel().setTableClass(listItem, listColumn);
        JTable table = new JTable(model);
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
}
