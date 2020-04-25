
package Service;

import Model.CurrentClass;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClassModel {
    public DefaultTableModel setTableClass(List<CurrentClass> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        CurrentClass currentClass = null;
        if (rows > 0){
            for (int i = 0; i < rows; i++){                
                currentClass = listItem.get(i);
                obj = new Object[columns];
                obj[0] = i + 1;
                obj[1] = currentClass.getClassId();
                obj[2] = currentClass.getName();
                obj[3] = currentClass.getCourse();
                obj[4] = currentClass.getStudentAmount();
                obj[5] = currentClass.getRegistrationDate();
                obj[6] = currentClass.isStatus() == true? "Actived" : "Not Actived";
                dtm.addRow(obj);
                }
            }
        return dtm;  
    }
}
