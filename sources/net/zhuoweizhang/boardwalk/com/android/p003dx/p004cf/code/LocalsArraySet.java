package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import java.util.ArrayList;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.LocalsArraySet */
public class LocalsArraySet extends LocalsArray {
    private final OneLocalsArray primary;
    private final ArrayList<LocalsArray> secondaries;

    public LocalsArraySet(int i) {
        OneLocalsArray oneLocalsArray;
        ArrayList<LocalsArray> arrayList;
        int i2 = i;
        super(i2 != 0);
        OneLocalsArray oneLocalsArray2 = oneLocalsArray;
        OneLocalsArray oneLocalsArray3 = new OneLocalsArray(i2);
        this.primary = oneLocalsArray2;
        ArrayList<LocalsArray> arrayList2 = arrayList;
        ArrayList<LocalsArray> arrayList3 = new ArrayList<>();
        this.secondaries = arrayList2;
    }

    private LocalsArraySet(LocalsArraySet localsArraySet) {
        ArrayList<LocalsArray> arrayList;
        LocalsArraySet localsArraySet2 = localsArraySet;
        super(localsArraySet2.getMaxLocals() > 0);
        this.primary = localsArraySet2.primary.copy();
        ArrayList<LocalsArray> arrayList2 = arrayList;
        ArrayList<LocalsArray> arrayList3 = new ArrayList<>(localsArraySet2.secondaries.size());
        this.secondaries = arrayList2;
        int size = localsArraySet2.secondaries.size();
        for (int i = 0; i < size; i++) {
            LocalsArray localsArray = (LocalsArray) localsArraySet2.secondaries.get(i);
            if (localsArray == null) {
                boolean add = this.secondaries.add(null);
            } else {
                boolean add2 = this.secondaries.add(localsArray.copy());
            }
        }
    }

    public LocalsArraySet(OneLocalsArray oneLocalsArray, ArrayList<LocalsArray> arrayList) {
        OneLocalsArray oneLocalsArray2 = oneLocalsArray;
        ArrayList<LocalsArray> arrayList2 = arrayList;
        super(oneLocalsArray2.getMaxLocals() > 0);
        this.primary = oneLocalsArray2;
        this.secondaries = arrayList2;
    }

    private LocalsArray getSecondaryForLabel(int i) {
        int i2 = i;
        if (i2 >= this.secondaries.size()) {
            return null;
        }
        return (LocalsArray) this.secondaries.get(i2);
    }

    private LocalsArraySet mergeWithOne(OneLocalsArray oneLocalsArray) {
        ArrayList arrayList;
        boolean z;
        LocalsArraySet localsArraySet;
        StringBuilder sb;
        OneLocalsArray oneLocalsArray2 = oneLocalsArray;
        OneLocalsArray merge = this.primary.merge(oneLocalsArray2.getPrimary());
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(this.secondaries.size());
        ArrayList arrayList4 = arrayList2;
        int size = this.secondaries.size();
        int i = 0;
        boolean z2 = false;
        while (true) {
            z = z2;
            if (i >= size) {
                break;
            }
            LocalsArray localsArray = (LocalsArray) this.secondaries.get(i);
            LocalsArray localsArray2 = null;
            if (localsArray != null) {
                try {
                    localsArray2 = localsArray.merge(oneLocalsArray2);
                } catch (SimException e) {
                    SimException simException = e;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    simException.addContext(sb2.append("Merging one locals against caller block ").append(Hex.m51u2(i)).toString());
                    localsArray2 = null;
                }
            }
            boolean z3 = z || localsArray != localsArray2;
            boolean add = arrayList4.add(localsArray2);
            i++;
            z2 = z3;
        }
        if (this.primary != merge || z) {
            LocalsArraySet localsArraySet2 = localsArraySet;
            LocalsArraySet localsArraySet3 = new LocalsArraySet(merge, arrayList4);
            return localsArraySet2;
        }
        return this;
    }

