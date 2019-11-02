package android.support.p000v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.ipaulpro.afilechooser.utils.MimeTypeParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* renamed from: android.support.v4.content.LocalBroadcastManager */
public class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock;
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers;

    /* renamed from: android.support.v4.content.LocalBroadcastManager$BroadcastRecord */
    private static class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        BroadcastRecord(Intent intent2, ArrayList<ReceiverRecord> arrayList) {
            ArrayList<ReceiverRecord> arrayList2 = arrayList;
            this.intent = intent2;
            this.receivers = arrayList2;
        }
    }

    /* renamed from: android.support.v4.content.LocalBroadcastManager$ReceiverRecord */
    private static class ReceiverRecord {
        boolean broadcasting;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            BroadcastReceiver broadcastReceiver2 = broadcastReceiver;
            this.filter = intentFilter;
            this.receiver = broadcastReceiver2;
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder(128);
            StringBuilder sb4 = sb2;
            StringBuilder append = sb4.append("Receiver{");
            StringBuilder append2 = sb4.append(this.receiver);
            StringBuilder append3 = sb4.append(" filter=");
            StringBuilder append4 = sb4.append(this.filter);
            StringBuilder append5 = sb4.append("}");
            return sb4.toString();
        }
    }

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        mLock = obj2;
    }

    private LocalBroadcastManager(Context context) {
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap;
        HashMap<String, ArrayList<ReceiverRecord>> hashMap2;
        ArrayList<BroadcastRecord> arrayList;
        C00351 r7;
        Context context2 = context;
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap3 = hashMap;
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap4 = new HashMap<>();
        this.mReceivers = hashMap3;
        HashMap<String, ArrayList<ReceiverRecord>> hashMap5 = hashMap2;
        HashMap<String, ArrayList<ReceiverRecord>> hashMap6 = new HashMap<>();
        this.mActions = hashMap5;
        ArrayList<BroadcastRecord> arrayList2 = arrayList;
        ArrayList<BroadcastRecord> arrayList3 = new ArrayList<>();
        this.mPendingBroadcasts = arrayList2;
        this.mAppContext = context2;
        C00351 r3 = r7;
        C00351 r4 = new Handler(this, context2.getMainLooper()) {
            final /* synthetic */ LocalBroadcastManager this$0;

            {
                Looper looper = r7;
                this.this$0 = r6;
            }

            public void handleMessage(Message message) {
                Message message2 = message;
                switch (message2.what) {
                    case 1:
                        this.this$0.executePendingBroadcasts();
                        return;
                    default:
                        super.handleMessage(message2);
                        return;
                }
            }
        };
        this.mHandler = r3;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if (r6 >= r4.length) goto L_0x0001;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        r7 = r4[r6];
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r8 >= r7.receivers.size()) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        ((android.support.p000v4.content.LocalBroadcastManager.ReceiverRecord) r7.receivers.get(r8)).receiver.onReceive(r0.mAppContext, r7.intent);
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        r6 = r6 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executePendingBroadcasts() {
        /*
            r12 = this;
            r0 = r12
        L_0x0001:
            r9 = r0
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<android.content.IntentFilter>> r9 = r9.mReceivers
            r1 = r9
            r9 = r1
            monitor-enter(r9)
            r9 = r0
            java.util.ArrayList<android.support.v4.content.LocalBroadcastManager$BroadcastRecord> r9 = r9.mPendingBroadcasts     // Catch:{ all -> 0x0059 }
            int r9 = r9.size()     // Catch:{ all -> 0x0059 }
            r3 = r9
            r9 = r3
            if (r9 > 0) goto L_0x0015
            r9 = r1
            monitor-exit(r9)     // Catch:{ all -> 0x0059 }
            return
        L_0x0015:
            r9 = r3
            android.support.v4.content.LocalBroadcastManager$BroadcastRecord[] r9 = new android.support.p000v4.content.LocalBroadcastManager.BroadcastRecord[r9]     // Catch:{ all -> 0x0059 }
            r4 = r9
            r9 = r0
            java.util.ArrayList<android.support.v4.content.LocalBroadcastManager$BroadcastRecord> r9 = r9.mPendingBroadcasts     // Catch:{ all -> 0x0059 }
            r10 = r4
            java.lang.Object[] r9 = r9.toArray(r10)     // Catch:{ all -> 0x0059 }
            r9 = r0
            java.util.ArrayList<android.support.v4.content.LocalBroadcastManager$BroadcastRecord> r9 = r9.mPendingBroadcasts     // Catch:{ all -> 0x0059 }
            r9.clear()     // Catch:{ all -> 0x0059 }
            r9 = r1
            monitor-exit(r9)     // Catch:{ all -> 0x0059 }
            r9 = 0
            r6 = r9
        L_0x002b:
            r9 = r6
            r10 = r4
            int r10 = r10.length
            if (r9 >= r10) goto L_0x0001
            r9 = r4
            r10 = r6
            r9 = r9[r10]
            r7 = r9
            r9 = 0
            r8 = r9
        L_0x0037:
            r9 = r8
            r10 = r7
            java.util.ArrayList<android.support.v4.content.LocalBroadcastManager$ReceiverRecord> r10 = r10.receivers
            int r10 = r10.size()
            if (r9 >= r10) goto L_0x005f
            r9 = r7
            java.util.ArrayList<android.support.v4.content.LocalBroadcastManager$ReceiverRecord> r9 = r9.receivers
            r10 = r8
            java.lang.Object r9 = r9.get(r10)
            android.support.v4.content.LocalBroadcastManager$ReceiverRecord r9 = (android.support.p000v4.content.LocalBroadcastManager.ReceiverRecord) r9
            android.content.BroadcastReceiver r9 = r9.receiver
            r10 = r0
            android.content.Context r10 = r10.mAppContext
            r11 = r7
            android.content.Intent r11 = r11.intent
            r9.onReceive(r10, r11)
            int r8 = r8 + 1
            goto L_0x0037
        L_0x0059:
            r9 = move-exception
            r2 = r9
            r9 = r1
            monitor-exit(r9)     // Catch:{ all -> 0x0059 }
            r9 = r2
            throw r9
        L_0x005f:
            int r6 = r6 + 1
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.content.LocalBroadcastManager.executePendingBroadcasts():void");
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        LocalBroadcastManager localBroadcastManager2;
        Context context2 = context;
        Object obj = mLock;
        synchronized (obj) {
            try {
                if (mInstance == null) {
                    LocalBroadcastManager localBroadcastManager3 = localBroadcastManager2;
                    LocalBroadcastManager localBroadcastManager4 = new LocalBroadcastManager(context2.getApplicationContext());
                    mInstance = localBroadcastManager3;
                }
                th = mInstance;
            } finally {
                localBroadcastManager = th;
                Object obj2 = obj;
                Throwable th = localBroadcastManager;
            }
        }
        return localBroadcastManager;
    }

    /* JADX INFO: finally extract failed */
    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        ReceiverRecord receiverRecord;
        ArrayList arrayList;
        ArrayList arrayList2;
        BroadcastReceiver broadcastReceiver2 = broadcastReceiver;
        IntentFilter intentFilter2 = intentFilter;
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap = this.mReceivers;
        synchronized (hashMap) {
            try {
                ReceiverRecord receiverRecord2 = receiverRecord;
                ReceiverRecord receiverRecord3 = new ReceiverRecord(intentFilter2, broadcastReceiver2);
                ReceiverRecord receiverRecord4 = receiverRecord2;
                ArrayList arrayList3 = (ArrayList) this.mReceivers.get(broadcastReceiver2);
                if (arrayList3 == null) {
                    ArrayList arrayList4 = arrayList2;
                    ArrayList arrayList5 = new ArrayList(1);
                    arrayList3 = arrayList4;
                    Object put = this.mReceivers.put(broadcastReceiver2, arrayList3);
                }
                boolean add = arrayList3.add(intentFilter2);
                for (int i = 0; i < intentFilter2.countActions(); i++) {
                    String action = intentFilter2.getAction(i);
                    ArrayList arrayList6 = (ArrayList) this.mActions.get(action);
                    if (arrayList6 == null) {
                        ArrayList arrayList7 = arrayList;
                        ArrayList arrayList8 = new ArrayList(1);
                        arrayList6 = arrayList7;
                        Object put2 = this.mActions.put(action, arrayList6);
                    }
                    boolean add2 = arrayList6.add(receiverRecord4);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap2 = hashMap;
                throw th2;
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        BroadcastRecord broadcastRecord;
        String str;
        StringBuilder sb;
        ArrayList arrayList;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        Intent intent2 = intent;
        ArrayList arrayList2 = this.mReceivers;
        synchronized (arrayList2) {
            try {
                String action = intent2.getAction();
                String resolveTypeIfNeeded = intent2.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
                Uri data = intent2.getData();
                String scheme = intent2.getScheme();
                Set categories = intent2.getCategories();
                boolean z = (8 & intent2.getFlags()) != 0;
                if (z) {
                    String str2 = TAG;
                    StringBuilder sb6 = sb5;
                    StringBuilder sb7 = new StringBuilder();
                    int v = Log.v(str2, sb6.append("Resolving type ").append(resolveTypeIfNeeded).append(" scheme ").append(scheme).append(" of intent ").append(intent2).toString());
                }
                th = (ArrayList) this.mActions.get(intent2.getAction());
                if (arrayList2 != null) {
                    if (z) {
                        String str3 = TAG;
                        StringBuilder sb8 = sb4;
                        StringBuilder sb9 = new StringBuilder();
                        int v2 = Log.v(str3, sb8.append("Action list: ").append(arrayList2).toString());
                    }
                    ArrayList arrayList3 = null;
                    for (int i = 0; i < arrayList2.size(); i++) {
                        ReceiverRecord receiverRecord = (ReceiverRecord) arrayList2.get(i);
                        if (z) {
                            String str4 = TAG;
                            StringBuilder sb10 = sb3;
                            StringBuilder sb11 = new StringBuilder();
                            int v3 = Log.v(str4, sb10.append("Matching against filter ").append(receiverRecord.filter).toString());
                        }
                        if (!receiverRecord.broadcasting) {
                            int match = receiverRecord.filter.match(action, resolveTypeIfNeeded, scheme, data, categories, TAG);
                            if (match >= 0) {
                                if (z) {
                                    String str5 = TAG;
                                    StringBuilder sb12 = sb2;
                                    StringBuilder sb13 = new StringBuilder();
                                    int v4 = Log.v(str5, sb12.append("  Filter matched!  match=0x").append(Integer.toHexString(match)).toString());
                                }
                                if (arrayList3 == null) {
                                    ArrayList arrayList4 = arrayList;
                                    ArrayList arrayList5 = new ArrayList();
                                    arrayList3 = arrayList4;
                                }
                                boolean add = arrayList3.add(receiverRecord);
                                receiverRecord.broadcasting = true;
                            } else if (z) {
                                switch (match) {
                                    case -4:
                                        str = "category";
                                        break;
                                    case -3:
                                        str = "action";
                                        break;
                                    case -2:
                                        str = "data";
                                        break;
                                    case -1:
                                        str = MimeTypeParser.TAG_TYPE;
                                        break;
                                    default:
                                        str = "unknown reason";
                                        break;
                                }
                                String str6 = TAG;
                                StringBuilder sb14 = sb;
                                StringBuilder sb15 = new StringBuilder();
                                int v5 = Log.v(str6, sb14.append("  Filter did not match: ").append(str).toString());
                            }
                        } else if (z) {
                            int v6 = Log.v(TAG, "  Filter's target already added");
                        }
                    }
                    if (arrayList3 != null) {
                        for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                            ((ReceiverRecord) arrayList3.get(i2)).broadcasting = false;
                        }
                        ArrayList<BroadcastRecord> arrayList6 = this.mPendingBroadcasts;
                        BroadcastRecord broadcastRecord2 = broadcastRecord;
                        BroadcastRecord broadcastRecord3 = new BroadcastRecord(intent2, arrayList3);
                        boolean add2 = arrayList6.add(broadcastRecord2);
                        if (!this.mHandler.hasMessages(1)) {
                            boolean sendEmptyMessage = this.mHandler.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } finally {
                Throwable th = th;
                ArrayList arrayList7 = arrayList2;
                Throwable th2 = th;
            }
        }
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    /* JADX INFO: finally extract failed */
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        BroadcastReceiver broadcastReceiver2 = broadcastReceiver;
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap = this.mReceivers;
        synchronized (hashMap) {
            try {
                ArrayList arrayList = (ArrayList) this.mReceivers.remove(broadcastReceiver2);
                if (arrayList != null) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        IntentFilter intentFilter = (IntentFilter) arrayList.get(i);
                        for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                            String action = intentFilter.getAction(i2);
                            ArrayList arrayList2 = (ArrayList) this.mActions.get(action);
                            if (arrayList2 != null) {
                                int i3 = 0;
                                while (i3 < arrayList2.size()) {
                                    if (((ReceiverRecord) arrayList2.get(i3)).receiver == broadcastReceiver2) {
                                        Object remove = arrayList2.remove(i3);
                                        i3--;
                                    }
                                    i3++;
                                }
                                if (arrayList2.size() <= 0) {
                                    Object remove2 = this.mActions.remove(action);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap2 = hashMap;
                throw th2;
            }
        }
    }
}
