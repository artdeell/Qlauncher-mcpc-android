package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

public interface InputImplementation {
    Object createCursor(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException;

    void createKeyboard() throws LWJGLException;

    void createMouse() throws LWJGLException;

    void destroyCursor(Object obj);

    void destroyKeyboard();

    void destroyMouse();

    int getButtonCount();

    int getHeight();

    int getMaxCursorSize();

    int getMinCursorSize();

    int getNativeCursorCapabilities();

    int getWidth();

    void grabMouse(boolean z);

    boolean hasWheel();

    boolean isInsideWindow();

    void pollKeyboard(ByteBuffer byteBuffer);

    void pollMouse(IntBuffer intBuffer, ByteBuffer byteBuffer);

    void readKeyboard(ByteBuffer byteBuffer);

    void readMouse(ByteBuffer byteBuffer);

    void setCursorPosition(int i, int i2);

    void setNativeCursor(Object obj) throws LWJGLException;
}
