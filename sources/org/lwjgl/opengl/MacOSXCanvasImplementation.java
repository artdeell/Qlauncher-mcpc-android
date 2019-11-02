package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import org.lwjgl.LWJGLException;

final class MacOSXCanvasImplementation implements AWTCanvasImplementation {
    MacOSXCanvasImplementation() {
    }

    public PeerInfo createPeerInfo(Canvas canvas, PixelFormat pixelFormat, ContextAttribs contextAttribs) throws LWJGLException {
        MacOSXAWTGLCanvasPeerInfo macOSXAWTGLCanvasPeerInfo;
        MacOSXAWTGLCanvasPeerInfo macOSXAWTGLCanvasPeerInfo2;
        Canvas canvas2 = canvas;
        PixelFormat pixelFormat2 = pixelFormat;
        ContextAttribs contextAttribs2 = contextAttribs;
        try {
            MacOSXAWTGLCanvasPeerInfo macOSXAWTGLCanvasPeerInfo3 = macOSXAWTGLCanvasPeerInfo2;
            MacOSXAWTGLCanvasPeerInfo macOSXAWTGLCanvasPeerInfo4 = new MacOSXAWTGLCanvasPeerInfo(canvas2, pixelFormat2, contextAttribs2, true);
            return macOSXAWTGLCanvasPeerInfo3;
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            MacOSXAWTGLCanvasPeerInfo macOSXAWTGLCanvasPeerInfo5 = macOSXAWTGLCanvasPeerInfo;
            MacOSXAWTGLCanvasPeerInfo macOSXAWTGLCanvasPeerInfo6 = new MacOSXAWTGLCanvasPeerInfo(canvas2, pixelFormat2, contextAttribs2, false);
            return macOSXAWTGLCanvasPeerInfo5;
        }
    }

    public GraphicsConfiguration findConfiguration(GraphicsDevice graphicsDevice, PixelFormat pixelFormat) throws LWJGLException {
        GraphicsDevice graphicsDevice2 = graphicsDevice;
        PixelFormat pixelFormat2 = pixelFormat;
        return null;
    }
}
