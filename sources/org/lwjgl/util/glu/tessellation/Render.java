package org.lwjgl.util.glu.tessellation;

class Render {
    static final /* synthetic */ boolean $assertionsDisabled = (!Render.class.desiredAssertionStatus());
    private static final int SIGN_INCONSISTENT = 2;
    private static final boolean USE_OPTIMIZED_CODE_PATH = false;
    private static final RenderFan renderFan;
    private static final RenderStrip renderStrip;
    private static final RenderTriangle renderTriangle;

    private static class FaceCount {
        GLUhalfEdge eStart;
        renderCallBack render;
        long size;

        private FaceCount() {
        }

        private FaceCount(long j, GLUhalfEdge gLUhalfEdge, renderCallBack rendercallback) {
            GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
            renderCallBack rendercallback2 = rendercallback;
            this.size = j;
            this.eStart = gLUhalfEdge2;
            this.render = rendercallback2;
        }

        /* synthetic */ FaceCount(long j, GLUhalfEdge gLUhalfEdge, renderCallBack rendercallback, C08461 r16) {
            C08461 r5 = r16;
            this(j, gLUhalfEdge, rendercallback);
        }

        /* synthetic */ FaceCount(C08461 r4) {
            C08461 r1 = r4;
            this();
        }
    }

    private static class RenderFan implements renderCallBack {
        static final /* synthetic */ boolean $assertionsDisabled = (!Render.class.desiredAssertionStatus());

        private RenderFan() {
        }

        /* synthetic */ RenderFan(C08461 r4) {
            C08461 r1 = r4;
            this();
        }

        public void render(GLUtessellatorImpl gLUtessellatorImpl, GLUhalfEdge gLUhalfEdge, long j) {
            AssertionError assertionError;
            GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
            GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
            long j2 = j;
            gLUtessellatorImpl2.callBeginOrBeginData(6);
            gLUtessellatorImpl2.callVertexOrVertexData(gLUhalfEdge2.Org.data);
            gLUtessellatorImpl2.callVertexOrVertexData(gLUhalfEdge2.Sym.Org.data);
            while (!Render.Marked(gLUhalfEdge2.Lface)) {
                gLUhalfEdge2.Lface.marked = true;
                j2--;
                gLUhalfEdge2 = gLUhalfEdge2.Onext;
                gLUtessellatorImpl2.callVertexOrVertexData(gLUhalfEdge2.Sym.Org.data);
            }
            if ($assertionsDisabled || j2 == 0) {
                gLUtessellatorImpl2.callEndOrEndData();
                return;
            }
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError();
            throw assertionError2;
        }
    }

    private static class RenderStrip implements renderCallBack {
        static final /* synthetic */ boolean $assertionsDisabled = (!Render.class.desiredAssertionStatus());

        private RenderStrip() {
        }

        /* synthetic */ RenderStrip(C08461 r4) {
            C08461 r1 = r4;
            this();
        }

        public void render(GLUtessellatorImpl gLUtessellatorImpl, GLUhalfEdge gLUhalfEdge, long j) {
            AssertionError assertionError;
            GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
            GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
            long j2 = j;
            gLUtessellatorImpl2.callBeginOrBeginData(5);
            gLUtessellatorImpl2.callVertexOrVertexData(gLUhalfEdge2.Org.data);
            gLUtessellatorImpl2.callVertexOrVertexData(gLUhalfEdge2.Sym.Org.data);
            while (!Render.Marked(gLUhalfEdge2.Lface)) {
                gLUhalfEdge2.Lface.marked = true;
                j2--;
                GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2.Lnext.Sym;
                gLUtessellatorImpl2.callVertexOrVertexData(gLUhalfEdge3.Org.data);
                if (Render.Marked(gLUhalfEdge3.Lface)) {
                    break;
                }
                gLUhalfEdge3.Lface.marked = true;
                j2--;
                gLUhalfEdge2 = gLUhalfEdge3.Onext;
                gLUtessellatorImpl2.callVertexOrVertexData(gLUhalfEdge2.Sym.Org.data);
            }
            if ($assertionsDisabled || j2 == 0) {
                gLUtessellatorImpl2.callEndOrEndData();
                return;
            }
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError();
            throw assertionError2;
        }
    }

