package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@TargetApi(8)
@zzhb
public class zzis {

    @TargetApi(9)
    public static class zza extends zzis {
        public zza() {
            super(null);
        }

        public boolean zza(Request request) {
            Request showRunningNotification = request.setShowRunningNotification(true);
            return true;
        }

        public int zzhv() {
            return 6;
        }

        public int zzhw() {
            return 7;
        }
    }

    @TargetApi(11)
    public static class zzb extends zza {
        public zzb() {
        }

        public boolean zza(Request request) {
            Request request2 = request;
            request2.allowScanningByMediaScanner();
            Request notificationVisibility = request2.setNotificationVisibility(1);
            return true;
        }

        public boolean zza(Context context, WebSettings webSettings) {
            C04181 r7;
            Context context2 = context;
            WebSettings webSettings2 = webSettings;
            boolean zza = super.zza(context2, webSettings2);
            C04181 r3 = r7;
            final Context context3 = context2;
            C04181 r4 = new Callable<File>(this) {
                final /* synthetic */ zzb zzMg;

                {
                    Context context = r7;
                    this.zzMg = r6;
                }

                /* renamed from: zzhz */
                public File call() {
                    return context3.getCacheDir();
                }
            };
            if (((File) zzjb.zzb(r3)) != null) {
                webSettings2.setAppCachePath(context2.getCacheDir().getAbsolutePath());
                webSettings2.setAppCacheMaxSize(0);
                webSettings2.setAppCacheEnabled(true);
            }
            webSettings2.setDatabasePath(context2.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
            webSettings2.setDatabaseEnabled(true);
            webSettings2.setDomStorageEnabled(true);
            webSettings2.setDisplayZoomControls(false);
            webSettings2.setBuiltInZoomControls(true);
            webSettings2.setSupportZoom(true);
            webSettings2.setAllowContentAccess(false);
            return true;
        }

        public boolean zza(Window window) {
            window.setFlags(16777216, 16777216);
            return true;
        }

        public zzjq zzb(zzjp zzjp, boolean z) {
            zzjw zzjw;
            zzjw zzjw2 = zzjw;
            zzjw zzjw3 = new zzjw(zzjp, z);
            return zzjw2;
        }

        public Set<String> zzf(Uri uri) {
            return uri.getQueryParameterNames();
        }

        public WebChromeClient zzk(zzjp zzjp) {
            zzjv zzjv;
            zzjv zzjv2 = zzjv;
            zzjv zzjv3 = new zzjv(zzjp);
            return zzjv2;
        }

        public boolean zzm(View view) {
            view.setLayerType(0, null);
            return true;
        }

        public boolean zzn(View view) {
            view.setLayerType(1, null);
            return true;
        }
    }

    @TargetApi(14)
    public static class zzc extends zzb {
        public zzc() {
        }

        public String zza(SslError sslError) {
            return sslError.getUrl();
        }

        public WebChromeClient zzk(zzjp zzjp) {
            zzjx zzjx;
            zzjx zzjx2 = zzjx;
            zzjx zzjx3 = new zzjx(zzjp);
            return zzjx2;
        }
    }

    @TargetApi(17)
    public static class zzd extends zzf {
        public zzd() {
        }

        public String getDefaultUserAgent(Context context) {
            return WebSettings.getDefaultUserAgent(context);
        }

