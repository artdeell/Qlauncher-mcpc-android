package org.lwjgl.input;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.InputImplementation;

public class Keyboard {
    private static final int BUFFER_SIZE = 50;
    public static final int CHAR_NONE = 0;
    public static final int EVENT_SIZE = 18;
    public static final int KEYBOARD_SIZE = 256;
    public static final int KEY_0 = 11;
    public static final int KEY_1 = 2;
    public static final int KEY_2 = 3;
    public static final int KEY_3 = 4;
    public static final int KEY_4 = 5;
    public static final int KEY_5 = 6;
    public static final int KEY_6 = 7;
    public static final int KEY_7 = 8;
    public static final int KEY_8 = 9;
    public static final int KEY_9 = 10;
    public static final int KEY_A = 30;
    public static final int KEY_ADD = 78;
    public static final int KEY_APOSTROPHE = 40;
    public static final int KEY_APPS = 221;
    public static final int KEY_AT = 145;
    public static final int KEY_AX = 150;
    public static final int KEY_B = 48;
    public static final int KEY_BACK = 14;
    public static final int KEY_BACKSLASH = 43;
    public static final int KEY_C = 46;
    public static final int KEY_CAPITAL = 58;
    public static final int KEY_CIRCUMFLEX = 144;
    public static final int KEY_CLEAR = 218;
    public static final int KEY_COLON = 146;
    public static final int KEY_COMMA = 51;
    public static final int KEY_CONVERT = 121;
    public static final int KEY_D = 32;
    public static final int KEY_DECIMAL = 83;
    public static final int KEY_DELETE = 211;
    public static final int KEY_DIVIDE = 181;
    public static final int KEY_DOWN = 208;
    public static final int KEY_E = 18;
    public static final int KEY_END = 207;
    public static final int KEY_EQUALS = 13;
    public static final int KEY_ESCAPE = 1;
    public static final int KEY_F = 33;
    public static final int KEY_F1 = 59;
    public static final int KEY_F10 = 68;
    public static final int KEY_F11 = 87;
    public static final int KEY_F12 = 88;
    public static final int KEY_F13 = 100;
    public static final int KEY_F14 = 101;
    public static final int KEY_F15 = 102;
    public static final int KEY_F16 = 103;
    public static final int KEY_F17 = 104;
    public static final int KEY_F18 = 105;
    public static final int KEY_F19 = 113;
    public static final int KEY_F2 = 60;
    public static final int KEY_F3 = 61;
    public static final int KEY_F4 = 62;
    public static final int KEY_F5 = 63;
    public static final int KEY_F6 = 64;
    public static final int KEY_F7 = 65;
    public static final int KEY_F8 = 66;
    public static final int KEY_F9 = 67;
    public static final int KEY_FUNCTION = 196;
    public static final int KEY_G = 34;
    public static final int KEY_GRAVE = 41;
    public static final int KEY_H = 35;
    public static final int KEY_HOME = 199;
    public static final int KEY_I = 23;
    public static final int KEY_INSERT = 210;
    public static final int KEY_J = 36;
    public static final int KEY_K = 37;
    public static final int KEY_KANA = 112;
    public static final int KEY_KANJI = 148;
    public static final int KEY_L = 38;
    public static final int KEY_LBRACKET = 26;
    public static final int KEY_LCONTROL = 29;
    public static final int KEY_LEFT = 203;
    public static final int KEY_LMENU = 56;
    public static final int KEY_LMETA = 219;
    public static final int KEY_LSHIFT = 42;
    public static final int KEY_LWIN = 219;
    public static final int KEY_M = 50;
    public static final int KEY_MINUS = 12;
    public static final int KEY_MULTIPLY = 55;
    public static final int KEY_N = 49;
    public static final int KEY_NEXT = 209;
    public static final int KEY_NOCONVERT = 123;
    public static final int KEY_NONE = 0;
    public static final int KEY_NUMLOCK = 69;
    public static final int KEY_NUMPAD0 = 82;
    public static final int KEY_NUMPAD1 = 79;
    public static final int KEY_NUMPAD2 = 80;
    public static final int KEY_NUMPAD3 = 81;
    public static final int KEY_NUMPAD4 = 75;
    public static final int KEY_NUMPAD5 = 76;
    public static final int KEY_NUMPAD6 = 77;
    public static final int KEY_NUMPAD7 = 71;
    public static final int KEY_NUMPAD8 = 72;
    public static final int KEY_NUMPAD9 = 73;
    public static final int KEY_NUMPADCOMMA = 179;
    public static final int KEY_NUMPADENTER = 156;
    public static final int KEY_NUMPADEQUALS = 141;
    public static final int KEY_O = 24;
    public static final int KEY_P = 25;
    public static final int KEY_PAUSE = 197;
    public static final int KEY_PERIOD = 52;
    public static final int KEY_POWER = 222;
    public static final int KEY_PRIOR = 201;
    public static final int KEY_Q = 16;
    public static final int KEY_R = 19;
    public static final int KEY_RBRACKET = 27;
    public static final int KEY_RCONTROL = 157;
    public static final int KEY_RETURN = 28;
    public static final int KEY_RIGHT = 205;
    public static final int KEY_RMENU = 184;
    public static final int KEY_RMETA = 220;
    public static final int KEY_RSHIFT = 54;
    public static final int KEY_RWIN = 220;
    public static final int KEY_S = 31;
    public static final int KEY_SCROLL = 70;
    public static final int KEY_SECTION = 167;
    public static final int KEY_SEMICOLON = 39;
    public static final int KEY_SLASH = 53;
    public static final int KEY_SLEEP = 223;
    public static final int KEY_SPACE = 57;
    public static final int KEY_STOP = 149;
    public static final int KEY_SUBTRACT = 74;
    public static final int KEY_SYSRQ = 183;
    public static final int KEY_T = 20;
    public static final int KEY_TAB = 15;
    public static final int KEY_U = 22;
    public static final int KEY_UNDERLINE = 147;
    public static final int KEY_UNLABELED = 151;
    public static final int KEY_UP = 200;
    public static final int KEY_V = 47;
    public static final int KEY_W = 17;
    public static final int KEY_X = 45;
    public static final int KEY_Y = 21;
    public static final int KEY_YEN = 125;
    public static final int KEY_Z = 44;
    private static int counter;
    private static boolean created;
    private static KeyEvent current_event;
    private static InputImplementation implementation;
    private static boolean initialized;
    private static final int keyCount = counter;
    private static final ByteBuffer keyDownBuffer = BufferUtils.createByteBuffer(256);
    private static final Map<String, Integer> keyMap;
    private static final String[] keyName = new String[256];
    private static ByteBuffer readBuffer;
    private static boolean repeat_enabled;
    private static KeyEvent tmp_event;

