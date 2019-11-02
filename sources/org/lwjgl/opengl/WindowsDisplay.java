package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.KeyboardFocusManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.SwingUtilities;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.input.Mouse;

final class WindowsDisplay implements DisplayImplementation {
    private static final int GAMMA_LENGTH = 256;
    private static final int GWL_EXSTYLE = -20;
    private static final int GWL_STYLE = -16;
    private static final int HTCLIENT = 1;
    private static final long HWND_BOTTOM = 1;
    private static final long HWND_NOTOPMOST = -2;
    private static final long HWND_TOP = 0;
    private static final long HWND_TOPMOST = -1;
    private static final int ICON_BIG = 1;
    private static final int ICON_SMALL = 0;
    private static final int MK_XBUTTON1 = 32;
    private static final int MK_XBUTTON2 = 64;
    private static final int SC_ARRANGE = 61712;
    private static final int SC_CLOSE = 61536;
    private static final int SC_CONTEXTHELP = 61824;
    private static final int SC_DEFAULT = 61792;
    private static final int SC_HOTKEY = 61776;
    private static final int SC_HSCROLL = 61568;
    private static final int SC_KEYMENU = 61696;
    private static final int SC_MAXIMIZE = 61488;
    private static final int SC_MINIMIZE = 61472;
    private static final int SC_MONITORPOWER = 61808;
    private static final int SC_MOUSEMENU = 61584;
    private static final int SC_MOVE = 61456;
    private static final int SC_NEXTWINDOW = 61504;
    private static final int SC_PREVWINDOW = 61520;
    private static final int SC_RESTORE = 61728;
    private static final int SC_SCREENSAVE = 61760;
    private static final int SC_SEPARATOR = 61455;
    private static final int SC_SIZE = 61440;
    private static final int SC_TASKLIST = 61744;
    private static final int SC_VSCROLL = 61552;
    private static final int SIZE_MAXIMIZED = 2;
    private static final int SIZE_MINIMIZED = 1;
    private static final int SIZE_RESTORED = 0;
    static final int SM_CMOUSEBUTTONS = 43;
    static final int SM_CXCURSOR = 13;
    static final int SM_CYCURSOR = 14;
    static final int SM_MOUSEWHEELPRESENT = 75;
    private static final int SWP_FRAMECHANGED = 32;
    private static final int SWP_NOMOVE = 2;
    private static final int SWP_NOSIZE = 1;
    private static final int SWP_NOZORDER = 4;
    private static final int SW_MAXIMIZE = 3;
    private static final int SW_NORMAL = 1;
    private static final int SW_RESTORE = 9;
    private static final int SW_SHOWDEFAULT = 10;
    private static final int SW_SHOWMINNOACTIVE = 7;
    private static final int WA_ACTIVE = 1;
    private static final int WA_CLICKACTIVE = 2;
    private static final int WA_INACTIVE = 0;
    private static final int WM_ACTIVATE = 6;
    private static final int WM_CANCELMODE = 31;
    private static final int WM_CAPTURECHANGED = 533;
    private static final int WM_CHAR = 258;
    private static final int WM_ENTERSIZEMOVE = 561;
    private static final int WM_EXITSIZEMOVE = 562;
    private static final int WM_GETICON = 127;
    private static final int WM_KEYDOWN = 256;
    private static final int WM_KEYUP = 257;
    private static final int WM_KILLFOCUS = 8;
    private static final int WM_LBUTTONDBLCLK = 515;
    private static final int WM_LBUTTONDOWN = 513;
    private static final int WM_LBUTTONUP = 514;
    private static final int WM_MBUTTONDBLCLK = 521;
    private static final int WM_MBUTTONDOWN = 519;
    private static final int WM_MBUTTONUP = 520;
    private static final int WM_MOUSEACTIVATE = 33;
    private static final int WM_MOUSELEAVE = 675;
    private static final int WM_MOUSEMOVE = 512;
    private static final int WM_MOUSEWHEEL = 522;
    private static final int WM_MOVE = 3;
    private static final int WM_PAINT = 15;
    private static final int WM_QUIT = 18;
    private static final int WM_RBUTTONDBLCLK = 518;
    private static final int WM_RBUTTONDOWN = 516;
    private static final int WM_RBUTTONUP = 517;
    private static final int WM_SETCURSOR = 32;
    private static final int WM_SETFOCUS = 7;
    private static final int WM_SETICON = 128;
    private static final int WM_SIZE = 5;
    private static final int WM_SIZING = 532;
    private static final int WM_SYSCHAR = 262;
    private static final int WM_SYSCOMMAND = 274;
    private static final int WM_SYSKEYDOWN = 260;
    private static final int WM_SYSKEYUP = 261;
    private static final int WM_WINDOWPOSCHANGED = 71;
    private static final int WM_XBUTTONDBLCLK = 525;
    private static final int WM_XBUTTONDOWN = 523;
    private static final int WM_XBUTTONUP = 524;
    private static final int WS_MAXIMIZEBOX = 65536;
    private static final int WS_THICKFRAME = 262144;
    private static final int XBUTTON1 = 1;
    private static final int XBUTTON2 = 2;
    private static WindowsDisplay current_display;
    private static boolean cursor_clipped;
    private static boolean hasParent;
    private static final Rect rect;
    private static final IntBuffer rect_buffer = BufferUtils.createIntBuffer(4);
    private int captureMouse = -1;
    private boolean close_requested;
    private Object current_cursor;
    private ByteBuffer current_gamma;
    private DisplayMode current_mode;
    private long hdc;
    private int height;
    private long hwnd;
    private boolean iconsLoaded;
    private boolean inAppActivate;
    private boolean isFocused;
    private boolean isMinimized;
    private boolean is_dirty;
    private WindowsKeyboard keyboard;
    private long large_icon;
    private boolean maximized;
    private boolean mode_set;
    private WindowsMouse mouse;
    private boolean mouseInside;
    /* access modifiers changed from: private */
    public Canvas parent;
    private FocusAdapter parent_focus_tracker;
    /* access modifiers changed from: private */
    public AtomicBoolean parent_focused;
    private long parent_hwnd;
    private WindowsDisplayPeerInfo peer_info;
    private boolean redoMakeContextCurrent;
    private boolean resizable;
    private boolean resized;
    private ByteBuffer saved_gamma;
    private long small_icon;
    private boolean trackingMouse;
    private int width;

