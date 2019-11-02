package com.google.android.gms.ads.internal.purchase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.util.Locale;

@zzhb
public class zzh {
    /* access modifiers changed from: private */
    public static final String zzFV;
    private static zzh zzFX;
    private static final Object zzpV;
    private final zza zzFW;

    public class zza extends SQLiteOpenHelper {
        final /* synthetic */ zzh zzFY;

        public zza(zzh zzh, Context context, String str) {
            Context context2 = context;
            String str2 = str;
            this.zzFY = zzh;
            super(context2, str2, null, 4);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(zzh.zzFV);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            StringBuilder sb;
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            int i3 = i;
            int i4 = i2;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.zzaJ(sb2.append("Database updated from version ").append(i3).append(" to version ").append(i4).toString());
            sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(sQLiteDatabase2);
        }
    }

    static {
        Object obj;
        Object[] objArr = new Object[5];
        Object[] objArr2 = objArr;
        objArr[0] = "InAppPurchase";
        Object[] objArr3 = objArr2;
        Object[] objArr4 = objArr3;
        objArr3[1] = "purchase_id";
        Object[] objArr5 = objArr4;
        Object[] objArr6 = objArr5;
        objArr5[2] = "product_id";
        Object[] objArr7 = objArr6;
        Object[] objArr8 = objArr7;
        objArr7[3] = "developer_payload";
        Object[] objArr9 = objArr8;
        Object[] objArr10 = objArr9;
        objArr9[4] = "record_time";
        zzFV = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", objArr10);
        Object obj2 = obj;
        Object obj3 = new Object();
        zzpV = obj2;
    }

    zzh(Context context) {
        zza zza2;
        zza zza3 = zza2;
        zza zza4 = new zza(this, context, "google_inapp_purchase.db");
        this.zzFW = zza3;
    }

    public static zzh zzy(Context context) {
        zzh zzh;
        zzh zzh2;
        Context context2 = context;
        Object obj = zzpV;
        synchronized (obj) {
            try {
                if (zzFX == null) {
                    zzh zzh3 = zzh2;
                    zzh zzh4 = new zzh(context2);
                    zzFX = zzh3;
                }
                th = zzFX;
            } finally {
                zzh = th;
                Object obj2 = obj;
                Throwable th = zzh;
            }
        }
        return zzh;
    }

