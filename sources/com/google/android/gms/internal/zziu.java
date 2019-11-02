package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

@zzhb
public class zziu {
    /* access modifiers changed from: private */
    public final Context mContext;
    private int mState;
    private final float zzDB;
    private String zzMh;
    private float zzMi;
    private float zzMj;
    private float zzMk;

    public zziu(Context context) {
        Context context2 = context;
        this.mState = 0;
        this.mContext = context2;
        this.zzDB = context2.getResources().getDisplayMetrics().density;
    }

    public zziu(Context context, String str) {
        String str2 = str;
        this(context);
        this.zzMh = str2;
    }

    private void showDialog() {
        Builder builder;
        C04191 r9;
        C04202 r92;
        if (!(this.mContext instanceof Activity)) {
            zzin.zzaJ("Can not create dialog without Activity Context");
            return;
        }
        String zzaG = zzaG(this.zzMh);
        Builder builder2 = builder;
        Builder builder3 = new Builder(this.mContext);
        Builder builder4 = builder2;
        Builder message = builder4.setMessage(zzaG);
        Builder title = builder4.setTitle("Ad Information");
        C04191 r5 = r9;
        final String str = zzaG;
        C04191 r6 = new OnClickListener(this) {
            final /* synthetic */ zziu zzMm;

            {
                String str = r7;
                this.zzMm = r6;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent;
                DialogInterface dialogInterface2 = dialogInterface;
                int i2 = i;
                zzir zzbC = zzr.zzbC();
                Context zza = this.zzMm.mContext;
                Intent intent2 = intent;
                Intent intent3 = new Intent("android.intent.action.SEND");
                zzbC.zzb(zza, Intent.createChooser(intent2.setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
            }
        };
        Builder positiveButton = builder4.setPositiveButton("Share", r5);
        C04202 r52 = r92;
        C04202 r62 = new OnClickListener(this) {
            final /* synthetic */ zziu zzMm;

            {
                this.zzMm = r5;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        };
        Builder negativeButton = builder4.setNegativeButton("Close", r52);
        builder4.create().show();
    }

    static String zzaG(String str) {
        Uri.Builder builder;
        StringBuilder sb;
        String trim;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            trim = "No debug information";
        } else {
            String replaceAll = str2.replaceAll("\\+", "%20");
            Uri.Builder builder2 = builder;
            Uri.Builder builder3 = new Uri.Builder();
            Uri build = builder2.encodedQuery(replaceAll).build();
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = sb2;
            Map zze = zzr.zzbC().zze(build);
            for (String str3 : zze.keySet()) {
                StringBuilder append = sb4.append(str3).append(" = ").append((String) zze.get(str3)).append("\n\n");
            }
            trim = sb4.toString().trim();
            if (TextUtils.isEmpty(trim)) {
                return "No debug information";
            }
        }
        return trim;
    }

    /* access modifiers changed from: 0000 */
    public void zza(int i, float f, float f2) {
        int i2 = i;
        float f3 = f;
        float f4 = f2;
        if (i2 == 0) {
            this.mState = 0;
            this.zzMi = f3;
            this.zzMj = f4;
            this.zzMk = f4;
        } else if (this.mState == -1) {
        } else {
            if (i2 == 2) {
                if (f4 > this.zzMj) {
                    this.zzMj = f4;
                } else if (f4 < this.zzMk) {
                    this.zzMk = f4;
                }
                if (this.zzMj - this.zzMk > 30.0f * this.zzDB) {
                    this.mState = -1;
                    return;
                }
                if (this.mState == 0 || this.mState == 2) {
                    if (f3 - this.zzMi >= 50.0f * this.zzDB) {
                        this.zzMi = f3;
                        this.mState = 1 + this.mState;
                    }
                } else if ((this.mState == 1 || this.mState == 3) && f3 - this.zzMi <= -50.0f * this.zzDB) {
                    this.zzMi = f3;
                    this.mState = 1 + this.mState;
                }
                if (this.mState == 1 || this.mState == 3) {
                    if (f3 > this.zzMi) {
                        this.zzMi = f3;
                    }
                } else if (this.mState == 2 && f3 < this.zzMi) {
                    this.zzMi = f3;
                }
            } else if (i2 == 1 && this.mState == 4) {
                showDialog();
            }
        }
    }

    public void zzaF(String str) {
        String str2 = str;
        this.zzMh = str2;
    }

    public void zze(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int historySize = motionEvent2.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent2.getActionMasked(), motionEvent2.getHistoricalX(0, i), motionEvent2.getHistoricalY(0, i));
        }
        zza(motionEvent2.getActionMasked(), motionEvent2.getX(), motionEvent2.getY());
    }
}
