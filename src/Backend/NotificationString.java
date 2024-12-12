/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Backend.Friend_Management.PostString;

/**
 *
 * @author User
 */
public class NotificationString {
    private String name;
    private String type;
    private String userId;
    private String profilePhoto;
    private String user;
    private PostString post;
    private String status; 
    
    public NotificationString(String type, String name, String userId, String profilePhoto) {
        this.name = name;
        this.userId = userId;
        this.profilePhoto = profilePhoto;
 
    }
    public NotificationString(String type, String status) {
        this.status = status;
    }
    public NotificationString(String type, String user, PostString post) {
        this.user = user;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public PostString getPost() {
        return post;
    }

    public void setPost(PostString post) {
        this.post = post;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
