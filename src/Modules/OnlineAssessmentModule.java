    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
1.Ask tutor confirmation when giving marks
2.Tutor can check report only marked by her
*/
package Modules;
import Classes.Announcement;
import Classes.Course;
import Classes.AssignmentSubmitted;
import Classes.Assignment;
import static Main.Database.noti;
import java.text.ParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Main.MainPage.database;
import Main.MainPage;
import Main.Menus;
import static Main.Menus.logo;
/**
 *
 * @author ochen
 */
public class OnlineAssessmentModule {
    
    public static Scanner scanner = new Scanner(System.in);
    public static int userIndex;
    
    public static void OnlineAssessment(){
        String selection;
        boolean check = true;
        
        do{
        Menus.logo();
        
        check = true;
        System.out.println(" Select course : ");
       
        for(int i = 0 ; i < database.learner.size() ; i++){
            if(database.learner.get(i).getStudentID().equals(database.userID)){
                userIndex = i;
                break;
            }
            else{
                
            }
        }
        
        for(int i = 0; i < database.learner.get(userIndex).getRegisteredCourse().size(); i++){
            System.out.println((i+1) + ". " + database.learner.get(userIndex).getRegisteredCourse().get(i).getCourse().getCourseID() + " - " + database.learner.get(userIndex).getRegisteredCourse().get(i).getCourse().getCourseName());
        }
        
        int exitno = (database.learner.get(userIndex).getRegisteredCourse().size() + 1);
        System.out.println(exitno + ". Exit");
        System.out.print(" >> ");
        selection = scanner.nextLine();

        if(selection.equals(Integer.toString(exitno))){
          
        }
        
        else
        {
            if(selection.matches("-?\\d+"))
           {
                if(Integer.parseInt(selection) > database.learner.get(userIndex).getRegisteredCourse().size())
                {
                 System.out.println("Wrong input please enter again.");
                 check = false;
                }
                
                else
                {
                    OnlineAssessmentMenu(selection);
                }
           
           }
           else
           {
                    System.out.println("Wrong input please enter again.");
                    check = false;
           }
        }
        
        
        
        
        
        }while(check == false);
        
        
    
        }
    
    public static void OnlineAssessmentMenu(String selection)
    {
        boolean check = true;
        do{
         try 
         {
             check = true;
             logo();
            int ccourse = (Integer.parseInt(selection) - 1);
            System.out.println(database.learner.get(userIndex).getRegisteredCourse().get(ccourse).getCourse().getCourseID() + " - " + database.learner.get(userIndex).getRegisteredCourse().get(ccourse).getCourse().getCourseName());
            System.out.println(" 1. View assignment details ");
            System.out.println(" 2. Submit assignment");
            System.out.println(" 3. View assignment marks");
            System.out.println(" 4. Print receipt ");
            System.out.println(" 5. Back");
            System.out.print(" >> ");
            String choice = scanner.nextLine();


            if(choice.equals("1")){
                
                AssignmentDetails(ccourse);
                
            }

            else if(choice.equals("2")){
                
                submitAssignment(ccourse);

            }
            
            else if(choice.equals("3")){
                
                viewAssignmentMarks(ccourse);

            }
            
            else if(choice.equals("4")){
                printReceipt(ccourse);
            }
            
            else if(choice.equals("5")){
                  //OnlineAssessment();
            }
            
            else
            {
                System.out.println("Invalid input. Please enter again");
                check = false;
            }
       
         }
         
         catch(ArrayIndexOutOfBoundsException exception) 
         {
             System.out.println("Wrong course.");
             OnlineAssessment();
         }
         
        }while(check == false);
           
    }
    
