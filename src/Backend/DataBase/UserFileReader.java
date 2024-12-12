package Backend.DataBase;

import Backend.Friend_Management.Relation;
import Backend.Friend_Management.Relationship;
import Backend.Friend_Management.friendRequest;
import Backend.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserFileReader extends JsonFileReader {

    public UserFileReader(String path) {
        super(path);
    }

    @Override
    public ArrayList<User> readAll() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).setPrettyPrinting().create();
        ArrayList<User> users = new ArrayList<>(); //create users array
        try (FileReader fileReader = new FileReader(getFilePath())) {
            Type userListType = new TypeToken<ArrayList<User>>() { //create typetoken to be used in reading
            }.getType();
            users = gson.fromJson(fileReader, userListType);//read and make the required arraylist
        } catch (IOException e) {
            e.printStackTrace();
        }

        //handling relationship reading
        ArrayList<friendRequest> requests = new FriendRequestFileReader(requestsDataBase).readAll();

        for (friendRequest req : requests) {
            String senderUserID = req.getSenderID();
            String recieverUserID = req.getReceiverID();
            User sender = null;
            User reciever = null;

            //find the two friends from the Arraylist
            for (User user : users) {
                if (user.getUserId().equals(senderUserID)) {
                    sender = user;
                }
                if (user.getUserId().equals(recieverUserID)) {
                    reciever = user;
                }
                if (sender != null && reciever != null) {
                    break;
                }
            }

            if (sender != null && reciever != null) {
                //Get sender relations
                ArrayList<Relationship> senderFriends = sender.getFriends();
                ArrayList<Relationship> senderBlocked = sender.getBlocked();
                ArrayList<Relationship> senderReceived = sender.getReceived();
                ArrayList<Relationship> senderSent = sender.getSent();
                //get reciever relations
                ArrayList<Relationship> recieverFriends = reciever.getFriends();
                ArrayList<Relationship> recieverBlocked = reciever.getBlocked();
                ArrayList<Relationship> recieverReceived = reciever.getReceived();
                ArrayList<Relationship> recieverSent = reciever.getSent();

                //get common realtion
                Relation rel = req.getStatus();
                //relations to be found
                Relationship senderRelationshipWithReciever = null;
                Relationship recieverRelationshipWithSender = null;

                //find Relationship
                if (rel.getRelation().equals("Friend")) {
                    /*if they are friends search friends array in both*/
                    //Find sender RelationShip object
                    for (Relationship relationship : senderFriends) {
                        if (relationship.getRelation().equals(rel.getRelation())) {
                            senderRelationshipWithReciever = relationship;
                            break;
                        }
                    }

                    //Find reciever RelationShip object
                    for (Relationship relationship : recieverFriends) {
                        if (relationship.getRelation().equals(rel.getRelation())) {
                            recieverRelationshipWithSender = relationship;
                            break;
                        }
                    }
                } else if (rel.getRelation().equals("pending")) {
                    /*if they are pending search sent array in sender and recieved arraylist in reciever*/
                    //Find sender RelationShip object
                    for (Relationship relationship : senderSent) {
                        if (relationship.getRelation().equals(rel.getRelation())) {
                            senderRelationshipWithReciever = relationship;
                            break;
                        }
                    }

                    //Find reciever RelationShip object
                    for (Relationship relationship : recieverReceived) {
                        if (relationship.getRelation().equals(rel.getRelation())) {
                            recieverRelationshipWithSender = relationship;
                            break;
                        }
                    }
                } else if (rel.getRelation().equals("Block")) {
                    /*if they are blocked search blocked arraylist in both*/
                    //Find sender RelationShip object
                    for (Relationship relationship : senderBlocked) {
                        if (relationship.getRelation().equals(rel.getRelation())) {
                            senderRelationshipWithReciever = relationship;
                            break;
                        }
                    }

                    //Find reciever RelationShip object
                    for (Relationship relationship : recieverBlocked) {
                        if (relationship.getRelation().equals(rel.getRelation())) {
                            recieverRelationshipWithSender = relationship;
                            break;
                        }
                    }
                }
                /*after finding both realtionships set them to the same object as the friendRequest*/
                if (senderRelationshipWithReciever != null) {
                    senderRelationshipWithReciever.setRelation(rel);
                }
                if (recieverRelationshipWithSender != null) {
                    recieverRelationshipWithSender.setRelation(rel);
                }
            }
        }

        return users;
    }

    public static void main(String[] args) {
        System.out.println("Start:");
        UserFileReader reader = new UserFileReader(userDataBase);
        reader.readAll();
    }

}
