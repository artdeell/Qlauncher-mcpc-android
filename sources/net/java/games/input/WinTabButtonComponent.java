package net.java.games.input;

import net.java.games.input.Component.Identifier;

public class WinTabButtonComponent extends WinTabComponent {
    private int index;

    protected WinTabButtonComponent(WinTabContext winTabContext, int i, String str, Identifier identifier, int i2) {
        int i3 = i2;
        super(winTabContext, i, str, identifier);
        this.index = i3;
    }

    public Event processPacket(WinTabPacket winTabPacket) {
        Event event;
        WinTabPacket winTabPacket2 = winTabPacket;
        float f = (winTabPacket2.PK_BUTTONS & ((int) Math.pow(2.0d, (double) this.index))) > 0 ? 1.0f : 0.0f;
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
