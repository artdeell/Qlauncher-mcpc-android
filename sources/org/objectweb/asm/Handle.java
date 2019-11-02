package org.objectweb.asm;

public final class Handle {

    /* renamed from: a */
    final int f346a;

    /* renamed from: b */
    final String f347b;

    /* renamed from: c */
    final String f348c;

    /* renamed from: d */
    final String f349d;

    public Handle(int i, String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        this.f346a = i;
        this.f347b = str4;
        this.f348c = str5;
        this.f349d = str6;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 != this) {
            if (!(obj2 instanceof Handle)) {
                return false;
            }
            Handle handle = (Handle) obj2;
            if (this.f346a != handle.f346a || !this.f347b.equals(handle.f347b) || !this.f348c.equals(handle.f348c) || !this.f349d.equals(handle.f349d)) {
                return false;
            }
        }
        return true;
    }

    public String getDesc() {
        return this.f349d;
    }

    public String getName() {
        return this.f348c;
    }

    public String getOwner() {
        return this.f347b;
    }

    public int getTag() {
        return this.f346a;
    }

    public int hashCode() {
        return this.f346a + (this.f347b.hashCode() * this.f348c.hashCode() * this.f349d.hashCode());
    }

    public String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append(this.f347b).append('.').append(this.f348c).append(this.f349d).append(" (").append(this.f346a).append(')').toString();
    }
}
