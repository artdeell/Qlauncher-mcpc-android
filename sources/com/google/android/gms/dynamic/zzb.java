package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.zzc.zza;

@SuppressLint({"NewApi"})
public final class zzb extends zza {
    private Fragment zzavH;

    private zzb(Fragment fragment) {
        this.zzavH = fragment;
    }

    public static zzb zza(Fragment fragment) {
        zzb zzb;
        Fragment fragment2 = fragment;
        if (fragment2 == null) {
            return null;
        }
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb(fragment2);
        return zzb2;
    }

    public Bundle getArguments() {
        return this.zzavH.getArguments();
    }

    public int getId() {
        return this.zzavH.getId();
    }

    public boolean getRetainInstance() {
        return this.zzavH.getRetainInstance();
    }

    public String getTag() {
        return this.zzavH.getTag();
    }

    public int getTargetRequestCode() {
        return this.zzavH.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.zzavH.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzC(this.zzavH.getView());
    }

    public boolean isAdded() {
        return this.zzavH.isAdded();
    }

    public boolean isDetached() {
        return this.zzavH.isDetached();
    }

    public boolean isHidden() {
        return this.zzavH.isHidden();
    }

    public boolean isInLayout() {
        return this.zzavH.isInLayout();
    }

    public boolean isRemoving() {
        return this.zzavH.isRemoving();
    }

    public boolean isResumed() {
        return this.zzavH.isResumed();
    }

    public boolean isVisible() {
        return this.zzavH.isVisible();
    }

    public void setHasOptionsMenu(boolean z) {
        boolean z2 = z;
        this.zzavH.setHasOptionsMenu(z2);
    }

    public void setMenuVisibility(boolean z) {
        boolean z2 = z;
        this.zzavH.setMenuVisibility(z2);
    }

    public void setRetainInstance(boolean z) {
        boolean z2 = z;
        this.zzavH.setRetainInstance(z2);
    }

    public void setUserVisibleHint(boolean z) {
        boolean z2 = z;
        this.zzavH.setUserVisibleHint(z2);
    }

    public void startActivity(Intent intent) {
        Intent intent2 = intent;
        this.zzavH.startActivity(intent2);
    }

    public void startActivityForResult(Intent intent, int i) {
        Intent intent2 = intent;
        int i2 = i;
        this.zzavH.startActivityForResult(intent2, i2);
    }

    public void zzn(zzd zzd) {
        View view = (View) zze.zzp(zzd);
        this.zzavH.registerForContextMenu(view);
    }

    public void zzo(zzd zzd) {
        View view = (View) zze.zzp(zzd);
        this.zzavH.unregisterForContextMenu(view);
    }

    public zzd zztV() {
        return zze.zzC(this.zzavH.getActivity());
    }

    public zzc zztW() {
        return zza(this.zzavH.getParentFragment());
    }

    public zzd zztX() {
        return zze.zzC(this.zzavH.getResources());
    }

    public zzc zztY() {
        return zza(this.zzavH.getTargetFragment());
    }
}
