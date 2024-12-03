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
public class JsonFileWriter {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()) .setPrettyPrinting() .create();
        LocalDate date = LocalDate.of(2004, Month.OCTOBER, 26);
        User user = new User("U1", "mina@gmail.com", "Mina Emile", "123456", date);
        user.setBio("I am an Engineer");
        user.setCoverPhoto("src\\Mina.png");
        user.setStatus(Boolean.TRUE);
        ArrayList<Relationship> friends = new ArrayList<>();
        Relation friend = new Relation();
        friend.setFriend();
        friends.add(0, new Relationship("U2", friend));
        Relation friend2 = new Relation();
        friend2.setBlock();
        friends.add(0, new Relationship("U3", friend2));
        user.setFriends(friends);

        String json = gson.toJson(user);
        
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Mnw Emile\\Desktop\\Prog_Labs\\prog2_lab8_socialApp\\ConnectHub\\src\\Backend\\DataBase\\users.json",false)) {
            fileWriter.write(json);
            System.out.println("Successfully wrote JSON object to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
