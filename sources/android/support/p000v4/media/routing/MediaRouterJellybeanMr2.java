package android.support.p000v4.media.routing;

import android.media.MediaRouter;
import android.media.MediaRouter.Callback;

/* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr2 */
class MediaRouterJellybeanMr2 extends MediaRouterJellybeanMr1 {

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr2$RouteInfo */
    public static final class RouteInfo {
        public RouteInfo() {
        }

        public static CharSequence getDescription(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).getDescription();
        }

        public static boolean isConnecting(Object obj) {
            return ((android.media.MediaRouter.RouteInfo) obj).isConnecting();
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr2$UserRouteInfo */
    public static final class UserRouteInfo {
        public UserRouteInfo() {
        }

        public static void setDescription(Object obj, CharSequence charSequence) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setDescription(charSequence);
        }
    }

    MediaRouterJellybeanMr2() {
    }

    public static void addCallback(Object obj, int i, Object obj2, int i2) {
        ((MediaRouter) obj).addCallback(i, (Callback) obj2, i2);
    }

    public static Object getDefaultRoute(Object obj) {
        return ((MediaRouter) obj).getDefaultRoute();
    }
}