    private LocalsArraySet mergeWithSet(LocalsArraySet localsArraySet) {
        ArrayList arrayList;
        boolean z;
        LocalsArraySet localsArraySet2;
        StringBuilder sb;
        LocalsArray localsArray;
        LocalsArraySet localsArraySet3 = localsArraySet;
        OneLocalsArray merge = this.primary.merge(localsArraySet3.getPrimary());
        int size = this.secondaries.size();
        int size2 = localsArraySet3.secondaries.size();
        int max = Math.max(size, size2);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(max);
        ArrayList arrayList4 = arrayList2;
        int i = 0;
        boolean z2 = false;
        while (true) {
            z = z2;
            if (i >= max) {
                break;
            }
            LocalsArray localsArray2 = i < size ? (LocalsArray) this.secondaries.get(i) : null;
            LocalsArray localsArray3 = i < size2 ? (LocalsArray) localsArraySet3.secondaries.get(i) : null;
            if (localsArray2 == localsArray3) {
                localsArray = localsArray2;
            } else if (localsArray2 == null) {
                localsArray = localsArray3;
            } else if (localsArray3 == null) {
                localsArray = localsArray2;
            } else {
                try {
                    localsArray = localsArray2.merge(localsArray3);
                } catch (SimException e) {
                    SimException simException = e;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    simException.addContext(sb2.append("Merging locals set for caller block ").append(Hex.m51u2(i)).toString());
                    localsArray = null;
                }
            }
            boolean z3 = z || localsArray2 != localsArray;
            boolean add = arrayList4.add(localsArray);
            i++;
            z2 = z3;
        }
        if (this.primary != merge || z) {
            LocalsArraySet localsArraySet4 = localsArraySet2;
            LocalsArraySet localsArraySet5 = new LocalsArraySet(merge, arrayList4);
            return localsArraySet4;
        }
        return this;
    }

    public void annotate(ExceptionWithContext exceptionWithContext) {
        StringBuilder sb;
        ExceptionWithContext exceptionWithContext2 = exceptionWithContext;
        exceptionWithContext2.addContext("(locals array set; primary)");
        this.primary.annotate(exceptionWithContext2);
        int size = this.secondaries.size();
        for (int i = 0; i < size; i++) {
            LocalsArray localsArray = (LocalsArray) this.secondaries.get(i);
            if (localsArray != null) {
                ExceptionWithContext exceptionWithContext3 = exceptionWithContext2;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                exceptionWithContext3.addContext(sb2.append("(locals array set: primary for caller ").append(Hex.m51u2(i)).append(')').toString());
                localsArray.getPrimary().annotate(exceptionWithContext2);
            }
        }
    }

    public LocalsArray copy() {
        LocalsArraySet localsArraySet;
        LocalsArraySet localsArraySet2 = localsArraySet;
        LocalsArraySet localsArraySet3 = new LocalsArraySet(this);
        return localsArraySet2;
    }

    public TypeBearer get(int i) {
        return this.primary.get(i);
    }

    public TypeBearer getCategory1(int i) {
        return this.primary.getCategory1(i);
    }

    public TypeBearer getCategory2(int i) {
        return this.primary.getCategory2(i);
    }

    public int getMaxLocals() {
        return this.primary.getMaxLocals();
    }

    public TypeBearer getOrNull(int i) {
        return this.primary.getOrNull(i);
    }

    /* access modifiers changed from: protected */
    public OneLocalsArray getPrimary() {
        return this.primary;
    }

    public void invalidate(int i) {
        int i2 = i;
        throwIfImmutable();
        this.primary.invalidate(i2);
        Iterator it = this.secondaries.iterator();
        while (it.hasNext()) {
            LocalsArray localsArray = (LocalsArray) it.next();
            if (localsArray != null) {
                localsArray.invalidate(i2);
            }
        }
    }

    public void makeInitialized(Type type) {
        Type type2 = type;
        if (this.primary.getMaxLocals() != 0) {
            throwIfImmutable();
            this.primary.makeInitialized(type2);
            Iterator it = this.secondaries.iterator();
            while (it.hasNext()) {
                LocalsArray localsArray = (LocalsArray) it.next();
                if (localsArray != null) {
                    localsArray.makeInitialized(type2);
                }
            }
        }
    }

