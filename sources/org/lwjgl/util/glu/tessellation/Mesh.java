package org.lwjgl.util.glu.tessellation;

class Mesh {
    static final /* synthetic */ boolean $assertionsDisabled = (!Mesh.class.desiredAssertionStatus());

    private Mesh() {
    }

    static void KillEdge(GLUhalfEdge gLUhalfEdge) {
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        if (!gLUhalfEdge2.first) {
            gLUhalfEdge2 = gLUhalfEdge2.Sym;
        }
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2.next;
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge2.Sym.next;
        gLUhalfEdge3.Sym.next = gLUhalfEdge4;
        gLUhalfEdge4.Sym.next = gLUhalfEdge3;
    }

    static void KillFace(GLUface gLUface, GLUface gLUface2) {
        GLUface gLUface3 = gLUface;
        GLUface gLUface4 = gLUface2;
        GLUhalfEdge gLUhalfEdge = gLUface3.anEdge;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        do {
            gLUhalfEdge2.Lface = gLUface4;
            gLUhalfEdge2 = gLUhalfEdge2.Lnext;
        } while (gLUhalfEdge2 != gLUhalfEdge);
        GLUface gLUface5 = gLUface3.prev;
        GLUface gLUface6 = gLUface3.next;
        gLUface6.prev = gLUface5;
        gLUface5.next = gLUface6;
    }

    static void KillVertex(GLUvertex gLUvertex, GLUvertex gLUvertex2) {
        GLUvertex gLUvertex3 = gLUvertex;
        GLUvertex gLUvertex4 = gLUvertex2;
        GLUhalfEdge gLUhalfEdge = gLUvertex3.anEdge;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        do {
            gLUhalfEdge2.Org = gLUvertex4;
            gLUhalfEdge2 = gLUhalfEdge2.Onext;
        } while (gLUhalfEdge2 != gLUhalfEdge);
        GLUvertex gLUvertex5 = gLUvertex3.prev;
        GLUvertex gLUvertex6 = gLUvertex3.next;
        gLUvertex6.prev = gLUvertex5;
        gLUvertex5.next = gLUvertex6;
    }

    static GLUhalfEdge MakeEdge(GLUhalfEdge gLUhalfEdge) {
        GLUhalfEdge gLUhalfEdge2;
        GLUhalfEdge gLUhalfEdge3;
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge5 = gLUhalfEdge2;
        GLUhalfEdge gLUhalfEdge6 = new GLUhalfEdge(true);
        GLUhalfEdge gLUhalfEdge7 = gLUhalfEdge5;
        GLUhalfEdge gLUhalfEdge8 = gLUhalfEdge3;
        GLUhalfEdge gLUhalfEdge9 = new GLUhalfEdge(false);
        GLUhalfEdge gLUhalfEdge10 = gLUhalfEdge8;
        if (!gLUhalfEdge4.first) {
            gLUhalfEdge4 = gLUhalfEdge4.Sym;
        }
        GLUhalfEdge gLUhalfEdge11 = gLUhalfEdge4.Sym.next;
        gLUhalfEdge10.next = gLUhalfEdge11;
        gLUhalfEdge11.Sym.next = gLUhalfEdge7;
        gLUhalfEdge7.next = gLUhalfEdge4;
        gLUhalfEdge4.Sym.next = gLUhalfEdge10;
        gLUhalfEdge7.Sym = gLUhalfEdge10;
        gLUhalfEdge7.Onext = gLUhalfEdge7;
        gLUhalfEdge7.Lnext = gLUhalfEdge10;
        gLUhalfEdge7.Org = null;
        gLUhalfEdge7.Lface = null;
        gLUhalfEdge7.winding = 0;
        gLUhalfEdge7.activeRegion = null;
        gLUhalfEdge10.Sym = gLUhalfEdge7;
        gLUhalfEdge10.Onext = gLUhalfEdge10;
        gLUhalfEdge10.Lnext = gLUhalfEdge7;
        gLUhalfEdge10.Org = null;
        gLUhalfEdge10.Lface = null;
        gLUhalfEdge10.winding = 0;
        gLUhalfEdge10.activeRegion = null;
        return gLUhalfEdge7;
    }

