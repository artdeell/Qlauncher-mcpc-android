package com.google.android.gms.internal;

import com.google.android.gms.internal.zzso;
import java.io.IOException;

public abstract class zzso<M extends zzso<M>> extends zzsu {
    protected zzsq zzbuj;

    public zzso() {
    }

    public void writeTo(zzsn zzsn) throws IOException {
        zzsn zzsn2 = zzsn;
        if (this.zzbuj != null) {
            for (int i = 0; i < this.zzbuj.size(); i++) {
                this.zzbuj.zzmG(i).writeTo(zzsn2);
            }
        }
    }

    /* renamed from: zzJp */
    public M clone() throws CloneNotSupportedException {
        zzso zzso = (zzso) super.clone();
        zzss.zza(this, zzso);
        return zzso;
    }

    public final <T> T zza(zzsp<M, T> zzsp) {
        zzsp<M, T> zzsp2 = zzsp;
        if (this.zzbuj != null) {
            zzsr zzmF = this.zzbuj.zzmF(zzsx.zzmJ(zzsp2.tag));
            if (zzmF != null) {
                return zzmF.zzb(zzsp2);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzsm zzsm, int i) throws IOException {
        zzsw zzsw;
        zzsr zzsr;
        zzsq zzsq;
        zzsm zzsm2 = zzsm;
        int i2 = i;
        int position = zzsm2.getPosition();
        if (!zzsm2.zzmo(i2)) {
            return false;
        }
        int zzmJ = zzsx.zzmJ(i2);
        zzsw zzsw2 = zzsw;
        zzsw zzsw3 = new zzsw(i2, zzsm2.zzz(position, zzsm2.getPosition() - position));
        zzsw zzsw4 = zzsw2;
        zzsr zzsr2 = null;
        if (this.zzbuj == null) {
            zzsq zzsq2 = zzsq;
            zzsq zzsq3 = new zzsq();
            this.zzbuj = zzsq2;
        } else {
            zzsr2 = this.zzbuj.zzmF(zzmJ);
        }
        if (zzsr2 == null) {
            zzsr zzsr3 = zzsr;
            zzsr zzsr4 = new zzsr();
            zzsr2 = zzsr3;
            this.zzbuj.zza(zzmJ, zzsr2);
        }
        zzsr2.zza(zzsw4);
        return true;
    }

    /* access modifiers changed from: protected */
    public int zzz() {
        int i;
        if (this.zzbuj != null) {
            i = 0;
            for (int i2 = 0; i2 < this.zzbuj.size(); i2++) {
                i += this.zzbuj.zzmG(i2).zzz();
            }
        } else {
            i = 0;
        }
        return i;
    }
}
