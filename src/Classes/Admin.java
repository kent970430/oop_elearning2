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
public class Admin extends User{
     private String adminID;
    private String adminStatus;

    public Admin() {
    }

    public Admin(String userName, String password,String status,String adminID, String adminStatus, String realName) {
        super(userName,password,status,realName);
        this.adminID = adminID;
        this.adminStatus = adminStatus;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }
    
    
    
}
