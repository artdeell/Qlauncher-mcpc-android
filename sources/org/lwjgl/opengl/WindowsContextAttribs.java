package org.lwjgl.opengl;

final class WindowsContextAttribs implements ContextAttribsImplementation {
    private static final int WGL_CONTEXT_COMPATIBILITY_PROFILE_BIT_ARB = 2;
    private static final int WGL_CONTEXT_CORE_PROFILE_BIT_ARB = 1;
    private static final int WGL_CONTEXT_DEBUG_BIT_ARB = 1;
    private static final int WGL_CONTEXT_FLAGS_ARB = 8340;
    private static final int WGL_CONTEXT_FORWARD_COMPATIBLE_BIT_ARB = 2;
    private static final int WGL_CONTEXT_LAYER_PLANE_ARB = 8339;
    private static final int WGL_CONTEXT_MAJOR_VERSION_ARB = 8337;
    private static final int WGL_CONTEXT_MINOR_VERSION_ARB = 8338;
    private static final int WGL_CONTEXT_PROFILE_MASK_ARB = 37158;

    WindowsContextAttribs() {
    }

    public int getDebugBit() {
        return 1;
    }

    public int getFlagsAttrib() {
        return WGL_CONTEXT_FLAGS_ARB;
    }

    public int getForwardCompatibleBit() {
        return 2;
    }

    public int getLayerPlaneAttrib() {
        return WGL_CONTEXT_LAYER_PLANE_ARB;
    }

    public int getMajorVersionAttrib() {
        return WGL_CONTEXT_MAJOR_VERSION_ARB;
    }

    public int getMinorVersionAttrib() {
        return WGL_CONTEXT_MINOR_VERSION_ARB;
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
