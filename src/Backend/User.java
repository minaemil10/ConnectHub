/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.time.LocalDate;
import java.util.ArrayList;
import Backend.Friend_Management.Relationship;

/**
 *
 * @author carls
 */
public class User {
    private static String userId;
    private String email;
    private String userName;
    private String password;
    private LocalDate DateOfBirth;
    private Boolean status;
    private String profilePhoto;
    private String coverPhoto;
    private String bio;
    private ArrayList<Relationship> friends;
    private ArrayList<String> myPosts;

    public User(String userId, String email, String userName, String password, LocalDate DateOfBirth) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.DateOfBirth = DateOfBirth;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<Relationship> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<Relationship> friends) {
        this.friends = friends;
    }

   

    public ArrayList<String> getMyPosts() {
        return myPosts;
    }

    public void setMyPosts(ArrayList<String> myPosts) {
        this.myPosts = myPosts;

    }
    public void addRelation ( Relationship relationship){
        friends.add(relationship);
    }
    public void deleteRelation (Relationship relationship){
        friends.remove(relationship);
    }
}
