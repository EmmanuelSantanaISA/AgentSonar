/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dcslab.virtualreality.view;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.dcslab.virtualreality.controller.SensorCallback;
import org.dcslab.virtualreality.controller.SerialCommunicationController;
import org.dcslab.virtualreality.controller.SensorController;

/**
 *
 * @author armando
 */
public class SensorView extends javax.swing.JFrame {

    private SerialCommunicationController scc;
    private HashMap ports;
    private SensorController serialReader;
    //private BridgeController bridgeController;
    //private int time = 25;
    private boolean shutdown;
    SensorCallback bridgeController;

    /**
     * Creates new form SensorController
     */
    public SensorView(SensorCallback bridgeController) {
        serialReader = new SensorController(this);
        scc = SerialCommunicationController.getInstace();
        //scc.setBridgeController(bridgeController);
        this.bridgeController = bridgeController;

        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fillPorts();
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    btnDisconnectActionPerformed(null);
                } catch (Exception ex) {
                    Logger.getLogger(SensorView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void fillPorts() {
        ports = scc.searchForPorts();
        cmbPorts.removeAllItems();

        Iterator it = ports.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            cmbPorts.addItem(pair.getKey());
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

        jLabel5 = new javax.swing.JLabel();
        pnlSensor = new javax.swing.JPanel();
        lblPorts = new javax.swing.JLabel();
        cmbPorts = new javax.swing.JComboBox();
        btnConnect = new javax.swing.JButton();
        btnDisconnect = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        lblIsConnected = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sensor Controller");

        pnlSensor.setBorder(javax.swing.BorderFactory.createTitledBorder("Sensor Connection Manager"));
        pnlSensor.setToolTipText("Sensor Connection Manager");
        pnlSensor.setName("Sensor Connection Manager"); // NOI18N

        lblPorts.setText("Serial Port:");

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnDisconnect.setText("Disconnect");
        btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnectActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblIsConnected.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        lblIsConnected.setForeground(new java.awt.Color(255, 0, 0));
        lblIsConnected.setText("Disconnected");

        javax.swing.GroupLayout pnlSensorLayout = new javax.swing.GroupLayout(pnlSensor);
        pnlSensor.setLayout(pnlSensorLayout);
        pnlSensorLayout.setHorizontalGroup(
            pnlSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSensorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPorts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlSensorLayout.createSequentialGroup()
                        .addComponent(lblIsConnected)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDisconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbPorts, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSensorLayout.setVerticalGroup(
            pnlSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSensorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPorts)
                    .addComponent(cmbPorts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnect)
                    .addComponent(btnDisconnect)
                    .addComponent(btnRefresh)
                    .addComponent(lblIsConnected))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblPorts.getAccessibleContext().setAccessibleName("Serial Port");
        lblPorts.getAccessibleContext().setAccessibleDescription("");
        cmbPorts.getAccessibleContext().setAccessibleName("");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSensor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSensor.getAccessibleContext().setAccessibleDescription("");

        getAccessibleContext().setAccessibleName("Sensor Connection");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        fillPorts();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        try {
            serialReader.setShutdown(true);
            scc.disconnect();
            scc.connect((String) cmbPorts.getSelectedItem());
            lblIsConnected.setText("Connected");
            lblIsConnected.setForeground(new Color(0, 200, 0));
            serialReader.setShutdown(false);
            new Thread(serialReader).start();
        } catch (Exception ex) {
            Logger.getLogger(SensorView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed
        try {
            serialReader.setShutdown(true);
            scc.disconnect();
            lblIsConnected.setText("Disconnected");
            lblIsConnected.setForeground(Color.red);
        } catch (Exception ex) {
            Logger.getLogger(SensorView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDisconnectActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        try {
            serialReader.setShutdown(true);
            scc.disconnect();
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(SensorView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    public boolean isShutdown() {
        return shutdown;
    }

    public void setShutdown(boolean shutdown) {
        this.shutdown = shutdown;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDisconnect;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox cmbPorts;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblIsConnected;
    private javax.swing.JLabel lblPorts;
    private javax.swing.JPanel pnlSensor;
    // End of variables declaration//GEN-END:variables
}