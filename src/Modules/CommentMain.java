/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;
import Classes.Comment;
import Classes.Thread;
import java.util.ArrayList;
import java.util.Scanner;
import Classes.Course;
import Main.Menus;
import Main.MainPage;
import static Main.MainPage.database;
import static Main.Menus.tutorMenu;
import static Main.MainPage.scanner;
import static Modules.ForumModuleMain.scanner;
import static Modules.TheadMenuMain.printThread;
import static Modules.TheadMenuMain.threadMenu;
/**
 *
 * @author kueky
 */
public class CommentMain {
    static Scanner scan = new Scanner(System.in);
    public static void replyComment(Thread selectedThread, int threadNumber){
        String content;

        System.out.println("Please Type Your Content");
        content = scan.nextLine();
        
        database.createComment(content, database.currentUser, selectedThread);
        
    }
    
    public static void readComment(Thread selectedThread,int threadNumber, int commentIndex){
         boolean valid;
          String choice;
          int count = 1;
          //int threadNumber = 1;
         
          System.out.println(count);
          
          do {              
              try {
              
                  printComment(selectedThread, commentIndex);
                
                
                count = Menus.commentMenu(count, commentIndex);
                
            } catch (Exception e) {
                System.out.println("This Thread Has No Comment Yet!");
                  
            }
              System.out.println(count + ". " + "Return");
              choice = scan.nextLine();
              valid = MainPage.validation(choice, count);
          } while (!valid);
          
          int userChoice = Integer.parseInt(choice);
          
          if(count == 1 && userChoice == 1){
              printThread( database.selectedForum,  threadNumber);
          }else{
              if(commentIndex != 0 && commentIndex != (selectedThread.getCommentList().size()-1) ){
                  switch(userChoice){  
              case 1:
                  commentIndex-=1;
                  printNextComment(selectedThread,threadNumber,commentIndex);
                  break;
              case 2:
                  commentIndex+=1;
                  printNextComment(selectedThread,threadNumber,commentIndex);
                  break;
              case 3: 
                 printSelectedComment(selectedThread,threadNumber,commentIndex);
                  break;
              case 4:
                  replyComment(selectedThread, database.selectedComment,  threadNumber,  commentIndex);
                  break;
              case 5:
                  readComment(database.selectedThread,commentIndex,commentIndex);
                  break;
              case 6:
                  reportComment(selectedThread,threadNumber,commentIndex);
                  break;
                  
              case 7:
                  printThread( database.selectedForum,  threadNumber);
                  break;
                  }
                  
                  
              }else if(commentIndex == 0 && commentIndex != (selectedThread.getCommentList().size()-1)){
                 switch(userChoice){  
              case 1:
                  commentIndex+=1;
                  printNextComment(selectedThread,threadNumber,commentIndex);
                  break;
              case 2:
                  printSelectedComment(selectedThread,threadNumber,commentIndex);
                  break;
              case 3: 
                  replyComment(selectedThread, database.selectedComment,  threadNumber,  commentIndex);
                  break;
              case 4:
                  readComment(database.selectedThread,commentIndex,commentIndex);
                  break;
              case 5:
                   reportComment(selectedThread,threadNumber,commentIndex);
                  break;
              case 6:
                  printThread( database.selectedForum,  threadNumber);
                  break;
          } 
              }else if(commentIndex != 0 && commentIndex == (selectedThread.getCommentList().size()-1)){
                  switch(userChoice){  
              case 1:
                  commentIndex-=1;
                  printNextComment(selectedThread,threadNumber,commentIndex);
                  break;
              case 2:
                  printSelectedComment(selectedThread,threadNumber,commentIndex);
                  break;
              case 3: 
                  replyComment(selectedThread, database.selectedComment,  threadNumber,  commentIndex);
                  break;
              case 4:
                  readComment(database.selectedThread,commentIndex,commentIndex);
                  break;
              case 5:
                   reportComment(selectedThread,threadNumber,commentIndex);
                  break;
              case 6:
                  printThread( database.selectedForum,  threadNumber);
                  break;
                  }
              }else{
                  switch(userChoice){  
              case 1:
                   replyComment(selectedThread, database.selectedComment,  threadNumber,  commentIndex);
                  break;
              case 2:
                  readComment(database.selectedThread,commentIndex,commentIndex);
                  break;
              case 3: 
                 reportComment(selectedThread,threadNumber,commentIndex);
                  break;
         
              case 4:
                  printThread( database.selectedForum,  threadNumber);
                  break;
          }
              }
              
          }     
    }
    
