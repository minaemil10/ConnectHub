package Backend.DataBase;

import Backend.Content;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ContentFileWriter extends JsonFileWriter<Content>{

    public ContentFileWriter(String filePath) {
        super(filePath);
    }

    @Override
    public void writeAll(ArrayList<Content> data) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
        //write content to file
        String json = gson.toJson(data);
        try (FileWriter fileWriter = new FileWriter(getFilePath(), false)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
