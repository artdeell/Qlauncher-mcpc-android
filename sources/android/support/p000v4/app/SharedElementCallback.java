package android.support.p000v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.app.SharedElementCallback */
public abstract class SharedElementCallback {
    private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
    private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
    private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
    private static int MAX_IMAGE_SIZE = 1048576;
    private Matrix mTempMatrix;

    public SharedElementCallback() {
    }

    private static Bitmap createDrawableBitmap(Drawable drawable) {
        Canvas canvas;
        Drawable drawable2 = drawable;
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        int intrinsicHeight = drawable2.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        float min = Math.min(1.0f, ((float) MAX_IMAGE_SIZE) / ((float) (intrinsicWidth * intrinsicHeight)));
        if ((drawable2 instanceof BitmapDrawable) && min == 1.0f) {
            return ((BitmapDrawable) drawable2).getBitmap();
        }
        int i = (int) (min * ((float) intrinsicWidth));
        int i2 = (int) (min * ((float) intrinsicHeight));
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas2 = canvas;
        Canvas canvas3 = new Canvas(createBitmap);
        Canvas canvas4 = canvas2;
        Rect bounds = drawable2.getBounds();
        int i3 = bounds.left;
        int i4 = bounds.top;
        int i5 = bounds.right;
        int i6 = bounds.bottom;
        drawable2.setBounds(0, 0, i, i2);
        drawable2.draw(canvas4);
        drawable2.setBounds(i3, i4, i5, i6);
        return createBitmap;
    }

    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        Canvas canvas;
        Matrix matrix2;
        Bundle bundle;
        View view2 = view;
        Matrix matrix3 = matrix;
        RectF rectF2 = rectF;
        if (view2 instanceof ImageView) {
            ImageView imageView = (ImageView) view2;
            Drawable drawable = imageView.getDrawable();
            Drawable background = imageView.getBackground();
            if (drawable != null && background == null) {
                Bitmap createDrawableBitmap = createDrawableBitmap(drawable);
                if (createDrawableBitmap != null) {
                    Bundle bundle2 = bundle;
                    Bundle bundle3 = new Bundle();
                    Bundle bundle4 = bundle2;
                    bundle4.putParcelable(BUNDLE_SNAPSHOT_BITMAP, createDrawableBitmap);
                    bundle4.putString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE, imageView.getScaleType().toString());
                    if (imageView.getScaleType() == ScaleType.MATRIX) {
                        float[] fArr = new float[9];
                        imageView.getImageMatrix().getValues(fArr);
                        bundle4.putFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX, fArr);
                    }
                    return bundle4;
                }
            }
        }
        int round = Math.round(rectF2.width());
        int round2 = Math.round(rectF2.height());
        Bitmap bitmap = null;
        if (round > 0) {
            bitmap = null;
            if (round2 > 0) {
                float min = Math.min(1.0f, ((float) MAX_IMAGE_SIZE) / ((float) (round * round2)));
                int i = (int) (min * ((float) round));
                int i2 = (int) (min * ((float) round2));
                if (this.mTempMatrix == null) {
                    Matrix matrix4 = matrix2;
                    Matrix matrix5 = new Matrix();
                    this.mTempMatrix = matrix4;
                }
                this.mTempMatrix.set(matrix3);
                boolean postTranslate = this.mTempMatrix.postTranslate(-rectF2.left, -rectF2.top);
                boolean postScale = this.mTempMatrix.postScale(min, min);
                bitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                Canvas canvas2 = canvas;
                Canvas canvas3 = new Canvas(bitmap);
                Canvas canvas4 = canvas2;
                canvas4.concat(this.mTempMatrix);
                view2.draw(canvas4);
            }
        }
        return bitmap;
    }

    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        Matrix matrix;
        Context context2 = context;
        Parcelable parcelable2 = parcelable;
        if (parcelable2 instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable2;
            Bitmap bitmap = (Bitmap) bundle.getParcelable(BUNDLE_SNAPSHOT_BITMAP);
            if (bitmap == null) {
                return null;
            }
            ImageView imageView4 = imageView3;
            ImageView imageView5 = new ImageView(context2);
            ImageView imageView6 = imageView4;
            imageView = imageView6;
            imageView6.setImageBitmap(bitmap);
            imageView6.setScaleType(ScaleType.valueOf(bundle.getString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE)));
            if (imageView6.getScaleType() == ScaleType.MATRIX) {
                float[] floatArray = bundle.getFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX);
                Matrix matrix2 = matrix;
                Matrix matrix3 = new Matrix();
                Matrix matrix4 = matrix2;
                matrix4.setValues(floatArray);
                imageView6.setImageMatrix(matrix4);
            }
        } else {
            imageView = null;
            if (parcelable2 instanceof Bitmap) {
                Bitmap bitmap2 = (Bitmap) parcelable2;
                ImageView imageView7 = imageView2;
                ImageView imageView8 = new ImageView(context2);
                imageView = imageView7;
                imageView.setImageBitmap(bitmap2);
            }
        }
        return imageView;
    }

    public void onMapSharedElements(List<String> list, Map<String, View> map) {
    }

    public void onRejectSharedElements(List<View> list) {
    }

    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
    }

    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
    }
}
