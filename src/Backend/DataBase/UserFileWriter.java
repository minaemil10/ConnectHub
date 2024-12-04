package Backend.DataBase;

import Backend.Friend_Management.Relationship;
import Backend.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserFileWriter extends JsonFileWriter<User> {
    public UserFileWriter(String filePath) {
        super(filePath);
    }

    @Override
    public void writeAll(ArrayList<User> users) {
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
                for (Relationship rel : tempRel) {
                    user.deleteRelation(rel);
                }
            }
        }

    }
}
