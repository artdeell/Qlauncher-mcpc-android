package net.minecraft.kdt.mcfragments;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.minecraft.kdt.C0634R;

public class LauncherFragment extends Fragment {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        View onCreateView = super.onCreateView(layoutInflater2, viewGroup2, bundle);
        return layoutInflater2.inflate(C0634R.layout.lmaintab_news, viewGroup2, false);
    }

    public LauncherFragment() {
    }
}
