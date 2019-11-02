package org.lwjgl.util.mapped;

public class MappedSet2 {

    /* renamed from: a */
    private final MappedObject f246a;

    /* renamed from: b */
    private final MappedObject f247b;
    public int view;

    MappedSet2(MappedObject mappedObject, MappedObject mappedObject2) {
        MappedObject mappedObject3 = mappedObject2;
        this.f246a = mappedObject;
        this.f247b = mappedObject3;
    }

    public void next() {
        this.f246a.next();
        this.f247b.next();
    }

    /* access modifiers changed from: 0000 */
    public void view(int i) {
        int i2 = i;
        this.f246a.setViewAddress(this.f246a.getViewAddress(i2));
        this.f247b.setViewAddress(this.f247b.getViewAddress(i2));
    }
}
