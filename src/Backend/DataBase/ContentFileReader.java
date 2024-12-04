package Backend.DataBase;

import Backend.Content;
import Backend.Post;
import Backend.Story;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;

public class ContentFileReader extends JsonFileReader{
    public ContentFileReader(String filePath) {
        super(filePath);
    }

    @Override
    public ArrayList<Content> readAll(){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
        ArrayList<Content> Content = new ArrayList<>();
        try (FileReader fileReader = new FileReader(getFilePath())) {
            Type contentListType = new TypeToken<ArrayList<Content>>() {
            }.getType();
            Content = gson.fromJson(fileReader, contentListType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Content;
    }

    public ArrayList<Story> readAllStories(){
        ArrayList<Story> stories = new ArrayList<>();
        ContentFileReader reader = new ContentFileReader(getFilePath());
        ArrayList<Content> contents = reader.readAll();
        for(Content con : contents){
            if(con.getContentID().startsWith("S")){
                stories.add(contentToStory(con));
            }
        }
        return stories;
    }

    public ArrayList<Post> readAllPosts(){
        ArrayList<Post> posts = new ArrayList<>();
        ContentFileReader reader = new ContentFileReader(getFilePath());
        ArrayList<Content> contents = reader.readAll();
        for(Content con : contents){
            if(con.getContentID().startsWith("P")){
                posts.add(contentToPost(con));
            }
        }
        return posts;
    }


    public static Story contentToStory(Content con){
        return new Story(con.getPhoto(),con.getContentID(),con.getAuthorID(),con.getText());
    }
    public static Post contentToPost(Content con){
        Post post =  new Post(con.getContentID(),con.getAuthorID(),con.getText());
        post.setPhoto(con.getPhoto());
        return post;
    }
}
