package java.awt;

public class HeadlessException extends UnsupportedOperationException {
    private static final long serialVersionUID = 167183644944358563L;

    public HeadlessException() {
    }

    public HeadlessException(String str) {
        super(str);
    }

    public String getMessage() {
        StringBuffer stringBuffer;
        String message = super.getMessage();
        String headlessMessage = GraphicsEnvironment.getHeadlessMessage();
        if (message == null) {
            return headlessMessage;
        }
        if (headlessMessage == null) {
            return message;
        }
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append(message).append(headlessMessage).toString();
    }
}