    /* renamed from: x */
    private int f200x;

    /* renamed from: y */
    private int f201y;

    private static final class Rect {
        public int bottom;
        public int left;
        public int right;
        public int top;

        private Rect() {
        }

        /* synthetic */ Rect(C08081 r4) {
            C08081 r1 = r4;
            this();
        }

        public static void intersect(Rect rect, Rect rect2, Rect rect3) {
            Rect rect4 = rect;
            Rect rect5 = rect2;
            Rect rect6 = rect3;
            rect6.top = Math.max(rect4.top, rect5.top);
            rect6.bottom = Math.min(rect4.bottom, rect5.bottom);
            rect6.left = Math.max(rect4.left, rect5.left);
            rect6.right = Math.min(rect4.right, rect5.right);
        }

        public void copyFromBuffer(IntBuffer intBuffer) {
            IntBuffer intBuffer2 = intBuffer;
            this.top = intBuffer2.get(0);
            this.bottom = intBuffer2.get(1);
            this.left = intBuffer2.get(2);
            this.right = intBuffer2.get(3);
        }

        public void copyToBuffer(IntBuffer intBuffer) {
            IntBuffer put = intBuffer.put(0, this.top).put(1, this.bottom).put(2, this.left).put(3, this.right);
        }

        public void offset(int i, int i2) {
            int i3 = i;
            int i4 = i2;
            this.left = i3 + this.left;
            this.right = i3 + this.right;
            this.top = i4 + this.top;
            this.bottom = i4 + this.bottom;
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append("Rect: top = ").append(this.top).append(" bottom = ").append(this.bottom).append(" left = ").append(this.left).append(" right = ").append(this.right).append(", width: ").append(this.right - this.left).append(", height: ").append(this.bottom - this.top).toString();
        }
    }

    static {
        Rect rect2;
        RuntimeException runtimeException;
        Rect rect3 = rect2;
        Rect rect4 = new Rect(null);
        rect = rect3;
        try {
            setWindowProc(WindowsDisplay.class.getDeclaredMethod("handleMessage", new Class[]{Long.TYPE, Integer.TYPE, Long.TYPE, Long.TYPE, Long.TYPE}));
        } catch (NoSuchMethodException e) {
            NoSuchMethodException noSuchMethodException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(noSuchMethodException);
            throw runtimeException2;
        }
    }

    WindowsDisplay() {
        current_display = this;
    }

    private native boolean adjustWindowRectEx(IntBuffer intBuffer, int i, boolean z, int i2);

    private void appActivate(boolean z) {
        boolean z2 = z;
        if (!this.inAppActivate) {
            this.inAppActivate = true;
            this.isFocused = z2;
            if (z2) {
                if (Display.isFullscreen()) {
                    restoreDisplayMode();
                }
                if (this.parent == null) {
                    if (this.maximized) {
                        showWindow(getHwnd(), 3);
                    } else {
                        showWindow(getHwnd(), 9);
                    }
                    setForegroundWindow(getHwnd());
                }
                setFocus(getHwnd());
                this.redoMakeContextCurrent = true;
                if (Display.isFullscreen()) {
                    updateClipping();
                }
                if (this.keyboard != null) {
                    this.keyboard.fireLostKeyEvents();
                }
            } else if (Display.isFullscreen()) {
                showWindow(getHwnd(), 7);
                resetDisplayMode();
            } else {
                updateClipping();
            }
            updateCursor();
            this.inAppActivate = false;
        }
    }

    static void centerCursor(long j) {
        long j2 = j;
        if (getForegroundWindow() == j2 || hasParent) {
            getGlobalClientRect(j2, rect);
            int i = rect.left;
            int i2 = rect.top;
            int i3 = (rect.left + rect.right) / 2;
            int i4 = (rect.top + rect.bottom) / 2;
            nSetCursorPosition(i3, i4);
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (current_display != null) {
                current_display.setMousePosition(i5, transformY(j2, i6));
            }
        }
    }

    private void checkCursorState() {
        updateClipping();
    }

    private static native void clientToScreen(long j, IntBuffer intBuffer);

    private static native void clipCursor(IntBuffer intBuffer) throws LWJGLException;

    private static native ByteBuffer convertToNativeRamp(FloatBuffer floatBuffer) throws LWJGLException;

    private static native long createIcon(int i, int i2, IntBuffer intBuffer);

    private static native long defWindowProc(long j, int i, long j2, long j3);

    private static native void destroyIcon(long j);

