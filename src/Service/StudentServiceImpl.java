package Service;

import DAO.StudentDAO;
import DAO.StudentDAOImpl;
import Model.Student;
import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentDAO studentDAO = null;
    
    public StudentServiceImpl(){
        studentDAO = new StudentDAOImpl();
    }
            
    @Override
    public List<Student> getList() {
        return studentDAO.getList();
    }
    
}
