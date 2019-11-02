package net.minecraft.kdt;

import adrt.ADRTLogCatReader;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentTabHost;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.kdtmarken.filerapi.FileListView;
import com.kdtmarken.filermod.MFileListView;
import com.kdtmarken.filermod.MFileSelectedListener;
import java.io.File;
import net.minecraft.kdt.MCProfile.Builder;
import net.minecraft.kdt.mcfragments.ConsoleFragment;

public class MCLauncherActivity extends FragmentActivity {
    private String[] availableVersions = MCClassPath.versionList;
    private FragmentTabHost mTabHost;
    /* access modifiers changed from: private */
    public Builder profile;
    private String profilePath;
    private TextView tvNicknameView;
    /* access modifiers changed from: private */
    public TextView tvVersion;
    private Spinner versionSelector;

    /* access modifiers changed from: protected */
    @Override
    public void onCreate(Bundle bundle) {
        NoClassDefFoundError noClassDefFoundError;
        NoClassDefFoundError noClassDefFoundError2;
        ArrayAdapter arrayAdapter;
        AnonymousClass100000000 r13;
        Bundle bundle2 = bundle;
        ADRTLogCatReader.onContext(this, "com.aide.ui");
        super.onCreate(bundle2);
        setContentView(C0634R.layout.launcher_main);
        this.mTabHost = (FragmentTabHost) findViewById(16908306);
        this.mTabHost.setup(this, getSupportFragmentManager(), C0634R.C0636id.realtabcontent);
        try {
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tab1").setIndicator("Launcher News"), Class.forName("net.minecraft.kdt.mcfragments.LauncherFragment"), null);
            try {
                this.mTabHost.addTab(this.mTabHost.newTabSpec("tab2").setIndicator("Crash log"), Class.forName("net.minecraft.kdt.mcfragments.ConsoleFragment"), null);
                this.tvNicknameView = (TextView) findId(C0634R.C0636id.launcherMainNicknameView);
                this.tvVersion = (TextView) findId(C0634R.C0636id.launcherMainVersionView);
                try {
                    this.profilePath = getIntent().getExtras().getString("POFfilepath");
                    this.profile = MCProfile.load(this.profilePath);
                    this.tvNicknameView.setText(this.profile.getNickname());
                } catch (Exception e) {
                    MCClassPath.throwError(this, e);
                }
                ArrayAdapter arrayAdapter2 = arrayAdapter;
                ArrayAdapter arrayAdapter3 = new ArrayAdapter(this, 17367048, this.availableVersions);
                ArrayAdapter arrayAdapter4 = arrayAdapter2;
                arrayAdapter4.setDropDownViewResource(17367055);
                this.versionSelector = (Spinner) findId(C0634R.C0636id.launchermainSelectVersion);
                this.versionSelector.setAdapter(arrayAdapter4);
                this.versionSelector.setSelection(selectAt(this.availableVersions, this.profile.getVersion()));
                Spinner spinner = this.versionSelector;
                AnonymousClass100000000 r8 = r13;
                AnonymousClass100000000 r9 = new OnItemSelectedListener(this) {
                    private final MCLauncherActivity this$0;

                    {
                        this.this$0 = r6;
                    }

                    static MCLauncherActivity access$0(AnonymousClass100000000 r4) {
                        return r4.this$0;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        StringBuffer stringBuffer;
                        View view2 = view;
                        long j2 = j;
                        String obj = adapterView.getItemAtPosition(i).toString();
                        this.this$0.profile.setVersion(obj);
                        String build = MCProfile.build(this.this$0.profile);
                        TextView access$L1000001 = this.this$0.tvVersion;
                        StringBuffer stringBuffer2 = stringBuffer;
                        StringBuffer stringBuffer3 = new StringBuffer();
                        access$L1000001.setText(stringBuffer2.append("Ready to play Minecraft ").append(obj).toString());
                    }
                };
                spinner.setOnItemSelectedListener(r8);
            } catch (ClassNotFoundException e2) {
                ClassNotFoundException classNotFoundException = e2;
                NoClassDefFoundError noClassDefFoundError3 = noClassDefFoundError2;
                NoClassDefFoundError noClassDefFoundError4 = new NoClassDefFoundError(classNotFoundException.getMessage());
                throw noClassDefFoundError3;
            }
        } catch (ClassNotFoundException e3) {
            ClassNotFoundException classNotFoundException2 = e3;
            NoClassDefFoundError noClassDefFoundError5 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError6 = new NoClassDefFoundError(classNotFoundException2.getMessage());
            throw noClassDefFoundError5;
        }
    }

