package Backend.Friend_Management;

public class RelationString {
    private String username;
    private String relation;
    private String ID;


    public RelationString(String username, String relation,String ID) {
        this.username = username;
        this.relation = relation;
        this.ID=ID;

    }
    public RelationString(String username,String ID) {
        this.username = username;
        this.relation = relation;
        this.ID=null;

    }
    public String getUsernameString() {
        return username;
    }

    public String getIdString() {
        return ID;
    }

    public String getRelationString() {
        return relation;
    }
}
