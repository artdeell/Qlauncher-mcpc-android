package android.support.p000v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: android.support.v4.net.ConnectivityManagerCompatGingerbread */
class ConnectivityManagerCompatGingerbread {
    ConnectivityManagerCompatGingerbread() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            switch (activeNetworkInfo.getType()) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                case 1:
                    return false;
                default:
                    return true;
            }
        }
        return true;
    }
}
