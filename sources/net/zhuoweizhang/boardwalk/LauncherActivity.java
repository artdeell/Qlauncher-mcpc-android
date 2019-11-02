package net.zhuoweizhang.boardwalk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.ipaulpro.afilechooser.FileChooserActivity;
import com.ipaulpro.afilechooser.utils.FileUtils;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.zhuoweizhang.boardwalk.LaunchMinecraftTask.Listener;
import net.zhuoweizhang.boardwalk.com.android.p003dx.Version;
import net.zhuoweizhang.boardwalk.util.PlatformUtils;
import org.lwjgl.LWJGLUtil;

public class LauncherActivity extends Activity implements OnClickListener, Listener, OnItemSelectedListener {
    public static final int REQUEST_BROWSE_FOR_CREDENTIALS = 1013;
    public static final int REQUEST_BROWSE_FOR_RESOURCE_PACK = 1014;
    public static final String[] versionsSupported;
    private AdView adView;
    private Handler handler;
    public Button importCredentialsButton;
    public Button importResourcePackButton;
    private InterstitialAd interstitial;
    public boolean isLaunching = false;
    public Button loginButton;
    public Button logoutButton;
    public TextView passwordText;
    public Button playButton;
    public ProgressBar progressBar;
    public TextView progressText;
    public TextView recommendationText;
    public boolean refreshedToken = false;
    public TextView usernameText;
    public Spinner versionSpinner;
    public ArrayAdapter<String> versionSpinnerAdapter;
    public List<String> versionsStringList;

    private class LauncherAdListener extends AdListener {
        final /* synthetic */ LauncherActivity this$0;

        private LauncherAdListener(LauncherActivity launcherActivity) {
            this.this$0 = launcherActivity;
        }

        /* synthetic */ LauncherAdListener(LauncherActivity launcherActivity, C06381 r7) {
            C06381 r2 = r7;
            this(launcherActivity);
        }

        public void onAdClosed() {
            this.this$0.doLaunch();
        }

        public void onAdFailedToLoad(int i) {
            int i2 = i;
            this.this$0.enableLaunchButton();
        }

        public void onAdLoaded() {
            this.this$0.enableLaunchButton();
        }
    }

    static {
        String[] strArr = new String[1];
        String[] strArr2 = strArr;
        strArr[0] = MainActivity.VERSION_TO_LAUNCH;
        versionsSupported = strArr2;
    }

    public LauncherActivity() {
        ArrayList arrayList;
        C06381 r5;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.versionsStringList = arrayList2;
        C06381 r2 = r5;
        C06381 r3 = new Handler(this) {
            final /* synthetic */ LauncherActivity this$0;

            {
                this.this$0 = r5;
            }

            public void handleMessage(Message message) {
                Message message2 = message;
                this.this$0.enableLaunchButton();
            }
        };
        this.handler = r2;
    }

    private void doBrowseForResourcePack() {
        Intent createGetContentIntent = FileUtils.createGetContentIntent();
        Intent type = createGetContentIntent.setType("application/zip");
        Intent intent = createGetContentIntent.setClass(this, FileChooserActivity.class);
        startActivityForResult(createGetContentIntent, REQUEST_BROWSE_FOR_RESOURCE_PACK);
    }

    private void doExportLog() {
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] strArr = new String[4];
            String[] strArr2 = strArr;
            strArr[0] = "logcat";
            String[] strArr3 = strArr2;
            String[] strArr4 = strArr3;
            strArr3[1] = "-d";
            String[] strArr5 = strArr4;
            String[] strArr6 = strArr5;
            strArr5[2] = "-f";
            String[] strArr7 = strArr6;
            String[] strArr8 = strArr7;
            strArr7[3] = "/sdcard/boardwalk/log.txt";
            Process exec = runtime.exec(strArr8);
            this.progressText.setText("Log exported to /sdcard/boardwalk/log.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doLogout() {
        getSharedPreferences("launcher_prefs", 0).edit().remove("auth_accessToken").remove("auth_profile_name").remove("auth_profile_id").apply();
        updateUiWithLoginStatus();
    }

    /* access modifiers changed from: private */
    public void enableLaunchButton() {
        this.playButton.setEnabled(true);
    }

