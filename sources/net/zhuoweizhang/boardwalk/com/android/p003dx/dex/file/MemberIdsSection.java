package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.Formatter;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import net.zhuoweizhang.boardwalk.com.android.dex.DexException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.command.dexer.Main;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.MemberIdsSection */
public abstract class MemberIdsSection extends UniformItemSection {
    public MemberIdsSection(String str, DexFile dexFile) {
        super(str, dexFile, 4);
    }

    /* JADX INFO: finally extract failed */
    private String getTooManyMembersMessage() {
        TreeMap treeMap;
        Formatter formatter;
        StringBuilder sb;
        AtomicInteger atomicInteger;
        TreeMap treeMap2 = treeMap;
        TreeMap treeMap3 = new TreeMap();
        TreeMap treeMap4 = treeMap2;
        for (Item item : items()) {
            String packageName = ((MemberIdItem) item).getDefiningClass().getPackageName();
            AtomicInteger atomicInteger2 = (AtomicInteger) treeMap4.get(packageName);
            if (atomicInteger2 == null) {
                AtomicInteger atomicInteger3 = atomicInteger;
                AtomicInteger atomicInteger4 = new AtomicInteger();
                atomicInteger2 = atomicInteger3;
                Object put = treeMap4.put(packageName, atomicInteger2);
            }
            int incrementAndGet = atomicInteger2.incrementAndGet();
        }
        Formatter formatter2 = formatter;
        Formatter formatter3 = new Formatter();
        Formatter formatter4 = formatter2;
        try {
            String str = this instanceof MethodIdsSection ? "method" : "field";
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            Formatter format = formatter4.format(sb2.append("Too many %s references: %d; max is %d.%n").append(Main.getTooManyIdsErrorMessage()).append("%n").append("References by package:").toString(), new Object[]{str, Integer.valueOf(items().size()), Integer.valueOf(65536)});
            for (Entry entry : treeMap4.entrySet()) {
                Formatter format2 = formatter4.format("%n%6d %s", new Object[]{Integer.valueOf(((AtomicInteger) entry.getValue()).get()), entry.getKey()});
            }
            String formatter5 = formatter4.toString();
            formatter4.close();
            return formatter5;
        } catch (Throwable th) {
            Throwable th2 = th;
            formatter4.close();
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public void orderItems() {
        DexException dexException;
        if (items().size() > 65536) {
            DexException dexException2 = dexException;
            DexException dexException3 = new DexException(getTooManyMembersMessage());
            throw dexException2;
        }
        int i = 0;
        for (Item item : items()) {
            ((MemberIdItem) item).setIndex(i);
            i++;
        }
    }
}
