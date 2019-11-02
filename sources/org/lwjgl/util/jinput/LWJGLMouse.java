package org.lwjgl.util.jinput;

import java.io.IOException;
import net.java.games.input.AbstractComponent;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Mouse;
import net.java.games.input.Rumbler;

final class LWJGLMouse extends Mouse {
    private static final int EVENT_BUTTON = 4;
    private static final int EVENT_DONE = 5;
    private static final int EVENT_WHEEL = 3;
    private static final int EVENT_X = 1;
    private static final int EVENT_Y = 2;
    private int event_state = 5;

    static final class Axis extends AbstractComponent {
        Axis(net.java.games.input.Component.Identifier.Axis axis) {
            net.java.games.input.Component.Identifier.Axis axis2 = axis;
            super(axis2.getName(), axis2);
        }

        public boolean isAnalog() {
            return true;
        }

        public boolean isRelative() {
            return true;
        }

        /* access modifiers changed from: protected */
        public float poll() throws IOException {
            return 0.0f;
        }
    }

    static final class Button extends AbstractComponent {
        private float value;

        Button(net.java.games.input.Component.Identifier.Button button) {
            net.java.games.input.Component.Identifier.Button button2 = button;
            super(button2.getName(), button2);
        }

        public boolean isAnalog() {
            return false;
        }

        public boolean isRelative() {
            return false;
        }

        /* access modifiers changed from: protected */
        public float poll() throws IOException {
            return this.value;
        }

        /* access modifiers changed from: 0000 */
        public void setValue(float f) {
            float f2 = f;
            this.value = f2;
        }
    }

    LWJGLMouse() {
        super("LWJGLMouse", createComponents(), new Controller[0], new Rumbler[0]);
    }

    private static Component[] createComponents() {
        Axis axis;
        Axis axis2;
        Axis axis3;
        Button button;
        Button button2;
        Button button3;
        Component[] componentArr = new Component[6];
        Component[] componentArr2 = componentArr;
        Axis axis4 = axis;
        Axis axis5 = new Axis(net.java.games.input.Component.Identifier.Axis.f31X);
        componentArr2[0] = axis4;
        Component[] componentArr3 = componentArr;
        Axis axis6 = axis2;
        Axis axis7 = new Axis(net.java.games.input.Component.Identifier.Axis.f32Y);
        componentArr3[1] = axis6;
        Component[] componentArr4 = componentArr;
        Axis axis8 = axis3;
        Axis axis9 = new Axis(net.java.games.input.Component.Identifier.Axis.f33Z);
        componentArr4[2] = axis8;
        Component[] componentArr5 = componentArr;
        Button button4 = button;
        Button button5 = new Button(net.java.games.input.Component.Identifier.Button.LEFT);
        componentArr5[3] = button4;
        Component[] componentArr6 = componentArr;
        Button button6 = button2;
        Button button7 = new Button(net.java.games.input.Component.Identifier.Button.MIDDLE);
        componentArr6[4] = button6;
        Component[] componentArr7 = componentArr;
        Button button8 = button3;
        Button button9 = new Button(net.java.games.input.Component.Identifier.Button.RIGHT);
        componentArr7[5] = button8;
        return componentArr;
    }

    private Button map(int i) {
        switch (i) {
            case 0:
                return (Button) getLeft();
            case 1:
                return (Button) getRight();
            case 2:
                return (Button) getMiddle();
            default:
                return null;
        }
    }

