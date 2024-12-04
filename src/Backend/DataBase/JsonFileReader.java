/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DataBase;

import Backend.Friend_Management.friendRequest;
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
            System.out.println(users);
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
            System.out.println(req);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return req;
    }

    public static void main(String[] args) {
        JsonFileReader reader = new JsonFileReader(userDataBase);
        reader.readAllUsers();
        JsonFileReader reader2 = new JsonFileReader(requestsDataBase);
        reader2.readAllRequests();
    }
}
