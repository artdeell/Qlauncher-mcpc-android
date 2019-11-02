package net.java.games.input;

public final class Event {
    private Component component;
    private long nanos;
    private float value;

    public Event() {
    }

    public final Component getComponent() {
        return this.component;
    }

    public final long getNanos() {
        return this.nanos;
    }

    public final float getValue() {
        return this.value;
    }

    public final void set(Component component2, float f, long j) {
        float f2 = f;
        long j2 = j;
        this.component = component2;
        this.value = f2;
        this.nanos = j2;
    }

    public final void set(Event event) {
        Event event2 = event;
        set(event2.getComponent(), event2.getValue(), event2.getNanos());
    }

    public final String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append("Event: component = ").append(this.component).append(" | value = ").append(this.value).toString();
    }
}
