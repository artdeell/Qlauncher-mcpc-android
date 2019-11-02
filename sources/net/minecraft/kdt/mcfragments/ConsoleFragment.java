package net.minecraft.kdt.mcfragments;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.io.File;
import net.minecraft.kdt.C0634R;
import net.minecraft.kdt.FileAccess;

public class ConsoleFragment extends Fragment {
    public static String crashPath;
    private TextView crashView;

    static {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        crashPath = stringBuffer2.append(FileAccess.MAIN_PATH).append("/gamedir/crash").toString();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        View onCreateView = super.onCreateView(layoutInflater2, viewGroup2, bundle);
        return layoutInflater2.inflate(C0634R.layout.lmaintab_consolelog, viewGroup2, false);
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        File file;
        super.onActivityCreated(bundle);
        this.crashView = (TextView) getView().findViewById(C0634R.C0636id.lmaintabconsolelogCrashView);
        File file2 = file;
        File file3 = new File(crashPath);
        boolean mkdirs = file2.mkdirs();
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshContentCrash();
    }

    public void refreshContentCrash() {
        StringBuffer stringBuffer;
        File file;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        try {
            StringBuffer stringBuffer4 = stringBuffer;
            StringBuffer stringBuffer5 = new StringBuffer();
            File lastFileModified = FileAccess.lastFileModified(stringBuffer4.append(crashPath).append("-reports").toString());
            File file2 = file;
            StringBuffer stringBuffer6 = stringBuffer2;
            StringBuffer stringBuffer7 = new StringBuffer();
            StringBuffer stringBuffer8 = stringBuffer3;
            StringBuffer stringBuffer9 = new StringBuffer();
            File file3 = new File(stringBuffer6.append(stringBuffer8.append(crashPath).append("/").toString()).append(lastFileModified.getName()).toString());
            File file4 = file2;
            boolean renameTo = lastFileModified.renameTo(file4);
            this.crashView.setText(FileAccess.read(file4.getAbsolutePath()));
        } catch (Exception e) {
            Exception exc = e;
        }
    }

    public ConsoleFragment() {
    }
}
