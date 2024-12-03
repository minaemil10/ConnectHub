/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DataBase;

import Backend.Friend_Management.Relation;
import Backend.Friend_Management.Relationship;
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
public class JsonFileWriter implements FilePaths{

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
                for (Relationship rel : relations) {
                    if (rel.getRelation().equals("Cancel"))
                    {
                        System.out.println(rel.getRelation());
                        user.deleteRelation(rel);
                    }
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

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2004, Month.OCTOBER, 26);
        User user1 = new User("U1", "mina@gmail.com", "Mina Emile", "123456", date1);
        user1.setBio("I am an Engineer");
        user1.setCoverPhoto("src\\Mina.png");
        user1.setStatus(Boolean.TRUE);
        ArrayList<Relationship> relationships = new ArrayList<>();
        user1.setFriends(relationships);
        
        Relation rel2 = new Relation();
        rel2.setBlock();
        Relationship relation2 = new Relationship("U3", rel2);
        user1.addRelation(relation2);
        
        Relation rel1 = new Relation();
        rel1.setFriend();
        Relationship relation1 = new Relationship("U2", rel1);
        user1.addRelation(relation1);
      
        
        
        LocalDate date2 = LocalDate.of(2001, Month.JANUARY, 15);
        User user2 = new User("U2", "john@example.com", "John Doe", "password", date2);
        user2.setBio("I am a Developer");
        user2.setCoverPhoto("src\\John.png");
        user2.setStatus(Boolean.FALSE);
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        JsonFileWriter writer = new JsonFileWriter(userDataBase);
        writer.writeAllUsers(users);
    }

}
