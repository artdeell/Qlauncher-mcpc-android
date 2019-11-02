package net.java.games.input;

import java.io.PrintStream;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Component.Identifier.Axis;
import net.java.games.input.Component.Identifier.Button;
import net.java.games.input.Component.Identifier.Key;
import net.java.games.input.Controller.PortType;
import net.java.games.input.Controller.Type;

class LinuxNativeTypesMap {
    private static LinuxNativeTypesMap INSTANCE;
    private final Identifier[] absAxesIDs = new Identifier[63];
    private final Identifier[] buttonIDs = new Identifier[511];
    private final Identifier[] relAxesIDs = new Identifier[15];

    static {
        LinuxNativeTypesMap linuxNativeTypesMap;
        LinuxNativeTypesMap linuxNativeTypesMap2 = linuxNativeTypesMap;
        LinuxNativeTypesMap linuxNativeTypesMap3 = new LinuxNativeTypesMap();
        INSTANCE = linuxNativeTypesMap2;
    }

    private LinuxNativeTypesMap() {
        reInit();
    }

    public static Identifier getAbsAxisID(int i) {
        StringBuffer stringBuffer;
        Identifier identifier;
        int i2 = i;
        try {
            identifier = INSTANCE.absAxesIDs[i2];
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            PrintStream printStream = System.out;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            printStream.println(stringBuffer2.append("INSTANCE.absAxesIDs is only ").append(INSTANCE.absAxesIDs.length).append(" long, so ").append(i2).append(" not contained").toString());
            identifier = null;
        }
        if (identifier == null) {
            identifier = Axis.SLIDER;
        }
        return identifier;
    }

    public static Identifier getButtonID(int i) {
        StringBuffer stringBuffer;
        Identifier identifier;
        int i2 = i;
        try {
            identifier = INSTANCE.buttonIDs[i2];
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            PrintStream printStream = System.out;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            printStream.println(stringBuffer2.append("INSTANCE.buttonIDs is only ").append(INSTANCE.buttonIDs.length).append(" long, so ").append(i2).append(" not contained").toString());
            identifier = null;
        }
        if (identifier == null) {
            identifier = Key.UNKNOWN;
        }
        return identifier;
    }

    public static PortType getPortType(int i) {
        switch (i) {
            case 3:
                return PortType.USB;
            case 17:
                return PortType.I8042;
            case 19:
                return PortType.SERIAL;
            case 20:
                return PortType.GAME;
            case 21:
                return PortType.PARALLEL;
            default:
                return PortType.UNKNOWN;
        }
    }

    public static Identifier getRelAxisID(int i) {
        StringBuffer stringBuffer;
        Identifier identifier;
        int i2 = i;
        try {
            identifier = INSTANCE.relAxesIDs[i2];
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            PrintStream printStream = System.out;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            printStream.println(stringBuffer2.append("INSTANCE.relAxesIDis only ").append(INSTANCE.relAxesIDs.length).append(" long, so ").append(i2).append(" not contained").toString());
            identifier = null;
        }
        if (identifier == null) {
            identifier = Axis.SLIDER_VELOCITY;
        }
        return identifier;
    }

