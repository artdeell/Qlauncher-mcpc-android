package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zznc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
    public static final zze CREATOR;
    private final String mClassName;
    private final int mVersionCode;
    private final FieldMappingDictionary zzamT;
    private final Parcel zzana;
    private final int zzanb;
    private int zzanc;
    private int zzand;

    static {
        zze zze;
        zze zze2 = zze;
        zze zze3 = new zze();
        CREATOR = zze2;
    }

    SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        Parcel parcel2 = parcel;
        FieldMappingDictionary fieldMappingDictionary2 = fieldMappingDictionary;
        this.mVersionCode = i;
        this.zzana = (Parcel) zzx.zzz(parcel2);
        this.zzanb = 2;
        this.zzamT = fieldMappingDictionary2;
        if (this.zzamT == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zzamT.zzrB();
        }
        this.zzanc = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary fieldMappingDictionary, String str) {
        SafeParcelable safeParcelable2 = safeParcelable;
        FieldMappingDictionary fieldMappingDictionary2 = fieldMappingDictionary;
        String str2 = str;
        this.mVersionCode = 1;
        this.zzana = Parcel.obtain();
        safeParcelable2.writeToParcel(this.zzana, 0);
        this.zzanb = 1;
        this.zzamT = (FieldMappingDictionary) zzx.zzz(fieldMappingDictionary2);
        this.mClassName = (String) zzx.zzz(str2);
        this.zzanc = 2;
    }

    private static HashMap<Integer, Entry<String, Field<?, ?>>> zzN(Map<String, Field<?, ?>> map) {
        HashMap hashMap;
        Map<String, Field<?, ?>> map2 = map;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        for (Entry entry : map2.entrySet()) {
            Object put = hashMap4.put(Integer.valueOf(((Field) entry.getValue()).zzrs()), entry);
        }
        return hashMap4;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse zza(T t) {
        SafeParcelResponse safeParcelResponse;
        T t2 = t;
        String canonicalName = t2.getClass().getCanonicalName();
        SafeParcelResponse safeParcelResponse2 = safeParcelResponse;
        SafeParcelResponse safeParcelResponse3 = new SafeParcelResponse((SafeParcelable) t2, zzb(t2), canonicalName);
        return safeParcelResponse2;
    }

    private static void zza(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        IllegalStateException illegalStateException2;
        StringBuilder sb2;
        FieldMappingDictionary fieldMappingDictionary2 = fieldMappingDictionary;
        FastJsonResponse fastJsonResponse2 = fastJsonResponse;
        Class cls = fastJsonResponse2.getClass();
        if (!fieldMappingDictionary2.zzb(cls)) {
            Map zzrl = fastJsonResponse2.zzrl();
            fieldMappingDictionary2.zza(cls, zzrl);
            for (String str : zzrl.keySet()) {
                Field field = (Field) zzrl.get(str);
                Class zzrt = field.zzrt();
                if (zzrt != null) {
                    try {
                        zza(fieldMappingDictionary2, (FastJsonResponse) zzrt.newInstance());
                    } catch (InstantiationException e) {
                        InstantiationException instantiationException = e;
                        IllegalStateException illegalStateException3 = illegalStateException2;
                        StringBuilder sb3 = sb2;
                        StringBuilder sb4 = new StringBuilder();
                        IllegalStateException illegalStateException4 = new IllegalStateException(sb3.append("Could not instantiate an object of type ").append(field.zzrt().getCanonicalName()).toString(), instantiationException);
                        throw illegalStateException3;
                    } catch (IllegalAccessException e2) {
                        IllegalAccessException illegalAccessException = e2;
                        IllegalStateException illegalStateException5 = illegalStateException;
                        StringBuilder sb5 = sb;
                        StringBuilder sb6 = new StringBuilder();
                        IllegalStateException illegalStateException6 = new IllegalStateException(sb5.append("Could not access object of type ").append(field.zzrt().getCanonicalName()).toString(), illegalAccessException);
                        throw illegalStateException5;
                    }
                }
            }
        }
    }

    private void zza(StringBuilder sb, int i, Object obj) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb2;
        StringBuilder sb3 = sb;
        int i2 = i;
        Object obj2 = obj;
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                StringBuilder append = sb3.append(obj2);
                return;
            case 7:
                StringBuilder append2 = sb3.append("\"").append(zznb.zzcU(obj2.toString())).append("\"");
                return;
            case 8:
                StringBuilder append3 = sb3.append("\"").append(zzmo.zzj((byte[]) obj2)).append("\"");
                return;
            case 9:
                StringBuilder append4 = sb3.append("\"").append(zzmo.zzk((byte[]) obj2));
                StringBuilder append5 = sb3.append("\"");
                return;
            case 10:
                zznc.zza(sb3, (HashMap) obj2);
                return;
            case 11:
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Method does not accept concrete type.");
                throw illegalArgumentException3;
            default:
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException2;
                StringBuilder sb4 = sb2;
                StringBuilder sb5 = new StringBuilder();
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb4.append("Unknown type = ").append(i2).toString());
                throw illegalArgumentException5;
        }
    }

    private void zza(StringBuilder sb, Field<?, ?> field, Parcel parcel, int i) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb2;
        StringBuilder sb3 = sb;
        Field<?, ?> field2 = field;
        Parcel parcel2 = parcel;
        int i2 = i;
        switch (field2.zzrk()) {
            case 0:
                zzb(sb3, field2, zza(field2, Integer.valueOf(zza.zzg(parcel2, i2))));
                return;
            case 1:
                zzb(sb3, field2, zza(field2, zza.zzk(parcel2, i2)));
                return;
            case 2:
                zzb(sb3, field2, zza(field2, Long.valueOf(zza.zzi(parcel2, i2))));
                return;
            case 3:
                zzb(sb3, field2, zza(field2, Float.valueOf(zza.zzl(parcel2, i2))));
                return;
            case 4:
                zzb(sb3, field2, zza(field2, Double.valueOf(zza.zzn(parcel2, i2))));
                return;
            case 5:
                zzb(sb3, field2, zza(field2, zza.zzo(parcel2, i2)));
                return;
            case 6:
                zzb(sb3, field2, zza(field2, Boolean.valueOf(zza.zzc(parcel2, i2))));
                return;
            case 7:
                zzb(sb3, field2, zza(field2, zza.zzp(parcel2, i2)));
                return;
            case 8:
            case 9:
                zzb(sb3, field2, zza(field2, zza.zzs(parcel2, i2)));
                return;
            case 10:
                zzb(sb3, field2, zza(field2, zzl(zza.zzr(parcel2, i2))));
                return;
            case 11:
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Method does not accept concrete type.");
                throw illegalArgumentException3;
            default:
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException2;
                StringBuilder sb4 = sb2;
                StringBuilder sb5 = new StringBuilder();
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb4.append("Unknown field out type = ").append(field2.zzrk()).toString());
                throw illegalArgumentException5;
        }
    }

    private void zza(StringBuilder sb, String str, Field<?, ?> field, Parcel parcel, int i) {
        StringBuilder sb2 = sb;
        Field<?, ?> field2 = field;
        Parcel parcel2 = parcel;
        int i2 = i;
        StringBuilder append = sb2.append("\"").append(str).append("\":");
        if (field2.zzrv()) {
            zza(sb2, field2, parcel2, i2);
        } else {
            zzb(sb2, field2, parcel2, i2);
        }
    }

    private void zza(StringBuilder sb, Map<String, Field<?, ?>> map, Parcel parcel) {
        C0881zza zza;
        StringBuilder sb2;
        StringBuilder sb3 = sb;
        Parcel parcel2 = parcel;
        HashMap zzN = zzN(map);
        StringBuilder append = sb3.append('{');
        int zzau = zza.zzau(parcel2);
        boolean z = false;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            Entry entry = (Entry) zzN.get(Integer.valueOf(zza.zzca(zzat)));
            if (entry != null) {
                if (z) {
                    StringBuilder append2 = sb3.append(",");
                }
                zza(sb3, (String) entry.getKey(), (Field) entry.getValue(), parcel2, zzat);
                z = true;
            }
        }
        if (parcel2.dataPosition() != zzau) {
            C0881zza zza2 = zza;
            StringBuilder sb4 = sb2;
            StringBuilder sb5 = new StringBuilder();
            C0881zza zza3 = new C0881zza(sb4.append("Overread allowed size end=").append(zzau).toString(), parcel2);
            throw zza2;
        }
        StringBuilder append3 = sb3.append('}');
    }

    private static FieldMappingDictionary zzb(FastJsonResponse fastJsonResponse) {
        FieldMappingDictionary fieldMappingDictionary;
        FastJsonResponse fastJsonResponse2 = fastJsonResponse;
        FieldMappingDictionary fieldMappingDictionary2 = fieldMappingDictionary;
        FieldMappingDictionary fieldMappingDictionary3 = new FieldMappingDictionary(fastJsonResponse2.getClass());
        FieldMappingDictionary fieldMappingDictionary4 = fieldMappingDictionary2;
        zza(fieldMappingDictionary4, fastJsonResponse2);
        fieldMappingDictionary4.zzrz();
        fieldMappingDictionary4.zzry();
        return fieldMappingDictionary4;
    }

    private void zzb(StringBuilder sb, Field<?, ?> field, Parcel parcel, int i) {
        IllegalStateException illegalStateException;
        UnsupportedOperationException unsupportedOperationException;
        IllegalStateException illegalStateException2;
        StringBuilder sb2 = sb;
        Field<?, ?> field2 = field;
        Parcel parcel2 = parcel;
        int i2 = i;
        if (field2.zzrq()) {
            StringBuilder append = sb2.append("[");
            switch (field2.zzrk()) {
                case 0:
                    zzmn.zza(sb2, zza.zzv(parcel2, i2));
                    break;
                case 1:
                    zzmn.zza(sb2, (T[]) zza.zzx(parcel2, i2));
                    break;
                case 2:
                    zzmn.zza(sb2, zza.zzw(parcel2, i2));
                    break;
                case 3:
                    zzmn.zza(sb2, zza.zzy(parcel2, i2));
                    break;
                case 4:
                    zzmn.zza(sb2, zza.zzz(parcel2, i2));
                    break;
                case 5:
                    zzmn.zza(sb2, (T[]) zza.zzA(parcel2, i2));
                    break;
                case 6:
                    zzmn.zza(sb2, zza.zzu(parcel2, i2));
                    break;
                case 7:
                    zzmn.zza(sb2, zza.zzB(parcel2, i2));
                    break;
                case 8:
                case 9:
                case 10:
                    UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                    UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                    throw unsupportedOperationException2;
                case 11:
                    Parcel[] zzF = zza.zzF(parcel2, i2);
                    int length = zzF.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        if (i3 > 0) {
                            StringBuilder append2 = sb2.append(",");
                        }
                        zzF[i3].setDataPosition(0);
                        zza(sb2, field2.zzrx(), zzF[i3]);
                    }
                    break;
                default:
                    IllegalStateException illegalStateException3 = illegalStateException2;
                    IllegalStateException illegalStateException4 = new IllegalStateException("Unknown field type out.");
                    throw illegalStateException3;
            }
            StringBuilder append3 = sb2.append("]");
            return;
        }
        switch (field2.zzrk()) {
            case 0:
                StringBuilder append4 = sb2.append(zza.zzg(parcel2, i2));
                return;
            case 1:
                StringBuilder append5 = sb2.append(zza.zzk(parcel2, i2));
                return;
            case 2:
                StringBuilder append6 = sb2.append(zza.zzi(parcel2, i2));
                return;
            case 3:
                StringBuilder append7 = sb2.append(zza.zzl(parcel2, i2));
                return;
            case 4:
                StringBuilder append8 = sb2.append(zza.zzn(parcel2, i2));
                return;
            case 5:
                StringBuilder append9 = sb2.append(zza.zzo(parcel2, i2));
                return;
            case 6:
                StringBuilder append10 = sb2.append(zza.zzc(parcel2, i2));
                return;
            case 7:
                StringBuilder append11 = sb2.append("\"").append(zznb.zzcU(zza.zzp(parcel2, i2))).append("\"");
                return;
            case 8:
                StringBuilder append12 = sb2.append("\"").append(zzmo.zzj(zza.zzs(parcel2, i2))).append("\"");
                return;
            case 9:
                StringBuilder append13 = sb2.append("\"").append(zzmo.zzk(zza.zzs(parcel2, i2)));
                StringBuilder append14 = sb2.append("\"");
                return;
            case 10:
                Bundle zzr = zza.zzr(parcel2, i2);
                Set keySet = zzr.keySet();
                int size = keySet.size();
                StringBuilder append15 = sb2.append("{");
                Iterator it = keySet.iterator();
                boolean z = true;
                while (true) {
                    boolean z2 = z;
                    if (it.hasNext()) {
                        String str = (String) it.next();
                        if (!z2) {
                            StringBuilder append16 = sb2.append(",");
                        }
                        StringBuilder append17 = sb2.append("\"").append(str).append("\"");
                        StringBuilder append18 = sb2.append(":");
                        StringBuilder append19 = sb2.append("\"").append(zznb.zzcU(zzr.getString(str))).append("\"");
                        z = false;
                    } else {
                        StringBuilder append20 = sb2.append("}");
                        return;
                    }
                }
            case 11:
                Parcel zzE = zza.zzE(parcel2, i2);
                zzE.setDataPosition(0);
                zza(sb2, field2.zzrx(), zzE);
                return;
            default:
                IllegalStateException illegalStateException5 = illegalStateException;
                IllegalStateException illegalStateException6 = new IllegalStateException("Unknown field type out");
                throw illegalStateException5;
        }
    }

    private void zzb(StringBuilder sb, Field<?, ?> field, Object obj) {
        StringBuilder sb2 = sb;
        Field<?, ?> field2 = field;
        Object obj2 = obj;
        if (field2.zzrp()) {
            zzb(sb2, field2, (ArrayList) obj2);
        } else {
            zza(sb2, field2.zzrj(), obj2);
        }
    }

    private void zzb(StringBuilder sb, Field<?, ?> field, ArrayList<?> arrayList) {
        StringBuilder sb2 = sb;
        Field<?, ?> field2 = field;
        ArrayList<?> arrayList2 = arrayList;
        StringBuilder append = sb2.append("[");
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                StringBuilder append2 = sb2.append(",");
            }
            zza(sb2, field2.zzrj(), arrayList2.get(i));
        }
        StringBuilder append3 = sb2.append("]");
    }

    public static HashMap<String, String> zzl(Bundle bundle) {
        HashMap hashMap;
        Bundle bundle2 = bundle;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        for (String str : bundle2.keySet()) {
            Object put = hashMap4.put(str, bundle2.getString(str));
        }
        return hashMap4;
    }

    public int describeContents() {
        zze zze = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        StringBuilder sb;
        Object zzb = zzx.zzb(this.zzamT, (Object) "Cannot convert to JSON on client side.");
        Parcel zzrD = zzrD();
        zzrD.setDataPosition(0);
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(100);
        StringBuilder sb4 = sb2;
        zza(sb4, this.zzamT.zzcR(this.mClassName), zzrD);
        return sb4.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        zze zze = CREATOR;
        zze.zza(this, parcel2, i2);
    }

    /* access modifiers changed from: protected */
    public Object zzcN(String str) {
        UnsupportedOperationException unsupportedOperationException;
        String str2 = str;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Converting to JSON does not require this method.");
        throw unsupportedOperationException2;
    }

    /* access modifiers changed from: protected */
    public boolean zzcO(String str) {
        UnsupportedOperationException unsupportedOperationException;
        String str2 = str;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Converting to JSON does not require this method.");
        throw unsupportedOperationException2;
    }

    public Parcel zzrD() {
        switch (this.zzanc) {
            case 0:
                this.zzand = zzb.zzav(this.zzana);
                zzb.zzI(this.zzana, this.zzand);
                this.zzanc = 2;
                break;
            case 1:
                zzb.zzI(this.zzana, this.zzand);
                this.zzanc = 2;
                break;
        }
        return this.zzana;
    }

    /* access modifiers changed from: 0000 */
    public FieldMappingDictionary zzrE() {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        switch (this.zzanb) {
            case 0:
                return null;
            case 1:
                return this.zzamT;
            case 2:
                return this.zzamT;
            default:
                IllegalStateException illegalStateException2 = illegalStateException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Invalid creation type: ").append(this.zzanb).toString());
                throw illegalStateException2;
        }
    }

    public Map<String, Field<?, ?>> zzrl() {
        if (this.zzamT == null) {
            return null;
        }
        return this.zzamT.zzcR(this.mClassName);
    }
}