    public static void AssignmentDetails(int ccourse)
    {
        logo();
        if(database.learner.get(userIndex).getRegisteredCourse().get(ccourse).getCourse().getAssignment() == null)
        {
            System.out.println("Assignment not available yet. Please check back later.");
            System.out.println("Press any key to exit..");
                
            String dummy = scanner.nextLine();
    
            int selection = ccourse + 1;
        
            OnlineAssessmentMenu(Integer.toString(selection));
            
        }
        
        else{
        
        System.out.println("Assignment Details - " + database.learner.get(userIndex).getRegisteredCourse().get(ccourse).getCourse().getCourseID() + " " + database.learner.get(userIndex).getRegisteredCourse().get(ccourse).getCourse().getCourseName());
                
        System.out.println("\n" + database.learner.get(userIndex).getRegisteredCourse().get(ccourse).getCourse().getAssignment().getAssignmentDescription());
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = new Date();
        date = database.learner.get(userIndex).getRegisteredCourse().get(ccourse).getCourse().getAssignment().getDeadline();
        
        System.out.println("\nDeadline : " + formatter.format(date));
           
        System.out.println("Press any key to exit..");
                
        String dummy = scanner.nextLine();
    
        int selection = ccourse + 1;
        
        OnlineAssessmentMenu(Integer.toString(selection));
        }
        
    }
    
    public static void submitAssignment(int course)
    {
        logo();
        boolean yesno = false;
        boolean check10 = false;
        boolean check11 = false;
        int i=0;
        for(int j=0; j < database.submitted.size() ; j++)
       {
           
           try{
           if(database.submitted.get(j).getLearner().getStudentID().equals(database.userID) && database.submitted.get(j).getAssignment().getAssignmentID().equals(database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getAssignmentID())
                   && database.submitted.get(j).getDateSubmitted()!=null && database.submitted.get(j).getLearner().getStudentID().equals(database.userID)){
               
               yesno = true;
               i = j;
               
               
           }
           }
           catch(NullPointerException e){}
       }
        
        if(yesno == false){
            
            submitAssignmentYes(course);
        }
        
        //System.out.print(yesno);
        else{
            
            // ================================================================NEW========================================
            if(database.submitted.get(i).getMarks() <= 100 && database.submitted.get(i).getMarks() > 0){
                
                
                check10 = true;
                
            }
            
            if(check10 == true)
            {
                System.out.println("Marks has been given to your assignment. You can't submit again.");
                System.out.println("\nPress any key to continue");
                String sasdjasdd = scanner.nextLine();
                
                int selection = course + 1;
                OnlineAssessmentMenu(Integer.toString(selection));
            }
            
            else
            {
                check11 = false;
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                Date date = new Date();
                date = database.submitted.get(i).getDateSubmitted();
                
                do{
               System.out.println("You have submitted the assignment on " + formatter.format(date));
               System.out.print("Do you wish to resubmit and overwrite your current assignment? (Y/N) > ");
               String yesno1 = scanner.nextLine();
               if(yesno1.equals("N") || yesno1.equals("n"))
               {
                   check11 = true;
                   int selection = course + 1;
                   OnlineAssessmentMenu(Integer.toString(selection));   
               }
               
               else if(yesno1.equals("Y") || yesno1.equals("y"))
               {
                   check11 = true;
                   database.submitted.remove(i);
                   logo();
                   submitAssignmentYes(course);
                
               }
               
               else
               {
                   check11 = false;
               }
                }while(check11 == false);
            }
            
        }
        
        
    }
    
