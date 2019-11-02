package net.zhuoweizhang.boardwalk.com.android.p003dx.merge;

import java.util.Comparator;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassDef;
import net.zhuoweizhang.boardwalk.com.android.dex.Dex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.merge.SortableType */
final class SortableType {
    public static final Comparator<SortableType> NULLS_LAST_ORDER;
    private ClassDef classDef;
    /* access modifiers changed from: private */
    public int depth = -1;
    private final Dex dex;

    static {
        C07121 r2;
        C07121 r0 = r2;
        C07121 r1 = new Comparator<SortableType>() {
            public int compare(SortableType sortableType, SortableType sortableType2) {
                SortableType sortableType3 = sortableType;
                SortableType sortableType4 = sortableType2;
                if (sortableType3 == sortableType4) {
                    return 0;
                }
                if (sortableType4 == null) {
                    return -1;
                }
                if (sortableType3 == null) {
                    return 1;
                }
                return sortableType3.depth != sortableType4.depth ? sortableType3.depth - sortableType4.depth : sortableType3.getTypeIndex() - sortableType4.getTypeIndex();
            }
        };
        NULLS_LAST_ORDER = r0;
    }

    public SortableType(Dex dex2, ClassDef classDef2) {
        Dex dex3 = dex2;
        ClassDef classDef3 = classDef2;
        this.dex = dex3;
        this.classDef = classDef3;
    }

    public ClassDef getClassDef() {
        return this.classDef;
    }

    public Dex getDex() {
        return this.dex;
    }

    public int getTypeIndex() {
        return this.classDef.getTypeIndex();
    }

    public boolean isDepthAssigned() {
        return this.depth != -1;
    }

    public boolean tryAssignDepth(SortableType[] sortableTypeArr) {
        int i;
        int max;
        SortableType[] sortableTypeArr2 = sortableTypeArr;
        if (this.classDef.getSupertypeIndex() == -1) {
            i = 0;
        } else {
            SortableType sortableType = sortableTypeArr2[this.classDef.getSupertypeIndex()];
            if (sortableType == null) {
                i = 1;
            } else {
                if (sortableType.depth != -1) {
                    i = sortableType.depth;
                }
                return false;
            }
        }
        short[] interfaces = this.classDef.getInterfaces();
        int length = interfaces.length;
        for (int i2 = 0; i2 < length; i2++) {
            SortableType sortableType2 = sortableTypeArr2[interfaces[i2]];
            if (sortableType2 == null) {
                max = Math.max(i, 1);
            } else if (sortableType2.depth == -1) {
                return false;
            } else {
                max = Math.max(i, sortableType2.depth);
            }
            i = max;
        }
        this.depth = i + 1;
        return true;
    }
}
