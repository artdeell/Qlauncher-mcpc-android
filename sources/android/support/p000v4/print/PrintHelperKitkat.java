package android.support.p000v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument.Page;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo;
import android.print.PrintJob;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: android.support.v4.print.PrintHelperKitkat */
class PrintHelperKitkat {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    private static final String LOG_TAG = "PrintHelperKitkat";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode;
    final Context mContext;
    Options mDecodeOptions = null;
    /* access modifiers changed from: private */
    public final Object mLock;
    int mOrientation;
    int mScaleMode;

    /* renamed from: android.support.v4.print.PrintHelperKitkat$OnPrintFinishCallback */
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    PrintHelperKitkat(Context context) {
        Object obj;
        Context context2 = context;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.mLock = obj2;
        this.mScaleMode = 2;
        this.mColorMode = 2;
        this.mOrientation = 1;
        this.mContext = context2;
    }

    /* access modifiers changed from: private */
    public Bitmap convertBitmapForColorMode(Bitmap bitmap, int i) {
        Canvas canvas;
        Paint paint;
        ColorMatrix colorMatrix;
        ColorMatrixColorFilter colorMatrixColorFilter;
        Bitmap bitmap2 = bitmap;
        if (i != 1) {
            return bitmap2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Config.ARGB_8888);
        Canvas canvas2 = canvas;
        Canvas canvas3 = new Canvas(createBitmap);
        Canvas canvas4 = canvas2;
        Paint paint2 = paint;
        Paint paint3 = new Paint();
        Paint paint4 = paint2;
        ColorMatrix colorMatrix2 = colorMatrix;
        ColorMatrix colorMatrix3 = new ColorMatrix();
        ColorMatrix colorMatrix4 = colorMatrix2;
        colorMatrix4.setSaturation(0.0f);
        Paint paint5 = paint4;
        ColorMatrixColorFilter colorMatrixColorFilter2 = colorMatrixColorFilter;
        ColorMatrixColorFilter colorMatrixColorFilter3 = new ColorMatrixColorFilter(colorMatrix4);
        ColorFilter colorFilter = paint5.setColorFilter(colorMatrixColorFilter2);
        canvas4.drawBitmap(bitmap2, 0.0f, 0.0f, paint4);
        canvas4.setBitmap(null);
        return createBitmap;
    }

    /* access modifiers changed from: private */
    public Matrix getMatrix(int i, int i2, RectF rectF, int i3) {
        Matrix matrix;
        int i4 = i;
        int i5 = i2;
        RectF rectF2 = rectF;
        int i6 = i3;
        Matrix matrix2 = matrix;
        Matrix matrix3 = new Matrix();
        Matrix matrix4 = matrix2;
        float width = rectF2.width() / ((float) i4);
        float min = i6 == 2 ? Math.max(width, rectF2.height() / ((float) i5)) : Math.min(width, rectF2.height() / ((float) i5));
        boolean postScale = matrix4.postScale(min, min);
        boolean postTranslate = matrix4.postTranslate((rectF2.width() - (min * ((float) i4))) / 2.0f, (rectF2.height() - (min * ((float) i5))) / 2.0f);
        return matrix4;
    }

