/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dcslab.virtualreality.main;

import org.dcslab.virtualreality.controller.BridgeController;
import org.dcslab.virtualreality.view.BridgeView;

/**
 *
 * @author emmanuelsantana
 */
public class MainApp {

    public static void main(String[] args) {
        setLookAndFeel();

        BridgeController bridgeController = new BridgeController();
        BridgeView bridge = new BridgeView(bridgeController);
        bridge.setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BridgeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
