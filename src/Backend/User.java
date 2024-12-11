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
    private ArrayList<String> myPosts = new ArrayList<>();
    private ArrayList<String> myStories;
    private ArrayList<String> myGroups;
    private ArrayList<String> groupRequests;
    private ArrayList<String> groupsLeftByMe;
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
        friends = new ArrayList<>();
        Blocked = new ArrayList<>();
        received = new ArrayList<>();
        sent = new ArrayList<>();
        myStories = new ArrayList<>();
        this.myGroups = new ArrayList<>();
        this.groupsLeftByMe = new ArrayList<>();
        this.groupRequests = new ArrayList<>();
        moveFriends();
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
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
                if (hex.length() == 1) {
                    hexString.append('0');
                }
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
        moveFriends();
        return friends;
    }

    public ArrayList<String> getMyPosts() {
        return myPosts;
    }

    public ArrayList<Relationship> getBlocked() {
        moveFriends();
        return Blocked;
    }

    public ArrayList<Relationship> getReceived() {
        moveFriends();
        return received;
    }

    public ArrayList<Relationship> getSent() {
        return sent;
    }

    public void sendRelation(Relationship relationship) {
        sent.add(relationship);
    }

    public void addFriendRelation(Relationship relationship) {
        friends.add(relationship);
    }

    public void receiveRelation(Relationship relationship) {
        received.add(relationship);
    }

    public void deleteRelation(Relationship relationship) {
        received.remove(relationship);
    }

    public boolean acceptFriendRequest(String senderID) {
        moveFriends();
        for (int i = 0; i < received.size(); i++) {
            if (received.get(i).getrelationWith().equalsIgnoreCase(senderID)) {
                received.get(i).setFriend();
                friends.add(received.get(i));
                received.remove(received.get(i));
                return true;
            }

        }
        return false;
    }

    public boolean cancelFriendRequest(String senderID) {
        for (int i = 0; i < received.size(); i++) {
            if (received.get(i).getrelationWith().equalsIgnoreCase(senderID)) {
                received.get(i).setCancel();
                received.remove(received.get(i));
                
            }
        }
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).getrelationWith().equalsIgnoreCase(senderID)) {
                friends.get(i).setCancel();
                friends.remove(friends.get(i));
                
            }
        }
        return true;
    }

    public boolean blockFriend(String receiverID) {
        moveFriends();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).getrelationWith().equalsIgnoreCase(receiverID)) {
                friends.get(i).setBlock();
                Blocked.add(friends.get(i));
                friends.remove(friends.get(i));
                return true;
            }
        }
        return false;
    }

    public void addPost(String contentID) {

        myPosts.addFirst(contentID);
    }

    public void addStory(String contentID) {
        myStories.addFirst(contentID);
    }

    public ArrayList<String> getMyStories() {
        return myStories;
    }

    public void removeContent(String contentID) {
        myPosts.remove(contentID);
    }

    private void moveFriends() {
        for (int i = 0; i < sent.size(); i++) {
            if (sent.get(i).getRelation().equalsIgnoreCase("Friend")) {
                friends.add(sent.get(i));
                sent.remove(sent.get(i));
            }
            else if(sent.get(i).getRelation().equalsIgnoreCase("Cancel")){
                sent.remove(i);
            }

        }
        for (int i = 0; i < friends.size(); i++) {
             if(friends.get(i).getRelation().equalsIgnoreCase("Cancel")){
                friends.remove(i);
            }

        }
               
        for (int i = 0; i < friends.size(); i++) {
             if(friends.get(i).getRelation().equalsIgnoreCase("Block")){
                friends.remove(i);
            }

        }
        
    }
    
    
    /*groups functionionality methods*/

    public ArrayList<String> getAllMyGroups() {
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(this.myGroups);
        return temp;
    }

    public ArrayList<String> getAllGroupsLeftByMe() {
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(this.groupsLeftByMe);
        return temp;
    }

    public ArrayList<String> getAllGroupRequests() {
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(this.groupRequests);
        return temp;
    }

    public void addGroupRequest(String groupID){
        groupRequests.add(groupID);
    }
   
    public void removeGroupRequest(String groupID){
        groupRequests.remove(groupID);
    }
    
    public void joinGroup(String groupID){
        groupRequests.remove(groupID);
        myGroups.add(groupID);
        groupsLeftByMe.remove(groupID);
    }
    
    public void leaveGroup(String groupID){
        myGroups.remove(groupID);
        groupsLeftByMe.add(groupID);
    }

    public void removeGroup(String groupID){
         myGroups.remove(groupID);
    }
}