    public static void submitAssignmentYes(int course){
        
                System.out.println(database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getAssignmentID());
                System.out.println(database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getAssignmentDescription());
                System.out.println("--------------------------------------------------");
                try{
                    for(int d=0; d < database.submitted.size() ; d++){
                        if(database.submitted.get(d).getComment().equals("draft") && database.submitted.get(d).getLearner().getStudentID().equals(database.userID) && 
                                database.submitted.get(d).getAssignment().getAssignmentID().equals(database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getAssignmentID())){
                            System.out.println("Previous Draft :"); 
                            System.out.println(database.submitted.get(d).getContent());
                        }

                    }
                }
                catch(IndexOutOfBoundsException e){}

                boolean checkEmpty = false;
                String answer = "";
                do{
                    checkEmpty = false;
                System.out.println("Answer :");

                
                Scanner keyboard = new Scanner(System.in);
                String line;
                while (keyboard.hasNextLine()) {
                    line = keyboard.nextLine();
                    if (line.isEmpty()) {
                        break;
                    }
                    answer += line + "\n";
                }
                
                if(answer.equals(""))
                {
                    System.out.println("Cannot submit empty answer.");
                    checkEmpty = true;
                }
                
                }while(checkEmpty == true);

                boolean check = true;
                do{
                System.out.println("Do you wish to submit now or save as draft?");
                System.out.println("WARNING: After exit you can't make any new changes to it.");
                System.out.println("1. Submit");
                System.out.println("2. Save as draft");
                System.out.println("3. Exit");
                System.out.print(">> ");
                String choice = scanner.nextLine();

                if(choice.equals("1")){
                    for(int j=0; j < database.submitted.size() ; j++){
                        if(database.submitted.get(j).getLearner().getStudentID().equals(database.userID) && database.submitted.get(j).getAssignment().getAssignmentID().equals(database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getAssignmentID())){
                            database.submitted.remove(j);
                        }
                    }

                Date date = new Date();

                database.submitted.add(new AssignmentSubmitted(-1,database.currentLearner,date,null,answer,"",new Assignment(database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getAssignmentID(),database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getAssignmentDescription(),database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getDeadline(),0)));

                 int selection = course + 1;
                
                 OnlineAssessmentMenu(Integer.toString(selection));
                }

                else if(choice.equals("2")){
                boolean yesla = false; //To get if there's any submited draft before
                int k=0;
                for(int h=0; h < database.submitted.size() ; h++){
                    if(database.submitted.get(h).getLearner().getStudentID().equals(database.userID) && database.submitted.get(h).getAssignment().getAssignmentID().equals(database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getAssignmentID())
                            && database.submitted.get(h).getComment().equals("draft"))
                    {
                        yesla = true;
                        k=h;
                        break;
                    }
                }

                if(yesla == true)
                {
                    database.submitted.get(k).setContent(answer);
                }
                else
                {
                    database.submitted.add(new AssignmentSubmitted(-1,database.currentLearner,null,null,answer,"draft",new Assignment(database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getAssignmentID(),database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getAssignmentDescription(),database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getDeadline(),0)));
                }

                 int selection = course + 1;
                 
                 OnlineAssessmentMenu(Integer.toString(selection));   
                 check = true;
                }
                
                else if(choice.equals("3")){
                     int selection = course + 1;
                    
                     OnlineAssessmentMenu(Integer.toString(selection));   
                     check = true;
                }
                
                else
                {
                    System.out.println("Invalid input. Please enter again.");
                    check = false;
                }
                
                }while(check == false); 
    }
    