    private static class RenderTriangle implements renderCallBack {
        static final /* synthetic */ boolean $assertionsDisabled = (!Render.class.desiredAssertionStatus());

        private RenderTriangle() {
        }

        /* synthetic */ RenderTriangle(C08461 r4) {
            C08461 r1 = r4;
            this();
        }

        public void render(GLUtessellatorImpl gLUtessellatorImpl, GLUhalfEdge gLUhalfEdge, long j) {
            AssertionError assertionError;
            GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
            GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
            long j2 = j;
            if ($assertionsDisabled || j2 == 1) {
                gLUtessellatorImpl2.lonelyTriList = Render.AddToTrail(gLUhalfEdge2.Lface, gLUtessellatorImpl2.lonelyTriList);
                return;
            }
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError();
            throw assertionError2;
        }
    }

    private interface renderCallBack {
        void render(GLUtessellatorImpl gLUtessellatorImpl, GLUhalfEdge gLUhalfEdge, long j);
    }

    static {
        RenderFan renderFan2;
        RenderStrip renderStrip2;
        RenderTriangle renderTriangle2;
        RenderFan renderFan3 = renderFan2;
        RenderFan renderFan4 = new RenderFan(null);
        renderFan = renderFan3;
        RenderStrip renderStrip3 = renderStrip2;
        RenderStrip renderStrip4 = new RenderStrip(null);
        renderStrip = renderStrip3;
        RenderTriangle renderTriangle3 = renderTriangle2;
        RenderTriangle renderTriangle4 = new RenderTriangle(null);
        renderTriangle = renderTriangle3;
    }

    private Render() {
    }

    /* access modifiers changed from: private */
    public static GLUface AddToTrail(GLUface gLUface, GLUface gLUface2) {
        GLUface gLUface3 = gLUface;
        gLUface3.trail = gLUface2;
        gLUface3.marked = true;
        return gLUface3;
    }

    static int ComputeNormal(GLUtessellatorImpl gLUtessellatorImpl, double[] dArr, boolean z) {
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        double[] dArr2 = dArr;
        boolean z2 = z;
        CachedVertex[] cachedVertexArr = gLUtessellatorImpl2.cache;
        int i = gLUtessellatorImpl2.cacheCount;
        double[] dArr3 = new double[3];
        int i2 = 0;
        if (!z2) {
            dArr2[2] = 0.0d;
            dArr2[1] = 0.0d;
            dArr2[0] = 0.0d;
        }
        int i3 = 1;
        double d = cachedVertexArr[1].coords[0] - cachedVertexArr[0].coords[0];
        double d2 = cachedVertexArr[1].coords[1] - cachedVertexArr[0].coords[1];
        double d3 = cachedVertexArr[1].coords[2] - cachedVertexArr[0].coords[2];
        while (true) {
            i3++;
            if (i3 >= i) {
                break;
            }
            double d4 = d;
            double d5 = d2;
            double d6 = d3;
            d = cachedVertexArr[i3].coords[0] - cachedVertexArr[0].coords[0];
            d2 = cachedVertexArr[i3].coords[1] - cachedVertexArr[0].coords[1];
            d3 = cachedVertexArr[i3].coords[2] - cachedVertexArr[0].coords[2];
            dArr3[0] = (d5 * d3) - (d6 * d2);
            dArr3[1] = (d6 * d) - (d4 * d3);
            dArr3[2] = (d4 * d2) - (d5 * d);
            double d7 = (dArr3[0] * dArr2[0]) + (dArr3[1] * dArr2[1]) + (dArr3[2] * dArr2[2]);
            if (!z2) {
                if (d7 >= 0.0d) {
                    dArr2[0] = dArr2[0] + dArr3[0];
                    dArr2[1] = dArr2[1] + dArr3[1];
                    dArr2[2] = dArr2[2] + dArr3[2];
                } else {
                    dArr2[0] = dArr2[0] - dArr3[0];
                    dArr2[1] = dArr2[1] - dArr3[1];
                    dArr2[2] = dArr2[2] - dArr3[2];
                }
            } else if (d7 == 0.0d) {
                continue;
            } else if (d7 > 0.0d) {
                if (i2 < 0) {
                    i2 = 2;
                    break;
                }
                i2 = 1;
            } else if (i2 > 0) {
                return 2;
            } else {
                i2 = -1;
            }
        }
        return i2;
    }

