package org.lwjgl.openal;

import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;

public final class ALCcontext {
    final long context;
    private boolean valid = true;

    ALCcontext(long j) {
        this.context = j;
    }

    static IntBuffer createAttributeList(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(7);
        IntBuffer put = createIntBuffer.put(4103);
        IntBuffer put2 = createIntBuffer.put(i4);
        IntBuffer put3 = createIntBuffer.put(4104);
        IntBuffer put4 = createIntBuffer.put(i5);
        IntBuffer put5 = createIntBuffer.put(4105);
        IntBuffer put6 = createIntBuffer.put(i6);
        IntBuffer put7 = createIntBuffer.put(0);
        return createIntBuffer;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        return obj2 instanceof ALCcontext ? ((ALCcontext) obj2).context == this.context : super.equals(obj2);
    }

    public boolean isValid() {
        return this.valid;
    }

    /* access modifiers changed from: 0000 */
    public void setInvalid() {
        this.valid = false;
    }
}