        public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            Context context2 = context;
            Bitmap bitmap2 = bitmap;
            float f2 = f;
            if (!z || f2 <= 0.0f || f2 > 25.0f) {
                BitmapDrawable bitmapDrawable4 = bitmapDrawable;
                BitmapDrawable bitmapDrawable5 = new BitmapDrawable(context2.getResources(), bitmap2);
                return bitmapDrawable4;
            }
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, bitmap2.getWidth(), bitmap2.getHeight(), false);
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                RenderScript create = RenderScript.create(context2);
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(f2);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
                BitmapDrawable bitmapDrawable6 = bitmapDrawable3;
                BitmapDrawable bitmapDrawable7 = new BitmapDrawable(context2.getResources(), createBitmap);
                return bitmapDrawable6;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                BitmapDrawable bitmapDrawable8 = bitmapDrawable2;
                BitmapDrawable bitmapDrawable9 = new BitmapDrawable(context2.getResources(), bitmap2);
                return bitmapDrawable8;
            }
        }

        public boolean zza(Context context, WebSettings webSettings) {
            WebSettings webSettings2 = webSettings;
            boolean zza = super.zza(context, webSettings2);
            webSettings2.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }
    }

    @TargetApi(18)
    public static class zze extends zzd {
        public zze() {
        }

        public boolean isAttachedToWindow(View view) {
            View view2 = view;
            return super.isAttachedToWindow(view2) || view2.getWindowId() != null;
        }

        public int zzhx() {
            return 14;
        }
    }

    @TargetApi(16)
    public static class zzf extends zzc {
        public zzf() {
        }

        public void zza(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public void zza(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public boolean zza(Context context, WebSettings webSettings) {
            WebSettings webSettings2 = webSettings;
            boolean zza = super.zza(context, webSettings2);
            webSettings2.setAllowFileAccessFromFileURLs(false);
            webSettings2.setAllowUniversalAccessFromFileURLs(false);
            return true;
        }

        public void zzb(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
            OnGlobalLayoutListener onGlobalLayoutListener2 = onGlobalLayoutListener;
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
                zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener2);
            }
        }
    }

    @TargetApi(19)
    public static class zzg extends zze {
        public zzg() {
        }

        public boolean isAttachedToWindow(View view) {
            return view.isAttachedToWindow();
        }

        public LayoutParams zzhy() {
            LayoutParams layoutParams;
            LayoutParams layoutParams2 = layoutParams;
            LayoutParams layoutParams3 = new LayoutParams(-1, -1);
            return layoutParams2;
        }
    }

    private zzis() {
    }

    /* synthetic */ zzis(C04171 r4) {
        C04171 r1 = r4;
        this();
    }

    public static zzis zzP(int i) {
        zzis zzis;
        zza zza2;
        zzb zzb2;
        zzc zzc2;
        zzf zzf2;
        zzd zzd2;
        zze zze2;
        zzg zzg2;
        int i2 = i;
        if (i2 >= 19) {
            zzg zzg3 = zzg2;
            zzg zzg4 = new zzg();
            return zzg3;
        } else if (i2 >= 18) {
            zze zze3 = zze2;
            zze zze4 = new zze();
            return zze3;
        } else if (i2 >= 17) {
            zzd zzd3 = zzd2;
            zzd zzd4 = new zzd();
            return zzd3;
        } else if (i2 >= 16) {
            zzf zzf3 = zzf2;
            zzf zzf4 = new zzf();
            return zzf3;
        } else if (i2 >= 14) {
            zzc zzc3 = zzc2;
            zzc zzc4 = new zzc();
            return zzc3;
        } else if (i2 >= 11) {
            zzb zzb3 = zzb2;
            zzb zzb4 = new zzb();
            return zzb3;
        } else if (i2 >= 9) {
            zza zza3 = zza2;
            zza zza4 = new zza();
            return zza3;
        } else {
            zzis zzis2 = zzis;
            zzis zzis3 = new zzis();
            return zzis2;
        }
    }

    public String getDefaultUserAgent(Context context) {
        Context context2 = context;
        return LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public boolean isAttachedToWindow(View view) {
        View view2 = view;
        return (view2.getWindowToken() == null && view2.getWindowVisibility() == 8) ? false : true;
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        BitmapDrawable bitmapDrawable;
        boolean z2 = z;
        float f2 = f;
        BitmapDrawable bitmapDrawable2 = bitmapDrawable;
        BitmapDrawable bitmapDrawable3 = new BitmapDrawable(context.getResources(), bitmap);
        return bitmapDrawable2;
    }

    public String zza(SslError sslError) {
        SslError sslError2 = sslError;
        return LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public void zza(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public void zza(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean zza(Request request) {
        Request request2 = request;
        return false;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        Context context2 = context;
        WebSettings webSettings2 = webSettings;
        return false;
    }

    public boolean zza(Window window) {
        Window window2 = window;
        return false;
    }

    public zzjq zzb(zzjp zzjp, boolean z) {
        zzjq zzjq;
        zzjq zzjq2 = zzjq;
        zzjq zzjq3 = new zzjq(zzjp, z);
        return zzjq2;
    }

    public void zzb(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        OnGlobalLayoutListener onGlobalLayoutListener2 = onGlobalLayoutListener;
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener2);
        }
    }

    public Set<String> zzf(Uri uri) {
        LinkedHashSet linkedHashSet;
        Uri uri2 = uri;
        if (uri2.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri2.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        LinkedHashSet linkedHashSet4 = linkedHashSet2;
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            boolean add = linkedHashSet4.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet4);
    }

    public int zzhv() {
        return 0;
    }

    public int zzhw() {
        return 1;
    }

    public int zzhx() {
        return 5;
    }

    public LayoutParams zzhy() {
        LayoutParams layoutParams;
        LayoutParams layoutParams2 = layoutParams;
        LayoutParams layoutParams3 = new LayoutParams(-2, -2);
        return layoutParams2;
    }

    public boolean zzi(zzjp zzjp) {
        zzjp zzjp2 = zzjp;
        if (zzjp2 == null) {
            return false;
        }
        zzjp2.onPause();
        return true;
    }

    public boolean zzj(zzjp zzjp) {
        zzjp zzjp2 = zzjp;
        if (zzjp2 == null) {
            return false;
        }
        zzjp2.onResume();
        return true;
    }

    public WebChromeClient zzk(zzjp zzjp) {
        zzjp zzjp2 = zzjp;
        return null;
    }

    public boolean zzm(View view) {
        View view2 = view;
        return false;
    }

    public boolean zzn(View view) {
        View view2 = view;
        return false;
    }
}
