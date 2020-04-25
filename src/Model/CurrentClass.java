package Model;

import java.util.ArrayList;

public class CurrentClass {
    private int classId;
    private String name;
    private String course;
    private int studentAmount;
    private String registrationDate;
    private boolean status;
    
    private ArrayList classList = new ArrayList();
    
    public CurrentClass(){
        classList.clear();
        CurrentClass class1 = new CurrentClass(0220, "C0220H1","Java-Fulltime" , 20, "20/02/2020", true);
        CurrentClass class2 = new CurrentClass(0503, "C0503H2","PHP-Fulltime", 15, "03/05/2020", false);
        classList.add(class1);
        classList.add(class2);
    }
    
    public CurrentClass(int classId, String name, String course, int studentAmount, String registrationDate, boolean status){
        this.classId = classId;
        this.name = name;
        this.course = course;
        this.studentAmount = studentAmount;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public ArrayList getClassList() {
        return classList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setStudentAmount(int studentAmount) {
        this.studentAmount = this.studentAmount;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getClassId() {
        return classId;
    }

    public String getCourse() {
        return course;
    }

    public int getStudentAmount() {
        return studentAmount;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public boolean isStatus() {
        return status;
    }       
}
