package org.lwjgl.test.mapped;

import java.nio.ByteBuffer;

public class MappedObjectTests2 {
    static final /* synthetic */ boolean $assertionsDisabled = (!MappedObjectTests2.class.desiredAssertionStatus());

    public MappedObjectTests2() {
    }

    static void testFields() {
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        AssertionError assertionError4;
        AssertionError assertionError5;
        AssertionError assertionError6;
        AssertionError assertionError7;
        AssertionError assertionError8;
        AssertionError assertionError9;
        AssertionError assertionError10;
        AssertionError assertionError11;
        MappedVec3 mappedVec3 = (MappedVec3) MappedVec3.map(ByteBuffer.allocateDirect(200));
        testWriteFieldAccess(mappedVec3);
        mappedVec3.f214x = 13.13f;
        mappedVec3.f215y = 14.14f;
        mappedVec3.f216z = 15.15f;
        System.out.println(mappedVec3.viewAddress);
        if (!$assertionsDisabled && mappedVec3.f214x != 13.13f) {
            AssertionError assertionError12 = assertionError11;
            AssertionError assertionError13 = new AssertionError();
            throw assertionError12;
        } else if (!$assertionsDisabled && mappedVec3.f215y != 14.14f) {
            AssertionError assertionError14 = assertionError10;
            AssertionError assertionError15 = new AssertionError();
            throw assertionError14;
        } else if ($assertionsDisabled || mappedVec3.f216z == 15.15f) {
            mappedVec3.view = 0;
            if (!$assertionsDisabled && mappedVec3.f214x != 13.13f) {
                AssertionError assertionError16 = assertionError8;
                AssertionError assertionError17 = new AssertionError();
                throw assertionError16;
            } else if (!$assertionsDisabled && mappedVec3.f215y != 14.14f) {
                AssertionError assertionError18 = assertionError7;
                AssertionError assertionError19 = new AssertionError();
                throw assertionError18;
            } else if ($assertionsDisabled || mappedVec3.f216z == 15.15f) {
                System.out.println(mappedVec3);
                mappedVec3.view = 1;
                System.out.println(mappedVec3);
                if (!$assertionsDisabled && mappedVec3.f214x != 0.0f) {
                    AssertionError assertionError20 = assertionError5;
                    AssertionError assertionError21 = new AssertionError();
                    throw assertionError20;
                } else if (!$assertionsDisabled && mappedVec3.f215y != 0.0f) {
                    AssertionError assertionError22 = assertionError4;
                    AssertionError assertionError23 = new AssertionError();
                    throw assertionError22;
                } else if ($assertionsDisabled || mappedVec3.f216z == 0.0f) {
                    mappedVec3.view = 1;
                    mappedVec3.f214x = 0.1234f;
                    mappedVec3.view = 0;
                    long j = mappedVec3.viewAddress;
                    mappedVec3.view = 1;
                    long j2 = mappedVec3.viewAddress;
                    if (!$assertionsDisabled && j2 - j != ((long) MappedVec3.SIZEOF)) {
                        AssertionError assertionError24 = assertionError2;
                        AssertionError assertionError25 = new AssertionError();
                        throw assertionError24;
                    } else if ($assertionsDisabled || j2 - j == ((long) mappedVec3.getSizeof())) {
                        mappedVec3.view = 0;
                    } else {
                        AssertionError assertionError26 = assertionError;
                        AssertionError assertionError27 = new AssertionError();
                        throw assertionError26;
                    }
                } else {
                    AssertionError assertionError28 = assertionError3;
                    AssertionError assertionError29 = new AssertionError();
                    throw assertionError28;
                }
            } else {
                AssertionError assertionError30 = assertionError6;
                AssertionError assertionError31 = new AssertionError();
                throw assertionError30;
            }
        } else {
            AssertionError assertionError32 = assertionError9;
            AssertionError assertionError33 = new AssertionError();
            throw assertionError32;
        }
    }

    static void testWriteFieldAccess(MappedVec3 mappedVec3) {
        MappedVec3 mappedVec32 = mappedVec3;
        System.out.println(mappedVec32.baseAddress);
        System.out.println(mappedVec32.viewAddress);
        System.out.println(mappedVec32.getAlign());
        System.out.println(MappedVec3.SIZEOF);
    }
}