    private void initAds() {
        Builder builder;
        InterstitialAd interstitialAd;
        Builder builder2;
        LauncherAdListener launcherAdListener;
        this.adView = (AdView) findViewById(C0646R.C0648id.f160ad);
        Builder builder3 = builder;
        Builder builder4 = new Builder();
        this.adView.loadAd(builder3.addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice(AdvertConstants.DEVICE_ID_TESTER).addTestDevice(AdvertConstants.DEVICE_ID_TESTER_L).addTestDevice(AdvertConstants.DEVICE_ID_TESTER_NEW).build());
        InterstitialAd interstitialAd2 = interstitialAd;
        InterstitialAd interstitialAd3 = new InterstitialAd(this);
        this.interstitial = interstitialAd2;
        this.interstitial.setAdUnitId("ca-app-pub-2652482030334356/4318313426");
        Builder builder5 = builder2;
        Builder builder6 = new Builder();
        AdRequest build = builder5.addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice(AdvertConstants.DEVICE_ID_TESTER).addTestDevice(AdvertConstants.DEVICE_ID_TESTER_L).addTestDevice(AdvertConstants.DEVICE_ID_TESTER_NEW).build();
        InterstitialAd interstitialAd4 = this.interstitial;
        LauncherAdListener launcherAdListener2 = launcherAdListener;
        LauncherAdListener launcherAdListener3 = new LauncherAdListener(this, null);
        interstitialAd4.setAdListener(launcherAdListener2);
        this.interstitial.loadAd(build);
    }

    private void refreshToken() {
        RefreshAuthTokenTask refreshAuthTokenTask;
        if (isLoggedIn()) {
            RefreshAuthTokenTask refreshAuthTokenTask2 = refreshAuthTokenTask;
            RefreshAuthTokenTask refreshAuthTokenTask3 = new RefreshAuthTokenTask(this);
            AsyncTask execute = refreshAuthTokenTask2.execute(new String[0]);
        }
    }

    private void updateVersionSpinner() {
        ArrayAdapter<String> arrayAdapter;
        RefreshVersionListTask refreshVersionListTask;
        boolean addAll = this.versionsStringList.addAll(Arrays.asList(versionsSupported));
        String string = getSharedPreferences("launcher_prefs", 0).getString("selected_version", MainActivity.VERSION_TO_LAUNCH);
        if (!this.versionsStringList.contains(string)) {
            boolean add = this.versionsStringList.add(string);
        }
        ArrayAdapter<String> arrayAdapter2 = arrayAdapter;
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<>(this, 17367048, this.versionsStringList);
        this.versionSpinnerAdapter = arrayAdapter2;
        this.versionSpinnerAdapter.setDropDownViewResource(17367049);
        this.versionSpinner.setAdapter(this.versionSpinnerAdapter);
        this.versionSpinner.setSelection(this.versionsStringList.indexOf(string));
        RefreshVersionListTask refreshVersionListTask2 = refreshVersionListTask;
        RefreshVersionListTask refreshVersionListTask3 = new RefreshVersionListTask(this);
        AsyncTask execute = refreshVersionListTask2.execute(new String[0]);
    }

