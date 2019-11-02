package org.lwjgl.util.glu.tessellation;

class Normal {
    static final /* synthetic */ boolean $assertionsDisabled = (!Normal.class.desiredAssertionStatus());
    static boolean SLANTED_SWEEP;
    static double S_UNIT_X;
    static double S_UNIT_Y;
    private static final boolean TRUE_PROJECT = false;

    static {
        if (SLANTED_SWEEP) {
            S_UNIT_X = 0.5094153956495538d;
            S_UNIT_Y = 0.8605207462201063d;
            return;
        }
        S_UNIT_X = 1.0d;
        S_UNIT_Y = 0.0d;
    }

    private Normal() {
    }

    static void CheckOrientation(GLUtessellatorImpl gLUtessellatorImpl) {
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        GLUface gLUface = gLUtessellatorImpl2.mesh.fHead;
        GLUvertex gLUvertex = gLUtessellatorImpl2.mesh.vHead;
        double d = 0.0d;
        GLUface gLUface2 = gLUface.next;
        while (true) {
            GLUface gLUface3 = gLUface2;
            if (gLUface3 == gLUface) {
                break;
            }
            GLUhalfEdge gLUhalfEdge = gLUface3.anEdge;
            if (gLUhalfEdge.winding > 0) {
                do {
                    d += (gLUhalfEdge.Org.f242s - gLUhalfEdge.Sym.Org.f242s) * (gLUhalfEdge.Org.f243t + gLUhalfEdge.Sym.Org.f243t);
                    gLUhalfEdge = gLUhalfEdge.Lnext;
                } while (gLUhalfEdge != gLUface3.anEdge);
            }
            gLUface2 = gLUface3.next;
        }
        if (d < 0.0d) {
            GLUvertex gLUvertex2 = gLUvertex.next;
            while (true) {
                GLUvertex gLUvertex3 = gLUvertex2;
                if (gLUvertex3 != gLUvertex) {
                    gLUvertex3.f243t = -gLUvertex3.f243t;
                    gLUvertex2 = gLUvertex3.next;
                } else {
                    gLUtessellatorImpl2.tUnit[0] = -gLUtessellatorImpl2.tUnit[0];
                    gLUtessellatorImpl2.tUnit[1] = -gLUtessellatorImpl2.tUnit[1];
                    gLUtessellatorImpl2.tUnit[2] = -gLUtessellatorImpl2.tUnit[2];
                    return;
                }
            }
        }
    }

    static void ComputeNormal(GLUtessellatorImpl gLUtessellatorImpl, double[] dArr) {
        double[] dArr2 = dArr;
        GLUvertex gLUvertex = gLUtessellatorImpl.mesh.vHead;
        double[] dArr3 = new double[3];
        double[] dArr4 = new double[3];
        GLUvertex[] gLUvertexArr = new GLUvertex[3];
        GLUvertex[] gLUvertexArr2 = new GLUvertex[3];
        double[] dArr5 = new double[3];
        double[] dArr6 = new double[3];
        double[] dArr7 = new double[3];
        dArr3[2] = -2.0E150d;
        dArr3[1] = -2.0E150d;
        dArr3[0] = -2.0E150d;
        dArr4[2] = 2.0E150d;
        dArr4[1] = 2.0E150d;
        dArr4[0] = 2.0E150d;
        GLUvertex gLUvertex2 = gLUvertex.next;
        while (true) {
            GLUvertex gLUvertex3 = gLUvertex2;
            if (gLUvertex3 == gLUvertex) {
                break;
            }
            for (int i = 0; i < 3; i++) {
                double d = gLUvertex3.coords[i];
                if (d < dArr4[i]) {
                    dArr4[i] = d;
                    gLUvertexArr[i] = gLUvertex3;
                }
                if (d > dArr3[i]) {
                    dArr3[i] = d;
                    gLUvertexArr2[i] = gLUvertex3;
                }
            }
            gLUvertex2 = gLUvertex3.next;
        }
        char c = 0;
        if (dArr3[1] - dArr4[1] > dArr3[0] - dArr4[0]) {
            c = 1;
        }
        if (dArr3[2] - dArr4[2] > dArr3[c] - dArr4[c]) {
            c = 2;
        }
        if (dArr4[c] >= dArr3[c]) {
            dArr2[0] = 0.0d;
            dArr2[1] = 0.0d;
            dArr2[2] = 1.0d;
            return;
        }
        double d2 = 0.0d;
        GLUvertex gLUvertex4 = gLUvertexArr[c];
        GLUvertex gLUvertex5 = gLUvertexArr2[c];
        dArr5[0] = gLUvertex4.coords[0] - gLUvertex5.coords[0];
        dArr5[1] = gLUvertex4.coords[1] - gLUvertex5.coords[1];
        dArr5[2] = gLUvertex4.coords[2] - gLUvertex5.coords[2];
        GLUvertex gLUvertex6 = gLUvertex.next;
        while (true) {
            GLUvertex gLUvertex7 = gLUvertex6;
            if (gLUvertex7 == gLUvertex) {
                break;
            }
            dArr6[0] = gLUvertex7.coords[0] - gLUvertex5.coords[0];
            dArr6[1] = gLUvertex7.coords[1] - gLUvertex5.coords[1];
            dArr6[2] = gLUvertex7.coords[2] - gLUvertex5.coords[2];
            dArr7[0] = (dArr5[1] * dArr6[2]) - (dArr5[2] * dArr6[1]);
            dArr7[1] = (dArr5[2] * dArr6[0]) - (dArr5[0] * dArr6[2]);
            dArr7[2] = (dArr5[0] * dArr6[1]) - (dArr5[1] * dArr6[0]);
            double d3 = (dArr7[0] * dArr7[0]) + (dArr7[1] * dArr7[1]) + (dArr7[2] * dArr7[2]);
            if (d3 > d2) {
                d2 = d3;
                dArr2[0] = dArr7[0];
                dArr2[1] = dArr7[1];
                dArr2[2] = dArr7[2];
            }
            gLUvertex6 = gLUvertex7.next;
        }
        if (d2 <= 0.0d) {
            dArr2[2] = 0.0d;
            dArr2[1] = 0.0d;
            dArr2[0] = 0.0d;
            dArr2[LongAxis(dArr5)] = 1.0d;
        }
    }

