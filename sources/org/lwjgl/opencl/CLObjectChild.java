package org.lwjgl.opencl;

import org.lwjgl.LWJGLUtil;
import org.lwjgl.opencl.CLObject;

abstract class CLObjectChild<P extends CLObject> extends CLObjectRetainable {
    private final P parent;

    protected CLObjectChild(long j, P p) {
        IllegalStateException illegalStateException;
        P p2 = p;
        super(j);
        if (!LWJGLUtil.DEBUG || p2 == null || p2.isValid()) {
            this.parent = p2;
            return;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("The parent specified is not a valid CL object.");
        throw illegalStateException2;
    }

    public P getParent() {
        return this.parent;
    }
}
