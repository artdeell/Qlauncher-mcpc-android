package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.tessellation.Dict.DictLeq;
import org.lwjgl.util.glu.tessellation.PriorityQ.Leq;

class Sweep {
    static final /* synthetic */ boolean $assertionsDisabled = (!Sweep.class.desiredAssertionStatus());
    private static final double SENTINEL_COORD = 4.0E150d;
    private static final boolean TOLERANCE_NONZERO = false;

    private Sweep() {
    }

    static ActiveRegion AddRegionBelow(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion, GLUhalfEdge gLUhalfEdge) {
        ActiveRegion activeRegion2;
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        ActiveRegion activeRegion3 = activeRegion;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        ActiveRegion activeRegion4 = activeRegion2;
        ActiveRegion activeRegion5 = new ActiveRegion();
        ActiveRegion activeRegion6 = activeRegion4;
        if (activeRegion6 == null) {
            RuntimeException runtimeException3 = runtimeException2;
            RuntimeException runtimeException4 = new RuntimeException();
            throw runtimeException3;
        }
        activeRegion6.eUp = gLUhalfEdge2;
        activeRegion6.nodeUp = Dict.dictInsertBefore(gLUtessellatorImpl2.dict, activeRegion3.nodeUp, activeRegion6);
        if (activeRegion6.nodeUp == null) {
            RuntimeException runtimeException5 = runtimeException;
            RuntimeException runtimeException6 = new RuntimeException();
            throw runtimeException5;
        }
        activeRegion6.fixUpperEdge = false;
        activeRegion6.sentinel = false;
        activeRegion6.dirty = false;
        gLUhalfEdge2.activeRegion = activeRegion6;
        return activeRegion6;
    }

    static void AddRightEdges(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion, GLUhalfEdge gLUhalfEdge, GLUhalfEdge gLUhalfEdge2, GLUhalfEdge gLUhalfEdge3, boolean z) {
        AssertionError assertionError;
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RuntimeException runtimeException3;
        AssertionError assertionError2;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        ActiveRegion activeRegion2 = activeRegion;
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge2;
        GLUhalfEdge gLUhalfEdge5 = gLUhalfEdge3;
        boolean z2 = z;
        boolean z3 = true;
        GLUhalfEdge gLUhalfEdge6 = gLUhalfEdge;
        do {
            if ($assertionsDisabled || Geom.VertLeq(gLUhalfEdge6.Org, gLUhalfEdge6.Sym.Org)) {
                ActiveRegion AddRegionBelow = AddRegionBelow(gLUtessellatorImpl2, activeRegion2, gLUhalfEdge6.Sym);
                gLUhalfEdge6 = gLUhalfEdge6.Onext;
            } else {
                AssertionError assertionError3 = assertionError2;
                AssertionError assertionError4 = new AssertionError();
                throw assertionError3;
            }
        } while (gLUhalfEdge6 != gLUhalfEdge4);
        if (gLUhalfEdge5 == null) {
            gLUhalfEdge5 = RegionBelow(activeRegion2).eUp.Sym.Onext;
        }
        ActiveRegion activeRegion3 = activeRegion2;
        GLUhalfEdge gLUhalfEdge7 = gLUhalfEdge5;
        while (true) {
            ActiveRegion RegionBelow = RegionBelow(activeRegion3);
            GLUhalfEdge gLUhalfEdge8 = RegionBelow.eUp.Sym;
            if (gLUhalfEdge8.Org != gLUhalfEdge7.Org) {
                activeRegion3.dirty = true;
                if (!$assertionsDisabled && activeRegion3.windingNumber - gLUhalfEdge8.winding != RegionBelow.windingNumber) {
                    AssertionError assertionError5 = assertionError;
                    AssertionError assertionError6 = new AssertionError();
                    throw assertionError5;
                } else if (z2) {
                    WalkDirtyRegions(gLUtessellatorImpl2, activeRegion3);
                    return;
                } else {
                    return;
                }
            } else {
                if (gLUhalfEdge8.Onext != gLUhalfEdge7) {
                    if (!Mesh.__gl_meshSplice(gLUhalfEdge8.Sym.Lnext, gLUhalfEdge8)) {
                        RuntimeException runtimeException4 = runtimeException2;
                        RuntimeException runtimeException5 = new RuntimeException();
                        throw runtimeException4;
                    } else if (!Mesh.__gl_meshSplice(gLUhalfEdge7.Sym.Lnext, gLUhalfEdge8)) {
                        RuntimeException runtimeException6 = runtimeException3;
                        RuntimeException runtimeException7 = new RuntimeException();
                        throw runtimeException6;
                    }
                }
                RegionBelow.windingNumber = activeRegion3.windingNumber - gLUhalfEdge8.winding;
                RegionBelow.inside = IsWindingInside(gLUtessellatorImpl2, RegionBelow.windingNumber);
                activeRegion3.dirty = true;
                if (!z3 && CheckForRightSplice(gLUtessellatorImpl2, activeRegion3)) {
                    AddWinding(gLUhalfEdge8, gLUhalfEdge7);
                    DeleteRegion(gLUtessellatorImpl2, activeRegion3);
                    if (!Mesh.__gl_meshDelete(gLUhalfEdge7)) {
                        RuntimeException runtimeException8 = runtimeException;
                        RuntimeException runtimeException9 = new RuntimeException();
                        throw runtimeException8;
                    }
                }
                activeRegion3 = RegionBelow;
                gLUhalfEdge7 = gLUhalfEdge8;
                z3 = false;
            }
        }
    }

    static void AddSentinel(GLUtessellatorImpl gLUtessellatorImpl, double d) {
        ActiveRegion activeRegion;
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RuntimeException runtimeException3;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        double d2 = d;
        ActiveRegion activeRegion2 = activeRegion;
        ActiveRegion activeRegion3 = new ActiveRegion();
        ActiveRegion activeRegion4 = activeRegion2;
        if (activeRegion4 == null) {
            RuntimeException runtimeException4 = runtimeException3;
            RuntimeException runtimeException5 = new RuntimeException();
            throw runtimeException4;
        }
        GLUhalfEdge __gl_meshMakeEdge = Mesh.__gl_meshMakeEdge(gLUtessellatorImpl2.mesh);
        if (__gl_meshMakeEdge == null) {
            RuntimeException runtimeException6 = runtimeException2;
            RuntimeException runtimeException7 = new RuntimeException();
            throw runtimeException6;
        }
        __gl_meshMakeEdge.Org.f242s = SENTINEL_COORD;
        __gl_meshMakeEdge.Org.f243t = d2;
        __gl_meshMakeEdge.Sym.Org.f242s = -4.0E150d;
        __gl_meshMakeEdge.Sym.Org.f243t = d2;
        gLUtessellatorImpl2.event = __gl_meshMakeEdge.Sym.Org;
        activeRegion4.eUp = __gl_meshMakeEdge;
        activeRegion4.windingNumber = 0;
        activeRegion4.inside = false;
        activeRegion4.fixUpperEdge = false;
        activeRegion4.sentinel = true;
        activeRegion4.dirty = false;
        activeRegion4.nodeUp = Dict.dictInsert(gLUtessellatorImpl2.dict, activeRegion4);
        if (activeRegion4.nodeUp == null) {
            RuntimeException runtimeException8 = runtimeException;
            RuntimeException runtimeException9 = new RuntimeException();
            throw runtimeException8;
        }
    }

    private static void AddWinding(GLUhalfEdge gLUhalfEdge, GLUhalfEdge gLUhalfEdge2) {
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge2;
        gLUhalfEdge3.winding += gLUhalfEdge4.winding;
        gLUhalfEdge3.Sym.winding += gLUhalfEdge4.Sym.winding;
    }

