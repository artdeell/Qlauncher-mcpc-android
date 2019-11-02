package java.awt;

public class GraphicsEnvironment {
    public static String getHeadlessMessage() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append("\nNo X11 DISPLAY variable was set, ").append("but this program performed an operation which requires it.").toString();
    }

    public GraphicsEnvironment() {
    }
}
