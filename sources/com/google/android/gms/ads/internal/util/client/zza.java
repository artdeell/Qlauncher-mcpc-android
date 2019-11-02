package com.google.android.gms.ads.internal.util.client;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.support.annotation.Nullable;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzne;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.StringTokenizer;
import org.lwjgl.LWJGLUtil;

@zzhb
public class zza {
    public static final Handler zzMS;
    private static final String zzMT = AdView.class.getName();
    private static final String zzMU = InterstitialAd.class.getName();
    private static final String zzMV = PublisherAdView.class.getName();
    private static final String zzMW = PublisherInterstitialAd.class.getName();
    private static final String zzMX = SearchAdView.class.getName();
    private static final String zzMY = AdLoader.class.getName();

    static {
        Handler handler;
        Handler handler2 = handler;
        Handler handler3 = new Handler(Looper.getMainLooper());
        zzMS = handler2;
    }

    public zza() {
    }

    private void zza(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str, int i, int i2) {
        TextView textView;
        FrameLayout frameLayout;
        LayoutParams layoutParams;
        ViewGroup viewGroup2 = viewGroup;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        String str2 = str;
        int i3 = i;
        int i4 = i2;
        if (viewGroup2.getChildCount() == 0) {
            Context context = viewGroup2.getContext();
            TextView textView2 = textView;
            TextView textView3 = new TextView(context);
            TextView textView4 = textView2;
            textView4.setGravity(17);
            textView4.setText(str2);
            textView4.setTextColor(i3);
            textView4.setBackgroundColor(i4);
            FrameLayout frameLayout2 = frameLayout;
            FrameLayout frameLayout3 = new FrameLayout(context);
            FrameLayout frameLayout4 = frameLayout2;
            frameLayout4.setBackgroundColor(i3);
            int zzb = zzb(context, 3);
            FrameLayout frameLayout5 = frameLayout4;
            TextView textView5 = textView4;
            LayoutParams layoutParams2 = layoutParams;
            LayoutParams layoutParams3 = new LayoutParams(adSizeParcel2.widthPixels - zzb, adSizeParcel2.heightPixels - zzb, 17);
            frameLayout5.addView(textView5, layoutParams2);
            viewGroup2.addView(frameLayout4, adSizeParcel2.widthPixels, adSizeParcel2.heightPixels);
        }
    }

    public String zzT(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
        if (string == null || zzhI()) {
            string = "emulator";
        }
        return zzaH(string);
    }

    public boolean zzU(Context context) {
        return zze.isGooglePlayServicesAvailable(context) == 0;
    }

    public boolean zzV(Context context) {
        Context context2 = context;
        if (context2.getResources().getConfiguration().orientation == 2) {
            DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
            if (((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600) {
                return true;
            }
        }
        return false;
    }

    public boolean zzW(Context context) {
        int intValue;
        int intValue2;
        Context context2 = context;
        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context2.getSystemService("window")).getDefaultDisplay();
        if (zzne.zzsi()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            intValue = displayMetrics.heightPixels;
            intValue2 = displayMetrics.widthPixels;
        } else {
            try {
                intValue = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                intValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e) {
                Exception exc = e;
                return false;
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.heightPixels == intValue && displayMetrics.widthPixels == intValue2;
    }

    public int zzX(Context context) {
        Context context2 = context;
        int identifier = context2.getResources().getIdentifier("navigation_bar_width", "dimen", LWJGLUtil.PLATFORM_ANDROID_NAME);
        if (identifier > 0) {
            return context2.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public int zza(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    @Nullable
    public String zza(StackTraceElement[] stackTraceElementArr, String str) {
        String str2;
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        String str3 = str;
        int i = 0;
        while (true) {
            if (i + 1 >= stackTraceElementArr2.length) {
                str2 = null;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr2[i];
            String className = stackTraceElement.getClassName();
            if (!"loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) || (!zzMT.equalsIgnoreCase(className) && !zzMU.equalsIgnoreCase(className) && !zzMV.equalsIgnoreCase(className) && !zzMW.equalsIgnoreCase(className) && !zzMX.equalsIgnoreCase(className) && !zzMY.equalsIgnoreCase(className))) {
                i++;
            }
        }
        str2 = stackTraceElementArr2[i + 1].getClassName();
        if (str3 != null) {
            String zzb = zzb(str3, ".", 3);
            if (str2 != null && !str2.contains(zzb)) {
                return str2;
            }
        }
        return null;
    }

    public void zza(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str) {
        zza(viewGroup, adSizeParcel, str, ViewCompat.MEASURED_STATE_MASK, -1);
    }

    public void zza(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str, String str2) {
        ViewGroup viewGroup2 = viewGroup;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        String str3 = str;
        zzb.zzaK(str2);
        zza(viewGroup2, adSizeParcel2, str3, SupportMenu.CATEGORY_MASK, ViewCompat.MEASURED_STATE_MASK);
    }

    public String zzaH(String str) {
        BigInteger bigInteger;
        String str2 = str;
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str2.getBytes());
                Locale locale = Locale.US;
                Object[] objArr = new Object[1];
                Object[] objArr2 = objArr;
                BigInteger bigInteger2 = bigInteger;
                BigInteger bigInteger3 = new BigInteger(1, instance.digest());
                objArr2[0] = bigInteger2;
                return String.format(locale, "%032X", objArr);
            } catch (NoSuchAlgorithmException e) {
                NoSuchAlgorithmException noSuchAlgorithmException = e;
                i++;
            }
        }
        return null;
    }

    public int zzb(Context context, int i) {
        return zza(context.getResources().getDisplayMetrics(), i);
    }

    public int zzb(DisplayMetrics displayMetrics, int i) {
        return Math.round(((float) i) / displayMetrics.density);
    }

    /* access modifiers changed from: 0000 */
    public String zzb(String str, String str2, int i) {
        StringTokenizer stringTokenizer;
        StringBuilder sb;
        String str3 = str;
        int i2 = i;
        StringTokenizer stringTokenizer2 = stringTokenizer;
        StringTokenizer stringTokenizer3 = new StringTokenizer(str3, str2);
        StringTokenizer stringTokenizer4 = stringTokenizer2;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        int i3 = i2 - 1;
        if (i2 > 0 && stringTokenizer4.hasMoreElements()) {
            StringBuilder append = sb4.append(stringTokenizer4.nextToken());
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0 || !stringTokenizer4.hasMoreElements()) {
                    str3 = sb4.toString();
                } else {
                    StringBuilder append2 = sb4.append(".").append(stringTokenizer4.nextToken());
                    i3 = i4;
                }
            }
            str3 = sb4.toString();
        }
        return str3;
    }

    public int zzc(Context context, int i) {
        DisplayMetrics displayMetrics;
        int i2 = i;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics2 = displayMetrics;
        DisplayMetrics displayMetrics3 = new DisplayMetrics();
        DisplayMetrics displayMetrics4 = displayMetrics2;
        defaultDisplay.getMetrics(displayMetrics4);
        return zzb(displayMetrics4, i2);
    }

    public boolean zzhI() {
        return Build.DEVICE.startsWith("generic");
    }

    public boolean zzhJ() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
