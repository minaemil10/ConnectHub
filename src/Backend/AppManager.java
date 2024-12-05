package Backend;

import Backend.Friend_Management.friendRequest;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AppManager {
    private ArrayList<User> Data;
    private ArrayList<Post>posts;
    private ArrayList<Story>stories;
    private User currentUser;
    private ProfileManger profileManger;

    public AppManager(ArrayList<User> Data,ArrayList<Post>posts,ArrayList<Story>stories) {
        currentUser=null;
        this.Data = Data;
        this.posts=posts;
        this.stories=stories;
        deleteStory();
    }
    /*accessing app*/
    public void signUpUser(int userId , String email, String password, String userName, LocalDate registrationTime, Boolean status, ArrayList <User> users ){
        /*ntfahm fe mwdo3 el id*/
        Data.add(new SignUp().addUser(email,password,userName,registrationTime,status,users));
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
        posts.add(post);
        return true;
    }
    public boolean createStory(String photo, String text){
        Story story = new Story(photo,currentUser.getUserId(),text);
        currentUser.addContent(story.getContentID());
        stories.add(story);
        return true;
    }
    public Story getStoryWithID(String storyID){
        deleteStory();
        for (int i = 0; i < stories.size(); i++) {
            if(stories.get(i).getContentID().equalsIgnoreCase(storyID)){
                return stories.get(i);
            }

        }
        return null;
    }
    public Content getPostWithID(String postID){
        for (int i = 0; i < stories.size(); i++) {
            if(stories.get(i).getContentID().equalsIgnoreCase(postID)){
                return posts.get(i);
            }

        }
        return null;
    }


    public ArrayList<Story> getStoriesWithAuthor(String authorID){
        deleteStory();
        ArrayList<Story> authorContent=new ArrayList<>();
        for (int i = 0; i < stories.size(); i++) {
            if(stories.get(i).getAuthorID().equalsIgnoreCase(authorID)){
                authorContent.add(stories.get(i));
            }
        }
        return authorContent;
    }
    public ArrayList<Post> getPostsWithAuthor(String authorID){
        ArrayList<Post> authorContent=new ArrayList<>();
        for (int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getAuthorID().equalsIgnoreCase(authorID)){
                authorContent.add(posts.get(i));
            }
        }
        return authorContent;
    }
    public void deleteStory(){
        LocalDateTime currentTime = LocalDateTime.now();
        for (int i = 0; i < stories.size(); i++) {
            Content temp = stories.get(i);
            if (temp.getContentID().split("-")[0].equalsIgnoreCase("S") && currentTime.isAfter(temp.getTimePosted().plusHours(24))) {
                currentUser.removeContent(temp.getContentID());
                stories.remove(temp);
            }
        }
    }


    /*can the user modify the content??*/







}
