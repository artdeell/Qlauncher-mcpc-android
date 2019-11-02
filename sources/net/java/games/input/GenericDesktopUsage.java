package net.java.games.input;

import net.java.games.input.Component.Identifier;
import net.java.games.input.Component.Identifier.Axis;
import net.java.games.input.Component.Identifier.Button;

final class GenericDesktopUsage implements Usage {
    public static final GenericDesktopUsage BYTE_COUNT;
    public static final GenericDesktopUsage COUNTED_BUFFER;
    public static final GenericDesktopUsage DIAL;
    public static final GenericDesktopUsage DPAD_DOWN;
    public static final GenericDesktopUsage DPAD_LEFT;
    public static final GenericDesktopUsage DPAD_RIGHT;
    public static final GenericDesktopUsage DPAD_UP;
    public static final GenericDesktopUsage GAME_PAD;
    public static final GenericDesktopUsage HATSWITCH;
    public static final GenericDesktopUsage JOYSTICK;
    public static final GenericDesktopUsage KEYBOARD;
    public static final GenericDesktopUsage KEYPAD;
    public static final GenericDesktopUsage MOTION_WAKEUP;
    public static final GenericDesktopUsage MOUSE;
    public static final GenericDesktopUsage MULTI_AXIS_CONTROLLER;
    public static final GenericDesktopUsage POINTER;

    /* renamed from: RX */
    public static final GenericDesktopUsage f100RX;

    /* renamed from: RY */
    public static final GenericDesktopUsage f101RY;

    /* renamed from: RZ */
    public static final GenericDesktopUsage f102RZ;
    public static final GenericDesktopUsage SELECT;
    public static final GenericDesktopUsage SLIDER;
    public static final GenericDesktopUsage START;
    public static final GenericDesktopUsage SYSTEM_APP_MENU;
    public static final GenericDesktopUsage SYSTEM_CONTEXT_MENU;
    public static final GenericDesktopUsage SYSTEM_CONTROL;
    public static final GenericDesktopUsage SYSTEM_MAIN_MENU;
    public static final GenericDesktopUsage SYSTEM_MENU;
    public static final GenericDesktopUsage SYSTEM_MENU_DOWN;
    public static final GenericDesktopUsage SYSTEM_MENU_EXIT;
    public static final GenericDesktopUsage SYSTEM_MENU_HELP;
    public static final GenericDesktopUsage SYSTEM_MENU_LEFT;
    public static final GenericDesktopUsage SYSTEM_MENU_RIGHT;
    public static final GenericDesktopUsage SYSTEM_MENU_UP;
    public static final GenericDesktopUsage SYSTEM_POWER_DOWN;
    public static final GenericDesktopUsage SYSTEM_SLEEP;
    public static final GenericDesktopUsage SYSTEM_WAKE_UP;
    public static final GenericDesktopUsage VBRX;
    public static final GenericDesktopUsage VBRY;
    public static final GenericDesktopUsage VBRZ;
    public static final GenericDesktopUsage VNO;

    /* renamed from: VX */
    public static final GenericDesktopUsage f103VX;

    /* renamed from: VY */
    public static final GenericDesktopUsage f104VY;

    /* renamed from: VZ */
    public static final GenericDesktopUsage f105VZ;
    public static final GenericDesktopUsage WHEEL;

    /* renamed from: X */
    public static final GenericDesktopUsage f106X;

    /* renamed from: Y */
    public static final GenericDesktopUsage f107Y;

    /* renamed from: Z */
    public static final GenericDesktopUsage f108Z;
    private static final GenericDesktopUsage[] map = new GenericDesktopUsage[255];
    private final int usage_id;

