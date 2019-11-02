package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.zzex.zza;
import java.util.Map;

@zzhb
public final class zzew extends zza {
    private Map<Class<? extends NetworkExtras>, NetworkExtras> zzCG;

    public zzew() {
    }

    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> zzey zzah(String str) throws RemoteException {
        StringBuilder sb;
        RemoteException remoteException;
        zzfe zzfe;
        zzfj zzfj;
        String str2 = str;
        try {
            Class cls = Class.forName(str2, false, zzew.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
                zzfj zzfj2 = zzfj;
                zzfj zzfj3 = new zzfj(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.zzCG.get(mediationAdapter.getAdditionalParametersType()));
                return zzfj2;
            } else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                zzfe zzfe2 = zzfe;
                zzfe zzfe3 = new zzfe((com.google.android.gms.ads.mediation.MediationAdapter) cls.newInstance());
                return zzfe2;
            } else {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zzb.zzaK(sb2.append("Could not instantiate mediation adapter: ").append(str2).append(" (not a valid adapter).").toString());
                RemoteException remoteException2 = remoteException;
                RemoteException remoteException3 = new RemoteException();
                throw remoteException2;
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            return zzai(str2);
        }
    }

    private zzey zzai(String str) throws RemoteException {
        RemoteException remoteException;
        StringBuilder sb;
        CustomEventAdapter customEventAdapter;
        zzfj zzfj;
        zzfe zzfe;
        com.google.android.gms.ads.mediation.customevent.CustomEventAdapter customEventAdapter2;
        zzfe zzfe2;
        AdUrlAdapter adUrlAdapter;
        zzfe zzfe3;
        AdMobAdapter adMobAdapter;
        String str2 = str;
        try {
            zzb.zzaI("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str2)) {
                zzfe zzfe4 = zzfe3;
                AdMobAdapter adMobAdapter2 = adMobAdapter;
                AdMobAdapter adMobAdapter3 = new AdMobAdapter();
                zzfe zzfe5 = new zzfe(adMobAdapter2);
                return zzfe4;
            } else if ("com.google.ads.mediation.AdUrlAdapter".equals(str2)) {
                zzfe zzfe6 = zzfe2;
                AdUrlAdapter adUrlAdapter2 = adUrlAdapter;
                AdUrlAdapter adUrlAdapter3 = new AdUrlAdapter();
                zzfe zzfe7 = new zzfe(adUrlAdapter2);
                return zzfe6;
            } else if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str2)) {
                zzfe zzfe8 = zzfe;
                com.google.android.gms.ads.mediation.customevent.CustomEventAdapter customEventAdapter3 = customEventAdapter2;
                com.google.android.gms.ads.mediation.customevent.CustomEventAdapter customEventAdapter4 = new com.google.android.gms.ads.mediation.customevent.CustomEventAdapter();
                zzfe zzfe9 = new zzfe(customEventAdapter3);
                return zzfe8;
            } else {
                if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str2)) {
                    CustomEventAdapter customEventAdapter5 = customEventAdapter;
                    CustomEventAdapter customEventAdapter6 = new CustomEventAdapter();
                    CustomEventAdapter customEventAdapter7 = customEventAdapter5;
                    zzfj zzfj2 = zzfj;
                    zzfj zzfj3 = new zzfj(customEventAdapter7, (CustomEventExtras) this.zzCG.get(customEventAdapter7.getAdditionalParametersType()));
                    return zzfj2;
                }
                RemoteException remoteException2 = remoteException;
                RemoteException remoteException3 = new RemoteException();
                throw remoteException2;
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzd(sb2.append("Could not instantiate mediation adapter: ").append(str2).append(". ").toString(), th2);
        }
    }

    public zzey zzaf(String str) throws RemoteException {
        return zzah(str);
    }

    public boolean zzag(String str) throws RemoteException {
        StringBuilder sb;
        String str2 = str;
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str2, false, zzew.class.getClassLoader()));
        } catch (Throwable th) {
            Throwable th2 = th;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzb.zzaK(sb2.append("Could not load custom event implementation class: ").append(str2).append(", assuming old implementation.").toString());
            return false;
        }
    }

    public void zzg(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        Map<Class<? extends NetworkExtras>, NetworkExtras> map2 = map;
        this.zzCG = map2;
    }
}
