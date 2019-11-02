package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zzhb
public class zzg extends zzi {
    private Object zzpV;
    private zzfb zzyl;
    private zzfc zzym;
    private final zzp zzyn;
    private zzh zzyo;
    private boolean zzyp;

    private zzg(Context context, zzp zzp, zzan zzan) {
        Object obj;
        zzp zzp2 = zzp;
        super(context, zzp2, null, zzan, null, null, null);
        this.zzyp = false;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzyn = zzp2;
    }

    public zzg(Context context, zzp zzp, zzan zzan, zzfb zzfb) {
        zzfb zzfb2 = zzfb;
        this(context, zzp, zzan);
        this.zzyl = zzfb2;
    }

    public zzg(Context context, zzp zzp, zzan zzan, zzfc zzfc) {
        zzfc zzfc2 = zzfc;
        this(context, zzp, zzan);
        this.zzym = zzfc2;
    }

    public void recordImpression() {
        zzx.zzcD("recordImpression must be called on the main UI thread.");
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zzn(true);
                if (this.zzyo != null) {
                    this.zzyo.recordImpression();
                } else if (this.zzyl != null && !this.zzyl.getOverrideImpressionRecording()) {
                    this.zzyl.recordImpression();
                } else if (this.zzym != null && !this.zzym.getOverrideImpressionRecording()) {
                    this.zzym.recordImpression();
                }
            } catch (RemoteException e) {
                zzin.zzd("Failed to call recordImpression", e);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
            this.zzyn.recordImpression();
        }
    }

    public zzb zza(OnClickListener onClickListener) {
        OnClickListener onClickListener2 = onClickListener;
        return null;
    }

    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        View view2 = view;
        Map<String, WeakReference<View>> map2 = map;
        JSONObject jSONObject4 = jSONObject;
        JSONObject jSONObject5 = jSONObject2;
        JSONObject jSONObject6 = jSONObject3;
        zzx.zzcD("performClick must be called on the main UI thread.");
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzyo != null) {
                    this.zzyo.zza(view2, map2, jSONObject4, jSONObject5, jSONObject6);
                    this.zzyn.onAdClicked();
                } else {
                    if (this.zzyl != null && !this.zzyl.getOverrideClickHandling()) {
                        this.zzyl.zzc(zze.zzC(view2));
                        this.zzyn.onAdClicked();
                    }
                    if (this.zzym != null && !this.zzym.getOverrideClickHandling()) {
                        this.zzym.zzc(zze.zzC(view2));
                        this.zzyn.onAdClicked();
                    }
                }
            } catch (RemoteException e) {
                zzin.zzd("Failed to call performClick", e);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzc(zzh zzh) {
        zzh zzh2 = zzh;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzyo = zzh2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public boolean zzdP() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzyp;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public zzh zzdQ() {
        zzh zzh = this.zzpV;
        synchronized (zzh) {
            try {
                th = this.zzyo;
            } finally {
                Throwable th = th;
                zzh zzh2 = zzh;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public zzjp zzdR() {
        return null;
    }

    public void zzg(View view) {
        View view2 = view;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzyp = true;
                if (this.zzyl != null) {
                    this.zzyl.zzd(zze.zzC(view2));
                } else if (this.zzym != null) {
                    this.zzym.zzd(zze.zzC(view2));
                }
            } catch (RemoteException e) {
                zzin.zzd("Failed to call prepareAd", e);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
            this.zzyp = false;
        }
    }
}
