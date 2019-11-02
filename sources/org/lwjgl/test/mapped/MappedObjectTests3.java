package org.lwjgl.test.mapped;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.lwjgl.MemoryUtil;
import org.lwjgl.util.mapped.MappedObject;
import org.lwjgl.util.mapped.MappedSet;
import org.lwjgl.util.mapped.MappedSet2;

public class MappedObjectTests3 {
    static final /* synthetic */ boolean $assertionsDisabled = (!MappedObjectTests3.class.desiredAssertionStatus());

    public static class Xyz extends MappedObject {

        /* renamed from: x */
        int f209x;

        /* renamed from: y */
        int f210y;

        /* renamed from: z */
        int f211z;

        public Xyz() {
        }
    }

    public MappedObjectTests3() {
    }

    static void testConstructor() {
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        AssertionError assertionError4;
        long address = MemoryUtil.getAddress(ByteBuffer.allocateDirect(1024).order(ByteOrder.nativeOrder()));
        MappedFloat mappedFloat = (MappedFloat) MappedFloat.map(address, 1024);
        if (!$assertionsDisabled && address != mappedFloat.baseAddress) {
            AssertionError assertionError5 = assertionError4;
            AssertionError assertionError6 = new AssertionError();
            throw assertionError5;
        } else if ($assertionsDisabled || mappedFloat.value == 0.0f) {
            mappedFloat.view = 1;
            if ($assertionsDisabled || mappedFloat.value == 0.0f) {
                mappedFloat.runViewConstructor();
                if ($assertionsDisabled || mappedFloat.value == 4.0f) {
                    MappedObject malloc = Xyz.malloc(3);
                    return;
                }
                AssertionError assertionError7 = assertionError;
                AssertionError assertionError8 = new AssertionError();
                throw assertionError7;
            }
            AssertionError assertionError9 = assertionError2;
            AssertionError assertionError10 = new AssertionError();
            throw assertionError9;
        } else {
            AssertionError assertionError11 = assertionError3;
            AssertionError assertionError12 = new AssertionError();
            throw assertionError11;
        }
    }

