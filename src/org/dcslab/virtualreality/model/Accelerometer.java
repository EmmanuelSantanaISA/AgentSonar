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
public class Accelerometer extends AxisSensor3{
    public Accelerometer(){
        
    }
    
    public Accelerometer(Double x, Double y, Double z){
        super(x, y, z);
    }
}
