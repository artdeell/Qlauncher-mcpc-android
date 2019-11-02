package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzhb;
import java.util.List;

@zzhb
class zzb extends RelativeLayout {
    private static final float[] zzxR = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private final RelativeLayout zzxS;
    private AnimationDrawable zzxT;

    public zzb(Context context, zza zza) {
        LayoutParams layoutParams;
        ShapeDrawable shapeDrawable;
        RoundRectShape roundRectShape;
        RelativeLayout relativeLayout;
        LayoutParams layoutParams2;
        ImageView imageView;
        AnimationDrawable animationDrawable;
        LayoutParams layoutParams3;
        TextView textView;
        Context context2 = context;
        zza zza2 = zza;
        super(context2);
        Object zzz = zzx.zzz(zza2);
        LayoutParams layoutParams4 = layoutParams;
        LayoutParams layoutParams5 = new LayoutParams(-2, -2);
        LayoutParams layoutParams6 = layoutParams4;
        layoutParams6.addRule(10);
        layoutParams6.addRule(11);
        ShapeDrawable shapeDrawable2 = shapeDrawable;
        RoundRectShape roundRectShape2 = roundRectShape;
        RoundRectShape roundRectShape3 = new RoundRectShape(zzxR, null, null);
        ShapeDrawable shapeDrawable3 = new ShapeDrawable(roundRectShape2);
        ShapeDrawable shapeDrawable4 = shapeDrawable2;
        shapeDrawable4.getPaint().setColor(zza2.getBackgroundColor());
        RelativeLayout relativeLayout2 = relativeLayout;
        RelativeLayout relativeLayout3 = new RelativeLayout(context2);
        this.zzxS = relativeLayout2;
        this.zzxS.setLayoutParams(layoutParams6);
        zzr.zzbE().zza((View) this.zzxS, (Drawable) shapeDrawable4);
        LayoutParams layoutParams7 = layoutParams2;
        LayoutParams layoutParams8 = new LayoutParams(-2, -2);
        LayoutParams layoutParams9 = layoutParams7;
        if (!TextUtils.isEmpty(zza2.getText())) {
            LayoutParams layoutParams10 = layoutParams3;
            LayoutParams layoutParams11 = new LayoutParams(-2, -2);
            LayoutParams layoutParams12 = layoutParams10;
            TextView textView2 = textView;
            TextView textView3 = new TextView(context2);
            TextView textView4 = textView2;
            textView4.setLayoutParams(layoutParams12);
            textView4.setId(1195835393);
            textView4.setTypeface(Typeface.DEFAULT);
            textView4.setText(zza2.getText());
            textView4.setTextColor(zza2.getTextColor());
            textView4.setTextSize((float) zza2.getTextSize());
            textView4.setPadding(zzn.zzcS().zzb(context2, 4), 0, zzn.zzcS().zzb(context2, 4), 0);
            this.zzxS.addView(textView4);
            layoutParams9.addRule(1, textView4.getId());
        }
        ImageView imageView2 = imageView;
        ImageView imageView3 = new ImageView(context2);
        ImageView imageView4 = imageView2;
        imageView4.setLayoutParams(layoutParams9);
        imageView4.setId(1195835394);
        List<Drawable> zzdG = zza2.zzdG();
        if (zzdG.size() > 1) {
            AnimationDrawable animationDrawable2 = animationDrawable;
            AnimationDrawable animationDrawable3 = new AnimationDrawable();
            this.zzxT = animationDrawable2;
            for (Drawable addFrame : zzdG) {
                this.zzxT.addFrame(addFrame, zza2.zzdH());
            }
            zzr.zzbE().zza((View) imageView4, (Drawable) this.zzxT);
        } else if (zzdG.size() == 1) {
            imageView4.setImageDrawable((Drawable) zzdG.get(0));
        }
        this.zzxS.addView(imageView4);
        addView(this.zzxS);
    }

    public void onAttachedToWindow() {
        if (this.zzxT != null) {
            this.zzxT.start();
        }
        super.onAttachedToWindow();
    }

    public ViewGroup zzdI() {
        return this.zzxS;
    }
}
