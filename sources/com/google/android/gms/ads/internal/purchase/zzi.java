package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzih;
import com.google.android.gms.internal.zzin;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzi {
    public zzi() {
    }

    public void zza(Context context, boolean z, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Intent intent;
        Context context2 = context;
        boolean z2 = z;
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel2 = gInAppPurchaseManagerInfoParcel;
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        Intent intent4 = intent2;
        Intent className = intent4.setClassName(context2, InAppPurchaseActivity.CLASS_NAME);
        Intent putExtra = intent4.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z2);
        GInAppPurchaseManagerInfoParcel.zza(intent4, gInAppPurchaseManagerInfoParcel2);
        zzr.zzbC().zzb(context2, intent4);
    }

    public String zzaq(String str) {
        JSONObject jSONObject;
        String str2 = str;
        if (str2 == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject(str2);
            return jSONObject2.getString("developerPayload");
        } catch (JSONException e) {
            JSONException jSONException = e;
            zzin.zzaK("Fail to parse purchase data");
            return null;
        }
    }

    public String zzar(String str) {
        JSONObject jSONObject;
        String str2 = str;
        if (str2 == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject;
            JSONObject jSONObject3 = new JSONObject(str2);
            return jSONObject2.getString("purchaseToken");
        } catch (JSONException e) {
            JSONException jSONException = e;
            zzin.zzaK("Fail to parse purchase data");
            return null;
        }
    }

    public int zzd(Intent intent) {
        StringBuilder sb;
        Intent intent2 = intent;
        if (intent2 == null) {
            return 5;
        }
        Object obj = intent2.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            zzin.zzaK("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.zzaK(sb2.append("Unexpected type for intent response code. ").append(obj.getClass().getName()).toString());
            return 5;
        }
    }

    public int zzd(Bundle bundle) {
        StringBuilder sb;
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            zzin.zzaK("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.zzaK(sb2.append("Unexpected type for intent response code. ").append(obj.getClass().getName()).toString());
            return 5;
        }
    }

    public String zze(Intent intent) {
        Intent intent2 = intent;
        if (intent2 == null) {
            return null;
        }
        return intent2.getStringExtra("INAPP_PURCHASE_DATA");
    }

    public String zzf(Intent intent) {
        Intent intent2 = intent;
        if (intent2 == null) {
            return null;
        }
        return intent2.getStringExtra("INAPP_DATA_SIGNATURE");
    }

    public void zzz(Context context) {
        C01831 r8;
        Intent intent;
        Context context2 = context;
        C01831 r4 = r8;
        final Context context3 = context2;
        C01831 r5 = new ServiceConnection(this) {
            final /* synthetic */ zzi zzFZ;

            {
                Context context = r7;
                this.zzFZ = r6;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                zzb zzb;
                ComponentName componentName2 = componentName;
                IBinder iBinder2 = iBinder;
                zzb zzb2 = zzb;
                zzb zzb3 = new zzb(context3.getApplicationContext(), false);
                zzb zzb4 = zzb2;
                zzb4.zzN(iBinder2);
                int zzb5 = zzb4.zzb(3, context3.getPackageName(), "inapp");
                zzih zzbF = zzr.zzbF();
                boolean z = false;
                if (zzb5 == 0) {
                    z = true;
                }
                zzbF.zzC(z);
                context3.unbindService(this);
                zzb4.destroy();
            }

            public void onServiceDisconnected(ComponentName componentName) {
            }
        };
        C01831 r2 = r4;
        Intent intent2 = intent;
        Intent intent3 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        Intent intent4 = intent2;
        Intent intent5 = intent4.setPackage(zze.GOOGLE_PLAY_STORE_PACKAGE);
        boolean bindService = context2.bindService(intent4, r2, 1);
    }
}
