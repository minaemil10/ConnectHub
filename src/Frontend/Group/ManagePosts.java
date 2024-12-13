/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.AppManager;
import Backend.Friend_Management.PostString;
import java.util.ArrayList;

/**
 *
 * @author carls
 */
public class ManagePosts extends javax.swing.JFrame {

    /**
     * Creates new form ManagePosts
     */
    AppManager a;
    String gpId;
    public ManagePosts(AppManager a, String gpId) {
        initComponents();
        this.a=a;
        this.gpId= gpId;
        ArrayList<PostString> pendingPosts = a.getAllPendingPostsOfGroup(gpId);
        for(PostString p : pendingPosts){
            String text = p.getText();
            String date = p.getDate();
            String id= p.getPostId();
            String photo = p.getPhoto();
            String name  = p.getAuthor();
            if(photo.equals("No file selected")){
               GroupPostText gp = new GroupPostText(a, name, date, text, p.getPostId(), gpId);
               managePost.add(gp);
            }
            else{
                GroupPostImage gp = new GroupPostImage(a, name, photo, date, text, p.getPostId(), gpId);
                managePost.add(gp);
            }
        }
        managePost.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
        managePost.revalidate();
        managePost.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ManagePostsPane = new javax.swing.JScrollPane();
        managePost = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        managePost.setLayout(new javax.swing.BoxLayout(managePost, javax.swing.BoxLayout.LINE_AXIS));
        ManagePostsPane.setViewportView(managePost);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(ManagePostsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ManagePostsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ManagePosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagePosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagePosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagePosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
        //        new ManagePosts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ManagePostsPane;
    private javax.swing.JPanel managePost;
    // End of variables declaration//GEN-END:variables
}
