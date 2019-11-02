package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

import java.util.Arrays;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.FixedSizeList */
public class FixedSizeList extends MutabilityControl implements ToHuman {
    private Object[] arr;

    public FixedSizeList(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        super(i2 != 0);
        try {
            this.arr = new Object[i2];
        } catch (NegativeArraySizeException e) {
            NegativeArraySizeException negativeArraySizeException = e;
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("size < 0");
            throw illegalArgumentException2;
        }
    }

    private Object throwIndex(int i) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        IndexOutOfBoundsException indexOutOfBoundsException2;
        if (i < 0) {
            IndexOutOfBoundsException indexOutOfBoundsException3 = indexOutOfBoundsException2;
            IndexOutOfBoundsException indexOutOfBoundsException4 = new IndexOutOfBoundsException("n < 0");
            throw indexOutOfBoundsException3;
        }
        IndexOutOfBoundsException indexOutOfBoundsException5 = indexOutOfBoundsException;
        IndexOutOfBoundsException indexOutOfBoundsException6 = new IndexOutOfBoundsException("n >= size()");
        throw indexOutOfBoundsException5;
    }

    private String toString0(String str, String str2, String str3, boolean z) {
        StringBuffer stringBuffer;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        boolean z2 = z;
        int length = this.arr.length;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(10 + (length * 10));
        StringBuffer stringBuffer4 = stringBuffer2;
        if (str4 != null) {
            StringBuffer append = stringBuffer4.append(str4);
        }
        for (int i = 0; i < length; i++) {
            if (!(i == 0 || str5 == null)) {
                StringBuffer append2 = stringBuffer4.append(str5);
            }
            if (z2) {
                StringBuffer append3 = stringBuffer4.append(((ToHuman) this.arr[i]).toHuman());
            } else {
                StringBuffer append4 = stringBuffer4.append(this.arr[i]);
            }
        }
        if (str6 != null) {
            StringBuffer append5 = stringBuffer4.append(str6);
        }
        return stringBuffer4.toString();
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this == obj2) {
            return true;
        }
        if (obj2 == null || getClass() != obj2.getClass()) {
            return false;
        }
        return Arrays.equals(this.arr, ((FixedSizeList) obj2).arr);
    }

    /* access modifiers changed from: protected */
    public final Object get0(int i) {
        Object obj;
        NullPointerException nullPointerException;
        StringBuilder sb;
        int i2 = i;
        try {
            obj = this.arr[i2];
            if (obj == null) {
                NullPointerException nullPointerException2 = nullPointerException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                NullPointerException nullPointerException3 = new NullPointerException(sb2.append("unset: ").append(i2).toString());
                throw nullPointerException2;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            obj = throwIndex(i2);
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    public final Object getOrNull0(int i) {
        return this.arr[i];
    }

    public int hashCode() {
        return Arrays.hashCode(this.arr);
    }

    /* access modifiers changed from: protected */
    public final void set0(int i, Object obj) {
        int i2 = i;
        Object obj2 = obj;
        throwIfImmutable();
        try {
            this.arr[i2] = obj2;
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            Object throwIndex = throwIndex(i2);
        }
    }

    public void shrinkToFit() {
        int i = 0;
        int length = this.arr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.arr[i3] != null) {
                i2++;
            }
        }
        if (length != i2) {
            throwIfImmutable();
            Object[] objArr = new Object[i2];
            for (int i4 = 0; i4 < length; i4++) {
                Object obj = this.arr[i4];
                if (obj != null) {
                    objArr[i] = obj;
                    i++;
                }
            }
            this.arr = objArr;
            if (i2 == 0) {
                setImmutable();
            }
        }
    }

    public final int size() {
        return this.arr.length;
    }

    public String toHuman() {
        StringBuilder sb;
        String name = getClass().getName();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return toString0(sb2.append(name.substring(1 + name.lastIndexOf(46))).append('{').toString(), ", ", "}", true);
    }

    public String toHuman(String str, String str2, String str3) {
        return toString0(str, str2, str3, true);
    }

    public String toString() {
        StringBuilder sb;
        String name = getClass().getName();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return toString0(sb2.append(name.substring(1 + name.lastIndexOf(46))).append('{').toString(), ", ", "}", false);
    }

    public String toString(String str, String str2, String str3) {
        return toString0(str, str2, str3, false);
    }
}
