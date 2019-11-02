package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalList */
public final class LocalList extends FixedSizeList {
    private static final boolean DEBUG = false;
    public static final LocalList EMPTY;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalList$Disposition */
    public enum Disposition {
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalList$Entry */
    public static class Entry implements Comparable<Entry> {
        private final int address;
        private final Disposition disposition;
        private final RegisterSpec spec;
        private final CstType type;

        public Entry(int i, Disposition disposition2, RegisterSpec registerSpec) {
            NullPointerException nullPointerException;
            NullPointerException nullPointerException2;
            NullPointerException nullPointerException3;
            IllegalArgumentException illegalArgumentException;
            int i2 = i;
            Disposition disposition3 = disposition2;
            RegisterSpec registerSpec2 = registerSpec;
            if (i2 < 0) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("address < 0");
                throw illegalArgumentException2;
            } else if (disposition3 == null) {
                NullPointerException nullPointerException4 = nullPointerException3;
                NullPointerException nullPointerException5 = new NullPointerException("disposition == null");
                throw nullPointerException4;
            } else {
                try {
                    if (registerSpec2.getLocalItem() == null) {
                        NullPointerException nullPointerException6 = nullPointerException2;
                        NullPointerException nullPointerException7 = new NullPointerException("spec.getLocalItem() == null");
                        throw nullPointerException6;
                    }
                    this.address = i2;
                    this.disposition = disposition3;
                    this.spec = registerSpec2;
                    this.type = CstType.intern(registerSpec2.getType());
                } catch (NullPointerException e) {
                    NullPointerException nullPointerException8 = e;
                    NullPointerException nullPointerException9 = nullPointerException;
                    NullPointerException nullPointerException10 = new NullPointerException("spec == null");
                    throw nullPointerException9;
                }
            }
        }

        public int compareTo(Entry entry) {
            Entry entry2 = entry;
            int i = 1;
            if (this.address < entry2.address) {
                i = -1;
            } else if (this.address <= entry2.address) {
                boolean isStart = isStart();
                if (isStart == entry2.isStart()) {
                    return this.spec.compareTo(entry2.spec);
                }
                if (!isStart) {
                    return -1;
                }
            }
            return i;
        }

        public boolean equals(Object obj) {
            Object obj2 = obj;
            return (obj2 instanceof Entry) && compareTo((Entry) obj2) == 0;
        }

        public int getAddress() {
            return this.address;
        }

        public Disposition getDisposition() {
            return this.disposition;
        }

        public CstString getName() {
            return this.spec.getLocalItem().getName();
        }

        public int getRegister() {
            return this.spec.getReg();
        }

        public RegisterSpec getRegisterSpec() {
            return this.spec;
        }

        public CstString getSignature() {
            return this.spec.getLocalItem().getSignature();
        }

        public CstType getType() {
            return this.type;
        }

        public boolean isStart() {
            return this.disposition == Disposition.START;
        }

        public boolean matches(Entry entry) {
            return matches(entry.spec);
        }

        public boolean matches(RegisterSpec registerSpec) {
            return this.spec.equalsUsingSimpleType(registerSpec);
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append(Integer.toHexString(this.address)).append(" ").append(this.disposition).append(" ").append(this.spec).toString();
        }

