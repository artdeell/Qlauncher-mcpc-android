package net.java.games.input;

import net.java.games.input.Component.Identifier;

public class WinTabCursorComponent extends WinTabComponent {
    private int index;

    protected WinTabCursorComponent(WinTabContext winTabContext, int i, String str, Identifier identifier, int i2) {
        int i3 = i2;
        super(winTabContext, i, str, identifier);
        this.index = i3;
    }

    public Event processPacket(WinTabPacket winTabPacket) {
        Event event;
        Event event2;
        Event event3;
        WinTabPacket winTabPacket2 = winTabPacket;
        if (winTabPacket2.PK_CURSOR == this.index && this.lastKnownValue == 0.0f) {
            this.lastKnownValue = 1.0f;
            Event event4 = event3;
            Event event5 = new Event();
            event = event4;
            event.set(this, this.lastKnownValue, 1000 * winTabPacket2.PK_TIME);
        } else {
            event = null;
            if (winTabPacket2.PK_CURSOR != this.index) {
                event = null;
                if (this.lastKnownValue == 1.0f) {
                    this.lastKnownValue = 0.0f;
                    Event event6 = event2;
                    Event event7 = new Event();
                    Event event8 = event6;
                    event8.set(this, this.lastKnownValue, 1000 * winTabPacket2.PK_TIME);
                    return event8;
                }
            }
        }
        return event;
    }
}
