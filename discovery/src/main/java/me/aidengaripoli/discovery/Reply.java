package me.aidengaripoli.discovery;

public class Reply {

    private String macAddress;

    private int status;

    private int visibility;

    Reply(String macAddress, int status, int visibility) {
        this.macAddress = macAddress;
        this.status = status;
        this.visibility = visibility;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public int getStatus() {
        return status;
    }

    public int getVisibility() {
        return visibility;
    }
}
