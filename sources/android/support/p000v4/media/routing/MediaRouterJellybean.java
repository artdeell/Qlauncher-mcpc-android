package android.support.p000v4.media.routing;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaRouter;
import android.media.RemoteControlClient;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.routing.MediaRouterJellybean */
class MediaRouterJellybean {
    public static final int ALL_ROUTE_TYPES = 8388611;
    public static final int ROUTE_TYPE_LIVE_AUDIO = 1;
    public static final int ROUTE_TYPE_LIVE_VIDEO = 2;
    public static final int ROUTE_TYPE_USER = 8388608;
    private static final String TAG = "MediaRouterJellybean";

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$Callback */
    public interface Callback {
        void onRouteAdded(Object obj);

        void onRouteChanged(Object obj);

        void onRouteGrouped(Object obj, Object obj2, int i);

        void onRouteRemoved(Object obj);

        void onRouteSelected(int i, Object obj);

        void onRouteUngrouped(Object obj, Object obj2);

        void onRouteUnselected(int i, Object obj);

        void onRouteVolumeChanged(Object obj);
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$CallbackProxy */
    static class CallbackProxy<T extends Callback> extends android.media.MediaRouter.Callback {
        protected final T mCallback;

        public CallbackProxy(T t) {
            this.mCallback = t;
        }

        public void onRouteAdded(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo) {
            MediaRouter mediaRouter2 = mediaRouter;
            android.media.MediaRouter.RouteInfo routeInfo2 = routeInfo;
            this.mCallback.onRouteAdded(routeInfo2);
        }

        public void onRouteChanged(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo) {
            MediaRouter mediaRouter2 = mediaRouter;
            android.media.MediaRouter.RouteInfo routeInfo2 = routeInfo;
            this.mCallback.onRouteChanged(routeInfo2);
        }

        public void onRouteGrouped(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo, android.media.MediaRouter.RouteGroup routeGroup, int i) {
            MediaRouter mediaRouter2 = mediaRouter;
            android.media.MediaRouter.RouteInfo routeInfo2 = routeInfo;
            android.media.MediaRouter.RouteGroup routeGroup2 = routeGroup;
            int i2 = i;
            this.mCallback.onRouteGrouped(routeInfo2, routeGroup2, i2);
        }

        public void onRouteRemoved(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo) {
            MediaRouter mediaRouter2 = mediaRouter;
            android.media.MediaRouter.RouteInfo routeInfo2 = routeInfo;
            this.mCallback.onRouteRemoved(routeInfo2);
        }

        public void onRouteSelected(MediaRouter mediaRouter, int i, android.media.MediaRouter.RouteInfo routeInfo) {
            MediaRouter mediaRouter2 = mediaRouter;
            int i2 = i;
            android.media.MediaRouter.RouteInfo routeInfo2 = routeInfo;
            this.mCallback.onRouteSelected(i2, routeInfo2);
        }

        public void onRouteUngrouped(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo, android.media.MediaRouter.RouteGroup routeGroup) {
            MediaRouter mediaRouter2 = mediaRouter;
            android.media.MediaRouter.RouteInfo routeInfo2 = routeInfo;
            android.media.MediaRouter.RouteGroup routeGroup2 = routeGroup;
            this.mCallback.onRouteUngrouped(routeInfo2, routeGroup2);
        }

        public void onRouteUnselected(MediaRouter mediaRouter, int i, android.media.MediaRouter.RouteInfo routeInfo) {
            MediaRouter mediaRouter2 = mediaRouter;
            int i2 = i;
            android.media.MediaRouter.RouteInfo routeInfo2 = routeInfo;
            this.mCallback.onRouteUnselected(i2, routeInfo2);
        }

