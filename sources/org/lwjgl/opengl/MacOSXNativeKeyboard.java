package org.lwjgl.opengl;

import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.HashMap;

final class MacOSXNativeKeyboard extends EventQueue {
    private int deferred_character;
    private int deferred_key_code;
    private byte deferred_key_state;
    private long deferred_nanos;
    private final ByteBuffer event = ByteBuffer.allocate(18);
    private boolean has_deferred_event;
    private final byte[] key_states = new byte[256];
    private HashMap<Short, Integer> nativeToLwjglMap;
    private ByteBuffer window_handle;

    MacOSXNativeKeyboard(ByteBuffer byteBuffer) {
        HashMap<Short, Integer> hashMap;
        ByteBuffer byteBuffer2 = byteBuffer;
        super(18);
        HashMap<Short, Integer> hashMap2 = hashMap;
        HashMap<Short, Integer> hashMap3 = new HashMap<>();
        this.nativeToLwjglMap = hashMap2;
        initKeyboardMappings();
        this.window_handle = byteBuffer2;
    }

    private void flushDeferredEvent() {
        if (this.has_deferred_event) {
            putKeyEvent(this.deferred_key_code, this.deferred_key_state, this.deferred_character, this.deferred_nanos, false);
            this.has_deferred_event = false;
        }
    }

    private int getMappedKeyCode(short s) {
        short s2 = s;
        if (this.nativeToLwjglMap.containsKey(Short.valueOf(s2))) {
            return ((Integer) this.nativeToLwjglMap.get(Short.valueOf(s2))).intValue();
        }
        return -1;
    }

