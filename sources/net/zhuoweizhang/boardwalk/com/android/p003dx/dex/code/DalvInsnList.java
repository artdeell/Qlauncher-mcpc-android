package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstBaseMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IndentingWriter;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.DalvInsnList */
public final class DalvInsnList extends FixedSizeList {
    private final int regCount;

    public DalvInsnList(int i, int i2) {
        int i3 = i2;
        super(i);
        this.regCount = i3;
    }

    public static DalvInsnList makeImmutable(ArrayList<DalvInsn> arrayList, int i) {
        DalvInsnList dalvInsnList;
        ArrayList<DalvInsn> arrayList2 = arrayList;
        int i2 = i;
        int size = arrayList2.size();
        DalvInsnList dalvInsnList2 = dalvInsnList;
        DalvInsnList dalvInsnList3 = new DalvInsnList(size, i2);
        DalvInsnList dalvInsnList4 = dalvInsnList2;
        for (int i3 = 0; i3 < size; i3++) {
            dalvInsnList4.set(i3, (DalvInsn) arrayList2.get(i3));
        }
        dalvInsnList4.setImmutable();
        return dalvInsnList4;
    }

    public int codeSize() {
        int size = size();
        if (size == 0) {
            return 0;
        }
        return get(size - 1).getNextAddress();
    }

    public void debugPrint(OutputStream outputStream, String str, boolean z) {
        OutputStreamWriter outputStreamWriter;
        RuntimeException runtimeException;
        String str2 = str;
        boolean z2 = z;
        OutputStreamWriter outputStreamWriter2 = outputStreamWriter;
        OutputStreamWriter outputStreamWriter3 = new OutputStreamWriter(outputStream);
        OutputStreamWriter outputStreamWriter4 = outputStreamWriter2;
        debugPrint((Writer) outputStreamWriter4, str2, z2);
        try {
            outputStreamWriter4.flush();
        } catch (IOException e) {
            IOException iOException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(iOException);
            throw runtimeException2;
        }
    }

    public void debugPrint(Writer writer, String str, boolean z) {
        IndentingWriter indentingWriter;
        RuntimeException runtimeException;
        boolean z2 = z;
        IndentingWriter indentingWriter2 = indentingWriter;
        IndentingWriter indentingWriter3 = new IndentingWriter(writer, 0, str);
        IndentingWriter indentingWriter4 = indentingWriter2;
        int size = size();
        int i = 0;
        while (i < size) {
            try {
                DalvInsn dalvInsn = (DalvInsn) get0(i);
                String listingString = (dalvInsn.codeSize() != 0 || z2) ? dalvInsn.listingString(LibrariesRepository.MOJANG_MAVEN_REPO, 0, z2) : null;
                if (listingString != null) {
                    indentingWriter4.write(listingString);
                }
                i++;
            } catch (IOException e) {
                IOException iOException = e;
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException(iOException);
                throw runtimeException2;
            }
        }
        indentingWriter4.flush();
    }

    public DalvInsn get(int i) {
        return (DalvInsn) get0(i);
    }

    public int getOutsSize() {
        int parameterWordCount;
        int size = size();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= size) {
                return i3;
            }
            DalvInsn dalvInsn = (DalvInsn) get0(i);
            if (!(dalvInsn instanceof CstInsn)) {
                parameterWordCount = i3;
            } else {
                Constant constant = ((CstInsn) dalvInsn).getConstant();
                if (!(constant instanceof CstBaseMethodRef)) {
                    parameterWordCount = i3;
                } else {
                    parameterWordCount = ((CstBaseMethodRef) constant).getParameterWordCount(dalvInsn.getOpcode().getFamily() == 113);
                    if (parameterWordCount <= i3) {
                        parameterWordCount = i3;
                    }
                }
            }
            i++;
            i2 = parameterWordCount;
        }
    }

    public int getRegistersSize() {
        return this.regCount;
    }

    public void set(int i, DalvInsn dalvInsn) {
        set0(i, dalvInsn);
    }

    public void writeTo(AnnotatedOutput annotatedOutput) {
        RuntimeException runtimeException;
        StringBuilder sb;
        StringBuilder sb2;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int cursor = annotatedOutput2.getCursor();
        int size = size();
        int i = 0;
        if (annotatedOutput2.annotates()) {
            boolean isVerbose = annotatedOutput2.isVerbose();
            int i2 = 0;
            while (true) {
                i = 0;
                if (i2 >= size) {
                    break;
                }
                DalvInsn dalvInsn = (DalvInsn) get0(i2);
                int codeSize = 2 * dalvInsn.codeSize();
                String listingString = (codeSize != 0 || isVerbose) ? dalvInsn.listingString("  ", annotatedOutput2.getAnnotationWidth(), true) : null;
                if (listingString != null) {
                    annotatedOutput2.annotate(codeSize, listingString);
                } else if (codeSize != 0) {
                    annotatedOutput2.annotate(codeSize, LibrariesRepository.MOJANG_MAVEN_REPO);
                }
                i2++;
            }
        }
        while (i < size) {
            DalvInsn dalvInsn2 = (DalvInsn) get0(i);
            try {
                dalvInsn2.writeTo(annotatedOutput2);
                i++;
            } catch (RuntimeException e) {
                RuntimeException runtimeException2 = e;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                throw ExceptionWithContext.withContext(runtimeException2, sb3.append("...while writing ").append(dalvInsn2).toString());
            }
        }
        int cursor2 = (annotatedOutput2.getCursor() - cursor) / 2;
        if (cursor2 != codeSize()) {
            RuntimeException runtimeException3 = runtimeException;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            RuntimeException runtimeException4 = new RuntimeException(sb5.append("write length mismatch; expected ").append(codeSize()).append(" but actually wrote ").append(cursor2).toString());
            throw runtimeException3;
        }
    }
}
