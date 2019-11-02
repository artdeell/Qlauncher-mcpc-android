package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.internal.zzb;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zzb<BatchResult> {
    /* access modifiers changed from: private */
    public int zzafZ;
    /* access modifiers changed from: private */
    public boolean zzaga;
    /* access modifiers changed from: private */
    public boolean zzagb;
    /* access modifiers changed from: private */
    public final PendingResult<?>[] zzagc;
    /* access modifiers changed from: private */
    public final Object zzpV;

    public static final class Builder {
        private GoogleApiClient zzaaj;
        private List<PendingResult<?>> zzage;

        public Builder(GoogleApiClient googleApiClient) {
            ArrayList arrayList;
            GoogleApiClient googleApiClient2 = googleApiClient;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            this.zzage = arrayList2;
            this.zzaaj = googleApiClient2;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken batchResultToken;
            PendingResult<R> pendingResult2 = pendingResult;
            BatchResultToken batchResultToken2 = batchResultToken;
            BatchResultToken batchResultToken3 = new BatchResultToken(this.zzage.size());
            BatchResultToken batchResultToken4 = batchResultToken2;
            boolean add = this.zzage.add(pendingResult2);
            return batchResultToken4;
        }

        public Batch build() {
            Batch batch;
            Batch batch2 = batch;
            Batch batch3 = new Batch(this.zzage, this.zzaaj, null);
            return batch2;
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        Object obj;
        C02211 r10;
        BatchResult batchResult;
        List<PendingResult<?>> list2 = list;
        super(googleApiClient);
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzafZ = list2.size();
        this.zzagc = new PendingResult[this.zzafZ];
        if (list2.isEmpty()) {
            BatchResult batchResult2 = batchResult;
            BatchResult batchResult3 = new BatchResult(Status.zzagC, this.zzagc);
            zza(batchResult2);
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            PendingResult pendingResult = (PendingResult) list2.get(i);
            this.zzagc[i] = pendingResult;
            PendingResult pendingResult2 = pendingResult;
            C02211 r6 = r10;
            C02211 r7 = new zza(this) {
                final /* synthetic */ Batch zzagd;

                {
                    this.zzagd = r5;
                }

                /* JADX INFO: finally extract failed */
                public void zzu(Status status) {
                    Status status2;
                    BatchResult batchResult;
                    Status status3;
                    Status status4 = status;
                    Object zza = this.zzagd.zzpV;
                    synchronized (zza) {
                        try {
                            if (!this.zzagd.isCanceled()) {
                                if (status4.isCanceled()) {
                                    boolean zza2 = Batch.zza(this.zzagd, true);
                                } else if (!status4.isSuccess()) {
                                    boolean zzb = Batch.zzb(this.zzagd, true);
                                }
                                int zzb2 = Batch.zzb(this.zzagd);
                                if (this.zzagd.zzafZ == 0) {
                                    if (this.zzagd.zzagb) {
                                        Batch.super.cancel();
                                    } else {
                                        if (this.zzagd.zzaga) {
                                            Status status5 = status3;
                                            Status status6 = new Status(13);
                                            status2 = status5;
                                        } else {
                                            status2 = Status.zzagC;
                                        }
                                        Batch batch = this.zzagd;
                                        BatchResult batchResult2 = batchResult;
                                        BatchResult batchResult3 = new BatchResult(status2, this.zzagd.zzagc);
                                        batch.zza(batchResult2);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            Object obj = zza;
                            throw th2;
                        }
                    }
                }
            };
            pendingResult2.zza(r6);
        }
    }

    /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, C02211 r10) {
        C02211 r3 = r10;
        this(list, googleApiClient);
    }

    static /* synthetic */ boolean zza(Batch batch, boolean z) {
        boolean z2 = z;
        batch.zzagb = z2;
        return z2;
    }

    static /* synthetic */ int zzb(Batch batch) {
        Batch batch2 = batch;
        int i = batch2.zzafZ;
        batch2.zzafZ = i - 1;
        return i;
    }

    static /* synthetic */ boolean zzb(Batch batch, boolean z) {
        boolean z2 = z;
        batch.zzaga = z2;
        return z2;
    }

    public void cancel() {
        super.cancel();
        PendingResult<?>[] pendingResultArr = this.zzagc;
        int length = pendingResultArr.length;
        for (int i = 0; i < length; i++) {
            pendingResultArr[i].cancel();
        }
    }

    /* renamed from: createFailedResult */
    public BatchResult zzc(Status status) {
        BatchResult batchResult;
        BatchResult batchResult2 = batchResult;
        BatchResult batchResult3 = new BatchResult(status, this.zzagc);
        return batchResult2;
    }
}
