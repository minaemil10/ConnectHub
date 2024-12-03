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
    public void changeEmail (String email){
        boolean isVaildEmail = Validator.isEmail(email);
        if(isVaildEmail){
        user.setEmail(email);
        }
    }
    public void changeUserName (String userName){
        user.setUserName(userName);
    }
    public void changePassword(String password){
        boolean isValidPassword = Validator.isPassword(password);
        if(isValidPassword){
        user.setPassword(password);
        }
    }
    public void changeProfilePhoto(String profilePhoto){
        user.setProfilePhoto(profilePhoto);
    }
    public void changeCoverPhoto(String CoverPhoto) {
        user.setCoverPhoto(CoverPhoto);
    }
    public void ChangeBio (String bio){
        user.setBio(bio);
    }
}