    private static void FreeTrail(GLUface gLUface) {
        for (GLUface gLUface2 = gLUface; gLUface2 != null; gLUface2 = gLUface2.trail) {
            gLUface2.marked = false;
        }
    }

    private static boolean IsEven(long j) {
        return (1 & j) == 0;
    }

    /* access modifiers changed from: private */
    public static boolean Marked(GLUface gLUface) {
        GLUface gLUface2 = gLUface;
        return !gLUface2.inside || gLUface2.marked;
    }

    static FaceCount MaximumFan(GLUhalfEdge gLUhalfEdge) {
        FaceCount faceCount;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        FaceCount faceCount2 = faceCount;
        FaceCount faceCount3 = new FaceCount(0, null, renderFan, null);
        FaceCount faceCount4 = faceCount2;
        GLUface gLUface = null;
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2;
        while (true) {
            GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge3;
            if (Marked(gLUhalfEdge4.Lface)) {
                break;
            }
            gLUface = AddToTrail(gLUhalfEdge4.Lface, gLUface);
            faceCount4.size = 1 + faceCount4.size;
            gLUhalfEdge3 = gLUhalfEdge4.Onext;
        }
        GLUhalfEdge gLUhalfEdge5 = gLUhalfEdge2;
        while (true) {
            GLUhalfEdge gLUhalfEdge6 = gLUhalfEdge5;
            if (!Marked(gLUhalfEdge6.Sym.Lface)) {
                gLUface = AddToTrail(gLUhalfEdge6.Sym.Lface, gLUface);
                faceCount4.size = 1 + faceCount4.size;
                gLUhalfEdge5 = gLUhalfEdge6.Sym.Lnext;
            } else {
                faceCount4.eStart = gLUhalfEdge6;
                FreeTrail(gLUface);
                return faceCount4;
            }
        }
    }

