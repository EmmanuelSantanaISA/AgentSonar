/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dcslab.virtualreality.model;

/**
 *
 * @author emmanuelsantana
 */
public class Gyroscope {
    private String roll;
    private String pitch;
    private String yaw;

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public String getYaw() {
        return yaw;
    }

    public void setYaw(String yaw) {
        this.yaw = yaw;
    }
}
