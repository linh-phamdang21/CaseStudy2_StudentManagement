package Model;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
    private String studentId;
    private String name;
    private String telephone;
    private String address;
    private Date dateOfBirth;
    private boolean gender;
    private boolean status;

    
    public Student(){
        
    }
    
    public Student(String studentId, String name, String telephone, String address, Date dateOfBirth, boolean gender, boolean  status){
        this.studentId = studentId;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.status = status;
    }
    
    public void setStudentId(String studentId) {
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

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth= dateOfBirth;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStudentId() {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Studen ID: " + studentId + " , name: "+ name + ", gender: " + gender + ", phone number: " + telephone +
                ", address: " + address + "";
    }   
}
