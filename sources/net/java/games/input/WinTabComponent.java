package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Component.Identifier.Axis;
import net.java.games.input.Component.Identifier.Button;

public class WinTabComponent extends AbstractComponent {
    public static final int NPressureAxis = 4;
    public static final int OrientationAxis = 6;
    public static final int RotationAxis = 7;
    public static final int TPressureAxis = 5;
    public static final int XAxis = 1;
    public static final int YAxis = 2;
    public static final int ZAxis = 3;
    static Class class$net$java$games$input$Component$Identifier$Button;
    private boolean analog;
    protected float lastKnownValue;
    private int max;
    private int min;

    protected WinTabComponent(WinTabContext winTabContext, int i, String str, Identifier identifier) {
        WinTabContext winTabContext2 = winTabContext;
        int i2 = i;
        super(str, identifier);
        this.min = 0;
        this.max = 1;
        this.analog = false;
    }

    protected WinTabComponent(WinTabContext winTabContext, int i, String str, Identifier identifier, int i2, int i3) {
        WinTabContext winTabContext2 = winTabContext;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        super(str, identifier);
        this.min = i5;
        this.max = i6;
        this.analog = true;
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

    public static Collection createButtons(WinTabContext winTabContext, int i, int i2) {
        ArrayList arrayList;
        Class cls;
        StringBuffer stringBuffer;
        WinTabButtonComponent winTabButtonComponent;
        WinTabContext winTabContext2 = winTabContext;
        int i3 = i;
        int i4 = i2;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (int i5 = 0; i5 < i4; i5++) {
            try {
                if (class$net$java$games$input$Component$Identifier$Button == null) {
                    cls = class$("net.java.games.input.Component$Identifier$Button");
                    class$net$java$games$input$Component$Identifier$Button = cls;
                } else {
                    cls = class$net$java$games$input$Component$Identifier$Button;
                }
                Class cls2 = cls;
                StringBuffer stringBuffer2 = stringBuffer;
                StringBuffer stringBuffer3 = new StringBuffer();
                Identifier identifier = (Identifier) cls2.getField(stringBuffer2.append("_").append(i5).toString()).get(null);
                ArrayList arrayList5 = arrayList4;
                WinTabButtonComponent winTabButtonComponent2 = winTabButtonComponent;
                WinTabButtonComponent winTabButtonComponent3 = new WinTabButtonComponent(winTabContext2, i3, identifier.getName(), identifier, i5);
                boolean add = arrayList5.add(winTabButtonComponent2);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            }
        }
        return arrayList4;
    }

    public static List createComponents(WinTabContext winTabContext, int i, int i2, int[] iArr) {
        ArrayList arrayList;
        WinTabComponent winTabComponent;
        WinTabComponent winTabComponent2;
        WinTabComponent winTabComponent3;
        WinTabComponent winTabComponent4;
        WinTabComponent winTabComponent5;
        WinTabComponent winTabComponent6;
        WinTabComponent winTabComponent7;
        WinTabComponent winTabComponent8;
        WinTabComponent winTabComponent9;
        WinTabComponent winTabComponent10;
        WinTabComponent winTabComponent11;
        WinTabContext winTabContext2 = winTabContext;
        int i3 = i;
        int i4 = i2;
        int[] iArr2 = iArr;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        switch (i4) {
            case 1:
                Axis axis = Axis.f31X;
                ArrayList arrayList5 = arrayList4;
                WinTabComponent winTabComponent12 = winTabComponent11;
                WinTabComponent winTabComponent13 = new WinTabComponent(winTabContext2, i3, axis.getName(), axis, iArr2[0], iArr2[1]);
                boolean add = arrayList5.add(winTabComponent12);
                return arrayList4;
            case 2:
                Axis axis2 = Axis.f32Y;
                ArrayList arrayList6 = arrayList4;
                WinTabComponent winTabComponent14 = winTabComponent10;
                WinTabComponent winTabComponent15 = new WinTabComponent(winTabContext2, i3, axis2.getName(), axis2, iArr2[0], iArr2[1]);
                boolean add2 = arrayList6.add(winTabComponent14);
                return arrayList4;
            case 3:
                Axis axis3 = Axis.f33Z;
                ArrayList arrayList7 = arrayList4;
                WinTabComponent winTabComponent16 = winTabComponent9;
                WinTabComponent winTabComponent17 = new WinTabComponent(winTabContext2, i3, axis3.getName(), axis3, iArr2[0], iArr2[1]);
                boolean add3 = arrayList7.add(winTabComponent16);
                return arrayList4;
            case 4:
                Axis axis4 = Axis.X_FORCE;
                ArrayList arrayList8 = arrayList4;
                WinTabComponent winTabComponent18 = winTabComponent8;
                WinTabComponent winTabComponent19 = new WinTabComponent(winTabContext2, i3, axis4.getName(), axis4, iArr2[0], iArr2[1]);
                boolean add4 = arrayList8.add(winTabComponent18);
                return arrayList4;
            case 5:
                Axis axis5 = Axis.Y_FORCE;
                ArrayList arrayList9 = arrayList4;
                WinTabComponent winTabComponent20 = winTabComponent7;
                WinTabComponent winTabComponent21 = new WinTabComponent(winTabContext2, i3, axis5.getName(), axis5, iArr2[0], iArr2[1]);
                boolean add5 = arrayList9.add(winTabComponent20);
                return arrayList4;
            case 6:
                Axis axis6 = Axis.f28RX;
                ArrayList arrayList10 = arrayList4;
                WinTabComponent winTabComponent22 = winTabComponent4;
                WinTabComponent winTabComponent23 = new WinTabComponent(winTabContext2, i3, axis6.getName(), axis6, iArr2[0], iArr2[1]);
                boolean add6 = arrayList10.add(winTabComponent22);
                Axis axis7 = Axis.f29RY;
                ArrayList arrayList11 = arrayList4;
                WinTabComponent winTabComponent24 = winTabComponent5;
                WinTabComponent winTabComponent25 = new WinTabComponent(winTabContext2, i3, axis7.getName(), axis7, iArr2[2], iArr2[3]);
                boolean add7 = arrayList11.add(winTabComponent24);
                Axis axis8 = Axis.f30RZ;
                ArrayList arrayList12 = arrayList4;
                WinTabComponent winTabComponent26 = winTabComponent6;
                WinTabComponent winTabComponent27 = new WinTabComponent(winTabContext2, i3, axis8.getName(), axis8, iArr2[4], iArr2[5]);
                boolean add8 = arrayList12.add(winTabComponent26);
                return arrayList4;
            case 7:
                Axis axis9 = Axis.f28RX;
                ArrayList arrayList13 = arrayList4;
                WinTabComponent winTabComponent28 = winTabComponent;
                WinTabComponent winTabComponent29 = new WinTabComponent(winTabContext2, i3, axis9.getName(), axis9, iArr2[0], iArr2[1]);
                boolean add9 = arrayList13.add(winTabComponent28);
                Axis axis10 = Axis.f29RY;
                ArrayList arrayList14 = arrayList4;
                WinTabComponent winTabComponent30 = winTabComponent2;
                WinTabComponent winTabComponent31 = new WinTabComponent(winTabContext2, i3, axis10.getName(), axis10, iArr2[2], iArr2[3]);
                boolean add10 = arrayList14.add(winTabComponent30);
                Axis axis11 = Axis.f30RZ;
                ArrayList arrayList15 = arrayList4;
                WinTabComponent winTabComponent32 = winTabComponent3;
                WinTabComponent winTabComponent33 = new WinTabComponent(winTabContext2, i3, axis11.getName(), axis11, iArr2[4], iArr2[5]);
                boolean add11 = arrayList15.add(winTabComponent32);
                return arrayList4;
            default:
                return arrayList4;
        }
    }

    public static Collection createCursors(WinTabContext winTabContext, int i, String[] strArr) {
        ArrayList arrayList;
        WinTabCursorComponent winTabCursorComponent;
        WinTabContext winTabContext2 = winTabContext;
        int i2 = i;
        String[] strArr2 = strArr;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (int i3 = 0; i3 < strArr2.length; i3++) {
            Button button = strArr2[i3].matches("Puck") ? Button.TOOL_FINGER : strArr2[i3].matches("Eraser.*") ? Button.TOOL_RUBBER : Button.TOOL_PEN;
            Button button2 = button;
            ArrayList arrayList5 = arrayList4;
            WinTabCursorComponent winTabCursorComponent2 = winTabCursorComponent;
            WinTabCursorComponent winTabCursorComponent3 = new WinTabCursorComponent(winTabContext2, i2, button2.getName(), button2, i3);
            boolean add = arrayList5.add(winTabCursorComponent2);
        }
        return arrayList4;
    }

    private float normalise(float f) {
        float f2 = f;
        if (this.max == this.min) {
            return f2;
        }
        return (f2 - ((float) this.min)) / ((float) (this.max - this.min));
    }

    public boolean isAnalog() {
        return this.analog;
    }

    public boolean isRelative() {
        return false;
    }

    /* access modifiers changed from: protected */
    public float poll() throws IOException {
        return this.lastKnownValue;
    }

    public Event processPacket(WinTabPacket winTabPacket) {
        Event event;
        WinTabPacket winTabPacket2 = winTabPacket;
        float f = this.lastKnownValue;
        if (getIdentifier() == Axis.f31X) {
            f = normalise((float) winTabPacket2.PK_X);
        }
        if (getIdentifier() == Axis.f32Y) {
            f = normalise((float) winTabPacket2.PK_Y);
        }
        if (getIdentifier() == Axis.f33Z) {
            f = normalise((float) winTabPacket2.PK_Z);
        }
        if (getIdentifier() == Axis.X_FORCE) {
            f = normalise((float) winTabPacket2.PK_NORMAL_PRESSURE);
        }
        if (getIdentifier() == Axis.Y_FORCE) {
            f = normalise((float) winTabPacket2.PK_TANGENT_PRESSURE);
        }
        if (getIdentifier() == Axis.f28RX) {
            f = normalise((float) winTabPacket2.PK_ORIENTATION_ALT);
        }
        if (getIdentifier() == Axis.f29RY) {
            f = normalise((float) winTabPacket2.PK_ORIENTATION_AZ);
        }
        if (getIdentifier() == Axis.f30RZ) {
            f = normalise((float) winTabPacket2.PK_ORIENTATION_TWIST);
        }
        if (f == getPollData()) {
            return null;
        }
        this.lastKnownValue = f;
        Event event2 = event;
        Event event3 = new Event();
        Event event4 = event2;
        event4.set(this, f, 1000 * winTabPacket2.PK_TIME);
        return event4;
    }
}
