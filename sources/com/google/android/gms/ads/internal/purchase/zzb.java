package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.lang.reflect.Method;

@zzhb
public class zzb {
    private final Context mContext;
    private final boolean zzFA;
    Object zzFz;

    public zzb(Context context) {
        this(context, true);
    }

    public zzb(Context context, boolean z) {
        boolean z2 = z;
        this.mContext = context;
        this.zzFA = z2;
    }

    public void destroy() {
        this.zzFz = null;
    }

    public void zzN(IBinder iBinder) {
        IBinder iBinder2 = iBinder;
        try {
            Class[] clsArr = new Class[1];
            Class[] clsArr2 = clsArr;
            clsArr[0] = IBinder.class;
            Method declaredMethod = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", clsArr2);
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = iBinder2;
            this.zzFz = declaredMethod.invoke(null, objArr2);
        } catch (Exception e) {
            Exception exc = e;
            if (this.zzFA) {
                zzin.zzaK("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
            }
        }
    }

    public int zzb(int i, String str, String str2) {
        int i2 = i;
        String str3 = str;
        String str4 = str2;
        try {
            Class loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("isBillingSupported", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.zzFz), new Object[]{Integer.valueOf(i2), str3, str4})).intValue();
        } catch (Exception e) {
            Exception exc = e;
            if (this.zzFA) {
                zzin.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", exc);
            }
            return 5;
        }
    }

    public Bundle zzb(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        try {
            Class loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(loadClass.cast(this.zzFz), new Object[]{Integer.valueOf(3), str4, str5, "inapp", str6});
        } catch (Exception e) {
            Exception exc = e;
            if (this.zzFA) {
                zzin.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", exc);
            }
            return null;
        }
    }

    public int zzh(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        try {
            Class loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("consumePurchase", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.zzFz), new Object[]{Integer.valueOf(3), str3, str4})).intValue();
        } catch (Exception e) {
            Exception exc = e;
            if (this.zzFA) {
                zzin.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", exc);
            }
            return 5;
        }
    }

    public Bundle zzi(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        try {
            Class loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getPurchases", new Class[]{Integer.TYPE, String.class, String.class, String.class}).invoke(loadClass.cast(this.zzFz), new Object[]{Integer.valueOf(3), str3, "inapp", str4});
        } catch (Exception e) {
            Exception exc = e;
            if (this.zzFA) {
                zzin.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", exc);
            }
            return null;
        }
    }
}
