/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connecthub;

import Frontend.LoginWindow;
import Frontend.ProfileDetails;
import Frontend.ProfileDetails;
/**
 *
 * @author Mnw Emile
 */
public class ConnectHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new ProfileDetails().setVisible(true);
            }
        });
    }    }
