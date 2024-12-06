/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.AppManager;
import Backend.Online;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carls
 */
public class NewsfeedWindow extends javax.swing.JFrame {

    /**
     * Creates new form NewsfeedWindow
     */
    private AppManager a ;
    public NewsfeedWindow(AppManager a) {
        initComponents();
        this.a = a;
         postPanel.setLayout(new javax.swing.BoxLayout(postPanel, javax.swing.BoxLayout.Y_AXIS));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        storyPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        postPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        RefreshButton = new javax.swing.JButton();
        profileMangmentButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        CreatePostButton = new javax.swing.JButton();
        CreateStoryButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        status = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane3.setViewportBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        storyPanel.setLayout(new javax.swing.BoxLayout(storyPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane3.setViewportView(storyPanel);

        jScrollPane4.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jScrollPane4ComponentAdded(evt);
            }
        });
        jScrollPane4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jScrollPane4FocusGained(evt);
            }
        });

        postPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        postPanel.setAutoscrolls(true);
        postPanel.setLayout(new javax.swing.BoxLayout(postPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane4.setViewportView(postPanel);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("photo");

        RefreshButton.setBackground(new java.awt.Color(0, 153, 255));
        RefreshButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RefreshButton.setForeground(new java.awt.Color(255, 255, 255));
        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        profileMangmentButton.setBackground(new java.awt.Color(0, 153, 255));
        profileMangmentButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        profileMangmentButton.setForeground(new java.awt.Color(255, 255, 255));
        profileMangmentButton.setText("My profile");
        profileMangmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileMangmentButtonActionPerformed(evt);
            }
        });

        LogoutButton.setBackground(new java.awt.Color(0, 153, 255));
        LogoutButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogoutButton.setText("Logout");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        CreatePostButton.setBackground(new java.awt.Color(0, 153, 255));
        CreatePostButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CreatePostButton.setForeground(new java.awt.Color(255, 255, 255));
        CreatePostButton.setText("Create a post");
        CreatePostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePostButtonActionPerformed(evt);
            }
        });

        CreateStoryButton.setBackground(new java.awt.Color(0, 153, 255));
        CreateStoryButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CreateStoryButton.setForeground(new java.awt.Color(255, 255, 255));
        CreateStoryButton.setText("Create a story");
        CreateStoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateStoryButtonActionPerformed(evt);
            }
        });

        status.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "User", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(status);
        if (status.getColumnModel().getColumnCount() > 0) {
            status.getColumnModel().getColumn(0).setPreferredWidth(120);
            status.getColumnModel().getColumn(0).setMaxWidth(120);
            status.getColumnModel().getColumn(1).setPreferredWidth(121);
            status.getColumnModel().getColumn(1).setMaxWidth(121);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(CreateStoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(CreatePostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 445, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RefreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(profileMangmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(LogoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RefreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(profileMangmentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LogoutButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreateStoryButton)
                    .addComponent(CreatePostButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addComponent(jScrollPane5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<Online> o = a.getOnline();
        for(Online on : o){
            //DefaultTableModel model = new DefaultTableModel();
            DefaultTableModel model = (DefaultTableModel) status.getModel();
            String user  = on.getUser();
            String status;
            if(on.getStatus()){
                status = "online";
            }
            else{
                status = "offline";
            }
            model.addRow(new Object[]{user, status});
        }
        
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void profileMangmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileMangmentButtonActionPerformed
        // TODO add your handling code here:
        ProfileDetails profileDetails = new ProfileDetails(a);
        profileDetails.setVisible(true);
    }//GEN-LAST:event_profileMangmentButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // TODO add your handling code here:
        a.LogoutUser();
        
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void CreatePostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePostButtonActionPerformed
        // TODO add your handling code here:
        //String text = "Connect app";
        //Post post = new PostImage(text);
        //postPanel.add(post);
//        JFrame frame = new JFrame("Custom Dialog Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300, 200);
//        frame.setVisible(true);
//
//        // Button to open the dialog
//        JButton openDialogButton = new JButton("Open Dialog");
//        frame.add(openDialogButton, BorderLayout.CENTER);

        // Action listener for the button
       // openDialogButton.addActionListener(e -> {
            // Open the custom dialog
            Result result = showCustomDialog();
            if(result.userText.equals("")){
                JOptionPane.showMessageDialog(null, "Text can't be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if(!result.imagePath.equals("No file selected")){
                PostImage post = new PostImage(result.userText, result.imagePath);
                postPanel.add(post);
            }
            else{
                PostText postText = new PostText(result.userText);
                postPanel.add(postText);
            }
           // System.out.println(result.imagePath);
           
//        });
      //  postPanel.setBackground(Color.BLUE);
        postPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
        postPanel.revalidate();
        postPanel.repaint();
        
    }//GEN-LAST:event_CreatePostButtonActionPerformed

    private void CreateStoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateStoryButtonActionPerformed
        // TODO add your handling code here:
        Result result = showCustomDialog();
            if(result.userText.equals("")){
                JOptionPane.showMessageDialog(null, "Text can't be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if(!result.imagePath.equals("No file selected")){
                StoryImage storyImage = new StoryImage(result.userText, result.imagePath);
                storyPanel.add(storyImage);
            }
            else{
                PostText postText = new PostText(result.userText);
                storyPanel.add(postText);
            }
        storyPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
        storyPanel.revalidate();
        storyPanel.repaint();
    }//GEN-LAST:event_CreateStoryButtonActionPerformed

    private void jScrollPane4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane4FocusGained

    private void jScrollPane4ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jScrollPane4ComponentAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jScrollPane4ComponentAdded
     public static Result showCustomDialog() {
        // Create a JDialog
        JDialog dialog = new JDialog((Frame) null ,"Custom Dialog", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());


        // Panel for file chooser
        JPanel filePanel = new JPanel(new FlowLayout());
        JLabel fileLabel = new JLabel("No file selected");
        JButton fileButton = new JButton("Choose Image");
        filePanel.add(fileButton);
        filePanel.add(fileLabel);

        // Add file chooser functionality
        fileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            // Filter for image files only
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "bmp");
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(dialog);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                fileLabel.setText(selectedFile.getAbsolutePath());
            }
        });

        // Text area for user input
        JTextArea textArea = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(new JLabel("Enter your text:"), BorderLayout.NORTH);
        textPanel.add(scrollPane, BorderLayout.CENTER);

        // Buttons for OK and Cancel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        // Variable to hold the result
        final Result[] dialogResult = {null};

        // Action for OK button
        okButton.addActionListener(e -> {
            String imagePath = fileLabel.getText();
            String userText = textArea.getText();
            dialogResult[0] = new Result(imagePath, userText);
            dialog.dispose();
            // Only proceed if a file is selected
//            if (!imagePath.equals("No file selected")) {
//                dialogResult[0] = new Result(imagePath, userText);
//                dialog.dispose();
//            } else {
//                JOptionPane.showMessageDialog(dialog, "Please select an image.", "Warning", JOptionPane.WARNING_MESSAGE);
//            }
        });

        // Action for Cancel button
        cancelButton.addActionListener(e -> {
            dialogResult[0] = null;
            dialog.dispose();
        });

        // Add components to the dialog
        dialog.add(filePanel, BorderLayout.NORTH);
        dialog.add(textPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // Show the dialog
        dialog.setVisible(true);

        // Return the result
        return dialogResult[0];
    }

    // Class to hold the result
    static class Result {
        String imagePath;
        String userText;

        public Result(String imagePath, String userText) {
            this.imagePath = imagePath;
            this.userText = userText;
        }
    }


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
            java.util.logging.Logger.getLogger(NewsfeedWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewsfeedWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewsfeedWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewsfeedWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            //    new NewsfeedWindow(a).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreatePostButton;
    private javax.swing.JButton CreateStoryButton;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel postPanel;
    private javax.swing.JButton profileMangmentButton;
    private javax.swing.JTable status;
    private javax.swing.JPanel storyPanel;
    // End of variables declaration//GEN-END:variables
}
