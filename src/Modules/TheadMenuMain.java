/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

import Classes.Forum;
import Main.MainPage;
import static Main.MainPage.database;
import Main.Menus;
import static Modules.ForumModuleMain.*;
import java.util.Random; 

public class TheadMenuMain {
    public static void threadMenu(){
          boolean valid;
          String choice;
          do{
              //show thread menu
              Menus.threadMenuMenu(database.selectedForum); 
              choice = scanner.nextLine();
              valid = MainPage.validation(choice, 5);
          }while(!valid);
          
          int userChoice = Integer.parseInt(choice);
          
          switch(userChoice){
              case 1:
                  Menus.logo();
                  postNewThead();
                  break;
              case 2:
                  printThread(database.selectedForum, 0);
                  break;
              case 3:
                  randomThread(database.selectedForum);
              case 4:
                  reportThread(database.selectedForum);
              case 5:
                  database.selectedForum = null;
                  accessForum();
                  break;
          }
      }
    public static void printThread(Forum selectedForum, int threadNumber){
          boolean valid;
          String choice;
          int count = 1;
          //int threadNumber = 1;
          
          do {              
              try {
                
                Menus.printSelectedForumMenu(selectedForum);
                System.out.println(selectedForum.getThread(threadNumber).printThread(threadNumber, selectedForum.getThreadList().size()));
                database.selectedThread = selectedForum.getThreadList().get(threadNumber);
                System.out.println("==================================================================");
                System.out.println("");
                count = Menus.threadActionSelectionMenu(count,threadNumber, selectedForum);
            } catch (Exception e) {
                System.out.println("This Forum Has No Thread Yet!");
                  
            }
              System.out.println(count + ". " + "Return");
              choice = scanner.nextLine();
              valid = MainPage.validation(choice, count);
          } while (!valid);
          
          int userChoice = Integer.parseInt(choice);
          
          if(count == 1 && userChoice == 1){
              threadMenu();
          }else{
              if(threadNumber != 0 && threadNumber != (selectedForum.getThreadList().size()-1) ){
                  switch(userChoice){  
              case 1:
                  threadNumber-=1;
                  printNextThread(selectedForum,threadNumber);
                  break;
              case 2:
                  threadNumber+=1;
                  printNextThread(selectedForum,threadNumber);
                  break;
              case 3: 
                 printSelectedThread(selectedForum,threadNumber);
                  break;
              case 4:
                  CommentMain.postComment(database.selectedThread,threadNumber);
                  break;
              case 5:
                  CommentMain.readComment(database.selectedThread,threadNumber,0);
                  break;
              case 6:
                  reportThread(selectedForum,threadNumber);
                  break;
                  
              case 7:
                  threadMenu();
                  break;
                  }
                  
                  
              }else if(threadNumber == 0 && threadNumber != (selectedForum.getThreadList().size()-1)){
                 switch(userChoice){  
              case 1:
                  threadNumber+=1;
                  printNextThread(selectedForum,threadNumber);
                  break;
              case 2:
                  printSelectedThread(selectedForum,threadNumber);
                  break;
              case 3: 
                 CommentMain.postComment(database.selectedThread,threadNumber);
                  break;
              case 4:
                  CommentMain.readComment(database.selectedThread,threadNumber,0);
                  break;
              case 5:
                  reportThread(selectedForum,threadNumber);
                  break;
              case 6:
                  threadMenu();
                  break;
          } 
              }else if(threadNumber != 0 && threadNumber == (selectedForum.getThreadList().size()-1)){
                  switch(userChoice){  
              case 1:
                  threadNumber-=1;
                  printNextThread(selectedForum,threadNumber);
                  break;
              case 2:
                  printSelectedThread(selectedForum,threadNumber);
                  break;
              case 3: 
                  CommentMain.postComment(database.selectedThread,threadNumber);
                  break;
              case 4:
                  CommentMain.readComment(database.selectedThread,threadNumber,0);
                  break;
              case 5:
                  reportThread(selectedForum,threadNumber);
                  break;
              case 6:
                  threadMenu();
                  break;
                  }
              }else{
                  switch(userChoice){  
              case 1:
                   CommentMain.postComment(database.selectedThread,threadNumber);
                  break;
              case 2:
                  CommentMain.readComment(database.selectedThread,threadNumber,0);
                  break;
              case 3: 
                reportThread(selectedForum,threadNumber);
                  break;
         
              case 4:
                  threadMenu();
                  break;
          }
              }
              
          }     
      }
    public static void printNextThread(Forum selectedForum, int threadNumber){
          if(selectedForum.getThreadList().size() <= threadNumber){
              System.out.println("You reach end of Post");
              System.out.println("Press anything to Continue");
              scanner.nextLine();
              threadNumber -= 1;
              printThread(selectedForum, threadNumber);
          }else{
              selectedForum.getThread(threadNumber);
              //threadNumber += 1;
              printThread(selectedForum, threadNumber);
          }
      }
    public static void printSelectedThread(Forum selectedForum, int threadNumber){
          int max = selectedForum.getThreadList().size();
          String choice;
          boolean valid;
          
          do{
              //show thread menu
              System.out.println("Current max Thread : " + max);
              System.out.println("Please enter Thread Number : ");
              choice = scanner.nextLine();
              valid = MainPage.validation(choice, max);
          }while(!valid);
          
          int userChoice = Integer.parseInt(choice);
          threadNumber = userChoice;
          printThread(selectedForum, (threadNumber-1));
      }
    public static void reportThread(Forum selectedForum,int threadNumber){
          int index = threadNumber;
          selectedForum.getThreadList().get(index).setThreadStatus(false);
          System.out.println("You have reported This Thread!");
          System.out.println("Please press anything to continue : ");
          scanner.nextLine();
          printThread(selectedForum,  threadNumber);
      }
    public static void reportThread(Forum selectedForum){
          boolean valid;
          String choice;
          do { 
             System.out.println("Maximum Thread Number : " + selectedForum.getThreadList().size());
             System.out.print("Please enter Thread Number : ");
             choice = scanner.nextLine();
             valid = MainPage.validation(choice, selectedForum.getThreadList().size());
          } while (!valid);
          
          int userChoice = Integer.parseInt(choice);
          userChoice--;
          confirmReportThread(selectedForum,userChoice);
          
      }
    public static void confirmReportThread(Forum selectedForum,int userChoice){
          System.out.println("");
          System.out.println("Is this thread you want to report?");
          System.out.println("==================================================================");
          System.out.println(selectedForum.getThreadList().get(userChoice).printThread(userChoice, selectedForum.getThreadList().size()));
          System.out.println("==================================================================");
          
          boolean valid;
          String choice;
          do {              
             System.out.println("1. Yes");
             System.out.println("2. No");
             
             choice = scanner.nextLine();
             valid = MainPage.validation(choice, 2);
          } while (!valid);
          
          int userChoice1 = Integer.parseInt(choice);
          
          switch(userChoice1){
              case 1:
                  selectedForum.getThreadList().get(userChoice).setThreadStatus(false);
                  System.out.println("You have reported This Thread!");
                  System.out.println("Please press anything to continue : ");
                  scanner.nextLine();
          }
          
          threadMenu();
      }
    public static void randomThread(Forum selectedForum){
          int max = selectedForum.getThreadList().size();
          Random random = new Random();
          int threadNumber = random.nextInt(max);
          System.out.println(threadNumber);
          System.out.println(max);
          printThread(selectedForum, threadNumber);
      }
    public static void postNewThead(){
          //Menu.logo();
          String title;
          String content;
          System.out.println("Please Type Your Thread Title : ");
          title = scanner.nextLine();
          System.out.println("Please Type Your Content");
          content = scanner.nextLine();
          confirmPostNewThread(title,content);
      }
    public static void confirmPostNewThread(String title, String content){
          boolean valid;
          String choice;
          do { 
             System.out.println("");
             System.out.println("");
             System.out.println("This is You New Thread : ");
             System.out.println("Title : " + title);
             System.out.println("Content : " + content);
             System.out.println("Are you Sure You Want To Post? ");
             System.out.println("1. Yes");
             System.out.println("2. No, I want to Type again");
             System.out.println("3. No, I want Exit To Menu");
             
             choice = scanner.nextLine();
             valid = MainPage.validation(choice, 3);
          } while (!valid);
          
          int userChoice = Integer.parseInt(choice);
          Forum selectedForum = database.selectedForum;
          switch(userChoice){
              case 1:
                  database.createThread(content, database.currentUser, title,selectedForum);
                  System.out.println("Your Thread Has Been Posted");
                  threadMenu();
                  break;
              case 2:
                  Menus.logo();
                  System.out.println("This is your last post : ");
                  System.out.println("Title : " + title);
                  System.out.println("Content : " + content);
                  postNewThead();
              case 3:
                  threadMenu();
          } 
      }
}
