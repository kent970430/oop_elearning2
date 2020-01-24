/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

import Classes.*;
import Classes.Learner;
import Main.MainPage;
import static Main.MainPage.database;
import static Main.Menus.logo;
import Modules.ForumModuleMain;
import static Modules.ForumModuleMain.*;
import Modules.OnlineAssessmentModule;
import Modules.RegisterModule;
import static Modules.TheadMenuMain.threadMenu;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author taruc
 */
public class RegisterModule {
    
    public static void registerLearner(){
        boolean same = false;
        String username;
        String studentID = database.learner.get((database.learner.size()-1)).getStudentID();
        String studentID1 = studentID.substring(5);
        int id = Integer.parseInt(studentID1);
        String newID;
        
        if(id < 10){
            newID = "18WMR000" + (id+1);
        }
        else if(id < 100)
        {
            newID = "18WMR00" + (id+1);
        }
        else
        {
            newID = "18WMR0" + (id+1);
        }
        
        do{
            
        same = false;
        logo();
        
        
        System.out.println("Student ID : " + newID);
        System.out.print("Username   : ");
        username = scanner.nextLine();
        
        for(int i=0; i<database.learner.size() ; i++){
            if(database.learner.get(i).getUserName().equals(username)){
                System.out.println("Username taken. Please choose another username.");
                same = true;
            
            }
        }
        }while(same == true);
        
        System.out.print("Password   : ");
        String password = scanner.nextLine();
        
        System.out.print("Full Name  : ");
        String fullName = scanner.nextLine();
        
        
        System.out.print("\nAre you sure you want to register? (Y/N) >> ");
        String choice = scanner.nextLine();
        
        if(choice.equals("y") || choice.equals("Y")){
            
            Learner l = new Learner(newID,username,password,"Learner",fullName);
            database.learner.add(l);
            MainPage.startUp();
            
        }
        
        else if(choice.equals("n") || choice.equals("N")){
       
            MainPage.startUp();
      
        }
    }
    
    public static void registerTutor(){
        boolean same = false;
        String tutorID = database.tutor.get((database.tutor.size()-1)).getTutorID();
        String tutorID1 = tutorID.substring(1);
        int id = Integer.parseInt(tutorID1);
        String newTutorID;
        String username;
        
        do{
            same = false;
        logo();
        
        if(id < 10){
            newTutorID = "T100" + (id + 1);
        }
        else if(id < 100){
            newTutorID = "T10" + (id + 1);
        }
        else{
            newTutorID = "T1" + (id + 1);
        }
        
        System.out.println("Tutor ID   : " + newTutorID);
        System.out.print("Username   : ");
        username = scanner.nextLine();
        
        for(int i=0; i<database.tutor.size() ; i++){
            if(database.tutor.get(i).getUserName().equals(username)){
                System.out.println("Username taken. Please choose another username.");
                same = true;
            
            }
        }
        
        }while(same==true);
        System.out.print("Password   : ");
        String password = scanner.nextLine();
        
        System.out.print("Full Name  : ");
        String fullName = scanner.nextLine();
        
        
        System.out.print("\nAre you sure you want to register? (Y/N) >> ");
        String choice = scanner.nextLine();
        
        if(choice.equals("y") || choice.equals("Y")){
            Tutor t = new Tutor(username,password,"Tutor",newTutorID,"Available", fullName);
            database.tutor.add(t);
            MainPage.staffMenu();
            
        }
        
        else if(choice.equals("n") || choice.equals("N")){
       
            MainPage.staffMenu();
      
        }
        
        
    }
}
