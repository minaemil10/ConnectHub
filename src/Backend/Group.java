/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;

/**
 *
 * @author Mnw Emile
 */
public class Group {

    private String groupName;
    private String groupID;
    private String description;
    private String groupPhoto;
    private final String CREATOR_ID;
    private ArrayList<String> admins;
    private ArrayList<String> users;
    private ArrayList<String> pendingRequests;
    private ArrayList<String> posts;
    private ArrayList<String> pendingPosts;
    private static int groupsCount = 0;

    public Group(String groupName, String CREATOR_ID) {
        this.groupName = groupName;
        this.CREATOR_ID = CREATOR_ID;
        groupsCount++;
        this.groupID = "G" + groupsCount;
        this.users = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.pendingPosts = new ArrayList<>();
        this.pendingRequests = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public Group(String groupName, String description, String groupPhoto, String CREATOR_ID) {
        this.groupName = groupName;
        this.description = description;
        this.groupPhoto = groupPhoto;
        this.CREATOR_ID = CREATOR_ID;
        groupsCount++;
        this.groupID = "G" + groupsCount;
        this.users = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.pendingPosts = new ArrayList<>();
        this.pendingRequests = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    /*checking if id Exist in the group*/
    public boolean isUser(String id) {
        for (String s : this.users) {
            if (s.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdmin(String id) {
        for (String s : this.admins) {
            if (s.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOwner(String id) {
        if (this.CREATOR_ID.equals(id)) {
            return true;
        }
        return false;
    }

    public boolean isPendingRequest(String id) {
        for (String s : this.pendingRequests) {
            if (s.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPendingPost(String id) {
        for (String s : this.pendingPosts) {
            if (s.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPost(String id) {
        for (String s : this.posts) {
            if (s.equals(id)) {
                return true;
            }
        }
        return false;
    }

    /*required actions in group*/
    //members managment
    public void addMember(String id) {
        pendingRequests.add(id);
    }

    public void acceptMember(String id) {
        if (isPendingRequest(id)) {
            pendingRequests.remove(id);
            users.add(id);
        }
    }
    
    public void declineMember(String id) {
        if (isPendingRequest(id)) {
            pendingRequests.remove(id);
        }
    }


    public void removeMember(String id) {
        if (isUser(id)) {
            users.remove(id);
        }
    }

    public void promoteUserToAdmin(String id) {
        if (isUser(id)) {
            users.remove(id);
            admins.add(id);
        }
    }

    public void demoteAdminToUser(String id) {
        if (isAdmin(id)) {
            admins.remove(id);
            users.add(id);
        }
    }

    //postsManagment
    public void addPostOfUser(String id) {
        if (!isPendingPost(id)) {
            this.pendingPosts.add(id);
        }
    }

    public void addPostOfAdmin(String id) {
        if (!isPost(id)) {
            this.posts.add(id);
        }
    }
    
    public void acceptPost(String id){
        if(isPendingPost(id)){
            this.pendingPosts.remove(id);
            this.posts.add(id);
        }
    }
    
    public void declinePost(String id){
        if(isPendingPost(id)){
            this.pendingPosts.remove(id);
        }
    }

    public void removePost(String id){
        if(isPost(id)){
            posts.remove(id);
        }
    }
}
