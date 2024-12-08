package Backend;

import Backend.Friend_Management.PostString;
import Backend.Friend_Management.RelationString;

import Backend.Friend_Management.Relationship;
import Backend.Friend_Management.friendRequest;
import java.time.Duration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AppManager {

    private ArrayList<User> Data;
    private ArrayList<Post> posts;
    private ArrayList<Story> stories;
    private ArrayList<friendRequest> request;
    private ArrayList<Group> groups;
    private User currentUser;
    private ProfileManger profileManger;
    

    public AppManager(ArrayList<User> Data, ArrayList<Post> posts, ArrayList<Story> stories, ArrayList<friendRequest> request,ArrayList<Group> groups) {
        currentUser = null;
        this.Data = Data;
        this.posts = posts;
        this.stories = stories;
        this.request = request;
        this.groups = groups;
    }

    /*accessing app*/
    public boolean signUpUser(String email, String password, String userName, LocalDate registrationTime) {
        /*ntfahm fe mwdo3 el id*/
        User temp = new SignUp().addUser(email, password, userName, registrationTime, Data);
        currentUser = temp;
        if (temp == null) {
            return false;
        } else {

            Data.add(temp);
            Server.writeUsers();
            return true;

        }

    }

    public boolean loginUser(String email, String Password) {
        currentUser = new Login().accessUser(email, Password, Data);
        profileManger = new ProfileManger(currentUser);
        deleteStory();
        return currentUser != null;
    }

    public void LogoutUser() {
        boolean logout = new Logout().logout(currentUser);
        clearCancel();
        Server.writeUsers();
        Server.writeContent();
        Server.writeRelationShips();
    }

    /*friend requests*/
    public boolean sendFriendRequest(String receiver) {
        clearCancel();
        /*need to handle if the user is already in the friends*/
        for (int i = 0; i < Data.size(); i++) {
            if (Data.get(i).getUserId().equalsIgnoreCase(receiver)) {
                friendRequest temp = new friendRequest(currentUser.getUserId(), Data.get(i).getUserId());
                temp.make(currentUser, Data.get(i));
                request.add(temp);
                return true;
            }
        }
        return false;
    }

    public boolean acceptFriendRequest(String senderID) {
        clearCancel();
        for (int i = 0; i < request.size(); i++) {
            if (request.get(i).getSenderID().equalsIgnoreCase(senderID) && request.get(i).getReceiverID().equalsIgnoreCase(currentUser.getUserId())) {
                request.get(i).accept();
                currentUser.acceptFriendRequest(senderID);
                return true;
            }

        }
        return false;
    }

    public boolean cancelFriendRequest(String senderID) {
        clearCancel();
        for (int i = 0; i < request.size(); i++) {
            if (request.get(i).getSenderID().equalsIgnoreCase(senderID) && request.get(i).getReceiverID().equalsIgnoreCase(currentUser.getUserId())) {
                currentUser.cancelFriendRequest(senderID);
                request.get(i).decline();
                
                
                return true;
            }

        }

        return true;
    }

    
    public boolean blockFriend(String userID) {
        clearCancel();

        for (int i = 0; i < request.size(); i++) {
            if (request.get(i).getSenderID().equalsIgnoreCase(userID) && request.get(i).getReceiverID().equalsIgnoreCase(currentUser.getUserId())) {
                currentUser.blockFriend(userID);
                request.get(i).blockAndSwitch();
                
                return true;
            } else if (request.get(i).getSenderID().equalsIgnoreCase(currentUser.getUserId()) && request.get(i).getReceiverID().equalsIgnoreCase(userID)) {
                request.get(i).block();
                currentUser.blockFriend(userID);
                return true;
            }

        }

        return true;
    }

    /*Profile Manager*/

    public boolean changePassword(String password) {
        currentUser.setPassword(password);
        return true;
    }

    public boolean changeProfilePhoto(String profilePhoto) {
        currentUser.setProfilePhoto(profilePhoto);
        return true;
    }

    public boolean changeCoverPhoto(String coverPhoto) {
        currentUser.setCoverPhoto(coverPhoto);
        return true;
    }

    public boolean changeBio(String bio) {
        currentUser.setBio(bio);
        return true;
    }

    public String getProfilePhoto() {
        return currentUser.getProfilePhoto();
    }

    public String getCoverPhoto() {
        return currentUser.getCoverPhoto();
    }

    public String getBio() {
        return currentUser.getBio();
    }

    public boolean checkPassword(String password) {
        return currentUser.checkPassword(password);
    }

    /*content management*/
 /*posts manager*/
    public boolean createPost(String photo, String text) {
        Post post = new Post(photo, currentUser.getUserId(), text);
        currentUser.addPost(post.getContentID());
        posts.add(post);
        return true;
    }

    public boolean createStory(String photo, String text) {
        Story story = new Story(photo, currentUser.getUserId(), text);
        currentUser.addStory(story.getContentID());
        stories.add(story);
        return true;
    }

    public Story getStoryWithID(String storyID) {
        // deleteStory();
        for (int i = 0; i < stories.size(); i++) {
            if (stories.get(i).getContentID().equalsIgnoreCase(storyID)) {
                return stories.get(i);
            }

        }
        return null;
    }

    public Content getPostWithID(String postID) {
        for (int i = 0; i < stories.size(); i++) {
            if (stories.get(i).getContentID().equalsIgnoreCase(postID)) {
                return posts.get(i);
            }

        }
        return null;
    }

    public ArrayList<Post> getPostsWithAuthor(String authorID) {
        ArrayList<Post> authorContent = new ArrayList<>();
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getAuthorID().equalsIgnoreCase(authorID)) {
                authorContent.add(posts.get(i));
            }
        }
        return authorContent;
    }

    public void deleteStory() {
        LocalDateTime currentTime = LocalDateTime.now();
        for (int i = 0; i < stories.size(); i++) {
            Content temp = stories.get(i);
            
            Duration duration = Duration.between(temp.getTimePosted(), currentTime);
            //System.out.print(duration.toHours());
            if (duration.toHours()>=24) {
                currentUser.removeContent(temp.getContentID());
                stories.remove(temp);
                
            }
        }
    }

    /*can the user modify the content??*/
 /*get the online friends*/
    public ArrayList<Online> getOnline() {
        ArrayList<Online> onlinefriends = new ArrayList<>();
        for (int i = 0; i < currentUser.getFriends().size(); i++) {
            for (int j = 0; j < Data.size(); j++) {
                /*searching for the user using id*/
                if (Data.get(j).getUserId().equalsIgnoreCase(currentUser.getFriends().get(i).getrelationWith())) {
                    onlinefriends.add(new Online(Data.get(j).getStatus(), Data.get(j).getUserName()));

                }
            }
        }
        return onlinefriends;
    }

    /*get the friends*/
    public ArrayList<RelationString> getFriends() {

        ArrayList<RelationString> relationStrings = new ArrayList<>();
        for (int i = 0; i < currentUser.getFriends().size(); i++) {
            for (int j = 0; j < Data.size(); j++) {
                /*searching for the user using id*/
                if (Data.get(j).getUserId().equalsIgnoreCase(currentUser.getFriends().get(i).getrelationWith())) {
                    relationStrings.add(new RelationString(Data.get(j).getUserName(), Data.get(j).getProfilePhoto(), Data.get(j).getUserId()));

                }
            }
        }
        return relationStrings;
    }

    public ArrayList<RelationString> getRequests() {
        ArrayList<RelationString> relationStrings = new ArrayList<>();
        for (int i = 0; i < currentUser.getReceived().size(); i++) {
            for (int j = 0; j < Data.size(); j++) {
                /*searching for the user using id*/
                if (Data.get(j).getUserId().equalsIgnoreCase(currentUser.getReceived().get(i).getrelationWith())) {
                    relationStrings.add(new RelationString(Data.get(j).getUserName(), Data.get(j).getProfilePhoto(), Data.get(j).getUserId()));
                }
            }
        }
        return relationStrings;
    }

    public ArrayList<RelationString> Blocked() {
        ArrayList<RelationString> relationStrings = new ArrayList<>();
        for (int i = 0; i < currentUser.getBlocked().size(); i++) {
            for (int j = 0; j < Data.size(); j++) {
                /*searching for the user using id*/
                if (Data.get(j).getUserId().equalsIgnoreCase(currentUser.getBlocked().get(i).getrelationWith())) {
                    relationStrings.add(new RelationString(Data.get(j).getUserName(), Data.get(j).getProfilePhoto(), Data.get(j).getUserId()));
                }
            }
        }
        return relationStrings;
    }

    /**/
    public ArrayList<PostString> getPosts() {
        ArrayList<PostString> posts = new ArrayList<>();
        for (int i = 0; i < currentUser.getFriends().size(); i++) {
            for (int j = 0; j < this.posts.size(); j++) {
                if (this.posts.get(j).getAuthorID().equalsIgnoreCase(currentUser.getFriends().get(i).getrelationWith())) {
                    /*searching for the user using id*/
                    for (int k = 0; k < Data.size(); k++) {
                        if (Data.get(k).getUserId().equalsIgnoreCase(this.posts.get(j).getAuthorID())) {
                            posts.add(new PostString(Data.get(k).getUserName(), this.posts.get(j).getText(), this.posts.get(j).getPhoto(), this.posts.get(j).getTimePosted().toString()));
                        }
                    }
                }
            }
        }
        System.out.print(posts.size());
        return posts;
    }

    public ArrayList<PostString> getMyPosts() {
        ArrayList<PostString> posts = new ArrayList<>();
        for (int i = 0; i < currentUser.getMyPosts().size(); i++) {
            for (int j = 0; j < this.posts.size(); j++) {
                if (currentUser.getMyPosts().get(i).equalsIgnoreCase(this.posts.get(j).getContentID())) {
                    posts.add(new PostString(currentUser.getUserName(), this.posts.get(j).getText(), this.posts.get(j).getPhoto(), this.posts.get(j).getTimePosted().toString()));
                }

            }
        }
        return posts;
    }

    public ArrayList<PostString> getMyStories() {
        ArrayList<PostString> stories = new ArrayList<>();
        for (int i = 0; i < currentUser.getMyStories().size(); i++) {
            for (int j = 0; j < this.stories.size(); j++) {
                if (currentUser.getMyStories().get(i).equalsIgnoreCase(this.stories.get(j).getContentID())) {
                    stories.add(new PostString(currentUser.getUserName(), this.stories.get(j).getText(), this.stories.get(j).getPhoto(), this.stories.get(j).getTimePosted().toString()));
                }

            }
        }
        return stories;
    }

    public ArrayList<PostString> getStories() {
        deleteStory();
        ArrayList<PostString> stories = new ArrayList<>();
        for (int i = 0; i < currentUser.getFriends().size(); i++) {
            for (int j = 0; j < this.stories.size(); j++) {
                if (this.stories.get(j).getAuthorID().equalsIgnoreCase(currentUser.getFriends().get(i).getrelationWith())) {


                    /*searching for the user using id*/
                    for (int k = 0; k < Data.size(); k++) {
                        if (Data.get(k).getUserId().equalsIgnoreCase(this.stories.get(j).getAuthorID())) {
                            stories.add(new PostString(Data.get(k).getUserName(), this.stories.get(j).getText(), this.stories.get(j).getPhoto(), this.stories.get(j).getTimePosted().toString()));
                        }
                    }

                }
            }
        }
       // System.out.print(stories.size());
        return stories;
    }

    public ArrayList<RelationString> friendSuggest() {
        ArrayList<RelationString> suggestion = new ArrayList<>();
        ArrayList<Relationship> temp = new ArrayList<>();

        temp.addAll(currentUser.getFriends());
        temp.addAll(currentUser.getBlocked());
        temp.addAll(currentUser.getReceived());
temp.addAll(currentUser.getSent());
        if (temp.isEmpty()) {

            for (int i = 0; i < Data.size(); i++) {
                if (!currentUser.getUserId().equalsIgnoreCase(Data.get(i).getUserId())) {
                    suggestion.add(new RelationString(Data.get(i).getUserName(), Data.get(i).getProfilePhoto(), Data.get(i).getUserId()));
                }
            }
        } else {
            for (int i = 0; i < temp.size(); i++) {

                for (int j = 0; j < Data.size(); j++) {

                    if (!currentUser.getUserId().equalsIgnoreCase(Data.get(j).getUserId()) && !(temp.get(i).getrelationWith().equalsIgnoreCase(Data.get(j).getUserId()))) {
                        suggestion.add(new RelationString(Data.get(j).getUserName(), Data.get(j).getProfilePhoto(), Data.get(j).getUserId()));
                    }
                }
            }
        }
        for (int i = 0; i < suggestion.size(); i++) {
            for (int k = 0; k < request.size(); k++) {
                /*check if the user is receiver to block*/
                if (currentUser.getUserId().equalsIgnoreCase(request.get(k).getReceiverID()) && request.get(k).getStatus().getRelation().equalsIgnoreCase("Block")&&suggestion.get(i).getIdString().equalsIgnoreCase(request.get(k).getSenderID())) {
                        suggestion.remove(suggestion.get(i));
                }
            }
        }
        return suggestion;
    }

    private void clearCancel() {
        for (int i = 0; i < request.size(); i++) {
            if (request.get(i).getStatus().getRelation().equalsIgnoreCase("Cancel")) {
                request.remove(request.get(i));
            }

        }

    }
    
    
    /*Group Managment methods*/
    //Group creation and attribute editing
   public void createGroup(String name){
       Group group = new Group(name, currentUser.getUserId());
       currentUser.addGroupRequest(group.getGroupID());
       currentUser.joinGroup(group.getGroupID());
       groups.add(group);
   }
   
   public void changeGroupPhoto(String photoPath,String groupID){
       Group group = null;
       for(Group g : groups){
           if(g.getGroupID().equals(groupID)){
               group = g;
               break;
           }
       }
       group.setGroupPhoto(photoPath);
   }
   
   public void changeGroupName(String name,String groupID){
       Group group = null;
       for(Group g : groups){
           if(g.getGroupID().equals(groupID)){
               group = g;
               break;
           }
       }
       group.setGroupName(name);
   }
   
   public void changeGroupDescription(String description,String groupID){
       Group group = null;
       for(Group g : groups){
           if(g.getGroupID().equals(groupID)){
               group = g;
               break;
           }
       }
       group.setDescription(description);
   }
   
   public GroupString getCroupInfo(String id){
       Group group = null;
       for(Group g : groups){
           if(g.getGroupID().equals(id)){
               group = g;
               break;
           }
       }
       return new GroupString(group.getGroupName(), group.getGroupPhoto(), group.getDescription(), group.getGroupID());
   }
   
   public ArrayList<GroupString> getMyGroups(){
        ArrayList<GroupString> data = new ArrayList<>();
       for(String groupId : currentUser.getAllMyGroups()){
           for(Group group : groups){
               if(group.getGroupID().equals(groupId)){
                   data.add(new GroupString(group.getGroupName(), group.getGroupPhoto(), group.getDescription(), group.getGroupID()));
               }
           }
       }
       return data;
   }
   
}