    private static final class KeyEvent {
        /* access modifiers changed from: private */
        public int character;
        /* access modifiers changed from: private */
        public int key;
        /* access modifiers changed from: private */
        public long nanos;
        /* access modifiers changed from: private */
        public boolean repeat;
        /* access modifiers changed from: private */
        public boolean state;

        private KeyEvent() {
        }

        /* synthetic */ KeyEvent(C07541 r4) {
            C07541 r1 = r4;
            this();
        }

        static /* synthetic */ boolean access$202(KeyEvent keyEvent, boolean z) {
            boolean z2 = z;
            keyEvent.repeat = z2;
            return z2;
        }

        static /* synthetic */ int access$302(KeyEvent keyEvent, int i) {
            int i2 = i;
            keyEvent.key = i2;
            return i2;
        }

        static /* synthetic */ boolean access$402(KeyEvent keyEvent, boolean z) {
            boolean z2 = z;
            keyEvent.state = z2;
            return z2;
        }

        static /* synthetic */ int access$502(KeyEvent keyEvent, int i) {
            int i2 = i;
            keyEvent.character = i2;
            return i2;
        }

        static /* synthetic */ long access$602(KeyEvent keyEvent, long j) {
            long j2 = j;
            keyEvent.nanos = j2;
            return j2;
        }

        /* access modifiers changed from: private */
        public void reset() {
            this.character = 0;
            this.key = 0;
            this.state = false;
            this.repeat = false;
        }
    }

    static {
        HashMap hashMap;
        KeyEvent keyEvent;
        KeyEvent keyEvent2;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap(253);
        keyMap = hashMap2;
        Field[] fields = Keyboard.class.getFields();
        try {
            int length = fields.length;
            for (int i = 0; i < length; i++) {
                Field field = fields[i];
                if (Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getName().startsWith("KEY_") && !field.getName().endsWith("WIN")) {
                    int i2 = field.getInt(null);
                    String substring = field.getName().substring(4);
                    keyName[i2] = substring;
                    Object put = keyMap.put(substring, Integer.valueOf(i2));
                    counter = 1 + counter;
                }
            }
        } catch (Exception e) {
            Exception exc = e;
        }
        KeyEvent keyEvent3 = keyEvent;
        KeyEvent keyEvent4 = new KeyEvent(null);
        current_event = keyEvent3;
        KeyEvent keyEvent5 = keyEvent2;
        KeyEvent keyEvent6 = new KeyEvent(null);
        tmp_event = keyEvent5;
    }

    private Keyboard() {
    }

