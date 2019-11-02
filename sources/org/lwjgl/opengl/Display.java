package org.lwjgl.opengl;

import java.awt.Canvas;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.HashSet;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengles.ContextAttribs;

public final class Display {

    /* renamed from: b */
    private static float f195b;
    private static ByteBuffer[] cached_icons;
    private static DisplayMode current_mode;
    private static final DisplayImplementation display_impl = createDisplayImplementation();
    private static DrawableLWJGL drawable;
    private static boolean fullscreen;

    /* renamed from: g */
    private static float f196g;
    private static int height = 0;
    private static final DisplayMode initial_mode;
    private static Canvas parent;
    private static boolean parent_resized;

    /* renamed from: r */
    private static float f197r;
    /* access modifiers changed from: private */
    public static final Thread shutdown_hook;
    private static int swap_interval;
    private static String title = "Game";
    private static int width = 0;
    private static boolean window_created;
    private static boolean window_resizable;
    private static boolean window_resized;

    /* renamed from: x */
    private static int f198x = -1;

    /* renamed from: y */
    private static int f199y = -1;

    static {
        C07831 r5;
        RuntimeException runtimeException;
        StringBuilder sb;
        C07831 r2 = r5;
        C07831 r3 = new Thread() {
            public void run() {
                Display.reset();
            }
        };
        shutdown_hook = r2;
        Sys.initialize();
        try {
            DisplayMode init = display_impl.init();
            initial_mode = init;
            current_mode = init;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Initial mode: ").append(initial_mode).toString());
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(lWJGLException);
            throw runtimeException2;
        }
    }

    private Display() {
    }

    static /* synthetic */ int access$402(int i) {
        int i2 = i;
        f198x = i2;
        return i2;
    }

    static /* synthetic */ int access$502(int i) {
        int i2 = i;
        f199y = i2;
        return i2;
    }

    static /* synthetic */ ByteBuffer[] access$602(ByteBuffer[] byteBufferArr) {
        ByteBuffer[] byteBufferArr2 = byteBufferArr;
        cached_icons = byteBufferArr2;
        return byteBufferArr2;
    }

    public static void create() throws LWJGLException {
        PixelFormat pixelFormat;
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat();
        create(pixelFormat2);
    }

