/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author kueky
 */
public class Forum {
    private String dateCreated;
    private String forumID;
    private String forumDescription;
    private String forumType;
    private Course course;
    private ArrayList<Thread> threadList;
   

    public Forum(String forumType, Course course) {
        SimpleDateFormat  dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	Date date = new Date();
	this.dateCreated = dateFormat.format(date);
        this.forumType = forumType;
        this.course = course;
        this.forumDescription = setForumDescription(this.forumType);
        this.threadList = new ArrayList<>();
    }

    public Forum() {
      
    }
    private String setForumDescription(String forumType){
        String description = "";
        
        switch(forumType){
            case "Subject" : 
                description = "This is Subject Related Forum";
                break;
            case "Helpful Resource" :
                description = "This is Helpful Resource Forum";
                break;
            case "General Discussion" :
                description = "This is General Discussion Forum";
                break;       
        }
        return description;
    }
    public String getForumType() {
        return forumType;
    }
    public Course getCourse() {
        return course;
    }
    public void addThread(Thread thread){
        threadList.add(thread);
    }
    public ArrayList<Thread> getThreadList() {
        return threadList;
    }
    public Thread getThread(){
        return this.threadList.get(0);
    }
    public Thread getThread(int index){
        return this.threadList.get(index);
    }
    

  
    
    @Override
    public String toString() {
        String a;
        a = String.format("Forum Type : %s\nCourse : %s\nDate : %s\nDescription : %s\n"
                ,this.forumType,this.course, this.dateCreated, this.forumDescription);
        
        return a;
    }
}
