/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend;

import Backend.AppManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author User
 */
public class MyPosts_Stories extends javax.swing.JPanel {

    /**
     * Creates new form MyPosts_Stories
     */
    private AppManager a ;
    public MyPosts_Stories(AppManager a) {
        this.a = a;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        postPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        storyPanel = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        CreateStoryButton = new javax.swing.JButton();
        CreatePostButton = new javax.swing.JButton();

        postPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout postPanelLayout = new javax.swing.GroupLayout(postPanel);
        postPanel.setLayout(postPanelLayout);
        postPanelLayout.setHorizontalGroup(
            postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        postPanelLayout.setVerticalGroup(
            postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(postPanel);

        storyPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout storyPanelLayout = new javax.swing.GroupLayout(storyPanel);
        storyPanel.setLayout(storyPanelLayout);
        storyPanelLayout.setHorizontalGroup(
            storyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        storyPanelLayout.setVerticalGroup(
            storyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(storyPanel);

        back.setBackground(new java.awt.Color(102, 153, 255));
        back.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        CreateStoryButton.setBackground(new java.awt.Color(102, 153, 255));
        CreateStoryButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CreateStoryButton.setForeground(new java.awt.Color(255, 255, 255));
        CreateStoryButton.setText("Create Story");
        CreateStoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateStoryButtonActionPerformed(evt);
            }
        });

        CreatePostButton.setBackground(new java.awt.Color(102, 153, 255));
        CreatePostButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CreatePostButton.setForeground(new java.awt.Color(255, 255, 255));
        CreatePostButton.setText("Create post");
        CreatePostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePostButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CreateStoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CreatePostButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(301, 301, 301))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(CreateStoryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(CreatePostButton)))
                .addGap(18, 18, 18)
                .addComponent(back)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CreateStoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateStoryButtonActionPerformed
        // TODO add your handling code here:
                Result result = showCustomDialog();
            if(result.userText.equals("")){
                JOptionPane.showMessageDialog(null, "Text can't be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if(!result.imagePath.equals("No file selected")){
//                StoryImage storyImage = new StoryImage(result.userText, result.imagePath);
//                storyPanel.add(storyImage);
            }
            else{
//                PostText postText = new PostText(result.userText);
//                storyPanel.add(postText);
            }
        storyPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
        storyPanel.revalidate();
        storyPanel.repaint();
    }//GEN-LAST:event_CreateStoryButtonActionPerformed

    private void CreatePostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePostButtonActionPerformed
        // TODO add your handling code here:
                    Result result = showCustomDialog();
            if(result.userText.equals("")){
                JOptionPane.showMessageDialog(null, "Text can't be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if(!result.imagePath.equals("No file selected")){
//                PostImage post = new PostImage(result.userText, result.imagePath);
//                postPanel.add(post);
            }
            else{
//                PostText postText = new PostText(result.userText);
//                postPanel.add(postText);
            }
           // System.out.println(result.imagePath);
           
//        });
      //  postPanel.setBackground(Color.BLUE);
        postPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
        postPanel.revalidate();
        postPanel.repaint();
    }//GEN-LAST:event_CreatePostButtonActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        ProfileDetails profileDetails = new ProfileDetails(a);
        profileDetails.setVisible(true);
       
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreatePostButton;
    private javax.swing.JButton CreateStoryButton;
    private javax.swing.JButton back;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel postPanel;
    private javax.swing.JPanel storyPanel;
    // End of variables declaration//GEN-END:variables
}