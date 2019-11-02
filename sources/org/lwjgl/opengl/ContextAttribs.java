package org.lwjgl.opengl;

import org.lwjgl.LWJGLUtil;

public final class ContextAttribs {
    private static final int CONTEXT_ES2_PROFILE_BIT_EXT = 4;
    private static final int CONTEXT_RESET_ISOLATION_BIT_ARB = 8;
    private static final int CONTEXT_RESET_NOTIFICATION_STRATEGY_ARB = 33366;
    private static final int CONTEXT_ROBUST_ACCESS_BIT_ARB = 4;
    private static final int LOSE_CONTEXT_ON_RESET_ARB = 33362;
    private static final int NO_RESET_NOTIFICATION_ARB = 33377;
    private boolean contextResetIsolation;
    private boolean debug;
    private boolean forwardCompatible;
    private int layerPlane;
    private boolean loseContextOnReset;
    private int majorVersion;
    private int minorVersion;
    private boolean profileCompatibility;
    private boolean profileCore;
    private boolean profileES;
    private boolean robustAccess;

    public ContextAttribs() {
        this(1, 0);
    }

    public ContextAttribs(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i3 = i;
        int i4 = i2;
        if (i3 < 0 || 4 < i3 || i4 < 0 || ((i3 == 4 && 4 < i4) || ((i3 == 3 && 3 < i4) || ((i3 == 2 && 1 < i4) || (i3 == 1 && 5 < i4))))) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid OpenGL version specified: ").append(i3).append('.').append(i4).toString());
            throw illegalArgumentException2;
        }
        this.majorVersion = i3;
        this.minorVersion = i4;
    }

    private ContextAttribs(ContextAttribs contextAttribs) {
        ContextAttribs contextAttribs2 = contextAttribs;
        this.majorVersion = contextAttribs2.majorVersion;
        this.minorVersion = contextAttribs2.minorVersion;
        this.layerPlane = contextAttribs2.layerPlane;
        this.debug = contextAttribs2.debug;
        this.forwardCompatible = contextAttribs2.forwardCompatible;
        this.robustAccess = contextAttribs2.robustAccess;
        this.profileCore = contextAttribs2.profileCore;
        this.profileCompatibility = contextAttribs2.profileCompatibility;
        this.profileES = contextAttribs2.profileES;
        this.loseContextOnReset = contextAttribs2.loseContextOnReset;
    }

    private static ContextAttribsImplementation getImplementation() {
        WindowsContextAttribs windowsContextAttribs;
        LinuxContextAttribs linuxContextAttribs;
        IllegalStateException illegalStateException;
        switch (LWJGLUtil.getPlatform()) {
            case 1:
                LinuxContextAttribs linuxContextAttribs2 = linuxContextAttribs;
                LinuxContextAttribs linuxContextAttribs3 = new LinuxContextAttribs();
                return linuxContextAttribs2;
            case 3:
                WindowsContextAttribs windowsContextAttribs2 = windowsContextAttribs;
                WindowsContextAttribs windowsContextAttribs3 = new WindowsContextAttribs();
                return windowsContextAttribs2;
            default:
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Unsupported platform");
                throw illegalStateException2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0101, code lost:
        if (r2.minorVersion != 0) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0039, code lost:
        if (r2.minorVersion != 0) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.nio.IntBuffer getAttribList() {
        /*
            r22 = this;
            r2 = r22
            int r19 = org.lwjgl.LWJGLUtil.getPlatform()
            r20 = 2
            r0 = r19
            r1 = r20
            if (r0 != r1) goto L_0x0013
        L_0x000e:
            r19 = 0
            r2 = r19
        L_0x0012:
            return r2
        L_0x0013:
            org.lwjgl.opengl.ContextAttribsImplementation r19 = getImplementation()
            r3 = r19
            r19 = r2
            r0 = r19
            int r0 = r0.majorVersion
            r19 = r0
            r20 = 1
            r0 = r19
            r1 = r20
            if (r0 != r1) goto L_0x003b
            r19 = r2
            r0 = r19
            int r0 = r0.minorVersion
            r19 = r0
            r18 = r19
            r19 = 0
            r4 = r19
            r19 = r18
            if (r19 == 0) goto L_0x0043
        L_0x003b:
            r19 = 0
            r20 = 2
            int r19 = r19 + 2
            r4 = r19
        L_0x0043:
            r19 = r2
            r0 = r19
            int r0 = r0.layerPlane
            r19 = r0
            if (r19 <= 0) goto L_0x004f
            int r4 = r4 + 1
        L_0x004f:
            r19 = r2
            r0 = r19
            boolean r0 = r0.debug
            r19 = r0
            r5 = r19
            r19 = 0
            r6 = r19
            r19 = r5
            if (r19 == 0) goto L_0x006d
            r19 = 0
            r20 = r3
            int r20 = r20.getDebugBit()
            r19 = r19 | r20
            r6 = r19
        L_0x006d:
            r19 = r2
            r0 = r19
            boolean r0 = r0.forwardCompatible
            r19 = r0
            if (r19 == 0) goto L_0x0083
            r19 = r6
            r20 = r3
            int r20 = r20.getForwardCompatibleBit()
            r19 = r19 | r20
            r6 = r19
        L_0x0083:
            r19 = r2
            r0 = r19
            boolean r0 = r0.robustAccess
            r19 = r0
            if (r19 == 0) goto L_0x0095
            r19 = r6
            r20 = 4
            r19 = r19 | 4
            r6 = r19
        L_0x0095:
            r19 = r2
            r0 = r19
            boolean r0 = r0.contextResetIsolation
            r19 = r0
            if (r19 == 0) goto L_0x00a7
            r19 = r6
            r20 = 8
            r19 = r19 | 8
            r6 = r19
        L_0x00a7:
            r19 = r6
            if (r19 <= 0) goto L_0x00ad
            int r4 = r4 + 1
        L_0x00ad:
            r19 = r2
            r0 = r19
            boolean r0 = r0.profileCore
            r19 = r0
            if (r19 == 0) goto L_0x01af
            r19 = 0
            r20 = r3
            int r20 = r20.getProfileCoreBit()
            r19 = r19 | r20
            r8 = r19
        L_0x00c3:
            r19 = r8
            if (r19 <= 0) goto L_0x00c9
            int r4 = r4 + 1
        L_0x00c9:
            r19 = r2
            r0 = r19
            boolean r0 = r0.loseContextOnReset
            r19 = r0
            if (r19 == 0) goto L_0x00d5
            int r4 = r4 + 1
        L_0x00d5:
            r19 = r4
            if (r19 == 0) goto L_0x000e
            r19 = 1
            r20 = r4
            r21 = 2
            int r20 = r20 * 2
            int r19 = r19 + r20
            java.nio.IntBuffer r19 = org.lwjgl.BufferUtils.createIntBuffer(r19)
            r9 = r19
            r19 = r2
            r0 = r19
            int r0 = r0.majorVersion
            r19 = r0
            r20 = 1
            r0 = r19
            r1 = r20
            if (r0 != r1) goto L_0x0103
            r19 = r2
            r0 = r19
            int r0 = r0.minorVersion
            r19 = r0
            if (r19 == 0) goto L_0x0133
        L_0x0103:
            r19 = r9
            r20 = r3
            int r20 = r20.getMajorVersionAttrib()
            java.nio.IntBuffer r19 = r19.put(r20)
            r20 = r2
            r0 = r20
            int r0 = r0.majorVersion
            r20 = r0
            java.nio.IntBuffer r19 = r19.put(r20)
            r19 = r9
            r20 = r3
            int r20 = r20.getMinorVersionAttrib()
            java.nio.IntBuffer r19 = r19.put(r20)
            r20 = r2
            r0 = r20
            int r0 = r0.minorVersion
            r20 = r0
            java.nio.IntBuffer r19 = r19.put(r20)
        L_0x0133:
            r19 = r2
            r0 = r19
            int r0 = r0.layerPlane
            r19 = r0
            if (r19 <= 0) goto L_0x0155
            r19 = r9
            r20 = r3
            int r20 = r20.getLayerPlaneAttrib()
            java.nio.IntBuffer r19 = r19.put(r20)
            r20 = r2
            r0 = r20
            int r0 = r0.layerPlane
            r20 = r0
            java.nio.IntBuffer r19 = r19.put(r20)
        L_0x0155:
            r19 = r6
            if (r19 <= 0) goto L_0x016b
            r19 = r9
            r20 = r3
            int r20 = r20.getFlagsAttrib()
            java.nio.IntBuffer r19 = r19.put(r20)
            r20 = r6
            java.nio.IntBuffer r19 = r19.put(r20)
        L_0x016b:
            r19 = r8
            if (r19 <= 0) goto L_0x0181
            r19 = r9
            r20 = r3
            int r20 = r20.getProfileMaskAttrib()
            java.nio.IntBuffer r19 = r19.put(r20)
            r20 = r8
            java.nio.IntBuffer r19 = r19.put(r20)
        L_0x0181:
            r19 = r2
            r0 = r19
            boolean r0 = r0.loseContextOnReset
            r19 = r0
            if (r19 == 0) goto L_0x019b
            r19 = r9
            r20 = 33366(0x8256, float:4.6756E-41)
            java.nio.IntBuffer r19 = r19.put(r20)
            r20 = 33362(0x8252, float:4.675E-41)
            java.nio.IntBuffer r19 = r19.put(r20)
        L_0x019b:
            r19 = r9
            r20 = 0
            java.nio.IntBuffer r19 = r19.put(r20)
            r19 = r9
            java.nio.Buffer r19 = r19.rewind()
            r19 = r9
            r2 = r19
            goto L_0x0012
        L_0x01af:
            r19 = r2
            r0 = r19
            boolean r0 = r0.profileCompatibility
            r19 = r0
            if (r19 == 0) goto L_0x01c7
            r19 = 0
            r20 = r3
            int r20 = r20.getProfileCompatibilityBit()
            r19 = r19 | r20
            r8 = r19
            goto L_0x00c3
        L_0x01c7:
            r19 = r2
            r0 = r19
            boolean r0 = r0.profileES
            r19 = r0
            r7 = r19
            r19 = 0
            r8 = r19
            r19 = r7
            if (r19 == 0) goto L_0x00c3
            r19 = 0
            r20 = 4
            r19 = r19 | 4
            r8 = r19
            goto L_0x00c3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextAttribs.getAttribList():java.nio.IntBuffer");
    }

    public int getLayerPlane() {
        return this.layerPlane;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isForwardCompatible() {
        return this.forwardCompatible;
    }

    public boolean isProfileCompatibility() {
        return this.profileCompatibility;
    }

    public boolean isProfileCore() {
        return this.profileCore;
    }

    public boolean isProfileES() {
        return this.profileES;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(32);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("ContextAttribs:");
        StringBuilder append2 = sb4.append(" Version=").append(this.majorVersion).append('.').append(this.minorVersion);
        StringBuilder append3 = sb4.append(" - Layer=").append(this.layerPlane);
        StringBuilder append4 = sb4.append(" - Debug=").append(this.debug);
        StringBuilder append5 = sb4.append(" - ForwardCompatible=").append(this.forwardCompatible);
        StringBuilder append6 = sb4.append(" - RobustAccess=").append(this.robustAccess);
        if (this.robustAccess) {
            StringBuilder append7 = sb4.append(" (").append(this.loseContextOnReset ? "LOSE_CONTEXT_ON_RESET" : "NO_RESET_NOTIFICATION");
        }
        StringBuilder append8 = sb4.append(" - Profile=");
        if (this.profileCore) {
            StringBuilder append9 = sb4.append("Core");
        } else if (this.profileCompatibility) {
            StringBuilder append10 = sb4.append("Compatibility");
        } else {
            StringBuilder append11 = sb4.append("None");
        }
        return sb4.toString();
    }

    public ContextAttribs withContextResetIsolation(boolean z) {
        ContextAttribs contextAttribs;
        boolean z2 = z;
        if (z2 == this.contextResetIsolation) {
            return this;
        }
        ContextAttribs contextAttribs2 = contextAttribs;
        ContextAttribs contextAttribs3 = new ContextAttribs(this);
        ContextAttribs contextAttribs4 = contextAttribs2;
        contextAttribs4.contextResetIsolation = z2;
        return contextAttribs4;
    }

    public ContextAttribs withDebug(boolean z) {
        ContextAttribs contextAttribs;
        boolean z2 = z;
        if (z2 == this.debug) {
            return this;
        }
        ContextAttribs contextAttribs2 = contextAttribs;
        ContextAttribs contextAttribs3 = new ContextAttribs(this);
        ContextAttribs contextAttribs4 = contextAttribs2;
        contextAttribs4.debug = z2;
        return contextAttribs4;
    }

    public ContextAttribs withForwardCompatible(boolean z) {
        ContextAttribs contextAttribs;
        boolean z2 = z;
        if (z2 == this.forwardCompatible) {
            return this;
        }
        ContextAttribs contextAttribs2 = contextAttribs;
        ContextAttribs contextAttribs3 = new ContextAttribs(this);
        ContextAttribs contextAttribs4 = contextAttribs2;
        contextAttribs4.forwardCompatible = z2;
        return contextAttribs4;
    }

    public ContextAttribs withLayer(int i) {
        ContextAttribs contextAttribs;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid layer plane specified: ").append(i2).toString());
            throw illegalArgumentException2;
        } else if (i2 == this.layerPlane) {
            return this;
        } else {
            ContextAttribs contextAttribs2 = contextAttribs;
            ContextAttribs contextAttribs3 = new ContextAttribs(this);
            ContextAttribs contextAttribs4 = contextAttribs2;
            contextAttribs4.layerPlane = i2;
            return contextAttribs4;
        }
    }

    public ContextAttribs withLoseContextOnReset(boolean z) {
        ContextAttribs contextAttribs;
        boolean z2 = z;
        if (z2 == this.loseContextOnReset) {
            return this;
        }
        ContextAttribs contextAttribs2 = contextAttribs;
        ContextAttribs contextAttribs3 = new ContextAttribs(this);
        ContextAttribs contextAttribs4 = contextAttribs2;
        contextAttribs4.loseContextOnReset = z2;
        return contextAttribs4;
    }

    public ContextAttribs withProfileCompatibility(boolean z) {
        IllegalArgumentException illegalArgumentException;
        ContextAttribs contextAttribs;
        boolean z2 = z;
        if (this.majorVersion < 3 || (this.majorVersion == 3 && this.minorVersion < 2)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Profiles are only supported on OpenGL version 3.2 or higher.");
            throw illegalArgumentException2;
        } else if (z2 == this.profileCompatibility) {
            return this;
        } else {
            ContextAttribs contextAttribs2 = contextAttribs;
            ContextAttribs contextAttribs3 = new ContextAttribs(this);
            ContextAttribs contextAttribs4 = contextAttribs2;
            contextAttribs4.profileCompatibility = z2;
            if (z2) {
                contextAttribs4.profileCore = false;
            }
            return contextAttribs4;
        }
    }

    public ContextAttribs withProfileCore(boolean z) {
        IllegalArgumentException illegalArgumentException;
        ContextAttribs contextAttribs;
        boolean z2 = z;
        if (this.majorVersion < 3 || (this.majorVersion == 3 && this.minorVersion < 2)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Profiles are only supported on OpenGL version 3.2 or higher.");
            throw illegalArgumentException2;
        } else if (z2 == this.profileCore) {
            return this;
        } else {
            ContextAttribs contextAttribs2 = contextAttribs;
            ContextAttribs contextAttribs3 = new ContextAttribs(this);
            ContextAttribs contextAttribs4 = contextAttribs2;
            contextAttribs4.profileCore = z2;
            if (z2) {
                contextAttribs4.profileCompatibility = false;
            }
            return contextAttribs4;
        }
    }

    public ContextAttribs withProfileES(boolean z) {
        IllegalArgumentException illegalArgumentException;
        ContextAttribs contextAttribs;
        boolean z2 = z;
        if (this.majorVersion != 2 || this.minorVersion != 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("The OpenGL ES profiles is only supported for OpenGL version 2.0.");
            throw illegalArgumentException2;
        } else if (z2 == this.profileES) {
            return this;
        } else {
            ContextAttribs contextAttribs2 = contextAttribs;
            ContextAttribs contextAttribs3 = new ContextAttribs(this);
            ContextAttribs contextAttribs4 = contextAttribs2;
            contextAttribs4.profileES = z2;
            return contextAttribs4;
        }
    }
}
