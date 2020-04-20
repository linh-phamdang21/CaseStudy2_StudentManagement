package Model;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
    private int studentId;
    private String name;
    private String telephone;
    private String address;
    private Date dateOfBirthDate;
    private boolean gender;
    private boolean status;

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirthDate(Date dateOfBirthDate) {
        this.dateOfBirthDate = dateOfBirthDate;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirthDate() {
        return dateOfBirthDate;
    }

    public boolean isGender() {
        return gender;
    }

    public boolean isStatus() {
        return status;
    }
}
