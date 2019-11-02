package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.ads.afma.nano.NanoAdshieldEvent.AdShieldEvent;
import com.google.ads.afma.nano.NanoAfmaSignals.AFMASignals;
import com.google.ads.afma.nano.NanoAfmaSignals.AFMASignals.TouchInfo;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.zzc;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class zzal extends zzak {
    private static long startTime = 0;
    private static Method zznH;
    private static Method zznI;
    private static Method zznJ;
    private static Method zznK;
    private static Method zznL;
    private static Method zznM;
    private static Method zznN;
    private static Method zznO;
    private static Method zznP;
    private static Method zznQ;
    private static Method zznR;
    private static Method zznS;
    private static Method zznT;
    private static String zznU;
    private static String zznV;
    private static String zznW;
    private static zzaq zznX;
    static boolean zznY = false;
    protected static zzb zznZ = null;
    protected static AdShieldEvent zzoa;
    protected static int zzob;
    private static Random zzoc;
    private static zzc zzod = zzc.zzoK();
    private static boolean zzoe;
    protected static boolean zzof = false;
    protected static boolean zzog = false;
    protected static boolean zzoh = false;
    protected static boolean zzoi = false;
    private static boolean zzoj = false;

    static class zza extends Exception {
        public zza() {
        }

        public zza(Throwable th) {
            super(th);
        }
    }

    static {
        Random random;
        Random random2 = random;
        Random random3 = new Random();
        zzoc = random2;
    }

    protected zzal(Context context, zzap zzap) {
        AdShieldEvent adShieldEvent;
        Context context2 = context;
        super(context2, zzap);
        AdShieldEvent adShieldEvent2 = adShieldEvent;
        AdShieldEvent adShieldEvent3 = new AdShieldEvent();
        zzoa = adShieldEvent2;
        zzoa.appId = context2.getPackageName();
    }

    private void zzT() {
        if (zzoi && zznZ != null) {
            boolean zza2 = zznZ.zza(zznG, 100, TimeUnit.MILLISECONDS);
            zznG.disconnect();
        }
    }

    static String zzU() throws zza {
        zza zza2;
        if (zznU != null) {
            return zznU;
        }
        zza zza3 = zza2;
        zza zza4 = new zza();
        throw zza3;
    }

    static Long zzV() throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        if (zznH == null) {
            zza zza5 = zza4;
            zza zza6 = new zza();
            throw zza5;
        }
        try {
            return (Long) zznH.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            zza zza7 = zza3;
            zza zza8 = new zza(illegalAccessException);
            throw zza7;
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            zza zza9 = zza2;
            zza zza10 = new zza(invocationTargetException);
            throw zza9;
        }
    }

    static String zzW() throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        if (zznJ == null) {
            zza zza5 = zza4;
            zza zza6 = new zza();
            throw zza5;
        }
        try {
            return (String) zznJ.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            zza zza7 = zza3;
            zza zza8 = new zza(illegalAccessException);
            throw zza7;
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            zza zza9 = zza2;
            zza zza10 = new zza(invocationTargetException);
            throw zza9;
        }
    }

    static Long zzX() throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        if (zznI == null) {
            zza zza5 = zza4;
            zza zza6 = new zza();
            throw zza5;
        }
        try {
            return (Long) zznI.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            zza zza7 = zza3;
            zza zza8 = new zza(illegalAccessException);
            throw zza7;
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            zza zza9 = zza2;
            zza zza10 = new zza(invocationTargetException);
            throw zza9;
        }
    }

    static String zza(Context context, zzap zzap) throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        zza zza5;
        Context context2 = context;
        zzap zzap2 = zzap;
        if (zznV != null) {
            return zznV;
        }
        if (zznK == null) {
            zza zza6 = zza5;
            zza zza7 = new zza();
            throw zza6;
        }
        try {
            Method method = zznK;
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = context2;
            ByteBuffer byteBuffer = (ByteBuffer) method.invoke(null, objArr2);
            if (byteBuffer == null) {
                zza zza8 = zza4;
                zza zza9 = new zza();
                throw zza8;
            }
            zznV = zzap2.zza(byteBuffer.array(), true);
            return zznV;
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            zza zza10 = zza3;
            zza zza11 = new zza(illegalAccessException);
            throw zza10;
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            zza zza12 = zza2;
            zza zza13 = new zza(invocationTargetException);
            throw zza12;
        }
    }

    static ArrayList<Long> zza(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        MotionEvent motionEvent2 = motionEvent;
        DisplayMetrics displayMetrics2 = displayMetrics;
        if (zznL == null || motionEvent2 == null) {
            zza zza5 = zza2;
            zza zza6 = new zza();
            throw zza5;
        }
        try {
            Method method = zznL;
            Object[] objArr = new Object[2];
            Object[] objArr2 = objArr;
            objArr[0] = motionEvent2;
            Object[] objArr3 = objArr2;
            Object[] objArr4 = objArr3;
            objArr3[1] = displayMetrics2;
            return (ArrayList) method.invoke(null, objArr4);
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            zza zza7 = zza4;
            zza zza8 = new zza(illegalAccessException);
            throw zza7;
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            zza zza9 = zza3;
            zza zza10 = new zza(invocationTargetException);
            throw zza9;
        }
    }

    protected static void zza(int i, int i2) throws IOException {
        int i3 = i;
        int i4 = i2;
        if (zzoi && zzof && zznZ != null) {
            com.google.android.gms.clearcut.zzb.zza zzi = zznZ.zzi(zzsu.toByteArray(zzoa));
            com.google.android.gms.clearcut.zzb.zza zzbr = zzi.zzbr(i4);
            com.google.android.gms.clearcut.zzb.zza zzbq = zzi.zzbq(i3);
            PendingResult zzd = zzi.zzd(zznG);
        }
    }

    protected static void zza(String str, Context context, zzap zzap) {
        zzaq zzaq;
        Random random;
        Builder builder;
        zzb zzb;
        String str2 = str;
        Context context2 = context;
        zzap zzap2 = zzap;
        synchronized (zzal.class) {
            try {
                if (!zznY) {
                    try {
                        zzaq zzaq2 = zzaq;
                        zzaq zzaq3 = new zzaq(zzap2, null);
                        zznX = zzaq2;
                        zznU = str2;
                        zzbt.initialize(context2);
                        zzm(context2);
                        startTime = zzV().longValue();
                        Random random2 = random;
                        Random random3 = new Random();
                        zzoc = random2;
                        try {
                            Builder builder2 = builder;
                            Builder builder3 = new Builder(context2);
                            zznG = builder2.addApi(zzb.API).build();
                            zzod = zzc.zzoK();
                            zzoe = zzod.isGooglePlayServicesAvailable(context2) == 0;
                            zzbt.initialize(context2);
                            zzof = ((Boolean) zzbt.zzwZ.get()).booleanValue();
                            zzb zzb2 = zzb;
                            zzb zzb3 = new zzb(context2, "ADSHIELD", null, null);
                            zznZ = zzb2;
                        } catch (NoClassDefFoundError e) {
                            NoClassDefFoundError noClassDefFoundError = e;
                        }
                        zzoj = zzod.zzaj(context2) > 0;
                        zznY = true;
                    } catch (zza e2) {
                        zza zza2 = e2;
                    } catch (UnsupportedOperationException e3) {
                        UnsupportedOperationException unsupportedOperationException = e3;
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Class<zzal> cls = zzal.class;
                throw th2;
            }
        }
    }

    static String zzb(Context context, zzap zzap) throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        zza zza5;
        Context context2 = context;
        zzap zzap2 = zzap;
        if (zznW != null) {
            return zznW;
        }
        if (zznN == null) {
            zza zza6 = zza5;
            zza zza7 = new zza();
            throw zza6;
        }
        try {
            Method method = zznN;
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = context2;
            ByteBuffer byteBuffer = (ByteBuffer) method.invoke(null, objArr2);
            if (byteBuffer == null) {
                zza zza8 = zza4;
                zza zza9 = new zza();
                throw zza8;
            }
            zznW = zzap2.zza(byteBuffer.array(), true);
            return zznW;
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            zza zza10 = zza3;
            zza zza11 = new zza(illegalAccessException);
            throw zza10;
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            zza zza12 = zza2;
            zza zza13 = new zza(invocationTargetException);
            throw zza12;
        }
    }

    private static String zzb(byte[] bArr, String str) throws zza {
        zza zza2;
        zza zza3;
        String str2;
        try {
            String str3 = str2;
            String str4 = new String(zznX.zzc(bArr, str), "UTF-8");
            return str3;
        } catch (com.google.android.gms.internal.zzaq.zza e) {
            com.google.android.gms.internal.zzaq.zza zza4 = e;
            zza zza5 = zza3;
            zza zza6 = new zza(zza4);
            throw zza5;
        } catch (UnsupportedEncodingException e2) {
            UnsupportedEncodingException unsupportedEncodingException = e2;
            zza zza7 = zza2;
            zza zza8 = new zza(unsupportedEncodingException);
            throw zza7;
        }
    }

    private void zze(Context context) {
        Context context2 = context;
        if (zzoe) {
            zznG.connect();
            zzoi = true;
            return;
        }
        zzoi = false;
    }

    static String zzf(Context context) throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        zza zza5;
        Context context2 = context;
        if (zznM == null) {
            zza zza6 = zza5;
            zza zza7 = new zza();
            throw zza6;
        }
        try {
            Method method = zznM;
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = context2;
            String str = (String) method.invoke(null, objArr2);
            if (str != null) {
                return str;
            }
            zza zza8 = zza4;
            zza zza9 = new zza();
            throw zza8;
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            zza zza10 = zza3;
            zza zza11 = new zza(illegalAccessException);
            throw zza10;
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            zza zza12 = zza2;
            zza zza13 = new zza(invocationTargetException);
            throw zza12;
        }
    }

    static String zzg(Context context) throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        Context context2 = context;
        if (zznQ == null) {
            zza zza5 = zza4;
            zza zza6 = new zza();
            throw zza5;
        }
        try {
            Method method = zznQ;
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = context2;
            return (String) method.invoke(null, objArr2);
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            zza zza7 = zza3;
            zza zza8 = new zza(illegalAccessException);
            throw zza7;
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            zza zza9 = zza2;
            zza zza10 = new zza(invocationTargetException);
            throw zza9;
        }
    }

    static Long zzh(Context context) throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        Context context2 = context;
        if (zznR == null) {
            zza zza5 = zza4;
            zza zza6 = new zza();
            throw zza5;
        }
        try {
            Method method = zznR;
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = context2;
            return (Long) method.invoke(null, objArr2);
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            zza zza7 = zza3;
            zza zza8 = new zza(illegalAccessException);
            throw zza7;
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            zza zza9 = zza2;
            zza zza10 = new zza(invocationTargetException);
            throw zza9;
        }
    }

    static ArrayList<Long> zzi(Context context) throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        zza zza5;
        Context context2 = context;
        if (zznO == null) {
            zza zza6 = zza5;
            zza zza7 = new zza();
            throw zza6;
        }
        try {
            Method method = zznO;
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = context2;
            ArrayList arrayList = (ArrayList) method.invoke(null, objArr2);
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            zza zza8 = zza4;
            zza zza9 = new zza();
            throw zza8;
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            zza zza10 = zza3;
            zza zza11 = new zza(illegalAccessException);
            throw zza10;
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            zza zza12 = zza2;
            zza zza13 = new zza(invocationTargetException);
            throw zza12;
        }
    }

    static int[] zzj(Context context) throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        Context context2 = context;
        if (zznP == null) {
            zza zza5 = zza4;
            zza zza6 = new zza();
            throw zza5;
        }
        try {
            Method method = zznP;
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = context2;
            return (int[]) method.invoke(null, objArr2);
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            zza zza7 = zza3;
            zza zza8 = new zza(illegalAccessException);
            throw zza7;
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            zza zza9 = zza2;
            zza zza10 = new zza(invocationTargetException);
            throw zza9;
        }
    }

    static int zzk(Context context) throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        Context context2 = context;
        if (zznS == null) {
            zza zza5 = zza4;
            zza zza6 = new zza();
            throw zza5;
        }
        try {
            Method method = zznS;
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = context2;
            return ((Integer) method.invoke(null, objArr2)).intValue();
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            zza zza7 = zza3;
            zza zza8 = new zza(illegalAccessException);
            throw zza7;
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            zza zza9 = zza2;
            zza zza10 = new zza(invocationTargetException);
            throw zza9;
        }
    }

    static int zzl(Context context) throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        Context context2 = context;
        if (zznT == null) {
            zza zza5 = zza4;
            zza zza6 = new zza();
            throw zza5;
        }
        try {
            Method method = zznT;
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = context2;
            return ((Integer) method.invoke(null, objArr2)).intValue();
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            zza zza7 = zza3;
            zza zza8 = new zza(illegalAccessException);
            throw zza7;
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            zza zza9 = zza2;
            zza zza10 = new zza(invocationTargetException);
            throw zza9;
        }
    }

    private static void zzm(Context context) throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        zza zza5;
        zza zza6;
        zza zza7;
        File file;
        File createTempFile;
        FileOutputStream fileOutputStream;
        File file2;
        DexClassLoader dexClassLoader;
        File file3;
        zza zza8;
        Context context2 = context;
        try {
            byte[] zzl = zznX.zzl(zzar.getKey());
            byte[] zzc = zznX.zzc(zzl, zzar.zzac());
            File cacheDir = context2.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context2.getDir("dex", 0);
                if (cacheDir == null) {
                    zza zza9 = zza8;
                    zza zza10 = new zza();
                    throw zza9;
                }
            }
            file = cacheDir;
            createTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream2 = fileOutputStream;
            FileOutputStream fileOutputStream3 = new FileOutputStream(createTempFile);
            FileOutputStream fileOutputStream4 = fileOutputStream2;
            fileOutputStream4.write(zzc, 0, zzc.length);
            fileOutputStream4.close();
            DexClassLoader dexClassLoader2 = dexClassLoader;
            DexClassLoader dexClassLoader3 = new DexClassLoader(createTempFile.getAbsolutePath(), file.getAbsolutePath(), null, context2.getClassLoader());
            DexClassLoader dexClassLoader4 = dexClassLoader2;
            Class loadClass = dexClassLoader4.loadClass(zzb(zzl, zzar.zzal()));
            Class loadClass2 = dexClassLoader4.loadClass(zzb(zzl, zzar.zzaz()));
            Class loadClass3 = dexClassLoader4.loadClass(zzb(zzl, zzar.zzat()));
            Class loadClass4 = dexClassLoader4.loadClass(zzb(zzl, zzar.zzap()));
            Class loadClass5 = dexClassLoader4.loadClass(zzb(zzl, zzar.zzaB()));
            Class loadClass6 = dexClassLoader4.loadClass(zzb(zzl, zzar.zzan()));
            Class loadClass7 = dexClassLoader4.loadClass(zzb(zzl, zzar.zzax()));
            Class loadClass8 = dexClassLoader4.loadClass(zzb(zzl, zzar.zzav()));
            Class loadClass9 = dexClassLoader4.loadClass(zzb(zzl, zzar.zzaj()));
            Class loadClass10 = dexClassLoader4.loadClass(zzb(zzl, zzar.zzah()));
            Class loadClass11 = dexClassLoader4.loadClass(zzb(zzl, zzar.zzaf()));
            Class loadClass12 = dexClassLoader4.loadClass(zzb(zzl, zzar.zzar()));
            Class loadClass13 = dexClassLoader4.loadClass(zzb(zzl, zzar.zzad()));
            zznH = loadClass.getMethod(zzb(zzl, zzar.zzam()), new Class[0]);
            zznI = loadClass2.getMethod(zzb(zzl, zzar.zzaA()), new Class[0]);
            zznJ = loadClass3.getMethod(zzb(zzl, zzar.zzau()), new Class[0]);
            Class cls = loadClass4;
            String zzb = zzb(zzl, zzar.zzaq());
            Class[] clsArr = new Class[1];
            Class[] clsArr2 = clsArr;
            clsArr[0] = Context.class;
            zznK = cls.getMethod(zzb, clsArr2);
            Class cls2 = loadClass5;
            String zzb2 = zzb(zzl, zzar.zzaC());
            Class[] clsArr3 = new Class[2];
            Class[] clsArr4 = clsArr3;
            clsArr3[0] = MotionEvent.class;
            Class[] clsArr5 = clsArr4;
            Class[] clsArr6 = clsArr5;
            clsArr5[1] = DisplayMetrics.class;
            zznL = cls2.getMethod(zzb2, clsArr6);
            Class cls3 = loadClass6;
            String zzb3 = zzb(zzl, zzar.zzao());
            Class[] clsArr7 = new Class[1];
            Class[] clsArr8 = clsArr7;
            clsArr7[0] = Context.class;
            zznM = cls3.getMethod(zzb3, clsArr8);
            Class cls4 = loadClass7;
            String zzb4 = zzb(zzl, zzar.zzay());
            Class[] clsArr9 = new Class[1];
            Class[] clsArr10 = clsArr9;
            clsArr9[0] = Context.class;
            zznN = cls4.getMethod(zzb4, clsArr10);
            Class cls5 = loadClass8;
            String zzb5 = zzb(zzl, zzar.zzaw());
            Class[] clsArr11 = new Class[1];
            Class[] clsArr12 = clsArr11;
            clsArr11[0] = Context.class;
            zznO = cls5.getMethod(zzb5, clsArr12);
            Class cls6 = loadClass9;
            String zzb6 = zzb(zzl, zzar.zzak());
            Class[] clsArr13 = new Class[1];
            Class[] clsArr14 = clsArr13;
            clsArr13[0] = Context.class;
            zznP = cls6.getMethod(zzb6, clsArr14);
            Class cls7 = loadClass10;
            String zzb7 = zzb(zzl, zzar.zzai());
            Class[] clsArr15 = new Class[1];
            Class[] clsArr16 = clsArr15;
            clsArr15[0] = Context.class;
            zznQ = cls7.getMethod(zzb7, clsArr16);
            Class cls8 = loadClass11;
            String zzb8 = zzb(zzl, zzar.zzag());
            Class[] clsArr17 = new Class[1];
            Class[] clsArr18 = clsArr17;
            clsArr17[0] = Context.class;
            zznR = cls8.getMethod(zzb8, clsArr18);
            Class cls9 = loadClass12;
            String zzb9 = zzb(zzl, zzar.zzas());
            Class[] clsArr19 = new Class[1];
            Class[] clsArr20 = clsArr19;
            clsArr19[0] = Context.class;
            zznS = cls9.getMethod(zzb9, clsArr20);
            Class cls10 = loadClass13;
            String zzb10 = zzb(zzl, zzar.zzae());
            Class[] clsArr21 = new Class[1];
            Class[] clsArr22 = clsArr21;
            clsArr21[0] = Context.class;
            zznT = cls10.getMethod(zzb10, clsArr22);
            String name = createTempFile.getName();
            boolean delete = createTempFile.delete();
            File file4 = file3;
            File file5 = new File(file, name.replace(".jar", ".dex"));
            boolean delete2 = file4.delete();
        } catch (FileNotFoundException e) {
            FileNotFoundException fileNotFoundException = e;
            zza zza11 = zza7;
            zza zza12 = new zza(fileNotFoundException);
            throw zza11;
        } catch (IOException e2) {
            IOException iOException = e2;
            zza zza13 = zza6;
            zza zza14 = new zza(iOException);
            throw zza13;
        } catch (ClassNotFoundException e3) {
            ClassNotFoundException classNotFoundException = e3;
            zza zza15 = zza5;
            zza zza16 = new zza(classNotFoundException);
            throw zza15;
        } catch (com.google.android.gms.internal.zzaq.zza e4) {
            com.google.android.gms.internal.zzaq.zza zza17 = e4;
            zza zza18 = zza4;
            zza zza19 = new zza(zza17);
            throw zza18;
        } catch (NoSuchMethodException e5) {
            NoSuchMethodException noSuchMethodException = e5;
            zza zza20 = zza3;
            zza zza21 = new zza(noSuchMethodException);
            throw zza20;
        } catch (NullPointerException e6) {
            NullPointerException nullPointerException = e6;
            zza zza22 = zza2;
            zza zza23 = new zza(nullPointerException);
            throw zza22;
        } catch (Throwable th) {
            Throwable th2 = th;
            String name2 = createTempFile.getName();
            boolean delete3 = createTempFile.delete();
            File file6 = file2;
            File file7 = new File(file, name2.replace(".jar", ".dex"));
            boolean delete4 = file6.delete();
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzS() {
        return zzoj;
    }

    /* access modifiers changed from: protected */
    public AFMASignals zzc(Context context) {
        AFMASignals aFMASignals;
        Context context2 = context;
        AFMASignals aFMASignals2 = aFMASignals;
        AFMASignals aFMASignals3 = new AFMASignals();
        AFMASignals aFMASignals4 = aFMASignals2;
        try {
            zze(context2);
            zzob = zzoc.nextInt();
            zza(0, zzob);
            try {
                aFMASignals4.osVersion = zzW();
                zza(1, zzob);
            } catch (zza e) {
                zza zza2 = e;
            }
            try {
                aFMASignals4.afmaVersion = zzU();
                zza(2, zzob);
            } catch (zza e2) {
                zza zza3 = e2;
            }
            try {
                long longValue = zzV().longValue();
                aFMASignals4.evtTime = Long.valueOf(longValue);
                if (startTime != 0) {
                    aFMASignals4.uptSignal = Long.valueOf(longValue - startTime);
                    aFMASignals4.usgSignal = Long.valueOf(startTime);
                }
                zza(25, zzob);
            } catch (zza e3) {
                zza zza4 = e3;
            }
            try {
                ArrayList zzi = zzi(context2);
                aFMASignals4.uwSignal = Long.valueOf(((Long) zzi.get(0)).longValue());
                aFMASignals4.uhSignal = Long.valueOf(((Long) zzi.get(1)).longValue());
                zza(31, zzob);
            } catch (zza e4) {
                zza zza5 = e4;
            }
            try {
                aFMASignals4.utzSignal = zzX();
                zza(33, zzob);
            } catch (zza e5) {
                zza zza6 = e5;
            }
            try {
                if (!zzog || !zzoh) {
                    aFMASignals4.intSignal = zza(context2, this.zznF);
                    zza(27, zzob);
                }
            } catch (zza e6) {
                zza zza7 = e6;
            }
            try {
                aFMASignals4.cerSignal = zzb(context2, this.zznF);
                zza(29, zzob);
            } catch (zza e7) {
                zza zza8 = e7;
            }
            try {
                int[] zzj = zzj(context2);
                aFMASignals4.btsSignal = Long.valueOf((long) zzj[0]);
                aFMASignals4.btlSignal = Long.valueOf((long) zzj[1]);
                zza(5, zzob);
            } catch (zza e8) {
                zza zza9 = e8;
            }
            try {
                aFMASignals4.ornSignal = Long.valueOf((long) zzk(context2));
                zza(12, zzob);
            } catch (zza e9) {
                zza zza10 = e9;
            }
            try {
                aFMASignals4.atvSignal = Long.valueOf((long) zzl(context2));
                zza(3, zzob);
            } catch (zza e10) {
                zza zza11 = e10;
            }
            try {
                aFMASignals4.vnmSignal = zzg(context2);
                zza(34, zzob);
            } catch (zza e11) {
                zza zza12 = e11;
            }
            try {
                aFMASignals4.vcdSignal = zzh(context2);
                zza(35, zzob);
            } catch (zza e12) {
                zza zza13 = e12;
            }
            zzT();
            return aFMASignals4;
        } catch (IOException e13) {
            IOException iOException = e13;
            return aFMASignals4;
        }
    }

    /* access modifiers changed from: protected */
    public AFMASignals zzd(Context context) {
        AFMASignals aFMASignals;
        TouchInfo touchInfo;
        Context context2 = context;
        AFMASignals aFMASignals2 = aFMASignals;
        AFMASignals aFMASignals3 = new AFMASignals();
        AFMASignals aFMASignals4 = aFMASignals2;
        try {
            zze(context2);
            zzob = zzoc.nextInt();
            try {
                aFMASignals4.afmaVersion = zzU();
            } catch (zza e) {
                zza zza2 = e;
            }
            try {
                aFMASignals4.osVersion = zzW();
            } catch (zza e2) {
                zza zza3 = e2;
            }
            try {
                aFMASignals4.evtTime = zzV();
            } catch (zza e3) {
                zza zza4 = e3;
            }
            zza(0, zzob);
            try {
                ArrayList zza5 = zza(this.zznx, this.zznE);
                aFMASignals4.tcxSignal = (Long) zza5.get(0);
                aFMASignals4.tcySignal = (Long) zza5.get(1);
                if (((Long) zza5.get(2)).longValue() >= 0) {
                    aFMASignals4.tctSignal = (Long) zza5.get(2);
                }
                aFMASignals4.tcpSignal = (Long) zza5.get(3);
                aFMASignals4.tcdSignal = (Long) zza5.get(4);
                zza(14, zzob);
            } catch (zza e4) {
                zza zza6 = e4;
            }
            if (this.zznz > 0) {
                aFMASignals4.tcdnSignal = Long.valueOf(this.zznz);
            }
            if (this.zznA > 0) {
                aFMASignals4.tcmSignal = Long.valueOf(this.zznA);
            }
            if (this.zznB > 0) {
                aFMASignals4.tcuSignal = Long.valueOf(this.zznB);
            }
            if (this.zznC > 0) {
                aFMASignals4.tccSignal = Long.valueOf(this.zznC);
            }
            try {
                int size = -1 + this.zzny.size();
                if (size > 0) {
                    aFMASignals4.previousTouches = new TouchInfo[size];
                    for (int i = 0; i < size; i++) {
                        ArrayList zza7 = zza((MotionEvent) this.zzny.get(i), this.zznE);
                        TouchInfo touchInfo2 = touchInfo;
                        TouchInfo touchInfo3 = new TouchInfo();
                        TouchInfo touchInfo4 = touchInfo2;
                        touchInfo4.tcxSignal = (Long) zza7.get(0);
                        touchInfo4.tcySignal = (Long) zza7.get(1);
                        aFMASignals4.previousTouches[i] = touchInfo4;
                    }
                }
            } catch (zza e5) {
                zza zza8 = e5;
                aFMASignals4.previousTouches = null;
            }
            try {
                aFMASignals4.vnmSignal = zzg(context2);
            } catch (zza e6) {
                zza zza9 = e6;
            }
            try {
                aFMASignals4.vcdSignal = zzh(context2);
            } catch (zza e7) {
                zza zza10 = e7;
            }
            zzT();
            return aFMASignals4;
        } catch (IOException e8) {
            IOException iOException = e8;
            return aFMASignals4;
        }
    }
}
