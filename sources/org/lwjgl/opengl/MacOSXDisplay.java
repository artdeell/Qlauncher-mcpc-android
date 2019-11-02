package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.Robot;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.MemoryUtil;

final class MacOSXDisplay implements DisplayImplementation {
    private static final int GAMMA_LENGTH = 256;
    private static final int PBUFFER_HANDLE_SIZE = 24;
    private static final IntBuffer current_viewport = BufferUtils.createIntBuffer(16);
    private Canvas canvas;
    private boolean close_requested;
    private ByteBuffer context;
    private long currentNativeCursor = 0;
    private MacOSXNativeKeyboard keyboard;
    private KeyboardEventQueue keyboard_queue;
    private MacOSXNativeMouse mouse;
    private boolean mouseInsideWindow;
    private MacOSXMouseEventQueue mouse_queue;
    private boolean native_mode = true;
    private DisplayMode requested_mode;
    private Robot robot;
    private boolean skipViewportValue = false;
    private boolean updateNativeCursor = false;
    private ByteBuffer window;

    MacOSXDisplay() {
    }

    private static boolean equals(DisplayMode displayMode, DisplayMode displayMode2) {
        DisplayMode displayMode3 = displayMode;
        DisplayMode displayMode4 = displayMode2;
        return displayMode3.getWidth() == displayMode4.getWidth() && displayMode3.getHeight() == displayMode4.getHeight() && displayMode3.getBitsPerPixel() == displayMode4.getBitsPerPixel() && displayMode3.getFrequency() == displayMode4.getFrequency();
    }

    private static long getCursorHandle(Object obj) {
        Object obj2 = obj;
        if (obj2 != null) {
            return ((Long) obj2).longValue();
        }
        return 0;
    }

    private static boolean isUndecorated() {
        return Display.getPrivilegedBoolean("org.lwjgl.opengl.Window.undecorated");
    }

