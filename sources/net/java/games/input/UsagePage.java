package net.java.games.input;

import java.lang.reflect.Method;

final class UsagePage {
    public static final UsagePage ALPHANUMERIC_DISPLAY;
    public static final UsagePage ARCADE;
    public static final UsagePage BAR_CODE_SCANNER;
    public static final UsagePage BATTERY_SYSTEM;
    public static final UsagePage BUTTON;
    public static final UsagePage CAMERACONTROL;
    public static final UsagePage CONSUMER;
    public static final UsagePage DIGITIZER;
    public static final UsagePage GAME;
    public static final UsagePage GENERIC_DESKTOP;
    public static final UsagePage KEYBOARD_OR_KEYPAD;
    public static final UsagePage LEDS;
    public static final UsagePage ORDINAL;
    public static final UsagePage PID;
    public static final UsagePage POWER_DEVICE;
    public static final UsagePage SCALE;
    public static final UsagePage SIMULATION;
    public static final UsagePage SPORT;
    public static final UsagePage TELEPHONY;
    public static final UsagePage UNDEFINED;
    public static final UsagePage UNICODE;

    /* renamed from: VR */
    public static final UsagePage f158VR;
    static Class class$net$java$games$input$ButtonUsage;
    static Class class$net$java$games$input$GenericDesktopUsage;
    static Class class$net$java$games$input$KeyboardUsage;
    private static final UsagePage[] map = new UsagePage[255];
    private final Class usage_class;
    private final int usage_page_id;