    public static void viewAssignmentMarks(int course){
        logo();
        boolean submitted = false;
        int j = -1;
        for(int k=0; k < database.submitted.size() ; k++)
       {
           try{
            
           if(database.submitted.get(k).getLearner().getStudentID().equals(database.userID) && database.submitted.get(k).getAssignment().getAssignmentID().equals(database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getAssignmentID())){
               
               submitted = true;
               j = k;
               break;
           }
       }
           catch(NullPointerException e){}
           
       }
        
        if(submitted == false){
            System.out.println("You have not submitted the assignment yet.");
            System.out.println("\nPress any key to continue");
            String andasds = scanner.nextLine();
            int selection = course + 1;
            OnlineAssessmentMenu(Integer.toString(selection)); 
        }
        
        else{
            boolean yesno = true;
       
           try{
            if(database.submitted.get(j).getLearner().getStudentID().equals(database.userID) && database.submitted.get(j).getAssignment().getAssignmentID().equals(database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getAssignment().getAssignmentID())
                    && database.submitted.get(j).getMarks() == -1){

                yesno = false;

            }
           }
           catch(NullPointerException e){}
       
        
                if(yesno == false){
                    System.out.println("Your assignment is still currently marking by the tutors. Please come back later.");
                    System.out.println("\nPress any key to continue");
                    String andasds = scanner.nextLine();
                    int selection = course + 1;
                    OnlineAssessmentMenu(Integer.toString(selection)); 
                }
                else{

                    System.out.println("\n"+database.submitted.get(j).getAssignment().getAssignmentID() + " " + database.course.get(j).getCourseName());
                    System.out.println(database.submitted.get(j).getAssignment().getAssignmentDescription());
                    System.out.println("-------------------------------------------------");
                    System.out.println(database.submitted.get(j).getContent());
                    System.out.println("\n");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Marks : " + database.submitted.get(j).getMarks());
                    if(database.submitted.get(j).getComment().equals("")){
                        System.out.println("\nPress any key to continue");
                        String andasds = scanner.nextLine();
                        int selection = course + 1;
                        OnlineAssessmentMenu(Integer.toString(selection)); 
                    }
                    else{
                    System.out.println("Comments : " + database.submitted.get(j).getComment());
                    System.out.println("\nPress any key to continue");
                    String andasds = scanner.nextLine();
                    int selection = course + 1;
                    OnlineAssessmentMenu(Integer.toString(selection)); 
                    }

                }
        }
        
    }
    
    public static void assignTutor(){
        
        boolean check1;
        do{
        boolean check = false;  //Check if got any submitted assignment
        check1 = true;
        logo();
        System.out.println("\tSubmitted Assignment");
        System.out.println("\t--------------------");
        
        int count = 0;
        
        ArrayList<AssignmentSubmitted> store = new ArrayList<AssignmentSubmitted>();
        
         for(int i=0; i < database.submitted.size() ; i++)
       {
           try{
           if(database.submitted.get(i).getTutor() == null && database.submitted.get(i).getMarks() == -1 && !database.submitted.get(i).getComment().equals("draft"))
           {
               store.add(database.submitted.get(i));
           }   
           }
           catch(NullPointerException e)
           {
               
           }
       }
        
        for(int i=0; i < store.size() ; i++)
       {
           if(store.get(i).getTutor() == null)
           {
               String name ="";
               String courseName="";
               
               for(int j=0; j<database.learner.size();j++)
               {
                   if(database.learner.get(j).getStudentID().equals(store.get(i).getLearner().getStudentID())){
                       name = database.learner.get(j).getRealName();
                       break;
                   }
               }
               
               for(int k=0; k<database.course.size();k++)
               {
                   if(store.get(i).getAssignment().getAssignmentID().equals(database.course.get(k).getCourseID())){
                       courseName = database.course.get(k).getCourseName();
                       break;
                   }
               }
               
               //System.out.println((i+1) + ". " + store.get(i).getAssignment().getAssignmentID() + " " + courseName +" - " + name + " " + store.get(i).getSubmittedAssignmentID());
               System.out.println((i+1) + ". " + store.get(i).getAssignment().getAssignmentID() + " " + courseName +" - " + name + " ");
               
               check = true;
           }   
       }
        
        if(check == false)
        {
            System.out.println("No assignment available. Press any key to go back.");
            String andasds = scanner.nextLine();
            
        }
            
        else
        {
            
                System.out.println((store.size() + 1) + ". Exit");

                System.out.print(" >> ");
                String choice = scanner.nextLine();

                int exit = store.size() + 1;

                if(choice.equals(Integer.toString(store.size() + 1)))
                {
                    
                }

                else
                {
                    int choice1 = 0;

                try
                {
                    choice1 = Integer.parseInt(choice);
                    choice1 --;
                }

                catch(NumberFormatException e)
                {
                    System.out.println("Invalid input.");
                    check1 = false;
                }
                
                if(check1 != false)
                {
                    if(choice1 <= store.size())
                    {
                    logo();
                    int countc=0;
                    System.out.println("Available Tutor");
                    System.out.println("---------------");

                    for(int i=0; i<database.course.size();i++){
                        
                        if(store.get(choice1).getAssignment().getAssignmentID().equals(database.course.get(i).getCourseID())){
                            countc = i;
                            for(int k=0; k<database.course.get(i).getTutor().size();k++){
                                
                                System.out.println((k+1) + ". " + database.course.get(i).getTutor().get(k).getTutorID() + " - " + database.course.get(i).getTutor().get(k).getRealName());
                                
                            }
                        }
                        
                    }
                    
                    int exitno = database.course.get(countc).getTutor().size() + 1;
                    System.out.println(exitno +". Exit");
                    
                    System.out.print("\n >> ");
                    String tutid = scanner.nextLine();
                    
                    if(tutid.equals(Integer.toString(exitno))){
                        
                    }
                    
                    else{
                        
                        int tutorid = 0;
                            try
                            {
                                tutorid = Integer.parseInt(tutid);
                                tutorid -= 1;
                            }

                            catch(NumberFormatException e)
                            {
                                
                                check1 = false;
                            }
                            
                            if(check1 != false)
                            {
                                if(tutorid >= database.course.get(countc).getTutor().size())
                                {
                                System.out.println("Invalid input. Please enter again.");
                                check1 = false;
                                }
                            
                                else
                                {
                                    
                                    
                                    store.get(choice1).setTutor(database.course.get(countc).getTutor().get(tutorid));
                                    
                                   

                                    for(int i=0; i < database.submitted.size() ; i++){

                                                if(database.submitted.get(i).getLearner().getStudentID().equals(store.get(choice1).getLearner().getStudentID())
                                                        && database.submitted.get(i).getAssignment().getAssignmentID().equals(store.get(choice1).getAssignment().getAssignmentID()))
                                                {
                                                    database.submitted.set(i, store.get(choice1));
                                                    
                                                    

                                                }   
                                      }
                                    
                                    System.out.println(database.submitted.get(1).getTutor().getTutorID());
                                    

                                    noti.add(new Announcement("Tutor","tutor","NOTE : Mark Assignment."));
                                    store.clear();
                                    assignTutor();
                                }
                            }
                            
                            else
                            {
                                System.out.println("Invalid input. Enter again.");
                            }
                            
                    }
                    }

                 else
                {
                       System.out.println("Invalid input. Please reenter");
                       check1 = false;
                }
                }                
            }
        }
        }while(check1 == false);
    }
    
