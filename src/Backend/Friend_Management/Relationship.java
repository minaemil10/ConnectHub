package Backend.Friend_Management;

public class Relationship {
    private String relationWith;
    private Relation relation;

    public Relationship( Relation relation,String relationWith) {
        this.relationWith = relationWith;
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

    public String getrelationWith() {
        return relationWith;
    }

}
