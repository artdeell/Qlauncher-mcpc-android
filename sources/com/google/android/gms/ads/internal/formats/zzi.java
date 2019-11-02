package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzi implements zzh {
    private final Context mContext;
    /* access modifiers changed from: private */
    public zzjp zzpD;
    private final VersionInfoParcel zzpT;
    private final Object zzpV;
    private final zzp zzyn;
    private final JSONObject zzyq;
    /* access modifiers changed from: private */
    public final zzed zzyr;
    private final zza zzys;
    private final zzan zzyt;
    private boolean zzyu;
    /* access modifiers changed from: private */
    public String zzyv;
    private WeakReference<View> zzyw = null;

    public zzi(Context context, zzp zzp, zzed zzed, zzan zzan, JSONObject jSONObject, zza zza, VersionInfoParcel versionInfoParcel) {
        Object obj;
        Context context2 = context;
        zzp zzp2 = zzp;
        zzed zzed2 = zzed;
        zzan zzan2 = zzan;
        JSONObject jSONObject2 = jSONObject;
        zza zza2 = zza;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.mContext = context2;
        this.zzyn = zzp2;
        this.zzyr = zzed2;
        this.zzyt = zzan2;
        this.zzyq = jSONObject2;
        this.zzys = zza2;
        this.zzpT = versionInfoParcel2;
    }

    static /* synthetic */ String zza(zzi zzi, String str) {
        String str2 = str;
        zzi.zzyv = str2;
        return str2;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void recordImpression() {
        JSONObject jSONObject;
        zzx.zzcD("recordImpression must be called on the main UI thread.");
        zzn(true);
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = jSONObject2;
            JSONObject put = jSONObject4.put("ad", this.zzyq);
            this.zzyr.zza("google.afma.nativeAds.handleImpressionPing", jSONObject4);
        } catch (JSONException e) {
            zzin.zzb("Unable to create impression JSON.", e);
        }
        this.zzyn.zza((zzh) this);
    }

    public zzb zza(OnClickListener onClickListener) {
        zzb zzb;
        LayoutParams layoutParams;
        OnClickListener onClickListener2 = onClickListener;
        zza zzdN = this.zzys.zzdN();
        if (zzdN == null) {
            return null;
        }
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb(this.mContext, zzdN);
        zzb zzb4 = zzb2;
        zzb zzb5 = zzb4;
        LayoutParams layoutParams2 = layoutParams;
        LayoutParams layoutParams3 = new LayoutParams(-1, -1);
        zzb5.setLayoutParams(layoutParams2);
        zzb4.zzdI().setOnClickListener(onClickListener2);
        zzb4.zzdI().setContentDescription("Ad attribution icon");
        return zzb4;
    }

    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        View view2 = view;
        Map<String, WeakReference<View>> map2 = map;
        JSONObject jSONObject4 = jSONObject;
        JSONObject jSONObject5 = jSONObject2;
        JSONObject jSONObject6 = jSONObject3;
        zzx.zzcD("performClick must be called on the main UI thread.");
        for (Entry entry : map2.entrySet()) {
            if (view2.equals((View) ((WeakReference) entry.getValue()).get())) {
                zza((String) entry.getKey(), jSONObject4, jSONObject5, jSONObject6);
                return;
            }
        }
    }

    public void zza(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        String str2 = str;
        JSONObject jSONObject6 = jSONObject;
        JSONObject jSONObject7 = jSONObject2;
        JSONObject jSONObject8 = jSONObject3;
        zzx.zzcD("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject9 = jSONObject4;
            JSONObject jSONObject10 = new JSONObject();
            JSONObject jSONObject11 = jSONObject9;
            JSONObject put = jSONObject11.put("asset", str2);
            JSONObject put2 = jSONObject11.put("template", this.zzys.zzdM());
            JSONObject jSONObject12 = jSONObject5;
            JSONObject jSONObject13 = new JSONObject();
            JSONObject jSONObject14 = jSONObject12;
            JSONObject put3 = jSONObject14.put("ad", this.zzyq);
            JSONObject put4 = jSONObject14.put("click", jSONObject11);
            JSONObject put5 = jSONObject14.put("has_custom_click_handler", this.zzyn.zzs(this.zzys.getCustomTemplateId()) != null);
            if (jSONObject6 != null) {
                JSONObject put6 = jSONObject14.put("view_rectangles", jSONObject6);
            }
            if (jSONObject7 != null) {
                JSONObject put7 = jSONObject14.put("click_point", jSONObject7);
            }
            if (jSONObject8 != null) {
                JSONObject put8 = jSONObject14.put("native_view_rectangle", jSONObject8);
            }
            this.zzyr.zza("google.afma.nativeAds.handleClickGmsg", jSONObject14);
        } catch (JSONException e) {
            zzin.zzb("Unable to create click JSON.", e);
        }
    }

    public void zzb(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        this.zzyt.zza(motionEvent2);
    }

    public zzjp zzdR() {
        C01661 r6;
        C01682 r62;
        C01693 r63;
        C01704 r64;
        C01715 r65;
        this.zzpD = zzdT();
        this.zzpD.getView().setVisibility(8);
        C01661 r3 = r6;
        C01661 r4 = new zzdf(this) {
            final /* synthetic */ zzi zzyx;

            {
                this.zzyx = r5;
            }

            public void zza(zzjp zzjp, Map<String, String> map) {
                C01671 r11;
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                zzjq zzhU = this.zzyx.zzpD.zzhU();
                C01671 r6 = r11;
                final Map<String, String> map3 = map2;
                C01671 r7 = new zzjq.zza(this) {
                    final /* synthetic */ C01661 zzyz;

                    {
                        Map map = r7;
                        this.zzyz = r6;
                    }

                    public void zza(zzjp zzjp, boolean z) {
                        JSONObject jSONObject;
                        zzjp zzjp2 = zzjp;
                        boolean z2 = z;
                        String zza = zzi.zza(this.zzyz.zzyx, (String) map3.get("id"));
                        JSONObject jSONObject2 = jSONObject;
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = jSONObject2;
                        try {
                            JSONObject put = jSONObject4.put("messageType", "htmlLoaded");
                            JSONObject put2 = jSONObject4.put("id", this.zzyz.zzyx.zzyv);
                            this.zzyz.zzyx.zzyr.zzb("sendMessageToNativeJs", jSONObject4);
                        } catch (JSONException e) {
                            zzin.zzb("Unable to dispatch sendMessageToNativeJsevent", e);
                        }
                    }
                };
                zzhU.zza((zzjq.zza) r6);
                String str = (String) map2.get("overlayHtml");
                String str2 = (String) map2.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    this.zzyx.zzpD.loadData(str, "text/html", "UTF-8");
                } else {
                    this.zzyx.zzpD.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        };
        this.zzyr.zza("/loadHtml", (zzdf) r3);
        C01682 r32 = r62;
        C01682 r42 = new zzdf(this) {
            final /* synthetic */ zzi zzyx;

            {
                this.zzyx = r5;
            }

            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                this.zzyx.zzpD.getView().setVisibility(0);
            }
        };
        this.zzyr.zza("/showOverlay", (zzdf) r32);
        C01693 r33 = r63;
        C01693 r43 = new zzdf(this) {
            final /* synthetic */ zzi zzyx;

            {
                this.zzyx = r5;
            }

            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                this.zzyx.zzpD.getView().setVisibility(8);
            }
        };
        this.zzyr.zza("/hideOverlay", (zzdf) r33);
        C01704 r34 = r64;
        C01704 r44 = new zzdf(this) {
            final /* synthetic */ zzi zzyx;

            {
                this.zzyx = r5;
            }

            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                this.zzyx.zzpD.getView().setVisibility(8);
            }
        };
        this.zzpD.zzhU().zza("/hideOverlay", (zzdf) r34);
        C01715 r35 = r65;
        C01715 r45 = new zzdf(this) {
            final /* synthetic */ zzi zzyx;

            {
                this.zzyx = r5;
            }

            public void zza(zzjp zzjp, Map<String, String> map) {
                JSONObject jSONObject;
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                JSONObject jSONObject2 = jSONObject;
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = jSONObject2;
                try {
                    for (String str : map2.keySet()) {
                        JSONObject put = jSONObject4.put(str, map2.get(str));
                    }
                    JSONObject put2 = jSONObject4.put("id", this.zzyx.zzyv);
                    this.zzyx.zzyr.zzb("sendMessageToNativeJs", jSONObject4);
                } catch (JSONException e) {
                    zzin.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                }
            }
        };
        this.zzpD.zzhU().zza("/sendMessageToSdk", (zzdf) r35);
        return this.zzpD;
    }

    public View zzdS() {
        if (this.zzyw != null) {
            return (View) this.zzyw.get();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public zzjp zzdT() {
        return zzr.zzbD().zza(this.mContext, AdSizeParcel.zzt(this.mContext), false, false, this.zzyt, this.zzpT);
    }

    public void zzg(View view) {
    }

    public void zzh(View view) {
        Rect rect;
        View view2 = view;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!this.zzyu) {
                    if (view2.isShown()) {
                        View view3 = view2;
                        Rect rect2 = rect;
                        Rect rect3 = new Rect();
                        if (view3.getGlobalVisibleRect(rect2, null)) {
                            recordImpression();
                        }
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzi(View view) {
        WeakReference<View> weakReference;
        WeakReference<View> weakReference2 = weakReference;
        WeakReference<View> weakReference3 = new WeakReference<>(view);
        this.zzyw = weakReference2;
    }

    /* access modifiers changed from: protected */
    public void zzn(boolean z) {
        boolean z2 = z;
        this.zzyu = z2;
    }
}
