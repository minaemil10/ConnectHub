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
    private static int counter;
    
    public User addUser (String email, String password, String userName,LocalDate dateOfBirth, ArrayList <User> users ){
        Validator v = new Validator();
        // Checking if the email is already signed
        for(User u : users){
               if(u.getEmail().equals(email)){
                   return null;
               }
           }
            // Validation of password and EMAIL
           if(v.isEmail(email) && v.isPassword(password)){
               counter++;
               User user = new User("U"+counter, email, userName, password, dateOfBirth);
               return user;
           }
           else
               return null;
    }
    /*to set the id after reading file*/
    public static void setCounter(int counter) {
        SignUp.counter = counter;
    }
}
