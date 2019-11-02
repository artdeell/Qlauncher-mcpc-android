package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.DexOptions;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.OutputCollector */
public final class OutputCollector {
    private final OutputFinisher finisher;
    private ArrayList<DalvInsn> suffix;

    public OutputCollector(DexOptions dexOptions, int i, int i2, int i3) {
        OutputFinisher outputFinisher;
        ArrayList<DalvInsn> arrayList;
        int i4 = i2;
        OutputFinisher outputFinisher2 = outputFinisher;
        OutputFinisher outputFinisher3 = new OutputFinisher(dexOptions, i, i3);
        this.finisher = outputFinisher2;
        ArrayList<DalvInsn> arrayList2 = arrayList;
        ArrayList<DalvInsn> arrayList3 = new ArrayList<>(i4);
        this.suffix = arrayList2;
    }

    private void appendSuffixToOutput() {
        int size = this.suffix.size();
        for (int i = 0; i < size; i++) {
            this.finisher.add((DalvInsn) this.suffix.get(i));
        }
        this.suffix = null;
    }

    public void add(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        this.finisher.add(dalvInsn2);
    }

    public void addSuffix(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        boolean add = this.suffix.add(dalvInsn2);
    }

    public OutputFinisher getFinisher() {
        UnsupportedOperationException unsupportedOperationException;
        if (this.suffix == null) {
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("already processed");
            throw unsupportedOperationException2;
        }
        appendSuffixToOutput();
        return this.finisher;
    }

    public void reverseBranch(int i, CodeAddress codeAddress) {
        int i2 = i;
        CodeAddress codeAddress2 = codeAddress;
        this.finisher.reverseBranch(i2, codeAddress2);
    }
}
