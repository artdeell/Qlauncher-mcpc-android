package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.ConstantPool;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ClassFile */
public interface ClassFile {
    int getAccessFlags();

    AttributeList getAttributes();

    ConstantPool getConstantPool();

    FieldList getFields();

    TypeList getInterfaces();

    int getMagic();

    int getMajorVersion();

    MethodList getMethods();

    int getMinorVersion();

    CstString getSourceFile();

    CstType getSuperclass();

    CstType getThisClass();
}
