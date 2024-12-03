package Backend.Friend_Management;

public class Relation {
    private String relation;

    public Relation() {
        this.relation = "pending";
    }

    public void setFriend() {
        this.relation = "Friend";
    }
    public void setBlock() {
        this.relation = "Block";
    }
    public String getRelation() {
        return relation;
    }
}
