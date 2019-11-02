package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttCode;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttLineNumberTable;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttLocalVariableTable;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttLocalVariableTypeTable;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Attribute;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.AttributeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ClassFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Method;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Prototype;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ConcreteMethod */
public final class ConcreteMethod implements Method {
    private final boolean accSuper;
    private final AttCode attCode;
    private final LineNumberList lineNumbers;
    private final LocalVariableList localVariables;
    private final Method method;
    private final CstString sourceFile;

    public ConcreteMethod(Method method2, int i, CstString cstString, boolean z, boolean z2) {
        LineNumberList lineNumberList;
        LocalVariableList localVariableList;
        Method method3 = method2;
        int i2 = i;
        CstString cstString2 = cstString;
        boolean z3 = z;
        boolean z4 = z2;
        this.method = method3;
        this.accSuper = (i2 & 32) != 0;
        this.sourceFile = cstString2;
        this.attCode = (AttCode) method3.getAttributes().findFirst(AttCode.ATTRIBUTE_NAME);
        AttributeList attributes = this.attCode.getAttributes();
        LineNumberList lineNumberList2 = LineNumberList.EMPTY;
        if (z3) {
            lineNumberList = lineNumberList2;
            AttLineNumberTable attLineNumberTable = (AttLineNumberTable) attributes.findFirst(AttLineNumberTable.ATTRIBUTE_NAME);
            while (attLineNumberTable != null) {
                LineNumberList concat = LineNumberList.concat(lineNumberList, attLineNumberTable.getLineNumbers());
                attLineNumberTable = (AttLineNumberTable) attributes.findNext(attLineNumberTable);
                lineNumberList = concat;
            }
        } else {
            lineNumberList = lineNumberList2;
        }
        this.lineNumbers = lineNumberList;
        LocalVariableList localVariableList2 = LocalVariableList.EMPTY;
        if (z4) {
            Attribute findFirst = attributes.findFirst(AttLocalVariableTable.ATTRIBUTE_NAME);
            while (true) {
                AttLocalVariableTable attLocalVariableTable = (AttLocalVariableTable) findFirst;
                if (attLocalVariableTable == null) {
                    break;
                }
                localVariableList2 = LocalVariableList.concat(localVariableList2, attLocalVariableTable.getLocalVariables());
                findFirst = attributes.findNext(attLocalVariableTable);
            }
            LocalVariableList localVariableList3 = LocalVariableList.EMPTY;
            Attribute findFirst2 = attributes.findFirst(AttLocalVariableTypeTable.ATTRIBUTE_NAME);
            while (true) {
                AttLocalVariableTypeTable attLocalVariableTypeTable = (AttLocalVariableTypeTable) findFirst2;
                if (attLocalVariableTypeTable == null) {
                    break;
                }
                localVariableList3 = LocalVariableList.concat(localVariableList3, attLocalVariableTypeTable.getLocalVariables());
                findFirst2 = attributes.findNext(attLocalVariableTypeTable);
            }
            if (localVariableList3.size() != 0) {
                localVariableList = LocalVariableList.mergeDescriptorsAndSignatures(localVariableList2, localVariableList3);
                this.localVariables = localVariableList;
            }
        }
        localVariableList = localVariableList2;
        this.localVariables = localVariableList;
    }

    public ConcreteMethod(Method method2, ClassFile classFile, boolean z, boolean z2) {
        ClassFile classFile2 = classFile;
        this(method2, classFile2.getAccessFlags(), classFile2.getSourceFile(), z, z2);
    }

    public boolean getAccSuper() {
        return this.accSuper;
    }

    public int getAccessFlags() {
        return this.method.getAccessFlags();
    }

    public AttributeList getAttributes() {
        return this.method.getAttributes();
    }

    public ByteCatchList getCatches() {
        return this.attCode.getCatches();
    }

    public BytecodeArray getCode() {
        return this.attCode.getCode();
    }

    public CstType getDefiningClass() {
        return this.method.getDefiningClass();
    }

    public CstString getDescriptor() {
        return this.method.getDescriptor();
    }

    public Prototype getEffectiveDescriptor() {
        return this.method.getEffectiveDescriptor();
    }

    public LineNumberList getLineNumbers() {
        return this.lineNumbers;
    }

    public LocalVariableList getLocalVariables() {
        return this.localVariables;
    }

    public int getMaxLocals() {
        return this.attCode.getMaxLocals();
    }

    public int getMaxStack() {
        return this.attCode.getMaxStack();
    }

    public CstString getName() {
        return this.method.getName();
    }

    public CstNat getNat() {
        return this.method.getNat();
    }

    public SourcePosition makeSourcePosistion(int i) {
        SourcePosition sourcePosition;
        int i2 = i;
        SourcePosition sourcePosition2 = sourcePosition;
        SourcePosition sourcePosition3 = new SourcePosition(this.sourceFile, i2, this.lineNumbers.pcToLine(i2));
        return sourcePosition2;
    }
}
