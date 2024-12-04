/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DataBase;

import Backend.Content;
import Backend.Friend_Management.Relation;
import Backend.Friend_Management.Relationship;
import Backend.Friend_Management.friendRequest;
import Backend.Post;
import Backend.Story;
import Backend.User;
import com.google.gson.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author Mnw Emile
 */
public class JsonFileWriter implements FilePaths {

    private String filePath;

    public JsonFileWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeAllUsers(ArrayList<User> users) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();

        //check for rlations set to "cancel" and remove them
        for (User user : users) {
            ArrayList<Relationship> relations = user.getFriends();
            if (relations != null) {
                ArrayList<Relationship> tempRel = new ArrayList<>(); 
                for (Relationship rel : relations) {
                    if (rel.getRelation().equals("Cancel")) {
                        tempRel.add(rel);
                    }
                }
                for(Relationship rel : tempRel){
                user.deleteRelation(rel);
                }
            }
        }
        //write user to file
        String json = gson.toJson(users);
        try (FileWriter fileWriter = new FileWriter(filePath, false)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAllContent(ArrayList<Content> contents) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
        //write content to file
        String json = gson.toJson(contents);
        try (FileWriter fileWriter = new FileWriter(filePath, false)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAllFriendRequests(ArrayList<friendRequest> requests) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
        //write request to file
        String json = gson.toJson(requests);
        try (FileWriter fileWriter = new FileWriter(filePath, false)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    //main to test methods
    /*public static void main(String[] args) {
        
        //create user1
        LocalDate date1 = LocalDate.of(2004, Month.OCTOBER, 26);
        User user1 = new User("U1", "mina@gmail.com", "Mina Emile", "123456", date1);
        user1.setBio("I am an Engineer");
        user1.setCoverPhoto("src\\Mina.png");
        user1.setStatus(Boolean.TRUE);
        ArrayList<Relationship> relationships = new ArrayList<>();
        user1.setFriends(relationships);
        
        //create user2
        LocalDate date2 = LocalDate.of(2001, Month.JANUARY, 15);
        User user2 = new User("U2", "john@example.com", "John Doe", "password", date2);
        user2.setBio("I am a Developer");
        user2.setCoverPhoto("src\\John.png");
        user2.setStatus(Boolean.FALSE);
        ArrayList<Relationship> relationships2 = new ArrayList<>();
        user2.setFriends(relationships2);
        //create user Array
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        
        //create content
        Content c1 = new Story(userDataBase, contentDataBase, userDataBase, userDataBase);
        Content c2 = new Post(contentDataBase, userDataBase, userDataBase);
        ArrayList<Content> cont = new ArrayList<>();
        cont.add(c1);
        cont.add(c2);
        JsonFileWriter contetWriter = new JsonFileWriter(contentDataBase);
        contetWriter.writeAllContent(cont);//write content
        //create friendRequest
        friendRequest r1 = new friendRequest("U1", "U2", "friend");
        r1.make(user1, user2);
        r1.accept();
        ArrayList<friendRequest> req = new ArrayList<>();
        req.add(r1);
        JsonFileWriter requestWriter = new JsonFileWriter(requestsDataBase);
        requestWriter.writeAllFriendRequests(req);//write requests
        
        JsonFileWriter userWriter = new JsonFileWriter(userDataBase);
        userWriter.writeAllUsers(users);//write users

    }*/

}