    private void setButtonState(int i) {
        int i2 = i;
        Button map = map(i2);
        if (map != null) {
            map.setValue(org.lwjgl.input.Mouse.isButtonDown(i2) ? 1.0f : 0.0f);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: CFG modification limit reached, blocks count: 148 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getNextDeviceEvent(net.java.games.input.Event r21) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r15 = r1
            monitor-enter(r15)
            boolean r15 = org.lwjgl.input.Mouse.isCreated()     // Catch:{ all -> 0x00d8 }
            r4 = r15
            r15 = 0
            r5 = r15
            r15 = r4
            if (r15 != 0) goto L_0x0026
        L_0x0010:
            r15 = r1
            monitor-exit(r15)
            r15 = r5
            r1 = r15
            return r1
        L_0x0015:
            boolean r15 = org.lwjgl.input.Mouse.next()     // Catch:{ all -> 0x00d8 }
            r8 = r15
            r15 = 0
            r5 = r15
            r15 = r8
            if (r15 == 0) goto L_0x0010
            r15 = r1
            r16 = 1
            r0 = r16
            r15.event_state = r0     // Catch:{ all -> 0x00d8 }
        L_0x0026:
            long r15 = org.lwjgl.input.Mouse.getEventNanoseconds()     // Catch:{ all -> 0x00d8 }
            r6 = r15
            r15 = r1
            int r15 = r15.event_state     // Catch:{ all -> 0x00d8 }
            switch(r15) {
                case 1: goto L_0x0032;
                case 2: goto L_0x0057;
                case 3: goto L_0x007d;
                case 4: goto L_0x00a3;
                case 5: goto L_0x0015;
                default: goto L_0x0031;
            }     // Catch:{ all -> 0x00d8 }
        L_0x0031:
            goto L_0x0026
        L_0x0032:
            r15 = r1
            r16 = 2
            r0 = r16
            r15.event_state = r0     // Catch:{ all -> 0x00d8 }
            int r15 = org.lwjgl.input.Mouse.getEventDX()     // Catch:{ all -> 0x00d8 }
            r14 = r15
            r15 = r14
            if (r15 == 0) goto L_0x0026
            r15 = r2
            r16 = r1
            net.java.games.input.Component r16 = r16.getX()     // Catch:{ all -> 0x00d8 }
            r17 = r14
            r0 = r17
            float r0 = (float) r0     // Catch:{ all -> 0x00d8 }
            r17 = r0
            r18 = r6
            r15.set(r16, r17, r18)     // Catch:{ all -> 0x00d8 }
            r15 = 1
            r5 = r15
            goto L_0x0010
        L_0x0057:
            r15 = r1
            r16 = 3
            r0 = r16
            r15.event_state = r0     // Catch:{ all -> 0x00d8 }
            int r15 = org.lwjgl.input.Mouse.getEventDY()     // Catch:{ all -> 0x00d8 }
            int r15 = -r15
            r13 = r15
            r15 = r13
            if (r15 == 0) goto L_0x0026
            r15 = r2
            r16 = r1
            net.java.games.input.Component r16 = r16.getY()     // Catch:{ all -> 0x00d8 }
            r17 = r13
            r0 = r17
            float r0 = (float) r0     // Catch:{ all -> 0x00d8 }
            r17 = r0
            r18 = r6
            r15.set(r16, r17, r18)     // Catch:{ all -> 0x00d8 }
            r15 = 1
            r5 = r15
            goto L_0x0010
        L_0x007d:
            r15 = r1
            r16 = 4
            r0 = r16
            r15.event_state = r0     // Catch:{ all -> 0x00d8 }
            int r15 = org.lwjgl.input.Mouse.getEventDWheel()     // Catch:{ all -> 0x00d8 }
            r12 = r15
            r15 = r12
            if (r15 == 0) goto L_0x0026
            r15 = r2
            r16 = r1
            net.java.games.input.Component r16 = r16.getWheel()     // Catch:{ all -> 0x00d8 }
            r17 = r12
            r0 = r17
            float r0 = (float) r0     // Catch:{ all -> 0x00d8 }
            r17 = r0
            r18 = r6
            r15.set(r16, r17, r18)     // Catch:{ all -> 0x00d8 }
            r15 = 1
            r5 = r15
            goto L_0x0010
        L_0x00a3:
            r15 = r1
            r16 = 5
            r0 = r16
            r15.event_state = r0     // Catch:{ all -> 0x00d8 }
            int r15 = org.lwjgl.input.Mouse.getEventButton()     // Catch:{ all -> 0x00d8 }
            r9 = r15
            r15 = r9
            r16 = -1
            r0 = r16
            if (r15 == r0) goto L_0x0026
            r15 = r1
            r16 = r9
            org.lwjgl.util.jinput.LWJGLMouse$Button r15 = r15.map(r16)     // Catch:{ all -> 0x00d8 }
            r10 = r15
            r15 = r10
            if (r15 == 0) goto L_0x0026
            boolean r15 = org.lwjgl.input.Mouse.getEventButtonState()     // Catch:{ all -> 0x00d8 }
            if (r15 == 0) goto L_0x00de
            r15 = 1065353216(0x3f800000, float:1.0)
            r11 = r15
        L_0x00ca:
            r15 = r2
            r16 = r10
            r17 = r11
            r18 = r6
            r15.set(r16, r17, r18)     // Catch:{ all -> 0x00d8 }
            r15 = 1
            r5 = r15
            goto L_0x0010
        L_0x00d8:
            r15 = move-exception
            r3 = r15
            r15 = r1
            monitor-exit(r15)
            r15 = r3
            throw r15
        L_0x00de:
            r15 = 0
            r11 = r15
            goto L_0x00ca
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.jinput.LWJGLMouse.getNextDeviceEvent(net.java.games.input.Event):boolean");
    }

    public void pollDevice() throws IOException {
        synchronized (this) {
            try {
                th = org.lwjgl.input.Mouse.isCreated();
                if (th) {
                    org.lwjgl.input.Mouse.poll();
                    for (int i = 0; i < 3; i++) {
                        setButtonState(i);
                    }
                }
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
    }
}
