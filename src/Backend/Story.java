/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Mnw Emile
 */
public class Story extends Content{

    private static int id;
    public Story(String photo, String authorID, String text) {

        super(photo, "S-"+id++, authorID, text);
    }
    public Story(String photo, String contentID,String authorID, String text) {
        super(photo, contentID, authorID, text);
    }
    public static void setId(int id) {
        Story.id = id;
    }
}
