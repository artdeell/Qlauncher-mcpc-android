package net.java.games.input;

final class DataQueue {
    static final boolean $assertionsDisabled;
    static Class class$net$java$games$input$DataQueue;
    private final Object[] elements;
    private int limit;
    private int position;

    static {
        Class cls;
        if (class$net$java$games$input$DataQueue == null) {
            cls = class$("net.java.games.input.DataQueue");
            class$net$java$games$input$DataQueue = cls;
        } else {
            cls = class$net$java$games$input$DataQueue;
        }
        $assertionsDisabled = !cls.desiredAssertionStatus();
    }

    public DataQueue(int i, Class cls) {
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        Class cls2 = cls;
        this.elements = new Object[i];
        int i2 = 0;
        while (i2 < this.elements.length) {
            try {
                this.elements[i2] = cls2.newInstance();
                i2++;
            } catch (InstantiationException e) {
                InstantiationException instantiationException = e;
                RuntimeException runtimeException3 = runtimeException2;
                RuntimeException runtimeException4 = new RuntimeException(instantiationException);
                throw runtimeException3;
            } catch (IllegalAccessException e2) {
                IllegalAccessException illegalAccessException = e2;
                RuntimeException runtimeException5 = runtimeException;
                RuntimeException runtimeException6 = new RuntimeException(illegalAccessException);
                throw runtimeException5;
            }
        }
        clear();
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

    private final void swap(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        Object obj = this.elements[i3];
        this.elements[i3] = this.elements[i4];
        this.elements[i4] = obj;
    }

    public final void clear() {
        this.position = 0;
        this.limit = this.elements.length;
    }

    public final void compact() {
        int i = 0;
        while (hasRemaining()) {
            swap(this.position, i);
            this.position = 1 + this.position;
            i++;
        }
        this.position = i;
        this.limit = this.elements.length;
    }

    public final void flip() {
        this.limit = this.position;
        this.position = 0;
    }

    public final Object get() {
        if (!hasRemaining()) {
            return null;
        }
        int i = this.position;
        this.position = i + 1;
        return get(i);
    }

    public final Object get(int i) {
        AssertionError assertionError;
        int i2 = i;
        if ($assertionsDisabled || i2 < this.limit) {
            return this.elements[i2];
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    public final Object[] getElements() {
        return this.elements;
    }

    public final boolean hasRemaining() {
        return remaining() > 0;
    }

    public final int limit() {
        return this.limit;
    }

    public final int position() {
        return this.position;
    }

    public final void position(int i) {
        int i2 = i;
        this.position = i2;
    }

    public final int remaining() {
        return this.limit - this.position;
    }
}
