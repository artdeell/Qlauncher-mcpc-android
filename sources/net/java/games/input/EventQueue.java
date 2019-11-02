package net.java.games.input;

public final class EventQueue {
    private int head;
    private final Event[] queue;
    private int tail;

    public EventQueue(int i) {
        Event event;
        this.queue = new Event[(i + 1)];
        for (int i2 = 0; i2 < this.queue.length; i2++) {
            Event[] eventArr = this.queue;
            int i3 = i2;
            Event event2 = event;
            Event event3 = new Event();
            eventArr[i3] = event2;
        }
    }

    private final int increase(int i) {
        return (i + 1) % this.queue.length;
    }

    /* access modifiers changed from: 0000 */
    public final void add(Event event) {
        Event event2 = event;
        synchronized (this) {
            try {
                this.queue[this.tail].set(event2);
                this.tail = increase(this.tail);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public final boolean getNextEvent(Event event) {
        boolean z;
        Event event2 = event;
        synchronized (this) {
            try {
                if (this.head == this.tail) {
                    z = false;
                } else {
                    event2.set(this.queue[this.head]);
                    this.head = increase(this.head);
                    z = true;
                }
            } finally {
                int i = th;
                Throwable th = i;
            }
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public final boolean isFull() {
        boolean z;
        synchronized (this) {
            try {
                z = increase(this.tail) == this.head;
            } finally {
                int i = th;
                Throwable th = i;
            }
        }
        return z;
    }
}
