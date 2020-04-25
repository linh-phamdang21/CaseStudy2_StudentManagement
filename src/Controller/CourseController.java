
package Controller;

import Model.CurrentCourse;
import Service.CourseModel;
import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sun.font.SunFontManager;

public class CourseController {
    JPanel jpnView;
    CourseModel courseModel = null;
    CurrentCourse currentCourse = new CurrentCourse();
    private String[] listColumn = {"Ordinal", "ID", "Name", "Description","Start Date", "End Date", "Status"};
    
    public CourseController(JPanel jpnView){
        this.jpnView = jpnView;
    }
    
    public void setCourseToTable(){
        List<CurrentCourse> listItem = currentCourse.getCourseList();
        DefaultTableModel model = new CourseModel().setTableCourse(listItem, listColumn);
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
