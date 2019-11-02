package net.zhuoweizhang.boardwalk;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import java.io.PrintStream;

public class PostExitActivity extends Activity {
    /* access modifiers changed from: private */
    public InterstitialAd interstitial;
    private ProgressBar progressBar;

    private class PostExitAdListener extends AdListener {
        final /* synthetic */ PostExitActivity this$0;

        private PostExitAdListener(PostExitActivity postExitActivity) {
            this.this$0 = postExitActivity;
        }

        /* synthetic */ PostExitAdListener(PostExitActivity postExitActivity, C06451 r7) {
            C06451 r2 = r7;
            this(postExitActivity);
        }

        public void onAdFailedToLoad(int i) {
            StringBuilder sb;
            int i2 = i;
            PrintStream printStream = System.err;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("Ad load fail: ").append(i2).toString());
            this.this$0.finish();
        }

        public void onAdLoaded() {
            this.this$0.interstitial.show();
            this.this$0.finish();
        }
    }

    public PostExitActivity() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ProgressBar progressBar2;
        LayoutParams layoutParams;
        InterstitialAd interstitialAd;
        Builder builder;
        PostExitAdListener postExitAdListener;
        super.onCreate(bundle);
        ProgressBar progressBar3 = progressBar2;
        ProgressBar progressBar4 = new ProgressBar(this);
        this.progressBar = progressBar3;
        this.progressBar.setIndeterminate(true);
        ProgressBar progressBar5 = this.progressBar;
        LayoutParams layoutParams2 = layoutParams;
        LayoutParams layoutParams3 = new LayoutParams(-2, -2);
        setContentView(progressBar5, layoutParams2);
        InterstitialAd interstitialAd2 = interstitialAd;
        InterstitialAd interstitialAd3 = new InterstitialAd(this);
        this.interstitial = interstitialAd2;
        this.interstitial.setAdUnitId("ca-app-pub-2652482030334356/5468611825");
        Builder builder2 = builder;
        Builder builder3 = new Builder();
        AdRequest build = builder2.addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice(AdvertConstants.DEVICE_ID_TESTER).addTestDevice(AdvertConstants.DEVICE_ID_TESTER_L).addTestDevice(AdvertConstants.DEVICE_ID_TESTER_NEW).build();
        InterstitialAd interstitialAd4 = this.interstitial;
        PostExitAdListener postExitAdListener2 = postExitAdListener;
        PostExitAdListener postExitAdListener3 = new PostExitAdListener(this, null);
        interstitialAd4.setAdListener(postExitAdListener2);
        this.interstitial.loadAd(build);
    }
}
