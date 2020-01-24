package Main;

import Classes.Admin;
import Classes.Course;
import Modules.ForumModuleMain;
import Classes.Forum;
import Classes.Learner;
import Classes.Announcement;
import Classes.Payment;
import Classes.RegisteredCourse;
import Classes.Tutor;
import static Main.MainPage.database;
import java.util.ArrayList;
import java.util.Scanner;
import Main.MainPage;

import java.util.ArrayList;

public class Menus {
    
        static boolean isLearner = false;
        static boolean isTutor = false;
        static boolean isAdmin = false;
   
    public static void startUp(){
        logo();
        System.out.println(" 1. Login ");
        System.out.println(" 2. Register");
        System.out.println(" 3. Exit");
         System.out.print(" >> ");
    }
    
    public static String Login()
    {
        
        isLearner = false;     //To prevent invalid login still successfully.
        isTutor = false;
        isAdmin = false;
        
        String username11;
        
        Scanner scanner = new Scanner(System.in);
        String role = "";
        
        do{
        logo();
        
        System.out.print(" User ID  : ");
        String username = scanner.nextLine();
        
        System.out.print(" Password : ");
        String password = scanner.nextLine();
        
        for(int i=0; i< database.learner.size();i++){
            if(database.learner.get(i).getUserName().equals(username)){
                if(database.learner.get(i).getPassword().equals(password)){
                    isLearner = true;
                    isTutor = false;
                    isAdmin = false;
                    database.userID = database.learner.get(i).getStudentID();
                    database.currentUser = database.learner.get(i);
                    database.fullName = database.learner.get(i).getRealName();
                    database.currentLearner = database.learner.get(i);
                    break;
                }
            }
        }
        
        for(int i=0; i< database.tutor.size();i++){
            if(database.tutor.get(i).getUserName().equals(username)){
                if(database.tutor.get(i).getPassword().equals(password)){
                    isLearner = false;
                    isTutor = true;
                    isAdmin = false;
                    database.userID = database.tutor.get(i).getTutorID();
                    database.currentUser = database.tutor.get(i);
                    break;
                }
            }
        }
        
        for(int i=0; i< database.admin.size();i++){
            if(database.admin.get(i).getUserName().equals(username)){
                if(database.admin.get(i).getPassword().equals(password)){
                    isLearner = false;
                    isTutor = false;
                    isAdmin = true;
                    database.userID = database.admin.get(i).getAdminID();
                    database.currentUser = database.admin.get(i);
                    break;
                }
            }
        }
        
        
        if(isLearner == true){
            role = "Student";
           
        }
        
        else if(isTutor == true){
            role = "Tutor";
            
        }
        
        else if(isAdmin == true){
            role = "Admin";
            
        }
        else{
            System.out.println("\nWrong username or password! \n\n");
            role = "";
            isLearner = false;
            isTutor = false;
            isAdmin = false;   
        }
        
        
    }while(isLearner == false && isTutor == false && isAdmin == false);
        
        return role;
        
    }
    
