/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DataBase;

import Backend.Friend_Management.Relationship;
import Backend.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author Mnw Emile
 */
public class JsonFileReader implements FilePaths{
    private String filePath;

    public JsonFileReader(String filePath) {
        this.filePath = filePath;
    }
    
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2004, Month.OCTOBER, 26);
        User user1 = new User("U1", "mina@gmail.com", "Mina Emile", "123456", date1);
        user1.setBio("I am an Engineer");
        user1.setCoverPhoto("src\\Mina.png");
        user1.setStatus(Boolean.TRUE);
        ArrayList<Relationship> relationships = new ArrayList<>();
        user1.setFriends(relationships);
    }
}
