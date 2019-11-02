package org.lwjgl.input;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.InputImplementation;

public class Mouse {
    private static final int BUFFER_SIZE = 50;
    public static final int EVENT_SIZE = 22;
    private static int absolute_x;
    private static int absolute_y;
    private static int buttonCount = -1;
    private static final Map<String, Integer> buttonMap;
    private static String[] buttonName;
    private static ByteBuffer buttons;
    private static boolean clipMouseCoordinatesToWindow;
    private static IntBuffer coord_buffer;
    private static boolean created;
    private static Cursor currentCursor;
    private static int dwheel;

    /* renamed from: dx */
    private static int f191dx;

    /* renamed from: dy */
    private static int f192dy;
    private static final boolean emulateCursorAnimation = (LWJGLUtil.getPlatform() == 3 || LWJGLUtil.getPlatform() == 2);
    private static int eventButton;
    private static boolean eventState;
    private static int event_dwheel;
    private static int event_dx;
    private static int event_dy;
    private static long event_nanos;
    private static int event_x;
    private static int event_y;
    private static int grab_x;
    private static int grab_y;
    private static boolean hasWheel;
    private static InputImplementation implementation;
    private static boolean initialized;
    private static boolean isGrabbed;
    private static int last_event_raw_x;
    private static int last_event_raw_y;
    private static ByteBuffer readBuffer;

    /* renamed from: x */
    private static int f193x;

    /* renamed from: y */
    private static int f194y;

    static {
        HashMap hashMap;
        boolean z = true;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap(16);
        buttonMap = hashMap2;
        if (getPrivilegedBoolean("org.lwjgl.input.Mouse.allowNegativeMouseCoords")) {
            z = false;
        }
        clipMouseCoordinatesToWindow = z;
    }

    private Mouse() {
    }

    public static void create() throws LWJGLException {
        IllegalStateException illegalStateException;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if (!Display.isCreated()) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Display must be created.");
                    throw illegalStateException2;
                }
                create(OpenGLPackageAccess.createImplementation());
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    private static void create(InputImplementation inputImplementation) throws LWJGLException {
        InputImplementation inputImplementation2 = inputImplementation;
        if (!created) {
            if (!initialized) {
                initialize();
            }
            implementation = inputImplementation2;
            implementation.createMouse();
            hasWheel = implementation.hasWheel();
            created = true;
            buttonCount = implementation.getButtonCount();
            buttons = BufferUtils.createByteBuffer(buttonCount);
            coord_buffer = BufferUtils.createIntBuffer(3);
            if (!(currentCursor == null || implementation.getNativeCursorCapabilities() == 0)) {
                Cursor nativeCursor = setNativeCursor(currentCursor);
            }
            readBuffer = ByteBuffer.allocate(1100);
            Buffer limit = readBuffer.limit(0);
            setGrabbed(isGrabbed);
        }
    }

