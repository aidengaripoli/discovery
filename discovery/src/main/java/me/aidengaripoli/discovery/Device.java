package me.aidengaripoli.discovery;

import java.net.InetAddress;

/**
 *
 */
public class Device {

    private String macAddress;

    private InetAddress ipAddress;

    private int status;

    private int visibility;

    Device(String macAddress, InetAddress ipAddress, int status, int visibility) {
        this.macAddress = macAddress;
        this.ipAddress = ipAddress;
        this.status = status;
        this.visibility = visibility;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public int getStatus() {
        return status;
    }

    public int getVisibility() {
        return visibility;
    }

    @Override
    public String toString() {
        return macAddress + "," + ipAddress + "," + status + "," + visibility;
    }
}
