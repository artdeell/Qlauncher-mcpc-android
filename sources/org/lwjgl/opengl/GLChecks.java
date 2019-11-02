package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLUtil;

class GLChecks {
    private GLChecks() {
    }

    static int calculateBytesPerCharCode(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        switch (i2) {
            case GL11.GL_UNSIGNED_BYTE /*5121*/:
            case NVPathRendering.GL_UTF8_NV /*37018*/:
                return 1;
            case GL11.GL_UNSIGNED_SHORT /*5123*/:
            case GL11.GL_2_BYTES /*5127*/:
            case NVPathRendering.GL_UTF16_NV /*37019*/:
                return 2;
            case GL11.GL_3_BYTES /*5128*/:
                return 3;
            case GL11.GL_4_BYTES /*5129*/:
                return 4;
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unsupported charcode type: ").append(i2).toString());
                throw illegalArgumentException2;
        }
    }

    static int calculateBytesPerPathName(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        switch (i2) {
            case GL11.GL_BYTE /*5120*/:
            case GL11.GL_UNSIGNED_BYTE /*5121*/:
            case NVPathRendering.GL_UTF8_NV /*37018*/:
                return 1;
            case GL11.GL_SHORT /*5122*/:
            case GL11.GL_UNSIGNED_SHORT /*5123*/:
            case GL11.GL_2_BYTES /*5127*/:
            case NVPathRendering.GL_UTF16_NV /*37019*/:
                return 2;
            case GL11.GL_INT /*5124*/:
            case GL11.GL_UNSIGNED_INT /*5125*/:
            case GL11.GL_FLOAT /*5126*/:
            case GL11.GL_4_BYTES /*5129*/:
                return 4;
            case GL11.GL_3_BYTES /*5128*/:
                return 3;
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unsupported path name type: ").append(i2).toString());
                throw illegalArgumentException2;
        }
    }

    private static int calculateBytesPerPixel(int i, int i2) {
        int i3;
        int i4;
        int i5 = i;
        switch (i2) {
            case GL11.GL_BYTE /*5120*/:
            case GL11.GL_UNSIGNED_BYTE /*5121*/:
                i3 = 1;
                break;
            case GL11.GL_SHORT /*5122*/:
            case GL11.GL_UNSIGNED_SHORT /*5123*/:
                i3 = 2;
                break;
            case GL11.GL_INT /*5124*/:
            case GL11.GL_UNSIGNED_INT /*5125*/:
            case GL11.GL_FLOAT /*5126*/:
                i3 = 4;
                break;
            default:
                return 0;
        }
        switch (i5) {
            case GL11.GL_ALPHA /*6406*/:
            case GL11.GL_LUMINANCE /*6409*/:
                i4 = 1;
                break;
            case GL11.GL_RGB /*6407*/:
            case 32992:
                i4 = 3;
                break;
            case GL11.GL_RGBA /*6408*/:
            case 32768:
            case 32993:
                i4 = 4;
                break;
            case GL11.GL_LUMINANCE_ALPHA /*6410*/:
                i4 = 2;
                break;
            default:
                return 0;
        }
        return i3 * i4;
    }

    private static int calculateImageStorage(int i, int i2, int i3, int i4, int i5) {
        return i5 * i4 * i3 * calculateBytesPerPixel(i, i2);
    }

    static int calculateImageStorage(Buffer buffer, int i, int i2, int i3, int i4, int i5) {
        Buffer buffer2 = buffer;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        if (LWJGLUtil.CHECKS) {
            return calculateImageStorage(i6, i7, i8, i9, i10) >> BufferUtils.getElementSizeExponent(buffer2);
        }
        return 0;
    }

