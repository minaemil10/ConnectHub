package Backend.Friend_Management;

public class Relationship {
    private String senderID;
    private String receiverID;
    private Relation relation;

    public Relationship(String senderID, Relation relation,String receiverID) {
        this.senderID = senderID;
        this.receiverID = receiverID;
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
    public void setBlockAndSetReceiver() {
        String temp=senderID;
        relation.setBlock();
        senderID=receiverID;
        receiverID=temp;
    }
    public String getReceiverID() {
        return receiverID;
    }
    public String getSenderID() {
        return senderID;
    }
}
