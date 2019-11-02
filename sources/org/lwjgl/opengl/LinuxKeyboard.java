package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLUtil;

final class LinuxKeyboard {
    private static final int KEYBOARD_BUFFER_SIZE = 50;
    private static final int LockMapIndex = 1;
    private static final long LockMask = 2;
    private static final long NoSymbol = 0;
    private static final long ShiftMask = 1;
    private static final int XLookupBoth = 4;
    private static final int XLookupChars = 2;
    private final int caps_lock_mask;
    private final CharBuffer char_buffer;
    private final ByteBuffer compose_status;
    private int deferred_event_keycode;
    private byte deferred_key_state;
    private int deferred_keycode;
    private long deferred_nanos;
    private final EventQueue event_queue;
    private boolean has_deferred_event;
    private final byte[] key_down_buffer = new byte[256];
    private final int modeswitch_mask;
    private final ByteBuffer native_translation_buffer;
    private final int numlock_mask;
    private final int shift_lock_mask;
    private final int[] temp_translation_buffer;
    private final ByteBuffer tmp_event;
    private final CharsetDecoder utf8_decoder;
    private final long xic;
    private final long xim;

    LinuxKeyboard(long j, long j2) {
        EventQueue eventQueue;
        long j3 = j;
        long j4 = j2;
        EventQueue eventQueue2 = eventQueue;
        EventQueue eventQueue3 = new EventQueue(18);
        this.event_queue = eventQueue2;
        this.tmp_event = ByteBuffer.allocate(18);
        this.temp_translation_buffer = new int[50];
        this.native_translation_buffer = BufferUtils.createByteBuffer(50);
        this.utf8_decoder = Charset.forName("UTF-8").newDecoder();
        this.char_buffer = CharBuffer.allocate(50);
        long modifierMapping = getModifierMapping(j3);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        if (modifierMapping != NoSymbol) {
            int maxKeyPerMod = getMaxKeyPerMod(modifierMapping);
            for (int i5 = 0; i5 < 8; i5++) {
                for (int i6 = 0; i6 < maxKeyPerMod; i6++) {
                    int i7 = 1 << i5;
                    switch ((int) keycodeToKeySym(j3, lookupModifierMap(modifierMapping, i6 + (i5 * maxKeyPerMod)))) {
                        case 65406:
                            i2 |= i7;
                            break;
                        case LinuxKeycodes.XK_Num_Lock /*65407*/:
                            i3 |= i7;
                            break;
                        case LinuxKeycodes.XK_Caps_Lock /*65509*/:
                            if (i5 != 1) {
                                break;
                            } else {
                                i = i7;
                                i4 = 0;
                                break;
                            }
                        case LinuxKeycodes.XK_Shift_Lock /*65510*/:
                            if (i5 == 1 && i == 0) {
                                i4 = i7;
                                break;
                            }
                    }
                }
            }
            freeModifierMapping(modifierMapping);
        }
        this.numlock_mask = i3;
        this.modeswitch_mask = i2;
        this.caps_lock_mask = i;
        this.shift_lock_mask = i4;
        setDetectableKeyRepeat(j3, true);
        this.xim = openIM(j3);
        if (this.xim != NoSymbol) {
            this.xic = createIC(this.xim, j4);
            if (this.xic != NoSymbol) {
                setupIMEventMask(j3, j4, this.xic);
            } else {
                destroy(j3);
            }
        } else {
            this.xic = NoSymbol;
        }
        this.compose_status = allocateComposeStatus();
    }

    private static native ByteBuffer allocateComposeStatus();

    private static native void closeIM(long j);

    private static native long createIC(long j, long j2);

    private static native void destroyIC(long j);

    private void flushDeferredEvent() {
        if (this.has_deferred_event) {
            putKeyboardEvent(this.deferred_keycode, this.deferred_key_state, 0, this.deferred_nanos, false);
            this.has_deferred_event = false;
        }
    }

    private static native void freeModifierMapping(long j);

    private byte getKeyState(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        switch (i2) {
            case 2:
                return 1;
            case 3:
                return 0;
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unknown event_type: ").append(i2).toString());
                throw illegalArgumentException2;
        }
    }

