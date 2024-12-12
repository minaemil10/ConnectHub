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
    private String userId;
    private String profilePhoto;
    private static int num = 0;
    private String Id;
    public Notification(String name, String userId, String profilePhoto) {
        this.name = name;
        this.userId = userId;
        this.profilePhoto = profilePhoto;
        num++;
        Id = "n"+num; 
        
    }
    
    
    
    public  String getId() {
        return Id;
    }
    
}
