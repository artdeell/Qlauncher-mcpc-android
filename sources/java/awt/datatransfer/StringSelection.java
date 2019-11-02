package java.awt.datatransfer;

public class StringSelection {
    private String data;

    public StringSelection(String str) {
        this.data = str;
    }

    public String getString() {
        return this.data;
    }
}
