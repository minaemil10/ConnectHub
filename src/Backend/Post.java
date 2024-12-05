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
    private static int id;
    public Post(String photo, String authorID, String text) {//optional photo

        /*null should be sent from the front end*/
        super(photo, "P-"+id++, authorID, text);
    }

    public static void setId(int id) {
        Post.id = id;
    }
}
