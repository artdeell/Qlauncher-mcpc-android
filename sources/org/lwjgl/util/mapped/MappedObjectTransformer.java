package org.lwjgl.util.mapped;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;
import org.objectweb.asm.util.TraceClassVisitor;

public class MappedObjectTransformer {
    static final /* synthetic */ boolean $assertionsDisabled = (!MappedObjectTransformer.class.desiredAssertionStatus());
    static final String ALIGN_METHOD_NAME = "getAlign";
    static final String CACHE_LINE_PAD_JVM;
    static final String CAPACITY_METHOD_NAME = "capacity";
    static final Map<Integer, String> INSNTYPE_TO_NAME;
    static final String MAPPEDSET_PREFIX = jvmClassName(MappedSet.class);
    static final String MAPPED_HELPER_JVM = jvmClassName(MappedHelper.class);
    static final String MAPPED_OBJECT_JVM = jvmClassName(MappedObject.class);
    static final String MAPPED_SET2_JVM = jvmClassName(MappedSet2.class);
    static final String MAPPED_SET3_JVM = jvmClassName(MappedSet3.class);
    static final String MAPPED_SET4_JVM = jvmClassName(MappedSet4.class);
    static final String NEXT_METHOD_NAME = "next";
    static final Map<Integer, String> OPCODE_TO_NAME;
    static final boolean PRINT_ACTIVITY = (LWJGLUtil.DEBUG && LWJGLUtil.getPrivilegedBoolean("org.lwjgl.util.mapped.PrintActivity"));
    static final boolean PRINT_BYTECODE = (LWJGLUtil.DEBUG && LWJGLUtil.getPrivilegedBoolean("org.lwjgl.util.mapped.PrintBytecode"));
    static final boolean PRINT_TIMING = (PRINT_ACTIVITY && LWJGLUtil.getPrivilegedBoolean("org.lwjgl.util.mapped.PrintTiming"));
    static final String SIZEOF_METHOD_NAME = "getSizeof";
    static final String VIEWADDRESS_METHOD_NAME = "getViewAddress";
    static final String VIEW_CONSTRUCTOR_NAME = "constructView$LWJGL";
    static final Map<String, MappedSubtypeInfo> className_to_subtype;
    static boolean is_currently_computing_frames;

    private static class FieldInfo {
        final boolean isPointer;
        final boolean isVolatile;
        final long length;
        final long lengthPadded;
        final long offset;
        final Type type;

        FieldInfo(long j, long j2, long j3, Type type2, boolean z, boolean z2) {
            long j4 = j2;
            long j5 = j3;
            Type type3 = type2;
            boolean z3 = z;
            boolean z4 = z2;
            this.offset = j;
            this.length = j4;
            this.lengthPadded = j5;
            this.type = type3;
            this.isVolatile = z3;
            this.isPointer = z4;
        }

        /* access modifiers changed from: 0000 */
        public String getAccessType() {
            StringBuilder sb;
            if (this.isPointer) {
                return "a";
            }
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append(this.type.getDescriptor().toLowerCase()).append(this.isVolatile ? RegisterSpec.PREFIX : LibrariesRepository.MOJANG_MAVEN_REPO).toString();
        }
    }

    private static class MappedSubtypeInfo {
        final int align;
        final boolean cacheLinePadded;
        final String className;
        final Map<String, FieldInfo> fields;
        final int padding;
        final int sizeof;
        final int sizeof_shift;

        MappedSubtypeInfo(String str, Map<String, FieldInfo> map, int i, int i2, int i3, boolean z) {
            Map<String, FieldInfo> map2 = map;
            int i4 = i;
            int i5 = i2;
            int i6 = i3;
            boolean z2 = z;
            this.className = str;
            this.sizeof = i4;
            if ((i4 & (i4 - 1)) == 0) {
                this.sizeof_shift = getPoT(i4);
            } else {
                this.sizeof_shift = 0;
            }
            this.align = i5;
            this.padding = i6;
            this.cacheLinePadded = z2;
            this.fields = map2;
        }

        private static int getPoT(int i) {
            int i2 = -1;
            for (int i3 = i; i3 > 0; i3 >>= 1) {
                i2++;
            }
            return i2;
        }
    }

    private static class TransformationAdapter extends ClassAdapter {
        final String className;
        boolean transformed;

        TransformationAdapter(ClassVisitor classVisitor, String str) {
            String str2 = str;
            super(classVisitor);
            this.className = str2;
        }

        /* JADX WARNING: type inference failed for: r15v0 */
        /* JADX WARNING: type inference failed for: r7v9 */
        /* JADX WARNING: type inference failed for: r0v2, types: [org.objectweb.asm.FieldVisitor] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.objectweb.asm.FieldVisitor visitField(int r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Object r21) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r20
                r5 = r21
                java.util.Map<java.lang.String, org.lwjgl.util.mapped.MappedObjectTransformer$MappedSubtypeInfo> r7 = org.lwjgl.util.mapped.MappedObjectTransformer.className_to_subtype
                r8 = r0
                java.lang.String r8 = r8.className
                java.lang.Object r7 = r7.get(r8)
                org.lwjgl.util.mapped.MappedObjectTransformer$MappedSubtypeInfo r7 = (org.lwjgl.util.mapped.MappedObjectTransformer.MappedSubtypeInfo) r7
                r6 = r7
                r7 = r6
                if (r7 == 0) goto L_0x0068
                r7 = r6
                java.util.Map<java.lang.String, org.lwjgl.util.mapped.MappedObjectTransformer$FieldInfo> r7 = r7.fields
                r8 = r2
                boolean r7 = r7.containsKey(r8)
                if (r7 == 0) goto L_0x0068
                boolean r7 = org.lwjgl.util.mapped.MappedObjectTransformer.PRINT_ACTIVITY
                if (r7 == 0) goto L_0x0065
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r15 = r7
                r7 = r15
                r8 = r15
                r8.<init>()
                java.lang.Class<org.lwjgl.util.mapped.MappedObjectTransformer> r8 = org.lwjgl.util.mapped.MappedObjectTransformer.class
                java.lang.String r8 = r8.getSimpleName()
                java.lang.StringBuilder r7 = r7.append(r8)
                java.lang.String r8 = ": discarding field: "
                java.lang.StringBuilder r7 = r7.append(r8)
                r8 = r0
                java.lang.String r8 = r8.className
                java.lang.StringBuilder r7 = r7.append(r8)
                java.lang.String r8 = "."
                java.lang.StringBuilder r7 = r7.append(r8)
                r8 = r2
                java.lang.StringBuilder r7 = r7.append(r8)
                java.lang.String r8 = ":"
                java.lang.StringBuilder r7 = r7.append(r8)
                r8 = r3
                java.lang.StringBuilder r7 = r7.append(r8)
                java.lang.String r7 = r7.toString()
                org.lwjgl.LWJGLUtil.log(r7)
            L_0x0065:
                r7 = 0
                r0 = r7
            L_0x0067:
                return r0
            L_0x0068:
                r7 = r1
                r8 = 8
                r7 = r7 & 8
                if (r7 != 0) goto L_0x007f
                org.lwjgl.util.mapped.MappedObjectTransformer$TransformationAdapter$1 r7 = new org.lwjgl.util.mapped.MappedObjectTransformer$TransformationAdapter$1
                r15 = r7
                r7 = r15
                r8 = r15
                r9 = r0
                r10 = r1
                r11 = r2
                r12 = r3
                r13 = r4
                r14 = r5
                r8.<init>(r9, r10, r11, r12, r13, r14)
                r0 = r7
                goto L_0x0067
            L_0x007f:
                r7 = r0
                r8 = r1
                r9 = r2
                r10 = r3
                r11 = r4
                r12 = r5
                org.objectweb.asm.FieldVisitor r7 = org.lwjgl.util.mapped.MappedObjectTransformer.super.visitField(r8, r9, r10, r11, r12)
                r0 = r7
                goto L_0x0067
            */
            throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.mapped.MappedObjectTransformer.TransformationAdapter.visitField(int, java.lang.String, java.lang.String, java.lang.String, java.lang.Object):org.objectweb.asm.FieldVisitor");
        }

