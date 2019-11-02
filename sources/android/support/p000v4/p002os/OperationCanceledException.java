package android.support.p000v4.p002os;

/* renamed from: android.support.v4.os.OperationCanceledException */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String str) {
        String str2 = str;
        if (str2 == null) {
            str2 = "The operation has been canceled.";
        }
        super(str2);
    }
}
