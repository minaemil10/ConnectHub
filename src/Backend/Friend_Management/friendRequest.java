package Backend.Friend_Management;

import Backend.DataBase.DataBaseOBJ;
import Backend.User;

public class friendRequest implements DataBaseOBJ {
private String senderID;
private String receiverID;
private Relation status;

    public friendRequest(String senderID, String receiverID) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.status = new Relation();
    }
    public void make(User sender,User receiver){
        new Relationship(status,receiverID);
        sender.sendRelation(new Relationship(status,receiverID));
        receiver.receiveRelation(new Relationship(status,senderID));
    }
    public void accept(){
        status.setFriend();
    }
    public void decline(){
        status.setCanceled();
    }

}
