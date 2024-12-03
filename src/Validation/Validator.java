/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

/**
 *
 * @author Mnw Emile
 */
public class Validator {
    public static boolean isEmail(String email){
        if (email == null || email.isEmpty()) {
            return false;
        }
    
        // Check if the email contains exactly one '@' character
        String [] emailSplit = email.split("@");
        if (emailSplit.length != 2) {
            return false;
        }
       
         String localPart = emailSplit[0];
        String domainPart = emailSplit[1];

        //check localPart is not empty and doesnt statrt or end with a dot
        if ( localPart.startsWith(".") || localPart.endsWith(".")) {
            return false;
        }

        //check domain part isnot empty and has at least one dot that's not in the start pr the end
        if (domainPart.isEmpty() || domainPart.indexOf('.') == -1 || domainPart.startsWith(".") || domainPart.endsWith(".")) {
            return false;
        }

        // Check characters in local part
        for (char c : localPart.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || c == '.' || c == '_' || c == '-' || c == '+')) {
                return false;
            }
        }

        // Check characters in domain part
        for (char c : domainPart.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || c == '.' || c == '-')) {
                return false;
            }
        }

        return true;
    }
    
    public static boolean isPassword(String password){
       if(password == null || password.isEmpty()){
           return false;
       }
       
       re
    }
    
}