    static {
        GenericDesktopUsage genericDesktopUsage;
        GenericDesktopUsage genericDesktopUsage2;
        GenericDesktopUsage genericDesktopUsage3;
        GenericDesktopUsage genericDesktopUsage4;
        GenericDesktopUsage genericDesktopUsage5;
        GenericDesktopUsage genericDesktopUsage6;
        GenericDesktopUsage genericDesktopUsage7;
        GenericDesktopUsage genericDesktopUsage8;
        GenericDesktopUsage genericDesktopUsage9;
        GenericDesktopUsage genericDesktopUsage10;
        GenericDesktopUsage genericDesktopUsage11;
        GenericDesktopUsage genericDesktopUsage12;
        GenericDesktopUsage genericDesktopUsage13;
        GenericDesktopUsage genericDesktopUsage14;
        GenericDesktopUsage genericDesktopUsage15;
        GenericDesktopUsage genericDesktopUsage16;
        GenericDesktopUsage genericDesktopUsage17;
        GenericDesktopUsage genericDesktopUsage18;
        GenericDesktopUsage genericDesktopUsage19;
        GenericDesktopUsage genericDesktopUsage20;
        GenericDesktopUsage genericDesktopUsage21;
        GenericDesktopUsage genericDesktopUsage22;
        GenericDesktopUsage genericDesktopUsage23;
        GenericDesktopUsage genericDesktopUsage24;
        GenericDesktopUsage genericDesktopUsage25;
        GenericDesktopUsage genericDesktopUsage26;
        GenericDesktopUsage genericDesktopUsage27;
        GenericDesktopUsage genericDesktopUsage28;
        GenericDesktopUsage genericDesktopUsage29;
        GenericDesktopUsage genericDesktopUsage30;
        GenericDesktopUsage genericDesktopUsage31;
        GenericDesktopUsage genericDesktopUsage32;
        GenericDesktopUsage genericDesktopUsage33;
        GenericDesktopUsage genericDesktopUsage34;
        GenericDesktopUsage genericDesktopUsage35;
        GenericDesktopUsage genericDesktopUsage36;
        GenericDesktopUsage genericDesktopUsage37;
        GenericDesktopUsage genericDesktopUsage38;
        GenericDesktopUsage genericDesktopUsage39;
        GenericDesktopUsage genericDesktopUsage40;
        GenericDesktopUsage genericDesktopUsage41;
        GenericDesktopUsage genericDesktopUsage42;
        GenericDesktopUsage genericDesktopUsage43;
        GenericDesktopUsage genericDesktopUsage44;
        GenericDesktopUsage genericDesktopUsage45;
        GenericDesktopUsage genericDesktopUsage46;
        GenericDesktopUsage genericDesktopUsage47;
        GenericDesktopUsage genericDesktopUsage48 = genericDesktopUsage;
        GenericDesktopUsage genericDesktopUsage49 = new GenericDesktopUsage(1);
        POINTER = genericDesktopUsage48;
        GenericDesktopUsage genericDesktopUsage50 = genericDesktopUsage2;
        GenericDesktopUsage genericDesktopUsage51 = new GenericDesktopUsage(2);
        MOUSE = genericDesktopUsage50;
        GenericDesktopUsage genericDesktopUsage52 = genericDesktopUsage3;
        GenericDesktopUsage genericDesktopUsage53 = new GenericDesktopUsage(4);
        JOYSTICK = genericDesktopUsage52;
        GenericDesktopUsage genericDesktopUsage54 = genericDesktopUsage4;
        GenericDesktopUsage genericDesktopUsage55 = new GenericDesktopUsage(5);
        GAME_PAD = genericDesktopUsage54;
        GenericDesktopUsage genericDesktopUsage56 = genericDesktopUsage5;
        GenericDesktopUsage genericDesktopUsage57 = new GenericDesktopUsage(6);
        KEYBOARD = genericDesktopUsage56;
        GenericDesktopUsage genericDesktopUsage58 = genericDesktopUsage6;
        GenericDesktopUsage genericDesktopUsage59 = new GenericDesktopUsage(7);
        KEYPAD = genericDesktopUsage58;
        GenericDesktopUsage genericDesktopUsage60 = genericDesktopUsage7;
        GenericDesktopUsage genericDesktopUsage61 = new GenericDesktopUsage(8);
        MULTI_AXIS_CONTROLLER = genericDesktopUsage60;
        GenericDesktopUsage genericDesktopUsage62 = genericDesktopUsage8;
        GenericDesktopUsage genericDesktopUsage63 = new GenericDesktopUsage(48);
        f106X = genericDesktopUsage62;
        GenericDesktopUsage genericDesktopUsage64 = genericDesktopUsage9;
        GenericDesktopUsage genericDesktopUsage65 = new GenericDesktopUsage(49);
        f107Y = genericDesktopUsage64;
        GenericDesktopUsage genericDesktopUsage66 = genericDesktopUsage10;
        GenericDesktopUsage genericDesktopUsage67 = new GenericDesktopUsage(50);
        f108Z = genericDesktopUsage66;
        GenericDesktopUsage genericDesktopUsage68 = genericDesktopUsage11;
        GenericDesktopUsage genericDesktopUsage69 = new GenericDesktopUsage(51);
        f100RX = genericDesktopUsage68;
        GenericDesktopUsage genericDesktopUsage70 = genericDesktopUsage12;
        GenericDesktopUsage genericDesktopUsage71 = new GenericDesktopUsage(52);
        f101RY = genericDesktopUsage70;
        GenericDesktopUsage genericDesktopUsage72 = genericDesktopUsage13;
        GenericDesktopUsage genericDesktopUsage73 = new GenericDesktopUsage(53);
        f102RZ = genericDesktopUsage72;
        GenericDesktopUsage genericDesktopUsage74 = genericDesktopUsage14;
        GenericDesktopUsage genericDesktopUsage75 = new GenericDesktopUsage(54);
        SLIDER = genericDesktopUsage74;
        GenericDesktopUsage genericDesktopUsage76 = genericDesktopUsage15;
        GenericDesktopUsage genericDesktopUsage77 = new GenericDesktopUsage(55);
        DIAL = genericDesktopUsage76;
        GenericDesktopUsage genericDesktopUsage78 = genericDesktopUsage16;
        GenericDesktopUsage genericDesktopUsage79 = new GenericDesktopUsage(56);
        WHEEL = genericDesktopUsage78;
        GenericDesktopUsage genericDesktopUsage80 = genericDesktopUsage17;
        GenericDesktopUsage genericDesktopUsage81 = new GenericDesktopUsage(57);
        HATSWITCH = genericDesktopUsage80;
        GenericDesktopUsage genericDesktopUsage82 = genericDesktopUsage18;
        GenericDesktopUsage genericDesktopUsage83 = new GenericDesktopUsage(58);
        COUNTED_BUFFER = genericDesktopUsage82;
        GenericDesktopUsage genericDesktopUsage84 = genericDesktopUsage19;
        GenericDesktopUsage genericDesktopUsage85 = new GenericDesktopUsage(59);
        BYTE_COUNT = genericDesktopUsage84;
        GenericDesktopUsage genericDesktopUsage86 = genericDesktopUsage20;
        GenericDesktopUsage genericDesktopUsage87 = new GenericDesktopUsage(60);
        MOTION_WAKEUP = genericDesktopUsage86;
        GenericDesktopUsage genericDesktopUsage88 = genericDesktopUsage21;
        GenericDesktopUsage genericDesktopUsage89 = new GenericDesktopUsage(61);
        START = genericDesktopUsage88;
        GenericDesktopUsage genericDesktopUsage90 = genericDesktopUsage22;
        GenericDesktopUsage genericDesktopUsage91 = new GenericDesktopUsage(62);
        SELECT = genericDesktopUsage90;
        GenericDesktopUsage genericDesktopUsage92 = genericDesktopUsage23;
        GenericDesktopUsage genericDesktopUsage93 = new GenericDesktopUsage(64);
        f103VX = genericDesktopUsage92;
        GenericDesktopUsage genericDesktopUsage94 = genericDesktopUsage24;
        GenericDesktopUsage genericDesktopUsage95 = new GenericDesktopUsage(65);
        f104VY = genericDesktopUsage94;
        GenericDesktopUsage genericDesktopUsage96 = genericDesktopUsage25;
        GenericDesktopUsage genericDesktopUsage97 = new GenericDesktopUsage(66);
        f105VZ = genericDesktopUsage96;
        GenericDesktopUsage genericDesktopUsage98 = genericDesktopUsage26;
        GenericDesktopUsage genericDesktopUsage99 = new GenericDesktopUsage(67);
        VBRX = genericDesktopUsage98;
        GenericDesktopUsage genericDesktopUsage100 = genericDesktopUsage27;
        GenericDesktopUsage genericDesktopUsage101 = new GenericDesktopUsage(68);
        VBRY = genericDesktopUsage100;
        GenericDesktopUsage genericDesktopUsage102 = genericDesktopUsage28;
        GenericDesktopUsage genericDesktopUsage103 = new GenericDesktopUsage(69);
        VBRZ = genericDesktopUsage102;
        GenericDesktopUsage genericDesktopUsage104 = genericDesktopUsage29;
        GenericDesktopUsage genericDesktopUsage105 = new GenericDesktopUsage(70);
        VNO = genericDesktopUsage104;
        GenericDesktopUsage genericDesktopUsage106 = genericDesktopUsage30;
        GenericDesktopUsage genericDesktopUsage107 = new GenericDesktopUsage(128);
        SYSTEM_CONTROL = genericDesktopUsage106;
        GenericDesktopUsage genericDesktopUsage108 = genericDesktopUsage31;
        GenericDesktopUsage genericDesktopUsage109 = new GenericDesktopUsage(129);
        SYSTEM_POWER_DOWN = genericDesktopUsage108;
        GenericDesktopUsage genericDesktopUsage110 = genericDesktopUsage32;
        GenericDesktopUsage genericDesktopUsage111 = new GenericDesktopUsage(130);
        SYSTEM_SLEEP = genericDesktopUsage110;
        GenericDesktopUsage genericDesktopUsage112 = genericDesktopUsage33;
        GenericDesktopUsage genericDesktopUsage113 = new GenericDesktopUsage(131);
        SYSTEM_WAKE_UP = genericDesktopUsage112;
        GenericDesktopUsage genericDesktopUsage114 = genericDesktopUsage34;
        GenericDesktopUsage genericDesktopUsage115 = new GenericDesktopUsage(132);
        SYSTEM_CONTEXT_MENU = genericDesktopUsage114;
        GenericDesktopUsage genericDesktopUsage116 = genericDesktopUsage35;
        GenericDesktopUsage genericDesktopUsage117 = new GenericDesktopUsage(133);
        SYSTEM_MAIN_MENU = genericDesktopUsage116;
        GenericDesktopUsage genericDesktopUsage118 = genericDesktopUsage36;
        GenericDesktopUsage genericDesktopUsage119 = new GenericDesktopUsage(134);
        SYSTEM_APP_MENU = genericDesktopUsage118;
        GenericDesktopUsage genericDesktopUsage120 = genericDesktopUsage37;
        GenericDesktopUsage genericDesktopUsage121 = new GenericDesktopUsage(135);
        SYSTEM_MENU_HELP = genericDesktopUsage120;
        GenericDesktopUsage genericDesktopUsage122 = genericDesktopUsage38;
        GenericDesktopUsage genericDesktopUsage123 = new GenericDesktopUsage(136);
        SYSTEM_MENU_EXIT = genericDesktopUsage122;
        GenericDesktopUsage genericDesktopUsage124 = genericDesktopUsage39;
        GenericDesktopUsage genericDesktopUsage125 = new GenericDesktopUsage(137);
        SYSTEM_MENU = genericDesktopUsage124;
        GenericDesktopUsage genericDesktopUsage126 = genericDesktopUsage40;
        GenericDesktopUsage genericDesktopUsage127 = new GenericDesktopUsage(138);
        SYSTEM_MENU_RIGHT = genericDesktopUsage126;
        GenericDesktopUsage genericDesktopUsage128 = genericDesktopUsage41;
        GenericDesktopUsage genericDesktopUsage129 = new GenericDesktopUsage(139);
        SYSTEM_MENU_LEFT = genericDesktopUsage128;
        GenericDesktopUsage genericDesktopUsage130 = genericDesktopUsage42;
        GenericDesktopUsage genericDesktopUsage131 = new GenericDesktopUsage(140);
        SYSTEM_MENU_UP = genericDesktopUsage130;
        GenericDesktopUsage genericDesktopUsage132 = genericDesktopUsage43;
        GenericDesktopUsage genericDesktopUsage133 = new GenericDesktopUsage(141);
        SYSTEM_MENU_DOWN = genericDesktopUsage132;
        GenericDesktopUsage genericDesktopUsage134 = genericDesktopUsage44;
        GenericDesktopUsage genericDesktopUsage135 = new GenericDesktopUsage(144);
        DPAD_UP = genericDesktopUsage134;
        GenericDesktopUsage genericDesktopUsage136 = genericDesktopUsage45;
        GenericDesktopUsage genericDesktopUsage137 = new GenericDesktopUsage(145);
        DPAD_DOWN = genericDesktopUsage136;
        GenericDesktopUsage genericDesktopUsage138 = genericDesktopUsage46;
        GenericDesktopUsage genericDesktopUsage139 = new GenericDesktopUsage(146);
        DPAD_RIGHT = genericDesktopUsage138;
        GenericDesktopUsage genericDesktopUsage140 = genericDesktopUsage47;
        GenericDesktopUsage genericDesktopUsage141 = new GenericDesktopUsage(147);
        DPAD_LEFT = genericDesktopUsage140;
    }

    private GenericDesktopUsage(int i) {
        int i2 = i;
        map[i2] = this;
        this.usage_id = i2;
    }

    public static final GenericDesktopUsage map(int i) {
        int i2 = i;
        if (i2 < 0 || i2 >= map.length) {
            return null;
        }
        return map[i2];
    }

    public final Identifier getIdentifier() {
        if (this == f106X) {
            return Axis.f31X;
        }
        if (this == f107Y) {
            return Axis.f32Y;
        }
        if (this == f108Z || this == WHEEL) {
            return Axis.f33Z;
        }
        if (this == f100RX) {
            return Axis.f28RX;
        }
        if (this == f101RY) {
            return Axis.f29RY;
        }
        if (this == f102RZ) {
            return Axis.f30RZ;
        }
        if (this == SLIDER) {
            return Axis.SLIDER;
        }
        if (this == HATSWITCH) {
            return Axis.POV;
        }
        if (this == SELECT) {
            return Button.SELECT;
        }
        return null;
    }

    public final String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append("GenericDesktopUsage (0x").append(Integer.toHexString(this.usage_id)).append(")").toString();
    }
}
