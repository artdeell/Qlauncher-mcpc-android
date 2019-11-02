package org.objectweb.asm;

final class Item {

    /* renamed from: a */
    int f356a;

    /* renamed from: b */
    int f357b;

    /* renamed from: c */
    int f358c;

    /* renamed from: d */
    long f359d;

    /* renamed from: g */
    String f360g;

    /* renamed from: h */
    String f361h;

    /* renamed from: i */
    String f362i;

    /* renamed from: j */
    int f363j;

    /* renamed from: k */
    Item f364k;

    Item() {
    }

    Item(int i) {
        this.f356a = i;
    }

    Item(int i, Item item) {
        Item item2 = item;
        this.f356a = i;
        this.f357b = item2.f357b;
        this.f358c = item2.f358c;
        this.f359d = item2.f359d;
        this.f360g = item2.f360g;
        this.f361h = item2.f361h;
        this.f362i = item2.f362i;
        this.f363j = item2.f363j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11180a(double d) {
        double d2 = d;
        this.f357b = 6;
        this.f359d = Double.doubleToRawLongBits(d2);
        this.f363j = Integer.MAX_VALUE & (this.f357b + ((int) d2));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11181a(float f) {
        float f2 = f;
        this.f357b = 4;
        this.f358c = Float.floatToRawIntBits(f2);
        this.f363j = Integer.MAX_VALUE & (this.f357b + ((int) f2));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11182a(int i) {
        int i2 = i;
        this.f357b = 3;
        this.f358c = i2;
        this.f363j = Integer.MAX_VALUE & (i2 + this.f357b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11183a(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        this.f357b = 33;
        this.f358c = i3;
        this.f363j = i4;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11184a(int i, String str, String str2, String str3) {
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        this.f357b = i2;
        this.f360g = str4;
        this.f361h = str5;
        this.f362i = str6;
        switch (i2) {
            case 1:
            case 7:
            case 8:
            case 16:
            case 30:
                this.f363j = Integer.MAX_VALUE & (i2 + str4.hashCode());
                return;
            case 12:
                this.f363j = Integer.MAX_VALUE & (i2 + (str4.hashCode() * str5.hashCode()));
                return;
            default:
                this.f363j = Integer.MAX_VALUE & (i2 + (str4.hashCode() * str5.hashCode() * str6.hashCode()));
                return;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11185a(long j) {
        long j2 = j;
        this.f357b = 5;
        this.f359d = j2;
        this.f363j = Integer.MAX_VALUE & (this.f357b + ((int) j2));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11186a(String str, String str2, int i) {
        String str3 = str;
        String str4 = str2;
        int i2 = i;
        this.f357b = 18;
        this.f359d = (long) i2;
        this.f360g = str3;
        this.f361h = str4;
        this.f363j = Integer.MAX_VALUE & (18 + (i2 * this.f360g.hashCode() * this.f361h.hashCode()));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo11187a(Item item) {
        Item item2 = item;
        switch (this.f357b) {
            case 1:
            case 7:
            case 8:
            case 16:
            case 30:
                return item2.f360g.equals(this.f360g);
            case 3:
            case 4:
                if (item2.f358c != this.f358c) {
                    return false;
                }
                break;
            case 5:
            case 6:
            case 32:
                if (item2.f359d != this.f359d) {
                    return false;
                }
                break;
            case 12:
                if (!item2.f360g.equals(this.f360g) || !item2.f361h.equals(this.f361h)) {
                    return false;
                }
            case 18:
                if (item2.f359d != this.f359d || !item2.f360g.equals(this.f360g) || !item2.f361h.equals(this.f361h)) {
                    return false;
                }
            case 31:
                if (item2.f358c != this.f358c || !item2.f360g.equals(this.f360g)) {
                    return false;
                }
            default:
                if (!item2.f360g.equals(this.f360g) || !item2.f361h.equals(this.f361h) || !item2.f362i.equals(this.f362i)) {
                    return false;
                }
        }
        return true;
    }
}
