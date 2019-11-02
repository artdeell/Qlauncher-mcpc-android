package org.lwjgl.util.jinput;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import net.java.games.input.AbstractComponent;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Event;
import net.java.games.input.Keyboard;
import net.java.games.input.Rumbler;

final class LWJGLKeyboard extends Keyboard {

    private static final class Key extends AbstractComponent {
        private final int lwjgl_key;
        private float value;

        Key(net.java.games.input.Component.Identifier.Key key, int i) {
            net.java.games.input.Component.Identifier.Key key2 = key;
            int i2 = i;
            super(key2.getName(), key2);
            this.lwjgl_key = i2;
        }

        public boolean isAnalog() {
            return false;
        }

        public boolean isRelative() {
            return false;
        }

        /* access modifiers changed from: protected */
        public float poll() {
            return this.value;
        }

        public void update() {
            this.value = org.lwjgl.input.Keyboard.isKeyDown(this.lwjgl_key) ? 1.0f : 0.0f;
        }
    }

    LWJGLKeyboard() {
        super("LWJGLKeyboard", createComponents(), new Controller[0], new Rumbler[0]);
    }

    private static Component[] createComponents() {
        ArrayList arrayList;
        RuntimeException runtimeException;
        Key key;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        Field[] fields = org.lwjgl.input.Keyboard.class.getFields();
        int length = fields.length;
        int i = 0;
        while (i < length) {
            Field field = fields[i];
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType() == Integer.TYPE && field.getName().startsWith("KEY_")) {
                    int i2 = field.getInt(null);
                    net.java.games.input.Component.Identifier.Key map = KeyMap.map(i2);
                    if (map != net.java.games.input.Component.Identifier.Key.UNKNOWN) {
                        ArrayList arrayList5 = arrayList4;
                        Key key2 = key;
                        Key key3 = new Key(map, i2);
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
        return (Component[]) arrayList4.toArray(new Component[arrayList4.size()]);
    }

    /* access modifiers changed from: protected */
    public boolean getNextDeviceEvent(Event event) throws IOException {
        boolean z;
        boolean z2;
        Event event2 = event;
        synchronized (this) {
            try {
                th = false;
                if (org.lwjgl.input.Keyboard.isCreated()) {
                    z2 = false;
                    if (org.lwjgl.input.Keyboard.next()) {
                        int eventKey = org.lwjgl.input.Keyboard.getEventKey();
                        z2 = false;
                        if (eventKey != 0) {
                            net.java.games.input.Component.Identifier.Key map = KeyMap.map(eventKey);
                            z2 = false;
                            if (map != null) {
                                Component component = getComponent(map);
                                z2 = false;
                                if (component != null) {
                                    event2.set(component, org.lwjgl.input.Keyboard.getEventKeyState() ? 1.0f : 0.0f, org.lwjgl.input.Keyboard.getEventNanoseconds());
                                    z2 = true;
                                }
                            }
                        }
                    }
                }
            } finally {
                z = th;
                Throwable th = z;
            }
        }
        return z2;
    }

    public void pollDevice() throws IOException {
        synchronized (this) {
            try {
                th = org.lwjgl.input.Keyboard.isCreated();
                if (th) {
                    org.lwjgl.input.Keyboard.poll();
                    Component[] components = getComponents();
                    int length = components.length;
                    for (int i = 0; i < length; i++) {
                        ((Key) components[i]).update();
                    }
                }
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
    }
}
