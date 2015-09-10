/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dcslab.virtualreality.controller;

import java.io.IOException;
import org.dcslab.virtualreality.model.Percept;
import org.dcslab.virtualreality.view.SensorView;

/**
 *
 * @author armando
 */
public class SensorController implements Runnable {

    private SerialCommunicationController scc;
    private boolean shutdown;
    private SensorView view;

    public SensorController(SensorView sensorView) {
        setShutdown(true);
        scc = SerialCommunicationController.getInstace();
        this.view = sensorView;
    }

    public boolean isShutdown() {
        return shutdown;
    }

    public void setShutdown(boolean shutdown) {
        this.shutdown = shutdown;
    }

    @Override
    public void run() {
        String json = "";
        byte[] buffer = new byte[1];
        try {
            while (scc.getInputStream().read(buffer) > -1 && !isShutdown()) {
                String character = new String(buffer);
                System.out.println("Serial: "  + character);
                if (!character.equals("\n")) {
                    if (character.equals("\r")) {
                        Percept percept = scc.JsonDeserialize(json);
                        if (percept != null) {
                           
                        }
                        json = "";
                    } else {
                        json += character;
                    }
                }
            }
            setShutdown(true);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
