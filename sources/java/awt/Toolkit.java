package java.awt;

import java.awt.datatransfer.Clipboard;

public class Toolkit {
    Toolkit() {
    }

    public static Toolkit getDefaultToolkit() {
        Toolkit toolkit;
        Toolkit toolkit2 = toolkit;
        Toolkit toolkit3 = new Toolkit();
        return toolkit2;
    }

    public Clipboard getSystemClipboard() {
        Clipboard clipboard;
        Clipboard clipboard2 = clipboard;
        Clipboard clipboard3 = new Clipboard();
        return clipboard2;
    }
}