    public static void tutorMenu(){
        logo();
        
        try{
        
        for(int i=0; i < database.noti.size() ; i++)
       {
           if(database.noti.get(i).getId().equals(database.currentUser.getUserName()))
           {
               System.out.println(database.noti.get(i).getNotification() + "\n");
               database.noti.remove(i);
           }
       }
        }
        catch(NullPointerException e)
        {
            
        }
        
        System.out.println("Welcome, " + database.currentUser.getRealName() + ".\n");
        
        System.out.println("Please Select Action : ");
        System.out.println("1. Forum");
        System.out.println("2. Mark Assignment");
        System.out.println("3. View Assignment Report");
        System.out.println("4. Make Announcement");
        System.out.println("5. Logout");
        System.out.print("\nYour Selection : ");
    }
    public static void forumMenu(){
        System.out.println("==========================================");
          System.out.println("");
          System.out.println("Welcome To BINTON UNIVERSITY Forum");
          System.out.println("");
          System.out.println("==========================================");
          System.out.println("Please Choose Which SubForum that You want to access : ");
          System.out.println("1. Helpful Resource");
          System.out.println("2. Subject Topic");
          System.out.println("3. General Discussion");
          System.out.println("4. Return");
          System.out.print("\nYour Choice : ");
      }
    public static void threadMenuMenu(Forum selectedForum){
          System.out.println("==========================================");
          System.out.println("");
          System.out.println("  Welcome To " + selectedForum.getCourse().getCourseName() +" "+ selectedForum.getForumType() + " Sub-Forum");
          System.out.println("");
          System.out.println("==========================================");
          System.out.println("\nPlease select 1 of the Following Action : ");
          System.out.println("1. Create New Thread");
          System.out.println("2. View Thread");
          System.out.println("3. View Random Thread");
          System.out.println("4. Report Thread");
          System.out.println("5. Return");
          System.out.print("\nYour Selection : "); 
      }
    public static int tutorForumMenu(){
          logo();
          int counter = 1;
          System.out.println("Please Choose 1 of the Action : ");
          String role = Main.MainPage.database.role;
      //    if(role.equals("Tutor")){
            if(database.currentUser.getStatus().equals("Tutor")){
              System.out.println(counter + ". Create Forum");
              counter++;
          }
          System.out.println(counter + ". View Forum");
          counter++;
          System.out.println(counter + ". Return");
          System.out.print("\nYour Selection : ");
          
          return counter;
    }
    public static void accessForumMenu(){
        int counter = 1;
        Menus.logo();
          System.out.println("Which Course You Want To Access");
          ArrayList<Course> courseListMenu = new ArrayList<>();
          ForumModuleMain.loopForumCourseMenu(courseListMenu);
          for(Course course : courseListMenu){
              System.out.println(counter + ". " + course.getCourseName());
              counter++;
          }
          if(counter == 1){
              System.out.println("\n\nCurrently No Forum Yet\n\n");
          }
          System.out.println(courseListMenu.size()+1 + ". Return");
    }
    public static void createSubForumMenu(){
        int counter = 1;
        logo();
        System.out.println("Which Course Do You Want To create Forum? : ");
        ArrayList<Course> courseListMenu = new ArrayList<>();
        ForumModuleMain.loopCorseMenu(courseListMenu);
        
        
        for(Course course : courseListMenu){
              System.out.println(counter + ". " + course.getCourseName());
              counter++;
          }
        
          if(counter == 1){
              System.out.println("\n\nAll Courses Have Forum\n\n");
          }
          System.out.println(courseListMenu.size()+1 + ". Return");
          System.out.print("Your Selection : ");
    }
    public static void printSelectedForumMenu(Forum selectedForum){
        System.out.println("==================================================================");
        System.out.println("Course : " + selectedForum.getCourse().getCourseName());
            System.out.println("ForumType : " + selectedForum.getForumType());
            System.out.println("==================================================================");
    }
    public static int threadActionSelectionMenu(int count, int threadNumber, Forum selectedForum){
        if(threadNumber != 0 && threadNumber != (selectedForum.getThreadList().size()-1) ){
            System.out.println(count + ". " + "Print Previous Thread");
            count++;
            System.out.println(count + ". " + "Print Next Thread");
            count++;
            System.out.println(count + ". " + "Print Selected Thread");
            count++;
        }else if(threadNumber == 0 && threadNumber != (selectedForum.getThreadList().size()-1)){
            System.out.println(count + ". " + "Print Next Thread");
            count++;
            System.out.println(count + ". " + "Print Selected Thread");
            count++;
        }else if(threadNumber != 0 && threadNumber == (selectedForum.getThreadList().size()-1)){
            System.out.println(count + ". " + "Print Previous Thread");
            count++;
            System.out.println(count + ". " + "Print Selected Thread");
            count++;
        }
            System.out.println(count + ". " + "Reply Thread");
            count++;
            System.out.println(count + ". " + "Read Reply");
            count++;
            System.out.println(count + ". " + "Report This Thread");
            count++;
       
        return count;
    }
    
