/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import Backend.Friend_Management.RelationString;
import Backend.Friend_Management.friendRequest;
import java.util.ArrayList;
/**
 *
 * @author carls
 */
public class Notification {

    String friendRequests;
    String userId;
    String profilePhoto;
    private static int id;
    public Notification(String friendRequests, String userId, String profilePhoto) {
          this.friendRequests = friendRequests;
          this.userId = userId;
          this.profilePhoto = profilePhoto;
          id++;
    }

    

    int getId() {
            return id;
    }
    
}
