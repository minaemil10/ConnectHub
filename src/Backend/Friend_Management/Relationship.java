package Backend.Friend_Management;

public class Relationship {
    private String relatedUserId;
    private Relation relation;

    public Relationship( Relation relation,String relationWith) {
        this.relatedUserId = relationWith;
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

    public String getRelatedUserID() {
        return relatedUserId;
    }


}
