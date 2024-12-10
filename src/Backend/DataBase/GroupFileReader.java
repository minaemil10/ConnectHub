/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DataBase;

import Backend.Content;
import Backend.Group;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.print.attribute.standard.MediaName;

/**
 *
 * @author Mnw Emile
 */
public class GroupFileReader extends JsonFileReader {

    public GroupFileReader(String filePath) {
        super(filePath);
    }

    @Override
    public ArrayList<Group> readAll() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).setPrettyPrinting().create();
        ArrayList<Group> groups = new ArrayList<>(); //arrayList creation
        try (FileReader fileReader = new FileReader(getFilePath())) {
            Type contentListType = new TypeToken<ArrayList<Group>>() { //create Type token
            }.getType();
            groups = gson.fromJson(fileReader, contentListType); //create arrayList from file

        } catch (IOException e) {
            e.printStackTrace();
        }
        return groups;
    }

}
