package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Merger */
public final class Merger {
    private Merger() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b5, code lost:
        if (r6 == net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.CLONEABLE) goto L_0x00b7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isPossiblyAssignableFrom(net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer r16, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer r17) {
        /*
            r0 = r16
            r1 = r17
            r14 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r14 = r14.getType()
            r2 = r14
            r14 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r14 = r14.getType()
            r3 = r14
            r14 = r2
            r15 = r3
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x001b
        L_0x0018:
            r14 = 1
            r0 = r14
        L_0x001a:
            return r0
        L_0x001b:
            r14 = r2
            int r14 = r14.getBasicType()
            r4 = r14
            r14 = r3
            int r14 = r14.getBasicType()
            r5 = r14
            r14 = r4
            r15 = 10
            if (r14 != r15) goto L_0x00c3
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r14 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.OBJECT
            r6 = r14
            r14 = 9
            r7 = r14
        L_0x0032:
            r14 = r5
            r15 = 10
            if (r14 != r15) goto L_0x00bd
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r14 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.OBJECT
            r8 = r14
            r14 = 9
            r9 = r14
        L_0x003d:
            r14 = r7
            r15 = 9
            if (r14 != r15) goto L_0x0047
            r14 = r9
            r15 = 9
            if (r14 == r15) goto L_0x0058
        L_0x0047:
            r14 = r6
            boolean r14 = r14.isIntlike()
            if (r14 == 0) goto L_0x0055
            r14 = r8
            boolean r14 = r14.isIntlike()
            if (r14 != 0) goto L_0x0018
        L_0x0055:
            r14 = 0
            r0 = r14
            goto L_0x001a
        L_0x0058:
            r14 = r6
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r15 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.KNOWN_NULL
            if (r14 != r15) goto L_0x0060
            r14 = 0
            r0 = r14
            goto L_0x001a
        L_0x0060:
            r14 = r8
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r15 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.KNOWN_NULL
            if (r14 == r15) goto L_0x0018
            r14 = r6
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r15 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.OBJECT
            if (r14 == r15) goto L_0x0018
            r14 = r6
            boolean r14 = r14.isArray()
            if (r14 == 0) goto L_0x00a2
            r14 = r8
            boolean r14 = r14.isArray()
            if (r14 != 0) goto L_0x007b
            r14 = 0
            r0 = r14
            goto L_0x001a
        L_0x007b:
            r14 = r8
            r12 = r14
            r14 = r6
            r13 = r14
        L_0x007f:
            r14 = r13
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r14 = r14.getComponentType()
            r13 = r14
            r14 = r12
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r14 = r14.getComponentType()
            r12 = r14
            r14 = r13
            boolean r14 = r14.isArray()
            if (r14 == 0) goto L_0x0099
            r14 = r12
            boolean r14 = r14.isArray()
            if (r14 != 0) goto L_0x007f
        L_0x0099:
            r14 = r13
            r15 = r12
            boolean r14 = isPossiblyAssignableFrom(r14, r15)
            r0 = r14
            goto L_0x001a
        L_0x00a2:
            r14 = r8
            boolean r14 = r14.isArray()
            if (r14 == 0) goto L_0x0018
            r14 = r6
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r15 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.SERIALIZABLE
            if (r14 == r15) goto L_0x00b7
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r14 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.CLONEABLE
            r11 = r14
            r14 = 0
            r10 = r14
            r14 = r6
            r15 = r11
            if (r14 != r15) goto L_0x00b9
        L_0x00b7:
            r14 = 1
            r10 = r14
        L_0x00b9:
            r14 = r10
            r0 = r14
            goto L_0x001a
        L_0x00bd:
            r14 = r3
            r8 = r14
            r14 = r5
            r9 = r14
            goto L_0x003d
        L_0x00c3:
            r14 = r2
            r6 = r14
            r14 = r4
            r7 = r14
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.Merger.isPossiblyAssignableFrom(net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer, net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer):boolean");
    }

    public static OneLocalsArray mergeLocals(OneLocalsArray oneLocalsArray, OneLocalsArray oneLocalsArray2) {
        SimException simException;
        OneLocalsArray oneLocalsArray3 = oneLocalsArray;
        OneLocalsArray oneLocalsArray4 = oneLocalsArray2;
        if (oneLocalsArray3 != oneLocalsArray4) {
            int maxLocals = oneLocalsArray3.getMaxLocals();
            if (oneLocalsArray4.getMaxLocals() != maxLocals) {
                SimException simException2 = simException;
                SimException simException3 = new SimException("mismatched maxLocals values");
                throw simException2;
            }
            OneLocalsArray oneLocalsArray5 = null;
            for (int i = 0; i < maxLocals; i++) {
                TypeBearer orNull = oneLocalsArray3.getOrNull(i);
                TypeBearer mergeType = mergeType(orNull, oneLocalsArray4.getOrNull(i));
                if (mergeType != orNull) {
                    if (oneLocalsArray5 == null) {
                        oneLocalsArray5 = oneLocalsArray3.copy();
                    }
                    if (mergeType == null) {
                        oneLocalsArray5.invalidate(i);
                    } else {
                        oneLocalsArray5.set(i, mergeType);
                    }
                }
            }
            if (oneLocalsArray5 != null) {
                oneLocalsArray5.setImmutable();
                return oneLocalsArray5;
            }
        }
        return oneLocalsArray3;
    }

    public static ExecutionStack mergeStack(ExecutionStack executionStack, ExecutionStack executionStack2) {
        StringBuilder sb;
        SimException simException;
        StringBuilder sb2;
        SimException simException2;
        ExecutionStack executionStack3 = executionStack;
        ExecutionStack executionStack4 = executionStack2;
        if (executionStack3 != executionStack4) {
            int size = executionStack3.size();
            if (executionStack4.size() != size) {
                SimException simException3 = simException2;
                SimException simException4 = new SimException("mismatched stack depths");
                throw simException3;
            }
            ExecutionStack executionStack5 = null;
            for (int i = 0; i < size; i++) {
                TypeBearer peek = executionStack3.peek(i);
                TypeBearer peek2 = executionStack4.peek(i);
                TypeBearer mergeType = mergeType(peek, peek2);
                if (mergeType != peek) {
                    if (executionStack5 == null) {
                        executionStack5 = executionStack3.copy();
                    }
                    if (mergeType == null) {
                        try {
                            SimException simException5 = simException;
                            StringBuilder sb3 = sb2;
                            StringBuilder sb4 = new StringBuilder();
                            SimException simException6 = new SimException(sb3.append("incompatible: ").append(peek).append(", ").append(peek2).toString());
                            throw simException5;
                        } catch (SimException e) {
                            SimException simException7 = e;
                            SimException simException8 = simException7;
                            StringBuilder sb5 = sb;
                            StringBuilder sb6 = new StringBuilder();
                            simException8.addContext(sb5.append("...while merging stack[").append(Hex.m51u2(i)).append("]").toString());
                            throw simException7;
                        }
                    } else {
                        executionStack5.change(i, mergeType);
                    }
                }
            }
            if (executionStack5 != null) {
                executionStack5.setImmutable();
                return executionStack5;
            }
        }
        return executionStack3;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r0v2, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v5, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer mergeType(net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer r6, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer r7) {
        /*
            r0 = r6
            r1 = r7
            r4 = r0
            if (r4 == 0) goto L_0x000d
            r4 = r0
            r5 = r1
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0010
        L_0x000d:
            r4 = r0
            r0 = r4
        L_0x000f:
            return r0
        L_0x0010:
            r4 = r1
            if (r4 != 0) goto L_0x0016
            r4 = 0
            r0 = r4
            goto L_0x000f
        L_0x0016:
            r4 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r4 = r4.getType()
            r0 = r4
            r4 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r4 = r4.getType()
            r2 = r4
            r4 = r0
            r5 = r2
            if (r4 == r5) goto L_0x000d
            r4 = r0
            boolean r4 = r4.isReference()
            if (r4 == 0) goto L_0x0072
            r4 = r2
            boolean r4 = r4.isReference()
            if (r4 == 0) goto L_0x0072
            r4 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r5 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.KNOWN_NULL
            if (r4 != r5) goto L_0x003c
            r4 = r2
            r0 = r4
            goto L_0x000f
        L_0x003c:
            r4 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r5 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.KNOWN_NULL
            if (r4 == r5) goto L_0x000d
            r4 = r0
            boolean r4 = r4.isArray()
            if (r4 == 0) goto L_0x006e
            r4 = r2
            boolean r4 = r4.isArray()
            if (r4 == 0) goto L_0x006e
            r4 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r4 = r4.getComponentType()
            r5 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r5 = r5.getComponentType()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r4 = mergeType(r4, r5)
            r3 = r4
            r4 = r3
            if (r4 != 0) goto L_0x0065
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r4 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.OBJECT
            r0 = r4
            goto L_0x000f
        L_0x0065:
            r4 = r3
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r4 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type) r4
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r4 = r4.getArrayType()
            r0 = r4
            goto L_0x000f
        L_0x006e:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r4 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.OBJECT
            r0 = r4
            goto L_0x000f
        L_0x0072:
            r4 = r0
            boolean r4 = r4.isIntlike()
            if (r4 == 0) goto L_0x0084
            r4 = r2
            boolean r4 = r4.isIntlike()
            if (r4 == 0) goto L_0x0084
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r4 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.INT
            r0 = r4
            goto L_0x000f
        L_0x0084:
            r4 = 0
            r0 = r4
            goto L_0x000f
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.Merger.mergeType(net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer, net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer):net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer");
    }
}
