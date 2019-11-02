package com.google.android.gms.playlog.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.playlog.internal.zza$zza reason: collision with other inner class name */
    public static abstract class C0925zza extends Binder implements zza {

        /* renamed from: com.google.android.gms.playlog.internal.zza$zza$zza reason: collision with other inner class name */
        private static class C0926zza implements zza {
            private IBinder zzoz;

            C0926zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException {
                String str2 = str;
                PlayLoggerContext playLoggerContext2 = playLoggerContext;
                LogEvent logEvent2 = logEvent;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str2);
                    if (playLoggerContext2 != null) {
                        obtain.writeInt(1);
                        playLoggerContext2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (logEvent2 != null) {
                        obtain.writeInt(1);
                        logEvent2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.zzoz.transact(2, obtain, null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException {
                String str2 = str;
                PlayLoggerContext playLoggerContext2 = playLoggerContext;
                List<LogEvent> list2 = list;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str2);
                    if (playLoggerContext2 != null) {
                        obtain.writeInt(1);
                        playLoggerContext2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list2);
                    boolean transact = this.zzoz.transact(3, obtain, null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException {
                String str2 = str;
                PlayLoggerContext playLoggerContext2 = playLoggerContext;
                byte[] bArr2 = bArr;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str2);
                    if (playLoggerContext2 != null) {
                        obtain.writeInt(1);
                        playLoggerContext2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr2);
                    boolean transact = this.zzoz.transact(4, obtain, null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public static zza zzdN(IBinder iBinder) {
            C0926zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zza)) {
                return (zza) queryLocalInterface;
            }
            C0926zza zza2 = zza;
            C0926zza zza3 = new C0926zza(iBinder2);
            return zza2;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            int i4 = i2;
            switch (i3) {
                case 2:
                    parcel3.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    String readString = parcel3.readString();
                    PlayLoggerContext playLoggerContext = parcel3.readInt() != 0 ? PlayLoggerContext.CREATOR.createFromParcel(parcel3) : null;
                    LogEvent logEvent = null;
                    if (parcel3.readInt() != 0) {
                        logEvent = LogEvent.CREATOR.createFromParcel(parcel3);
                    }
                    zza(readString, playLoggerContext, logEvent);
                    return true;
                case 3:
                    parcel3.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    String readString2 = parcel3.readString();
                    PlayLoggerContext playLoggerContext2 = null;
                    if (parcel3.readInt() != 0) {
                        playLoggerContext2 = PlayLoggerContext.CREATOR.createFromParcel(parcel3);
                    }
                    zza(readString2, playLoggerContext2, (List<LogEvent>) parcel3.createTypedArrayList(LogEvent.CREATOR));
                    return true;
                case 4:
                    parcel3.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    String readString3 = parcel3.readString();
                    PlayLoggerContext playLoggerContext3 = null;
                    if (parcel3.readInt() != 0) {
                        playLoggerContext3 = PlayLoggerContext.CREATOR.createFromParcel(parcel3);
                    }
                    zza(readString3, playLoggerContext3, parcel3.createByteArray());
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.playlog.internal.IPlayLogService");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException;
}
