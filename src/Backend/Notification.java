/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import Backend.Friend_Management.friendRequest;
import java.util.ArrayList;
/**
 *
 * @author carls
 */
public class Notification {
    private ArrayList<friendRequest> friendRequest;
    private ArrayList<Group> groupNotification;
    private ArrayList<Post> groupPosts;

    public Notification() {
        this.friendRequest = new ArrayList<>();
        this.groupNotification = new ArrayList<>();
        this.groupPosts = new ArrayList<>();
    }

    public ArrayList<friendRequest> getFriendRequest() {
        return friendRequest;
    }

    public void setFriendRequest(ArrayList<friendRequest> friendRequest) {
        this.friendRequest = friendRequest;
    }

    public ArrayList<Group> getGroupNotification() {
        return groupNotification;
    }

    public void setGroupNotification(ArrayList<Group> groupNotification) {
        this.groupNotification = groupNotification;
    }

    public ArrayList<Post> getGroupPosts() {
        return groupPosts;
    }

    public void setGroupPosts(ArrayList<Post> groupPosts) {
        this.groupPosts = groupPosts;
    }
    
}
