package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.CatchHandlerList */
public final class CatchHandlerList extends FixedSizeList implements Comparable<CatchHandlerList> {
    public static final CatchHandlerList EMPTY;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.CatchHandlerList$Entry */
    public static class Entry implements Comparable<Entry> {
        private final CstType exceptionType;
        private final int handler;

        public Entry(CstType cstType, int i) {
            NullPointerException nullPointerException;
            IllegalArgumentException illegalArgumentException;
            CstType cstType2 = cstType;
            int i2 = i;
            if (i2 < 0) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("handler < 0");
                throw illegalArgumentException2;
            } else if (cstType2 == null) {
                NullPointerException nullPointerException2 = nullPointerException;
                NullPointerException nullPointerException3 = new NullPointerException("exceptionType == null");
                throw nullPointerException2;
            } else {
                this.handler = i2;
                this.exceptionType = cstType2;
            }
        }

        public int compareTo(Entry entry) {
            Entry entry2 = entry;
            if (this.handler < entry2.handler) {
                return -1;
            }
            if (this.handler > entry2.handler) {
                return 1;
            }
            return this.exceptionType.compareTo((Constant) entry2.exceptionType);
        }

        public boolean equals(Object obj) {
            Object obj2 = obj;
            boolean z = false;
            if (obj2 instanceof Entry) {
                z = false;
                if (compareTo((Entry) obj2) == 0) {
                    z = true;
                }
            }
            return z;
        }

        public CstType getExceptionType() {
            return this.exceptionType;
        }

        public int getHandler() {
            return this.handler;
        }

        public int hashCode() {
            return (31 * this.handler) + this.exceptionType.hashCode();
        }
    }

    static {
        CatchHandlerList catchHandlerList;
        CatchHandlerList catchHandlerList2 = catchHandlerList;
        CatchHandlerList catchHandlerList3 = new CatchHandlerList(0);
        EMPTY = catchHandlerList2;
    }

    public CatchHandlerList(int i) {
        super(i);
    }

    public boolean catchesAll() {
        int size = size();
        if (size == 0) {
            return false;
        }
        return get(size - 1).getExceptionType().equals(CstType.OBJECT);
    }

    public int compareTo(CatchHandlerList catchHandlerList) {
        CatchHandlerList catchHandlerList2 = catchHandlerList;
        if (this != catchHandlerList2) {
            int size = size();
            int size2 = catchHandlerList2.size();
            int min = Math.min(size, size2);
            for (int i = 0; i < min; i++) {
                int compareTo = get(i).compareTo(catchHandlerList2.get(i));
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            if (size < size2) {
                return -1;
            }
            if (size > size2) {
                return 1;
            }
        }
        return 0;
    }

    public Entry get(int i) {
        return (Entry) get0(i);
    }

    public void set(int i, Entry entry) {
        set0(i, entry);
    }

    public void set(int i, CstType cstType, int i2) {
        Entry entry;
        int i3 = i;
        Entry entry2 = entry;
        Entry entry3 = new Entry(cstType, i2);
        set0(i3, entry2);
    }

    public String toHuman() {
        return toHuman(LibrariesRepository.MOJANG_MAVEN_REPO, LibrariesRepository.MOJANG_MAVEN_REPO);
    }

    public String toHuman(String str, String str2) {
        StringBuilder sb;
        String str3 = str;
        String str4 = str2;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(100);
        StringBuilder sb4 = sb2;
        int size = size();
        StringBuilder append = sb4.append(str3);
        StringBuilder append2 = sb4.append(str4);
        StringBuilder append3 = sb4.append("catch ");
        for (int i = 0; i < size; i++) {
            Entry entry = get(i);
            if (i != 0) {
                StringBuilder append4 = sb4.append(",\n");
                StringBuilder append5 = sb4.append(str3);
                StringBuilder append6 = sb4.append("  ");
            }
            if (i != size - 1 || !catchesAll()) {
                StringBuilder append7 = sb4.append(entry.getExceptionType().toHuman());
            } else {
                StringBuilder append8 = sb4.append("<any>");
            }
            StringBuilder append9 = sb4.append(" -> ");
            StringBuilder append10 = sb4.append(Hex.u2or4(entry.getHandler()));
        }
        return sb4.toString();
    }
}
