package org.lwjgl.util.glu.tessellation;

class TessMono {
    static final /* synthetic */ boolean $assertionsDisabled = (!TessMono.class.desiredAssertionStatus());

    TessMono() {
    }

    public static void __gl_meshDiscardExterior(GLUmesh gLUmesh) {
        GLUmesh gLUmesh2 = gLUmesh;
        GLUface gLUface = gLUmesh2.fHead.next;
        while (true) {
            GLUface gLUface2 = gLUface;
            if (gLUface2 != gLUmesh2.fHead) {
                GLUface gLUface3 = gLUface2.next;
                if (!gLUface2.inside) {
                    Mesh.__gl_meshZapFace(gLUface2);
                }
                gLUface = gLUface3;
            } else {
                return;
            }
        }
    }

    public static boolean __gl_meshSetWindingNumber(GLUmesh gLUmesh, int i, boolean z) {
        GLUmesh gLUmesh2 = gLUmesh;
        int i2 = i;
        boolean z2 = z;
        GLUhalfEdge gLUhalfEdge = gLUmesh2.eHead.next;
        while (true) {
            GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
            if (gLUhalfEdge2 == gLUmesh2.eHead) {
                return true;
            }
            GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2.next;
            if (gLUhalfEdge2.Sym.Lface.inside != gLUhalfEdge2.Lface.inside) {
                gLUhalfEdge2.winding = gLUhalfEdge2.Lface.inside ? i2 : -i2;
            } else if (!z2) {
                gLUhalfEdge2.winding = 0;
            } else if (!Mesh.__gl_meshDelete(gLUhalfEdge2)) {
                return false;
            }
            gLUhalfEdge = gLUhalfEdge3;
        }
    }

    public static boolean __gl_meshTessellateInterior(GLUmesh gLUmesh) {
        GLUmesh gLUmesh2 = gLUmesh;
        GLUface gLUface = gLUmesh2.fHead.next;
        while (true) {
            GLUface gLUface2 = gLUface;
            if (gLUface2 == gLUmesh2.fHead) {
                return true;
            }
            GLUface gLUface3 = gLUface2.next;
            if (gLUface2.inside && !__gl_meshTessellateMonoRegion(gLUface2)) {
                return false;
            }
            gLUface = gLUface3;
        }
    }

    static boolean __gl_meshTessellateMonoRegion(GLUface gLUface) {
        AssertionError assertionError;
        AssertionError assertionError2;
        GLUhalfEdge gLUhalfEdge = gLUface.anEdge;
        if ($assertionsDisabled || !(gLUhalfEdge.Lnext == gLUhalfEdge || gLUhalfEdge.Lnext.Lnext == gLUhalfEdge)) {
            while (Geom.VertLeq(gLUhalfEdge.Sym.Org, gLUhalfEdge.Org)) {
                gLUhalfEdge = gLUhalfEdge.Onext.Sym;
            }
            while (Geom.VertLeq(gLUhalfEdge.Org, gLUhalfEdge.Sym.Org)) {
                gLUhalfEdge = gLUhalfEdge.Lnext;
            }
            GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge.Onext.Sym;
            while (gLUhalfEdge.Lnext != gLUhalfEdge2) {
                if (Geom.VertLeq(gLUhalfEdge.Sym.Org, gLUhalfEdge2.Org)) {
                    while (gLUhalfEdge2.Lnext != gLUhalfEdge && (Geom.EdgeGoesLeft(gLUhalfEdge2.Lnext) || Geom.EdgeSign(gLUhalfEdge2.Org, gLUhalfEdge2.Sym.Org, gLUhalfEdge2.Lnext.Sym.Org) <= 0.0d)) {
                        GLUhalfEdge __gl_meshConnect = Mesh.__gl_meshConnect(gLUhalfEdge2.Lnext, gLUhalfEdge2);
                        if (__gl_meshConnect == null) {
                            return false;
                        }
                        gLUhalfEdge2 = __gl_meshConnect.Sym;
                    }
                    gLUhalfEdge2 = gLUhalfEdge2.Onext.Sym;
                } else {
                    while (gLUhalfEdge2.Lnext != gLUhalfEdge && (Geom.EdgeGoesRight(gLUhalfEdge.Onext.Sym) || Geom.EdgeSign(gLUhalfEdge.Sym.Org, gLUhalfEdge.Org, gLUhalfEdge.Onext.Sym.Org) >= 0.0d)) {
                        GLUhalfEdge __gl_meshConnect2 = Mesh.__gl_meshConnect(gLUhalfEdge, gLUhalfEdge.Onext.Sym);
                        if (__gl_meshConnect2 == null) {
                            return false;
                        }
                        gLUhalfEdge = __gl_meshConnect2.Sym;
                    }
                    gLUhalfEdge = gLUhalfEdge.Lnext;
                }
            }
            if ($assertionsDisabled || gLUhalfEdge2.Lnext != gLUhalfEdge) {
                while (gLUhalfEdge2.Lnext.Lnext != gLUhalfEdge) {
                    GLUhalfEdge __gl_meshConnect3 = Mesh.__gl_meshConnect(gLUhalfEdge2.Lnext, gLUhalfEdge2);
                    if (__gl_meshConnect3 == null) {
                        return false;
                    }
                    gLUhalfEdge2 = __gl_meshConnect3.Sym;
                }
                return true;
            }
            AssertionError assertionError3 = assertionError;
            AssertionError assertionError4 = new AssertionError();
            throw assertionError3;
        }
        AssertionError assertionError5 = assertionError2;
        AssertionError assertionError6 = new AssertionError();
        throw assertionError5;
    }
}