        /* JADX WARNING: type inference failed for: r17v0 */
        /* JADX WARNING: type inference failed for: r8v5 */
        /* JADX WARNING: type inference failed for: r0v1, types: [org.objectweb.asm.MethodVisitor] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.objectweb.asm.MethodVisitor visitMethod(int r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String[] r23) {
            /*
                r18 = this;
                r0 = r18
                r1 = r19
                r2 = r20
                r3 = r21
                r4 = r22
                r5 = r23
                java.lang.String r8 = "<init>"
                r9 = r2
                boolean r8 = r8.equals(r9)
                if (r8 == 0) goto L_0x0085
                java.util.Map<java.lang.String, org.lwjgl.util.mapped.MappedObjectTransformer$MappedSubtypeInfo> r8 = org.lwjgl.util.mapped.MappedObjectTransformer.className_to_subtype
                r9 = r0
                java.lang.String r9 = r9.className
                java.lang.Object r8 = r8.get(r9)
                org.lwjgl.util.mapped.MappedObjectTransformer$MappedSubtypeInfo r8 = (org.lwjgl.util.mapped.MappedObjectTransformer.MappedSubtypeInfo) r8
                if (r8 == 0) goto L_0x0085
                java.lang.String r8 = "()V"
                r9 = r3
                boolean r8 = r8.equals(r9)
                if (r8 != 0) goto L_0x0058
                java.lang.ClassFormatError r8 = new java.lang.ClassFormatError
                r17 = r8
                r8 = r17
                r9 = r17
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r17 = r10
                r10 = r17
                r11 = r17
                r11.<init>()
                r11 = r0
                java.lang.String r11 = r11.className
                java.lang.StringBuilder r10 = r10.append(r11)
                java.lang.String r11 = " can only have a default constructor, found: "
                java.lang.StringBuilder r10 = r10.append(r11)
                r11 = r3
                java.lang.StringBuilder r10 = r10.append(r11)
                java.lang.String r10 = r10.toString()
                r9.<init>(r10)
                throw r8
            L_0x0058:
                r8 = r0
                r9 = r1
                r10 = r2
                r11 = r3
                r12 = r4
                r13 = r5
                org.objectweb.asm.MethodVisitor r8 = org.lwjgl.util.mapped.MappedObjectTransformer.super.visitMethod(r9, r10, r11, r12, r13)
                r7 = r8
                r8 = r7
                r9 = 25
                r10 = 0
                r8.visitVarInsn(r9, r10)
                r8 = r7
                r9 = 183(0xb7, float:2.56E-43)
                java.lang.String r10 = org.lwjgl.util.mapped.MappedObjectTransformer.MAPPED_OBJECT_JVM
                java.lang.String r11 = "<init>"
                java.lang.String r12 = "()V"
                r8.visitMethodInsn(r9, r10, r11, r12)
                r8 = r7
                r9 = 177(0xb1, float:2.48E-43)
                r8.visitInsn(r9)
                r8 = r7
                r9 = 0
                r10 = 0
                r8.visitMaxs(r9, r10)
                java.lang.String r8 = "constructView$LWJGL"
                r2 = r8
            L_0x0085:
                r8 = r0
                r9 = r1
                r10 = r2
                r11 = r3
                r12 = r4
                r13 = r5
                org.objectweb.asm.MethodVisitor r8 = org.lwjgl.util.mapped.MappedObjectTransformer.super.visitMethod(r9, r10, r11, r12, r13)
                r6 = r8
                org.lwjgl.util.mapped.MappedObjectTransformer$TransformationAdapter$2 r8 = new org.lwjgl.util.mapped.MappedObjectTransformer$TransformationAdapter$2
                r17 = r8
                r8 = r17
                r9 = r17
                r10 = r0
                r11 = r1
                r12 = r2
                r13 = r3
                r14 = r4
                r15 = r5
                r16 = r6
                r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                r0 = r8
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.mapped.MappedObjectTransformer.TransformationAdapter.visitMethod(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):org.objectweb.asm.MethodVisitor");
        }
    }

    static {
        StringBuilder sb;
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        MappedSubtypeInfo mappedSubtypeInfo;
        StringBuilder sb2;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        CACHE_LINE_PAD_JVM = sb3.append("L").append(jvmClassName(CacheLinePad.class)).append(";").toString();
        HashMap hashMap4 = hashMap;
        HashMap hashMap5 = new HashMap();
        OPCODE_TO_NAME = hashMap4;
        HashMap hashMap6 = hashMap2;
        HashMap hashMap7 = new HashMap();
        INSNTYPE_TO_NAME = hashMap6;
        Map<Integer, String> map = OPCODE_TO_NAME;
        String[] strArr = new String[5];
        String[] strArr2 = strArr;
        strArr[0] = "V1_";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "ACC_";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = "T_";
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[3] = "F_";
        String[] strArr9 = strArr8;
        String[] strArr10 = strArr9;
        strArr9[4] = "MH_";
        getClassEnums(Opcodes.class, map, strArr10);
        getClassEnums(AbstractInsnNode.class, INSNTYPE_TO_NAME, new String[0]);
        HashMap hashMap8 = hashMap3;
        HashMap hashMap9 = new HashMap();
        className_to_subtype = hashMap8;
        Map<String, MappedSubtypeInfo> map2 = className_to_subtype;
        String str = MAPPED_OBJECT_JVM;
        MappedSubtypeInfo mappedSubtypeInfo2 = mappedSubtypeInfo;
        MappedSubtypeInfo mappedSubtypeInfo3 = new MappedSubtypeInfo(MAPPED_OBJECT_JVM, null, -1, -1, -1, false);
        Object put = map2.put(str, mappedSubtypeInfo2);
        String property = System.getProperty("java.vm.name");
        if (property != null && !property.contains("Server")) {
            PrintStream printStream = System.err;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            printStream.println(sb5.append("Warning: ").append(MappedObject.class.getSimpleName()).append("s have inferiour performance on Client VMs, please consider switching to a Server VM.").toString());
        }
    }

    public MappedObjectTransformer() {
    }

    private static void checkInsnAfterIsArray(AbstractInsnNode abstractInsnNode, int i) {
        ClassFormatError classFormatError;
        StringBuilder sb;
        ClassFormatError classFormatError2;
        AbstractInsnNode abstractInsnNode2 = abstractInsnNode;
        int i2 = i;
        if (abstractInsnNode2 == null) {
            ClassFormatError classFormatError3 = classFormatError2;
            ClassFormatError classFormatError4 = new ClassFormatError("Unexpected end of instructions after .asArray() method.");
            throw classFormatError3;
        } else if (abstractInsnNode2.getOpcode() != i2) {
            ClassFormatError classFormatError5 = classFormatError;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            ClassFormatError classFormatError6 = new ClassFormatError(sb2.append("The result of .asArray() must be stored to a local variable. Found: ").append(getOpcodeName(abstractInsnNode2)).toString());
            throw classFormatError5;
        }
    }

    private static InsnList generateAddressInstructions(FieldInsnNode fieldInsnNode) {
        InternalError internalError;
        IllegalStateException illegalStateException;
        FieldInsnNode fieldInsnNode2 = fieldInsnNode;
        if (!"J".equals(fieldInsnNode2.desc)) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException();
            throw illegalStateException2;
        } else if (fieldInsnNode2.getOpcode() == 180) {
            return null;
        } else {
            if (fieldInsnNode2.getOpcode() == 181) {
                throwAccessErrorOnReadOnlyField(fieldInsnNode2.owner, fieldInsnNode2.name);
            }
            InternalError internalError2 = internalError;
            InternalError internalError3 = new InternalError();
            throw internalError2;
        }
    }

    private static InsnList generateByteBufferInstructions(FieldInsnNode fieldInsnNode, MappedSubtypeInfo mappedSubtypeInfo, long j) {
        InternalError internalError;
        InsnList insnList;
        AbstractInsnNode abstractInsnNode;
        AbstractInsnNode abstractInsnNode2;
        AbstractInsnNode abstractInsnNode3;
        AbstractInsnNode abstractInsnNode4;
        AbstractInsnNode abstractInsnNode5;
        AbstractInsnNode abstractInsnNode6;
        StringBuilder sb;
        FieldInsnNode fieldInsnNode2 = fieldInsnNode;
        MappedSubtypeInfo mappedSubtypeInfo2 = mappedSubtypeInfo;
        long j2 = j;
        if (fieldInsnNode2.getOpcode() == 181) {
            throwAccessErrorOnReadOnlyField(fieldInsnNode2.owner, fieldInsnNode2.name);
        }
        if (fieldInsnNode2.getOpcode() == 180) {
            InsnList insnList2 = insnList;
            InsnList insnList3 = new InsnList();
            InsnList insnList4 = insnList2;
            InsnList insnList5 = insnList4;
            AbstractInsnNode abstractInsnNode7 = abstractInsnNode;
            AbstractInsnNode fieldInsnNode3 = new FieldInsnNode(180, mappedSubtypeInfo2.className, "viewAddress", "J");
            insnList5.add(abstractInsnNode7);
            InsnList insnList6 = insnList4;
            AbstractInsnNode abstractInsnNode8 = abstractInsnNode2;
            AbstractInsnNode ldcInsnNode = new LdcInsnNode(Long.valueOf(j2));
            insnList6.add(abstractInsnNode8);
            InsnList insnList7 = insnList4;
            AbstractInsnNode abstractInsnNode9 = abstractInsnNode3;
            AbstractInsnNode insnNode = new InsnNode(97);
            insnList7.add(abstractInsnNode9);
            InsnList insnList8 = insnList4;
            AbstractInsnNode abstractInsnNode10 = abstractInsnNode4;
            AbstractInsnNode ldcInsnNode2 = new LdcInsnNode(Long.valueOf(((FieldInfo) mappedSubtypeInfo2.fields.get(fieldInsnNode2.name)).length));
            insnList8.add(abstractInsnNode10);
            InsnList insnList9 = insnList4;
            AbstractInsnNode abstractInsnNode11 = abstractInsnNode5;
            AbstractInsnNode insnNode2 = new InsnNode(136);
            insnList9.add(abstractInsnNode11);
            InsnList insnList10 = insnList4;
            AbstractInsnNode abstractInsnNode12 = abstractInsnNode6;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            AbstractInsnNode methodInsnNode = new MethodInsnNode(184, MAPPED_HELPER_JVM, "newBuffer", sb2.append("(JI)L").append(jvmClassName(ByteBuffer.class)).append(";").toString());
            insnList10.add(abstractInsnNode12);
            return insnList4;
        }
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError();
        throw internalError2;
    }

    private static InsnList generateCopyRangeInstructions(MappedSubtypeInfo mappedSubtypeInfo) {
        InsnList insnList;
        AbstractInsnNode abstractInsnNode;
        AbstractInsnNode abstractInsnNode2;
        StringBuilder sb;
        MappedSubtypeInfo mappedSubtypeInfo2 = mappedSubtypeInfo;
        InsnList insnList2 = insnList;
        InsnList insnList3 = new InsnList();
        InsnList insnList4 = insnList2;
        insnList4.add(getIntNode(mappedSubtypeInfo2.sizeof));
        InsnList insnList5 = insnList4;
        AbstractInsnNode abstractInsnNode3 = abstractInsnNode;
        AbstractInsnNode insnNode = new InsnNode(104);
        insnList5.add(abstractInsnNode3);
        InsnList insnList6 = insnList4;
        AbstractInsnNode abstractInsnNode4 = abstractInsnNode2;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        AbstractInsnNode methodInsnNode = new MethodInsnNode(184, MAPPED_HELPER_JVM, "copy", sb2.append("(L").append(MAPPED_OBJECT_JVM).append(";L").append(MAPPED_OBJECT_JVM).append(";I)V").toString());
        insnList6.add(abstractInsnNode4);
        return insnList4;
    }

    private static InsnList generateCopyToInstructions(MappedSubtypeInfo mappedSubtypeInfo) {
        InsnList insnList;
        AbstractInsnNode abstractInsnNode;
        StringBuilder sb;
        MappedSubtypeInfo mappedSubtypeInfo2 = mappedSubtypeInfo;
        InsnList insnList2 = insnList;
        InsnList insnList3 = new InsnList();
        InsnList insnList4 = insnList2;
        insnList4.add(getIntNode(mappedSubtypeInfo2.sizeof - mappedSubtypeInfo2.padding));
        InsnList insnList5 = insnList4;
        AbstractInsnNode abstractInsnNode2 = abstractInsnNode;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        AbstractInsnNode methodInsnNode = new MethodInsnNode(184, MAPPED_HELPER_JVM, "copy", sb2.append("(L").append(MAPPED_OBJECT_JVM).append(";L").append(MAPPED_OBJECT_JVM).append(";I)V").toString());
        insnList5.add(abstractInsnNode2);
        return insnList4;
    }

    private static InsnList generateDupInstructions(MethodInsnNode methodInsnNode) {
        InsnList insnList;
        AbstractInsnNode abstractInsnNode;
        AbstractInsnNode abstractInsnNode2;
        AbstractInsnNode abstractInsnNode3;
        AbstractInsnNode abstractInsnNode4;
        StringBuilder sb;
        MethodInsnNode methodInsnNode2 = methodInsnNode;
        InsnList insnList2 = insnList;
        InsnList insnList3 = new InsnList();
        InsnList insnList4 = insnList2;
        InsnList insnList5 = insnList4;
        AbstractInsnNode abstractInsnNode5 = abstractInsnNode;
        AbstractInsnNode typeInsnNode = new TypeInsnNode(187, methodInsnNode2.owner);
        insnList5.add(abstractInsnNode5);
        InsnList insnList6 = insnList4;
        AbstractInsnNode abstractInsnNode6 = abstractInsnNode2;
        AbstractInsnNode insnNode = new InsnNode(89);
        insnList6.add(abstractInsnNode6);
        InsnList insnList7 = insnList4;
        AbstractInsnNode abstractInsnNode7 = abstractInsnNode3;
        AbstractInsnNode methodInsnNode3 = new MethodInsnNode(183, methodInsnNode2.owner, "<init>", "()V");
        insnList7.add(abstractInsnNode7);
        InsnList insnList8 = insnList4;
        AbstractInsnNode abstractInsnNode8 = abstractInsnNode4;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        AbstractInsnNode methodInsnNode4 = new MethodInsnNode(184, MAPPED_HELPER_JVM, "dup", sb2.append("(L").append(MAPPED_OBJECT_JVM).append(";L").append(MAPPED_OBJECT_JVM).append(";)L").append(MAPPED_OBJECT_JVM).append(";").toString());
        insnList8.add(abstractInsnNode8);
        return insnList4;
    }

    private static InsnList generateFieldInstructions(FieldInsnNode fieldInsnNode, FieldInfo fieldInfo) {
        InsnList insnList;
        InternalError internalError;
        AbstractInsnNode abstractInsnNode;
        StringBuilder sb;
        StringBuilder sb2;
        AbstractInsnNode abstractInsnNode2;
        StringBuilder sb3;
        StringBuilder sb4;
        FieldInsnNode fieldInsnNode2 = fieldInsnNode;
        FieldInfo fieldInfo2 = fieldInfo;
        InsnList insnList2 = insnList;
        InsnList insnList3 = new InsnList();
        InsnList insnList4 = insnList2;
        if (fieldInsnNode2.getOpcode() == 181) {
            insnList4.add(getIntNode((int) fieldInfo2.offset));
            InsnList insnList5 = insnList4;
            AbstractInsnNode abstractInsnNode3 = abstractInsnNode2;
            String str = MAPPED_HELPER_JVM;
            StringBuilder sb5 = sb3;
            StringBuilder sb6 = new StringBuilder();
            String sb7 = sb5.append(fieldInfo2.getAccessType()).append("put").toString();
            StringBuilder sb8 = sb4;
            StringBuilder sb9 = new StringBuilder();
            AbstractInsnNode methodInsnNode = new MethodInsnNode(184, str, sb7, sb8.append("(L").append(MAPPED_OBJECT_JVM).append(";").append(fieldInsnNode2.desc).append("I)V").toString());
            insnList5.add(abstractInsnNode3);
            return insnList4;
        } else if (fieldInsnNode2.getOpcode() == 180) {
            insnList4.add(getIntNode((int) fieldInfo2.offset));
            InsnList insnList6 = insnList4;
            AbstractInsnNode abstractInsnNode4 = abstractInsnNode;
            String str2 = MAPPED_HELPER_JVM;
            StringBuilder sb10 = sb;
            StringBuilder sb11 = new StringBuilder();
            String sb12 = sb10.append(fieldInfo2.getAccessType()).append("get").toString();
            StringBuilder sb13 = sb2;
            StringBuilder sb14 = new StringBuilder();
            AbstractInsnNode methodInsnNode2 = new MethodInsnNode(184, str2, sb12, sb13.append("(L").append(MAPPED_OBJECT_JVM).append(";I)").append(fieldInsnNode2.desc).toString());
            insnList6.add(abstractInsnNode4);
            return insnList4;
        } else {
            InternalError internalError2 = internalError;
            InternalError internalError3 = new InternalError();
            throw internalError2;
        }
    }

    private static InsnList generateMapInstructions(MappedSubtypeInfo mappedSubtypeInfo, String str, boolean z, boolean z2) {
        InsnList insnList;
        AbstractInsnNode abstractInsnNode;
        StringBuilder sb;
        AbstractInsnNode abstractInsnNode2;
        AbstractInsnNode abstractInsnNode3;
        AbstractInsnNode abstractInsnNode4;
        AbstractInsnNode abstractInsnNode5;
        AbstractInsnNode abstractInsnNode6;
        AbstractInsnNode abstractInsnNode7;
        StringBuilder sb2;
        AbstractInsnNode abstractInsnNode8;
        AbstractInsnNode abstractInsnNode9;
        StringBuilder sb3;
        MappedSubtypeInfo mappedSubtypeInfo2 = mappedSubtypeInfo;
        String str2 = str;
        boolean z3 = z;
        boolean z4 = z2;
        InsnList insnList2 = insnList;
        InsnList insnList3 = new InsnList();
        InsnList insnList4 = insnList2;
        if (z4) {
            insnList4.add(getIntNode(mappedSubtypeInfo2.sizeof));
            InsnList insnList5 = insnList4;
            AbstractInsnNode abstractInsnNode10 = abstractInsnNode8;
            AbstractInsnNode insnNode = new InsnNode(104);
            insnList5.add(abstractInsnNode10);
            String jvmClassName = mappedSubtypeInfo2.cacheLinePadded ? jvmClassName(CacheUtil.class) : jvmClassName(BufferUtils.class);
            InsnList insnList6 = insnList4;
            AbstractInsnNode abstractInsnNode11 = abstractInsnNode9;
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            AbstractInsnNode methodInsnNode = new MethodInsnNode(184, jvmClassName, "createByteBuffer", sb4.append("(I)L").append(jvmClassName(ByteBuffer.class)).append(";").toString());
            insnList6.add(abstractInsnNode11);
        } else if (z3) {
            InsnList insnList7 = insnList4;
            AbstractInsnNode abstractInsnNode12 = abstractInsnNode;
            StringBuilder sb6 = sb;
            StringBuilder sb7 = new StringBuilder();
            AbstractInsnNode methodInsnNode2 = new MethodInsnNode(184, MAPPED_HELPER_JVM, "newBuffer", sb6.append("(JI)L").append(jvmClassName(ByteBuffer.class)).append(";").toString());
            insnList7.add(abstractInsnNode12);
        }
        InsnList insnList8 = insnList4;
        AbstractInsnNode abstractInsnNode13 = abstractInsnNode2;
        AbstractInsnNode typeInsnNode = new TypeInsnNode(187, str2);
        insnList8.add(abstractInsnNode13);
        InsnList insnList9 = insnList4;
        AbstractInsnNode abstractInsnNode14 = abstractInsnNode3;
        AbstractInsnNode insnNode2 = new InsnNode(89);
        insnList9.add(abstractInsnNode14);
        InsnList insnList10 = insnList4;
        AbstractInsnNode abstractInsnNode15 = abstractInsnNode4;
        AbstractInsnNode methodInsnNode3 = new MethodInsnNode(183, str2, "<init>", "()V");
        insnList10.add(abstractInsnNode15);
        InsnList insnList11 = insnList4;
        AbstractInsnNode abstractInsnNode16 = abstractInsnNode5;
        AbstractInsnNode insnNode3 = new InsnNode(90);
        insnList11.add(abstractInsnNode16);
        InsnList insnList12 = insnList4;
        AbstractInsnNode abstractInsnNode17 = abstractInsnNode6;
        AbstractInsnNode insnNode4 = new InsnNode(95);
        insnList12.add(abstractInsnNode17);
        insnList4.add(getIntNode(mappedSubtypeInfo2.align));
        insnList4.add(getIntNode(mappedSubtypeInfo2.sizeof));
        InsnList insnList13 = insnList4;
        AbstractInsnNode abstractInsnNode18 = abstractInsnNode7;
        StringBuilder sb8 = sb2;
        StringBuilder sb9 = new StringBuilder();
        AbstractInsnNode methodInsnNode4 = new MethodInsnNode(184, MAPPED_HELPER_JVM, "setup", sb8.append("(L").append(MAPPED_OBJECT_JVM).append(";Ljava/nio/ByteBuffer;II)V").toString());
        insnList13.add(abstractInsnNode18);
        return insnList4;
    }

    private static InsnList generateRunViewConstructorInstructions(MethodInsnNode methodInsnNode) {
        InsnList insnList;
        AbstractInsnNode abstractInsnNode;
        AbstractInsnNode abstractInsnNode2;
        MethodInsnNode methodInsnNode2 = methodInsnNode;
        InsnList insnList2 = insnList;
        InsnList insnList3 = new InsnList();
        InsnList insnList4 = insnList2;
        InsnList insnList5 = insnList4;
        AbstractInsnNode abstractInsnNode3 = abstractInsnNode;
        AbstractInsnNode insnNode = new InsnNode(89);
        insnList5.add(abstractInsnNode3);
        InsnList insnList6 = insnList4;
        AbstractInsnNode abstractInsnNode4 = abstractInsnNode2;
        AbstractInsnNode methodInsnNode3 = new MethodInsnNode(182, methodInsnNode2.owner, VIEW_CONSTRUCTOR_NAME, "()V");
        insnList6.add(abstractInsnNode4);
        return insnList4;
    }

    private static InsnList generateSIZEOFInstructions(FieldInsnNode fieldInsnNode, MappedSubtypeInfo mappedSubtypeInfo) {
        InsnList insnList;
        InternalError internalError;
        InternalError internalError2;
        FieldInsnNode fieldInsnNode2 = fieldInsnNode;
        MappedSubtypeInfo mappedSubtypeInfo2 = mappedSubtypeInfo;
        if (!"I".equals(fieldInsnNode2.desc)) {
            InternalError internalError3 = internalError2;
            InternalError internalError4 = new InternalError();
            throw internalError3;
        }
        InsnList insnList2 = insnList;
        InsnList insnList3 = new InsnList();
        InsnList insnList4 = insnList2;
        if (fieldInsnNode2.getOpcode() == 178) {
            insnList4.add(getIntNode(mappedSubtypeInfo2.sizeof));
            return insnList4;
        }
        if (fieldInsnNode2.getOpcode() == 179) {
            throwAccessErrorOnReadOnlyField(fieldInsnNode2.owner, fieldInsnNode2.name);
        }
        InternalError internalError5 = internalError;
        InternalError internalError6 = new InternalError();
        throw internalError5;
    }

    private static InsnList generateSetViewInstructions(FieldInsnNode fieldInsnNode) {
        InsnList insnList;
        InternalError internalError;
        AbstractInsnNode abstractInsnNode;
        StringBuilder sb;
        AbstractInsnNode abstractInsnNode2;
        StringBuilder sb2;
        AbstractInsnNode abstractInsnNode3;
        StringBuilder sb3;
        InternalError internalError2;
        FieldInsnNode fieldInsnNode2 = fieldInsnNode;
        if (fieldInsnNode2.getOpcode() == 180) {
            throwAccessErrorOnReadOnlyField(fieldInsnNode2.owner, fieldInsnNode2.name);
        }
        if (fieldInsnNode2.getOpcode() != 181) {
            InternalError internalError3 = internalError2;
            InternalError internalError4 = new InternalError();
            throw internalError3;
        }
        InsnList insnList2 = insnList;
        InsnList insnList3 = new InsnList();
        InsnList insnList4 = insnList2;
        if (MAPPED_SET2_JVM.equals(fieldInsnNode2.owner)) {
            InsnList insnList5 = insnList4;
            AbstractInsnNode abstractInsnNode4 = abstractInsnNode3;
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            AbstractInsnNode methodInsnNode = new MethodInsnNode(184, MAPPED_HELPER_JVM, "put_views", sb4.append("(L").append(MAPPED_SET2_JVM).append(";I)V").toString());
            insnList5.add(abstractInsnNode4);
            return insnList4;
        } else if (MAPPED_SET3_JVM.equals(fieldInsnNode2.owner)) {
            InsnList insnList6 = insnList4;
            AbstractInsnNode abstractInsnNode5 = abstractInsnNode2;
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            AbstractInsnNode methodInsnNode2 = new MethodInsnNode(184, MAPPED_HELPER_JVM, "put_views", sb6.append("(L").append(MAPPED_SET3_JVM).append(";I)V").toString());
            insnList6.add(abstractInsnNode5);
            return insnList4;
        } else if (MAPPED_SET4_JVM.equals(fieldInsnNode2.owner)) {
            InsnList insnList7 = insnList4;
            AbstractInsnNode abstractInsnNode6 = abstractInsnNode;
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            AbstractInsnNode methodInsnNode3 = new MethodInsnNode(184, MAPPED_HELPER_JVM, "put_views", sb8.append("(L").append(MAPPED_SET4_JVM).append(";I)V").toString());
            insnList7.add(abstractInsnNode6);
            return insnList4;
        } else {
            InternalError internalError5 = internalError;
            InternalError internalError6 = new InternalError();
            throw internalError5;
        }
    }

    private static InsnList generateSliceInstructions(MethodInsnNode methodInsnNode) {
        InsnList insnList;
        AbstractInsnNode abstractInsnNode;
        AbstractInsnNode abstractInsnNode2;
        AbstractInsnNode abstractInsnNode3;
        AbstractInsnNode abstractInsnNode4;
        StringBuilder sb;
        MethodInsnNode methodInsnNode2 = methodInsnNode;
        InsnList insnList2 = insnList;
        InsnList insnList3 = new InsnList();
        InsnList insnList4 = insnList2;
        InsnList insnList5 = insnList4;
        AbstractInsnNode abstractInsnNode5 = abstractInsnNode;
        AbstractInsnNode typeInsnNode = new TypeInsnNode(187, methodInsnNode2.owner);
        insnList5.add(abstractInsnNode5);
        InsnList insnList6 = insnList4;
        AbstractInsnNode abstractInsnNode6 = abstractInsnNode2;
        AbstractInsnNode insnNode = new InsnNode(89);
        insnList6.add(abstractInsnNode6);
        InsnList insnList7 = insnList4;
        AbstractInsnNode abstractInsnNode7 = abstractInsnNode3;
        AbstractInsnNode methodInsnNode3 = new MethodInsnNode(183, methodInsnNode2.owner, "<init>", "()V");
        insnList7.add(abstractInsnNode7);
        InsnList insnList8 = insnList4;
        AbstractInsnNode abstractInsnNode8 = abstractInsnNode4;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        AbstractInsnNode methodInsnNode4 = new MethodInsnNode(184, MAPPED_HELPER_JVM, "slice", sb2.append("(L").append(MAPPED_OBJECT_JVM).append(";L").append(MAPPED_OBJECT_JVM).append(";)L").append(MAPPED_OBJECT_JVM).append(";").toString());
        insnList8.add(abstractInsnNode8);
        return insnList4;
    }

    private static InsnList generateViewInstructions(FieldInsnNode fieldInsnNode, MappedSubtypeInfo mappedSubtypeInfo) {
        InsnList insnList;
        InternalError internalError;
        AbstractInsnNode abstractInsnNode;
        StringBuilder sb;
        AbstractInsnNode abstractInsnNode2;
        StringBuilder sb2;
        AbstractInsnNode abstractInsnNode3;
        StringBuilder sb3;
        AbstractInsnNode abstractInsnNode4;
        StringBuilder sb4;
        InternalError internalError2;
        FieldInsnNode fieldInsnNode2 = fieldInsnNode;
        MappedSubtypeInfo mappedSubtypeInfo2 = mappedSubtypeInfo;
        if (!"I".equals(fieldInsnNode2.desc)) {
            InternalError internalError3 = internalError2;
            InternalError internalError4 = new InternalError();
            throw internalError3;
        }
        InsnList insnList2 = insnList;
        InsnList insnList3 = new InsnList();
        InsnList insnList4 = insnList2;
        if (fieldInsnNode2.getOpcode() == 180) {
            if (mappedSubtypeInfo2.sizeof_shift != 0) {
                insnList4.add(getIntNode(mappedSubtypeInfo2.sizeof_shift));
                InsnList insnList5 = insnList4;
                AbstractInsnNode abstractInsnNode5 = abstractInsnNode4;
                StringBuilder sb5 = sb4;
                StringBuilder sb6 = new StringBuilder();
                AbstractInsnNode methodInsnNode = new MethodInsnNode(184, MAPPED_HELPER_JVM, "get_view_shift", sb5.append("(L").append(MAPPED_OBJECT_JVM).append(";I)I").toString());
                insnList5.add(abstractInsnNode5);
                return insnList4;
            }
            insnList4.add(getIntNode(mappedSubtypeInfo2.sizeof));
            InsnList insnList6 = insnList4;
            AbstractInsnNode abstractInsnNode6 = abstractInsnNode3;
            StringBuilder sb7 = sb3;
            StringBuilder sb8 = new StringBuilder();
            AbstractInsnNode methodInsnNode2 = new MethodInsnNode(184, MAPPED_HELPER_JVM, "get_view", sb7.append("(L").append(MAPPED_OBJECT_JVM).append(";I)I").toString());
            insnList6.add(abstractInsnNode6);
            return insnList4;
        } else if (fieldInsnNode2.getOpcode() != 181) {
            InternalError internalError5 = internalError;
            InternalError internalError6 = new InternalError();
            throw internalError5;
        } else if (mappedSubtypeInfo2.sizeof_shift != 0) {
            insnList4.add(getIntNode(mappedSubtypeInfo2.sizeof_shift));
            InsnList insnList7 = insnList4;
            AbstractInsnNode abstractInsnNode7 = abstractInsnNode2;
            StringBuilder sb9 = sb2;
            StringBuilder sb10 = new StringBuilder();
            AbstractInsnNode methodInsnNode3 = new MethodInsnNode(184, MAPPED_HELPER_JVM, "put_view_shift", sb9.append("(L").append(MAPPED_OBJECT_JVM).append(";II)V").toString());
            insnList7.add(abstractInsnNode7);
            return insnList4;
        } else {
            insnList4.add(getIntNode(mappedSubtypeInfo2.sizeof));
            InsnList insnList8 = insnList4;
            AbstractInsnNode abstractInsnNode8 = abstractInsnNode;
            StringBuilder sb11 = sb;
            StringBuilder sb12 = new StringBuilder();
            AbstractInsnNode methodInsnNode4 = new MethodInsnNode(184, MAPPED_HELPER_JVM, "put_view", sb11.append("(L").append(MAPPED_OBJECT_JVM).append(";II)V").toString());
            insnList8.add(abstractInsnNode8);
            return insnList4;
        }
    }

    private static void getClassEnums(Class cls, Map<Integer, String> map, String... strArr) {
        IllegalStateException illegalStateException;
        Map<Integer, String> map2 = map;
        String[] strArr2 = strArr;
        try {
            Field[] fields = cls.getFields();
            int length = fields.length;
            for (int i = 0; i < length; i++) {
                Field field = fields[i];
                if (Modifier.isStatic(field.getModifiers()) && field.getType() == Integer.TYPE) {
                    int length2 = strArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length2) {
                            if (field.getName().startsWith(strArr2[i2])) {
                                break;
                            }
                            i2++;
                        } else if (map2.put((Integer) field.get(null), field.getName()) != null) {
                            IllegalStateException illegalStateException2 = illegalStateException;
                            IllegalStateException illegalStateException3 = new IllegalStateException();
                            throw illegalStateException2;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static AbstractInsnNode getIntNode(int i) {
        LdcInsnNode ldcInsnNode;
        IntInsnNode intInsnNode;
        IntInsnNode intInsnNode2;
        InsnNode insnNode;
        int i2 = i;
        if (i2 <= 5 && -1 <= i2) {
            InsnNode insnNode2 = insnNode;
            InsnNode insnNode3 = new InsnNode(1 + i2 + 2);
            return insnNode2;
        } else if (i2 >= -128 && i2 <= 127) {
            IntInsnNode intInsnNode3 = intInsnNode2;
            IntInsnNode intInsnNode4 = new IntInsnNode(16, i2);
            return intInsnNode3;
        } else if (i2 < -32768 || i2 > 32767) {
            LdcInsnNode ldcInsnNode2 = ldcInsnNode;
            LdcInsnNode ldcInsnNode3 = new LdcInsnNode(Integer.valueOf(i2));
            return ldcInsnNode2;
        } else {
            IntInsnNode intInsnNode5 = intInsnNode;
            IntInsnNode intInsnNode6 = new IntInsnNode(17, i2);
            return intInsnNode5;
        }
    }

    private static ClassAdapter getMethodGenAdapter(String str, ClassVisitor classVisitor) {
        C08533 r6;
        C08533 r2 = r6;
        final String str2 = str;
        C08533 r3 = new ClassAdapter(classVisitor) {
            {
                ClassVisitor classVisitor = r6;
            }

            private void generateAlignGetter(MappedSubtypeInfo mappedSubtypeInfo) {
                MappedSubtypeInfo mappedSubtypeInfo2 = mappedSubtypeInfo;
                MethodVisitor visitMethod = MappedObjectTransformer.super.visitMethod(1, MappedObjectTransformer.ALIGN_METHOD_NAME, "()I", null, null);
                visitMethod.visitCode();
                MappedObjectTransformer.visitIntNode(visitMethod, mappedSubtypeInfo2.sizeof);
                visitMethod.visitInsn(172);
                visitMethod.visitMaxs(1, 1);
                visitMethod.visitEnd();
            }

            private void generateByteBufferGetter(String str, FieldInfo fieldInfo) {
                StringBuilder sb;
                StringBuilder sb2;
                FieldInfo fieldInfo2 = fieldInfo;
                String str2 = MappedObjectTransformer.getterName(str);
                StringBuilder sb3 = sb;
                StringBuilder sb4 = new StringBuilder();
                MethodVisitor visitMethod = MappedObjectTransformer.super.visitMethod(9, str2, sb3.append("(L").append(str2).append(";I)").append(fieldInfo2.type.getDescriptor()).toString(), null, null);
                visitMethod.visitCode();
                visitMethod.visitVarInsn(25, 0);
                visitMethod.visitVarInsn(21, 1);
                visitMethod.visitMethodInsn(182, str2, MappedObjectTransformer.VIEWADDRESS_METHOD_NAME, "(I)J");
                MappedObjectTransformer.visitIntNode(visitMethod, (int) fieldInfo2.offset);
                visitMethod.visitInsn(133);
                visitMethod.visitInsn(97);
                MappedObjectTransformer.visitIntNode(visitMethod, (int) fieldInfo2.length);
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                visitMethod.visitMethodInsn(184, MappedObjectTransformer.MAPPED_HELPER_JVM, "newBuffer", sb5.append("(JI)L").append(MappedObjectTransformer.jvmClassName(ByteBuffer.class)).append(";").toString());
                visitMethod.visitInsn(176);
                visitMethod.visitMaxs(3, 2);
                visitMethod.visitEnd();
            }

            private void generateCapacity() {
                StringBuilder sb;
                StringBuilder sb2;
                MethodVisitor visitMethod = MappedObjectTransformer.super.visitMethod(1, MappedObjectTransformer.CAPACITY_METHOD_NAME, "()I", null, null);
                visitMethod.visitCode();
                visitMethod.visitVarInsn(25, 0);
                StringBuilder sb3 = sb;
                StringBuilder sb4 = new StringBuilder();
                visitMethod.visitMethodInsn(182, MappedObjectTransformer.MAPPED_OBJECT_JVM, "backingByteBuffer", sb3.append("()L").append(MappedObjectTransformer.jvmClassName(ByteBuffer.class)).append(";").toString());
                visitMethod.visitInsn(89);
                visitMethod.visitMethodInsn(182, MappedObjectTransformer.jvmClassName(ByteBuffer.class), MappedObjectTransformer.CAPACITY_METHOD_NAME, "()I");
                visitMethod.visitInsn(95);
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                visitMethod.visitMethodInsn(184, MappedObjectTransformer.jvmClassName(MemoryUtil.class), "getAddress0", sb5.append("(L").append(MappedObjectTransformer.jvmClassName(Buffer.class)).append(";)J").toString());
                visitMethod.visitVarInsn(25, 0);
                visitMethod.visitFieldInsn(180, MappedObjectTransformer.MAPPED_OBJECT_JVM, "baseAddress", "J");
                visitMethod.visitInsn(101);
                visitMethod.visitInsn(136);
                visitMethod.visitInsn(96);
                visitMethod.visitFieldInsn(178, str2, "SIZEOF", "I");
                visitMethod.visitInsn(108);
                visitMethod.visitInsn(172);
                visitMethod.visitMaxs(3, 1);
                visitMethod.visitEnd();
            }

            private void generateFieldGetter(String str, FieldInfo fieldInfo) {
                StringBuilder sb;
                StringBuilder sb2;
                StringBuilder sb3;
                FieldInfo fieldInfo2 = fieldInfo;
                String str2 = MappedObjectTransformer.getterName(str);
                StringBuilder sb4 = sb;
                StringBuilder sb5 = new StringBuilder();
                MethodVisitor visitMethod = MappedObjectTransformer.super.visitMethod(9, str2, sb4.append("(L").append(str2).append(";I)").append(fieldInfo2.type.getDescriptor()).toString(), null, null);
                visitMethod.visitCode();
                visitMethod.visitVarInsn(25, 0);
                visitMethod.visitVarInsn(21, 1);
                visitMethod.visitMethodInsn(182, str2, MappedObjectTransformer.VIEWADDRESS_METHOD_NAME, "(I)J");
                MappedObjectTransformer.visitIntNode(visitMethod, (int) fieldInfo2.offset);
                visitMethod.visitInsn(133);
                visitMethod.visitInsn(97);
                MethodVisitor methodVisitor = visitMethod;
                String str3 = MappedObjectTransformer.MAPPED_HELPER_JVM;
                StringBuilder sb6 = sb2;
                StringBuilder sb7 = new StringBuilder();
                String sb8 = sb6.append(fieldInfo2.getAccessType()).append("get").toString();
                StringBuilder sb9 = sb3;
                StringBuilder sb10 = new StringBuilder();
                methodVisitor.visitMethodInsn(184, str3, sb8, sb9.append("(J)").append(fieldInfo2.type.getDescriptor()).toString());
                visitMethod.visitInsn(fieldInfo2.type.getOpcode(172));
                visitMethod.visitMaxs(3, 2);
                visitMethod.visitEnd();
            }

            private void generateFieldSetter(String str, FieldInfo fieldInfo) {
                StringBuilder sb;
                StringBuilder sb2;
                StringBuilder sb3;
                FieldInfo fieldInfo2 = fieldInfo;
                String str2 = MappedObjectTransformer.setterName(str);
                StringBuilder sb4 = sb;
                StringBuilder sb5 = new StringBuilder();
                MethodVisitor visitMethod = MappedObjectTransformer.super.visitMethod(9, str2, sb4.append("(L").append(str2).append(";I").append(fieldInfo2.type.getDescriptor()).append(")V").toString(), null, null);
                visitMethod.visitCode();
                int i = 0;
                switch (fieldInfo2.type.getSort()) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        i = 21;
                        break;
                    case 6:
                        i = 23;
                        break;
                    case 7:
                        i = 22;
                        break;
                    case 8:
                        i = 24;
                        break;
                }
                visitMethod.visitVarInsn(i, 2);
                visitMethod.visitVarInsn(25, 0);
                visitMethod.visitVarInsn(21, 1);
                visitMethod.visitMethodInsn(182, str2, MappedObjectTransformer.VIEWADDRESS_METHOD_NAME, "(I)J");
                MappedObjectTransformer.visitIntNode(visitMethod, (int) fieldInfo2.offset);
                visitMethod.visitInsn(133);
                visitMethod.visitInsn(97);
                MethodVisitor methodVisitor = visitMethod;
                String str3 = MappedObjectTransformer.MAPPED_HELPER_JVM;
                StringBuilder sb6 = sb2;
                StringBuilder sb7 = new StringBuilder();
                String sb8 = sb6.append(fieldInfo2.getAccessType()).append("put").toString();
                StringBuilder sb9 = sb3;
                StringBuilder sb10 = new StringBuilder();
                methodVisitor.visitMethodInsn(184, str3, sb8, sb9.append("(").append(fieldInfo2.type.getDescriptor()).append("J)V").toString());
                visitMethod.visitInsn(177);
                visitMethod.visitMaxs(4, 4);
                visitMethod.visitEnd();
            }

            private void generateNext() {
                MethodVisitor visitMethod = MappedObjectTransformer.super.visitMethod(1, MappedObjectTransformer.NEXT_METHOD_NAME, "()V", null, null);
                visitMethod.visitCode();
                visitMethod.visitVarInsn(25, 0);
                visitMethod.visitInsn(89);
                visitMethod.visitFieldInsn(180, MappedObjectTransformer.MAPPED_OBJECT_JVM, "viewAddress", "J");
                visitMethod.visitFieldInsn(178, str2, "SIZEOF", "I");
                visitMethod.visitInsn(133);
                visitMethod.visitInsn(97);
                visitMethod.visitMethodInsn(182, str2, "setViewAddress", "(J)V");
                visitMethod.visitInsn(177);
                visitMethod.visitMaxs(3, 1);
                visitMethod.visitEnd();
            }

            private void generateSizeofGetter() {
                MethodVisitor visitMethod = MappedObjectTransformer.super.visitMethod(1, MappedObjectTransformer.SIZEOF_METHOD_NAME, "()I", null, null);
                visitMethod.visitCode();
                visitMethod.visitFieldInsn(178, str2, "SIZEOF", "I");
                visitMethod.visitInsn(172);
                visitMethod.visitMaxs(1, 1);
                visitMethod.visitEnd();
            }

            private void generateViewAddressGetter() {
                StringBuilder sb;
                MethodVisitor visitMethod = MappedObjectTransformer.super.visitMethod(1, MappedObjectTransformer.VIEWADDRESS_METHOD_NAME, "(I)J", null, null);
                visitMethod.visitCode();
                visitMethod.visitVarInsn(25, 0);
                visitMethod.visitFieldInsn(180, MappedObjectTransformer.MAPPED_OBJECT_JVM, "baseAddress", "J");
                visitMethod.visitVarInsn(21, 1);
                visitMethod.visitFieldInsn(178, str2, "SIZEOF", "I");
                visitMethod.visitInsn(104);
                visitMethod.visitInsn(133);
                visitMethod.visitInsn(97);
                if (MappedObject.CHECKS) {
                    visitMethod.visitInsn(92);
                    visitMethod.visitVarInsn(25, 0);
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    visitMethod.visitMethodInsn(184, MappedObjectTransformer.MAPPED_HELPER_JVM, "checkAddress", sb2.append("(JL").append(MappedObjectTransformer.MAPPED_OBJECT_JVM).append(";)V").toString());
                }
                visitMethod.visitInsn(173);
                visitMethod.visitMaxs(3, 2);
                visitMethod.visitEnd();
            }

            public void visitEnd() {
                MappedSubtypeInfo mappedSubtypeInfo = (MappedSubtypeInfo) MappedObjectTransformer.className_to_subtype.get(str2);
                generateViewAddressGetter();
                generateCapacity();
                generateAlignGetter(mappedSubtypeInfo);
                generateSizeofGetter();
                generateNext();
                for (String str : mappedSubtypeInfo.fields.keySet()) {
                    FieldInfo fieldInfo = (FieldInfo) mappedSubtypeInfo.fields.get(str);
                    if (fieldInfo.type.getDescriptor().length() > 1) {
                        generateByteBufferGetter(str, fieldInfo);
                    } else {
                        generateFieldGetter(str, fieldInfo);
                        generateFieldSetter(str, fieldInfo);
                    }
                }
                MappedObjectTransformer.super.visitEnd();
            }
        };
        return r2;
    }

    static String getOpcodeName(AbstractInsnNode abstractInsnNode) {
        StringBuilder sb;
        StringBuilder sb2;
        String sb3;
        AbstractInsnNode abstractInsnNode2 = abstractInsnNode;
        String str = (String) OPCODE_TO_NAME.get(Integer.valueOf(abstractInsnNode2.getOpcode()));
        StringBuilder sb4 = sb;
        StringBuilder sb5 = new StringBuilder();
        StringBuilder append = sb4.append((String) INSNTYPE_TO_NAME.get(Integer.valueOf(abstractInsnNode2.getType()))).append(": ").append(abstractInsnNode2.getOpcode());
        if (str == null) {
            sb3 = LibrariesRepository.MOJANG_MAVEN_REPO;
        } else {
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            sb3 = sb6.append(" [").append((String) OPCODE_TO_NAME.get(Integer.valueOf(abstractInsnNode2.getOpcode()))).append("]").toString();
        }
        return append.append(sb3).toString();
    }

    static String getterName(String str) {
        StringBuilder sb;
        String str2 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("get$").append(Character.toUpperCase(str2.charAt(0))).append(str2.substring(1)).append("$LWJGL").toString();
    }

    static String jvmClassName(Class<?> cls) {
        return cls.getName().replace('.', ClassPathElement.SEPARATOR_CHAR);
    }

    private static void printBytecode(byte[] bArr) {
        StringWriter stringWriter;
        TraceClassVisitor traceClassVisitor;
        ClassWriter classWriter;
        PrintWriter printWriter;
        ClassReader classReader;
        byte[] bArr2 = bArr;
        StringWriter stringWriter2 = stringWriter;
        StringWriter stringWriter3 = new StringWriter();
        StringWriter stringWriter4 = stringWriter2;
        TraceClassVisitor traceClassVisitor2 = traceClassVisitor;
        ClassWriter classWriter2 = classWriter;
        ClassWriter classWriter3 = new ClassWriter(0);
        PrintWriter printWriter2 = printWriter;
        PrintWriter printWriter3 = new PrintWriter(stringWriter4);
        TraceClassVisitor traceClassVisitor3 = new TraceClassVisitor(classWriter2, printWriter2);
        TraceClassVisitor traceClassVisitor4 = traceClassVisitor2;
        ClassReader classReader2 = classReader;
        ClassReader classReader3 = new ClassReader(bArr2);
        classReader2.accept(traceClassVisitor4, 0);
        LWJGLUtil.log(stringWriter4.toString());
    }

    public static void register(Class<? extends MappedObject> cls) {
        HashMap hashMap;
        MappedSubtypeInfo mappedSubtypeInfo;
        InternalError internalError;
        StringBuilder sb;
        ClassFormatError classFormatError;
        InternalError internalError2;
        ClassFormatError classFormatError2;
        StringBuilder sb2;
        Class<? extends MappedObject> cls2 = cls;
        if (!MappedObjectClassLoader.FORKED) {
            MappedType mappedType = (MappedType) cls2.getAnnotation(MappedType.class);
            if (mappedType != null && mappedType.padding() < 0) {
                ClassFormatError classFormatError3 = classFormatError2;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                ClassFormatError classFormatError4 = new ClassFormatError(sb3.append("Invalid mapped type padding: ").append(mappedType.padding()).toString());
                throw classFormatError3;
            } else if (cls2.getEnclosingClass() == null || Modifier.isStatic(cls2.getModifiers())) {
                String jvmClassName = jvmClassName(cls2);
                HashMap hashMap2 = hashMap;
                HashMap hashMap3 = new HashMap();
                HashMap hashMap4 = hashMap2;
                long j = 0;
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                for (int i = 0; i < length; i++) {
                    Field field = declaredFields[i];
                    FieldInfo registerField = registerField(mappedType == null || mappedType.autoGenerateOffsets(), jvmClassName, j, field);
                    if (registerField != null) {
                        Object put = hashMap4.put(field.getName(), registerField);
                        j = Math.max(j, registerField.offset + registerField.lengthPadded);
                    }
                }
                int i2 = 4;
                int i3 = 0;
                boolean z = false;
                if (mappedType != null) {
                    i2 = mappedType.align();
                    if (!mappedType.cacheLinePadding()) {
                        i3 = mappedType.padding();
                        z = false;
                    } else if (mappedType.padding() != 0) {
                        ClassFormatError classFormatError5 = classFormatError;
                        ClassFormatError classFormatError6 = new ClassFormatError("Mapped type padding cannot be specified together with cacheLinePadding.");
                        throw classFormatError5;
                    } else {
                        int cacheLineSize = (int) (j % ((long) CacheUtil.getCacheLineSize()));
                        i3 = 0;
                        if (cacheLineSize != 0) {
                            i3 = CacheUtil.getCacheLineSize() - cacheLineSize;
                        }
                        z = true;
                    }
                }
                MappedSubtypeInfo mappedSubtypeInfo2 = mappedSubtypeInfo;
                MappedSubtypeInfo mappedSubtypeInfo3 = new MappedSubtypeInfo(jvmClassName, hashMap4, (int) (j + ((long) i3)), i2, i3, z);
                MappedSubtypeInfo mappedSubtypeInfo4 = mappedSubtypeInfo2;
                if (className_to_subtype.put(jvmClassName, mappedSubtypeInfo4) != null) {
                    InternalError internalError3 = internalError;
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    InternalError internalError4 = new InternalError(sb5.append("duplicate mapped type: ").append(mappedSubtypeInfo4.className).toString());
                    throw internalError3;
                }
            } else {
                InternalError internalError5 = internalError2;
                InternalError internalError6 = new InternalError("only top-level or static inner classes are allowed");
                throw internalError5;
            }
        }
    }

    private static FieldInfo registerField(boolean z, String str, long j, Field field) {
        long j2;
        FieldInfo fieldInfo;
        StringBuilder sb;
        AssertionError assertionError;
        AssertionError assertionError2;
        ClassFormatError classFormatError;
        StringBuilder sb2;
        ClassFormatError classFormatError2;
        StringBuilder sb3;
        IllegalStateException illegalStateException;
        StringBuilder sb4;
        ClassFormatError classFormatError3;
        IllegalStateException illegalStateException2;
        StringBuilder sb5;
        ClassFormatError classFormatError4;
        StringBuilder sb6;
        ClassFormatError classFormatError5;
        StringBuilder sb7;
        ClassFormatError classFormatError6;
        StringBuilder sb8;
        ClassFormatError classFormatError7;
        StringBuilder sb9;
        boolean z2 = z;
        String str2 = str;
        long j3 = j;
        Field field2 = field;
        if (Modifier.isStatic(field2.getModifiers())) {
            return null;
        }
        if (field2.getType().isPrimitive() || field2.getType() == ByteBuffer.class) {
            MappedField mappedField = (MappedField) field2.getAnnotation(MappedField.class);
            if (mappedField != null || z2) {
                Pointer pointer = (Pointer) field2.getAnnotation(Pointer.class);
                if (pointer != null && field2.getType() != Long.TYPE) {
                    ClassFormatError classFormatError8 = classFormatError5;
                    StringBuilder sb10 = sb7;
                    StringBuilder sb11 = new StringBuilder();
                    ClassFormatError classFormatError9 = new ClassFormatError(sb10.append("The @Pointer annotation can only be used on long fields. @Pointer field found: ").append(str2).append(".").append(field2.getName()).append(": ").append(field2.getType()).toString());
                    throw classFormatError8;
                } else if (!Modifier.isVolatile(field2.getModifiers()) || (pointer == null && field2.getType() != ByteBuffer.class)) {
                    if (field2.getType() == Long.TYPE || field2.getType() == Double.TYPE) {
                        j2 = pointer == null ? 8 : (long) MappedObjectUnsafe.INSTANCE.addressSize();
                    } else {
                        if (field2.getType() == Double.TYPE) {
                            j2 = 8;
                        } else {
                            if (field2.getType() == Integer.TYPE || field2.getType() == Float.TYPE) {
                                j2 = 4;
                            } else {
                                if (field2.getType() == Character.TYPE || field2.getType() == Short.TYPE) {
                                    j2 = 2;
                                } else {
                                    if (field2.getType() == Byte.TYPE) {
                                        j2 = 1;
                                    } else if (field2.getType() == ByteBuffer.class) {
                                        j2 = mappedField.byteLength();
                                        if (j2 < 0) {
                                            IllegalStateException illegalStateException3 = illegalStateException2;
                                            StringBuilder sb12 = sb5;
                                            StringBuilder sb13 = new StringBuilder();
                                            IllegalStateException illegalStateException4 = new IllegalStateException(sb12.append("invalid byte length for mapped ByteBuffer field: ").append(str2).append(".").append(field2.getName()).append(" [length=").append(j2).append("]").toString());
                                            throw illegalStateException3;
                                        }
                                    } else {
                                        ClassFormatError classFormatError10 = classFormatError3;
                                        ClassFormatError classFormatError11 = new ClassFormatError(field2.getType().getName());
                                        throw classFormatError10;
                                    }
                                }
                            }
                        }
                    }
                    if (field2.getType() == ByteBuffer.class || j3 % j2 == 0) {
                        CacheLinePad cacheLinePad = (CacheLinePad) field2.getAnnotation(CacheLinePad.class);
                        long j4 = j3;
                        if (!(mappedField == null || mappedField.byteOffset() == -1)) {
                            if (mappedField.byteOffset() < 0) {
                                ClassFormatError classFormatError12 = classFormatError2;
                                StringBuilder sb14 = sb3;
                                StringBuilder sb15 = new StringBuilder();
                                ClassFormatError classFormatError13 = new ClassFormatError(sb14.append("Invalid field byte offset: ").append(str2).append(".").append(field2.getName()).append(" [byteOffset=").append(mappedField.byteOffset()).append("]").toString());
                                throw classFormatError12;
                            } else if (cacheLinePad != null) {
                                ClassFormatError classFormatError14 = classFormatError;
                                StringBuilder sb16 = sb2;
                                StringBuilder sb17 = new StringBuilder();
                                ClassFormatError classFormatError15 = new ClassFormatError(sb16.append("A field byte offset cannot be specified together with cache-line padding: ").append(str2).append(".").append(field2.getName()).toString());
                                throw classFormatError14;
                            } else {
                                j4 = mappedField.byteOffset();
                            }
                        }
                        long j5 = j2;
                        if (cacheLinePad != null) {
                            if (cacheLinePad.before() && j4 % ((long) CacheUtil.getCacheLineSize()) != 0) {
                                j4 += ((long) CacheUtil.getCacheLineSize()) - (j4 & ((long) (-1 + CacheUtil.getCacheLineSize())));
                            }
                            if (cacheLinePad.after() && (j4 + j2) % ((long) CacheUtil.getCacheLineSize()) != 0) {
                                j5 += ((long) CacheUtil.getCacheLineSize()) - ((j4 + j2) % ((long) CacheUtil.getCacheLineSize()));
                            }
                            if (!$assertionsDisabled && cacheLinePad.before() && j4 % ((long) CacheUtil.getCacheLineSize()) != 0) {
                                AssertionError assertionError3 = assertionError2;
                                AssertionError assertionError4 = new AssertionError();
                                throw assertionError3;
                            } else if (!$assertionsDisabled && cacheLinePad.after() && (j4 + j5) % ((long) CacheUtil.getCacheLineSize()) != 0) {
                                AssertionError assertionError5 = assertionError;
                                AssertionError assertionError6 = new AssertionError();
                                throw assertionError5;
                            }
                        }
                        if (PRINT_ACTIVITY) {
                            StringBuilder sb18 = sb;
                            StringBuilder sb19 = new StringBuilder();
                            LWJGLUtil.log(sb18.append(MappedObjectTransformer.class.getSimpleName()).append(": ").append(str2).append(".").append(field2.getName()).append(" [type=").append(field2.getType().getSimpleName()).append(", offset=").append(j4).append("]").toString());
                        }
                        FieldInfo fieldInfo2 = fieldInfo;
                        FieldInfo fieldInfo3 = new FieldInfo(j4, j2, j5, Type.getType(field2.getType()), Modifier.isVolatile(field2.getModifiers()), pointer != null);
                        return fieldInfo2;
                    }
                    IllegalStateException illegalStateException5 = illegalStateException;
                    StringBuilder sb20 = sb4;
                    StringBuilder sb21 = new StringBuilder();
                    IllegalStateException illegalStateException6 = new IllegalStateException(sb20.append("misaligned mapped type: ").append(str2).append(".").append(field2.getName()).toString());
                    throw illegalStateException5;
                } else {
                    ClassFormatError classFormatError16 = classFormatError4;
                    StringBuilder sb22 = sb6;
                    StringBuilder sb23 = new StringBuilder();
                    ClassFormatError classFormatError17 = new ClassFormatError(sb22.append("The volatile keyword is not supported for @Pointer or ByteBuffer fields. Volatile field found: ").append(str2).append(".").append(field2.getName()).append(": ").append(field2.getType()).toString());
                    throw classFormatError16;
                }
            } else {
                ClassFormatError classFormatError18 = classFormatError6;
                StringBuilder sb24 = sb8;
                StringBuilder sb25 = new StringBuilder();
                ClassFormatError classFormatError19 = new ClassFormatError(sb24.append("field '").append(str2).append(".").append(field2.getName()).append("' missing annotation ").append(MappedField.class.getName()).append(": ").append(str2).toString());
                throw classFormatError18;
            }
        } else {
            ClassFormatError classFormatError20 = classFormatError7;
            StringBuilder sb26 = sb9;
            StringBuilder sb27 = new StringBuilder();
            ClassFormatError classFormatError21 = new ClassFormatError(sb26.append("field '").append(str2).append(".").append(field2.getName()).append("' not supported: ").append(field2.getType()).toString());
            throw classFormatError20;
        }
    }

    static int replace(InsnList insnList, int i, AbstractInsnNode abstractInsnNode, InsnList insnList2) {
        InsnList insnList3 = insnList;
        int i2 = i;
        AbstractInsnNode abstractInsnNode2 = abstractInsnNode;
        InsnList insnList4 = insnList2;
        int size = insnList4.size();
        insnList3.insert(abstractInsnNode2, insnList4);
        insnList3.remove(abstractInsnNode2);
        return i2 + (size - 1);
    }

    static String setterName(String str) {
        StringBuilder sb;
        String str2 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("set$").append(Character.toUpperCase(str2.charAt(0))).append(str2.substring(1)).append("$LWJGL").toString();
    }

    private static void throwAccessErrorOnReadOnlyField(String str, String str2) {
        IllegalAccessError illegalAccessError;
        StringBuilder sb;
        String str3 = str;
        String str4 = str2;
        IllegalAccessError illegalAccessError2 = illegalAccessError;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalAccessError illegalAccessError3 = new IllegalAccessError(sb2.append("The ").append(str3).append(".").append(str4).append(" field is final.").toString());
        throw illegalAccessError2;
    }

    static int transformArrayAccess(InsnList insnList, int i, Map<AbstractInsnNode, Frame<BasicValue>> map, VarInsnNode varInsnNode, MappedSubtypeInfo mappedSubtypeInfo, int i2) {
        InternalError internalError;
        ClassFormatError classFormatError;
        StringBuilder sb;
        AbstractInsnNode abstractInsnNode;
        InternalError internalError2;
        ClassFormatError classFormatError2;
        StringBuilder sb2;
        VarInsnNode varInsnNode2;
        StringBuilder sb3;
        AbstractInsnNode abstractInsnNode2;
        AbstractInsnNode abstractInsnNode3;
        StringBuilder sb4;
        AbstractInsnNode abstractInsnNode4;
        StringBuilder sb5;
        InsnList insnList2 = insnList;
        int i3 = i;
        Map<AbstractInsnNode, Frame<BasicValue>> map2 = map;
        VarInsnNode varInsnNode3 = varInsnNode;
        MappedSubtypeInfo mappedSubtypeInfo2 = mappedSubtypeInfo;
        int i4 = i2;
        int stackSize = 1 + ((Frame) map2.get(varInsnNode3)).getStackSize();
        VarInsnNode varInsnNode4 = varInsnNode3;
        while (true) {
            varInsnNode4 = varInsnNode4.getNext();
            if (varInsnNode4 == null) {
                InternalError internalError3 = internalError;
                InternalError internalError4 = new InternalError();
                throw internalError3;
            }
            Frame frame = (Frame) map2.get(varInsnNode4);
            if (frame != null) {
                int stackSize2 = frame.getStackSize();
                if (stackSize2 == stackSize + 1 && varInsnNode4.getOpcode() == 50) {
                    VarInsnNode varInsnNode5 = varInsnNode4;
                    while (true) {
                        varInsnNode4 = varInsnNode4.getNext();
                        if (varInsnNode4 == null) {
                            break;
                        }
                        Frame frame2 = (Frame) map2.get(varInsnNode4);
                        if (frame2 != null) {
                            int stackSize3 = frame2.getStackSize();
                            if (stackSize3 != stackSize + 1 || varInsnNode4.getOpcode() != 181) {
                                if (stackSize3 == stackSize && varInsnNode4.getOpcode() == 180) {
                                    FieldInsnNode fieldInsnNode = (FieldInsnNode) varInsnNode4;
                                    InsnList insnList3 = insnList2;
                                    VarInsnNode varInsnNode6 = varInsnNode4;
                                    AbstractInsnNode abstractInsnNode5 = abstractInsnNode3;
                                    String str = mappedSubtypeInfo2.className;
                                    String str2 = getterName(fieldInsnNode.name);
                                    StringBuilder sb6 = sb4;
                                    StringBuilder sb7 = new StringBuilder();
                                    AbstractInsnNode methodInsnNode = new MethodInsnNode(184, str, str2, sb6.append("(L").append(mappedSubtypeInfo2.className).append(";I)").append(fieldInsnNode.desc).toString());
                                    insnList3.insert(varInsnNode6, abstractInsnNode5);
                                    insnList2.remove(varInsnNode4);
                                    break;
                                } else if (stackSize3 == stackSize && varInsnNode4.getOpcode() == 89 && varInsnNode4.getNext().getOpcode() == 180) {
                                    FieldInsnNode next = varInsnNode4.getNext();
                                    VarInsnNode varInsnNode7 = varInsnNode2;
                                    String str3 = mappedSubtypeInfo2.className;
                                    String str4 = getterName(next.name);
                                    StringBuilder sb8 = sb3;
                                    StringBuilder sb9 = new StringBuilder();
                                    VarInsnNode methodInsnNode2 = new MethodInsnNode(184, str3, str4, sb8.append("(L").append(mappedSubtypeInfo2.className).append(";I)").append(next.desc).toString());
                                    VarInsnNode varInsnNode8 = varInsnNode7;
                                    InsnList insnList4 = insnList2;
                                    VarInsnNode varInsnNode9 = varInsnNode4;
                                    AbstractInsnNode abstractInsnNode6 = abstractInsnNode2;
                                    AbstractInsnNode insnNode = new InsnNode(92);
                                    insnList4.insert(varInsnNode9, abstractInsnNode6);
                                    insnList2.insert(varInsnNode4.getNext(), varInsnNode8);
                                    insnList2.remove(varInsnNode4);
                                    insnList2.remove(next);
                                    varInsnNode4 = varInsnNode8;
                                } else if (stackSize3 < stackSize) {
                                    ClassFormatError classFormatError3 = classFormatError2;
                                    StringBuilder sb10 = sb2;
                                    StringBuilder sb11 = new StringBuilder();
                                    ClassFormatError classFormatError4 = new ClassFormatError(sb10.append("Invalid ").append(mappedSubtypeInfo2.className).append(" view array usage detected: ").append(getOpcodeName(varInsnNode4)).toString());
                                    throw classFormatError3;
                                }
                            } else {
                                FieldInsnNode fieldInsnNode2 = (FieldInsnNode) varInsnNode4;
                                InsnList insnList5 = insnList2;
                                VarInsnNode varInsnNode10 = varInsnNode4;
                                AbstractInsnNode abstractInsnNode7 = abstractInsnNode4;
                                String str5 = mappedSubtypeInfo2.className;
                                String str6 = setterName(fieldInsnNode2.name);
                                StringBuilder sb12 = sb5;
                                StringBuilder sb13 = new StringBuilder();
                                AbstractInsnNode methodInsnNode3 = new MethodInsnNode(184, str5, str6, sb12.append("(L").append(mappedSubtypeInfo2.className).append(";I").append(fieldInsnNode2.desc).append(")V").toString());
                                insnList5.insert(varInsnNode10, abstractInsnNode7);
                                insnList2.remove(varInsnNode4);
                                break;
                            }
                        }
                    }
                    insnList2.remove(varInsnNode5);
                    return i3;
                } else if (stackSize2 == stackSize && varInsnNode4.getOpcode() == 190) {
                    if (!LWJGLUtil.DEBUG || varInsnNode3.getNext() == varInsnNode4) {
                        insnList2.remove(varInsnNode4);
                        varInsnNode3.var = i4;
                        InsnList insnList6 = insnList2;
                        VarInsnNode varInsnNode11 = varInsnNode3;
                        AbstractInsnNode abstractInsnNode8 = abstractInsnNode;
                        AbstractInsnNode methodInsnNode4 = new MethodInsnNode(182, mappedSubtypeInfo2.className, CAPACITY_METHOD_NAME, "()I");
                        insnList6.insert(varInsnNode11, abstractInsnNode8);
                        return i3 + 1;
                    }
                    InternalError internalError5 = internalError2;
                    InternalError internalError6 = new InternalError();
                    throw internalError5;
                } else if (stackSize2 < stackSize) {
                    ClassFormatError classFormatError5 = classFormatError;
                    StringBuilder sb14 = sb;
                    StringBuilder sb15 = new StringBuilder();
                    ClassFormatError classFormatError6 = new ClassFormatError(sb14.append("Invalid ").append(mappedSubtypeInfo2.className).append(" view array usage detected: ").append(getOpcodeName(varInsnNode4)).toString());
                    throw classFormatError5;
                }
            }
        }
    }

    static InsnList transformFieldAccess(FieldInsnNode fieldInsnNode) {
        InsnList insnList;
        StringBuilder sb;
        FieldInsnNode fieldInsnNode2 = fieldInsnNode;
        MappedSubtypeInfo mappedSubtypeInfo = (MappedSubtypeInfo) className_to_subtype.get(fieldInsnNode2.owner);
        if (mappedSubtypeInfo == null) {
            insnList = null;
            if ("view".equals(fieldInsnNode2.name)) {
                insnList = null;
                if (fieldInsnNode2.owner.startsWith(MAPPEDSET_PREFIX)) {
                    insnList = generateSetViewInstructions(fieldInsnNode2);
                }
            }
        } else if ("SIZEOF".equals(fieldInsnNode2.name)) {
            return generateSIZEOFInstructions(fieldInsnNode2, mappedSubtypeInfo);
        } else {
            if ("view".equals(fieldInsnNode2.name)) {
                return generateViewInstructions(fieldInsnNode2, mappedSubtypeInfo);
            }
            if ("baseAddress".equals(fieldInsnNode2.name) || "viewAddress".equals(fieldInsnNode2.name)) {
                return generateAddressInstructions(fieldInsnNode2);
            }
            FieldInfo fieldInfo = (FieldInfo) mappedSubtypeInfo.fields.get(fieldInsnNode2.name);
            insnList = null;
            if (fieldInfo != null) {
                String str = fieldInsnNode2.desc;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                return str.equals(sb2.append("L").append(jvmClassName(ByteBuffer.class)).append(";").toString()) ? generateByteBufferInstructions(fieldInsnNode2, mappedSubtypeInfo, fieldInfo.offset) : generateFieldInstructions(fieldInsnNode2, fieldInfo);
            }
        }
        return insnList;
    }

    static byte[] transformMappedAPI(String str, byte[] bArr) {
        C08522 r10;
        ClassAdapter classAdapter;
        ClassReader classReader;
        String str2 = str;
        byte[] bArr2 = bArr;
        C08522 r6 = r10;
        C08522 r7 = new ClassWriter(2) {
            /* access modifiers changed from: protected */
            public String getCommonSuperClass(String str, String str2) {
                String str3 = str;
                String str4 = str2;
                return ((!MappedObjectTransformer.is_currently_computing_frames || str3.startsWith("java/")) && str4.startsWith("java/")) ? super.getCommonSuperClass(str3, str4) : "java/lang/Object";
            }
        };
        C08522 r2 = r6;
        ClassAdapter classAdapter2 = classAdapter;
        ClassAdapter transformationAdapter = new TransformationAdapter(r2, str2);
        ClassAdapter classAdapter3 = classAdapter2;
        ClassAdapter classAdapter4 = classAdapter3;
        if (className_to_subtype.containsKey(str2)) {
            classAdapter4 = getMethodGenAdapter(str2, classAdapter4);
        }
        ClassReader classReader2 = classReader;
        ClassReader classReader3 = new ClassReader(bArr2);
        classReader2.accept(classAdapter4, 4);
        if (!classAdapter3.transformed) {
            return bArr2;
        }
        byte[] byteArray = r2.toByteArray();
        if (PRINT_BYTECODE) {
            printBytecode(byteArray);
        }
        return byteArray;
    }

    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r4v3, types: [org.objectweb.asm.ClassVisitor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static byte[] transformMappedObject(byte[] r7) {
        /*
            r0 = r7
            org.objectweb.asm.ClassWriter r3 = new org.objectweb.asm.ClassWriter
            r6 = r3
            r3 = r6
            r4 = r6
            r5 = 0
            r4.<init>(r5)
            r1 = r3
            org.lwjgl.util.mapped.MappedObjectTransformer$1 r3 = new org.lwjgl.util.mapped.MappedObjectTransformer$1
            r6 = r3
            r3 = r6
            r4 = r6
            r5 = r1
            r4.<init>(r5)
            r2 = r3
            org.objectweb.asm.ClassReader r3 = new org.objectweb.asm.ClassReader
            r6 = r3
            r3 = r6
            r4 = r6
            r5 = r0
            r4.<init>(r5)
            r4 = r2
            r5 = 0
            r3.accept(r4, r5)
            r3 = r1
            byte[] r3 = r3.toByteArray()
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.mapped.MappedObjectTransformer.transformMappedObject(byte[]):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x02d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int transformMethodCall(org.objectweb.asm.tree.InsnList r22, int r23, java.util.Map<org.objectweb.asm.tree.AbstractInsnNode, org.objectweb.asm.tree.analysis.Frame<org.objectweb.asm.tree.analysis.BasicValue>> r24, org.objectweb.asm.tree.MethodInsnNode r25, org.lwjgl.util.mapped.MappedObjectTransformer.MappedSubtypeInfo r26, java.util.Map<java.lang.Integer, org.lwjgl.util.mapped.MappedObjectTransformer.MappedSubtypeInfo> r27) {
        /*
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r27
            r14 = r4
            int r14 = r14.getOpcode()
            switch(r14) {
                case 182: goto L_0x0017;
                case 183: goto L_0x022a;
                case 184: goto L_0x0260;
                default: goto L_0x0014;
            }
        L_0x0014:
            r14 = r2
            r1 = r14
        L_0x0016:
            return r1
        L_0x0017:
            java.lang.String r14 = "asArray"
            r15 = r4
            java.lang.String r15 = r15.name
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x00eb
            r14 = r4
            java.lang.String r14 = r14.desc
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r21 = r15
            r15 = r21
            r16 = r21
            r16.<init>()
            java.lang.String r16 = "()[L"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = MAPPED_OBJECT_JVM
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = ";"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r15 = r15.toString()
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x00eb
            r14 = r4
            org.objectweb.asm.tree.AbstractInsnNode r14 = r14.getNext()
            r10 = r14
            r14 = r10
            r15 = 192(0xc0, float:2.69E-43)
            checkInsnAfterIsArray(r14, r15)
            r14 = r10
            org.objectweb.asm.tree.AbstractInsnNode r14 = r14.getNext()
            r11 = r14
            r14 = r11
            r15 = 58
            checkInsnAfterIsArray(r14, r15)
            r14 = r3
            r15 = r11
            java.lang.Object r14 = r14.get(r15)
            org.objectweb.asm.tree.analysis.Frame r14 = (org.objectweb.asm.tree.analysis.Frame) r14
            r12 = r14
            r14 = r12
            r15 = -1
            r16 = r12
            int r16 = r16.getStackSize()
            int r15 = r15 + r16
            org.objectweb.asm.tree.analysis.Value r14 = r14.getStack(r15)
            org.objectweb.asm.tree.analysis.BasicValue r14 = (org.objectweb.asm.tree.analysis.BasicValue) r14
            org.objectweb.asm.Type r14 = r14.getType()
            org.objectweb.asm.Type r14 = r14.getElementType()
            java.lang.String r14 = r14.getInternalName()
            r13 = r14
            r14 = r4
            java.lang.String r14 = r14.owner
            r15 = r13
            boolean r14 = r14.equals(r15)
            if (r14 != 0) goto L_0x00cd
            java.lang.ClassCastException r14 = new java.lang.ClassCastException
            r21 = r14
            r14 = r21
            r15 = r21
            java.lang.StringBuilder r16 = new java.lang.StringBuilder
            r21 = r16
            r16 = r21
            r17 = r21
            r17.<init>()
            java.lang.String r17 = "Source: "
            java.lang.StringBuilder r16 = r16.append(r17)
            r17 = r4
            r0 = r17
            java.lang.String r0 = r0.owner
            r17 = r0
            java.lang.StringBuilder r16 = r16.append(r17)
            java.lang.String r17 = " - Target: "
            java.lang.StringBuilder r16 = r16.append(r17)
            r17 = r13
            java.lang.StringBuilder r16 = r16.append(r17)
            java.lang.String r16 = r16.toString()
            r15.<init>(r16)
            throw r14
        L_0x00cd:
            r14 = r6
            r15 = r11
            org.objectweb.asm.tree.VarInsnNode r15 = (org.objectweb.asm.tree.VarInsnNode) r15
            int r15 = r15.var
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r16 = r5
            java.lang.Object r14 = r14.put(r15, r16)
            r14 = r1
            r15 = r4
            org.objectweb.asm.tree.AbstractInsnNode r15 = r15.getNext()
            r14.remove(r15)
            r14 = r1
            r15 = r4
            r14.remove(r15)
        L_0x00eb:
            java.lang.String r14 = "dup"
            r15 = r4
            java.lang.String r15 = r15.name
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0131
            r14 = r4
            java.lang.String r14 = r14.desc
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r21 = r15
            r15 = r21
            r16 = r21
            r16.<init>()
            java.lang.String r16 = "()L"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = MAPPED_OBJECT_JVM
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = ";"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r15 = r15.toString()
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0131
            r14 = r1
            r15 = r2
            r16 = r4
            r17 = r4
            org.objectweb.asm.tree.InsnList r17 = generateDupInstructions(r17)
            int r14 = replace(r14, r15, r16, r17)
            r1 = r14
            goto L_0x0016
        L_0x0131:
            java.lang.String r14 = "slice"
            r15 = r4
            java.lang.String r15 = r15.name
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0177
            r14 = r4
            java.lang.String r14 = r14.desc
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r21 = r15
            r15 = r21
            r16 = r21
            r16.<init>()
            java.lang.String r16 = "()L"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = MAPPED_OBJECT_JVM
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = ";"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r15 = r15.toString()
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0177
            r14 = r1
            r15 = r2
            r16 = r4
            r17 = r4
            org.objectweb.asm.tree.InsnList r17 = generateSliceInstructions(r17)
            int r14 = replace(r14, r15, r16, r17)
            r1 = r14
            goto L_0x0016
        L_0x0177:
            java.lang.String r14 = "runViewConstructor"
            r15 = r4
            java.lang.String r15 = r15.name
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x019e
            java.lang.String r14 = "()V"
            r15 = r4
            java.lang.String r15 = r15.desc
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x019e
            r14 = r1
            r15 = r2
            r16 = r4
            r17 = r4
            org.objectweb.asm.tree.InsnList r17 = generateRunViewConstructorInstructions(r17)
            int r14 = replace(r14, r15, r16, r17)
            r1 = r14
            goto L_0x0016
        L_0x019e:
            java.lang.String r14 = "copyTo"
            r15 = r4
            java.lang.String r15 = r15.name
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x01e4
            r14 = r4
            java.lang.String r14 = r14.desc
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r21 = r15
            r15 = r21
            r16 = r21
            r16.<init>()
            java.lang.String r16 = "(L"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = MAPPED_OBJECT_JVM
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = ";)V"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r15 = r15.toString()
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x01e4
            r14 = r1
            r15 = r2
            r16 = r4
            r17 = r5
            org.objectweb.asm.tree.InsnList r17 = generateCopyToInstructions(r17)
            int r14 = replace(r14, r15, r16, r17)
            r1 = r14
            goto L_0x0016
        L_0x01e4:
            java.lang.String r14 = "copyRange"
            r15 = r4
            java.lang.String r15 = r15.name
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0014
            r14 = r4
            java.lang.String r14 = r14.desc
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r21 = r15
            r15 = r21
            r16 = r21
            r16.<init>()
            java.lang.String r16 = "(L"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = MAPPED_OBJECT_JVM
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = ";I)V"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r15 = r15.toString()
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0014
            r14 = r1
            r15 = r2
            r16 = r4
            r17 = r5
            org.objectweb.asm.tree.InsnList r17 = generateCopyRangeInstructions(r17)
            int r14 = replace(r14, r15, r16, r17)
            r1 = r14
            goto L_0x0016
        L_0x022a:
            r14 = r4
            java.lang.String r14 = r14.owner
            java.lang.String r15 = MAPPED_OBJECT_JVM
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0014
            java.lang.String r14 = "<init>"
            r15 = r4
            java.lang.String r15 = r15.name
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0014
            java.lang.String r14 = "()V"
            r15 = r4
            java.lang.String r15 = r15.desc
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0014
            r14 = r1
            r15 = r4
            org.objectweb.asm.tree.AbstractInsnNode r15 = r15.getPrevious()
            r14.remove(r15)
            r14 = r1
            r15 = r4
            r14.remove(r15)
            r14 = r2
            r15 = 2
            int r14 = r14 + -2
            r1 = r14
            goto L_0x0016
        L_0x0260:
            java.lang.String r14 = "map"
            r15 = r4
            java.lang.String r15 = r15.name
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x032b
            r14 = r4
            java.lang.String r14 = r14.desc
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r21 = r15
            r15 = r21
            r16 = r21
            r16.<init>()
            java.lang.String r16 = "(JI)L"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = MAPPED_OBJECT_JVM
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = ";"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r15 = r15.toString()
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x032b
            r14 = 1
            r7 = r14
        L_0x0297:
            java.lang.String r14 = "map"
            r15 = r4
            java.lang.String r15 = r15.name
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x032f
            r14 = r4
            java.lang.String r14 = r14.desc
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r21 = r15
            r15 = r21
            r16 = r21
            r16.<init>()
            java.lang.String r16 = "(Ljava/nio/ByteBuffer;)L"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = MAPPED_OBJECT_JVM
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = ";"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r15 = r15.toString()
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x032f
            r14 = 1
            r8 = r14
        L_0x02ce:
            java.lang.String r14 = "malloc"
            r15 = r4
            java.lang.String r15 = r15.name
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0332
            r14 = r4
            java.lang.String r14 = r14.desc
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r21 = r15
            r15 = r21
            r16 = r21
            r16.<init>()
            java.lang.String r16 = "(I)L"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = MAPPED_OBJECT_JVM
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = ";"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r15 = r15.toString()
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0332
            r14 = 1
            r9 = r14
        L_0x0305:
            r14 = r7
            if (r14 != 0) goto L_0x030e
            r14 = r8
            if (r14 != 0) goto L_0x030e
            r14 = r9
            if (r14 == 0) goto L_0x0014
        L_0x030e:
            r14 = r1
            r15 = r2
            r16 = r4
            r17 = r5
            r18 = r4
            r0 = r18
            java.lang.String r0 = r0.owner
            r18 = r0
            r19 = r7
            r20 = r9
            org.objectweb.asm.tree.InsnList r17 = generateMapInstructions(r17, r18, r19, r20)
            int r14 = replace(r14, r15, r16, r17)
            r1 = r14
            goto L_0x0016
        L_0x032b:
            r14 = 0
            r7 = r14
            goto L_0x0297
        L_0x032f:
            r14 = 0
            r8 = r14
            goto L_0x02ce
        L_0x0332:
            r14 = 0
            r9 = r14
            goto L_0x0305
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.mapped.MappedObjectTransformer.transformMethodCall(org.objectweb.asm.tree.InsnList, int, java.util.Map, org.objectweb.asm.tree.MethodInsnNode, org.lwjgl.util.mapped.MappedObjectTransformer$MappedSubtypeInfo, java.util.Map):int");
    }

    static void visitIntNode(MethodVisitor methodVisitor, int i) {
        MethodVisitor methodVisitor2 = methodVisitor;
        int i2 = i;
        if (i2 <= 5 && -1 <= i2) {
            methodVisitor2.visitInsn(1 + i2 + 2);
        } else if (i2 >= -128 && i2 <= 127) {
            methodVisitor2.visitIntInsn(16, i2);
        } else if (i2 < -32768 || i2 > 32767) {
            methodVisitor2.visitLdcInsn(Integer.valueOf(i2));
        } else {
            methodVisitor2.visitIntInsn(17, i2);
        }
    }
}
