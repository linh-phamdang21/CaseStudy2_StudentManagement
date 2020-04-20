package Model;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable{
    private int courseId;
    private String courseName;
    private String description;
    private Date startDate;
    private Date endDate;
    private boolean status;

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isStatus() {
        return status;
    }
    
    
}
