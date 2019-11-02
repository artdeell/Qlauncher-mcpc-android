package android.support.p000v4.media.routing;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.MediaRouter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1 */
class MediaRouterJellybeanMr1 extends MediaRouterJellybean {
    private static final String TAG = "MediaRouterJellybeanMr1";

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$ActiveScanWorkaround */
    public static final class ActiveScanWorkaround implements Runnable {
        private static final int WIFI_DISPLAY_SCAN_INTERVAL = 15000;
        private boolean mActivelyScanningWifiDisplays;
        private final DisplayManager mDisplayManager;
        private final Handler mHandler;
        private Method mScanWifiDisplaysMethod;

        public ActiveScanWorkaround(Context context, Handler handler) {
            UnsupportedOperationException unsupportedOperationException;
            Context context2 = context;
            Handler handler2 = handler;
            if (VERSION.SDK_INT != 17) {
                UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
                throw unsupportedOperationException2;
            }
            this.mDisplayManager = (DisplayManager) context2.getSystemService("display");
            this.mHandler = handler2;
            try {
                this.mScanWifiDisplaysMethod = DisplayManager.class.getMethod("scanWifiDisplays", new Class[0]);
            } catch (NoSuchMethodException e) {
                NoSuchMethodException noSuchMethodException = e;
            }
        }

        public void run() {
            if (this.mActivelyScanningWifiDisplays) {
                try {
                    Object invoke = this.mScanWifiDisplaysMethod.invoke(this.mDisplayManager, new Object[0]);
                } catch (IllegalAccessException e) {
                    int w = Log.w(MediaRouterJellybeanMr1.TAG, "Cannot scan for wifi displays.", e);
                } catch (InvocationTargetException e2) {
                    int w2 = Log.w(MediaRouterJellybeanMr1.TAG, "Cannot scan for wifi displays.", e2);
                }
                boolean postDelayed = this.mHandler.postDelayed(this, 15000);
            }
        }

        public void setActiveScanRouteTypes(int i) {
            if ((i & 2) != 0) {
                if (this.mActivelyScanningWifiDisplays) {
                    return;
                }
                if (this.mScanWifiDisplaysMethod != null) {
                    this.mActivelyScanningWifiDisplays = true;
                    boolean post = this.mHandler.post(this);
                    return;
                }
                int w = Log.w(MediaRouterJellybeanMr1.TAG, "Cannot scan for wifi displays because the DisplayManager.scanWifiDisplays() method is not available on this device.");
            } else if (this.mActivelyScanningWifiDisplays) {
                this.mActivelyScanningWifiDisplays = false;
                this.mHandler.removeCallbacks(this);
            }
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$Callback */
    public interface Callback extends android.support.p000v4.media.routing.MediaRouterJellybean.Callback {
        void onRoutePresentationDisplayChanged(Object obj);
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$CallbackProxy */
    static class CallbackProxy<T extends Callback> extends CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        public void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo) {
            MediaRouter mediaRouter2 = mediaRouter;
            android.media.MediaRouter.RouteInfo routeInfo2 = routeInfo;
            ((Callback) this.mCallback).onRoutePresentationDisplayChanged(routeInfo2);
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$IsConnectingWorkaround */
    public static final class IsConnectingWorkaround {
        private Method mGetStatusCodeMethod;
        private int mStatusConnecting;

        public IsConnectingWorkaround() {
            UnsupportedOperationException unsupportedOperationException;
            if (VERSION.SDK_INT != 17) {
                UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
                throw unsupportedOperationException2;
            }
            try {
                this.mStatusConnecting = android.media.MediaRouter.RouteInfo.class.getField("STATUS_CONNECTING").getInt(null);
                this.mGetStatusCodeMethod = android.media.MediaRouter.RouteInfo.class.getMethod("getStatusCode", new Class[0]);
            } catch (NoSuchFieldException e) {
                NoSuchFieldException noSuchFieldException = e;
            } catch (NoSuchMethodException e2) {
                NoSuchMethodException noSuchMethodException = e2;
            } catch (IllegalAccessException e3) {
                IllegalAccessException illegalAccessException = e3;
            }
        }

        public boolean isConnecting(Object obj) {
            android.media.MediaRouter.RouteInfo routeInfo = (android.media.MediaRouter.RouteInfo) obj;
            if (this.mGetStatusCodeMethod != null) {
                try {
                    return ((Integer) this.mGetStatusCodeMethod.invoke(routeInfo, new Object[0])).intValue() == this.mStatusConnecting;
                } catch (IllegalAccessException e) {
                    IllegalAccessException illegalAccessException = e;
                } catch (InvocationTargetException e2) {
                    InvocationTargetException invocationTargetException = e2;
                }
            }
            return false;
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$RouteInfo */
    public static final class RouteInfo {
        public RouteInfo() {
        }

        public static Display getPresentationDisplay(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).getPresentationDisplay();
        }

        public static boolean isEnabled(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).isEnabled();
        }
    }

    MediaRouterJellybeanMr1() {
    }

    public static Object createCallback(Callback callback) {
        CallbackProxy callbackProxy;
        CallbackProxy callbackProxy2 = callbackProxy;
        CallbackProxy callbackProxy3 = new CallbackProxy(callback);
        return callbackProxy2;
    }
}
