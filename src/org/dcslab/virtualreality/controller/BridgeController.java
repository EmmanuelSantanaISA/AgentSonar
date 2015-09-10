/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dcslab.virtualreality.controller;

import org.dcslab.virtualreality.jm3.MoveBody;
import org.dcslab.virtualreality.view.SensorView;
import com.jme3.system.AppSettings;
import java.util.ArrayList;
import java.util.List;
import org.dcslab.virtualreality.model.Percept;

/**
 *
 * @author emmanuelsantana
 */
public class BridgeController implements SensorCallback {

    List<SensorCallback> animables;
    MoveBody moveBody;
    SensorView sensorControllerView = null;
private Percept percept;

    public BridgeController() {
        this.animables = new ArrayList<>();

    }

    public boolean addObserver(SensorCallback animableBody) {
        if (animables.contains(animableBody)) {
            System.out.println("This animable has already been registered");
            return false;
        } else {
            animables.add(animableBody);
            System.out.println("Animable correctly added");
            return true;
        }
    }

    public boolean deleteObserver(SensorCallback animableBody) {
        if (animables.contains(animableBody)) {
            animables.remove(animableBody);
            System.out.println("Animable correctly removed");
            return true;
        } else {
            animables.add(animableBody);
            System.out.println("This animable is not in the list");
            return false;
        }

    }

    public void startGame() {
        moveBody = new MoveBody();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                setUpWindow();
                moveBody.start();
            }

            private void setUpWindow() {
                moveBody.setShowSettings(false);
                AppSettings settings = new AppSettings(true);
                settings.put("Width", 1800);
                settings.put("Height", 1000);
                settings.put("Title", "My awesome Game");
                settings.put("VSync", true);
                //Anti-Aliasing
                settings.put("Samples", 4);
                moveBody.setSettings(settings);
            }
        });
        t.start();
    }

   

    public void startSensorController() {

        if (sensorControllerView == null) {
            sensorControllerView = new SensorView(this);
        }
        sensorControllerView.setVisible(true);
    }

    @Override
    public void update(Percept percept) {
        this.percept = percept;
        for (SensorCallback iAnimableBody : animables) {
            iAnimableBody.update(percept);
        }
    }
}
