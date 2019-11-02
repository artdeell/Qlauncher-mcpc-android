package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.opengl.XRandR.Screen;
import org.lwjgl.opengles.GLContext;

final class LinuxDisplay implements DisplayImplementation {
    public static final int AutoRepeatModeDefault = 2;
    public static final int AutoRepeatModeOff = 0;
    public static final int AutoRepeatModeOn = 1;
    private static final int ButtonPressMask = 4;
    private static final int ButtonReleaseMask = 8;
    public static final int CurrentTime = 0;
    private static final int FULLSCREEN_LEGACY = 1;
    private static final int FULLSCREEN_NETWM = 2;
    public static final int GrabSuccess = 0;
    private static final int KeyPressMask = 1;
    private static final int KeyReleaseMask = 2;
    private static final int NONE = 12;
    public static final int None = 0;
    private static final int NotifyAncestor = 0;
    private static final int NotifyDetailNone = 7;
    private static final int NotifyNonlinear = 3;
    private static final int NotifyPointer = 5;
    private static final int NotifyPointerRoot = 6;
    private static final int SaveSetRoot = 1;
    private static final int SaveSetUnmap = 1;
    private static final int SetModeInsert = 0;
    private static final int WINDOWED = 3;
    private static final int XF86VIDMODE = 11;
    private static final int XRANDR = 10;
    private static final int X_SetInputFocus = 42;
    private static long current_window;
    private static int current_window_mode = 3;
    private static long display;
    private static int display_connection_usage_count;
    private static long saved_error_handler;
    private static boolean xembedded;
    private long blank_cursor;
    private boolean close_requested;
    private long current_cursor;
    private int current_displaymode_extension = 12;
    private ByteBuffer current_gamma;
    private DisplayMode current_mode;
    private long delete_atom;
    private boolean dirty;
    private final LinuxEvent event_buffer;
    private final FocusListener focus_listener;
    private boolean focused;
    private boolean grab;
    private boolean input_released;
    private LinuxKeyboard keyboard;
    private boolean keyboard_grabbed;
    private long last_window_focus = 0;
    private boolean minimized;
    private LinuxMouse mouse;
    private boolean mouseInside = true;
    private Canvas parent;
    private boolean parent_focus_changed;
    private boolean parent_focused;
    private long parent_proxy_focus_window;
    private long parent_window;
    private PeerInfo peer_info;
    private boolean pointer_grabbed;
    private boolean resizable;
    private boolean resized;
    /* access modifiers changed from: private */
    public Screen[] savedXrandrConfig;
    private ByteBuffer saved_gamma;
    private DisplayMode saved_mode;
    private final LinuxEvent tmp_event_buffer;
    private int window_height;
    private int window_width;
    private int window_x;
    private int window_y;

    private static final class Compiz {
        private static boolean applyFix;
        /* access modifiers changed from: private */
        public static Provider provider;

        private interface Provider {
            boolean hasLegacyFullscreenSupport() throws LWJGLException;

            void setLegacyFullscreenSupport(boolean z) throws LWJGLException;
        }

        private Compiz() {
        }

        static /* synthetic */ Provider access$402(Provider provider2) {
            Provider provider3 = provider2;
            provider = provider3;
            return provider3;
        }

        static /* synthetic */ boolean access$602(boolean z) {
            boolean z2 = z;
            applyFix = z2;
            return z2;
        }

