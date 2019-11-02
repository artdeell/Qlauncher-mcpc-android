package android.support.p000v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.net.ConnectivityManagerCompat */
public class ConnectivityManagerCompat {
    private static final ConnectivityManagerCompatImpl IMPL;

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl */
    static class BaseConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        BaseConnectivityManagerCompatImpl() {
        }

        public boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                switch (activeNetworkInfo.getType()) {
                    case 0:
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

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$ConnectivityManagerCompatImpl */
    interface ConnectivityManagerCompatImpl {
        boolean isActiveNetworkMetered(ConnectivityManager connectivityManager);
    }

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$GingerbreadConnectivityManagerCompatImpl */
    static class GingerbreadConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        GingerbreadConnectivityManagerCompatImpl() {
        }

        public boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
            return ConnectivityManagerCompatGingerbread.isActiveNetworkMetered(connectivityManager);
        }
    }

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$HoneycombMR2ConnectivityManagerCompatImpl */
    static class HoneycombMR2ConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        HoneycombMR2ConnectivityManagerCompatImpl() {
        }

        public boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
            return ConnectivityManagerCompatHoneycombMR2.isActiveNetworkMetered(connectivityManager);
        }
    }

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$JellyBeanConnectivityManagerCompatImpl */
    static class JellyBeanConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        JellyBeanConnectivityManagerCompatImpl() {
        }

        public boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
            return ConnectivityManagerCompatJellyBean.isActiveNetworkMetered(connectivityManager);
        }
    }

    static {
        BaseConnectivityManagerCompatImpl baseConnectivityManagerCompatImpl;
        GingerbreadConnectivityManagerCompatImpl gingerbreadConnectivityManagerCompatImpl;
        HoneycombMR2ConnectivityManagerCompatImpl honeycombMR2ConnectivityManagerCompatImpl;
        JellyBeanConnectivityManagerCompatImpl jellyBeanConnectivityManagerCompatImpl;
        if (VERSION.SDK_INT >= 16) {
            JellyBeanConnectivityManagerCompatImpl jellyBeanConnectivityManagerCompatImpl2 = jellyBeanConnectivityManagerCompatImpl;
            JellyBeanConnectivityManagerCompatImpl jellyBeanConnectivityManagerCompatImpl3 = new JellyBeanConnectivityManagerCompatImpl();
            IMPL = jellyBeanConnectivityManagerCompatImpl2;
        } else if (VERSION.SDK_INT >= 13) {
            HoneycombMR2ConnectivityManagerCompatImpl honeycombMR2ConnectivityManagerCompatImpl2 = honeycombMR2ConnectivityManagerCompatImpl;
            HoneycombMR2ConnectivityManagerCompatImpl honeycombMR2ConnectivityManagerCompatImpl3 = new HoneycombMR2ConnectivityManagerCompatImpl();
            IMPL = honeycombMR2ConnectivityManagerCompatImpl2;
        } else if (VERSION.SDK_INT >= 8) {
            GingerbreadConnectivityManagerCompatImpl gingerbreadConnectivityManagerCompatImpl2 = gingerbreadConnectivityManagerCompatImpl;
            GingerbreadConnectivityManagerCompatImpl gingerbreadConnectivityManagerCompatImpl3 = new GingerbreadConnectivityManagerCompatImpl();
            IMPL = gingerbreadConnectivityManagerCompatImpl2;
        } else {
            BaseConnectivityManagerCompatImpl baseConnectivityManagerCompatImpl2 = baseConnectivityManagerCompatImpl;
            BaseConnectivityManagerCompatImpl baseConnectivityManagerCompatImpl3 = new BaseConnectivityManagerCompatImpl();
            IMPL = baseConnectivityManagerCompatImpl2;
        }
    }

    public ConnectivityManagerCompat() {
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager connectivityManager, Intent intent) {
        ConnectivityManager connectivityManager2 = connectivityManager;
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
            return connectivityManager2.getNetworkInfo(networkInfo.getType());
        }
        return null;
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        return IMPL.isActiveNetworkMetered(connectivityManager);
    }
}
