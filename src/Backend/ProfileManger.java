/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

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
        // isvaild checker
        user.setEmail(email);
    }
    public void changeUserName (String userName){
        user.setUserName(userName);
    }
    public void changePassword(String password){
        // is vaild checker
        user.setPassword(password);
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
