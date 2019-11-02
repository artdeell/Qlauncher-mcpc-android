package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.ipaulpro.afilechooser.utils.MimeTypeParser;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@zzhb
public final class zzdo implements zzdf {
    private final Map<zzjp, Integer> zzzI;

    public zzdo() {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2 = weakHashMap;
        WeakHashMap weakHashMap3 = new WeakHashMap();
        this.zzzI = weakHashMap2;
    }

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        StringBuilder sb;
        Context context2 = context;
        String str2 = str;
        int i2 = i;
        String str3 = (String) map.get(str2);
        if (str3 != null) {
            try {
                i2 = zzn.zzcS().zzb(context2, Integer.parseInt(str3));
            } catch (NumberFormatException e) {
                NumberFormatException numberFormatException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zzin.zzaK(sb2.append("Could not parse ").append(str2).append(" in a video GMSG: ").append(str3).toString());
                return i2;
            }
        }
        return i2;
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        int i;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        JSONObject jSONObject;
        StringBuilder sb4;
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        String str = (String) map2.get("action");
        if (str == null) {
            zzin.zzaK("Action missing from video GMSG.");
            return;
        }
        if (zzin.zzQ(3)) {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject(map2);
            JSONObject jSONObject4 = jSONObject2;
            Object remove = jSONObject4.remove("google.afma.Notify_dt");
            StringBuilder sb5 = sb4;
            StringBuilder sb6 = new StringBuilder();
            zzin.zzaI(sb5.append("Video GMSG: ").append(str).append(" ").append(jSONObject4.toString()).toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map2.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzin.zzaK("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int parseColor = Color.parseColor(str2);
                zzjo zzia = zzjp2.zzia();
                if (zzia != null) {
                    zzk zzhM = zzia.zzhM();
                    if (zzhM != null) {
                        zzhM.setBackgroundColor(parseColor);
                        return;
                    }
                }
                Object put = this.zzzI.put(zzjp2, Integer.valueOf(parseColor));
            } catch (IllegalArgumentException e) {
                IllegalArgumentException illegalArgumentException = e;
                zzin.zzaK("Invalid color parameter in video GMSG.");
            }
        } else {
            zzjo zzia2 = zzjp2.zzia();
            if (zzia2 == null) {
                zzin.zzaK("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = "new".equals(str);
            boolean equals2 = "position".equals(str);
            if (equals || equals2) {
                Context context = zzjp2.getContext();
                int zza = zza(context, map2, "x", 0);
                int zza2 = zza(context, map2, "y", 0);
                int zza3 = zza(context, map2, "w", -1);
                int zza4 = zza(context, map2, "h", -1);
                try {
                    i = Integer.parseInt((String) map2.get("player"));
                } catch (NumberFormatException e2) {
                    NumberFormatException numberFormatException = e2;
                    i = 0;
                }
                if (!equals || zzia2.zzhM() != null) {
                    zzia2.zze(zza, zza2, zza3, zza4);
                    return;
                }
                zzia2.zza(zza, zza2, zza3, zza4, i);
                if (this.zzzI.containsKey(zzjp2)) {
                    int intValue = ((Integer) this.zzzI.get(zzjp2)).intValue();
                    zzk zzhM2 = zzia2.zzhM();
                    zzhM2.setBackgroundColor(intValue);
                    zzhM2.zzfE();
                    return;
                }
                return;
            }
            zzk zzhM3 = zzia2.zzhM();
            if (zzhM3 == null) {
                zzk.zzg(zzjp2);
            } else if ("click".equals(str)) {
                Context context2 = zzjp2.getContext();
                int zza5 = zza(context2, map2, "x", 0);
                int zza6 = zza(context2, map2, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza5, (float) zza6, 0);
                zzhM3.zzd(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str)) {
                String str3 = (String) map2.get("time");
                if (str3 == null) {
                    zzin.zzaK("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzhM3.seekTo((int) (1000.0f * Float.parseFloat(str3)));
                } catch (NumberFormatException e3) {
                    NumberFormatException numberFormatException2 = e3;
                    StringBuilder sb7 = sb3;
                    StringBuilder sb8 = new StringBuilder();
                    zzin.zzaK(sb7.append("Could not parse time parameter from currentTime video GMSG: ").append(str3).toString());
                }
            } else if ("hide".equals(str)) {
                zzhM3.setVisibility(4);
            } else if ("load".equals(str)) {
                zzhM3.zzfD();
            } else if (MimeTypeParser.ATTR_MIMETYPE.equals(str)) {
                zzhM3.setMimeType((String) map2.get(MimeTypeParser.ATTR_MIMETYPE));
            } else if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map2.get("muted"))) {
                    zzhM3.zzff();
                } else {
                    zzhM3.zzfg();
                }
            } else if ("pause".equals(str)) {
                zzhM3.pause();
            } else if ("play".equals(str)) {
                zzhM3.play();
            } else if ("show".equals(str)) {
                zzhM3.setVisibility(0);
            } else if ("src".equals(str)) {
                zzhM3.zzap((String) map2.get("src"));
            } else if ("volume".equals(str)) {
                String str4 = (String) map2.get("volume");
                if (str4 == null) {
                    zzin.zzaK("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzhM3.zza(Float.parseFloat(str4));
                } catch (NumberFormatException e4) {
                    NumberFormatException numberFormatException3 = e4;
                    StringBuilder sb9 = sb2;
                    StringBuilder sb10 = new StringBuilder();
                    zzin.zzaK(sb9.append("Could not parse volume parameter from volume video GMSG: ").append(str4).toString());
                }
            } else if ("watermark".equals(str)) {
                zzhM3.zzfE();
            } else {
                StringBuilder sb11 = sb;
                StringBuilder sb12 = new StringBuilder();
                zzin.zzaK(sb11.append("Unknown video action: ").append(str).toString());
            }
        }
    }
}
