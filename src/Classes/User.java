/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author kueky
 */
public class User {
    // this is the real name of user not login username
    private String userName;
    private String password;
    private String status;
    private String realName;

    public User() {
    }

    public User(String userName, String password, String status, String realName) {
        this.userName = userName;
        this.status = status;
        this.password = password;
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public String getRealName() {
        return realName;
    }
    
    

    public String getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
      
}