        public Entry withDisposition(Disposition disposition2) {
            Entry entry;
            Disposition disposition3 = disposition2;
            if (disposition3 == this.disposition) {
                return this;
            }
            Entry entry2 = entry;
            Entry entry3 = new Entry(this.address, disposition3, this.spec);
            return entry2;
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalList$MakeState */
    public static class MakeState {
        private int[] endIndices = null;
        private int lastAddress = 0;
        private int nullResultCount = 0;
        private RegisterSpecSet regs = null;
        private final ArrayList<Entry> result;

        public MakeState(int i) {
            ArrayList<Entry> arrayList;
            ArrayList<Entry> arrayList2 = arrayList;
            ArrayList<Entry> arrayList3 = new ArrayList<>(i);
            this.result = arrayList2;
        }

        private void aboutToProcess(int i, int i2) {
            RegisterSpecSet registerSpecSet;
            RuntimeException runtimeException;
            int i3 = i;
            int i4 = i2;
            boolean z = this.endIndices == null;
            if (i3 == this.lastAddress && !z) {
                return;
            }
            if (i3 < this.lastAddress) {
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("shouldn't happen");
                throw runtimeException2;
            } else if (z || i4 >= this.endIndices.length) {
                int i5 = i4 + 1;
                RegisterSpecSet registerSpecSet2 = registerSpecSet;
                RegisterSpecSet registerSpecSet3 = new RegisterSpecSet(i5);
                RegisterSpecSet registerSpecSet4 = registerSpecSet2;
                int[] iArr = new int[i5];
                Arrays.fill(iArr, -1);
                if (!z) {
                    registerSpecSet4.putAll(this.regs);
                    System.arraycopy(this.endIndices, 0, iArr, 0, this.endIndices.length);
                }
                this.regs = registerSpecSet4;
                this.endIndices = iArr;
            }
        }

        private void add(int i, Disposition disposition, RegisterSpec registerSpec) {
            Entry entry;
            int i2 = i;
            Disposition disposition2 = disposition;
            RegisterSpec registerSpec2 = registerSpec;
            int reg = registerSpec2.getReg();
            ArrayList<Entry> arrayList = this.result;
            Entry entry2 = entry;
            Entry entry3 = new Entry(i2, disposition2, registerSpec2);
            boolean add = arrayList.add(entry2);
            if (disposition2 == Disposition.START) {
                this.regs.put(registerSpec2);
                this.endIndices[reg] = -1;
                return;
            }
            this.regs.remove(registerSpec2);
            this.endIndices[reg] = -1 + this.result.size();
        }

        private void addOrUpdateEnd(int i, Disposition disposition, RegisterSpec registerSpec) {
            RuntimeException runtimeException;
            int i2 = i;
            Disposition disposition2 = disposition;
            RegisterSpec registerSpec2 = registerSpec;
            if (disposition2 == Disposition.START) {
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("shouldn't happen");
                throw runtimeException2;
            }
            int i3 = this.endIndices[registerSpec2.getReg()];
            if (i3 >= 0) {
                Entry entry = (Entry) this.result.get(i3);
                if (entry.getAddress() == i2 && entry.getRegisterSpec().equals(registerSpec2)) {
                    Object obj = this.result.set(i3, entry.withDisposition(disposition2));
                    this.regs.remove(registerSpec2);
                    return;
                }
            }
            endLocal(i2, registerSpec2, disposition2);
        }

        private boolean checkForEmptyRange(int i, RegisterSpec registerSpec) {
            boolean z;
            int i2 = i;
            RegisterSpec registerSpec2 = registerSpec;
            int size = -1 + this.result.size();
            while (size >= 0) {
                Entry entry = (Entry) this.result.get(size);
                if (entry != null) {
                    if (entry.getAddress() != i2) {
                        return false;
                    }
                    if (entry.matches(registerSpec2)) {
                        break;
                    }
                }
                size--;
            }
            this.regs.remove(registerSpec2);
            Object obj = this.result.set(size, null);
            this.nullResultCount = 1 + this.nullResultCount;
            int reg = registerSpec2.getReg();
            int i3 = size - 1;
            Entry entry2 = null;
            while (true) {
                z = false;
                if (i3 < 0) {
                    break;
                }
                entry2 = (Entry) this.result.get(i3);
                if (entry2 != null && entry2.getRegisterSpec().getReg() == reg) {
                    z = true;
                    break;
                }
                i3--;
            }
            if (z) {
                this.endIndices[reg] = i3;
                if (entry2.getAddress() == i2) {
                    Object obj2 = this.result.set(i3, entry2.withDisposition(Disposition.END_SIMPLY));
                }
            }
            return true;
        }

        private static RegisterSpec filterSpec(RegisterSpec registerSpec) {
            RegisterSpec registerSpec2 = registerSpec;
            if (registerSpec2 != null && registerSpec2.getType() == Type.KNOWN_NULL) {
                registerSpec2 = registerSpec2.withType(Type.OBJECT);
            }
            return registerSpec2;
        }

        public void endLocal(int i, RegisterSpec registerSpec) {
            endLocal(i, registerSpec, Disposition.END_SIMPLY);
        }

        public void endLocal(int i, RegisterSpec registerSpec, Disposition disposition) {
            int i2 = i;
            RegisterSpec registerSpec2 = registerSpec;
            Disposition disposition2 = disposition;
            int reg = registerSpec2.getReg();
            RegisterSpec filterSpec = filterSpec(registerSpec2);
            aboutToProcess(i2, reg);
            if (this.endIndices[reg] < 0 && !checkForEmptyRange(i2, filterSpec)) {
                add(i2, disposition2, filterSpec);
            }
        }

        public LocalList finish() {
            int i;
            LocalList localList;
            aboutToProcess(IDirectInputDevice.DIPROPRANGE_NOMAX, 0);
            int size = this.result.size();
            int i2 = size - this.nullResultCount;
            if (i2 == 0) {
                return LocalList.EMPTY;
            }
            Entry[] entryArr = new Entry[i2];
            if (size != i2) {
                Iterator it = this.result.iterator();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (!it.hasNext()) {
                        break;
                    }
                    Entry entry = (Entry) it.next();
                    if (entry != null) {
                        int i5 = i4 + 1;
                        entryArr[i4] = entry;
                        i = i5;
                    } else {
                        i = i4;
                    }
                    i3 = i;
                }
            } else {
                Object[] array = this.result.toArray(entryArr);
            }
            Arrays.sort(entryArr);
            LocalList localList2 = localList;
            LocalList localList3 = new LocalList(i2);
            LocalList localList4 = localList2;
            for (int i6 = 0; i6 < i2; i6++) {
                localList4.set(i6, entryArr[i6]);
            }
            localList4.setImmutable();
            return localList4;
        }

        public void snapshot(int i, RegisterSpecSet registerSpecSet) {
            int i2 = i;
            RegisterSpecSet registerSpecSet2 = registerSpecSet;
            int maxSize = registerSpecSet2.getMaxSize();
            aboutToProcess(i2, maxSize - 1);
            for (int i3 = 0; i3 < maxSize; i3++) {
                RegisterSpec registerSpec = this.regs.get(i3);
                RegisterSpec filterSpec = filterSpec(registerSpecSet2.get(i3));
                if (registerSpec == null) {
                    if (filterSpec != null) {
                        startLocal(i2, filterSpec);
                    }
                } else if (filterSpec == null) {
                    endLocal(i2, registerSpec);
                } else if (!filterSpec.equalsUsingSimpleType(registerSpec)) {
                    endLocal(i2, registerSpec);
                    startLocal(i2, filterSpec);
                }
            }
        }

        public void startLocal(int i, RegisterSpec registerSpec) {
            int i2 = i;
            RegisterSpec registerSpec2 = registerSpec;
            int reg = registerSpec2.getReg();
            RegisterSpec filterSpec = filterSpec(registerSpec2);
            aboutToProcess(i2, reg);
            RegisterSpec registerSpec3 = this.regs.get(reg);
            if (!filterSpec.equalsUsingSimpleType(registerSpec3)) {
                RegisterSpec findMatchingLocal = this.regs.findMatchingLocal(filterSpec);
                if (findMatchingLocal != null) {
                    addOrUpdateEnd(i2, Disposition.END_MOVED, findMatchingLocal);
                }
                int i3 = this.endIndices[reg];
                if (registerSpec3 != null) {
                    add(i2, Disposition.END_REPLACED, registerSpec3);
                } else if (i3 >= 0) {
                    Entry entry = (Entry) this.result.get(i3);
                    if (entry.getAddress() == i2) {
                        if (entry.matches(filterSpec)) {
                            Object obj = this.result.set(i3, null);
                            this.nullResultCount = 1 + this.nullResultCount;
                            this.regs.put(filterSpec);
                            this.endIndices[reg] = -1;
                            return;
                        }
                        Object obj2 = this.result.set(i3, entry.withDisposition(Disposition.END_REPLACED));
                    }
                }
                if (reg > 0) {
                    RegisterSpec registerSpec4 = this.regs.get(reg - 1);
                    if (registerSpec4 != null && registerSpec4.isCategory2()) {
                        addOrUpdateEnd(i2, Disposition.END_CLOBBERED_BY_NEXT, registerSpec4);
                    }
                }
                if (filterSpec.isCategory2()) {
                    RegisterSpec registerSpec5 = this.regs.get(reg + 1);
                    if (registerSpec5 != null) {
                        addOrUpdateEnd(i2, Disposition.END_CLOBBERED_BY_PREV, registerSpec5);
                    }
                }
                add(i2, Disposition.START, filterSpec);
            }
        }
    }

