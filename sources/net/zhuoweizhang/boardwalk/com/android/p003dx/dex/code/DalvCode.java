package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import java.util.HashSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.DalvCode */
public final class DalvCode {
    private CatchTable catches;
    private DalvInsnList insns;
    private LocalList locals;
    private final int positionInfo;
    private PositionList positions;
    private CatchBuilder unprocessedCatches;
    private OutputFinisher unprocessedInsns;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.DalvCode$AssignIndicesCallback */
    public interface AssignIndicesCallback {
        int getIndex(Constant constant);
    }

    public DalvCode(int i, OutputFinisher outputFinisher, CatchBuilder catchBuilder) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        int i2 = i;
        OutputFinisher outputFinisher2 = outputFinisher;
        CatchBuilder catchBuilder2 = catchBuilder;
        if (outputFinisher2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("unprocessedInsns == null");
            throw nullPointerException3;
        } else if (catchBuilder2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("unprocessedCatches == null");
            throw nullPointerException5;
        } else {
            this.positionInfo = i2;
            this.unprocessedInsns = outputFinisher2;
            this.unprocessedCatches = catchBuilder2;
            this.catches = null;
            this.positions = null;
            this.locals = null;
            this.insns = null;
        }
    }

    private void finishProcessingIfNecessary() {
        if (this.insns == null) {
            this.insns = this.unprocessedInsns.finishProcessingAndGetList();
            this.positions = PositionList.make(this.insns, this.positionInfo);
            this.locals = LocalList.make(this.insns);
            this.catches = this.unprocessedCatches.build();
            this.unprocessedInsns = null;
            this.unprocessedCatches = null;
        }
    }

    public void assignIndices(AssignIndicesCallback assignIndicesCallback) {
        AssignIndicesCallback assignIndicesCallback2 = assignIndicesCallback;
        this.unprocessedInsns.assignIndices(assignIndicesCallback2);
    }

    public HashSet<Type> getCatchTypes() {
        return this.unprocessedCatches.getCatchTypes();
    }

    public CatchTable getCatches() {
        finishProcessingIfNecessary();
        return this.catches;
    }

    public HashSet<Constant> getInsnConstants() {
        return this.unprocessedInsns.getAllConstants();
    }

    public DalvInsnList getInsns() {
        finishProcessingIfNecessary();
        return this.insns;
    }

    public LocalList getLocals() {
        finishProcessingIfNecessary();
        return this.locals;
    }

    public PositionList getPositions() {
        finishProcessingIfNecessary();
        return this.positions;
    }

    public boolean hasAnyCatches() {
        return this.unprocessedCatches.hasAnyCatches();
    }

    public boolean hasLocals() {
        return this.unprocessedInsns.hasAnyLocalInfo();
    }

    public boolean hasPositions() {
        return this.positionInfo != 1 && this.unprocessedInsns.hasAnyPositionInfo();
    }
}
