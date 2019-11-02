package net.java.games.input;

import java.util.HashMap;
import java.util.Map;
import net.java.games.input.Component.Identifier.Button;

final class ButtonUsage implements Usage {
    private static final Map map;
    private final int button_id;

    static {
        HashMap hashMap;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        map = hashMap2;
    }

    private ButtonUsage(int i) {
        this.button_id = i;
    }

    public static final ButtonUsage map(int i) {
        Integer num;
        ButtonUsage buttonUsage;
        int i2 = i;
        Integer num2 = num;
        Integer num3 = new Integer(i2);
        Integer num4 = num2;
        ButtonUsage buttonUsage2 = (ButtonUsage) map.get(num4);
        if (buttonUsage2 != null) {
            return buttonUsage2;
        }
        ButtonUsage buttonUsage3 = buttonUsage;
        ButtonUsage buttonUsage4 = new ButtonUsage(i2);
        ButtonUsage buttonUsage5 = buttonUsage3;
        Object put = map.put(num4, buttonUsage5);
        return buttonUsage5;
    }

    public final Button getIdentifier() {
        switch (this.button_id) {
            case 1:
                return Button.f40_0;
            case 2:
                return Button.f41_1;
            case 3:
                return Button.f42_2;
            case 4:
                return Button.f43_3;
            case 5:
                return Button.f44_4;
            case 6:
                return Button.f45_5;
            case 7:
                return Button.f46_6;
            case 8:
                return Button.f47_7;
            case 9:
                return Button.f48_8;
            case 10:
                return Button.f49_9;
            case 11:
                return Button._10;
            case 12:
                return Button._11;
            case 13:
                return Button._12;
            case 14:
                return Button._13;
            case 15:
                return Button._14;
            case 16:
                return Button._15;
            case 17:
                return Button._16;
            case 18:
                return Button._17;
            case 19:
                return Button._18;
            case 20:
                return Button._19;
            case 21:
                return Button._20;
            case 22:
                return Button._21;
            case 23:
                return Button._22;
            case 24:
                return Button._23;
            case 25:
                return Button._24;
            case 26:
                return Button._25;
            case 27:
                return Button._26;
            case 28:
                return Button._27;
            case 29:
                return Button._28;
            case 30:
                return Button._29;
            case 31:
                return Button._30;
            case 32:
                return Button._31;
            default:
                return null;
        }
    }

    public final String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append("ButtonUsage (").append(this.button_id).append(")").toString();
    }
}
