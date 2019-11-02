package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.java.games.input.Controller.PortType;
import net.java.games.input.Controller.Type;

final class LinuxEventDevice implements LinuxDevice {
    static Class class$net$java$games$input$Component$Identifier$Axis;
    static Class class$net$java$games$input$Component$Identifier$Key;
    private boolean closed;
    private final Map component_map;
    private final List components;

    /* renamed from: fd */
    private final long f154fd;
    private final LinuxInputID input_id;
    private final byte[] key_states = new byte[64];
    private final String name;
    private final Rumbler[] rumblers;
    private final Type type;

    public LinuxEventDevice(String str) throws IOException {
        HashMap hashMap;
        long nOpen;
        String str2 = str;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.component_map = hashMap2;
        boolean z = true;
        try {
            nOpen = nOpen(str2, true);
        } catch (IOException e) {
            IOException iOException = e;
            nOpen = nOpen(str2, false);
            z = false;
        }
        this.f154fd = nOpen;
        try {
            this.name = getDeviceName();
            this.input_id = getDeviceInputID();
            this.components = getDeviceComponents();
            if (z) {
                this.rumblers = enumerateRumblers();
            } else {
                this.rumblers = new Rumbler[0];
            }
            this.type = guessType();
        } catch (IOException e2) {
            IOException iOException2 = e2;
            close();
            throw iOException2;
        }
    }

    static long access$000(LinuxEventDevice linuxEventDevice) {
        return linuxEventDevice.f154fd;
    }

    static void access$100(long j) throws IOException {
        nClose(j);
    }

    private final void addAbsoluteAxes(List list) throws IOException {
        LinuxEventComponent linuxEventComponent;
        List list2 = list;
        byte[] absoluteAxesBits = getAbsoluteAxesBits();
        for (int i = 0; i < 8 * absoluteAxesBits.length; i++) {
            if (isBitSet(absoluteAxesBits, i)) {
                List list3 = list2;
                LinuxEventComponent linuxEventComponent2 = linuxEventComponent;
                LinuxEventComponent linuxEventComponent3 = new LinuxEventComponent(this, LinuxNativeTypesMap.getAbsAxisID(i), false, 3, i);
                boolean add = list3.add(linuxEventComponent2);
            }
        }
    }

    private final void addKeys(List list) throws IOException {
        LinuxEventComponent linuxEventComponent;
        List list2 = list;
        byte[] keysBits = getKeysBits();
        for (int i = 0; i < 8 * keysBits.length; i++) {
            if (isBitSet(keysBits, i)) {
                List list3 = list2;
                LinuxEventComponent linuxEventComponent2 = linuxEventComponent;
                LinuxEventComponent linuxEventComponent3 = new LinuxEventComponent(this, LinuxNativeTypesMap.getButtonID(i), false, 1, i);
                boolean add = list3.add(linuxEventComponent2);
            }
        }
    }

    private final void addRelativeAxes(List list) throws IOException {
        LinuxEventComponent linuxEventComponent;
        List list2 = list;
        byte[] relativeAxesBits = getRelativeAxesBits();
        for (int i = 0; i < 8 * relativeAxesBits.length; i++) {
            if (isBitSet(relativeAxesBits, i)) {
                List list3 = list2;
                LinuxEventComponent linuxEventComponent2 = linuxEventComponent;
                LinuxEventComponent linuxEventComponent3 = new LinuxEventComponent(this, LinuxNativeTypesMap.getRelAxisID(i), true, 2, i);
                boolean add = list3.add(linuxEventComponent2);
            }
        }
    }

    private final void checkClosed() throws IOException {
        IOException iOException;
        if (this.closed) {
            IOException iOException2 = iOException;
            IOException iOException3 = new IOException("Device is closed");
            throw iOException2;
        }
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

    private static final int countComponents(List list, Class cls, boolean z) {
        List list2 = list;
        Class cls2 = cls;
        boolean z2 = z;
        int i = 0;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            LinuxEventComponent linuxEventComponent = (LinuxEventComponent) list2.get(i2);
            if (cls2.isInstance(linuxEventComponent.getIdentifier()) && z2 == linuxEventComponent.isRelative()) {
                i++;
            }
        }
        return i;
    }

