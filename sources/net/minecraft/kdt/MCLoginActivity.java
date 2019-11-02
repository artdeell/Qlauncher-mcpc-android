package net.minecraft.kdt;

import adrt.ADRTLogCatReader;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.app.ActivityCompat;
import android.support.p000v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.kdtmarken.filermod.MFileListView;
import com.kdtmarken.filermod.MFileSelectedListener;
import com.kdtmarken.mojangauth.LoginListener;
import com.kdtmarken.mojangauth.LoginTask;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public class MCLoginActivity extends Activity {
    private int REQUEST_STORAGE_REQUEST_CODE = NativeDefinitions.KEY_TUNER;
    private AlertDialog alertD;
    /* access modifiers changed from: private */
    public AlertDialog dialogLoginAcc;
    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private boolean isDenied;
    /* access modifiers changed from: private */
    public ProgressBar prb;

    private void replaceFont(ViewGroup viewGroup) {
        FontChangeCrawler fontChangeCrawler;
        ViewGroup viewGroup2 = viewGroup;
        FontChangeCrawler fontChangeCrawler2 = fontChangeCrawler;
        FontChangeCrawler fontChangeCrawler3 = new FontChangeCrawler(getAssets(), "font/MCFont.otf");
        fontChangeCrawler2.replaceFonts(viewGroup2);
    }

    /* access modifiers changed from: protected */
    @Override
    public void onCreate(Bundle bundle) {
        Builder builder;
        AnonymousClass100000000 r10;
        Bundle bundle2 = bundle;
        ADRTLogCatReader.onContext(this, "com.aide.ui");
        super.onCreate(bundle2);
        setContentView(C0634R.layout.launcher);
        replaceFont((ViewGroup) findViewById(16908290));
        Builder builder2 = builder;
        Builder builder3 = new Builder(this);
        Builder builder4 = builder2;
        Builder title = builder4.setTitle("Error");
        Builder message = builder4.setMessage("Please grant Storage Permissions to continue!");
        AnonymousClass100000000 r7 = r10;
        AnonymousClass100000000 r8 = new OnClickListener(this) {
            private final MCLoginActivity this$0;

            {
                this.this$0 = r6;
            }

            static MCLoginActivity access$0(AnonymousClass100000000 r4) {
                return r4.this$0;
            }

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DialogInterface dialogInterface2 = dialogInterface;
                int i2 = i;
                this.this$0.finish();
            }
        };
        Builder positiveButton = builder4.setPositiveButton("OK", r7);
        Builder cancelable = builder4.setCancelable(false);
        this.alertD = builder4.create();
        this.isDenied = false;
        if (VERSION.SDK_INT < 23) {
            return;
        }
        if (!isStorageAllowed()) {
            this.isDenied = true;
            this.alertD.show();
            requestStoragePermission();
            return;
        }
        initMain();
    }

    /* access modifiers changed from: protected */
    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = i;
        int i4 = i2;
        super.onActivityResult(i3, i4, intent);
        if (i3 == UserStatus.REQUEST_USER && i4 == UserStatus.SWITCH_USER) {
            loginSavedAcc(null);
        }
    }

    private void initMain() {
        File file;
        File file2;
        File file3;
        Builder builder;
        File file4;
        StringBuffer stringBuffer;
        File file5 = file;
        File file6 = new File(MCClassPath.mpModEnable);
        File file7 = file5;
        File file8 = file2;
        File file9 = new File(MCClassPath.mpModDisable);
        File file10 = file8;
        File file11 = file3;
        File file12 = new File(MCClassPath.mpModAddNewMo);
        File file13 = file11;
        boolean mkdirs = file7.mkdirs();
        boolean mkdir = file10.mkdir();
        try {
            boolean createNewFile = file13.createNewFile();
        } catch (IOException e) {
            IOException iOException = e;
        }
        try {
            File file14 = file4;
            File file15 = new File(FileAccess.MAIN_PATH);
            boolean mkdirs2 = file14.mkdirs();
            MCClassPath.extractList(this, MCClassPath.nonExist(FileAccess.ADDED_LIBS));
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            FileAccess.copyAssetToFolderIfNonExist(this, "options.txt", stringBuffer2.append(FileAccess.MAIN_PATH).append("/gamedir").toString());
        } catch (Exception e2) {
            Exception exc = e2;
            Builder builder2 = builder;
            Builder builder3 = new Builder(this);
            AlertDialog show = builder2.setTitle("Error").setMessage(Log.getStackTraceString(exc)).setPositiveButton("OK", null).show();
        }
    }

    public void loginNickname(View view) {
        LinearLayout linearLayout;
        Builder builder;
        View view2 = view;
        LinearLayout linearLayout2 = linearLayout;
        LinearLayout linearLayout3 = new LinearLayout(this);
        LinearLayout linearLayout4 = linearLayout2;
        View inflate = LayoutInflater.from(this).inflate(C0634R.layout.launcher_free, linearLayout4, true);
        replaceFont(linearLayout4);
        this.edit1 = (EditText) linearLayout4.findViewById(C0634R.C0636id.launcherFreeNickname);
        Builder builder2 = builder;
        Builder builder3 = new Builder(this);
        AlertDialog show = builder2.setTitle("Register with nickname").setView(linearLayout4).show();
    }

    public void loginAccount(View view) {
        LinearLayout linearLayout;
        Builder builder;
        View view2 = view;
        LinearLayout linearLayout2 = linearLayout;
        LinearLayout linearLayout3 = new LinearLayout(this);
        LinearLayout linearLayout4 = linearLayout2;
        View inflate = LayoutInflater.from(this).inflate(C0634R.layout.launcher_acc, linearLayout4, true);
        replaceFont(linearLayout4);
        this.edit2 = (EditText) linearLayout4.findViewById(C0634R.C0636id.launcherAccEmail);
        this.edit3 = (EditText) linearLayout4.findViewById(C0634R.C0636id.launcherAccPassword);
        if (this.prb == null) {
            this.prb = (ProgressBar) linearLayout4.findViewById(C0634R.C0636id.launcherAccProgress);
        }
        if (this.dialogLoginAcc == null) {
            Builder builder2 = builder;
            Builder builder3 = new Builder(this);
            this.dialogLoginAcc = builder2.setTitle("Login with account (No no no this feature currently NOT WORKING)").setView(linearLayout4).create();
        }
        this.dialogLoginAcc.show();
    }

    public void loginSavedAcc(View view) {
        File file;
        Builder builder;
        MFileListView mFileListView;
        AnonymousClass100000002 r14;
        View view2 = view;
        File file2 = file;
        File file3 = new File(MCClassPath.mpProfiles);
        boolean mkdir = file2.mkdir();
        Builder builder2 = builder;
        Builder builder3 = new Builder(this);
        Builder builder4 = builder2;
        Builder title = builder4.setTitle("Profiles");
        Builder positiveButton = builder4.setPositiveButton(17039360, null);
        AlertDialog create = builder4.create();
        MFileListView mFileListView2 = mFileListView;
        MFileListView mFileListView3 = new MFileListView((Context) this, create);
        MFileListView mFileListView4 = mFileListView2;
        mFileListView4.listFileAt(MCClassPath.mpProfiles);
        MFileListView mFileListView5 = mFileListView4;
        AnonymousClass100000002 r9 = r14;
        AnonymousClass100000002 r10 = new MFileSelectedListener(this, mFileListView4, create) {
            private final MCLoginActivity this$0;
            private final AlertDialog val$dialog;
            private final MFileListView val$flv;

            {
                MFileListView mFileListView = r9;
                AlertDialog alertDialog = r10;
                this.this$0 = r8;
                this.val$flv = mFileListView;
                this.val$dialog = alertDialog;
            }

            static MCLoginActivity access$0(AnonymousClass100000002 r4) {
                return r4.this$0;
            }

            @Override
            public void onFileLongClick(File file, String str, String str2, String str3) {
                Builder builder;
                StringBuffer stringBuffer;
                AnonymousClass100000001 r15;
                File file2 = file;
                String str4 = str;
                String str5 = str2;
                String str6 = str3;
                Builder builder2 = builder;
                Builder builder3 = new Builder(this.this$0);
                Builder builder4 = builder2;
                Builder title = builder4.setTitle("Delete this account?");
                Builder builder5 = builder4;
                StringBuffer stringBuffer2 = stringBuffer;
                StringBuffer stringBuffer3 = new StringBuffer();
                Builder message = builder5.setMessage(stringBuffer2.append(str5).append(" will be deleted").toString());
                Builder builder6 = builder4;
                AnonymousClass100000001 r10 = r15;
                AnonymousClass100000001 r11 = new OnClickListener(this, file2, this.val$flv) {
                    private final AnonymousClass100000002 this$0;
                    private final File val$file;
                    private final MFileListView val$flv;

                    {
                        File file = r9;
                        MFileListView mFileListView = r10;
                        this.this$0 = r8;
                        this.val$file = file;
                        this.val$flv = mFileListView;
                    }

                    static AnonymousClass100000002 access$0(AnonymousClass100000001 r4) {
                        return r4.this$0;
                    }

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DialogInterface dialogInterface2 = dialogInterface;
                        int i2 = i;
                        boolean delete = this.val$file.delete();
                        this.val$flv.refreshPath();
                    }
                };
                Builder positiveButton = builder6.setPositiveButton(17039370, r10);
                Builder negativeButton = builder4.setNegativeButton(17039360, null);
                AlertDialog show = builder4.show();
            }

            @Override
            public void onFileSelected(File file, String str, String str2, String str3) {
                File file2 = file;
                String str4 = str;
                String str5 = str2;
                String str6 = str3;
                try {
                    if (MCProfile.load(str4).getIsAccount()) {
                        MCProfile.updateTokens(this.this$0, str4);
                    }
                    MCProfile.launchWithProfile(this.this$0, str4);
                    this.val$dialog.hide();
                } catch (Exception e) {
                    MCClassPath.throwError(this.this$0, e);
                }
            }
        };
        mFileListView5.setFileSelectedListener(r9);
        create.setView(mFileListView4);
        create.show();
    }

    public void loginMC(View view) {
        LoginTask loginTask;
        AnonymousClass100000003 r8;
        View view2 = view;
        LoginTask loginTask2 = loginTask;
        LoginTask loginTask3 = new LoginTask();
        AnonymousClass100000003 r4 = r8;
        AnonymousClass100000003 r5 = new LoginListener(this, view2) {
            private final MCLoginActivity this$0;
            private final View val$v;

            {
                View view = r8;
                this.this$0 = r7;
                this.val$v = view;
            }

            static MCLoginActivity access$0(AnonymousClass100000003 r4) {
                return r4.this$0;
            }

            @Override
            public void onBeforeLogin() {
                this.val$v.setEnabled(false);
                this.this$0.dialogLoginAcc.setCancelable(false);
                this.this$0.prb.setVisibility(0);
            }

            @Override
            public void onLoginDone(String[] strArr) {
                MCProfile.Builder builder;
                Builder builder2;
                String[] strArr2 = strArr;
                if (strArr2[0].equals("ERROR")) {
                    Builder builder3 = builder2;
                    Builder builder4 = new Builder(this.this$0);
                    AlertDialog show = builder3.setTitle("Login error").setMessage(MCLoginActivity.strArrToString(strArr2)).setPositiveButton(17039370, null).show();
                } else {
                    MCProfile.Builder builder5 = builder;
                    MCProfile.Builder builder6 = new MCProfile.Builder();
                    MCProfile.Builder builder7 = builder5;
                    builder7.setAccessToken(strArr2[1]);
                    builder7.setClientID(strArr2[2]);
                    builder7.setProfileID(strArr2[3]);
                    builder7.setNickname(strArr2[4]);
                    builder7.setVersion("1.7.10");
                    MCProfile.launchWithProfile(this.this$0, MCProfile.build(builder7));
                }
                this.val$v.setEnabled(true);
                this.this$0.dialogLoginAcc.setCancelable(true);
                this.this$0.prb.setVisibility(8);
            }
        };
        LoginTask loginListener = loginTask2.setLoginListener(r4);
        String[] strArr = new String[2];
        String[] strArr2 = strArr;
        strArr[0] = this.edit2.getText().toString();
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = this.edit3.getText().toString();
        AsyncTask execute = loginListener.execute(strArr4);
    }

    public void loginFree(View view) {
        Builder builder;
        File file;
        MCProfile.Builder builder2;
        View view2 = view;
        try {
            File file2 = file;
            File file3 = new File(FileAccess.MAIN_PATH);
            boolean mkdir = file2.mkdir();
            String editable = this.edit1.getText().toString();
            if (editable.isEmpty()) {
                this.edit1.setError("Nickname cannot be empty");
            } else if (editable.length() <= 2) {
                this.edit1.setError("Nickname must be at least 3 characters");
            } else {
                MCProfile.Builder builder3 = builder2;
                MCProfile.Builder builder4 = new MCProfile.Builder();
                MCProfile.Builder builder5 = builder3;
                builder5.setIsAccount(false);
                builder5.setNickname(editable);
                MCProfile.launchWithProfile(this, MCProfile.build(builder5));
            }
        } catch (Exception e) {
            Exception exc = e;
            Builder builder6 = builder;
            Builder builder7 = new Builder(this);
            AlertDialog show = builder6.setTitle("Error").setMessage(Log.getStackTraceString(exc)).setPositiveButton("OK", null).show();
        }
    }

    public static String strArrToString(String[] strArr) {
        String[] strArr2 = strArr;
        strArr2[0] = LibrariesRepository.MOJANG_MAVEN_REPO;
        String arrays = Arrays.toString(strArr2);
        return arrays.substring(1, arrays.length() - 1).replace(",", "\n");
    }

    private boolean isStorageAllowed() {
        int checkSelfPermission = ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE");
        if (checkSelfPermission == 0 && checkSelfPermission2 == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void requestStoragePermission() {
        String[] strArr = new String[2];
        String[] strArr2 = strArr;
        strArr[0] = "android.permission.WRITE_EXTERNAL_STORAGE";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "android.permission.READ_EXTERNAL_STORAGE";
        ActivityCompat.requestPermissions(this, strArr4, this.REQUEST_STORAGE_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Timer timer;
        AnonymousClass100000004 r9;
        String[] strArr2 = strArr;
        int[] iArr2 = iArr;
        if (i != this.REQUEST_STORAGE_REQUEST_CODE) {
            return;
        }
        if (iArr2.length > 0 && iArr2[0] == 0 && iArr2[1] == 0) {
            this.alertD.hide();
            initMain();
            return;
        }
        Timer timer2 = timer;
        Timer timer3 = new Timer();
        AnonymousClass100000004 r6 = r9;
        AnonymousClass100000004 r7 = new TimerTask(this) {
            private final MCLoginActivity this$0;

            {
                this.this$0 = r6;
            }

            static MCLoginActivity access$0(AnonymousClass100000004 r4) {
                return r4.this$0;
            }

            @Override
            public void run() {
                this.this$0.requestStoragePermission();
            }
        };
        timer2.schedule(r6, (long) 200);
    }

    public MCLoginActivity() {
    }
}
