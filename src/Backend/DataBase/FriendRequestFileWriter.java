package Backend.DataBase;

import Backend.Friend_Management.friendRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FriendRequestFileWriter extends JsonFileWriter<friendRequest>{
    public FriendRequestFileWriter(String filePath) {
        super(filePath);
    }

    @Override
    public void writeAll(ArrayList<friendRequest> requests) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
        //write request to file
        String json = gson.toJson(requests);
        try (FileWriter fileWriter = new FileWriter(getFilePath(), false)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