    public static void markAssignment(){
        
        boolean check1;
        do{
        logo();
        boolean check = false;
        check1 = true;
        int count = 0;
        
        ArrayList<AssignmentSubmitted> store = new ArrayList<AssignmentSubmitted>();
        
        try{
            for(int i=0; i < database.submitted.size() ; i++)
       {
//           System.out.println("HI");
//           System.out.println(database.submitted.get(1).getTutor().getTutorID());
//           System.out.println(database.userID + "HI");
              if(database.submitted.get(i).getTutor() == null)
              {
                  
              }
              else if(database.submitted.get(i).getTutor().getTutorID().equals(database.userID) && database.submitted.get(i).getMarks() == -1)
           {
               
               store.add(database.submitted.get(i));

           }   
       }
            
        }
        catch(NullPointerException e){

        }
             
        
        for(int i=0; i < store.size() ; i++)
       {
           if(store.get(i).getTutor().getTutorID().equals(database.userID))
           {
               System.out.println((i+1) + ". " + store.get(i).getAssignment().getAssignmentID() + " - " + store.get(i).getLearner().getStudentID() + " - " + store.get(i).getLearner().getRealName());
               check = true;
               count++;
           }   
       }
        
        if(check == false)
        {
            System.out.println("No assignment to mark. Press any key to go back.");
            String andasds = scanner.nextLine();
            //MainPage.tutorMenu();
        }
            
        else
        {
            System.out.println((count + 1) + ". Exit");

                System.out.print(" >> ");
                String choice = scanner.nextLine();

                int exit = count + 1;

                if(choice.equals(Integer.toString(count + 1)))
                {
                    //MainPage.tutorMenu();
                }

                else
                {
                    int choice1 = 0;

                    try
                    {
                        choice1 = Integer.parseInt(choice);
                        choice1 --;
                    }

                    catch(NumberFormatException e)
                    {
                        System.out.println("Invalid input. Please enter numeric only.");
                        check1 = false;
                    }
                    
                    if(check1 != false)
                    {
                        if(choice1 <= count)
                        {
                        logo();
                        System.out.println("Student ID : " + store.get(choice1).getLearner().getStudentID()  + " - " + store.get(choice1).getLearner().getRealName());
                        System.out.println("Course     : " + store.get(choice1).getAssignment().getAssignmentID() + " - " 
                                + store.get(choice1).getAssignment().getAssignmentDescription());
                        System.out.println("-----------------------------------------------------");
                        System.out.println(store.get(choice1).getContent());
                        
                        System.out.print("Mark >> ");
                        String mark = scanner.nextLine();
                        
                            try
                            {
                                Integer.parseInt(mark);

                            }
                            catch(NumberFormatException e )
                            {
                               check1 = false;
                            }
                            
                            if(check1 != false)
                            {
                                if(Integer.parseInt(mark) < 0 || Integer.parseInt(mark) > 100){
                                System.out.println("Please enter 1-100.");
                                check1 = false;
                                }
                                
                                else
                                {
                                    store.get(choice1).setMarks(Integer.parseInt(mark));
                            
                                    System.out.print("Comment >> ");

                                    String comment = "";
                                    Scanner keyboard = new Scanner(System.in);
                                    String line;
                                    while (keyboard.hasNextLine()) {
                                        line = keyboard.nextLine();
                                        if (line.isEmpty()) {
                                            break;
                                        }
                                        comment += line + "\n";
                                    }

                                    store.get(choice1).setComment(comment);

                                    for(int i=0; i < database.submitted.size() ; i++){
                                        try{
                                            
                                            if(database.submitted.get(i).getTutor().getTutorID() == null){
                                                
                                            }
                                            
                                            else if(database.submitted.get(i).getTutor().getTutorID().equals(database.userID) && database.submitted.get(i).getLearner().getStudentID().equals(store.get(choice1).getLearner().getStudentID())
                                                && database.submitted.get(i).getAssignment().getAssignmentID().equals(store.get(choice1).getAssignment().getAssignmentID()))
                                        {
                                            database.submitted.set(i, store.get(choice1));

                                        }   
                                        }
                                        
                                        catch(NullPointerException e){}

                                        
                                        
                                    }
                                    
                                    // Do you wish to mark another assignment?
                                    System.out.println("Submitted successfully!");
                                    System.out.println("\nPress any key to continue.");
                                    String adiasodj = scanner.nextLine();
                                    
                                    //MainPage.tutorMenu();
                                }
                            
                            }
                            
                            else
                            {
                                System.out.println("Please enter 1-100.");
                            }

                        }

                     else
                        {
                           System.out.println("Invalid input.");
                           check1 = false;
                           
                        }
                    }

                }
        }
        }while(check1 == false);
    }
    