    /* JADX INFO: finally extract failed */
    private void handleKey(int i, byte b, int i2, long j) {
        int i3 = i;
        byte b2 = b;
        int i4 = i2;
        long j2 = j;
        synchronized (this) {
            if (i4 == 65535) {
                i4 = 0;
            }
            if (b2 == 1) {
                try {
                    boolean z = false;
                    if (this.has_deferred_event) {
                        if (j2 == this.deferred_nanos && this.deferred_key_code == i3) {
                            this.has_deferred_event = false;
                            z = true;
                        } else {
                            flushDeferredEvent();
                            z = false;
                        }
                    }
                    putKeyEvent(i3, b2, i4, j2, z);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            } else {
                flushDeferredEvent();
                this.has_deferred_event = true;
                this.deferred_nanos = j2;
                this.deferred_key_code = i3;
                this.deferred_key_state = b2;
                this.deferred_character = i4;
            }
        }
    }

    private void initKeyboardMappings() {
        Object put = this.nativeToLwjglMap.put(Short.valueOf(29), Integer.valueOf(11));
        Object put2 = this.nativeToLwjglMap.put(Short.valueOf(18), Integer.valueOf(2));
        Object put3 = this.nativeToLwjglMap.put(Short.valueOf(19), Integer.valueOf(3));
        Object put4 = this.nativeToLwjglMap.put(Short.valueOf(20), Integer.valueOf(4));
        Object put5 = this.nativeToLwjglMap.put(Short.valueOf(21), Integer.valueOf(5));
        Object put6 = this.nativeToLwjglMap.put(Short.valueOf(23), Integer.valueOf(6));
        Object put7 = this.nativeToLwjglMap.put(Short.valueOf(22), Integer.valueOf(7));
        Object put8 = this.nativeToLwjglMap.put(Short.valueOf(26), Integer.valueOf(8));
        Object put9 = this.nativeToLwjglMap.put(Short.valueOf(28), Integer.valueOf(9));
        Object put10 = this.nativeToLwjglMap.put(Short.valueOf(25), Integer.valueOf(10));
        Object put11 = this.nativeToLwjglMap.put(Short.valueOf(0), Integer.valueOf(30));
        Object put12 = this.nativeToLwjglMap.put(Short.valueOf(11), Integer.valueOf(48));
        Object put13 = this.nativeToLwjglMap.put(Short.valueOf(8), Integer.valueOf(46));
        Object put14 = this.nativeToLwjglMap.put(Short.valueOf(2), Integer.valueOf(32));
        Object put15 = this.nativeToLwjglMap.put(Short.valueOf(14), Integer.valueOf(18));
        Object put16 = this.nativeToLwjglMap.put(Short.valueOf(3), Integer.valueOf(33));
        Object put17 = this.nativeToLwjglMap.put(Short.valueOf(5), Integer.valueOf(34));
        Object put18 = this.nativeToLwjglMap.put(Short.valueOf(4), Integer.valueOf(35));
        Object put19 = this.nativeToLwjglMap.put(Short.valueOf(34), Integer.valueOf(23));
        Object put20 = this.nativeToLwjglMap.put(Short.valueOf(38), Integer.valueOf(36));
        Object put21 = this.nativeToLwjglMap.put(Short.valueOf(40), Integer.valueOf(37));
        Object put22 = this.nativeToLwjglMap.put(Short.valueOf(37), Integer.valueOf(38));
        Object put23 = this.nativeToLwjglMap.put(Short.valueOf(46), Integer.valueOf(50));
        Object put24 = this.nativeToLwjglMap.put(Short.valueOf(45), Integer.valueOf(49));
        Object put25 = this.nativeToLwjglMap.put(Short.valueOf(31), Integer.valueOf(24));
        Object put26 = this.nativeToLwjglMap.put(Short.valueOf(35), Integer.valueOf(25));
        Object put27 = this.nativeToLwjglMap.put(Short.valueOf(12), Integer.valueOf(16));
        Object put28 = this.nativeToLwjglMap.put(Short.valueOf(15), Integer.valueOf(19));
        Object put29 = this.nativeToLwjglMap.put(Short.valueOf(1), Integer.valueOf(31));
        Object put30 = this.nativeToLwjglMap.put(Short.valueOf(17), Integer.valueOf(20));
        Object put31 = this.nativeToLwjglMap.put(Short.valueOf(32), Integer.valueOf(22));
        Object put32 = this.nativeToLwjglMap.put(Short.valueOf(9), Integer.valueOf(47));
        Object put33 = this.nativeToLwjglMap.put(Short.valueOf(13), Integer.valueOf(17));
        Object put34 = this.nativeToLwjglMap.put(Short.valueOf(7), Integer.valueOf(45));
        Object put35 = this.nativeToLwjglMap.put(Short.valueOf(16), Integer.valueOf(21));
        Object put36 = this.nativeToLwjglMap.put(Short.valueOf(6), Integer.valueOf(44));
        Object put37 = this.nativeToLwjglMap.put(Short.valueOf(42), Integer.valueOf(43));
        Object put38 = this.nativeToLwjglMap.put(Short.valueOf(43), Integer.valueOf(51));
        Object put39 = this.nativeToLwjglMap.put(Short.valueOf(24), Integer.valueOf(13));
        Object put40 = this.nativeToLwjglMap.put(Short.valueOf(33), Integer.valueOf(26));
        Object put41 = this.nativeToLwjglMap.put(Short.valueOf(27), Integer.valueOf(12));
        Object put42 = this.nativeToLwjglMap.put(Short.valueOf(39), Integer.valueOf(40));
        Object put43 = this.nativeToLwjglMap.put(Short.valueOf(30), Integer.valueOf(27));
        Object put44 = this.nativeToLwjglMap.put(Short.valueOf(41), Integer.valueOf(39));
        Object put45 = this.nativeToLwjglMap.put(Short.valueOf(44), Integer.valueOf(53));
        Object put46 = this.nativeToLwjglMap.put(Short.valueOf(47), Integer.valueOf(52));
        Object put47 = this.nativeToLwjglMap.put(Short.valueOf(50), Integer.valueOf(144));
        Object put48 = this.nativeToLwjglMap.put(Short.valueOf(65), Integer.valueOf(83));
        Object put49 = this.nativeToLwjglMap.put(Short.valueOf(67), Integer.valueOf(55));
        Object put50 = this.nativeToLwjglMap.put(Short.valueOf(69), Integer.valueOf(78));
        Object put51 = this.nativeToLwjglMap.put(Short.valueOf(71), Integer.valueOf(218));
        Object put52 = this.nativeToLwjglMap.put(Short.valueOf(75), Integer.valueOf(181));
        Object put53 = this.nativeToLwjglMap.put(Short.valueOf(76), Integer.valueOf(156));
        Object put54 = this.nativeToLwjglMap.put(Short.valueOf(78), Integer.valueOf(74));
        Object put55 = this.nativeToLwjglMap.put(Short.valueOf(81), Integer.valueOf(141));
        Object put56 = this.nativeToLwjglMap.put(Short.valueOf(82), Integer.valueOf(82));
        Object put57 = this.nativeToLwjglMap.put(Short.valueOf(83), Integer.valueOf(79));
        Object put58 = this.nativeToLwjglMap.put(Short.valueOf(84), Integer.valueOf(80));
        Object put59 = this.nativeToLwjglMap.put(Short.valueOf(85), Integer.valueOf(81));
        Object put60 = this.nativeToLwjglMap.put(Short.valueOf(86), Integer.valueOf(75));
        Object put61 = this.nativeToLwjglMap.put(Short.valueOf(87), Integer.valueOf(76));
        Object put62 = this.nativeToLwjglMap.put(Short.valueOf(88), Integer.valueOf(77));
        Object put63 = this.nativeToLwjglMap.put(Short.valueOf(89), Integer.valueOf(71));
        Object put64 = this.nativeToLwjglMap.put(Short.valueOf(91), Integer.valueOf(72));
        Object put65 = this.nativeToLwjglMap.put(Short.valueOf(92), Integer.valueOf(73));
        Object put66 = this.nativeToLwjglMap.put(Short.valueOf(36), Integer.valueOf(28));
        Object put67 = this.nativeToLwjglMap.put(Short.valueOf(48), Integer.valueOf(15));
        Object put68 = this.nativeToLwjglMap.put(Short.valueOf(49), Integer.valueOf(57));
        Object put69 = this.nativeToLwjglMap.put(Short.valueOf(51), Integer.valueOf(14));
        Object put70 = this.nativeToLwjglMap.put(Short.valueOf(53), Integer.valueOf(1));
        Object put71 = this.nativeToLwjglMap.put(Short.valueOf(54), Integer.valueOf(220));
        Object put72 = this.nativeToLwjglMap.put(Short.valueOf(55), Integer.valueOf(219));
        Object put73 = this.nativeToLwjglMap.put(Short.valueOf(56), Integer.valueOf(42));
        Object put74 = this.nativeToLwjglMap.put(Short.valueOf(57), Integer.valueOf(58));
        Object put75 = this.nativeToLwjglMap.put(Short.valueOf(58), Integer.valueOf(56));
        Object put76 = this.nativeToLwjglMap.put(Short.valueOf(59), Integer.valueOf(29));
        Object put77 = this.nativeToLwjglMap.put(Short.valueOf(60), Integer.valueOf(54));
        Object put78 = this.nativeToLwjglMap.put(Short.valueOf(61), Integer.valueOf(184));
        Object put79 = this.nativeToLwjglMap.put(Short.valueOf(62), Integer.valueOf(157));
        Object put80 = this.nativeToLwjglMap.put(Short.valueOf(63), Integer.valueOf(196));
        Object put81 = this.nativeToLwjglMap.put(Short.valueOf(119), Integer.valueOf(207));
        Object put82 = this.nativeToLwjglMap.put(Short.valueOf(122), Integer.valueOf(59));
        Object put83 = this.nativeToLwjglMap.put(Short.valueOf(120), Integer.valueOf(60));
        Object put84 = this.nativeToLwjglMap.put(Short.valueOf(99), Integer.valueOf(61));
        Object put85 = this.nativeToLwjglMap.put(Short.valueOf(118), Integer.valueOf(62));
        Object put86 = this.nativeToLwjglMap.put(Short.valueOf(96), Integer.valueOf(63));
        Object put87 = this.nativeToLwjglMap.put(Short.valueOf(97), Integer.valueOf(64));
        Object put88 = this.nativeToLwjglMap.put(Short.valueOf(98), Integer.valueOf(65));
        Object put89 = this.nativeToLwjglMap.put(Short.valueOf(100), Integer.valueOf(66));
        Object put90 = this.nativeToLwjglMap.put(Short.valueOf(101), Integer.valueOf(67));
        Object put91 = this.nativeToLwjglMap.put(Short.valueOf(109), Integer.valueOf(68));
        Object put92 = this.nativeToLwjglMap.put(Short.valueOf(103), Integer.valueOf(87));
        Object put93 = this.nativeToLwjglMap.put(Short.valueOf(111), Integer.valueOf(88));
        Object put94 = this.nativeToLwjglMap.put(Short.valueOf(105), Integer.valueOf(100));
        Object put95 = this.nativeToLwjglMap.put(Short.valueOf(107), Integer.valueOf(101));
        Object put96 = this.nativeToLwjglMap.put(Short.valueOf(113), Integer.valueOf(102));
        Object put97 = this.nativeToLwjglMap.put(Short.valueOf(106), Integer.valueOf(103));
        Object put98 = this.nativeToLwjglMap.put(Short.valueOf(64), Integer.valueOf(104));
        Object put99 = this.nativeToLwjglMap.put(Short.valueOf(79), Integer.valueOf(105));
        Object put100 = this.nativeToLwjglMap.put(Short.valueOf(80), Integer.valueOf(113));
        Object put101 = this.nativeToLwjglMap.put(Short.valueOf(117), Integer.valueOf(211));
        Object put102 = this.nativeToLwjglMap.put(Short.valueOf(114), Integer.valueOf(210));
        Object put103 = this.nativeToLwjglMap.put(Short.valueOf(115), Integer.valueOf(199));
        Object put104 = this.nativeToLwjglMap.put(Short.valueOf(121), Integer.valueOf(209));
        Object put105 = this.nativeToLwjglMap.put(Short.valueOf(116), Integer.valueOf(201));
        Object put106 = this.nativeToLwjglMap.put(Short.valueOf(123), Integer.valueOf(203));
        Object put107 = this.nativeToLwjglMap.put(Short.valueOf(124), Integer.valueOf(205));
        Object put108 = this.nativeToLwjglMap.put(Short.valueOf(125), Integer.valueOf(208));
        Object put109 = this.nativeToLwjglMap.put(Short.valueOf(126), Integer.valueOf(200));
        Object put110 = this.nativeToLwjglMap.put(Short.valueOf(10), Integer.valueOf(167));
        Object put111 = this.nativeToLwjglMap.put(Short.valueOf(110), Integer.valueOf(221));
        Object put112 = this.nativeToLwjglMap.put(Short.valueOf(297), Integer.valueOf(146));
    }

    private native void nRegisterKeyListener(ByteBuffer byteBuffer);

    private native void nUnregisterKeyListener(ByteBuffer byteBuffer);

    public void copyEvents(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        synchronized (this) {
            try {
                flushDeferredEvent();
                super.copyEvents(byteBuffer2);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void keyPressed(int i, int i2, long j) {
        handleKey(i, 1, i2, j);
    }

    public void keyReleased(int i, int i2, long j) {
        handleKey(i, 0, i2, j);
    }

    public void keyTyped(KeyEvent keyEvent) {
    }

    public void poll(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        synchronized (this) {
            try {
                flushDeferredEvent();
                int position = byteBuffer2.position();
                ByteBuffer put = byteBuffer2.put(this.key_states);
                Buffer position2 = byteBuffer2.position(position);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void putKeyEvent(int i, byte b, int i2, long j, boolean z) {
        StringBuilder sb;
        int i3 = i;
        byte b2 = b;
        int i4 = i2;
        long j2 = j;
        boolean z2 = z;
        int mappedKeyCode = getMappedKeyCode((short) i3);
        if (mappedKeyCode < 0) {
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("Unrecognized keycode: ").append(i3).toString());
            return;
        }
        if (this.key_states[mappedKeyCode] == b2) {
            z2 = true;
        }
        this.key_states[mappedKeyCode] = b2;
        putKeyboardEvent(mappedKeyCode, b2, i4 & 65535, j2, z2);
    }

    public void putKeyboardEvent(int i, byte b, int i2, long j, boolean z) {
        int i3 = i;
        byte b2 = b;
        int i4 = i2;
        long j2 = j;
        boolean z2 = z;
        Buffer clear = this.event.clear();
        ByteBuffer put = this.event.putInt(i3).put(b2).putInt(i4).putLong(j2).put(z2 ? (byte) 1 : 0);
        Buffer flip = this.event.flip();
        boolean putEvent = putEvent(this.event);
    }

    public void register() {
        nRegisterKeyListener(this.window_handle);
    }

    public void unregister() {
        nUnregisterKeyListener(this.window_handle);
    }
}