        public void onRouteVolumeChanged(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo) {
            MediaRouter mediaRouter2 = mediaRouter;
            android.media.MediaRouter.RouteInfo routeInfo2 = routeInfo;
            this.mCallback.onRouteVolumeChanged(routeInfo2);
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$GetDefaultRouteWorkaround */
    public static final class GetDefaultRouteWorkaround {
        private Method mGetSystemAudioRouteMethod;

        public GetDefaultRouteWorkaround() {
            UnsupportedOperationException unsupportedOperationException;
            if (VERSION.SDK_INT < 16 || VERSION.SDK_INT > 17) {
                UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
                throw unsupportedOperationException2;
            }
            try {
                this.mGetSystemAudioRouteMethod = MediaRouter.class.getMethod("getSystemAudioRoute", new Class[0]);
            } catch (NoSuchMethodException e) {
                NoSuchMethodException noSuchMethodException = e;
            }
        }

        public Object getDefaultRoute(Object obj) {
            MediaRouter mediaRouter = (MediaRouter) obj;
            if (this.mGetSystemAudioRouteMethod != null) {
                try {
                    return this.mGetSystemAudioRouteMethod.invoke(mediaRouter, new Object[0]);
                } catch (IllegalAccessException e) {
                    IllegalAccessException illegalAccessException = e;
                } catch (InvocationTargetException e2) {
                    InvocationTargetException invocationTargetException = e2;
                }
            }
            return mediaRouter.getRouteAt(0);
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$RouteCategory */
    public static final class RouteCategory {
        public RouteCategory() {
        }

        public static CharSequence getName(Object obj, Context context) {
            return ((android.media.MediaRouter.RouteCategory) obj).getName(context);
        }

        public static List getRoutes(Object obj) {
            ArrayList arrayList;
            Object obj2 = obj;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            List routes = ((android.media.MediaRouter.RouteCategory) obj2).getRoutes(arrayList4);
            return arrayList4;
        }

        public static int getSupportedTypes(Object obj) {
            return ((android.media.MediaRouter.RouteCategory) obj).getSupportedTypes();
        }

        public static boolean isGroupable(Object obj) {
            return ((android.media.MediaRouter.RouteCategory) obj).isGroupable();
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$RouteGroup */
    public static final class RouteGroup {
        public RouteGroup() {
        }

        public static List getGroupedRoutes(Object obj) {
            ArrayList arrayList;
            android.media.MediaRouter.RouteGroup routeGroup = (android.media.MediaRouter.RouteGroup) obj;
            int routeCount = routeGroup.getRouteCount();
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(routeCount);
            ArrayList arrayList4 = arrayList2;
            for (int i = 0; i < routeCount; i++) {
                boolean add = arrayList4.add(routeGroup.getRouteAt(i));
            }
            return arrayList4;
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$RouteInfo */
    public static final class RouteInfo {
        public RouteInfo() {
        }

        public static Object getCategory(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).getCategory();
        }

        public static Object getGroup(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).getGroup();
        }

        public static Drawable getIconDrawable(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).getIconDrawable();
        }

        public static CharSequence getName(Object obj, Context context) {
            return ((android.media.MediaRouter.RouteInfo) obj).getName(context);
        }

        public static int getPlaybackStream(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).getPlaybackStream();
        }

        public static int getPlaybackType(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).getPlaybackType();
        }

        public static CharSequence getStatus(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).getStatus();
        }

        public static int getSupportedTypes(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).getSupportedTypes();
        }

        public static Object getTag(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).getTag();
        }

        public static int getVolume(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).getVolume();
        }

        public static int getVolumeHandling(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).getVolumeHandling();
        }

