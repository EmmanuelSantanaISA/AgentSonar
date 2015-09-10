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
public class Magnetometer extends AxisSensor3 {

    public Magnetometer() {

    }

    public Magnetometer(Double x, Double y, Double z) {
        super(x, y, z);
    }

    @Override
    public Double getX() {
        return x * 0.1;
    }

    @Override
    public Double getY() {
        return y * 0.1;
    }

    @Override
    public Double getZ() {
        return z * 0.1;
    }
}
