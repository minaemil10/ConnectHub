/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Login {

  
    public User accessUser (String email, String Password, ArrayList<User> users ){
        for(User u : users){
            if(u.getPassword().equals(Password) && u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }
   
}
