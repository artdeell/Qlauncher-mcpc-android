package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.zzd.zza;
import java.lang.reflect.Field;

public final class zze<T> extends zza {
    private final T mWrappedObject;

    private zze(T t) {
        this.mWrappedObject = t;
    }

    public static <T> zzd zzC(T t) {
        zze zze;
        zze zze2 = zze;
        zze zze3 = new zze(t);
        return zze2;
    }

    public static <T> T zzp(zzd zzd) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        IllegalArgumentException illegalArgumentException4;
        IllegalArgumentException illegalArgumentException5;
        zzd zzd2 = zzd;
        if (zzd2 instanceof zze) {
            return ((zze) zzd2).mWrappedObject;
        }
        IBinder asBinder = zzd2.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return field.get(asBinder);
                } catch (NullPointerException e) {
                    NullPointerException nullPointerException = e;
                    IllegalArgumentException illegalArgumentException6 = illegalArgumentException5;
                    IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("Binder object is null.", nullPointerException);
                    throw illegalArgumentException6;
                } catch (IllegalArgumentException e2) {
                    IllegalArgumentException illegalArgumentException8 = e2;
                    IllegalArgumentException illegalArgumentException9 = illegalArgumentException4;
                    IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException("remoteBinder is the wrong class.", illegalArgumentException8);
                    throw illegalArgumentException9;
                } catch (IllegalAccessException e3) {
                    IllegalAccessException illegalAccessException = e3;
                    IllegalArgumentException illegalArgumentException11 = illegalArgumentException3;
                    IllegalArgumentException illegalArgumentException12 = new IllegalArgumentException("Could not access the field in remoteBinder.", illegalAccessException);
                    throw illegalArgumentException11;
                }
            } else {
                IllegalArgumentException illegalArgumentException13 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException14 = new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
                throw illegalArgumentException13;
            }
        } else {
            IllegalArgumentException illegalArgumentException15 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException16 = new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
            throw illegalArgumentException15;
        }
    }
}
