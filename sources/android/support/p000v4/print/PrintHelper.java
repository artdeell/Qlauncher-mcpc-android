package android.support.p000v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.FileNotFoundException;

/* renamed from: android.support.v4.print.PrintHelper */
public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    PrintHelperVersionImpl mImpl;

    /* renamed from: android.support.v4.print.PrintHelper$OnPrintFinishCallback */
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    /* renamed from: android.support.v4.print.PrintHelper$PrintHelperKitkatImpl */
    private static final class PrintHelperKitkatImpl implements PrintHelperVersionImpl {
        private final PrintHelperKitkat mPrintHelper;

        PrintHelperKitkatImpl(Context context) {
            PrintHelperKitkat printHelperKitkat;
            PrintHelperKitkat printHelperKitkat2 = printHelperKitkat;
            PrintHelperKitkat printHelperKitkat3 = new PrintHelperKitkat(context);
            this.mPrintHelper = printHelperKitkat2;
        }

        public int getColorMode() {
            return this.mPrintHelper.getColorMode();
        }

        public int getOrientation() {
            return this.mPrintHelper.getOrientation();
        }

        public int getScaleMode() {
            return this.mPrintHelper.getScaleMode();
        }

        public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            C00881 r9;
            String str2 = str;
            Bitmap bitmap2 = bitmap;
            OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
            C00881 r4 = null;
            if (onPrintFinishCallback2 != null) {
                C00881 r5 = r9;
                final OnPrintFinishCallback onPrintFinishCallback3 = onPrintFinishCallback2;
                C00881 r6 = new android.support.p000v4.print.PrintHelperKitkat.OnPrintFinishCallback(this) {
                    final /* synthetic */ PrintHelperKitkatImpl this$0;

                    {
                        OnPrintFinishCallback onPrintFinishCallback = r7;
                        this.this$0 = r6;
                    }

                    public void onFinish() {
                        onPrintFinishCallback3.onFinish();
                    }
                };
                r4 = r5;
            }
            this.mPrintHelper.printBitmap(str2, bitmap2, (android.support.p000v4.print.PrintHelperKitkat.OnPrintFinishCallback) r4);
        }

        public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
            C00892 r9;
            String str2 = str;
            Uri uri2 = uri;
            OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
            C00892 r4 = null;
            if (onPrintFinishCallback2 != null) {
                C00892 r5 = r9;
                final OnPrintFinishCallback onPrintFinishCallback3 = onPrintFinishCallback2;
                C00892 r6 = new android.support.p000v4.print.PrintHelperKitkat.OnPrintFinishCallback(this) {
                    final /* synthetic */ PrintHelperKitkatImpl this$0;

                    {
                        OnPrintFinishCallback onPrintFinishCallback = r7;
                        this.this$0 = r6;
                    }

                    public void onFinish() {
                        onPrintFinishCallback3.onFinish();
                    }
                };
                r4 = r5;
            }
            this.mPrintHelper.printBitmap(str2, uri2, (android.support.p000v4.print.PrintHelperKitkat.OnPrintFinishCallback) r4);
        }

        public void setColorMode(int i) {
            int i2 = i;
            this.mPrintHelper.setColorMode(i2);
        }

        public void setOrientation(int i) {
            int i2 = i;
            this.mPrintHelper.setOrientation(i2);
        }

        public void setScaleMode(int i) {
            int i2 = i;
            this.mPrintHelper.setScaleMode(i2);
        }
    }

    /* renamed from: android.support.v4.print.PrintHelper$PrintHelperStubImpl */
    private static final class PrintHelperStubImpl implements PrintHelperVersionImpl {
        int mColorMode;
        int mOrientation;
        int mScaleMode;

        private PrintHelperStubImpl() {
            this.mScaleMode = 2;
            this.mColorMode = 2;
            this.mOrientation = 1;
        }

        /* synthetic */ PrintHelperStubImpl(C00871 r4) {
            C00871 r1 = r4;
            this();
        }

        public int getColorMode() {
            return this.mColorMode;
        }

        public int getOrientation() {
            return this.mOrientation;
        }

        public int getScaleMode() {
            return this.mScaleMode;
        }

        public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        }

        public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
        }

        public void setColorMode(int i) {
            int i2 = i;
            this.mColorMode = i2;
        }

        public void setOrientation(int i) {
            int i2 = i;
            this.mOrientation = i2;
        }

        public void setScaleMode(int i) {
            int i2 = i;
            this.mScaleMode = i2;
        }
    }

    /* renamed from: android.support.v4.print.PrintHelper$PrintHelperVersionImpl */
    interface PrintHelperVersionImpl {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback);

        void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException;

        void setColorMode(int i);

        void setOrientation(int i);

        void setScaleMode(int i);
    }

    public PrintHelper(Context context) {
        PrintHelperStubImpl printHelperStubImpl;
        PrintHelperKitkatImpl printHelperKitkatImpl;
        Context context2 = context;
        if (systemSupportsPrint()) {
            PrintHelperKitkatImpl printHelperKitkatImpl2 = printHelperKitkatImpl;
            PrintHelperKitkatImpl printHelperKitkatImpl3 = new PrintHelperKitkatImpl(context2);
            this.mImpl = printHelperKitkatImpl2;
            return;
        }
        PrintHelperStubImpl printHelperStubImpl2 = printHelperStubImpl;
        PrintHelperStubImpl printHelperStubImpl3 = new PrintHelperStubImpl(null);
        this.mImpl = printHelperStubImpl2;
    }

    public static boolean systemSupportsPrint() {
        return VERSION.SDK_INT >= 19;
    }

    public int getColorMode() {
        return this.mImpl.getColorMode();
    }

    public int getOrientation() {
        return this.mImpl.getOrientation();
    }

    public int getScaleMode() {
        return this.mImpl.getScaleMode();
    }

    public void printBitmap(String str, Bitmap bitmap) {
        String str2 = str;
        Bitmap bitmap2 = bitmap;
        this.mImpl.printBitmap(str2, bitmap2, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        String str2 = str;
        Bitmap bitmap2 = bitmap;
        OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
        this.mImpl.printBitmap(str2, bitmap2, onPrintFinishCallback2);
    }

    public void printBitmap(String str, Uri uri) throws FileNotFoundException {
        String str2 = str;
        Uri uri2 = uri;
        this.mImpl.printBitmap(str2, uri2, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        String str2 = str;
        Uri uri2 = uri;
        OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
        this.mImpl.printBitmap(str2, uri2, onPrintFinishCallback2);
    }

    public void setColorMode(int i) {
        int i2 = i;
        this.mImpl.setColorMode(i2);
    }

    public void setOrientation(int i) {
        int i2 = i;
        this.mImpl.setOrientation(i2);
    }

    public void setScaleMode(int i) {
        int i2 = i;
        this.mImpl.setScaleMode(i2);
    }
}
