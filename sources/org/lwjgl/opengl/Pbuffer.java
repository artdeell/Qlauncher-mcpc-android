package org.lwjgl.opengl;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.PointerBuffer;
import org.lwjgl.Sys;

public final class Pbuffer extends DrawableGL {
    public static final int BACK_LEFT_BUFFER = 8325;
    public static final int BACK_RIGHT_BUFFER = 8326;
    public static final int CUBE_MAP_FACE = 8316;
    public static final int DEPTH_BUFFER = 8359;
    public static final int FRONT_LEFT_BUFFER = 8323;
    public static final int FRONT_RIGHT_BUFFER = 8324;
    public static final int MIPMAP_LEVEL = 8315;
    public static final int PBUFFER_SUPPORTED = 1;
    public static final int RENDER_DEPTH_TEXTURE_SUPPORTED = 8;
    public static final int RENDER_TEXTURE_RECTANGLE_SUPPORTED = 4;
    public static final int RENDER_TEXTURE_SUPPORTED = 2;
    public static final int TEXTURE_CUBE_MAP_NEGATIVE_X = 8318;
    public static final int TEXTURE_CUBE_MAP_NEGATIVE_Y = 8320;
    public static final int TEXTURE_CUBE_MAP_NEGATIVE_Z = 8322;
    public static final int TEXTURE_CUBE_MAP_POSITIVE_X = 8317;
    public static final int TEXTURE_CUBE_MAP_POSITIVE_Y = 8319;
    public static final int TEXTURE_CUBE_MAP_POSITIVE_Z = 8321;
    private final int height;
    private final int width;

    static {
        Sys.initialize();
    }

    public Pbuffer(int i, int i2, PixelFormat pixelFormat, Drawable drawable) throws LWJGLException {
        this(i, i2, pixelFormat, null, drawable);
    }

    public Pbuffer(int i, int i2, PixelFormat pixelFormat, RenderTexture renderTexture, Drawable drawable) throws LWJGLException {
        this(i, i2, pixelFormat, renderTexture, drawable, null);
    }

