package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;

final class CLChecks {
    private CLChecks() {
    }

    static int calculateBufferRectSize(PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, long j, long j2) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb2;
        IllegalArgumentException illegalArgumentException3;
        StringBuilder sb3;
        IllegalArgumentException illegalArgumentException4;
        StringBuilder sb4;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = j;
        long j4 = j2;
        if (!LWJGLUtil.CHECKS) {
            return 0;
        }
        long j5 = pointerBuffer3.get(0);
        long j6 = pointerBuffer3.get(1);
        long j7 = pointerBuffer3.get(2);
        if (!LWJGLUtil.DEBUG || (j5 >= 0 && j6 >= 0 && j7 >= 0)) {
            long j8 = pointerBuffer4.get(0);
            long j9 = pointerBuffer4.get(1);
            long j10 = pointerBuffer4.get(2);
            if (!LWJGLUtil.DEBUG || (j8 >= 1 && j9 >= 1 && j10 >= 1)) {
                if (j3 == 0) {
                    j3 = j8;
                } else if (LWJGLUtil.DEBUG && j3 < j8) {
                    IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb5.append("Invalid host row pitch specified: ").append(j3).toString());
                    throw illegalArgumentException5;
                }
                if (j4 == 0) {
                    j4 = j3 * j9;
                } else if (LWJGLUtil.DEBUG && j4 < j3 * j9) {
                    IllegalArgumentException illegalArgumentException7 = illegalArgumentException2;
                    StringBuilder sb7 = sb2;
                    StringBuilder sb8 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException(sb7.append("Invalid host slice pitch specified: ").append(j4).toString());
                    throw illegalArgumentException7;
                }
                return (int) (j5 + (j7 * j4) + (j6 * j3) + (j10 * j8 * j9));
            }
            IllegalArgumentException illegalArgumentException9 = illegalArgumentException3;
            StringBuilder sb9 = sb3;
            StringBuilder sb10 = new StringBuilder();
            IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException(sb9.append("Invalid cl_mem rectangle region dimensions: ").append(j8).append(" x ").append(j9).append(" x ").append(j10).toString());
            throw illegalArgumentException9;
        }
        IllegalArgumentException illegalArgumentException11 = illegalArgumentException4;
        StringBuilder sb11 = sb4;
        StringBuilder sb12 = new StringBuilder();
        IllegalArgumentException illegalArgumentException12 = new IllegalArgumentException(sb11.append("Invalid cl_mem host offset: ").append(j5).append(", ").append(j6).append(", ").append(j7).toString());
        throw illegalArgumentException11;
    }

    static int calculateImage2DSize(ByteBuffer byteBuffer, long j, long j2, long j3) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        if (!LWJGLUtil.CHECKS) {
            return 0;
        }
        if (!LWJGLUtil.DEBUG || (j4 >= 1 && j5 >= 1)) {
            int elementSize = getElementSize(byteBuffer2);
            if (j6 == 0) {
                j6 = j4 * ((long) elementSize);
            } else if (LWJGLUtil.DEBUG && (j6 < j4 * ((long) elementSize) || j6 % ((long) elementSize) != 0)) {
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException;
                StringBuilder sb3 = sb;
                StringBuilder sb4 = new StringBuilder();
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(sb3.append("Invalid image_row_pitch specified: ").append(j6).toString());
                throw illegalArgumentException3;
            }
            return (int) (j6 * j5);
        }
        IllegalArgumentException illegalArgumentException5 = illegalArgumentException2;
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = new StringBuilder();
        IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb5.append("Invalid 2D image dimensions: ").append(j4).append(" x ").append(j5).toString());
        throw illegalArgumentException5;
    }

    static int calculateImage3DSize(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, long j5) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb2;
        IllegalArgumentException illegalArgumentException3;
        StringBuilder sb3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j6 = j;
        long j7 = j2;
        long j8 = j3;
        long j9 = j4;
        long j10 = j5;
        if (!LWJGLUtil.CHECKS) {
            return 0;
        }
        if (!LWJGLUtil.DEBUG || (j6 >= 1 && j7 >= 1 && j8 >= 2)) {
            int elementSize = getElementSize(byteBuffer2);
            if (j9 == 0) {
                j9 = j6 * ((long) elementSize);
            } else if (LWJGLUtil.DEBUG && (j9 < j6 * ((long) elementSize) || j9 % ((long) elementSize) != 0)) {
                IllegalArgumentException illegalArgumentException4 = illegalArgumentException;
                StringBuilder sb4 = sb;
                StringBuilder sb5 = new StringBuilder();
                IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException(sb4.append("Invalid image_row_pitch specified: ").append(j9).toString());
                throw illegalArgumentException4;
            }
            if (j10 == 0) {
                j10 = j9 * j7;
            } else if (LWJGLUtil.DEBUG && (j9 < j9 * j7 || j10 % j9 != 0)) {
                IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
                StringBuilder sb6 = sb2;
                StringBuilder sb7 = new StringBuilder();
                IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException(sb6.append("Invalid image_slice_pitch specified: ").append(j9).toString());
                throw illegalArgumentException6;
            }
            return (int) (j10 * j8);
        }
        IllegalArgumentException illegalArgumentException8 = illegalArgumentException3;
        StringBuilder sb8 = sb3;
        StringBuilder sb9 = new StringBuilder();
        IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException(sb8.append("Invalid 3D image dimensions: ").append(j6).append(" x ").append(j7).append(" x ").append(j8).toString());
        throw illegalArgumentException8;
    }

    static int calculateImageSize(PointerBuffer pointerBuffer, long j, long j2) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb2;
        IllegalArgumentException illegalArgumentException3;
        StringBuilder sb3;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j3 = j;
        long j4 = j2;
        if (!LWJGLUtil.CHECKS) {
            return 0;
        }
        long j5 = pointerBuffer2.get(0);
        long j6 = pointerBuffer2.get(1);
        long j7 = pointerBuffer2.get(2);
        if (!LWJGLUtil.DEBUG || (j5 >= 1 && j6 >= 1 && j7 >= 1)) {
            if (j3 == 0) {
                j3 = j5;
            } else if (LWJGLUtil.DEBUG && j3 < j5) {
                IllegalArgumentException illegalArgumentException4 = illegalArgumentException;
                StringBuilder sb4 = sb;
                StringBuilder sb5 = new StringBuilder();
                IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException(sb4.append("Invalid row pitch specified: ").append(j3).toString());
                throw illegalArgumentException4;
            }
            if (j4 == 0) {
                j4 = j3 * j6;
            } else if (LWJGLUtil.DEBUG && j4 < j3 * j6) {
                IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
                StringBuilder sb6 = sb2;
                StringBuilder sb7 = new StringBuilder();
                IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException(sb6.append("Invalid slice pitch specified: ").append(j4).toString());
                throw illegalArgumentException6;
            }
            return (int) (j4 * j7);
        }
        IllegalArgumentException illegalArgumentException8 = illegalArgumentException3;
        StringBuilder sb8 = sb3;
        StringBuilder sb9 = new StringBuilder();
        IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException(sb8.append("Invalid cl_mem image region dimensions: ").append(j5).append(" x ").append(j6).append(" x ").append(j7).toString());
        throw illegalArgumentException8;
    }

    private static int getChannelCount(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        switch (i2) {
            case CL10.CL_R /*4272*/:
            case CL10.CL_A /*4273*/:
            case CL10.CL_INTENSITY /*4280*/:
            case CL10.CL_LUMINANCE /*4281*/:
            case CL11.CL_Rx /*4282*/:
                return 1;
            case CL10.CL_RG /*4274*/:
            case CL10.CL_RA /*4275*/:
            case CL11.CL_RGx /*4283*/:
                return 2;
            case CL10.CL_RGB /*4276*/:
            case CL11.CL_RGBx /*4284*/:
                return 3;
            case CL10.CL_RGBA /*4277*/:
            case CL10.CL_BGRA /*4278*/:
            case CL10.CL_ARGB /*4279*/:
                return 4;
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid cl_channel_order specified: ").append(LWJGLUtil.toHexString(i2)).toString());
                throw illegalArgumentException2;
        }
    }

    private static int getChannelSize(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        switch (i2) {
            case CL10.CL_SNORM_INT8 /*4304*/:
            case CL10.CL_UNORM_INT8 /*4306*/:
            case CL10.CL_SIGNED_INT8 /*4311*/:
            case CL10.CL_UNSIGNED_INT8 /*4314*/:
                return 1;
            case CL10.CL_SNORM_INT16 /*4305*/:
            case CL10.CL_UNORM_INT16 /*4307*/:
            case CL10.CL_UNORM_SHORT_565 /*4308*/:
            case CL10.CL_UNORM_SHORT_555 /*4309*/:
            case CL10.CL_SIGNED_INT16 /*4312*/:
            case CL10.CL_UNSIGNED_INT16 /*4315*/:
            case CL10.CL_HALF_FLOAT /*4317*/:
                return 2;
            case CL10.CL_UNORM_INT_101010 /*4310*/:
            case CL10.CL_SIGNED_INT32 /*4313*/:
            case CL10.CL_UNSIGNED_INT32 /*4316*/:
            case CL10.CL_FLOAT /*4318*/:
                return 4;
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid cl_channel_type specified: ").append(LWJGLUtil.toHexString(i2)).toString());
                throw illegalArgumentException2;
        }
    }

    private static int getElementSize(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        return getChannelCount(byteBuffer2.getInt(0 + byteBuffer2.position())) * getChannelSize(byteBuffer2.getInt(4 + byteBuffer2.position()));
    }
}
