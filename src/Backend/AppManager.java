package Backend;

import Backend.Friend_Management.friendRequest;
import Validation.Validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class AppManager {
    private ArrayList<User> Data;
    private User currentUser;
    private ProfileManger profileManger;

    public AppManager() {
        currentUser=null;
        Data = new ArrayList<>();
    }
    /*accessing app*/
    public void signUpUser(int userId , String email, String password, String userName, LocalDate regestrationTime, Boolean status, ArrayList <User> users ){
        /*ntfahm fe mwdo3 el id*/
        Data.add(new SignUp().addUser(userId,email,password,userName,regestrationTime,status,users));
    }
    public void loginUser(String email, String Password){
        currentUser=new Login().accessUser(email,Password,Data);
        profileManger =new ProfileManger(currentUser);
    }
    public void LogoutUser(){
        boolean logout = new Logout().logout(currentUser);
    }
    /*friend requests*/
    public void sendFriendRequest(User receiver){
        /*need to handle if the user is already in the array list*/
        new friendRequest(currentUser.getUserId(), receiver.getUserId()).make(currentUser,receiver);
    }
    public boolean acceptFriendRequest(String senderID){
        return currentUser.acceptFriendRequest(senderID);
    }
    public boolean cancelFriendRequest(String senderID){
        return currentUser.cancelFriendRequest(senderID);
    }
    public boolean blockFriend(String userID){
        return currentUser.blockFriend(userID);
    }
    /*Profile Manager*/
    public boolean changeEmail(String email){
        return profileManger.changeEmail(email);

    }
    public boolean changeUsername(String username){
        return profileManger.changeUserName(username);
    }
    public boolean changePassword(String password){
        return profileManger.changePassword(password);
    }
    public boolean changeProfilePhoto(String profilePhoto){
        return profileManger.changeProfilePhoto(profilePhoto);
    }
    public boolean changeCoverPhoto(String coverPhoto){
        return profileManger.changeCoverPhoto(coverPhoto);
    }
    public boolean changeBio(String bio){
        return profileManger.changeBio(bio);
    }
    /*content management*/
    public boolean createPost(String contentID, String authorID, String text){
        return false;
    }


    /*database management*/







}
