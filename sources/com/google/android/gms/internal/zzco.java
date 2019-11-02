package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzch.zza;
import java.util.ArrayList;
import java.util.List;

@zzhb
public class zzco extends NativeContentAd {
    private final List<Image> zzyN;
    private final zzcn zzyP;
    private final zzci zzyQ;

    public zzco(zzcn zzcn) {
        ArrayList arrayList;
        zzci zzci;
        zzci zzci2;
        zzci zzci3;
        zzcn zzcn2 = zzcn;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.zzyN = arrayList2;
        this.zzyP = zzcn2;
        try {
            List<Object> images = this.zzyP.getImages();
            if (images != null) {
                for (Object zzc : images) {
                    zzch zzc2 = zzc(zzc);
                    if (zzc2 != null) {
                        List<Image> list = this.zzyN;
                        zzci zzci4 = zzci3;
                        zzci zzci5 = new zzci(zzc2);
                        boolean add = list.add(zzci4);
                    }
                }
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get image.", e);
        }
        try {
            zzch zzdO = this.zzyP.zzdO();
            if (zzdO != null) {
                zzci zzci6 = zzci2;
                zzci zzci7 = new zzci(zzdO);
                zzci = zzci6;
                this.zzyQ = zzci;
            }
        } catch (RemoteException e2) {
            zzb.zzb("Failed to get icon.", e2);
        }
        zzci = null;
        this.zzyQ = zzci;
    }

    public void destroy() {
        try {
            this.zzyP.destroy();
        } catch (RemoteException e) {
            zzb.zzb("Failed to destroy", e);
        }
    }

    public CharSequence getAdvertiser() {
        try {
            return this.zzyP.getAdvertiser();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get attribution.", e);
            return null;
        }
    }

    public CharSequence getBody() {
        try {
            return this.zzyP.getBody();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.zzyP.getCallToAction();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.zzyP.getExtras();
        } catch (RemoteException e) {
            zzb.zzd("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.zzyP.getHeadline();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public List<Image> getImages() {
        return this.zzyN;
    }

    public Image getLogo() {
        return this.zzyQ;
    }

    /* access modifiers changed from: 0000 */
    public zzch zzc(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof IBinder) {
            return zza.zzt((IBinder) obj2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdL */
    public zzd zzaH() {
        try {
            return this.zzyP.zzdL();
        } catch (RemoteException e) {
            zzb.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