    public static void assignmentReport(){     //Might need to store into multiple backup databases.
        boolean check1;
        do{
        logo();
        System.out.println("             View Report              "); 
        System.out.println("======================================"); 
        check1 = true;
        int count = 1;
        ArrayList<Course> store = new ArrayList<Course>();
        
        for(int i = 0; i < database.course.size() ; i++){
            for(int j = 0; j < database.course.get(i).getTutor().size() ; j++){              
                if(database.course.get(i).getTutor().get(j).getTutorID().equals(database.userID)){
                    store.add(database.course.get(i));
                }
            }
        }
        
        for(int i1 = 0 ; i1 < store.size() ; i1++){
            System.out.println(count + ". " + store.get(i1).getCourseID() + " " + store.get(i1).getCourseName());
            count ++;
        }
        
        if(store.isEmpty()){
            System.out.println("No report available.\n");
            System.out.println("Press any key to continue.");
            String sadasdaa = scanner.nextLine();
            
        }
        
        else
        {
            int exito = (store.size() + 1);
        
            System.out.println( exito + ". Exit");
            System.out.print(" >> ");
            String choice = scanner.nextLine();

            if(choice.equals(Integer.toString(exito))){
                
            }
        
            else{
                int choice1 = 0;
                        try
                        {
                            choice1 = Integer.parseInt(choice);
                            choice1 --;
                        }

                        catch(NumberFormatException e)
                        {
                            System.out.println("Invalid input.");
                            check1 = false;
                        }
                        
                        if(check1 != false)
                        {
                            if(choice1 > store.size())
                            {
                                System.out.println("Invalid course. Please enter again.");
                                check1 = false;
                            }
                            
                            else
                            {
                                logo();
                                System.out.println("Assignment Report - " + store.get(choice1).getCourseID());
                                System.out.println("======================================"); 
                                System.out.println("Student ID\t\tMarks");
                                boolean yesno = false;
                                for(int i = 0; i < database.submitted.size(); i++){
                                    try{
                                    if(database.submitted.get(i).getAssignment().getAssignmentID().equals(store.get(choice1).getCourseID())){
                                        if(database.submitted.get(i).getMarks() <= 100 && database.submitted.get(i).getMarks() > 0 ){
                                            System.out.println(database.submitted.get(i).getLearner().getStudentID() + "\t\t" + database.submitted.get(i).getMarks());
                                            yesno = true;
                                        }
                                    }
                                    }
                                    catch(IndexOutOfBoundsException e){}

                                }

                                if(yesno == false)
                                {
                                    System.out.println("Nothing to show here. Press anything to continue");
                                    String aisdisad = scanner.nextLine();
                                   
                                }

                                else
                                {

                                    System.out.println("\nPress any key to continue.");
                                    String aisdisad = scanner.nextLine();
                                    
                                }
                            }

                        }
                        
                        else
                        {
                            System.out.println("Please enter numeric only!");
                        }

            }
        }
        
        }while(check1 == false);
        
    }
    
