package com.google.ads.afma.nano;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzss;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public interface NanoAdshieldEvent {

    public static final class AdShieldEvent extends zzsu {
        private static volatile AdShieldEvent[] zzaK;
        public String appId;

        public AdShieldEvent() {
            AdShieldEvent clear = clear();
        }

        public static AdShieldEvent[] emptyArray() {
            if (zzaK == null) {
                Object obj = zzss.zzbut;
                synchronized (obj) {
                    try {
                        if (zzaK == null) {
                            zzaK = new AdShieldEvent[0];
                        }
                    } catch (Throwable th) {
                        while (true) {
                            Throwable th2 = th;
                            Object obj2 = obj;
                            throw th2;
                        }
                    }
                }
            }
            return zzaK;
        }

        public static AdShieldEvent parseFrom(zzsm zzsm) throws IOException {
            AdShieldEvent adShieldEvent;
            zzsm zzsm2 = zzsm;
            AdShieldEvent adShieldEvent2 = adShieldEvent;
            AdShieldEvent adShieldEvent3 = new AdShieldEvent();
            return adShieldEvent2.mergeFrom(zzsm2);
        }

        public static AdShieldEvent parseFrom(byte[] bArr) throws zzst {
            AdShieldEvent adShieldEvent;
            byte[] bArr2 = bArr;
            AdShieldEvent adShieldEvent2 = adShieldEvent;
            AdShieldEvent adShieldEvent3 = new AdShieldEvent();
            return (AdShieldEvent) zzsu.mergeFrom(adShieldEvent2, bArr2);
        }

        public AdShieldEvent clear() {
            this.appId = LibrariesRepository.MOJANG_MAVEN_REPO;
            this.zzbuu = -1;
            return this;
        }

        public AdShieldEvent mergeFrom(zzsm zzsm) throws IOException {
            zzsm zzsm2 = zzsm;
            while (true) {
                int zzIX = zzsm2.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.appId = zzsm2.readString();
                        continue;
                    default:
                        if (!zzsx.zzb(zzsm2, zzIX)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            zzsn zzsn2 = zzsn;
            if (!this.appId.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzsn2.zzn(1, this.appId);
            }
            super.writeTo(zzsn2);
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (!this.appId.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzz += zzsn.zzo(1, this.appId);
            }
            return zzz;
        }
    }
}
