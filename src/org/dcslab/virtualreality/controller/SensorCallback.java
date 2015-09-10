/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dcslab.virtualreality.controller;

import org.dcslab.virtualreality.model.Percept;

/**
 *
 * @author emmanuelsantana
 */
public interface SensorCallback {

    void update(Percept percept);

}
