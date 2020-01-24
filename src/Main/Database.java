/*
Thread = Only OOAD three subforum have 1 thread
Course = 4 course
Sub forum = only The last course havt created
*/
package Main;

import Classes.*;
import Classes.Course;
import Classes.Forum;
import Classes.Thread;
import Classes.Assignment;
import Classes.AssignmentSubmitted;
import Classes.Announcement;
import java.util.ArrayList;
import static Main.MainPage.database;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Database {
    
    public   ArrayList<Course> course = new ArrayList<>();
    public   ArrayList<Forum> forum = new ArrayList<>();
    public   String [] forumTypeList = {"Subject", "Helpful Resource", "General Discussion"};
    public   ArrayList<User> user = new ArrayList<>();
    public   User currentUser;
    public Learner currentLearner;
    public String userID;
    public String fullName;
    public Forum selectedForum;
    public Thread selectedThread;
    public Comment selectedComment;
    public String role;
    private  ArrayList<Course> courseList = new ArrayList<>();
    public static ArrayList<Assignment> assignment = new ArrayList<Assignment>();
    public static ArrayList<AssignmentSubmitted> submitted = new ArrayList<AssignmentSubmitted>();
    public static ArrayList<Announcement> noti = new ArrayList<Announcement>();
    public static ArrayList<Learner> learner = new ArrayList<Learner>();
    public static ArrayList<Tutor> tutor = new ArrayList<Tutor>();
    public static ArrayList<Admin> admin = new ArrayList<Admin>();
    public static ArrayList<Programme> programmeList= new ArrayList<Programme>();
    
     public static ArrayList<RegisteredCourse> CourseReg = new ArrayList<RegisteredCourse>();//lun
  
   //private static Forum [] subForum = {new Forum("Subject", ooad)};
   // private static Forum [] helpForum = {new Forum("Helpful Resource", ooad)};
    //private static Forum [] geForum = {new Forum("General Discussion", ooad)};
    
    public void addData(){
        database.addProgrammeData();
        database.addCurrentUser();
        database.addCourseData();
        database.addForumData();
        database.addThread();
        database.addNotification();
        database.addPayment();
    }
    
    public  void addCourseData(){
        
        Date deadlinedate = new Date();
        
        String deadline = "10-October-2019";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        try {
         deadlinedate = formatter.parse(deadline);
         } catch (ParseException e) {
        
         }
       
        Course c = new Course("BACS1001","Research Method","Learn how to do research additional topics that are useless.",1000,3);
        Assignment a = new Assignment("BACS1001","Do some research on nothing and cry in the corner",deadlinedate,0);
        c.setAssignment(a);
        this.course.add(c);
        
        Course c1 = new Course("BACS1002","Object Oriented Programming","Learn how to do java coding that will makes you sleepless.",2000,3);
        Assignment a1 = new Assignment("BACS1002","Develop a java application that is impossible.",deadlinedate,0);
        c1.setAssignment(a1);
        this.course.add(c1);
        
        Course c2 = new Course("BACS1003","Operating System","Learn how to do command prompt programming that is totally bullshit.",1000,3);
        Assignment a2 = new Assignment("BACS1003","Develop a command prompt applcation that makes you go ???",deadlinedate,0);
        c2.setAssignment(a2);
        this.course.add(c2);
        
        Course c3 = new Course("BACS1004","Web Application Development","Learn how to make a noob website.",1500,3);
        Assignment a3 = new Assignment("BACS1004","Make a website that will impress no one.",deadlinedate,0);
        c3.setAssignment(a3);
        this.course.add(c3);
        
        
        returnProgramme("RIS").addCourse(c);
        returnProgramme("RIS").addCourse(c1);
        returnProgramme("RIS").addCourse(c2);
        
        returnProgramme("RSD").addCourse(c);
        returnProgramme("RSD").addCourse(c1);
        returnProgramme("RSD").addCourse(c2);
        returnProgramme("RSD").addCourse(c3);

        returnProgramme("RIT").addCourse(c);
        returnProgramme("RIT").addCourse(c3);
        
        
        
        Date date1 = new Date();
        Date date2 = new Date();
        Date date3 = new Date();
        Date date4 = new Date();
        Date date5 = new Date();
        Date date6 = new Date();
        Date date7 = new Date();
        Date date8 = new Date();
        Date date9 = new Date();
        Date date10 = new Date();
        
        String sDate1 = "31-January-2019";
        String sDate2 = "31-March-2019";
        String sDate3 = "31-May-2019";
        String sDate4 = "31-August-2019";
        
        String sDate5 = "31-January-2020";
        String sDate6 = "31-March-2020";
        String sDate7 = "31-May-2020";
        String sDate8 = "31-August-2020";
        String sDate9 = "31-October-2020";
        String sDate10 = "31-December-2020";
        
        try {
         date1 = formatter.parse(sDate1);
         date2 = formatter.parse(sDate2);
         date3 = formatter.parse(sDate3);
         date4 = formatter.parse(sDate4);
         
         date5 = formatter.parse(sDate5);
         date6 = formatter.parse(sDate6);
         date7 = formatter.parse(sDate7);
         date8 = formatter.parse(sDate8);
         date9 = formatter.parse(sDate9);
         date10 = formatter.parse(sDate10);
         } 
        catch (ParseException e) {
         }
        
        CourseSchedule S12019 = new CourseSchedule("2019(Jan)",date1, date2);
        c.addCsList(S12019);
        CourseSchedule S22019 = new CourseSchedule("2019(May)",date3, date4);
        c.addCsList(S22019);
        
        CourseSchedule S12020 = new CourseSchedule("2020(Jan)", date5, date6);
        c.addCsList(S12020);
        c1.addCsList(S12020);
        c2.addCsList(S12020);
        
        CourseSchedule S22020 = new CourseSchedule("2020(Mar)",date7, date8);
        c.addCsList(S22020);
        c2.addCsList(S22020);
        c3.addCsList(S22020);
        
        CourseSchedule S32020 = new CourseSchedule("2020(Oct)", date9, date10);
        c1.addCsList(S32020);
        c3.addCsList(S32020);
        c2.addCsList(S32020);
        
        
        RegisteredCourse rc = new RegisteredCourse(c, c.getCsList().get(0));
        RegisteredCourse rc1 = new RegisteredCourse(c1,c.getCsList().get(0));
        
        Learner l = new Learner("18WMR0000","test","123","Learner","Kuek Yong Boon");
        l.addRegisteredCourse(rc);
        l.addRegisteredCourse(rc1);
        learner.add(l);
        
        
        Learner l1 = new Learner("18WMR0001","test1","123","Learner","Lim Yi En");
        l1.addRegisteredCourse(rc1);
        learner.add(l1);
        
        //(String userName, String password,String status,String adminID, String adminStatus)
        Tutor t = new Tutor("tutor","123","Tutor","T1000","Available", "Ong Chun Heng");
        tutor.add(t);
        Tutor t1 = new Tutor("tutor1","123","Tutor","T1001","Available", "Memes");
        tutor.add(t1);
        Tutor t2 = new Tutor("tutor2","123","Tutor","T1002","Available", "Godzilla");
        tutor.add(t2);
        Tutor t3 = new Tutor("tutor3","123","Tutor","T1003","Available", "King Kong");
        tutor.add(t3);
        Tutor t4 = new Tutor("tutor4","123","Tutor","T1004","Available", "Annaconda");
        tutor.add(t4);
        
        c.addTutor(t1);
        c.addTutor(t2);
        c.addTutor(t3);
        c.addTutor(t4);
        
        c1.addTutor(t1);
        
        c2.addTutor(t2);
        c2.addTutor(t3);
        
        c3.addTutor(t1);
        c3.addTutor(t2);
        c3.addTutor(t3);
        
        Date date = new Date();
        //AssignmentSubmitted( marks,  learner,  dateSubmitted,  tutor,  content,  comment,  assignment)
        submitted.add(new AssignmentSubmitted(-1,l,null,null,"Hi \n My name is","draft",a));
       // submitted.add(new AssignmentSubmitted(-1,l,date,null,"Hi \n This is my assignment","",a1));
        submitted.add(new AssignmentSubmitted(-1,l1,date,t1,"Hi \n This is my assignment","",a));
        //submitted.add(new AssignmentSubmitted(39,l1,date,t3,"Hi \n This is my assignment","",a1));
        
        Admin ad = new Admin("admin","123","Admin","A1000","Available", "Wong Qi Lun");
        admin.add(ad);
        
        
    }
    
     public void addProgrammeData(){
              
       Programme ris = new Programme("RIS", "Information Security","This programme produces and equips graduates with in-depth\n"
                                    + "knowledge and skills that are essential to work as professionals\n"
                                        + "in the software systems development and computer networking sectors.\n", 10200 );
       Programme rsd = new Programme("RSD", "Software System Development","This programme produces and equips graduates with in-depth\n"
                                    + "knowledge and skills that are essential to work as professionals\n"
                                        + "in the software systems development and computer networking sectors.\n", 10000 );
       Programme rit = new Programme("RIT", "Internet Technology","This programme produces and equips graduates with in-depth\n"
                                    + "knowledge and skills that are essential to work as professionals\n"
                                        + "in the software systems development and computer networking sectors.\n", 13200 );
      
        
       programmeList.add(ris);
       programmeList.add(rsd);
       programmeList.add(rit);

    }
    
     
    public Programme returnProgramme(String name){
        Programme p = null;
        
        for(Programme p1 : database.programmeList){
            if(p1.getProgrammeCode().equals(name)){
                p = p1;
            }
        }
        return p; 
    } 
    
    
    public void addForumData(){

        
        for(int i = 0; i < this.course.size() -1;i++){
            createForum(this.course.get(i));
        }
    }

    
   public void addThread(){
        Forum forum1 = this.forum.get(0);
        Forum forum2 = this.forum.get(1);
        Forum forum3 = this.forum.get(2);
        Forum forum4 = this.forum.get(3);

        Thread t1 = new Thread("I'm so happy today 1!", this.learner.get(1), "Happy",forum1);
        Thread t2 = new Thread("I'm so happy today 2!", this.learner.get(1), "Happy",forum2);
        Thread t3 = new Thread("I'm so happy today 3!", this.learner.get(0), "Happy",forum3);
        Thread t4 = new Thread("I'm so happy today 4!", this.learner.get(0), "Happy",forum4);
        
        this.forum.get(0).addThread(t1);
        this.forum.get(1).addThread(t2);
        this.forum.get(2).addThread(t3);
        this.forum.get(3).addThread(t4);
    }
    public void addCurrentUser(){
        //this.currentUser = this.user.get(1);
    }
    public  void createForum(Course course){
        for(String forumTypeList : forumTypeList){
            Forum newforum = new Forum(forumTypeList,course);
            this.forum.add(newforum);
            try {
                course.addForum(newforum);
                //System.out.println("You Success created forum");
            } catch (Exception e) {
                 // System.out.println("You fail created forum");
            }
            
        }
        
    }
    public  void createThread(String threadDescription, User user, String threadTitle, Forum selectedForum){
        //int index = selectedForum.getThreadList().size();
        Thread newThread = new Thread(threadDescription, user, threadTitle,selectedForum);
        this.selectedForum.addThread(newThread);
    }
    
    public void createComment(String commentContent, User user, Thread selectedThread){
        Comment newComment = new Comment(commentContent, user, selectedThread);
        this.selectedThread.addComment(newComment);
    }
    public void createComment(String commentContent, User user, Comment selectedComment){
        Comment newComment = new Comment(commentContent, user, selectedComment);
        this.selectedComment.addComment(newComment);
    }
    
    public void addNotification(){
         noti.add(new Announcement("admin","admin","NOTE : Assign assignment to tutor."));
    }
    
    public void addPayment(){
       //i have to cop this whole thing because i need courses to make course registers and we dont have a real database to make course regs"
        

       learner.get(0).addPayment(new Payment("1",learner.get(0).getRegisteredCourse().get(0)));
       learner.get(1).addPayment(new Payment("1",learner.get(1).getRegisteredCourse().get(0)));

   }
   
}
