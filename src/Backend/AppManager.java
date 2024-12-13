package Backend;

import Backend.Friend_Management.PostString;
import Backend.Friend_Management.RelationString;

import Backend.Friend_Management.Relationship;
import Backend.Friend_Management.UserSearch;
import Backend.Friend_Management.friendRequest;
import Backend.Group;
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
    private ArrayList<NotificationString> notifications = new ArrayList<>();

    public AppManager(ArrayList<User> Data, ArrayList<Post> posts, ArrayList<Story> stories, ArrayList<friendRequest> request ,ArrayList<Group> groups) {
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
        Server.writeGroups();
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
                Notification notification = new Notification("Friend request", currentUser.getUserName(), currentUser.getUserId(), currentUser.getProfilePhoto());
                temp.setNotificationId(notification.getId());
                Data.get(i).addNotification(notification);
                
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
                removeNotification(request.get(i).getNotificationId());
                return true;
            }

        }
        return false;
    }
    
    //function used to CancelFriend requests
    public boolean cancelFriendRequest(String senderID) {
        clearCancel();
        for (int i = 0; i < request.size(); i++) {
            if (request.get(i).getSenderID().equalsIgnoreCase(senderID) && request.get(i).getReceiverID().equalsIgnoreCase(currentUser.getUserId())) {
                currentUser.cancelFriendRequest(senderID);
                request.get(i).decline();

                removeNotification(request.get(i).getNotificationId());
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

    private Group getGroup(String id) {
        Group group = null;
        for (Group g : groups) {
            if (g.getGroupID().equals(id)) {
                group = g;
                break;
            }
        }
        return group;
    }

    private User getUser(String id) {
        User user = null;
        for (User u : Data) {
            if (u.getUserId().equals(id)) {
                user = u;
                break;
            }
        }
        return user;
    }

    private Post getPost(String id) {
        Post post = null;
        for (Post p : posts) {
            if (p.getContentID().equals(id)) {
                post = p;
                break;
            }
        }
        return post;
    }


    /*Group Managment methods*/
    //Group creation and attribute editing
    public String createGroup(String name) {
        Group group = new Group(name, currentUser.getUserId());
        currentUser.addGroupRequest(group.getGroupID());
        currentUser.joinGroup(group.getGroupID());
        groups.add(group);
        return group.getGroupID();
    }

    public void changeGroupPhoto(String photoPath, String groupID) {
        Group group = null;
        for (Group g : groups) {
            if (g.getGroupID().equals(groupID)) {
                group = g;
                break;
            }
        }
        group.setGroupPhoto(photoPath);
        Notification notification = new Notification("Group Photo Changed", photoPath);
        for(User u : Data){
                if(group.checkUser(u.getUserId()) != null ){
                    if(!currentUser.getUserId().equals(u.getUserId()))
                    u.addNotification(notification);
    }
        }
    }

    public void changeGroupName(String name, String groupID) {
        Group group = getGroup(groupID);
        group.setGroupName(name);
        Notification notification = new Notification("Group Name Changed", name);
        for(User u : Data){
                if(group.checkUser(u.getUserId()) != null ){
                    if(!currentUser.getUserId().equals(u.getUserId()))
                    u.addNotification(notification);
    }
        }
    }

    public void changeGroupDescription(String description, String groupID) {
        Group group = getGroup(groupID);
        group.setDescription(description);
        Notification notification = new Notification("Group Description Changed", description);
        for(User u : Data){
                if(group.checkUser(u.getUserId()) != null ){
                    if(!currentUser.getUserId().equals(u.getUserId()))
                    u.addNotification(notification);
    }
        }
    }

    
    //group data getting 
    public GroupString getCroupInfo(String id) {
        Group group = getGroup(id);
        return new GroupString(group.getGroupName(), group.getGroupPhoto(), group.getDescription(), group.getGroupID(), group.checkUser(currentUser.getUserId()));
    }

    
    public ArrayList<GroupString> getMyGroups() {
        ArrayList<GroupString> data = new ArrayList<>();
        for (String groupId : currentUser.getAllMyGroups()) {
            for (Group group : groups) {
                if (group.getGroupID().equals(groupId)) {
                    data.add(new GroupString(group.getGroupName(), group.getGroupPhoto(), group.getDescription(), group.getGroupID(), group.checkUser(currentUser.getUserId())));
                }
            }
        }
        return data;
    }
    
    public ArrayList<UserSearch> getAllMembersOfGroup(String groupId){
        Group group = getGroup(groupId);
         ArrayList<UserSearch> temp = new ArrayList<>();
        for(User u : Data){
            if(group.checkUser(u.getUserId()) != null){
                temp.add(new UserSearch(u.getUserName(),group.checkUser(u.getUserId()),u.getUserId(),u.getProfilePhoto()));
            }
        }
        return temp;
    }
    
    public ArrayList<UserSearch> getAllAdminsOfGroup(String groupId){
        Group group = getGroup(groupId);
         ArrayList<UserSearch> temp = new ArrayList<>();
        for(User u : Data){
            if((group.checkUser(u.getUserId())!= null) && group.checkUser(u.getUserId()).equals("admin") ){
                temp.add(new UserSearch(u.getUserName(),group.checkUser(u.getUserId()),u.getUserId(),u.getProfilePhoto()));
            }
        }
        return temp;
    }
    
    public ArrayList<UserSearch> getAllUsersOfGroup(String groupId){
        Group group = getGroup(groupId);
         ArrayList<UserSearch> temp = new ArrayList<>();
        for(User u : Data){
            if((group.checkUser(u.getUserId())!= null) &&group.checkUser(u.getUserId()).equals("user")){
                temp.add(new UserSearch(u.getUserName(),group.checkUser(u.getUserId()),u.getUserId(),u.getProfilePhoto()));
            }
        }
        return temp;
    }
    
    public UserSearch getOwnerOfGroup(String groupId){
        Group group = getGroup(groupId);
         ArrayList<UserSearch> temp = new ArrayList<>();
        for(User u : Data){
            if(group.checkUser(u.getUserId()).equals("owner") ){
                return new UserSearch(u.getUserName(),group.checkUser(u.getUserId()),u.getUserId(),u.getProfilePhoto());
            }
        }
        return null;
    }
    
     public ArrayList<UserSearch> getAllPendingRequestsOfGroup(String groupId){
        Group group = getGroup(groupId);
         ArrayList<UserSearch> temp = new ArrayList<>();
        for(User u : Data){
            if((group.checkUser(u.getUserId())!= null) &&group.isPendingRequest(u.getUserId())){
                temp.add(new UserSearch(u.getUserName(),group.checkUser(u.getUserId()),u.getUserId(),u.getProfilePhoto()));
            }
        }
        return temp;
    }
     
     public ArrayList<PostString> getAllPendingPostsOfGroup(String groupId){
        Group group = getGroup(groupId);
         ArrayList<PostString> temp = new ArrayList<>();
        for(Post post : posts){
            if(group.isPendingPost(post.getContentID())){
                temp.add(new PostString(getUser(post.getAuthorID()).getUserName(), post.getText(), post.getPhoto(), post.getTimePosted().toString(), post.getContentID()));
            }
        }
        return temp;
    }
    

    public boolean createGroupPost(String groupId, String photo, String text) {
        Group group = getGroup(groupId);
        if (group.checkUser(currentUser.getUserId()) == null) {
            return false;
        } else if (group.checkUser(currentUser.getUserId()).equals("user")) {
            Post post = new Post(photo, currentUser.getUserId(), text);
            userAddGroupPost(post.getContentID(), groupId);
            posts.add(post);
            for(User u : Data){
            if(group.checkUser(currentUser.getUserId()) != null && (group.checkUser(currentUser.getUserId()).equals("owner") || group.checkUser(currentUser.getUserId()).equals("admin"))){
                Notification n = new Notification("New post need to be Approved", currentUser.getUserName(), post,groupId);
                u.addNotification(n);
                group.setRequestNotifcation(post.getContentID(), n.getId());
            }
            }
            return true;
        } else {
            Post post = new Post(photo, currentUser.getUserId(), text);
            adminAddGroupPost(post.getContentID(), groupId);
            posts.add(post);
            for(User u : Data){
              if(group.checkUser(currentUser.getUserId()) != null){
                Notification n = new Notification("New post added to group", currentUser.getUserName(), post);
                u.addNotification(n);
                }  
            }
            
            return true;
        }
        
    }

    public ArrayList<PostString> getAllGroupPost(String groupId) {
        Group group = getGroup(groupId);
        ArrayList<PostString> tempPosts = new ArrayList<>();
        for (Post post : posts) {
            if (group.isPost(post.getContentID())) { //check if it is a post inside the group
                tempPosts.add(new PostString(getUser(post.getAuthorID()).getUserName(), post.getText(), post.getPhoto(), post.getTimePosted().toString(), post.getContentID()));
            }
        }
        return tempPosts;
    }

    //group Managment Special for Owner
    public void promoteUser(String userId, String groupId) {
        Group group = getGroup(groupId);
        //owner only can make this action
        if (group.checkUser(currentUser.getUserId()) != null && group.isOwner(currentUser.getUserId())) {
            group.promoteUserToAdmin(userId);
        }
    }

    public void demoteAdmin(String userId, String groupId) {
        Group group = getGroup(groupId);
        //owner only can make this action
        if (group.checkUser(currentUser.getUserId()) != null && group.isOwner(currentUser.getUserId())) {
            group.demoteAdminToUser(userId);
        }
    }

    public void deleteGroup(String groupId) {
        Group group = getGroup(groupId);
        //owner only can make this action
        if (group.checkUser(currentUser.getUserId()) != null && group.isOwner(currentUser.getUserId())) {
            for (User user : Data) {
                user.removeGroup(groupId);//remove it from groupsIDs in all users
            }
            groups.remove(group); //remove it from the system data
        }
    }

    public void removeAdminFromGroup(String userId, String groupId) {
        Group group = getGroup(groupId);
        if (group.checkUser(currentUser.getUserId()) != null && group.isOwner(currentUser.getUserId())) {
            demoteAdmin(userId, groupId); //demote him to normal user
            removeMember(userId, groupId);  //removeNormalUser
        }
    }

    //admins and owner specific actions
    public void approveRequest(String userId, String groupId) {
        Group group = getGroup(groupId);
        User user = getUser(userId);
        
        if (group.checkUser(currentUser.getUserId()) != null && (group.checkUser(currentUser.getUserId()).equals("owner") || group.checkUser(currentUser.getUserId()).equals("admin"))) {
            if (group.isPendingRequest(userId)) {
                user.joinGroup(groupId); //change group to mygroups array
                group.acceptMember(userId); //change user from requests to users
                Notification notification = new Notification("approve request",user.getUserName(),user.getUserId(),user.getProfilePhoto() );
                for(User u : Data){
                if(group.checkUser(u.getUserId()) != null ){
                    if(!currentUser.getUserId().equals(u.getUserId()))
                    u.addNotification(notification);
                }
                }
            }
        }
        removeNotification(group.getRequestNotifcation(userId));

    }

    public void approvePostRequest(String postId, String groupId) {
        Group group = getGroup(groupId);
        if (group.checkUser(currentUser.getUserId()) != null && (group.checkUser(currentUser.getUserId()).equals("owner") || group.checkUser(currentUser.getUserId()).equals("admin"))) {
            if (group.isPendingPost(postId)) {
                group.acceptPost(postId); //change user from requests to users
            }
             Content post = getPostWithID(postId);
            Notification  notification = new Notification("approve post request" , currentUser.getUserName(),post );
            for(User u : Data){
                if(group.checkUser(u.getUserId()) != null && !group.checkUser(u.getUserId()).equals("user")){
                    if(!currentUser.getUserId().equals(u.getUserId()))
                    u.addNotification(notification);
                }
            }
            removeNotification(group.getRequestNotifcation(postId));
        }
    }

    public void declineRequest(String userId, String groupId) {
        Group group = getGroup(groupId);
        User user = getUser(userId);
        if (group.checkUser(currentUser.getUserId()) != null && (group.checkUser(currentUser.getUserId()).equals("owner") || group.checkUser(currentUser.getUserId()).equals("admin"))) {
            if (group.isPendingRequest(userId)) {
                user.removeGroupRequest(groupId); //remove request from grouprequests
                group.declineMember(userId); //remove user from requests
                Notification  notification = new Notification("decline user request" ,"Your request have been declined");
                    user.addNotification(notification);
             
            }
        }
        removeNotification(group.getRequestNotifcation(userId));
    }

    public void declinePostRequest(String postId, String groupId) {
        Group group = getGroup(groupId);
        if (group.checkUser(currentUser.getUserId()) != null && (group.checkUser(currentUser.getUserId()).equals("owner") || group.checkUser(currentUser.getUserId()).equals("admin"))) {
            if (group.isPendingPost(postId)) {
                Content post = getPostWithID(postId);
                group.declinePost(postId); //remove post from requests
                Notification  notification = new Notification("decline post request" , currentUser.getUserName(),post );
                currentUser.addNotification(notification);
            }
            removeNotification(group.getRequestNotifcation(postId));
        }
    }

    public void removeMember(String userId, String groupId) {
        Group group = getGroup(groupId);
        User user = getUser(userId);
        if (group.checkUser(currentUser.getUserId()) != null && (group.checkUser(currentUser.getUserId()).equals("owner") || group.checkUser(currentUser.getUserId()).equals("admin"))) {
            if (group.isUser(userId)) { //admins can only remove normal users
                user.removeGroup(groupId); //remove request from grouprequests
                group.removeMember(userId); //remove user from requests
                Notification  notification = new Notification("Remove member", currentUser.getUserName()+" Removed "+ user.getUserName() +"From Group");
             for(User u : Data){
                if(group.checkUser(u.getUserId()) != null){
                    if(!currentUser.getUserId().equals(u.getUserId()))
                        u.addNotification(notification);
                }
            }
            
            }
            
        }
    }

    public void deletePost(String postId, String groupId) {
        Group group = getGroup(groupId);

        if (group.checkUser(currentUser.getUserId()) != null && (group.checkUser(currentUser.getUserId()).equals("owner") || group.checkUser(currentUser.getUserId()).equals("admin"))) {
            group.removePost(postId);
            Notification  notification = new Notification("Delete post", currentUser.getUserName()+" Deleted a post");
            for(User u : Data){
                if(group.checkUser(u.getUserId()) != null){
                    if(!currentUser.getUserId().equals(u.getUserId()))
                        u.addNotification(notification);
                }
            }
        }
    }

    private void adminAddGroupPost(String postId, String groupId) {
        Group group = getGroup(groupId);
        boolean flag = false;
        if (group.checkUser(currentUser.getUserId()) != null && (group.checkUser(currentUser.getUserId()).equals("owner") || group.checkUser(currentUser.getUserId()).equals("admin"))) {
            group.addPostOfAdmin(postId);
            flag = true;
        }
        if(flag){
         Content post = getPostWithID(postId);
         Notification  notification = new Notification("Admin added post to Group",currentUser.getUserName(),post );
        for(User u : Data){
                if(group.checkUser(u.getUserId()) != null){
                    if(!currentUser.getUserId().equals(u.getUserId()))
                     u.addNotification(notification);
                }
            }
        
        }
    }

    // TODO: add editPost code
    public boolean editPost(String postId, String groupId, String text, String photo) {
        Group group = getGroup(groupId);
        if (group.checkUser(currentUser.getUserId()) != null && (group.checkUser(currentUser.getUserId()).equals("owner") || group.checkUser(currentUser.getUserId()).equals("admin"))) {
            if (group.isPost(postId)) {
                Post post = getPost(postId);
                post.setPhoto(photo);
                post.setText(text);
                Notification  notification = new Notification("Edit post", currentUser.getUserName() + " Edited this post", post); // post not content
                for(User u : Data){
                   if(group.checkUser(u.getUserId()) != null){
                       if(!currentUser.getUserId().equals(u.getUserId()))
                       u.addNotification(notification);
                   } 
                }
                return true;
                
                
                
            }
        }
        return false;
    }

    //user specific actions
    private void userAddGroupPost(String postId, String groupId) {
        Group group = getGroup(groupId);
        if (group.checkUser(currentUser.getUserId()) != null && group.isUser(currentUser.getUserId())) {
            group.addPostOfUser(postId);
            ArrayList<String> admins = group.getAllAdmins();
            Content post = getPostWithID(postId);
            Notification  notification = new Notification("User added post to group" , currentUser.getUserName(),post );
            group.setRequestNotifcation(postId, notification.getId());
            for(User u : Data){
                if(!currentUser.getUserId().equals(u.getUserId()))
                if(group.checkUser(u.getUserId()) != null && !group.checkUser(u.getUserId()).equals("user")){
                    u.addNotification(notification);
                    
                }
                
            }
            
        }
    }

    public void joinGroup(String groupId) { //function to be used to send notification to all admins that the user needs to join
        Group group = getGroup(groupId);
        if (group.checkUser(currentUser.getUserId()) == null && !group.isPendingRequest(currentUser.getUserId())) {
            group.addMember(groupId);
            currentUser.addGroupRequest(groupId);
            Notification  notification = new Notification("Join Group", currentUser.getUserName(), currentUser.getUserId(), currentUser.getProfilePhoto());
            removeNotification(group.getRequestNotifcation(currentUser.getUserId()));
            for(User u : Data){
                if(group.checkUser(u.getUserId()) != null && !group.checkUser(u.getUserId()).equals("user")){
                    if(!currentUser.getUserId().equals(u.getUserId()))
                    u.addNotification(notification);
                }
                
            }
            
        }
    }

    public void leaveGroup(String groupId) {
        Group group = getGroup(groupId);
        if (group.isOwner(currentUser.getUserId())) {
            // TODO: code to handle owner Leaving the group
        } else if (group.checkUser(currentUser.getUserId()) != null) {
            group.removeMember(currentUser.getUserId());
            currentUser.leaveGroup(groupId);
            Notification  notification = new Notification("Leave Group",currentUser.getUserName() + " Left " + group.getGroupName() + " Group");
            
            for(User u : Data){
                if(group.checkUser(u.getUserId()) != null && !group.checkUser(u.getUserId()).equals("user") ){ // notification will not be sent to user as he has already left group
                    if(!currentUser.getUserId().equals(u.getUserId()))
                    u.addNotification(notification);
                    //no need to delete this notification
                }
            }
        }
        
    }

    public void removeNotification(String notificationId) {
        for (User u : Data) {
            u.removeNotification(notificationId);
        }
        //remove notification from app manager
    }

    public ArrayList<PostString> getGroupPosts() {
        ArrayList<PostString> posts = new ArrayList();
        for (int i = 0; i < currentUser.getAllMyGroups().size(); i++) {
            for (int j = 0; j < groups.size(); j++) {
                if (currentUser.getAllMyGroups().get(i).equalsIgnoreCase(groups.get(j).getGroupID())) {
                    for (int k = 0; j < groups.get(j).getAllPosts().size(); k++) {
                        for (int l = 0; l < this.posts.size(); l++) {
                            for (int m = 0; m < Data.size(); m++) {
                                if (Data.get(m).getUserId().equalsIgnoreCase(this.posts.get(l).getAuthorID())) {
                                    posts.add(new PostString(Data.get(m).getUserName(), this.posts.get(l).getText(), this.posts.get(l).getPhoto(), this.posts.get(l).getTimePosted().toString()));

                                }
                            }

                        }

                    }
                }
            }
        }
        return posts;
    }
    public ArrayList<RelationString> groupSuggest(){
       ArrayList<String>temp=new ArrayList();
       temp.addAll(currentUser.getAllGroupRequests());
       temp.addAll(currentUser.getAllGroupsLeftByMe());
       temp.addAll(currentUser.getAllMyGroups());
        ArrayList<RelationString> groups=new ArrayList();
        for (Group group : this.groups) { 
        if (!temp.contains(group.getGroupID())) {
            groups.add(new RelationString(group.getGroupName(), group.getGroupPhoto(), group.getGroupID()));
        }
    }
       
        return groups;
    }

    public ArrayList<UserSearch> SearchFriend(String key) {
        ArrayList<UserSearch> found = new ArrayList();
        ArrayList<RelationString> friends = getFriends();

        for (int i = 0; i < Data.size(); i++) {
            if (key.equalsIgnoreCase(Data.get(i).getUserName())) {
                if (currentUser.isFriend(Data.get(i).getUserId())) {
                    found.add(new UserSearch(Data.get(i).getUserName(), "Friend", Data.get(i).getUserId(), Data.get(i).getProfilePhoto()));
                } else if (currentUser.isBlock(Data.get(i).getUserId())) {
                    found.add(new UserSearch(Data.get(i).getUserName(), "Blocked", Data.get(i).getUserId(), Data.get(i).getProfilePhoto()));
                } else if (currentUser.isPending(Data.get(i).getUserId())) {
                    found.add(new UserSearch(Data.get(i).getUserName(), "Pending", Data.get(i).getUserId(), Data.get(i).getProfilePhoto()));
                } else {
                    found.add(new UserSearch(Data.get(i).getUserName(), "No Relation", Data.get(i).getUserId(), Data.get(i).getProfilePhoto()));
                }
            }
        }
        for (int i = 0; i < found.size(); i++) {
            for (int k = 0; k < request.size(); k++) {
                /*check if the user is receiver to block*/
                if (currentUser.getUserId().equalsIgnoreCase(found.get(i).getIdString())||currentUser.getUserId().equalsIgnoreCase(request.get(k).getReceiverID()) && request.get(k).getStatus().getRelation().equalsIgnoreCase("Block") && found.get(i).getIdString().equalsIgnoreCase(request.get(k).getSenderID())) {
                    found.remove(found.get(i));
                }
            }
        }
        
        return found;
    }
    public ArrayList<UserSearch> SearchGroup(String key) {
        ArrayList<UserSearch> found = new ArrayList();
        for (int i = 0; i < groups.size(); i++) {
            if (key.equalsIgnoreCase(groups.get(i).getGroupID())) {
                if (currentUser.isMember(groups.get(i).getGroupID())) {
                    found.add(new UserSearch(groups.get(i).getGroupName(), "Member", groups.get(i).getGroupID(), groups.get(i).getGroupPhoto()));
                } else if (currentUser.isPendingGroup(groups.get(i).getGroupID())) {
                    found.add(new UserSearch(groups.get(i).getGroupName(), "Pending", groups.get(i).getGroupID(), groups.get(i).getGroupPhoto()));
                } else {
                    found.add(new UserSearch(groups.get(i).getGroupName(), "No Relation", groups.get(i).getGroupID(), groups.get(i).getGroupPhoto()));
                }
            }
        }

        return found;
    }
    public ArrayList<Notification> getNotifications() {
        return currentUser.getNotifications();
    }

}