    private native ByteBuffer nCreateWindow(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    private native Object nGetCurrentDisplayMode();

    private native void nGetDisplayModes(Object obj);

    private native int nGetHeight(ByteBuffer byteBuffer);

    private native int nGetWidth(ByteBuffer byteBuffer);

    private native int nGetX(ByteBuffer byteBuffer);

    private native int nGetY(ByteBuffer byteBuffer);

    private native boolean nIsFocused(ByteBuffer byteBuffer);

    private native boolean nIsMiniaturized(ByteBuffer byteBuffer);

    private native boolean nIsNativeMode(ByteBuffer byteBuffer);

    private native void nResizeWindow(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    private native void nSetResizable(ByteBuffer byteBuffer, boolean z);

    private native void nSetTitle(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    private native boolean nWasResized(ByteBuffer byteBuffer);

    private native void restoreGamma();

    public void addDisplayMode(Object obj, int i, int i2, int i3, int i4) {
        DisplayMode displayMode;
        List list = (List) obj;
        DisplayMode displayMode2 = displayMode;
        DisplayMode displayMode3 = new DisplayMode(i, i2, i3, i4);
        boolean add = list.add(displayMode2);
    }

    public void bindTexImageToPbuffer(PeerInfo peerInfo, int i) {
        UnsupportedOperationException unsupportedOperationException;
        PeerInfo peerInfo2 = peerInfo;
        int i2 = i;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public Object createCursor(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        return this.native_mode ? Long.valueOf(MacOSXNativeMouse.createCursor(i6, i7, i8, i9, i10, intBuffer3, intBuffer4)) : AWTUtil.createCursor(i6, i7, i8, i9, i10, intBuffer3, intBuffer4);
    }

    public Object createDisplayMode(int i, int i2, int i3, int i4) {
        DisplayMode displayMode;
        DisplayMode displayMode2 = displayMode;
        DisplayMode displayMode3 = new DisplayMode(i, i2, i3, i4);
        return displayMode2;
    }

    public void createKeyboard() throws LWJGLException {
        KeyboardEventQueue keyboardEventQueue;
        MacOSXNativeKeyboard macOSXNativeKeyboard;
        if (this.native_mode) {
            MacOSXNativeKeyboard macOSXNativeKeyboard2 = macOSXNativeKeyboard;
            MacOSXNativeKeyboard macOSXNativeKeyboard3 = new MacOSXNativeKeyboard(this.window);
            this.keyboard = macOSXNativeKeyboard2;
            this.keyboard.register();
            return;
        }
        KeyboardEventQueue keyboardEventQueue2 = keyboardEventQueue;
        KeyboardEventQueue keyboardEventQueue3 = new KeyboardEventQueue(this.canvas);
        this.keyboard_queue = keyboardEventQueue2;
        this.keyboard_queue.register();
    }

    public void createMouse() throws LWJGLException {
        MacOSXMouseEventQueue macOSXMouseEventQueue;
        MacOSXNativeMouse macOSXNativeMouse;
        if (this.native_mode) {
            MacOSXNativeMouse macOSXNativeMouse2 = macOSXNativeMouse;
            MacOSXNativeMouse macOSXNativeMouse3 = new MacOSXNativeMouse(this, this.window);
            this.mouse = macOSXNativeMouse2;
            this.mouse.register();
            return;
        }
        MacOSXMouseEventQueue macOSXMouseEventQueue2 = macOSXMouseEventQueue;
        MacOSXMouseEventQueue macOSXMouseEventQueue3 = new MacOSXMouseEventQueue(this.canvas);
        this.mouse_queue = macOSXMouseEventQueue2;
        this.mouse_queue.register();
    }

    public PeerInfo createPbuffer(int i, int i2, PixelFormat pixelFormat, ContextAttribs contextAttribs, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException {
        MacOSXPbufferPeerInfo macOSXPbufferPeerInfo;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        MacOSXPbufferPeerInfo macOSXPbufferPeerInfo2 = macOSXPbufferPeerInfo;
        MacOSXPbufferPeerInfo macOSXPbufferPeerInfo3 = new MacOSXPbufferPeerInfo(i, i2, pixelFormat, contextAttribs);
        return macOSXPbufferPeerInfo2;
    }

    public PeerInfo createPeerInfo(PixelFormat pixelFormat, ContextAttribs contextAttribs) throws LWJGLException {
        MacOSXDisplayPeerInfo macOSXDisplayPeerInfo;
        MacOSXDisplayPeerInfo macOSXDisplayPeerInfo2;
        PixelFormat pixelFormat2 = pixelFormat;
        ContextAttribs contextAttribs2 = contextAttribs;
        try {
            MacOSXDisplayPeerInfo macOSXDisplayPeerInfo3 = macOSXDisplayPeerInfo2;
            MacOSXDisplayPeerInfo macOSXDisplayPeerInfo4 = new MacOSXDisplayPeerInfo(pixelFormat2, contextAttribs2, true);
            return macOSXDisplayPeerInfo3;
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            MacOSXDisplayPeerInfo macOSXDisplayPeerInfo5 = macOSXDisplayPeerInfo;
            MacOSXDisplayPeerInfo macOSXDisplayPeerInfo6 = new MacOSXDisplayPeerInfo(pixelFormat2, contextAttribs2, false);
            return macOSXDisplayPeerInfo5;
        }
    }

    public void createWindow(DrawableLWJGL drawableLWJGL, DisplayMode displayMode, Canvas canvas2, int i, int i2) throws LWJGLException {
        DrawableLWJGL drawableLWJGL2 = drawableLWJGL;
        DisplayMode displayMode2 = displayMode;
        Canvas canvas3 = canvas2;
        int i3 = i;
        int i4 = i2;
        boolean isFullscreen = Display.isFullscreen();
        boolean isResizable = Display.isResizable();
        boolean z = canvas3 != null && !isFullscreen;
        if (z) {
            this.canvas = canvas3;
        } else {
            this.canvas = null;
        }
        this.close_requested = false;
        PeerInfo peerInfo = ((DrawableGL) Display.getDrawable()).peer_info;
        ByteBuffer lockAndGetHandle = peerInfo.lockAndGetHandle();
        try {
            this.window = nCreateWindow(i3, i4, displayMode2.getWidth(), displayMode2.getHeight(), isFullscreen, isUndecorated(), isResizable, z, lockAndGetHandle, z ? ((MacOSXCanvasPeerInfo) peerInfo).window_handle : this.window);
            if (isFullscreen) {
                this.skipViewportValue = true;
                if (current_viewport.get(2) == 0 && current_viewport.get(3) == 0) {
                    IntBuffer put = current_viewport.put(2, displayMode2.getWidth());
                    IntBuffer put2 = current_viewport.put(3, displayMode2.getHeight());
                }
            }
            this.native_mode = nIsNativeMode(lockAndGetHandle);
            if (!this.native_mode) {
                this.robot = AWTUtil.createRobot(this.canvas);
            }
            peerInfo.unlock();
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            destroyWindow();
            throw lWJGLException;
        } catch (Throwable th) {
            Throwable th2 = th;
            peerInfo.unlock();
            throw th2;
        }
    }

    public void destroyCursor(Object obj) {
        long cursorHandle = getCursorHandle(obj);
        if (this.currentNativeCursor == cursorHandle) {
            this.currentNativeCursor = 0;
        }
        MacOSXNativeMouse.destroyCursor(cursorHandle);
    }

    public void destroyKeyboard() {
        if (this.native_mode) {
            if (this.keyboard != null) {
                this.keyboard.unregister();
            }
            this.keyboard = null;
            return;
        }
        if (this.keyboard_queue != null) {
            this.keyboard_queue.unregister();
        }
        this.keyboard_queue = null;
    }

    public void destroyMouse() {
        if (this.native_mode) {
            try {
                MacOSXNativeMouse.setCursor(0);
            } catch (LWJGLException e) {
                LWJGLException lWJGLException = e;
            }
            grabMouse(false);
            if (this.mouse != null) {
                this.mouse.unregister();
            }
            this.mouse = null;
            return;
        }
        if (this.mouse_queue != null) {
            MacOSXMouseEventQueue.nGrabMouse(false);
            this.mouse_queue.unregister();
        }
        this.mouse_queue = null;
    }

    public void destroyWindow() {
        if (!this.native_mode) {
            PeerInfo peerInfo = ((DrawableGL) Display.getDrawable()).peer_info;
            if (peerInfo != null) {
                nDestroyCALayer(peerInfo.getHandle());
            }
            this.robot = null;
        }
        nDestroyWindow(this.window);
    }

    public void doHandleQuit() {
        synchronized (this) {
            try {
                this.close_requested = true;
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public String getAdapter() {
        return null;
    }

    public DisplayMode[] getAvailableDisplayModes() throws LWJGLException {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        nGetDisplayModes(arrayList4);
        return (DisplayMode[]) arrayList4.toArray(new DisplayMode[arrayList4.size()]);
    }

    public int getButtonCount() {
        return AWTUtil.getButtonCount();
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public int getGammaRampLength() {
        return 256;
    }

    public int getHeight() {
        return nGetHeight(this.window);
    }

    public int getMaxCursorSize() {
        return AWTUtil.getMaxCursorSize();
    }

    public int getMinCursorSize() {
        return AWTUtil.getMinCursorSize();
    }

    public int getNativeCursorCapabilities() {
        if (this.native_mode) {
            return 7;
        }
        return AWTUtil.getNativeCursorCapabilities();
    }

    public int getPbufferCapabilities() {
        return 1;
    }

    public String getVersion() {
        return null;
    }

    public int getWidth() {
        return nGetWidth(this.window);
    }

    public int getX() {
        return nGetX(this.window);
    }

    public int getY() {
        return nGetY(this.window);
    }

    public void grabMouse(boolean z) {
        boolean z2 = z;
        if (this.native_mode) {
            this.mouse.setGrabbed(z2);
        } else {
            this.mouse_queue.setGrabbed(z2);
        }
    }

    public boolean hasWheel() {
        return AWTUtil.hasWheel();
    }

    public DisplayMode init() throws LWJGLException {
        return (DisplayMode) nGetCurrentDisplayMode();
    }

    public boolean isActive() {
        return this.native_mode ? nIsFocused(this.window) : Display.getParent().hasFocus();
    }

    public boolean isBufferLost(PeerInfo peerInfo) {
        PeerInfo peerInfo2 = peerInfo;
        return false;
    }

    public boolean isCloseRequested() {
        synchronized (this) {
            try {
                th = this.close_requested;
                this.close_requested = false;
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public boolean isDirty() {
        return false;
    }

    public boolean isInsideWindow() {
        return this.mouseInsideWindow;
    }

    public boolean isVisible() {
        return true;
    }

    public void mouseInsideWindow(boolean z) {
        boolean z2 = z;
        synchronized (this) {
            try {
                this.mouseInsideWindow = z2;
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }
        this.updateNativeCursor = true;
    }

    public native void nDestroyCALayer(ByteBuffer byteBuffer);

    public native void nDestroyWindow(ByteBuffer byteBuffer);

    public void pollKeyboard(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        if (this.native_mode) {
            this.keyboard.poll(byteBuffer2);
        } else {
            this.keyboard_queue.poll(byteBuffer2);
        }
    }

    public void pollMouse(IntBuffer intBuffer, ByteBuffer byteBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (this.native_mode) {
            this.mouse.poll(intBuffer2, byteBuffer2);
        } else {
            this.mouse_queue.poll(intBuffer2, byteBuffer2);
        }
    }

    public void readKeyboard(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        if (this.native_mode) {
            this.keyboard.copyEvents(byteBuffer2);
        } else {
            this.keyboard_queue.copyEvents(byteBuffer2);
        }
    }

    public void readMouse(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        if (this.native_mode) {
            this.mouse.copyEvents(byteBuffer2);
        } else {
            this.mouse_queue.copyEvents(byteBuffer2);
        }
    }

    public void releaseTexImageFromPbuffer(PeerInfo peerInfo, int i) {
        UnsupportedOperationException unsupportedOperationException;
        PeerInfo peerInfo2 = peerInfo;
        int i2 = i;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public void resetDisplayMode() {
        this.requested_mode = null;
        restoreGamma();
    }

    public void reshape(int i, int i2, int i3, int i4) {
    }

    public void setCursorPosition(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.native_mode && this.mouse != null) {
            this.mouse.setCursorPosition(i3, i4);
        }
    }

    public native void setGammaRamp(FloatBuffer floatBuffer) throws LWJGLException;

    public int setIcon(ByteBuffer[] byteBufferArr) {
        ByteBuffer[] byteBufferArr2 = byteBufferArr;
        return 0;
    }

    public void setNativeCursor(Object obj) throws LWJGLException {
        Object obj2 = obj;
        if (this.native_mode) {
            this.currentNativeCursor = getCursorHandle(obj2);
            if (!Display.isCreated()) {
                return;
            }
            if (this.mouseInsideWindow) {
                MacOSXNativeMouse.setCursor(this.currentNativeCursor);
            } else {
                MacOSXNativeMouse.setCursor(0);
            }
        }
    }

    public void setPbufferAttrib(PeerInfo peerInfo, int i, int i2) {
        UnsupportedOperationException unsupportedOperationException;
        PeerInfo peerInfo2 = peerInfo;
        int i3 = i;
        int i4 = i2;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public void setResizable(boolean z) {
        nSetResizable(this.window, z);
    }

    public void setTitle(String str) {
        nSetTitle(this.window, MemoryUtil.encodeUTF8(str));
    }

    public void switchDisplayMode(DisplayMode displayMode) throws LWJGLException {
        LWJGLException lWJGLException;
        StringBuilder sb;
        DisplayMode displayMode2 = displayMode;
        DisplayMode[] availableDisplayModes = getAvailableDisplayModes();
        int length = availableDisplayModes.length;
        for (int i = 0; i < length; i++) {
            DisplayMode displayMode3 = availableDisplayModes[i];
            if (equals(displayMode3, displayMode2)) {
                this.requested_mode = displayMode3;
                return;
            }
        }
        LWJGLException lWJGLException2 = lWJGLException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        LWJGLException lWJGLException3 = new LWJGLException(sb2.append(displayMode2).append(" is not supported").toString());
        throw lWJGLException2;
    }

    public void update() {
        DrawableGL drawableGL = (DrawableGL) Display.getDrawable();
        if (1 != 0) {
            drawableGL.context.update();
            if (this.skipViewportValue) {
                this.skipViewportValue = false;
            } else {
                GL11.glGetInteger(2978, current_viewport);
            }
            GL11.glViewport(current_viewport.get(0), current_viewport.get(1), current_viewport.get(2), current_viewport.get(3));
        }
        if (this.native_mode && this.updateNativeCursor) {
            this.updateNativeCursor = false;
            try {
                setNativeCursor(Long.valueOf(this.currentNativeCursor));
            } catch (LWJGLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean wasResized() {
        return nWasResized(this.window);
    }
}
