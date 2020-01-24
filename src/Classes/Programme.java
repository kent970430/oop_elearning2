/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author ochen
 */
public class Programme {
     private String programmeCode;
    private String programmeName;
    private String programmeDescription;
    private int fee;
    private ArrayList<Course> course = new ArrayList<>();
    
    DecimalFormat formatter = new DecimalFormat("RM ###,###,###.00");
    public Programme() {
    }

    public Programme(String programmeCode, String programmeName, String programmeDescription, int fee) {
        this.programmeCode = programmeCode;
        this.programmeName = programmeName;
        this.programmeDescription = programmeDescription;
        this.fee = fee;
    }    
    
    public String getProgrammeCode() {
        return programmeCode;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public String getProgrammeDescription() {
        return programmeDescription;
    }
    
    public void addCourse(Course course) {
        this.course.add(course);
    }
    
    public ArrayList<Course> getCourse() {
        return course;
    }

    public int getFee() {
        
        return fee;
    }
    
    public void setCourse(Course course) {
        this.course.add(course);
    }

    public void setProgrammeDescription(String programmeDescription) {
        this.programmeDescription = programmeDescription;
    }


    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }
    
    public String printTitle(){
        String value="";
    
        value = programmeName + " (" + programmeCode + ")";
        return value;
    }
    
    
    
    @Override
    public String toString(){    
    return formatter.format(fee);
    }
    
}