    static void testForeach() {
        StringBuilder sb;
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        AssertionError assertionError4;
        MappedSomething mappedSomething = (MappedSomething) MappedSomething.malloc(10);
        int i = 0;
        for (MappedSomething mappedSomething2 : MappedObject.foreach(mappedSomething, 5)) {
            if (!$assertionsDisabled) {
                int i2 = i + 1;
                if (mappedSomething2.view != i) {
                    AssertionError assertionError5 = assertionError4;
                    AssertionError assertionError6 = new AssertionError();
                    throw assertionError5;
                }
                i = i2;
            }
        }
        if ($assertionsDisabled || mappedSomething.view == 4) {
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("current.view=").append(mappedSomething.view).append(", not ").append(5).append(", as you might expect").toString());
            int i3 = 0;
            for (MappedSomething mappedSomething3 : MappedObject.foreach(mappedSomething)) {
                if (!$assertionsDisabled) {
                    int i4 = i3 + 1;
                    if (mappedSomething3.view != i3) {
                        AssertionError assertionError7 = assertionError2;
                        AssertionError assertionError8 = new AssertionError();
                        throw assertionError7;
                    }
                    i3 = i4;
                }
            }
            if (!$assertionsDisabled && mappedSomething.view != 9) {
                AssertionError assertionError9 = assertionError;
                AssertionError assertionError10 = new AssertionError();
                throw assertionError9;
            }
            return;
        }
        AssertionError assertionError11 = assertionError3;
        AssertionError assertionError12 = new AssertionError();
        throw assertionError11;
    }

    static void testMappedBuffer() {
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
        MappedSomething mappedSomething = (MappedSomething) MappedSomething.malloc(4);
        if ($assertionsDisabled || mappedSomething.data != mappedSomething.data) {
            long address = MemoryUtil.getAddress(mappedSomething.backingByteBuffer());
            ByteBuffer byteBuffer = mappedSomething.data;
            long address2 = MemoryUtil.getAddress(byteBuffer);
            if (!$assertionsDisabled && address2 - address != 4) {
                AssertionError assertionError11 = assertionError9;
                AssertionError assertionError12 = new AssertionError();
                throw assertionError11;
            } else if (!$assertionsDisabled && byteBuffer.capacity() != -4 + MappedSomething.SIZEOF) {
                AssertionError assertionError13 = assertionError8;
                AssertionError assertionError14 = new AssertionError();
                throw assertionError13;
            } else if (!$assertionsDisabled && mappedSomething.shared != 0) {
                AssertionError assertionError15 = assertionError7;
                AssertionError assertionError16 = new AssertionError();
                throw assertionError15;
            } else if ($assertionsDisabled || byteBuffer.getInt(8) == 0) {
                mappedSomething.shared = 1234;
                if (!$assertionsDisabled && mappedSomething.shared != 1234) {
                    AssertionError assertionError17 = assertionError5;
                    AssertionError assertionError18 = new AssertionError();
                    throw assertionError17;
                } else if ($assertionsDisabled || byteBuffer.getInt(8) == 1234) {
                    mappedSomething.view = 1 + mappedSomething.view;
                    ByteBuffer byteBuffer2 = mappedSomething.data;
                    long address3 = MemoryUtil.getAddress(byteBuffer2);
                    if (!$assertionsDisabled && address3 - address != ((long) (4 + MappedSomething.SIZEOF))) {
                        AssertionError assertionError19 = assertionError3;
                        AssertionError assertionError20 = new AssertionError();
                        throw assertionError19;
                    } else if (!$assertionsDisabled && address3 - address2 != ((long) (0 + MappedSomething.SIZEOF))) {
                        AssertionError assertionError21 = assertionError2;
                        AssertionError assertionError22 = new AssertionError();
                        throw assertionError21;
                    } else if (!$assertionsDisabled && byteBuffer2.capacity() != -4 + MappedSomething.SIZEOF) {
                        AssertionError assertionError23 = assertionError;
                        AssertionError assertionError24 = new AssertionError();
                        throw assertionError23;
                    }
                } else {
                    AssertionError assertionError25 = assertionError4;
                    AssertionError assertionError26 = new AssertionError();
                    throw assertionError25;
                }
            } else {
                AssertionError assertionError27 = assertionError6;
                AssertionError assertionError28 = new AssertionError();
                throw assertionError27;
            }
        } else {
            AssertionError assertionError29 = assertionError10;
            AssertionError assertionError30 = new AssertionError();
            throw assertionError29;
        }
    }

    static void testMappedSet() {
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        AssertionError assertionError4;
        AssertionError assertionError5;
        AssertionError assertionError6;
        AssertionError assertionError7;
        AssertionError assertionError8;
        MappedVec2 mappedVec2 = (MappedVec2) MappedVec2.malloc(3);
        MappedVec3 mappedVec3 = (MappedVec3) MappedVec3.malloc(3);
        MappedSet2 create = MappedSet.create(mappedVec2, mappedVec3);
        if (!$assertionsDisabled && mappedVec2.view != 0) {
            AssertionError assertionError9 = assertionError8;
            AssertionError assertionError10 = new AssertionError();
            throw assertionError9;
        } else if ($assertionsDisabled || mappedVec3.view == 0) {
            create.view = 2;
            if (!$assertionsDisabled && mappedVec2.view != 2) {
                AssertionError assertionError11 = assertionError6;
                AssertionError assertionError12 = new AssertionError();
                throw assertionError11;
            } else if ($assertionsDisabled || mappedVec3.view == 2) {
                create.view = 0;
                if (!$assertionsDisabled && mappedVec2.view != 0) {
                    AssertionError assertionError13 = assertionError4;
                    AssertionError assertionError14 = new AssertionError();
                    throw assertionError13;
                } else if ($assertionsDisabled || mappedVec3.view == 0) {
                    create.next();
                    if (!$assertionsDisabled && mappedVec2.view != 1) {
                        AssertionError assertionError15 = assertionError2;
                        AssertionError assertionError16 = new AssertionError();
                        throw assertionError15;
                    } else if (!$assertionsDisabled && mappedVec3.view != 1) {
                        AssertionError assertionError17 = assertionError;
                        AssertionError assertionError18 = new AssertionError();
                        throw assertionError17;
                    }
                } else {
                    AssertionError assertionError19 = assertionError3;
                    AssertionError assertionError20 = new AssertionError();
                    throw assertionError19;
                }
            } else {
                AssertionError assertionError21 = assertionError5;
                AssertionError assertionError22 = new AssertionError();
                throw assertionError21;
            }
        } else {
            AssertionError assertionError23 = assertionError7;
            AssertionError assertionError24 = new AssertionError();
            throw assertionError23;
        }
    }
}
