package java.awt.datatransfer;

public class Clipboard {
    public synchronized void setContents(Transferable transferable, ClipboardOwner clipboardOwner) {
        Transferable transferable2 = transferable;
        ClipboardOwner clipboardOwner2 = clipboardOwner;
        synchronized (this) {
        }
    }

    public Clipboard() {
    }
}
