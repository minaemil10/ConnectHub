/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Validation.Validator;

/**
 *
 * @author carls
 */
public class ProfileManger {
    private User user;

    public ProfileManger(User user) {
        this.user = user;
    }
    public boolean changeEmail (String email){
        boolean isVaildEmail = Validator.isEmail(email);
        if(isVaildEmail){
        user.setEmail(email);
        return true;
        }
        return false;
    }
    public boolean changeUserName (String userName){
        user.setUserName(userName);
        return true;
    }
    public boolean changePassword(String password){
        boolean isValidPassword = Validator.isPassword(password);
        if(isValidPassword){
        user.setPassword(password);
        return true;
        }
        return false;
    }
    public boolean changeProfilePhoto(String profilePhoto){
        user.setProfilePhoto(profilePhoto);
        return true;
    }
    public boolean changeCoverPhoto(String CoverPhoto) {
        user.setCoverPhoto(CoverPhoto);
        return true;
    }
    public boolean changeBio (String bio){
        user.setBio(bio);
        return true;
    }
}
