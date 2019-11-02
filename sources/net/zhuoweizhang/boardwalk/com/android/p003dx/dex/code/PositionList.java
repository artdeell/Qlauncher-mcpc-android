package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.PositionList */
public final class PositionList extends FixedSizeList {
    public static final PositionList EMPTY;
    public static final int IMPORTANT = 3;
    public static final int LINES = 2;
    public static final int NONE = 1;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.PositionList$Entry */
    public static class Entry {
        private final int address;
        private final SourcePosition position;

        public Entry(int i, SourcePosition sourcePosition) {
            NullPointerException nullPointerException;
            IllegalArgumentException illegalArgumentException;
            int i2 = i;
            SourcePosition sourcePosition2 = sourcePosition;
            if (i2 < 0) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("address < 0");
                throw illegalArgumentException2;
            } else if (sourcePosition2 == null) {
                NullPointerException nullPointerException2 = nullPointerException;
                NullPointerException nullPointerException3 = new NullPointerException("position == null");
                throw nullPointerException2;
            } else {
                this.address = i2;
                this.position = sourcePosition2;
            }
        }

        public int getAddress() {
            return this.address;
        }

        public SourcePosition getPosition() {
            return this.position;
        }
    }

    static {
        PositionList positionList;
        PositionList positionList2 = positionList;
        PositionList positionList3 = new PositionList(0);
        EMPTY = positionList2;
    }

    public PositionList(int i) {
        super(i);
    }

    public static PositionList make(DalvInsnList dalvInsnList, int i) {
        PositionList positionList;
        Entry entry;
        IllegalArgumentException illegalArgumentException;
        DalvInsnList dalvInsnList2 = dalvInsnList;
        int i2 = i;
        switch (i2) {
            case 1:
                return EMPTY;
            case 2:
            case 3:
                SourcePosition sourcePosition = SourcePosition.NO_INFO;
                int size = dalvInsnList2.size();
                Entry[] entryArr = new Entry[size];
                int i3 = 0;
                boolean z = false;
                SourcePosition sourcePosition2 = sourcePosition;
                for (int i4 = 0; i4 < size; i4++) {
                    DalvInsn dalvInsn = dalvInsnList2.get(i4);
                    if (dalvInsn instanceof CodeAddress) {
                        z = true;
                    } else {
                        SourcePosition position = dalvInsn.getPosition();
                        if (!position.equals(sourcePosition) && !position.sameLine(sourcePosition2) && (i2 != 3 || z)) {
                            Entry[] entryArr2 = entryArr;
                            int i5 = i3;
                            Entry entry2 = entry;
                            Entry entry3 = new Entry(dalvInsn.getAddress(), position);
                            entryArr2[i5] = entry2;
                            i3++;
                            sourcePosition2 = position;
                            z = false;
                        }
                    }
                }
                PositionList positionList2 = positionList;
                PositionList positionList3 = new PositionList(i3);
                PositionList positionList4 = positionList2;
                for (int i6 = 0; i6 < i3; i6++) {
                    positionList4.set(i6, entryArr[i6]);
                }
                positionList4.setImmutable();
                return positionList4;
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bogus howMuch");
                throw illegalArgumentException2;
        }
    }

    public Entry get(int i) {
        return (Entry) get0(i);
    }

    public void set(int i, Entry entry) {
        set0(i, entry);
    }
}
