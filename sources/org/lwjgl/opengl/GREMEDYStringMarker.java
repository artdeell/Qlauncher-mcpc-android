package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class GREMEDYStringMarker {
    private GREMEDYStringMarker() {
    }

    public static void glStringMarkerGREMEDY(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glStringMarkerGREMEDY;
        BufferChecks.checkFunctionAddress(j);
        nglStringMarkerGREMEDY(charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), j);
    }

    public static void glStringMarkerGREMEDY(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glStringMarkerGREMEDY;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglStringMarkerGREMEDY(byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    static native void nglStringMarkerGREMEDY(int i, long j, long j2);
}
