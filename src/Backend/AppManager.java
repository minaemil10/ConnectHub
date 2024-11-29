package Backend;

import Backend.Friend_Management.friendRequest;
import Validation.Validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class AppManager {
    private ArrayList<User> Data;
    private User currentUser;

    public AppManager() {
        currentUser=null;
        Data = new ArrayList<>();
    }
    public void signUpUser(String userId , String email, String password, String userName, LocalDate regestrationTime, Boolean status, ArrayList <User> users ){
        Data.add(new SignUp().addUser(userId,email,password,userName,regestrationTime,status,users));
    }
    public void loginUser(String email, String Password){
        currentUser=new Login().accessUser(email,Password,Data);
    }
    public void LogoutUser(){
        boolean logout = new Logout().logout(currentUser);
    }
    public void sendFriendRequest(User receiver){
        new friendRequest(currentUser.getUserId(), receiver.getUserId()).make(currentUser,receiver);
    }
    public void acceptFriendRequest(String senderID){


    }
    public void cancelFriendRequest(String senderID){

    }
    public void blockFriend(String userID){

    }
    public boolean changeEmail(String email){
        if(Validator.isEmail(email)){
            currentUser.setEmail(email);
            return true;
        }
        return false;
    }




}
