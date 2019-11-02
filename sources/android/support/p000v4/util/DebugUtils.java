package android.support.p000v4.util;

/* renamed from: android.support.v4.util.DebugUtils */
public class DebugUtils {
    public DebugUtils() {
    }

    public static void buildShortClassTag(Object obj, StringBuilder sb) {
        Object obj2 = obj;
        StringBuilder sb2 = sb;
        if (obj2 == null) {
            StringBuilder append = sb2.append("null");
            return;
        }
        String simpleName = obj2.getClass().getSimpleName();
        if (simpleName == null || simpleName.length() <= 0) {
            simpleName = obj2.getClass().getName();
            int lastIndexOf = simpleName.lastIndexOf(46);
            if (lastIndexOf > 0) {
                simpleName = simpleName.substring(lastIndexOf + 1);
            }
        }
        StringBuilder append2 = sb2.append(simpleName);
        StringBuilder append3 = sb2.append('{');
        StringBuilder append4 = sb2.append(Integer.toHexString(System.identityHashCode(obj2)));
    }
}
