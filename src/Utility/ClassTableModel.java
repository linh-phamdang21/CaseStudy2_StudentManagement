
package Utility;

import Model.Student;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClassTableModel {
    
    public DefaultTableModel setTableStudent(List<Student> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if (rows > 0){
            for (int i = 0; i < rows; i++){
                Student student = listItem.get(i);
                obj = new Object[columns];
                obj[0] = student.getStudentId();
                obj[1] = (i + 1);
                obj[2] = student.getName();
                obj[3] = student.getDateOfBirth();
                obj[4] = student.isGender();
                obj[5] = student.getTelephone();
                obj[6] = student.getAddress();
                obj[7] = student.isStatus();
                dtm.addRow(obj);
            }
        }
        return dtm;  
    }
    
}