    private static long getKeySym(long j, int i, int i2) {
        long j2 = j;
        int i3 = i;
        int i4 = i2;
        long lookupKeysym = lookupKeysym(j2, i4 + (i3 * 2));
        if (isNoSymbolOrVendorSpecific(lookupKeysym) && i4 == 1) {
            lookupKeysym = lookupKeysym(j2, 0 + (i3 * 2));
        }
        if (isNoSymbolOrVendorSpecific(lookupKeysym) && i3 == 1) {
            lookupKeysym = getKeySym(j2, 0, i4);
        }
        return lookupKeysym;
    }

    private int getKeycode(long j, int i) {
        long j2 = j;
        int mapKeySymToLWJGLKeyCode = LinuxKeycodes.mapKeySymToLWJGLKeyCode(mapEventToKeySym(j2, i));
        if (mapKeySymToLWJGLKeyCode == 0) {
            mapKeySymToLWJGLKeyCode = LinuxKeycodes.mapKeySymToLWJGLKeyCode(lookupKeysym(j2, 0));
        }
        return mapKeySymToLWJGLKeyCode;
    }

    private static native int getMaxKeyPerMod(long j);

    private static native long getModifierMapping(long j);

    private void handleKeyEvent(long j, long j2, int i, int i2, int i3) {
        long j3 = j;
        long j4 = j2;
        int i4 = i;
        int i5 = i2;
        int keycode = getKeycode(j3, i3);
        byte keyState = getKeyState(i4);
        boolean z = keyState == this.key_down_buffer[keycode];
        this.key_down_buffer[keycode] = keyState;
        long j5 = j4 * 1000000;
        if (i4 == 2) {
            if (this.has_deferred_event) {
                if (j5 == this.deferred_nanos && i5 == this.deferred_event_keycode) {
                    this.has_deferred_event = false;
                    z = true;
                } else {
                    flushDeferredEvent();
                }
            }
            translateEvent(j3, keycode, keyState, j5, z);
            return;
        }
        flushDeferredEvent();
        this.has_deferred_event = true;
        this.deferred_keycode = keycode;
        this.deferred_event_keycode = i5;
        this.deferred_nanos = j5;
        this.deferred_key_state = keyState;
    }

    private static boolean isKeypadKeysym(long j) {
        long j2 = j;
        return (65408 <= j2 && j2 <= 65469) || (285212672 <= j2 && j2 <= 285278207);
    }

    private static boolean isNoSymbolOrVendorSpecific(long j) {
        long j2 = j;
        return j2 == NoSymbol || (268435456 & j2) != NoSymbol;
    }

    private static native long keycodeToKeySym(long j, int i);

    private static native long lookupKeysym(long j, int i);

    private static native int lookupModifierMap(long j, int i);

