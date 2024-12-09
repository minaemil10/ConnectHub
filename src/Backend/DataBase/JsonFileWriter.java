/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DataBase;


import java.util.ArrayList;

/**
 *
 * @author Mnw Emile
 */
public abstract class JsonFileWriter<T extends DataBaseOBJ> implements FilePaths {

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public JsonFileWriter(String filePath) {
        this.filePath = filePath;
    }

    public abstract void writeAll(ArrayList<T> data);
}