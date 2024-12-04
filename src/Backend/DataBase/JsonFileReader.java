/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DataBase;

import Backend.Content;
import Backend.Friend_Management.friendRequest;
import Backend.Post;
import Backend.Story;
import Backend.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Mnw Emile
 */
public class JsonFileReader implements FilePaths {
    private String filePath;

    public JsonFileReader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<User> readAllUsers(){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
        ArrayList<User> users = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath)) {
            Type userListType = new TypeToken<ArrayList<User>>() {
            }.getType();
            users = gson.fromJson(fileReader, userListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public ArrayList<friendRequest> readAllRequests(){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
        ArrayList<friendRequest> req = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath)) {
            Type reqListType = new TypeToken<ArrayList<friendRequest>>() {
            }.getType();
            req = gson.fromJson(fileReader, reqListType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return req;
    }


    public ArrayList<Content> readAllContent(){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
        ArrayList<Content> Content = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath)) {
            Type contentListType = new TypeToken<ArrayList<Content>>() {
            }.getType();
            Content = gson.fromJson(fileReader, contentListType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Content;
    }

    public ArrayList<Story> readAllStories(){
        ArrayList<Story> stories = new ArrayList<>();
        JsonFileReader reader = new JsonFileReader(filePath);
        ArrayList<Content> contents =  reader.readAllContent();
        for(Content con : contents){
            if(con.getContentID().startsWith("S")){
                stories.add(contentToStory(con));
            }
        }
        return stories;
    }

    public ArrayList<Post> readAllPosts(){
        ArrayList<Post> posts = new ArrayList<>();
        JsonFileReader reader = new JsonFileReader(filePath);
        ArrayList<Content> contents =  reader.readAllContent();
        for(Content con : contents){
            if(con.getContentID().startsWith("P")){
                posts.add(contentToPost(con));
            }
        }
        return posts;
    }


    public static Story contentToStory(Content con){
        return new Story(con.getPhoto(),con.getContentID(),con.getAuthorID(),con.getText());
    }
    public static Post contentToPost(Content con){
        Post post =  new Post(con.getContentID(),con.getAuthorID(),con.getText());
        post.setPhoto(con.getPhoto());
        return post;
    }
}
