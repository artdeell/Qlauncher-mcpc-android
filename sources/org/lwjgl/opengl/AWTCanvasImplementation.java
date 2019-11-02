package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import org.lwjgl.LWJGLException;

interface AWTCanvasImplementation {
    PeerInfo createPeerInfo(Canvas canvas, PixelFormat pixelFormat, ContextAttribs contextAttribs) throws LWJGLException;

    GraphicsConfiguration findConfiguration(GraphicsDevice graphicsDevice, PixelFormat pixelFormat) throws LWJGLException;
}
