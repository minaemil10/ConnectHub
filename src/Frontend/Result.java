/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author User
 */
class Result {
        String imagePath;
        String userText;

        public Result(String imagePath, String userText) {
            this.imagePath = imagePath;
            this.userText = userText;
        }
    

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
}
    // Class to hold the result
    