    private final Rumbler[] enumerateRumblers() {
        ArrayList arrayList;
        StringBuffer stringBuffer;
        LinuxRumbleFF linuxRumbleFF;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        try {
            int numEffects = getNumEffects();
            if (numEffects <= 0) {
                return (Rumbler[]) arrayList4.toArray(new Rumbler[0]);
            }
            if (isBitSet(getForceFeedbackBits(), 80) && numEffects > arrayList4.size()) {
                ArrayList arrayList5 = arrayList4;
                LinuxRumbleFF linuxRumbleFF2 = linuxRumbleFF;
                LinuxRumbleFF linuxRumbleFF3 = new LinuxRumbleFF(this);
                boolean add = arrayList5.add(linuxRumbleFF2);
            }
            return (Rumbler[]) arrayList4.toArray(new Rumbler[0]);
        } catch (IOException e) {
            IOException iOException = e;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            LinuxEnvironmentPlugin.logln(stringBuffer2.append("Failed to enumerate rumblers: ").append(iOException.getMessage()).toString());
        }
    }

    private final byte[] getAbsoluteAxesBits() throws IOException {
        byte[] bArr = new byte[8];
        nGetBits(this.f154fd, 3, bArr);
        return bArr;
    }

    private final List getDeviceComponents() throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        byte[] eventTypeBits = getEventTypeBits();
        if (isBitSet(eventTypeBits, 1)) {
            addKeys(arrayList4);
        }
        if (isBitSet(eventTypeBits, 3)) {
            addAbsoluteAxes(arrayList4);
        }
        if (isBitSet(eventTypeBits, 2)) {
            addRelativeAxes(arrayList4);
        }
        return arrayList4;
    }

    private final LinuxInputID getDeviceInputID() throws IOException {
        return nGetInputID(this.f154fd);
    }

    private final String getDeviceName() throws IOException {
        return nGetName(this.f154fd);
    }

    private final byte[] getDeviceUsageBits() throws IOException {
        byte[] bArr = new byte[2];
        if (getVersion() >= 65537) {
            nGetDeviceUsageBits(this.f154fd, bArr);
        }
        return bArr;
    }

    private final byte[] getEventTypeBits() throws IOException {
        byte[] bArr = new byte[4];
        nGetBits(this.f154fd, 0, bArr);
        return bArr;
    }

    private final byte[] getForceFeedbackBits() throws IOException {
        byte[] bArr = new byte[16];
        nGetBits(this.f154fd, 21, bArr);
        return bArr;
    }

    private final byte[] getKeysBits() throws IOException {
        byte[] bArr = new byte[64];
        nGetBits(this.f154fd, 1, bArr);
        return bArr;
    }

    private final byte[] getRelativeAxesBits() throws IOException {
        byte[] bArr = new byte[2];
        nGetBits(this.f154fd, 2, bArr);
        return bArr;
    }

    private final int getVersion() throws IOException {
        return nGetVersion(this.f154fd);
    }

    private final Type guessType() throws IOException {
        Type guessTypeFromUsages = guessTypeFromUsages();
        if (guessTypeFromUsages == Type.UNKNOWN) {
            guessTypeFromUsages = guessTypeFromComponents();
        }
        return guessTypeFromUsages;
    }

    private final Type guessTypeFromComponents() throws IOException {
        Class cls;
        Class cls2;
        Class cls3;
        List components2 = getComponents();
        if (components2.size() == 0) {
            return Type.UNKNOWN;
        }
        if (class$net$java$games$input$Component$Identifier$Axis == null) {
            cls = class$("net.java.games.input.Component$Identifier$Axis");
            class$net$java$games$input$Component$Identifier$Axis = cls;
        } else {
            cls = class$net$java$games$input$Component$Identifier$Axis;
        }
        int countComponents = countComponents(components2, cls, true);
        if (class$net$java$games$input$Component$Identifier$Axis == null) {
            cls2 = class$("net.java.games.input.Component$Identifier$Axis");
            class$net$java$games$input$Component$Identifier$Axis = cls2;
        } else {
            cls2 = class$net$java$games$input$Component$Identifier$Axis;
        }
        int countComponents2 = countComponents(components2, cls2, false);
        if (class$net$java$games$input$Component$Identifier$Key == null) {
            cls3 = class$("net.java.games.input.Component$Identifier$Key");
            class$net$java$games$input$Component$Identifier$Key = cls3;
        } else {
            cls3 = class$net$java$games$input$Component$Identifier$Key;
        }
        int countComponents3 = countComponents(components2, cls3, false);
        int i = 0;
        if (this.name.toLowerCase().indexOf("mouse") != -1) {
            i = 0 + 1;
        }
        int i2 = 0;
        if (this.name.toLowerCase().indexOf("keyboard") != -1) {
            i2 = 0 + 1;
        }
        int i3 = 0;
        if (this.name.toLowerCase().indexOf("joystick") != -1) {
            i3 = 0 + 1;
        }
        int i4 = 0;
        if (this.name.toLowerCase().indexOf("gamepad") != -1) {
            i4 = 0 + 1;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < components2.size(); i9++) {
            LinuxEventComponent linuxEventComponent = (LinuxEventComponent) components2.get(i9);
            if (linuxEventComponent.getButtonTrait() == Type.MOUSE) {
                i6++;
            } else {
                if (linuxEventComponent.getButtonTrait() == Type.KEYBOARD) {
                    i5++;
                } else {
                    if (linuxEventComponent.getButtonTrait() == Type.GAMEPAD) {
                        i8++;
                    } else {
                        if (linuxEventComponent.getButtonTrait() == Type.STICK) {
                            i7++;
                        }
                    }
                }
            }
        }
        if (i6 >= i5 && i6 >= i7 && i6 >= i8) {
            i++;
        } else if (i5 >= i6 && i5 >= i7 && i5 >= i8) {
            i2++;
        } else if (i7 >= i5 && i7 >= i6 && i7 >= i8) {
            i3++;
        } else if (i8 >= i5 && i8 >= i6 && i8 >= i7) {
            i4++;
        }
        if (countComponents >= 2) {
            i++;
        }
        if (countComponents2 >= 2) {
            i3++;
            i4++;
        }
        if (i >= i2 && i >= i3 && i >= i4) {
            return Type.MOUSE;
        }
        if (i2 >= i && i2 >= i3 && i2 >= i4) {
            return Type.KEYBOARD;
        }
        if (i3 >= i && i3 >= i2 && i3 >= i4) {
            return Type.STICK;
        }
        if (i4 < i || i4 < i2 || i4 < i3) {
            return null;
        }
        return Type.GAMEPAD;
    }

    private final Type guessTypeFromUsages() throws IOException {
        byte[] deviceUsageBits = getDeviceUsageBits();
        return isBitSet(deviceUsageBits, 0) ? Type.MOUSE : isBitSet(deviceUsageBits, 3) ? Type.KEYBOARD : isBitSet(deviceUsageBits, 2) ? Type.GAMEPAD : isBitSet(deviceUsageBits, 1) ? Type.STICK : Type.UNKNOWN;
    }

    public static final boolean isBitSet(byte[] bArr, int i) {
        int i2 = i;
        return (bArr[i2 / 8] & (1 << (i2 % 8))) != 0;
    }

    private static final native void nClose(long j) throws IOException;

    private static final native void nEraseEffect(long j, int i) throws IOException;

    private static final native void nGetAbsInfo(long j, int i, LinuxAbsInfo linuxAbsInfo) throws IOException;

    private static final native void nGetBits(long j, int i, byte[] bArr) throws IOException;

    private static final native void nGetDeviceUsageBits(long j, byte[] bArr) throws IOException;

    private static final native LinuxInputID nGetInputID(long j) throws IOException;

    private static final native void nGetKeyStates(long j, byte[] bArr) throws IOException;

    private static final native String nGetName(long j) throws IOException;

    private static final native boolean nGetNextEvent(long j, LinuxEvent linuxEvent) throws IOException;

    private static final native int nGetNumEffects(long j) throws IOException;

    private static final native int nGetVersion(long j) throws IOException;

    private static final native long nOpen(String str, boolean z) throws IOException;

    private static final native int nUploadConstantEffect(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) throws IOException;

    private static final native int nUploadRumbleEffect(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IOException;

    private static final native void nWriteEvent(long j, int i, int i2, int i3) throws IOException;

    public final void close() throws IOException {
        C06211 r6;
        synchronized (this) {
            try {
                th = this.closed;
                if (!th) {
                    this.closed = true;
                    C06211 r3 = r6;
                    C06211 r4 = new LinuxDeviceTask(this) {
                        private final LinuxEventDevice this$0;

                        {
                            this.this$0 = r5;
                        }

                        /* access modifiers changed from: protected */
                        public final Object execute() throws IOException {
                            LinuxEventDevice.access$100(LinuxEventDevice.access$000(this.this$0));
                            return null;
                        }
                    };
                    Object execute = LinuxEnvironmentPlugin.execute(r3);
                }
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void eraseEffect(int i) throws IOException {
        int i2 = i;
        nEraseEffect(this.f154fd, i2);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws IOException {
        close();
    }

    public final void getAbsInfo(int i, LinuxAbsInfo linuxAbsInfo) throws IOException {
        int i2 = i;
        LinuxAbsInfo linuxAbsInfo2 = linuxAbsInfo;
        synchronized (this) {
            try {
                checkClosed();
                nGetAbsInfo(this.f154fd, i2, linuxAbsInfo2);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public final List getComponents() {
        return this.components;
    }

    public final LinuxInputID getInputID() {
        return this.input_id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNextEvent(LinuxEvent linuxEvent) throws IOException {
        boolean z;
        LinuxEvent linuxEvent2 = linuxEvent;
        synchronized (this) {
            try {
                checkClosed();
                th = nGetNextEvent(this.f154fd, linuxEvent2);
            } finally {
                z = th;
                Throwable th = z;
            }
        }
        return z;
    }

    public final int getNumEffects() throws IOException {
        return nGetNumEffects(this.f154fd);
    }

    public final PortType getPortType() throws IOException {
        return this.input_id.getPortType();
    }

    public final Rumbler[] getRumblers() {
        return this.rumblers;
    }

    public final Type getType() {
        return this.type;
    }

    public final boolean isKeySet(int i) {
        return isBitSet(this.key_states, i);
    }

    public final LinuxComponent mapDescriptor(LinuxAxisDescriptor linuxAxisDescriptor) {
        return (LinuxComponent) this.component_map.get(linuxAxisDescriptor);
    }

    public final void pollKeyStates() throws IOException {
        synchronized (this) {
            try {
                nGetKeyStates(this.f154fd, this.key_states);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public final void registerComponent(LinuxAxisDescriptor linuxAxisDescriptor, LinuxComponent linuxComponent) {
        LinuxAxisDescriptor linuxAxisDescriptor2 = linuxAxisDescriptor;
        LinuxComponent linuxComponent2 = linuxComponent;
        Object put = this.component_map.put(linuxAxisDescriptor2, linuxComponent2);
    }

    public final int uploadConstantEffect(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) throws IOException {
        int i12;
        int i13 = i;
        int i14 = i2;
        int i15 = i3;
        int i16 = i4;
        int i17 = i5;
        int i18 = i6;
        int i19 = i7;
        int i20 = i8;
        int i21 = i9;
        int i22 = i10;
        int i23 = i11;
        synchronized (this) {
            try {
                checkClosed();
                th = nUploadConstantEffect(this.f154fd, i13, i15, i14, i16, i17, i18, i19, i20, i21, i22, i23);
            } finally {
                i12 = th;
                Throwable th = i12;
            }
        }
        return i12;
    }

    public final int uploadRumbleEffect(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IOException {
        int i9;
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        synchronized (this) {
            try {
                checkClosed();
                th = nUploadRumbleEffect(this.f154fd, i10, i12, i11, i13, i14, i15, i16, i17);
            } finally {
                i9 = th;
                Throwable th = i9;
            }
        }
        return i9;
    }

    public final void writeEvent(int i, int i2, int i3) throws IOException {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        synchronized (this) {
            try {
                checkClosed();
                nWriteEvent(this.f154fd, i4, i5, i6);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}
