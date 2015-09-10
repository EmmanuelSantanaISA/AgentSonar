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
public class AxisSensor3 {
    protected Double x;
    protected Double y;
    protected Double z;

    public AxisSensor3(){
        
    }
    
    public AxisSensor3(Double x, Double y, Double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }
}
