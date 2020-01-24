/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;


public class AssignmentSubmitted {
    private int marks;
    private Learner learner;
    private Date dateSubmitted;
    private Tutor tutor;
    private String content;
    private String comment;

    Assignment assignment;

    public AssignmentSubmitted() {
    }

    public AssignmentSubmitted(int marks, Learner learner, Date dateSubmitted, Tutor tutor, String content, String comment, Assignment assignment) {
        this.marks = marks;
        this.learner = learner;
        this.dateSubmitted = dateSubmitted;
        this.tutor = tutor;
        this.content = content;
        this.comment = comment;
        this.assignment = assignment;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public int getMarks() {
        return marks;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public String getContent() {
        return content;
    }

    public String getComment() {
        return comment;
    }

    
    public void setContent(String content) {
        this.content = content;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Learner getLearner() {
        return learner;
    }

    public void setLearner(Learner learner) {
        this.learner = learner;
    }
    
    
    
    
    

}