    public void addToVersionSpinner(List<String> list) {
        StringBuilder sb;
        List<String> list2 = list;
        String string = getSharedPreferences("launcher_prefs", 0).getString("selected_version", MainActivity.VERSION_TO_LAUNCH);
        this.versionsStringList.clear();
        boolean addAll = this.versionsStringList.addAll(list2);
        int indexOf = this.versionsStringList.indexOf(string);
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("Selected version: ").append(string).append(" index: ").append(indexOf).toString());
        this.versionSpinnerAdapter.notifyDataSetChanged();
        this.versionSpinner.setSelection(indexOf);
    }

    public void doBrowseForCredentials() {
        AlertDialog.Builder builder;
        C06392 r6;
        AlertDialog.Builder builder2 = builder;
        AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
        AlertDialog.Builder message = builder2.setMessage(C0646R.string.login_import_credentials_info);
        C06392 r3 = r6;
        C06392 r4 = new DialogInterface.OnClickListener(this) {
            final /* synthetic */ LauncherActivity this$0;

            {
                this.this$0 = r5;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                DialogInterface dialogInterface2 = dialogInterface;
                int i2 = i;
                Intent createGetContentIntent = FileUtils.createGetContentIntent();
                Intent type = createGetContentIntent.setType("application/json");
                Intent intent = createGetContentIntent.setClass(this.this$0, FileChooserActivity.class);
                this.this$0.startActivityForResult(createGetContentIntent, LauncherActivity.REQUEST_BROWSE_FOR_CREDENTIALS);
            }
        };
        AlertDialog show = message.setPositiveButton(17039370, r3).setNegativeButton(17039360, null).show();
    }

    public void doLaunch() {
        LaunchMinecraftTask launchMinecraftTask;
        this.isLaunching = true;
        this.adView.pause();
        this.adView.setVisibility(8);
        this.progressBar.setVisibility(0);
        this.loginButton.setVisibility(8);
        this.logoutButton.setVisibility(8);
        this.playButton.setVisibility(8);
        this.versionSpinner.setVisibility(8);
        this.importCredentialsButton.setVisibility(8);
        this.importResourcePackButton.setVisibility(8);
        LaunchMinecraftTask launchMinecraftTask2 = launchMinecraftTask;
        LaunchMinecraftTask launchMinecraftTask3 = new LaunchMinecraftTask(this, this);
        AsyncTask execute = launchMinecraftTask2.execute(new Void[0]);
    }

    public void doLogin() {
        LoginTask loginTask;
        LoginTask loginTask2 = loginTask;
        LoginTask loginTask3 = new LoginTask(this);
        AsyncTask execute = loginTask2.execute(new String[]{this.usernameText.getText().toString(), this.passwordText.getText().toString()});
    }

    public void doPreLaunch() {
        if (this.interstitial.isLoaded()) {
            this.interstitial.show();
        } else {
            doLaunch();
        }
    }

    public boolean isLoggedIn() {
        boolean z = false;
        if (getSharedPreferences("launcher_prefs", 0).getString("auth_accessToken", null) != null) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        ImportResourcePackTask importResourcePackTask;
        ImportVanillaAuthTask importVanillaAuthTask;
        int i3 = i;
        int i4 = i2;
        Intent intent2 = intent;
        switch (i3) {
            case REQUEST_BROWSE_FOR_CREDENTIALS /*1013*/:
                if (i4 == -1) {
                    File file = FileUtils.getFile(intent2.getData());
                    ImportVanillaAuthTask importVanillaAuthTask2 = importVanillaAuthTask;
                    ImportVanillaAuthTask importVanillaAuthTask3 = new ImportVanillaAuthTask(this);
                    AsyncTask execute = importVanillaAuthTask2.execute(new String[]{file.getAbsolutePath()});
                    return;
                }
                return;
            case REQUEST_BROWSE_FOR_RESOURCE_PACK /*1014*/:
                if (i4 == -1) {
                    File file2 = FileUtils.getFile(intent2.getData());
                    ImportResourcePackTask importResourcePackTask2 = importResourcePackTask;
                    ImportResourcePackTask importResourcePackTask3 = new ImportResourcePackTask(this);
                    File[] fileArr = new File[1];
                    File[] fileArr2 = fileArr;
                    fileArr[0] = file2;
                    AsyncTask execute2 = importResourcePackTask2.execute(fileArr2);
                    return;
                }
                return;
            default:
                super.onActivityResult(i3, i4, intent2);
                return;
        }
    }

    public void onBackPressed() {
        if (!this.isLaunching) {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        View view2 = view;
        if (view2 == this.loginButton) {
            doLogin();
        } else if (view2 == this.playButton) {
            doPreLaunch();
        } else if (view2 == this.logoutButton) {
            doLogout();
        } else if (view2 == this.importCredentialsButton) {
            doBrowseForCredentials();
        } else if (view2 == this.importResourcePackButton) {
            doBrowseForResourcePack();
        }
    }

    public void onCreate(Bundle bundle) {
        File file;
        super.onCreate(bundle);
        setContentView(C0646R.layout.launcher_layout);
        this.loginButton = (Button) findViewById(C0646R.C0648id.launcher_login_button);
        this.usernameText = (TextView) findViewById(C0646R.C0648id.launcher_username_text);
        this.passwordText = (TextView) findViewById(C0646R.C0648id.launcher_password_text);
        this.progressText = (TextView) findViewById(C0646R.C0648id.launcher_progress_text);
        this.progressBar = (ProgressBar) findViewById(C0646R.C0648id.launcher_progress_bar);
        this.loginButton.setOnClickListener(this);
        this.playButton = (Button) findViewById(C0646R.C0648id.launcher_play_button);
        this.playButton.setOnClickListener(this);
        this.recommendationText = (TextView) findViewById(C0646R.C0648id.launcher_recommendation_text);
        this.logoutButton = (Button) findViewById(C0646R.C0648id.launcher_logout_button);
        this.logoutButton.setOnClickListener(this);
        this.importCredentialsButton = (Button) findViewById(C0646R.C0648id.launcher_import_credentials_button);
        this.importCredentialsButton.setOnClickListener(this);
        this.importResourcePackButton = (Button) findViewById(C0646R.C0648id.launcher_import_resource_pack_button);
        this.importResourcePackButton.setOnClickListener(this);
        this.versionSpinner = (Spinner) findViewById(C0646R.C0648id.launcher_version_spinner);
        this.versionSpinner.setOnItemSelectedListener(this);
        updateVersionSpinner();
        updateUiWithLoginStatus();
        updateRecommendationText();
        this.playButton.setEnabled(false);
        boolean sendEmptyMessageDelayed = this.handler.sendEmptyMessageDelayed(LWJGLUtil.PLATFORM_ANDROID, 30000);
        initAds();
        refreshToken();
        File file2 = file;
        File file3 = new File("/sdcard/boardwalk/debugconsole");
        if (file2.exists()) {
            RemoteDebugConsole.start();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem add = menu.add(getResources().getString(C0646R.string.about_app));
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.adView.destroy();
        super.onDestroy();
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        StringBuilder sb;
        AlertDialog.Builder builder;
        View view2 = view;
        int i2 = i;
        long j2 = j;
        if (adapterView == this.versionSpinner) {
            String str = (String) this.versionsStringList.get(i2);
            SharedPreferences sharedPreferences = getSharedPreferences("launcher_prefs", 0);
            if (!sharedPreferences.getString("selected_version", MainActivity.VERSION_TO_LAUNCH).equals(str)) {
                sharedPreferences.edit().putString("selected_version", str).apply();
                PrintStream printStream = System.out;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                printStream.println(sb2.append("Version: ").append(str).toString());
                if (str.equals(Version.VERSION) && DalvikTweaks.isDalvik()) {
                    AlertDialog.Builder builder2 = builder;
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                    AlertDialog show = builder2.setMessage("Minecraft 1.8 is unplayable on Dalvik due to severe lag and two-minute startup times. Please use a device with ART. Launching 1.8 on Dalvik may work, but this is completely unsupported. It is strongly recommended that you launch 1.7.10 instead.").setPositiveButton(17039370, null).show();
                }
            }
        }
    }

    public void onLaunchError() {
        this.isLaunching = false;
        this.playButton.setVisibility(0);
        this.importResourcePackButton.setVisibility(0);
        this.versionSpinner.setVisibility(0);
        this.adView.resume();
        this.adView.setVisibility(0);
        this.progressBar.setVisibility(8);
        updateUiWithLoginStatus();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent;
        MenuItem menuItem2 = menuItem;
        CharSequence title = menuItem2.getTitle();
        if (title.equals(getResources().getString(C0646R.string.about_app))) {
            Intent intent2 = intent;
            Intent intent3 = new Intent(this, AboutAppActivity.class);
            startActivity(intent2);
            return true;
        } else if (!title.equals(getResources().getString(C0646R.string.export_log))) {
            return super.onOptionsItemSelected(menuItem2);
        } else {
            doExportLog();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.adView.pause();
        super.onPause();
        getSharedPreferences("launcher_prefs", 0).edit().putString("auth_lastEmail", this.usernameText.getText().toString()).apply();
    }

    public void onProgressUpdate(String str) {
        String str2 = str;
        this.progressText.setText(str2);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.usernameText.setText(getSharedPreferences("launcher_prefs", 0).getString("auth_lastEmail", LibrariesRepository.MOJANG_MAVEN_REPO));
        this.adView.resume();
    }

    public void updateRecommendationText() {
        StringBuilder sb;
        File file;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        if (PlatformUtils.getNumCores() < 2) {
            StringBuilder append = sb4.append(getResources().getText(C0646R.string.recommendation_dual_core)).append("\n");
        }
        if (DalvikTweaks.isDalvik()) {
            File file2 = file;
            File file3 = new File("/system/lib/libart.so");
            if (file2.exists()) {
                StringBuilder append2 = sb4.append(getResources().getText(C0646R.string.recommendation_art)).append("\n");
            }
        }
        this.recommendationText.setText(sb4.toString());
    }

    public void updateUiWithLoginStatus() {
        int i = 8;
        boolean isLoggedIn = isLoggedIn();
        this.usernameText.setEnabled(!isLoggedIn);
        this.passwordText.setVisibility(isLoggedIn ? 8 : 0);
        Button button = this.playButton;
        Resources resources = getResources();
        int i2 = isLoggedIn ? this.refreshedToken ? 2131034138 : 2131034136 : 2131034137;
        button.setText(resources.getText(i2));
        this.loginButton.setVisibility(isLoggedIn ? 8 : 0);
        this.logoutButton.setVisibility(isLoggedIn ? 0 : 8);
        Button button2 = this.importCredentialsButton;
        if (!isLoggedIn) {
            i = 0;
        }
        button2.setVisibility(i);
    }
}
