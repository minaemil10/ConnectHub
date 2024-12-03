package Backend.Friend_Management;

import Backend.User;

public class friendRequest {
private String senderID;
private String receiverID;
private Relation status;

    public friendRequest(String senderID, String receiverID, String status) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.status = new Relation();
    }
    public void make(User sender,User receiver){
        sender.addRelation(new Relationship(receiverID,status));
        receiver.addRelation(new Relationship(senderID,status));
    }
    public void accept(){
        status.setFriend();
    }
    public void decline(){
        status.setCanceled();
    }
}