  public static int commentMenu(int count,int commentIndex){
       if(commentIndex != 0 && commentIndex != (database.selectedThread.getCommentList().size()-1) ){
            System.out.println(count + ". " + "Print Previous Comment");
            count++;
            System.out.println(count + ". " + "Print Next Comment");
            count++;
            System.out.println(count + ". " + "Print Selected Comment");
            count++;
        }else if(commentIndex == 0 && commentIndex != (database.selectedThread.getCommentList().size()-1)){
            System.out.println(count + ". " + "Print Next Comment");
            count++;
            System.out.println(count + ". " + "Print Selected Comment");
            count++;
        }else if(commentIndex != 0 && commentIndex == (database.selectedThread.getCommentList().size()-1)){
            System.out.println(count + ". " + "Print Previous Comment");
            count++;
            System.out.println(count + ". " + "Print Selected Comment");
            count++;
        }
            System.out.println(count + ". " + "Reply Comment");
            count++;
            System.out.println(count + ". " + "Read Reply");
            count++;
            System.out.println(count + ". " + "Report This Comment");
            count++;
       
        return count;
  }
    
     public static void learnerMenu()
    {
                       
         
        System.out.println("\n\n");
        logo();
        System.out.println("\t    Learner Menu");
        System.out.println("======================================");
        
        try{
            for(int i=0; i < database.noti.size() ; i++)
            {
                if(database.noti.get(i).getId().equals(database.currentUser.getUserName()) )
                 {
                      System.out.println(database.noti.get(i).getNotification() + "\n");
                     database.noti.remove(i);
                }
            }
        }
        
        catch(NullPointerException e)
        {
            
        }
         
        System.out.println("Welcome, " + database.fullName + ". \n");
        System.out.println(" 1. Online Assessment");
        System.out.println(" 2. Visit Forum");
        System.out.println(" 3. Register Course");
        System.out.println(" 4. Logout");
        System.out.print(" >> ");
        
        
    }
     
     public static void staffMenu()
     {
         logo();
                    // Print notification
        
                for(int i=0; i < database.noti.size() ; i++)
       {
           try{
           if(database.noti.get(i).getId().equals(database.currentUser.getUserName()))
           {
               System.out.println(database.noti.get(i).getNotification() + "\n");
               database.noti.remove(i);
           }
           
           }
           catch(NullPointerException e)
                   {
                       
                   }
       }
         
         System.out.println("1. Assign assignment to tutor");
         System.out.println("2. Add new tutor");
         System.out.println("3. View reports");
         System.out.println("4. Add Bill");
         System.out.println("5. View students");
         System.out.println("6. Make Announcement");
         System.out.println("7. Logout");
         System.out.print(" >> ");
     }
    
     public static void logo()
    {  
      
       System.out.println("======================================");
       System.out.println("          BINTON UNIVERSITY           ");
       System.out.println("     E-LEARNING MANAGEMENT SYSTEM     ");
       System.out.println("======================================"); 
     
    }
     
     // lun afterthis
      public static Learner selectedLearner;    
     public static void addPaymentbill(){//for admin to bill students
         //main function1lun
     for (int i = 0 ; i < Database.learner.size() ; i++)
         {
             System.out.println(i + ".\t" +Database.learner.get(i).getStudentID()+ "\t" +Database.learner.get(i).getUserName() );
          }
         Scanner s =new Scanner(System.in); 
         System.out.println("Select learner to process");
         int choice = s.nextInt();
         selectedLearner = Database.learner.get(choice);
         String blank =s.nextLine();
         System.out.println("give me payment ID");
         String paymentID = s.nextLine();
         Database.learner.get(choice).addPayment(new Payment(paymentID,makeCourseReg() ));

               database.noti.add(new Announcement("Learner",selectedLearner.getUserName(),"You have a new Payment Bill"));
      
       
      
     }    
    