    static void CallCombine(GLUtessellatorImpl gLUtessellatorImpl, GLUvertex gLUvertex, Object[] objArr, float[] fArr, boolean z) {
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        GLUvertex gLUvertex2 = gLUvertex;
        Object[] objArr2 = objArr;
        boolean z2 = z;
        double[] dArr = {gLUvertex2.coords[0], gLUvertex2.coords[1], gLUvertex2.coords[2]};
        Object[] objArr3 = new Object[1];
        gLUtessellatorImpl2.callCombineOrCombineData(dArr, objArr2, fArr, objArr3);
        gLUvertex2.data = objArr3[0];
        if (gLUvertex2.data != null) {
            return;
        }
        if (!z2) {
            gLUvertex2.data = objArr2[0];
        } else if (!gLUtessellatorImpl2.fatalError) {
            gLUtessellatorImpl2.callErrorOrErrorData(100156);
            gLUtessellatorImpl2.fatalError = true;
        }
    }

    static boolean CheckForIntersect(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        GLUvertex gLUvertex;
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RuntimeException runtimeException3;
        RuntimeException runtimeException4;
        RuntimeException runtimeException5;
        RuntimeException runtimeException6;
        RuntimeException runtimeException7;
        RuntimeException runtimeException8;
        RuntimeException runtimeException9;
        RuntimeException runtimeException10;
        RuntimeException runtimeException11;
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        AssertionError assertionError4;
        AssertionError assertionError5;
        AssertionError assertionError6;
        AssertionError assertionError7;
        AssertionError assertionError8;
        AssertionError assertionError9;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        ActiveRegion activeRegion2 = activeRegion;
        ActiveRegion RegionBelow = RegionBelow(activeRegion2);
        GLUhalfEdge gLUhalfEdge = activeRegion2.eUp;
        GLUhalfEdge gLUhalfEdge2 = RegionBelow.eUp;
        GLUvertex gLUvertex2 = gLUhalfEdge.Org;
        GLUvertex gLUvertex3 = gLUhalfEdge2.Org;
        GLUvertex gLUvertex4 = gLUhalfEdge.Sym.Org;
        GLUvertex gLUvertex5 = gLUhalfEdge2.Sym.Org;
        GLUvertex gLUvertex6 = gLUvertex;
        GLUvertex gLUvertex7 = new GLUvertex();
        GLUvertex gLUvertex8 = gLUvertex6;
        if (!$assertionsDisabled && Geom.VertEq(gLUvertex5, gLUvertex4)) {
            AssertionError assertionError10 = assertionError9;
            AssertionError assertionError11 = new AssertionError();
            throw assertionError10;
        } else if (!$assertionsDisabled && Geom.EdgeSign(gLUvertex4, gLUtessellatorImpl2.event, gLUvertex2) > 0.0d) {
            AssertionError assertionError12 = assertionError8;
            AssertionError assertionError13 = new AssertionError();
            throw assertionError12;
        } else if (!$assertionsDisabled && Geom.EdgeSign(gLUvertex5, gLUtessellatorImpl2.event, gLUvertex3) < 0.0d) {
            AssertionError assertionError14 = assertionError7;
            AssertionError assertionError15 = new AssertionError();
            throw assertionError14;
        } else if (!$assertionsDisabled && (gLUvertex2 == gLUtessellatorImpl2.event || gLUvertex3 == gLUtessellatorImpl2.event)) {
            AssertionError assertionError16 = assertionError6;
            AssertionError assertionError17 = new AssertionError();
            throw assertionError16;
        } else if (!$assertionsDisabled && (activeRegion2.fixUpperEdge || RegionBelow.fixUpperEdge)) {
            AssertionError assertionError18 = assertionError5;
            AssertionError assertionError19 = new AssertionError();
            throw assertionError18;
        } else if (gLUvertex2 == gLUvertex3) {
            return false;
        } else {
            if (Math.min(gLUvertex2.f243t, gLUvertex4.f243t) > Math.max(gLUvertex3.f243t, gLUvertex5.f243t)) {
                return false;
            }
            if (Geom.VertLeq(gLUvertex2, gLUvertex3)) {
                if (Geom.EdgeSign(gLUvertex5, gLUvertex2, gLUvertex3) > 0.0d) {
                    return false;
                }
            } else if (Geom.EdgeSign(gLUvertex4, gLUvertex3, gLUvertex2) < 0.0d) {
                return false;
            }
            DebugEvent(gLUtessellatorImpl2);
            Geom.EdgeIntersect(gLUvertex4, gLUvertex2, gLUvertex5, gLUvertex3, gLUvertex8);
            if (!$assertionsDisabled && Math.min(gLUvertex2.f243t, gLUvertex4.f243t) > gLUvertex8.f243t) {
                AssertionError assertionError20 = assertionError4;
                AssertionError assertionError21 = new AssertionError();
                throw assertionError20;
            } else if (!$assertionsDisabled && gLUvertex8.f243t > Math.max(gLUvertex3.f243t, gLUvertex5.f243t)) {
                AssertionError assertionError22 = assertionError3;
                AssertionError assertionError23 = new AssertionError();
                throw assertionError22;
            } else if (!$assertionsDisabled && Math.min(gLUvertex5.f242s, gLUvertex4.f242s) > gLUvertex8.f242s) {
                AssertionError assertionError24 = assertionError2;
                AssertionError assertionError25 = new AssertionError();
                throw assertionError24;
            } else if ($assertionsDisabled || gLUvertex8.f242s <= Math.max(gLUvertex3.f242s, gLUvertex2.f242s)) {
                if (Geom.VertLeq(gLUvertex8, gLUtessellatorImpl2.event)) {
                    gLUvertex8.f242s = gLUtessellatorImpl2.event.f242s;
                    gLUvertex8.f243t = gLUtessellatorImpl2.event.f243t;
                }
                GLUvertex gLUvertex9 = Geom.VertLeq(gLUvertex2, gLUvertex3) ? gLUvertex2 : gLUvertex3;
                if (Geom.VertLeq(gLUvertex9, gLUvertex8)) {
                    gLUvertex8.f242s = gLUvertex9.f242s;
                    gLUvertex8.f243t = gLUvertex9.f243t;
                }
                if (Geom.VertEq(gLUvertex8, gLUvertex2) || Geom.VertEq(gLUvertex8, gLUvertex3)) {
                    boolean CheckForRightSplice = CheckForRightSplice(gLUtessellatorImpl2, activeRegion2);
                    return false;
                } else if ((!Geom.VertEq(gLUvertex4, gLUtessellatorImpl2.event) && Geom.EdgeSign(gLUvertex4, gLUtessellatorImpl2.event, gLUvertex8) >= 0.0d) || (!Geom.VertEq(gLUvertex5, gLUtessellatorImpl2.event) && Geom.EdgeSign(gLUvertex5, gLUtessellatorImpl2.event, gLUvertex8) <= 0.0d)) {
                    if (gLUvertex5 != gLUtessellatorImpl2.event) {
                        if (gLUvertex4 != gLUtessellatorImpl2.event) {
                            if (Geom.EdgeSign(gLUvertex4, gLUtessellatorImpl2.event, gLUvertex8) >= 0.0d) {
                                ActiveRegion RegionAbove = RegionAbove(activeRegion2);
                                activeRegion2.dirty = true;
                                RegionAbove.dirty = true;
                                if (Mesh.__gl_meshSplitEdge(gLUhalfEdge.Sym) == null) {
                                    RuntimeException runtimeException12 = runtimeException2;
                                    RuntimeException runtimeException13 = new RuntimeException();
                                    throw runtimeException12;
                                }
                                gLUhalfEdge.Org.f242s = gLUtessellatorImpl2.event.f242s;
                                gLUhalfEdge.Org.f243t = gLUtessellatorImpl2.event.f243t;
                            }
                            if (Geom.EdgeSign(gLUvertex5, gLUtessellatorImpl2.event, gLUvertex8) <= 0.0d) {
                                RegionBelow.dirty = true;
                                activeRegion2.dirty = true;
                                if (Mesh.__gl_meshSplitEdge(gLUhalfEdge2.Sym) == null) {
                                    RuntimeException runtimeException14 = runtimeException;
                                    RuntimeException runtimeException15 = new RuntimeException();
                                    throw runtimeException14;
                                }
                                gLUhalfEdge2.Org.f242s = gLUtessellatorImpl2.event.f242s;
                                gLUhalfEdge2.Org.f243t = gLUtessellatorImpl2.event.f243t;
                            }
                            return false;
                        } else if (Mesh.__gl_meshSplitEdge(gLUhalfEdge2.Sym) == null) {
                            RuntimeException runtimeException16 = runtimeException4;
                            RuntimeException runtimeException17 = new RuntimeException();
                            throw runtimeException16;
                        } else if (!Mesh.__gl_meshSplice(gLUhalfEdge.Lnext, gLUhalfEdge2.Sym.Lnext)) {
                            RuntimeException runtimeException18 = runtimeException3;
                            RuntimeException runtimeException19 = new RuntimeException();
                            throw runtimeException18;
                        } else {
                            ActiveRegion TopRightRegion = TopRightRegion(activeRegion2);
                            GLUhalfEdge gLUhalfEdge3 = RegionBelow(TopRightRegion).eUp.Sym.Onext;
                            activeRegion2.eUp = gLUhalfEdge2.Sym.Lnext;
                            AddRightEdges(gLUtessellatorImpl2, TopRightRegion, FinishLeftRegions(gLUtessellatorImpl2, activeRegion2, null).Onext, gLUhalfEdge.Sym.Onext, gLUhalfEdge3, true);
                            return true;
                        }
                    } else if (Mesh.__gl_meshSplitEdge(gLUhalfEdge.Sym) == null) {
                        RuntimeException runtimeException20 = runtimeException7;
                        RuntimeException runtimeException21 = new RuntimeException();
                        throw runtimeException20;
                    } else if (!Mesh.__gl_meshSplice(gLUhalfEdge2.Sym, gLUhalfEdge)) {
                        RuntimeException runtimeException22 = runtimeException6;
                        RuntimeException runtimeException23 = new RuntimeException();
                        throw runtimeException22;
                    } else {
                        ActiveRegion TopLeftRegion = TopLeftRegion(activeRegion2);
                        if (TopLeftRegion == null) {
                            RuntimeException runtimeException24 = runtimeException5;
                            RuntimeException runtimeException25 = new RuntimeException();
                            throw runtimeException24;
                        }
                        GLUhalfEdge gLUhalfEdge4 = RegionBelow(TopLeftRegion).eUp;
                        GLUhalfEdge FinishLeftRegions = FinishLeftRegions(gLUtessellatorImpl2, RegionBelow(TopLeftRegion), RegionBelow);
                        AddRightEdges(gLUtessellatorImpl2, TopLeftRegion, gLUhalfEdge4.Sym.Lnext, gLUhalfEdge4, gLUhalfEdge4, true);
                        return true;
                    }
                } else if (Mesh.__gl_meshSplitEdge(gLUhalfEdge.Sym) == null) {
                    RuntimeException runtimeException26 = runtimeException11;
                    RuntimeException runtimeException27 = new RuntimeException();
                    throw runtimeException26;
                } else if (Mesh.__gl_meshSplitEdge(gLUhalfEdge2.Sym) == null) {
                    RuntimeException runtimeException28 = runtimeException10;
                    RuntimeException runtimeException29 = new RuntimeException();
                    throw runtimeException28;
                } else if (!Mesh.__gl_meshSplice(gLUhalfEdge2.Sym.Lnext, gLUhalfEdge)) {
                    RuntimeException runtimeException30 = runtimeException9;
                    RuntimeException runtimeException31 = new RuntimeException();
                    throw runtimeException30;
                } else {
                    gLUhalfEdge.Org.f242s = gLUvertex8.f242s;
                    gLUhalfEdge.Org.f243t = gLUvertex8.f243t;
                    gLUhalfEdge.Org.pqHandle = gLUtessellatorImpl2.f241pq.pqInsert(gLUhalfEdge.Org);
                    if (((long) gLUhalfEdge.Org.pqHandle) == Long.MAX_VALUE) {
                        gLUtessellatorImpl2.f241pq.pqDeletePriorityQ();
                        gLUtessellatorImpl2.f241pq = null;
                        RuntimeException runtimeException32 = runtimeException8;
                        RuntimeException runtimeException33 = new RuntimeException();
                        throw runtimeException32;
                    }
                    GetIntersectData(gLUtessellatorImpl2, gLUhalfEdge.Org, gLUvertex2, gLUvertex4, gLUvertex3, gLUvertex5);
                    ActiveRegion RegionAbove2 = RegionAbove(activeRegion2);
                    RegionBelow.dirty = true;
                    activeRegion2.dirty = true;
                    RegionAbove2.dirty = true;
                    return false;
                }
            } else {
                AssertionError assertionError26 = assertionError;
                AssertionError assertionError27 = new AssertionError();
                throw assertionError26;
            }
        }
    }

