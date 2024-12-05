/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.time.LocalDate;
import java.util.ArrayList;

import Backend.DataBase.DataBaseOBJ;
import Backend.Friend_Management.Relationship;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author carls
 */
public class User implements DataBaseOBJ {
    private String userId;
    private String email;
    private String userName;
    private String password;
    private LocalDate DateOfBirth;
    private Boolean status;
    private String profilePhoto;
    private String coverPhoto;
    private String bio;

    private ArrayList<String> myPosts;
    private ArrayList<Relationship> friends;
    private ArrayList<Relationship> Blocked;
    private ArrayList<Relationship> received;
    private ArrayList<Relationship> sent;
    /*m7tagen arraylist ll friend 3lshan deh el httn3t lama a7tag a3rf men el online*/
    /*lw 3mlna keda hn8yr fel relations w m7tagen nn2l kol relation l arraylist*/
    public User(String userId, String email, String userName, String password, LocalDate DateOfBirth) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.setPassword(password);
        this.DateOfBirth = DateOfBirth;
        friends=new ArrayList<>();
        Blocked=new ArrayList<>();
        received=new ArrayList<>();
        sent=new ArrayList<>();
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

    public boolean checkPassword(String password) {
        return this.password.equals(hashPassword(password));
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }
    
     private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
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
    public void sendRelation ( Relationship relationship){
        sent.add(relationship);
    }
    public void receiveRelation ( Relationship relationship){
        received.add(relationship);
    }
    public void deleteRelation (Relationship relationship){
        received.remove(relationship);
    }
    public boolean acceptFriendRequest(String senderID){
        for (int i = 0; i < received.size(); i++) {
            if(received.get(i).getrelationWith().equalsIgnoreCase(senderID)){
                received.get(i).setFriend();
                friends.add(received.get(i));
                received.remove(received.get(i));
                return true;
            }

        }
        return false;
    }
    public boolean cancelFriendRequest(String senderID){
        for (int i = 0; i < received.size(); i++) {
            if(received.get(i).getrelationWith().equalsIgnoreCase(senderID)){
                received.get(i).setCancel();
                received.remove(received.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean blockFriend(String receiverID){
        for (int i = 0; i < friends.size(); i++) {
            if(friends.get(i).getrelationWith().equalsIgnoreCase(receiverID)){
                friends.get(i).setBlock();
                Blocked.add(friends.get(i));
                friends.remove(friends.get(i));
                return true;
            }
        }
        return false;
    }
    public void addContent(String contentID){
        myPosts.add(contentID);
    }
    public void removeContent(String contentID){myPosts.remove(contentID);}
}
