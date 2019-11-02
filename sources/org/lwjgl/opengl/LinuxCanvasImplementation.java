package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

final class LinuxCanvasImplementation implements AWTCanvasImplementation {
    LinuxCanvasImplementation() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        org.lwjgl.opengl.LinuxDisplay.decDisplay();
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int findVisualIDFromFormat(int r10, org.lwjgl.opengl.PixelFormat r11) throws org.lwjgl.LWJGLException {
        /*
            r0 = r10
            r1 = r11
            org.lwjgl.opengl.LinuxDisplay.lockAWT()     // Catch:{ all -> 0x0030 }
            org.lwjgl.opengl.GLContext.loadOpenGLLibrary()     // Catch:{ all -> 0x0029 }
            org.lwjgl.opengl.LinuxDisplay.incDisplay()     // Catch:{ all -> 0x0022 }
            long r6 = org.lwjgl.opengl.LinuxDisplay.getDisplay()     // Catch:{ all -> 0x0022 }
            r8 = r0
            r9 = r1
            int r6 = nFindVisualIDFromFormat(r6, r8, r9)     // Catch:{ all -> 0x0022 }
            r5 = r6
            org.lwjgl.opengl.LinuxDisplay.decDisplay()     // Catch:{ all -> 0x0029 }
            org.lwjgl.opengl.GLContext.unloadOpenGLLibrary()     // Catch:{ all -> 0x0030 }
            org.lwjgl.opengl.LinuxDisplay.unlockAWT()
            r6 = r5
            r0 = r6
            return r0
        L_0x0022:
            r6 = move-exception
            r4 = r6
            org.lwjgl.opengl.LinuxDisplay.decDisplay()     // Catch:{ all -> 0x0029 }
            r6 = r4
            throw r6     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r6 = move-exception
            r3 = r6
            org.lwjgl.opengl.GLContext.unloadOpenGLLibrary()     // Catch:{ all -> 0x0030 }
            r6 = r3
            throw r6     // Catch:{ all -> 0x0030 }
        L_0x0030:
            r6 = move-exception
            r2 = r6
            org.lwjgl.opengl.LinuxDisplay.unlockAWT()
            r6 = r2
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.LinuxCanvasImplementation.findVisualIDFromFormat(int, org.lwjgl.opengl.PixelFormat):int");
    }

    static int getScreenFromDevice(GraphicsDevice graphicsDevice) throws LWJGLException {
        LWJGLException lWJGLException;
        C07931 r6;
        GraphicsDevice graphicsDevice2 = graphicsDevice;
        try {
            C07931 r3 = r6;
            final GraphicsDevice graphicsDevice3 = graphicsDevice2;
            C07931 r4 = new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return graphicsDevice3.getClass().getMethod("getScreen", new Class[0]);
                }
            };
            return ((Integer) ((Method) AccessController.doPrivileged(r3)).invoke(graphicsDevice2, new Object[0])).intValue();
        } catch (Exception e) {
            Exception exc = e;
            LWJGLException lWJGLException2 = lWJGLException;
            LWJGLException lWJGLException3 = new LWJGLException((Throwable) exc);
            throw lWJGLException2;
        }
    }

    private static int getVisualIDFromConfiguration(GraphicsConfiguration graphicsConfiguration) throws LWJGLException {
        LWJGLException lWJGLException;
        C07942 r6;
        GraphicsConfiguration graphicsConfiguration2 = graphicsConfiguration;
        try {
            C07942 r3 = r6;
            final GraphicsConfiguration graphicsConfiguration3 = graphicsConfiguration2;
            C07942 r4 = new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return graphicsConfiguration3.getClass().getMethod("getVisual", new Class[0]);
                }
            };
            return ((Integer) ((Method) AccessController.doPrivileged(r3)).invoke(graphicsConfiguration2, new Object[0])).intValue();
        } catch (Exception e) {
            Exception exc = e;
            LWJGLException lWJGLException2 = lWJGLException;
            LWJGLException lWJGLException3 = new LWJGLException((Throwable) exc);
            throw lWJGLException2;
        }
    }

    private static native int nFindVisualIDFromFormat(long j, int i, PixelFormat pixelFormat) throws LWJGLException;

    public PeerInfo createPeerInfo(Canvas canvas, PixelFormat pixelFormat, ContextAttribs contextAttribs) throws LWJGLException {
        LinuxAWTGLCanvasPeerInfo linuxAWTGLCanvasPeerInfo;
        PixelFormat pixelFormat2 = pixelFormat;
        ContextAttribs contextAttribs2 = contextAttribs;
        LinuxAWTGLCanvasPeerInfo linuxAWTGLCanvasPeerInfo2 = linuxAWTGLCanvasPeerInfo;
        LinuxAWTGLCanvasPeerInfo linuxAWTGLCanvasPeerInfo3 = new LinuxAWTGLCanvasPeerInfo(canvas);
        return linuxAWTGLCanvasPeerInfo2;
    }

    public GraphicsConfiguration findConfiguration(GraphicsDevice graphicsDevice, PixelFormat pixelFormat) throws LWJGLException {
        StringBuilder sb;
        GraphicsDevice graphicsDevice2 = graphicsDevice;
        try {
            int findVisualIDFromFormat = findVisualIDFromFormat(getScreenFromDevice(graphicsDevice2), pixelFormat);
            GraphicsConfiguration[] configurations = graphicsDevice2.getConfigurations();
            int length = configurations.length;
            for (int i = 0; i < length; i++) {
                GraphicsConfiguration graphicsConfiguration = configurations[i];
                if (getVisualIDFromConfiguration(graphicsConfiguration) == findVisualIDFromFormat) {
                    return graphicsConfiguration;
                }
            }
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Got exception while trying to determine configuration: ").append(lWJGLException).toString());
        }
        return null;
    }
}
