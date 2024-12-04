package Backend.DataBase;

import Backend.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;

public class UserFileReader extends JsonFileReader{

    public UserFileReader(String filePath) {
        super(filePath);
    }

    @Override
    public ArrayList<User> readAll() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
        ArrayList<User> users = new ArrayList<>();
        try (FileReader fileReader = new FileReader(getFilePath())) {
            Type userListType = new TypeToken<ArrayList<User>>() {
            }.getType();
            users = gson.fromJson(fileReader, userListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
