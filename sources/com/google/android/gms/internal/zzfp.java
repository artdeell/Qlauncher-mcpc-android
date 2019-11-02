package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C0157R;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

@zzhb
public class zzfp extends zzfs {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Map<String, String> zzxA;

    public zzfp(zzjp zzjp, Map<String, String> map) {
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        super(zzjp2, "storePicture");
        this.zzxA = map2;
        this.mContext = zzjp2.zzhP();
    }

    public void execute() {
        C03711 r11;
        C03722 r112;
        StringBuilder sb;
        StringBuilder sb2;
        if (this.mContext == null) {
            zzam("Activity context is not available");
        } else if (!zzr.zzbC().zzM(this.mContext).zzdl()) {
            zzam("Feature is not supported by the device.");
        } else {
            String str = (String) this.zzxA.get("iurl");
            if (TextUtils.isEmpty(str)) {
                zzam("Image url cannot be empty.");
            } else if (!URLUtil.isValidUrl(str)) {
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                zzam(sb3.append("Invalid image url: ").append(str).toString());
            } else {
                String zzal = zzal(str);
                if (!zzr.zzbC().zzaE(zzal)) {
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    zzam(sb5.append("Image type not recognized: ").append(zzal).toString());
                    return;
                }
                Builder zzL = zzr.zzbC().zzL(this.mContext);
                Builder title = zzL.setTitle(zzr.zzbF().zzd(C0157R.string.store_picture_title, "Save image"));
                Builder message = zzL.setMessage(zzr.zzbF().zzd(C0157R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                Builder builder = zzL;
                String zzd = zzr.zzbF().zzd(C0157R.string.accept, "Accept");
                C03711 r6 = r11;
                final String str2 = str;
                final String str3 = zzal;
                C03711 r7 = new OnClickListener(this) {
                    final /* synthetic */ zzfp zzDt;

                    {
                        String str = r8;
                        String str2 = r9;
                        this.zzDt = r7;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        DialogInterface dialogInterface2 = dialogInterface;
                        int i2 = i;
                        try {
                            long enqueue = ((DownloadManager) this.zzDt.mContext.getSystemService("download")).enqueue(this.zzDt.zzf(str2, str3));
                        } catch (IllegalStateException e) {
                            IllegalStateException illegalStateException = e;
                            this.zzDt.zzam("Could not store picture.");
                        }
                    }
                };
                Builder positiveButton = builder.setPositiveButton(zzd, r6);
                Builder builder2 = zzL;
                String zzd2 = zzr.zzbF().zzd(C0157R.string.decline, "Decline");
                C03722 r62 = r112;
                C03722 r72 = new OnClickListener(this) {
                    final /* synthetic */ zzfp zzDt;

                    {
                        this.zzDt = r5;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        DialogInterface dialogInterface2 = dialogInterface;
                        int i2 = i;
                        this.zzDt.zzam("User canceled the download.");
                    }
                };
                Builder negativeButton = builder2.setNegativeButton(zzd2, r62);
                zzL.create().show();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public String zzal(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    /* access modifiers changed from: 0000 */
    public Request zzf(String str, String str2) {
        Request request;
        String str3 = str2;
        Request request2 = request;
        Request request3 = new Request(Uri.parse(str));
        Request request4 = request2;
        Request destinationInExternalPublicDir = request4.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str3);
        boolean zza = zzr.zzbE().zza(request4);
        return request4;
    }
}