    static {
        LocalList localList;
        LocalList localList2 = localList;
        LocalList localList3 = new LocalList(0);
        EMPTY = localList2;
    }

    public LocalList(int i) {
        super(i);
    }

    private static void debugVerify(LocalList localList) {
        LocalList localList2 = localList;
        try {
            debugVerify0(localList2);
        } catch (RuntimeException e) {
            RuntimeException runtimeException = e;
            int size = localList2.size();
            for (int i = 0; i < size; i++) {
                System.err.println(localList2.get(i));
            }
            throw runtimeException;
        }
    }

    private static void debugVerify0(LocalList localList) {
        RuntimeException runtimeException;
        StringBuilder sb;
        RuntimeException runtimeException2;
        StringBuilder sb2;
        RuntimeException runtimeException3;
        StringBuilder sb3;
        RuntimeException runtimeException4;
        StringBuilder sb4;
        RuntimeException runtimeException5;
        StringBuilder sb5;
        LocalList localList2 = localList;
        int size = localList2.size();
        Entry[] entryArr = new Entry[65536];
        for (int i = 0; i < size; i++) {
            Entry entry = localList2.get(i);
            int register = entry.getRegister();
            if (entry.isStart()) {
                Entry entry2 = entryArr[register];
                if (entry2 == null || !entry.matches(entry2)) {
                    entryArr[register] = entry;
                } else {
                    RuntimeException runtimeException6 = runtimeException5;
                    StringBuilder sb6 = sb5;
                    StringBuilder sb7 = new StringBuilder();
                    RuntimeException runtimeException7 = new RuntimeException(sb6.append("redundant start at ").append(Integer.toHexString(entry.getAddress())).append(": got ").append(entry).append("; had ").append(entry2).toString());
                    throw runtimeException6;
                }
            } else if (entryArr[register] == null) {
                RuntimeException runtimeException8 = runtimeException;
                StringBuilder sb8 = sb;
                StringBuilder sb9 = new StringBuilder();
                RuntimeException runtimeException9 = new RuntimeException(sb8.append("redundant end at ").append(Integer.toHexString(entry.getAddress())).toString());
                throw runtimeException8;
            } else {
                int address = entry.getAddress();
                boolean z = false;
                for (int i2 = i + 1; i2 < size; i2++) {
                    Entry entry3 = localList2.get(i2);
                    if (entry3.getAddress() != address) {
                        break;
                    }
                    if (entry3.getRegisterSpec().getReg() == register) {
                        if (!entry3.isStart()) {
                            RuntimeException runtimeException10 = runtimeException3;
                            StringBuilder sb10 = sb3;
                            StringBuilder sb11 = new StringBuilder();
                            RuntimeException runtimeException11 = new RuntimeException(sb10.append("redundant end at ").append(Integer.toHexString(address)).toString());
                            throw runtimeException10;
                        } else if (entry.getDisposition() != Disposition.END_REPLACED) {
                            RuntimeException runtimeException12 = runtimeException4;
                            StringBuilder sb12 = sb4;
                            StringBuilder sb13 = new StringBuilder();
                            RuntimeException runtimeException13 = new RuntimeException(sb12.append("improperly marked end at ").append(Integer.toHexString(address)).toString());
                            throw runtimeException12;
                        } else {
                            z = true;
                        }
                    }
                }
                if (z || entry.getDisposition() != Disposition.END_REPLACED) {
                    entryArr[register] = null;
                } else {
                    RuntimeException runtimeException14 = runtimeException2;
                    StringBuilder sb14 = sb2;
                    StringBuilder sb15 = new StringBuilder();
                    RuntimeException runtimeException15 = new RuntimeException(sb14.append("improper end replacement claim at ").append(Integer.toHexString(address)).toString());
                    throw runtimeException14;
                }
            }
        }
    }