        public static int getVolumeMax(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).getVolumeMax();
        }

        public static boolean isGroup(Object obj) {
            return obj instanceof android.media.MediaRouter.RouteGroup;
        }

        public static void requestSetVolume(Object obj, int i) {
            ((android.media.MediaRouter.RouteInfo) obj).requestSetVolume(i);
        }

        public static void requestUpdateVolume(Object obj, int i) {
            ((android.media.MediaRouter.RouteInfo) obj).requestUpdateVolume(i);
        }

        public static void setTag(Object obj, Object obj2) {
            ((android.media.MediaRouter.RouteInfo) obj).setTag(obj2);
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$SelectRouteWorkaround */
    public static final class SelectRouteWorkaround {
        private Method mSelectRouteIntMethod;

        public SelectRouteWorkaround() {
            UnsupportedOperationException unsupportedOperationException;
            if (VERSION.SDK_INT < 16 || VERSION.SDK_INT > 17) {
                UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
                throw unsupportedOperationException2;
            }
            try {
                this.mSelectRouteIntMethod = MediaRouter.class.getMethod("selectRouteInt", new Class[]{Integer.TYPE, android.media.MediaRouter.RouteInfo.class});
            } catch (NoSuchMethodException e) {
                NoSuchMethodException noSuchMethodException = e;
            }
        }

        public void selectRoute(Object obj, int i, Object obj2) {
            int i2 = i;
            MediaRouter mediaRouter = (MediaRouter) obj;
            android.media.MediaRouter.RouteInfo routeInfo = (android.media.MediaRouter.RouteInfo) obj2;
            if ((8388608 & routeInfo.getSupportedTypes()) == 0) {
                if (this.mSelectRouteIntMethod != null) {
                    try {
                        Object invoke = this.mSelectRouteIntMethod.invoke(mediaRouter, new Object[]{Integer.valueOf(i2), routeInfo});
                        return;
                    } catch (IllegalAccessException e) {
                        int w = Log.w(MediaRouterJellybean.TAG, "Cannot programmatically select non-user route.  Media routing may not work.", e);
                    } catch (InvocationTargetException e2) {
                        int w2 = Log.w(MediaRouterJellybean.TAG, "Cannot programmatically select non-user route.  Media routing may not work.", e2);
                    }
                } else {
                    int w3 = Log.w(MediaRouterJellybean.TAG, "Cannot programmatically select non-user route because the platform is missing the selectRouteInt() method.  Media routing may not work.");
                }
            }
            mediaRouter.selectRoute(i2, routeInfo);
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$UserRouteInfo */
    public static final class UserRouteInfo {
        public UserRouteInfo() {
        }

        public static void setIconDrawable(Object obj, Drawable drawable) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setIconDrawable(drawable);
        }

        public static void setName(Object obj, CharSequence charSequence) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setName(charSequence);
        }

        public static void setPlaybackStream(Object obj, int i) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setPlaybackStream(i);
        }

        public static void setPlaybackType(Object obj, int i) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setPlaybackType(i);
        }

        public static void setRemoteControlClient(Object obj, Object obj2) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setRemoteControlClient((RemoteControlClient) obj2);
        }

        public static void setStatus(Object obj, CharSequence charSequence) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setStatus(charSequence);
        }

        public static void setVolume(Object obj, int i) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setVolume(i);
        }

        public static void setVolumeCallback(Object obj, Object obj2) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setVolumeCallback((android.media.MediaRouter.VolumeCallback) obj2);
        }

        public static void setVolumeHandling(Object obj, int i) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setVolumeHandling(i);
        }

        public static void setVolumeMax(Object obj, int i) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setVolumeMax(i);
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$VolumeCallback */
    public interface VolumeCallback {
        void onVolumeSetRequest(Object obj, int i);

        void onVolumeUpdateRequest(Object obj, int i);
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$VolumeCallbackProxy */
    static class VolumeCallbackProxy<T extends VolumeCallback> extends android.media.MediaRouter.VolumeCallback {
        protected final T mCallback;

        public VolumeCallbackProxy(T t) {
            this.mCallback = t;
        }

        public void onVolumeSetRequest(android.media.MediaRouter.RouteInfo routeInfo, int i) {
            android.media.MediaRouter.RouteInfo routeInfo2 = routeInfo;
            int i2 = i;
            this.mCallback.onVolumeSetRequest(routeInfo2, i2);
        }

        public void onVolumeUpdateRequest(android.media.MediaRouter.RouteInfo routeInfo, int i) {
            android.media.MediaRouter.RouteInfo routeInfo2 = routeInfo;
            int i2 = i;
            this.mCallback.onVolumeUpdateRequest(routeInfo2, i2);
        }
    }

    MediaRouterJellybean() {
    }

    public static void addCallback(Object obj, int i, Object obj2) {
        ((MediaRouter) obj).addCallback(i, (android.media.MediaRouter.Callback) obj2);
    }

    public static void addUserRoute(Object obj, Object obj2) {
        ((MediaRouter) obj).addUserRoute((android.media.MediaRouter.UserRouteInfo) obj2);
    }

    public static Object createCallback(Callback callback) {
        CallbackProxy callbackProxy;
        CallbackProxy callbackProxy2 = callbackProxy;
        CallbackProxy callbackProxy3 = new CallbackProxy(callback);
        return callbackProxy2;
    }

    public static Object createRouteCategory(Object obj, String str, boolean z) {
        return ((MediaRouter) obj).createRouteCategory(str, z);
    }

    public static Object createUserRoute(Object obj, Object obj2) {
        return ((MediaRouter) obj).createUserRoute((android.media.MediaRouter.RouteCategory) obj2);
    }

    public static Object createVolumeCallback(VolumeCallback volumeCallback) {
        VolumeCallbackProxy volumeCallbackProxy;
        VolumeCallbackProxy volumeCallbackProxy2 = volumeCallbackProxy;
        VolumeCallbackProxy volumeCallbackProxy3 = new VolumeCallbackProxy(volumeCallback);
        return volumeCallbackProxy2;
    }

    public static List getCategories(Object obj) {
        ArrayList arrayList;
        MediaRouter mediaRouter = (MediaRouter) obj;
        int categoryCount = mediaRouter.getCategoryCount();
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(categoryCount);
        ArrayList arrayList4 = arrayList2;
        for (int i = 0; i < categoryCount; i++) {
            boolean add = arrayList4.add(mediaRouter.getCategoryAt(i));
        }
        return arrayList4;
    }

    public static Object getMediaRouter(Context context) {
        return context.getSystemService("media_router");
    }

    public static List getRoutes(Object obj) {
        ArrayList arrayList;
        MediaRouter mediaRouter = (MediaRouter) obj;
        int routeCount = mediaRouter.getRouteCount();
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(routeCount);
        ArrayList arrayList4 = arrayList2;
        for (int i = 0; i < routeCount; i++) {
            boolean add = arrayList4.add(mediaRouter.getRouteAt(i));
        }
        return arrayList4;
    }

    public static Object getSelectedRoute(Object obj, int i) {
        return ((MediaRouter) obj).getSelectedRoute(i);
    }

    public static void removeCallback(Object obj, Object obj2) {
        ((MediaRouter) obj).removeCallback((android.media.MediaRouter.Callback) obj2);
    }

    public static void removeUserRoute(Object obj, Object obj2) {
        ((MediaRouter) obj).removeUserRoute((android.media.MediaRouter.UserRouteInfo) obj2);
    }

    public static void selectRoute(Object obj, int i, Object obj2) {
        ((MediaRouter) obj).selectRoute(i, (android.media.MediaRouter.RouteInfo) obj2);
    }
}
