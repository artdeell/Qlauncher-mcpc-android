package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.PointerBuffer;

public interface Drawable {
    void destroy();

    boolean isCurrent() throws LWJGLException;

    void makeCurrent() throws LWJGLException;

    void releaseContext() throws LWJGLException;

    void setCLSharingProperties(PointerBuffer pointerBuffer) throws LWJGLException;
}
