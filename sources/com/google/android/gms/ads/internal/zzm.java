package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.zzf.zza;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzes;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzm {
    private static zzd zza(zzfb zzfb) throws RemoteException {
        zzd zzd;
        zzfb zzfb2 = zzfb;
        zzd zzd2 = zzd;
        zzd zzd3 = new zzd(zzfb2.getHeadline(), zzfb2.getImages(), zzfb2.getBody(), zzfb2.zzdK(), zzfb2.getCallToAction(), zzfb2.getStarRating(), zzfb2.getStore(), zzfb2.getPrice(), null, zzfb2.getExtras());
        return zzd2;
    }

    private static zze zza(zzfc zzfc) throws RemoteException {
        zze zze;
        zzfc zzfc2 = zzfc;
        zze zze2 = zze;
        zze zze3 = new zze(zzfc2.getHeadline(), zzfc2.getImages(), zzfc2.getBody(), zzfc2.zzdO(), zzfc2.getCallToAction(), zzfc2.getAdvertiser(), null, zzfc2.getExtras());
        return zze2;
    }

    static zzdf zza(zzfb zzfb, zzfc zzfc, zza zza) {
        C02085 r8;
        C02085 r3 = r8;
        final zzfb zzfb2 = zzfb;
        final zza zza2 = zza;
        final zzfc zzfc2 = zzfc;
        C02085 r4 = new zzdf() {
            {
                zza zza = r8;
                zzfc zzfc = r9;
            }

            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                View view = zzjp2.getView();
                if (view != null) {
                    try {
                        if (zzfb2 != null) {
                            if (!zzfb2.getOverrideClickHandling()) {
                                zzfb2.zzc(com.google.android.gms.dynamic.zze.zzC(view));
                                zza2.onClick();
                                return;
                            }
                            zzm.zza(zzjp2);
                        } else if (zzfc2 == null) {
                        } else {
                            if (!zzfc2.getOverrideClickHandling()) {
                                zzfc2.zzc(com.google.android.gms.dynamic.zze.zzC(view));
                                zza2.onClick();
                                return;
                            }
                            zzm.zza(zzjp2);
                        }
                    } catch (RemoteException e) {
                        zzin.zzd("Unable to call handleClick on mapper", e);
                    }
                }
            }
        };
        return r3;
    }

    static zzdf zza(CountDownLatch countDownLatch) {
        C02063 r4;
        C02063 r1 = r4;
        final CountDownLatch countDownLatch2 = countDownLatch;
        C02063 r2 = new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                countDownLatch2.countDown();
                View view = zzjp2.getView();
                if (view != null) {
                    view.setVisibility(0);
                }
            }
        };
        return r1;
    }

    private static String zza(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        StringBuilder sb;
        Bitmap bitmap2 = bitmap;
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
        if (bitmap2 == null) {
            zzin.zzaK("Bitmap is null. Returning empty string");
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        boolean compress = bitmap2.compress(CompressFormat.PNG, 100, byteArrayOutputStream4);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream4.toByteArray(), 0);
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("data:image/png;base64,").append(encodeToString).toString();
    }

    static String zza(zzch zzch) {
        zzch zzch2 = zzch;
        if (zzch2 == null) {
            zzin.zzaK("Image is null. Returning empty string");
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        try {
            Uri uri = zzch2.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            zzin.zzaK("Unable to get image uri. Trying data uri next");
        }
        return zzb(zzch2);
    }

    /* access modifiers changed from: private */
    public static JSONObject zza(Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Bundle bundle2 = bundle;
        String str2 = str;
        JSONObject jSONObject3 = jSONObject;
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = jSONObject3;
        if (bundle2 == null || TextUtils.isEmpty(str2)) {
            return jSONObject5;
        }
        JSONObject jSONObject6 = jSONObject2;
        JSONObject jSONObject7 = new JSONObject(str2);
        JSONObject jSONObject8 = jSONObject6;
        Iterator keys = jSONObject8.keys();
        while (keys.hasNext()) {
            String str3 = (String) keys.next();
            if (bundle2.containsKey(str3)) {
                if ("image".equals(jSONObject8.getString(str3))) {
                    Object obj = bundle2.get(str3);
                    if (obj instanceof Bitmap) {
                        JSONObject put = jSONObject5.put(str3, zza((Bitmap) obj));
                    } else {
                        zzin.zzaK("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle2.get(str3) instanceof Bitmap) {
                    zzin.zzaK("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    JSONObject put2 = jSONObject5.put(str3, String.valueOf(bundle2.get(str3)));
                }
            }
        }
        return jSONObject5;
    }

    public static void zza(zzif zzif, zza zza) {
        zzif zzif2 = zzif;
        zza zza2 = zza;
        if (zzg(zzif2)) {
            zzjp zzjp = zzif2.zzED;
            View view = zzjp.getView();
            if (view == null) {
                zzin.zzaK("AdWebView is null");
                return;
            }
            try {
                List<String> list = zzif2.zzCp.zzBM;
                if (list == null || list.isEmpty()) {
                    zzin.zzaK("No template ids present in mediation response");
                    return;
                }
                zzfb zzeF = zzif2.zzCq.zzeF();
                zzfc zzeG = zzif2.zzCq.zzeG();
                if (list.contains("2") && zzeF != null) {
                    zzeF.zzd(com.google.android.gms.dynamic.zze.zzC(view));
                    if (!zzeF.getOverrideImpressionRecording()) {
                        zzeF.recordImpression();
                    }
                    zzjp.zzhU().zza("/nativeExpressViewClicked", zza(zzeF, (zzfc) null, zza2));
                } else if (!list.contains("1") || zzeG == null) {
                    zzin.zzaK("No matching template id and mapper");
                } else {
                    zzeG.zzd(com.google.android.gms.dynamic.zze.zzC(view));
                    if (!zzeG.getOverrideImpressionRecording()) {
                        zzeG.recordImpression();
                    }
                    zzjp.zzhU().zza("/nativeExpressViewClicked", zza((zzfb) null, zzeG, zza2));
                }
            } catch (RemoteException e) {
                zzin.zzd("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void zza(zzjp zzjp) {
        zzjp zzjp2 = zzjp;
        OnClickListener zzif = zzjp2.zzif();
        if (zzif != null) {
            zzif.onClick(zzjp2.getView());
        }
    }

    private static void zza(zzjp zzjp, zzd zzd, String str) {
        C02041 r9;
        zzjp zzjp2 = zzjp;
        zzd zzd2 = zzd;
        String str2 = str;
        zzjq zzhU = zzjp2.zzhU();
        C02041 r4 = r9;
        final zzd zzd3 = zzd2;
        final String str3 = str2;
        final zzjp zzjp3 = zzjp2;
        C02041 r5 = new zzjq.zza() {
            {
                String str = r8;
                zzjp zzjp = r9;
            }

            public void zza(zzjp zzjp, boolean z) {
                JSONObject jSONObject;
                JSONArray jSONArray;
                JSONObject jSONObject2;
                zzjp zzjp2 = zzjp;
                boolean z2 = z;
                try {
                    JSONObject jSONObject3 = jSONObject;
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = jSONObject3;
                    JSONObject put = jSONObject5.put("headline", zzd3.getHeadline());
                    JSONObject put2 = jSONObject5.put("body", zzd3.getBody());
                    JSONObject put3 = jSONObject5.put("call_to_action", zzd3.getCallToAction());
                    JSONObject put4 = jSONObject5.put("price", zzd3.getPrice());
                    JSONObject put5 = jSONObject5.put("star_rating", String.valueOf(zzd3.getStarRating()));
                    JSONObject put6 = jSONObject5.put("store", zzd3.getStore());
                    JSONObject put7 = jSONObject5.put("icon", zzm.zza(zzd3.zzdK()));
                    JSONArray jSONArray2 = jSONArray;
                    JSONArray jSONArray3 = new JSONArray();
                    JSONArray jSONArray4 = jSONArray2;
                    List<Object> images = zzd3.getImages();
                    if (images != null) {
                        for (Object zzd : images) {
                            JSONArray put8 = jSONArray4.put(zzm.zza(zzm.zzc(zzd)));
                        }
                    }
                    JSONObject put9 = jSONObject5.put("images", jSONArray4);
                    JSONObject put10 = jSONObject5.put("extras", zzm.zza(zzd3.getExtras(), str3));
                    JSONObject jSONObject6 = jSONObject2;
                    JSONObject jSONObject7 = new JSONObject();
                    JSONObject jSONObject8 = jSONObject6;
                    JSONObject put11 = jSONObject8.put("assets", jSONObject5);
                    JSONObject put12 = jSONObject8.put("template_id", "2");
                    zzjp3.zza("google.afma.nativeExpressAds.loadAssets", jSONObject8);
                } catch (JSONException e) {
                    zzin.zzd("Exception occurred when loading assets", e);
                }
            }
        };
        zzhU.zza((zzjq.zza) r4);
    }

    private static void zza(zzjp zzjp, zze zze, String str) {
        C02052 r9;
        zzjp zzjp2 = zzjp;
        zze zze2 = zze;
        String str2 = str;
        zzjq zzhU = zzjp2.zzhU();
        C02052 r4 = r9;
        final zze zze3 = zze2;
        final String str3 = str2;
        final zzjp zzjp3 = zzjp2;
        C02052 r5 = new zzjq.zza() {
            {
                String str = r8;
                zzjp zzjp = r9;
            }

            public void zza(zzjp zzjp, boolean z) {
                JSONObject jSONObject;
                JSONArray jSONArray;
                JSONObject jSONObject2;
                zzjp zzjp2 = zzjp;
                boolean z2 = z;
                try {
                    JSONObject jSONObject3 = jSONObject;
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = jSONObject3;
                    JSONObject put = jSONObject5.put("headline", zze3.getHeadline());
                    JSONObject put2 = jSONObject5.put("body", zze3.getBody());
                    JSONObject put3 = jSONObject5.put("call_to_action", zze3.getCallToAction());
                    JSONObject put4 = jSONObject5.put("advertiser", zze3.getAdvertiser());
                    JSONObject put5 = jSONObject5.put("logo", zzm.zza(zze3.zzdO()));
                    JSONArray jSONArray2 = jSONArray;
                    JSONArray jSONArray3 = new JSONArray();
                    JSONArray jSONArray4 = jSONArray2;
                    List<Object> images = zze3.getImages();
                    if (images != null) {
                        for (Object zzd : images) {
                            JSONArray put6 = jSONArray4.put(zzm.zza(zzm.zzc(zzd)));
                        }
                    }
                    JSONObject put7 = jSONObject5.put("images", jSONArray4);
                    JSONObject put8 = jSONObject5.put("extras", zzm.zza(zze3.getExtras(), str3));
                    JSONObject jSONObject6 = jSONObject2;
                    JSONObject jSONObject7 = new JSONObject();
                    JSONObject jSONObject8 = jSONObject6;
                    JSONObject put9 = jSONObject8.put("assets", jSONObject5);
                    JSONObject put10 = jSONObject8.put("template_id", "1");
                    zzjp3.zza("google.afma.nativeExpressAds.loadAssets", jSONObject8);
                } catch (JSONException e) {
                    zzin.zzd("Exception occurred when loading assets", e);
                }
            }
        };
        zzhU.zza((zzjq.zza) r4);
    }

    private static void zza(zzjp zzjp, CountDownLatch countDownLatch) {
        zzjp zzjp2 = zzjp;
        CountDownLatch countDownLatch2 = countDownLatch;
        zzjp2.zzhU().zza("/nativeExpressAssetsLoaded", zza(countDownLatch2));
        zzjp2.zzhU().zza("/nativeExpressAssetsLoadingFailed", zzb(countDownLatch2));
    }

    public static boolean zza(zzjp zzjp, zzes zzes, CountDownLatch countDownLatch) {
        boolean z;
        CountDownLatch countDownLatch2 = countDownLatch;
        try {
            z = zzb(zzjp, zzes, countDownLatch2);
        } catch (RemoteException e) {
            zzin.zzd("Unable to invoke load assets", e);
            z = false;
        } catch (RuntimeException e2) {
            RuntimeException runtimeException = e2;
            countDownLatch2.countDown();
            throw runtimeException;
        }
        if (!z) {
            countDownLatch2.countDown();
        }
        return z;
    }

    static zzdf zzb(CountDownLatch countDownLatch) {
        C02074 r4;
        C02074 r1 = r4;
        final CountDownLatch countDownLatch2 = countDownLatch;
        C02074 r2 = new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                zzin.zzaK("Adapter returned an ad, but assets substitution failed");
                countDownLatch2.countDown();
                zzjp2.destroy();
            }
        };
        return r1;
    }

    private static String zzb(zzch zzch) {
        try {
            com.google.android.gms.dynamic.zzd zzdJ = zzch.zzdJ();
            if (zzdJ == null) {
                zzin.zzaK("Drawable is null. Returning empty string");
                return LibrariesRepository.MOJANG_MAVEN_REPO;
            }
            Drawable drawable = (Drawable) com.google.android.gms.dynamic.zze.zzp(zzdJ);
            if (drawable instanceof BitmapDrawable) {
                return zza(((BitmapDrawable) drawable).getBitmap());
            }
            zzin.zzaK("Drawable is not an instance of BitmapDrawable. Returning empty string");
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            zzin.zzaK("Unable to get drawable. Returning empty string");
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
    }

    private static boolean zzb(zzjp zzjp, zzes zzes, CountDownLatch countDownLatch) throws RemoteException {
        zzjp zzjp2 = zzjp;
        zzes zzes2 = zzes;
        CountDownLatch countDownLatch2 = countDownLatch;
        View view = zzjp2.getView();
        if (view == null) {
            zzin.zzaK("AdWebView is null");
            return false;
        }
        view.setVisibility(4);
        List<String> list = zzes2.zzCp.zzBM;
        if (list == null || list.isEmpty()) {
            zzin.zzaK("No template ids present in mediation response");
            return false;
        }
        zza(zzjp2, countDownLatch2);
        zzfb zzeF = zzes2.zzCq.zzeF();
        zzfc zzeG = zzes2.zzCq.zzeG();
        if (list.contains("2") && zzeF != null) {
            zza(zzjp2, zza(zzeF), zzes2.zzCp.zzBL);
        } else if (!list.contains("1") || zzeG == null) {
            zzin.zzaK("No matching template id and mapper");
            return false;
        } else {
            zza(zzjp2, zza(zzeG), zzes2.zzCp.zzBL);
        }
        String str = zzes2.zzCp.zzBJ;
        String str2 = zzes2.zzCp.zzBK;
        if (str2 != null) {
            zzjp2.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        } else {
            zzjp2.loadData(str, "text/html", "UTF-8");
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static zzch zzc(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof IBinder) {
            return zzch.zza.zzt((IBinder) obj2);
        }
        return null;
    }

    public static View zzf(zzif zzif) {
        zzif zzif2 = zzif;
        if (zzif2 == null) {
            zzin.m19e("AdState is null");
            return null;
        } else if (zzg(zzif2)) {
            return zzif2.zzED.getView();
        } else {
            try {
                com.google.android.gms.dynamic.zzd view = zzif2.zzCq.getView();
                if (view != null) {
                    return (View) com.google.android.gms.dynamic.zze.zzp(view);
                }
                zzin.zzaK("View in mediation adapter is null.");
                return null;
            } catch (RemoteException e) {
                zzin.zzd("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    public static boolean zzg(zzif zzif) {
        zzif zzif2 = zzif;
        return (zzif2 == null || !zzif2.zzHT || zzif2.zzCp == null || zzif2.zzCp.zzBJ == null) ? false : true;
    }
}
