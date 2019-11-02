package org.lwjgl.opengl;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.Buffer;
import java.nio.ByteBuffer;

final class KeyboardEventQueue extends EventQueue implements KeyListener {
    private static final int[] KEY_MAP = new int[65535];
    private final Component component;
    private int deferred_character;
    private int deferred_key_code;
    private int deferred_key_location;
    private byte deferred_key_state;
    private long deferred_nanos;
    private final ByteBuffer event = ByteBuffer.allocate(18);
    private boolean has_deferred_event;
    private final byte[] key_states = new byte[256];

    static {
        KEY_MAP[48] = 11;
        KEY_MAP[49] = 2;
        KEY_MAP[50] = 3;
        KEY_MAP[51] = 4;
        KEY_MAP[52] = 5;
        KEY_MAP[53] = 6;
        KEY_MAP[54] = 7;
        KEY_MAP[55] = 8;
        KEY_MAP[56] = 9;
        KEY_MAP[57] = 10;
        KEY_MAP[65] = 30;
        KEY_MAP[107] = 78;
        KEY_MAP[65406] = 184;
        KEY_MAP[512] = 145;
        KEY_MAP[66] = 48;
        KEY_MAP[92] = 43;
        KEY_MAP[8] = 14;
        KEY_MAP[67] = 46;
        KEY_MAP[20] = 58;
        KEY_MAP[514] = 144;
        KEY_MAP[93] = 27;
        KEY_MAP[513] = 146;
        KEY_MAP[44] = 51;
        KEY_MAP[28] = 121;
        KEY_MAP[68] = 32;
        KEY_MAP[110] = 83;
        KEY_MAP[127] = 211;
        KEY_MAP[111] = 181;
        KEY_MAP[40] = 208;
        KEY_MAP[69] = 18;
        KEY_MAP[35] = 207;
        KEY_MAP[10] = 28;
        KEY_MAP[61] = 13;
        KEY_MAP[27] = 1;
        KEY_MAP[70] = 33;
        KEY_MAP[112] = 59;
        KEY_MAP[121] = 68;
        KEY_MAP[122] = 87;
        KEY_MAP[123] = 88;
        KEY_MAP[61440] = 100;
        KEY_MAP[61441] = 101;
        KEY_MAP[61442] = 102;
        KEY_MAP[113] = 60;
        KEY_MAP[114] = 61;
        KEY_MAP[115] = 62;
        KEY_MAP[116] = 63;
        KEY_MAP[117] = 64;
        KEY_MAP[118] = 65;
        KEY_MAP[119] = 66;
        KEY_MAP[120] = 67;
        KEY_MAP[71] = 34;
        KEY_MAP[72] = 35;
        KEY_MAP[36] = 199;
        KEY_MAP[73] = 23;
        KEY_MAP[155] = 210;
        KEY_MAP[74] = 36;
        KEY_MAP[75] = 37;
        KEY_MAP[21] = 112;
        KEY_MAP[25] = 148;
        KEY_MAP[76] = 38;
        KEY_MAP[37] = 203;
        KEY_MAP[77] = 50;
        KEY_MAP[45] = 12;
        KEY_MAP[106] = 55;
        KEY_MAP[78] = 49;
        KEY_MAP[144] = 69;
        KEY_MAP[96] = 82;
        KEY_MAP[97] = 79;
        KEY_MAP[98] = 80;
        KEY_MAP[99] = 81;
        KEY_MAP[100] = 75;
        KEY_MAP[101] = 76;
        KEY_MAP[102] = 77;
        KEY_MAP[103] = 71;
        KEY_MAP[104] = 72;
        KEY_MAP[105] = 73;
        KEY_MAP[79] = 24;
        KEY_MAP[91] = 26;
        KEY_MAP[80] = 25;
        KEY_MAP[34] = 209;
        KEY_MAP[33] = 201;
        KEY_MAP[19] = 197;
        KEY_MAP[46] = 52;
        KEY_MAP[81] = 16;
        KEY_MAP[82] = 19;
        KEY_MAP[39] = 205;
        KEY_MAP[83] = 31;
        KEY_MAP[145] = 70;
        KEY_MAP[59] = 39;
        KEY_MAP[108] = 83;
        KEY_MAP[47] = 53;
        KEY_MAP[32] = 57;
        KEY_MAP[65480] = 149;
        KEY_MAP[109] = 74;
        KEY_MAP[84] = 20;
        KEY_MAP[9] = 15;
        KEY_MAP[85] = 22;
        KEY_MAP[38] = 200;
        KEY_MAP[86] = 47;
        KEY_MAP[87] = 17;
        KEY_MAP[88] = 45;
        KEY_MAP[89] = 21;
        KEY_MAP[90] = 44;
    }

