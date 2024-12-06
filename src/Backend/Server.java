package Backend;

import Backend.DataBase.*;
import Backend.Friend_Management.Relationship;

import java.util.ArrayList;

import static Backend.DataBase.FilePaths.*;

public class Server {
    private static ArrayList<User> Data;
    private static ArrayList<Post>posts;
    private static ArrayList<Story>stories;
    private static ArrayList<Relationship>relationships;
    private static Server server=new Server();
    private Server() {
        Data = loadUsers();
        posts =loadPost();
        stories=loadStory();
//        relationships=loadRelationShips();
    }
    public static Server getInstance() {
        return server; // Getter for singleton instance
    }
    /*database management*/
    /*User Database*/
    public AppManager serve(){
       return new AppManager(Data,posts,stories);
    }
    private ArrayList<User> loadUsers() throws RuntimeException {
        ArrayList<User> temp= new UserFileReader(userDataBase).readAll();
        try {
            /*check the array*/
            SignUp.setCounter(Integer.parseInt(temp.getLast().getUserId().split("U")[1]));
            return temp;
        } catch (Exception e) {
            return temp;
        }

    }
    public static void writeUsers(){
        new UserFileWriter(userDataBase).writeAll(Data);
    }
    /*Content database*/
    private ArrayList<Post> loadPost(){
        return new ContentFileReader(contentDataBase).readAllPosts();
    }
    private ArrayList<Story> loadStory(){
        ArrayList<Story> temp= new ContentFileReader(contentDataBase).readAllStories();
    //    Story.setId(Integer.parseInt( temp.getLast().getContentID().split("-")[1]));
        return temp;
    }

    private void writeContent(){
        ArrayList<Content> contents = new ArrayList<>(stories);
        contents.addAll(posts);
        new ContentFileWriter(contentDataBase).writeAll(contents);
    }
    /*Expected relations writer and reader*/
    /*m7tagen ntfahm fe mwdo3 el requests dhhhh*/
//    private ArrayList<Relationship> loadRelationShips(){
//        return new FriendRequestFileReader(requestsDataBase).readAll();
//
//    }
//    private void writeRelationShips(){
//        new FriendRequestFileWriter(requestsDataBase).writeAll(Data);
//    }

}
