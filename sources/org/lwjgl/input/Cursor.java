package org.lwjgl.input;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.NondirectBufferWrapper;
import org.lwjgl.Sys;

public class Cursor {
    public static final int CURSOR_8_BIT_ALPHA = 2;
    public static final int CURSOR_ANIMATION = 4;
    public static final int CURSOR_ONE_BIT_TRANSPARENCY = 1;
    private final CursorElement[] cursors;
    private boolean destroyed;
    private int index;

    private static class CursorElement {
        final Object cursorHandle;
        final long delay;
        long timeout;

        CursorElement(Object obj, long j, long j2) {
            long j3 = j;
            long j4 = j2;
            this.cursorHandle = obj;
            this.delay = j3;
            this.timeout = j4;
        }
    }

    public Cursor(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        IllegalStateException illegalStateException;
        LWJGLException lWJGLException;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        th = intBuffer;
        IntBuffer intBuffer3 = intBuffer2;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if ((1 & getCapabilities()) == 0) {
                    LWJGLException lWJGLException2 = lWJGLException;
                    LWJGLException lWJGLException3 = new LWJGLException("Native cursors not supported");
                    throw lWJGLException2;
                }
                IntBuffer wrapBuffer = NondirectBufferWrapper.wrapBuffer(th, i10 * i6 * i7);
                if (intBuffer3 != null) {
                    intBuffer3 = NondirectBufferWrapper.wrapBuffer(intBuffer3, i10);
                }
                if (!Mouse.isCreated()) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Mouse must be created before creating cursor objects");
                    throw illegalStateException2;
                } else if (i10 * i6 * i7 > wrapBuffer.remaining()) {
                    IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
                    IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("width*height*numImages > images.remaining()");
                    throw illegalArgumentException4;
                } else if (i8 >= i6 || i8 < 0) {
                    IllegalArgumentException illegalArgumentException6 = illegalArgumentException;
                    IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("xHotspot > width || xHotspot < 0");
                    throw illegalArgumentException6;
                } else if (i9 >= i7 || i9 < 0) {
                    IllegalArgumentException illegalArgumentException8 = illegalArgumentException2;
                    IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("yHotspot > height || yHotspot < 0");
                    throw illegalArgumentException8;
                } else {
                    Sys.initialize();
                    this.cursors = createCursors(i6, i7, i8, (i7 - 1) - i9, i10, wrapBuffer, intBuffer3);
                }
            } finally {
                Throwable th = th;
                Object obj2 = obj;
                Throwable th2 = th;
            }
        }
    }

    private void checkValid() {
        IllegalStateException illegalStateException;
        if (this.destroyed) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("The cursor is destroyed");
            throw illegalStateException2;
        }
    }

    private static void convertARGBtoABGR(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        for (int i = 0; i < intBuffer2.limit(); i++) {
            int i2 = intBuffer2.get(i);
            byte b = (byte) (i2 >>> 8);
            byte b2 = (byte) i2;
            IntBuffer put = intBuffer2.put(i, ((((byte) (i2 >>> 24)) & 255) << 24) + ((b2 & 255) << 16) + ((b & 255) << 8) + (((byte) (i2 >>> 16)) & 255));
        }
    }

    private static CursorElement[] createCursors(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException {
        CursorElement[] cursorElementArr;
        CursorElement cursorElement;
        CursorElement cursorElement2;
        CursorElement cursorElement3;
        RuntimeException runtimeException;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(intBuffer3.remaining());
        flipImages(i6, i7, i10, intBuffer3, createIntBuffer);
        switch (LWJGLUtil.getPlatform()) {
            case 1:
                CursorElement cursorElement4 = cursorElement;
                CursorElement cursorElement5 = new CursorElement(Mouse.getImplementation().createCursor(i6, i7, i8, i9, i10, createIntBuffer, intBuffer4), -1, -1);
                cursorElementArr = new CursorElement[1];
                cursorElementArr[0] = cursorElement4;
                break;
            case 2:
                convertARGBtoABGR(createIntBuffer);
                cursorElementArr = new CursorElement[i10];
                for (int i11 = 0; i11 < i10; i11++) {
                    CursorElement[] cursorElementArr2 = cursorElementArr;
                    int i12 = i11;
                    CursorElement cursorElement6 = cursorElement3;
                    CursorElement cursorElement7 = new CursorElement(Mouse.getImplementation().createCursor(i6, i7, i8, i9, 1, createIntBuffer, null), intBuffer4 != null ? (long) intBuffer4.get(i11) : 0, System.currentTimeMillis());
                    cursorElementArr2[i12] = cursorElement6;
                    Buffer position = createIntBuffer.position(i6 * i7 * (i11 + 1));
                }
                break;
            case 3:
                cursorElementArr = new CursorElement[i10];
                for (int i13 = 0; i13 < i10; i13++) {
                    int i14 = i6 * i7;
                    for (int i15 = 0; i15 < i14; i15++) {
                        int i16 = i15 + (i13 * i14);
                        if ((255 & (createIntBuffer.get(i16) >> 24)) != 255) {
                            IntBuffer put = createIntBuffer.put(i16, 0);
                        }
                    }
                    CursorElement[] cursorElementArr3 = cursorElementArr;
                    int i17 = i13;
                    CursorElement cursorElement8 = cursorElement2;
                    CursorElement cursorElement9 = new CursorElement(Mouse.getImplementation().createCursor(i6, i7, i8, i9, 1, createIntBuffer, null), intBuffer4 != null ? (long) intBuffer4.get(i13) : 0, System.currentTimeMillis());
                    cursorElementArr3[i17] = cursorElement8;
                    Buffer position2 = createIntBuffer.position(i6 * i7 * (i13 + 1));
                }
                break;
            default:
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("Unknown OS");
                throw runtimeException2;
        }
        return cursorElementArr;
    }

    private static void flipImage(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        for (int i7 = 0; i7 < (i5 >> 1); i7++) {
            int i8 = i6 + (i7 * i4);
            int i9 = i6 + (i4 * (-1 + (i5 - i7)));
            for (int i10 = 0; i10 < i4; i10++) {
                int i11 = i8 + i10;
                int i12 = i9 + i10;
                int i13 = intBuffer3.get(i11 + intBuffer3.position());
                IntBuffer put = intBuffer4.put(i11, intBuffer3.get(i12 + intBuffer3.position()));
                IntBuffer put2 = intBuffer4.put(i12, i13);
            }
        }
    }

    private static void flipImages(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        for (int i7 = 0; i7 < i6; i7++) {
            flipImage(i4, i5, i5 * i7 * i4, intBuffer3, intBuffer4);
        }
    }

    public static int getCapabilities() {
        int i;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if (Mouse.getImplementation() != null) {
                    th = Mouse.getImplementation().getNativeCursorCapabilities();
                    return i;
                }
                int nativeCursorCapabilities = OpenGLPackageAccess.createImplementation().getNativeCursorCapabilities();
                return nativeCursorCapabilities;
            } finally {
                i = th;
                Object obj2 = obj;
                Throwable th = i;
            }
        }
    }

    public static int getMaxCursorSize() {
        int i;
        IllegalStateException illegalStateException;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if (!Mouse.isCreated()) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Mouse must be created.");
                    throw illegalStateException2;
                }
                th = Mouse.getImplementation().getMaxCursorSize();
            } finally {
                i = th;
                Object obj2 = obj;
                Throwable th = i;
            }
        }
        return i;
    }

    public static int getMinCursorSize() {
        int i;
        IllegalStateException illegalStateException;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if (!Mouse.isCreated()) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Mouse must be created.");
                    throw illegalStateException2;
                }
                th = Mouse.getImplementation().getMinCursorSize();
            } finally {
                i = th;
                Object obj2 = obj;
                Throwable th = i;
            }
        }
        return i;
    }

    public void destroy() {
        r1 = OpenGLPackageAccess.global_lock;
        synchronized (r1) {
            try {
                if (!this.destroyed) {
                    if (Mouse.getNativeCursor() == this) {
                        try {
                            Cursor nativeCursor = Mouse.setNativeCursor(null);
                        } catch (LWJGLException e) {
                            LWJGLException lWJGLException = e;
                        }
                    }
                    CursorElement[] cursorElementArr = this.cursors;
                    int length = cursorElementArr.length;
                    for (int i = 0; i < length; i++) {
                        Mouse.getImplementation().destroyCursor(cursorElementArr[i].cursorHandle);
                    }
                    this.destroyed = true;
                }
            } finally {
                Throwable th = th;
                Object obj = r1;
                Throwable th2 = th;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public Object getHandle() {
        checkValid();
        return this.cursors[this.index].cursorHandle;
    }

    /* access modifiers changed from: protected */
    public boolean hasTimedOut() {
        checkValid();
        return this.cursors.length > 1 && this.cursors[this.index].timeout < System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void nextCursor() {
        checkValid();
        int i = 1 + this.index;
        this.index = i;
        this.index = i % this.cursors.length;
    }

    /* access modifiers changed from: protected */
    public void setTimeout() {
        checkValid();
        this.cursors[this.index].timeout = System.currentTimeMillis() + this.cursors[this.index].delay;
    }
}