    private static native int lookupString(long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    private int lookupString(long j, int[] iArr) {
        long j2 = j;
        int[] iArr2 = iArr;
        return this.xic != NoSymbol ? lookupStringUnicode(j2, iArr2) : lookupStringISO88591(j2, iArr2);
    }

    private int lookupStringISO88591(long j, int[] iArr) {
        int[] iArr2 = iArr;
        int lookupString = lookupString(j, this.native_translation_buffer, this.compose_status);
        for (int i = 0; i < lookupString; i++) {
            iArr2[i] = 255 & this.native_translation_buffer.get(i);
        }
        return lookupString;
    }

    private int lookupStringUnicode(long j, int[] iArr) {
        int i;
        int[] iArr2 = iArr;
        int utf8LookupString = utf8LookupString(this.xic, j, this.native_translation_buffer, this.native_translation_buffer.position(), this.native_translation_buffer.remaining());
        if (utf8LookupString != 2 && utf8LookupString != 4) {
            return 0;
        }
        Buffer flip = this.native_translation_buffer.flip();
        CoderResult decode = this.utf8_decoder.decode(this.native_translation_buffer, this.char_buffer, true);
        ByteBuffer compact = this.native_translation_buffer.compact();
        Buffer flip2 = this.char_buffer.flip();
        int i2 = 0;
        while (true) {
            i = i2;
            if (!this.char_buffer.hasRemaining() || i >= iArr2.length) {
                CharBuffer compact2 = this.char_buffer.compact();
            } else {
                int i3 = i + 1;
                iArr2[i] = this.char_buffer.get();
                i2 = i3;
            }
        }
        CharBuffer compact22 = this.char_buffer.compact();
        return i;
    }

    private long mapEventToKeySym(long j, int i) {
        long keySym;
        long j2 = j;
        int i2 = i;
        int i3 = (i2 & this.modeswitch_mask) != 0 ? 1 : 0;
        if ((i2 & this.numlock_mask) != 0) {
            keySym = getKeySym(j2, i3, 1);
            if (isKeypadKeysym(keySym)) {
                if ((((long) i2) & (1 | ((long) this.shift_lock_mask))) != NoSymbol) {
                    keySym = getKeySym(j2, i3, 0);
                }
                return keySym;
            }
        }
        if ((3 & ((long) i2)) == NoSymbol) {
            return getKeySym(j2, i3, 0);
        }
        if ((1 & ((long) i2)) == NoSymbol) {
            keySym = getKeySym(j2, i3, 0);
            if ((i2 & this.caps_lock_mask) != 0) {
                return toUpper(keySym);
            }
        } else {
            keySym = getKeySym(j2, i3, 1);
            if ((i2 & this.caps_lock_mask) != 0) {
                return toUpper(keySym);
            }
        }
        return keySym;
    }

    private static native boolean nSetDetectableKeyRepeat(long j, boolean z);

    private static native long openIM(long j);

    private void putKeyboardEvent(int i, byte b, int i2, long j, boolean z) {
        int i3 = i;
        byte b2 = b;
        int i4 = i2;
        long j2 = j;
        boolean z2 = z;
        Buffer clear = this.tmp_event.clear();
        ByteBuffer put = this.tmp_event.putInt(i3).put(b2).putInt(i4).putLong(j2).put(z2 ? (byte) 1 : 0);
        Buffer flip = this.tmp_event.flip();
        boolean putEvent = this.event_queue.putEvent(this.tmp_event);
    }

    private static void setDetectableKeyRepeat(long j, boolean z) {
        StringBuilder sb;
        boolean z2 = z;
        if (!nSetDetectableKeyRepeat(j, z2)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Failed to set detectable key repeat to ").append(z2).toString());
        }
    }

    private static native void setupIMEventMask(long j, long j2, long j3);

    private static native long toUpper(long j);

    private void translateEvent(long j, int i, byte b, long j2, boolean z) {
        int i2 = i;
        byte b2 = b;
        long j3 = j2;
        boolean z2 = z;
        int lookupString = lookupString(j, this.temp_translation_buffer);
        if (lookupString > 0) {
            putKeyboardEvent(i2, b2, this.temp_translation_buffer[0], j3, z2);
            for (int i3 = 1; i3 < lookupString; i3++) {
                putKeyboardEvent(0, 0, this.temp_translation_buffer[i3], j3, z2);
            }
            return;
        }
        putKeyboardEvent(i2, b2, 0, j3, z2);
    }

    private static native int utf8LookupString(long j, long j2, ByteBuffer byteBuffer, int i, int i2);

    public void destroy(long j) {
        long j2 = j;
        if (this.xic != NoSymbol) {
            destroyIC(this.xic);
        }
        if (this.xim != NoSymbol) {
            closeIM(this.xim);
        }
        setDetectableKeyRepeat(j2, false);
    }

    public boolean filterEvent(LinuxEvent linuxEvent) {
        LinuxEvent linuxEvent2 = linuxEvent;
        switch (linuxEvent2.getType()) {
            case 2:
            case 3:
                handleKeyEvent(linuxEvent2.getKeyAddress(), linuxEvent2.getKeyTime(), linuxEvent2.getKeyType(), linuxEvent2.getKeyKeyCode(), linuxEvent2.getKeyState());
                return true;
            default:
                return false;
        }
    }

    public void poll(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        flushDeferredEvent();
        int position = byteBuffer2.position();
        ByteBuffer put = byteBuffer2.put(this.key_down_buffer);
        Buffer position2 = byteBuffer2.position(position);
    }

    public void read(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        flushDeferredEvent();
        this.event_queue.copyEvents(byteBuffer2);
    }
}
