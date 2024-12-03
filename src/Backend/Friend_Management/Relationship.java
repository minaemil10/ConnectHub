package Backend.Friend_Management;

public class Relationship {
    private String userID;
    private Relation relation;

    public Relationship(String userID, Relation relation) {
        this.userID = userID;
        this.relation = relation;
    }
    public void setFriend() {
        relation.setFriend();
    }
    public void setBlock() {
        relation.setBlock();
    }
    public void setCancel() {
        relation.setCanceled();
    }
    public String getRelation() {
        return relation.getRelation();
    }

    public String relationWithID() {
        return userID;
    }
}
