package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;

final class LinuxEvent {
    public static final int ButtonPress = 4;
    public static final int ButtonRelease = 5;
    public static final int ClientMessage = 33;
    public static final int ConfigureNotify = 22;
    public static final int EnterNotify = 7;
    public static final int Expose = 12;
    public static final int FocusIn = 9;
    public static final int FocusOut = 10;
    public static final int KeyPress = 2;
    public static final int KeyRelease = 3;
    public static final int LeaveNotify = 8;
    public static final int MapNotify = 19;
    public static final int MotionNotify = 6;
    public static final int UnmapNotify = 18;
    private final ByteBuffer event_buffer = createEventBuffer();

    LinuxEvent() {
    }

    private static native ByteBuffer createEventBuffer();

    public static native int getPending(long j);

    private static native boolean nFilterEvent(ByteBuffer byteBuffer, long j);

    private static native int nGetButtonButton(ByteBuffer byteBuffer);

    private static native long nGetButtonRoot(ByteBuffer byteBuffer);

    private static native int nGetButtonState(ByteBuffer byteBuffer);

    private static native long nGetButtonTime(ByteBuffer byteBuffer);

    private static native int nGetButtonType(ByteBuffer byteBuffer);

    private static native int nGetButtonX(ByteBuffer byteBuffer);

    private static native int nGetButtonXRoot(ByteBuffer byteBuffer);

    private static native int nGetButtonY(ByteBuffer byteBuffer);

    private static native int nGetButtonYRoot(ByteBuffer byteBuffer);

    private static native int nGetClientData(ByteBuffer byteBuffer, int i);

    private static native int nGetClientFormat(ByteBuffer byteBuffer);

    private static native long nGetClientMessageType(ByteBuffer byteBuffer);

    private static native int nGetFocusDetail(ByteBuffer byteBuffer);

    private static native int nGetFocusMode(ByteBuffer byteBuffer);

    private static native long nGetKeyAddress(ByteBuffer byteBuffer);

    private static native int nGetKeyKeyCode(ByteBuffer byteBuffer);

    private static native int nGetKeyState(ByteBuffer byteBuffer);

    private static native int nGetKeyTime(ByteBuffer byteBuffer);

    private static native int nGetKeyType(ByteBuffer byteBuffer);

    private static native int nGetType(ByteBuffer byteBuffer);

    private static native long nGetWindow(ByteBuffer byteBuffer);

    private static native void nNextEvent(long j, ByteBuffer byteBuffer);

    private static native void nSendEvent(ByteBuffer byteBuffer, long j, long j2, boolean z, long j3);

    private static native void nSetWindow(ByteBuffer byteBuffer, long j);

    public void copyFrom(LinuxEvent linuxEvent) {
        LinuxEvent linuxEvent2 = linuxEvent;
        int position = this.event_buffer.position();
        int position2 = linuxEvent2.event_buffer.position();
        ByteBuffer put = this.event_buffer.put(linuxEvent2.event_buffer);
        Buffer position3 = this.event_buffer.position(position);
        Buffer position4 = linuxEvent2.event_buffer.position(position2);
    }

    public boolean filterEvent(long j) {
        return nFilterEvent(this.event_buffer, j);
    }

    public int getButtonButton() {
        return nGetButtonButton(this.event_buffer);
    }

    public long getButtonRoot() {
        return nGetButtonRoot(this.event_buffer);
    }

    public int getButtonState() {
        return nGetButtonState(this.event_buffer);
    }

    public long getButtonTime() {
        return nGetButtonTime(this.event_buffer);
    }

    public int getButtonType() {
        return nGetButtonType(this.event_buffer);
    }

    public int getButtonX() {
        return nGetButtonX(this.event_buffer);
    }

    public int getButtonXRoot() {
        return nGetButtonXRoot(this.event_buffer);
    }

    public int getButtonY() {
        return nGetButtonY(this.event_buffer);
    }

    public int getButtonYRoot() {
        return nGetButtonYRoot(this.event_buffer);
    }

    public int getClientData(int i) {
        return nGetClientData(this.event_buffer, i);
    }

    public int getClientFormat() {
        return nGetClientFormat(this.event_buffer);
    }

    public long getClientMessageType() {
        return nGetClientMessageType(this.event_buffer);
    }

    public int getFocusDetail() {
        return nGetFocusDetail(this.event_buffer);
    }

    public int getFocusMode() {
        return nGetFocusMode(this.event_buffer);
    }

    public long getKeyAddress() {
        return nGetKeyAddress(this.event_buffer);
    }

    public int getKeyKeyCode() {
        return nGetKeyKeyCode(this.event_buffer);
    }

    public int getKeyState() {
        return nGetKeyState(this.event_buffer);
    }

    public long getKeyTime() {
        return (long) nGetKeyTime(this.event_buffer);
    }

    public int getKeyType() {
        return nGetKeyType(this.event_buffer);
    }

    public int getType() {
        return nGetType(this.event_buffer);
    }

    public long getWindow() {
        return nGetWindow(this.event_buffer);
    }

    public void nextEvent(long j) {
        nNextEvent(j, this.event_buffer);
    }

    public void sendEvent(long j, long j2, boolean z, long j3) {
        long j4 = j;
        long j5 = j2;
        boolean z2 = z;
        long j6 = j3;
        nSendEvent(this.event_buffer, j4, j5, z2, j6);
    }

    public void setWindow(long j) {
        long j2 = j;
        nSetWindow(this.event_buffer, j2);
    }
}
