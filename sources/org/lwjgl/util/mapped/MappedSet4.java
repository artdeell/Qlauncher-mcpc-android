package org.lwjgl.util.mapped;

public class MappedSet4 {

    /* renamed from: a */
    private final MappedObject f251a;

    /* renamed from: b */
    private final MappedObject f252b;

    /* renamed from: c */
    private final MappedObject f253c;

    /* renamed from: d */
    private final MappedObject f254d;
    public int view;

    MappedSet4(MappedObject mappedObject, MappedObject mappedObject2, MappedObject mappedObject3, MappedObject mappedObject4) {
        MappedObject mappedObject5 = mappedObject2;
        MappedObject mappedObject6 = mappedObject3;
        MappedObject mappedObject7 = mappedObject4;
        this.f251a = mappedObject;
        this.f252b = mappedObject5;
        this.f253c = mappedObject6;
        this.f254d = mappedObject7;
    }

    public void next() {
        this.f251a.next();
        this.f252b.next();
        this.f253c.next();
        this.f254d.next();
    }

    /* access modifiers changed from: 0000 */
    public void view(int i) {
        int i2 = i;
        this.f251a.setViewAddress(this.f251a.getViewAddress(i2));
        this.f252b.setViewAddress(this.f252b.getViewAddress(i2));
        this.f253c.setViewAddress(this.f253c.getViewAddress(i2));
        this.f254d.setViewAddress(this.f254d.getViewAddress(i2));
    }
}
