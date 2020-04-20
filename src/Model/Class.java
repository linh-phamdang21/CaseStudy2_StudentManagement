package Model;

import java.util.Date;

public class Class {
    private int classId;
    private Course course;
    private Student student;
    private Date registrationDate;
    private boolean status;

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getClassId() {
        return classId;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public boolean isStatus() {
        return status;
    }       
}