    static int calculateMetricsSize(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb2;
        int i3 = i;
        int i4 = i2;
        if (!LWJGLUtil.DEBUG || (i4 >= 0 && i4 % 4 == 0)) {
            int bitCount = Integer.bitCount(i3);
            if (!LWJGLUtil.DEBUG || (i4 >> 2) >= bitCount) {
                return i4 == 0 ? bitCount : i4 >> 2;
            }
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(sb3.append("The queried metrics do not fit in the specified stride: ").append(i4).toString());
            throw illegalArgumentException3;
        }
        IllegalArgumentException illegalArgumentException5 = illegalArgumentException2;
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = new StringBuilder();
        IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb5.append("Invalid stride value: ").append(i4).toString());
        throw illegalArgumentException5;
    }

    static int calculatePathColorGenCoeffsCount(int i, int i2) {
        int i3 = i2;
        int calculatePathGenCoeffsPerComponent = calculatePathGenCoeffsPerComponent(i);
        switch (i3) {
            case GL11.GL_RGB /*6407*/:
                return calculatePathGenCoeffsPerComponent * 3;
            case GL11.GL_RGBA /*6408*/:
                return calculatePathGenCoeffsPerComponent * 4;
            default:
                return calculatePathGenCoeffsPerComponent;
        }
    }

    private static int calculatePathGenCoeffsPerComponent(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        switch (i2) {
            case 0:
                return 0;
            case GL11.GL_EYE_LINEAR /*9216*/:
                return 4;
            case GL11.GL_OBJECT_LINEAR /*9217*/:
            case NVPathRendering.GL_PATH_OBJECT_BOUNDING_BOX_NV /*37002*/:
                return 3;
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unsupported gen mode: ").append(i2).toString());
                throw illegalArgumentException2;
        }
    }

    static int calculatePathTextGenCoeffsPerComponent(FloatBuffer floatBuffer, int i) {
        FloatBuffer floatBuffer2 = floatBuffer;
        int i2 = i;
        if (i2 == 0) {
            return 0;
        }
        return floatBuffer2.remaining() / calculatePathGenCoeffsPerComponent(i2);
    }

    private static int calculateTexImage1DStorage(int i, int i2, int i3) {
        return i3 * calculateBytesPerPixel(i, i2);
    }

    static int calculateTexImage1DStorage(Buffer buffer, int i, int i2, int i3) {
        Buffer buffer2 = buffer;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (LWJGLUtil.CHECKS) {
            return calculateTexImage1DStorage(i4, i5, i6) >> BufferUtils.getElementSizeExponent(buffer2);
        }
        return 0;
    }

    private static int calculateTexImage2DStorage(int i, int i2, int i3, int i4) {
        return i4 * calculateTexImage1DStorage(i, i2, i3);
    }

    static int calculateTexImage2DStorage(Buffer buffer, int i, int i2, int i3, int i4) {
        Buffer buffer2 = buffer;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (LWJGLUtil.CHECKS) {
            return calculateTexImage2DStorage(i5, i6, i7, i8) >> BufferUtils.getElementSizeExponent(buffer2);
        }
        return 0;
    }

    private static int calculateTexImage3DStorage(int i, int i2, int i3, int i4, int i5) {
        return i5 * calculateTexImage2DStorage(i, i2, i3, i4);
    }

    static int calculateTexImage3DStorage(Buffer buffer, int i, int i2, int i3, int i4, int i5) {
        Buffer buffer2 = buffer;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        if (LWJGLUtil.CHECKS) {
            return calculateTexImage3DStorage(i6, i7, i8, i9, i10) >> BufferUtils.getElementSizeExponent(buffer2);
        }
        return 0;
    }

    static int calculateTransformPathValues(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        switch (i2) {
            case 0:
                return 0;
            case NVPathRendering.GL_TRANSLATE_X_NV /*37006*/:
            case NVPathRendering.GL_TRANSLATE_Y_NV /*37007*/:
                return 1;
            case NVPathRendering.GL_TRANSLATE_2D_NV /*37008*/:
                return 2;
            case NVPathRendering.GL_TRANSLATE_3D_NV /*37009*/:
                return 3;
            case NVPathRendering.GL_AFFINE_2D_NV /*37010*/:
            case NVPathRendering.GL_TRANSPOSE_AFFINE_2D_NV /*37014*/:
                return 6;
            case NVPathRendering.GL_AFFINE_3D_NV /*37012*/:
            case NVPathRendering.GL_TRANSPOSE_AFFINE_3D_NV /*37016*/:
                return 12;
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unsupported transform type: ").append(i2).toString());
                throw illegalArgumentException2;
        }
    }

    static void ensureArrayVBOdisabled(ContextCapabilities contextCapabilities) {
        OpenGLException openGLException;
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(contextCapabilities2).arrayBuffer != 0) {
            OpenGLException openGLException2 = openGLException;
            OpenGLException openGLException3 = new OpenGLException("Cannot use Buffers when Array Buffer Object is enabled");
            throw openGLException2;
        }
    }

    static void ensureArrayVBOenabled(ContextCapabilities contextCapabilities) {
        OpenGLException openGLException;
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(contextCapabilities2).arrayBuffer == 0) {
            OpenGLException openGLException2 = openGLException;
            OpenGLException openGLException3 = new OpenGLException("Cannot use offsets when Array Buffer Object is disabled");
            throw openGLException2;
        }
    }

    static void ensureElementVBOdisabled(ContextCapabilities contextCapabilities) {
        OpenGLException openGLException;
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        if (LWJGLUtil.CHECKS && StateTracker.getElementArrayBufferBound(contextCapabilities2) != 0) {
            OpenGLException openGLException2 = openGLException;
            OpenGLException openGLException3 = new OpenGLException("Cannot use Buffers when Element Array Buffer Object is enabled");
            throw openGLException2;
        }
    }

    static void ensureElementVBOenabled(ContextCapabilities contextCapabilities) {
        OpenGLException openGLException;
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        if (LWJGLUtil.CHECKS && StateTracker.getElementArrayBufferBound(contextCapabilities2) == 0) {
            OpenGLException openGLException2 = openGLException;
            OpenGLException openGLException3 = new OpenGLException("Cannot use offsets when Element Array Buffer Object is disabled");
            throw openGLException2;
        }
    }

    static void ensureIndirectBOdisabled(ContextCapabilities contextCapabilities) {
        OpenGLException openGLException;
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(contextCapabilities2).indirectBuffer != 0) {
            OpenGLException openGLException2 = openGLException;
            OpenGLException openGLException3 = new OpenGLException("Cannot use Buffers when Draw Indirect Object is enabled");
            throw openGLException2;
        }
    }

    static void ensureIndirectBOenabled(ContextCapabilities contextCapabilities) {
        OpenGLException openGLException;
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(contextCapabilities2).indirectBuffer == 0) {
            OpenGLException openGLException2 = openGLException;
            OpenGLException openGLException3 = new OpenGLException("Cannot use offsets when Draw Indirect Object is disabled");
            throw openGLException2;
        }
    }

    static void ensurePackPBOdisabled(ContextCapabilities contextCapabilities) {
        OpenGLException openGLException;
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(contextCapabilities2).pixelPackBuffer != 0) {
            OpenGLException openGLException2 = openGLException;
            OpenGLException openGLException3 = new OpenGLException("Cannot use Buffers when Pixel Pack Buffer Object is enabled");
            throw openGLException2;
        }
    }

    static void ensurePackPBOenabled(ContextCapabilities contextCapabilities) {
        OpenGLException openGLException;
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(contextCapabilities2).pixelPackBuffer == 0) {
            OpenGLException openGLException2 = openGLException;
            OpenGLException openGLException3 = new OpenGLException("Cannot use offsets when Pixel Pack Buffer Object is disabled");
            throw openGLException2;
        }
    }

    static void ensureUnpackPBOdisabled(ContextCapabilities contextCapabilities) {
        OpenGLException openGLException;
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(contextCapabilities2).pixelUnpackBuffer != 0) {
            OpenGLException openGLException2 = openGLException;
            OpenGLException openGLException3 = new OpenGLException("Cannot use Buffers when Pixel Unpack Buffer Object is enabled");
            throw openGLException2;
        }
    }

    static void ensureUnpackPBOenabled(ContextCapabilities contextCapabilities) {
        OpenGLException openGLException;
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        if (LWJGLUtil.CHECKS && StateTracker.getReferences(contextCapabilities2).pixelUnpackBuffer == 0) {
            OpenGLException openGLException2 = openGLException;
            OpenGLException openGLException3 = new OpenGLException("Cannot use offsets when Pixel Unpack Buffer Object is disabled");
            throw openGLException2;
        }
    }

    static int getBufferObjectSize(ContextCapabilities contextCapabilities, int i) {
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        return GL15.glGetBufferParameteri(i, 34660);
    }

    static int getBufferObjectSizeARB(ContextCapabilities contextCapabilities, int i) {
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        return ARBBufferObject.glGetBufferParameteriARB(i, 34660);
    }

    static int getBufferObjectSizeATI(ContextCapabilities contextCapabilities, int i) {
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        return ATIVertexArrayObject.glGetObjectBufferiATI(i, 34660);
    }

    static int getNamedBufferObjectSize(ContextCapabilities contextCapabilities, int i) {
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        return EXTDirectStateAccess.glGetNamedBufferParameterEXT(i, 34660);
    }
}
