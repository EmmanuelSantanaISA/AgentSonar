/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dcslab.virtualreality.controller;

import flexjson.JSONDeserializer;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import org.dcslab.virtualreality.model.Percept;

/**
 *
 * @author armando
 */
public class SerialCommunicationController {

    private static SerialCommunicationController scc = new SerialCommunicationController();
    private CommPort commPort = null;
    private InputStream in = null;
    private OutputStream out = null;
    private SensorCallback bridge;
    private Percept gyro = null;

    private SerialCommunicationController() {
    }

    public boolean connect(String portName) throws Exception {
        CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(portName);
        boolean result = false;

        disconnect();
        if (portId.isCurrentlyOwned()) {
            System.out.println("Error. Port is currently in use.");
        } else {
            commPort = portId.open(this.getClass().getName(), 2000);
            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                in = serialPort.getInputStream();
                out = serialPort.getOutputStream();
            } else {
                System.out.println("Error. Only Serial ports are handled by this controller.");
                commPort.close();
            }
        }
        return result;
    }

    public void disconnect() throws Exception {
        if (commPort != null) {
            in.close();
            out.close();
            commPort.close();
        }
    }

    public HashMap searchForPorts() {
        Enumeration ports = CommPortIdentifier.getPortIdentifiers();
        HashMap portMap = new HashMap();
        while (ports.hasMoreElements()) {
            CommPortIdentifier curPort = (CommPortIdentifier) ports.nextElement();
            if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                portMap.put(curPort.getName(), curPort);
            }
        }
        return portMap;
    }

    public Percept JsonDeserialize(String json) {
        if (!"".equals(json)) {
            try {
                gyro = new JSONDeserializer<Percept>().deserialize(json, Percept.class);
            } catch (Exception ex) {
                System.out.println("Error. Deserializing json object." + ex.getMessage());
            }
        }
        return gyro;
    }


    public static SerialCommunicationController getInstace() {
        return scc;
    }

    public InputStream getInputStream() {
        return in;
    }

    public OutputStream getOutputStream() {
        return out;
    }
}
