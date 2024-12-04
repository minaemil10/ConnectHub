/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Mnw Emile
 */
public class Post extends Content{

    public Post(String contentID, String authorID, String text) {//optional photo
        /*null should be sent from the front end*/
        super(null, contentID, authorID, text);
    }
    
}
