package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcj.zza;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzjp;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@zzhb
public class zzk extends zza implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    /* access modifiers changed from: private */
    public FrameLayout zzoQ;
    private final Object zzpV;
    private final FrameLayout zzyD;
    private Map<String, WeakReference<View>> zzyE;
    private zzb zzyF;
    boolean zzyG = false;
    int zzyH;
    int zzyI;
    private zzh zzyf;

    public zzk(FrameLayout frameLayout, FrameLayout frameLayout2) {
        Object obj;
        HashMap hashMap;
        FrameLayout frameLayout3 = frameLayout;
        FrameLayout frameLayout4 = frameLayout2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.zzyE = hashMap2;
        this.zzyD = frameLayout3;
        this.zzoQ = frameLayout4;
        zzjk.zza((View) this.zzyD, (OnGlobalLayoutListener) this);
        zzjk.zza((View) this.zzyD, (OnScrollChangedListener) this);
        this.zzyD.setOnTouchListener(this);
    }

    public void destroy() {
        this.zzoQ.removeAllViews();
        this.zzoQ = null;
        this.zzyE = null;
        this.zzyF = null;
        this.zzyf = null;
    }

    /* access modifiers changed from: 0000 */
    public int getMeasuredHeight() {
        return this.zzyD.getMeasuredHeight();
    }

    /* access modifiers changed from: 0000 */
    public int getMeasuredWidth() {
        return this.zzyD.getMeasuredWidth();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r28) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r20 = r1
            r0 = r20
            java.lang.Object r0 = r0.zzpV
            r20 = r0
            r3 = r20
            r20 = r3
            monitor-enter(r20)
            r20 = r1
            r0 = r20
            com.google.android.gms.ads.internal.formats.zzh r0 = r0.zzyf     // Catch:{ all -> 0x0106 }
            r20 = r0
            if (r20 != 0) goto L_0x001f
            r20 = r3
            monitor-exit(r20)     // Catch:{ all -> 0x0106 }
        L_0x001e:
            return
        L_0x001f:
            org.json.JSONObject r20 = new org.json.JSONObject     // Catch:{ all -> 0x0106 }
            r26 = r20
            r20 = r26
            r21 = r26
            r21.<init>()     // Catch:{ all -> 0x0106 }
            r5 = r20
            r20 = r1
            r0 = r20
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r0 = r0.zzyE     // Catch:{ all -> 0x0106 }
            r20 = r0
            java.util.Set r20 = r20.entrySet()     // Catch:{ all -> 0x0106 }
            java.util.Iterator r20 = r20.iterator()     // Catch:{ all -> 0x0106 }
            r6 = r20
        L_0x003e:
            r20 = r6
            boolean r20 = r20.hasNext()     // Catch:{ all -> 0x0106 }
            if (r20 == 0) goto L_0x010f
            r20 = r6
            java.lang.Object r20 = r20.next()     // Catch:{ all -> 0x0106 }
            java.util.Map$Entry r20 = (java.util.Map.Entry) r20     // Catch:{ all -> 0x0106 }
            r15 = r20
            r20 = r15
            java.lang.Object r20 = r20.getValue()     // Catch:{ all -> 0x0106 }
            java.lang.ref.WeakReference r20 = (java.lang.ref.WeakReference) r20     // Catch:{ all -> 0x0106 }
            java.lang.Object r20 = r20.get()     // Catch:{ all -> 0x0106 }
            android.view.View r20 = (android.view.View) r20     // Catch:{ all -> 0x0106 }
            r16 = r20
            r20 = r1
            r21 = r16
            android.graphics.Point r20 = r20.zzj(r21)     // Catch:{ all -> 0x0106 }
            r17 = r20
            org.json.JSONObject r20 = new org.json.JSONObject     // Catch:{ all -> 0x0106 }
            r26 = r20
            r20 = r26
            r21 = r26
            r21.<init>()     // Catch:{ all -> 0x0106 }
            r18 = r20
            r20 = r18
            java.lang.String r21 = "width"
            r22 = r1
            r23 = r16
            int r23 = r23.getWidth()     // Catch:{ JSONException -> 0x00dd }
            int r22 = r22.zzq(r23)     // Catch:{ JSONException -> 0x00dd }
            org.json.JSONObject r20 = r20.put(r21, r22)     // Catch:{ JSONException -> 0x00dd }
            r20 = r18
            java.lang.String r21 = "height"
            r22 = r1
            r23 = r16
            int r23 = r23.getHeight()     // Catch:{ JSONException -> 0x00dd }
            int r22 = r22.zzq(r23)     // Catch:{ JSONException -> 0x00dd }
            org.json.JSONObject r20 = r20.put(r21, r22)     // Catch:{ JSONException -> 0x00dd }
            r20 = r18
            java.lang.String r21 = "x"
            r22 = r1
            r23 = r17
            r0 = r23
            int r0 = r0.x     // Catch:{ JSONException -> 0x00dd }
            r23 = r0
            int r22 = r22.zzq(r23)     // Catch:{ JSONException -> 0x00dd }
            org.json.JSONObject r20 = r20.put(r21, r22)     // Catch:{ JSONException -> 0x00dd }
            r20 = r18
            java.lang.String r21 = "y"
            r22 = r1
            r23 = r17
            r0 = r23
            int r0 = r0.y     // Catch:{ JSONException -> 0x00dd }
            r23 = r0
            int r22 = r22.zzq(r23)     // Catch:{ JSONException -> 0x00dd }
            org.json.JSONObject r20 = r20.put(r21, r22)     // Catch:{ JSONException -> 0x00dd }
            r20 = r5
            r21 = r15
            java.lang.Object r21 = r21.getKey()     // Catch:{ JSONException -> 0x00dd }
            java.lang.String r21 = (java.lang.String) r21     // Catch:{ JSONException -> 0x00dd }
            r22 = r18
            org.json.JSONObject r20 = r20.put(r21, r22)     // Catch:{ JSONException -> 0x00dd }
            goto L_0x003e
        L_0x00dd:
            r20 = move-exception
            r19 = r20
            java.lang.StringBuilder r20 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r26 = r20
            r20 = r26
            r21 = r26
            r21.<init>()     // Catch:{ all -> 0x0106 }
            java.lang.String r21 = "Unable to get view rectangle for view "
            java.lang.StringBuilder r20 = r20.append(r21)     // Catch:{ all -> 0x0106 }
            r21 = r15
            java.lang.Object r21 = r21.getKey()     // Catch:{ all -> 0x0106 }
            java.lang.String r21 = (java.lang.String) r21     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r20 = r20.append(r21)     // Catch:{ all -> 0x0106 }
            java.lang.String r20 = r20.toString()     // Catch:{ all -> 0x0106 }
            com.google.android.gms.internal.zzin.zzaK(r20)     // Catch:{ all -> 0x0106 }
            goto L_0x003e
        L_0x0106:
            r20 = move-exception
            r4 = r20
            r20 = r3
            monitor-exit(r20)     // Catch:{ all -> 0x0106 }
            r20 = r4
            throw r20
        L_0x010f:
            org.json.JSONObject r20 = new org.json.JSONObject     // Catch:{ all -> 0x0106 }
            r26 = r20
            r20 = r26
            r21 = r26
            r21.<init>()     // Catch:{ all -> 0x0106 }
            r7 = r20
            r20 = r7
            java.lang.String r21 = "x"
            r22 = r1
            r23 = r1
            r0 = r23
            int r0 = r0.zzyH     // Catch:{ JSONException -> 0x01b3 }
            r23 = r0
            int r22 = r22.zzq(r23)     // Catch:{ JSONException -> 0x01b3 }
            org.json.JSONObject r20 = r20.put(r21, r22)     // Catch:{ JSONException -> 0x01b3 }
            r20 = r7
            java.lang.String r21 = "y"
            r22 = r1
            r23 = r1
            r0 = r23
            int r0 = r0.zzyI     // Catch:{ JSONException -> 0x01b3 }
            r23 = r0
            int r22 = r22.zzq(r23)     // Catch:{ JSONException -> 0x01b3 }
            org.json.JSONObject r20 = r20.put(r21, r22)     // Catch:{ JSONException -> 0x01b3 }
        L_0x0148:
            org.json.JSONObject r20 = new org.json.JSONObject     // Catch:{ all -> 0x0106 }
            r26 = r20
            r20 = r26
            r21 = r26
            r21.<init>()     // Catch:{ all -> 0x0106 }
            r9 = r20
            r20 = r9
            java.lang.String r21 = "width"
            r22 = r1
            r23 = r1
            int r23 = r23.getMeasuredWidth()     // Catch:{ JSONException -> 0x01bc }
            int r22 = r22.zzq(r23)     // Catch:{ JSONException -> 0x01bc }
            org.json.JSONObject r20 = r20.put(r21, r22)     // Catch:{ JSONException -> 0x01bc }
            r20 = r9
            java.lang.String r21 = "height"
            r22 = r1
            r23 = r1
            int r23 = r23.getMeasuredHeight()     // Catch:{ JSONException -> 0x01bc }
            int r22 = r22.zzq(r23)     // Catch:{ JSONException -> 0x01bc }
            org.json.JSONObject r20 = r20.put(r21, r22)     // Catch:{ JSONException -> 0x01bc }
        L_0x017d:
            r20 = r1
            r0 = r20
            com.google.android.gms.ads.internal.formats.zzb r0 = r0.zzyF     // Catch:{ all -> 0x0106 }
            r20 = r0
            if (r20 == 0) goto L_0x01c5
            r20 = r1
            r0 = r20
            com.google.android.gms.ads.internal.formats.zzb r0 = r0.zzyF     // Catch:{ all -> 0x0106 }
            r20 = r0
            android.view.ViewGroup r20 = r20.zzdI()     // Catch:{ all -> 0x0106 }
            r21 = r2
            boolean r20 = r20.equals(r21)     // Catch:{ all -> 0x0106 }
            if (r20 == 0) goto L_0x01c5
            r20 = r1
            r0 = r20
            com.google.android.gms.ads.internal.formats.zzh r0 = r0.zzyf     // Catch:{ all -> 0x0106 }
            r20 = r0
            java.lang.String r21 = "1007"
            r22 = r5
            r23 = r7
            r24 = r9
            r20.zza(r21, r22, r23, r24)     // Catch:{ all -> 0x0106 }
        L_0x01ae:
            r20 = r3
            monitor-exit(r20)     // Catch:{ all -> 0x0106 }
            goto L_0x001e
        L_0x01b3:
            r20 = move-exception
            r8 = r20
            java.lang.String r20 = "Unable to get click location"
            com.google.android.gms.internal.zzin.zzaK(r20)     // Catch:{ all -> 0x0106 }
            goto L_0x0148
        L_0x01bc:
            r20 = move-exception
            r10 = r20
            java.lang.String r20 = "Unable to get native ad view bounding box"
            com.google.android.gms.internal.zzin.zzaK(r20)     // Catch:{ all -> 0x0106 }
            goto L_0x017d
        L_0x01c5:
            r20 = r1
            r0 = r20
            com.google.android.gms.ads.internal.formats.zzh r0 = r0.zzyf     // Catch:{ all -> 0x0106 }
            r20 = r0
            r21 = r2
            r22 = r1
            r0 = r22
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r0 = r0.zzyE     // Catch:{ all -> 0x0106 }
            r22 = r0
            r23 = r5
            r24 = r7
            r25 = r9
            r20.zza(r21, r22, r23, r24, r25)     // Catch:{ all -> 0x0106 }
            goto L_0x01ae
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.formats.zzk.onClick(android.view.View):void");
    }

    public void onGlobalLayout() {
        int i;
        LayoutParams layoutParams;
        int i2 = this.zzpV;
        synchronized (i2) {
            try {
                if (this.zzyG) {
                    i2 = getMeasuredWidth();
                    th = getMeasuredHeight();
                    if (!(i2 == 0 || i == 0)) {
                        FrameLayout frameLayout = this.zzoQ;
                        LayoutParams layoutParams2 = layoutParams;
                        LayoutParams layoutParams3 = new LayoutParams(i2, i);
                        frameLayout.setLayoutParams(layoutParams2);
                        this.zzyG = false;
                    }
                }
                if (this.zzyf != null) {
                    this.zzyf.zzh(this.zzyD);
                }
            } finally {
                i = th;
                int i3 = i2;
                Throwable th = i;
            }
        }
    }

    public void onScrollChanged() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzyf != null) {
                    this.zzyf.zzh(this.zzyD);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View view2 = view;
        MotionEvent motionEvent2 = motionEvent;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzyf == null) {
                    return false;
                }
                Point zzc = zzc(motionEvent2);
                this.zzyH = zzc.x;
                this.zzyI = zzc.y;
                MotionEvent obtain = MotionEvent.obtain(motionEvent2);
                obtain.setLocation((float) zzc.x, (float) zzc.y);
                this.zzyf.zzb(obtain);
                obtain.recycle();
                return false;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public zzd zzK(String str) {
        zzd zzd;
        String str2 = str;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                WeakReference weakReference = (WeakReference) this.zzyE.get(str2);
                th = zze.zzC(weakReference == null ? null : (View) weakReference.get());
            } finally {
                zzd = th;
                Object obj2 = obj;
                Throwable th = zzd;
            }
        }
        return zzd;
    }

    /* JADX INFO: finally extract failed */
    public void zza(zzd zzd) {
        C01721 r11;
        WeakReference weakReference;
        zzd zzd2 = zzd;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzyG = true;
                zzi(null);
                Object zzp = zze.zzp(zzd2);
                if (!(zzp instanceof zzi)) {
                    zzin.zzaK("Not an instance of native engine. This is most likely a transient error");
                    return;
                }
                zzi zzi = (zzi) zzp;
                if (!(this.zzyf instanceof zzg) || !((zzg) this.zzyf).zzdP()) {
                    this.zzyf = zzi;
                    if (this.zzyf instanceof zzg) {
                        ((zzg) this.zzyf).zzc(null);
                    }
                } else {
                    ((zzg) this.zzyf).zzc(zzi);
                }
                this.zzoQ.removeAllViews();
                this.zzyF = zzd(zzi);
                if (this.zzyF != null) {
                    WeakReference weakReference2 = weakReference;
                    WeakReference weakReference3 = new WeakReference(this.zzyF.zzdI());
                    Object put = this.zzyE.put("1007", weakReference2);
                    this.zzoQ.addView(this.zzyF);
                }
                Handler handler = zzir.zzMc;
                C01721 r7 = r11;
                final zzi zzi2 = zzi;
                C01721 r8 = new Runnable(this) {
                    final /* synthetic */ zzk zzyK;

                    {
                        zzi zzi = r7;
                        this.zzyK = r6;
                    }

                    public void run() {
                        zzjp zzdR = zzi2.zzdR();
                        if (zzdR != null) {
                            this.zzyK.zzoQ.addView(zzdR.getView());
                        }
                    }
                };
                boolean post = handler.post(r7);
                zzi.zzg(this.zzyD);
                zzi(this.zzyD);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zza(String str, zzd zzd) {
        WeakReference weakReference;
        String str2 = str;
        View view = (View) zze.zzp(zzd);
        Object obj = this.zzpV;
        synchronized (obj) {
            if (view == null) {
                try {
                    Object remove = this.zzyE.remove(str2);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            } else {
                Map<String, WeakReference<View>> map = this.zzyE;
                String str3 = str2;
                WeakReference weakReference2 = weakReference;
                WeakReference weakReference3 = new WeakReference(view);
                Object put = map.put(str3, weakReference2);
                view.setOnTouchListener(this);
                view.setOnClickListener(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public Point zzc(MotionEvent motionEvent) {
        Point point;
        MotionEvent motionEvent2 = motionEvent;
        int[] iArr = new int[2];
        this.zzyD.getLocationOnScreen(iArr);
        Point point2 = point;
        Point point3 = new Point((int) (motionEvent2.getRawX() - ((float) iArr[0])), (int) (motionEvent2.getRawY() - ((float) iArr[1])));
        return point2;
    }

    /* access modifiers changed from: 0000 */
    public zzb zzd(zzi zzi) {
        return zzi.zza((OnClickListener) this);
    }

    /* access modifiers changed from: 0000 */
    public void zzi(View view) {
        View view2 = view;
        if (this.zzyf != null) {
            zzh zzh = this.zzyf instanceof zzg ? ((zzg) this.zzyf).zzdQ() : this.zzyf;
            if (zzh != null) {
                zzh.zzi(view2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public Point zzj(View view) {
        Point point;
        Rect rect;
        Point point2;
        Rect rect2;
        Point point3;
        Rect rect3;
        Point point4;
        View view2 = view;
        if (this.zzyF == null || !this.zzyF.zzdI().equals(view2)) {
            Point point5 = point;
            Point point6 = new Point();
            Point point7 = point5;
            View view3 = view2;
            Rect rect4 = rect;
            Rect rect5 = new Rect();
            boolean globalVisibleRect = view3.getGlobalVisibleRect(rect4, point7);
            return point7;
        }
        Point point8 = point2;
        Point point9 = new Point();
        Point point10 = point8;
        FrameLayout frameLayout = this.zzyD;
        Rect rect6 = rect2;
        Rect rect7 = new Rect();
        boolean globalVisibleRect2 = frameLayout.getGlobalVisibleRect(rect6, point10);
        Point point11 = point3;
        Point point12 = new Point();
        Point point13 = point11;
        View view4 = view2;
        Rect rect8 = rect3;
        Rect rect9 = new Rect();
        boolean globalVisibleRect3 = view4.getGlobalVisibleRect(rect8, point13);
        Point point14 = point4;
        Point point15 = new Point(point13.x - point10.x, point13.y - point10.y);
        return point14;
    }

    /* access modifiers changed from: 0000 */
    public int zzq(int i) {
        return zzn.zzcS().zzc(this.zzyf.getContext(), i);
    }
}
