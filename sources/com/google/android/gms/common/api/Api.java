package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions> {
    private final String mName;
    private final zzc<?> zzaeE;
    private final zza<?, O> zzafW;
    private final zze<?, O> zzafX = null;
    private final zzf<?> zzafY;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public static abstract class zza<T extends zzb, O> {
        public zza() {
        }

        public int getPriority() {
            return IDirectInputDevice.DIPROPRANGE_NOMAX;
        }

        public abstract T zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);

        public List<Scope> zzo(O o) {
            O o2 = o;
            return Collections.emptyList();
        }
    }

    public interface zzb {
        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean isConnected();

        void zza(com.google.android.gms.common.api.GoogleApiClient.zza zza);

        void zza(zzp zzp, Set<Scope> set);

        boolean zzmE();

        boolean zznb();

        Intent zznc();

        IBinder zzoT();
    }

    public static final class zzc<C extends zzb> {
        public zzc() {
        }
    }

    public interface zzd<T extends IInterface> {
        T zzW(IBinder iBinder);

        void zza(int i, T t);

        String zzgu();

        String zzgv();
    }

    public interface zze<T extends zzd, O> {
        int getPriority();

        int zzoU();

        T zzq(O o);
    }

    public static final class zzf<C extends zzd> {
    }

    public <C extends zzb> Api(String str, zza<C, O> zza2, zzc<C> zzc2) {
        String str2 = str;
        zza<C, O> zza3 = zza2;
        zzc<C> zzc3 = zzc2;
        Object zzb2 = zzx.zzb(zza3, (Object) "Cannot construct an Api with a null ClientBuilder");
        Object zzb3 = zzx.zzb(zzc3, (Object) "Cannot construct an Api with a null ClientKey");
        this.mName = str2;
        this.zzafW = zza3;
        this.zzaeE = zzc3;
        this.zzafY = null;
    }

    public String getName() {
        return this.mName;
    }

    public zza<?, O> zzoP() {
        zzx.zza(this.zzafW != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.zzafW;
    }

    public zze<?, O> zzoQ() {
        zzx.zza(this.zzafX != null, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return this.zzafX;
    }

    public zzc<?> zzoR() {
        zzx.zza(this.zzaeE != null, (Object) "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.zzaeE;
    }

    public boolean zzoS() {
        return this.zzafY != null;
    }
}
