/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend;

import Backend.AppManager;

/**
 *
 * @author carls
 */
public class AcceptedPostText extends javax.swing.JPanel {

    /**
     * Creates new form AcceptedPostText
     */
    private AppManager a;
    private String postId;
    private String GroupId;
    public AcceptedPostText(String text,String name, String date,AppManager a,String postId,String GroupId) {
        initComponents();
        this.a = a;
        textArea.setText(text);
        Name.setText(name);
        this.date.setText(date);
        this.postId = postId;
        this.GroupId = GroupId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Name = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        textArea = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        EditButton1 = new javax.swing.JButton();
        EditButton2 = new javax.swing.JButton();
        save = new javax.swing.JButton();

        Name.setEnabled(false);

        date.setEnabled(false);

        textArea.setFocusable(false);

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        EditButton1.setBackground(new java.awt.Color(51, 153, 255));
        EditButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditButton1.setText("Edit");
        EditButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButton1ActionPerformed(evt);
            }
        });

        EditButton2.setBackground(new java.awt.Color(51, 153, 255));
        EditButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditButton2.setText("Remove");
        EditButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButton2ActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.setEnabled(false);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(EditButton1)
                        .addGap(12, 12, 12)
                        .addComponent(save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EditButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addComponent(textArea, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditButton1)
                    .addComponent(save)
                    .addComponent(EditButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EditButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButton1ActionPerformed
        // TODO add your handling code here:
        textArea.setFocusable(true);
        save.setEnabled(true);
        
    }//GEN-LAST:event_EditButton1ActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        a.editPost(postId, GroupId, textArea.getText(), "No file selected");
        save.setEnabled(false);
        textArea.setFocusable(false);
    }//GEN-LAST:event_saveActionPerformed

    private void EditButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButton2ActionPerformed
        // TODO add your handling code here:
        a.deletePost(postId, GroupId);
    }//GEN-LAST:event_EditButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditButton1;
    private javax.swing.JButton EditButton2;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField date;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton save;
    private javax.swing.JTextField textArea;
    // End of variables declaration//GEN-END:variables
}
