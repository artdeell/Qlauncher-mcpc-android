package org.lwjgl.util.mapped;

public class MappedSet {
    public MappedSet() {
    }

    public static MappedSet2 create(MappedObject mappedObject, MappedObject mappedObject2) {
        MappedSet2 mappedSet2;
        MappedSet2 mappedSet22 = mappedSet2;
        MappedSet2 mappedSet23 = new MappedSet2(mappedObject, mappedObject2);
        return mappedSet22;
    }

    public static MappedSet3 create(MappedObject mappedObject, MappedObject mappedObject2, MappedObject mappedObject3) {
        MappedSet3 mappedSet3;
        MappedSet3 mappedSet32 = mappedSet3;
        MappedSet3 mappedSet33 = new MappedSet3(mappedObject, mappedObject2, mappedObject3);
        return mappedSet32;
    }

    public static MappedSet4 create(MappedObject mappedObject, MappedObject mappedObject2, MappedObject mappedObject3, MappedObject mappedObject4) {
        MappedSet4 mappedSet4;
        MappedSet4 mappedSet42 = mappedSet4;
        MappedSet4 mappedSet43 = new MappedSet4(mappedObject, mappedObject2, mappedObject3, mappedObject4);
        return mappedSet42;
    }
}
