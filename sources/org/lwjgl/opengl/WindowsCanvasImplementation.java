package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;
import java.security.AccessController;
import java.security.PrivilegedAction;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

final class WindowsCanvasImplementation implements AWTCanvasImplementation {
    static {
        C08071 r2;
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        C08071 r0 = r2;
        C08071 r1 = new PrivilegedAction<Object>() {
            public Object run() {
                StringBuilder sb;
                try {
                    System.loadLibrary("jawt");
                } catch (UnsatisfiedLinkError e) {
                    UnsatisfiedLinkError unsatisfiedLinkError = e;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    LWJGLUtil.log(sb2.append("Failed to load jawt: ").append(unsatisfiedLinkError.getMessage()).toString());
                }
                return null;
            }
        };
        Object doPrivileged = AccessController.doPrivileged(r0);
    }

    WindowsCanvasImplementation() {
    }

    public PeerInfo createPeerInfo(Canvas canvas, PixelFormat pixelFormat, ContextAttribs contextAttribs) throws LWJGLException {
        WindowsAWTGLCanvasPeerInfo windowsAWTGLCanvasPeerInfo;
        ContextAttribs contextAttribs2 = contextAttribs;
        WindowsAWTGLCanvasPeerInfo windowsAWTGLCanvasPeerInfo2 = windowsAWTGLCanvasPeerInfo;
        WindowsAWTGLCanvasPeerInfo windowsAWTGLCanvasPeerInfo3 = new WindowsAWTGLCanvasPeerInfo(canvas, pixelFormat);
        return windowsAWTGLCanvasPeerInfo2;
    }

    public GraphicsConfiguration findConfiguration(GraphicsDevice graphicsDevice, PixelFormat pixelFormat) throws LWJGLException {
        GraphicsDevice graphicsDevice2 = graphicsDevice;
        PixelFormat pixelFormat2 = pixelFormat;
        return null;
    }
}
