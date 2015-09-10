/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dcslab.virtualreality.model;

/**
 *
 * @author emmanuelsantana
 */
public class PlayerModel {

    private String name;
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return name;
    }
}
