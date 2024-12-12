/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.AppManager;
import Backend.Friend_Management.PostString;
import Backend.Friend_Management.UserSearch;
import Backend.GroupString;
import static Frontend.MyPosts_Stories.showCustomDialog;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author carls
 */
public class GroupForAdmins extends javax.swing.JFrame {

    /**
     * Creates new form GroupForAdmins
     */
    private AppManager a;
    GroupString gs;
    public GroupForAdmins(AppManager a, GroupString gs) {
        initComponents();
        this.a = a;
        this.gs = gs;
        postPanel.setLayout(new javax.swing.BoxLayout(postPanel, javax.swing.BoxLayout.Y_AXIS));
        String photo = gs.getPhoto();
        String groupName = gs.getName();
        GroupNameField.setText(groupName);
        String groupD = gs.getDescription();
        GroupDescriptionField.setText(groupD);
        ImageIcon imageIcon = new ImageIcon(photo);
            Image image = imageIcon.getImage().getScaledInstance(
                90, 
                90, 
                Image.SCALE_SMOOTH
            );
        GroupPhoto.setIcon(new ImageIcon(image));
        GroupPhoto.setText("");
        ArrayList<PostString> posts = a.getGroupPosts();
        for(PostString p : posts){
            String text = p.getText();
            String postPhoto = p.getPhoto();
            String name = p.getAuthor();
            String date = p.getDate();
            if(postPhoto.equals("No file selected")){
                AcceptedPostText ap =new AcceptedPostText(text, name, date, a, p.getPostId(), gs.getId());
                postPanel.add(ap);
            }
            else{
                AcceptedPostImage ap = new AcceptedPostImage(photo, text, name, date, a, p.getPostId(), gs.getId());
                postPanel.add(ap);
            }
            
        }
            postPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
            postPanel.revalidate();
            postPanel.repaint(); 
        ArrayList<UserSearch> members = a.getAllMembersOfGroup(gs.getId());
        for(UserSearch u : members){
            String name= u.getUsernameString();
            String userPhoto = u.getPhotoString();
            String relation = u.getRelationString();
            String id = u.getIdString();
            MembersForAdmin m = new MembersForAdmin(a, name, userPhoto, id, gs.getId());
            membersPanel.add(m);
        }
        ArrayList<UserSearch> pendingMembers = a.getAllPendingRequestsOfGroup(gs.getId());
        for(UserSearch u : members){
            String name= u.getUsernameString();
            String userPhoto = u.getPhotoString();
            String relation = u.getRelationString();
            String id = u.getIdString();
            PendingMembers pm = new PendingMembers(a, name, photo, id, gs.getId());
            pendingPanel.add(pm);
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupPhoto = new javax.swing.JLabel();
        GroupNameField = new javax.swing.JTextField();
        GroupDescriptionField = new javax.swing.JTextField();
        GroupPostsPane = new javax.swing.JScrollPane();
        postPanel = new javax.swing.JPanel();
        CreatepostButton = new javax.swing.JButton();
        ManagepostButton = new javax.swing.JButton();
        PendingMembersLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pendingPanel = new javax.swing.JPanel();
        MembersLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        membersPanel = new javax.swing.JPanel();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setPreferredSize(new java.awt.Dimension(1000, 615));
        setSize(new java.awt.Dimension(1000, 0));

        GroupPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GroupNameField.setEditable(false);

        GroupDescriptionField.setEditable(false);

        javax.swing.GroupLayout postPanelLayout = new javax.swing.GroupLayout(postPanel);
        postPanel.setLayout(postPanelLayout);
        postPanelLayout.setHorizontalGroup(
            postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );
        postPanelLayout.setVerticalGroup(
            postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        GroupPostsPane.setViewportView(postPanel);

        CreatepostButton.setBackground(new java.awt.Color(51, 153, 255));
        CreatepostButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CreatepostButton.setForeground(new java.awt.Color(255, 255, 255));
        CreatepostButton.setText("Create post");
        CreatepostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatepostButtonActionPerformed(evt);
            }
        });

