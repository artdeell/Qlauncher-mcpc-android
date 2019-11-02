package com.apple.eawt;

import java.awt.Canvas;
import java.awt.Dimension;

public abstract class CocoaComponent extends Canvas {
    public CocoaComponent() {
    }

    public abstract int createNSView();

    public long createNSViewLong() {
        return 0;
    }

    public abstract Dimension getMaximumSize();

    public abstract Dimension getMinimumSize();

    public abstract Dimension getPreferredSize();

    public final void sendMessage(int i, Object obj) {
    }
}
