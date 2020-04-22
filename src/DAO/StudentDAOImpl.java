
package DAO;

import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{
    List<Student> list;
    @Override
    public List<Student> getList(){
        try {
            List<Student> list = new ArrayList<>();
            Student student1 = new Student();
            student1.setStudentId(1);
            student1.setName("thu");
            student1.setGender(true);
            student1.setStatus(true);
            list.add(student1);
            
            Student student2 = new Student();
            student2.setStudentId(5);
            student2.setName("linh");
            student2.setGender(false);
            student2.setStatus(true);
            list.add(student2);
            
            Iterator<Student> iterator = list.iterator();
//            while (iterator.hasNext()) {
//                Student student = new Student();
//                student.setStudentId(student.getStudentId());
//                student.setName(student.getName());
//                student.setDateOfBirth(student.getDateOfBirth());
//                student.setTelephone(student.getTelephone());
//                student.setGender(student.isGender());
//                student.setAddress(student.getAddress());
//                student.setStatus(student.isStatus());
//                list.add(student);
//        }
        return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
    
    public Student addStudent(){
        Student student = new Student();
        return student;
    }
    
//    @Override
//    public int createOrUpdate(HocVien hocVien) {
//        try {
//            Connection cons = DBConnect.getConnection();
//            String sql = "INSERT INTO hoc_vien(ma_hoc_vien, ho_ten, ngay_sinh, gioi_tinh, so_dien_thoai, dia_chi, tinh_trang) VALUES(?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE ho_ten = VALUES(ho_ten), ngay_sinh = VALUES(ngay_sinh), gioi_tinh = VALUES(gioi_tinh), so_dien_thoai = VALUES(so_dien_thoai), dia_chi = VALUES(dia_chi), tinh_trang = VALUES(tinh_trang);";
//            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            ps.setInt(1, hocVien.getMa_hoc_vien());
//            ps.setString(2, hocVien.getHo_ten());
//            ps.setDate(3, hocVien.getNgay_sinh());
//            ps.setBoolean(4, hocVien.isGioi_tinh());
//            ps.setString(5, hocVien.getSo_dien_thoai());
//            ps.setString(6, hocVien.getDia_chi());
//            ps.setBoolean(7, hocVien.isTinh_trang());
//            ps.execute();
//            ResultSet rs = ps.getGeneratedKeys();
//            int generatedKey = 0;
//            if (rs.next()) {
//                generatedKey = rs.getInt(1);
//            }
//            ps.close();
//            cons.close();
//            return generatedKey;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return 0;
//    }
    
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl();
        System.out.println(studentDAO.getList());
    }
}
