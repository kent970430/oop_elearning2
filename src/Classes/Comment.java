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
public class Comment {
    private String commentID;
    private Date datePosted;
    private boolean commentStatus = true;
    private int numberOfReport = 0;
    private String commentContent;
    private User user;
    private ArrayList<Comment> commentList;

    public Comment() {
    }

    public Comment(String commentContent, User user, Thread selectedThread) {
        int index = selectedThread.getCommentList().size();
        String thread = selectedThread.getThreadID();
        this.commentID = thread +"C" + (index + 1);
        Date today = Calendar.getInstance().getTime();
        this.datePosted = today;
        this.commentContent = commentContent;
        this.user = user;
        this.commentList = new ArrayList<>();
    }
    
    public Comment(String commentContent, User user, Comment selectedComment) {
        int index = selectedComment.getCommentList().size();
        String thread = selectedComment.getCommentID();
        this.commentID = thread +"C" + (index + 1);
        Date today = Calendar.getInstance().getTime();
        this.datePosted = today;
        this.commentContent = commentContent;
        this.user = user;
        this.commentList = new ArrayList<>();
    }
    
     public String printThread(int current, int total){
        return "\nComment ID : " + this.commentID
                + "                 Comment Number : " + (current+1) + "/" + total
                + "\n\nPost By : " + this.user.getRealName()
                + "\n\nContent : \n" + this.commentContent
                + "\n\nDate Posted : " + this.datePosted
                + "\nTotal Comment: " + this.commentList.size();
    }

    public void setCommentStatus(boolean commentStatus) {
        this.commentStatus = commentStatus;
    }

    public ArrayList<Comment> getCommentList() {
        return commentList;
    }

    public String getCommentID() {
        return commentID;
    }
    
    public void addComment(Comment comment){
        this.commentList.add(comment);
    }
    
    
    
     
     
}
