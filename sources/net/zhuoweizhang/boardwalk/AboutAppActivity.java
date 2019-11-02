package net.zhuoweizhang.boardwalk;

import adrt.ADRTLogCatReader;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import net.minecraft.kdt.C0634R;

public final class AboutAppActivity extends Activity {

    /* renamed from: e */
    private EditText f159e;
    private SharedPreferences name;

    public AboutAppActivity() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle bundle2 = bundle;
        ADRTLogCatReader.onContext(this, "com.aide.ui");
        super.onCreate(bundle2);
        setContentView(C0634R.mipmap.ic_launcher);
        this.f159e = (EditText) findViewById(C0634R.style.AppTheme);
        this.name = getSharedPreferences("launcher_prefs", 0);
        this.f159e.setText(this.name.getString("auth_profile_name", null));
    }

    public void save(View view) {
        View view2 = view;
        this.name.edit().putString("auth_lastEmail", this.f159e.getText().toString()).putString("auth_accessToken", "HACKLOGINh67uG67y64hGtH77YtR67hHU7UtTt7u675EVY65Fy6G4gY").putString("auth_profile_name", this.f159e.getText().toString()).putString("auth_profle_id", "HackCodeH67uHY76").apply();
    }
}