    public static void printNextComment(Thread selectedThread,int threadNumber, int commentIndex){
        if(selectedThread.getCommentList().size() <= commentIndex){
              System.out.println("You reach end of Post");
              System.out.println("Press anything to Continue");
              scan.nextLine();
              commentIndex -= 1;
              readComment(database.selectedThread,commentIndex,commentIndex);
          }else{
              printComment(selectedThread, commentIndex);
              //threadNumber += 1;
              readComment(database.selectedThread,commentIndex,commentIndex);
          }
    }
    
    public static void reportComment(Thread selectedThread, int threadNumber, int commentIndex){
        int index = threadNumber;
          selectedThread.getCommentList().get(commentIndex).setCommentStatus(false);
          System.out.println("You have reported This Thread!");
          System.out.println("Please press anything to continue : ");
          scan.nextLine();
          readComment( selectedThread, threadNumber,  commentIndex);
    }
    
    public static void replyComment(Thread selectedThread, Comment selectedComment, int threadNumber, int commentIndex){
        String content;

        System.out.println("Please Type Your Content");
        content = scan.nextLine();
        
        database.createComment(content, database.currentUser, selectedComment);
         //printComment(selectedThread, commentIndex);
        readComment( selectedThread, threadNumber,  commentIndex);
    }
    
    public static void printSelectedComment(Thread selectedThread, int threadNumber, int commentIndex){
        int max = selectedThread.getCommentList().size();
          String choice;
          boolean valid;
          
          do{
              //show thread menu
              System.out.println("Current max Comment : " + max);
              System.out.println("Please enter Comment Number : ");
              choice = scan.nextLine();
              valid = MainPage.validation(choice, max);
          }while(!valid);
          
          int userChoice = Integer.parseInt(choice);
          commentIndex = userChoice;
          //printThread(selectedForum, (threadNumber-1));
          readComment( selectedThread, threadNumber,  (commentIndex-1));
    }
    
    public static void printComment(Thread selectedThread, int commentIndex){
        database.selectedComment = selectedThread.getCommentList().get(commentIndex);
        System.out.println("");
        System.out.println("===================================================");
        System.out.println(selectedThread.getCommentList().get(commentIndex).printThread(commentIndex, selectedThread.getCommentList().size()));
        System.out.println("===================================================");
        System.out.println("");
        //selectedThread.getCommentList();
        //System.out.println(selectedThread.getCommentList().get(0).printThread(0, 1));
    }
    
    public static void printComment(Comment selectedComment, int commentIndex){
        database.selectedComment = selectedComment.getCommentList().get(commentIndex);
        System.out.println("");
        System.out.println("===================================================");
        System.out.println(selectedComment.getCommentList().get(commentIndex).printThread(commentIndex, selectedComment.getCommentList().size()));
        System.out.println("===================================================");
        System.out.println("");
        //selectedThread.getCommentList();
        //System.out.println(selectedThread.getCommentList().get(0).printThread(0, 1));
    }
    
    public static void postComment(Thread selectedThread,int threadNumber){
        String content;

        System.out.println("Please Type Your Content");
        content = scan.nextLine();
        
        database.createComment(content, database.currentUser, selectedThread);
        
        printThread( database.selectedForum,  threadNumber);
    }

   
}
