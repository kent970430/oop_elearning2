/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Classes.Course;
import Classes.Forum;
import Classes.Thread;

/**
 *
 * @author kueky
 */
public class testingMethodClass {
    Database database = new Database();
    
     public void loopCurentCourse(){
          for(Course courseData : database.course){
            System.out.println(courseData);
        }
      }
      public void loopSubject(){
          int counter = 0;
          for(Forum forum : database.forum){
              if(forum.getForumType() == "Subject"){
                  System.out.println(forum);
                  counter++;
              }
          }
          
          System.out.println(counter);
      }
      public void loopThread(){
          for(Forum forum:database.forum){
            if(!forum.getThreadList().isEmpty()){
                for(Thread thread : forum.getThreadList()){
                    System.out.println(forum.getCourse().getCourseName());
                    System.out.println(forum.getForumType());
                    System.out.println(thread);
                    System.out.println("");
                }
            }

        }
      }
}
