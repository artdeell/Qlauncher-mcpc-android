package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.GLUtessellator;
import org.lwjgl.util.glu.GLUtessellatorCallback;
import org.lwjgl.util.glu.GLUtessellatorCallbackAdapter;

public class GLUtessellatorImpl implements GLUtessellator {
    static final /* synthetic */ boolean $assertionsDisabled = (!GLUtessellatorImpl.class.desiredAssertionStatus());
    private static final double GLU_TESS_DEFAULT_TOLERANCE = 0.0d;
    private static GLUtessellatorCallback NULL_CB = null;
    public static final int TESS_MAX_CACHE = 100;
    boolean boundaryOnly;
    CachedVertex[] cache = new CachedVertex[100];
    int cacheCount;
    private GLUtessellatorCallback callBegin;
    private GLUtessellatorCallback callBeginData;
    private GLUtessellatorCallback callCombine;
    private GLUtessellatorCallback callCombineData;
    private GLUtessellatorCallback callEdgeFlag;
    private GLUtessellatorCallback callEdgeFlagData;
    private GLUtessellatorCallback callEnd;
    private GLUtessellatorCallback callEndData;
    private GLUtessellatorCallback callError;
    private GLUtessellatorCallback callErrorData;
    private GLUtessellatorCallback callVertex;
    private GLUtessellatorCallback callVertexData;
    Dict dict;
    GLUvertex event;
    boolean fatalError;
    boolean flagBoundary;
    private boolean flushCacheOnNextVertex;
    private GLUhalfEdge lastEdge;
    GLUface lonelyTriList;
    GLUmesh mesh;
    double[] normal = new double[3];
    private Object polygonData;

    /* renamed from: pq */
    PriorityQ f241pq;
    private double relTolerance;
    double[] sUnit = new double[3];
    private int state = 0;
    double[] tUnit = new double[3];
    int windingRule;

    static {
        GLUtessellatorCallbackAdapter gLUtessellatorCallbackAdapter;
        GLUtessellatorCallbackAdapter gLUtessellatorCallbackAdapter2 = gLUtessellatorCallbackAdapter;
        GLUtessellatorCallbackAdapter gLUtessellatorCallbackAdapter3 = new GLUtessellatorCallbackAdapter();
        NULL_CB = gLUtessellatorCallbackAdapter2;
    }

