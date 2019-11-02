package android.support.p000v4.hardware.display;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.hardware.display.DisplayManagerCompat */
public abstract class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, DisplayManagerCompat> sInstances;

    /* renamed from: android.support.v4.hardware.display.DisplayManagerCompat$JellybeanMr1Impl */
    private static class JellybeanMr1Impl extends DisplayManagerCompat {
        private final Object mDisplayManagerObj;

        public JellybeanMr1Impl(Context context) {
            this.mDisplayManagerObj = DisplayManagerJellybeanMr1.getDisplayManager(context);
        }

        public Display getDisplay(int i) {
            return DisplayManagerJellybeanMr1.getDisplay(this.mDisplayManagerObj, i);
        }

        public Display[] getDisplays() {
            return DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj);
        }

        public Display[] getDisplays(String str) {
            return DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj, str);
        }
    }

    /* renamed from: android.support.v4.hardware.display.DisplayManagerCompat$LegacyImpl */
    private static class LegacyImpl extends DisplayManagerCompat {
        private final WindowManager mWindowManager;

        public LegacyImpl(Context context) {
            this.mWindowManager = (WindowManager) context.getSystemService("window");
        }

        public Display getDisplay(int i) {
            int i2 = i;
            Display defaultDisplay = this.mWindowManager.getDefaultDisplay();
            if (defaultDisplay.getDisplayId() == i2) {
                return defaultDisplay;
            }
            return null;
        }

        public Display[] getDisplays() {
            return new Display[]{this.mWindowManager.getDefaultDisplay()};
        }

        public Display[] getDisplays(String str) {
            return str == null ? getDisplays() : new Display[0];
        }
    }

    static {
        WeakHashMap<Context, DisplayManagerCompat> weakHashMap;
        WeakHashMap<Context, DisplayManagerCompat> weakHashMap2 = weakHashMap;
        WeakHashMap<Context, DisplayManagerCompat> weakHashMap3 = new WeakHashMap<>();
        sInstances = weakHashMap2;
    }

    DisplayManagerCompat() {
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r4v7, types: [android.support.v4.hardware.display.DisplayManagerCompat] */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.support.v4.hardware.display.DisplayManagerCompat] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p000v4.hardware.display.DisplayManagerCompat getInstance(android.content.Context r8) {
        /*
            r0 = r8
            java.util.WeakHashMap<android.content.Context, android.support.v4.hardware.display.DisplayManagerCompat> r4 = sInstances
            r1 = r4
            r4 = r1
            monitor-enter(r4)
            java.util.WeakHashMap<android.content.Context, android.support.v4.hardware.display.DisplayManagerCompat> r4 = sInstances     // Catch:{ all -> 0x003b }
            r5 = r0
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x003b }
            android.support.v4.hardware.display.DisplayManagerCompat r4 = (android.support.p000v4.hardware.display.DisplayManagerCompat) r4     // Catch:{ all -> 0x003b }
            r3 = r4
            r4 = r3
            if (r4 != 0) goto L_0x002b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x003b }
            r5 = 17
            if (r4 < r5) goto L_0x0030
            android.support.v4.hardware.display.DisplayManagerCompat$JellybeanMr1Impl r4 = new android.support.v4.hardware.display.DisplayManagerCompat$JellybeanMr1Impl     // Catch:{ all -> 0x003b }
            r7 = r4
            r4 = r7
            r5 = r7
            r6 = r0
            r5.<init>(r6)     // Catch:{ all -> 0x003b }
            r3 = r4
        L_0x0023:
            java.util.WeakHashMap<android.content.Context, android.support.v4.hardware.display.DisplayManagerCompat> r4 = sInstances     // Catch:{ all -> 0x003b }
            r5 = r0
            r6 = r3
            java.lang.Object r4 = r4.put(r5, r6)     // Catch:{ all -> 0x003b }
        L_0x002b:
            r4 = r1
            monitor-exit(r4)     // Catch:{ all -> 0x003b }
            r4 = r3
            r0 = r4
            return r0
        L_0x0030:
            android.support.v4.hardware.display.DisplayManagerCompat$LegacyImpl r4 = new android.support.v4.hardware.display.DisplayManagerCompat$LegacyImpl     // Catch:{ all -> 0x003b }
            r7 = r4
            r4 = r7
            r5 = r7
            r6 = r0
            r5.<init>(r6)     // Catch:{ all -> 0x003b }
            r3 = r4
            goto L_0x0023
        L_0x003b:
            r4 = move-exception
            r2 = r4
            r4 = r1
            monitor-exit(r4)     // Catch:{ all -> 0x003b }
            r4 = r2
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.hardware.display.DisplayManagerCompat.getInstance(android.content.Context):android.support.v4.hardware.display.DisplayManagerCompat");
    }

    public abstract Display getDisplay(int i);

    public abstract Display[] getDisplays();

    public abstract Display[] getDisplays(String str);
}
