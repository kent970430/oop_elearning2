/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

import Classes.Forum;
import java.util.ArrayList;
import java.util.Scanner;
import Classes.Course;
import Main.Menus;
import Main.MainPage;
import static Main.MainPage.tutorMenu;
import static Main.MainPage.database;
import static Modules.TheadMenuMain.threadMenu;
//import static newjavaassignmentforummodule.NewJavaAssignmentForumModule.database;
//import static newjavaassignmentforummodule.NewJavaAssignmentForumModule.validation;
/**
 *
 * @author kueky
 */
public class ForumModuleMain {
      public static Scanner scanner = new Scanner(System.in);  
    
      public static void tutorForum(){
          boolean valid;
          String choice;
          int max = 0;
          String role = Main.MainPage.database.role;
          do {
              max = Menus.tutorForumMenu();
              choice = scanner.nextLine();
              valid = MainPage.validation(choice, max);
          } while (!valid);
          
          int userChoice = Integer.parseInt(choice);
          
          if(database.currentUser.getStatus().equals("Tutor")){
              switch(userChoice){
                  case 1:
                      createSubForum();
                      break;
                  case 2:
                      accessForum();
                      break;
                  case 3:
                      //return;
                      
                      break;
         } 
         }else if(database.currentUser.getStatus().equals("Student")){
            switch(userChoice){
                  case 1:
                       accessForum();
                      break;
                  case 2:
                     tutorMenu();
                      break;
            } 
         }else if(database.currentUser.getStatus().equals("Staff")){
             switch(userChoice){
                  case 1:
                      createSubForum();
                      break;
                  case 2:
                      accessForum();
                      break;
                  case 3:
                      //return;
                      tutorMenu();
                      break;
            } 
         }
         
      }
      public static void createSubForum(){
          boolean valid;
          String choice;
          ArrayList<Course> courseListMenu = new ArrayList<>();
          loopCorseMenu(courseListMenu);
          // following trycatch is to validate user input
          // if correct then will create a forum based on course selected
            
           do {              
               Menus.createSubForumMenu();
               choice = scanner.nextLine();
               valid = MainPage.validation(choice, courseListMenu.size()+1);
          } while (!valid);
           
           int userChoice = Integer.parseInt(choice);
           if(userChoice == (courseListMenu.size() +1)){
               tutorForum();
           }else{
                database.createForum(courseListMenu.get(--userChoice));
                System.out.println("\n\n---------------------------");
                System.out.println("You Have Created " + courseListMenu.get(userChoice).getCourseName() + " SubForum");
                // below is to prompt for continue create forum
                confirmContinue();
           }
      }
      public static void accessForum(){
          boolean valid;
          String choice;
          Course selectedCourse;
          ArrayList<Course> courseListMenu = new ArrayList<>();
          loopForumCourseMenu(courseListMenu);
          
          do {              
            Menus.accessForumMenu();
            choice = scanner.nextLine();
            valid = MainPage.validation(choice, courseListMenu.size()+1);
          } while (!valid);
          
          int userChoice = Integer.parseInt(choice);
          
          
          if(userChoice == (courseListMenu.size() +1)){
              // this is return
              tutorForum();
          }else{
              // this is forumTypeSelection
              selectedCourse = courseListMenu.get(--userChoice);
              do {                  
                  Menus.forumMenu();
                  choice = scanner.nextLine();
                  valid = MainPage.validation(choice, 4);
              } while (!valid);
              
              userChoice = Integer.parseInt(choice);
              
              if(userChoice == 4){
                  accessForum();
              }else{
                String selectedForumType = database.forumTypeList[--userChoice];
                //Forum selectedForum = getSelectedForum(selectedCourse, selectedForumType);
                database.selectedForum = getSelectedForum(selectedCourse, selectedForumType);
                threadMenu();  
              }
          }
      }     
      public static void loopCorseMenu(ArrayList<Course> courseListMenu){
          for(Course course : database.course){
              if(course.getForum().isEmpty())
              {
               courseListMenu.add(course);
              }
          }
       
      }
      public static void loopForumCourseMenu(ArrayList<Course> courseListMenu){
          for(Course course : database.course){
              if(!course.getForum().isEmpty()){
                courseListMenu.add(course);
              }
          }
      }
      public static void confirmContinue(){
          boolean valid ;
          String choice;
          
          do {              
              System.out.println("Do You want To Continue Create Forum ?");
              System.out.println("1. Yes\n2. No");
              
              choice = scanner.nextLine();
              valid = MainPage.validation(choice, 2);
          } while (!valid);
          
          int userChoice = Integer.parseInt(choice);
          
          if(userChoice == 1){
              createSubForum();
          }else{
              tutorForum();
          }
      }
      public static Forum getSelectedForum(Course selectedCourse, String selectedForumType){
          Forum selectedForum = new Forum();
          
          for(Forum forum : database.forum){
              if(forum.getCourse() == selectedCourse && forum.getForumType() == selectedForumType){
                  selectedForum = forum;
              }
          }
          
          return selectedForum;
      }

}
