/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DataBase;

import Backend.Friend_Management.friendRequest;
import Backend.Notification;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Mnw Emile
 */
public class NotificationFileReader extends JsonFileReader {

    public NotificationFileReader(String filePath) {
        super(filePath);
    }

    @Override
    public ArrayList<Notification> readAll() {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
        ArrayList<Notification> notifications = new ArrayList<>(); //arraylist creation
        try (FileReader fileReader = new FileReader(getFilePath())) {
            Type notiListType = new TypeToken<ArrayList<Notification>>() { //create type token
            }.getType();
            notifications = gson.fromJson(fileReader, notiListType); //createArray from file
        } catch (IOException e) {
            e.printStackTrace();
        }
        return notifications;
    }
    
}
