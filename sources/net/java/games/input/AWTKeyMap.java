package net.java.games.input;

import java.awt.event.KeyEvent;
import net.java.games.input.Component.Identifier.Key;

final class AWTKeyMap {
    AWTKeyMap() {
    }

    public static final Key map(KeyEvent keyEvent) {
        KeyEvent keyEvent2 = keyEvent;
        int keyCode = keyEvent2.getKeyCode();
        int keyLocation = keyEvent2.getKeyLocation();
        switch (keyCode) {
            case 10:
                return keyLocation == 4 ? Key.NUMPADENTER : Key.RETURN;
            case 16:
                return keyLocation == 3 ? Key.RSHIFT : Key.LSHIFT;
            case 17:
                return keyLocation == 3 ? Key.RCONTROL : Key.LCONTROL;
            case 18:
                return keyLocation == 3 ? Key.RALT : Key.LALT;
            case 44:
                return keyLocation == 4 ? Key.NUMPADCOMMA : Key.COMMA;
            default:
                return mapKeyCode(keyCode);
        }
    }

    public static final Key mapKeyCode(int i) {
        switch (i) {
            case 8:
                return Key.BACKSLASH;
            case 9:
                return Key.TAB;
            case 19:
                return Key.PAUSE;
            case 20:
                return Key.CAPITAL;
            case 21:
                return Key.KANA;
            case 25:
                return Key.KANJI;
            case 27:
                return Key.ESCAPE;
            case 28:
                return Key.CONVERT;
            case 29:
                return Key.NOCONVERT;
            case 32:
                return Key.SPACE;
            case 33:
                return Key.PAGEUP;
            case 34:
                return Key.PAGEDOWN;
            case 35:
                return Key.END;
            case 36:
                return Key.HOME;
            case 37:
                return Key.LEFT;
            case 38:
                return Key.f82UP;
            case 39:
                return Key.RIGHT;
            case 40:
                return Key.DOWN;
            case 45:
                return Key.MINUS;
            case 46:
                return Key.PERIOD;
            case 47:
                return Key.SLASH;
            case 48:
                return Key.f88_0;
            case 49:
                return Key.f89_1;
            case 50:
                return Key.f90_2;
            case 51:
                return Key.f91_3;
            case 52:
                return Key.f92_4;
            case 53:
                return Key.f93_5;
            case 54:
                return Key.f94_6;
            case 55:
                return Key.f95_7;
            case 56:
                return Key.f96_8;
            case 57:
                return Key.f97_9;
            case 59:
                return Key.SEMICOLON;
            case 61:
                return Key.EQUALS;
            case 65:
                return Key.f50A;
            case 66:
                return Key.f53B;
            case 67:
                return Key.f54C;
            case 68:
                return Key.f55D;
            case 69:
                return Key.f56E;
            case 70:
                return Key.f57F;
            case 71:
                return Key.f67G;
            case 72:
                return Key.f68H;
            case 73:
                return Key.f69I;
            case 74:
                return Key.f70J;
            case 75:
                return Key.f71K;
            case 76:
                return Key.f72L;
            case 77:
                return Key.f73M;
            case 78:
                return Key.f74N;
            case 79:
                return Key.f75O;
            case 80:
                return Key.f76P;
            case 81:
                return Key.f77Q;
            case 82:
                return Key.f78R;
            case 83:
                return Key.f79S;
            case 84:
                return Key.f80T;
            case 85:
                return Key.f81U;
            case 86:
                return Key.f83V;
            case 87:
                return Key.f84W;
            case 88:
                return Key.f85X;
            case 89:
                return Key.f86Y;
            case 90:
                return Key.f87Z;
            case 91:
                return Key.LBRACKET;
            case 92:
                return Key.BACKSLASH;
            case 93:
                return Key.RBRACKET;
            case 96:
                return Key.NUMPAD0;
            case 97:
                return Key.NUMPAD1;
            case 98:
                return Key.NUMPAD2;
            case 99:
                return Key.NUMPAD3;
            case 100:
                return Key.NUMPAD4;
            case 101:
                return Key.NUMPAD5;
            case 102:
                return Key.NUMPAD6;
            case 103:
                return Key.NUMPAD7;
            case 104:
                return Key.NUMPAD8;
            case 105:
                return Key.NUMPAD9;
            case 106:
                return Key.MULTIPLY;
            case 107:
                return Key.ADD;
            case 109:
                return Key.SUBTRACT;
            case 110:
                return Key.DECIMAL;
            case 111:
                return Key.DIVIDE;
            case 112:
                return Key.f58F1;
            case 113:
                return Key.f59F2;
            case 114:
                return Key.f60F3;
            case 115:
                return Key.f61F4;
            case 116:
                return Key.f62F5;
            case 117:
                return Key.f63F6;
            case 118:
                return Key.f64F7;
            case 119:
                return Key.f65F8;
            case 120:
                return Key.f66F9;
            case 121:
                return Key.F10;
            case 122:
                return Key.F11;
            case 123:
                return Key.F12;
            case 127:
                return Key.DELETE;
            case 144:
                return Key.NUMLOCK;
            case 145:
                return Key.SCROLL;
            case 155:
                return Key.INSERT;
            case 222:
                return Key.APOSTROPHE;
            case 512:
                return Key.f51AT;
            case 513:
                return Key.COLON;
            case 514:
                return Key.CIRCUMFLEX;
            case 520:
                return Key.GRAVE;
            case 523:
                return Key.UNDERLINE;
            case 65480:
                return Key.STOP;
            default:
                return Key.UNKNOWN;
        }
    }
}