    /* JADX INFO: finally extract failed */
    private Bitmap loadBitmap(Uri uri, Options options) throws FileNotFoundException {
        IllegalArgumentException illegalArgumentException;
        Uri uri2 = uri;
        Options options2 = options;
        if (uri2 == null || this.mContext == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bad argument to loadBitmap");
            throw illegalArgumentException2;
        }
        InputStream inputStream = null;
        try {
            inputStream = this.mContext.getContentResolver().openInputStream(uri2);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options2);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    int w = Log.w(LOG_TAG, "close fail ", e);
                    return decodeStream;
                }
            }
            return decodeStream;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    int w2 = Log.w(LOG_TAG, "close fail ", e2);
                }
            }
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public Bitmap loadConstrainedBitmap(Uri uri, int i) throws FileNotFoundException {
        IllegalArgumentException illegalArgumentException;
        Options options;
        int i2;
        Options options2;
        Object obj;
        th = uri;
        int i3 = i;
        if (i3 > 0 && th != null) {
            if (this.mContext != null) {
                Options options3 = options;
                Options options4 = new Options();
                Options options5 = options3;
                options5.inJustDecodeBounds = true;
                Bitmap loadBitmap = loadBitmap(th, options5);
                int i4 = options5.outWidth;
                int i5 = options5.outHeight;
                if (i4 > 0 && i5 > 0) {
                    int max = Math.max(i4, i5);
                    int i6 = 1;
                    while (true) {
                        i2 = i6;
                        if (max <= i3) {
                            break;
                        }
                        max >>>= 1;
                        i6 = i2 << 1;
                    }
                    if (i2 > 0 && Math.min(i4, i5) / i2 > 0) {
                        Options options6 = this.mLock;
                        synchronized (options6) {
                            try {
                                Options options7 = options2;
                                Options options8 = new Options();
                                this.mDecodeOptions = options7;
                                this.mDecodeOptions.inMutable = true;
                                this.mDecodeOptions.inSampleSize = i2;
                                options6 = this.mDecodeOptions;
                            } finally {
                                while (true) {
                                    Throwable th = th;
                                    Options options9 = options6;
                                    Throwable th2 = th;
                                }
                            }
                        }
                        try {
                            Bitmap loadBitmap2 = loadBitmap(th, options6);
                            th = this.mLock;
                            synchronized (obj) {
                                try {
                                    this.mDecodeOptions = null;
                                } catch (Throwable th3) {
                                    Throwable th4 = th3;
                                    Object obj2 = obj;
                                    throw th4;
                                }
                            }
                            return loadBitmap2;
                        } catch (Throwable th5) {
                            Throwable th6 = th5;
                            th = this.mLock;
                            synchronized (obj) {
                                this.mDecodeOptions = null;
                                Object obj3 = obj;
                                throw th6;
                            }
                        } finally {
                            while (true) {
                                obj = th;
                                Object obj4 = obj;
                                Throwable th7 = obj;
                            }
                        }
                    }
                }
                return null;
            }
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bad argument to getScaledBitmap");
        throw illegalArgumentException2;
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
        Builder builder;
        C00901 r17;
        String str2 = str;
        Bitmap bitmap2 = bitmap;
        OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
        if (bitmap2 != null) {
            int i = this.mScaleMode;
            PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
            MediaSize mediaSize = MediaSize.UNKNOWN_PORTRAIT;
            if (bitmap2.getWidth() > bitmap2.getHeight()) {
                mediaSize = MediaSize.UNKNOWN_LANDSCAPE;
            }
            Builder builder2 = builder;
            Builder builder3 = new Builder();
            PrintAttributes build = builder2.setMediaSize(mediaSize).setColorMode(this.mColorMode).build();
            PrintManager printManager2 = printManager;
            String str3 = str2;
            C00901 r10 = r17;
            final String str4 = str2;
            final Bitmap bitmap3 = bitmap2;
            final int i2 = i;
            final OnPrintFinishCallback onPrintFinishCallback3 = onPrintFinishCallback2;
            C00901 r11 = new PrintDocumentAdapter(this) {
                private PrintAttributes mAttributes;
                final /* synthetic */ PrintHelperKitkat this$0;

                {
                    String str = r10;
                    Bitmap bitmap = r11;
                    int i = r12;
                    OnPrintFinishCallback onPrintFinishCallback = r13;
                    this.this$0 = r9;
                }

                public void onFinish() {
                    if (onPrintFinishCallback3 != null) {
                        onPrintFinishCallback3.onFinish();
                    }
                }

                public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, LayoutResultCallback layoutResultCallback, Bundle bundle) {
                    PrintDocumentInfo.Builder builder;
                    PrintAttributes printAttributes3 = printAttributes;
                    PrintAttributes printAttributes4 = printAttributes2;
                    CancellationSignal cancellationSignal2 = cancellationSignal;
                    LayoutResultCallback layoutResultCallback2 = layoutResultCallback;
                    Bundle bundle2 = bundle;
                    boolean z = true;
                    this.mAttributes = printAttributes4;
                    PrintDocumentInfo.Builder builder2 = builder;
                    PrintDocumentInfo.Builder builder3 = new PrintDocumentInfo.Builder(str4);
                    PrintDocumentInfo build = builder2.setContentType(1).setPageCount(1).build();
                    if (printAttributes4.equals(printAttributes3)) {
                        z = false;
                    }
                    layoutResultCallback2.onLayoutFinished(build, z);
                }

                public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, WriteResultCallback writeResultCallback) {
                    PrintedPdfDocument printedPdfDocument;
                    RectF rectF;
                    FileOutputStream fileOutputStream;
                    PageRange[] pageRangeArr2 = pageRangeArr;
                    ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
                    CancellationSignal cancellationSignal2 = cancellationSignal;
                    WriteResultCallback writeResultCallback2 = writeResultCallback;
                    PrintedPdfDocument printedPdfDocument2 = printedPdfDocument;
                    PrintedPdfDocument printedPdfDocument3 = new PrintedPdfDocument(this.this$0.mContext, this.mAttributes);
                    PrintedPdfDocument printedPdfDocument4 = printedPdfDocument2;
                    Bitmap access$000 = this.this$0.convertBitmapForColorMode(bitmap3, this.mAttributes.getColorMode());
                    try {
                        Page startPage = printedPdfDocument4.startPage(1);
                        RectF rectF2 = rectF;
                        RectF rectF3 = new RectF(startPage.getInfo().getContentRect());
                        startPage.getCanvas().drawBitmap(access$000, this.this$0.getMatrix(access$000.getWidth(), access$000.getHeight(), rectF2, i2), null);
                        printedPdfDocument4.finishPage(startPage);
                        PrintedPdfDocument printedPdfDocument5 = printedPdfDocument4;
                        FileOutputStream fileOutputStream2 = fileOutputStream;
                        FileOutputStream fileOutputStream3 = new FileOutputStream(parcelFileDescriptor2.getFileDescriptor());
                        printedPdfDocument5.writeTo(fileOutputStream2);
                        writeResultCallback2.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                    } catch (IOException e) {
                        int e2 = Log.e(PrintHelperKitkat.LOG_TAG, "Error writing printed content", e);
                        writeResultCallback2.onWriteFailed(null);
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        if (printedPdfDocument4 != null) {
                            printedPdfDocument4.close();
                        }
                        if (parcelFileDescriptor2 != null) {
                            try {
                                parcelFileDescriptor2.close();
                            } catch (IOException e3) {
                                IOException iOException = e3;
                            }
                        }
                        if (access$000 != bitmap3) {
                            access$000.recycle();
                        }
                        throw th2;
                    }
                    if (printedPdfDocument4 != null) {
                        printedPdfDocument4.close();
                    }
                    if (parcelFileDescriptor2 != null) {
                        try {
                            parcelFileDescriptor2.close();
                        } catch (IOException e4) {
                            IOException iOException2 = e4;
                        }
                    }
                    if (access$000 != bitmap3) {
                        access$000.recycle();
                    }
                }
            };
            PrintJob print = printManager2.print(str3, r10, build);
        }
    }

    public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        C00912 r14;
        Builder builder;
        String str2 = str;
        C00912 r7 = r14;
        final String str3 = str2;
        final Uri uri2 = uri;
        final OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
        final int i = this.mScaleMode;
        C00912 r8 = new PrintDocumentAdapter(this) {
            private PrintAttributes mAttributes;
            Bitmap mBitmap = null;
            AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
            final /* synthetic */ PrintHelperKitkat this$0;

            {
                String str = r10;
                Uri uri = r11;
                OnPrintFinishCallback onPrintFinishCallback = r12;
                int i = r13;
                this.this$0 = r9;
            }

            /* access modifiers changed from: private */
            public void cancelLoad() {
                Object access$400 = this.this$0.mLock;
                synchronized (access$400) {
                    try {
                        if (this.this$0.mDecodeOptions != null) {
                            this.this$0.mDecodeOptions.requestCancelDecode();
                            this.this$0.mDecodeOptions = null;
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj = access$400;
                        throw th2;
                    }
                }
            }

            public void onFinish() {
                super.onFinish();
                cancelLoad();
                if (this.mLoadBitmap != null) {
                    boolean cancel = this.mLoadBitmap.cancel(true);
                }
                if (onPrintFinishCallback2 != null) {
                    onPrintFinishCallback2.onFinish();
                }
                if (this.mBitmap != null) {
                    this.mBitmap.recycle();
                    this.mBitmap = null;
                }
            }

            public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, LayoutResultCallback layoutResultCallback, Bundle bundle) {
                C00921 r16;
                PrintDocumentInfo.Builder builder;
                PrintAttributes printAttributes3 = printAttributes;
                PrintAttributes printAttributes4 = printAttributes2;
                CancellationSignal cancellationSignal2 = cancellationSignal;
                LayoutResultCallback layoutResultCallback2 = layoutResultCallback;
                Bundle bundle2 = bundle;
                boolean z = true;
                this.mAttributes = printAttributes4;
                if (cancellationSignal2.isCanceled()) {
                    layoutResultCallback2.onLayoutCancelled();
                } else if (this.mBitmap != null) {
                    PrintDocumentInfo.Builder builder2 = builder;
                    PrintDocumentInfo.Builder builder3 = new PrintDocumentInfo.Builder(str3);
                    PrintDocumentInfo build = builder2.setContentType(1).setPageCount(1).build();
                    if (printAttributes4.equals(printAttributes3)) {
                        z = false;
                    }
                    layoutResultCallback2.onLayoutFinished(build, z);
                } else {
                    C00921 r9 = r16;
                    final CancellationSignal cancellationSignal3 = cancellationSignal2;
                    final PrintAttributes printAttributes5 = printAttributes4;
                    final PrintAttributes printAttributes6 = printAttributes3;
                    final LayoutResultCallback layoutResultCallback3 = layoutResultCallback2;
                    C00921 r10 = new AsyncTask<Uri, Boolean, Bitmap>(this) {
                        final /* synthetic */ C00912 this$1;

                        {
                            CancellationSignal cancellationSignal = r10;
                            PrintAttributes printAttributes = r11;
                            PrintAttributes printAttributes2 = r12;
                            LayoutResultCallback layoutResultCallback = r13;
                            this.this$1 = r9;
                        }

                        /* access modifiers changed from: protected */
                        public Bitmap doInBackground(Uri... uriArr) {
                            Uri[] uriArr2 = uriArr;
                            try {
                                return this.this$1.this$0.loadConstrainedBitmap(uri2, PrintHelperKitkat.MAX_PRINT_SIZE);
                            } catch (FileNotFoundException e) {
                                FileNotFoundException fileNotFoundException = e;
                                return null;
                            }
                        }

                        /* access modifiers changed from: protected */
                        public void onCancelled(Bitmap bitmap) {
                            Bitmap bitmap2 = bitmap;
                            layoutResultCallback3.onLayoutCancelled();
                            this.this$1.mLoadBitmap = null;
                        }

                        /* access modifiers changed from: protected */
                        public void onPostExecute(Bitmap bitmap) {
                            PrintDocumentInfo.Builder builder;
                            Bitmap bitmap2 = bitmap;
                            boolean z = true;
                            super.onPostExecute(bitmap2);
                            this.this$1.mBitmap = bitmap2;
                            if (bitmap2 != null) {
                                PrintDocumentInfo.Builder builder2 = builder;
                                PrintDocumentInfo.Builder builder3 = new PrintDocumentInfo.Builder(str3);
                                PrintDocumentInfo build = builder2.setContentType(1).setPageCount(1).build();
                                if (printAttributes5.equals(printAttributes6)) {
                                    z = false;
                                }
                                layoutResultCallback3.onLayoutFinished(build, z);
                            } else {
                                layoutResultCallback3.onLayoutFailed(null);
                            }
                            this.this$1.mLoadBitmap = null;
                        }

                        /* access modifiers changed from: protected */
                        public void onPreExecute() {
                            C00931 r5;
                            CancellationSignal cancellationSignal = cancellationSignal3;
                            C00931 r2 = r5;
                            C00931 r3 = new OnCancelListener(this) {
                                final /* synthetic */ C00921 this$2;

                                {
                                    this.this$2 = r5;
                                }

                                public void onCancel() {
                                    this.this$2.this$1.cancelLoad();
                                    boolean cancel = this.this$2.cancel(false);
                                }
                            };
                            cancellationSignal.setOnCancelListener(r2);
                        }
                    };
                    this.mLoadBitmap = r9.execute(new Uri[0]);
                }
            }

            public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, WriteResultCallback writeResultCallback) {
                PrintedPdfDocument printedPdfDocument;
                RectF rectF;
                FileOutputStream fileOutputStream;
                PageRange[] pageRangeArr2 = pageRangeArr;
                ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
                CancellationSignal cancellationSignal2 = cancellationSignal;
                WriteResultCallback writeResultCallback2 = writeResultCallback;
                PrintedPdfDocument printedPdfDocument2 = printedPdfDocument;
                PrintedPdfDocument printedPdfDocument3 = new PrintedPdfDocument(this.this$0.mContext, this.mAttributes);
                PrintedPdfDocument printedPdfDocument4 = printedPdfDocument2;
                Bitmap access$000 = this.this$0.convertBitmapForColorMode(this.mBitmap, this.mAttributes.getColorMode());
                try {
                    Page startPage = printedPdfDocument4.startPage(1);
                    RectF rectF2 = rectF;
                    RectF rectF3 = new RectF(startPage.getInfo().getContentRect());
                    startPage.getCanvas().drawBitmap(access$000, this.this$0.getMatrix(this.mBitmap.getWidth(), this.mBitmap.getHeight(), rectF2, i), null);
                    printedPdfDocument4.finishPage(startPage);
                    PrintedPdfDocument printedPdfDocument5 = printedPdfDocument4;
                    FileOutputStream fileOutputStream2 = fileOutputStream;
                    FileOutputStream fileOutputStream3 = new FileOutputStream(parcelFileDescriptor2.getFileDescriptor());
                    printedPdfDocument5.writeTo(fileOutputStream2);
                    writeResultCallback2.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } catch (IOException e) {
                    int e2 = Log.e(PrintHelperKitkat.LOG_TAG, "Error writing printed content", e);
                    writeResultCallback2.onWriteFailed(null);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (printedPdfDocument4 != null) {
                        printedPdfDocument4.close();
                    }
                    if (parcelFileDescriptor2 != null) {
                        try {
                            parcelFileDescriptor2.close();
                        } catch (IOException e3) {
                            IOException iOException = e3;
                        }
                    }
                    if (access$000 != this.mBitmap) {
                        access$000.recycle();
                    }
                    throw th2;
                }
                if (printedPdfDocument4 != null) {
                    printedPdfDocument4.close();
                }
                if (parcelFileDescriptor2 != null) {
                    try {
                        parcelFileDescriptor2.close();
                    } catch (IOException e4) {
                        IOException iOException2 = e4;
                    }
                }
                if (access$000 != this.mBitmap) {
                    access$000.recycle();
                }
            }
        };
        C00912 r4 = r7;
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        Builder builder2 = builder;
        Builder builder3 = new Builder();
        Builder builder4 = builder2;
        Builder colorMode = builder4.setColorMode(this.mColorMode);
        if (this.mOrientation == 1) {
            Builder mediaSize = builder4.setMediaSize(MediaSize.UNKNOWN_LANDSCAPE);
        } else if (this.mOrientation == 2) {
            Builder mediaSize2 = builder4.setMediaSize(MediaSize.UNKNOWN_PORTRAIT);
        }
        PrintJob print = printManager.print(str2, r4, builder4.build());
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
