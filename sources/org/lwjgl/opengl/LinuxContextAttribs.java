package org.lwjgl.opengl;

final class LinuxContextAttribs implements ContextAttribsImplementation {
    private static final int GLX_CONTEXT_COMPATIBILITY_PROFILE_BIT_ARB = 2;
    private static final int GLX_CONTEXT_CORE_PROFILE_BIT_ARB = 1;
    private static final int GLX_CONTEXT_DEBUG_BIT_ARB = 1;
    private static final int GLX_CONTEXT_FLAGS_ARB = 8340;
    private static final int GLX_CONTEXT_FORWARD_COMPATIBLE_BIT_ARB = 2;
    private static final int GLX_CONTEXT_MAJOR_VERSION_ARB = 8337;
    private static final int GLX_CONTEXT_MINOR_VERSION_ARB = 8338;
    private static final int GLX_CONTEXT_PROFILE_MASK_ARB = 37158;

    LinuxContextAttribs() {
    }

    public int getDebugBit() {
        return 1;
    }

    public int getFlagsAttrib() {
        return GLX_CONTEXT_FLAGS_ARB;
    }

    public int getForwardCompatibleBit() {
        return 2;
    }

    public int getLayerPlaneAttrib() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public int getMajorVersionAttrib() {
        return GLX_CONTEXT_MAJOR_VERSION_ARB;
    }

    public int getMinorVersionAttrib() {
        return GLX_CONTEXT_MINOR_VERSION_ARB;
    }

    public int getProfileCompatibilityBit() {
        return 2;
    }

    public int getProfileCoreBit() {
        return 1;
    }

    public int getProfileMaskAttrib() {
        return 37158;
    }
}
