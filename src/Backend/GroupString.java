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
    private String rule;

    public GroupString(String name, String photo, String description, String id, String rule) {
        this.name = name;
        this.photo = photo;
        this.description = description;
        this.id = id;
        this.rule = rule;
    }

    public String getRule() {
        return rule;
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
