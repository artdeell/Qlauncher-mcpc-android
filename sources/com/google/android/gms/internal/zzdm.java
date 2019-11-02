package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzr;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@zzhb
public final class zzdm implements zzdf {
    private final zze zzzA;
    private final zzfn zzzB;
    private final zzdh zzzD;

    public static class zza extends zzim {
        private final String zzF;
        private final zzjp zzpD;
        private final String zzzE = "play.google.com";
        private final String zzzF = "market";
        private final int zzzG = 10;

        public zza(zzjp zzjp, String str) {
            zzjp zzjp2 = zzjp;
            String str2 = str;
            this.zzpD = zzjp2;
            this.zzF = str2;
        }

        public void onStop() {
        }

        public Intent zzT(String str) {
            Intent intent;
            Uri parse = Uri.parse(str);
            Intent intent2 = intent;
            Intent intent3 = new Intent("android.intent.action.VIEW");
            Intent intent4 = intent2;
            Intent addFlags = intent4.addFlags(268435456);
            Intent data = intent4.setData(parse);
            return intent4;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0107, code lost:
            com.google.android.gms.internal.zzin.zzaK("Arrived at landing page, this ideally should not happen. Will open it in browser.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            r16.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0111, code lost:
            r5 = r4;
         */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0136  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0107 A[EDGE_INSN: B:71:0x0107->B:33:0x0107 ?: BREAK  
        EDGE_INSN: B:71:0x0107->B:33:0x0107 ?: BREAK  
        EDGE_INSN: B:71:0x0107->B:33:0x0107 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zzbr() {
            /*
                r32 = this;
                r2 = r32
                r26 = 0
                r3 = r26
                r26 = r2
                r0 = r26
                java.lang.String r0 = r0.zzF
                r26 = r0
                r4 = r26
            L_0x0010:
                r26 = r3
                r27 = 10
                r0 = r26
                r1 = r27
                if (r0 >= r1) goto L_0x0202
                r26 = r3
                r27 = 1
                int r26 = r26 + 1
                r7 = r26
                java.net.URL r26 = new java.net.URL     // Catch:{ IndexOutOfBoundsException -> 0x0150, IOException -> 0x017d, RuntimeException -> 0x01aa }
                r31 = r26
                r26 = r31
                r27 = r31
                r28 = r4
                r27.<init>(r28)     // Catch:{ IndexOutOfBoundsException -> 0x0150, IOException -> 0x017d, RuntimeException -> 0x01aa }
                r8 = r26
                java.lang.String r26 = "play.google.com"
                r27 = r8
                java.lang.String r27 = r27.getHost()     // Catch:{ IndexOutOfBoundsException -> 0x0150, IOException -> 0x017d, RuntimeException -> 0x01aa }
                boolean r26 = r26.equalsIgnoreCase(r27)     // Catch:{ IndexOutOfBoundsException -> 0x0150, IOException -> 0x017d, RuntimeException -> 0x01aa }
                r15 = r26
                r26 = r15
                if (r26 == 0) goto L_0x0067
                r26 = r4
                r5 = r26
            L_0x0047:
                r26 = r2
                r27 = r5
                android.content.Intent r26 = r26.zzT(r27)
                r6 = r26
                com.google.android.gms.internal.zzir r26 = com.google.android.gms.ads.internal.zzr.zzbC()
                r27 = r2
                r0 = r27
                com.google.android.gms.internal.zzjp r0 = r0.zzpD
                r27 = r0
                android.content.Context r27 = r27.getContext()
                r28 = r6
                r26.zzb(r27, r28)
                return
            L_0x0067:
                java.lang.String r26 = "market"
                r27 = r8
                java.lang.String r27 = r27.getProtocol()     // Catch:{ IndexOutOfBoundsException -> 0x0150, IOException -> 0x017d, RuntimeException -> 0x01aa }
                boolean r26 = r26.equalsIgnoreCase(r27)     // Catch:{ IndexOutOfBoundsException -> 0x0150, IOException -> 0x017d, RuntimeException -> 0x01aa }
                if (r26 == 0) goto L_0x007a
                r26 = r4
                r5 = r26
                goto L_0x0047
            L_0x007a:
                r26 = r8
                java.net.URLConnection r26 = r26.openConnection()     // Catch:{ IndexOutOfBoundsException -> 0x0150, IOException -> 0x017d, RuntimeException -> 0x01aa }
                java.net.HttpURLConnection r26 = (java.net.HttpURLConnection) r26     // Catch:{ IndexOutOfBoundsException -> 0x0150, IOException -> 0x017d, RuntimeException -> 0x01aa }
                r16 = r26
                com.google.android.gms.internal.zzir r26 = com.google.android.gms.ads.internal.zzr.zzbC()     // Catch:{ all -> 0x0145 }
                r27 = r2
                r0 = r27
                com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x0145 }
                r27 = r0
                android.content.Context r27 = r27.getContext()     // Catch:{ all -> 0x0145 }
                r28 = r2
                r0 = r28
                com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x0145 }
                r28 = r0
                com.google.android.gms.ads.internal.util.client.VersionInfoParcel r28 = r28.zzhX()     // Catch:{ all -> 0x0145 }
                r0 = r28
                java.lang.String r0 = r0.afmaVersion     // Catch:{ all -> 0x0145 }
                r28 = r0
                r29 = 0
                r30 = r16
                r26.zza(r27, r28, r29, r30)     // Catch:{ all -> 0x0145 }
                r26 = r16
                int r26 = r26.getResponseCode()     // Catch:{ all -> 0x0145 }
                r18 = r26
                r26 = r16
                java.util.Map r26 = r26.getHeaderFields()     // Catch:{ all -> 0x0145 }
                r19 = r26
                r26 = r18
                r27 = 300(0x12c, float:4.2E-43)
                r0 = r26
                r1 = r27
                if (r0 < r1) goto L_0x01fc
                r26 = r18
                r27 = 399(0x18f, float:5.59E-43)
                r0 = r26
                r1 = r27
                if (r0 > r1) goto L_0x01fc
                r26 = r19
                java.lang.String r27 = "Location"
                boolean r26 = r26.containsKey(r27)     // Catch:{ all -> 0x0145 }
                if (r26 == 0) goto L_0x0117
                r26 = r19
                java.lang.String r27 = "Location"
                java.lang.Object r26 = r26.get(r27)     // Catch:{ all -> 0x0145 }
                java.util.List r26 = (java.util.List) r26     // Catch:{ all -> 0x0145 }
                r25 = r26
            L_0x00e7:
                r26 = r25
                if (r26 == 0) goto L_0x01fc
                r26 = r25
                int r26 = r26.size()     // Catch:{ all -> 0x0145 }
                if (r26 <= 0) goto L_0x01fc
                r26 = r25
                r27 = 0
                java.lang.Object r26 = r26.get(r27)     // Catch:{ all -> 0x0145 }
                java.lang.String r26 = (java.lang.String) r26     // Catch:{ all -> 0x0145 }
                r20 = r26
            L_0x00ff:
                r26 = r20
                boolean r26 = android.text.TextUtils.isEmpty(r26)     // Catch:{ all -> 0x0145 }
                if (r26 == 0) goto L_0x0136
                java.lang.String r26 = "Arrived at landing page, this ideally should not happen. Will open it in browser."
                com.google.android.gms.internal.zzin.zzaK(r26)     // Catch:{ all -> 0x0145 }
                r26 = r16
                r26.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x0150, IOException -> 0x017d, RuntimeException -> 0x01aa }
                r26 = r4
                r5 = r26
                goto L_0x0047
            L_0x0117:
                r26 = r19
                java.lang.String r27 = "location"
                boolean r26 = r26.containsKey(r27)     // Catch:{ all -> 0x0145 }
                r24 = r26
                r26 = 0
                r25 = r26
                r26 = r24
                if (r26 == 0) goto L_0x00e7
                r26 = r19
                java.lang.String r27 = "location"
                java.lang.Object r26 = r26.get(r27)     // Catch:{ all -> 0x0145 }
                java.util.List r26 = (java.util.List) r26     // Catch:{ all -> 0x0145 }
                r25 = r26
                goto L_0x00e7
            L_0x0136:
                r26 = r16
                r26.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x01ef, IOException -> 0x01e3, RuntimeException -> 0x01d7 }
                r26 = r7
                r3 = r26
                r26 = r20
                r4 = r26
                goto L_0x0010
            L_0x0145:
                r26 = move-exception
                r17 = r26
                r26 = r16
                r26.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x0150, IOException -> 0x017d, RuntimeException -> 0x01aa }
                r26 = r17
                throw r26     // Catch:{ IndexOutOfBoundsException -> 0x0150, IOException -> 0x017d, RuntimeException -> 0x01aa }
            L_0x0150:
                r26 = move-exception
                r13 = r26
                r26 = r13
                r14 = r26
                r26 = r4
                r5 = r26
            L_0x015b:
                java.lang.StringBuilder r26 = new java.lang.StringBuilder
                r31 = r26
                r26 = r31
                r27 = r31
                r27.<init>()
                java.lang.String r27 = "Error while parsing ping URL: "
                java.lang.StringBuilder r26 = r26.append(r27)
                r27 = r5
                java.lang.StringBuilder r26 = r26.append(r27)
                java.lang.String r26 = r26.toString()
                r27 = r14
                com.google.android.gms.internal.zzin.zzd(r26, r27)
                goto L_0x0047
            L_0x017d:
                r26 = move-exception
                r11 = r26
                r26 = r11
                r12 = r26
                r26 = r4
                r5 = r26
            L_0x0188:
                java.lang.StringBuilder r26 = new java.lang.StringBuilder
                r31 = r26
                r26 = r31
                r27 = r31
                r27.<init>()
                java.lang.String r27 = "Error while pinging URL: "
                java.lang.StringBuilder r26 = r26.append(r27)
                r27 = r5
                java.lang.StringBuilder r26 = r26.append(r27)
                java.lang.String r26 = r26.toString()
                r27 = r12
                com.google.android.gms.internal.zzin.zzd(r26, r27)
                goto L_0x0047
            L_0x01aa:
                r26 = move-exception
                r9 = r26
                r26 = r9
                r10 = r26
                r26 = r4
                r5 = r26
            L_0x01b5:
                java.lang.StringBuilder r26 = new java.lang.StringBuilder
                r31 = r26
                r26 = r31
                r27 = r31
                r27.<init>()
                java.lang.String r27 = "Error while pinging URL: "
                java.lang.StringBuilder r26 = r26.append(r27)
                r27 = r5
                java.lang.StringBuilder r26 = r26.append(r27)
                java.lang.String r26 = r26.toString()
                r27 = r10
                com.google.android.gms.internal.zzin.zzd(r26, r27)
                goto L_0x0047
            L_0x01d7:
                r26 = move-exception
                r23 = r26
                r26 = r20
                r5 = r26
                r26 = r23
                r10 = r26
                goto L_0x01b5
            L_0x01e3:
                r26 = move-exception
                r22 = r26
                r26 = r20
                r5 = r26
                r26 = r22
                r12 = r26
                goto L_0x0188
            L_0x01ef:
                r26 = move-exception
                r21 = r26
                r26 = r20
                r5 = r26
                r26 = r21
                r14 = r26
                goto L_0x015b
            L_0x01fc:
                java.lang.String r26 = ""
                r20 = r26
                goto L_0x00ff
            L_0x0202:
                r26 = r4
                r5 = r26
                goto L_0x0047
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.zza.zzbr():void");
        }
    }

    public static class zzb {
        private final zzjp zzpD;

        public zzb(zzjp zzjp) {
            this.zzpD = zzjp;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0125, code lost:
            if (zza(r2, r7) == null) goto L_0x0127;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.content.Intent zza(android.content.Context r27, java.util.Map<java.lang.String, java.lang.String> r28) {
            /*
                r26 = this;
                r1 = r26
                r2 = r27
                r3 = r28
                r21 = r2
                java.lang.String r22 = "activity"
                java.lang.Object r21 = r21.getSystemService(r22)
                android.app.ActivityManager r21 = (android.app.ActivityManager) r21
                r4 = r21
                r21 = r3
                java.lang.String r22 = "u"
                java.lang.Object r21 = r21.get(r22)
                java.lang.String r21 = (java.lang.String) r21
                r5 = r21
                r21 = r5
                boolean r21 = android.text.TextUtils.isEmpty(r21)
                r6 = r21
                r21 = 0
                r7 = r21
                r21 = r6
                if (r21 == 0) goto L_0x0033
            L_0x002e:
                r21 = r7
                r1 = r21
            L_0x0032:
                return r1
            L_0x0033:
                r21 = r1
                r0 = r21
                com.google.android.gms.internal.zzjp r0 = r0.zzpD
                r21 = r0
                if (r21 == 0) goto L_0x0051
                com.google.android.gms.internal.zzir r21 = com.google.android.gms.ads.internal.zzr.zzbC()
                r22 = r1
                r0 = r22
                com.google.android.gms.internal.zzjp r0 = r0.zzpD
                r22 = r0
                r23 = r5
                java.lang.String r21 = r21.zza(r22, r23)
                r5 = r21
            L_0x0051:
                r21 = r5
                android.net.Uri r21 = android.net.Uri.parse(r21)
                r8 = r21
                r21 = r3
                java.lang.String r22 = "use_first_package"
                java.lang.Object r21 = r21.get(r22)
                java.lang.String r21 = (java.lang.String) r21
                boolean r21 = java.lang.Boolean.parseBoolean(r21)
                r9 = r21
                r21 = r3
                java.lang.String r22 = "use_running_process"
                java.lang.Object r21 = r21.get(r22)
                java.lang.String r21 = (java.lang.String) r21
                boolean r21 = java.lang.Boolean.parseBoolean(r21)
                r10 = r21
                java.lang.String r21 = "http"
                r22 = r8
                java.lang.String r22 = r22.getScheme()
                boolean r21 = r21.equalsIgnoreCase(r22)
                if (r21 == 0) goto L_0x00da
                r21 = r8
                android.net.Uri$Builder r21 = r21.buildUpon()
                java.lang.String r22 = "https"
                android.net.Uri$Builder r21 = r21.scheme(r22)
                android.net.Uri r21 = r21.build()
                r11 = r21
            L_0x0099:
                java.util.ArrayList r21 = new java.util.ArrayList
                r25 = r21
                r21 = r25
                r22 = r25
                r22.<init>()
                r12 = r21
                r21 = r1
                r22 = r8
                android.content.Intent r21 = r21.zzd(r22)
                r13 = r21
                r21 = r1
                r22 = r11
                android.content.Intent r21 = r21.zzd(r22)
                r14 = r21
                r21 = r1
                r22 = r2
                r23 = r13
                r24 = r12
                android.content.pm.ResolveInfo r21 = r21.zza(r22, r23, r24)
                r15 = r21
                r21 = r15
                if (r21 == 0) goto L_0x00fb
                r21 = r1
                r22 = r13
                r23 = r15
                android.content.Intent r21 = r21.zza(r22, r23)
                r1 = r21
                goto L_0x0032
            L_0x00da:
                java.lang.String r21 = "https"
                r22 = r8
                java.lang.String r22 = r22.getScheme()
                boolean r21 = r21.equalsIgnoreCase(r22)
                if (r21 == 0) goto L_0x01c3
                r21 = r8
                android.net.Uri$Builder r21 = r21.buildUpon()
                java.lang.String r22 = "http"
                android.net.Uri$Builder r21 = r21.scheme(r22)
                android.net.Uri r21 = r21.build()
                r11 = r21
                goto L_0x0099
            L_0x00fb:
                r21 = r14
                if (r21 == 0) goto L_0x0127
                r21 = r1
                r22 = r2
                r23 = r14
                android.content.pm.ResolveInfo r21 = r21.zza(r22, r23)
                r20 = r21
                r21 = r20
                if (r21 == 0) goto L_0x0127
                r21 = r1
                r22 = r13
                r23 = r20
                android.content.Intent r21 = r21.zza(r22, r23)
                r7 = r21
                r21 = r1
                r22 = r2
                r23 = r7
                android.content.pm.ResolveInfo r21 = r21.zza(r22, r23)
                if (r21 != 0) goto L_0x002e
            L_0x0127:
                r21 = r12
                int r21 = r21.size()
                if (r21 != 0) goto L_0x0135
                r21 = r13
                r1 = r21
                goto L_0x0032
            L_0x0135:
                r21 = r10
                if (r21 == 0) goto L_0x01a3
                r21 = r4
                if (r21 == 0) goto L_0x01a3
                r21 = r4
                java.util.List r21 = r21.getRunningAppProcesses()
                r16 = r21
                r21 = r16
                if (r21 == 0) goto L_0x01a3
                r21 = r12
                java.util.Iterator r21 = r21.iterator()
                r17 = r21
            L_0x0151:
                r21 = r17
                boolean r21 = r21.hasNext()
                if (r21 == 0) goto L_0x01a3
                r21 = r17
                java.lang.Object r21 = r21.next()
                android.content.pm.ResolveInfo r21 = (android.content.pm.ResolveInfo) r21
                r18 = r21
                r21 = r16
                java.util.Iterator r21 = r21.iterator()
                r19 = r21
            L_0x016b:
                r21 = r19
                boolean r21 = r21.hasNext()
                if (r21 == 0) goto L_0x0151
                r21 = r19
                java.lang.Object r21 = r21.next()
                android.app.ActivityManager$RunningAppProcessInfo r21 = (android.app.ActivityManager.RunningAppProcessInfo) r21
                r0 = r21
                java.lang.String r0 = r0.processName
                r21 = r0
                r22 = r18
                r0 = r22
                android.content.pm.ActivityInfo r0 = r0.activityInfo
                r22 = r0
                r0 = r22
                java.lang.String r0 = r0.packageName
                r22 = r0
                boolean r21 = r21.equals(r22)
                if (r21 == 0) goto L_0x016b
                r21 = r1
                r22 = r13
                r23 = r18
                android.content.Intent r21 = r21.zza(r22, r23)
                r1 = r21
                goto L_0x0032
            L_0x01a3:
                r21 = r9
                if (r21 == 0) goto L_0x01bd
                r21 = r1
                r22 = r13
                r23 = r12
                r24 = 0
                java.lang.Object r23 = r23.get(r24)
                android.content.pm.ResolveInfo r23 = (android.content.pm.ResolveInfo) r23
                android.content.Intent r21 = r21.zza(r22, r23)
                r1 = r21
                goto L_0x0032
            L_0x01bd:
                r21 = r13
                r1 = r21
                goto L_0x0032
            L_0x01c3:
                r21 = 0
                r11 = r21
                goto L_0x0099
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.zzb.zza(android.content.Context, java.util.Map):android.content.Intent");
        }

        public Intent zza(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2;
            ResolveInfo resolveInfo2 = resolveInfo;
            Intent intent3 = intent2;
            Intent intent4 = new Intent(intent);
            Intent intent5 = intent3;
            Intent className = intent5.setClassName(resolveInfo2.activityInfo.packageName, resolveInfo2.activityInfo.name);
            return intent5;
        }

        public ResolveInfo zza(Context context, Intent intent) {
            ArrayList arrayList;
            Context context2 = context;
            Intent intent2 = intent;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            return zza(context2, intent2, arrayList2);
        }

        public ResolveInfo zza(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            ResolveInfo resolveInfo;
            Intent intent2 = intent;
            ArrayList<ResolveInfo> arrayList2 = arrayList;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List queryIntentActivities = packageManager.queryIntentActivities(intent2, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent2, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i = 0;
                while (true) {
                    if (i >= queryIntentActivities.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo2 = (ResolveInfo) queryIntentActivities.get(i);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                    i++;
                }
                boolean addAll = arrayList2.addAll(queryIntentActivities);
                return resolveInfo;
            }
            resolveInfo = null;
            boolean addAll2 = arrayList2.addAll(queryIntentActivities);
            return resolveInfo;
        }

        public Intent zzd(Uri uri) {
            Intent intent;
            Uri uri2 = uri;
            if (uri2 == null) {
                return null;
            }
            Intent intent2 = intent;
            Intent intent3 = new Intent("android.intent.action.VIEW");
            Intent intent4 = intent2;
            Intent addFlags = intent4.addFlags(268435456);
            Intent data = intent4.setData(uri2);
            Intent action = intent4.setAction("android.intent.action.VIEW");
            return intent4;
        }
    }

    public zzdm(zzdh zzdh, zze zze, zzfn zzfn) {
        zze zze2 = zze;
        zzfn zzfn2 = zzfn;
        this.zzzD = zzdh;
        this.zzzA = zze2;
        this.zzzB = zzfn2;
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzr.zzbE().zzhw();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzr.zzbE().zzhv();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzr.zzbE().zzhx();
            }
        }
        return -1;
    }

    private static void zze(zzjp zzjp, Map<String, String> map) {
        zza zza2;
        zzjp zzjp2 = zzjp;
        String str = (String) map.get("u");
        if (TextUtils.isEmpty(str)) {
            zzin.zzaK("Destination url cannot be empty.");
            return;
        }
        zza zza3 = zza2;
        zza zza4 = new zza(zzjp2, str);
        Future zzhn = zza3.zzgd();
    }

    private static void zzf(zzjp zzjp, Map<String, String> map) {
        zzb zzb2;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel;
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        Context context = zzjp2.getContext();
        if (TextUtils.isEmpty((String) map2.get("u"))) {
            zzin.zzaK("Destination url cannot be empty.");
            return;
        }
        zzjq zzhU = zzjp2.zzhU();
        zzb zzb3 = zzb2;
        zzb zzb4 = new zzb(zzjp2);
        Intent zza2 = zzb3.zza(context, map2);
        zzjq zzjq = zzhU;
        try {
            AdLauncherIntentInfoParcel adLauncherIntentInfoParcel2 = adLauncherIntentInfoParcel;
            AdLauncherIntentInfoParcel adLauncherIntentInfoParcel3 = new AdLauncherIntentInfoParcel(zza2);
            zzjq.zza(adLauncherIntentInfoParcel2);
        } catch (ActivityNotFoundException e) {
            zzin.zzaK(e.getMessage());
        }
    }

    private void zzo(boolean z) {
        boolean z2 = z;
        if (this.zzzB != null) {
            this.zzzB.zzp(z2);
        }
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel;
        ArrayList arrayList;
        ArrayList arrayList2;
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        String str = (String) map2.get("a");
        if (str == null) {
            zzin.zzaK("Action missing from an open GMSG.");
        } else if (this.zzzA == null || this.zzzA.zzbh()) {
            zzjq zzhU = zzjp2.zzhU();
            if ("expand".equalsIgnoreCase(str)) {
                if (zzjp2.zzhY()) {
                    zzin.zzaK("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzo(false);
                zzhU.zza(zzc(map2), zzd(map2));
            } else if ("webapp".equalsIgnoreCase(str)) {
                String str2 = (String) map2.get("u");
                zzo(false);
                if (str2 != null) {
                    zzhU.zza(zzc(map2), zzd(map2), str2);
                } else {
                    zzhU.zza(zzc(map2), zzd(map2), (String) map2.get("html"), (String) map2.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                String str3 = (String) map2.get("product_id");
                String str4 = (String) map2.get("report_urls");
                if (this.zzzD == null) {
                    return;
                }
                if (str4 == null || str4.isEmpty()) {
                    zzdh zzdh = this.zzzD;
                    String str5 = str3;
                    ArrayList arrayList3 = arrayList;
                    ArrayList arrayList4 = new ArrayList();
                    zzdh.zza(str5, arrayList3);
                    return;
                }
                String[] split = str4.split(" ");
                zzdh zzdh2 = this.zzzD;
                String str6 = str3;
                ArrayList arrayList5 = arrayList2;
                ArrayList arrayList6 = new ArrayList(Arrays.asList(split));
                zzdh2.zza(str6, arrayList5);
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map2.get("play_store"))) {
                zze(zzjp2, map2);
            } else if (!"app".equalsIgnoreCase(str) || !"true".equalsIgnoreCase((String) map2.get("system_browser"))) {
                zzo(true);
                String str7 = (String) map2.get("u");
                zzjq zzjq = zzhU;
                AdLauncherIntentInfoParcel adLauncherIntentInfoParcel2 = adLauncherIntentInfoParcel;
                AdLauncherIntentInfoParcel adLauncherIntentInfoParcel3 = new AdLauncherIntentInfoParcel((String) map2.get("i"), !TextUtils.isEmpty(str7) ? zzr.zzbC().zza(zzjp2, str7) : str7, (String) map2.get("m"), (String) map2.get("p"), (String) map2.get("c"), (String) map2.get("f"), (String) map2.get("e"));
                zzjq.zza(adLauncherIntentInfoParcel2);
            } else {
                zzo(true);
                zzf(zzjp2, map2);
            }
        } else {
            this.zzzA.zzq((String) map2.get("u"));
        }
    }
}
