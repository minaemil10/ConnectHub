/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Backend.DataBase.DataBaseOBJ;

/**
 *
 * @author User
 */
public class Notification implements DataBaseOBJ{
    private String name;
    private String type;
    private String userId;
    private String profilePhoto;
    private static int num = 0;
    private String Id;
    private String user;
    private Content post;
    private String status; 
    public Notification(String type, String name, String userId, String profilePhoto) {
        this.name = name;
        this.userId = userId;
        this.profilePhoto = profilePhoto;
        num++;
        Id = "n"+num; 
    }

    public Notification(String type, String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Notification(String type, String user, Content post) {
        this.user = user;
        this.post = post;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public static void setNum(int num) {
        Notification.num = num;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public static int getNum() {
        return num;
    }

    public String getUser() {
        return user;
    }

    public void setPost(Content post) {
        this.post = post;
    }

    public Content getPost() {
        return post;
    }

    public  String getId() {
        return Id;
    }
    
}