    public void mcaccSwitchUser(View view) {
        View view2 = view;
        setResult(UserStatus.SWITCH_USER);
        finish();
    }

    public void mcaccLogout(View view) {
        View view2 = view;
        finish();
    }

    private void showProfileInfo() {
        AlertDialog.Builder builder;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        StringBuffer stringBuffer4;
        StringBuffer stringBuffer5;
        StringBuffer stringBuffer6;
        StringBuffer stringBuffer7;
        StringBuffer stringBuffer8;
        StringBuffer stringBuffer9;
        StringBuffer stringBuffer10;
        StringBuffer stringBuffer11;
        StringBuffer stringBuffer12;
        StringBuffer stringBuffer13;
        AlertDialog.Builder builder2 = builder;
        AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
        AlertDialog.Builder title = builder2.setTitle("Info player");
        StringBuffer stringBuffer14 = stringBuffer;
        StringBuffer stringBuffer15 = new StringBuffer();
        StringBuffer stringBuffer16 = stringBuffer2;
        StringBuffer stringBuffer17 = new StringBuffer();
        StringBuffer stringBuffer18 = stringBuffer3;
        StringBuffer stringBuffer19 = new StringBuffer();
        StringBuffer stringBuffer20 = stringBuffer4;
        StringBuffer stringBuffer21 = new StringBuffer();
        StringBuffer stringBuffer22 = stringBuffer5;
        StringBuffer stringBuffer23 = new StringBuffer();
        StringBuffer stringBuffer24 = stringBuffer6;
        StringBuffer stringBuffer25 = new StringBuffer();
        StringBuffer stringBuffer26 = stringBuffer7;
        StringBuffer stringBuffer27 = new StringBuffer();
        StringBuffer stringBuffer28 = stringBuffer8;
        StringBuffer stringBuffer29 = new StringBuffer();
        StringBuffer stringBuffer30 = stringBuffer9;
        StringBuffer stringBuffer31 = new StringBuffer();
        StringBuffer stringBuffer32 = stringBuffer10;
        StringBuffer stringBuffer33 = new StringBuffer();
        StringBuffer stringBuffer34 = stringBuffer11;
        StringBuffer stringBuffer35 = new StringBuffer();
        StringBuffer stringBuffer36 = stringBuffer12;
        StringBuffer stringBuffer37 = new StringBuffer();
        StringBuffer stringBuffer38 = stringBuffer13;
        StringBuffer stringBuffer39 = new StringBuffer();
        AlertDialog show = title.setMessage(stringBuffer14.append(stringBuffer16.append(stringBuffer18.append(stringBuffer20.append(stringBuffer22.append(stringBuffer24.append(stringBuffer26.append(stringBuffer28.append(stringBuffer30.append(stringBuffer32.append(stringBuffer34.append(stringBuffer36.append(stringBuffer38.append("AccessToken=").append(this.profile.getAccessToken()).toString()).append("\n").toString()).append("ClientID=").toString()).append(this.profile.getClientID()).toString()).append("\n").toString()).append("ProfileID=").toString()).append(this.profile.getProfileID()).toString()).append("\n").toString()).append("Nickname=").toString()).append(this.profile.getNickname()).toString()).append("\n").toString()).append("Version=").toString()).append(this.profile.getVersion()).toString()).show();
    }

