/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author User
 */
public class Logout {
    
    public boolean logout (User user){
        if(user!=null){
        user.setStatus(false);
        return true;}
        return false;
    }
    
}
