package Backend.DataBase;

import java.util.ArrayList;

import Backend.Friend_Management.friendRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
public class FriendRequestFileReader extends JsonFileReader{
    public FriendRequestFileReader(String filePath) {
        super(filePath);
    }

    @Override
    public ArrayList<friendRequest> readAll() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
        ArrayList<friendRequest> req = new ArrayList<>();
        try (FileReader fileReader = new FileReader(getFilePath())) {
            Type reqListType = new TypeToken<ArrayList<friendRequest>>() {
            }.getType();
            req = gson.fromJson(fileReader, reqListType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return req;
    }
}
