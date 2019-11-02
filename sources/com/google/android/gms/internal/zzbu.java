package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.zzr;
import java.util.LinkedHashMap;
import java.util.Map;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;

@zzhb
public class zzbu {
    private Context mContext = null;
    private String zzsy = null;
    private boolean zzxi;
    private String zzxj;
    private Map<String, String> zzxk;

    public zzbu(Context context, String str) {
        LinkedHashMap linkedHashMap;
        Context context2 = context;
        String str2 = str;
        this.mContext = context2;
        this.zzsy = str2;
        this.zzxi = ((Boolean) zzbt.zzwg.get()).booleanValue();
        this.zzxj = (String) zzbt.zzwh.get();
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        this.zzxk = linkedHashMap2;
        Object put = this.zzxk.put("s", "gmob_sdk");
        Object put2 = this.zzxk.put(RegisterSpec.PREFIX, "3");
        Object put3 = this.zzxk.put("os", VERSION.RELEASE);
        Object put4 = this.zzxk.put("sdk", VERSION.SDK);
        Object put5 = this.zzxk.put("device", zzr.zzbC().zzht());
        Object put6 = this.zzxk.put("app", context2.getApplicationContext() != null ? context2.getApplicationContext().getPackageName() : context2.getPackageName());
        zzhj zzE = zzr.zzbI().zzE(this.mContext);
        Object put7 = this.zzxk.put("network_coarse", Integer.toString(zzE.zzKc));
        Object put8 = this.zzxk.put("network_fine", Integer.toString(zzE.zzKd));
    }

    /* access modifiers changed from: 0000 */
    public Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: 0000 */
    public String zzcs() {
        return this.zzsy;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzdu() {
        return this.zzxi;
    }

    /* access modifiers changed from: 0000 */
    public String zzdv() {
        return this.zzxj;
    }

    /* access modifiers changed from: 0000 */
    public Map<String, String> zzdw() {
        return this.zzxk;
    }
}
