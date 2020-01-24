/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ochen
 */
public class RegisteredCourse {
    private Date dateRegistered;
    private String status;
    private String result;
    private Course course;
    private Payment payment;
    private CourseSchedule cs;

    public RegisteredCourse(Course course){
        this.course = course;
        this.dateRegistered = new Date();
        this.status = "Enroll";
    }
    
    public RegisteredCourse(Course course, CourseSchedule cs) {
        this.course = course;
        this.dateRegistered = new Date();
        this.cs = cs;
        this.status = "Enroll";
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public String getResult() {
        return result;
    }

    public CourseSchedule getCs() {
        return cs;
    }
    
    
    
    public Course getCourse() {
        return course;
    }
    
    public String getStatus() {
        return status;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setCs(CourseSchedule cs) {
        this.cs = cs;
    }
    
    
    
    public void setStatus(String status) {
        this.status = status;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    
    
    
    
    
}
