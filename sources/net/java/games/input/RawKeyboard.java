package net.java.games.input;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class RawKeyboard extends Keyboard {
    static Class class$net$java$games$input$RawIdentifierMap;
    private final RawDevice device;
    private final RawKeyboardEvent raw_event;

    static final class Key extends AbstractComponent {
        private final RawDevice device;
        private final int vkey_code;

        public Key(RawDevice rawDevice, int i, net.java.games.input.Component.Identifier.Key key) {
            RawDevice rawDevice2 = rawDevice;
            int i2 = i;
            net.java.games.input.Component.Identifier.Key key2 = key;
            super(key2.getName(), key2);
            this.device = rawDevice2;
            this.vkey_code = i2;
        }

        public final boolean isAnalog() {
            return false;
        }

        public final boolean isRelative() {
            return false;
        }

        /* access modifiers changed from: protected */
        public final float poll() throws IOException {
            return this.device.isKeyDown(this.vkey_code) ? 1.0f : 0.0f;
        }
    }

    protected RawKeyboard(String str, RawDevice rawDevice, Controller[] controllerArr, Rumbler[] rumblerArr) throws IOException {
        RawKeyboardEvent rawKeyboardEvent;
        RawDevice rawDevice2 = rawDevice;
        super(str, createKeyboardComponents(rawDevice2), controllerArr, rumblerArr);
        RawKeyboardEvent rawKeyboardEvent2 = rawKeyboardEvent;
        RawKeyboardEvent rawKeyboardEvent3 = new RawKeyboardEvent();
        this.raw_event = rawKeyboardEvent2;
        this.device = rawDevice2;
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

    private static final Component[] createKeyboardComponents(RawDevice rawDevice) {
        ArrayList arrayList;
        Class cls;
        RuntimeException runtimeException;
        Key key;
        RawDevice rawDevice2 = rawDevice;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        if (class$net$java$games$input$RawIdentifierMap == null) {
            cls = class$("net.java.games.input.RawIdentifierMap");
            class$net$java$games$input$RawIdentifierMap = cls;
        } else {
            cls = class$net$java$games$input$RawIdentifierMap;
        }
        Field[] fields = cls.getFields();
        int i = 0;
        while (i < fields.length) {
            Field field = fields[i];
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType() == Integer.TYPE) {
                    int i2 = field.getInt(null);
                    net.java.games.input.Component.Identifier.Key mapVKey = RawIdentifierMap.mapVKey(i2);
                    if (mapVKey != net.java.games.input.Component.Identifier.Key.UNKNOWN) {
                        ArrayList arrayList5 = arrayList4;
                        Key key2 = key;
                        Key key3 = new Key(rawDevice2, i2, mapVKey);
                        boolean add = arrayList5.add(key2);
                    }
                }
                i++;
            } catch (IllegalAccessException e) {
                IllegalAccessException illegalAccessException = e;
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException(illegalAccessException);
                throw runtimeException2;
            }
        }
        return (Component[]) arrayList4.toArray(new Component[0]);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r1.set(r5, 0.0f, r0.raw_event.getNanos());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean getNextDeviceEvent(net.java.games.input.Event r13) throws java.io.IOException {
        /*
            r12 = this;
            r0 = r12
            r1 = r13
            r7 = 1
            r2 = r7
            r7 = r0
            monitor-enter(r7)
        L_0x0006:
            r7 = r0
            net.java.games.input.RawDevice r7 = r7.device     // Catch:{ all -> 0x0050 }
            r8 = r0
            net.java.games.input.RawKeyboardEvent r8 = r8.raw_event     // Catch:{ all -> 0x0050 }
            boolean r7 = r7.getNextKeyboardEvent(r8)     // Catch:{ all -> 0x0050 }
            r4 = r7
            r7 = r4
            if (r7 != 0) goto L_0x001b
            r7 = 0
            r2 = r7
        L_0x0016:
            r7 = r0
            monitor-exit(r7)
            r7 = r2
            r0 = r7
            return r0
        L_0x001b:
            r7 = r0
            r8 = r0
            net.java.games.input.RawKeyboardEvent r8 = r8.raw_event     // Catch:{ all -> 0x0050 }
            int r8 = r8.getVKey()     // Catch:{ all -> 0x0050 }
            net.java.games.input.Component$Identifier$Key r8 = net.java.games.input.RawIdentifierMap.mapVKey(r8)     // Catch:{ all -> 0x0050 }
            net.java.games.input.Component r7 = r7.getComponent(r8)     // Catch:{ all -> 0x0050 }
            r5 = r7
            r7 = r5
            if (r7 == 0) goto L_0x0006
            r7 = r0
            net.java.games.input.RawKeyboardEvent r7 = r7.raw_event     // Catch:{ all -> 0x0050 }
            int r7 = r7.getMessage()     // Catch:{ all -> 0x0050 }
            r6 = r7
            r7 = r6
            r8 = 256(0x100, float:3.59E-43)
            if (r7 == r8) goto L_0x0041
            r7 = r6
            r8 = 260(0x104, float:3.64E-43)
            if (r7 != r8) goto L_0x0056
        L_0x0041:
            r7 = r1
            r8 = r5
            r9 = 1065353216(0x3f800000, float:1.0)
            r10 = r0
            net.java.games.input.RawKeyboardEvent r10 = r10.raw_event     // Catch:{ all -> 0x0050 }
            long r10 = r10.getNanos()     // Catch:{ all -> 0x0050 }
            r7.set(r8, r9, r10)     // Catch:{ all -> 0x0050 }
            goto L_0x0016
        L_0x0050:
            r7 = move-exception
            r3 = r7
            r7 = r0
            monitor-exit(r7)
            r7 = r3
            throw r7
        L_0x0056:
            r7 = r6
            r8 = 257(0x101, float:3.6E-43)
            if (r7 == r8) goto L_0x0060
            r7 = r6
            r8 = 261(0x105, float:3.66E-43)
            if (r7 != r8) goto L_0x0006
        L_0x0060:
            r7 = r1
            r8 = r5
            r9 = 0
            r10 = r0
            net.java.games.input.RawKeyboardEvent r10 = r10.raw_event     // Catch:{ all -> 0x0050 }
            long r10 = r10.getNanos()     // Catch:{ all -> 0x0050 }
            r7.set(r8, r9, r10)     // Catch:{ all -> 0x0050 }
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: net.java.games.input.RawKeyboard.getNextDeviceEvent(net.java.games.input.Event):boolean");
    }

    public final void pollDevice() throws IOException {
        this.device.pollKeyboard();
    }

    /* access modifiers changed from: protected */
    public final void setDeviceEventQueueSize(int i) throws IOException {
        int i2 = i;
        this.device.setBufferSize(i2);
    }
}