    public static void assignmentReportAdmin(){
        logo();
        int choice1 = 0;
        String choice;
        boolean check = true;
        
        System.out.println("         Assignment Report            "); 
        System.out.println("======================================"); 
        
        for(int i=0 ; i < database.course.size() ; i++){
            System.out.println((i+1) + ". " + database.course.get(i).getCourseID() + " " + database.course.get(i).getCourseName());
            
        } 
        
        int allreport = (database.course.size() + 1);
        System.out.println(allreport + ". All Courses");
        
        int exit = (database.course.size() + 2);
        System.out.println(exit + ". Back");
        
        do{
        do{
            
        System.out.print(">> ");
        choice = scanner.nextLine();
        
        try
        {
            choice1 = Integer.parseInt(choice);
            check = true;
        }
        
        catch(NumberFormatException e)
        {
            System.out.println("Invalid input. Please enter numeric only.");
            check = false;
        }
        
        }while(check == false);
        
        if(choice1 > (database.course.size() + 2)){
            System.out.println("Invalid option. Please enter again.");
            check = false;
        }
        else if(choice1 <= 0){
            System.out.println("Invalid option. Please enter based on the index.");
            check = false;
        }
        else{
        check = true;
            
        }
        }while(check == false);
        
        
        if(choice.equals(Integer.toString(exit))){
           // MainPage.staffMenu();
        }
        
        else if(choice.equals(Integer.toString(allreport)))
        {
            assignmentReportDetailed(allreport);
        }
        
        else
        {
            choice1 --;
            assignmentReportDetailed(choice1);
        }
        
        
        
    }
    
    
    public static void assignmentReportDetailed(int choice){
        boolean check = false;
        boolean check1 = false;
        int allreport = (database.course.size() + 1);
        logo();
        
        
        if(choice == allreport){
            for(int i=0; i < database.course.size(); i++){
                
                System.out.println(database.course.get(i).getCourseID() + " - " + database.course.get(i).getCourseName());
                System.out.println("Student ID      Marks   Date submitted");
                System.out.println("======================================");
                
                
                
                for(int j=0; j < database.submitted.size(); j++){
                    if(database.submitted.get(j).getAssignment().getAssignmentID().equals(database.course.get(i).getCourseID()) && database.submitted.get(j).getMarks() > 0){
                        
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                        Date date = new Date();
                        date = database.submitted.get(j).getDateSubmitted();
                        
                        System.out.println(database.submitted.get(j).getLearner().getStudentID() + " " + "\t" + database.submitted.get(j).getMarks() + "\t" + formatter.format(date));
                        check1 = true;
                    }
                    else
                    {
                        check1 = false;
                    }
                    
                    
                    
                }
                
                if(check1 == false){
                    System.out.println("No assignment available.");
                }
                
                System.out.println("\n");
            }
            
            System.out.println("Press any key to continue.");
            
            String aisdsaid = scanner.nextLine();
            
        }
        
        else{
            System.out.println("Student ID      Marks   Date submitted");
            System.out.println("======================================");
            for(int i=0; i < database.submitted.size(); i++)
            {
                if(database.submitted.get(i).getAssignment().getAssignmentID().equals(database.course.get(choice).getCourseID())){
                    if(database.submitted.get(i).getMarks() == -1){
                        
                    }
                    else
                    {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                        Date date = new Date();
                        date = database.submitted.get(i).getDateSubmitted();
                        
                        System.out.println(database.submitted.get(i).getLearner().getStudentID() + " " + "\t" + database.submitted.get(i).getMarks() + "\t" + formatter.format(date));
                        check = true;
                    }
                }
            }
            
            if(check == false)
            {
                System.out.println("Report currently not available.");
            }
            
            System.out.println("\nPress any key to continue.");
            String aisjdia = scanner.nextLine();
            
            
            
        }
        
    }
    
    
    public static void printReceipt(int course){
        logo();
        boolean check = false;
        for(int i = 0; i < database.submitted.size(); i++)
        {
            if(database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getCourseID().equals(database.submitted.get(i).getAssignment().getAssignmentID()) && database.submitted.get(i).getLearner().getStudentID().equals(database.userID)){
            
                if(database.submitted.get(i).getMarks() > 0 ){
                    System.out.println("\n     Official Receipt for " + database.submitted.get(i).getAssignment().getAssignmentID() + " " + database.learner.get(userIndex).getRegisteredCourse().get(course).getCourse().getCourseName());
                    
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                    Date date = new Date();
                    date = database.submitted.get(i).getDateSubmitted();
                    System.out.println(" ");
                    System.out.println("ID \t\t: " + database.userID);
                    System.out.println("Name \t\t: " + database.currentUser.getRealName());
                    System.out.println("Submitted on \t: " + date);
                    System.out.println("Marks \t\t: " + database.submitted.get(i).getMarks());
                    System.out.println("Tutor comment \t: " + database.submitted.get(i).getComment());
                    System.out.println("Marked by\t: " + database.submitted.get(i).getTutor().getRealName());
                    
                    Date today = new Date();
                    System.out.println("\nReceipt generated on " + today);
                    System.out.println("\nPress any key to continue.");
                    String aisjdis = scanner.nextLine();
                    
                    check = true;
                }
                
            }
        }
        
        if(check == false){
            System.out.println("No receipe available. Please wait for your tutor to mark your assignment.");
            System.out.println("\nPress any key to continue.");
            String aisjdis = scanner.nextLine();
        }
    }
    
    
    
    
}
