package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

final class APPLEContextLoggingFunctions {
    private APPLEContextLoggingFunctions() {
    }

    static void clLogMessagesToStderrAPPLE(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        ByteBuffer byteBuffer4 = byteBuffer;
        ByteBuffer byteBuffer5 = byteBuffer2;
        ByteBuffer byteBuffer6 = byteBuffer3;
        long j = CLCapabilities.clLogMessagesToStderrAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkDirect(byteBuffer5);
        BufferChecks.checkDirect(byteBuffer6);
        nclLogMessagesToStderrAPPLE(MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddress(byteBuffer5), (long) byteBuffer5.remaining(), MemoryUtil.getAddress(byteBuffer6), j);
    }

    static void clLogMessagesToStdoutAPPLE(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        ByteBuffer byteBuffer4 = byteBuffer;
        ByteBuffer byteBuffer5 = byteBuffer2;
        ByteBuffer byteBuffer6 = byteBuffer3;
        long j = CLCapabilities.clLogMessagesToStdoutAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkDirect(byteBuffer5);
        BufferChecks.checkDirect(byteBuffer6);
        nclLogMessagesToStdoutAPPLE(MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddress(byteBuffer5), (long) byteBuffer5.remaining(), MemoryUtil.getAddress(byteBuffer6), j);
    }

    static void clLogMessagesToSystemLogAPPLE(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        ByteBuffer byteBuffer4 = byteBuffer;
        ByteBuffer byteBuffer5 = byteBuffer2;
        ByteBuffer byteBuffer6 = byteBuffer3;
        long j = CLCapabilities.clLogMessagesToSystemLogAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkDirect(byteBuffer5);
        BufferChecks.checkDirect(byteBuffer6);
        nclLogMessagesToSystemLogAPPLE(MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddress(byteBuffer5), (long) byteBuffer5.remaining(), MemoryUtil.getAddress(byteBuffer6), j);
    }

    static native void nclLogMessagesToStderrAPPLE(long j, long j2, long j3, long j4, long j5);

    static native void nclLogMessagesToStdoutAPPLE(long j, long j2, long j3, long j4, long j5);

    static native void nclLogMessagesToSystemLogAPPLE(long j, long j2, long j3, long j4, long j5);
}
