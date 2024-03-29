package me.aidengaripoli.discovery;

import android.os.Parcel;
import android.os.Parcelable;

import java.net.InetAddress;

/**
 *
 */
public class Device implements Parcelable {

    public static final Creator<Device> CREATOR = new Creator<Device>() {
        @Override
        public Device createFromParcel(Parcel in) {
            return new Device(in);
        }

        @Override
        public Device[] newArray(int size) {
            return new Device[size];
        }
    };

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

    protected Device(Parcel in) {
        macAddress = in.readString();
        ipAddress = (InetAddress) in.readSerializable();
        status = in.readInt();
        visibility = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(macAddress);
        dest.writeSerializable(ipAddress);
        dest.writeInt(status);
        dest.writeInt(visibility);
    }
}