    public static final Type guessButtonTrait(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 169:
            case 170:
            case 171:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case 189:
            case 190:
            case 191:
            case 192:
            case 193:
            case 194:
            case 200:
            case 201:
            case 202:
            case 203:
            case 205:
            case 206:
            case 207:
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            case 213:
            case 214:
            case 215:
            case 216:
            case 217:
            case 218:
            case 219:
            case 220:
            case 221:
            case 222:
            case 223:
            case 224:
            case 225:
            case 226:
            case 227:
            case 228:
            case 229:
            case 230:
            case NativeDefinitions.KEY_OK /*352*/:
            case NativeDefinitions.KEY_SELECT /*353*/:
            case NativeDefinitions.KEY_GOTO /*354*/:
            case NativeDefinitions.KEY_CLEAR /*355*/:
            case NativeDefinitions.KEY_POWER2 /*356*/:
            case NativeDefinitions.KEY_OPTION /*357*/:
            case NativeDefinitions.KEY_INFO /*358*/:
            case NativeDefinitions.KEY_TIME /*359*/:
            case NativeDefinitions.KEY_VENDOR /*360*/:
            case NativeDefinitions.KEY_ARCHIVE /*361*/:
            case NativeDefinitions.KEY_PROGRAM /*362*/:
            case NativeDefinitions.KEY_CHANNEL /*363*/:
            case NativeDefinitions.KEY_FAVORITES /*364*/:
            case NativeDefinitions.KEY_EPG /*365*/:
            case NativeDefinitions.KEY_PVR /*366*/:
            case NativeDefinitions.KEY_MHP /*367*/:
            case NativeDefinitions.KEY_LANGUAGE /*368*/:
            case NativeDefinitions.KEY_TITLE /*369*/:
            case NativeDefinitions.KEY_SUBTITLE /*370*/:
            case NativeDefinitions.KEY_ANGLE /*371*/:
            case NativeDefinitions.KEY_ZOOM /*372*/:
            case NativeDefinitions.KEY_MODE /*373*/:
            case NativeDefinitions.KEY_KEYBOARD /*374*/:
            case NativeDefinitions.KEY_SCREEN /*375*/:
            case NativeDefinitions.KEY_PC /*376*/:
            case NativeDefinitions.KEY_TV /*377*/:
            case NativeDefinitions.KEY_TV2 /*378*/:
            case NativeDefinitions.KEY_VCR /*379*/:
            case NativeDefinitions.KEY_VCR2 /*380*/:
            case NativeDefinitions.KEY_SAT /*381*/:
            case NativeDefinitions.KEY_SAT2 /*382*/:
            case NativeDefinitions.KEY_CD /*383*/:
            case NativeDefinitions.KEY_TAPE /*384*/:
            case NativeDefinitions.KEY_RADIO /*385*/:
            case NativeDefinitions.KEY_TUNER /*386*/:
            case NativeDefinitions.KEY_PLAYER /*387*/:
            case NativeDefinitions.KEY_TEXT /*388*/:
            case NativeDefinitions.KEY_DVD /*389*/:
            case NativeDefinitions.KEY_AUX /*390*/:
            case NativeDefinitions.KEY_MP3 /*391*/:
            case NativeDefinitions.KEY_AUDIO /*392*/:
            case NativeDefinitions.KEY_VIDEO /*393*/:
            case NativeDefinitions.KEY_DIRECTORY /*394*/:
            case NativeDefinitions.KEY_LIST /*395*/:
            case NativeDefinitions.KEY_MEMO /*396*/:
            case NativeDefinitions.KEY_CALENDAR /*397*/:
            case NativeDefinitions.KEY_RED /*398*/:
            case NativeDefinitions.KEY_GREEN /*399*/:
            case NativeDefinitions.KEY_YELLOW /*400*/:
            case NativeDefinitions.KEY_BLUE /*401*/:
            case NativeDefinitions.KEY_CHANNELUP /*402*/:
            case NativeDefinitions.KEY_CHANNELDOWN /*403*/:
            case NativeDefinitions.KEY_FIRST /*404*/:
            case NativeDefinitions.KEY_LAST /*405*/:
            case NativeDefinitions.KEY_AB /*406*/:
            case NativeDefinitions.KEY_NEXT /*407*/:
            case NativeDefinitions.KEY_RESTART /*408*/:
            case NativeDefinitions.KEY_SLOW /*409*/:
            case NativeDefinitions.KEY_SHUFFLE /*410*/:
            case NativeDefinitions.KEY_BREAK /*411*/:
            case NativeDefinitions.KEY_PREVIOUS /*412*/:
            case NativeDefinitions.KEY_DIGITS /*413*/:
            case NativeDefinitions.KEY_TEEN /*414*/:
            case NativeDefinitions.KEY_TWEN /*415*/:
            case NativeDefinitions.KEY_DEL_EOL /*448*/:
            case NativeDefinitions.KEY_DEL_EOS /*449*/:
            case NativeDefinitions.KEY_INS_LINE /*450*/:
            case NativeDefinitions.KEY_DEL_LINE /*451*/:
            case NativeDefinitions.KEY_FN /*464*/:
            case NativeDefinitions.KEY_FN_ESC /*465*/:
            case NativeDefinitions.KEY_FN_F1 /*466*/:
            case NativeDefinitions.KEY_FN_F2 /*467*/:
            case NativeDefinitions.KEY_FN_F3 /*468*/:
            case NativeDefinitions.KEY_FN_F4 /*469*/:
            case NativeDefinitions.KEY_FN_F5 /*470*/:
            case NativeDefinitions.KEY_FN_F6 /*471*/:
            case NativeDefinitions.KEY_FN_F7 /*472*/:
            case NativeDefinitions.KEY_FN_F8 /*473*/:
            case NativeDefinitions.KEY_FN_F9 /*474*/:
            case NativeDefinitions.KEY_FN_F10 /*475*/:
            case NativeDefinitions.KEY_FN_F11 /*476*/:
            case NativeDefinitions.KEY_FN_F12 /*477*/:
            case NativeDefinitions.KEY_FN_1 /*478*/:
            case NativeDefinitions.KEY_FN_2 /*479*/:
            case 480:
            case NativeDefinitions.KEY_FN_E /*481*/:
            case NativeDefinitions.KEY_FN_F /*482*/:
            case NativeDefinitions.KEY_FN_S /*483*/:
            case NativeDefinitions.KEY_FN_B /*484*/:
                return Type.KEYBOARD;
            case 256:
            case 257:
            case 258:
            case 259:
            case 260:
            case 261:
            case NativeDefinitions.BTN_6 /*262*/:
            case NativeDefinitions.BTN_7 /*263*/:
            case NativeDefinitions.BTN_8 /*264*/:
            case NativeDefinitions.BTN_9 /*265*/:
                return Type.UNKNOWN;
            case 272:
            case NativeDefinitions.BTN_RIGHT /*273*/:
            case NativeDefinitions.BTN_MIDDLE /*274*/:
            case NativeDefinitions.BTN_SIDE /*275*/:
            case NativeDefinitions.BTN_EXTRA /*276*/:
                return Type.MOUSE;
            case 288:
            case NativeDefinitions.BTN_THUMB /*289*/:
            case NativeDefinitions.BTN_THUMB2 /*290*/:
            case NativeDefinitions.BTN_TOP /*291*/:
            case NativeDefinitions.BTN_TOP2 /*292*/:
            case NativeDefinitions.BTN_PINKIE /*293*/:
            case NativeDefinitions.BTN_BASE /*294*/:
            case NativeDefinitions.BTN_BASE2 /*295*/:
            case NativeDefinitions.BTN_BASE3 /*296*/:
            case NativeDefinitions.BTN_BASE4 /*297*/:
            case NativeDefinitions.BTN_BASE5 /*298*/:
            case NativeDefinitions.BTN_BASE6 /*299*/:
            case NativeDefinitions.BTN_DEAD /*303*/:
                return Type.STICK;
            case 304:
            case NativeDefinitions.BTN_B /*305*/:
            case NativeDefinitions.BTN_C /*306*/:
            case NativeDefinitions.BTN_X /*307*/:
            case NativeDefinitions.BTN_Y /*308*/:
            case NativeDefinitions.BTN_Z /*309*/:
            case NativeDefinitions.BTN_TL /*310*/:
            case NativeDefinitions.BTN_TR /*311*/:
            case NativeDefinitions.BTN_TL2 /*312*/:
            case NativeDefinitions.BTN_TR2 /*313*/:
            case NativeDefinitions.BTN_SELECT /*314*/:
            case NativeDefinitions.BTN_MODE /*316*/:
            case NativeDefinitions.BTN_THUMBL /*317*/:
            case NativeDefinitions.BTN_THUMBR /*318*/:
                return Type.GAMEPAD;
            default:
                return Type.UNKNOWN;
        }
    }

    private void reInit() {
        this.buttonIDs[1] = Key.ESCAPE;
        this.buttonIDs[2] = Key.f89_1;
        this.buttonIDs[3] = Key.f90_2;
        this.buttonIDs[4] = Key.f91_3;
        this.buttonIDs[5] = Key.f92_4;
        this.buttonIDs[6] = Key.f93_5;
        this.buttonIDs[7] = Key.f94_6;
        this.buttonIDs[8] = Key.f95_7;
        this.buttonIDs[9] = Key.f96_8;
        this.buttonIDs[10] = Key.f97_9;
        this.buttonIDs[11] = Key.f88_0;
        this.buttonIDs[12] = Key.MINUS;
        this.buttonIDs[13] = Key.EQUALS;
        this.buttonIDs[14] = Key.BACK;
        this.buttonIDs[15] = Key.TAB;
        this.buttonIDs[16] = Key.f77Q;
        this.buttonIDs[17] = Key.f84W;
        this.buttonIDs[18] = Key.f56E;
        this.buttonIDs[19] = Key.f78R;
        this.buttonIDs[20] = Key.f80T;
        this.buttonIDs[21] = Key.f86Y;
        this.buttonIDs[22] = Key.f81U;
        this.buttonIDs[23] = Key.f69I;
        this.buttonIDs[24] = Key.f75O;
        this.buttonIDs[25] = Key.f76P;
        this.buttonIDs[26] = Key.LBRACKET;
        this.buttonIDs[27] = Key.RBRACKET;
        this.buttonIDs[28] = Key.RETURN;
        this.buttonIDs[29] = Key.LCONTROL;
        this.buttonIDs[30] = Key.f50A;
        this.buttonIDs[31] = Key.f79S;
        this.buttonIDs[32] = Key.f55D;
        this.buttonIDs[33] = Key.f57F;
        this.buttonIDs[34] = Key.f67G;
        this.buttonIDs[35] = Key.f68H;
        this.buttonIDs[36] = Key.f70J;
        this.buttonIDs[37] = Key.f71K;
        this.buttonIDs[38] = Key.f72L;
        this.buttonIDs[39] = Key.SEMICOLON;
        this.buttonIDs[40] = Key.APOSTROPHE;
        this.buttonIDs[41] = Key.GRAVE;
        this.buttonIDs[42] = Key.LSHIFT;
        this.buttonIDs[43] = Key.BACKSLASH;
        this.buttonIDs[44] = Key.f87Z;
        this.buttonIDs[45] = Key.f85X;
        this.buttonIDs[46] = Key.f54C;
        this.buttonIDs[47] = Key.f83V;
        this.buttonIDs[48] = Key.f53B;
        this.buttonIDs[49] = Key.f74N;
        this.buttonIDs[50] = Key.f73M;
        this.buttonIDs[51] = Key.COMMA;
        this.buttonIDs[52] = Key.PERIOD;
        this.buttonIDs[53] = Key.SLASH;
        this.buttonIDs[54] = Key.RSHIFT;
        this.buttonIDs[55] = Key.MULTIPLY;
        this.buttonIDs[56] = Key.LALT;
        this.buttonIDs[57] = Key.SPACE;
        this.buttonIDs[58] = Key.CAPITAL;
        this.buttonIDs[59] = Key.f58F1;
        this.buttonIDs[60] = Key.f59F2;
        this.buttonIDs[61] = Key.f60F3;
        this.buttonIDs[62] = Key.f61F4;
        this.buttonIDs[63] = Key.f62F5;
        this.buttonIDs[64] = Key.f63F6;
        this.buttonIDs[65] = Key.f64F7;
        this.buttonIDs[66] = Key.f65F8;
        this.buttonIDs[67] = Key.f66F9;
        this.buttonIDs[68] = Key.F10;
        this.buttonIDs[69] = Key.NUMLOCK;
        this.buttonIDs[70] = Key.SCROLL;
        this.buttonIDs[71] = Key.NUMPAD7;
        this.buttonIDs[72] = Key.NUMPAD8;
        this.buttonIDs[73] = Key.NUMPAD9;
        this.buttonIDs[74] = Key.SUBTRACT;
        this.buttonIDs[75] = Key.NUMPAD4;
        this.buttonIDs[76] = Key.NUMPAD5;
        this.buttonIDs[77] = Key.NUMPAD6;
        this.buttonIDs[78] = Key.ADD;
        this.buttonIDs[79] = Key.NUMPAD1;
        this.buttonIDs[80] = Key.NUMPAD2;
        this.buttonIDs[81] = Key.NUMPAD3;
        this.buttonIDs[82] = Key.NUMPAD0;
        this.buttonIDs[83] = Key.DECIMAL;
        this.buttonIDs[183] = Key.F13;
        this.buttonIDs[86] = null;
        this.buttonIDs[87] = Key.F11;
        this.buttonIDs[88] = Key.F12;
        this.buttonIDs[184] = Key.F14;
        this.buttonIDs[185] = Key.F15;
        this.buttonIDs[186] = null;
        this.buttonIDs[187] = null;
        this.buttonIDs[188] = null;
        this.buttonIDs[189] = null;
        this.buttonIDs[190] = null;
        this.buttonIDs[96] = Key.NUMPADENTER;
        this.buttonIDs[97] = Key.RCONTROL;
        this.buttonIDs[98] = Key.DIVIDE;
        this.buttonIDs[99] = Key.SYSRQ;
        this.buttonIDs[100] = Key.RALT;
        this.buttonIDs[101] = null;
        this.buttonIDs[102] = Key.HOME;
        this.buttonIDs[103] = Key.f82UP;
        this.buttonIDs[104] = Key.PAGEUP;
        this.buttonIDs[105] = Key.LEFT;
        this.buttonIDs[106] = Key.RIGHT;
        this.buttonIDs[107] = Key.END;
        this.buttonIDs[108] = Key.DOWN;
        this.buttonIDs[109] = Key.PAGEDOWN;
        this.buttonIDs[110] = Key.INSERT;
        this.buttonIDs[111] = Key.DELETE;
        this.buttonIDs[119] = Key.PAUSE;
        this.buttonIDs[117] = Key.NUMPADEQUAL;
        this.buttonIDs[142] = Key.SLEEP;
        this.buttonIDs[240] = Key.UNLABELED;
        this.buttonIDs[256] = Button.f40_0;
        this.buttonIDs[257] = Button.f41_1;
        this.buttonIDs[258] = Button.f42_2;
        this.buttonIDs[259] = Button.f43_3;
        this.buttonIDs[260] = Button.f44_4;
        this.buttonIDs[261] = Button.f45_5;
        this.buttonIDs[262] = Button.f46_6;
        this.buttonIDs[263] = Button.f47_7;
        this.buttonIDs[264] = Button.f48_8;
        this.buttonIDs[265] = Button.f49_9;
        this.buttonIDs[272] = Button.LEFT;
        this.buttonIDs[273] = Button.RIGHT;
        this.buttonIDs[274] = Button.MIDDLE;
        this.buttonIDs[275] = Button.SIDE;
        this.buttonIDs[276] = Button.EXTRA;
        this.buttonIDs[277] = Button.FORWARD;
        this.buttonIDs[278] = Button.BACK;
        this.buttonIDs[288] = Button.TRIGGER;
        this.buttonIDs[289] = Button.THUMB;
        this.buttonIDs[290] = Button.THUMB2;
        this.buttonIDs[291] = Button.TOP;
        this.buttonIDs[292] = Button.TOP2;
        this.buttonIDs[293] = Button.PINKIE;
        this.buttonIDs[294] = Button.BASE;
        this.buttonIDs[295] = Button.BASE2;
        this.buttonIDs[296] = Button.BASE3;
        this.buttonIDs[297] = Button.BASE4;
        this.buttonIDs[298] = Button.BASE5;
        this.buttonIDs[299] = Button.BASE6;
        this.buttonIDs[303] = Button.DEAD;
        this.buttonIDs[304] = Button.f34A;
        this.buttonIDs[305] = Button.f35B;
        this.buttonIDs[306] = Button.f36C;
        this.buttonIDs[307] = Button.f37X;
        this.buttonIDs[308] = Button.f38Y;
        this.buttonIDs[309] = Button.f39Z;
        this.buttonIDs[310] = Button.LEFT_THUMB;
        this.buttonIDs[311] = Button.RIGHT_THUMB;
        this.buttonIDs[312] = Button.LEFT_THUMB2;
        this.buttonIDs[313] = Button.RIGHT_THUMB2;
        this.buttonIDs[314] = Button.SELECT;
        this.buttonIDs[316] = Button.MODE;
        this.buttonIDs[317] = Button.LEFT_THUMB3;
        this.buttonIDs[318] = Button.RIGHT_THUMB3;
        this.buttonIDs[320] = Button.TOOL_PEN;
        this.buttonIDs[321] = Button.TOOL_RUBBER;
        this.buttonIDs[322] = Button.TOOL_BRUSH;
        this.buttonIDs[323] = Button.TOOL_PENCIL;
        this.buttonIDs[324] = Button.TOOL_AIRBRUSH;
        this.buttonIDs[325] = Button.TOOL_FINGER;
        this.buttonIDs[326] = Button.TOOL_MOUSE;
        this.buttonIDs[327] = Button.TOOL_LENS;
        this.buttonIDs[330] = Button.TOUCH;
        this.buttonIDs[331] = Button.STYLUS;
        this.buttonIDs[332] = Button.STYLUS2;
        this.relAxesIDs[0] = Axis.f31X;
        this.relAxesIDs[1] = Axis.f32Y;
        this.relAxesIDs[2] = Axis.f33Z;
        this.relAxesIDs[8] = Axis.f33Z;
        this.relAxesIDs[6] = Axis.SLIDER;
        this.relAxesIDs[7] = Axis.SLIDER;
        this.relAxesIDs[9] = Axis.SLIDER;
        this.absAxesIDs[0] = Axis.f31X;
        this.absAxesIDs[1] = Axis.f32Y;
        this.absAxesIDs[2] = Axis.f33Z;
        this.absAxesIDs[3] = Axis.f28RX;
        this.absAxesIDs[4] = Axis.f29RY;
        this.absAxesIDs[5] = Axis.f30RZ;
        this.absAxesIDs[6] = Axis.SLIDER;
        this.absAxesIDs[7] = Axis.f30RZ;
        this.absAxesIDs[8] = Axis.f32Y;
        this.absAxesIDs[9] = Axis.SLIDER;
        this.absAxesIDs[10] = Axis.SLIDER;
        this.absAxesIDs[16] = Axis.POV;
        this.absAxesIDs[17] = Axis.POV;
        this.absAxesIDs[18] = Axis.POV;
        this.absAxesIDs[19] = Axis.POV;
        this.absAxesIDs[20] = Axis.POV;
        this.absAxesIDs[21] = Axis.POV;
        this.absAxesIDs[22] = Axis.POV;
        this.absAxesIDs[23] = Axis.POV;
        this.absAxesIDs[24] = null;
        this.absAxesIDs[25] = null;
        this.absAxesIDs[26] = null;
        this.absAxesIDs[27] = null;
        this.absAxesIDs[40] = null;
    }
}
