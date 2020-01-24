/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.Date;


public class Assignment {
   
    private String assignmentID;
    private String assignmentDescription;
    private Date deadline;
    private int weightage;
    
    private ArrayList<AssignmentSubmitted> submitted;

    public Assignment() {
    }

    public Assignment(String assignmentID, String assignmentDescription, Date deadline, int weightage) {
        this.assignmentID = assignmentID;
        this.assignmentDescription = assignmentDescription;
        this.deadline = deadline;
        this.weightage = weightage;
        
    }

    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    public String getAssignmentID() {
        return assignmentID;
    }

    public Date getDeadline() {
        return deadline;
    }

    public int getWeightage() {
        return weightage;
    }

    public ArrayList<AssignmentSubmitted> getSubmitted() {
        return submitted;
    }

    public void addSubmitted(AssignmentSubmitted submitted){
        this.submitted.add(submitted);
    }
    

    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }

    public void setAssignmentID(String assignmentID) {
        this.assignmentID = assignmentID;
    }



    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setWeightage(int weightage) {
        this.weightage = weightage;
    }
    
}