    public GLUtessellatorImpl() {
        CachedVertex cachedVertex;
        this.normal[0] = 0.0d;
        this.normal[1] = 0.0d;
        this.normal[2] = 0.0d;
        this.relTolerance = GLU_TESS_DEFAULT_TOLERANCE;
        this.windingRule = GLU.GLU_TESS_WINDING_ODD;
        this.flagBoundary = false;
        this.boundaryOnly = false;
        this.callBegin = NULL_CB;
        this.callEdgeFlag = NULL_CB;
        this.callVertex = NULL_CB;
        this.callEnd = NULL_CB;
        this.callError = NULL_CB;
        this.callCombine = NULL_CB;
        this.callBeginData = NULL_CB;
        this.callEdgeFlagData = NULL_CB;
        this.callVertexData = NULL_CB;
        this.callEndData = NULL_CB;
        this.callErrorData = NULL_CB;
        this.callCombineData = NULL_CB;
        this.polygonData = null;
        for (int i = 0; i < this.cache.length; i++) {
            CachedVertex[] cachedVertexArr = this.cache;
            int i2 = i;
            CachedVertex cachedVertex2 = cachedVertex;
            CachedVertex cachedVertex3 = new CachedVertex();
            cachedVertexArr[i2] = cachedVertex2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        if (org.lwjgl.util.glu.tessellation.Mesh.__gl_meshSplice(r4, r4.Sym) == false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean addVertex(double[] r10, java.lang.Object r11) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r0
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r5 = r5.lastEdge
            r3 = r5
            r5 = r3
            if (r5 != 0) goto L_0x005d
            r5 = r0
            org.lwjgl.util.glu.tessellation.GLUmesh r5 = r5.mesh
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r5 = org.lwjgl.util.glu.tessellation.Mesh.__gl_meshMakeEdge(r5)
            r4 = r5
            r5 = r4
            if (r5 != 0) goto L_0x0018
        L_0x0015:
            r5 = 0
            r0 = r5
        L_0x0017:
            return r0
        L_0x0018:
            r5 = r4
            r6 = r4
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r6 = r6.Sym
            boolean r5 = org.lwjgl.util.glu.tessellation.Mesh.__gl_meshSplice(r5, r6)
            if (r5 == 0) goto L_0x0015
        L_0x0022:
            r5 = r4
            org.lwjgl.util.glu.tessellation.GLUvertex r5 = r5.Org
            r6 = r2
            r5.data = r6
            r5 = r4
            org.lwjgl.util.glu.tessellation.GLUvertex r5 = r5.Org
            double[] r5 = r5.coords
            r6 = 0
            r7 = r1
            r8 = 0
            r7 = r7[r8]
            r5[r6] = r7
            r5 = r4
            org.lwjgl.util.glu.tessellation.GLUvertex r5 = r5.Org
            double[] r5 = r5.coords
            r6 = 1
            r7 = r1
            r8 = 1
            r7 = r7[r8]
            r5[r6] = r7
            r5 = r4
            org.lwjgl.util.glu.tessellation.GLUvertex r5 = r5.Org
            double[] r5 = r5.coords
            r6 = 2
            r7 = r1
            r8 = 2
            r7 = r7[r8]
            r5[r6] = r7
            r5 = r4
            r6 = 1
            r5.winding = r6
            r5 = r4
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r5 = r5.Sym
            r6 = -1
            r5.winding = r6
            r5 = r0
            r6 = r4
            r5.lastEdge = r6
            r5 = 1
            r0 = r5
            goto L_0x0017
        L_0x005d:
            r5 = r3
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r5 = org.lwjgl.util.glu.tessellation.Mesh.__gl_meshSplitEdge(r5)
            if (r5 == 0) goto L_0x0015
            r5 = r3
            org.lwjgl.util.glu.tessellation.GLUhalfEdge r5 = r5.Lnext
            r4 = r5
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.glu.tessellation.GLUtessellatorImpl.addVertex(double[], java.lang.Object):boolean");
    }

    private void cacheVertex(double[] dArr, Object obj) {
        CachedVertex cachedVertex;
        double[] dArr2 = dArr;
        Object obj2 = obj;
        if (this.cache[this.cacheCount] == null) {
            CachedVertex[] cachedVertexArr = this.cache;
            int i = this.cacheCount;
            CachedVertex cachedVertex2 = cachedVertex;
            CachedVertex cachedVertex3 = new CachedVertex();
            cachedVertexArr[i] = cachedVertex2;
        }
        CachedVertex cachedVertex4 = this.cache[this.cacheCount];
        cachedVertex4.data = obj2;
        cachedVertex4.coords[0] = dArr2[0];
        cachedVertex4.coords[1] = dArr2[1];
        cachedVertex4.coords[2] = dArr2[2];
        this.cacheCount = 1 + this.cacheCount;
    }

    private boolean flushCache() {
        CachedVertex[] cachedVertexArr = this.cache;
        this.mesh = Mesh.__gl_meshNewMesh();
        if (this.mesh != null) {
            int i = 0;
            while (i < this.cacheCount) {
                CachedVertex cachedVertex = cachedVertexArr[i];
                if (addVertex(cachedVertex.coords, cachedVertex.data)) {
                    i++;
                }
            }
            this.cacheCount = 0;
            this.flushCacheOnNextVertex = false;
            return true;
        }
        return false;
    }

    public static GLUtessellator gluNewTess() {
        GLUtessellatorImpl gLUtessellatorImpl;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        GLUtessellatorImpl gLUtessellatorImpl3 = new GLUtessellatorImpl();
        return gLUtessellatorImpl2;
    }

    private void gotoState(int i) {
        int i2 = i;
        while (this.state != i2) {
            if (this.state < i2) {
                if (this.state == 0) {
                    callErrorOrErrorData(100151);
                    gluTessBeginPolygon(null);
                } else if (this.state == 1) {
                    callErrorOrErrorData(100152);
                    gluTessBeginContour();
                }
            } else if (this.state == 2) {
                callErrorOrErrorData(100154);
                gluTessEndContour();
            } else if (this.state == 1) {
                callErrorOrErrorData(100153);
                makeDormant();
            }
        }
    }

    private void makeDormant() {
        if (this.mesh != null) {
            Mesh.__gl_meshDeleteMesh(this.mesh);
        }
        this.state = 0;
        this.lastEdge = null;
        this.mesh = null;
    }

    private void requireState(int i) {
        int i2 = i;
        if (this.state != i2) {
            gotoState(i2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void callBeginOrBeginData(int i) {
        int i2 = i;
        if (this.callBeginData != NULL_CB) {
            this.callBeginData.beginData(i2, this.polygonData);
        } else {
            this.callBegin.begin(i2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void callCombineOrCombineData(double[] dArr, Object[] objArr, float[] fArr, Object[] objArr2) {
        double[] dArr2 = dArr;
        Object[] objArr3 = objArr;
        float[] fArr2 = fArr;
        Object[] objArr4 = objArr2;
        if (this.callCombineData != NULL_CB) {
            this.callCombineData.combineData(dArr2, objArr3, fArr2, objArr4, this.polygonData);
        } else {
            this.callCombine.combine(dArr2, objArr3, fArr2, objArr4);
        }
    }

    /* access modifiers changed from: 0000 */
    public void callEdgeFlagOrEdgeFlagData(boolean z) {
        boolean z2 = z;
        if (this.callEdgeFlagData != NULL_CB) {
            this.callEdgeFlagData.edgeFlagData(z2, this.polygonData);
        } else {
            this.callEdgeFlag.edgeFlag(z2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void callEndOrEndData() {
        if (this.callEndData != NULL_CB) {
            this.callEndData.endData(this.polygonData);
        } else {
            this.callEnd.end();
        }
    }

    /* access modifiers changed from: 0000 */
    public void callErrorOrErrorData(int i) {
        int i2 = i;
        if (this.callErrorData != NULL_CB) {
            this.callErrorData.errorData(i2, this.polygonData);
        } else {
            this.callError.error(i2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void callVertexOrVertexData(Object obj) {
        Object obj2 = obj;
        if (this.callVertexData != NULL_CB) {
            this.callVertexData.vertexData(obj2, this.polygonData);
        } else {
            this.callVertex.vertex(obj2);
        }
    }

    public void gluBeginPolygon() {
        gluTessBeginPolygon(null);
        gluTessBeginContour();
    }

    public void gluDeleteTess() {
        requireState(0);
    }

    public void gluEndPolygon() {
        gluTessEndContour();
        gluTessEndPolygon();
    }

    public void gluGetTessProperty(int i, double[] dArr, int i2) {
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        double[] dArr2 = dArr;
        int i3 = i2;
        double d = 1.0d;
        switch (i) {
            case GLU.GLU_TESS_WINDING_RULE /*100140*/:
                if ($assertionsDisabled || this.windingRule == 100130 || this.windingRule == 100131 || this.windingRule == 100132 || this.windingRule == 100133 || this.windingRule == 100134) {
                    dArr2[i3] = (double) this.windingRule;
                    return;
                }
                AssertionError assertionError4 = assertionError2;
                AssertionError assertionError5 = new AssertionError();
                throw assertionError4;
            case GLU.GLU_TESS_BOUNDARY_ONLY /*100141*/:
                if ($assertionsDisabled || this.boundaryOnly || !this.boundaryOnly) {
                    if (!this.boundaryOnly) {
                        d = 0.0d;
                    }
                    dArr2[i3] = d;
                    return;
                }
                AssertionError assertionError6 = assertionError;
                AssertionError assertionError7 = new AssertionError();
                throw assertionError6;
            case GLU.GLU_TESS_TOLERANCE /*100142*/:
                if ($assertionsDisabled || (GLU_TESS_DEFAULT_TOLERANCE <= this.relTolerance && this.relTolerance <= 1.0d)) {
                    dArr2[i3] = this.relTolerance;
                    return;
                }
                AssertionError assertionError8 = assertionError3;
                AssertionError assertionError9 = new AssertionError();
                throw assertionError8;
            default:
                dArr2[i3] = 0.0d;
                callErrorOrErrorData(100900);
                return;
        }
    }

    public void gluNextContour(int i) {
        int i2 = i;
        gluTessEndContour();
        gluTessBeginContour();
    }

    public void gluTessBeginContour() {
        requireState(1);
        this.state = 2;
        this.lastEdge = null;
        if (this.cacheCount > 0) {
            this.flushCacheOnNextVertex = true;
        }
    }

    public void gluTessBeginPolygon(Object obj) {
        Object obj2 = obj;
        requireState(0);
        this.state = 1;
        this.cacheCount = 0;
        this.flushCacheOnNextVertex = false;
        this.mesh = null;
        this.polygonData = obj2;
    }

    public void gluTessCallback(int i, GLUtessellatorCallback gLUtessellatorCallback) {
        GLUtessellatorCallback gLUtessellatorCallback2 = gLUtessellatorCallback;
        boolean z = true;
        switch (i) {
            case 100100:
                if (gLUtessellatorCallback2 == null) {
                    gLUtessellatorCallback2 = NULL_CB;
                }
                this.callBegin = gLUtessellatorCallback2;
                return;
            case 100101:
                if (gLUtessellatorCallback2 == null) {
                    gLUtessellatorCallback2 = NULL_CB;
                }
                this.callVertex = gLUtessellatorCallback2;
                return;
            case 100102:
                if (gLUtessellatorCallback2 == null) {
                    gLUtessellatorCallback2 = NULL_CB;
                }
                this.callEnd = gLUtessellatorCallback2;
                return;
            case 100103:
                if (gLUtessellatorCallback2 == null) {
                    gLUtessellatorCallback2 = NULL_CB;
                }
                this.callError = gLUtessellatorCallback2;
                return;
            case 100104:
                this.callEdgeFlag = gLUtessellatorCallback2 == null ? NULL_CB : gLUtessellatorCallback2;
                this.flagBoundary = gLUtessellatorCallback2 != null;
                return;
            case GLU.GLU_TESS_COMBINE /*100105*/:
                if (gLUtessellatorCallback2 == null) {
                    gLUtessellatorCallback2 = NULL_CB;
                }
                this.callCombine = gLUtessellatorCallback2;
                return;
            case GLU.GLU_TESS_BEGIN_DATA /*100106*/:
                if (gLUtessellatorCallback2 == null) {
                    gLUtessellatorCallback2 = NULL_CB;
                }
                this.callBeginData = gLUtessellatorCallback2;
                return;
            case GLU.GLU_TESS_VERTEX_DATA /*100107*/:
                if (gLUtessellatorCallback2 == null) {
                    gLUtessellatorCallback2 = NULL_CB;
                }
                this.callVertexData = gLUtessellatorCallback2;
                return;
            case GLU.GLU_TESS_END_DATA /*100108*/:
                if (gLUtessellatorCallback2 == null) {
                    gLUtessellatorCallback2 = NULL_CB;
                }
                this.callEndData = gLUtessellatorCallback2;
                return;
            case GLU.GLU_TESS_ERROR_DATA /*100109*/:
                if (gLUtessellatorCallback2 == null) {
                    gLUtessellatorCallback2 = NULL_CB;
                }
                this.callErrorData = gLUtessellatorCallback2;
                return;
            case GLU.GLU_TESS_EDGE_FLAG_DATA /*100110*/:
                GLUtessellatorCallback gLUtessellatorCallback3 = gLUtessellatorCallback2 == null ? NULL_CB : gLUtessellatorCallback2;
                this.callBegin = gLUtessellatorCallback3;
                this.callEdgeFlagData = gLUtessellatorCallback3;
                if (gLUtessellatorCallback2 == null) {
                    z = false;
                }
                this.flagBoundary = z;
                return;
            case GLU.GLU_TESS_COMBINE_DATA /*100111*/:
                if (gLUtessellatorCallback2 == null) {
                    gLUtessellatorCallback2 = NULL_CB;
                }
                this.callCombineData = gLUtessellatorCallback2;
                return;
            default:
                callErrorOrErrorData(100900);
                return;
        }
    }

    public void gluTessEndContour() {
        requireState(2);
        this.state = 1;
    }

    public void gluTessEndPolygon() {
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RuntimeException runtimeException3;
        try {
            requireState(1);
            this.state = 0;
            if (this.mesh == null) {
                if (!this.flagBoundary && Render.__gl_renderCache(this)) {
                    this.polygonData = null;
                    return;
                } else if (!flushCache()) {
                    RuntimeException runtimeException4 = runtimeException3;
                    RuntimeException runtimeException5 = new RuntimeException();
                    throw runtimeException4;
                }
            }
            Normal.__gl_projectPolygon(this);
            if (!Sweep.__gl_computeInterior(this)) {
                RuntimeException runtimeException6 = runtimeException2;
                RuntimeException runtimeException7 = new RuntimeException();
                throw runtimeException6;
            }
            GLUmesh gLUmesh = this.mesh;
            if (!this.fatalError) {
                if (!(this.boundaryOnly ? TessMono.__gl_meshSetWindingNumber(gLUmesh, 1, true) : TessMono.__gl_meshTessellateInterior(gLUmesh))) {
                    RuntimeException runtimeException8 = runtimeException;
                    RuntimeException runtimeException9 = new RuntimeException();
                    throw runtimeException8;
                }
                Mesh.__gl_meshCheckMesh(gLUmesh);
                if (!(this.callBegin == NULL_CB && this.callEnd == NULL_CB && this.callVertex == NULL_CB && this.callEdgeFlag == NULL_CB && this.callBeginData == NULL_CB && this.callEndData == NULL_CB && this.callVertexData == NULL_CB && this.callEdgeFlagData == NULL_CB)) {
                    if (this.boundaryOnly) {
                        Render.__gl_renderBoundary(this, gLUmesh);
                    } else {
                        Render.__gl_renderMesh(this, gLUmesh);
                    }
                }
            }
            Mesh.__gl_meshDeleteMesh(gLUmesh);
            this.polygonData = null;
        } catch (Exception e) {
            e.printStackTrace();
            callErrorOrErrorData(100902);
        }
    }

    public void gluTessNormal(double d, double d2, double d3) {
        double d4 = d2;
        double d5 = d3;
        this.normal[0] = d;
        this.normal[1] = d4;
        this.normal[2] = d5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        if (r2 == GLU_TESS_DEFAULT_TOLERANCE) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        r0.boundaryOnly = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        callErrorOrErrorData(100901);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void gluTessProperty(int r11, double r12) {
        /*
            r10 = this;
            r0 = r10
            r1 = r11
            r2 = r12
            r6 = r1
            switch(r6) {
                case 100140: goto L_0x002a;
                case 100141: goto L_0x0038;
                case 100142: goto L_0x000f;
                default: goto L_0x0007;
            }
        L_0x0007:
            r6 = r0
            r7 = 100900(0x18a24, float:1.41391E-40)
            r6.callErrorOrErrorData(r7)
        L_0x000e:
            return
        L_0x000f:
            r6 = r2
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x001d
            r6 = r2
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0025
        L_0x001d:
            r6 = r0
            r7 = 100901(0x18a25, float:1.41392E-40)
            r6.callErrorOrErrorData(r7)
            goto L_0x000e
        L_0x0025:
            r6 = r0
            r7 = r2
            r6.relTolerance = r7
            goto L_0x000e
        L_0x002a:
            r6 = r2
            int r6 = (int) r6
            r5 = r6
            r6 = r5
            double r6 = (double) r6
            r8 = r2
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x001d
            r6 = r5
            switch(r6) {
                case 100130: goto L_0x0046;
                case 100131: goto L_0x0046;
                case 100132: goto L_0x0046;
                case 100133: goto L_0x0046;
                case 100134: goto L_0x0046;
                default: goto L_0x0038;
            }
        L_0x0038:
            r6 = r2
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x004b
            r6 = 1
            r4 = r6
        L_0x0041:
            r6 = r0
            r7 = r4
            r6.boundaryOnly = r7
            goto L_0x000e
        L_0x0046:
            r6 = r0
            r7 = r5
            r6.windingRule = r7
            goto L_0x000e
        L_0x004b:
            r6 = 0
            r4 = r6
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.glu.tessellation.GLUtessellatorImpl.gluTessProperty(int, double):void");
    }

    public void gluTessVertex(double[] dArr, int i, Object obj) {
        double[] dArr2 = dArr;
        int i2 = i;
        Object obj2 = obj;
        boolean z = false;
        double[] dArr3 = new double[3];
        requireState(2);
        if (this.flushCacheOnNextVertex) {
            if (!flushCache()) {
                callErrorOrErrorData(100902);
                return;
            }
            this.lastEdge = null;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            double d = dArr2[i3 + i2];
            if (d < -1.0E150d) {
                d = -1.0E150d;
                z = true;
            }
            if (d > 1.0E150d) {
                d = 1.0E150d;
                z = true;
            }
            dArr3[i3] = d;
        }
        if (z) {
            callErrorOrErrorData(100155);
        }
        if (this.mesh == null) {
            if (this.cacheCount < 100) {
                cacheVertex(dArr3, obj2);
                return;
            } else if (!flushCache()) {
                callErrorOrErrorData(100902);
                return;
            }
        }
        if (!addVertex(dArr3, obj2)) {
            callErrorOrErrorData(100902);
        }
    }
}
