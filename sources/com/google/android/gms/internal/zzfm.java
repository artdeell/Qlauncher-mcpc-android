package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.C0157R;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@zzhb
public class zzfm extends zzfs {
    /* access modifiers changed from: private */
    public final Context mContext;
    private String zzCU;
    private long zzCV;
    private long zzCW;
    private String zzCX;
    private String zzCY;
    private final Map<String, String> zzxA;

    public zzfm(zzjp zzjp, Map<String, String> map) {
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        super(zzjp2, "createCalendarEvent");
        this.zzxA = map2;
        this.mContext = zzjp2.zzhP();
        zzeK();
    }

    private String zzaj(String str) {
        String str2 = str;
        return TextUtils.isEmpty((CharSequence) this.zzxA.get(str2)) ? LibrariesRepository.MOJANG_MAVEN_REPO : (String) this.zzxA.get(str2);
    }

    private long zzak(String str) {
        String str2 = str;
        String str3 = (String) this.zzxA.get(str2);
        if (str3 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str3);
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = e;
            return -1;
        }
    }

    private void zzeK() {
        this.zzCU = zzaj("description");
        this.zzCX = zzaj("summary");
        this.zzCV = zzak("start_ticks");
        this.zzCW = zzak("end_ticks");
        this.zzCY = zzaj("location");
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(14)
    public Intent createIntent() {
        Intent intent;
        Intent intent2 = intent;
        Intent intent3 = new Intent("android.intent.action.EDIT");
        Intent data = intent2.setData(Events.CONTENT_URI);
        Intent putExtra = data.putExtra("title", this.zzCU);
        Intent putExtra2 = data.putExtra("eventLocation", this.zzCY);
        Intent putExtra3 = data.putExtra("description", this.zzCX);
        if (this.zzCV > -1) {
            Intent putExtra4 = data.putExtra("beginTime", this.zzCV);
        }
        if (this.zzCW > -1) {
            Intent putExtra5 = data.putExtra("endTime", this.zzCW);
        }
        Intent flags = data.setFlags(268435456);
        return data;
    }

    public void execute() {
        C03681 r7;
        C03692 r72;
        if (this.mContext == null) {
            zzam("Activity context is not available.");
        } else if (!zzr.zzbC().zzM(this.mContext).zzdo()) {
            zzam("This feature is not available on the device.");
        } else {
            Builder zzL = zzr.zzbC().zzL(this.mContext);
            Builder title = zzL.setTitle(zzr.zzbF().zzd(C0157R.string.create_calendar_title, "Create calendar event"));
            Builder message = zzL.setMessage(zzr.zzbF().zzd(C0157R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            Builder builder = zzL;
            String zzd = zzr.zzbF().zzd(C0157R.string.accept, "Accept");
            C03681 r4 = r7;
            C03681 r5 = new OnClickListener(this) {
                final /* synthetic */ zzfm zzCZ;

                {
                    this.zzCZ = r5;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    DialogInterface dialogInterface2 = dialogInterface;
                    int i2 = i;
                    zzr.zzbC().zzb(this.zzCZ.mContext, this.zzCZ.createIntent());
                }
            };
            Builder positiveButton = builder.setPositiveButton(zzd, r4);
            Builder builder2 = zzL;
            String zzd2 = zzr.zzbF().zzd(C0157R.string.decline, "Decline");
            C03692 r42 = r72;
            C03692 r52 = new OnClickListener(this) {
                final /* synthetic */ zzfm zzCZ;

                {
                    this.zzCZ = r5;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    DialogInterface dialogInterface2 = dialogInterface;
                    int i2 = i;
                    this.zzCZ.zzam("Operation denied by user.");
                }
            };
            Builder negativeButton = builder2.setNegativeButton(zzd2, r42);
            zzL.create().show();
        }
    }
}
