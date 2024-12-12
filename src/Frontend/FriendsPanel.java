/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend;

import Backend.AppManager;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author carls
 */
public class FriendsPanel extends javax.swing.JPanel {

    private AppManager a;
    private String id;
    private String name;
    private String photo;
    public FriendsPanel(String id, String name, String photo ,AppManager a) {
        initComponents();
        this.id=id;
        this.a = a;
        FriendNameField.setText(name);
        ImageIcon imageIcon = new ImageIcon(photo);
            Image image = imageIcon.getImage().getScaledInstance(
                90, 
                90, 
                Image.SCALE_SMOOTH
            );
            FriendPhotoLabel1.setIcon(new ImageIcon(image));
            FriendPhotoLabel1.setText("");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FriendPhotoLabel1 = new javax.swing.JLabel();
        FriendNameField = new javax.swing.JTextField();
        ViewProfileButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        BlockButton = new javax.swing.JButton();

        FriendPhotoLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        FriendNameField.setEditable(false);

        ViewProfileButton.setBackground(new java.awt.Color(51, 153, 255));
        ViewProfileButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ViewProfileButton.setForeground(new java.awt.Color(255, 255, 255));
        ViewProfileButton.setText("View Profile");
        ViewProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewProfileButtonActionPerformed(evt);
            }
        });

        RemoveButton.setBackground(new java.awt.Color(51, 153, 255));
        RemoveButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RemoveButton.setForeground(new java.awt.Color(255, 255, 255));
        RemoveButton.setText("Remove");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        BlockButton.setBackground(new java.awt.Color(51, 153, 255));
        BlockButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BlockButton.setForeground(new java.awt.Color(255, 255, 255));
        BlockButton.setText("Block");
        BlockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlockButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(FriendPhotoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FriendNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ViewProfileButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RemoveButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(BlockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(FriendPhotoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(FriendNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ViewProfileButton)
                            .addComponent(RemoveButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BlockButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ViewProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewProfileButtonActionPerformed
         new ViewProfile(a,id).setVisible(true);
    }//GEN-LAST:event_ViewProfileButtonActionPerformed

    private void BlockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlockButtonActionPerformed
        a.blockFriend(id);
    }//GEN-LAST:event_BlockButtonActionPerformed

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        //fill it
    }//GEN-LAST:event_RemoveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BlockButton;
    private javax.swing.JTextField FriendNameField;
    private javax.swing.JLabel FriendPhotoLabel1;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JButton ViewProfileButton;
    // End of variables declaration//GEN-END:variables
}
