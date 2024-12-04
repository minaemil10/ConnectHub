/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import java.awt.Image;
import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Backend.SignUp;
import Backend.User;
import java.util.ArrayList;

/**
 *
 * @author carls
 */
public class SignUpWindow extends javax.swing.JFrame {

    /**
     * Creates new form SignUpWindow
     */
    private String profilePhotoPath = ""; 
    private String coverPhotoPath = ""; 

    public SignUpWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        username3 = new javax.swing.JTextField();
        birthday = new javax.swing.JTextField();
        jUsernameField = new javax.swing.JTextField();
        jEmailField = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jConfirmPasswordField = new javax.swing.JPasswordField();
        jCalendarPanel1 = new de.wannawork.jcalendar.JCalendarPanel();
        profilePhoto = new javax.swing.JTextField();
        UploadProfilePhoto = new javax.swing.JButton();
        UploadCoverPhoto1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jSignUpButton = new javax.swing.JButton();
        photoLabel = new javax.swing.JLabel();
        photoLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        username.setEditable(false);
        username.setBackground(new java.awt.Color(0, 153, 255));
        username.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setText("Username");

        email.setEditable(false);
        email.setBackground(new java.awt.Color(0, 153, 255));
        email.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setText("Email");

        password.setEditable(false);
        password.setBackground(new java.awt.Color(0, 153, 255));
        password.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setText("Password");

        username3.setEditable(false);
        username3.setBackground(new java.awt.Color(0, 153, 255));
        username3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        username3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username3.setText("Confirm Password");

        birthday.setEditable(false);
        birthday.setBackground(new java.awt.Color(0, 153, 255));
        birthday.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        birthday.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        birthday.setText("Birthday");

        jUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsernameFieldActionPerformed(evt);
            }
        });

        jEmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmailFieldActionPerformed(evt);
            }
        });

        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });

        jConfirmPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfirmPasswordFieldActionPerformed(evt);
            }
        });

        jCalendarPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jCalendarPanel1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        profilePhoto.setEditable(false);
        profilePhoto.setBackground(new java.awt.Color(0, 153, 255));
        profilePhoto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        profilePhoto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        profilePhoto.setText("profile photo");

        UploadProfilePhoto.setBackground(new java.awt.Color(0, 153, 255));
        UploadProfilePhoto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UploadProfilePhoto.setForeground(new java.awt.Color(255, 255, 255));
        UploadProfilePhoto.setText("Upload photo");
        UploadProfilePhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadProfilePhotoActionPerformed(evt);
            }
        });

        UploadCoverPhoto1.setBackground(new java.awt.Color(0, 153, 255));
        UploadCoverPhoto1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UploadCoverPhoto1.setForeground(new java.awt.Color(255, 255, 255));
        UploadCoverPhoto1.setText("Upload photo");
        UploadCoverPhoto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadCoverPhoto1ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 153, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Cover photo");

        jSignUpButton.setBackground(new java.awt.Color(0, 153, 255));
        jSignUpButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSignUpButton.setForeground(new java.awt.Color(255, 255, 255));
        jSignUpButton.setText("SignUp");
        jSignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSignUpButtonActionPerformed(evt);
            }
        });

        photoLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        photoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photoLabel.setText("no photo");

        photoLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        photoLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photoLabel1.setText("no photo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(email)
                    .addComponent(password)
                    .addComponent(username3)
                    .addComponent(username))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jUsernameField)
                    .addComponent(jEmailField)
                    .addComponent(jPasswordField)
                    .addComponent(jConfirmPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UploadCoverPhoto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jCalendarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(profilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(UploadProfilePhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(photoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(photoLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jSignUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UploadProfilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UploadCoverPhoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(photoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addComponent(jSignUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUsernameFieldActionPerformed

    private void jEmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmailFieldActionPerformed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private void jConfirmPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfirmPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jConfirmPasswordFieldActionPerformed

    private void UploadProfilePhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadProfilePhotoActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".png");
            }

            @Override
            public String getDescription() {
                return "PNG Images (*.png)";
            }
        });
        
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
             profilePhotoPath = selectedFile.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(profilePhotoPath);
            Image image = imageIcon.getImage().getScaledInstance(
                photoLabel.getWidth(), 
                photoLabel.getHeight(), 
                Image.SCALE_SMOOTH
            );
            photoLabel.setIcon(new ImageIcon(image));
            photoLabel.setText(""); 
            
           JOptionPane.showMessageDialog(this, "photo uploaded successfully");
        } else {
        JOptionPane.showMessageDialog(null, "No image selected", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    
    }//GEN-LAST:event_UploadProfilePhotoActionPerformed

    private void jCalendarPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jCalendarPanel1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jCalendarPanel1AncestorAdded

    private void UploadCoverPhoto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadCoverPhoto1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".png");
            }

            @Override
            public String getDescription() {
                return "PNG Images (*.png)";
            }
        });
        
        // Show the file chooser dialog
        int result = fileChooser.showOpenDialog(null);
        
        // Check if the user selected a file
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            coverPhotoPath = selectedFile.getAbsolutePath();
           ImageIcon imageIcon = new ImageIcon(coverPhotoPath);
            Image image = imageIcon.getImage().getScaledInstance(
                photoLabel1.getWidth(), 
                photoLabel1.getHeight(), 
                Image.SCALE_SMOOTH
            );
            photoLabel1.setIcon(new ImageIcon(image));
            photoLabel1.setText("");
            
           JOptionPane.showMessageDialog(this, "photo uploaded successfully");
        } else {
        JOptionPane.showMessageDialog(null, "No image selected", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_UploadCoverPhoto1ActionPerformed

    private void jSignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSignUpButtonActionPerformed
        // TODO add your handling code here:
        /* ArrayList<User> users = AppManger.getUsers();
         String email = jEmailField.getText().trim();
         String userName = jUsernameField.getText().trim();
         String password = new String(jPasswordField.getPassword()).trim();
         String confirmPassword = new String(jConfirmPasswordField.getPassword()).trim();
         LocalDate birthDate = LocalDate.ofInstant(jCalendarPanel1.getDate().toInstant(), ZoneId.systemDefault());
         LocalDate today = LocalDate.now();
         int age = Period.between(birthDate, today).getYears();
    
         if(email.isEmpty() || userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
             JOptionPane.showMessageDialog(null, "there are empty fields.", "Warning", JOptionPane.WARNING_MESSAGE);
         }
         else if(!(password.equals(confirmPassword))){
             JOptionPane.showMessageDialog(null, "passwords not identical", "Warning", JOptionPane.WARNING_MESSAGE);
         }
         else if(!(Validation.Validator.isEmail(email))){
             JOptionPane.showMessageDialog(null, "enter correct email.", "Warning", JOptionPane.WARNING_MESSAGE);
         }
         else if (age < 12) {
        JOptionPane.showMessageDialog(null, "You must be at least 12 years old to sign up.", "Warning", JOptionPane.WARNING_MESSAGE);
    }
         else{
             SignUp signUp = new SignUp();
             User user  = signUp.addUser(users.size()+ 1 , email, password, userName, birthDate, false , users);
             if(!coverPhotoPath.isEmpty()){
             user.setCoverPhoto(coverPhotoPath);
             }
             if(!profilePhotoPath.isEmpty()){
                 user.setProfilePhoto(profilePhotoPath);
             }
             JOptionPane.showMessageDialog(this, "account created successfully");
             LoginWindow login = new LoginWindow();
             login.setVisible(true);
             this.dispose();
         }*/
    }//GEN-LAST:event_jSignUpButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SignUpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UploadCoverPhoto1;
    private javax.swing.JButton UploadProfilePhoto;
    private javax.swing.JTextField birthday;
    private javax.swing.JTextField email;
    private de.wannawork.jcalendar.JCalendarPanel jCalendarPanel1;
    private javax.swing.JPasswordField jConfirmPasswordField;
    private javax.swing.JTextField jEmailField;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JButton jSignUpButton;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jUsernameField;
    private javax.swing.JTextField password;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JLabel photoLabel1;
    private javax.swing.JTextField profilePhoto;
    private javax.swing.JTextField username;
    private javax.swing.JTextField username3;
    // End of variables declaration//GEN-END:variables
}
