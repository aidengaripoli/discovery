package me.aidengaripoli.discoveryexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.List;

import me.aidengaripoli.discovery.Device;
import me.aidengaripoli.discovery.Discovery;
import me.aidengaripoli.discovery.callbacks.GetDiscoveredDevicesCallback;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    Discovery discovery;

    private Button buttonDiscoverDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discovery =  new Discovery(this);

        buttonDiscoverDevices = findViewById(R.id.button_discover_devices);
        buttonDiscoverDevices.setOnClickListener(v -> discoverDevices());
    }

    private void discoverDevices() {
        buttonDiscoverDevices.setEnabled(false);
        discovery.discoverDevices(new GetDiscoveredDevicesCallback() {
            @Override
            public void foundDevices(List<Device> devices) {
                Log.d(TAG, "Found " + devices.size() + " device(s):");
                for (Device device : devices) {
                    Log.d(TAG, "\tMAC: " + device.getMacAddress() + ", IP: " + device.getIpAddress());
                }
                runOnUiThread(() -> buttonDiscoverDevices.setEnabled(true));
            }

            @Override
            public void noDevicesFound() {
                Log.d(TAG, "No devices found.");
                runOnUiThread(() -> buttonDiscoverDevices.setEnabled(true));
            }

            @Override
            public void discoveryFailure() {
                Log.d(TAG, "Something went wrong during discovery.");
                runOnUiThread(() -> buttonDiscoverDevices.setEnabled(true));
            }
        });
    }
}
