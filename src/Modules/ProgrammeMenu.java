/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

import Classes.Course;
import Classes.Programme;
import Classes.RegisteredCourse;
import Main.Database;
import static Main.MainPage.database;
import static Main.MainPage.validation;
import Main.Menus;
import static Modules.RegisterCourseModule.validation1;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ProgrammeMenu {
    public static Scanner scanner = new Scanner(System.in);
    private static int userIndex;
    private static int uc;
    
    
    
    public static void getLearner(){
        for(int i = 0 ; i < database.learner.size() ; i++){
            if(database.learner.get(i).getStudentID().equals(database.userID)){
                userIndex = i;
                break;
            }
            else{
                
            }
        }
    }
    
    public static void printProgramme(){

        Menus.logo();
        System.out.println("Programme : ");
        int count=1;
        for (Programme pgm : database.programmeList){
            
            System.out.println(count +") "+pgm.getProgrammeCode() + " " + pgm.getProgrammeName());
            count++;
        }
        programMenu();
    }
    

    public static void programMenu(){
        boolean valid;
        String input;
        String choice;
            do {    
                System.out.println(" ");
                System.out.println("1. View More about course");
                System.out.println("2. Back to previous page");
                System.out.println("(Please enter the value 1 OR 2.)");
                System.out.print(">>");
                choice = scanner.nextLine();
                valid = validation1(choice, 2);

            } while(!valid);
            
            int userChoice1 = Integer.parseInt(choice);
            switch(userChoice1){
                  case 1:
                       do {                
                
                            System.out.print("\nPlease enter the number of the Programme (1 ~"+ database.programmeList.size()+ ")"+": ");
                            input = scanner.nextLine();
                            valid = validation2(input,database.programmeList.size());

                            } while(!valid);
                            int userChoice = Integer.parseInt(input);
                            uc = userChoice -1;
                      break;
           
                  case 2:
                      RegisterCourseModule.RegisterCourseMenu();             
                      break;
           }
        
           
                
            
                
                        System.out.println("\n=========================================================================");
                        System.out.println("        Programme Title: "+ database.programmeList.get(uc).printTitle());
                        System.out.println("=========================================================================");
                System.out.println("Description:\n");      
                System.out.println(database.programmeList.get(uc).getProgrammeDescription());
                
                
                System.out.println("Courses: ");
                for (Course pgmcourse: database.programmeList.get(uc).getCourse()){
                    System.out.println(" * "+pgmcourse.getCourseID() + " " + pgmcourse.getCourseName() + " * ");
                }
                
                System.out.println("                                                    ----------------");
                System.out.println("                                         Total Fee:   " + calPrice());
                System.out.println("                                                    ----------------");

                enrollment();
    }
    
    public static String calPrice(){
        double total=0;
        DecimalFormat formatter = new DecimalFormat("RM ###,###,###.00");
        for (Course pgm: database.programmeList.get(uc).getCourse()){
            total += pgm.printPrice();
            
            
        }        
        return formatter.format(total);
    }
    
    private Object RegisterCourse;
    
            
            
    
     
    
    public static void enrollment(){
        boolean valid;
        String choice;
        
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
                Scanner scan = new Scanner(System.in);
                System.out.println("\n1.Enrollment    2. Back to Programme Menu ");
                System.out.print(">> ");
                choice = scan.nextLine();
                valid = validation(choice, 2);

                } while(!valid);
                int userChoice = Integer.parseInt(choice);
                switch(userChoice){
                    
                    case 1:
                        Menus.logo();
                        System.out.println("\t    REGISTER PROGRAMME");
                        System.out.println("======================================");
                        System.out.println("Register Programme Name: (" 
                            + database.programmeList.get(uc).getProgrammeCode()+ ")"+database.course.get(uc).getCourseName());

                      break; 
                    case 2:
                        printProgramme();
                    }
            }
            else{
                System.out.println(" ");
                System.out.println("**You are already register for this programme.**");
                System.out.print("Press any key back to menu ^.^ : ");
                String inputs = scanner.nextLine();
                System.out.println(" ");
                
                    printProgramme();
            }      
    }
 
        public static void printRegisterPage(){
        boolean valid;
        String choice;
        String input;
          
            do {                
                System.out.println("\nPlease select yours intake month: ");
                    System.out.println("1. January      2. May      3. October");

                    System.out.print(">>");
                    choice = scanner.nextLine();
                    valid = validation1(choice, 3);
   
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

                for (Course pgmcourse: database.programmeList.get(uc).getCourse()){
                    
                    RegisteredCourse newRC = new RegisteredCourse(pgmcourse);
                    Database.learner.get(userIndex).addRegisteredCourse(newRC); 
                }

                
                Menus.logo();
                successful();
                
            }
            else{ 
               
            }
            
            System.out.println(" ");
            System.out.print("Press any key back to menu ^.^ : ");
            scanner.nextLine();
            String inputs = scanner.nextLine();
            System.out.println(" ");
            
            printProgramme();
               
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
       
    
       public static boolean validation2(String input, int max){
        if(input.matches("-?\\d+") && (Integer.parseInt(input) <= max && Integer.parseInt(input) >= 1) ){
            return true;
        }
        else
            System.out.println("\nINVALID INPUT, ENTER THE VALUE of 1~"+ database.programmeList.size()+" only!");
        
        return false;
        
    }
   
}