        static void init() {
            C07991 r2;
            if (!Display.getPrivilegedBoolean("org.lwjgl.opengl.Window.nocompiz_lfs")) {
                C07991 r0 = r2;
                C07991 r1 = new PrivilegedAction<Object>() {
                    public Object run() {
                        C08012 r11;
                        StringBuilder sb;
                        C08001 r112;
                        try {
                            if (!Compiz.isProcessActive("compiz")) {
                                return null;
                            }
                            Provider access$402 = Compiz.access$402(null);
                            String str = null;
                            if (Compiz.isProcessActive("dbus-daemon")) {
                                str = "Dbus";
                                C08001 r8 = r112;
                                C08001 r9 = new Provider(this) {
                                    private static final String KEY = "/org/freedesktop/compiz/workarounds/allscreens/legacy_fullscreen";
                                    final /* synthetic */ C07991 this$0;

                                    {
                                        this.this$0 = r5;
                                    }

                                    public boolean hasLegacyFullscreenSupport() throws LWJGLException {
                                        LWJGLException lWJGLException;
                                        LWJGLException lWJGLException2;
                                        LWJGLException lWJGLException3;
                                        String[] strArr = new String[6];
                                        String[] strArr2 = strArr;
                                        strArr[0] = "dbus-send";
                                        String[] strArr3 = strArr2;
                                        String[] strArr4 = strArr3;
                                        strArr3[1] = "--print-reply";
                                        String[] strArr5 = strArr4;
                                        String[] strArr6 = strArr5;
                                        strArr5[2] = "--type=method_call";
                                        String[] strArr7 = strArr6;
                                        String[] strArr8 = strArr7;
                                        strArr7[3] = "--dest=org.freedesktop.compiz";
                                        String[] strArr9 = strArr8;
                                        String[] strArr10 = strArr9;
                                        strArr9[4] = KEY;
                                        String[] strArr11 = strArr10;
                                        String[] strArr12 = strArr11;
                                        strArr11[5] = "org.freedesktop.compiz.get";
                                        List access$500 = Compiz.run(strArr12);
                                        if (access$500 == null || access$500.size() < 2) {
                                            LWJGLException lWJGLException4 = lWJGLException;
                                            LWJGLException lWJGLException5 = new LWJGLException("Invalid Dbus reply.");
                                            throw lWJGLException4;
                                        } else if (!((String) access$500.get(0)).startsWith("method return")) {
                                            LWJGLException lWJGLException6 = lWJGLException3;
                                            LWJGLException lWJGLException7 = new LWJGLException("Invalid Dbus reply.");
                                            throw lWJGLException6;
                                        } else {
                                            String trim = ((String) access$500.get(1)).trim();
                                            if (trim.startsWith("boolean") && trim.length() >= 12) {
                                                return "true".equalsIgnoreCase(trim.substring(1 + "boolean".length()));
                                            }
                                            LWJGLException lWJGLException8 = lWJGLException2;
                                            LWJGLException lWJGLException9 = new LWJGLException("Invalid Dbus reply.");
                                            throw lWJGLException8;
                                        }
                                    }

                                    public void setLegacyFullscreenSupport(boolean z) throws LWJGLException {
                                        StringBuilder sb;
                                        LWJGLException lWJGLException;
                                        boolean z2 = z;
                                        String[] strArr = new String[6];
                                        strArr[0] = "dbus-send";
                                        strArr[1] = "--type=method_call";
                                        strArr[2] = "--dest=org.freedesktop.compiz";
                                        strArr[3] = KEY;
                                        strArr[4] = "org.freedesktop.compiz.set";
                                        String[] strArr2 = strArr;
                                        StringBuilder sb2 = sb;
                                        StringBuilder sb3 = new StringBuilder();
                                        strArr2[5] = sb2.append("boolean:").append(Boolean.toString(z2)).toString();
                                        if (Compiz.run(strArr) == null) {
                                            LWJGLException lWJGLException2 = lWJGLException;
                                            LWJGLException lWJGLException3 = new LWJGLException("Failed to apply Compiz LFS workaround.");
                                            throw lWJGLException2;
                                        }
                                    }
                                };
                                Provider access$4022 = Compiz.access$402(r8);
                            } else {
                                try {
                                    Process exec = Runtime.getRuntime().exec("gconftool");
                                    str = "gconftool";
                                    C08012 r82 = r11;
                                    C08012 r92 = new Provider(this) {
                                        private static final String KEY = "/apps/compiz/plugins/workarounds/allscreens/options/legacy_fullscreen";
                                        final /* synthetic */ C07991 this$0;

                                        {
                                            this.this$0 = r5;
                                        }

                                        public boolean hasLegacyFullscreenSupport() throws LWJGLException {
                                            LWJGLException lWJGLException;
                                            String[] strArr = new String[3];
                                            String[] strArr2 = strArr;
                                            strArr[0] = "gconftool";
                                            String[] strArr3 = strArr2;
                                            String[] strArr4 = strArr3;
                                            strArr3[1] = "-g";
                                            String[] strArr5 = strArr4;
                                            String[] strArr6 = strArr5;
                                            strArr5[2] = KEY;
                                            List access$500 = Compiz.run(strArr6);
                                            if (access$500 != null && access$500.size() != 0) {
                                                return Boolean.parseBoolean(((String) access$500.get(0)).trim());
                                            }
                                            LWJGLException lWJGLException2 = lWJGLException;
                                            LWJGLException lWJGLException3 = new LWJGLException("Invalid gconftool reply.");
                                            throw lWJGLException2;
                                        }

                                        public void setLegacyFullscreenSupport(boolean z) throws LWJGLException {
                                            LWJGLException lWJGLException;
                                            boolean z2 = z;
                                            if (Compiz.run("gconftool", "-s", KEY, "-s", Boolean.toString(z2), "-t", "bool") == null) {
                                                LWJGLException lWJGLException2 = lWJGLException;
                                                LWJGLException lWJGLException3 = new LWJGLException("Failed to apply Compiz LFS workaround.");
                                                throw lWJGLException2;
                                            } else if (z2) {
                                                try {
                                                    Thread.sleep(200);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                    };
                                    Provider access$4023 = Compiz.access$402(r82);
                                } catch (IOException e) {
                                    IOException iOException = e;
                                }
                            }
                            if (Compiz.provider != null && !Compiz.provider.hasLegacyFullscreenSupport()) {
                                boolean access$602 = Compiz.access$602(true);
                                StringBuilder sb2 = sb;
                                StringBuilder sb3 = new StringBuilder();
                                LWJGLUtil.log(sb2.append("Using ").append(str).append(" to apply Compiz LFS workaround.").toString());
                                return null;
                            }
                            return null;
                        } catch (LWJGLException e2) {
                            LWJGLException lWJGLException = e2;
                            return null;
                        } catch (Throwable th) {
                            Object obj = th;
                        }
                    }
                };
                Object doPrivileged = AccessController.doPrivileged(r0);
            }
        }

        /* access modifiers changed from: private */
        public static boolean isProcessActive(String str) throws LWJGLException {
            String str2 = str;
            String[] strArr = new String[3];
            String[] strArr2 = strArr;
            strArr[0] = "ps";
            String[] strArr3 = strArr2;
            String[] strArr4 = strArr3;
            strArr3[1] = "-C";
            String[] strArr5 = strArr4;
            String[] strArr6 = strArr5;
            strArr5[2] = str2;
            List<String> run = run(strArr6);
            if (run != null) {
                for (String contains : run) {
                    if (contains.contains(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public static List<String> run(String... strArr) throws LWJGLException {
            ArrayList arrayList;
            LWJGLException lWJGLException;
            LWJGLException lWJGLException2;
            BufferedReader bufferedReader;
            InputStreamReader inputStreamReader;
            String[] strArr2 = strArr;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            try {
                Process exec = Runtime.getRuntime().exec(strArr2);
                if (exec.waitFor() != 0) {
                    return null;
                }
                BufferedReader bufferedReader2 = bufferedReader;
                InputStreamReader inputStreamReader2 = inputStreamReader;
                InputStreamReader inputStreamReader3 = new InputStreamReader(exec.getInputStream());
                BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
                BufferedReader bufferedReader4 = bufferedReader2;
                while (true) {
                    String readLine = bufferedReader4.readLine();
                    if (readLine != null) {
                        boolean add = arrayList4.add(readLine);
                    } else {
                        bufferedReader4.close();
                        return arrayList4;
                    }
                }
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
                LWJGLException lWJGLException3 = lWJGLException2;
                LWJGLException lWJGLException4 = new LWJGLException("Process interrupted.", interruptedException);
                throw lWJGLException3;
            } catch (IOException e2) {
                IOException iOException = e2;
                LWJGLException lWJGLException5 = lWJGLException;
                LWJGLException lWJGLException6 = new LWJGLException("Process failed.", iOException);
                throw lWJGLException5;
            }
        }

        static void setLegacyFullscreenSupport(boolean z) {
            C08022 r4;
            boolean z2 = z;
            if (applyFix) {
                C08022 r1 = r4;
                final boolean z3 = z2;
                C08022 r2 = new PrivilegedAction<Object>() {
                    public Object run() {
                        StringBuilder sb;
                        try {
                            Compiz.provider.setLegacyFullscreenSupport(z3);
                        } catch (LWJGLException e) {
                            LWJGLException lWJGLException = e;
                            StringBuilder sb2 = sb;
                            StringBuilder sb3 = new StringBuilder();
                            LWJGLUtil.log(sb2.append("Failed to change Compiz Legacy Fullscreen Support. Reason: ").append(lWJGLException.getMessage()).toString());
                        }
                        return null;
                    }
                };
                Object doPrivileged = AccessController.doPrivileged(r1);
            }
        }
    }

    LinuxDisplay() {
        LinuxEvent linuxEvent;
        LinuxEvent linuxEvent2;
        FocusListener focusListener;
        LinuxEvent linuxEvent3 = linuxEvent;
        LinuxEvent linuxEvent4 = new LinuxEvent();
        this.event_buffer = linuxEvent3;
        LinuxEvent linuxEvent5 = linuxEvent2;
        LinuxEvent linuxEvent6 = new LinuxEvent();
        this.tmp_event_buffer = linuxEvent5;
        FocusListener focusListener2 = focusListener;
        FocusListener r3 = new FocusListener(this) {
            final /* synthetic */ LinuxDisplay this$0;

            {
                this.this$0 = r5;
            }

            public void focusGained(FocusEvent focusEvent) {
                FocusEvent focusEvent2 = focusEvent;
                Object obj = GlobalLock.lock;
                synchronized (obj) {
                    try {
                        boolean access$002 = LinuxDisplay.access$002(this.this$0, true);
                        boolean access$102 = LinuxDisplay.access$102(this.this$0, true);
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj2 = obj;
                        throw th2;
                    }
                }
            }

            public void focusLost(FocusEvent focusEvent) {
                FocusEvent focusEvent2 = focusEvent;
                Object obj = GlobalLock.lock;
                synchronized (obj) {
                    try {
                        boolean access$002 = LinuxDisplay.access$002(this.this$0, false);
                        boolean access$102 = LinuxDisplay.access$102(this.this$0, true);
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj2 = obj;
                        throw th2;
                    }
                }
            }
        };
        this.focus_listener = focusListener2;
    }

    static /* synthetic */ boolean access$002(LinuxDisplay linuxDisplay, boolean z) {
        boolean z2 = z;
        linuxDisplay.parent_focused = z2;
        return z2;
    }

    static /* synthetic */ boolean access$102(LinuxDisplay linuxDisplay, boolean z) {
        boolean z2 = z;
        linuxDisplay.parent_focus_changed = z2;
        return z2;
    }

    private void acquireInput() {
        StringBuilder sb;
        if (!isLegacyFullscreen() && this.input_released) {
            this.input_released = false;
            updateInputGrab();
            if (current_window_mode == 2) {
                try {
                    switchDisplayModeOnTmpDisplay(this.current_mode);
                    setGammaRampOnTmpDisplay(this.current_gamma);
                } catch (LWJGLException e) {
                    LWJGLException lWJGLException = e;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    LWJGLUtil.log(sb2.append("Failed to restore mode: ").append(lWJGLException.getMessage()).toString());
                }
            }
        }
    }

    private static native int callErrorHandler(long j, long j2, long j3);

    private void checkInput() {
        if (this.parent != null) {
            if (xembedded) {
                if (this.last_window_focus != 0 || this.parent_focused != this.focused) {
                    if (!isParentWindowActive(0)) {
                        this.last_window_focus = 0;
                        this.focused = false;
                    } else if (this.parent_focused) {
                        nSetInputFocus(getDisplay(), current_window, 0);
                        this.last_window_focus = current_window;
                        this.focused = true;
                    } else {
                        nSetInputFocus(getDisplay(), this.parent_proxy_focus_window, 0);
                        this.last_window_focus = this.parent_proxy_focus_window;
                        this.focused = false;
                    }
                }
            } else if (this.parent_focus_changed && this.parent_focused) {
                setInputFocusUnsafe(getWindow());
                this.parent_focus_changed = false;
            }
        }
    }

    static native void closeDisplay(long j);

    private static ByteBuffer convertIcon(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int i3 = i;
        int i4 = i2;
        ByteBuffer createByteBuffer = BufferUtils.createByteBuffer(byteBuffer2.capacity());
        for (int i5 = 0; i5 < i4; i5++) {
            for (int i6 = 0; i6 < i3; i6++) {
                byte b = byteBuffer2.get((i6 * 4) + (4 * i5 * i3));
                byte b2 = byteBuffer2.get(1 + (i6 * 4) + (4 * i5 * i3));
                ByteBuffer put = createByteBuffer.put((i6 * 4) + (4 * i5 * i3), byteBuffer2.get(2 + (i6 * 4) + (4 * i5 * i3)));
                ByteBuffer put2 = createByteBuffer.put(1 + (i6 * 4) + (4 * i5 * i3), b2);
                ByteBuffer put3 = createByteBuffer.put(2 + (i6 * 4) + (4 * i5 * i3), b);
            }
        }
        return createByteBuffer;
    }

    private static ByteBuffer convertIconMask(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int i3 = i;
        int i4 = i2;
        ByteBuffer createByteBuffer = BufferUtils.createByteBuffer((byteBuffer2.capacity() / 4) / 8);
        for (int i5 = 0; i5 < i4; i5++) {
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = i6 + (i5 * i3);
                int i8 = i7 / 8;
                ByteBuffer put = createByteBuffer.put(i8, (byte) (255 & (createByteBuffer.get(i8) | (((byteBuffer2.get(3 + ((i6 * 4) + (4 * (i5 * i3)))) & 255) >= Byte.MAX_VALUE ? 1 : 0) << (i7 % 8)))));
            }
        }
        return createByteBuffer;
    }

    private static ByteBuffer convertToNativeRamp(FloatBuffer floatBuffer) throws LWJGLException {
        FloatBuffer floatBuffer2 = floatBuffer;
        return nConvertToNativeRamp(floatBuffer2, floatBuffer2.position(), floatBuffer2.remaining());
    }

    private static long createBlankCursor() {
        return nCreateBlankCursor(getDisplay(), getWindow());
    }

    static void decDisplay() {
    }

    private void doSetGamma(ByteBuffer byteBuffer) throws LWJGLException {
        ByteBuffer byteBuffer2 = byteBuffer;
        lockAWT();
        try {
            setGammaRampOnTmpDisplay(byteBuffer2);
            this.current_gamma = byteBuffer2;
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    private static int getBestDisplayModeExtension() {
        if (isXrandrSupported()) {
            LWJGLUtil.log("Using Xrandr for display mode switching");
            return 10;
        } else if (isXF86VidModeSupported()) {
            LWJGLUtil.log("Using XF86VidMode for display mode switching");
            return 11;
        } else {
            LWJGLUtil.log("No display mode extensions available");
            return 12;
        }
    }

    private static native int getChildCount(long j, long j2) throws LWJGLException;

    private static ByteBuffer getCurrentGammaRamp() throws LWJGLException {
        ByteBuffer byteBuffer;
        lockAWT();
        try {
            incDisplay();
            if (isXF86VidModeSupported()) {
                th = nGetCurrentGammaRamp(getDisplay(), getDefaultScreen());
                decDisplay();
                unlockAWT();
                return byteBuffer;
            }
            decDisplay();
            unlockAWT();
            return null;
        } catch (Throwable th) {
            th = th;
            unlockAWT();
            throw th;
        } finally {
            byteBuffer = th;
            decDisplay();
            Throwable th2 = byteBuffer;
        }
    }

    private static DisplayMode getCurrentXRandrMode() throws LWJGLException {
        DisplayMode displayMode;
        lockAWT();
        try {
            incDisplay();
            th = nGetCurrentXRandrMode(getDisplay(), getDefaultScreen());
            decDisplay();
            unlockAWT();
            return displayMode;
        } catch (Throwable th) {
            th = th;
            unlockAWT();
            throw th;
        } finally {
            displayMode = th;
            decDisplay();
            Throwable th2 = displayMode;
        }
    }

    private static long getCursorHandle(Object obj) {
        Object obj2 = obj;
        if (obj2 != null) {
            return ((Long) obj2).longValue();
        }
        return 0;
    }

    static int getDefaultScreen() {
        return nGetDefaultScreen(getDisplay());
    }

    static long getDisplay() {
        InternalError internalError;
        StringBuilder sb;
        if (display_connection_usage_count > 0) {
            return display;
        }
        InternalError internalError2 = internalError;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        InternalError internalError3 = new InternalError(sb2.append("display_connection_usage_count = ").append(display_connection_usage_count).toString());
        throw internalError2;
    }

    private static native String getErrorText(long j, long j2);

    /* JADX INFO: finally extract failed */
    private static long getHandle(Canvas canvas) throws LWJGLException {
        LinuxPeerInfo linuxPeerInfo = (LinuxPeerInfo) AWTGLCanvas.createImplementation().createPeerInfo(canvas, null, null);
        ByteBuffer lockAndGetHandle = linuxPeerInfo.lockAndGetHandle();
        try {
            long drawable = linuxPeerInfo.getDrawable();
            linuxPeerInfo.unlock();
            return drawable;
        } catch (Throwable th) {
            Throwable th2 = th;
            linuxPeerInfo.unlock();
            throw th2;
        }
    }

    private static native long getParentWindow(long j, long j2) throws LWJGLException;

    private static native long getRootWindow(long j, int i);

    static long getWindow() {
        return current_window;
    }

    private int getWindowMode(boolean z) throws LWJGLException {
        if (!z) {
            return 3;
        }
        if (this.current_displaymode_extension != 10 || !isNetWMFullscreenSupported()) {
            LWJGLUtil.log("Using legacy mode for fullscreen window");
            return 1;
        }
        LWJGLUtil.log("Using NetWM for fullscreen window");
        return 2;
    }

    private static int globalErrorHandler(long j, long j2, long j3, long j4, long j5, long j6, long j7) throws LWJGLException {
        LWJGLException lWJGLException;
        StringBuilder sb;
        long j8 = j;
        long j9 = j2;
        long j10 = j3;
        long j11 = j4;
        long j12 = j5;
        long j13 = j6;
        long j14 = j7;
        if (xembedded && j13 == 42) {
            return 0;
        }
        if (j8 == getDisplay()) {
            String errorText = getErrorText(j8, j12);
            LWJGLException lWJGLException2 = lWJGLException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLException lWJGLException3 = new LWJGLException(sb2.append("X Error - disp: 0x").append(Long.toHexString(j10)).append(" serial: ").append(j11).append(" error: ").append(errorText).append(" request_code: ").append(j13).append(" minor_code: ").append(j14).toString());
            throw lWJGLException2;
        } else if (saved_error_handler != 0) {
            return callErrorHandler(saved_error_handler, j8, j9);
        } else {
            return 0;
        }
    }

    private void grabKeyboard() {
        if (!this.keyboard_grabbed && nGrabKeyboard(getDisplay(), getWindow()) == 0) {
            this.keyboard_grabbed = true;
        }
    }

    private void grabPointer() {
        if (!this.pointer_grabbed && nGrabPointer(getDisplay(), getWindow(), 0) == 0) {
            this.pointer_grabbed = true;
            if (isLegacyFullscreen()) {
                nSetViewPort(getDisplay(), getWindow(), getDefaultScreen());
            }
        }
    }

    private static native boolean hasProperty(long j, long j2, long j3);

    static void incDisplay() throws LWJGLException {
        if (display_connection_usage_count == 0) {
            try {
                GLContext.loadOpenGLLibrary();
                GLContext.loadOpenGLLibrary();
            } catch (Throwable th) {
                Throwable th2 = th;
            }
            saved_error_handler = setErrorHandler();
            display = openDisplay();
        }
        display_connection_usage_count = 1 + display_connection_usage_count;
    }

    /* JADX INFO: finally extract failed */
    private static long internAtom(String str, boolean z) throws LWJGLException {
        String str2 = str;
        boolean z2 = z;
        incDisplay();
        try {
            long nInternAtom = nInternAtom(getDisplay(), str2, z2);
            decDisplay();
            return nInternAtom;
        } catch (Throwable th) {
            Throwable th2 = th;
            decDisplay();
            throw th2;
        }
    }

    private static boolean isAncestorXEmbedded(long j) throws LWJGLException {
        long j2 = j;
        long internAtom = internAtom("_XEMBED_INFO", true);
        if (internAtom != 0) {
            long j3 = j2;
            while (true) {
                long j4 = j3;
                if (j4 == 0) {
                    break;
                } else if (hasProperty(getDisplay(), j4, internAtom)) {
                    return true;
                } else {
                    j3 = getParentWindow(getDisplay(), j4);
                }
            }
        }
        return false;
    }

    private static boolean isFullscreen() {
        return current_window_mode == 1 || current_window_mode == 2;
    }

    private static boolean isLegacyFullscreen() {
        return current_window_mode == 1;
    }

    private static boolean isNetWMFullscreenSupported() throws LWJGLException {
        boolean z;
        StringBuilder sb;
        if (Display.getPrivilegedBoolean("LWJGL_DISABLE_NETWM")) {
            return false;
        }
        lockAWT();
        try {
            incDisplay();
            th = nIsNetWMFullscreenSupported(getDisplay(), getDefaultScreen());
            decDisplay();
            unlockAWT();
            return z;
        } catch (LWJGLException th) {
            try {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Got exception while querying NetWM support: ").append(z).toString());
                unlockAWT();
                return false;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                unlockAWT();
                throw th3;
            }
        } finally {
            z = th;
            decDisplay();
            Throwable th4 = z;
        }
    }

    private boolean isParentWindowActive(long j) {
        StringBuilder sb;
        long j2 = j;
        try {
            if (j2 == current_window) {
                return true;
            }
            if (getChildCount(getDisplay(), j2) != 0) {
                return false;
            }
            long parentWindow = getParentWindow(getDisplay(), j2);
            if (parentWindow == 0) {
                return false;
            }
            long j3 = current_window;
            while (j3 != 0) {
                j3 = getParentWindow(getDisplay(), j3);
                if (j3 == parentWindow) {
                    this.parent_proxy_focus_window = j2;
                    return true;
                }
            }
            return false;
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Failed to detect if parent window is active: ").append(lWJGLException.getMessage()).toString());
            return true;
        }
    }

    private static boolean isXF86VidModeSupported() {
        boolean z;
        StringBuilder sb;
        lockAWT();
        try {
            incDisplay();
            th = nIsXF86VidModeSupported(getDisplay());
            decDisplay();
            unlockAWT();
            return z;
        } catch (LWJGLException th) {
            try {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Got exception while querying XF86VM support: ").append(z).toString());
                unlockAWT();
                return false;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                unlockAWT();
                throw th3;
            }
        } finally {
            z = th;
            decDisplay();
            Throwable th4 = z;
        }
    }

    private static boolean isXrandrSupported() {
        boolean z;
        StringBuilder sb;
        if (Display.getPrivilegedBoolean("LWJGL_DISABLE_XRANDR")) {
            return false;
        }
        lockAWT();
        try {
            incDisplay();
            th = nIsXrandrSupported(getDisplay());
            decDisplay();
            unlockAWT();
            return z;
        } catch (LWJGLException th) {
            try {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Got exception while querying Xrandr support: ").append(z).toString());
                unlockAWT();
                return false;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                unlockAWT();
                throw th3;
            }
        } finally {
            z = th;
            decDisplay();
            Throwable th4 = z;
        }
    }

    static void lockAWT() {
        StringBuilder sb;
        try {
            nLockAWT();
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Caught exception while locking AWT: ").append(lWJGLException).toString());
        }
    }

    private static native void mapRaised(long j, long j2);

    private static native ByteBuffer nConvertToNativeRamp(FloatBuffer floatBuffer, int i, int i2) throws LWJGLException;

    static native long nCreateBlankCursor(long j, long j2);

    private static native long nCreateCursor(long j, int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, int i6, IntBuffer intBuffer2, int i7) throws LWJGLException;

    private static native long nCreateWindow(long j, int i, ByteBuffer byteBuffer, DisplayMode displayMode, int i2, int i3, int i4, boolean z, long j2, boolean z2) throws LWJGLException;

    private static native void nDefineCursor(long j, long j2, long j3);

    static native void nDestroyCursor(long j, long j2);

    static native void nDestroyWindow(long j, long j2);

    private static native DisplayMode[] nGetAvailableDisplayModes(long j, int i, int i2) throws LWJGLException;

    private static native ByteBuffer nGetCurrentGammaRamp(long j, int i) throws LWJGLException;

    private static native DisplayMode nGetCurrentXRandrMode(long j, int i) throws LWJGLException;

    static native int nGetDefaultScreen(long j);

    private static native int nGetGammaRampLength(long j, int i) throws LWJGLException;

    private static native int nGetHeight(long j, long j2);

    private static native long nGetInputFocus(long j) throws LWJGLException;

    private static native int nGetMaxCursorSize(long j, long j2);

    private static native int nGetMinCursorSize(long j, long j2);

    private static native int nGetNativeCursorCapabilities(long j) throws LWJGLException;

    private static native int nGetPbufferCapabilities(long j, int i);

    private static native int nGetWidth(long j, long j2);

    private static native int nGetX(long j, long j2);

    private static native int nGetY(long j, long j2);

    static native int nGrabKeyboard(long j, long j2);

    static native int nGrabPointer(long j, long j2, long j3);

    private static native void nIconifyWindow(long j, long j2, int i);

    static native long nInternAtom(long j, String str, boolean z);

    private static native boolean nIsNetWMFullscreenSupported(long j, int i) throws LWJGLException;

    private static native boolean nIsXF86VidModeSupported(long j) throws LWJGLException;

    private static native boolean nIsXrandrSupported(long j) throws LWJGLException;

    private static native void nLockAWT() throws LWJGLException;

    private static native void nReshape(long j, long j2, int i, int i2, int i3, int i4);

    private static native void nSetGammaRamp(long j, int i, ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nSetInputFocus(long j, long j2, long j3);

    private static native void nSetTitle(long j, long j2, long j3, int i);

    private static native void nSetViewPort(long j, long j2, int i);

    private static native void nSetWindowIcon(long j, long j2, ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, int i3, int i4);

    private static native void nSetWindowSize(long j, long j2, int i, int i2, boolean z);

    private static native void nSwitchDisplayMode(long j, int i, int i2, DisplayMode displayMode) throws LWJGLException;

    private static native void nSync(long j, boolean z) throws LWJGLException;

    static native int nUngrabKeyboard(long j);

    static native int nUngrabPointer(long j);

    private static native void nUnlockAWT() throws LWJGLException;

    static native long openDisplay() throws LWJGLException;

    private void processEvents() {
        while (LinuxEvent.getPending(getDisplay()) > 0) {
            this.event_buffer.nextEvent(getDisplay());
            long window = this.event_buffer.getWindow();
            relayEventToParent(this.event_buffer);
            if (window == getWindow() && !this.event_buffer.filterEvent(window)) {
                if ((this.mouse == null || !this.mouse.filterEvent(this.grab, shouldWarpPointer(), this.event_buffer)) && (this.keyboard == null || !this.keyboard.filterEvent(this.event_buffer))) {
                    switch (this.event_buffer.getType()) {
                        case 7:
                            this.mouseInside = true;
                            break;
                        case 8:
                            this.mouseInside = false;
                            break;
                        case 9:
                            setFocused(true, this.event_buffer.getFocusDetail());
                            break;
                        case 10:
                            setFocused(false, this.event_buffer.getFocusDetail());
                            break;
                        case 12:
                            this.dirty = true;
                            break;
                        case 18:
                            this.dirty = true;
                            this.minimized = true;
                            break;
                        case 19:
                            this.dirty = true;
                            this.minimized = false;
                            break;
                        case 22:
                            int nGetX = nGetX(getDisplay(), getWindow());
                            int nGetY = nGetY(getDisplay(), getWindow());
                            int nGetWidth = nGetWidth(getDisplay(), getWindow());
                            int nGetHeight = nGetHeight(getDisplay(), getWindow());
                            this.window_x = nGetX;
                            this.window_y = nGetY;
                            if (this.window_width != nGetWidth || this.window_height != nGetHeight) {
                                this.resized = true;
                                this.window_width = nGetWidth;
                                this.window_height = nGetHeight;
                                break;
                            } else {
                                break;
                            }
                        case 33:
                            if (this.event_buffer.getClientFormat() == 32 && ((long) this.event_buffer.getClientData(0)) == this.delete_atom) {
                                this.close_requested = true;
                                break;
                            }
                    }
                }
            }
        }
    }

    private void relayEventToParent(LinuxEvent linuxEvent) {
        LinuxEvent linuxEvent2 = linuxEvent;
        if (this.parent != null) {
            switch (linuxEvent2.getType()) {
                case 2:
                    relayEventToParent(linuxEvent2, 1);
                    return;
                case 3:
                    relayEventToParent(linuxEvent2, 1);
                    return;
                case 4:
                    if (xembedded || !this.focused) {
                        relayEventToParent(linuxEvent2, 1);
                        return;
                    }
                    return;
                case 5:
                    if (xembedded || !this.focused) {
                        relayEventToParent(linuxEvent2, 1);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void relayEventToParent(LinuxEvent linuxEvent, int i) {
        int i2 = i;
        this.tmp_event_buffer.copyFrom(linuxEvent);
        this.tmp_event_buffer.setWindow(this.parent_window);
        this.tmp_event_buffer.sendEvent(getDisplay(), this.parent_window, true, (long) i2);
    }

    private void releaseInput() {
        StringBuilder sb;
        C07984 r7;
        if (!isLegacyFullscreen() && !this.input_released) {
            this.input_released = true;
            updateInputGrab();
            if (current_window_mode == 2) {
                nIconifyWindow(getDisplay(), getWindow(), getDefaultScreen());
                try {
                    if (this.current_displaymode_extension != 10 || this.savedXrandrConfig.length <= 0) {
                        switchDisplayModeOnTmpDisplay(this.saved_mode);
                    } else {
                        C07984 r2 = r7;
                        C07984 r3 = new PrivilegedAction<Object>(this) {
                            final /* synthetic */ LinuxDisplay this$0;

                            {
                                this.this$0 = r5;
                            }

                            public Object run() {
                                XRandR.setConfiguration(this.this$0.savedXrandrConfig);
                                return null;
                            }
                        };
                        Object doPrivileged = AccessController.doPrivileged(r2);
                    }
                    setGammaRampOnTmpDisplay(this.saved_gamma);
                } catch (LWJGLException e) {
                    LWJGLException lWJGLException = e;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    LWJGLUtil.log(sb2.append("Failed to restore saved mode: ").append(lWJGLException.getMessage()).toString());
                }
            }
        }
    }

    private static native void reparentWindow(long j, long j2, long j3, int i, int i2);

    private static native long resetErrorHandler(long j);

    private static native long setErrorHandler();

    private void setFocused(boolean z, int i) {
        boolean z2 = z;
        int i2 = i;
        if (this.focused != z2 && i2 != 7 && i2 != 5 && i2 != 6 && !xembedded) {
            this.focused = z2;
            if (this.focused) {
                acquireInput();
            } else {
                releaseInput();
            }
        }
    }

    private static void setGammaRampOnTmpDisplay(ByteBuffer byteBuffer) throws LWJGLException {
        ByteBuffer byteBuffer2 = byteBuffer;
        incDisplay();
        try {
            nSetGammaRamp(getDisplay(), getDefaultScreen(), byteBuffer2);
            decDisplay();
        } catch (Throwable th) {
            Throwable th2 = th;
            decDisplay();
            throw th2;
        }
    }

    private void setInputFocusUnsafe(long j) {
        StringBuilder sb;
        try {
            nSetInputFocus(getDisplay(), j, 0);
            nSync(getDisplay(), false);
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Got exception while trying to focus: ").append(lWJGLException).toString());
        }
    }

    private boolean shouldGrab() {
        return !this.input_released && this.grab && this.mouse != null;
    }

    private boolean shouldWarpPointer() {
        return this.pointer_grabbed && shouldGrab();
    }

    private void switchDisplayModeOnTmpDisplay(DisplayMode displayMode) throws LWJGLException {
        DisplayMode displayMode2 = displayMode;
        incDisplay();
        try {
            nSwitchDisplayMode(getDisplay(), getDefaultScreen(), this.current_displaymode_extension, displayMode2);
            decDisplay();
        } catch (Throwable th) {
            Throwable th2 = th;
            decDisplay();
            throw th2;
        }
    }

    private static native void synchronize(long j, boolean z);

    private void ungrabKeyboard() {
        if (this.keyboard_grabbed) {
            int nUngrabKeyboard = nUngrabKeyboard(getDisplay());
            this.keyboard_grabbed = false;
        }
    }

    private void ungrabPointer() {
        if (this.pointer_grabbed) {
            this.pointer_grabbed = false;
            int nUngrabPointer = nUngrabPointer(getDisplay());
        }
    }

    static void unlockAWT() {
        StringBuilder sb;
        try {
            nUnlockAWT();
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Caught exception while unlocking AWT: ").append(lWJGLException).toString());
        }
    }

    private void updateCursor() {
        nDefineCursor(getDisplay(), getWindow(), shouldGrab() ? this.blank_cursor : this.current_cursor);
    }

    private void updateInputGrab() {
        updatePointerGrab();
        updateKeyboardGrab();
    }

    private void updateKeyboardGrab() {
        if (isLegacyFullscreen()) {
            grabKeyboard();
        } else {
            ungrabKeyboard();
        }
    }

    private void updatePointerGrab() {
        if (isFullscreen() || shouldGrab()) {
            grabPointer();
        } else {
            ungrabPointer();
        }
        updateCursor();
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
        lockAWT();
        try {
            incDisplay();
            Long valueOf = Long.valueOf(nCreateCursor(getDisplay(), i6, i7, i8, i9, i10, intBuffer3, intBuffer3.position(), intBuffer4, intBuffer4 != null ? intBuffer4.position() : -1));
            unlockAWT();
            return valueOf;
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            decDisplay();
            throw lWJGLException;
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public void createKeyboard() throws LWJGLException {
        LinuxKeyboard linuxKeyboard;
        lockAWT();
        try {
            LinuxKeyboard linuxKeyboard2 = linuxKeyboard;
            LinuxKeyboard linuxKeyboard3 = new LinuxKeyboard(getDisplay(), getWindow());
            this.keyboard = linuxKeyboard2;
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public void createMouse() throws LWJGLException {
        LinuxMouse linuxMouse;
        lockAWT();
        try {
            LinuxMouse linuxMouse2 = linuxMouse;
            LinuxMouse linuxMouse3 = new LinuxMouse(getDisplay(), getWindow(), getWindow());
            this.mouse = linuxMouse2;
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
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
        LinuxDisplayPeerInfo linuxDisplayPeerInfo;
        ContextAttribs contextAttribs2 = contextAttribs;
        LinuxDisplayPeerInfo linuxDisplayPeerInfo2 = linuxDisplayPeerInfo;
        LinuxDisplayPeerInfo linuxDisplayPeerInfo3 = new LinuxDisplayPeerInfo(pixelFormat);
        this.peer_info = linuxDisplayPeerInfo2;
        return this.peer_info;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0199 A[Catch:{ all -> 0x0208, LWJGLException -> 0x0219 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01b4 A[Catch:{ all -> 0x0208, LWJGLException -> 0x0219 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void createWindow(org.lwjgl.opengl.DrawableLWJGL r33, org.lwjgl.opengl.DisplayMode r34, java.awt.Canvas r35, int r36, int r37) throws org.lwjgl.LWJGLException {
        /*
            r32 = this;
            r3 = r32
            r4 = r33
            r5 = r34
            r6 = r35
            r7 = r36
            r8 = r37
            lockAWT()
            incDisplay()     // Catch:{ all -> 0x0222 }
            r19 = r4
            r0 = r19
            boolean r0 = r0 instanceof org.lwjgl.opengl.DrawableGLES     // Catch:{ LWJGLException -> 0x0219 }
            r19 = r0
            if (r19 == 0) goto L_0x002f
            r19 = r3
            org.lwjgl.opengl.LinuxDisplayPeerInfo r20 = new org.lwjgl.opengl.LinuxDisplayPeerInfo     // Catch:{ LWJGLException -> 0x0219 }
            r31 = r20
            r20 = r31
            r21 = r31
            r21.<init>()     // Catch:{ LWJGLException -> 0x0219 }
            r0 = r20
            r1 = r19
            r1.peer_info = r0     // Catch:{ LWJGLException -> 0x0219 }
        L_0x002f:
            r19 = r3
            r0 = r19
            org.lwjgl.opengl.PeerInfo r0 = r0.peer_info     // Catch:{ LWJGLException -> 0x0219 }
            r19 = r0
            java.nio.ByteBuffer r19 = r19.lockAndGetHandle()     // Catch:{ LWJGLException -> 0x0219 }
            r11 = r19
            r19 = r3
            boolean r20 = org.lwjgl.opengl.Display.isFullscreen()     // Catch:{ all -> 0x0208 }
            int r19 = r19.getWindowMode(r20)     // Catch:{ all -> 0x0208 }
            current_window_mode = r19     // Catch:{ all -> 0x0208 }
            int r19 = current_window_mode     // Catch:{ all -> 0x0208 }
            r20 = 3
            r0 = r19
            r1 = r20
            if (r0 == r1) goto L_0x0058
            r19 = 1
            org.lwjgl.opengl.LinuxDisplay.Compiz.setLegacyFullscreenSupport(r19)     // Catch:{ all -> 0x0208 }
        L_0x0058:
            java.lang.String r19 = "org.lwjgl.opengl.Window.undecorated"
            boolean r19 = org.lwjgl.opengl.Display.getPrivilegedBoolean(r19)     // Catch:{ all -> 0x0208 }
            if (r19 != 0) goto L_0x0072
            int r19 = current_window_mode     // Catch:{ all -> 0x0208 }
            r20 = 3
            r0 = r19
            r1 = r20
            if (r0 == r1) goto L_0x01e8
            java.lang.String r19 = "org.lwjgl.opengl.Window.undecorated_fs"
            boolean r19 = org.lwjgl.opengl.Display.getPrivilegedBoolean(r19)     // Catch:{ all -> 0x0208 }
            if (r19 == 0) goto L_0x01e8
        L_0x0072:
            r19 = 1
            r13 = r19
        L_0x0076:
            r19 = r3
            r20 = r6
            r0 = r20
            r1 = r19
            r1.parent = r0     // Catch:{ all -> 0x0208 }
            r19 = r6
            if (r19 == 0) goto L_0x01ee
            r19 = r6
            long r19 = getHandle(r19)     // Catch:{ all -> 0x0208 }
            r14 = r19
        L_0x008c:
            r19 = r3
            r20 = r14
            r0 = r20
            r2 = r19
            r2.parent_window = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            boolean r20 = org.lwjgl.opengl.Display.isResizable()     // Catch:{ all -> 0x0208 }
            r0 = r20
            r1 = r19
            r1.resizable = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = 0
            r0 = r20
            r1 = r19
            r1.resized = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = r7
            r0 = r20
            r1 = r19
            r1.window_x = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = r8
            r0 = r20
            r1 = r19
            r1.window_y = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = r5
            int r20 = r20.getWidth()     // Catch:{ all -> 0x0208 }
            r0 = r20
            r1 = r19
            r1.window_width = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = r5
            int r20 = r20.getHeight()     // Catch:{ all -> 0x0208 }
            r0 = r20
            r1 = r19
            r1.window_height = r0     // Catch:{ all -> 0x0208 }
            long r19 = getDisplay()     // Catch:{ all -> 0x0208 }
            int r21 = getDefaultScreen()     // Catch:{ all -> 0x0208 }
            r22 = r11
            r23 = r5
            int r24 = current_window_mode     // Catch:{ all -> 0x0208 }
            r25 = r7
            r26 = r8
            r27 = r13
            r28 = r3
            r0 = r28
            long r0 = r0.parent_window     // Catch:{ all -> 0x0208 }
            r28 = r0
            r30 = r3
            r0 = r30
            boolean r0 = r0.resizable     // Catch:{ all -> 0x0208 }
            r30 = r0
            long r19 = nCreateWindow(r19, r21, r22, r23, r24, r25, r26, r27, r28, r30)     // Catch:{ all -> 0x0208 }
            current_window = r19     // Catch:{ all -> 0x0208 }
            long r19 = getDisplay()     // Catch:{ all -> 0x0208 }
            long r21 = current_window     // Catch:{ all -> 0x0208 }
            mapRaised(r19, r21)     // Catch:{ all -> 0x0208 }
            r19 = r6
            if (r19 == 0) goto L_0x0202
            r19 = r3
            r0 = r19
            long r0 = r0.parent_window     // Catch:{ all -> 0x0208 }
            r19 = r0
            boolean r19 = isAncestorXEmbedded(r19)     // Catch:{ all -> 0x0208 }
            if (r19 == 0) goto L_0x0202
            r19 = 1
            r16 = r19
        L_0x0125:
            r19 = r16
            xembedded = r19     // Catch:{ all -> 0x0208 }
            r19 = r3
            long r20 = createBlankCursor()     // Catch:{ all -> 0x0208 }
            r0 = r20
            r2 = r19
            r2.blank_cursor = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = 0
            r0 = r20
            r2 = r19
            r2.current_cursor = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = 0
            r0 = r20
            r1 = r19
            r1.focused = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = 0
            r0 = r20
            r1 = r19
            r1.input_released = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = 0
            r0 = r20
            r1 = r19
            r1.pointer_grabbed = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = 0
            r0 = r20
            r1 = r19
            r1.keyboard_grabbed = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = 0
            r0 = r20
            r1 = r19
            r1.close_requested = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = 0
            r0 = r20
            r1 = r19
            r1.grab = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = 0
            r0 = r20
            r1 = r19
            r1.minimized = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = 1
            r0 = r20
            r1 = r19
            r1.dirty = r0     // Catch:{ all -> 0x0208 }
            r19 = r4
            r0 = r19
            boolean r0 = r0 instanceof org.lwjgl.opengl.DrawableGLES     // Catch:{ all -> 0x0208 }
            r19 = r0
            if (r19 == 0) goto L_0x01b0
            r19 = r4
            org.lwjgl.opengl.DrawableGLES r19 = (org.lwjgl.opengl.DrawableGLES) r19     // Catch:{ all -> 0x0208 }
            long r20 = current_window     // Catch:{ all -> 0x0208 }
            long r22 = getDisplay()     // Catch:{ all -> 0x0208 }
            r24 = 4
            r25 = r4
            org.lwjgl.opengl.PixelFormatLWJGL r25 = r25.getPixelFormat()     // Catch:{ all -> 0x0208 }
            org.lwjgl.opengles.PixelFormat r25 = (org.lwjgl.opengles.PixelFormat) r25     // Catch:{ all -> 0x0208 }
            r19.initialize(r20, r22, r24, r25)     // Catch:{ all -> 0x0208 }
        L_0x01b0:
            r19 = r6
            if (r19 == 0) goto L_0x01d9
            r19 = r6
            r20 = r3
            r0 = r20
            java.awt.event.FocusListener r0 = r0.focus_listener     // Catch:{ all -> 0x0208 }
            r20 = r0
            r19.addFocusListener(r20)     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = r6
            boolean r20 = r20.isFocusOwner()     // Catch:{ all -> 0x0208 }
            r0 = r20
            r1 = r19
            r1.parent_focused = r0     // Catch:{ all -> 0x0208 }
            r19 = r3
            r20 = 1
            r0 = r20
            r1 = r19
            r1.parent_focus_changed = r0     // Catch:{ all -> 0x0208 }
        L_0x01d9:
            r19 = r3
            r0 = r19
            org.lwjgl.opengl.PeerInfo r0 = r0.peer_info     // Catch:{ LWJGLException -> 0x0219 }
            r19 = r0
            r19.unlock()     // Catch:{ LWJGLException -> 0x0219 }
            unlockAWT()
            return
        L_0x01e8:
            r19 = 0
            r13 = r19
            goto L_0x0076
        L_0x01ee:
            long r19 = getDisplay()     // Catch:{ all -> 0x0208 }
            int r21 = getDefaultScreen()     // Catch:{ all -> 0x0208 }
            long r19 = getRootWindow(r19, r21)     // Catch:{ all -> 0x0208 }
            r17 = r19
            r19 = r17
            r14 = r19
            goto L_0x008c
        L_0x0202:
            r19 = 0
            r16 = r19
            goto L_0x0125
        L_0x0208:
            r19 = move-exception
            r12 = r19
            r19 = r3
            r0 = r19
            org.lwjgl.opengl.PeerInfo r0 = r0.peer_info     // Catch:{ LWJGLException -> 0x0219 }
            r19 = r0
            r19.unlock()     // Catch:{ LWJGLException -> 0x0219 }
            r19 = r12
            throw r19     // Catch:{ LWJGLException -> 0x0219 }
        L_0x0219:
            r19 = move-exception
            r10 = r19
            decDisplay()     // Catch:{ all -> 0x0222 }
            r19 = r10
            throw r19     // Catch:{ all -> 0x0222 }
        L_0x0222:
            r19 = move-exception
            r9 = r19
            unlockAWT()
            r19 = r9
            throw r19
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.LinuxDisplay.createWindow(org.lwjgl.opengl.DrawableLWJGL, org.lwjgl.opengl.DisplayMode, java.awt.Canvas, int, int):void");
    }

    public void destroyCursor(Object obj) {
        Object obj2 = obj;
        lockAWT();
        try {
            nDestroyCursor(getDisplay(), getCursorHandle(obj2));
            decDisplay();
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public void destroyKeyboard() {
        lockAWT();
        try {
            this.keyboard.destroy(getDisplay());
            this.keyboard = null;
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public void destroyMouse() {
        this.mouse = null;
        updateInputGrab();
    }

    public void destroyWindow() {
        StringBuilder sb;
        lockAWT();
        try {
            if (this.parent != null) {
                this.parent.removeFocusListener(this.focus_listener);
            }
            setNativeCursor(null);
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Failed to reset cursor: ").append(lWJGLException.getMessage()).toString());
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
        nDestroyCursor(getDisplay(), this.blank_cursor);
        this.blank_cursor = 0;
        ungrabKeyboard();
        nDestroyWindow(getDisplay(), getWindow());
        decDisplay();
        if (current_window_mode != 3) {
            Compiz.setLegacyFullscreenSupport(false);
        }
        unlockAWT();
    }

    public String getAdapter() {
        return null;
    }

    public DisplayMode[] getAvailableDisplayModes() throws LWJGLException {
        DisplayMode[] displayModeArr;
        lockAWT();
        try {
            incDisplay();
            th = nGetAvailableDisplayModes(getDisplay(), getDefaultScreen(), this.current_displaymode_extension);
            decDisplay();
            unlockAWT();
            return displayModeArr;
        } catch (Throwable th) {
            th = th;
            unlockAWT();
            throw th;
        } finally {
            displayModeArr = th;
            decDisplay();
            Throwable th2 = displayModeArr;
        }
    }

    public int getButtonCount() {
        return this.mouse.getButtonCount();
    }

    public int getGammaRampLength() {
        StringBuilder sb;
        int i;
        StringBuilder sb2;
        if (!isXF86VidModeSupported()) {
            return 0;
        }
        lockAWT();
        try {
            incDisplay();
            try {
                e = nGetGammaRampLength(getDisplay(), getDefaultScreen());
                decDisplay();
                unlockAWT();
                return i;
            } catch (LWJGLException e) {
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                LWJGLUtil.log(sb3.append("Got exception while querying gamma length: ").append(i).toString());
                decDisplay();
                unlockAWT();
                return 0;
            } finally {
                i = e;
                decDisplay();
                Throwable th = i;
            }
        } catch (LWJGLException e2) {
            LWJGLException lWJGLException = e2;
            try {
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                LWJGLUtil.log(sb5.append("Failed to get gamma ramp length: ").append(lWJGLException).toString());
                unlockAWT();
                return 0;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                unlockAWT();
                throw th3;
            }
        }
    }

    public int getHeight() {
        return this.window_height;
    }

    public int getMaxCursorSize() {
        int i;
        StringBuilder sb;
        lockAWT();
        try {
            incDisplay();
            th = nGetMaxCursorSize(getDisplay(), getWindow());
            decDisplay();
            unlockAWT();
            return i;
        } catch (LWJGLException th) {
            try {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Exception occurred in getMaxCursorSize: ").append(i).toString());
                unlockAWT();
                return 0;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                unlockAWT();
                throw th3;
            }
        } finally {
            i = th;
            decDisplay();
            Throwable th4 = i;
        }
    }

    public int getMinCursorSize() {
        int i;
        StringBuilder sb;
        lockAWT();
        try {
            incDisplay();
            th = nGetMinCursorSize(getDisplay(), getWindow());
            decDisplay();
            unlockAWT();
            return i;
        } catch (LWJGLException th) {
            try {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Exception occurred in getMinCursorSize: ").append(i).toString());
                unlockAWT();
                return 0;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                unlockAWT();
                throw th3;
            }
        } finally {
            i = th;
            decDisplay();
            Throwable th4 = i;
        }
    }

    public int getNativeCursorCapabilities() {
        int i;
        RuntimeException runtimeException;
        lockAWT();
        try {
            incDisplay();
            th = nGetNativeCursorCapabilities(getDisplay());
            decDisplay();
            unlockAWT();
            return i;
        } catch (LWJGLException th) {
            try {
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException(i);
                throw runtimeException2;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                unlockAWT();
                throw th3;
            }
        } finally {
            i = th;
            decDisplay();
            Throwable th4 = i;
        }
    }

    public int getPbufferCapabilities() {
        int i;
        StringBuilder sb;
        lockAWT();
        try {
            incDisplay();
            th = nGetPbufferCapabilities(getDisplay(), getDefaultScreen());
            decDisplay();
            unlockAWT();
            return i;
        } catch (LWJGLException th) {
            try {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Exception occurred in getPbufferCapabilities: ").append(i).toString());
                unlockAWT();
                return 0;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                unlockAWT();
                throw th3;
            }
        } finally {
            i = th;
            decDisplay();
            Throwable th4 = i;
        }
    }

    public String getVersion() {
        return null;
    }

    public int getWidth() {
        return this.window_width;
    }

    public int getX() {
        return this.window_x;
    }

    public int getY() {
        return this.window_y;
    }

    public void grabMouse(boolean z) {
        boolean z2 = z;
        lockAWT();
        try {
            if (z2 != this.grab) {
                this.grab = z2;
                updateInputGrab();
                this.mouse.changeGrabbed(this.grab, shouldWarpPointer());
            }
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public boolean hasWheel() {
        return true;
    }

    /* JADX INFO: finally extract failed */
    public DisplayMode init() throws LWJGLException {
        LWJGLException lWJGLException;
        C07973 r8;
        LWJGLException lWJGLException2;
        StringBuilder sb;
        LWJGLException lWJGLException3;
        lockAWT();
        try {
            Compiz.init();
            this.delete_atom = internAtom("WM_DELETE_WINDOW", false);
            this.current_displaymode_extension = getBestDisplayModeExtension();
            if (this.current_displaymode_extension == 12) {
                LWJGLException lWJGLException4 = lWJGLException3;
                LWJGLException lWJGLException5 = new LWJGLException("No display mode extension is available");
                throw lWJGLException4;
            }
            DisplayMode[] availableDisplayModes = getAvailableDisplayModes();
            if (availableDisplayModes == null || availableDisplayModes.length == 0) {
                LWJGLException lWJGLException6 = lWJGLException;
                LWJGLException lWJGLException7 = new LWJGLException("No modes available");
                throw lWJGLException6;
            }
            switch (this.current_displaymode_extension) {
                case 10:
                    C07973 r5 = r8;
                    C07973 r6 = new PrivilegedAction<Screen[]>(this) {
                        final /* synthetic */ LinuxDisplay this$0;

                        {
                            this.this$0 = r5;
                        }

                        public Screen[] run() {
                            return XRandR.getConfiguration();
                        }
                    };
                    this.savedXrandrConfig = (Screen[]) AccessController.doPrivileged(r5);
                    this.saved_mode = getCurrentXRandrMode();
                    break;
                case 11:
                    this.saved_mode = availableDisplayModes[0];
                    break;
                default:
                    LWJGLException lWJGLException8 = lWJGLException2;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    LWJGLException lWJGLException9 = new LWJGLException(sb2.append("Unknown display mode extension: ").append(this.current_displaymode_extension).toString());
                    throw lWJGLException8;
            }
            this.current_mode = this.saved_mode;
            this.saved_gamma = getCurrentGammaRamp();
            this.current_gamma = this.saved_gamma;
            DisplayMode displayMode = this.saved_mode;
            unlockAWT();
            return displayMode;
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public boolean isActive() {
        return this.focused || isLegacyFullscreen();
    }

    public boolean isBufferLost(PeerInfo peerInfo) {
        PeerInfo peerInfo2 = peerInfo;
        return false;
    }

    public boolean isCloseRequested() {
        boolean z = this.close_requested;
        this.close_requested = false;
        return z;
    }

    public boolean isDirty() {
        boolean z = this.dirty;
        this.dirty = false;
        return z;
    }

    public boolean isInsideWindow() {
        return this.mouseInside;
    }

    public boolean isVisible() {
        return !this.minimized;
    }

    public void pollKeyboard(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        lockAWT();
        try {
            this.keyboard.poll(byteBuffer2);
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public void pollMouse(IntBuffer intBuffer, ByteBuffer byteBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        lockAWT();
        try {
            this.mouse.poll(this.grab, intBuffer2, byteBuffer2);
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public void readKeyboard(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        lockAWT();
        try {
            this.keyboard.read(byteBuffer2);
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public void readMouse(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        lockAWT();
        try {
            this.mouse.read(byteBuffer2);
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
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
        StringBuilder sb;
        C07962 r6;
        lockAWT();
        try {
            if (this.current_displaymode_extension != 10 || this.savedXrandrConfig.length <= 0) {
                switchDisplayMode(this.saved_mode);
            } else {
                C07962 r3 = r6;
                C07962 r4 = new PrivilegedAction<Object>(this) {
                    final /* synthetic */ LinuxDisplay this$0;

                    {
                        this.this$0 = r5;
                    }

                    public Object run() {
                        XRandR.setConfiguration(this.this$0.savedXrandrConfig);
                        return null;
                    }
                };
                Object doPrivileged = AccessController.doPrivileged(r3);
            }
            if (isXF86VidModeSupported()) {
                doSetGamma(this.saved_gamma);
            }
            Compiz.setLegacyFullscreenSupport(false);
            unlockAWT();
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Caught exception while resetting mode: ").append(lWJGLException).toString());
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public void reshape(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        lockAWT();
        try {
            nReshape(getDisplay(), getWindow(), i5, i6, i7, i8);
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public void setCursorPosition(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        lockAWT();
        try {
            this.mouse.setCursorPosition(i3, i4);
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public void setGammaRamp(FloatBuffer floatBuffer) throws LWJGLException {
        LWJGLException lWJGLException;
        FloatBuffer floatBuffer2 = floatBuffer;
        if (!isXF86VidModeSupported()) {
            LWJGLException lWJGLException2 = lWJGLException;
            LWJGLException lWJGLException3 = new LWJGLException("No gamma ramp support (Missing XF86VM extension)");
            throw lWJGLException2;
        }
        doSetGamma(convertToNativeRamp(floatBuffer2));
    }

    public int setIcon(ByteBuffer[] byteBufferArr) {
        int i;
        StringBuilder sb;
        th = byteBufferArr;
        lockAWT();
        try {
            incDisplay();
            th = th.length;
            for (int i2 = 0; i2 < th; i2++) {
                ByteBuffer byteBuffer = th[i2];
                int sqrt = (int) Math.sqrt((double) (byteBuffer.limit() / 4));
                if (sqrt > 0) {
                    ByteBuffer convertIcon = convertIcon(byteBuffer, sqrt, sqrt);
                    ByteBuffer convertIconMask = convertIconMask(byteBuffer, sqrt, sqrt);
                    nSetWindowIcon(getDisplay(), getWindow(), convertIcon, convertIcon.capacity(), convertIconMask, convertIconMask.capacity(), sqrt, sqrt);
                    decDisplay();
                    unlockAWT();
                    return 1;
                }
            }
            decDisplay();
            unlockAWT();
            return 0;
        } catch (LWJGLException th) {
            try {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Failed to set display icon: ").append(i).toString());
                unlockAWT();
                return 0;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                unlockAWT();
                throw th3;
            }
        } finally {
            i = th;
            decDisplay();
            Throwable th4 = i;
        }
    }

    public void setNativeCursor(Object obj) throws LWJGLException {
        this.current_cursor = getCursorHandle(obj);
        lockAWT();
        try {
            updateCursor();
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
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
        boolean z2 = z;
        if (this.resizable != z2) {
            this.resizable = z2;
            nSetWindowSize(getDisplay(), getWindow(), this.window_width, this.window_height, z2);
        }
    }

    public void setTitle(String str) {
        String str2 = str;
        lockAWT();
        try {
            ByteBuffer encodeUTF8 = MemoryUtil.encodeUTF8(str2);
            nSetTitle(getDisplay(), getWindow(), MemoryUtil.getAddress(encodeUTF8), -1 + encodeUTF8.remaining());
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public void switchDisplayMode(DisplayMode displayMode) throws LWJGLException {
        DisplayMode displayMode2 = displayMode;
        lockAWT();
        try {
            switchDisplayModeOnTmpDisplay(displayMode2);
            this.current_mode = displayMode2;
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public void update() {
        lockAWT();
        try {
            processEvents();
            checkInput();
            unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            unlockAWT();
            throw th2;
        }
    }

    public boolean wasResized() {
        boolean z = false;
        if (this.resized) {
            this.resized = false;
            z = true;
        }
        return z;
    }
}
