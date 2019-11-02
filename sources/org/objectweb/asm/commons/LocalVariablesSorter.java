package org.objectweb.asm.commons;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class LocalVariablesSorter extends MethodVisitor {
    private static final Type OBJECT_TYPE = Type.getObjectType("java/lang/Object");
    private boolean changed;
    protected final int firstLocal;
    private int[] mapping;
    private Object[] newLocals;
    protected int nextLocal;

    protected LocalVariablesSorter(int i, int i2, String str, MethodVisitor methodVisitor) {
        int i3 = i2;
        String str2 = str;
        super(i, methodVisitor);
        this.mapping = new int[40];
        this.newLocals = new Object[20];
        Type[] argumentTypes = Type.getArgumentTypes(str2);
        this.nextLocal = (i3 & 8) == 0 ? 1 : 0;
        for (int i4 = 0; i4 < argumentTypes.length; i4++) {
            this.nextLocal += argumentTypes[i4].getSize();
        }
        this.firstLocal = this.nextLocal;
    }

    public LocalVariablesSorter(int i, String str, MethodVisitor methodVisitor) {
        this(262144, i, str, methodVisitor);
    }

    private int remap(int i, Type type) {
        int i2;
        int i3 = i;
        Type type2 = type;
        if (i3 + type2.getSize() <= this.firstLocal) {
            return i3;
        }
        int size = -1 + (i3 * 2) + type2.getSize();
        int length = this.mapping.length;
        if (size >= length) {
            int[] iArr = new int[Math.max(length * 2, size + 1)];
            System.arraycopy(this.mapping, 0, iArr, 0, length);
            this.mapping = iArr;
        }
        int i4 = this.mapping[size];
        if (i4 == 0) {
            i2 = newLocalMapping(type2);
            setLocalType(i2, type2);
            this.mapping[size] = i2 + 1;
        } else {
            i2 = i4 - 1;
        }
        if (i2 != i3) {
            this.changed = true;
        }
        return i2;
    }

    private void setFrameLocal(int i, Object obj) {
        int i2 = i;
        Object obj2 = obj;
        int length = this.newLocals.length;
        if (i2 >= length) {
            Object[] objArr = new Object[Math.max(length * 2, i2 + 1)];
            System.arraycopy(this.newLocals, 0, objArr, 0, length);
            this.newLocals = objArr;
        }
        this.newLocals[i2] = obj2;
    }

    public int newLocal(Type type) {
        Object descriptor;
        Type type2 = type;
        switch (type2.getSort()) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                descriptor = Opcodes.INTEGER;
                break;
            case 6:
                descriptor = Opcodes.FLOAT;
                break;
            case 7:
                descriptor = Opcodes.LONG;
                break;
            case 8:
                descriptor = Opcodes.DOUBLE;
                break;
            case 9:
                descriptor = type2.getDescriptor();
                break;
            default:
                descriptor = type2.getInternalName();
                break;
        }
        int i = this.nextLocal;
        this.nextLocal += type2.getSize();
        setLocalType(i, type2);
        setFrameLocal(i, descriptor);
        return i;
    }

    /* access modifiers changed from: protected */
    public int newLocalMapping(Type type) {
        Type type2 = type;
        int i = this.nextLocal;
        this.nextLocal += type2.getSize();
        return i;
    }

    /* access modifiers changed from: protected */
    public void setLocalType(int i, Type type) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0099, code lost:
        r21 = r17;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void visitFrame(int r29, int r30, java.lang.Object[] r31, int r32, java.lang.Object[] r33) {
        /*
            r28 = this;
            r2 = r28
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r32
            r7 = r33
            r21 = 0
            r8 = r21
            r21 = r3
            r22 = -1
            r0 = r21
            r1 = r22
            if (r0 == r1) goto L_0x0028
            java.lang.IllegalStateException r21 = new java.lang.IllegalStateException
            r27 = r21
            r21 = r27
            r22 = r27
            java.lang.String r23 = "ClassReader.accept() should be called with EXPAND_FRAMES flag"
            r22.<init>(r23)
            throw r21
        L_0x0028:
            r21 = r2
            r0 = r21
            boolean r0 = r0.changed
            r21 = r0
            if (r21 != 0) goto L_0x0048
            r21 = r2
            r0 = r21
            org.objectweb.asm.MethodVisitor r0 = r0.f376mv
            r21 = r0
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r21.visitFrame(r22, r23, r24, r25, r26)
        L_0x0047:
            return
        L_0x0048:
            r21 = r2
            r0 = r21
            java.lang.Object[] r0 = r0.newLocals
            r21 = r0
            r0 = r21
            int r0 = r0.length
            r21 = r0
            r0 = r21
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r21 = r0
            r9 = r21
            r21 = r2
            r0 = r21
            java.lang.Object[] r0 = r0.newLocals
            r21 = r0
            r22 = 0
            r23 = r9
            r24 = 0
            r25 = r9
            r0 = r25
            int r0 = r0.length
            r25 = r0
            java.lang.System.arraycopy(r21, r22, r23, r24, r25)
            r21 = 0
            r10 = r21
            r21 = 0
            r11 = r21
        L_0x007d:
            r21 = r10
            r22 = r4
            r0 = r21
            r1 = r22
            if (r0 >= r1) goto L_0x012a
            r21 = r5
            r22 = r10
            r21 = r21[r22]
            r17 = r21
            r21 = r17
            java.lang.Integer r22 = org.objectweb.asm.Opcodes.LONG
            r0 = r21
            r1 = r22
            if (r0 == r1) goto L_0x00a3
            r21 = r17
            java.lang.Integer r22 = org.objectweb.asm.Opcodes.DOUBLE
            r0 = r21
            r1 = r22
            if (r0 != r1) goto L_0x00e3
        L_0x00a3:
            r21 = 2
            r18 = r21
        L_0x00a7:
            r21 = r17
            java.lang.Integer r22 = org.objectweb.asm.Opcodes.TOP
            r0 = r21
            r1 = r22
            if (r0 == r1) goto L_0x00d4
            org.objectweb.asm.Type r21 = OBJECT_TYPE
            r20 = r21
            r21 = r17
            java.lang.Integer r22 = org.objectweb.asm.Opcodes.INTEGER
            r0 = r21
            r1 = r22
            if (r0 != r1) goto L_0x00e8
            org.objectweb.asm.Type r21 = org.objectweb.asm.Type.INT_TYPE
            r20 = r21
        L_0x00c3:
            r21 = r2
            r22 = r2
            r23 = r11
            r24 = r20
            int r22 = r22.remap(r23, r24)
            r23 = r17
            r21.setFrameLocal(r22, r23)
        L_0x00d4:
            r21 = r11
            r22 = r18
            int r21 = r21 + r22
            r19 = r21
            int r10 = r10 + 1
            r21 = r19
            r11 = r21
            goto L_0x007d
        L_0x00e3:
            r21 = 1
            r18 = r21
            goto L_0x00a7
        L_0x00e8:
            r21 = r17
            java.lang.Integer r22 = org.objectweb.asm.Opcodes.FLOAT
            r0 = r21
            r1 = r22
            if (r0 != r1) goto L_0x00f7
            org.objectweb.asm.Type r21 = org.objectweb.asm.Type.FLOAT_TYPE
            r20 = r21
            goto L_0x00c3
        L_0x00f7:
            r21 = r17
            java.lang.Integer r22 = org.objectweb.asm.Opcodes.LONG
            r0 = r21
            r1 = r22
            if (r0 != r1) goto L_0x0106
            org.objectweb.asm.Type r21 = org.objectweb.asm.Type.LONG_TYPE
            r20 = r21
            goto L_0x00c3
        L_0x0106:
            r21 = r17
            java.lang.Integer r22 = org.objectweb.asm.Opcodes.DOUBLE
            r0 = r21
            r1 = r22
            if (r0 != r1) goto L_0x0115
            org.objectweb.asm.Type r21 = org.objectweb.asm.Type.DOUBLE_TYPE
            r20 = r21
            goto L_0x00c3
        L_0x0115:
            r21 = r17
            r0 = r21
            boolean r0 = r0 instanceof java.lang.String
            r21 = r0
            if (r21 == 0) goto L_0x00c3
            r21 = r17
            java.lang.String r21 = (java.lang.String) r21
            org.objectweb.asm.Type r21 = org.objectweb.asm.Type.getObjectType(r21)
            r20 = r21
            goto L_0x00c3
        L_0x012a:
            r21 = 0
            r12 = r21
            r21 = 0
            r13 = r21
        L_0x0132:
            r21 = r8
            r22 = r2
            r0 = r22
            java.lang.Object[] r0 = r0.newLocals
            r22 = r0
            r0 = r22
            int r0 = r0.length
            r22 = r0
            r0 = r21
            r1 = r22
            if (r0 >= r1) goto L_0x01b7
            r21 = r2
            r0 = r21
            java.lang.Object[] r0 = r0.newLocals
            r21 = r0
            r14 = r21
            r21 = r8
            r22 = 1
            int r21 = r21 + 1
            r15 = r21
            r21 = r14
            r22 = r8
            r21 = r21[r22]
            r16 = r21
            r21 = r16
            if (r21 == 0) goto L_0x01a4
            r21 = r16
            java.lang.Integer r22 = org.objectweb.asm.Opcodes.TOP
            r0 = r21
            r1 = r22
            if (r0 == r1) goto L_0x01a4
            r21 = r2
            r0 = r21
            java.lang.Object[] r0 = r0.newLocals
            r21 = r0
            r22 = r12
            r23 = r16
            r21[r22] = r23
            r21 = r12
            r22 = 1
            int r21 = r21 + 1
            r13 = r21
            r21 = r16
            java.lang.Integer r22 = org.objectweb.asm.Opcodes.LONG
            r0 = r21
            r1 = r22
            if (r0 == r1) goto L_0x0199
            r21 = r16
            java.lang.Integer r22 = org.objectweb.asm.Opcodes.DOUBLE
            r0 = r21
            r1 = r22
            if (r0 != r1) goto L_0x01b2
        L_0x0199:
            r21 = r15
            r22 = 1
            int r21 = r21 + 1
            r8 = r21
        L_0x01a1:
            int r12 = r12 + 1
            goto L_0x0132
        L_0x01a4:
            r21 = r2
            r0 = r21
            java.lang.Object[] r0 = r0.newLocals
            r21 = r0
            r22 = r12
            java.lang.Integer r23 = org.objectweb.asm.Opcodes.TOP
            r21[r22] = r23
        L_0x01b2:
            r21 = r15
            r8 = r21
            goto L_0x01a1
        L_0x01b7:
            r21 = r2
            r0 = r21
            org.objectweb.asm.MethodVisitor r0 = r0.f376mv
            r21 = r0
            r22 = r3
            r23 = r13
            r24 = r2
            r0 = r24
            java.lang.Object[] r0 = r0.newLocals
            r24 = r0
            r25 = r6
            r26 = r7
            r21.visitFrame(r22, r23, r24, r25, r26)
            r21 = r2
            r22 = r9
            r0 = r22
            r1 = r21
            r1.newLocals = r0
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.commons.LocalVariablesSorter.visitFrame(int, int, java.lang.Object[], int, java.lang.Object[]):void");
    }

    public void visitIincInsn(int i, int i2) {
        int i3 = i2;
        this.f376mv.visitIincInsn(remap(i, Type.INT_TYPE), i3);
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
        String str4 = str2;
        this.f376mv.visitLocalVariable(str, str4, str3, label, label2, remap(i, Type.getType(str4)));
    }

    public void visitMaxs(int i, int i2) {
        int i3 = i2;
        this.f376mv.visitMaxs(i, this.nextLocal);
    }

    public void visitVarInsn(int i, int i2) {
        Type type;
        int i3 = i;
        int i4 = i2;
        switch (i3) {
            case 21:
            case 54:
                type = Type.INT_TYPE;
                break;
            case 22:
            case 55:
                type = Type.LONG_TYPE;
                break;
            case 23:
            case 56:
                type = Type.FLOAT_TYPE;
                break;
            case 24:
            case 57:
                type = Type.DOUBLE_TYPE;
                break;
            default:
                type = OBJECT_TYPE;
                break;
        }
        this.f376mv.visitVarInsn(i3, remap(i4, type));
    }
}
