package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.BitIntSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ListIntSet;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.SetFactory */
public final class SetFactory {
    private static final int DOMFRONT_SET_THRESHOLD_SIZE = 3072;
    private static final int INTERFERENCE_SET_THRESHOLD_SIZE = 3072;
    private static final int LIVENESS_SET_THRESHOLD_SIZE = 3072;

    public SetFactory() {
    }

    static IntSet makeDomFrontSet(int i) {
        ListIntSet listIntSet;
        BitIntSet bitIntSet;
        int i2 = i;
        if (i2 <= 3072) {
            BitIntSet bitIntSet2 = bitIntSet;
            BitIntSet bitIntSet3 = new BitIntSet(i2);
            return bitIntSet2;
        }
        ListIntSet listIntSet2 = listIntSet;
        ListIntSet listIntSet3 = new ListIntSet();
        return listIntSet2;
    }

    public static IntSet makeInterferenceSet(int i) {
        ListIntSet listIntSet;
        BitIntSet bitIntSet;
        int i2 = i;
        if (i2 <= 3072) {
            BitIntSet bitIntSet2 = bitIntSet;
            BitIntSet bitIntSet3 = new BitIntSet(i2);
            return bitIntSet2;
        }
        ListIntSet listIntSet2 = listIntSet;
        ListIntSet listIntSet3 = new ListIntSet();
        return listIntSet2;
    }

    static IntSet makeLivenessSet(int i) {
        ListIntSet listIntSet;
        BitIntSet bitIntSet;
        int i2 = i;
        if (i2 <= 3072) {
            BitIntSet bitIntSet2 = bitIntSet;
            BitIntSet bitIntSet3 = new BitIntSet(i2);
            return bitIntSet2;
        }
        ListIntSet listIntSet2 = listIntSet;
        ListIntSet listIntSet3 = new ListIntSet();
        return listIntSet2;
    }
}
