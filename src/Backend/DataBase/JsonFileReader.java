/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DataBase;

import java.util.ArrayList;

/**
 * @author Mnw Emile
 */
public abstract class JsonFileReader implements FilePaths {
    private String filePath;

    public JsonFileReader(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    abstract public ArrayList<? extends DataBaseOBJ> readAll();
}