    static boolean CheckForLeftSplice(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RuntimeException runtimeException3;
        RuntimeException runtimeException4;
        AssertionError assertionError;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        ActiveRegion activeRegion2 = activeRegion;
        ActiveRegion RegionBelow = RegionBelow(activeRegion2);
        GLUhalfEdge gLUhalfEdge = activeRegion2.eUp;
        GLUhalfEdge gLUhalfEdge2 = RegionBelow.eUp;
        if ($assertionsDisabled || !Geom.VertEq(gLUhalfEdge.Sym.Org, gLUhalfEdge2.Sym.Org)) {
            if (Geom.VertLeq(gLUhalfEdge.Sym.Org, gLUhalfEdge2.Sym.Org)) {
                if (Geom.EdgeSign(gLUhalfEdge.Sym.Org, gLUhalfEdge2.Sym.Org, gLUhalfEdge.Org) >= 0.0d) {
                    ActiveRegion RegionAbove = RegionAbove(activeRegion2);
                    activeRegion2.dirty = true;
                    RegionAbove.dirty = true;
                    GLUhalfEdge __gl_meshSplitEdge = Mesh.__gl_meshSplitEdge(gLUhalfEdge);
                    if (__gl_meshSplitEdge == null) {
                        RuntimeException runtimeException5 = runtimeException4;
                        RuntimeException runtimeException6 = new RuntimeException();
                        throw runtimeException5;
                    } else if (!Mesh.__gl_meshSplice(gLUhalfEdge2.Sym, __gl_meshSplitEdge)) {
                        RuntimeException runtimeException7 = runtimeException3;
                        RuntimeException runtimeException8 = new RuntimeException();
                        throw runtimeException7;
                    } else {
                        __gl_meshSplitEdge.Lface.inside = activeRegion2.inside;
                        return true;
                    }
                }
            } else if (Geom.EdgeSign(gLUhalfEdge2.Sym.Org, gLUhalfEdge.Sym.Org, gLUhalfEdge2.Org) <= 0.0d) {
                RegionBelow.dirty = true;
                activeRegion2.dirty = true;
                GLUhalfEdge __gl_meshSplitEdge2 = Mesh.__gl_meshSplitEdge(gLUhalfEdge2);
                if (__gl_meshSplitEdge2 == null) {
                    RuntimeException runtimeException9 = runtimeException2;
                    RuntimeException runtimeException10 = new RuntimeException();
                    throw runtimeException9;
                } else if (!Mesh.__gl_meshSplice(gLUhalfEdge.Lnext, gLUhalfEdge2.Sym)) {
                    RuntimeException runtimeException11 = runtimeException;
                    RuntimeException runtimeException12 = new RuntimeException();
                    throw runtimeException11;
                } else {
                    __gl_meshSplitEdge2.Sym.Lface.inside = activeRegion2.inside;
                    return true;
                }
            }
            return false;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    static boolean CheckForRightSplice(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RuntimeException runtimeException3;
        RuntimeException runtimeException4;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        ActiveRegion activeRegion2 = activeRegion;
        ActiveRegion RegionBelow = RegionBelow(activeRegion2);
        GLUhalfEdge gLUhalfEdge = activeRegion2.eUp;
        GLUhalfEdge gLUhalfEdge2 = RegionBelow.eUp;
        if (Geom.VertLeq(gLUhalfEdge.Org, gLUhalfEdge2.Org)) {
            if (Geom.EdgeSign(gLUhalfEdge2.Sym.Org, gLUhalfEdge.Org, gLUhalfEdge2.Org) <= 0.0d) {
                if (!Geom.VertEq(gLUhalfEdge.Org, gLUhalfEdge2.Org)) {
                    if (Mesh.__gl_meshSplitEdge(gLUhalfEdge2.Sym) == null) {
                        RuntimeException runtimeException5 = runtimeException4;
                        RuntimeException runtimeException6 = new RuntimeException();
                        throw runtimeException5;
                    } else if (!Mesh.__gl_meshSplice(gLUhalfEdge, gLUhalfEdge2.Sym.Lnext)) {
                        RuntimeException runtimeException7 = runtimeException3;
                        RuntimeException runtimeException8 = new RuntimeException();
                        throw runtimeException7;
                    } else {
                        RegionBelow.dirty = true;
                        activeRegion2.dirty = true;
                    }
                } else if (gLUhalfEdge.Org != gLUhalfEdge2.Org) {
                    gLUtessellatorImpl2.f241pq.pqDelete(gLUhalfEdge.Org.pqHandle);
                    SpliceMergeVertices(gLUtessellatorImpl2, gLUhalfEdge2.Sym.Lnext, gLUhalfEdge);
                }
                return true;
            }
        } else if (Geom.EdgeSign(gLUhalfEdge.Sym.Org, gLUhalfEdge2.Org, gLUhalfEdge.Org) >= 0.0d) {
            ActiveRegion RegionAbove = RegionAbove(activeRegion2);
            activeRegion2.dirty = true;
            RegionAbove.dirty = true;
            if (Mesh.__gl_meshSplitEdge(gLUhalfEdge.Sym) == null) {
                RuntimeException runtimeException9 = runtimeException2;
                RuntimeException runtimeException10 = new RuntimeException();
                throw runtimeException9;
            }
            if (!Mesh.__gl_meshSplice(gLUhalfEdge2.Sym.Lnext, gLUhalfEdge)) {
                RuntimeException runtimeException11 = runtimeException;
                RuntimeException runtimeException12 = new RuntimeException();
                throw runtimeException11;
            }
            return true;
        }
        return false;
    }

    static void ComputeWinding(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        ActiveRegion activeRegion2 = activeRegion;
        activeRegion2.windingNumber = RegionAbove(activeRegion2).windingNumber + activeRegion2.eUp.winding;
        activeRegion2.inside = IsWindingInside(gLUtessellatorImpl2, activeRegion2.windingNumber);
    }

    static void ConnectLeftDegenerate(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion, GLUvertex gLUvertex) {
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        AssertionError assertionError;
        AssertionError assertionError2;
        RuntimeException runtimeException3;
        RuntimeException runtimeException4;
        RuntimeException runtimeException5;
        AssertionError assertionError3;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        ActiveRegion activeRegion2 = activeRegion;
        GLUvertex gLUvertex2 = gLUvertex;
        GLUhalfEdge gLUhalfEdge = activeRegion2.eUp;
        if (Geom.VertEq(gLUhalfEdge.Org, gLUvertex2)) {
            if (!$assertionsDisabled) {
                AssertionError assertionError4 = assertionError3;
                AssertionError assertionError5 = new AssertionError();
                throw assertionError4;
            }
            SpliceMergeVertices(gLUtessellatorImpl2, gLUhalfEdge, gLUvertex2.anEdge);
        } else if (!Geom.VertEq(gLUhalfEdge.Sym.Org, gLUvertex2)) {
            if (Mesh.__gl_meshSplitEdge(gLUhalfEdge.Sym) == null) {
                RuntimeException runtimeException6 = runtimeException5;
                RuntimeException runtimeException7 = new RuntimeException();
                throw runtimeException6;
            }
            if (activeRegion2.fixUpperEdge) {
                if (!Mesh.__gl_meshDelete(gLUhalfEdge.Onext)) {
                    RuntimeException runtimeException8 = runtimeException4;
                    RuntimeException runtimeException9 = new RuntimeException();
                    throw runtimeException8;
                }
                activeRegion2.fixUpperEdge = false;
            }
            if (!Mesh.__gl_meshSplice(gLUvertex2.anEdge, gLUhalfEdge)) {
                RuntimeException runtimeException10 = runtimeException3;
                RuntimeException runtimeException11 = new RuntimeException();
                throw runtimeException10;
            }
            SweepEvent(gLUtessellatorImpl2, gLUvertex2);
        } else if (!$assertionsDisabled) {
            AssertionError assertionError6 = assertionError2;
            AssertionError assertionError7 = new AssertionError();
            throw assertionError6;
        } else {
            ActiveRegion TopRightRegion = TopRightRegion(activeRegion2);
            ActiveRegion RegionBelow = RegionBelow(TopRightRegion);
            GLUhalfEdge gLUhalfEdge2 = RegionBelow.eUp.Sym;
            GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2.Onext;
            GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge3;
            if (RegionBelow.fixUpperEdge) {
                if ($assertionsDisabled || gLUhalfEdge4 != gLUhalfEdge2) {
                    DeleteRegion(gLUtessellatorImpl2, RegionBelow);
                    if (!Mesh.__gl_meshDelete(gLUhalfEdge2)) {
                        RuntimeException runtimeException12 = runtimeException2;
                        RuntimeException runtimeException13 = new RuntimeException();
                        throw runtimeException12;
                    }
                    gLUhalfEdge2 = gLUhalfEdge4.Sym.Lnext;
                } else {
                    AssertionError assertionError8 = assertionError;
                    AssertionError assertionError9 = new AssertionError();
                    throw assertionError8;
                }
            }
            if (!Mesh.__gl_meshSplice(gLUvertex2.anEdge, gLUhalfEdge2)) {
                RuntimeException runtimeException14 = runtimeException;
                RuntimeException runtimeException15 = new RuntimeException();
                throw runtimeException14;
            }
            if (!Geom.EdgeGoesLeft(gLUhalfEdge4)) {
                gLUhalfEdge4 = null;
            }
            AddRightEdges(gLUtessellatorImpl2, TopRightRegion, gLUhalfEdge2.Onext, gLUhalfEdge3, gLUhalfEdge4, true);
        }
    }

    static void ConnectLeftVertex(GLUtessellatorImpl gLUtessellatorImpl, GLUvertex gLUvertex) {
        ActiveRegion activeRegion;
        GLUhalfEdge gLUhalfEdge;
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RuntimeException runtimeException3;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        GLUvertex gLUvertex2 = gLUvertex;
        ActiveRegion activeRegion2 = activeRegion;
        ActiveRegion activeRegion3 = new ActiveRegion();
        ActiveRegion activeRegion4 = activeRegion2;
        activeRegion4.eUp = gLUvertex2.anEdge.Sym;
        ActiveRegion activeRegion5 = (ActiveRegion) Dict.dictKey(Dict.dictSearch(gLUtessellatorImpl2.dict, activeRegion4));
        ActiveRegion RegionBelow = RegionBelow(activeRegion5);
        GLUhalfEdge gLUhalfEdge2 = activeRegion5.eUp;
        GLUhalfEdge gLUhalfEdge3 = RegionBelow.eUp;
        if (Geom.EdgeSign(gLUhalfEdge2.Sym.Org, gLUvertex2, gLUhalfEdge2.Org) == 0.0d) {
            ConnectLeftDegenerate(gLUtessellatorImpl2, activeRegion5, gLUvertex2);
            return;
        }
        ActiveRegion activeRegion6 = Geom.VertLeq(gLUhalfEdge3.Sym.Org, gLUhalfEdge2.Sym.Org) ? activeRegion5 : RegionBelow;
        if (activeRegion5.inside || activeRegion6.fixUpperEdge) {
            if (activeRegion6 == activeRegion5) {
                gLUhalfEdge = Mesh.__gl_meshConnect(gLUvertex2.anEdge.Sym, gLUhalfEdge2.Lnext);
                if (gLUhalfEdge == null) {
                    RuntimeException runtimeException4 = runtimeException3;
                    RuntimeException runtimeException5 = new RuntimeException();
                    throw runtimeException4;
                }
            } else {
                GLUhalfEdge __gl_meshConnect = Mesh.__gl_meshConnect(gLUhalfEdge3.Sym.Onext.Sym, gLUvertex2.anEdge);
                if (__gl_meshConnect == null) {
                    RuntimeException runtimeException6 = runtimeException2;
                    RuntimeException runtimeException7 = new RuntimeException();
                    throw runtimeException6;
                }
                gLUhalfEdge = __gl_meshConnect.Sym;
            }
            if (!activeRegion6.fixUpperEdge) {
                ComputeWinding(gLUtessellatorImpl2, AddRegionBelow(gLUtessellatorImpl2, activeRegion5, gLUhalfEdge));
            } else if (!FixUpperEdge(activeRegion6, gLUhalfEdge)) {
                RuntimeException runtimeException8 = runtimeException;
                RuntimeException runtimeException9 = new RuntimeException();
                throw runtimeException8;
            }
            SweepEvent(gLUtessellatorImpl2, gLUvertex2);
            return;
        }
        AddRightEdges(gLUtessellatorImpl2, activeRegion5, gLUvertex2.anEdge, gLUvertex2.anEdge, null, true);
    }

    static void ConnectRightVertex(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion, GLUhalfEdge gLUhalfEdge) {
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RuntimeException runtimeException3;
        RuntimeException runtimeException4;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        ActiveRegion activeRegion2 = activeRegion;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2.Onext;
        ActiveRegion RegionBelow = RegionBelow(activeRegion2);
        GLUhalfEdge gLUhalfEdge4 = activeRegion2.eUp;
        GLUhalfEdge gLUhalfEdge5 = RegionBelow.eUp;
        if (gLUhalfEdge4.Sym.Org != gLUhalfEdge5.Sym.Org) {
            boolean CheckForIntersect = CheckForIntersect(gLUtessellatorImpl2, activeRegion2);
        }
        boolean z = false;
        if (Geom.VertEq(gLUhalfEdge4.Org, gLUtessellatorImpl2.event)) {
            if (!Mesh.__gl_meshSplice(gLUhalfEdge3.Sym.Lnext, gLUhalfEdge4)) {
                RuntimeException runtimeException5 = runtimeException4;
                RuntimeException runtimeException6 = new RuntimeException();
                throw runtimeException5;
            }
            activeRegion2 = TopLeftRegion(activeRegion2);
            if (activeRegion2 == null) {
                RuntimeException runtimeException7 = runtimeException3;
                RuntimeException runtimeException8 = new RuntimeException();
                throw runtimeException7;
            }
            gLUhalfEdge3 = RegionBelow(activeRegion2).eUp;
            GLUhalfEdge FinishLeftRegions = FinishLeftRegions(gLUtessellatorImpl2, RegionBelow(activeRegion2), RegionBelow);
            z = true;
        }
        if (Geom.VertEq(gLUhalfEdge5.Org, gLUtessellatorImpl2.event)) {
            if (!Mesh.__gl_meshSplice(gLUhalfEdge2, gLUhalfEdge5.Sym.Lnext)) {
                RuntimeException runtimeException9 = runtimeException2;
                RuntimeException runtimeException10 = new RuntimeException();
                throw runtimeException9;
            }
            gLUhalfEdge2 = FinishLeftRegions(gLUtessellatorImpl2, RegionBelow, null);
            z = true;
        }
        if (z) {
            AddRightEdges(gLUtessellatorImpl2, activeRegion2, gLUhalfEdge2.Onext, gLUhalfEdge3, gLUhalfEdge3, true);
            return;
        }
        GLUhalfEdge __gl_meshConnect = Mesh.__gl_meshConnect(gLUhalfEdge2.Onext.Sym, Geom.VertLeq(gLUhalfEdge5.Org, gLUhalfEdge4.Org) ? gLUhalfEdge5.Sym.Lnext : gLUhalfEdge4);
        if (__gl_meshConnect == null) {
            RuntimeException runtimeException11 = runtimeException;
            RuntimeException runtimeException12 = new RuntimeException();
            throw runtimeException11;
        }
        AddRightEdges(gLUtessellatorImpl2, activeRegion2, __gl_meshConnect, __gl_meshConnect.Onext, __gl_meshConnect.Onext, false);
        __gl_meshConnect.Sym.activeRegion.fixUpperEdge = true;
        WalkDirtyRegions(gLUtessellatorImpl2, activeRegion2);
    }

    private static void DebugEvent(GLUtessellatorImpl gLUtessellatorImpl) {
    }

    static void DeleteRegion(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        AssertionError assertionError;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        ActiveRegion activeRegion2 = activeRegion;
        if (!activeRegion2.fixUpperEdge || $assertionsDisabled || activeRegion2.eUp.winding == 0) {
            activeRegion2.eUp.activeRegion = null;
            Dict.dictDelete(gLUtessellatorImpl2.dict, activeRegion2.nodeUp);
            return;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    static void DoneEdgeDict(GLUtessellatorImpl gLUtessellatorImpl) {
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        int i = 0;
        while (true) {
            ActiveRegion activeRegion = (ActiveRegion) Dict.dictKey(Dict.dictMin(gLUtessellatorImpl2.dict));
            if (activeRegion != null) {
                if (!activeRegion.sentinel) {
                    if (!$assertionsDisabled && !activeRegion.fixUpperEdge) {
                        AssertionError assertionError4 = assertionError3;
                        AssertionError assertionError5 = new AssertionError();
                        throw assertionError4;
                    } else if (!$assertionsDisabled) {
                        i++;
                        if (i != 1) {
                            AssertionError assertionError6 = assertionError2;
                            AssertionError assertionError7 = new AssertionError();
                            throw assertionError6;
                        }
                    }
                }
                if ($assertionsDisabled || activeRegion.windingNumber == 0) {
                    DeleteRegion(gLUtessellatorImpl2, activeRegion);
                } else {
                    AssertionError assertionError8 = assertionError;
                    AssertionError assertionError9 = new AssertionError();
                    throw assertionError8;
                }
            } else {
                Dict.dictDeleteDict(gLUtessellatorImpl2.dict);
                return;
            }
        }
    }

    static void DonePriorityQ(GLUtessellatorImpl gLUtessellatorImpl) {
        gLUtessellatorImpl.f241pq.pqDeletePriorityQ();
    }

    static boolean EdgeLeq(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion, ActiveRegion activeRegion2) {
        ActiveRegion activeRegion3 = activeRegion;
        ActiveRegion activeRegion4 = activeRegion2;
        GLUvertex gLUvertex = gLUtessellatorImpl.event;
        GLUhalfEdge gLUhalfEdge = activeRegion3.eUp;
        GLUhalfEdge gLUhalfEdge2 = activeRegion4.eUp;
        return gLUhalfEdge.Sym.Org == gLUvertex ? gLUhalfEdge2.Sym.Org == gLUvertex ? Geom.VertLeq(gLUhalfEdge.Org, gLUhalfEdge2.Org) ? Geom.EdgeSign(gLUhalfEdge2.Sym.Org, gLUhalfEdge.Org, gLUhalfEdge2.Org) <= 0.0d : Geom.EdgeSign(gLUhalfEdge.Sym.Org, gLUhalfEdge2.Org, gLUhalfEdge.Org) >= 0.0d : Geom.EdgeSign(gLUhalfEdge2.Sym.Org, gLUvertex, gLUhalfEdge2.Org) <= 0.0d : gLUhalfEdge2.Sym.Org == gLUvertex ? Geom.EdgeSign(gLUhalfEdge.Sym.Org, gLUvertex, gLUhalfEdge.Org) >= 0.0d : Geom.EdgeEval(gLUhalfEdge.Sym.Org, gLUvertex, gLUhalfEdge.Org) >= Geom.EdgeEval(gLUhalfEdge2.Sym.Org, gLUvertex, gLUhalfEdge2.Org);
    }

    static GLUhalfEdge FinishLeftRegions(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion, ActiveRegion activeRegion2) {
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RuntimeException runtimeException3;
        RuntimeException runtimeException4;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        ActiveRegion activeRegion3 = activeRegion;
        ActiveRegion activeRegion4 = activeRegion2;
        ActiveRegion activeRegion5 = activeRegion3;
        GLUhalfEdge gLUhalfEdge = activeRegion3.eUp;
        while (true) {
            if (activeRegion5 == activeRegion4) {
                break;
            }
            activeRegion5.fixUpperEdge = false;
            ActiveRegion RegionBelow = RegionBelow(activeRegion5);
            GLUhalfEdge gLUhalfEdge2 = RegionBelow.eUp;
            if (gLUhalfEdge2.Org != gLUhalfEdge.Org) {
                if (!RegionBelow.fixUpperEdge) {
                    FinishRegion(gLUtessellatorImpl2, activeRegion5);
                    break;
                }
                gLUhalfEdge2 = Mesh.__gl_meshConnect(gLUhalfEdge.Onext.Sym, gLUhalfEdge2.Sym);
                if (gLUhalfEdge2 == null) {
                    RuntimeException runtimeException5 = runtimeException3;
                    RuntimeException runtimeException6 = new RuntimeException();
                    throw runtimeException5;
                } else if (!FixUpperEdge(RegionBelow, gLUhalfEdge2)) {
                    RuntimeException runtimeException7 = runtimeException4;
                    RuntimeException runtimeException8 = new RuntimeException();
                    throw runtimeException7;
                }
            }
            if (gLUhalfEdge.Onext != gLUhalfEdge2) {
                if (!Mesh.__gl_meshSplice(gLUhalfEdge2.Sym.Lnext, gLUhalfEdge2)) {
                    RuntimeException runtimeException9 = runtimeException;
                    RuntimeException runtimeException10 = new RuntimeException();
                    throw runtimeException9;
                } else if (!Mesh.__gl_meshSplice(gLUhalfEdge, gLUhalfEdge2)) {
                    RuntimeException runtimeException11 = runtimeException2;
                    RuntimeException runtimeException12 = new RuntimeException();
                    throw runtimeException11;
                }
            }
            FinishRegion(gLUtessellatorImpl2, activeRegion5);
            gLUhalfEdge = RegionBelow.eUp;
            activeRegion5 = RegionBelow;
        }
        return gLUhalfEdge;
    }

    static void FinishRegion(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        ActiveRegion activeRegion2 = activeRegion;
        GLUhalfEdge gLUhalfEdge = activeRegion2.eUp;
        GLUface gLUface = gLUhalfEdge.Lface;
        gLUface.inside = activeRegion2.inside;
        gLUface.anEdge = gLUhalfEdge;
        DeleteRegion(gLUtessellatorImpl2, activeRegion2);
    }

    static boolean FixUpperEdge(ActiveRegion activeRegion, GLUhalfEdge gLUhalfEdge) {
        AssertionError assertionError;
        ActiveRegion activeRegion2 = activeRegion;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        if (!$assertionsDisabled && !activeRegion2.fixUpperEdge) {
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError();
            throw assertionError2;
        } else if (!Mesh.__gl_meshDelete(activeRegion2.eUp)) {
            return false;
        } else {
            activeRegion2.fixUpperEdge = false;
            activeRegion2.eUp = gLUhalfEdge2;
            gLUhalfEdge2.activeRegion = activeRegion2;
            return true;
        }
    }

    static void GetIntersectData(GLUtessellatorImpl gLUtessellatorImpl, GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3, GLUvertex gLUvertex4, GLUvertex gLUvertex5) {
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        GLUvertex gLUvertex6 = gLUvertex;
        GLUvertex gLUvertex7 = gLUvertex2;
        GLUvertex gLUvertex8 = gLUvertex3;
        GLUvertex gLUvertex9 = gLUvertex4;
        GLUvertex gLUvertex10 = gLUvertex5;
        float[] fArr = new float[4];
        float[] fArr2 = new float[2];
        float[] fArr3 = new float[2];
        Object[] objArr = {gLUvertex7.data, gLUvertex8.data, gLUvertex9.data, gLUvertex10.data};
        double[] dArr = gLUvertex6.coords;
        double[] dArr2 = gLUvertex6.coords;
        gLUvertex6.coords[2] = 0.0d;
        dArr2[1] = 0.0d;
        dArr[0] = 0.0d;
        VertexWeights(gLUvertex6, gLUvertex7, gLUvertex8, fArr2);
        VertexWeights(gLUvertex6, gLUvertex9, gLUvertex10, fArr3);
        System.arraycopy(fArr2, 0, fArr, 0, 2);
        System.arraycopy(fArr3, 0, fArr, 2, 2);
        CallCombine(gLUtessellatorImpl2, gLUvertex6, objArr, fArr, true);
    }

    static void InitEdgeDict(GLUtessellatorImpl gLUtessellatorImpl) {
        C08471 r6;
        RuntimeException runtimeException;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        GLUtessellatorImpl gLUtessellatorImpl3 = gLUtessellatorImpl2;
        GLUtessellatorImpl gLUtessellatorImpl4 = gLUtessellatorImpl2;
        C08471 r3 = r6;
        final GLUtessellatorImpl gLUtessellatorImpl5 = gLUtessellatorImpl2;
        C08471 r4 = new DictLeq() {
            public boolean leq(Object obj, Object obj2, Object obj3) {
                Object obj4 = obj;
                return Sweep.EdgeLeq(gLUtessellatorImpl5, (ActiveRegion) obj2, (ActiveRegion) obj3);
            }
        };
        gLUtessellatorImpl3.dict = Dict.dictNewDict(gLUtessellatorImpl4, r3);
        if (gLUtessellatorImpl2.dict == null) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException();
            throw runtimeException2;
        }
        AddSentinel(gLUtessellatorImpl2, -4.0E150d);
        AddSentinel(gLUtessellatorImpl2, SENTINEL_COORD);
    }

    static boolean InitPriorityQ(GLUtessellatorImpl gLUtessellatorImpl) {
        C08482 r8;
        GLUvertex gLUvertex;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        C08482 r4 = r8;
        C08482 r5 = new Leq() {
            public boolean leq(Object obj, Object obj2) {
                return Geom.VertLeq((GLUvertex) obj, (GLUvertex) obj2);
            }
        };
        PriorityQ pqNewPriorityQ = PriorityQ.pqNewPriorityQ(r4);
        gLUtessellatorImpl2.f241pq = pqNewPriorityQ;
        if (pqNewPriorityQ == null) {
            return false;
        }
        GLUvertex gLUvertex2 = gLUtessellatorImpl2.mesh.vHead;
        GLUvertex gLUvertex3 = gLUvertex2.next;
        while (true) {
            gLUvertex = gLUvertex3;
            if (gLUvertex == gLUvertex2) {
                break;
            }
            gLUvertex.pqHandle = pqNewPriorityQ.pqInsert(gLUvertex);
            if (((long) gLUvertex.pqHandle) == Long.MAX_VALUE) {
                break;
            }
            gLUvertex3 = gLUvertex.next;
        }
        if (gLUvertex == gLUvertex2 && pqNewPriorityQ.pqInit()) {
            return true;
        }
        gLUtessellatorImpl2.f241pq.pqDeletePriorityQ();
        gLUtessellatorImpl2.f241pq = null;
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r1 <= -2) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean IsWindingInside(org.lwjgl.util.glu.tessellation.GLUtessellatorImpl r6, int r7) {
        /*
            r0 = r6
            r1 = r7
            r3 = r0
            int r3 = r3.windingRule
            switch(r3) {
                case 100130: goto L_0x0011;
                case 100131: goto L_0x001d;
                case 100132: goto L_0x0023;
                case 100133: goto L_0x0029;
                case 100134: goto L_0x002f;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.InternalError r3 = new java.lang.InternalError
            r5 = r3
            r3 = r5
            r4 = r5
            r4.<init>()
            throw r3
        L_0x0011:
            r3 = r1
            r4 = 1
            r3 = r3 & 1
            if (r3 == 0) goto L_0x001a
        L_0x0017:
            r3 = 1
            r0 = r3
        L_0x0019:
            return r0
        L_0x001a:
            r3 = 0
            r0 = r3
            goto L_0x0019
        L_0x001d:
            r3 = r1
            if (r3 != 0) goto L_0x0017
            r3 = 0
            r0 = r3
            goto L_0x0019
        L_0x0023:
            r3 = r1
            if (r3 > 0) goto L_0x0017
            r3 = 0
            r0 = r3
            goto L_0x0019
        L_0x0029:
            r3 = r1
            if (r3 < 0) goto L_0x0017
            r3 = 0
            r0 = r3
            goto L_0x0019
        L_0x002f:
            r3 = r1
            r4 = 2
            if (r3 >= r4) goto L_0x0039
            r3 = 0
            r2 = r3
            r3 = r1
            r4 = -2
            if (r3 > r4) goto L_0x003b
        L_0x0039:
            r3 = 1
            r2 = r3
        L_0x003b:
            r3 = r2
            r0 = r3
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.glu.tessellation.Sweep.IsWindingInside(org.lwjgl.util.glu.tessellation.GLUtessellatorImpl, int):boolean");
    }

    private static ActiveRegion RegionAbove(ActiveRegion activeRegion) {
        return (ActiveRegion) Dict.dictKey(Dict.dictSucc(activeRegion.nodeUp));
    }

    private static ActiveRegion RegionBelow(ActiveRegion activeRegion) {
        return (ActiveRegion) Dict.dictKey(Dict.dictPred(activeRegion.nodeUp));
    }

    static void RemoveDegenerateEdges(GLUtessellatorImpl gLUtessellatorImpl) {
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RuntimeException runtimeException3;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        GLUhalfEdge gLUhalfEdge = gLUtessellatorImpl2.mesh.eHead;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge.next;
        while (true) {
            GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2;
            if (gLUhalfEdge3 != gLUhalfEdge) {
                GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge3.next;
                GLUhalfEdge gLUhalfEdge5 = gLUhalfEdge3.Lnext;
                if (Geom.VertEq(gLUhalfEdge3.Org, gLUhalfEdge3.Sym.Org) && gLUhalfEdge3.Lnext.Lnext != gLUhalfEdge3) {
                    SpliceMergeVertices(gLUtessellatorImpl2, gLUhalfEdge5, gLUhalfEdge3);
                    if (!Mesh.__gl_meshDelete(gLUhalfEdge3)) {
                        RuntimeException runtimeException4 = runtimeException3;
                        RuntimeException runtimeException5 = new RuntimeException();
                        throw runtimeException4;
                    }
                    gLUhalfEdge3 = gLUhalfEdge5;
                    gLUhalfEdge5 = gLUhalfEdge3.Lnext;
                }
                if (gLUhalfEdge5.Lnext == gLUhalfEdge3) {
                    if (gLUhalfEdge5 != gLUhalfEdge3) {
                        if (gLUhalfEdge5 == gLUhalfEdge4 || gLUhalfEdge5 == gLUhalfEdge4.Sym) {
                            gLUhalfEdge4 = gLUhalfEdge4.next;
                        }
                        if (!Mesh.__gl_meshDelete(gLUhalfEdge5)) {
                            RuntimeException runtimeException6 = runtimeException2;
                            RuntimeException runtimeException7 = new RuntimeException();
                            throw runtimeException6;
                        }
                    }
                    if (gLUhalfEdge3 == gLUhalfEdge4 || gLUhalfEdge3 == gLUhalfEdge4.Sym) {
                        gLUhalfEdge4 = gLUhalfEdge4.next;
                    }
                    if (!Mesh.__gl_meshDelete(gLUhalfEdge3)) {
                        RuntimeException runtimeException8 = runtimeException;
                        RuntimeException runtimeException9 = new RuntimeException();
                        throw runtimeException8;
                    }
                }
                gLUhalfEdge2 = gLUhalfEdge4;
            } else {
                return;
            }
        }
    }

    static boolean RemoveDegenerateFaces(GLUmesh gLUmesh) {
        AssertionError assertionError;
        GLUmesh gLUmesh2 = gLUmesh;
        GLUface gLUface = gLUmesh2.fHead.next;
        while (true) {
            GLUface gLUface2 = gLUface;
            if (gLUface2 == gLUmesh2.fHead) {
                return true;
            }
            GLUface gLUface3 = gLUface2.next;
            GLUhalfEdge gLUhalfEdge = gLUface2.anEdge;
            if ($assertionsDisabled || gLUhalfEdge.Lnext != gLUhalfEdge) {
                if (gLUhalfEdge.Lnext.Lnext == gLUhalfEdge) {
                    AddWinding(gLUhalfEdge.Onext, gLUhalfEdge);
                    if (!Mesh.__gl_meshDelete(gLUhalfEdge)) {
                        return false;
                    }
                }
                gLUface = gLUface3;
            } else {
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
            }
        }
    }

    static void SpliceMergeVertices(GLUtessellatorImpl gLUtessellatorImpl, GLUhalfEdge gLUhalfEdge, GLUhalfEdge gLUhalfEdge2) {
        RuntimeException runtimeException;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge2;
        Object[] objArr = new Object[4];
        float[] fArr = {0.5f, 0.5f, 0.0f, 0.0f};
        objArr[0] = gLUhalfEdge3.Org.data;
        objArr[1] = gLUhalfEdge4.Org.data;
        CallCombine(gLUtessellatorImpl2, gLUhalfEdge3.Org, objArr, fArr, false);
        if (!Mesh.__gl_meshSplice(gLUhalfEdge3, gLUhalfEdge4)) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException();
            throw runtimeException2;
        }
    }

    static void SweepEvent(GLUtessellatorImpl gLUtessellatorImpl, GLUvertex gLUvertex) {
        RuntimeException runtimeException;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        GLUvertex gLUvertex2 = gLUvertex;
        gLUtessellatorImpl2.event = gLUvertex2;
        DebugEvent(gLUtessellatorImpl2);
        GLUhalfEdge gLUhalfEdge = gLUvertex2.anEdge;
        while (gLUhalfEdge.activeRegion == null) {
            gLUhalfEdge = gLUhalfEdge.Onext;
            if (gLUhalfEdge == gLUvertex2.anEdge) {
                ConnectLeftVertex(gLUtessellatorImpl2, gLUvertex2);
                return;
            }
        }
        ActiveRegion TopLeftRegion = TopLeftRegion(gLUhalfEdge.activeRegion);
        if (TopLeftRegion == null) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException();
            throw runtimeException2;
        }
        ActiveRegion RegionBelow = RegionBelow(TopLeftRegion);
        GLUhalfEdge gLUhalfEdge2 = RegionBelow.eUp;
        GLUhalfEdge FinishLeftRegions = FinishLeftRegions(gLUtessellatorImpl2, RegionBelow, null);
        if (FinishLeftRegions.Onext == gLUhalfEdge2) {
            ConnectRightVertex(gLUtessellatorImpl2, TopLeftRegion, FinishLeftRegions);
        } else {
            AddRightEdges(gLUtessellatorImpl2, TopLeftRegion, FinishLeftRegions.Onext, gLUhalfEdge2, gLUhalfEdge2, true);
        }
    }

    static ActiveRegion TopLeftRegion(ActiveRegion activeRegion) {
        ActiveRegion activeRegion2 = activeRegion;
        GLUvertex gLUvertex = activeRegion2.eUp.Org;
        do {
            activeRegion2 = RegionAbove(activeRegion2);
        } while (activeRegion2.eUp.Org == gLUvertex);
        if (activeRegion2.fixUpperEdge) {
            GLUhalfEdge __gl_meshConnect = Mesh.__gl_meshConnect(RegionBelow(activeRegion2).eUp.Sym, activeRegion2.eUp.Lnext);
            if (__gl_meshConnect == null) {
                activeRegion2 = null;
            } else if (!FixUpperEdge(activeRegion2, __gl_meshConnect)) {
                return null;
            } else {
                return RegionAbove(activeRegion2);
            }
        }
        return activeRegion2;
    }

    static ActiveRegion TopRightRegion(ActiveRegion activeRegion) {
        ActiveRegion activeRegion2 = activeRegion;
        GLUvertex gLUvertex = activeRegion2.eUp.Sym.Org;
        do {
            activeRegion2 = RegionAbove(activeRegion2);
        } while (activeRegion2.eUp.Sym.Org == gLUvertex);
        return activeRegion2;
    }

    static void VertexWeights(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3, float[] fArr) {
        GLUvertex gLUvertex4 = gLUvertex;
        GLUvertex gLUvertex5 = gLUvertex2;
        GLUvertex gLUvertex6 = gLUvertex3;
        float[] fArr2 = fArr;
        double VertL1dist = Geom.VertL1dist(gLUvertex5, gLUvertex4);
        double VertL1dist2 = Geom.VertL1dist(gLUvertex6, gLUvertex4);
        fArr2[0] = (float) ((0.5d * VertL1dist2) / (VertL1dist + VertL1dist2));
        fArr2[1] = (float) ((0.5d * VertL1dist) / (VertL1dist + VertL1dist2));
        double[] dArr = gLUvertex4.coords;
        dArr[0] = dArr[0] + (((double) fArr2[0]) * gLUvertex5.coords[0]) + (((double) fArr2[1]) * gLUvertex6.coords[0]);
        double[] dArr2 = gLUvertex4.coords;
        dArr2[1] = dArr2[1] + (((double) fArr2[0]) * gLUvertex5.coords[1]) + (((double) fArr2[1]) * gLUvertex6.coords[1]);
        double[] dArr3 = gLUvertex4.coords;
        dArr3[2] = dArr3[2] + (((double) fArr2[0]) * gLUvertex5.coords[2]) + (((double) fArr2[1]) * gLUvertex6.coords[2]);
    }

    static void WalkDirtyRegions(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RuntimeException runtimeException3;
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        ActiveRegion activeRegion2 = activeRegion;
        ActiveRegion RegionBelow = RegionBelow(activeRegion2);
        while (true) {
            if (RegionBelow.dirty) {
                activeRegion2 = RegionBelow;
                RegionBelow = RegionBelow(RegionBelow);
            } else {
                if (!activeRegion2.dirty) {
                    RegionBelow = activeRegion2;
                    activeRegion2 = RegionAbove(activeRegion2);
                    if (activeRegion2 == null || !activeRegion2.dirty) {
                        return;
                    }
                }
                activeRegion2.dirty = false;
                GLUhalfEdge gLUhalfEdge = activeRegion2.eUp;
                GLUhalfEdge gLUhalfEdge2 = RegionBelow.eUp;
                if (gLUhalfEdge.Sym.Org != gLUhalfEdge2.Sym.Org && CheckForLeftSplice(gLUtessellatorImpl2, activeRegion2)) {
                    if (RegionBelow.fixUpperEdge) {
                        DeleteRegion(gLUtessellatorImpl2, RegionBelow);
                        if (!Mesh.__gl_meshDelete(gLUhalfEdge2)) {
                            RuntimeException runtimeException4 = runtimeException3;
                            RuntimeException runtimeException5 = new RuntimeException();
                            throw runtimeException4;
                        }
                        RegionBelow = RegionBelow(activeRegion2);
                        gLUhalfEdge2 = RegionBelow.eUp;
                    } else if (activeRegion2.fixUpperEdge) {
                        DeleteRegion(gLUtessellatorImpl2, activeRegion2);
                        if (!Mesh.__gl_meshDelete(gLUhalfEdge)) {
                            RuntimeException runtimeException6 = runtimeException2;
                            RuntimeException runtimeException7 = new RuntimeException();
                            throw runtimeException6;
                        }
                        activeRegion2 = RegionAbove(RegionBelow);
                        gLUhalfEdge = activeRegion2.eUp;
                    }
                }
                if (gLUhalfEdge.Org != gLUhalfEdge2.Org) {
                    if (gLUhalfEdge.Sym.Org == gLUhalfEdge2.Sym.Org || activeRegion2.fixUpperEdge || RegionBelow.fixUpperEdge || !(gLUhalfEdge.Sym.Org == gLUtessellatorImpl2.event || gLUhalfEdge2.Sym.Org == gLUtessellatorImpl2.event)) {
                        boolean CheckForRightSplice = CheckForRightSplice(gLUtessellatorImpl2, activeRegion2);
                    } else if (CheckForIntersect(gLUtessellatorImpl2, activeRegion2)) {
                        return;
                    }
                }
                if (gLUhalfEdge.Org == gLUhalfEdge2.Org && gLUhalfEdge.Sym.Org == gLUhalfEdge2.Sym.Org) {
                    AddWinding(gLUhalfEdge2, gLUhalfEdge);
                    DeleteRegion(gLUtessellatorImpl2, activeRegion2);
                    if (!Mesh.__gl_meshDelete(gLUhalfEdge)) {
                        RuntimeException runtimeException8 = runtimeException;
                        RuntimeException runtimeException9 = new RuntimeException();
                        throw runtimeException8;
                    }
                    activeRegion2 = RegionAbove(RegionBelow);
                }
            }
        }
    }

    public static boolean __gl_computeInterior(GLUtessellatorImpl gLUtessellatorImpl) {
        GLUtessellatorImpl gLUtessellatorImpl2 = gLUtessellatorImpl;
        gLUtessellatorImpl2.fatalError = false;
        RemoveDegenerateEdges(gLUtessellatorImpl2);
        if (!InitPriorityQ(gLUtessellatorImpl2)) {
            return false;
        }
        InitEdgeDict(gLUtessellatorImpl2);
        while (true) {
            GLUvertex gLUvertex = (GLUvertex) gLUtessellatorImpl2.f241pq.pqExtractMin();
            if (gLUvertex == null) {
                break;
            }
            while (true) {
                GLUvertex gLUvertex2 = (GLUvertex) gLUtessellatorImpl2.f241pq.pqMinimum();
                if (gLUvertex2 == null || !Geom.VertEq(gLUvertex2, gLUvertex)) {
                    SweepEvent(gLUtessellatorImpl2, gLUvertex);
                } else {
                    SpliceMergeVertices(gLUtessellatorImpl2, gLUvertex.anEdge, ((GLUvertex) gLUtessellatorImpl2.f241pq.pqExtractMin()).anEdge);
                }
            }
            SweepEvent(gLUtessellatorImpl2, gLUvertex);
        }
        gLUtessellatorImpl2.event = ((ActiveRegion) Dict.dictKey(Dict.dictMin(gLUtessellatorImpl2.dict))).eUp.Org;
        DebugEvent(gLUtessellatorImpl2);
        DoneEdgeDict(gLUtessellatorImpl2);
        DonePriorityQ(gLUtessellatorImpl2);
        if (!RemoveDegenerateFaces(gLUtessellatorImpl2.mesh)) {
            return false;
        }
        Mesh.__gl_meshCheckMesh(gLUtessellatorImpl2.mesh);
        return true;
    }
}
