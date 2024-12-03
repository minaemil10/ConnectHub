/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Validation.Validator;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class SignUp {
    
    
    public User addUser (String userId ,String email, String password, String userName,LocalDate regestrationTime,Boolean status, ArrayList <User> users ){
        Validator v = new Validator();
        // Checking if the email is already signed
        for(User u : users){
               if(u.getEmail().equals(email)){
                   return null;
               }
           }
            // Validation of password and EMAIL
           if(v.isEmail(email) && v.isPassword(password)){
               User user = new User(userId, email, userName, password, regestrationTime);
               return user;
           }
           else
               return null;
    }
}
