/*
Important!!!
All validation below is coded like this :

            boolean valid;
            String choice;
            do {                
                ***** Here is you Menu Interface *****
                choice = scanner.nextLine();
                ***** The 2 is the highest number of your menu selection *****
                ***** validation function will eliminate other option, created by CHUN HENG *****
                valid = validation(choice, 2);
            } while(!valid);
            
            ***** Here is convert user choice into integer for switch statement *****
            
            int userChoice = Integer.parseInt(choice);
            switch(userChoice){
                  case 1:
                      tutorForum();
                      break;
                  case 2:
                      // return to last Menu
                      System.exit(0);
                      break;
           }

*/
package Main;

import Classes.*;
import Classes.Learner;
import static Main.Menus.selectedLearner;
import Modules.ForumModuleMain;
import static Modules.ForumModuleMain.*;
import Modules.OnlineAssessmentModule;
import Modules.RegisterCourseModule;
import Modules.RegisterModule;
import static Modules.TheadMenuMain.threadMenu;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainPage {
    public static Scanner scanner = new Scanner(System.in);
    public static Database database = new Database();

    public static void main(String[] args) {

        database.addData();
       
        startUp();        
  
        //---------------------testing thread here---------------------
        //printThread();
    }
    
    public static void startUp(){
        boolean valid;
        boolean exit= false;
        do{
            String choice;
            do {
                Menus.startUp();
                choice = scanner.nextLine();
                valid = validation(choice, 3);
            } while(!valid);
            
            int userChoice = Integer.parseInt(choice);
            switch(userChoice){
                  case 1:
                      String role = Menus.Login();
                      if(role.equals("Student")){
                          
                          learnerMenu();
                      }
                      
                      else if(role.equals("Admin")){
                          
                          staffMenu();
                          
                      }
                      
                      else if(role.equals("Tutor")){
                      
                          tutorMenu();
                          
                      }
                      
                      else{
                          Menus.startUp();
                      }
                      
                      break;
                 
                   
                  
                  case 2:
                      // return to last Menu
                      database.currentUser = null;
                      database.currentLearner = null;
                      database.userID = null;
                      RegisterModule.registerLearner();
                      
                      
                  case 3:
                  System.exit(0);   
                  exit = true;
                      
           }
            
        }while (exit == false);
    }
    
    public static void staffMenu(){
        boolean exit = false;
        do{
        Menus.staffMenu();
        
        String choice = scanner.nextLine();
        
        if(choice.equals("1")){
            OnlineAssessmentModule.assignTutor();
        }
        
        else if(choice.equals("2")){
            RegisterModule.registerTutor();
            
        }
        
        else if(choice.equals("3")){
            OnlineAssessmentModule.assignmentReportAdmin();
        }
        else if(choice.equals("4")){
                Menus.addPaymentbill();
        }   
        else if(choice.equals("5")){
                 for (int i = 0 ; i < Database.learner.size() ; i++)
         {
             System.out.println(i + ".\t" +Database.learner.get(i).getStudentID()+ "\t" +Database.learner.get(i).getUserName() );
          }
         Scanner s =new Scanner(System.in);
         System.out.println("Select learner to process");
         int choice23 = s.nextInt();
         Learner selectedLearner = Database.learner.get(choice23);//validate
         
         String blank =s.nextLine();
         Menus.viewStudentBill(selectedLearner);

        }
        else if (choice.equals("6")){
         Menus.makeAnnouncement();
        }
        else if(choice.equals("7")){
            database.currentUser = null;
            exit =true;
        }
        
        else{
            //staffMenu();
        }
        
        }while (exit ==false);
    }
    
    
      public static void tutorMenu(){
            boolean valid;
            boolean exit =false;
            
            String choice;
            do{
            do {                
                Menus.tutorMenu();
                choice = scanner.nextLine();
                valid = validation(choice, 5);
            } while(!valid);
            
            int userChoice = Integer.parseInt(choice);
            switch(userChoice){
                  case 1:
                      ForumModuleMain.tutorForum();
                      break;
                  case 2:
                      OnlineAssessmentModule.markAssignment();
                      break;
                  case 3:
                      OnlineAssessmentModule.assignmentReport();
                      break;
                  case 4:
                      Menus.makeAnnouncement();
                      break;
                  case 5:
                      // return to last Menu
                      database.currentUser = null;
                      exit = true;
                      break;
           }
            }while (exit ==false);
      }
      
      public static void learnerMenu(){
          boolean exit =false ;
          do{
          Menus.learnerMenu();
          String choice = scanner.nextLine();
        
        
         if(choice.equals("1")){
            OnlineAssessmentModule.OnlineAssessment();
        }
         
         else if(choice.equals("2")){
             ForumModuleMain.tutorForum();
         }
         
         else if(choice.equals("3")){
             RegisterCourseModule.RegisterCourseMenu();
         }
        
         else if(choice.equals("4")){
             database.currentUser = null;
             exit= true;
         }
        
         else
        {
               System.out.println("Invalid input. Please enter 1,2,3 or 4.");
               //learnerMenu();
        }
      } while(exit == false);
          }
      
      
      public static boolean validation(String choice, int max){
        if(choice.matches("-?\\d+") && (Integer.parseInt(choice) <= max && Integer.parseInt(choice) >= 1)){
            return true;
        }else{
            System.out.println("Wrong Input!");
        }
        return false;
    }
     
}
