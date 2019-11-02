package org.lwjgl.test.opengl.pbuffers;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.Pbuffer;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.opengl.RenderTexture;

final class UniqueRendererRTT extends TextureRenderer {
    UniqueRendererRTT(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    /* access modifiers changed from: 0000 */
    public void enable() {
        super.enable();
        this.pbuffer.releaseTexImage(Pbuffer.FRONT_LEFT_BUFFER);
    }

    /* access modifiers changed from: protected */
    public Pbuffer init(int i, int i2, int i3) {
        LWJGLException lWJGLException;
        RenderTexture renderTexture;
        Pbuffer pbuffer;
        PixelFormat pixelFormat;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        Pbuffer pbuffer2 = null;
        try {
            RenderTexture renderTexture2 = renderTexture;
            RenderTexture renderTexture3 = new RenderTexture(true, false, false, false, RenderTexture.RENDER_TEXTURE_2D, 0);
            RenderTexture renderTexture4 = renderTexture2;
            Pbuffer pbuffer3 = pbuffer;
            int i7 = i4;
            int i8 = i5;
            PixelFormat pixelFormat2 = pixelFormat;
            PixelFormat pixelFormat3 = new PixelFormat(16, 0, 0, 0, 0);
            Pbuffer pbuffer4 = new Pbuffer(i7, i8, pixelFormat2, renderTexture4, null);
            Pbuffer pbuffer5 = pbuffer3;
            try {
                pbuffer5.makeCurrent();
                PbufferTest.initGLState(i4, i5, 0.5f);
                GL11.glBindTexture(3553, i6);
                Display.makeCurrent();
                return pbuffer5;
            } catch (LWJGLException e) {
                lWJGLException = e;
                pbuffer2 = pbuffer5;
                lWJGLException.printStackTrace();
                System.exit(-1);
                return pbuffer2;
            }
        } catch (LWJGLException e2) {
            lWJGLException = e2;
            lWJGLException.printStackTrace();
            System.exit(-1);
            return pbuffer2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void updateTexture() {
        this.pbuffer.bindTexImage(Pbuffer.FRONT_LEFT_BUFFER);
    }
}
