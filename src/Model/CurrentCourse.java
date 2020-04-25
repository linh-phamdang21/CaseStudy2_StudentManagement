package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class CurrentCourse implements Serializable{
    private int courseId;
    private String courseName;
    private String description;
    private String startDate;
    private String endDate;
    private boolean status;

    ArrayList courseList = new ArrayList();
    
    public CurrentCourse(int courseId, String courseName, String description, String startDate, String endDate, boolean status){
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
    
    public CurrentCourse(){
        courseList.clear();
        CurrentCourse currentCourse1 = new CurrentCourse(1, "Java - Fullstack", "Complete in 6 months, CT-04", "20/02/2020", "20/08/2020",true);
        CurrentCourse currentCourse2 = new CurrentCourse(2, "PHP - Fullstack", "Complete in 6 months, CT-01", "03/05/2020", "03/11/2020",true);
        courseList.add(currentCourse1);
        courseList.add(currentCourse2);
    }

    public ArrayList getCourseList() {
        return courseList;
    }
    
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public boolean isStatus() {
        return status;
    }
    
    
}
