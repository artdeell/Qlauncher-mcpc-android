package org.lwjgl.opencl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opencl.api.CLBufferRegion;
import org.lwjgl.opencl.api.CLImageFormat;

public final class CLMem extends CLObjectChild<CLContext> {
    private static final CLMemUtil util = ((CLMemUtil) CLPlatform.getInfoUtilInstance(CLMem.class, "CL_MEM_UTIL"));

    interface CLMemUtil extends InfoUtil<CLMem> {
        CLMem createImage2D(CLContext cLContext, long j, CLImageFormat cLImageFormat, long j2, long j3, long j4, Buffer buffer, IntBuffer intBuffer);

        CLMem createImage3D(CLContext cLContext, long j, CLImageFormat cLImageFormat, long j2, long j3, long j4, long j5, long j6, Buffer buffer, IntBuffer intBuffer);

        CLMem createSubBuffer(CLMem cLMem, long j, int i, CLBufferRegion cLBufferRegion, IntBuffer intBuffer);

        int getGLObjectName(CLMem cLMem);

        int getGLObjectType(CLMem cLMem);

        int getGLTextureInfoInt(CLMem cLMem, int i);

        int getImageInfoFormat(CLMem cLMem, int i);

        CLImageFormat getImageInfoFormat(CLMem cLMem);

        long getImageInfoSize(CLMem cLMem, int i);

        ByteBuffer getInfoHostBuffer(CLMem cLMem);
    }

    CLMem(long j, CLContext cLContext) {
        CLContext cLContext2 = cLContext;
        super(j, cLContext2);
        if (isValid()) {
            cLContext2.getCLMemRegistry().registerObject(this);
        }
    }

    static CLMem create(long j, CLContext cLContext) {
        CLMem cLMem;
        long j2 = j;
        CLContext cLContext2 = cLContext;
        CLMem cLMem2 = (CLMem) cLContext2.getCLMemRegistry().getObject(j2);
        if (cLMem2 == null) {
            CLMem cLMem3 = cLMem;
            CLMem cLMem4 = new CLMem(j2, cLContext2);
            return cLMem3;
        }
        int retain = cLMem2.retain();
        return cLMem2;
    }

    public static CLMem createImage2D(CLContext cLContext, long j, CLImageFormat cLImageFormat, long j2, long j3, long j4, Buffer buffer, IntBuffer intBuffer) {
        return util.createImage2D(cLContext, j, cLImageFormat, j2, j3, j4, buffer, intBuffer);
    }

    public static CLMem createImage3D(CLContext cLContext, long j, CLImageFormat cLImageFormat, long j2, long j3, long j4, long j5, long j6, Buffer buffer, IntBuffer intBuffer) {
        return util.createImage3D(cLContext, j, cLImageFormat, j2, j3, j4, j5, j6, buffer, intBuffer);
    }

    public CLMem createSubBuffer(long j, int i, CLBufferRegion cLBufferRegion, IntBuffer intBuffer) {
        return util.createSubBuffer(this, j, i, cLBufferRegion, intBuffer);
    }

    public int getGLObjectName() {
        return util.getGLObjectName(this);
    }

    public int getGLObjectType() {
        return util.getGLObjectType(this);
    }

    public int getGLTextureInfoInt(int i) {
        return util.getGLTextureInfoInt(this, i);
    }

    public int getImageChannelOrder() {
        return util.getImageInfoFormat(this, 0);
    }

    public int getImageChannelType() {
        return util.getImageInfoFormat(this, 1);
    }

    public CLImageFormat getImageFormat() {
        return util.getImageInfoFormat(this);
    }

    public long getImageInfoSize(int i) {
        return util.getImageInfoSize(this, i);
    }

    public ByteBuffer getInfoHostBuffer() {
        return util.getInfoHostBuffer(this);
    }

    public int getInfoInt(int i) {
        return util.getInfoInt(this, i);
    }

    public long getInfoLong(int i) {
        return util.getInfoLong(this, i);
    }

    public long getInfoSize(int i) {
        return util.getInfoSize(this, i);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    public int release() {
        try {
            int release = super.release();
            if (!isValid()) {
                ((CLContext) getParent()).getCLMemRegistry().unregisterObject(this);
            }
            return release;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (!isValid()) {
                ((CLContext) getParent()).getCLMemRegistry().unregisterObject(this);
            }
            throw th2;
        }
    }
}
