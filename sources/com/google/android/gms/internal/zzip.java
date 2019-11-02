package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.concurrent.Future;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@zzhb
public final class zzip {

    private static abstract class zza extends zzim {
        private zza() {
        }

        /* synthetic */ zza(C04031 r4) {
            C04031 r1 = r4;
            this();
        }

        public void onStop() {
        }
    }

    public interface zzb {
        void zze(Bundle bundle);
    }

    public static Future zza(Context context, int i) {
        C04053 r6;
        C04053 r2 = r6;
        final Context context2 = context;
        final int i2 = i;
        C04053 r3 = new zza() {
            {
                int i = r7;
            }

            public void zzbr() {
                Editor edit = zzip.zzw(context2).edit();
                Editor putInt = edit.putInt("webview_cache_version", i2);
                edit.apply();
            }
        };
        return r2.zzgd();
    }

    public static Future zza(Context context, zzb zzb2) {
        C04042 r6;
        C04042 r2 = r6;
        final Context context2 = context;
        final zzb zzb3 = zzb2;
        C04042 r3 = new zza() {
            {
                zzb zzb = r7;
            }

            public void zzbr() {
                Bundle bundle;
                SharedPreferences zzw = zzip.zzw(context2);
                Bundle bundle2 = bundle;
                Bundle bundle3 = new Bundle();
                Bundle bundle4 = bundle2;
                bundle4.putBoolean("use_https", zzw.getBoolean("use_https", true));
                if (zzb3 != null) {
                    zzb3.zze(bundle4);
                }
            }
        };
        return r2.zzgd();
    }

    public static Future zza(Context context, boolean z) {
        C04031 r6;
        C04031 r2 = r6;
        final Context context2 = context;
        final boolean z2 = z;
        C04031 r3 = new zza() {
            {
                boolean z = r7;
            }

            public void zzbr() {
                Editor edit = zzip.zzw(context2).edit();
                Editor putBoolean = edit.putBoolean("use_https", z2);
                edit.apply();
            }
        };
        return r2.zzgd();
    }

    public static Future zzb(Context context, zzb zzb2) {
        C04064 r6;
        C04064 r2 = r6;
        final Context context2 = context;
        final zzb zzb3 = zzb2;
        C04064 r3 = new zza() {
            {
                zzb zzb = r7;
            }

            public void zzbr() {
                Bundle bundle;
                SharedPreferences zzw = zzip.zzw(context2);
                Bundle bundle2 = bundle;
                Bundle bundle3 = new Bundle();
                Bundle bundle4 = bundle2;
                bundle4.putInt("webview_cache_version", zzw.getInt("webview_cache_version", 0));
                if (zzb3 != null) {
                    zzb3.zze(bundle4);
                }
            }
        };
        return r2.zzgd();
    }

    public static Future zzb(Context context, boolean z) {
        C04075 r6;
        C04075 r2 = r6;
        final Context context2 = context;
        final boolean z2 = z;
        C04075 r3 = new zza() {
            {
                boolean z = r7;
            }

            public void zzbr() {
                Editor edit = zzip.zzw(context2).edit();
                Editor putBoolean = edit.putBoolean("content_url_opted_out", z2);
                edit.apply();
            }
        };
        return r2.zzgd();
    }

    public static Future zzc(Context context, zzb zzb2) {
        C04086 r6;
        C04086 r2 = r6;
        final Context context2 = context;
        final zzb zzb3 = zzb2;
        C04086 r3 = new zza() {
            {
                zzb zzb = r7;
            }

            public void zzbr() {
                Bundle bundle;
                SharedPreferences zzw = zzip.zzw(context2);
                Bundle bundle2 = bundle;
                Bundle bundle3 = new Bundle();
                Bundle bundle4 = bundle2;
                bundle4.putBoolean("content_url_opted_out", zzw.getBoolean("content_url_opted_out", true));
                if (zzb3 != null) {
                    zzb3.zze(bundle4);
                }
            }
        };
        return r2.zzgd();
    }

    public static Future zzd(Context context, zzb zzb2) {
        C04108 r6;
        C04108 r2 = r6;
        final Context context2 = context;
        final zzb zzb3 = zzb2;
        C04108 r3 = new zza() {
            {
                zzb zzb = r7;
            }

            public void zzbr() {
                Bundle bundle;
                SharedPreferences zzw = zzip.zzw(context2);
                Bundle bundle2 = bundle;
                Bundle bundle3 = new Bundle();
                Bundle bundle4 = bundle2;
                bundle4.putString("content_url_hashes", zzw.getString("content_url_hashes", LibrariesRepository.MOJANG_MAVEN_REPO));
                if (zzb3 != null) {
                    zzb3.zze(bundle4);
                }
            }
        };
        return r2.zzgd();
    }

    public static Future zzd(Context context, String str) {
        C04097 r6;
        C04097 r2 = r6;
        final Context context2 = context;
        final String str2 = str;
        C04097 r3 = new zza() {
            {
                String str = r7;
            }

            public void zzbr() {
                Editor edit = zzip.zzw(context2).edit();
                Editor putString = edit.putString("content_url_hashes", str2);
                edit.apply();
            }
        };
        return r2.zzgd();
    }

    public static SharedPreferences zzw(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
