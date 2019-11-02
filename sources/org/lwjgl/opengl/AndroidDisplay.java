package org.lwjgl.opengl;

import java.awt.Canvas;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

public final class AndroidDisplay implements DisplayImplementation {
    private static final ByteBuffer event_buffer = ByteBuffer.allocate(22);
    private static EventQueue event_queue;
    public static boolean grab;
    private static final byte[] key_down_buffer = new byte[256];
    private static final ByteBuffer keyboardEvent = ByteBuffer.allocate(18);
    private static final EventQueue keyboardEventQueue;
    private static long last_event_nanos = System.nanoTime();
    public static int mouseLastEventX = 0;
    public static int mouseLastEventY = 0;
    public static int mouseLastX = 0;
    public static int mouseLastY = 0;
    public static boolean mouseLeft = false;
    public static int mouseX = 0;
    public static int mouseY = 0;
    public static int windowHeight = 800;
    public static int windowWidth = GL11.GL_INVALID_ENUM;
    private long blank_cursor;
    private boolean close_requested;
    private long current_cursor;
    private boolean dirty;
    private boolean focused;
    private boolean input_released;
    private Keyboard keyboard;
    private boolean keyboard_grabbed;
    private boolean minimized;
    private boolean mouseInside = true;
    private boolean pointer_grabbed;
    private boolean resizable;
    private boolean resized;
    private int window_height;
    private int window_width;
    private int window_x;
    private int window_y;

    static {
        EventQueue eventQueue;
        EventQueue eventQueue2;
        EventQueue eventQueue3 = eventQueue;
        EventQueue eventQueue4 = new EventQueue(event_buffer.capacity());
        event_queue = eventQueue3;
        EventQueue eventQueue5 = eventQueue2;
        EventQueue eventQueue6 = new EventQueue(18);
        keyboardEventQueue = eventQueue5;
    }

    public AndroidDisplay() {
    }

    private static DisplayMode getCurrentXRandrMode() throws LWJGLException {
        return null;
    }

    private static long getCursorHandle(Object obj) {
        Object obj2 = obj;
        return 0;
    }

    private static void putKeyboardEvent(int i, byte b, int i2, long j, boolean z) {
        int i3 = i;
        byte b2 = b;
        int i4 = i2;
        long j2 = j;
        boolean z2 = z;
        Buffer clear = keyboardEvent.clear();
        ByteBuffer put = keyboardEvent.putInt(i3).put(b2).putInt(i4).putLong(j2).put(z2 ? (byte) 1 : 0);
        Buffer flip = keyboardEvent.flip();
        boolean putEvent = keyboardEventQueue.putEvent(keyboardEvent);
    }

    public static void putMouseEventWithCoords(byte b, byte b2, int i, int i2, int i3, long j) {
        byte b3 = b;
        byte b4 = b2;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        if (!grab) {
            Buffer clear = event_buffer.clear();
            ByteBuffer putLong = event_buffer.put(b3).put(b4).putInt(i4).putInt(i5).putInt(i6).putLong(j2);
            Buffer flip = event_buffer.flip();
            boolean putEvent = event_queue.putEvent(event_buffer);
            last_event_nanos = j2;
        } else if (b4 == 1) {
            mouseLastX = i4;
            mouseLastY = i5;
        }
    }

    public static void setKey(int i, char c, boolean z) {
        int i2 = i;
        char c2 = c;
        byte b = z ? (byte) 1 : 0;
        putKeyboardEvent(i2, b, c2, System.nanoTime(), false);
        if (i2 != 0) {
            setKeyDown(i2, b);
        }
    }

    private static void setKeyDown(int i, byte b) {
        key_down_buffer[i] = b;
    }

    public static void setMouseButtonInGrabMode(byte b, byte b2) {
        byte b3 = b;
        byte b4 = b2;
        long nanoTime = System.nanoTime();
        Buffer clear = event_buffer.clear();
        ByteBuffer putLong = event_buffer.put(b3).put(b4).putInt(0).putInt(0).putInt(0).putLong(nanoTime);
        Buffer flip = event_buffer.flip();
        boolean putEvent = event_queue.putEvent(event_buffer);
        last_event_nanos = nanoTime;
    }

    private boolean shouldWarpPointer() {
        return false;
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
        return null;
    }

    public void createKeyboard() throws LWJGLException {
    }

    public void createMouse() throws LWJGLException {
    }

