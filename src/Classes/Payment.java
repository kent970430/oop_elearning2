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
public class Payment {
    private String paymentID;
    private boolean status;
    private double amount;
    private ArrayList<RegisteredCourse> CourseReg = new ArrayList <RegisteredCourse>();

    public Payment(String paymentID,RegisteredCourse CourseReg) {
            this.paymentID = paymentID;
        this.status =false;
        this.CourseReg.add(CourseReg);
        this.amount = 0 ;
      
            amount += CourseReg.getCourse().printPrice();
            
        
    }

    public Payment(String paymentID,ArrayList<RegisteredCourse> CourseReg) {
        this.paymentID = paymentID;
        this.status =false;
        this.CourseReg = CourseReg;
        this.amount = 0 ;
        for (RegisteredCourse x : CourseReg){
            amount += x.getCourse().printPrice();
            
        }
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public boolean getStatus(){
        return status;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void paybill() {
        this.status = true;
    }
    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }
    
    @Override
    public String toString(){
        return paymentID + "\t" + amount + "\t" + status ;//lun
    }
    
    
    
}
