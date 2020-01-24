/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Forum;
import java.util.ArrayList;

/**
 *
 * @author kueky
 */
public class Course {
    private String courseID;
    private String courseDescription;
    private String courseName;
    private ArrayList<Forum> forum = new ArrayList<>();
    private Assignment assignment;
    private double price;
    private double creditHour;
    private ArrayList<CourseSchedule> csList = new ArrayList<>();
    private ArrayList<Tutor> tutor = new ArrayList<>();

    public Course() {
    }

    public Course(String courseID, String courseName, String courseDescription, double price, double creditHour) {
        this.courseID = courseID;
        this.courseDescription = courseDescription;
        this.courseName = courseName;
        this.price = price;
        this.creditHour = creditHour;
    }
    public String getCourseName() {
        return courseName;
    }
    public void addForum(Forum forum){
        this.forum.add(forum);
    }
    public ArrayList<Forum> getForum() {
        return forum;
    }

    public ArrayList<CourseSchedule> getCsList() {
        return csList;
    }
    
    public ArrayList<Tutor> getTutor() {
        return tutor;
    }
    
    
    public void addCsList(CourseSchedule cs){
        this.csList.add(cs);
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public void addTutor(Tutor tutor) {
        this.tutor.add(tutor);
    }
    
    
    public String getCourseDescription() {
        return courseDescription;
    }

    public String getCourseID() {
        return courseID;
    }
    
    public String printCourseDetails(){
        return "\n=============================================================== \n" + 
               "\t\t  "+ courseID +" " + courseName +
               "\n=============================================================== \nDescription: \n" 
                + this.courseDescription;
    }
     
    public double printPrice(){
        double totalprice=price * creditHour;
        
        return totalprice;
    }
    
    @Override
    public String toString() {
        String printing = "";
        
        printing += ("Name : " + this.courseName + "\nThis course have :");
        
        if(forum.isEmpty()){
            printing += "This Course Has No Forum Yet";
        }else{
            for(Forum a : forum){
           printing += (a.getForumType() + " ");
          }
        }
        return printing;
    }
    
    
}
