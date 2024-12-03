/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.time.LocalDate;

/**
 *
 * @author Mnw Emile
 */
public class Content {

    private String photo;
    private String contentID;
    private String authorID;
    private String text;
    private LocalDate timePosted;

    public Content(String photo, String contentID, String authorID, String text) {
        //contructor used to take all values except time because it is the current time
        this.photo = photo;
        this.contentID = contentID;
        this.authorID = authorID;
        this.text = text;
        timePosted = LocalDate.now();
    }
    
    //getters for all attributed
    public String getPhoto() {
        return photo;
    }

    public String getContentID() {
        return contentID;
    }

    public String getAuthorID() {
        return authorID;
    }

    public String getText() {
        return text;
    }

    public LocalDate getTimePosted() {
        return timePosted;
    }
    
    public Content() {
    }
    
    //setters for photo and text because this is the only changeable attributes
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
