package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzo extends FrameLayout implements OnClickListener {
    private final ImageButton zzEW;
    private final zzs zzEX;

    public zzo(Context context, int i, zzs zzs) {
        ImageButton imageButton;
        LayoutParams layoutParams;
        Context context2 = context;
        int i2 = i;
        zzs zzs2 = zzs;
        super(context2);
        this.zzEX = zzs2;
        setOnClickListener(this);
        ImageButton imageButton2 = imageButton;
        ImageButton imageButton3 = new ImageButton(context2);
        this.zzEW = imageButton2;
        this.zzEW.setImageResource(17301527);
        this.zzEW.setBackgroundColor(0);
        this.zzEW.setOnClickListener(this);
        this.zzEW.setPadding(0, 0, 0, 0);
        this.zzEW.setContentDescription("Interstitial close button");
        int zzb = zzn.zzcS().zzb(context2, i2);
        ImageButton imageButton4 = this.zzEW;
        LayoutParams layoutParams2 = layoutParams;
        LayoutParams layoutParams3 = new LayoutParams(zzb, zzb, 17);
        addView(imageButton4, layoutParams2);
    }

    public void onClick(View view) {
        View view2 = view;
        if (this.zzEX != null) {
            this.zzEX.zzfm();
        }
    }

    public void zza(boolean z, boolean z2) {
        boolean z3 = z;
        if (!z2) {
            this.zzEW.setVisibility(0);
        } else if (z3) {
            this.zzEW.setVisibility(4);
        } else {
            this.zzEW.setVisibility(8);
        }
    }
}
