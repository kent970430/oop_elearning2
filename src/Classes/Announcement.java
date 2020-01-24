/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author ochen
 */
public class Announcement {
    private String type;
    private String id;
    private String notification;

    public Announcement(String id, String notification) {
    this.id = id;
        this.notification = notification;
    }

    public Announcement(String type, String id, String notification) {
        this.type = type;
        this.id = id;
        this.notification = notification;
    }

    public String getId() {
        return id;
    }

    public String getNotification() {
        return notification;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
