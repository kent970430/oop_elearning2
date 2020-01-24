/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author kueky
 */
public class CourseSchedule {
     private String courseSchedule;
    private Date startDate;
    private Date endDate;
    

    public CourseSchedule(String courseSchedule, Date startDate, Date endDate) {
        this.courseSchedule = courseSchedule;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCourseSchedule() {
        return courseSchedule;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setCourseSchedule(String courseSchedule) {
        this.courseSchedule = courseSchedule;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    
}
