package org.lwjgl.test.mapped;

import org.lwjgl.test.mapped.MappedObjectTests3.Xyz;
import org.lwjgl.test.mapped.MappedObjectTests4.MappedCacheLinePadded;
import org.lwjgl.test.mapped.MappedObjectTests4.MappedFieldCacheLinePadded;
import org.lwjgl.test.mapped.MappedObjectTests4.MappedPointer;
import org.lwjgl.util.mapped.MappedObjectClassLoader;
import org.lwjgl.util.mapped.MappedObjectTransformer;

public class TestMappedObject {
    static final /* synthetic */ boolean $assertionsDisabled = (!TestMappedObject.class.desiredAssertionStatus());

    static {
        RuntimeException runtimeException;
        AssertionError assertionError;
        boolean z = false;
        if (!$assertionsDisabled) {
            z = true;
            if (1 == 0) {
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
            }
        }
        if (!z) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("Asserts must be enabled for this test.");
            throw runtimeException2;
        }
    }

    public TestMappedObject() {
    }

    public static void main(String[] strArr) throws Exception {
        String[] strArr2 = strArr;
        MappedObjectTransformer.register(MappedFloat.class);
        MappedObjectTransformer.register(MappedVec2.class);
        MappedObjectTransformer.register(MappedVec3.class);
        MappedObjectTransformer.register(MappedSomething.class);
        MappedObjectTransformer.register(Xyz.class);
        MappedObjectTransformer.register(MappedPointer.class);
        MappedObjectTransformer.register(MappedCacheLinePadded.class);
        MappedObjectTransformer.register(MappedFieldCacheLinePadded.class);
        if (!MappedObjectClassLoader.fork(TestMappedObject.class, strArr2)) {
            MappedObjectTests1.testViewField();
            MappedObjectTests2.testFields();
            MappedObjectTests3.testMappedBuffer();
            MappedObjectTests3.testForeach();
            MappedObjectTests3.testConstructor();
            MappedObjectTests3.testMappedSet();
            MappedObjectTests4.testLocalView();
            MappedObjectTests4.testPointer();
            MappedObjectTests4.testCacheLineAlignment();
            MappedObjectTests4.testCacheLinePadding();
            MappedObjectTests4.testCacheLinePaddingPOJO();
            System.out.println("done");
        }
    }
}
