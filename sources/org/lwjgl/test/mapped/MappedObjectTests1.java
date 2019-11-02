package org.lwjgl.test.mapped;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.lwjgl.MemoryUtil;
import org.lwjgl.util.mapped.MappedHelper;

public class MappedObjectTests1 {
    static final /* synthetic */ boolean $assertionsDisabled = (!MappedObjectTests1.class.desiredAssertionStatus());

    static class Test {
        int value;

        Test() {
        }
    }

    public MappedObjectTests1() {
    }

    static void testViewField() {
        Test test;
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
        AssertionError assertionError12;
        AssertionError assertionError13;
        AssertionError assertionError14;
        AssertionError assertionError15;
        AssertionError assertionError16;
        AssertionError assertionError17;
        AssertionError assertionError18;
        AssertionError assertionError19;
        AssertionError assertionError20;
        AssertionError assertionError21;
        AssertionError assertionError22;
        AssertionError assertionError23;
        Test test2 = test;
        Test test3 = new Test();
        Test test4 = test2;
        test4.value = 13;
        test4.value = 1 + test4.value;
        test4.value = 1 + test4.value;
        System.out.println(test4);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(200);
        MappedFloat mappedFloat = (MappedFloat) MappedFloat.map(allocateDirect);
        MappedFloat mappedFloat2 = (MappedFloat) MappedFloat.malloc(1234);
        if (!$assertionsDisabled && mappedFloat2.getSizeof() != MappedFloat.SIZEOF) {
            AssertionError assertionError24 = assertionError23;
            AssertionError assertionError25 = new AssertionError();
            throw assertionError24;
        } else if (!$assertionsDisabled && 1234 * mappedFloat2.getSizeof() != mappedFloat2.backingByteBuffer().capacity()) {
            AssertionError assertionError26 = assertionError22;
            AssertionError assertionError27 = new AssertionError();
            throw assertionError26;
        } else if (!$assertionsDisabled && 1234 * MappedFloat.SIZEOF != mappedFloat2.backingByteBuffer().capacity()) {
            AssertionError assertionError28 = assertionError21;
            AssertionError assertionError29 = new AssertionError();
            throw assertionError28;
        } else if ($assertionsDisabled || mappedFloat2.capacity() == mappedFloat2.backingByteBuffer().capacity() / MappedFloat.SIZEOF) {
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(200);
            Buffer position = allocateDirect2.position(10 * MappedFloat.SIZEOF);
            MappedFloat mappedFloat3 = (MappedFloat) MappedFloat.map(allocateDirect2);
            if (!$assertionsDisabled && mappedFloat3.capacity() != -10 + (mappedFloat3.backingByteBuffer().capacity() / MappedFloat.SIZEOF)) {
                AssertionError assertionError30 = assertionError19;
                AssertionError assertionError31 = new AssertionError();
                throw assertionError30;
            } else if ($assertionsDisabled || mappedFloat.value == 0.0f) {
                mappedFloat.value = 1.1f;
                if (!$assertionsDisabled && mappedFloat.value != 1.1f) {
                    AssertionError assertionError32 = assertionError17;
                    AssertionError assertionError33 = new AssertionError();
                    throw assertionError32;
                } else if ($assertionsDisabled || mappedFloat.view == 0) {
                    mappedFloat.view = 1;
                    if (!$assertionsDisabled && mappedFloat.view != 1) {
                        AssertionError assertionError34 = assertionError15;
                        AssertionError assertionError35 = new AssertionError();
                        throw assertionError34;
                    } else if ($assertionsDisabled || mappedFloat.value != 1.1f) {
                        mappedFloat.view = 0;
                        if ($assertionsDisabled || mappedFloat.view == 0) {
                            mappedFloat.view = 1 + mappedFloat.view;
                            if (!$assertionsDisabled && mappedFloat.view != 1) {
                                AssertionError assertionError36 = assertionError12;
                                AssertionError assertionError37 = new AssertionError();
                                throw assertionError36;
                            } else if ($assertionsDisabled || mappedFloat.value != 1.1f) {
                                mappedFloat.view = 0;
                                if ($assertionsDisabled || mappedFloat.view == 0) {
                                    mappedFloat.next();
                                    if (!$assertionsDisabled && mappedFloat.view != 1) {
                                        AssertionError assertionError38 = assertionError9;
                                        AssertionError assertionError39 = new AssertionError();
                                        throw assertionError38;
                                    } else if ($assertionsDisabled || mappedFloat.value != 1.1f) {
                                        mappedFloat.view = 0;
                                        if ($assertionsDisabled || mappedFloat.view == 0) {
                                            try {
                                                mappedFloat.view = 49;
                                                if ($assertionsDisabled || mappedFloat.view == 49) {
                                                    mappedFloat.view = 0;
                                                    mappedFloat.view = 50;
                                                    System.out.println("org.lwjgl.util.mapped.Checks is false or there is a bug in bounds checking.");
                                                    mappedFloat.view = 0;
                                                    if ($assertionsDisabled || mappedFloat.view == 0) {
                                                        try {
                                                            mappedFloat.view = 10;
                                                            MappedFloat mappedFloat4 = (MappedFloat) mappedFloat.slice();
                                                            mappedFloat.view = 0;
                                                            mappedFloat4.view = 39;
                                                            if ($assertionsDisabled || mappedFloat4.view == 39) {
                                                                mappedFloat4.view = 40;
                                                                System.out.println("org.lwjgl.util.mapped.Checks is false or there is a bug in bounds checking.");
                                                                try {
                                                                    ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(200);
                                                                    Buffer position2 = allocateDirect3.position(10 * MappedFloat.SIZEOF);
                                                                    MappedFloat mappedFloat5 = (MappedFloat) MappedFloat.map(allocateDirect3);
                                                                    mappedFloat5.view = 39;
                                                                    if ($assertionsDisabled || mappedFloat5.view == 39) {
                                                                        mappedFloat5.view = 40;
                                                                        System.out.println("org.lwjgl.util.mapped.Checks is false or there is a bug in bounds checking.");
                                                                        long address = MemoryUtil.getAddress(allocateDirect);
                                                                        ByteBuffer newBuffer = MappedHelper.newBuffer(address, allocateDirect.capacity());
                                                                        long address2 = MemoryUtil.getAddress(allocateDirect);
                                                                        System.out.println(allocateDirect);
                                                                        System.out.println(newBuffer);
                                                                        System.out.println(address);
                                                                        System.out.println(address2);
                                                                        mappedFloat.value = 13.37f;
                                                                        MappedFloat mappedFloat6 = (MappedFloat) mappedFloat.dup();
                                                                        mappedFloat6.view = 1;
                                                                        System.out.println(mappedFloat);
                                                                        System.out.println(mappedFloat6);
                                                                        mappedFloat.copyTo(mappedFloat6);
                                                                        System.out.println(mappedFloat);
                                                                        System.out.println(mappedFloat6);
                                                                        if ($assertionsDisabled || mappedFloat6.value == 13.37f) {
                                                                            mappedFloat.value = 73.31f;
                                                                            mappedFloat.copyRange(mappedFloat6, 1);
                                                                            if (!$assertionsDisabled && mappedFloat6.value != 73.31f) {
                                                                                AssertionError assertionError40 = assertionError;
                                                                                AssertionError assertionError41 = new AssertionError();
                                                                                throw assertionError40;
                                                                            }
                                                                            return;
                                                                        }
                                                                        AssertionError assertionError42 = assertionError2;
                                                                        AssertionError assertionError43 = new AssertionError();
                                                                        throw assertionError42;
                                                                    }
                                                                    AssertionError assertionError44 = assertionError3;
                                                                    AssertionError assertionError45 = new AssertionError();
                                                                    throw assertionError44;
                                                                } catch (IndexOutOfBoundsException e) {
                                                                    IndexOutOfBoundsException indexOutOfBoundsException = e;
                                                                }
                                                            } else {
                                                                AssertionError assertionError46 = assertionError4;
                                                                AssertionError assertionError47 = new AssertionError();
                                                                throw assertionError46;
                                                            }
                                                        } catch (IndexOutOfBoundsException e2) {
                                                            IndexOutOfBoundsException indexOutOfBoundsException2 = e2;
                                                        }
                                                    } else {
                                                        AssertionError assertionError48 = assertionError5;
                                                        AssertionError assertionError49 = new AssertionError();
                                                        throw assertionError48;
                                                    }
                                                } else {
                                                    AssertionError assertionError50 = assertionError6;
                                                    AssertionError assertionError51 = new AssertionError();
                                                    throw assertionError50;
                                                }
                                            } catch (IndexOutOfBoundsException e3) {
                                                IndexOutOfBoundsException indexOutOfBoundsException3 = e3;
                                            }
                                        } else {
                                            AssertionError assertionError52 = assertionError7;
                                            AssertionError assertionError53 = new AssertionError();
                                            throw assertionError52;
                                        }
                                    } else {
                                        AssertionError assertionError54 = assertionError8;
                                        AssertionError assertionError55 = new AssertionError();
                                        throw assertionError54;
                                    }
                                } else {
                                    AssertionError assertionError56 = assertionError10;
                                    AssertionError assertionError57 = new AssertionError();
                                    throw assertionError56;
                                }
                            } else {
                                AssertionError assertionError58 = assertionError11;
                                AssertionError assertionError59 = new AssertionError();
                                throw assertionError58;
                            }
                        } else {
                            AssertionError assertionError60 = assertionError13;
                            AssertionError assertionError61 = new AssertionError();
                            throw assertionError60;
                        }
                    } else {
                        AssertionError assertionError62 = assertionError14;
                        AssertionError assertionError63 = new AssertionError();
                        throw assertionError62;
                    }
                } else {
                    AssertionError assertionError64 = assertionError16;
                    AssertionError assertionError65 = new AssertionError();
                    throw assertionError64;
                }
            } else {
                AssertionError assertionError66 = assertionError18;
                AssertionError assertionError67 = new AssertionError();
                throw assertionError66;
            }
        } else {
            AssertionError assertionError68 = assertionError20;
            AssertionError assertionError69 = new AssertionError();
            throw assertionError68;
        }
    }
}
