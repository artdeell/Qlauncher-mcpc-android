package org.lwjgl.util.glu.tessellation;

class Geom {
    static final /* synthetic */ boolean $assertionsDisabled = (!Geom.class.desiredAssertionStatus());

    private Geom() {
    }

    static double EdgeEval(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3) {
        AssertionError assertionError;
        GLUvertex gLUvertex4 = gLUvertex;
        GLUvertex gLUvertex5 = gLUvertex2;
        GLUvertex gLUvertex6 = gLUvertex3;
        double d = 0.0d;
        if ($assertionsDisabled || (VertLeq(gLUvertex4, gLUvertex5) && VertLeq(gLUvertex5, gLUvertex6))) {
            double d2 = gLUvertex5.f242s - gLUvertex4.f242s;
            double d3 = gLUvertex6.f242s - gLUvertex5.f242s;
            if (d2 + d3 > 0.0d) {
                if (d2 >= d3) {
                    return (gLUvertex5.f243t - gLUvertex6.f243t) + ((gLUvertex6.f243t - gLUvertex4.f243t) * (d3 / (d2 + d3)));
                }
                d = (gLUvertex5.f243t - gLUvertex4.f243t) + ((gLUvertex4.f243t - gLUvertex6.f243t) * (d2 / (d2 + d3)));
            }
            return d;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    static boolean EdgeGoesLeft(GLUhalfEdge gLUhalfEdge) {
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        return VertLeq(gLUhalfEdge2.Sym.Org, gLUhalfEdge2.Org);
    }

    static boolean EdgeGoesRight(GLUhalfEdge gLUhalfEdge) {
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        return VertLeq(gLUhalfEdge2.Org, gLUhalfEdge2.Sym.Org);
    }

    static void EdgeIntersect(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3, GLUvertex gLUvertex4, GLUvertex gLUvertex5) {
        GLUvertex gLUvertex6 = gLUvertex;
        GLUvertex gLUvertex7 = gLUvertex2;
        GLUvertex gLUvertex8 = gLUvertex3;
        GLUvertex gLUvertex9 = gLUvertex4;
        GLUvertex gLUvertex10 = gLUvertex5;
        if (!VertLeq(gLUvertex6, gLUvertex7)) {
            GLUvertex gLUvertex11 = gLUvertex6;
            gLUvertex6 = gLUvertex7;
            gLUvertex7 = gLUvertex11;
        }
        if (!VertLeq(gLUvertex8, gLUvertex9)) {
            GLUvertex gLUvertex12 = gLUvertex8;
            gLUvertex8 = gLUvertex9;
            gLUvertex9 = gLUvertex12;
        }
        if (!VertLeq(gLUvertex6, gLUvertex8)) {
            GLUvertex gLUvertex13 = gLUvertex6;
            gLUvertex6 = gLUvertex8;
            gLUvertex8 = gLUvertex13;
            GLUvertex gLUvertex14 = gLUvertex7;
            gLUvertex7 = gLUvertex9;
            gLUvertex9 = gLUvertex14;
        }
        if (!VertLeq(gLUvertex8, gLUvertex7)) {
            gLUvertex10.f242s = (gLUvertex8.f242s + gLUvertex7.f242s) / 2.0d;
        } else if (VertLeq(gLUvertex7, gLUvertex9)) {
            double EdgeEval = EdgeEval(gLUvertex6, gLUvertex8, gLUvertex7);
            double EdgeEval2 = EdgeEval(gLUvertex8, gLUvertex7, gLUvertex9);
            if (EdgeEval + EdgeEval2 < 0.0d) {
                EdgeEval = -EdgeEval;
                EdgeEval2 = -EdgeEval2;
            }
            gLUvertex10.f242s = Interpolate(EdgeEval, gLUvertex8.f242s, EdgeEval2, gLUvertex7.f242s);
        } else {
            double EdgeSign = EdgeSign(gLUvertex6, gLUvertex8, gLUvertex7);
            double d = -EdgeSign(gLUvertex6, gLUvertex9, gLUvertex7);
            if (EdgeSign + d < 0.0d) {
                EdgeSign = -EdgeSign;
                d = -d;
            }
            gLUvertex10.f242s = Interpolate(EdgeSign, gLUvertex8.f242s, d, gLUvertex9.f242s);
        }
        if (!TransLeq(gLUvertex6, gLUvertex7)) {
            GLUvertex gLUvertex15 = gLUvertex6;
            gLUvertex6 = gLUvertex7;
            gLUvertex7 = gLUvertex15;
        }
        if (!TransLeq(gLUvertex8, gLUvertex9)) {
            GLUvertex gLUvertex16 = gLUvertex8;
            gLUvertex8 = gLUvertex9;
            gLUvertex9 = gLUvertex16;
        }
        if (!TransLeq(gLUvertex6, gLUvertex8)) {
            GLUvertex gLUvertex17 = gLUvertex8;
            gLUvertex8 = gLUvertex6;
            gLUvertex6 = gLUvertex17;
            GLUvertex gLUvertex18 = gLUvertex9;
            gLUvertex9 = gLUvertex7;
            gLUvertex7 = gLUvertex18;
        }
        if (!TransLeq(gLUvertex8, gLUvertex7)) {
            gLUvertex10.f243t = (gLUvertex8.f243t + gLUvertex7.f243t) / 2.0d;
        } else if (TransLeq(gLUvertex7, gLUvertex9)) {
            double TransEval = TransEval(gLUvertex6, gLUvertex8, gLUvertex7);
            double TransEval2 = TransEval(gLUvertex8, gLUvertex7, gLUvertex9);
            if (TransEval + TransEval2 < 0.0d) {
                TransEval = -TransEval;
                TransEval2 = -TransEval2;
            }
            gLUvertex10.f243t = Interpolate(TransEval, gLUvertex8.f243t, TransEval2, gLUvertex7.f243t);
        } else {
            double TransSign = TransSign(gLUvertex6, gLUvertex8, gLUvertex7);
            double d2 = -TransSign(gLUvertex6, gLUvertex9, gLUvertex7);
            if (TransSign + d2 < 0.0d) {
                TransSign = -TransSign;
                d2 = -d2;
            }
            gLUvertex10.f243t = Interpolate(TransSign, gLUvertex8.f243t, d2, gLUvertex9.f243t);
        }
    }

    static double EdgeSign(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3) {
        AssertionError assertionError;
        GLUvertex gLUvertex4 = gLUvertex;
        GLUvertex gLUvertex5 = gLUvertex2;
        GLUvertex gLUvertex6 = gLUvertex3;
        double d = 0.0d;
        if ($assertionsDisabled || (VertLeq(gLUvertex4, gLUvertex5) && VertLeq(gLUvertex5, gLUvertex6))) {
            double d2 = gLUvertex5.f242s - gLUvertex4.f242s;
            double d3 = gLUvertex6.f242s - gLUvertex5.f242s;
            if (d2 + d3 > 0.0d) {
                d = (d2 * (gLUvertex5.f243t - gLUvertex6.f243t)) + (d3 * (gLUvertex5.f243t - gLUvertex4.f243t));
            }
            return d;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    static double Interpolate(double d, double d2, double d3, double d4) {
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        if (d5 < 0.0d) {
            d5 = 0.0d;
        }
        if (d7 < 0.0d) {
            d7 = 0.0d;
        }
        return d5 <= d7 ? d7 == 0.0d ? (d6 + d8) / 2.0d : d6 + ((d8 - d6) * (d5 / (d5 + d7))) : d8 + ((d6 - d8) * (d7 / (d5 + d7)));
    }

    static double TransEval(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3) {
        AssertionError assertionError;
        GLUvertex gLUvertex4 = gLUvertex;
        GLUvertex gLUvertex5 = gLUvertex2;
        GLUvertex gLUvertex6 = gLUvertex3;
        double d = 0.0d;
        if ($assertionsDisabled || (TransLeq(gLUvertex4, gLUvertex5) && TransLeq(gLUvertex5, gLUvertex6))) {
            double d2 = gLUvertex5.f243t - gLUvertex4.f243t;
            double d3 = gLUvertex6.f243t - gLUvertex5.f243t;
            if (d2 + d3 > 0.0d) {
                if (d2 >= d3) {
                    return (gLUvertex5.f242s - gLUvertex6.f242s) + ((gLUvertex6.f242s - gLUvertex4.f242s) * (d3 / (d2 + d3)));
                }
                d = (gLUvertex5.f242s - gLUvertex4.f242s) + ((gLUvertex4.f242s - gLUvertex6.f242s) * (d2 / (d2 + d3)));
            }
            return d;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    static boolean TransLeq(GLUvertex gLUvertex, GLUvertex gLUvertex2) {
        GLUvertex gLUvertex3 = gLUvertex;
        GLUvertex gLUvertex4 = gLUvertex2;
        return gLUvertex3.f243t < gLUvertex4.f243t || (gLUvertex3.f243t == gLUvertex4.f243t && gLUvertex3.f242s <= gLUvertex4.f242s);
    }

    static double TransSign(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3) {
        AssertionError assertionError;
        GLUvertex gLUvertex4 = gLUvertex;
        GLUvertex gLUvertex5 = gLUvertex2;
        GLUvertex gLUvertex6 = gLUvertex3;
        double d = 0.0d;
        if ($assertionsDisabled || (TransLeq(gLUvertex4, gLUvertex5) && TransLeq(gLUvertex5, gLUvertex6))) {
            double d2 = gLUvertex5.f243t - gLUvertex4.f243t;
            double d3 = gLUvertex6.f243t - gLUvertex5.f243t;
            if (d2 + d3 > 0.0d) {
                d = (d2 * (gLUvertex5.f242s - gLUvertex6.f242s)) + (d3 * (gLUvertex5.f242s - gLUvertex4.f242s));
            }
            return d;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    static boolean VertCCW(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3) {
        GLUvertex gLUvertex4 = gLUvertex;
        GLUvertex gLUvertex5 = gLUvertex2;
        GLUvertex gLUvertex6 = gLUvertex3;
        return ((gLUvertex4.f242s * (gLUvertex5.f243t - gLUvertex6.f243t)) + (gLUvertex5.f242s * (gLUvertex6.f243t - gLUvertex4.f243t))) + (gLUvertex6.f242s * (gLUvertex4.f243t - gLUvertex5.f243t)) >= 0.0d;
    }

    static boolean VertEq(GLUvertex gLUvertex, GLUvertex gLUvertex2) {
        GLUvertex gLUvertex3 = gLUvertex;
        GLUvertex gLUvertex4 = gLUvertex2;
        return gLUvertex3.f242s == gLUvertex4.f242s && gLUvertex3.f243t == gLUvertex4.f243t;
    }

    static double VertL1dist(GLUvertex gLUvertex, GLUvertex gLUvertex2) {
        GLUvertex gLUvertex3 = gLUvertex;
        GLUvertex gLUvertex4 = gLUvertex2;
        return Math.abs(gLUvertex3.f242s - gLUvertex4.f242s) + Math.abs(gLUvertex3.f243t - gLUvertex4.f243t);
    }

    static boolean VertLeq(GLUvertex gLUvertex, GLUvertex gLUvertex2) {
        GLUvertex gLUvertex3 = gLUvertex;
        GLUvertex gLUvertex4 = gLUvertex2;
        return gLUvertex3.f242s < gLUvertex4.f242s || (gLUvertex3.f242s == gLUvertex4.f242s && gLUvertex3.f243t <= gLUvertex4.f243t);
    }
}
