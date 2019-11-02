package net.zhuoweizhang.boardwalk.com.android.p003dx.command.grep;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassData;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassData.Method;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassDef;
import net.zhuoweizhang.boardwalk.com.android.dex.Dex;
import net.zhuoweizhang.boardwalk.com.android.dex.EncodedValueReader;
import net.zhuoweizhang.boardwalk.com.android.dex.MethodId;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteInput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.CodeReader;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.CodeReader.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions.DecodedInstruction;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.grep.Grep */
public final class Grep {
    private final CodeReader codeReader;
    private int count = 0;
    private ClassDef currentClass;
    private Method currentMethod;
    private final Dex dex;
    private final PrintWriter out;
    private final Set<Integer> stringIds;

    public Grep(Dex dex2, Pattern pattern, PrintWriter printWriter) {
        CodeReader codeReader2;
        C06601 r8;
        Dex dex3 = dex2;
        Pattern pattern2 = pattern;
        PrintWriter printWriter2 = printWriter;
        CodeReader codeReader3 = codeReader2;
        CodeReader codeReader4 = new CodeReader();
        this.codeReader = codeReader3;
        this.dex = dex3;
        this.out = printWriter2;
        this.stringIds = getStringIds(dex3, pattern2);
        CodeReader codeReader5 = this.codeReader;
        C06601 r5 = r8;
        C06601 r6 = new Visitor(this) {
            final /* synthetic */ Grep this$0;

            {
                this.this$0 = r5;
            }

            public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
                DecodedInstruction[] decodedInstructionArr2 = decodedInstructionArr;
                this.this$0.encounterString(decodedInstruction.getIndex());
            }
        };
        codeReader5.setStringVisitor(r5);
    }

    /* access modifiers changed from: private */
    public void encounterString(int i) {
        StringBuilder sb;
        int i2 = i;
        if (this.stringIds.contains(Integer.valueOf(i2))) {
            PrintWriter printWriter = this.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printWriter.println(sb2.append(location()).append(" ").append((String) this.dex.strings().get(i2)).toString());
            this.count = 1 + this.count;
        }
    }

    private Set<Integer> getStringIds(Dex dex2, Pattern pattern) {
        HashSet hashSet;
        Dex dex3 = dex2;
        Pattern pattern2 = pattern;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        int i = 0;
        for (String matcher : dex3.strings()) {
            if (pattern2.matcher(matcher).find()) {
                boolean add = hashSet4.add(Integer.valueOf(i));
            }
            i++;
        }
        return hashSet4;
    }

    private String location() {
        StringBuilder sb;
        String str = (String) this.dex.typeNames().get(this.currentClass.getTypeIndex());
        if (this.currentMethod != null) {
            MethodId methodId = (MethodId) this.dex.methodIds().get(this.currentMethod.getMethodIndex());
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            str = sb2.append(str).append(".").append((String) this.dex.strings().get(methodId.getNameIndex())).toString();
        }
        return str;
    }

    private void readArray(EncodedValueReader encodedValueReader) {
        EncodedValueReader encodedValueReader2 = encodedValueReader;
        int readArray = encodedValueReader2.readArray();
        for (int i = 0; i < readArray; i++) {
            switch (encodedValueReader2.peek()) {
                case 23:
                    encounterString(encodedValueReader2.readString());
                    break;
                case 28:
                    readArray(encodedValueReader2);
                    break;
            }
        }
    }

    public int grep() {
        EncodedValueReader encodedValueReader;
        for (ClassDef classDef : this.dex.classDefs()) {
            this.currentClass = classDef;
            this.currentMethod = null;
            if (classDef.getClassDataOffset() != 0) {
                ClassData readClassData = this.dex.readClassData(classDef);
                int staticValuesOffset = classDef.getStaticValuesOffset();
                if (staticValuesOffset != 0) {
                    EncodedValueReader encodedValueReader2 = encodedValueReader;
                    EncodedValueReader encodedValueReader3 = new EncodedValueReader((ByteInput) this.dex.open(staticValuesOffset));
                    readArray(encodedValueReader2);
                }
                Method[] allMethods = readClassData.allMethods();
                int length = allMethods.length;
                for (int i = 0; i < length; i++) {
                    Method method = allMethods[i];
                    this.currentMethod = method;
                    if (method.getCodeOffset() != 0) {
                        this.codeReader.visitAll(this.dex.readCode(method).getInstructions());
                    }
                }
            }
        }
        this.currentClass = null;
        this.currentMethod = null;
        return this.count;
    }
}