        ManagepostButton.setBackground(new java.awt.Color(51, 153, 255));
        ManagepostButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ManagepostButton.setForeground(new java.awt.Color(255, 255, 255));
        ManagepostButton.setText("Manage posts");
        ManagepostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManagepostButtonActionPerformed(evt);
            }
        });

        PendingMembersLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PendingMembersLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PendingMembersLabel1.setText("Pending Members");

        javax.swing.GroupLayout pendingPanelLayout = new javax.swing.GroupLayout(pendingPanel);
        pendingPanel.setLayout(pendingPanelLayout);
        pendingPanelLayout.setHorizontalGroup(
            pendingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );
        pendingPanelLayout.setVerticalGroup(
            pendingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pendingPanel);

        MembersLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MembersLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MembersLabel1.setText("Members");

        javax.swing.GroupLayout membersPanelLayout = new javax.swing.GroupLayout(membersPanel);
        membersPanel.setLayout(membersPanelLayout);
        membersPanelLayout.setHorizontalGroup(
            membersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );
        membersPanelLayout.setVerticalGroup(
            membersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(membersPanel);

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(GroupPostsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MembersLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CreatepostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(150, 150, 150)
                                .addComponent(ManagepostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(GroupDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(GroupPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(GroupNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(refresh, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PendingMembersLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GroupPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(GroupNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GroupDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refresh))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CreatepostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ManagepostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PendingMembersLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GroupPostsPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MembersLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreatepostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatepostButtonActionPerformed
        // TODO add your handling code here:
            MyPosts_Stories.Result result = showCustomDialog();
            
            if(result.userText.equals("")){
                JOptionPane.showMessageDialog(null, "Text can't be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else {
                a.createGroupPost(gs.getId(), result.imagePath, result.userText);
               
            }
            postPanel.removeAll();
    }//GEN-LAST:event_CreatepostButtonActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        ArrayList<PostString>posts = a.getGroupPosts();
        for(PostString p : posts){
            String text = p.getText();
            String postPhoto = p.getPhoto();
            String name = p.getAuthor();
            String date = p.getDate();
            if(postPhoto.equals("No file selected")){
                PostText pt = new PostText(text, name, date);
                postPanel.add(pt);
            }
            else{
                PostImage pi = new PostImage(text, postPhoto, name, date);
                postPanel.add(pi);
            }
        }
            postPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
            postPanel.revalidate();
            postPanel.repaint();
         ArrayList<UserSearch> members = a.getAllMembersOfGroup(gs.getId());
        for(UserSearch u : members){
            String name= u.getUsernameString();
            String userPhoto = u.getPhotoString();
            String relation = u.getRelationString();
            String id = u.getIdString();
            MembersForAdmin m = new MembersForAdmin(a, name, userPhoto, id, gs.getId());
            membersPanel.add(m);
        }
    }//GEN-LAST:event_refreshActionPerformed

    private void ManagepostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagepostButtonActionPerformed
        // TODO add your handling code here:
        ManagePosts m = new ManagePosts();
        m.setVisible(true);
    }//GEN-LAST:event_ManagepostButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GroupForAdmins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GroupForAdmins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GroupForAdmins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GroupForAdmins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new GroupForAdmins().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreatepostButton;
    private javax.swing.JTextField GroupDescriptionField;
    private javax.swing.JTextField GroupNameField;
    private javax.swing.JLabel GroupPhoto;
    private javax.swing.JScrollPane GroupPostsPane;
    private javax.swing.JButton ManagepostButton;
    private javax.swing.JLabel MembersLabel1;
    private javax.swing.JLabel PendingMembersLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel membersPanel;
    private javax.swing.JPanel pendingPanel;
    private javax.swing.JPanel postPanel;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables
}
