package org.lwjgl.test.mapped;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.mapped.CacheLinePad;
import org.lwjgl.util.mapped.CacheUtil;
import org.lwjgl.util.mapped.MappedField;
import org.lwjgl.util.mapped.MappedObject;
import org.lwjgl.util.mapped.MappedType;
import org.lwjgl.util.mapped.Pointer;

public class MappedObjectTests4 {
    static final /* synthetic */ boolean $assertionsDisabled = (!MappedObjectTests4.class.desiredAssertionStatus());

    @MappedType(cacheLinePadding = true)
    public static class MappedCacheLinePadded extends MappedObject {
        int bar;
        int foo;

        public MappedCacheLinePadded() {
        }
    }

    public static class MappedFieldCacheLinePadded extends MappedObject {
        int bar;
        @CacheLinePad(after = false, before = true)
        @MappedField(byteLength = 12)
        ByteBuffer buffer;
        int foo;
        @CacheLinePad(before = true)
        int intBar;
        int intFoo;
        @CacheLinePad
        long longBar;
        long longFoo;

        public MappedFieldCacheLinePadded() {
        }
    }

    public static class MappedPointer extends MappedObject {
        int bar;
        int foo;
        @Pointer
        long pointer;

        public MappedPointer() {
        }
    }

    public static class POJOFieldCacheLinePadded {
        int bar;
        @CacheLinePad
        boolean bool;
        int foo;
        @CacheLinePad(before = true)
        int intBar;
        int intFoo;
        @CacheLinePad
        long longBar;
        long longFoo;

        public POJOFieldCacheLinePadded() {
        }
    }

    public MappedObjectTests4() {
    }

    public static void testCacheLineAlignment() {
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        AssertionError assertionError4;
        MappedCacheLinePadded mappedCacheLinePadded = (MappedCacheLinePadded) MappedCacheLinePadded.malloc(10);
        if (!$assertionsDisabled && mappedCacheLinePadded.backingByteBuffer().capacity() != 10 * CacheUtil.getCacheLineSize()) {
            AssertionError assertionError5 = assertionError4;
            AssertionError assertionError6 = new AssertionError();
            throw assertionError5;
        } else if ($assertionsDisabled || MemoryUtil.getAddress(mappedCacheLinePadded.backingByteBuffer()) % ((long) CacheUtil.getCacheLineSize()) == 0) {
            for (int i = 0; i < 10; i++) {
                mappedCacheLinePadded.view = i;
                mappedCacheLinePadded.foo = i;
                mappedCacheLinePadded.bar = i * 2;
            }
            int i2 = 0;
            while (i2 < 10) {
                mappedCacheLinePadded.view = i2;
                if (!$assertionsDisabled && mappedCacheLinePadded.foo != i2) {
                    AssertionError assertionError7 = assertionError2;
                    AssertionError assertionError8 = new AssertionError();
                    throw assertionError7;
                } else if ($assertionsDisabled || mappedCacheLinePadded.bar == i2 * 2) {
                    i2++;
                } else {
                    AssertionError assertionError9 = assertionError;
                    AssertionError assertionError10 = new AssertionError();
                    throw assertionError9;
                }
            }
        } else {
            AssertionError assertionError11 = assertionError3;
            AssertionError assertionError12 = new AssertionError();
            throw assertionError11;
        }
    }

