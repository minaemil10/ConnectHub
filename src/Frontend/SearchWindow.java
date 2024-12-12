/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.AppManager;
import Backend.Friend_Management.UserSearch;
import Frontend.Search.BlockedSearch;
import Frontend.Search.FriendListSearch;
import Frontend.Search.FriendRequestSearch;
import Frontend.Search.FriendSuggestionSearch;
import java.util.ArrayList;

/**
 *
 * @author beroo
 */
public class SearchWindow extends javax.swing.JFrame {

    /**
     * Creates new form SearchWindow
     */
    private AppManager a;

    public SearchWindow(AppManager a) {
        this.a = a;
        initComponents();
        friendSearch.setLayout(new javax.swing.BoxLayout(friendSearch, javax.swing.BoxLayout.Y_AXIS));
        setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        friendSearch = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("Search");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        SearchButton.setBackground(new java.awt.Color(0, 153, 255));
        SearchButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SearchButton.setForeground(new java.awt.Color(255, 255, 255));
        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search(evt);
            }
        });

        friendSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        friendSearch.setPreferredSize(new java.awt.Dimension(270, 460));
        friendSearch.setLayout(new javax.swing.BoxLayout(friendSearch, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(friendSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton))
                .addGap(18, 18, 18)
                .addComponent(friendSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed


    }//GEN-LAST:event_jTextField1ActionPerformed

    private void Search(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search
        ArrayList<UserSearch> found = a.SearchFriend(jTextField1.getText().trim());

        friendSearch.removeAll();
        for (int i = 0; i < found.size(); i++) {
            String id = found.get(i).getIdString();
            String photo = found.get(i).getRelationString();
            String name = found.get(i).getUsernameString();
            switch (found.get(i).getRelationString()) {
                case "Friend":
                    friendSearch.add(new FriendListSearch(id, name, photo, a));
                    break;
                case "No Relation":
                    friendSearch.add(new FriendSuggestionSearch(id, name, photo, a));
                    break;
                case "Blocked":
                    friendSearch.add(new BlockedSearch(id, name, photo, a));
                    break;
                case"Pending":
                    friendSearch.add(new FriendRequestSearch(id, name, photo, a));
                    break;
            }
        }
        friendSearch.revalidate();
        friendSearch.repaint();

    }//GEN-LAST:event_Search

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchButton;
    private javax.swing.JPanel friendSearch;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