    static void MakeFace(GLUface gLUface, GLUhalfEdge gLUhalfEdge, GLUface gLUface2) {
        AssertionError assertionError;
        GLUface gLUface3 = gLUface;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        GLUface gLUface4 = gLUface2;
        if ($assertionsDisabled || gLUface3 != null) {
            GLUface gLUface5 = gLUface4.prev;
            gLUface3.prev = gLUface5;
            gLUface5.next = gLUface3;
            gLUface3.next = gLUface4;
            gLUface4.prev = gLUface3;
            gLUface3.anEdge = gLUhalfEdge2;
            gLUface3.data = null;
            gLUface3.trail = null;
            gLUface3.marked = false;
            gLUface3.inside = gLUface4.inside;
            GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2;
            do {
                gLUhalfEdge3.Lface = gLUface3;
                gLUhalfEdge3 = gLUhalfEdge3.Lnext;
            } while (gLUhalfEdge3 != gLUhalfEdge2);
            return;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    static void MakeVertex(GLUvertex gLUvertex, GLUhalfEdge gLUhalfEdge, GLUvertex gLUvertex2) {
        AssertionError assertionError;
        GLUvertex gLUvertex3 = gLUvertex;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        GLUvertex gLUvertex4 = gLUvertex2;
        if ($assertionsDisabled || gLUvertex3 != null) {
            GLUvertex gLUvertex5 = gLUvertex4.prev;
            gLUvertex3.prev = gLUvertex5;
            gLUvertex5.next = gLUvertex3;
            gLUvertex3.next = gLUvertex4;
            gLUvertex4.prev = gLUvertex3;
            gLUvertex3.anEdge = gLUhalfEdge2;
            gLUvertex3.data = null;
            GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2;
            do {
                gLUhalfEdge3.Org = gLUvertex3;
                gLUhalfEdge3 = gLUhalfEdge3.Onext;
            } while (gLUhalfEdge3 != gLUhalfEdge2);
            return;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    static void Splice(GLUhalfEdge gLUhalfEdge, GLUhalfEdge gLUhalfEdge2) {
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge2;
        GLUhalfEdge gLUhalfEdge5 = gLUhalfEdge3.Onext;
        GLUhalfEdge gLUhalfEdge6 = gLUhalfEdge4.Onext;
        gLUhalfEdge5.Sym.Lnext = gLUhalfEdge4;
        gLUhalfEdge6.Sym.Lnext = gLUhalfEdge3;
        gLUhalfEdge3.Onext = gLUhalfEdge6;
        gLUhalfEdge4.Onext = gLUhalfEdge5;
    }

    static GLUhalfEdge __gl_meshAddEdgeVertex(GLUhalfEdge gLUhalfEdge) {
        GLUvertex gLUvertex;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        GLUhalfEdge MakeEdge = MakeEdge(gLUhalfEdge2);
        GLUhalfEdge gLUhalfEdge3 = MakeEdge.Sym;
        Splice(MakeEdge, gLUhalfEdge2.Lnext);
        MakeEdge.Org = gLUhalfEdge2.Sym.Org;
        GLUvertex gLUvertex2 = gLUvertex;
        GLUvertex gLUvertex3 = new GLUvertex();
        MakeVertex(gLUvertex2, gLUhalfEdge3, MakeEdge.Org);
        GLUface gLUface = gLUhalfEdge2.Lface;
        gLUhalfEdge3.Lface = gLUface;
        MakeEdge.Lface = gLUface;
        return MakeEdge;
    }

    public static void __gl_meshCheckMesh(GLUmesh gLUmesh) {
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        AssertionError assertionError4;
        AssertionError assertionError5;
        AssertionError assertionError6;
        AssertionError assertionError7;
        AssertionError assertionError8;
        AssertionError assertionError9;
        AssertionError assertionError10;
        AssertionError assertionError11;
        AssertionError assertionError12;
        AssertionError assertionError13;
        AssertionError assertionError14;
        AssertionError assertionError15;
        AssertionError assertionError16;
        AssertionError assertionError17;
        AssertionError assertionError18;
        AssertionError assertionError19;
        AssertionError assertionError20;
        AssertionError assertionError21;
        AssertionError assertionError22;
        GLUmesh gLUmesh2 = gLUmesh;
        GLUface gLUface = gLUmesh2.fHead;
        GLUvertex gLUvertex = gLUmesh2.vHead;
        GLUhalfEdge gLUhalfEdge = gLUmesh2.eHead;
        GLUface gLUface2 = gLUface;
        while (true) {
            GLUface gLUface3 = gLUface2;
            GLUface gLUface4 = gLUface3.next;
            if (gLUface4 != gLUface) {
                if ($assertionsDisabled || gLUface4.prev == gLUface3) {
                    GLUhalfEdge gLUhalfEdge2 = gLUface4.anEdge;
                    do {
                        if (!$assertionsDisabled && gLUhalfEdge2.Sym == gLUhalfEdge2) {
                            AssertionError assertionError23 = assertionError21;
                            AssertionError assertionError24 = new AssertionError();
                            throw assertionError23;
                        } else if (!$assertionsDisabled && gLUhalfEdge2.Sym.Sym != gLUhalfEdge2) {
                            AssertionError assertionError25 = assertionError20;
                            AssertionError assertionError26 = new AssertionError();
                            throw assertionError25;
                        } else if (!$assertionsDisabled && gLUhalfEdge2.Lnext.Onext.Sym != gLUhalfEdge2) {
                            AssertionError assertionError27 = assertionError19;
                            AssertionError assertionError28 = new AssertionError();
                            throw assertionError27;
                        } else if (!$assertionsDisabled && gLUhalfEdge2.Onext.Sym.Lnext != gLUhalfEdge2) {
                            AssertionError assertionError29 = assertionError18;
                            AssertionError assertionError30 = new AssertionError();
                            throw assertionError29;
                        } else if ($assertionsDisabled || gLUhalfEdge2.Lface == gLUface4) {
                            gLUhalfEdge2 = gLUhalfEdge2.Lnext;
                        } else {
                            AssertionError assertionError31 = assertionError17;
                            AssertionError assertionError32 = new AssertionError();
                            throw assertionError31;
                        }
                    } while (gLUhalfEdge2 != gLUface4.anEdge);
                    gLUface2 = gLUface4;
                } else {
                    AssertionError assertionError33 = assertionError22;
                    AssertionError assertionError34 = new AssertionError();
                    throw assertionError33;
                }
            } else if ($assertionsDisabled || (gLUface4.prev == gLUface3 && gLUface4.anEdge == null && gLUface4.data == null)) {
                GLUvertex gLUvertex2 = gLUvertex;
                while (true) {
                    GLUvertex gLUvertex3 = gLUvertex2;
                    GLUvertex gLUvertex4 = gLUvertex3.next;
                    if (gLUvertex4 != gLUvertex) {
                        if ($assertionsDisabled || gLUvertex4.prev == gLUvertex3) {
                            GLUhalfEdge gLUhalfEdge3 = gLUvertex4.anEdge;
                            do {
                                if (!$assertionsDisabled && gLUhalfEdge3.Sym == gLUhalfEdge3) {
                                    AssertionError assertionError35 = assertionError14;
                                    AssertionError assertionError36 = new AssertionError();
                                    throw assertionError35;
                                } else if (!$assertionsDisabled && gLUhalfEdge3.Sym.Sym != gLUhalfEdge3) {
                                    AssertionError assertionError37 = assertionError13;
                                    AssertionError assertionError38 = new AssertionError();
                                    throw assertionError37;
                                } else if (!$assertionsDisabled && gLUhalfEdge3.Lnext.Onext.Sym != gLUhalfEdge3) {
                                    AssertionError assertionError39 = assertionError12;
                                    AssertionError assertionError40 = new AssertionError();
                                    throw assertionError39;
                                } else if (!$assertionsDisabled && gLUhalfEdge3.Onext.Sym.Lnext != gLUhalfEdge3) {
                                    AssertionError assertionError41 = assertionError11;
                                    AssertionError assertionError42 = new AssertionError();
                                    throw assertionError41;
                                } else if ($assertionsDisabled || gLUhalfEdge3.Org == gLUvertex4) {
                                    gLUhalfEdge3 = gLUhalfEdge3.Onext;
                                } else {
                                    AssertionError assertionError43 = assertionError10;
                                    AssertionError assertionError44 = new AssertionError();
                                    throw assertionError43;
                                }
                            } while (gLUhalfEdge3 != gLUvertex4.anEdge);
                            gLUvertex2 = gLUvertex4;
                        } else {
                            AssertionError assertionError45 = assertionError15;
                            AssertionError assertionError46 = new AssertionError();
                            throw assertionError45;
                        }
                    } else if ($assertionsDisabled || (gLUvertex4.prev == gLUvertex3 && gLUvertex4.anEdge == null && gLUvertex4.data == null)) {
                        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge;
                        while (true) {
                            GLUhalfEdge gLUhalfEdge5 = gLUhalfEdge4;
                            GLUhalfEdge gLUhalfEdge6 = gLUhalfEdge5.next;
                            if (gLUhalfEdge6 != gLUhalfEdge) {
                                if (!$assertionsDisabled && gLUhalfEdge6.Sym.next != gLUhalfEdge5.Sym) {
                                    AssertionError assertionError47 = assertionError8;
                                    AssertionError assertionError48 = new AssertionError();
                                    throw assertionError47;
                                } else if (!$assertionsDisabled && gLUhalfEdge6.Sym == gLUhalfEdge6) {
                                    AssertionError assertionError49 = assertionError7;
                                    AssertionError assertionError50 = new AssertionError();
                                    throw assertionError49;
                                } else if (!$assertionsDisabled && gLUhalfEdge6.Sym.Sym != gLUhalfEdge6) {
                                    AssertionError assertionError51 = assertionError6;
                                    AssertionError assertionError52 = new AssertionError();
                                    throw assertionError51;
                                } else if (!$assertionsDisabled && gLUhalfEdge6.Org == null) {
                                    AssertionError assertionError53 = assertionError5;
                                    AssertionError assertionError54 = new AssertionError();
                                    throw assertionError53;
                                } else if (!$assertionsDisabled && gLUhalfEdge6.Sym.Org == null) {
                                    AssertionError assertionError55 = assertionError4;
                                    AssertionError assertionError56 = new AssertionError();
                                    throw assertionError55;
                                } else if (!$assertionsDisabled && gLUhalfEdge6.Lnext.Onext.Sym != gLUhalfEdge6) {
                                    AssertionError assertionError57 = assertionError3;
                                    AssertionError assertionError58 = new AssertionError();
                                    throw assertionError57;
                                } else if ($assertionsDisabled || gLUhalfEdge6.Onext.Sym.Lnext == gLUhalfEdge6) {
                                    gLUhalfEdge4 = gLUhalfEdge6;
                                } else {
                                    AssertionError assertionError59 = assertionError2;
                                    AssertionError assertionError60 = new AssertionError();
                                    throw assertionError59;
                                }
                            } else if ($assertionsDisabled) {
                                return;
                            } else {
                                if (gLUhalfEdge6.Sym.next != gLUhalfEdge5.Sym || gLUhalfEdge6.Sym != gLUmesh2.eHeadSym || gLUhalfEdge6.Sym.Sym != gLUhalfEdge6 || gLUhalfEdge6.Org != null || gLUhalfEdge6.Sym.Org != null || gLUhalfEdge6.Lface != null || gLUhalfEdge6.Sym.Lface != null) {
                                    AssertionError assertionError61 = assertionError;
                                    AssertionError assertionError62 = new AssertionError();
                                    throw assertionError61;
                                }
                                return;
                            }
                        }
                    } else {
                        AssertionError assertionError63 = assertionError9;
                        AssertionError assertionError64 = new AssertionError();
                        throw assertionError63;
                    }
                }
            } else {
                AssertionError assertionError65 = assertionError16;
                AssertionError assertionError66 = new AssertionError();
                throw assertionError65;
            }
        }
    }

    static GLUhalfEdge __gl_meshConnect(GLUhalfEdge gLUhalfEdge, GLUhalfEdge gLUhalfEdge2) {
        GLUface gLUface;
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge2;
        GLUhalfEdge MakeEdge = MakeEdge(gLUhalfEdge3);
        GLUhalfEdge gLUhalfEdge5 = MakeEdge.Sym;
        boolean z = false;
        if (gLUhalfEdge4.Lface != gLUhalfEdge3.Lface) {
            z = true;
            KillFace(gLUhalfEdge4.Lface, gLUhalfEdge3.Lface);
        }
        Splice(MakeEdge, gLUhalfEdge3.Lnext);
        Splice(gLUhalfEdge5, gLUhalfEdge4);
        MakeEdge.Org = gLUhalfEdge3.Sym.Org;
        gLUhalfEdge5.Org = gLUhalfEdge4.Org;
        GLUface gLUface2 = gLUhalfEdge3.Lface;
        gLUhalfEdge5.Lface = gLUface2;
        MakeEdge.Lface = gLUface2;
        gLUhalfEdge3.Lface.anEdge = gLUhalfEdge5;
        if (!z) {
            GLUface gLUface3 = gLUface;
            GLUface gLUface4 = new GLUface();
            MakeFace(gLUface3, MakeEdge, gLUhalfEdge3.Lface);
        }
        return MakeEdge;
    }

    static boolean __gl_meshDelete(GLUhalfEdge gLUhalfEdge) {
        GLUface gLUface;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2.Sym;
        boolean z = false;
        if (gLUhalfEdge2.Lface != gLUhalfEdge2.Sym.Lface) {
            z = true;
            KillFace(gLUhalfEdge2.Lface, gLUhalfEdge2.Sym.Lface);
        }
        if (gLUhalfEdge2.Onext == gLUhalfEdge2) {
            KillVertex(gLUhalfEdge2.Org, null);
        } else {
            gLUhalfEdge2.Sym.Lface.anEdge = gLUhalfEdge2.Sym.Lnext;
            gLUhalfEdge2.Org.anEdge = gLUhalfEdge2.Onext;
            Splice(gLUhalfEdge2, gLUhalfEdge2.Sym.Lnext);
            if (!z) {
                GLUface gLUface2 = gLUface;
                GLUface gLUface3 = new GLUface();
                MakeFace(gLUface2, gLUhalfEdge2, gLUhalfEdge2.Lface);
            }
        }
        if (gLUhalfEdge3.Onext == gLUhalfEdge3) {
            KillVertex(gLUhalfEdge3.Org, null);
            KillFace(gLUhalfEdge3.Lface, null);
        } else {
            gLUhalfEdge2.Lface.anEdge = gLUhalfEdge3.Sym.Lnext;
            gLUhalfEdge3.Org.anEdge = gLUhalfEdge3.Onext;
            Splice(gLUhalfEdge3, gLUhalfEdge3.Sym.Lnext);
        }
        KillEdge(gLUhalfEdge2);
        return true;
    }

    public static void __gl_meshDeleteMesh(GLUmesh gLUmesh) {
        GLUmesh gLUmesh2 = gLUmesh;
        GLUface gLUface = gLUmesh2.fHead.next;
        while (true) {
            GLUface gLUface2 = gLUface;
            if (gLUface2 == gLUmesh2.fHead) {
                break;
            }
            gLUface = gLUface2.next;
        }
        GLUvertex gLUvertex = gLUmesh2.vHead.next;
        while (true) {
            GLUvertex gLUvertex2 = gLUvertex;
            if (gLUvertex2 == gLUmesh2.vHead) {
                break;
            }
            gLUvertex = gLUvertex2.next;
        }
        GLUhalfEdge gLUhalfEdge = gLUmesh2.eHead.next;
        while (true) {
            GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
            if (gLUhalfEdge2 != gLUmesh2.eHead) {
                gLUhalfEdge = gLUhalfEdge2.next;
            } else {
                return;
            }
        }
    }

    static void __gl_meshDeleteMeshZap(GLUmesh gLUmesh) {
        AssertionError assertionError;
        GLUmesh gLUmesh2 = gLUmesh;
        GLUface gLUface = gLUmesh2.fHead;
        while (gLUface.next != gLUface) {
            __gl_meshZapFace(gLUface.next);
        }
        if (!$assertionsDisabled && gLUmesh2.vHead.next != gLUmesh2.vHead) {
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError();
            throw assertionError2;
        }
    }

    public static GLUhalfEdge __gl_meshMakeEdge(GLUmesh gLUmesh) {
        GLUvertex gLUvertex;
        GLUvertex gLUvertex2;
        GLUface gLUface;
        GLUmesh gLUmesh2 = gLUmesh;
        GLUvertex gLUvertex3 = gLUvertex;
        GLUvertex gLUvertex4 = new GLUvertex();
        GLUvertex gLUvertex5 = gLUvertex3;
        GLUvertex gLUvertex6 = gLUvertex2;
        GLUvertex gLUvertex7 = new GLUvertex();
        GLUvertex gLUvertex8 = gLUvertex6;
        GLUface gLUface2 = gLUface;
        GLUface gLUface3 = new GLUface();
        GLUface gLUface4 = gLUface2;
        GLUhalfEdge MakeEdge = MakeEdge(gLUmesh2.eHead);
        if (MakeEdge == null) {
            return null;
        }
        MakeVertex(gLUvertex5, MakeEdge, gLUmesh2.vHead);
        MakeVertex(gLUvertex8, MakeEdge.Sym, gLUmesh2.vHead);
        MakeFace(gLUface4, MakeEdge, gLUmesh2.fHead);
        return MakeEdge;
    }

    public static GLUmesh __gl_meshNewMesh() {
        GLUmesh gLUmesh;
        GLUmesh gLUmesh2 = gLUmesh;
        GLUmesh gLUmesh3 = new GLUmesh();
        GLUmesh gLUmesh4 = gLUmesh2;
        GLUvertex gLUvertex = gLUmesh4.vHead;
        GLUface gLUface = gLUmesh4.fHead;
        GLUhalfEdge gLUhalfEdge = gLUmesh4.eHead;
        GLUhalfEdge gLUhalfEdge2 = gLUmesh4.eHeadSym;
        gLUvertex.prev = gLUvertex;
        gLUvertex.next = gLUvertex;
        gLUvertex.anEdge = null;
        gLUvertex.data = null;
        gLUface.prev = gLUface;
        gLUface.next = gLUface;
        gLUface.anEdge = null;
        gLUface.data = null;
        gLUface.trail = null;
        gLUface.marked = false;
        gLUface.inside = false;
        gLUhalfEdge.next = gLUhalfEdge;
        gLUhalfEdge.Sym = gLUhalfEdge2;
        gLUhalfEdge.Onext = null;
        gLUhalfEdge.Lnext = null;
        gLUhalfEdge.Org = null;
        gLUhalfEdge.Lface = null;
        gLUhalfEdge.winding = 0;
        gLUhalfEdge.activeRegion = null;
        gLUhalfEdge2.next = gLUhalfEdge2;
        gLUhalfEdge2.Sym = gLUhalfEdge;
        gLUhalfEdge2.Onext = null;
        gLUhalfEdge2.Lnext = null;
        gLUhalfEdge2.Org = null;
        gLUhalfEdge2.Lface = null;
        gLUhalfEdge2.winding = 0;
        gLUhalfEdge2.activeRegion = null;
        return gLUmesh4;
    }

    public static boolean __gl_meshSplice(GLUhalfEdge gLUhalfEdge, GLUhalfEdge gLUhalfEdge2) {
        GLUface gLUface;
        GLUvertex gLUvertex;
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge2;
        if (gLUhalfEdge3 != gLUhalfEdge4) {
            boolean z = false;
            if (gLUhalfEdge4.Org != gLUhalfEdge3.Org) {
                z = true;
                KillVertex(gLUhalfEdge4.Org, gLUhalfEdge3.Org);
            }
            boolean z2 = false;
            if (gLUhalfEdge4.Lface != gLUhalfEdge3.Lface) {
                z2 = true;
                KillFace(gLUhalfEdge4.Lface, gLUhalfEdge3.Lface);
            }
            Splice(gLUhalfEdge4, gLUhalfEdge3);
            if (!z) {
                GLUvertex gLUvertex2 = gLUvertex;
                GLUvertex gLUvertex3 = new GLUvertex();
                MakeVertex(gLUvertex2, gLUhalfEdge4, gLUhalfEdge3.Org);
                gLUhalfEdge3.Org.anEdge = gLUhalfEdge3;
            }
            if (!z2) {
                GLUface gLUface2 = gLUface;
                GLUface gLUface3 = new GLUface();
                MakeFace(gLUface2, gLUhalfEdge4, gLUhalfEdge3.Lface);
                gLUhalfEdge3.Lface.anEdge = gLUhalfEdge3;
                return true;
            }
        }
        return true;
    }

    public static GLUhalfEdge __gl_meshSplitEdge(GLUhalfEdge gLUhalfEdge) {
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge3 = __gl_meshAddEdgeVertex(gLUhalfEdge2).Sym;
        Splice(gLUhalfEdge2.Sym, gLUhalfEdge2.Sym.Sym.Lnext);
        Splice(gLUhalfEdge2.Sym, gLUhalfEdge3);
        gLUhalfEdge2.Sym.Org = gLUhalfEdge3.Org;
        gLUhalfEdge3.Sym.Org.anEdge = gLUhalfEdge3.Sym;
        gLUhalfEdge3.Sym.Lface = gLUhalfEdge2.Sym.Lface;
        gLUhalfEdge3.winding = gLUhalfEdge2.winding;
        gLUhalfEdge3.Sym.winding = gLUhalfEdge2.Sym.winding;
        return gLUhalfEdge3;
    }

    static GLUmesh __gl_meshUnion(GLUmesh gLUmesh, GLUmesh gLUmesh2) {
        GLUmesh gLUmesh3 = gLUmesh;
        GLUmesh gLUmesh4 = gLUmesh2;
        GLUface gLUface = gLUmesh3.fHead;
        GLUvertex gLUvertex = gLUmesh3.vHead;
        GLUhalfEdge gLUhalfEdge = gLUmesh3.eHead;
        GLUface gLUface2 = gLUmesh4.fHead;
        GLUvertex gLUvertex2 = gLUmesh4.vHead;
        GLUhalfEdge gLUhalfEdge2 = gLUmesh4.eHead;
        if (gLUface2.next != gLUface2) {
            gLUface.prev.next = gLUface2.next;
            gLUface2.next.prev = gLUface.prev;
            gLUface2.prev.next = gLUface;
            gLUface.prev = gLUface2.prev;
        }
        if (gLUvertex2.next != gLUvertex2) {
            gLUvertex.prev.next = gLUvertex2.next;
            gLUvertex2.next.prev = gLUvertex.prev;
            gLUvertex2.prev.next = gLUvertex;
            gLUvertex.prev = gLUvertex2.prev;
        }
        if (gLUhalfEdge2.next != gLUhalfEdge2) {
            gLUhalfEdge.Sym.next.Sym.next = gLUhalfEdge2.next;
            gLUhalfEdge2.next.Sym.next = gLUhalfEdge.Sym.next;
            gLUhalfEdge2.Sym.next.Sym.next = gLUhalfEdge;
            gLUhalfEdge.Sym.next = gLUhalfEdge2.Sym.next;
        }
        return gLUmesh3;
    }

    static void __gl_meshZapFace(GLUface gLUface) {
        GLUhalfEdge gLUhalfEdge;
        GLUface gLUface2 = gLUface;
        GLUhalfEdge gLUhalfEdge2 = gLUface2.anEdge;
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2.Lnext;
        do {
            gLUhalfEdge = gLUhalfEdge3;
            gLUhalfEdge3 = gLUhalfEdge.Lnext;
            gLUhalfEdge.Lface = null;
            if (gLUhalfEdge.Sym.Lface == null) {
                if (gLUhalfEdge.Onext == gLUhalfEdge) {
                    KillVertex(gLUhalfEdge.Org, null);
                } else {
                    gLUhalfEdge.Org.anEdge = gLUhalfEdge.Onext;
                    Splice(gLUhalfEdge, gLUhalfEdge.Sym.Lnext);
                }
                GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge.Sym;
                if (gLUhalfEdge4.Onext == gLUhalfEdge4) {
                    KillVertex(gLUhalfEdge4.Org, null);
                } else {
                    gLUhalfEdge4.Org.anEdge = gLUhalfEdge4.Onext;
                    Splice(gLUhalfEdge4, gLUhalfEdge4.Sym.Lnext);
                }
                KillEdge(gLUhalfEdge);
            }
        } while (gLUhalfEdge != gLUhalfEdge2);
        GLUface gLUface3 = gLUface2.prev;
        GLUface gLUface4 = gLUface2.next;
        gLUface4.prev = gLUface3;
        gLUface3.next = gLUface4;
    }
}