    public PeerInfo createPbuffer(int i, int i2, PixelFormat pixelFormat, ContextAttribs contextAttribs, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException {
        LinuxPbufferPeerInfo linuxPbufferPeerInfo;
        ContextAttribs contextAttribs2 = contextAttribs;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        LinuxPbufferPeerInfo linuxPbufferPeerInfo2 = linuxPbufferPeerInfo;
        LinuxPbufferPeerInfo linuxPbufferPeerInfo3 = new LinuxPbufferPeerInfo(i, i2, pixelFormat);
        return linuxPbufferPeerInfo2;
    }

    public PeerInfo createPeerInfo(PixelFormat pixelFormat, ContextAttribs contextAttribs) throws LWJGLException {
        PixelFormat pixelFormat2 = pixelFormat;
        ContextAttribs contextAttribs2 = contextAttribs;
        return null;
    }

    public void createWindow(DrawableLWJGL drawableLWJGL, DisplayMode displayMode, Canvas canvas, int i, int i2) throws LWJGLException {
    }

    public void destroyCursor(Object obj) {
    }

    public void destroyKeyboard() {
    }

    public void destroyMouse() {
    }

    public void destroyWindow() {
    }

    public String getAdapter() {
        return null;
    }

    public DisplayMode[] getAvailableDisplayModes() throws LWJGLException {
        DisplayMode displayMode;
        DisplayMode[] displayModeArr = new DisplayMode[1];
        DisplayMode[] displayModeArr2 = displayModeArr;
        DisplayMode displayMode2 = displayMode;
        DisplayMode displayMode3 = new DisplayMode(windowWidth, windowHeight, 24, 60, true);
        displayModeArr2[0] = displayMode2;
        return displayModeArr;
    }

    public int getButtonCount() {
        return 3;
    }

    public int getGammaRampLength() {
        return 0;
    }

    public int getHeight() {
        return windowHeight;
    }

    public int getMaxCursorSize() {
        return 0;
    }

    public int getMinCursorSize() {
        return 0;
    }

    public int getNativeCursorCapabilities() {
        return 0;
    }

    public int getPbufferCapabilities() {
        return 0;
    }

    public String getVersion() {
        return null;
    }

    public int getWidth() {
        return windowWidth;
    }

    public int getX() {
        return this.window_x;
    }

    public int getY() {
        return this.window_y;
    }

    public void grabMouse(boolean z) {
        StringBuilder sb;
        boolean z2 = z;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("Grab: ").append(z2).toString());
        grab = z2;
    }

    public boolean hasWheel() {
        return true;
    }

    public DisplayMode init() throws LWJGLException {
        DisplayMode displayMode;
        DisplayMode displayMode2 = displayMode;
        DisplayMode displayMode3 = new DisplayMode(windowWidth, windowHeight, 24, 60, true);
        return displayMode2;
    }

    public boolean isActive() {
        return true;
    }

    public boolean isBufferLost(PeerInfo peerInfo) {
        PeerInfo peerInfo2 = peerInfo;
        return false;
    }

    public boolean isCloseRequested() {
        return false;
    }

    public boolean isDirty() {
        return false;
    }

    public boolean isInsideWindow() {
        return this.mouseInside;
    }

    public boolean isVisible() {
        return true;
    }

    public void pollKeyboard(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int position = byteBuffer2.position();
        ByteBuffer put = byteBuffer2.put(key_down_buffer);
        Buffer position2 = byteBuffer2.position(position);
    }

    public void pollMouse(IntBuffer intBuffer, ByteBuffer byteBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer put = intBuffer2.put(0, grab ? mouseX - mouseLastX : mouseX);
        IntBuffer put2 = intBuffer2.put(1, grab ? mouseY - mouseLastY : mouseY);
        ByteBuffer put3 = byteBuffer2.put(0, mouseLeft ? (byte) 1 : 0);
        mouseLastX = mouseX;
        mouseLastY = mouseY;
    }

    public void readKeyboard(ByteBuffer byteBuffer) {
        keyboardEventQueue.copyEvents(byteBuffer);
    }

    public void readMouse(ByteBuffer byteBuffer) {
        event_queue.copyEvents(byteBuffer);
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
    }

    public void reshape(int i, int i2, int i3, int i4) {
    }

    public void setCursorPosition(int i, int i2) {
    }

    public void setGammaRamp(FloatBuffer floatBuffer) throws LWJGLException {
        LWJGLException lWJGLException;
        FloatBuffer floatBuffer2 = floatBuffer;
        LWJGLException lWJGLException2 = lWJGLException;
        LWJGLException lWJGLException3 = new LWJGLException("No gamma ramp support (Missing XF86VM extension)");
        throw lWJGLException2;
    }

    public int setIcon(ByteBuffer[] byteBufferArr) {
        ByteBuffer[] byteBufferArr2 = byteBufferArr;
        return 0;
    }

    public void setNativeCursor(Object obj) throws LWJGLException {
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
    }

    public void setTitle(String str) {
    }

    public void switchDisplayMode(DisplayMode displayMode) throws LWJGLException {
    }

    public void update() {
    }

    public boolean wasResized() {
        return false;
    }
}
