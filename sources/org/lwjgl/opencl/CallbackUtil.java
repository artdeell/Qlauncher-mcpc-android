package org.lwjgl.opencl;

import java.util.HashMap;
import java.util.Map;

final class CallbackUtil {
    private static final Map<CLContext, Long> contextUserData;

    static {
        HashMap hashMap;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        contextUserData = hashMap2;
    }

    private CallbackUtil() {
    }

    static void checkCallback(int i, long j) {
        long j2 = j;
        if (i != 0 && j2 != 0) {
            deleteGlobalRef(j2);
        }
    }

    static long createGlobalRef(Object obj) {
        Object obj2 = obj;
        if (obj2 == null) {
            return 0;
        }
        return ncreateGlobalRef(obj2);
    }

    static native void deleteGlobalRef(long j);

    static native long getContextCallback();

    static native long getEventCallback();

    static native long getLogMessageToStderrAPPLE();

    static native long getLogMessageToStdoutAPPLE();

    static native long getLogMessageToSystemLogAPPLE();

    static native long getMemObjectDestructorCallback();

    static native long getNativeKernelCallback();

    static native long getPrintfCallback();

    static native long getProgramCallback();

    private static native long ncreateGlobalRef(Object obj);
}