    static FaceCount MaximumStrip(GLUhalfEdge gLUhalfEdge) {
        FaceCount faceCount;
        GLUhalfEdge gLUhalfEdge2;
        GLUhalfEdge gLUhalfEdge3;
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge;
        FaceCount faceCount2 = faceCount;
        FaceCount faceCount3 = new FaceCount(0, null, renderStrip, null);
        FaceCount faceCount4 = faceCount2;
        long j = 0;
        long j2 = 0;
        GLUface gLUface = null;
        GLUhalfEdge gLUhalfEdge5 = gLUhalfEdge4;
        while (true) {
            gLUhalfEdge2 = gLUhalfEdge5;
            if (Marked(gLUhalfEdge2.Lface)) {
                break;
            }
            gLUface = AddToTrail(gLUhalfEdge2.Lface, gLUface);
            j2++;
            gLUhalfEdge2 = gLUhalfEdge2.Lnext.Sym;
            if (Marked(gLUhalfEdge2.Lface)) {
                break;
            }
            gLUface = AddToTrail(gLUhalfEdge2.Lface, gLUface);
            j2++;
            gLUhalfEdge5 = gLUhalfEdge2.Onext;
        }
        GLUhalfEdge gLUhalfEdge6 = gLUhalfEdge2;
        GLUhalfEdge gLUhalfEdge7 = gLUhalfEdge4;
        while (true) {
            gLUhalfEdge3 = gLUhalfEdge7;
            if (Marked(gLUhalfEdge3.Sym.Lface)) {
                break;
            }
            gLUface = AddToTrail(gLUhalfEdge3.Sym.Lface, gLUface);
            j++;
            gLUhalfEdge3 = gLUhalfEdge3.Sym.Lnext;
            if (Marked(gLUhalfEdge3.Sym.Lface)) {
                break;
            }
            gLUface = AddToTrail(gLUhalfEdge3.Sym.Lface, gLUface);
            j++;
            gLUhalfEdge7 = gLUhalfEdge3.Sym.Onext.Sym;
        }
        GLUhalfEdge gLUhalfEdge8 = gLUhalfEdge3;
        faceCount4.size = j2 + j;
        if (IsEven(j2)) {
            faceCount4.eStart = gLUhalfEdge6.Sym;
        } else if (IsEven(j)) {
            faceCount4.eStart = gLUhalfEdge8;
        } else {
            faceCount4.size--;
            faceCount4.eStart = gLUhalfEdge8.Onext;
        }
        FreeTrail(gLUface);
        return faceCount4;
    }

    static void RenderLonelyTriangles(GLUtessellatorImpl gLUtessellatorImpl, GLUface gLUface) {
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        boolean z = true;
        gLUtessellatorImpl2.callBeginOrBeginData(4);
        for (GLUface gLUface2 = gLUface; gLUface2 != null; gLUface2 = gLUface2.trail) {
            GLUhalfEdge gLUhalfEdge = gLUface2.anEdge;
            do {
                if (gLUtessellatorImpl2.flagBoundary) {
                    boolean z2 = !gLUhalfEdge.Sym.Lface.inside;
                    if (z != z2) {
                        z = z2;
                        gLUtessellatorImpl2.callEdgeFlagOrEdgeFlagData(z);
                    }
                }
                gLUtessellatorImpl2.callVertexOrVertexData(gLUhalfEdge.Org.data);
                gLUhalfEdge = gLUhalfEdge.Lnext;
            } while (gLUhalfEdge != gLUface2.anEdge);
        }
        gLUtessellatorImpl2.callEndOrEndData();
    }

    static void RenderMaximumFaceGroup(GLUtessellatorImpl gLUtessellatorImpl, GLUface gLUface) {
        FaceCount faceCount;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        GLUhalfEdge gLUhalfEdge = gLUface.anEdge;
        FaceCount faceCount2 = faceCount;
        FaceCount faceCount3 = new FaceCount(null);
        FaceCount faceCount4 = faceCount2;
        faceCount4.size = 1;
        faceCount4.eStart = gLUhalfEdge;
        faceCount4.render = renderTriangle;
        if (!gLUtessellatorImpl2.flagBoundary) {
            FaceCount MaximumFan = MaximumFan(gLUhalfEdge);
            if (MaximumFan.size > faceCount4.size) {
                faceCount4 = MaximumFan;
            }
            FaceCount MaximumFan2 = MaximumFan(gLUhalfEdge.Lnext);
            if (MaximumFan2.size > faceCount4.size) {
                faceCount4 = MaximumFan2;
            }
            FaceCount MaximumFan3 = MaximumFan(gLUhalfEdge.Onext.Sym);
            if (MaximumFan3.size > faceCount4.size) {
                faceCount4 = MaximumFan3;
            }
            FaceCount MaximumStrip = MaximumStrip(gLUhalfEdge);
            if (MaximumStrip.size > faceCount4.size) {
                faceCount4 = MaximumStrip;
            }
            FaceCount MaximumStrip2 = MaximumStrip(gLUhalfEdge.Lnext);
            if (MaximumStrip2.size > faceCount4.size) {
                faceCount4 = MaximumStrip2;
            }
            FaceCount MaximumStrip3 = MaximumStrip(gLUhalfEdge.Onext.Sym);
            if (MaximumStrip3.size > faceCount4.size) {
                faceCount4 = MaximumStrip3;
            }
        }
        faceCount4.render.render(gLUtessellatorImpl2, faceCount4.eStart, faceCount4.size);
    }

