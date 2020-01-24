/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author kueky
 */
public class Thread {
    private String threadID;
    private Date datePosted;
    private boolean threadStatus = true;
    private int numberOfReport = 0;
    private String threadDescription;
    private String threadTitle;
    private User user;
    private ArrayList<Comment> commentList;

    public Thread() {
    }

    public Thread(String threadDescription, User user, String threadTitle, Forum selectedForum) {
        int index = selectedForum.getThreadList().size();
        String course = selectedForum.getCourse().getCourseName();
        String forumType = selectedForum.getForumType();
        this.threadID = course + forumType + "T" + (index + 1);
        Date today = Calendar.getInstance().getTime();
        this.datePosted = today;
        this.threadDescription = threadDescription;
        this.threadStatus = true;
        this.user = user;
        this.threadTitle = threadTitle;
        this.commentList = new ArrayList<>();
    }

    public String getThreadDescription() {
        return threadDescription;
    }

    public void setThreadDescription(String threadDescription) {
        this.threadDescription = threadDescription;
    }

    public void setThreadStatus(boolean threadStatus) {
        if(!threadStatus){
            this.numberOfReport++;
        }
        this.threadStatus = threadStatus;
    }
    
    public void addComment(Comment comment){
        this.commentList.add(comment);
    }

    public ArrayList<Comment> getCommentList() {
        return commentList;
    }

    public String getThreadID() {
        return threadID;
    }
    
    
    
    public boolean getThreadStatus(){
        return this.threadStatus;
    }

    public int getNumberOfReport() {
        return numberOfReport;
    }
    
    
    public String printThread(int current, int total){
        return "\nThread ID : " + this.threadID
                + "                 Thread Number : " + (current+1) + "/" + total
                + "\n\nPost By : " + this.user.getRealName()
                + "\nThread Title : " + this.threadTitle
                + "\n\nContent : \n" + this.threadDescription
                + "\n\nDate Posted : " + this.datePosted
                + "\nTotal Comment: " + this.commentList.size();
    }
    
//    @Override
//    public String toString() {
//        
//    }
    
    
    
    
    
}
