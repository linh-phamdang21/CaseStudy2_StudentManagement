
package Service;

import Model.CurrentCourse;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CourseModel {
    public DefaultTableModel setTableCourse(List<CurrentCourse> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column);
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
        CurrentCourse currentCourse = null;
        if (rows > 0){
            for (int i = 0; i < rows; i++){
                currentCourse = listItem.get(i);
                obj = new Object[columns];
                obj[0] = i+1;
                obj[1] = currentCourse.getCourseId();
                obj[2] = currentCourse.getCourseName();
                obj[3] = currentCourse.getDescription();
                obj[4] = currentCourse.getStartDate();
                obj[5] = currentCourse.getEndDate();
                obj[6] = currentCourse.isStatus()? "Actived" : "Not Actived";
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
