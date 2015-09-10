/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dcslab.virtualreality.model;

/**
 *
 * @author armando
 */
public class FXOS8700CQ {

    private Accelerometer accelerometer;
    private Magnetometer magnetometer;

    public FXOS8700CQ() {
    }

    public FXOS8700CQ(Accelerometer accelerometer, Magnetometer magnetometer) {
        this.accelerometer = accelerometer;
        this.magnetometer = magnetometer;
    }

    public Accelerometer getAccelerometer() {
        return accelerometer;
    }

    public void setAccelerometer(Accelerometer accelerometer) {
        this.accelerometer = accelerometer;
    }

    public Magnetometer getMagnetometer() {
        return magnetometer;
    }

    public void setMagnetometer(Magnetometer magnetometer) {
        this.magnetometer = magnetometer;
    }

    public Double getHeading() {
        double heading = Math.atan2(magnetometer.getY(), magnetometer.getX());
        if (heading < 0) {
            heading += 2 * Math.PI;
        }
        if (heading > 2 * Math.PI) {
            heading -= 2 * Math.PI;
        }

        return heading * 180 / Math.PI;
    }

    public double getUpperRightRotationX() {
        double rotation = Math.atan2(accelerometer.getZ(), accelerometer.getY());
        if (rotation < 0) {
            rotation += 2 * Math.PI;
        }
        if (rotation > 2 * Math.PI) {
            rotation -= 2 * Math.PI;
        }
        rotation = (rotation * 180 / Math.PI) - 2;
        return rotation > 181 ? rotation - 360 : rotation;
    }
    
    public double getUpperRightRotationY(){
        return 0;
    }
    
    public double getUpperRightRotationZ(){
        double rotation = Math.atan2(accelerometer.getX(), accelerometer.getY());
        if (rotation < 0) {
            rotation += 2 * Math.PI;
        }
        if (rotation > 2 * Math.PI) {
            rotation -= 2 * Math.PI;
        }
        rotation = (rotation * 180 / Math.PI) + 2;
        
        return rotation > 181 ? (rotation - 360)*-1 : rotation*-1;
    }
}