    KeyboardEventQueue(Component component2) {
        Component component3 = component2;
        super(18);
        this.component = component3;
    }

    private void flushDeferredEvent() {
        if (this.has_deferred_event) {
            putKeyEvent(this.deferred_key_code, this.deferred_key_location, this.deferred_key_state, this.deferred_character, this.deferred_nanos, false);
            this.has_deferred_event = false;
        }
    }

    private int getMappedKeyCode(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        switch (i3) {
            case 16:
                return i4 == 3 ? 54 : 42;
            case 17:
                return i4 == 3 ? 157 : 29;
            case 18:
                return i4 == 3 ? 184 : 56;
            case 157:
                return i4 == 3 ? 220 : 219;
            default:
                return KEY_MAP[i3];
        }
    }

    /* JADX INFO: finally extract failed */
    private void handleKey(int i, int i2, byte b, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        byte b2 = b;
        int i6 = i3;
        long j2 = j;
        synchronized (this) {
            if (i6 == 65535) {
                i6 = 0;
            }
            if (b2 == 1) {
                try {
                    boolean z = false;
                    if (this.has_deferred_event) {
                        if (j2 == this.deferred_nanos && this.deferred_key_code == i4 && this.deferred_key_location == i5) {
                            this.has_deferred_event = false;
                            z = true;
                        } else {
                            flushDeferredEvent();
                            z = false;
                        }
                    }
                    putKeyEvent(i4, i5, b2, i6, j2, z);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            } else {
                flushDeferredEvent();
                this.has_deferred_event = true;
                this.deferred_nanos = j2;
                this.deferred_key_code = i4;
                this.deferred_key_location = i5;
                this.deferred_key_state = b2;
                this.deferred_character = i6;
            }
        }
    }

    private void putKeyEvent(int i, int i2, byte b, int i3, long j, boolean z) {
        byte b2 = b;
        int i4 = i3;
        long j2 = j;
        boolean z2 = z;
        int mappedKeyCode = getMappedKeyCode(i, i2);
        if (this.key_states[mappedKeyCode] == b2) {
            z2 = true;
        }
        this.key_states[mappedKeyCode] = b2;
        putKeyboardEvent(mappedKeyCode, b2, i4 & 65535, j2, z2);
    }

    private void putKeyboardEvent(int i, byte b, int i2, long j, boolean z) {
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

    public void keyPressed(KeyEvent keyEvent) {
        KeyEvent keyEvent2 = keyEvent;
        handleKey(keyEvent2.getKeyCode(), keyEvent2.getKeyLocation(), 1, keyEvent2.getKeyChar(), 1000000 * keyEvent2.getWhen());
    }

    public void keyReleased(KeyEvent keyEvent) {
        KeyEvent keyEvent2 = keyEvent;
        handleKey(keyEvent2.getKeyCode(), keyEvent2.getKeyLocation(), 0, 0, 1000000 * keyEvent2.getWhen());
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

    public void register() {
        this.component.addKeyListener(this);
    }

    public void unregister() {
    }
}
