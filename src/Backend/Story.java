/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.time.LocalDateTime;

/**
 *
 * @author Mnw Emile
 */
public class Story extends Content{
    public Story(String photo, String contentID, String authorID, String text, LocalDateTime timePosted) {
        super(photo, contentID, authorID, text, timePosted);
    }

    private static int id;
    public Story(String photo, String authorID, String text) {

        super(photo, "S-"+id++, authorID, text, LocalDateTime.now());
    }
    public Story(String photo, String contentID,String authorID, String text) {
        super(photo, contentID, authorID, text,LocalDateTime.now());
    }
    public static void setId(int id) {
        Story.id = id;
    }
}