     public static void viewStudentBill(Learner learner){//for both admin and students to will a particular stud's bills tutors cannon view these
         //main function2 lun
         learner.ViewBill();
         boolean validation =false;
         Scanner s = new Scanner(System.in);
         if(learner.getPayment() != null ){
            System.out.println("Select a bill to pay using the index numbers  Or press q to go back to main menu");
            String choice = s.nextLine();
            validation = false;
            
            if(choice.charAt(0) =='q'){
                validation =true;
            }else do{ //paying the bill
                if(MainPage.validation(choice, learner.getPayment().size()+1)==false){
                    System.out.println("Please re-enter index number;");
                    choice = s.nextLine();
                }
                learner.getPayment().get(Integer.parseInt(choice)-1).paybill();//simple change of boolean
                System.out.println("Payment complete");
                //make notifiation
             validation= true;
                 
                        if (isAdmin == true){
 
                        }
                                else if (isLearner == true)
                                {Database.noti.add(new Announcement("Learner",MainPage.database.currentUser.getUserName(),"You have paid your bill"));
                                       
                                
                                }
                                  
                           break;
                       
                //idk how lol :(
            }while (validation ==false);
            
         }
         else {
          System.out.println("No Bills to be displayed press q to go back to main menu");
          if(s.nextLine().contains("Qq")){
              
          }
         }
     }
     public static RegisteredCourse selectRegisteredCourse(Learner learner){
         for (int i = 0 ; i < learner.getRegisteredCourse().size() ; i++)
         {
             Course CourseItem = learner.getRegisteredCourse().get(i).getCourse();
             System.out.println(i+1 + ".\t" + CourseItem.getCourseID() +"\t" + CourseItem.getCourseName());
          }
         Scanner s =new Scanner(System.in);
         String choice ;
           boolean valid=false;
         do{
         System.out.println("Select Course to process");
         choice =s.nextLine();
         valid =MainPage.validation(choice, learner.getRegisteredCourse().size());
         if(valid !=false){
             return learner.getRegisteredCourse().get(Integer.parseInt(choice)-1);
         }
         }while(!valid);
                return null;
     }
 
     public static ArrayList<RegisteredCourse> makeCourseReg(){
             boolean  con = false;
              ArrayList<RegisteredCourse> x = new  ArrayList<RegisteredCourse>();
        do {
            x.add(selectRegisteredCourse(selectedLearner));
            System.out.println("enter n to stop adding Courses");
            Scanner s =new Scanner(System.in);
            if (s.nextLine().charAt(0)=='n')
                con = true;
                
        }while(con == false );
        
     return x;
     }
     
     public static void makeAnnouncement(){
         //main function3
         // make global announcemnt
         Scanner s = new Scanner(System.in);
         System.out.println("Please Select an audience for your Announcement");
         System.out.println("1: Staff");
         System.out.println("2: Tutors");
         System.out.println("3: Students");
         System.out.println("4: Specific users");
         System.out.println("5: ALL USERS");
         System.out.println("6: Cancel Announcement");
         
      
         boolean valid =false;
         String choice;
         do{
             
             System.out.print("Input :");
                 choice = s.nextLine();
                valid = MainPage.validation(choice,6);
                
         }while(!valid);
        int intChoice= Integer.parseInt(choice) ;
        String NotificationEntry;
        switch (intChoice)
        {
            case 1:
               System.out.println("Please enter your Announcement cotent");
                NotificationEntry = s.nextLine();
               for(Admin admin: Database.admin)
                {
                    Database.noti.add(new Announcement("Admin",admin.getUserName(),NotificationEntry));
                }

                break;
                          
            case 2:
                System.out.println("Please enter your Announcement cotent");
                NotificationEntry = s.nextLine();
               for(Tutor tutor: Database.tutor)
                {
                    Database.noti.add(new Announcement("Tutor",tutor.getUserName(),NotificationEntry));
                }

                break;           
            case 3:
                System.out.println("Please enter your Announcement cotent");
                NotificationEntry = s.nextLine();
               for(Learner learner: Database.learner)
                {
                    Database.noti.add(new Announcement("Learner",learner.getUserName(),NotificationEntry));
                }

                break;          
                      
            case 4:
                System.out.println("Please enter your recipeient");
                String Recipient= s.nextLine();
                                System.out.println("Please enter your Announcement cotent");
                NotificationEntry = s.nextLine();
                //check if recipient is of any category
                Database.noti.add(new Announcement(Recipient,NotificationEntry));

                break;
            case 5:
                                System.out.println("Please enter your Announcement cotent");
                NotificationEntry = s.nextLine();
               for(Learner learner: Database.learner)
                {
                    Database.noti.add(new Announcement("Learner",learner.getStudentID(),NotificationEntry));
                }
                          for(Admin admin: Database.admin)
                {
                    Database.noti.add(new Announcement("Staff",admin.getAdminID(),NotificationEntry));
                }            
                          for(Tutor tutor: Database.tutor)
                {
                    Database.noti.add(new Announcement("Tutor",tutor.getTutorID(),NotificationEntry));
                }
                

                
                break;
            case 6:

 
        

                                
        }
        
     }   

     
}
