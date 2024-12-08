/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend;

import Backend.AppManager;
import Backend.Friend_Management.RelationString;
import Backend.Friend_Management.friendRequest;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FriendManagement extends javax.swing.JPanel {

    /**
     * Creates new form FriendManagement
     */
    private AppManager a ;
    public FriendManagement(AppManager a ) {
        initComponents();
        this.a = a;
        friendRequestPanel.setLayout(new javax.swing.BoxLayout(friendRequestPanel, javax.swing.BoxLayout.Y_AXIS));
        friendListPanel.setLayout(new javax.swing.BoxLayout(friendListPanel, javax.swing.BoxLayout.Y_AXIS));
        friendSuggest.setLayout(new javax.swing.BoxLayout(friendSuggest, javax.swing.BoxLayout.Y_AXIS));
        ArrayList <RelationString> suggest =  a.friendSuggest();
        for(RelationString r : suggest){
            String id = r.getIdString();
            String photo = r.getRelationString();
            String name = r.getUsernameString();
            FriendSuggestion suggestion = new FriendSuggestion(id, name, photo, a);
            friendSuggest.add(suggestion);
           // System.out.println(name);
            //link friend suggestion with panel
        }
        ArrayList <RelationString> request = a.getRequests();
        for(RelationString r : request){
            String id = r.getIdString();
            String photo = r.getRelationString();
            String name = r.getUsernameString();
            //link friend request with panel
            FriendRequest f = new FriendRequest(a, id, name, photo);
            friendRequestPanel.add(f);
            //System.out.println(name);
        }
        ArrayList <RelationString> friends = a.getFriends();
        //System.out.println(friends.size());
        for(RelationString r : friends){
            String id = r.getIdString();
            String photo = r.getRelationString();
            String name = r.getUsernameString();
            //link friend  with panel
            FriendList list = new FriendList(id, name, photo, a);
            friendListPanel.add(list);
            //System.out.println(name+id);
            
        }
        friendSuggest.repaint();
        friendRequestPanel.repaint();
        friendListPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new java.awt.ScrollPane();
        scrollPane2 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        friendRequestPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        friendListPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        friendSuggest = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();

        friendRequestPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        friendRequestPanel.setPreferredSize(new java.awt.Dimension(270, 460));
        friendRequestPanel.setLayout(new javax.swing.BoxLayout(friendRequestPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(friendRequestPanel);

        friendListPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        friendListPanel.setPreferredSize(new java.awt.Dimension(270, 460));
        friendListPanel.setLayout(new javax.swing.BoxLayout(friendListPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane2.setViewportView(friendListPanel);

        friendSuggest.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        friendSuggest.setPreferredSize(new java.awt.Dimension(270, 460));
        friendSuggest.setLayout(new javax.swing.BoxLayout(friendSuggest, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane3.setViewportView(friendSuggest);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Friend Suggestions");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Friend Requests");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Friend List");

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(128, 128, 128)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(120, 120, 120))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(refresh)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        friendSuggest.removeAll();
        friendRequestPanel.removeAll();
        friendListPanel.removeAll();
        friendRequestPanel.setLayout(new javax.swing.BoxLayout(friendRequestPanel, javax.swing.BoxLayout.Y_AXIS));
        friendListPanel.setLayout(new javax.swing.BoxLayout(friendListPanel, javax.swing.BoxLayout.Y_AXIS));
        friendSuggest.setLayout(new javax.swing.BoxLayout(friendSuggest, javax.swing.BoxLayout.Y_AXIS));

       ArrayList <RelationString> suggest =  a.friendSuggest();
        for(RelationString r : suggest){
            String id = r.getIdString();
            String photo = r.getRelationString();
            String name = r.getUsernameString();
            FriendSuggestion suggestion = new FriendSuggestion(id, name, photo, a);
            friendSuggest.add(suggestion);
           // System.out.println(name);
            //link friend suggestion with panel
        }
        ArrayList <RelationString> request = a.getRequests();
        for(RelationString r : request){
            String id = r.getIdString();
            String photo = r.getRelationString();
            String name = r.getUsernameString();
            //link friend request with panel
            FriendRequest f = new FriendRequest(a, id, name, photo);
            friendRequestPanel.add(f);
            //System.out.println(name);
        }
        ArrayList <RelationString> friends = a.getFriends();
        //System.out.println(friends.size());
        for(RelationString r : friends){
            String id = r.getIdString();
            String photo = r.getRelationString();
            String name = r.getUsernameString();
            //link friend  with panel
            FriendList list = new FriendList(id, name, photo, a);
            friendListPanel.add(list);
            //System.out.println(name+id);
            
        }
        friendSuggest.repaint();
        friendRequestPanel.repaint();
        friendListPanel.repaint();
    }//GEN-LAST:event_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel friendListPanel;
    private javax.swing.JPanel friendRequestPanel;
    private javax.swing.JPanel friendSuggest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton refresh;
    private java.awt.ScrollPane scrollPane1;
    private java.awt.ScrollPane scrollPane2;
    // End of variables declaration//GEN-END:variables
}