    /* JADX WARNING: type inference failed for: r8v11, types: [org.lwjgl.opengl.Context] */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Pbuffer(int r16, int r17, org.lwjgl.opengl.PixelFormat r18, org.lwjgl.opengl.RenderTexture r19, org.lwjgl.opengl.Drawable r20, org.lwjgl.opengl.ContextAttribs r21) throws org.lwjgl.LWJGLException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r8 = r0
            r8.<init>()
            r8 = r3
            if (r8 != 0) goto L_0x001f
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r14 = r8
            r8 = r14
            r9 = r14
            java.lang.String r10 = "Pixel format must be non-null"
            r9.<init>(r10)
            throw r8
        L_0x001f:
            r8 = r0
            r9 = r1
            r8.width = r9
            r8 = r0
            r9 = r2
            r8.height = r9
            r8 = r0
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r6
            r13 = r4
            org.lwjgl.opengl.PeerInfo r9 = createPbuffer(r9, r10, r11, r12, r13)
            r8.peer_info = r9
            r8 = r5
            if (r8 != 0) goto L_0x003b
            org.lwjgl.opengl.Drawable r8 = org.lwjgl.opengl.Display.getDrawable()
            r5 = r8
        L_0x003b:
            r8 = 0
            r7 = r8
            r8 = r5
            if (r8 == 0) goto L_0x0048
            r8 = r5
            org.lwjgl.opengl.DrawableLWJGL r8 = (org.lwjgl.opengl.DrawableLWJGL) r8
            org.lwjgl.opengl.Context r8 = r8.getContext()
            r7 = r8
        L_0x0048:
            r8 = r0
            org.lwjgl.opengl.ContextGL r9 = new org.lwjgl.opengl.ContextGL
            r14 = r9
            r9 = r14
            r10 = r14
            r11 = r0
            org.lwjgl.opengl.PeerInfo r11 = r11.peer_info
            r12 = r6
            r13 = r7
            org.lwjgl.opengl.ContextGL r13 = (org.lwjgl.opengl.ContextGL) r13
            r10.<init>(r11, r12, r13)
            r8.context = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.Pbuffer.<init>(int, int, org.lwjgl.opengl.PixelFormat, org.lwjgl.opengl.RenderTexture, org.lwjgl.opengl.Drawable, org.lwjgl.opengl.ContextAttribs):void");
    }

    private static PeerInfo createPbuffer(int i, int i2, PixelFormat pixelFormat, ContextAttribs contextAttribs, RenderTexture renderTexture) throws LWJGLException {
        int i3 = i;
        int i4 = i2;
        PixelFormat pixelFormat2 = pixelFormat;
        ContextAttribs contextAttribs2 = contextAttribs;
        RenderTexture renderTexture2 = renderTexture;
        if (renderTexture2 != null) {
            return Display.getImplementation().createPbuffer(i3, i4, pixelFormat2, contextAttribs2, renderTexture2.pixelFormatCaps, renderTexture2.pBufferAttribs);
        }
        return Display.getImplementation().createPbuffer(i3, i4, pixelFormat2, contextAttribs2, null, BufferUtils.createIntBuffer(1));
    }

    public static int getCapabilities() {
        return Display.getImplementation().getPbufferCapabilities();
    }

    public void bindTexImage(int i) {
        int i2 = i;
        synchronized (this) {
            try {
                checkDestroyed();
                Display.getImplementation().bindTexImageToPbuffer(this.peer_info, i2);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public /* bridge */ /* synthetic */ void checkGLError() {
        super.checkGLError();
    }

    public /* bridge */ /* synthetic */ ContextGL createSharedContext() throws LWJGLException {
        return super.createSharedContext();
    }

    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    public /* bridge */ /* synthetic */ ContextGL getContext() {
        return super.getContext();
    }

    public int getHeight() {
        int i;
        synchronized (this) {
            try {
                checkDestroyed();
                th = this.height;
            } finally {
                i = th;
                Throwable th = i;
            }
        }
        return i;
    }

    public /* bridge */ /* synthetic */ PixelFormatLWJGL getPixelFormat() {
        return super.getPixelFormat();
    }

    public int getWidth() {
        int i;
        synchronized (this) {
            try {
                checkDestroyed();
                th = this.width;
            } finally {
                i = th;
                Throwable th = i;
            }
        }
        return i;
    }

    public /* bridge */ /* synthetic */ void initContext(float f, float f2, float f3) {
        super.initContext(f, f2, f3);
    }

    public boolean isBufferLost() {
        boolean z;
        synchronized (this) {
            try {
                checkDestroyed();
                th = Display.getImplementation().isBufferLost(this.peer_info);
            } finally {
                z = th;
                Throwable th = z;
            }
        }
        return z;
    }

    public /* bridge */ /* synthetic */ boolean isCurrent() throws LWJGLException {
        return super.isCurrent();
    }

    public /* bridge */ /* synthetic */ void makeCurrent() throws LWJGLException {
        super.makeCurrent();
    }

    public /* bridge */ /* synthetic */ void releaseContext() throws LWJGLException {
        super.releaseContext();
    }

    public void releaseTexImage(int i) {
        int i2 = i;
        synchronized (this) {
            try {
                checkDestroyed();
                Display.getImplementation().releaseTexImageFromPbuffer(this.peer_info, i2);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void setAttrib(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        synchronized (this) {
            try {
                checkDestroyed();
                Display.getImplementation().setPbufferAttrib(this.peer_info, i3, i4);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public /* bridge */ /* synthetic */ void setCLSharingProperties(PointerBuffer pointerBuffer) throws LWJGLException {
        super.setCLSharingProperties(pointerBuffer);
    }

    public /* bridge */ /* synthetic */ void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL) throws LWJGLException {
        super.setPixelFormat(pixelFormatLWJGL);
    }

    public /* bridge */ /* synthetic */ void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL, ContextAttribs contextAttribs) throws LWJGLException {
        super.setPixelFormat(pixelFormatLWJGL, contextAttribs);
    }

    public /* bridge */ /* synthetic */ void setSwapInterval(int i) {
        super.setSwapInterval(i);
    }

    public /* bridge */ /* synthetic */ void swapBuffers() throws LWJGLException {
        super.swapBuffers();
    }
}
