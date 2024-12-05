package Backend;

import Backend.Friend_Management.friendRequest;
import Validation.Validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class AppManager {
    private ArrayList<User> Data;
    private ArrayList<Content>contents;
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
    public boolean sendFriendRequest(String receiver){
        /*need to handle if the user is already in the array list*/
        for (int i = 0; i < Data.size(); i++) {
            if(Data.get(i).getUserId().equalsIgnoreCase(receiver)){
                new friendRequest(currentUser.getUserId(), Data.get(i).getUserId()).make(currentUser,Data.get(i));
                return true;
            }

        }
        return false;

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
    /*posts manager*/
    public boolean createPost(String photo, String text){
        Post post = new Post(photo,currentUser.getUserId(),text);
        currentUser.addContent(post.getContentID());
        contents.add(post);
        return true;
    }
    public boolean createStory(String photo, String text){
        Story story = new Story(photo,currentUser.getUserId(),text);
        currentUser.addContent(story.getContentID());
        contents.add(story);
        return true;
    }
    public Content getContentWithID(String contentID){
        for (int i = 0; i < contents.size(); i++) {
            if(contents.get(i).getContentID().equalsIgnoreCase(contentID)){
                return contents.get(i);
            }

        }
        return null;
    }
    public ArrayList<Content> getContentWithAuthor(String authorID){
        ArrayList<Content> authorContent=new ArrayList<>();
        for (int i = 0; i < contents.size(); i++) {
            if(contents.get(i).getAuthorID().equalsIgnoreCase(authorID)){
                authorContent.add(contents.get(i));
            }

        }
        return authorContent;
    }
    public void deleteStory(){
        LocalDateTime currentTime = LocalDateTime.now();
        for (int i = 0; i < contents.size(); i++) {
            Content temp = contents.get(i);
            if (temp.getContentID().split("-")[0].equalsIgnoreCase("S") && currentTime.isAfter(temp.getTimePosted().plusHours(24))) {
                currentUser.removeContent(temp.getContentID());
                contents.remove(temp);
            }
        }
    }

    /*database management*/








}