    static Object doCreateCursor(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException {
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        return nCreateCursor(i, i2, i3, i4, i5, intBuffer3, intBuffer3.position(), intBuffer4, intBuffer4 != null ? intBuffer4.position() : -1);
    }

    static native void doDestroyCursor(Object obj);

    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        return HWND_TOP;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01ef, code lost:
        handleKeyButton(r6, r8, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0236, code lost:
        if (r2.captureMouse == -1) goto L_0x0247;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0238, code lost:
        handleMouseButton(r2.captureMouse, 0, r10);
        r2.captureMouse = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        return defWindowProc(r3, r5, r6, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long doHandleMessage(long r24, int r26, long r27, long r29, long r31) {
        /*
            r23 = this;
            r2 = r23
            r3 = r24
            r5 = r26
            r6 = r27
            r8 = r29
            r10 = r31
            r14 = r2
            java.awt.Canvas r14 = r14.parent
            if (r14 == 0) goto L_0x001a
            r14 = r2
            boolean r14 = r14.isFocused
            if (r14 != 0) goto L_0x001a
            r14 = r5
            switch(r14) {
                case 513: goto L_0x002b;
                case 516: goto L_0x002b;
                case 519: goto L_0x002b;
                case 523: goto L_0x002b;
                default: goto L_0x001a;
            }
        L_0x001a:
            r14 = r5
            switch(r14) {
                case 5: goto L_0x0042;
                case 6: goto L_0x003e;
                case 7: goto L_0x009e;
                case 8: goto L_0x0095;
                case 15: goto L_0x021e;
                case 18: goto L_0x01fa;
                case 31: goto L_0x022e;
                case 32: goto L_0x0073;
                case 33: goto L_0x00a7;
                case 71: goto L_0x024c;
                case 127: goto L_0x0274;
                case 256: goto L_0x01ef;
                case 257: goto L_0x01c5;
                case 258: goto L_0x01b7;
                case 260: goto L_0x01ef;
                case 261: goto L_0x01c5;
                case 262: goto L_0x01b7;
                case 274: goto L_0x0203;
                case 512: goto L_0x00ba;
                case 513: goto L_0x011c;
                case 514: goto L_0x012a;
                case 516: goto L_0x0138;
                case 517: goto L_0x0146;
                case 519: goto L_0x0154;
                case 520: goto L_0x0162;
                case 522: goto L_0x0104;
                case 523: goto L_0x0193;
                case 524: goto L_0x0170;
                case 532: goto L_0x006a;
                case 533: goto L_0x0232;
                case 675: goto L_0x0224;
                default: goto L_0x001e;
            }
        L_0x001e:
            r14 = r3
            r16 = r5
            r17 = r6
            r19 = r8
            long r14 = defWindowProc(r14, r16, r17, r19)
            r2 = r14
        L_0x002a:
            return r2
        L_0x002b:
            r14 = r2
            long r14 = r14.parent_hwnd
            r16 = r5
            r0 = r16
            long r0 = (long) r0
            r16 = r0
            r18 = r6
            r20 = r8
            long r14 = sendMessage(r14, r16, r18, r20)
            goto L_0x001a
        L_0x003e:
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x0042:
            r14 = r6
            int r14 = (int) r14
            switch(r14) {
                case 0: goto L_0x0048;
                case 1: goto L_0x0064;
                case 2: goto L_0x0048;
                default: goto L_0x0047;
            }
        L_0x0047:
            goto L_0x001e
        L_0x0048:
            r14 = r6
            int r14 = (int) r14
            r15 = 2
            if (r14 != r15) goto L_0x0061
            r14 = 1
            r13 = r14
        L_0x004f:
            r14 = r2
            r15 = r13
            r14.maximized = r15
            r14 = r2
            r15 = 1
            r14.resized = r15
            r14 = r2
            r14.updateWidthAndHeight()
            r14 = r2
            r15 = 0
            r14.setMinimized(r15)
            goto L_0x001e
        L_0x0061:
            r14 = 0
            r13 = r14
            goto L_0x004f
        L_0x0064:
            r14 = r2
            r15 = 1
            r14.setMinimized(r15)
            goto L_0x001e
        L_0x006a:
            r14 = r2
            r15 = 1
            r14.resized = r15
            r14 = r2
            r14.updateWidthAndHeight()
            goto L_0x001e
        L_0x0073:
            r14 = 65535(0xffff, double:3.23786E-319)
            r16 = r8
            long r14 = r14 & r16
            r16 = 1
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 != 0) goto L_0x0088
            r14 = r2
            r14.updateCursor()
            r14 = -1
            r2 = r14
            goto L_0x002a
        L_0x0088:
            r14 = r3
            r16 = r5
            r17 = r6
            r19 = r8
            long r14 = defWindowProc(r14, r16, r17, r19)
            r2 = r14
            goto L_0x002a
        L_0x0095:
            r14 = r2
            r15 = 0
            r14.appActivate(r15)
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x009e:
            r14 = r2
            r15 = 1
            r14.appActivate(r15)
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x00a7:
            r14 = r2
            java.awt.Canvas r14 = r14.parent
            if (r14 == 0) goto L_0x001e
            r14 = r2
            boolean r14 = r14.isFocused
            if (r14 != 0) goto L_0x00b5
            r14 = r2
            r14.grabFocus()
        L_0x00b5:
            r14 = 3
            r2 = r14
            goto L_0x002a
        L_0x00ba:
            r14 = r2
            r15 = 65535(0xffff, double:3.23786E-319)
            r17 = r8
            long r15 = r15 & r17
            int r15 = (int) r15
            short r15 = (short) r15
            r16 = r2
            long r16 = r16.getHwnd()
            r18 = 65535(0xffff, double:3.23786E-319)
            r20 = r8
            r22 = 16
            long r20 = r20 >> r22
            long r18 = r18 & r20
            r0 = r18
            int r0 = (int) r0
            r18 = r0
            r0 = r18
            short r0 = (short) r0
            r18 = r0
            int r16 = transformY(r16, r18)
            r17 = r10
            r14.handleMouseMoved(r15, r16, r17)
            r14 = r2
            r14.checkCursorState()
            r14 = r2
            r15 = 1
            r14.mouseInside = r15
            r14 = r2
            boolean r14 = r14.trackingMouse
            if (r14 != 0) goto L_0x00ff
            r14 = r2
            r15 = r2
            r16 = r3
            boolean r15 = r15.nTrackMouseEvent(r16)
            r14.trackingMouse = r15
        L_0x00ff:
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x0104:
            r14 = r2
            r15 = 65535(0xffff, double:3.23786E-319)
            r17 = r6
            r19 = 16
            long r17 = r17 >> r19
            long r15 = r15 & r17
            int r15 = (int) r15
            short r15 = (short) r15
            r16 = r10
            r14.handleMouseScrolled(r15, r16)
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x011c:
            r14 = r2
            r15 = 0
            r16 = 1
            r17 = r10
            r14.handleMouseButton(r15, r16, r17)
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x012a:
            r14 = r2
            r15 = 0
            r16 = 0
            r17 = r10
            r14.handleMouseButton(r15, r16, r17)
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x0138:
            r14 = r2
            r15 = 1
            r16 = 1
            r17 = r10
            r14.handleMouseButton(r15, r16, r17)
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x0146:
            r14 = r2
            r15 = 1
            r16 = 0
            r17 = r10
            r14.handleMouseButton(r15, r16, r17)
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x0154:
            r14 = r2
            r15 = 2
            r16 = 1
            r17 = r10
            r14.handleMouseButton(r15, r16, r17)
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x0162:
            r14 = r2
            r15 = 2
            r16 = 0
            r17 = r10
            r14.handleMouseButton(r15, r16, r17)
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x0170:
            r14 = r6
            r16 = 16
            long r14 = r14 >> r16
            r16 = 1
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 != 0) goto L_0x0189
            r14 = r2
            r15 = 3
            r16 = 0
            r17 = r10
            r14.handleMouseButton(r15, r16, r17)
        L_0x0184:
            r14 = 1
            r2 = r14
            goto L_0x002a
        L_0x0189:
            r14 = r2
            r15 = 4
            r16 = 0
            r17 = r10
            r14.handleMouseButton(r15, r16, r17)
            goto L_0x0184
        L_0x0193:
            r14 = 255(0xff, double:1.26E-321)
            r16 = r6
            long r14 = r14 & r16
            r16 = 32
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 != 0) goto L_0x01ad
            r14 = r2
            r15 = 3
            r16 = 1
            r17 = r10
            r14.handleMouseButton(r15, r16, r17)
        L_0x01a8:
            r14 = 1
            r2 = r14
            goto L_0x002a
        L_0x01ad:
            r14 = r2
            r15 = 4
            r16 = 1
            r17 = r10
            r14.handleMouseButton(r15, r16, r17)
            goto L_0x01a8
        L_0x01b7:
            r14 = r2
            r15 = r6
            r17 = r8
            r19 = r10
            r14.handleChar(r15, r17, r19)
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x01c5:
            r14 = r6
            r16 = 44
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 != 0) goto L_0x01ef
            r14 = r2
            org.lwjgl.opengl.WindowsKeyboard r14 = r14.keyboard
            if (r14 == 0) goto L_0x01ef
            r14 = r2
            org.lwjgl.opengl.WindowsKeyboard r14 = r14.keyboard
            r15 = 183(0xb7, float:2.56E-43)
            boolean r14 = r14.isKeyDown(r15)
            if (r14 != 0) goto L_0x01ef
            r14 = r2
            r15 = r6
            r17 = -1073741825(0xffffffffbfffffff, double:NaN)
            r19 = r8
            r21 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r19 = r19 & r21
            long r17 = r17 & r19
            r19 = r10
            r14.handleKeyButton(r15, r17, r19)
        L_0x01ef:
            r14 = r2
            r15 = r6
            r17 = r8
            r19 = r10
            r14.handleKeyButton(r15, r17, r19)
            goto L_0x001e
        L_0x01fa:
            r14 = r2
            r15 = 1
            r14.close_requested = r15
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x0203:
            r14 = 65520(0xfff0, double:3.2371E-319)
            r16 = r6
            long r14 = r14 & r16
            int r14 = (int) r14
            switch(r14) {
                case 61536: goto L_0x0210;
                case 61584: goto L_0x0219;
                case 61696: goto L_0x0219;
                case 61760: goto L_0x0219;
                case 61808: goto L_0x0219;
                default: goto L_0x020e;
            }
        L_0x020e:
            goto L_0x001e
        L_0x0210:
            r14 = r2
            r15 = 1
            r14.close_requested = r15
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x0219:
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x021e:
            r14 = r2
            r15 = 1
            r14.is_dirty = r15
            goto L_0x001e
        L_0x0224:
            r14 = r2
            r15 = 0
            r14.mouseInside = r15
            r14 = r2
            r15 = 0
            r14.trackingMouse = r15
            goto L_0x001e
        L_0x022e:
            boolean r14 = nReleaseCapture()
        L_0x0232:
            r14 = r2
            int r14 = r14.captureMouse
            r15 = -1
            if (r14 == r15) goto L_0x0247
            r14 = r2
            r15 = r2
            int r15 = r15.captureMouse
            r16 = 0
            r17 = r10
            r14.handleMouseButton(r15, r16, r17)
            r14 = r2
            r15 = -1
            r14.captureMouse = r15
        L_0x0247:
            r14 = 0
            r2 = r14
            goto L_0x002a
        L_0x024c:
            r14 = r2
            r15 = r3
            java.nio.IntBuffer r17 = rect_buffer
            boolean r14 = r14.getWindowRect(r15, r17)
            if (r14 == 0) goto L_0x026d
            org.lwjgl.opengl.WindowsDisplay$Rect r14 = rect
            java.nio.IntBuffer r15 = rect_buffer
            r14.copyFromBuffer(r15)
            r14 = r2
            org.lwjgl.opengl.WindowsDisplay$Rect r15 = rect
            int r15 = r15.top
            r14.f200x = r15
            r14 = r2
            org.lwjgl.opengl.WindowsDisplay$Rect r15 = rect
            int r15 = r15.bottom
            r14.f201y = r15
            goto L_0x001e
        L_0x026d:
            java.lang.String r14 = "WM_WINDOWPOSCHANGED: Unable to get window rect"
            org.lwjgl.LWJGLUtil.log(r14)
            goto L_0x001e
        L_0x0274:
            r14 = r2
            r15 = 1
            r14.iconsLoaded = r15
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.WindowsDisplay.doHandleMessage(long, int, long, long, long):long");
    }

    private void doSetGammaRamp(ByteBuffer byteBuffer) throws LWJGLException {
        ByteBuffer byteBuffer2 = byteBuffer;
        nSetGammaRamp(byteBuffer2);
        this.current_gamma = byteBuffer2;
    }

    private void freeLargeIcon() {
        if (this.large_icon != HWND_TOP) {
            destroyIcon(this.large_icon);
            this.large_icon = HWND_TOP;
        }
    }

    private void freeSmallIcon() {
        if (this.small_icon != HWND_TOP) {
            destroyIcon(this.small_icon);
            this.small_icon = HWND_TOP;
        }
    }

    private static native void getClientRect(long j, IntBuffer intBuffer);

    private static native DisplayMode getCurrentDisplayMode() throws LWJGLException;

    private static native ByteBuffer getCurrentGammaRamp() throws LWJGLException;

    private static native long getDC(long j);

    private static native long getDesktopWindow();

    private static native long getDllInstance();

    private static native long getForegroundWindow();

    private static void getGlobalClientRect(long j, Rect rect2) {
        long j2 = j;
        Rect rect3 = rect2;
        IntBuffer put = rect_buffer.put(0, 0).put(1, 0);
        clientToScreen(j2, rect_buffer);
        int i = rect_buffer.get(0);
        int i2 = rect_buffer.get(1);
        getClientRect(j2, rect_buffer);
        rect3.copyFromBuffer(rect_buffer);
        rect3.offset(i, i2);
    }

    private long getHdc() {
        return this.hdc;
    }

    private long getHwnd() {
        return this.hwnd;
    }

    /* JADX INFO: finally extract failed */
    private static long getHwnd(Canvas canvas) throws LWJGLException {
        WindowsPeerInfo windowsPeerInfo = (WindowsPeerInfo) AWTGLCanvas.createImplementation().createPeerInfo(canvas, null, null);
        ByteBuffer lockAndGetHandle = windowsPeerInfo.lockAndGetHandle();
        try {
            long hwnd2 = windowsPeerInfo.getHwnd();
            windowsPeerInfo.unlock();
            return hwnd2;
        } catch (Throwable th) {
            Throwable th2 = th;
            windowsPeerInfo.unlock();
            throw th2;
        }
    }

    static native int getSystemMetrics(int i);

    private static native long getWindowLongPtr(long j, int i);

    private native boolean getWindowRect(long j, IntBuffer intBuffer);

    private void grabFocus() {
        C08092 r4;
        if (this.parent == null) {
            setFocus(getHwnd());
            return;
        }
        C08092 r1 = r4;
        C08092 r2 = new Runnable(this) {
            final /* synthetic */ WindowsDisplay this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                this.this$0.parent.requestFocus();
            }
        };
        SwingUtilities.invokeLater(r1);
    }

    private void handleChar(long j, long j2, long j3) {
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        boolean z = ((byte) ((int) (1 - (1 & (j5 >>> 31))))) == ((byte) ((int) (1 & (j5 >>> 30))));
        if (this.keyboard != null) {
            this.keyboard.handleChar((int) (65535 & j4), j6, z);
        }
    }

    private void handleKeyButton(long j, long j2, long j3) {
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        byte b = (byte) ((int) (1 - (1 & (j5 >>> 31))));
        boolean z = b == ((byte) ((int) (1 & (j5 >>> 30))));
        byte b2 = (byte) ((int) (1 & (j5 >>> 24)));
        int i = (int) (255 & (j5 >>> 16));
        if (this.keyboard != null) {
            this.keyboard.handleKey((int) j4, i, b2 != 0, b, j6, z);
        }
    }

    private static long handleMessage(long j, int i, long j2, long j3, long j4) {
        long j5 = j;
        int i2 = i;
        long j6 = j2;
        long j7 = j3;
        return current_display != null ? current_display.doHandleMessage(j5, i2, j6, j7, j4) : defWindowProc(j5, i2, j6, j7);
    }

    private void handleMouseButton(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        if (this.mouse != null) {
            this.mouse.handleMouseButton((byte) i3, (byte) i4, j2);
            if (this.captureMouse == -1 && i3 != -1 && i4 == 1) {
                this.captureMouse = i3;
                long nSetCapture = nSetCapture(this.hwnd);
            }
            if (this.captureMouse != -1 && i3 == this.captureMouse && i4 == 0) {
                this.captureMouse = -1;
                boolean nReleaseCapture = nReleaseCapture();
            }
        }
    }

    private void handleMouseMoved(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        if (this.mouse != null) {
            this.mouse.handleMouseMoved(i3, i4, j2, shouldGrab());
        }
    }

    private void handleMouseScrolled(int i, long j) {
        int i2 = i;
        long j2 = j;
        if (this.mouse != null) {
            this.mouse.handleMouseScrolled(i2, j2);
        }
    }

    private static boolean isUndecorated() {
        return Display.getPrivilegedBoolean("org.lwjgl.opengl.Window.undecorated");
    }

    public static native ByteBuffer nCreateCursor(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, int i6, IntBuffer intBuffer2, int i7) throws LWJGLException;

    private static native long nCreateWindow(int i, int i2, int i3, int i4, boolean z, boolean z2, long j) throws LWJGLException;

    private static native void nDestroyWindow(long j);

    private native int nGetPbufferCapabilities(PixelFormat pixelFormat) throws LWJGLException;

    private native WindowsFileVersion nGetVersion(String str);

    private static native boolean nReleaseCapture();

    private static native void nReleaseDC(long j, long j2);

    private static native void nResetDisplayMode();

    private static native void nReshape(long j, int i, int i2, int i3, int i4, boolean z, boolean z2);

    private static native long nSetCapture(long j);

    private static native void nSetCursorPosition(int i, int i2);

    private static native void nSetGammaRamp(ByteBuffer byteBuffer) throws LWJGLException;

    static native void nSetNativeCursor(long j, Object obj) throws LWJGLException;

    private static native void nSetTitle(long j, long j2);

    private static native void nSwitchDisplayMode(DisplayMode displayMode) throws LWJGLException;

    private native boolean nTrackMouseEvent(long j);

    private static native void nUpdate();

    static void resetCursorClipping() {
        StringBuilder sb;
        if (cursor_clipped) {
            try {
                clipCursor(null);
            } catch (LWJGLException e) {
                LWJGLException lWJGLException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Failed to reset cursor clipping: ").append(lWJGLException).toString());
            }
            cursor_clipped = false;
        }
    }

    private void restoreDisplayMode() {
        StringBuilder sb;
        StringBuilder sb2;
        try {
            doSetGammaRamp(this.current_gamma);
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            LWJGLUtil.log(sb3.append("Failed to restore gamma: ").append(lWJGLException.getMessage()).toString());
        }
        if (!this.mode_set) {
            this.mode_set = true;
            try {
                nSwitchDisplayMode(this.current_mode);
            } catch (LWJGLException e2) {
                LWJGLException lWJGLException2 = e2;
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                LWJGLUtil.log(sb5.append("Failed to restore display mode: ").append(lWJGLException2.getMessage()).toString());
            }
        }
    }

    private static native long sendMessage(long j, long j2, long j3, long j4);

    private static native void setFocus(long j);

    private static native void setForegroundWindow(long j);

    private void setMinimized(boolean z) {
        this.isMinimized = z;
        checkCursorState();
    }

    private void setMousePosition(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.mouse != null) {
            this.mouse.setPosition(i3, i4);
        }
    }

    private static native long setWindowLongPtr(long j, int i, long j2);

    private static native boolean setWindowPos(long j, long j2, int i, int i2, int i3, int i4, long j3);

    private static native void setWindowProc(Method method);

    static void setupCursorClipping(long j) throws LWJGLException {
        long j2 = j;
        cursor_clipped = true;
        getGlobalClientRect(j2, rect);
        rect.copyToBuffer(rect_buffer);
        clipCursor(rect_buffer);
    }

    private boolean shouldGrab() {
        return !this.isMinimized && this.isFocused && Mouse.isGrabbed();
    }

    private static native void showWindow(long j, int i);

    private static int transformY(long j, int i) {
        int i2 = i;
        getClientRect(j, rect_buffer);
        rect.copyFromBuffer(rect_buffer);
        return (-1 + (rect.bottom - rect.top)) - i2;
    }

    private void updateClipping() {
        StringBuilder sb;
        if ((Display.isFullscreen() || (this.mouse != null && this.mouse.isGrabbed())) && !this.isMinimized && this.isFocused && (getForegroundWindow() == getHwnd() || hasParent)) {
            try {
                setupCursorClipping(getHwnd());
            } catch (LWJGLException e) {
                LWJGLException lWJGLException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("setupCursorClipping failed: ").append(lWJGLException.getMessage()).toString());
            }
        } else {
            resetCursorClipping();
        }
    }

    private void updateCursor() {
        StringBuilder sb;
        try {
            if (this.mouse == null || !shouldGrab()) {
                nSetNativeCursor(getHwnd(), this.current_cursor);
            } else {
                nSetNativeCursor(getHwnd(), this.mouse.getBlankCursor());
            }
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Failed to update cursor: ").append(lWJGLException).toString());
        }
    }

    private void updateWidthAndHeight() {
        getClientRect(this.hwnd, rect_buffer);
        rect.copyFromBuffer(rect_buffer);
        this.width = rect.right - rect.left;
        this.height = rect.bottom - rect.top;
    }

    public void bindTexImageToPbuffer(PeerInfo peerInfo, int i) {
        ((WindowsPbufferPeerInfo) peerInfo).bindTexImageToPbuffer(i);
    }

    public Object createCursor(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException {
        return doCreateCursor(i, i2, i3, i4, i5, intBuffer, intBuffer2);
    }

    public void createKeyboard() throws LWJGLException {
        WindowsKeyboard windowsKeyboard;
        WindowsKeyboard windowsKeyboard2 = windowsKeyboard;
        WindowsKeyboard windowsKeyboard3 = new WindowsKeyboard(getHwnd());
        this.keyboard = windowsKeyboard2;
    }

    public void createMouse() throws LWJGLException {
        WindowsMouse windowsMouse;
        WindowsMouse windowsMouse2 = windowsMouse;
        WindowsMouse windowsMouse3 = new WindowsMouse(getHwnd());
        this.mouse = windowsMouse2;
    }

    public PeerInfo createPbuffer(int i, int i2, PixelFormat pixelFormat, ContextAttribs contextAttribs, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException {
        WindowsPbufferPeerInfo windowsPbufferPeerInfo;
        ContextAttribs contextAttribs2 = contextAttribs;
        WindowsPbufferPeerInfo windowsPbufferPeerInfo2 = windowsPbufferPeerInfo;
        WindowsPbufferPeerInfo windowsPbufferPeerInfo3 = new WindowsPbufferPeerInfo(i, i2, pixelFormat, intBuffer, intBuffer2);
        return windowsPbufferPeerInfo2;
    }

    public PeerInfo createPeerInfo(PixelFormat pixelFormat, ContextAttribs contextAttribs) throws LWJGLException {
        WindowsDisplayPeerInfo windowsDisplayPeerInfo;
        PixelFormat pixelFormat2 = pixelFormat;
        ContextAttribs contextAttribs2 = contextAttribs;
        WindowsDisplayPeerInfo windowsDisplayPeerInfo2 = windowsDisplayPeerInfo;
        WindowsDisplayPeerInfo windowsDisplayPeerInfo3 = new WindowsDisplayPeerInfo(false);
        this.peer_info = windowsDisplayPeerInfo2;
        return this.peer_info;
    }

    public void createWindow(DrawableLWJGL drawableLWJGL, DisplayMode displayMode, Canvas canvas, int i, int i2) throws LWJGLException {
        WindowsDisplayPeerInfo windowsDisplayPeerInfo;
        AtomicBoolean atomicBoolean;
        C08081 r29;
        LWJGLException lWJGLException;
        LWJGLException lWJGLException2;
        DrawableLWJGL drawableLWJGL2 = drawableLWJGL;
        DisplayMode displayMode2 = displayMode;
        Canvas canvas2 = canvas;
        int i3 = i;
        int i4 = i2;
        this.close_requested = false;
        this.is_dirty = false;
        this.isMinimized = false;
        this.isFocused = false;
        this.redoMakeContextCurrent = false;
        this.maximized = false;
        this.parent = canvas2;
        hasParent = canvas2 != null;
        this.parent_hwnd = canvas2 != null ? getHwnd(canvas2) : 0;
        this.hwnd = nCreateWindow(i3, i4, displayMode2.getWidth(), displayMode2.getHeight(), Display.isFullscreen() || isUndecorated(), canvas2 != null, this.parent_hwnd);
        this.resizable = false;
        if (this.hwnd == HWND_TOP) {
            LWJGLException lWJGLException3 = lWJGLException2;
            LWJGLException lWJGLException4 = new LWJGLException("Failed to create window");
            throw lWJGLException3;
        }
        this.hdc = getDC(this.hwnd);
        if (this.hdc == HWND_TOP) {
            nDestroyWindow(this.hwnd);
            LWJGLException lWJGLException5 = lWJGLException;
            LWJGLException lWJGLException6 = new LWJGLException("Failed to get dc");
            throw lWJGLException5;
        }
        try {
            if (drawableLWJGL2 instanceof DrawableGL) {
                WindowsPeerInfo.setPixelFormat(getHdc(), WindowsPeerInfo.choosePixelFormat(getHdc(), 0, 0, (PixelFormat) drawableLWJGL2.getPixelFormat(), null, true, true, false, true));
            } else {
                WindowsDisplayPeerInfo windowsDisplayPeerInfo2 = windowsDisplayPeerInfo;
                WindowsDisplayPeerInfo windowsDisplayPeerInfo3 = new WindowsDisplayPeerInfo(true);
                this.peer_info = windowsDisplayPeerInfo2;
                ((DrawableGLES) drawableLWJGL2).initialize(this.hwnd, this.hdc, 4, drawableLWJGL2.getPixelFormat());
            }
            this.peer_info.initDC(getHwnd(), getHdc());
            showWindow(getHwnd(), 10);
            updateWidthAndHeight();
            if (canvas2 == null) {
                if (Display.isResizable()) {
                    setResizable(true);
                }
                setForegroundWindow(getHwnd());
            } else {
                AtomicBoolean atomicBoolean2 = atomicBoolean;
                AtomicBoolean atomicBoolean3 = new AtomicBoolean(false);
                this.parent_focused = atomicBoolean2;
                C08081 r19 = r29;
                C08081 r20 = new FocusAdapter(this) {
                    final /* synthetic */ WindowsDisplay this$0;

                    {
                        this.this$0 = r5;
                    }

                    public void focusGained(FocusEvent focusEvent) {
                        FocusEvent focusEvent2 = focusEvent;
                        this.this$0.parent_focused.set(true);
                        this.this$0.parent.setFocusable(false);
                        this.this$0.parent.setFocusable(true);
                        KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
                    }
                };
                C08081 r17 = r19;
                this.parent_focus_tracker = r17;
                canvas2.addFocusListener(r17);
            }
            grabFocus();
        } catch (LWJGLException e) {
            LWJGLException lWJGLException7 = e;
            nReleaseDC(this.hwnd, this.hdc);
            nDestroyWindow(this.hwnd);
            throw lWJGLException7;
        }
    }

    public void destroyCursor(Object obj) {
        doDestroyCursor(obj);
    }

    public void destroyKeyboard() {
        this.keyboard.destroy();
        this.keyboard = null;
    }

    public void destroyMouse() {
        if (this.mouse != null) {
            this.mouse.destroy();
        }
        this.mouse = null;
    }

    public void destroyWindow() {
        if (this.parent != null) {
            this.parent.removeFocusListener(this.parent_focus_tracker);
            this.parent_focus_tracker = null;
        }
        nReleaseDC(this.hwnd, this.hdc);
        nDestroyWindow(this.hwnd);
        freeLargeIcon();
        freeSmallIcon();
        resetCursorClipping();
    }

    public String getAdapter() {
        StringBuilder sb;
        StringBuilder sb2;
        try {
            char charAt = WindowsRegistry.queryRegistrationKey(3, "HARDWARE\\DeviceMap\\Video", "MaxObjectNumber").charAt(0);
            String str = LibrariesRepository.MOJANG_MAVEN_REPO;
            for (int i = 0; i < charAt; i++) {
                String str2 = "HARDWARE\\DeviceMap\\Video";
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                String queryRegistrationKey = WindowsRegistry.queryRegistrationKey(3, str2, sb3.append("\\Device\\Video").append(i).toString());
                if (queryRegistrationKey.toLowerCase().startsWith("\\registry\\machine\\")) {
                    String queryRegistrationKey2 = WindowsRegistry.queryRegistrationKey(3, queryRegistrationKey.substring("\\registry\\machine\\".length()), "InstalledDisplayDrivers");
                    if (queryRegistrationKey2.toUpperCase().startsWith("VGA")) {
                        str = queryRegistrationKey2;
                    } else if (!queryRegistrationKey2.toUpperCase().startsWith("RDP") && !queryRegistrationKey2.toUpperCase().startsWith("NMNDD")) {
                        return queryRegistrationKey2;
                    }
                }
            }
            if (!str.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                return str;
            }
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            LWJGLUtil.log(sb5.append("Exception occurred while querying registry: ").append(lWJGLException).toString());
        }
        return null;
    }

    public native DisplayMode[] getAvailableDisplayModes() throws LWJGLException;

    public int getButtonCount() {
        return this.mouse.getButtonCount();
    }

    public int getGammaRampLength() {
        return 256;
    }

    public int getHeight() {
        return this.height;
    }

    public int getMaxCursorSize() {
        return getSystemMetrics(13);
    }

    public int getMinCursorSize() {
        return getSystemMetrics(13);
    }

    public int getNativeCursorCapabilities() {
        return 1;
    }

    public int getPbufferCapabilities() {
        StringBuilder sb;
        PixelFormat pixelFormat;
        try {
            PixelFormat pixelFormat2 = pixelFormat;
            PixelFormat pixelFormat3 = new PixelFormat(0, 0, 0, 0, 0, 0, 0, 0, false);
            return nGetPbufferCapabilities(pixelFormat2);
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Exception occurred while determining pbuffer capabilities: ").append(lWJGLException).toString());
            return 0;
        }
    }

    public String getVersion() {
        StringBuilder sb;
        String adapter = getAdapter();
        if (adapter != null) {
            String[] split = adapter.split(",");
            if (split.length > 0) {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                WindowsFileVersion nGetVersion = nGetVersion(sb2.append(split[0]).append(".dll").toString());
                if (nGetVersion != null) {
                    return nGetVersion.toString();
                }
            }
        }
        return null;
    }

    public int getWidth() {
        return this.width;
    }

    public int getX() {
        return this.f200x;
    }

    public int getY() {
        return this.f201y;
    }

    public void grabMouse(boolean z) {
        this.mouse.grab(z, shouldGrab());
        updateCursor();
    }

    public boolean hasWheel() {
        return this.mouse.hasWheel();
    }

    public DisplayMode init() throws LWJGLException {
        ByteBuffer currentGammaRamp = getCurrentGammaRamp();
        this.saved_gamma = currentGammaRamp;
        this.current_gamma = currentGammaRamp;
        DisplayMode currentDisplayMode = getCurrentDisplayMode();
        this.current_mode = currentDisplayMode;
        return currentDisplayMode;
    }

    public boolean isActive() {
        return this.isFocused;
    }

    public boolean isBufferLost(PeerInfo peerInfo) {
        return ((WindowsPbufferPeerInfo) peerInfo).isBufferLost();
    }

    public boolean isCloseRequested() {
        boolean z = this.close_requested;
        this.close_requested = false;
        return z;
    }

    public boolean isDirty() {
        boolean z = this.is_dirty;
        this.is_dirty = false;
        return z;
    }

    public boolean isInsideWindow() {
        return this.mouseInside;
    }

    public boolean isVisible() {
        return !this.isMinimized;
    }

    public void pollKeyboard(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        this.keyboard.poll(byteBuffer2);
    }

    public void pollMouse(IntBuffer intBuffer, ByteBuffer byteBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        this.mouse.poll(intBuffer2, byteBuffer2);
    }

    public void readKeyboard(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        this.keyboard.read(byteBuffer2);
    }

    public void readMouse(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        this.mouse.read(byteBuffer2);
    }

    public void releaseTexImageFromPbuffer(PeerInfo peerInfo, int i) {
        ((WindowsPbufferPeerInfo) peerInfo).releaseTexImageFromPbuffer(i);
    }

    public void resetDisplayMode() {
        StringBuilder sb;
        try {
            doSetGammaRamp(this.saved_gamma);
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Failed to reset gamma ramp: ").append(lWJGLException.getMessage()).toString());
        }
        this.current_gamma = this.saved_gamma;
        if (this.mode_set) {
            this.mode_set = false;
            nResetDisplayMode();
        }
        resetCursorClipping();
    }

    public void reshape(int i, int i2, int i3, int i4) {
        nReshape(getHwnd(), i, i2, i3, i4, Display.isFullscreen() || isUndecorated(), this.parent != null);
    }

    public void setCursorPosition(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        getGlobalClientRect(getHwnd(), rect);
        nSetCursorPosition(i3 + rect.left, (-1 + rect.bottom) - i4);
        setMousePosition(i3, i4);
    }

    public void setGammaRamp(FloatBuffer floatBuffer) throws LWJGLException {
        doSetGammaRamp(convertToNativeRamp(floatBuffer));
    }

    public int setIcon(ByteBuffer[] byteBufferArr) {
        ByteBuffer[] byteBufferArr2 = byteBufferArr;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        int length = byteBufferArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            ByteBuffer byteBuffer = byteBufferArr2[i2];
            int limit = byteBuffer.limit() / 4;
            if (((int) Math.sqrt((double) limit)) == 16 && !z) {
                long createIcon = createIcon(16, 16, byteBuffer.asIntBuffer());
                long sendMessage = sendMessage(this.hwnd, 128, HWND_TOP, createIcon);
                freeSmallIcon();
                this.small_icon = createIcon;
                i++;
                z = true;
            }
            if (((int) Math.sqrt((double) limit)) == 32 && !z2) {
                long createIcon2 = createIcon(32, 32, byteBuffer.asIntBuffer());
                long sendMessage2 = sendMessage(this.hwnd, 128, 1, createIcon2);
                freeLargeIcon();
                this.large_icon = createIcon2;
                i++;
                z2 = true;
                this.iconsLoaded = false;
                long nanoTime = System.nanoTime();
                while (true) {
                    nUpdate();
                    if (this.iconsLoaded || 500000000 < System.nanoTime() - nanoTime) {
                        break;
                    }
                    Thread.yield();
                }
            }
        }
        return i;
    }

    public void setNativeCursor(Object obj) throws LWJGLException {
        this.current_cursor = obj;
        updateCursor();
    }

    public void setPbufferAttrib(PeerInfo peerInfo, int i, int i2) {
        ((WindowsPbufferPeerInfo) peerInfo).setPbufferAttrib(i, i2);
    }

    public void setResizable(boolean z) {
        int i;
        boolean z2 = z;
        if (this.resizable != z2) {
            int windowLongPtr = (int) getWindowLongPtr(this.hwnd, -16);
            int windowLongPtr2 = (int) getWindowLongPtr(this.hwnd, GWL_EXSTYLE);
            if (!z2 || Display.isFullscreen()) {
                i = windowLongPtr & -327681;
                long windowLongPtr3 = setWindowLongPtr(this.hwnd, -16, (long) i);
            } else {
                i = windowLongPtr | 327680;
                long windowLongPtr4 = setWindowLongPtr(this.hwnd, -16, (long) i);
            }
            getClientRect(this.hwnd, rect_buffer);
            rect.copyFromBuffer(rect_buffer);
            boolean adjustWindowRectEx = adjustWindowRectEx(rect_buffer, i, false, windowLongPtr2);
            rect.copyFromBuffer(rect_buffer);
            boolean windowPos = setWindowPos(this.hwnd, HWND_TOP, 0, 0, rect.right - rect.left, rect.bottom - rect.top, 38);
            updateWidthAndHeight();
            this.resized = false;
        }
        this.resizable = z2;
    }

    public void setTitle(String str) {
        nSetTitle(this.hwnd, MemoryUtil.getAddress0((Buffer) MemoryUtil.encodeUTF16(str)));
    }

    public void switchDisplayMode(DisplayMode displayMode) throws LWJGLException {
        DisplayMode displayMode2 = displayMode;
        nSwitchDisplayMode(displayMode2);
        this.current_mode = displayMode2;
        this.mode_set = true;
    }

    public void update() {
        StringBuilder sb;
        nUpdate();
        if (!this.isFocused && this.parent != null && this.parent_focused.compareAndSet(true, false)) {
            setFocus(getHwnd());
        }
        if (this.redoMakeContextCurrent) {
            this.redoMakeContextCurrent = false;
            try {
                Context context = ((DrawableLWJGL) Display.getDrawable()).getContext();
                if (context != null && context.isCurrent()) {
                    context.makeCurrent();
                }
            } catch (LWJGLException e) {
                LWJGLException lWJGLException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Exception occurred while trying to make context current: ").append(lWJGLException).toString());
            }
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
