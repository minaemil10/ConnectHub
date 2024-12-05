package Backend;

import Backend.DataBase.ContentFileReader;
import Backend.DataBase.ContentFileWriter;
import Backend.DataBase.UserFileReader;
import Backend.DataBase.UserFileWriter;

import java.util.ArrayList;

import static Backend.DataBase.FilePaths.*;

public class Server {
    private ArrayList<User> Data;
    private ArrayList<Content>contents;
    private static Server server=new Server();
    private Server() {
        Data = loadUsers();
        contents =loadContent();
    }
    public static Server getInstance() {
        return server; // Getter for singleton instance
    }
    /*database management*/
    /*User Database*/
    public AppManager serve(){
       return new AppManager(Data,contents);
    }
    private ArrayList<User> loadUsers(){
        return new UserFileReader(userDataBase).readAll();
    }
    private void writeUsers(){
        new UserFileWriter(userDataBase).writeAll(Data);
    }
    /*Content database*/
    private ArrayList<Content> loadContent(){
        return new ContentFileReader(contentDataBase).readAll();
    }
    private void writeContent(){
        new ContentFileWriter(contentDataBase).writeAll(contents);
    }

}