    public static void testCacheLinePadding() {
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        AssertionError assertionError4;
        AssertionError assertionError5;
        AssertionError assertionError6;
        AssertionError assertionError7;
        MappedFieldCacheLinePadded mappedFieldCacheLinePadded = (MappedFieldCacheLinePadded) MappedFieldCacheLinePadded.map(CacheUtil.createByteBuffer(10 * MappedFieldCacheLinePadded.SIZEOF));
        int cacheLineSize = 4 + 12 + 4 + 8 + CacheUtil.getCacheLineSize() + -8 + CacheUtil.getCacheLineSize() + CacheUtil.getCacheLineSize() + -4 + CacheUtil.getCacheLineSize();
        if (!$assertionsDisabled && MappedFieldCacheLinePadded.SIZEOF != cacheLineSize) {
            AssertionError assertionError8 = assertionError7;
            AssertionError assertionError9 = new AssertionError();
            throw assertionError8;
        } else if ($assertionsDisabled || mappedFieldCacheLinePadded.backingByteBuffer().capacity() == cacheLineSize * 10) {
            for (int i = 0; i < 10; i++) {
                mappedFieldCacheLinePadded.view = i;
                mappedFieldCacheLinePadded.longFoo = 1000000000 * ((long) i);
                mappedFieldCacheLinePadded.longBar = 2000000000 * ((long) i);
                mappedFieldCacheLinePadded.intFoo = i * 1000;
                mappedFieldCacheLinePadded.intBar = i * 2000;
                mappedFieldCacheLinePadded.foo = i;
            }
            int i2 = 0;
            while (i2 < 10) {
                mappedFieldCacheLinePadded.view = i2;
                if (!$assertionsDisabled && mappedFieldCacheLinePadded.longFoo != 1000000000 * ((long) i2)) {
                    AssertionError assertionError10 = assertionError5;
                    AssertionError assertionError11 = new AssertionError();
                    throw assertionError10;
                } else if (!$assertionsDisabled && mappedFieldCacheLinePadded.longBar != 2000000000 * ((long) i2)) {
                    AssertionError assertionError12 = assertionError4;
                    AssertionError assertionError13 = new AssertionError();
                    throw assertionError12;
                } else if (!$assertionsDisabled && mappedFieldCacheLinePadded.intFoo != i2 * 1000) {
                    AssertionError assertionError14 = assertionError3;
                    AssertionError assertionError15 = new AssertionError();
                    throw assertionError14;
                } else if (!$assertionsDisabled && mappedFieldCacheLinePadded.intBar != i2 * 2000) {
                    AssertionError assertionError16 = assertionError2;
                    AssertionError assertionError17 = new AssertionError();
                    throw assertionError16;
                } else if ($assertionsDisabled || mappedFieldCacheLinePadded.foo == i2) {
                    i2++;
                } else {
                    AssertionError assertionError18 = assertionError;
                    AssertionError assertionError19 = new AssertionError();
                    throw assertionError18;
                }
            }
        } else {
            AssertionError assertionError20 = assertionError6;
            AssertionError assertionError21 = new AssertionError();
            throw assertionError20;
        }
    }

    public static void testCacheLinePaddingPOJO() {
        POJOFieldCacheLinePadded pOJOFieldCacheLinePadded;
        AssertionError assertionError;
        POJOFieldCacheLinePadded pOJOFieldCacheLinePadded2 = pOJOFieldCacheLinePadded;
        POJOFieldCacheLinePadded pOJOFieldCacheLinePadded3 = new POJOFieldCacheLinePadded();
        Field[] declaredFields = pOJOFieldCacheLinePadded2.getClass().getDeclaredFields();
        if (!$assertionsDisabled && declaredFields.length != 107) {
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError();
            throw assertionError2;
        }
    }

    public static void testLWJGL() throws Exception {
        File file;
        PrintStream printStream = System.out;
        File file2 = file;
        File file3 = new File(System.getProperty("java.library.path"));
        printStream.println(file2.getCanonicalPath());
        Display.create();
    }

    public static void testLocalView() {
        MappedFloat mappedFloat = (MappedFloat) MappedFloat.malloc(5);
        MappedFloat mappedFloat2 = (MappedFloat) MappedFloat.malloc(5);
        testLocalView(mappedFloat);
        testLocalView(mappedFloat, mappedFloat2);
        testLocalView((MappedSomething) MappedSomething.malloc(5));
    }

