package Backend.DataBase;

import Backend.Friend_Management.Relationship;
import Backend.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class UserFileWriter extends JsonFileWriter<User> {
    public UserFileWriter(String path) {
        super(path);
    }

    @Override
    public void writeAll(ArrayList<User> users) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
        //check for relations set to "cancel" and remove them
        for (User user : users) {
            ArrayList<Relationship> relations = user.getFriends();
            if (relations != null) {
                ArrayList<Relationship> tempRel = new ArrayList<>();
                for (Relationship rel : relations) {
                    if (rel.getRelation().equals("Cancel")) {
                        tempRel.add(rel);
                    }
                }
                for (Relationship rel : tempRel) {
                    user.deleteRelation(rel);
                }
            }
        }
        //write user to file
        String json = gson.toJson(users);
        try (FileWriter fileWriter = new FileWriter(getFilePath(), false)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
