package com.futing.ftstudy.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
 
public class NetworkUtils {
 
    public static String getIPAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager != null && wifiManager.getConnectionInfo() != null) {
            int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
            return Formatter.formatIpAddress(ipAddress);
        }
        return "Unavailable";
    }
}