    public static LocalList make(DalvInsnList dalvInsnList) {
        MakeState makeState;
        DalvInsnList dalvInsnList2 = dalvInsnList;
        int size = dalvInsnList2.size();
        MakeState makeState2 = makeState;
        MakeState makeState3 = new MakeState(size);
        MakeState makeState4 = makeState2;
        for (int i = 0; i < size; i++) {
            DalvInsn dalvInsn = dalvInsnList2.get(i);
            if (dalvInsn instanceof LocalSnapshot) {
                makeState4.snapshot(dalvInsn.getAddress(), ((LocalSnapshot) dalvInsn).getLocals());
            } else if (dalvInsn instanceof LocalStart) {
                makeState4.startLocal(dalvInsn.getAddress(), ((LocalStart) dalvInsn).getLocal());
            } else if (dalvInsn instanceof LocalEnd) {
                makeState4.endLocal(dalvInsn.getAddress(), ((LocalEnd) dalvInsn).getLocal());
            }
        }
        return makeState4.finish();
    }

    public void debugPrint(PrintStream printStream, String str) {
        PrintStream printStream2 = printStream;
        String str2 = str;
        int size = size();
        for (int i = 0; i < size; i++) {
            printStream2.print(str2);
            printStream2.println(get(i));
        }
    }

    public Entry get(int i) {
        return (Entry) get0(i);
    }

    public void set(int i, Entry entry) {
        set0(i, entry);
    }
}
