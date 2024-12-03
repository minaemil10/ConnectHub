package Backend.Friend_Management;

public class friendRequest {
private String senderID;
private String receiverID;
private Relation status;

    public friendRequest(String senderID, String receiverID, String status) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.status = new Relation();
    }
    public void make(){
        /*arraylist of sender.add(new Relationship(receiver,status))*/
        /*arraylist of receiver.add(new Relationship(sender,status))*/
    }
    public void accept(){
        status.setFriend();
    }
    public void decline(){
        /*remove the friend request from the arraylist of both*/
    }


}