    public static void create(PixelFormat pixelFormat) throws LWJGLException {
        PixelFormat pixelFormat2 = pixelFormat;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                create(pixelFormat2, (Drawable) null, (ContextAttribs) null);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static void create(PixelFormat pixelFormat, ContextAttribs contextAttribs) throws LWJGLException {
        PixelFormat pixelFormat2 = pixelFormat;
        ContextAttribs contextAttribs2 = contextAttribs;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                create(pixelFormat2, (Drawable) null, contextAttribs2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static void create(PixelFormat pixelFormat, Drawable drawable2) throws LWJGLException {
        PixelFormat pixelFormat2 = pixelFormat;
        Drawable drawable3 = drawable2;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                create(pixelFormat2, drawable3, (ContextAttribs) null);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static void create(PixelFormat pixelFormat, Drawable drawable2, ContextAttribs contextAttribs) throws LWJGLException {
        C07864 r18;
        ContextGL contextGL;
        NullPointerException nullPointerException;
        IllegalStateException illegalStateException;
        PixelFormat pixelFormat2 = pixelFormat;
        Drawable drawable3 = drawable2;
        ContextAttribs contextAttribs2 = contextAttribs;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                if (isCreated()) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Only one LWJGL context may be instantiated at any one time.");
                    throw illegalStateException2;
                } else if (pixelFormat2 == null) {
                    NullPointerException nullPointerException2 = nullPointerException;
                    NullPointerException nullPointerException3 = new NullPointerException("pixel_format cannot be null");
                    throw nullPointerException2;
                } else {
                    removeShutdownHook();
                    registerShutdownHook();
                    if (isFullscreen()) {
                        switchDisplayMode();
                    }
                    C07864 r12 = r18;
                    C07864 r13 = new DrawableGL() {
                        public void destroy() {
                            Object obj = GlobalLock.lock;
                            synchronized (obj) {
                                try {
                                    if (Display.isCreated()) {
                                        Display.releaseDrawable();
                                        super.destroy();
                                        Display.destroyWindow();
                                        int access$402 = Display.access$402(Display.access$502(-1));
                                        ByteBuffer[] access$602 = Display.access$602(null);
                                        Display.reset();
                                        Display.removeShutdownHook();
                                    }
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    Object obj2 = obj;
                                    throw th2;
                                }
                            }
                        }
                    };
                    C07864 r5 = r12;
                    drawable = r5;
                    try {
                        r5.setPixelFormat(pixelFormat2, contextAttribs2);
                        try {
                            createWindow();
                            try {
                                C07864 r122 = r5;
                                ContextGL contextGL2 = contextGL;
                                ContextGL contextGL3 = new ContextGL(r5.peer_info, contextAttribs2, drawable3 != null ? ((DrawableGL) drawable3).getContext() : null);
                                r122.context = contextGL2;
                                makeCurrentAndSetSwapInterval();
                                initContext();
                            } catch (LWJGLException e) {
                                throw e;
                            } catch (LWJGLException e2) {
                                LWJGLException lWJGLException = e2;
                                destroyWindow();
                                throw lWJGLException;
                            }
                        } catch (LWJGLException e3) {
                            LWJGLException lWJGLException2 = e3;
                            r5.destroy();
                            throw lWJGLException2;
                        }
                    } catch (LWJGLException e4) {
                        LWJGLException lWJGLException3 = e4;
                        display_impl.resetDisplayMode();
                        throw lWJGLException3;
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static void create(PixelFormatLWJGL pixelFormatLWJGL) throws LWJGLException {
        PixelFormatLWJGL pixelFormatLWJGL2 = pixelFormatLWJGL;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                create(pixelFormatLWJGL2, (Drawable) null, (ContextAttribs) null);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static void create(PixelFormatLWJGL pixelFormatLWJGL, Drawable drawable2) throws LWJGLException {
        PixelFormatLWJGL pixelFormatLWJGL2 = pixelFormatLWJGL;
        Drawable drawable3 = drawable2;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                create(pixelFormatLWJGL2, drawable3, (ContextAttribs) null);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static void create(PixelFormatLWJGL pixelFormatLWJGL, Drawable drawable2, ContextAttribs contextAttribs) throws LWJGLException {
        C07875 r13;
        NullPointerException nullPointerException;
        IllegalStateException illegalStateException;
        PixelFormatLWJGL pixelFormatLWJGL2 = pixelFormatLWJGL;
        Drawable drawable3 = drawable2;
        ContextAttribs contextAttribs2 = contextAttribs;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                if (isCreated()) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Only one LWJGL context may be instantiated at any one time.");
                    throw illegalStateException2;
                } else if (pixelFormatLWJGL2 == null) {
                    NullPointerException nullPointerException2 = nullPointerException;
                    NullPointerException nullPointerException3 = new NullPointerException("pixel_format cannot be null");
                    throw nullPointerException2;
                } else {
                    removeShutdownHook();
                    registerShutdownHook();
                    if (isFullscreen()) {
                        switchDisplayMode();
                    }
                    C07875 r10 = r13;
                    C07875 r11 = new DrawableGLES() {
                        public void destroy() {
                            Object obj = GlobalLock.lock;
                            synchronized (obj) {
                                try {
                                    if (Display.isCreated()) {
                                        Display.releaseDrawable();
                                        super.destroy();
                                        Display.destroyWindow();
                                        int access$402 = Display.access$402(Display.access$502(-1));
                                        ByteBuffer[] access$602 = Display.access$602(null);
                                        Display.reset();
                                        Display.removeShutdownHook();
                                    }
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    Object obj2 = obj;
                                    throw th2;
                                }
                            }
                        }

                        public void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL, ContextAttribs contextAttribs) throws LWJGLException {
                            UnsupportedOperationException unsupportedOperationException;
                            PixelFormatLWJGL pixelFormatLWJGL2 = pixelFormatLWJGL;
                            ContextAttribs contextAttribs2 = contextAttribs;
                            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
                            throw unsupportedOperationException2;
                        }
                    };
                    C07875 r5 = r10;
                    drawable = r5;
                    try {
                        r5.setPixelFormat(pixelFormatLWJGL2);
                        try {
                            createWindow();
                            try {
                                r5.createContext(contextAttribs2, drawable3);
                                makeCurrentAndSetSwapInterval();
                                initContext();
                            } catch (LWJGLException e) {
                                LWJGLException lWJGLException = e;
                                r5.destroy();
                                throw lWJGLException;
                            } catch (LWJGLException e2) {
                                LWJGLException lWJGLException2 = e2;
                                destroyWindow();
                                throw lWJGLException2;
                            }
                        } catch (LWJGLException e3) {
                            LWJGLException lWJGLException3 = e3;
                            r5.destroy();
                            throw lWJGLException3;
                        }
                    } catch (LWJGLException e4) {
                        LWJGLException lWJGLException4 = e4;
                        display_impl.resetDisplayMode();
                        throw lWJGLException4;
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static void create(PixelFormatLWJGL pixelFormatLWJGL, ContextAttribs contextAttribs) throws LWJGLException {
        PixelFormatLWJGL pixelFormatLWJGL2 = pixelFormatLWJGL;
        ContextAttribs contextAttribs2 = contextAttribs;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                create(pixelFormatLWJGL2, (Drawable) null, contextAttribs2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    private static DisplayImplementation createDisplayImplementation() {
        AndroidDisplay androidDisplay;
        MacOSXDisplay macOSXDisplay;
        WindowsDisplay windowsDisplay;
        LinuxDisplay linuxDisplay;
        IllegalStateException illegalStateException;
        switch (LWJGLUtil.getPlatform()) {
            case 1:
                LinuxDisplay linuxDisplay2 = linuxDisplay;
                LinuxDisplay linuxDisplay3 = new LinuxDisplay();
                return linuxDisplay2;
            case 2:
                MacOSXDisplay macOSXDisplay2 = macOSXDisplay;
                MacOSXDisplay macOSXDisplay3 = new MacOSXDisplay();
                return macOSXDisplay2;
            case 3:
                WindowsDisplay windowsDisplay2 = windowsDisplay;
                WindowsDisplay windowsDisplay3 = new WindowsDisplay();
                return windowsDisplay2;
            case LWJGLUtil.PLATFORM_ANDROID /*1337*/:
                AndroidDisplay androidDisplay2 = androidDisplay;
                AndroidDisplay androidDisplay3 = new AndroidDisplay();
                return androidDisplay2;
            default:
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Unsupported platform");
                throw illegalStateException2;
        }
    }

    private static void createWindow() throws LWJGLException {
        LWJGLException lWJGLException;
        if (!window_created) {
            Canvas canvas = isFullscreen() ? null : parent;
            if (canvas == null || canvas.isDisplayable()) {
                display_impl.createWindow(drawable, getEffectiveMode(), canvas, getWindowX(), getWindowY());
                window_created = true;
                width = getDisplayMode().getWidth();
                height = getDisplayMode().getHeight();
                setTitle(title);
                initControls();
                if (cached_icons != null) {
                    int icon = setIcon(cached_icons);
                } else {
                    int icon2 = setIcon(new ByteBuffer[]{LWJGLUtil.LWJGLIcon32x32, LWJGLUtil.LWJGLIcon16x16});
                }
            } else {
                LWJGLException lWJGLException2 = lWJGLException;
                LWJGLException lWJGLException3 = new LWJGLException("Parent.isDisplayable() must be true");
                throw lWJGLException2;
            }
        }
    }

    public static void destroy() {
        if (isCreated()) {
            drawable.destroy();
        }
    }

    /* access modifiers changed from: private */
    public static void destroyWindow() {
        if (window_created) {
            releaseDrawable();
            if (Mouse.isCreated()) {
                Mouse.destroy();
            }
            if (Keyboard.isCreated()) {
                Keyboard.destroy();
            }
            display_impl.destroyWindow();
            window_created = false;
        }
    }

    public static String getAdapter() {
        String str = GlobalLock.lock;
        synchronized (str) {
            try {
                th = display_impl.getAdapter();
            } finally {
                Throwable th = th;
                String str2 = str;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static DisplayMode[] getAvailableDisplayModes() throws LWJGLException {
        DisplayMode[] displayModeArr;
        HashSet hashSet;
        StringBuilder sb;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                DisplayMode[] availableDisplayModes = display_impl.getAvailableDisplayModes();
                if (availableDisplayModes == null) {
                    th = new DisplayMode[0];
                    return displayModeArr;
                }
                HashSet hashSet2 = hashSet;
                HashSet hashSet3 = new HashSet(availableDisplayModes.length);
                HashSet hashSet4 = hashSet2;
                boolean addAll = hashSet4.addAll(Arrays.asList(availableDisplayModes));
                DisplayMode[] displayModeArr2 = new DisplayMode[hashSet4.size()];
                Object[] array = hashSet4.toArray(displayModeArr2);
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Removed ").append(availableDisplayModes.length - displayModeArr2.length).append(" duplicate displaymodes").toString());
                return displayModeArr2;
            } finally {
                displayModeArr = th;
                Object obj2 = obj;
                Throwable th = displayModeArr;
            }
        }
    }

    public static DisplayMode getDesktopDisplayMode() {
        return initial_mode;
    }

    public static DisplayMode getDisplayMode() {
        return current_mode;
    }

    public static Drawable getDrawable() {
        return drawable;
    }

    private static DisplayMode getEffectiveMode() {
        DisplayMode displayMode;
        if (isFullscreen() || parent == null) {
            return current_mode;
        }
        DisplayMode displayMode2 = displayMode;
        DisplayMode displayMode3 = new DisplayMode(parent.getWidth(), parent.getHeight());
        return displayMode2;
    }

    public static int getHeight() {
        return isFullscreen() ? getDisplayMode().getHeight() : parent != null ? parent.getHeight() : height;
    }

    static DisplayImplementation getImplementation() {
        return display_impl;
    }

    public static Canvas getParent() {
        Canvas canvas = GlobalLock.lock;
        synchronized (canvas) {
            try {
                th = parent;
            } finally {
                Throwable th = th;
                Canvas canvas2 = canvas;
                Throwable th2 = th;
            }
        }
        return th;
    }

    static boolean getPrivilegedBoolean(String str) {
        C07886 r4;
        C07886 r1 = r4;
        final String str2 = str;
        C07886 r2 = new PrivilegedAction<Boolean>() {
            public Boolean run() {
                return Boolean.valueOf(Boolean.getBoolean(str2));
            }
        };
        return ((Boolean) AccessController.doPrivileged(r1)).booleanValue();
    }

    public static String getTitle() {
        String str = GlobalLock.lock;
        synchronized (str) {
            try {
                th = title;
            } finally {
                Throwable th = th;
                String str2 = str;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static String getVersion() {
        String str = GlobalLock.lock;
        synchronized (str) {
            try {
                th = display_impl.getVersion();
            } finally {
                Throwable th = th;
                String str2 = str;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int getWidth() {
        return isFullscreen() ? getDisplayMode().getWidth() : parent != null ? parent.getWidth() : width;
    }

    private static int getWindowX() {
        int i = 0;
        if (!isFullscreen()) {
            i = 0;
            if (parent == null) {
                if (f198x != -1) {
                    return f198x;
                }
                i = Math.max(0, (initial_mode.getWidth() - current_mode.getWidth()) / 2);
            }
        }
        return i;
    }

    private static int getWindowY() {
        int i = 0;
        if (!isFullscreen()) {
            i = 0;
            if (parent == null) {
                if (f199y != -1) {
                    return f199y;
                }
                i = Math.max(0, (initial_mode.getHeight() - current_mode.getHeight()) / 2);
            }
        }
        return i;
    }

    public static int getX() {
        if (isFullscreen()) {
            return 0;
        }
        return parent != null ? parent.getX() : display_impl.getX();
    }

    public static int getY() {
        if (isFullscreen()) {
            return 0;
        }
        return parent != null ? parent.getY() : display_impl.getY();
    }

    private static void initContext() {
        drawable.initContext(f197r, f196g, f195b);
        update();
    }

    private static void initControls() {
        if (!getPrivilegedBoolean("org.lwjgl.opengl.Display.noinput")) {
            if (!Mouse.isCreated() && !getPrivilegedBoolean("org.lwjgl.opengl.Display.nomouse")) {
                try {
                    Mouse.create();
                } catch (LWJGLException e) {
                    e.printStackTrace(System.err);
                }
            }
            if (!Keyboard.isCreated() && !getPrivilegedBoolean("org.lwjgl.opengl.Display.nokeyboard")) {
                try {
                    Keyboard.create();
                } catch (LWJGLException e2) {
                    e2.printStackTrace(System.err);
                }
            }
        }
    }

    public static boolean isActive() {
        boolean z;
        IllegalStateException illegalStateException;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                if (!isCreated()) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Cannot determine focused state of uncreated window");
                    throw illegalStateException2;
                }
                th = display_impl.isActive();
            } finally {
                z = th;
                Object obj2 = obj;
                Throwable th = z;
            }
        }
        return z;
    }

    public static boolean isCloseRequested() {
        boolean z;
        IllegalStateException illegalStateException;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                if (!isCreated()) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Cannot determine close requested state of uncreated window");
                    throw illegalStateException2;
                }
                th = display_impl.isCloseRequested();
            } finally {
                z = th;
                Object obj2 = obj;
                Throwable th = z;
            }
        }
        return z;
    }

    public static boolean isCreated() {
        boolean z = GlobalLock.lock;
        synchronized (z) {
            try {
                th = window_created;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static boolean isCurrent() throws LWJGLException {
        return drawable.isCurrent();
    }

    public static boolean isDirty() {
        boolean z;
        IllegalStateException illegalStateException;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                if (!isCreated()) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Cannot determine dirty state of uncreated window");
                    throw illegalStateException2;
                }
                th = display_impl.isDirty();
            } finally {
                z = th;
                Object obj2 = obj;
                Throwable th = z;
            }
        }
        return z;
    }

    public static boolean isFullscreen() {
        boolean z = GlobalLock.lock;
        synchronized (z) {
            try {
                th = fullscreen && current_mode.isFullscreenCapable();
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static boolean isResizable() {
        return window_resizable;
    }

    public static boolean isVisible() {
        boolean z;
        IllegalStateException illegalStateException;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                if (!isCreated()) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Cannot determine minimized state of uncreated window");
                    throw illegalStateException2;
                }
                th = display_impl.isVisible();
            } finally {
                z = th;
                Object obj2 = obj;
                Throwable th = z;
            }
        }
        return z;
    }

    public static void makeCurrent() throws LWJGLException {
        drawable.makeCurrent();
    }

    private static void makeCurrentAndSetSwapInterval() throws LWJGLException {
        StringBuilder sb;
        makeCurrent();
        try {
            drawable.checkGLError();
        } catch (OpenGLException e) {
            OpenGLException openGLException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("OpenGL error during context creation: ").append(openGLException.getMessage()).toString());
        }
        setSwapInterval(swap_interval);
    }

    static void pollDevices() {
        if (Mouse.isCreated()) {
            Mouse.poll();
            Mouse.updateCursor();
        }
        if (Keyboard.isCreated()) {
            Keyboard.poll();
        }
        if (Controllers.isCreated()) {
            Controllers.poll();
        }
    }

    public static void processMessages() {
        IllegalStateException illegalStateException;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                if (!isCreated()) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Display not created");
                    throw illegalStateException2;
                }
                display_impl.update();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
        pollDevices();
    }

    private static void registerShutdownHook() {
        C07853 r2;
        C07853 r0 = r2;
        C07853 r1 = new PrivilegedAction<Object>() {
            public Object run() {
                Runtime.getRuntime().addShutdownHook(Display.shutdown_hook);
                return null;
            }
        };
        Object doPrivileged = AccessController.doPrivileged(r0);
    }

    public static void releaseContext() throws LWJGLException {
        drawable.releaseContext();
    }

    /* access modifiers changed from: private */
    public static void releaseDrawable() {
        StringBuilder sb;
        try {
            Context context = drawable.getContext();
            if (context != null && context.isCurrent()) {
                context.releaseCurrent();
                context.releaseDrawable();
            }
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Exception occurred while trying to release context: ").append(lWJGLException).toString());
        }
    }

    /* access modifiers changed from: private */
    public static void removeShutdownHook() {
        C07842 r2;
        C07842 r0 = r2;
        C07842 r1 = new PrivilegedAction<Object>() {
            public Object run() {
                boolean removeShutdownHook = Runtime.getRuntime().removeShutdownHook(Display.shutdown_hook);
                return null;
            }
        };
        Object doPrivileged = AccessController.doPrivileged(r0);
    }

    /* access modifiers changed from: private */
    public static void reset() {
        display_impl.resetDisplayMode();
        current_mode = initial_mode;
    }

    private static void reshape() {
        DisplayMode effectiveMode = getEffectiveMode();
        display_impl.reshape(getWindowX(), getWindowY(), effectiveMode.getWidth(), effectiveMode.getHeight());
    }

    public static void setDisplayConfiguration(float f, float f2, float f3) throws LWJGLException {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        LWJGLException lWJGLException;
        IllegalArgumentException illegalArgumentException2;
        LWJGLException lWJGLException2;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        int i = GlobalLock.lock;
        synchronized (i) {
            try {
                if (!isCreated()) {
                    LWJGLException lWJGLException3 = lWJGLException2;
                    LWJGLException lWJGLException4 = new LWJGLException("Display not yet created.");
                    throw lWJGLException3;
                } else if (f5 < -1.0f || f5 > 1.0f) {
                    IllegalArgumentException illegalArgumentException3 = illegalArgumentException;
                    IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Invalid brightness value");
                    throw illegalArgumentException3;
                } else if (f6 < 0.0f) {
                    IllegalArgumentException illegalArgumentException5 = illegalArgumentException2;
                    IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("Invalid contrast value");
                    throw illegalArgumentException5;
                } else {
                    th = display_impl.getGammaRampLength();
                    if (i == 0) {
                        LWJGLException lWJGLException5 = lWJGLException;
                        LWJGLException lWJGLException6 = new LWJGLException("Display configuration not supported");
                        throw lWJGLException5;
                    }
                    FloatBuffer createFloatBuffer = BufferUtils.createFloatBuffer(i);
                    for (int i2 = 0; i2 < i; i2++) {
                        float pow = 0.5f + (f6 * ((f5 + ((float) Math.pow((double) (((float) i2) / ((float) (i - 1))), (double) f4))) - 0.5f));
                        if (pow > 1.0f) {
                            pow = 1.0f;
                        } else if (pow < 0.0f) {
                            pow = 0.0f;
                        }
                        FloatBuffer put = createFloatBuffer.put(i2, pow);
                    }
                    display_impl.setGammaRamp(createFloatBuffer);
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    LWJGLUtil.log(sb2.append("Gamma set, gamma = ").append(f4).append(", brightness = ").append(f5).append(", contrast = ").append(f6).toString());
                }
            } finally {
                Throwable th = th;
                int i3 = i;
                Throwable th2 = th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004d, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        drawable.destroy();
        display_impl.resetDisplayMode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0059, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r3 = r5;
        r5 = r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:4:0x0009, B:18:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setDisplayMode(org.lwjgl.opengl.DisplayMode r9) throws org.lwjgl.LWJGLException {
        /*
            r0 = r9
            java.lang.Object r5 = org.lwjgl.opengl.GlobalLock.lock
            r1 = r5
            r5 = r1
            monitor-enter(r5)
            r5 = r0
            if (r5 != 0) goto L_0x001a
            java.lang.NullPointerException r5 = new java.lang.NullPointerException     // Catch:{ all -> 0x0014 }
            r8 = r5
            r5 = r8
            r6 = r8
            java.lang.String r7 = "mode must be non-null"
            r6.<init>(r7)     // Catch:{ all -> 0x0014 }
            throw r5     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r5 = move-exception
            r3 = r5
            r5 = r1
            monitor-exit(r5)     // Catch:{ all -> 0x0014 }
            r5 = r3
            throw r5
        L_0x001a:
            boolean r5 = isFullscreen()     // Catch:{ all -> 0x0014 }
            r2 = r5
            r5 = r0
            current_mode = r5     // Catch:{ all -> 0x0014 }
            boolean r5 = isCreated()     // Catch:{ all -> 0x0014 }
            if (r5 == 0) goto L_0x003f
            destroyWindow()     // Catch:{ all -> 0x0014 }
            r5 = r2
            if (r5 == 0) goto L_0x0042
            boolean r5 = isFullscreen()     // Catch:{ LWJGLException -> 0x004c }
            if (r5 != 0) goto L_0x0042
            org.lwjgl.opengl.DisplayImplementation r5 = display_impl     // Catch:{ LWJGLException -> 0x004c }
            r5.resetDisplayMode()     // Catch:{ LWJGLException -> 0x004c }
        L_0x0039:
            createWindow()     // Catch:{ LWJGLException -> 0x004c }
            makeCurrentAndSetSwapInterval()     // Catch:{ LWJGLException -> 0x004c }
        L_0x003f:
            r5 = r1
            monitor-exit(r5)     // Catch:{ all -> 0x0014 }
            return
        L_0x0042:
            boolean r5 = isFullscreen()     // Catch:{ LWJGLException -> 0x004c }
            if (r5 == 0) goto L_0x0039
            switchDisplayMode()     // Catch:{ LWJGLException -> 0x004c }
            goto L_0x0039
        L_0x004c:
            r5 = move-exception
            r4 = r5
            org.lwjgl.opengl.DrawableLWJGL r5 = drawable     // Catch:{ all -> 0x0014 }
            r5.destroy()     // Catch:{ all -> 0x0014 }
            org.lwjgl.opengl.DisplayImplementation r5 = display_impl     // Catch:{ all -> 0x0014 }
            r5.resetDisplayMode()     // Catch:{ all -> 0x0014 }
            r5 = r4
            throw r5     // Catch:{ all -> 0x0014 }
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.Display.setDisplayMode(org.lwjgl.opengl.DisplayMode):void");
    }

    public static void setDisplayModeAndFullscreen(DisplayMode displayMode) throws LWJGLException {
        DisplayMode displayMode2 = displayMode;
        setDisplayModeAndFullscreenInternal(displayMode2.isFullscreenCapable(), displayMode2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        drawable.destroy();
        display_impl.resetDisplayMode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0069, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        r6 = r7;
        r7 = r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:4:0x000a, B:22:0x0044] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void setDisplayModeAndFullscreenInternal(boolean r11, org.lwjgl.opengl.DisplayMode r12) throws org.lwjgl.LWJGLException {
        /*
            r0 = r11
            r1 = r12
            java.lang.Object r7 = org.lwjgl.opengl.GlobalLock.lock
            r2 = r7
            r7 = r2
            monitor-enter(r7)
            r7 = r1
            if (r7 != 0) goto L_0x001b
            java.lang.NullPointerException r7 = new java.lang.NullPointerException     // Catch:{ all -> 0x0015 }
            r10 = r7
            r7 = r10
            r8 = r10
            java.lang.String r9 = "mode must be non-null"
            r8.<init>(r9)     // Catch:{ all -> 0x0015 }
            throw r7     // Catch:{ all -> 0x0015 }
        L_0x0015:
            r7 = move-exception
            r6 = r7
            r7 = r2
            monitor-exit(r7)     // Catch:{ all -> 0x0015 }
            r7 = r6
            throw r7
        L_0x001b:
            org.lwjgl.opengl.DisplayMode r7 = current_mode     // Catch:{ all -> 0x0015 }
            r3 = r7
            r7 = r1
            current_mode = r7     // Catch:{ all -> 0x0015 }
            boolean r7 = isFullscreen()     // Catch:{ all -> 0x0015 }
            r4 = r7
            r7 = r0
            fullscreen = r7     // Catch:{ all -> 0x0015 }
            r7 = r4
            boolean r8 = isFullscreen()     // Catch:{ all -> 0x0015 }
            if (r7 != r8) goto L_0x0038
            r7 = r1
            r8 = r3
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0015 }
            if (r7 != 0) goto L_0x0053
        L_0x0038:
            boolean r7 = isCreated()     // Catch:{ all -> 0x0015 }
            if (r7 != 0) goto L_0x0041
            r7 = r2
            monitor-exit(r7)     // Catch:{ all -> 0x0015 }
        L_0x0040:
            return
        L_0x0041:
            destroyWindow()     // Catch:{ all -> 0x0015 }
            boolean r7 = isFullscreen()     // Catch:{ LWJGLException -> 0x005c }
            if (r7 == 0) goto L_0x0056
            switchDisplayMode()     // Catch:{ LWJGLException -> 0x005c }
        L_0x004d:
            createWindow()     // Catch:{ LWJGLException -> 0x005c }
            makeCurrentAndSetSwapInterval()     // Catch:{ LWJGLException -> 0x005c }
        L_0x0053:
            r7 = r2
            monitor-exit(r7)     // Catch:{ all -> 0x0015 }
            goto L_0x0040
        L_0x0056:
            org.lwjgl.opengl.DisplayImplementation r7 = display_impl     // Catch:{ LWJGLException -> 0x005c }
            r7.resetDisplayMode()     // Catch:{ LWJGLException -> 0x005c }
            goto L_0x004d
        L_0x005c:
            r7 = move-exception
            r5 = r7
            org.lwjgl.opengl.DrawableLWJGL r7 = drawable     // Catch:{ all -> 0x0015 }
            r7.destroy()     // Catch:{ all -> 0x0015 }
            org.lwjgl.opengl.DisplayImplementation r7 = display_impl     // Catch:{ all -> 0x0015 }
            r7.resetDisplayMode()     // Catch:{ all -> 0x0015 }
            r7 = r5
            throw r7     // Catch:{ all -> 0x0015 }
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.Display.setDisplayModeAndFullscreenInternal(boolean, org.lwjgl.opengl.DisplayMode):void");
    }

    public static void setFullscreen(boolean z) throws LWJGLException {
        setDisplayModeAndFullscreenInternal(z, current_mode);
    }

    /* JADX INFO: finally extract failed */
    public static int setIcon(ByteBuffer[] byteBufferArr) {
        ByteBuffer[] byteBufferArr2 = byteBufferArr;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                if (cached_icons != byteBufferArr2) {
                    cached_icons = new ByteBuffer[byteBufferArr2.length];
                    for (int i = 0; i < byteBufferArr2.length; i++) {
                        cached_icons[i] = BufferUtils.createByteBuffer(byteBufferArr2[i].capacity());
                        int position = byteBufferArr2[i].position();
                        ByteBuffer put = cached_icons[i].put(byteBufferArr2[i]);
                        Buffer position2 = byteBufferArr2[i].position(position);
                        Buffer flip = cached_icons[i].flip();
                    }
                }
                if (!isCreated() || parent != null) {
                    return 0;
                }
                int icon = display_impl.setIcon(cached_icons);
                return icon;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static void setInitialBackground(float f, float f2, float f3) {
        float f4 = f2;
        float f5 = f3;
        f197r = f;
        f196g = f4;
        f195b = f5;
    }

    public static void setLocation(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                f198x = i3;
                f199y = i4;
                if (isCreated() && !isFullscreen()) {
                    reshape();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setParent(java.awt.Canvas r6) throws org.lwjgl.LWJGLException {
        /*
            r0 = r6
            java.lang.Object r4 = org.lwjgl.opengl.GlobalLock.lock
            r1 = r4
            r4 = r1
            monitor-enter(r4)
            java.awt.Canvas r4 = parent     // Catch:{ all -> 0x002c }
            r5 = r0
            if (r4 == r5) goto L_0x0029
            r4 = r0
            parent = r4     // Catch:{ all -> 0x002c }
            boolean r4 = isCreated()     // Catch:{ all -> 0x002c }
            if (r4 != 0) goto L_0x0017
            r4 = r1
            monitor-exit(r4)     // Catch:{ all -> 0x002c }
        L_0x0016:
            return
        L_0x0017:
            destroyWindow()     // Catch:{ all -> 0x002c }
            boolean r4 = isFullscreen()     // Catch:{ LWJGLException -> 0x0038 }
            if (r4 == 0) goto L_0x0032
            switchDisplayMode()     // Catch:{ LWJGLException -> 0x0038 }
        L_0x0023:
            createWindow()     // Catch:{ LWJGLException -> 0x0038 }
            makeCurrentAndSetSwapInterval()     // Catch:{ LWJGLException -> 0x0038 }
        L_0x0029:
            r4 = r1
            monitor-exit(r4)     // Catch:{ all -> 0x002c }
            goto L_0x0016
        L_0x002c:
            r4 = move-exception
            r2 = r4
            r4 = r1
            monitor-exit(r4)     // Catch:{ all -> 0x002c }
            r4 = r2
            throw r4
        L_0x0032:
            org.lwjgl.opengl.DisplayImplementation r4 = display_impl     // Catch:{ LWJGLException -> 0x0038 }
            r4.resetDisplayMode()     // Catch:{ LWJGLException -> 0x0038 }
            goto L_0x0023
        L_0x0038:
            r4 = move-exception
            r3 = r4
            org.lwjgl.opengl.DrawableLWJGL r4 = drawable     // Catch:{ all -> 0x002c }
            r4.destroy()     // Catch:{ all -> 0x002c }
            org.lwjgl.opengl.DisplayImplementation r4 = display_impl     // Catch:{ all -> 0x002c }
            r4.resetDisplayMode()     // Catch:{ all -> 0x002c }
            r4 = r3
            throw r4     // Catch:{ all -> 0x002c }
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.Display.setParent(java.awt.Canvas):void");
    }

    public static void setParent(net.zhuoweizhang.makeshift.java.awt.Canvas canvas) {
    }

    public static void setResizable(boolean z) {
        boolean z2 = z;
        window_resizable = z2;
        if (isCreated()) {
            display_impl.setResizable(z2);
        }
    }

    public static void setSwapInterval(int i) {
        int i2 = i;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                swap_interval = i2;
                if (isCreated()) {
                    drawable.setSwapInterval(swap_interval);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static void setTitle(String str) {
        String str2 = str;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            if (str2 == null) {
                str2 = LibrariesRepository.MOJANG_MAVEN_REPO;
            }
            try {
                title = str2;
                if (isCreated()) {
                    display_impl.setTitle(title);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static void setVSyncEnabled(boolean z) {
        boolean z2 = z;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                setSwapInterval(z2 ? 1 : 0);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static void swapBuffers() throws LWJGLException {
        IllegalStateException illegalStateException;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                if (!isCreated()) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Display not created");
                    throw illegalStateException2;
                }
                drawable.checkGLError();
                drawable.swapBuffers();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    private static void switchDisplayMode() throws LWJGLException {
        IllegalStateException illegalStateException;
        if (!current_mode.isFullscreenCapable()) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Only modes acquired from getAvailableDisplayModes() can be used for fullscreen display");
            throw illegalStateException2;
        }
        display_impl.switchDisplayMode(current_mode);
    }

    public static void sync(int i) {
        Sync.sync(i);
    }

    public static void update() {
        update(true);
    }

    public static void update(boolean z) {
        RuntimeException runtimeException;
        IllegalStateException illegalStateException;
        boolean z2 = z;
        boolean z3 = true;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            if (!isCreated()) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Display not created");
                throw illegalStateException2;
            }
            if (display_impl.isVisible() || display_impl.isDirty()) {
                try {
                    swapBuffers();
                } catch (LWJGLException e) {
                    LWJGLException lWJGLException = e;
                    RuntimeException runtimeException2 = runtimeException;
                    RuntimeException runtimeException3 = new RuntimeException(lWJGLException);
                    throw runtimeException2;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
            if (isFullscreen() || parent != null || !display_impl.wasResized()) {
                z3 = false;
            }
            window_resized = z3;
            if (window_resized) {
                width = display_impl.getWidth();
                height = display_impl.getHeight();
            }
            if (parent_resized) {
                reshape();
                parent_resized = false;
                window_resized = true;
            }
            if (z2) {
                processMessages();
            }
        }
    }

    public static boolean wasResized() {
        return window_resized;
    }
}
