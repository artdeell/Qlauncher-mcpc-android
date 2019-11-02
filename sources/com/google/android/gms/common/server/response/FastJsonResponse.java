package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zznc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public static class Field<I, O> implements SafeParcelable {
        public static final zza CREATOR;
        private final int mVersionCode;
        protected final int zzamL;
        protected final boolean zzamM;
        protected final int zzamN;
        protected final boolean zzamO;
        protected final String zzamP;
        protected final int zzamQ;
        protected final Class<? extends FastJsonResponse> zzamR;
        protected final String zzamS;
        private FieldMappingDictionary zzamT;
        /* access modifiers changed from: private */
        public zza<I, O> zzamU;

        static {
            zza zza;
            zza zza2 = zza;
            zza zza3 = new zza();
            CREATOR = zza2;
        }

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            int i5 = i2;
            boolean z3 = z;
            int i6 = i3;
            boolean z4 = z2;
            String str3 = str;
            int i7 = i4;
            String str4 = str2;
            ConverterWrapper converterWrapper2 = converterWrapper;
            this.mVersionCode = i;
            this.zzamL = i5;
            this.zzamM = z3;
            this.zzamN = i6;
            this.zzamO = z4;
            this.zzamP = str3;
            this.zzamQ = i7;
            if (str4 == null) {
                this.zzamR = null;
                this.zzamS = null;
            } else {
                this.zzamR = SafeParcelResponse.class;
                this.zzamS = str4;
            }
            if (converterWrapper2 == null) {
                this.zzamU = null;
                return;
            }
            this.zzamU = converterWrapper2.zzrh();
        }

        protected Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, zza<I, O> zza) {
            int i4 = i;
            boolean z3 = z;
            int i5 = i2;
            boolean z4 = z2;
            String str2 = str;
            int i6 = i3;
            Class<? extends FastJsonResponse> cls2 = cls;
            zza<I, O> zza2 = zza;
            this.mVersionCode = 1;
            this.zzamL = i4;
            this.zzamM = z3;
            this.zzamN = i5;
            this.zzamO = z4;
            this.zzamP = str2;
            this.zzamQ = i6;
            this.zzamR = cls2;
            if (cls2 == null) {
                this.zzamS = null;
            } else {
                this.zzamS = cls2.getCanonicalName();
            }
            this.zzamU = zza2;
        }

        public static Field zza(String str, int i, zza<?, ?> zza, boolean z) {
            Field field;
            zza<?, ?> zza2 = zza;
            boolean z2 = z;
            Field field2 = field;
            Field field3 = new Field(zza2.zzrj(), z2, zza2.zzrk(), false, str, i, null, zza2);
            return field2;
        }

        public static <T extends FastJsonResponse> Field<T, T> zza(String str, int i, Class<T> cls) {
            Field field;
            Field field2 = field;
            Field field3 = new Field(11, false, 11, false, str, i, cls, null);
            return field2;
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> zzb(String str, int i, Class<T> cls) {
            Field field;
            Field field2 = field;
            Field field3 = new Field(11, true, 11, true, str, i, cls, null);
            return field2;
        }

        public static Field<Integer, Integer> zzi(String str, int i) {
            Field field;
            Field field2 = field;
            Field field3 = new Field(0, false, 0, false, str, i, null, null);
            return field2;
        }

        public static Field<Double, Double> zzj(String str, int i) {
            Field field;
            Field field2 = field;
            Field field3 = new Field(4, false, 4, false, str, i, null, null);
            return field2;
        }

        public static Field<Boolean, Boolean> zzk(String str, int i) {
            Field field;
            Field field2 = field;
            Field field3 = new Field(6, false, 6, false, str, i, null, null);
            return field2;
        }

        public static Field<String, String> zzl(String str, int i) {
            Field field;
            Field field2 = field;
            Field field3 = new Field(7, false, 7, false, str, i, null, null);
            return field2;
        }

        public static Field<ArrayList<String>, ArrayList<String>> zzm(String str, int i) {
            Field field;
            Field field2 = field;
            Field field3 = new Field(7, true, 7, true, str, i, null, null);
            return field2;
        }

        public I convertBack(O o) {
            return this.zzamU.convertBack(o);
        }

        public int describeContents() {
            zza zza = CREATOR;
            return 0;
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = sb2;
            StringBuilder append = sb4.append("Field\n");
            StringBuilder append2 = sb4.append("            versionCode=").append(this.mVersionCode).append(10);
            StringBuilder append3 = sb4.append("                 typeIn=").append(this.zzamL).append(10);
            StringBuilder append4 = sb4.append("            typeInArray=").append(this.zzamM).append(10);
            StringBuilder append5 = sb4.append("                typeOut=").append(this.zzamN).append(10);
            StringBuilder append6 = sb4.append("           typeOutArray=").append(this.zzamO).append(10);
            StringBuilder append7 = sb4.append("        outputFieldName=").append(this.zzamP).append(10);
            StringBuilder append8 = sb4.append("      safeParcelFieldId=").append(this.zzamQ).append(10);
            StringBuilder append9 = sb4.append("       concreteTypeName=").append(zzru()).append(10);
            if (zzrt() != null) {
                StringBuilder append10 = sb4.append("     concreteType.class=").append(zzrt().getCanonicalName()).append(10);
            }
            StringBuilder append11 = sb4.append("          converterName=").append(this.zzamU == null ? "null" : this.zzamU.getClass().getCanonicalName()).append(10);
            return sb4.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            int i2 = i;
            zza zza = CREATOR;
            zza.zza(this, parcel2, i2);
        }

        public void zza(FieldMappingDictionary fieldMappingDictionary) {
            FieldMappingDictionary fieldMappingDictionary2 = fieldMappingDictionary;
            this.zzamT = fieldMappingDictionary2;
        }

        public int zzrj() {
            return this.zzamL;
        }

        public int zzrk() {
            return this.zzamN;
        }

        public Field<I, O> zzro() {
            Field field;
            Field field2 = field;
            Field field3 = new Field(this.mVersionCode, this.zzamL, this.zzamM, this.zzamN, this.zzamO, this.zzamP, this.zzamQ, this.zzamS, zzrw());
            return field2;
        }

        public boolean zzrp() {
            return this.zzamM;
        }

        public boolean zzrq() {
            return this.zzamO;
        }

        public String zzrr() {
            return this.zzamP;
        }

        public int zzrs() {
            return this.zzamQ;
        }

        public Class<? extends FastJsonResponse> zzrt() {
            return this.zzamR;
        }

        /* access modifiers changed from: 0000 */
        public String zzru() {
            if (this.zzamS == null) {
                return null;
            }
            return this.zzamS;
        }

        public boolean zzrv() {
            return this.zzamU != null;
        }

        /* access modifiers changed from: 0000 */
        public ConverterWrapper zzrw() {
            if (this.zzamU == null) {
                return null;
            }
            return ConverterWrapper.zza(this.zzamU);
        }

        public Map<String, Field<?, ?>> zzrx() {
            Object zzz = zzx.zzz(this.zzamS);
            Object zzz2 = zzx.zzz(this.zzamT);
            return this.zzamT.zzcR(this.zzamS);
        }
    }

    public interface zza<I, O> {
        I convertBack(O o);

        int zzrj();

        int zzrk();
    }

    public FastJsonResponse() {
    }

    private void zza(StringBuilder sb, Field field, Object obj) {
        StringBuilder sb2 = sb;
        Field field2 = field;
        Object obj2 = obj;
        if (field2.zzrj() == 11) {
            StringBuilder append = sb2.append(((FastJsonResponse) field2.zzrt().cast(obj2)).toString());
        } else if (field2.zzrj() == 7) {
            StringBuilder append2 = sb2.append("\"");
            StringBuilder append3 = sb2.append(zznb.zzcU((String) obj2));
            StringBuilder append4 = sb2.append("\"");
        } else {
            StringBuilder append5 = sb2.append(obj2);
        }
    }

    private void zza(StringBuilder sb, Field field, ArrayList<Object> arrayList) {
        StringBuilder sb2 = sb;
        Field field2 = field;
        ArrayList<Object> arrayList2 = arrayList;
        StringBuilder append = sb2.append("[");
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                StringBuilder append2 = sb2.append(",");
            }
            Object obj = arrayList2.get(i);
            if (obj != null) {
                zza(sb2, field2, obj);
            }
        }
        StringBuilder append3 = sb2.append("]");
    }

    public String toString() {
        StringBuilder sb;
        Map zzrl = zzrl();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(100);
        StringBuilder sb4 = sb2;
        for (String str : zzrl.keySet()) {
            Field field = (Field) zzrl.get(str);
            if (zza(field)) {
                Object zza2 = zza(field, zzb(field));
                if (sb4.length() == 0) {
                    StringBuilder append = sb4.append("{");
                } else {
                    StringBuilder append2 = sb4.append(",");
                }
                StringBuilder append3 = sb4.append("\"").append(str).append("\":");
                if (zza2 != null) {
                    switch (field.zzrk()) {
                        case 8:
                            StringBuilder append4 = sb4.append("\"").append(zzmo.zzj((byte[]) zza2)).append("\"");
                            break;
                        case 9:
                            StringBuilder append5 = sb4.append("\"").append(zzmo.zzk((byte[]) zza2)).append("\"");
                            break;
                        case 10:
                            zznc.zza(sb4, (HashMap) zza2);
                            break;
                        default:
                            if (!field.zzrp()) {
                                zza(sb4, field, zza2);
                                break;
                            } else {
                                zza(sb4, field, (ArrayList) zza2);
                                break;
                            }
                    }
                } else {
                    StringBuilder append6 = sb4.append("null");
                }
            }
        }
        if (sb4.length() > 0) {
            StringBuilder append7 = sb4.append("}");
        } else {
            StringBuilder append8 = sb4.append("{}");
        }
        return sb4.toString();
    }

    /* access modifiers changed from: protected */
    public <O, I> I zza(Field<I, O> field, Object obj) {
        Field<I, O> field2 = field;
        Object obj2 = obj;
        if (field2.zzamU != null) {
            obj2 = field2.convertBack(obj2);
        }
        return obj2;
    }

    /* access modifiers changed from: protected */
    public boolean zza(Field field) {
        Field field2 = field;
        return field2.zzrk() == 11 ? field2.zzrq() ? zzcQ(field2.zzrr()) : zzcP(field2.zzrr()) : zzcO(field2.zzrr());
    }

    /* access modifiers changed from: protected */
    public Object zzb(Field field) {
        RuntimeException runtimeException;
        StringBuilder sb;
        Field field2 = field;
        String zzrr = field2.zzrr();
        if (field2.zzrt() == null) {
            return zzcN(field2.zzrr());
        }
        zzx.zza(zzcN(field2.zzrr()) == null, "Concrete field shouldn't be value object: %s", field2.zzrr());
        HashMap zzrm = field2.zzrq() ? zzrn() : zzrm();
        if (zzrm != null) {
            return zzrm.get(zzrr);
        }
        try {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return getClass().getMethod(sb2.append("get").append(Character.toUpperCase(zzrr.charAt(0))).append(zzrr.substring(1)).toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            Exception exc = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(exc);
            throw runtimeException2;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zzcN(String str);

    /* access modifiers changed from: protected */
    public abstract boolean zzcO(String str);

    /* access modifiers changed from: protected */
    public boolean zzcP(String str) {
        UnsupportedOperationException unsupportedOperationException;
        String str2 = str;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Concrete types not supported");
        throw unsupportedOperationException2;
    }

    /* access modifiers changed from: protected */
    public boolean zzcQ(String str) {
        UnsupportedOperationException unsupportedOperationException;
        String str2 = str;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Concrete type arrays not supported");
        throw unsupportedOperationException2;
    }

    public abstract Map<String, Field<?, ?>> zzrl();

    public HashMap<String, Object> zzrm() {
        return null;
    }

    public HashMap<String, Object> zzrn() {
        return null;
    }
}
