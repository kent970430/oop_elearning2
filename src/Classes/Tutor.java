/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author ochen
 */
public class Tutor extends User{
    private String tutorID;
    private String tutorStatus;

    public Tutor() {
    }

    public Tutor(String userName, String password,String status,String tutorID, String tutorStatus, String realName) {
        super(userName,password,status,realName);
        this.tutorID = tutorID;
        this.tutorStatus = tutorStatus;
    }

    public String getTutorID() {
        return tutorID;
    }

    public String getTutorStatus() {
        return tutorStatus;
    }

    public void setTutorID(String tutorID) {
        this.tutorID = tutorID;
    }

    public void setTutorStatus(String tutorStatus) {
        this.tutorStatus = tutorStatus;
    }
    
    
    
    
    
    
}
