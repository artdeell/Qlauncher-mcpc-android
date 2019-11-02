package net.zhuoweizhang.boardwalk;

import android.app.Activity;
import android.os.Bundle;
import java.io.PrintStream;

public class NerdyStuffActivity extends Activity {

    public static class Bench {
        public long lastMillis = 0;

        public Bench() {
        }

        public void tic() {
            this.lastMillis = System.currentTimeMillis();
        }

        public void toc() {
            StringBuilder sb;
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("Elapsed time: ").append(System.currentTimeMillis() - this.lastMillis).toString());
        }
    }

    public NerdyStuffActivity() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