    static {
        UsagePage usagePage;
        Class cls;
        UsagePage usagePage2;
        UsagePage usagePage3;
        UsagePage usagePage4;
        UsagePage usagePage5;
        UsagePage usagePage6;
        Class cls2;
        UsagePage usagePage7;
        UsagePage usagePage8;
        Class cls3;
        UsagePage usagePage9;
        UsagePage usagePage10;
        UsagePage usagePage11;
        UsagePage usagePage12;
        UsagePage usagePage13;
        UsagePage usagePage14;
        UsagePage usagePage15;
        UsagePage usagePage16;
        UsagePage usagePage17;
        UsagePage usagePage18;
        UsagePage usagePage19;
        UsagePage usagePage20;
        UsagePage usagePage21;
        UsagePage usagePage22;
        UsagePage usagePage23 = usagePage;
        UsagePage usagePage24 = new UsagePage(0);
        UNDEFINED = usagePage23;
        if (class$net$java$games$input$GenericDesktopUsage == null) {
            cls = class$("net.java.games.input.GenericDesktopUsage");
            class$net$java$games$input$GenericDesktopUsage = cls;
        } else {
            cls = class$net$java$games$input$GenericDesktopUsage;
        }
        UsagePage usagePage25 = usagePage2;
        UsagePage usagePage26 = new UsagePage(1, cls);
        GENERIC_DESKTOP = usagePage25;
        UsagePage usagePage27 = usagePage3;
        UsagePage usagePage28 = new UsagePage(2);
        SIMULATION = usagePage27;
        UsagePage usagePage29 = usagePage4;
        UsagePage usagePage30 = new UsagePage(3);
        f158VR = usagePage29;
        UsagePage usagePage31 = usagePage5;
        UsagePage usagePage32 = new UsagePage(4);
        SPORT = usagePage31;
        UsagePage usagePage33 = usagePage6;
        UsagePage usagePage34 = new UsagePage(5);
        GAME = usagePage33;
        if (class$net$java$games$input$KeyboardUsage == null) {
            cls2 = class$("net.java.games.input.KeyboardUsage");
            class$net$java$games$input$KeyboardUsage = cls2;
        } else {
            cls2 = class$net$java$games$input$KeyboardUsage;
        }
        UsagePage usagePage35 = usagePage7;
        UsagePage usagePage36 = new UsagePage(7, cls2);
        KEYBOARD_OR_KEYPAD = usagePage35;
        UsagePage usagePage37 = usagePage8;
        UsagePage usagePage38 = new UsagePage(8);
        LEDS = usagePage37;
        if (class$net$java$games$input$ButtonUsage == null) {
            cls3 = class$("net.java.games.input.ButtonUsage");
            class$net$java$games$input$ButtonUsage = cls3;
        } else {
            cls3 = class$net$java$games$input$ButtonUsage;
        }
        UsagePage usagePage39 = usagePage9;
        UsagePage usagePage40 = new UsagePage(9, cls3);
        BUTTON = usagePage39;
        UsagePage usagePage41 = usagePage10;
        UsagePage usagePage42 = new UsagePage(10);
        ORDINAL = usagePage41;
        UsagePage usagePage43 = usagePage11;
        UsagePage usagePage44 = new UsagePage(11);
        TELEPHONY = usagePage43;
        UsagePage usagePage45 = usagePage12;
        UsagePage usagePage46 = new UsagePage(12);
        CONSUMER = usagePage45;
        UsagePage usagePage47 = usagePage13;
        UsagePage usagePage48 = new UsagePage(13);
        DIGITIZER = usagePage47;
        UsagePage usagePage49 = usagePage14;
        UsagePage usagePage50 = new UsagePage(15);
        PID = usagePage49;
        UsagePage usagePage51 = usagePage15;
        UsagePage usagePage52 = new UsagePage(16);
        UNICODE = usagePage51;
        UsagePage usagePage53 = usagePage16;
        UsagePage usagePage54 = new UsagePage(20);
        ALPHANUMERIC_DISPLAY = usagePage53;
        UsagePage usagePage55 = usagePage17;
        UsagePage usagePage56 = new UsagePage(132);
        POWER_DEVICE = usagePage55;
        UsagePage usagePage57 = usagePage18;
        UsagePage usagePage58 = new UsagePage(133);
        BATTERY_SYSTEM = usagePage57;
        UsagePage usagePage59 = usagePage19;
        UsagePage usagePage60 = new UsagePage(140);
        BAR_CODE_SCANNER = usagePage59;
        UsagePage usagePage61 = usagePage20;
        UsagePage usagePage62 = new UsagePage(141);
        SCALE = usagePage61;
        UsagePage usagePage63 = usagePage21;
        UsagePage usagePage64 = new UsagePage(144);
        CAMERACONTROL = usagePage63;
        UsagePage usagePage65 = usagePage22;
        UsagePage usagePage66 = new UsagePage(145);
        ARCADE = usagePage65;
    }

    private UsagePage(int i) {
        this(i, null);
    }

    private UsagePage(int i, Class cls) {
        int i2 = i;
        Class cls2 = cls;
        map[i2] = this;
        this.usage_class = cls2;
        this.usage_page_id = i2;
    }

    static Class class$(String str) {
        NoClassDefFoundError noClassDefFoundError;
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError();
            throw noClassDefFoundError2.initCause(classNotFoundException);
        }
    }

    public static final UsagePage map(int i) {
        int i2 = i;
        if (i2 < 0 || i2 >= map.length) {
            return null;
        }
        return map[i2];
    }

    public final Usage mapUsage(int i) {
        Error error;
        Integer num;
        int i2 = i;
        if (this.usage_class == null) {
            return null;
        }
        try {
            Method method = this.usage_class.getMethod("map", new Class[]{Integer.TYPE});
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            Integer num2 = num;
            Integer num3 = new Integer(i2);
            objArr2[0] = num2;
            return (Usage) method.invoke(null, objArr);
        } catch (Exception e) {
            Exception exc = e;
            Error error2 = error;
            Error error3 = new Error(exc);
            throw error2;
        }
    }

    public final String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append("UsagePage (0x").append(Integer.toHexString(this.usage_page_id)).append(")").toString();
    }
}
