package net.java.games.input;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

final class AWTKeyboard extends Keyboard implements AWTEventListener {
    static Class class$java$awt$event$KeyEvent;
    private final List awt_events;
    private Event[] processed_events;
    private int processed_events_index;

    private static final class Key extends AbstractComponent {
        private float value;

        public Key(net.java.games.input.Component.Identifier.Key key) {
            net.java.games.input.Component.Identifier.Key key2 = key;
            super(key2.getName(), key2);
        }

        public final boolean isAnalog() {
            return false;
        }

        public final boolean isRelative() {
            return false;
        }

        /* access modifiers changed from: protected */
        public final float poll() {
            return this.value;
        }

        public final void setValue(float f) {
            float f2 = f;
            this.value = f2;
        }
    }

    protected AWTKeyboard() {
        ArrayList arrayList;
        super("AWTKeyboard", createComponents(), new Controller[0], new Rumbler[0]);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.awt_events = arrayList2;
        Toolkit.getDefaultToolkit().addAWTEventListener(this, 8);
        resizeEventQueue(32);
    }

    private final void addEvent(Key key, float f, long j) {
        Key key2 = key;
        float f2 = f;
        long j2 = j;
        key2.setValue(f2);
        if (this.processed_events_index < this.processed_events.length) {
            Event[] eventArr = this.processed_events;
            int i = this.processed_events_index;
            this.processed_events_index = i + 1;
            eventArr[i].set(key2, f2, j2);
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

    private static final Component[] createComponents() {
        ArrayList arrayList;
        Class cls;
        Key key;
        Key key2;
        Key key3;
        Key key4;
        Key key5;
        Key key6;
        Key key7;
        Key key8;
        Key key9;
        Key key10;
        RuntimeException runtimeException;
        Key key11;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        if (class$java$awt$event$KeyEvent == null) {
            cls = class$("java.awt.event.KeyEvent");
            class$java$awt$event$KeyEvent = cls;
        } else {
            cls = class$java$awt$event$KeyEvent;
        }
        Field[] fields = cls.getFields();
        int i = 0;
        while (i < fields.length) {
            Field field = fields[i];
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType() == Integer.TYPE && field.getName().startsWith("VK_")) {
                    net.java.games.input.Component.Identifier.Key mapKeyCode = AWTKeyMap.mapKeyCode(field.getInt(null));
                    if (mapKeyCode != net.java.games.input.Component.Identifier.Key.UNKNOWN) {
                        ArrayList arrayList5 = arrayList4;
                        Key key12 = key11;
                        Key key13 = new Key(mapKeyCode);
                        boolean add = arrayList5.add(key12);
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
        ArrayList arrayList6 = arrayList4;
        Key key14 = key;
        Key key15 = new Key(net.java.games.input.Component.Identifier.Key.RCONTROL);
        boolean add2 = arrayList6.add(key14);
        ArrayList arrayList7 = arrayList4;
        Key key16 = key2;
        Key key17 = new Key(net.java.games.input.Component.Identifier.Key.LCONTROL);
        boolean add3 = arrayList7.add(key16);
        ArrayList arrayList8 = arrayList4;
        Key key18 = key3;
        Key key19 = new Key(net.java.games.input.Component.Identifier.Key.RSHIFT);
        boolean add4 = arrayList8.add(key18);
        ArrayList arrayList9 = arrayList4;
        Key key20 = key4;
        Key key21 = new Key(net.java.games.input.Component.Identifier.Key.LSHIFT);
        boolean add5 = arrayList9.add(key20);
        ArrayList arrayList10 = arrayList4;
        Key key22 = key5;
        Key key23 = new Key(net.java.games.input.Component.Identifier.Key.RALT);
        boolean add6 = arrayList10.add(key22);
        ArrayList arrayList11 = arrayList4;
        Key key24 = key6;
        Key key25 = new Key(net.java.games.input.Component.Identifier.Key.LALT);
        boolean add7 = arrayList11.add(key24);
        ArrayList arrayList12 = arrayList4;
        Key key26 = key7;
        Key key27 = new Key(net.java.games.input.Component.Identifier.Key.NUMPADENTER);
        boolean add8 = arrayList12.add(key26);
        ArrayList arrayList13 = arrayList4;
        Key key28 = key8;
        Key key29 = new Key(net.java.games.input.Component.Identifier.Key.RETURN);
        boolean add9 = arrayList13.add(key28);
        ArrayList arrayList14 = arrayList4;
        Key key30 = key9;
        Key key31 = new Key(net.java.games.input.Component.Identifier.Key.NUMPADCOMMA);
        boolean add10 = arrayList14.add(key30);
        ArrayList arrayList15 = arrayList4;
        Key key32 = key10;
        Key key33 = new Key(net.java.games.input.Component.Identifier.Key.COMMA);
        boolean add11 = arrayList15.add(key32);
        return (Component[]) arrayList4.toArray(new Component[0]);
    }

    private final void processEvent(KeyEvent keyEvent) {
        KeyEvent keyEvent2 = keyEvent;
        net.java.games.input.Component.Identifier.Key map = AWTKeyMap.map(keyEvent2);
        if (map != null) {
            Key key = (Key) getComponent(map);
            if (key != null) {
                long when = 1000000 * keyEvent2.getWhen();
                if (keyEvent2.getID() == 401) {
                    addEvent(key, 1.0f, when);
                } else if (keyEvent2.getID() == 402) {
                    KeyEvent peekEvent = Toolkit.getDefaultToolkit().getSystemEventQueue().peekEvent(NativeDefinitions.KEY_BLUE);
                    if (peekEvent == null || peekEvent.getWhen() != keyEvent2.getWhen()) {
                        addEvent(key, 0.0f, when);
                    }
                }
            }
        }
    }

    private final void resizeEventQueue(int i) {
        Event event;
        this.processed_events = new Event[i];
        for (int i2 = 0; i2 < this.processed_events.length; i2++) {
            Event[] eventArr = this.processed_events;
            int i3 = i2;
            Event event2 = event;
            Event event3 = new Event();
            eventArr[i3] = event2;
        }
        this.processed_events_index = 0;
    }

    public final void eventDispatched(AWTEvent aWTEvent) {
        AWTEvent aWTEvent2 = aWTEvent;
        synchronized (this) {
            try {
                if (aWTEvent2 instanceof KeyEvent) {
                    boolean add = this.awt_events.add(aWTEvent2);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean getNextDeviceEvent(Event event) throws IOException {
        boolean z;
        boolean z2;
        Event event2 = event;
        synchronized (this) {
            try {
                th = false;
                if (this.processed_events_index != 0) {
                    this.processed_events_index = -1 + this.processed_events_index;
                    event2.set(this.processed_events[0]);
                    Event event3 = this.processed_events[0];
                    this.processed_events[0] = this.processed_events[this.processed_events_index];
                    this.processed_events[this.processed_events_index] = event3;
                    z2 = true;
                }
            } finally {
                z = th;
                Throwable th = z;
            }
        }
        return z2;
    }

    /* JADX INFO: finally extract failed */
    public final void pollDevice() throws IOException {
        synchronized (this) {
            int i = 0;
            while (i < this.awt_events.size()) {
                try {
                    processEvent((KeyEvent) this.awt_events.get(i));
                    i++;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
            this.awt_events.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void setDeviceEventQueueSize(int i) throws IOException {
        resizeEventQueue(i);
    }
}
