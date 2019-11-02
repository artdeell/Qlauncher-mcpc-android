package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.zzc.zza;

public final class zzh extends zza {
    private Fragment zzalg;

    private zzh(Fragment fragment) {
        this.zzalg = fragment;
    }

    public static zzh zza(Fragment fragment) {
        zzh zzh;
        Fragment fragment2 = fragment;
        if (fragment2 == null) {
            return null;
        }
        zzh zzh2 = zzh;
        zzh zzh3 = new zzh(fragment2);
        return zzh2;
    }

    public Bundle getArguments() {
        return this.zzalg.getArguments();
    }

    public int getId() {
        return this.zzalg.getId();
    }

    public boolean getRetainInstance() {
        return this.zzalg.getRetainInstance();
    }

    public String getTag() {
        return this.zzalg.getTag();
    }

    public int getTargetRequestCode() {
        return this.zzalg.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.zzalg.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzC(this.zzalg.getView());
    }

    public boolean isAdded() {
        return this.zzalg.isAdded();
    }

    public boolean isDetached() {
        return this.zzalg.isDetached();
    }

    public boolean isHidden() {
        return this.zzalg.isHidden();
    }

    public boolean isInLayout() {
        return this.zzalg.isInLayout();
    }

    public boolean isRemoving() {
        return this.zzalg.isRemoving();
    }

    public boolean isResumed() {
        return this.zzalg.isResumed();
    }

    public boolean isVisible() {
        return this.zzalg.isVisible();
    }

    public void setHasOptionsMenu(boolean z) {
        boolean z2 = z;
        this.zzalg.setHasOptionsMenu(z2);
    }

    public void setMenuVisibility(boolean z) {
        boolean z2 = z;
        this.zzalg.setMenuVisibility(z2);
    }

    public void setRetainInstance(boolean z) {
        boolean z2 = z;
        this.zzalg.setRetainInstance(z2);
    }

    public void setUserVisibleHint(boolean z) {
        boolean z2 = z;
        this.zzalg.setUserVisibleHint(z2);
    }

    public void startActivity(Intent intent) {
        Intent intent2 = intent;
        this.zzalg.startActivity(intent2);
    }

    public void startActivityForResult(Intent intent, int i) {
        Intent intent2 = intent;
        int i2 = i;
        this.zzalg.startActivityForResult(intent2, i2);
    }

    public void zzn(zzd zzd) {
        View view = (View) zze.zzp(zzd);
        this.zzalg.registerForContextMenu(view);
    }

    public void zzo(zzd zzd) {
        View view = (View) zze.zzp(zzd);
        this.zzalg.unregisterForContextMenu(view);
    }

    public zzd zztV() {
        return zze.zzC(this.zzalg.getActivity());
    }

    public zzc zztW() {
        return zza(this.zzalg.getParentFragment());
    }

    public zzd zztX() {
        return zze.zzC(this.zzalg.getResources());
    }

    public zzc zztY() {
        return zza(this.zzalg.getTargetFragment());
    }
}
