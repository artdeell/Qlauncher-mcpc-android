package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;

public final class ATIMapObjectBuffer {
    private ATIMapObjectBuffer() {
    }

    public static ByteBuffer glMapObjectBufferATI(int i, long j, ByteBuffer byteBuffer) {
        int i2 = i;
        long j2 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = GLContext.getCapabilities().glMapObjectBufferATI;
        BufferChecks.checkFunctionAddress(j3);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        ByteBuffer nglMapObjectBufferATI = nglMapObjectBufferATI(i2, j2, byteBuffer2, j3);
        if (!LWJGLUtil.CHECKS || nglMapObjectBufferATI != null) {
            return nglMapObjectBufferATI.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static ByteBuffer glMapObjectBufferATI(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMapObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        ByteBuffer nglMapObjectBufferATI = nglMapObjectBufferATI(i2, (long) GLChecks.getBufferObjectSizeATI(capabilities, i2), byteBuffer2, j);
        if (!LWJGLUtil.CHECKS || nglMapObjectBufferATI != null) {
            return nglMapObjectBufferATI.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glUnmapObjectBufferATI(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glUnmapObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        nglUnmapObjectBufferATI(i2, j);
    }

    static native ByteBuffer nglMapObjectBufferATI(int i, long j, ByteBuffer byteBuffer, long j2);

    static native void nglUnmapObjectBufferATI(int i, long j);
}
