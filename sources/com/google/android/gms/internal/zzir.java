package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zze;
import com.ipaulpro.afilechooser.utils.MimeTypeParser;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzir {
    public static final Handler zzMc;
    private boolean zzMd = true;
    private boolean zzMe = false;
    /* access modifiers changed from: private */
    public final Object zzpV;
    private String zzzN;

    private final class zza extends BroadcastReceiver {
        final /* synthetic */ zzir zzMf;

        private zza(zzir zzir) {
            this.zzMf = zzir;
        }

        /* synthetic */ zza(zzir zzir, C04161 r7) {
            C04161 r2 = r7;
            this(zzir);
        }

        public void onReceive(Context context, Intent intent) {
            Context context2 = context;
            Intent intent2 = intent;
            if ("android.intent.action.USER_PRESENT".equals(intent2.getAction())) {
                boolean zza = zzir.zza(this.zzMf, true);
            } else if ("android.intent.action.SCREEN_OFF".equals(intent2.getAction())) {
                boolean zza2 = zzir.zza(this.zzMf, false);
            }
        }
    }

    static {
        zzio zzio;
        zzio zzio2 = zzio;
        zzio zzio3 = new zzio(Looper.getMainLooper());
        zzMc = zzio2;
    }

    public zzir() {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
    }

    public static void runOnUiThread(Runnable runnable) {
        Runnable runnable2 = runnable;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable2.run();
        } else {
            boolean post = zzMc.post(runnable2);
        }
    }

    static /* synthetic */ String zza(zzir zzir, String str) {
        String str2 = str;
        zzir.zzzN = str2;
        return str2;
    }

    private JSONArray zza(Collection<?> collection) throws JSONException {
        JSONArray jSONArray;
        Collection<?> collection2 = collection;
        JSONArray jSONArray2 = jSONArray;
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = jSONArray2;
        for (Object zza2 : collection2) {
            zza(jSONArray4, zza2);
        }
        return jSONArray4;
    }

    private void zza(JSONArray jSONArray, Object obj) throws JSONException {
        JSONArray jSONArray2 = jSONArray;
        Object obj2 = obj;
        if (obj2 instanceof Bundle) {
            JSONArray put = jSONArray2.put(zzf((Bundle) obj2));
        } else if (obj2 instanceof Map) {
            JSONArray put2 = jSONArray2.put(zzG((Map) obj2));
        } else if (obj2 instanceof Collection) {
            JSONArray put3 = jSONArray2.put(zza((Collection) obj2));
        } else if (obj2 instanceof Object[]) {
            JSONArray put4 = jSONArray2.put(zza((Object[]) obj2));
        } else {
            JSONArray put5 = jSONArray2.put(obj2);
        }
    }

    private void zza(JSONObject jSONObject, String str, Object obj) throws JSONException {
        JSONObject jSONObject2 = jSONObject;
        String str2 = str;
        Object obj2 = obj;
        if (obj2 instanceof Bundle) {
            JSONObject put = jSONObject2.put(str2, zzf((Bundle) obj2));
        } else if (obj2 instanceof Map) {
            JSONObject put2 = jSONObject2.put(str2, zzG((Map) obj2));
        } else if (obj2 instanceof Collection) {
            if (str2 == null) {
                str2 = "null";
            }
            JSONObject put3 = jSONObject2.put(str2, zza((Collection) obj2));
        } else if (obj2 instanceof Object[]) {
            JSONObject put4 = jSONObject2.put(str2, zza((Collection<?>) Arrays.asList((Object[]) obj2)));
        } else {
            JSONObject put5 = jSONObject2.put(str2, obj2);
        }
    }

    private boolean zza(KeyguardManager keyguardManager) {
        KeyguardManager keyguardManager2 = keyguardManager;
        if (keyguardManager2 == null) {
            return false;
        }
        return keyguardManager2.inKeyguardRestrictedInputMode();
    }

    private boolean zza(PowerManager powerManager) {
        PowerManager powerManager2 = powerManager;
        return powerManager2 == null || powerManager2.isScreenOn();
    }

    static /* synthetic */ boolean zza(zzir zzir, boolean z) {
        boolean z2 = z;
        zzir.zzMd = z2;
        return z2;
    }

    private JSONObject zzf(Bundle bundle) throws JSONException {
        JSONObject jSONObject;
        Bundle bundle2 = bundle;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = jSONObject2;
        for (String str : bundle2.keySet()) {
            zza(jSONObject4, str, bundle2.get(str));
        }
        return jSONObject4;
    }

    private boolean zzs(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }

    public JSONObject zzG(Map<String, ?> map) throws JSONException {
        JSONException jSONException;
        StringBuilder sb;
        JSONObject jSONObject;
        Map<String, ?> map2 = map;
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = jSONObject2;
            for (String str : map2.keySet()) {
                zza(jSONObject4, str, map2.get(str));
            }
            return jSONObject4;
        } catch (ClassCastException e) {
            ClassCastException classCastException = e;
            JSONException jSONException2 = jSONException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            JSONException jSONException3 = new JSONException(sb2.append("Could not convert map to JSON: ").append(classCastException.getMessage()).toString());
            throw jSONException2;
        }
    }

    public boolean zzI(Context context) {
        Intent intent;
        boolean z;
        Context context2 = context;
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        Intent intent4 = intent2;
        Intent className = intent4.setClassName(context2, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context2.getPackageManager().resolveActivity(intent4, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            zzin.zzaK("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        if ((16 & resolveActivity.activityInfo.configChanges) == 0) {
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = "keyboard";
            zzin.zzaK(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", objArr2));
            z = false;
        } else {
            z = true;
        }
        if ((32 & resolveActivity.activityInfo.configChanges) == 0) {
            Object[] objArr3 = new Object[1];
            Object[] objArr4 = objArr3;
            objArr3[0] = "keyboardHidden";
            zzin.zzaK(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", objArr4));
            z = false;
        }
        if ((128 & resolveActivity.activityInfo.configChanges) == 0) {
            Object[] objArr5 = new Object[1];
            Object[] objArr6 = objArr5;
            objArr5[0] = "orientation";
            zzin.zzaK(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", objArr6));
            z = false;
        }
        if ((256 & resolveActivity.activityInfo.configChanges) == 0) {
            Object[] objArr7 = new Object[1];
            Object[] objArr8 = objArr7;
            objArr7[0] = "screenLayout";
            zzin.zzaK(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", objArr8));
            z = false;
        }
        if ((512 & resolveActivity.activityInfo.configChanges) == 0) {
            Object[] objArr9 = new Object[1];
            Object[] objArr10 = objArr9;
            objArr9[0] = "uiMode";
            zzin.zzaK(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", objArr10));
            z = false;
        }
        if ((1024 & resolveActivity.activityInfo.configChanges) == 0) {
            Object[] objArr11 = new Object[1];
            Object[] objArr12 = objArr11;
            objArr11[0] = "screenSize";
            zzin.zzaK(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", objArr12));
            z = false;
        }
        if ((2048 & resolveActivity.activityInfo.configChanges) != 0) {
            return z;
        }
        Object[] objArr13 = new Object[1];
        Object[] objArr14 = objArr13;
        objArr13[0] = "smallestScreenSize";
        zzin.zzaK(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", objArr14));
        return false;
    }

    public boolean zzJ(Context context) {
        IntentFilter intentFilter;
        zza zza2;
        Context context2 = context;
        if (this.zzMe) {
            return false;
        }
        IntentFilter intentFilter2 = intentFilter;
        IntentFilter intentFilter3 = new IntentFilter();
        IntentFilter intentFilter4 = intentFilter2;
        intentFilter4.addAction("android.intent.action.USER_PRESENT");
        intentFilter4.addAction("android.intent.action.SCREEN_OFF");
        Context applicationContext = context2.getApplicationContext();
        zza zza3 = zza2;
        zza zza4 = new zza(this, null);
        Intent registerReceiver = applicationContext.registerReceiver(zza3, intentFilter4);
        this.zzMe = true;
        return true;
    }

    /* access modifiers changed from: protected */
    public String zzK(Context context) {
        WebView webView;
        WebView webView2 = webView;
        WebView webView3 = new WebView(context);
        return webView2.getSettings().getUserAgentString();
    }

    public Builder zzL(Context context) {
        Builder builder;
        Builder builder2 = builder;
        Builder builder3 = new Builder(context);
        return builder2;
    }

    public zzbl zzM(Context context) {
        zzbl zzbl;
        zzbl zzbl2 = zzbl;
        zzbl zzbl3 = new zzbl(context);
        return zzbl2;
    }

    public String zzN(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            List runningTasks = activityManager.getRunningTasks(1);
            if (runningTasks != null && !runningTasks.isEmpty()) {
                RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
                if (!(runningTaskInfo == null || runningTaskInfo.topActivity == null)) {
                    return runningTaskInfo.topActivity.getClassName();
                }
            }
            return null;
        } catch (Exception e) {
            Exception exc = e;
        }
    }

    public boolean zzO(Context context) {
        Context context2 = context;
        try {
            ActivityManager activityManager = (ActivityManager) context2.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context2.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            Iterator it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && zzs(context2)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            Throwable th2 = th;
            return false;
        }
    }

    public Bitmap zzP(Context context) {
        Canvas canvas;
        Context context2 = context;
        if (!(context2 instanceof Activity)) {
            return null;
        }
        try {
            View decorView = ((Activity) context2).getWindow().getDecorView();
            Bitmap createBitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Config.ARGB_8888);
            Canvas canvas2 = canvas;
            Canvas canvas3 = new Canvas(createBitmap);
            Canvas canvas4 = canvas2;
            decorView.layout(0, 0, decorView.getWidth(), decorView.getHeight());
            decorView.draw(canvas4);
            return createBitmap;
        } catch (RuntimeException e) {
            zzin.zzb("Fail to capture screen shot", e);
            return null;
        }
    }

    public float zzQ(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        return streamMaxVolume == 0 ? 0.0f : ((float) audioManager.getStreamVolume(3)) / ((float) streamMaxVolume);
    }

    public int zzR(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    public DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics;
        WindowManager windowManager2 = windowManager;
        DisplayMetrics displayMetrics2 = displayMetrics;
        DisplayMetrics displayMetrics3 = new DisplayMetrics();
        DisplayMetrics displayMetrics4 = displayMetrics2;
        windowManager2.getDefaultDisplay().getMetrics(displayMetrics4);
        return displayMetrics4;
    }

    public PopupWindow zza(View view, int i, int i2, boolean z) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2 = popupWindow;
        PopupWindow popupWindow3 = new PopupWindow(view, i, i2, z);
        return popupWindow2;
    }

    public String zza(Context context, View view, AdSizeParcel adSizeParcel) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONArray jSONArray;
        JSONObject jSONObject3;
        Context context2 = context;
        View view2 = view;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        if (!((Boolean) zzbt.zzwz.get()).booleanValue()) {
            return null;
        }
        try {
            JSONObject jSONObject4 = jSONObject;
            JSONObject jSONObject5 = new JSONObject();
            JSONObject jSONObject6 = jSONObject4;
            JSONObject jSONObject7 = jSONObject2;
            JSONObject jSONObject8 = new JSONObject();
            JSONObject jSONObject9 = jSONObject7;
            JSONObject put = jSONObject9.put("width", adSizeParcel2.width);
            JSONObject put2 = jSONObject9.put("height", adSizeParcel2.height);
            JSONObject put3 = jSONObject6.put("size", jSONObject9);
            JSONObject put4 = jSONObject6.put("activity", zzN(context2));
            if (!adSizeParcel2.zzui) {
                JSONArray jSONArray2 = jSONArray;
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = jSONArray2;
                while (view2 != null) {
                    ViewParent parent = view2.getParent();
                    if (parent != null) {
                        int i = -1;
                        if (parent instanceof ViewGroup) {
                            i = ((ViewGroup) parent).indexOfChild(view2);
                        }
                        JSONObject jSONObject10 = jSONObject3;
                        JSONObject jSONObject11 = new JSONObject();
                        JSONObject jSONObject12 = jSONObject10;
                        JSONObject put5 = jSONObject12.put(MimeTypeParser.TAG_TYPE, parent.getClass().getName());
                        JSONObject put6 = jSONObject12.put("index_of_child", i);
                        JSONArray put7 = jSONArray4.put(jSONObject12);
                    }
                    view2 = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                }
                if (jSONArray4.length() > 0) {
                    JSONObject put8 = jSONObject6.put("parents", jSONArray4);
                }
            }
            return jSONObject6.toString();
        } catch (JSONException e) {
            zzin.zzd("Fail to get view hierarchy json", e);
            return null;
        }
    }

    public String zza(Context context, zzan zzan, String str) {
        Context context2 = context;
        zzan zzan2 = zzan;
        String str2 = str;
        if (zzan2 == null) {
            return str2;
        }
        try {
            Uri parse = Uri.parse(str2);
            if (zzan2.zzc(parse)) {
                parse = zzan2.zza(parse, context2);
            }
            return parse.toString();
        } catch (Exception e) {
            Exception exc = e;
            return str2;
        }
    }

    public String zza(zzjp zzjp, String str) {
        zzjp zzjp2 = zzjp;
        return zza(zzjp2.getContext(), zzjp2.zzhW(), str);
    }

    public String zza(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb;
        InputStreamReader inputStreamReader2 = inputStreamReader;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(8192);
        StringBuilder sb4 = sb2;
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader2.read(cArr);
            if (read == -1) {
                return sb4.toString();
            }
            StringBuilder append = sb4.append(cArr, 0, read);
        }
    }

    /* access modifiers changed from: 0000 */
    public JSONArray zza(Object[] objArr) throws JSONException {
        JSONArray jSONArray;
        Object[] objArr2 = objArr;
        JSONArray jSONArray2 = jSONArray;
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = jSONArray2;
        int length = objArr2.length;
        for (int i = 0; i < length; i++) {
            zza(jSONArray4, objArr2[i]);
        }
        return jSONArray4;
    }

    public void zza(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        OnGlobalLayoutListener onGlobalLayoutListener2 = onGlobalLayoutListener;
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener2);
        }
    }

    public void zza(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        OnScrollChangedListener onScrollChangedListener2 = onScrollChangedListener;
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener2);
        }
    }

    public void zza(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(zze(context, str));
    }

    public void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        Uri.Builder builder;
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        Bundle bundle2 = bundle;
        if (z) {
            Context applicationContext = context2.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context2;
            }
            bundle2.putString("os", VERSION.RELEASE);
            bundle2.putString("api", String.valueOf(VERSION.SDK_INT));
            bundle2.putString("device", zzr.zzbC().zzht());
            bundle2.putString("appid", applicationContext.getPackageName());
            bundle2.putString("eids", TextUtils.join(",", zzbt.zzdr()));
            if (str3 != null) {
                bundle2.putString("js", str3);
            } else {
                bundle2.putString("gmscore_version", Integer.toString(zze.zzaj(context2)));
            }
        }
        Uri.Builder builder2 = builder;
        Uri.Builder builder3 = new Uri.Builder();
        Uri.Builder appendQueryParameter = builder2.scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str4);
        for (String str5 : bundle2.keySet()) {
            Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter(str5, bundle2.getString(str5));
        }
        zzr.zzbC().zzc(context2, str3, appendQueryParameter.toString());
    }

    public void zza(Context context, String str, List<String> list) {
        zziy zziy;
        Context context2 = context;
        String str2 = str;
        for (String zziy2 : list) {
            zziy zziy3 = zziy;
            zziy zziy4 = new zziy(context2, str2, zziy2);
            Future zzhn = zziy3.zzgd();
        }
    }

    public void zza(Context context, String str, List<String> list, String str2) {
        zziy zziy;
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        for (String zziy2 : list) {
            zziy zziy3 = zziy;
            zziy zziy4 = new zziy(context2, str3, zziy2, str4);
            Future zzhn = zziy3.zzgd();
        }
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        zza(context, str, z, httpURLConnection, false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, String str2) {
        Context context2 = context;
        String str3 = str;
        boolean z2 = z;
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        String str4 = str2;
        httpURLConnection2.setConnectTimeout(60000);
        httpURLConnection2.setInstanceFollowRedirects(z2);
        httpURLConnection2.setReadTimeout(60000);
        httpURLConnection2.setRequestProperty("User-Agent", str4);
        httpURLConnection2.setUseCaches(false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        Context context2 = context;
        String str2 = str;
        boolean z3 = z;
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        boolean z4 = z2;
        httpURLConnection2.setConnectTimeout(60000);
        httpURLConnection2.setInstanceFollowRedirects(z3);
        httpURLConnection2.setReadTimeout(60000);
        httpURLConnection2.setRequestProperty("User-Agent", zze(context2, str2));
        httpURLConnection2.setUseCaches(z4);
    }

    public boolean zza(Context context, Bitmap bitmap, String str) {
        Context context2 = context;
        Bitmap bitmap2 = bitmap;
        String str2 = str;
        zzx.zzcE("saveImageToFile must not be called on the main UI thread.");
        try {
            FileOutputStream openFileOutput = context2.openFileOutput(str2, 0);
            boolean compress = bitmap2.compress(CompressFormat.PNG, 100, openFileOutput);
            openFileOutput.close();
            bitmap2.recycle();
            return true;
        } catch (Exception e) {
            zzin.zzb("Fail to save file", e);
            return false;
        }
    }

    public boolean zza(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public boolean zza(View view, Context context) {
        View view2 = view;
        Context context2 = context;
        Context applicationContext = context2.getApplicationContext();
        PowerManager powerManager = applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null;
        Object systemService = context2.getSystemService("keyguard");
        KeyguardManager keyguardManager = null;
        if (systemService != null) {
            keyguardManager = null;
            if (systemService instanceof KeyguardManager) {
                keyguardManager = (KeyguardManager) systemService;
            }
        }
        return zza(view2, powerManager, keyguardManager);
    }

    public boolean zza(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        View view2 = view;
        return view2.getVisibility() == 0 && view2.isShown() && zza(powerManager) && (zzr.zzbC().zzhq() || !zza(keyguardManager));
    }

    public boolean zza(ClassLoader classLoader, Class<?> cls, String str) {
        try {
            return cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
            Throwable th2 = th;
            return false;
        }
    }

    public String zzaC(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public int zzaD(String str) {
        StringBuilder sb;
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.zzaK(sb2.append("Could not parse value:").append(numberFormatException).toString());
            return 0;
        }
    }

    public boolean zzaE(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public void zzb(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        OnScrollChangedListener onScrollChangedListener2 = onScrollChangedListener;
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener2);
        }
    }

    public void zzb(Context context, Intent intent) {
        Context context2 = context;
        Intent intent2 = intent;
        try {
            context2.startActivity(intent2);
        } catch (Throwable th) {
            Throwable th2 = th;
            Intent addFlags = intent2.addFlags(268435456);
            context2.startActivity(intent2);
        }
    }

    public void zzb(Context context, String str, String str2, Bundle bundle, boolean z) {
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        Bundle bundle2 = bundle;
        boolean z2 = z;
        if (((Boolean) zzbt.zzwN.get()).booleanValue()) {
            zza(context2, str3, str4, bundle2, z2);
        }
    }

    public float zzbt() {
        zzn zzbs = zzr.zzbQ().zzbs();
        if (zzbs == null || !zzbs.zzbu()) {
            return 1.0f;
        }
        return zzbs.zzbt();
    }

    public void zzc(Context context, String str, String str2) {
        ArrayList arrayList;
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        boolean add = arrayList4.add(str4);
        zza(context2, str3, (List<String>) arrayList4);
    }

    public String zze(Context context, String str) {
        String str2;
        StringBuilder sb;
        C04161 r17;
        StringBuilder sb2;
        Context context2 = context;
        String str3 = str;
        r3 = this.zzpV;
        synchronized (r3) {
            try {
                if (this.zzzN != null) {
                    th = this.zzzN;
                    return str2;
                }
                try {
                    this.zzzN = zzr.zzbE().getDefaultUserAgent(context2);
                } catch (Exception e) {
                    Exception exc = e;
                }
                if (TextUtils.isEmpty(this.zzzN)) {
                    if (!com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
                        this.zzzN = null;
                        Handler handler = zzMc;
                        C04161 r13 = r17;
                        final Context context3 = context2;
                        C04161 r14 = new Runnable(this) {
                            final /* synthetic */ zzir zzMf;

                            {
                                Context context = r7;
                                this.zzMf = r6;
                            }

                            public void run() {
                                Object zza = this.zzMf.zzpV;
                                synchronized (zza) {
                                    try {
                                        String zza2 = zzir.zza(this.zzMf, this.zzMf.zzK(context3));
                                        this.zzMf.zzpV.notifyAll();
                                    } catch (Throwable th) {
                                        Throwable th2 = th;
                                        Object obj = zza;
                                        throw th2;
                                    }
                                }
                            }
                        };
                        boolean post = handler.post(r13);
                        while (this.zzzN == null) {
                            this.zzpV.wait();
                        }
                    } else {
                        try {
                            this.zzzN = zzK(context2);
                        } catch (Exception e2) {
                            Exception exc2 = e2;
                            this.zzzN = zzhr();
                        }
                    }
                }
                StringBuilder sb3 = sb;
                StringBuilder sb4 = new StringBuilder();
                this.zzzN = sb3.append(this.zzzN).append(" (Mobile; ").append(str3).append(")").toString();
                String str4 = this.zzzN;
                return str4;
            } catch (InterruptedException e3) {
                InterruptedException interruptedException = e3;
                this.zzzN = zzhr();
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                zzin.zzaK(sb5.append("Interrupted, use default user agent: ").append(this.zzzN).toString());
            } finally {
                str2 = th;
                Object obj = r3;
                Throwable th = str2;
            }
        }
    }

    public Map<String, String> zze(Uri uri) {
        HashMap hashMap;
        Uri uri2 = uri;
        if (uri2 == null) {
            return null;
        }
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        for (String str : zzr.zzbE().zzf(uri2)) {
            Object put = hashMap4.put(str, uri2.getQueryParameter(str));
        }
        return hashMap4;
    }

    public int[] zze(Activity activity) {
        Window window = activity.getWindow();
        if (window != null) {
            View findViewById = window.findViewById(16908290);
            if (findViewById != null) {
                return new int[]{findViewById.getWidth(), findViewById.getHeight()};
            }
        }
        return zzhu();
    }

    public Bitmap zzf(Context context, String str) {
        Context context2 = context;
        String str2 = str;
        zzx.zzcE("getBackgroundImage must not be called on the main UI thread.");
        try {
            FileInputStream openFileInput = context2.openFileInput(str2);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            return decodeStream;
        } catch (Exception e) {
            Exception exc = e;
            zzin.m19e("Fail to get background image");
            return null;
        }
    }

    public int[] zzf(Activity activity) {
        Activity activity2 = activity;
        int[] zze = zze(activity2);
        return new int[]{com.google.android.gms.ads.internal.client.zzn.zzcS().zzc(activity2, zze[0]), com.google.android.gms.ads.internal.client.zzn.zzcS().zzc(activity2, zze[1])};
    }

    public void zzg(Context context, String str) {
        Context context2 = context;
        String str2 = str;
        zzx.zzcE("deleteFile must not be called on the main UI thread.");
        boolean deleteFile = context2.deleteFile(str2);
    }

    public int[] zzg(Activity activity) {
        Window window = activity.getWindow();
        if (window != null) {
            View findViewById = window.findViewById(16908290);
            if (findViewById != null) {
                return new int[]{findViewById.getTop(), findViewById.getBottom()};
            }
        }
        return zzhu();
    }

    public int[] zzh(Activity activity) {
        Activity activity2 = activity;
        int[] zzg = zzg(activity2);
        return new int[]{com.google.android.gms.ads.internal.client.zzn.zzcS().zzc(activity2, zzg[0]), com.google.android.gms.ads.internal.client.zzn.zzcS().zzc(activity2, zzg[1])};
    }

    public boolean zzhq() {
        return this.zzMd;
    }

    /* access modifiers changed from: 0000 */
    public String zzhr() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(256);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            StringBuffer append2 = stringBuffer4.append(" ").append(VERSION.RELEASE);
        }
        StringBuffer append3 = stringBuffer4.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            StringBuffer append4 = stringBuffer4.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                StringBuffer append5 = stringBuffer4.append(" Build/").append(Build.DISPLAY);
            }
        }
        StringBuffer append6 = stringBuffer4.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer4.toString();
    }

    public String zzhs() {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        UUID randomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        BigInteger bigInteger3 = bigInteger;
        BigInteger bigInteger4 = new BigInteger(1, byteArray);
        String bigInteger5 = bigInteger3.toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(byteArray);
                instance.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(instance.digest(), 0, bArr, 0, 8);
                BigInteger bigInteger6 = bigInteger2;
                BigInteger bigInteger7 = new BigInteger(1, bArr);
                bigInteger5 = bigInteger6.toString();
            } catch (NoSuchAlgorithmException e) {
                NoSuchAlgorithmException noSuchAlgorithmException = e;
            }
        }
        return bigInteger5;
    }

    public String zzht() {
        StringBuilder sb;
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(str).append(" ").append(str2).toString();
    }

    /* access modifiers changed from: protected */
    public int[] zzhu() {
        return new int[]{0, 0};
    }

    public Bitmap zzk(View view) {
        View view2 = view;
        view2.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getDrawingCache());
        view2.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public int zzl(@Nullable View view) {
        ViewParent viewParent;
        View view2 = view;
        if (view2 == null) {
            return -1;
        }
        ViewParent parent = view2.getParent();
        while (true) {
            viewParent = parent;
            if (viewParent != null && !(viewParent instanceof AdapterView)) {
                parent = viewParent.getParent();
            }
        }
        if (viewParent == null) {
            return -1;
        }
        return ((AdapterView) viewParent).getPositionForView(view2);
    }
}