    public LocalsArraySet merge(LocalsArray localsArray) {
        LocalsArray localsArray2 = localsArray;
        try {
            LocalsArraySet mergeWithOne = localsArray2 instanceof LocalsArraySet ? mergeWithSet((LocalsArraySet) localsArray2) : mergeWithOne((OneLocalsArray) localsArray2);
            mergeWithOne.setImmutable();
            return mergeWithOne;
        } catch (SimException e) {
            SimException simException = e;
            simException.addContext("underlay locals:");
            annotate(simException);
            simException.addContext("overlay locals:");
            localsArray2.annotate(simException);
            throw simException;
        }
    }

    public LocalsArraySet mergeWithSubroutineCaller(LocalsArray localsArray, int i) {
        ArrayList arrayList;
        LocalsArraySet localsArraySet;
        LocalsArray localsArray2 = localsArray;
        int i2 = i;
        LocalsArray secondaryForLabel = getSecondaryForLabel(i2);
        OneLocalsArray merge = this.primary.merge(localsArray2.getPrimary());
        LocalsArray merge2 = secondaryForLabel == localsArray2 ? secondaryForLabel : secondaryForLabel == null ? localsArray2 : secondaryForLabel.merge(localsArray2);
        if (merge2 == secondaryForLabel && merge == this.primary) {
            return this;
        }
        int size = this.secondaries.size();
        int max = Math.max(i2 + 1, size);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(max);
        ArrayList arrayList4 = arrayList2;
        int i3 = 0;
        OneLocalsArray oneLocalsArray = null;
        while (true) {
            OneLocalsArray oneLocalsArray2 = oneLocalsArray;
            if (i3 < max) {
                LocalsArray localsArray3 = i3 == i2 ? merge2 : i3 < size ? (LocalsArray) this.secondaries.get(i3) : null;
                OneLocalsArray oneLocalsArray3 = localsArray3 != null ? oneLocalsArray2 == null ? localsArray3.getPrimary() : oneLocalsArray2.merge(localsArray3.getPrimary()) : oneLocalsArray2;
                OneLocalsArray oneLocalsArray4 = oneLocalsArray3;
                boolean add = arrayList4.add(localsArray3);
                i3++;
                oneLocalsArray = oneLocalsArray4;
            } else {
                LocalsArraySet localsArraySet2 = localsArraySet;
                LocalsArraySet localsArraySet3 = new LocalsArraySet(oneLocalsArray2, arrayList4);
                LocalsArraySet localsArraySet4 = localsArraySet2;
                localsArraySet4.setImmutable();
                return localsArraySet4;
            }
        }
    }

    public void set(int i, TypeBearer typeBearer) {
        int i2 = i;
        TypeBearer typeBearer2 = typeBearer;
        throwIfImmutable();
        this.primary.set(i2, typeBearer2);
        Iterator it = this.secondaries.iterator();
        while (it.hasNext()) {
            LocalsArray localsArray = (LocalsArray) it.next();
            if (localsArray != null) {
                localsArray.set(i2, typeBearer2);
            }
        }
    }

    public void set(RegisterSpec registerSpec) {
        RegisterSpec registerSpec2 = registerSpec;
        set(registerSpec2.getReg(), registerSpec2);
    }

    public void setImmutable() {
        this.primary.setImmutable();
        Iterator it = this.secondaries.iterator();
        while (it.hasNext()) {
            LocalsArray localsArray = (LocalsArray) it.next();
            if (localsArray != null) {
                localsArray.setImmutable();
            }
        }
        super.setImmutable();
    }

    public LocalsArray subArrayForLabel(int i) {
        return getSecondaryForLabel(i);
    }

    public String toHuman() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = sb3;
        StringBuilder append = sb5.append("(locals array set; primary)\n");
        StringBuilder append2 = sb5.append(getPrimary().toHuman());
        StringBuilder append3 = sb5.append(10);
        int size = this.secondaries.size();
        for (int i = 0; i < size; i++) {
            LocalsArray localsArray = (LocalsArray) this.secondaries.get(i);
            if (localsArray != null) {
                StringBuilder sb6 = sb5;
                StringBuilder sb7 = sb2;
                StringBuilder sb8 = new StringBuilder();
                StringBuilder append4 = sb6.append(sb7.append("(locals array set: primary for caller ").append(Hex.m51u2(i)).append(")\n").toString());
                StringBuilder append5 = sb5.append(localsArray.getPrimary().toHuman());
                StringBuilder append6 = sb5.append(10);
            }
        }
        return sb5.toString();
    }
}
