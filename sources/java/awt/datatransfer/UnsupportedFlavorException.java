package java.awt.datatransfer;

public class UnsupportedFlavorException extends Exception {
    private static final long serialVersionUID = 5383814944251665601L;

    public UnsupportedFlavorException(DataFlavor dataFlavor) {
        StringBuffer stringBuffer;
        DataFlavor dataFlavor2 = dataFlavor;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        super(stringBuffer2.append("flavor = ").append(String.valueOf(dataFlavor2)).toString());
    }
}
