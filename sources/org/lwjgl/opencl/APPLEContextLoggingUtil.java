package org.lwjgl.opencl;

import java.nio.ByteBuffer;

public final class APPLEContextLoggingUtil {
    public static final CLContextCallback STD_ERR_CALLBACK;
    public static final CLContextCallback STD_OUT_CALLBACK;
    public static final CLContextCallback SYSTEM_LOG_CALLBACK;

    static {
        C07711 r4;
        C07722 r42;
        C07733 r43;
        if (CLCapabilities.CL_APPLE_ContextLoggingFunctions) {
            C07711 r0 = r4;
            C07711 r1 = new CLContextCallback(CallbackUtil.getLogMessageToSystemLogAPPLE()) {
                /* access modifiers changed from: protected */
                public void handleMessage(String str, ByteBuffer byteBuffer) {
                    UnsupportedOperationException unsupportedOperationException;
                    String str2 = str;
                    ByteBuffer byteBuffer2 = byteBuffer;
                    UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                    UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
                    throw unsupportedOperationException2;
                }
            };
            SYSTEM_LOG_CALLBACK = r0;
            C07722 r02 = r42;
            C07722 r12 = new CLContextCallback(CallbackUtil.getLogMessageToStdoutAPPLE()) {
                /* access modifiers changed from: protected */
                public void handleMessage(String str, ByteBuffer byteBuffer) {
                    UnsupportedOperationException unsupportedOperationException;
                    String str2 = str;
                    ByteBuffer byteBuffer2 = byteBuffer;
                    UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                    UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
                    throw unsupportedOperationException2;
                }
            };
            STD_OUT_CALLBACK = r02;
            C07733 r03 = r43;
            C07733 r13 = new CLContextCallback(CallbackUtil.getLogMessageToStderrAPPLE()) {
                /* access modifiers changed from: protected */
                public void handleMessage(String str, ByteBuffer byteBuffer) {
                    UnsupportedOperationException unsupportedOperationException;
                    String str2 = str;
                    ByteBuffer byteBuffer2 = byteBuffer;
                    UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                    UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
                    throw unsupportedOperationException2;
                }
            };
            STD_ERR_CALLBACK = r03;
            return;
        }
        SYSTEM_LOG_CALLBACK = null;
        STD_OUT_CALLBACK = null;
        STD_ERR_CALLBACK = null;
    }

    private APPLEContextLoggingUtil() {
    }
}