    private static void testLocalView(MappedFloat mappedFloat) {
        StringBuilder sb;
        StringBuilder sb2;
        AssertionError assertionError;
        MappedFloat[] mappedFloatArr = (MappedFloat[]) mappedFloat.asArray();
        if ($assertionsDisabled || mappedFloatArr.length == 5) {
            int length = 10 * mappedFloatArr.length;
            for (int i = 0; i < 5; i++) {
                mappedFloatArr[i].value = (float) (i * 5);
                MappedFloat mappedFloat2 = mappedFloatArr[i];
                mappedFloat2.value = 2.0f * mappedFloat2.value;
            }
            System.out.println();
            float f = 0.0f;
            for (int i2 = 0; i2 < 5; i2++) {
                PrintStream printStream = System.out;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                printStream.println(sb3.append("[").append(i2).append("] =>").append(mappedFloatArr[i2].value).toString());
                f += mappedFloatArr[i2].value;
            }
            PrintStream printStream2 = System.out;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            printStream2.println(sb5.append("x = ").append(f).toString());
            return;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    private static void testLocalView(MappedFloat mappedFloat, MappedFloat mappedFloat2) {
        StringBuilder sb;
        StringBuilder sb2;
        MappedFloat mappedFloat3 = mappedFloat2;
        MappedFloat[] mappedFloatArr = (MappedFloat[]) mappedFloat.asArray();
        for (int i = 0; i < 5; i++) {
            mappedFloatArr[i].value = (float) Math.random();
            MappedFloat mappedFloat4 = mappedFloatArr[i];
            mappedFloat4.value = 2.0f * mappedFloat4.value;
        }
        MappedFloat[] mappedFloatArr2 = (MappedFloat[]) mappedFloat3.asArray();
        for (int i2 = 0; i2 < 5; i2++) {
            mappedFloatArr2[i2].value = (float) Math.random();
            MappedFloat mappedFloat5 = mappedFloatArr2[i2];
            mappedFloat5.value = 2.0f * mappedFloat5.value;
        }
        System.out.println();
        for (int i3 = 0; i3 < 5; i3++) {
            PrintStream printStream = System.out;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            printStream.println(sb3.append("[").append(i3).append("] =>").append(mappedFloatArr[i3].value).toString());
        }
        for (int i4 = 0; i4 < 5; i4++) {
            PrintStream printStream2 = System.out;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            printStream2.println(sb5.append("[").append(i4).append("] =>").append(mappedFloatArr2[i4].value).toString());
        }
    }

    private static void testLocalView(MappedSomething mappedSomething) {
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        MappedSomething mappedSomething2 = mappedSomething;
        MappedSomething[] mappedSomethingArr = (MappedSomething[]) mappedSomething2.asArray();
        if ($assertionsDisabled || mappedSomethingArr.length == 5) {
            long address = MemoryUtil.getAddress(mappedSomething2.backingByteBuffer());
            int i = 0;
            while (i < mappedSomethingArr.length) {
                ByteBuffer byteBuffer = mappedSomethingArr[i].data;
                if (!$assertionsDisabled && byteBuffer.capacity() != 60) {
                    AssertionError assertionError4 = assertionError2;
                    AssertionError assertionError5 = new AssertionError();
                    throw assertionError4;
                } else if ($assertionsDisabled || MemoryUtil.getAddress(byteBuffer) == 4 + address + ((long) (i * MappedSomething.SIZEOF))) {
                    i++;
                } else {
                    AssertionError assertionError6 = assertionError;
                    AssertionError assertionError7 = new AssertionError();
                    throw assertionError6;
                }
            }
            return;
        }
        AssertionError assertionError8 = assertionError3;
        AssertionError assertionError9 = new AssertionError();
        throw assertionError8;
    }

    public static void testPointer() {
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        AssertionError assertionError4;
        MappedPointer mappedPointer = (MappedPointer) MappedPointer.malloc(100);
        if ($assertionsDisabled || mappedPointer.backingByteBuffer().capacity() == 100 * (8 + PointerBuffer.getPointerSize())) {
            for (int i = 0; i < 100; i++) {
                mappedPointer.view = i;
                mappedPointer.foo = i;
                mappedPointer.pointer = (long) (i * 1000);
                mappedPointer.bar = i * 2;
            }
            int i2 = 0;
            while (i2 < 100) {
                mappedPointer.view = i2;
                if (!$assertionsDisabled && mappedPointer.foo != i2) {
                    AssertionError assertionError5 = assertionError3;
                    AssertionError assertionError6 = new AssertionError();
                    throw assertionError5;
                } else if (!$assertionsDisabled && mappedPointer.pointer != ((long) (i2 * 1000))) {
                    AssertionError assertionError7 = assertionError2;
                    AssertionError assertionError8 = new AssertionError();
                    throw assertionError7;
                } else if ($assertionsDisabled || mappedPointer.bar == i2 * 2) {
                    i2++;
                } else {
                    AssertionError assertionError9 = assertionError;
                    AssertionError assertionError10 = new AssertionError();
                    throw assertionError9;
                }
            }
            return;
        }
        AssertionError assertionError11 = assertionError4;
        AssertionError assertionError12 = new AssertionError();
        throw assertionError11;
    }
}
