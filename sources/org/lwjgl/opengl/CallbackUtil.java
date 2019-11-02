package org.lwjgl.opengl;

import java.util.HashMap;
import java.util.Map;

final class CallbackUtil {
    private static final Map<ContextCapabilities, Long> contextUserParamsAMD;
    private static final Map<ContextCapabilities, Long> contextUserParamsARB;
    private static final Map<ContextCapabilities, Long> contextUserParamsKHR;

    static {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4 = hashMap;
        HashMap hashMap5 = new HashMap();
        contextUserParamsARB = hashMap4;
        HashMap hashMap6 = hashMap2;
        HashMap hashMap7 = new HashMap();
        contextUserParamsAMD = hashMap6;
        HashMap hashMap8 = hashMap3;
        HashMap hashMap9 = new HashMap();
        contextUserParamsKHR = hashMap8;
    }

    private CallbackUtil() {
    }

    static long createGlobalRef(Object obj) {
        Object obj2 = obj;
        if (obj2 == null) {
            return 0;
        }
        return ncreateGlobalRef(obj2);
    }

    private static native void deleteGlobalRef(long j);

    static native long getDebugCallbackKHR();

    static native long getDebugOutputCallbackAMD();

    static native long getDebugOutputCallbackARB();

    private static native long ncreateGlobalRef(Object obj);

    private static void registerContextCallback(long j, Map<ContextCapabilities, Long> map) {
        IllegalStateException illegalStateException;
        long j2 = j;
        Map<ContextCapabilities, Long> map2 = map;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        if (capabilities == null) {
            deleteGlobalRef(j2);
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No context is current.");
            throw illegalStateException2;
        }
        Long l = (Long) map2.remove(capabilities);
        if (l != null) {
            deleteGlobalRef(l.longValue());
        }
        if (j2 != 0) {
            Object put = map2.put(capabilities, Long.valueOf(j2));
        }
    }

    static void registerContextCallbackAMD(long j) {
        registerContextCallback(j, contextUserParamsAMD);
    }

    static void registerContextCallbackARB(long j) {
        registerContextCallback(j, contextUserParamsARB);
    }

    static void registerContextCallbackKHR(long j) {
        registerContextCallback(j, contextUserParamsKHR);
    }

    static void unregisterCallbacks(Object obj) {
        ContextCapabilities capabilities = GLContext.getCapabilities(obj);
        Long l = (Long) contextUserParamsARB.remove(capabilities);
        if (l != null) {
            deleteGlobalRef(l.longValue());
        }
        Long l2 = (Long) contextUserParamsAMD.remove(capabilities);
        if (l2 != null) {
            deleteGlobalRef(l2.longValue());
        }
        Long l3 = (Long) contextUserParamsKHR.remove(capabilities);
        if (l3 != null) {
            deleteGlobalRef(l3.longValue());
        }
    }
}
