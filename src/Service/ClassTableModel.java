
package Service;

import DAO.StudentList;
import Model.Student;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClassTableModel {
    
    public DefaultTableModel setTableStudent(List<Student> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        Student student = null;
        if (rows > 0){
            for (int i = 0; i < rows; i++){                
                student = listItem.get(i);
                obj = new Object[columns];
                obj[0] = student.getStudentId();
                obj[1] = (i + 1);
                obj[2] = student.getName();
                obj[3] = student.getDateOfBirth();
                obj[4] = student.isGender() == true? "Male" : "Female";
                obj[5] = student.getTelephone();
                obj[6] = student.getAddress();
                obj[7] = student.isStatus();
                dtm.addRow(obj);
                }
            }
        return dtm;  
    }
}
