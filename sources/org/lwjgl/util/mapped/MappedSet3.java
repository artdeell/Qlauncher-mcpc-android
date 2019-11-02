package org.lwjgl.util.mapped;

public class MappedSet3 {

    /* renamed from: a */
    private final MappedObject f248a;

    /* renamed from: b */
    private final MappedObject f249b;

    /* renamed from: c */
    private final MappedObject f250c;
    public int view;

    MappedSet3(MappedObject mappedObject, MappedObject mappedObject2, MappedObject mappedObject3) {
        MappedObject mappedObject4 = mappedObject2;
        MappedObject mappedObject5 = mappedObject3;
        this.f248a = mappedObject;
        this.f249b = mappedObject4;
        this.f250c = mappedObject5;
    }

    public void next() {
        this.f248a.next();
        this.f249b.next();
        this.f250c.next();
    }

    /* access modifiers changed from: 0000 */
    public void view(int i) {
        int i2 = i;
        this.f248a.setViewAddress(this.f248a.getViewAddress(i2));
        this.f249b.setViewAddress(this.f249b.getViewAddress(i2));
        this.f250c.setViewAddress(this.f250c.getViewAddress(i2));
    }
}
