package me.aidengaripoli.discovery.callbacks;

import java.util.List;

import me.aidengaripoli.discovery.Device;

/**
 *
 */
public interface GetDiscoveredDevicesCallback extends BaseCallback {

    /**
     *
     * @param devices
     */
    void foundDevices(List<Device> devices);

    /**
     *
     */
    void noDevicesFound();

}