    public int getRecordCount() {
        StringBuilder sb;
        Object obj = zzpV;
        synchronized (obj) {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return 0;
                }
                Cursor rawQuery = writableDatabase.rawQuery("select count(*) from InAppPurchase", null);
                if (rawQuery.moveToFirst()) {
                    int i = rawQuery.getInt(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return i;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return 0;
            } catch (SQLiteException e) {
                SQLiteException sQLiteException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zzin.zzaK(sb2.append("Error getting record count").append(sQLiteException.getMessage()).toString());
                if (0 != 0) {
                    null.close();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzFW.getWritableDatabase();
        } catch (SQLiteException e) {
            SQLiteException sQLiteException = e;
            zzin.zzaK("Error opening writable conversion tracking database");
            return null;
        }
    }

    public zzf zza(Cursor cursor) {
        zzf zzf;
        Cursor cursor2 = cursor;
        if (cursor2 == null) {
            return null;
        }
        zzf zzf2 = zzf;
        zzf zzf3 = new zzf(cursor2.getLong(0), cursor2.getString(1), cursor2.getString(2));
        return zzf2;
    }

    /* JADX INFO: finally extract failed */
    public void zza(zzf zzf) {
        zzf zzf2 = zzf;
        if (zzf2 != null) {
            Object obj = zzpV;
            synchronized (obj) {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    if (writableDatabase != null) {
                        int delete = writableDatabase.delete("InAppPurchase", String.format(Locale.US, "%s = %d", new Object[]{"purchase_id", Long.valueOf(zzf2.zzFP)}), null);
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzb(zzf zzf) {
        ContentValues contentValues;
        zzf zzf2 = zzf;
        if (zzf2 != null) {
            Object obj = zzpV;
            synchronized (obj) {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    if (writableDatabase != null) {
                        ContentValues contentValues2 = contentValues;
                        ContentValues contentValues3 = new ContentValues();
                        ContentValues contentValues4 = contentValues2;
                        contentValues4.put("product_id", zzf2.zzFR);
                        contentValues4.put("developer_payload", zzf2.zzFQ);
                        contentValues4.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
                        zzf2.zzFP = writableDatabase.insert("InAppPurchase", null, contentValues4);
                        if (((long) getRecordCount()) > 20000) {
                            zzfY();
                        }
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007c A[Catch:{ all -> 0x0077, all -> 0x0044 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzfY() {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r8 = zzpV
            r1 = r8
            r8 = r1
            monitor-enter(r8)
            r8 = r0
            android.database.sqlite.SQLiteDatabase r8 = r8.getWritableDatabase()     // Catch:{ all -> 0x0044 }
            r3 = r8
            r8 = r3
            if (r8 != 0) goto L_0x0013
            r8 = r1
            monitor-exit(r8)     // Catch:{ all -> 0x0044 }
        L_0x0012:
            return
        L_0x0013:
            r8 = r3
            java.lang.String r9 = "InAppPurchase"
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            java.lang.String r15 = "record_time ASC"
            java.lang.String r16 = "1"
            android.database.Cursor r8 = r8.query(r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x004a, all -> 0x0085 }
            r7 = r8
            r8 = r7
            r5 = r8
            r8 = r5
            if (r8 == 0) goto L_0x003a
            r8 = r5
            boolean r8 = r8.moveToFirst()     // Catch:{ SQLiteException -> 0x0082 }
            if (r8 == 0) goto L_0x003a
            r8 = r0
            r9 = r0
            r10 = r5
            com.google.android.gms.ads.internal.purchase.zzf r9 = r9.zza(r10)     // Catch:{ SQLiteException -> 0x0082 }
            r8.zza(r9)     // Catch:{ SQLiteException -> 0x0082 }
        L_0x003a:
            r8 = r5
            if (r8 == 0) goto L_0x0041
            r8 = r5
            r8.close()     // Catch:{ all -> 0x0044 }
        L_0x0041:
            r8 = r1
            monitor-exit(r8)     // Catch:{ all -> 0x0044 }
            goto L_0x0012
        L_0x0044:
            r8 = move-exception
            r2 = r8
            r8 = r1
            monitor-exit(r8)     // Catch:{ all -> 0x0044 }
            r8 = r2
            throw r8
        L_0x004a:
            r8 = move-exception
            r6 = r8
            r8 = 0
            r5 = r8
        L_0x004e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r17 = r8
            r8 = r17
            r9 = r17
            r9.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r9 = "Error remove oldest record"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x0077 }
            r9 = r6
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0077 }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x0077 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0077 }
            com.google.android.gms.internal.zzin.zzaK(r8)     // Catch:{ all -> 0x0077 }
            r8 = r5
            if (r8 == 0) goto L_0x0041
            r8 = r5
            r8.close()     // Catch:{ all -> 0x0044 }
            goto L_0x0041
        L_0x0077:
            r8 = move-exception
            r4 = r8
        L_0x0079:
            r8 = r5
            if (r8 == 0) goto L_0x0080
            r8 = r5
            r8.close()     // Catch:{ all -> 0x0044 }
        L_0x0080:
            r8 = r4
            throw r8     // Catch:{ all -> 0x0044 }
        L_0x0082:
            r8 = move-exception
            r6 = r8
            goto L_0x004e
        L_0x0085:
            r8 = move-exception
            r4 = r8
            r8 = 0
            r5 = r8
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzh.zzfY():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.ads.internal.purchase.zzf> zzg(long r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            java.lang.Object r13 = zzpV
            r3 = r13
            r13 = r3
            monitor-enter(r13)
            java.util.LinkedList r13 = new java.util.LinkedList     // Catch:{ all -> 0x009e }
            r23 = r13
            r13 = r23
            r14 = r23
            r14.<init>()     // Catch:{ all -> 0x009e }
            r4 = r13
            r13 = r1
            r15 = 0
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 > 0) goto L_0x0021
            r13 = r3
            monitor-exit(r13)     // Catch:{ all -> 0x009e }
            r13 = r4
            r0 = r13
        L_0x0020:
            return r0
        L_0x0021:
            r13 = r0
            android.database.sqlite.SQLiteDatabase r13 = r13.getWritableDatabase()     // Catch:{ all -> 0x009e }
            r6 = r13
            r13 = r6
            if (r13 != 0) goto L_0x002f
            r13 = r3
            monitor-exit(r13)     // Catch:{ all -> 0x009e }
            r13 = r4
            r0 = r13
            goto L_0x0020
        L_0x002f:
            r13 = r6
            java.lang.String r14 = "InAppPurchase"
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            java.lang.String r20 = "record_time ASC"
            r21 = r1
            java.lang.String r21 = java.lang.String.valueOf(r21)     // Catch:{ SQLiteException -> 0x0071, all -> 0x00a4 }
            android.database.Cursor r13 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x0071, all -> 0x00a4 }
            r10 = r13
            r13 = r10
            r8 = r13
            r13 = r8
            boolean r13 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x00b4 }
            if (r13 == 0) goto L_0x0065
        L_0x0051:
            r13 = r4
            r14 = r0
            r15 = r8
            com.google.android.gms.ads.internal.purchase.zzf r14 = r14.zza(r15)     // Catch:{ SQLiteException -> 0x00b4 }
            boolean r13 = r13.add(r14)     // Catch:{ SQLiteException -> 0x00b4 }
            r13 = r8
            boolean r13 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x00b4 }
            r12 = r13
            r13 = r12
            if (r13 != 0) goto L_0x0051
        L_0x0065:
            r13 = r8
            if (r13 == 0) goto L_0x006c
            r13 = r8
            r13.close()     // Catch:{ all -> 0x009e }
        L_0x006c:
            r13 = r3
            monitor-exit(r13)     // Catch:{ all -> 0x009e }
            r13 = r4
            r0 = r13
            goto L_0x0020
        L_0x0071:
            r13 = move-exception
            r9 = r13
            r13 = 0
            r8 = r13
        L_0x0075:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
            r23 = r13
            r13 = r23
            r14 = r23
            r14.<init>()     // Catch:{ all -> 0x00b1 }
            java.lang.String r14 = "Error extracing purchase info: "
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ all -> 0x00b1 }
            r14 = r9
            java.lang.String r14 = r14.getMessage()     // Catch:{ all -> 0x00b1 }
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ all -> 0x00b1 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.internal.zzin.zzaK(r13)     // Catch:{ all -> 0x00b1 }
            r13 = r8
            if (r13 == 0) goto L_0x006c
            r13 = r8
            r13.close()     // Catch:{ all -> 0x009e }
            goto L_0x006c
        L_0x009e:
            r13 = move-exception
            r5 = r13
            r13 = r3
            monitor-exit(r13)     // Catch:{ all -> 0x009e }
            r13 = r5
            throw r13
        L_0x00a4:
            r13 = move-exception
            r7 = r13
            r13 = 0
            r8 = r13
        L_0x00a8:
            r13 = r8
            if (r13 == 0) goto L_0x00af
            r13 = r8
            r13.close()     // Catch:{ all -> 0x009e }
        L_0x00af:
            r13 = r7
            throw r13     // Catch:{ all -> 0x009e }
        L_0x00b1:
            r13 = move-exception
            r7 = r13
            goto L_0x00a8
        L_0x00b4:
            r13 = move-exception
            r9 = r13
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzh.zzg(long):java.util.List");
    }
}