    /* access modifiers changed from: protected */
    @Override
    public void onResumeFragments() {
        StringBuffer stringBuffer;
        Exception exc;
        super.onResumeFragments();
        try {
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            if (FileAccess.lastFileModified(stringBuffer2.append(ConsoleFragment.crashPath).append("-reports").toString()).exists()) {
                this.mTabHost.setCurrentTabByTag("tab2");
                return;
            }
            Exception exc2 = exc;
            Exception exc3 = new Exception();
            throw exc2;
        } catch (Exception e) {
            Exception exc4 = e;
        }
    }

    public int selectAt(String[] strArr, String str) {
        String str2 = str;
        int i = 0;
        String[] strArr2 = strArr;
        for (int i2 = 0; i2 < strArr2.length; i2++) {
            if (strArr2[i2].equals(str2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    @Override
    public void onResume() {
        super.onResume();
    }

    public void launchGame(View view) {
        NoClassDefFoundError noClassDefFoundError;
        View view2 = view;
        Intent intent = r7;
        Intent intent2 = intent;
        r7 = intent;
        try {
            Intent intent3 = new Intent(this, Class.forName("net.minecraft.kdt.MainActivity"));
            Intent intent4 = intent2;
            Intent putExtra = intent4.putExtra("POFfilepath", this.profilePath);
            startActivity(intent4);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError(classNotFoundException.getMessage());
            throw noClassDefFoundError2;
        }
    }

    public <T> T findId(int i) {
        return findViewById(i);
    }

    public void modManager(View view) {
        AlertDialog.Builder builder;
        MFileListView mFileListView;
        StringBuffer stringBuffer;
        AnonymousClass100000001 r11;
        View view2 = view;
        AlertDialog.Builder builder2 = builder;
        AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
        AlertDialog.Builder builder4 = builder2;
        AlertDialog.Builder title = builder4.setTitle("Mods manager (Forge)");
        AlertDialog.Builder positiveButton = builder4.setPositiveButton(17039360, null);
        AlertDialog create = builder4.create();
        MFileListView mFileListView2 = mFileListView;
        MFileListView mFileListView3 = new MFileListView((Context) this, create);
        MFileListView mFileListView4 = mFileListView2;
        MFileListView mFileListView5 = mFileListView4;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        mFileListView5.listFileAt(stringBuffer2.append(MCClassPath.mainpath).append("/ModsManager").toString());
        MFileListView mFileListView6 = mFileListView4;
        AnonymousClass100000001 r8 = r11;
        AnonymousClass100000001 r9 = new MFileSelectedListener(this) {
            private final MCLauncherActivity this$0;

            {
                this.this$0 = r6;
            }

            static MCLauncherActivity access$0(AnonymousClass100000001 r4) {
                return r4.this$0;
            }

            @Override
            public void onFileLongClick(File file, String str, String str2, String str3) {
            }

            @Override
            public void onFileSelected(File file, String str, String str2, String str3) {
                File file2 = file;
                String str4 = str;
                String str5 = str2;
                if (!str3.equals(".jar")) {
                    this.this$0.openSelect();
                }
            }
        };
        mFileListView6.setFileSelectedListener(r8);
        create.setView(mFileListView4);
        create.show();
    }

    public void openSelect() {
        AlertDialog.Builder builder;
        FileListView fileListView;
        AlertDialog.Builder builder2 = builder;
        AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
        AlertDialog.Builder builder4 = builder2;
        AlertDialog.Builder title = builder4.setTitle("Select a mod to add");
        AlertDialog.Builder positiveButton = builder4.setPositiveButton(17039360, null);
        AlertDialog create = builder4.create();
        FileListView fileListView2 = fileListView;
        FileListView fileListView3 = new FileListView(this);
        create.setView(fileListView2);
        create.show();
    }

    public MCLauncherActivity() {
    }
}
