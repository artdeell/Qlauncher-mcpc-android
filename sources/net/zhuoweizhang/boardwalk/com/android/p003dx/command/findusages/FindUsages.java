package net.zhuoweizhang.boardwalk.com.android.p003dx.command.findusages;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassData;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassData.Field;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassData.Method;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassDef;
import net.zhuoweizhang.boardwalk.com.android.dex.Dex;
import net.zhuoweizhang.boardwalk.com.android.dex.FieldId;
import net.zhuoweizhang.boardwalk.com.android.dex.MethodId;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.CodeReader;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.CodeReader.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.OpcodeInfo;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions.DecodedInstruction;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.findusages.FindUsages */
public final class FindUsages {
    private final CodeReader codeReader;
    private ClassDef currentClass;
    private Method currentMethod;
    private final Dex dex;
    /* access modifiers changed from: private */
    public final Set<Integer> fieldIds;
    /* access modifiers changed from: private */
    public final Set<Integer> methodIds;
    private final PrintWriter out;

    public FindUsages(Dex dex2, String str, String str2, PrintWriter printWriter) {
        CodeReader codeReader2;
        HashSet hashSet;
        HashSet hashSet2;
        HashSet hashSet3;
        HashSet hashSet4;
        C06581 r25;
        C06592 r252;
        Dex dex3 = dex2;
        String str3 = str;
        String str4 = str2;
        PrintWriter printWriter2 = printWriter;
        CodeReader codeReader3 = codeReader2;
        CodeReader codeReader4 = new CodeReader();
        this.codeReader = codeReader3;
        this.dex = dex3;
        this.out = printWriter2;
        HashSet hashSet5 = hashSet;
        HashSet hashSet6 = new HashSet();
        HashSet<Integer> hashSet7 = hashSet5;
        HashSet hashSet8 = hashSet2;
        HashSet hashSet9 = new HashSet();
        HashSet hashSet10 = hashSet8;
        Pattern compile = Pattern.compile(str3);
        Pattern compile2 = Pattern.compile(str4);
        List strings = dex3.strings();
        for (int i = 0; i < strings.size(); i++) {
            String str5 = (String) strings.get(i);
            if (compile.matcher(str5).matches()) {
                boolean add = hashSet7.add(Integer.valueOf(i));
            }
            if (compile2.matcher(str5).matches()) {
                boolean add2 = hashSet10.add(Integer.valueOf(i));
            }
        }
        if (hashSet7.isEmpty() || hashSet10.isEmpty()) {
            this.fieldIds = null;
            this.methodIds = null;
            return;
        }
        HashSet hashSet11 = hashSet3;
        HashSet hashSet12 = new HashSet();
        this.methodIds = hashSet11;
        HashSet hashSet13 = hashSet4;
        HashSet hashSet14 = new HashSet();
        this.fieldIds = hashSet13;
        for (Integer intValue : hashSet7) {
            int binarySearch = Collections.binarySearch(dex3.typeIds(), Integer.valueOf(intValue.intValue()));
            if (binarySearch >= 0) {
                boolean addAll = this.methodIds.addAll(getMethodIds(dex3, hashSet10, binarySearch));
                boolean addAll2 = this.fieldIds.addAll(getFieldIds(dex3, hashSet10, binarySearch));
            }
        }
        CodeReader codeReader5 = this.codeReader;
        C06581 r20 = r25;
        final PrintWriter printWriter3 = printWriter2;
        final Dex dex4 = dex3;
        C06581 r21 = new Visitor(this) {
            final /* synthetic */ FindUsages this$0;

            {
                PrintWriter printWriter = r8;
                Dex dex = r9;
                this.this$0 = r7;
            }

            public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
                StringBuilder sb;
                DecodedInstruction[] decodedInstructionArr2 = decodedInstructionArr;
                DecodedInstruction decodedInstruction2 = decodedInstruction;
                int index = decodedInstruction2.getIndex();
                if (this.this$0.fieldIds.contains(Integer.valueOf(index))) {
                    PrintWriter printWriter = printWriter3;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    printWriter.println(sb2.append(this.this$0.location()).append(": field reference ").append(dex4.fieldIds().get(index)).append(" (").append(OpcodeInfo.getName(decodedInstruction2.getOpcode())).append(")").toString());
                }
            }
        };
        codeReader5.setFieldVisitor(r20);
        CodeReader codeReader6 = this.codeReader;
        C06592 r202 = r252;
        final PrintWriter printWriter4 = printWriter2;
        final Dex dex5 = dex3;
        C06592 r212 = new Visitor(this) {
            final /* synthetic */ FindUsages this$0;

            {
                PrintWriter printWriter = r8;
                Dex dex = r9;
                this.this$0 = r7;
            }

            public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
                StringBuilder sb;
                DecodedInstruction[] decodedInstructionArr2 = decodedInstructionArr;
                DecodedInstruction decodedInstruction2 = decodedInstruction;
                int index = decodedInstruction2.getIndex();
                if (this.this$0.methodIds.contains(Integer.valueOf(index))) {
                    PrintWriter printWriter = printWriter4;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    printWriter.println(sb2.append(this.this$0.location()).append(": method reference ").append(dex5.methodIds().get(index)).append(" (").append(OpcodeInfo.getName(decodedInstruction2.getOpcode())).append(")").toString());
                }
            }
        };
        codeReader6.setMethodVisitor(r202);
    }

    private Set<Integer> findAssignableTypes(Dex dex2, int i) {
        HashSet hashSet;
        Dex dex3 = dex2;
        int i2 = i;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        boolean add = hashSet4.add(Integer.valueOf(i2));
        for (ClassDef classDef : dex3.classDefs()) {
            if (hashSet4.contains(Integer.valueOf(classDef.getSupertypeIndex()))) {
                boolean add2 = hashSet4.add(Integer.valueOf(classDef.getTypeIndex()));
            } else {
                short[] interfaces = classDef.getInterfaces();
                int length = interfaces.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (hashSet4.contains(Integer.valueOf(interfaces[i3]))) {
                        boolean add3 = hashSet4.add(Integer.valueOf(classDef.getTypeIndex()));
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        return hashSet4;
    }

    private Set<Integer> getFieldIds(Dex dex2, Set<Integer> set, int i) {
        HashSet hashSet;
        Dex dex3 = dex2;
        Set<Integer> set2 = set;
        int i2 = i;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        int i3 = 0;
        for (FieldId fieldId : dex3.fieldIds()) {
            if (set2.contains(Integer.valueOf(fieldId.getNameIndex())) && i2 == fieldId.getDeclaringClassIndex()) {
                boolean add = hashSet4.add(Integer.valueOf(i3));
            }
            i3++;
        }
        return hashSet4;
    }

    private Set<Integer> getMethodIds(Dex dex2, Set<Integer> set, int i) {
        HashSet hashSet;
        Dex dex3 = dex2;
        Set<Integer> set2 = set;
        Set findAssignableTypes = findAssignableTypes(dex3, i);
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        int i2 = 0;
        for (MethodId methodId : dex3.methodIds()) {
            if (set2.contains(Integer.valueOf(methodId.getNameIndex())) && findAssignableTypes.contains(Integer.valueOf(methodId.getDeclaringClassIndex()))) {
                boolean add = hashSet4.add(Integer.valueOf(i2));
            }
            i2++;
        }
        return hashSet4;
    }

    /* access modifiers changed from: private */
    public String location() {
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

    public void findUsages() {
        StringBuilder sb;
        StringBuilder sb2;
        if (this.fieldIds != null && this.methodIds != null) {
            for (ClassDef classDef : this.dex.classDefs()) {
                this.currentClass = classDef;
                this.currentMethod = null;
                if (classDef.getClassDataOffset() != 0) {
                    ClassData readClassData = this.dex.readClassData(classDef);
                    Field[] allFields = readClassData.allFields();
                    int length = allFields.length;
                    for (int i = 0; i < length; i++) {
                        int fieldIndex = allFields[i].getFieldIndex();
                        if (this.fieldIds.contains(Integer.valueOf(fieldIndex))) {
                            PrintWriter printWriter = this.out;
                            StringBuilder sb3 = sb2;
                            StringBuilder sb4 = new StringBuilder();
                            printWriter.println(sb3.append(location()).append(" field declared ").append(this.dex.fieldIds().get(fieldIndex)).toString());
                        }
                    }
                    Method[] allMethods = readClassData.allMethods();
                    int length2 = allMethods.length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        Method method = allMethods[i2];
                        this.currentMethod = method;
                        int methodIndex = method.getMethodIndex();
                        if (this.methodIds.contains(Integer.valueOf(methodIndex))) {
                            PrintWriter printWriter2 = this.out;
                            StringBuilder sb5 = sb;
                            StringBuilder sb6 = new StringBuilder();
                            printWriter2.println(sb5.append(location()).append(" method declared ").append(this.dex.methodIds().get(methodIndex)).toString());
                        }
                        if (method.getCodeOffset() != 0) {
                            this.codeReader.visitAll(this.dex.readCode(method).getInstructions());
                        }
                    }
                }
            }
            this.currentClass = null;
            this.currentMethod = null;
        }
    }
}
