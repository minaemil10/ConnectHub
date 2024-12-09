/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Mnw Emile
 */
public class GroupString {
    private String name;
    private String photo;
    private String description;
    private String id;

    public GroupString(String name, String photo, String description, String id) {
        this.name = name;
        this.photo = photo;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }
    
    
}
