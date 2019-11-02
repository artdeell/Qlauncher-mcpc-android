package android.support.p000v4.p002os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.p000v4.p002os.IResultReceiver.Stub;

/* renamed from: android.support.v4.os.ResultReceiver */
public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR;
    final Handler mHandler;
    final boolean mLocal;
    IResultReceiver mReceiver;

    /* renamed from: android.support.v4.os.ResultReceiver$MyResultReceiver */
    class MyResultReceiver extends Stub {
        final /* synthetic */ ResultReceiver this$0;

        MyResultReceiver(ResultReceiver resultReceiver) {
            this.this$0 = resultReceiver;
        }

        public void send(int i, Bundle bundle) {
            MyRunnable myRunnable;
            int i2 = i;
            Bundle bundle2 = bundle;
            if (this.this$0.mHandler != null) {
                Handler handler = this.this$0.mHandler;
                MyRunnable myRunnable2 = myRunnable;
                MyRunnable myRunnable3 = new MyRunnable(this.this$0, i2, bundle2);
                boolean post = handler.post(myRunnable2);
                return;
            }
            this.this$0.onReceiveResult(i2, bundle2);
        }
    }

    /* renamed from: android.support.v4.os.ResultReceiver$MyRunnable */
    class MyRunnable implements Runnable {
        final int mResultCode;
        final Bundle mResultData;
        final /* synthetic */ ResultReceiver this$0;

        MyRunnable(ResultReceiver resultReceiver, int i, Bundle bundle) {
            int i2 = i;
            Bundle bundle2 = bundle;
            this.this$0 = resultReceiver;
            this.mResultCode = i2;
            this.mResultData = bundle2;
        }

        public void run() {
            this.this$0.onReceiveResult(this.mResultCode, this.mResultData);
        }
    }

    static {
        C00861 r2;
        C00861 r0 = r2;
        C00861 r1 = new Creator<ResultReceiver>() {
            public ResultReceiver createFromParcel(Parcel parcel) {
                ResultReceiver resultReceiver;
                ResultReceiver resultReceiver2 = resultReceiver;
                ResultReceiver resultReceiver3 = new ResultReceiver(parcel);
                return resultReceiver2;
            }

            public ResultReceiver[] newArray(int i) {
                return new ResultReceiver[i];
            }
        };
        CREATOR = r0;
    }

    public ResultReceiver(Handler handler) {
        Handler handler2 = handler;
        this.mLocal = true;
        this.mHandler = handler2;
    }

    ResultReceiver(Parcel parcel) {
        Parcel parcel2 = parcel;
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = Stub.asInterface(parcel2.readStrongBinder());
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i, Bundle bundle) {
    }

    public void send(int i, Bundle bundle) {
        MyRunnable myRunnable;
        int i2 = i;
        Bundle bundle2 = bundle;
        if (this.mLocal) {
            if (this.mHandler != null) {
                Handler handler = this.mHandler;
                MyRunnable myRunnable2 = myRunnable;
                MyRunnable myRunnable3 = new MyRunnable(this, i2, bundle2);
                boolean post = handler.post(myRunnable2);
                return;
            }
            onReceiveResult(i2, bundle2);
        } else if (this.mReceiver != null) {
            try {
                this.mReceiver.send(i2, bundle2);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void writeToParcel(Parcel parcel, int i) {
        MyResultReceiver myResultReceiver;
        Parcel parcel2 = parcel;
        int i2 = i;
        synchronized (this) {
            try {
                if (this.mReceiver == null) {
                    MyResultReceiver myResultReceiver2 = myResultReceiver;
                    MyResultReceiver myResultReceiver3 = new MyResultReceiver(this);
                    this.mReceiver = myResultReceiver2;
                }
                parcel2.writeStrongBinder(this.mReceiver.asBinder());
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}
