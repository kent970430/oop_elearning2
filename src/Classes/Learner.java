/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author ochen
 */
public class Learner extends User{
    private String studentID;
    private Programme programme;
    private ArrayList<RegisteredCourse> registeredCourse = new ArrayList<>();
    private ArrayList<Payment> payment = new ArrayList<> ();//lun
    

    public Learner(String studentID,String userName, String password, String status, String realName) {
         super(userName,password,status,realName);
        this.studentID = studentID;
       
    }
    
    public void addPayment(Payment payment){
        this.payment.add(payment);//lun for admin only
    }
    
    public void addRegisteredCourse(RegisteredCourse registeredCourse){
        this.registeredCourse.add(registeredCourse);
    }
    
    public void setProgramme(Programme programme){
        this.programme = programme;
    }

    public String getStudentID() {
        return studentID;
    }

    public ArrayList<RegisteredCourse> getRegisteredCourse() {
        return registeredCourse;
    }
    
    public ArrayList<Payment> getPayment() {
        return payment;
    }
    @SuppressWarnings("empty-statement")
     public void  ViewBill(){//lun
        int counter= 1;
        for(Payment x : payment){
            System.out.println(counter + "\t"+x.getPaymentID()+"\t" +x.getAmount() + "\t" + x.getStatus());                   ;
         counter++;   
        }
    }
    
}