    public static void __gl_renderBoundary(GLUtessellatorImpl gLUtessellatorImpl, GLUmesh gLUmesh) {
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        GLUmesh gLUmesh2 = gLUmesh;
        GLUface gLUface = gLUmesh2.fHead.next;
        while (true) {
            GLUface gLUface2 = gLUface;
            if (gLUface2 != gLUmesh2.fHead) {
                if (gLUface2.inside) {
                    gLUtessellatorImpl2.callBeginOrBeginData(2);
                    GLUhalfEdge gLUhalfEdge = gLUface2.anEdge;
                    do {
                        gLUtessellatorImpl2.callVertexOrVertexData(gLUhalfEdge.Org.data);
                        gLUhalfEdge = gLUhalfEdge.Lnext;
                    } while (gLUhalfEdge != gLUface2.anEdge);
                    gLUtessellatorImpl2.callEndOrEndData();
                }
                gLUface = gLUface2.next;
            } else {
                return;
            }
        }
    }

    public static boolean __gl_renderCache(GLUtessellatorImpl gLUtessellatorImpl) {
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        CachedVertex[] cachedVertexArr = gLUtessellatorImpl2.cache;
        int i = gLUtessellatorImpl2.cacheCount;
        double[] dArr = new double[3];
        if (gLUtessellatorImpl2.cacheCount >= 3) {
            dArr[0] = gLUtessellatorImpl2.normal[0];
            dArr[1] = gLUtessellatorImpl2.normal[1];
            dArr[2] = gLUtessellatorImpl2.normal[2];
            if (dArr[0] == 0.0d && dArr[1] == 0.0d && dArr[2] == 0.0d) {
                int ComputeNormal = ComputeNormal(gLUtessellatorImpl2, dArr, false);
            }
            int ComputeNormal2 = ComputeNormal(gLUtessellatorImpl2, dArr, true);
            if (ComputeNormal2 == 2) {
                return false;
            }
            if (ComputeNormal2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void __gl_renderMesh(GLUtessellatorImpl gLUtessellatorImpl, GLUmesh gLUmesh) {
        AssertionError assertionError;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        GLUmesh gLUmesh2 = gLUmesh;
        gLUtessellatorImpl2.lonelyTriList = null;
        GLUface gLUface = gLUmesh2.fHead.next;
        while (true) {
            GLUface gLUface2 = gLUface;
            if (gLUface2 == gLUmesh2.fHead) {
                break;
            }
            gLUface2.marked = false;
            gLUface = gLUface2.next;
        }
        GLUface gLUface3 = gLUmesh2.fHead.next;
        while (true) {
            GLUface gLUface4 = gLUface3;
            if (gLUface4 != gLUmesh2.fHead) {
                if (gLUface4.inside && !gLUface4.marked) {
                    RenderMaximumFaceGroup(gLUtessellatorImpl2, gLUface4);
                    if (!$assertionsDisabled && !gLUface4.marked) {
                        AssertionError assertionError2 = assertionError;
                        AssertionError assertionError3 = new AssertionError();
                        throw assertionError2;
                    }
                }
                gLUface3 = gLUface4.next;
            } else if (gLUtessellatorImpl2.lonelyTriList != null) {
                RenderLonelyTriangles(gLUtessellatorImpl2, gLUtessellatorImpl2.lonelyTriList);
                gLUtessellatorImpl2.lonelyTriList = null;
                return;
            } else {
                return;
            }
        }
    }
}