    private static double Dot(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        return (dArr3[0] * dArr4[0]) + (dArr3[1] * dArr4[1]) + (dArr3[2] * dArr4[2]);
    }

    static int LongAxis(double[] dArr) {
        double[] dArr2 = dArr;
        int i = 0;
        if (Math.abs(dArr2[1]) > Math.abs(dArr2[0])) {
            i = 1;
        }
        if (Math.abs(dArr2[2]) > Math.abs(dArr2[i])) {
            i = 2;
        }
        return i;
    }

    static void Normalize(double[] dArr) {
        AssertionError assertionError;
        double[] dArr2 = dArr;
        double d = (dArr2[0] * dArr2[0]) + (dArr2[1] * dArr2[1]) + (dArr2[2] * dArr2[2]);
        if ($assertionsDisabled || d > 0.0d) {
            double sqrt = Math.sqrt(d);
            dArr2[0] = dArr2[0] / sqrt;
            dArr2[1] = dArr2[1] / sqrt;
            dArr2[2] = dArr2[2] / sqrt;
            return;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    public static void __gl_projectPolygon(GLUtessellatorImpl gLUtessellatorImpl) {
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        GLUvertex gLUvertex = gLUtessellatorImpl2.mesh.vHead;
        double[] dArr = {gLUtessellatorImpl2.normal[0], gLUtessellatorImpl2.normal[1], gLUtessellatorImpl2.normal[2]};
        boolean z = false;
        if (dArr[0] == 0.0d) {
            z = false;
            if (dArr[1] == 0.0d) {
                z = false;
                if (dArr[2] == 0.0d) {
                    ComputeNormal(gLUtessellatorImpl2, dArr);
                    z = true;
                }
            }
        }
        double[] dArr2 = gLUtessellatorImpl2.sUnit;
        double[] dArr3 = gLUtessellatorImpl2.tUnit;
        int LongAxis = LongAxis(dArr);
        dArr2[LongAxis] = 0.0d;
        dArr2[(LongAxis + 1) % 3] = S_UNIT_X;
        dArr2[(LongAxis + 2) % 3] = S_UNIT_Y;
        dArr3[LongAxis] = 0.0d;
        dArr3[(LongAxis + 1) % 3] = dArr[LongAxis] > 0.0d ? -S_UNIT_Y : S_UNIT_Y;
        dArr3[(LongAxis + 2) % 3] = dArr[LongAxis] > 0.0d ? S_UNIT_X : -S_UNIT_X;
        GLUvertex gLUvertex2 = gLUvertex.next;
        while (true) {
            GLUvertex gLUvertex3 = gLUvertex2;
            if (gLUvertex3 == gLUvertex) {
                break;
            }
            gLUvertex3.f242s = Dot(gLUvertex3.coords, dArr2);
            gLUvertex3.f243t = Dot(gLUvertex3.coords, dArr3);
            gLUvertex2 = gLUvertex3.next;
        }
        if (z) {
            CheckOrientation(gLUtessellatorImpl2);
        }
    }
}
