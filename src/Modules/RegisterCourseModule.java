/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

import Classes.Course;
import Classes.CourseSchedule;
import Classes.Programme;
import Classes.RegisteredCourse;
import Main.Database;
import Main.MainPage;
import static Main.MainPage.database;
import static Main.MainPage.scanner;
import static Main.MainPage.startUp;
import static Main.MainPage.validation;
import Main.Menus;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class RegisterCourseModule {
        public static Scanner scanner = new Scanner(System.in);
        private static int uc;
        private static int userIndex;
        
    public RegisterCourseModule() {
    }

    public static int getUc() {
        return uc;
    }
    

    public static void RegisterCourseMenu(){
        
        for (int i=0;i<database.learner.size();i++){
            if(database.learner.get(i).getStudentID().equals(database.userID)){
                userIndex = i;
                break;
            }
            else{
                
            }
        }
        
        boolean valid;
        String choice;
        Menus.logo();
        do {   
               System.out.println("1. View Course");
               System.out.println("2. View Programme");
               System.out.println("3. Back to Menu");
               System.out.println("Please enter the number from 1 To 3.");
               System.out.print(" >> ");
               choice = scanner.nextLine();
               valid = validation1(choice, 3);
                   
               
        } 
        while(!valid);
        
//            if (!valid){
//        
//                System.out.println(" ");
//                System.out.println("*Wrong Input! You only can enter value from 1 To 3.*");
//                System.out.println(" ");
//            }
               
        
            int userChoice = Integer.parseInt(choice);
            switch(userChoice){
                
                  case 1:
                      printCourse();
                      break;
           
                  case 2:
                        ProgrammeMenu.printProgramme();
                      break;
                      
                  case 3:
                      Menus.learnerMenu();
                      break;
            }
     }
         

    public static void printCourse(){
        boolean valid;
        String choice;
        
        Menus.logo();
        
        for (int i=0 ; i<database.course.size() ; i++){
            
            System.out.println((i+1) +") "+database.course.get(i).getCourseID() + " " + database.course.get(i).getCourseName());
        }
        
        do {    
                System.out.println(" ");
                System.out.println("1. View More about course");
                System.out.println("2. Back to previous page");
                System.out.println("(Please enter the value 1 OR 2.)");
                System.out.print(">>");
                choice = scanner.nextLine();
                valid = validation1(choice, 2);

            } while(!valid);
            
            int userChoice = Integer.parseInt(choice);
            switch(userChoice){
                  case 1:
                      showCourseDetails();
                      
                      break;
           
                  case 2:
                      RegisterCourseMenu();             
                      break;
           }
            
        }
        
        public static void getIntakeDate(){
            String myFormatString = "dd MMM yyyy";
            SimpleDateFormat df = new SimpleDateFormat(myFormatString);
            Date current = new Date();
            int count=1;
            
            for(CourseSchedule cs : database.course.get(uc).getCsList()){
            long nextDate = cs.getStartDate().getTime();
            Date date2= new Date(nextDate);
            
                if (date2.after(current)){
                    System.out.println(count+ ")"+df.format(date2));
                    count++;
                }
                else{
                    
                }
        
            }
        }
        
    
        public static void showCourseDetails()  {
        
        boolean valid;
        String choice;
        String choice2 = "";
        
         DecimalFormat formatter = new DecimalFormat("RM ###,###,###.00");
            
            do {                
                System.out.println("Please enter the course Number:");
                System.out.println("(Please enter the value from 1 until " + database.course.size() + ")");
                System.out.print(">>");
                choice = scanner.nextLine();
                valid = validation1(choice, database.course.size());
                System.out.println(" ");
                
                System.out.println(" ");
                
            } while(!valid);
            int userChoice = Integer.parseInt(choice);
               uc = userChoice-1;
            
            System.out.println(database.course.get((uc)).printCourseDetails());
            System.out.println("\n\t\t\t                    Price: " +formatter.format(database.course.get(uc).printPrice()));     
            System.out.println("Intake: ");
            

            String myFormatString = "dd MMM yyyy";
            SimpleDateFormat df = new SimpleDateFormat(myFormatString);
            Date current = new Date();
            int count=1;
            
            for(CourseSchedule cs : database.course.get(uc).getCsList()){
            long nextDate = cs.getStartDate().getTime();
            Date date2= new Date(nextDate);
            
                if (date2.after(current)){
                    System.out.println(count+ ")"+cs.getCourseSchedule());
                    count++;
                }
                else{
                    
                }
        
            }
            
          
            
            //--------------------------------------Enrollment-------------------------------------------
            boolean validity123 = true;
            
            for(RegisteredCourse rc2 : database.learner.get(userIndex).getRegisteredCourse()){
                if(rc2.getCourse().getCourseName().equals(database.course.get((uc)).getCourseName())){
                    if(rc2.getStatus().equals("Enroll") || rc2.getStatus().equals("Pass")){
                        validity123 = false;
                        break;
                    }
                }
                else{
                    validity123=true;
                }
      
            }
            
            if(validity123 == true){
                do {                
                    System.out.println("\n 1. Enrollment \t 2. Back to Menu");
                    System.out.print(">>");
                    choice2 = scanner.nextLine();
                    valid = validation1(choice2, 2);
                  
                } 
                while(!valid);
            }
            else{
                System.out.println(" ");
                System.out.println("**You are already register for this course.**");
                System.out.print("Press any key back to menu ^.^ : ");
                String inputs = scanner.nextLine();
                System.out.println(" ");
                
                    RegisterCourseMenu();
            }
           
            
            int choices = Integer.parseInt(choice2);          
            if (choices == 1){
                
                Menus.logo();
                System.out.println("\t    REGISTER COURSE");
                System.out.println("======================================");
                System.out.println("Register Course Name: " 
                        + database.course.get(uc).getCourseID()+ " "+database.course.get(uc).getCourseName());
                
                printRegisterPage();
            }              
            else 
                printCourse();
            
        }  
        
        
        public static void printRegisterPage(){
        boolean valid;
        String choice;
        String input;
          
            do {                
                System.out.println("\nPlease select the start date: ");
                
                getIntakeDate();
                    System.out.println(" (You can only enter the value from 1 To " + database.course.get(uc).getCsList().size() +")" );
                    System.out.print(">>");
                    choice = scanner.nextLine();
                    valid = validation1(choice, database.course.get(uc).getCsList().size());
   
            } 
            while(!valid);
            do {
                System.out.println("1. Confirm to register \t 2. Cancel register");
                input =scanner.nextLine();
                valid = validation1(input, database.course.get(uc).getCsList().size());
            } 
            while(!valid);
            
            int userchoice = Integer.parseInt(input);
            if (userchoice == 1){

                RegisteredCourse newRC = new RegisteredCourse(database.course.get(uc)); //get the value that user had input
                database.learner.get(userIndex).addRegisteredCourse(newRC); // Store the registered course into the database for first student
                //newRC.setStatus("Enroll");
                Menus.logo();
                successful();
                
            }
            else{ 
                printCourse();
            }
            
            System.out.println(" ");
            System.out.print("Press any key back to menu ^.^ : ");
            scanner.nextLine();
            String inputs = scanner.nextLine();
            System.out.println(" ");
            
            RegisterCourseMenu();    
           }
        
        public static void successful(){
        System.out.println("| ======================================================== |");
        System.out.println("|      You are Succsessfully register for the course :     |" );
        System.out.println("|      "+database.course.get(uc).getCourseID()+ " "+database.course.get(uc).getCourseName());
        System.out.println("|                              //                          |");
      System.out.println("|                         \\\\  //                           |");
      System.out.println("|                          \\\\//                            |");
        System.out.println("|                           VV                             |");
        System.out.println("| ======================================================== |\n");
    }
        
        
        public static boolean validation1(String choice, int max){
            if(choice.matches("-?\\d+") && (Integer.parseInt(choice) <= max && Integer.parseInt(choice) >= 1)){
                return true;
            }
            else 
                System.out.println(" ");
                System.out.println("WRONG INPUT! Please enter the valid integer follow by the instruction!");
                System.out.println(" ");
            return false;
        
        }
        
        
}
        
        
        
    
        