    public static boolean areRepeatEventsEnabled() {
        boolean z = OpenGLPackageAccess.global_lock;
        synchronized (z) {
            try {
                th = repeat_enabled;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
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
            implementation.createKeyboard();
            created = true;
            readBuffer = ByteBuffer.allocate(900);
            reset();
        }
    }

    public static void destroy() {
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if (created) {
                    created = false;
                    implementation.destroyKeyboard();
                    reset();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static void enableRepeatEvents(boolean z) {
        boolean z2 = z;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                repeat_enabled = z2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static char getEventCharacter() {
        char c = OpenGLPackageAccess.global_lock;
        synchronized (c) {
            try {
                th = (char) current_event.character;
            } finally {
                Throwable th = th;
                char c2 = c;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int getEventKey() {
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                th = current_event.key;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static boolean getEventKeyState() {
        boolean z = OpenGLPackageAccess.global_lock;
        synchronized (z) {
            try {
                th = current_event.state;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static long getEventNanoseconds() {
        long j = OpenGLPackageAccess.global_lock;
        synchronized (j) {
            try {
                th = current_event.nanos;
            } finally {
                Throwable th = th;
                long j2 = j;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int getKeyCount() {
        return keyCount;
    }

    public static int getKeyIndex(String str) {
        int intValue;
        String str2 = str;
        synchronized (Keyboard.class) {
            try {
                Integer num = (Integer) keyMap.get(str2);
                intValue = num == null ? 0 : num.intValue();
            } catch (Throwable th) {
                Throwable th2 = th;
                Class<Keyboard> cls = Keyboard.class;
                throw th2;
            }
        }
        return intValue;
    }

    public static String getKeyName(int i) {
        String str;
        int i2 = i;
        synchronized (Keyboard.class) {
            try {
                th = keyName[i2];
            } finally {
                str = th;
                Class<Keyboard> cls = Keyboard.class;
                Throwable th = str;
            }
        }
        return str;
    }

    public static int getNumKeyboardEvents() {
        IllegalStateException illegalStateException;
        int i = OpenGLPackageAccess.global_lock;
        synchronized (i) {
            try {
                if (!created) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Keyboard must be created before you can read events");
                    throw illegalStateException2;
                }
                int position = readBuffer.position();
                int i2 = 0;
                while (readNext(tmp_event) && (!tmp_event.repeat || repeat_enabled)) {
                    i2 = th + 1;
                }
                Buffer position2 = readBuffer.position(position);
            } finally {
                Throwable th = th;
                int i3 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    private static void initialize() {
        if (!initialized) {
            Sys.initialize();
            initialized = true;
        }
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

    public static boolean isKeyDown(int i) {
        IllegalStateException illegalStateException;
        int i2 = i;
        boolean z = OpenGLPackageAccess.global_lock;
        synchronized (z) {
            try {
                if (!created) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Keyboard must be created before you can query key state");
                    throw illegalStateException2;
                }
                th = keyDownBuffer.get(i2) != 0;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static boolean isRepeatEvent() {
        boolean z = OpenGLPackageAccess.global_lock;
        synchronized (z) {
            try {
                th = current_event.repeat;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static boolean next() {
        IllegalStateException illegalStateException;
        boolean z = OpenGLPackageAccess.global_lock;
        synchronized (z) {
            try {
                if (!created) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Keyboard must be created before you can read events");
                    throw illegalStateException2;
                }
                do {
                    th = readNext(current_event);
                    if (!z || !current_event.repeat) {
                    }
                } while (!repeat_enabled);
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return z;
    }

    public static void poll() {
        IllegalStateException illegalStateException;
        Object obj = OpenGLPackageAccess.global_lock;
        synchronized (obj) {
            try {
                if (!created) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Keyboard must be created before you can poll the device");
                    throw illegalStateException2;
                }
                implementation.pollKeyboard(keyDownBuffer);
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
        implementation.readKeyboard(readBuffer);
        Buffer flip = readBuffer.flip();
    }

    private static boolean readNext(KeyEvent keyEvent) {
        KeyEvent keyEvent2 = keyEvent;
        if (!readBuffer.hasRemaining()) {
            return false;
        }
        int access$302 = KeyEvent.access$302(keyEvent2, 255 & readBuffer.getInt());
        boolean access$402 = KeyEvent.access$402(keyEvent2, readBuffer.get() != 0);
        int access$502 = KeyEvent.access$502(keyEvent2, readBuffer.getInt());
        long access$602 = KeyEvent.access$602(keyEvent2, readBuffer.getLong());
        boolean z = false;
        if (readBuffer.get() == 1) {
            z = true;
        }
        boolean access$202 = KeyEvent.access$202(keyEvent2, z);
        return true;
    }

    private static void reset() {
        Buffer limit = readBuffer.limit(0);
        for (int i = 0; i < keyDownBuffer.remaining(); i++) {
            ByteBuffer put = keyDownBuffer.put(i, 0);
        }
        current_event.reset();
    }
}
