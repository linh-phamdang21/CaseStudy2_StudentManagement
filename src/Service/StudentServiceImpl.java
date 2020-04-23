package Service;

//import DAO.StudentDAO;
import DAO.StudentDAOImpl;
import Model.Student;
import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentDAOImpl studentDAOImpl = null;
    
        public StudentServiceImpl(){
        studentDAOImpl = new StudentDAOImpl();
    }
            
    @Override
    public List<Student> getList() {
        return studentDAOImpl.getList();
    }
    
}
