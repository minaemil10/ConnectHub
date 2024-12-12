/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Friend_Management;

/**
 *
 * @author beroo
 */
public class UserSearch {
    private String username;
    private String relation;
    private String ID;
    private String photo;

    public UserSearch(String username, String relation, String ID, String photo) {
        this.username = username;
        this.relation = relation;
        this.ID = ID;
        this.photo = photo;
    }

   

    public String getPhotoString() {
        return photo;
    }


    public String getUsernameString() {
        return username;
    }

    public String getIdString() {
        return ID;
    }

    public String getRelationString() {
        return relation;
    }  
}