    public static void destroy() {
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if (created) {
                    created = false;
                    buttons = null;
                    coord_buffer = null;
                    implementation.destroyMouse();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static int getButtonCount() {
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                th = buttonCount;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int getButtonIndex(String str) {
        int i;
        String str2 = str;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                Integer num = (Integer) buttonMap.get(str2);
                if (num == null) {
                    return -1;
                }
                th = num.intValue();
                return i;
            } finally {
                i = th;
                Object obj2 = obj;
                Throwable th = i;
            }
        }
    }

    public static String getButtonName(int i) {
        String str;
        int i2 = i;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if (i2 >= buttonName.length || i2 < 0) {
                    return null;
                }
                th = buttonName[i2];
                return str;
            } finally {
                str = th;
                Object obj2 = obj;
                Throwable th = str;
            }
        }
    }

    public static int getDWheel() {
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                th = dwheel;
                dwheel = 0;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int getDX() {
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                th = f191dx;
                f191dx = 0;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int getDY() {
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                th = f192dy;
                f192dy = 0;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int getEventButton() {
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                th = eventButton;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static boolean getEventButtonState() {
        boolean z = OpenGLPackageAccess.global_lock;
        synchronized (z) {
            try {
                th = eventState;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int getEventDWheel() {
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                th = event_dwheel;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int getEventDX() {
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                th = event_dx;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int getEventDY() {
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                th = event_dy;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static long getEventNanoseconds() {
        long j = OpenGLPackageAccess.global_lock;
        synchronized (j) {
            try {
                th = event_nanos;
            } finally {
                Throwable th = th;
                long j2 = j;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int getEventX() {
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                th = event_x;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int getEventY() {
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                th = event_y;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    static InputImplementation getImplementation() {
        return implementation;
    }

    public static Cursor getNativeCursor() {
        Cursor cursor = OpenGLPackageAccess.global_lock;
        synchronized (cursor) {
            try {
                th = currentCursor;
            } finally {
                Throwable th = th;
                Cursor cursor2 = cursor;
                Throwable th2 = th;
            }
        }
        return th;
    }

    static boolean getPrivilegedBoolean(String str) {
        C07551 r4;
        C07551 r1 = r4;
        final String str2 = str;
        C07551 r2 = new PrivilegedAction<Boolean>() {
            public Boolean run() {
                return Boolean.valueOf(Boolean.getBoolean(str2));
            }
        };
        return ((Boolean) AccessController.doPrivileged(r1)).booleanValue();
    }

    public static int getX() {
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                th = f193x;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int getY() {
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                th = f194y;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static boolean hasWheel() {
        boolean z = OpenGLPackageAccess.global_lock;
        synchronized (z) {
            try {
                th = hasWheel;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    private static void initialize() {
        StringBuilder sb;
        Sys.initialize();
        buttonName = new String[16];
        for (int i = 0; i < 16; i++) {
            String[] strArr = buttonName;
            int i2 = i;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            strArr[i2] = sb2.append("BUTTON").append(i).toString();
            Object put = buttonMap.put(buttonName[i], Integer.valueOf(i));
        }
        initialized = true;
    }

    /* JADX INFO: finally extract failed */
    public static boolean isButtonDown(int i) {
        IllegalStateException illegalStateException;
        int i2 = i;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if (!created) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Mouse must be created before you can poll the button state");
                    throw illegalStateException2;
                } else if (i2 >= buttonCount || i2 < 0) {
                    return false;
                } else {
                    boolean z = false;
                    if (buttons.get(i2) == 1) {
                        z = true;
                    }
                    return z;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static boolean isClipMouseCoordinatesToWindow() {
        return clipMouseCoordinatesToWindow;
    }

    public static boolean isCreated() {
        boolean z = OpenGLPackageAccess.global_lock;
        synchronized (z) {
            try {
                th = created;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static boolean isGrabbed() {
        boolean z = OpenGLPackageAccess.global_lock;
        synchronized (z) {
            try {
                th = isGrabbed;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static boolean isInsideWindow() {
        return implementation.isInsideWindow();
    }

    public static boolean next() {
        boolean z;
        boolean z2;
        IllegalStateException illegalStateException;
        byte b = OpenGLPackageAccess.global_lock;
        synchronized (b) {
            try {
                if (!created) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Mouse must be created before you can read events");
                    throw illegalStateException2;
                } else if (!readBuffer.hasRemaining()) {
                    return false;
                } else {
                    eventButton = readBuffer.get();
                    th = false;
                    if (readBuffer.get() != 0) {
                        z2 = true;
                    }
                    eventState = z2;
                    if (isGrabbed()) {
                        event_dx = readBuffer.getInt();
                        event_dy = readBuffer.getInt();
                        event_x += event_dx;
                        event_y += event_dy;
                        last_event_raw_x = event_x;
                        last_event_raw_y = event_y;
                    } else {
                        int i = readBuffer.getInt();
                        int i2 = readBuffer.getInt();
                        event_dx = i - last_event_raw_x;
                        event_dy = i2 - last_event_raw_y;
                        event_x = i;
                        event_y = i2;
                        last_event_raw_x = i;
                        last_event_raw_y = i2;
                    }
                    if (clipMouseCoordinatesToWindow) {
                        event_x = Math.min(-1 + Display.getWidth(), Math.max(0, event_x));
                        event_y = Math.min(-1 + Display.getHeight(), Math.max(0, event_y));
                    }
                    event_dwheel = readBuffer.getInt();
                    event_nanos = readBuffer.getLong();
                    return true;
                }
            } finally {
                z = th;
                byte b2 = b;
                Throwable th = z;
            }
        }
    }

    public static void poll() {
        IllegalStateException illegalStateException;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if (!created) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Mouse must be created before you can poll it");
                    throw illegalStateException2;
                }
                implementation.pollMouse(coord_buffer, buttons);
                int i = coord_buffer.get(0);
                int i2 = coord_buffer.get(1);
                int i3 = coord_buffer.get(2);
                if (isGrabbed()) {
                    f191dx = i + f191dx;
                    f192dy = i2 + f192dy;
                    f193x = i + f193x;
                    f194y = i2 + f194y;
                    absolute_x = i + absolute_x;
                    absolute_y = i2 + absolute_y;
                } else {
                    f191dx = i - absolute_x;
                    f192dy = i2 - absolute_y;
                    f193x = i;
                    absolute_x = i;
                    f194y = i2;
                    absolute_y = i2;
                }
                if (clipMouseCoordinatesToWindow) {
                    f193x = Math.min(-1 + Display.getWidth(), Math.max(0, f193x));
                    f194y = Math.min(-1 + Display.getHeight(), Math.max(0, f194y));
                }
                dwheel = i3 + dwheel;
                read();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    private static void read() {
        ByteBuffer compact = readBuffer.compact();
        implementation.readMouse(readBuffer);
        Buffer flip = readBuffer.flip();
    }

    private static void resetMouse() {
        dwheel = 0;
        f192dy = 0;
        f191dx = 0;
        Buffer position = readBuffer.position(readBuffer.limit());
    }

    public static void setClipMouseCoordinatesToWindow(boolean z) {
        clipMouseCoordinatesToWindow = z;
    }

    public static void setCursorPosition(int i, int i2) {
        IllegalStateException illegalStateException;
        int i3 = i;
        int i4 = i2;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if (!isCreated()) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Mouse is not created");
                    throw illegalStateException2;
                }
                event_x = i3;
                f193x = i3;
                event_y = i4;
                f194y = i4;
                if (isGrabbed() || (1 & Cursor.getCapabilities()) == 0) {
                    grab_x = i3;
                    grab_y = i4;
                } else {
                    implementation.setCursorPosition(f193x, f194y);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static void setGrabbed(boolean z) {
        boolean z2 = z;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                boolean z3 = isGrabbed;
                isGrabbed = z2;
                if (isCreated()) {
                    if (z2 && !z3) {
                        grab_x = f193x;
                        grab_y = f194y;
                    } else if (!z2 && z3 && (1 & Cursor.getCapabilities()) != 0) {
                        implementation.setCursorPosition(grab_x, grab_y);
                    }
                    implementation.grabMouse(z2);
                    poll();
                    event_x = f193x;
                    event_y = f194y;
                    last_event_raw_x = f193x;
                    last_event_raw_y = f194y;
                    resetMouse();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static Cursor setNativeCursor(Cursor cursor) throws LWJGLException {
        Cursor cursor2;
        IllegalStateException illegalStateException;
        Cursor cursor3 = cursor;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if ((1 & Cursor.getCapabilities()) == 0) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Mouse doesn't support native cursors");
                    throw illegalStateException2;
                }
                cursor2 = currentCursor;
                currentCursor = cursor3;
                if (isCreated()) {
                    if (currentCursor != null) {
                        implementation.setNativeCursor(currentCursor.getHandle());
                        currentCursor.setTimeout();
                    } else {
                        implementation.setNativeCursor(null);
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
        return cursor2;
    }

    public static void updateCursor() {
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if (emulateCursorAnimation && currentCursor != null && currentCursor.hasTimedOut() && isInsideWindow()) {
                    currentCursor.nextCursor();
                    Cursor nativeCursor = setNativeCursor(currentCursor);
                }
            } catch (LWJGLException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
