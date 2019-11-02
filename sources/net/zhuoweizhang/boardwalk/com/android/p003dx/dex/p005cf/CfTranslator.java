package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.p005cf;

import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.DexOptions;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvCode;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvCode.AssignIndicesCallback;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.RopTranslator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.ClassDefItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.DexFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.EncodedField;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.EncodedMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.FieldIdItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.FieldIdsSection;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.MethodIdItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.MethodIdsSection;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.TypeIdItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.TypeIdsSection;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ConcreteMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.Ropper;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.DirectClassFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Field;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.FieldList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Method;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.MethodList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationsList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.AccessFlags;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.DexTranslationAdvice;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalVariableExtractor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalVariableInfo;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.ConstantPool;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstBaseMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstBoolean;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstByte;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstChar;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstEnumRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInterfaceMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstShort;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.TypedConstant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.Optimizer;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.cf.CfTranslator */
public class CfTranslator {
    private static final boolean DEBUG = false;

    private CfTranslator() {
    }

    private static TypedConstant coerceConstant(TypedConstant typedConstant, Type type) {
        UnsupportedOperationException unsupportedOperationException;
        StringBuilder sb;
        TypedConstant typedConstant2 = typedConstant;
        Type type2 = type;
        if (typedConstant2.getType().equals(type2)) {
            return typedConstant2;
        }
        switch (type2.getBasicType()) {
            case 1:
                return CstBoolean.make(((CstInteger) typedConstant2).getValue());
            case 2:
                return CstByte.make(((CstInteger) typedConstant2).getValue());
            case 3:
                return CstChar.make(((CstInteger) typedConstant2).getValue());
            case 8:
                return CstShort.make(((CstInteger) typedConstant2).getValue());
            default:
                UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(sb2.append("can't coerce ").append(typedConstant2).append(" to ").append(type2).toString());
                throw unsupportedOperationException2;
        }
    }

    private static void processFields(DirectClassFile directClassFile, ClassDefItem classDefItem, FieldIdsSection fieldIdsSection) {
        StringBuilder sb;
        CstFieldRef cstFieldRef;
        EncodedField encodedField;
        EncodedField encodedField2;
        DirectClassFile directClassFile2 = directClassFile;
        ClassDefItem classDefItem2 = classDefItem;
        FieldIdsSection fieldIdsSection2 = fieldIdsSection;
        CstType thisClass = directClassFile2.getThisClass();
        FieldList fields = directClassFile2.getFields();
        int size = fields.size();
        int i = 0;
        while (i < size) {
            Field field = fields.get(i);
            try {
                CstFieldRef cstFieldRef2 = cstFieldRef;
                CstFieldRef cstFieldRef3 = new CstFieldRef(thisClass, field.getNat());
                CstFieldRef cstFieldRef4 = cstFieldRef2;
                int accessFlags = field.getAccessFlags();
                if (AccessFlags.isStatic(accessFlags)) {
                    TypedConstant constantValue = field.getConstantValue();
                    EncodedField encodedField3 = encodedField2;
                    EncodedField encodedField4 = new EncodedField(cstFieldRef4, accessFlags);
                    EncodedField encodedField5 = encodedField3;
                    if (constantValue != null) {
                        constantValue = coerceConstant(constantValue, cstFieldRef4.getType());
                    }
                    classDefItem2.addStaticField(encodedField5, constantValue);
                } else {
                    ClassDefItem classDefItem3 = classDefItem2;
                    EncodedField encodedField6 = encodedField;
                    EncodedField encodedField7 = new EncodedField(cstFieldRef4, accessFlags);
                    classDefItem3.addInstanceField(encodedField6);
                }
                Annotations annotations = AttributeTranslator.getAnnotations(field.getAttributes());
                if (annotations.size() != 0) {
                    classDefItem2.addFieldAnnotations(cstFieldRef4, annotations);
                }
                FieldIdItem intern = fieldIdsSection2.intern(cstFieldRef4);
                i++;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                throw ExceptionWithContext.withContext(runtimeException, sb2.append("...while processing ").append(field.getName().toHuman()).append(" ").append(field.getDescriptor().toHuman()).toString());
            }
        }
    }

    private static void processMethods(DirectClassFile directClassFile, CfOptions cfOptions, DexOptions dexOptions, ClassDefItem classDefItem, MethodIdsSection methodIdsSection) {
        StringBuilder sb;
        CstMethodRef cstMethodRef;
        DalvCode dalvCode;
        int i;
        EncodedMethod encodedMethod;
        ConcreteMethod concreteMethod;
        StringBuilder sb2;
        RopMethod ropMethod;
        DirectClassFile directClassFile2 = directClassFile;
        CfOptions cfOptions2 = cfOptions;
        DexOptions dexOptions2 = dexOptions;
        ClassDefItem classDefItem2 = classDefItem;
        MethodIdsSection methodIdsSection2 = methodIdsSection;
        CstType thisClass = directClassFile2.getThisClass();
        MethodList methods = directClassFile2.getMethods();
        int size = methods.size();
        int i2 = 0;
        while (i2 < size) {
            Method method = methods.get(i2);
            try {
                CstMethodRef cstMethodRef2 = cstMethodRef;
                CstMethodRef cstMethodRef3 = new CstMethodRef(thisClass, method.getNat());
                CstMethodRef cstMethodRef4 = cstMethodRef2;
                int accessFlags = method.getAccessFlags();
                boolean isStatic = AccessFlags.isStatic(accessFlags);
                boolean isPrivate = AccessFlags.isPrivate(accessFlags);
                boolean isNative = AccessFlags.isNative(accessFlags);
                boolean isAbstract = AccessFlags.isAbstract(accessFlags);
                boolean z = cstMethodRef4.isInstanceInit() || cstMethodRef4.isClassInit();
                if (isNative || isAbstract) {
                    dalvCode = null;
                } else {
                    ConcreteMethod concreteMethod2 = concreteMethod;
                    ConcreteMethod concreteMethod3 = new ConcreteMethod(method, directClassFile2, cfOptions2.positionInfo != 1, cfOptions2.localInfo);
                    ConcreteMethod concreteMethod4 = concreteMethod2;
                    DexTranslationAdvice dexTranslationAdvice = DexTranslationAdvice.THE_ONE;
                    RopMethod convert = Ropper.convert(concreteMethod4, dexTranslationAdvice);
                    int parameterWordCount = cstMethodRef4.getParameterWordCount(isStatic);
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    String sb5 = sb3.append(thisClass.getClassType().getDescriptor()).append(".").append(method.getName().getString()).toString();
                    if (!cfOptions2.optimize || !OptimizerOptions.shouldOptimize(sb5)) {
                        ropMethod = convert;
                        convert = null;
                    } else {
                        ropMethod = Optimizer.optimize(convert, parameterWordCount, isStatic, cfOptions2.localInfo, dexTranslationAdvice);
                        if (cfOptions2.statistics) {
                            CodeStatistics.updateRopStatistics(convert, ropMethod);
                        }
                    }
                    LocalVariableInfo localVariableInfo = null;
                    if (cfOptions2.localInfo) {
                        localVariableInfo = LocalVariableExtractor.extract(ropMethod);
                    }
                    DalvCode translate = RopTranslator.translate(ropMethod, cfOptions2.positionInfo, localVariableInfo, parameterWordCount, dexOptions2);
                    if (cfOptions2.statistics && convert != null) {
                        updateDexStatistics(cfOptions2, dexOptions2, ropMethod, convert, localVariableInfo, parameterWordCount, concreteMethod4.getCode().size());
                    }
                    dalvCode = translate;
                }
                if (AccessFlags.isSynchronized(accessFlags)) {
                    i = 131072 | accessFlags;
                    if (!isNative) {
                        i &= -33;
                    }
                } else {
                    i = accessFlags;
                }
                if (z) {
                    i |= 65536;
                }
                EncodedMethod encodedMethod2 = encodedMethod;
                EncodedMethod encodedMethod3 = new EncodedMethod(cstMethodRef4, i, dalvCode, AttributeTranslator.getExceptions(method));
                EncodedMethod encodedMethod4 = encodedMethod2;
                if (cstMethodRef4.isInstanceInit() || cstMethodRef4.isClassInit() || isStatic || isPrivate) {
                    classDefItem2.addDirectMethod(encodedMethod4);
                } else {
                    classDefItem2.addVirtualMethod(encodedMethod4);
                }
                Annotations methodAnnotations = AttributeTranslator.getMethodAnnotations(method);
                if (methodAnnotations.size() != 0) {
                    classDefItem2.addMethodAnnotations(cstMethodRef4, methodAnnotations);
                }
                AnnotationsList parameterAnnotations = AttributeTranslator.getParameterAnnotations(method);
                if (parameterAnnotations.size() != 0) {
                    classDefItem2.addParameterAnnotations(cstMethodRef4, parameterAnnotations);
                }
                MethodIdItem intern = methodIdsSection2.intern(cstMethodRef4);
                i2++;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                StringBuilder sb6 = sb;
                StringBuilder sb7 = new StringBuilder();
                throw ExceptionWithContext.withContext(runtimeException, sb6.append("...while processing ").append(method.getName().toHuman()).append(" ").append(method.getDescriptor().toHuman()).toString());
            }
        }
    }

    public static ClassDefItem translate(DirectClassFile directClassFile, byte[] bArr, CfOptions cfOptions, DexOptions dexOptions, DexFile dexFile) {
        StringBuilder sb;
        DirectClassFile directClassFile2 = directClassFile;
        try {
            return translate0(directClassFile2, bArr, cfOptions, dexOptions, dexFile);
        } catch (RuntimeException e) {
            RuntimeException runtimeException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            throw ExceptionWithContext.withContext(runtimeException, sb2.append("...while processing ").append(directClassFile2.getFilePath()).toString());
        }
    }

    private static ClassDefItem translate0(DirectClassFile directClassFile, byte[] bArr, CfOptions cfOptions, DexOptions dexOptions, DexFile dexFile) {
        ClassDefItem classDefItem;
        DirectClassFile directClassFile2 = directClassFile;
        byte[] bArr2 = bArr;
        CfOptions cfOptions2 = cfOptions;
        DexOptions dexOptions2 = dexOptions;
        DexFile dexFile2 = dexFile;
        OptimizerOptions.loadOptimizeLists(cfOptions2.optimizeListFile, cfOptions2.dontOptimizeListFile);
        ClassDefItem classDefItem2 = classDefItem;
        ClassDefItem classDefItem3 = new ClassDefItem(directClassFile2.getThisClass(), -33 & directClassFile2.getAccessFlags(), directClassFile2.getSuperclass(), directClassFile2.getInterfaces(), cfOptions2.positionInfo == 1 ? null : directClassFile2.getSourceFile());
        ClassDefItem classDefItem4 = classDefItem2;
        Annotations classAnnotations = AttributeTranslator.getClassAnnotations(directClassFile2, cfOptions2);
        if (classAnnotations.size() != 0) {
            classDefItem4.setClassAnnotations(classAnnotations);
        }
        FieldIdsSection fieldIds = dexFile2.getFieldIds();
        MethodIdsSection methodIds = dexFile2.getMethodIds();
        TypeIdsSection typeIds = dexFile2.getTypeIds();
        processFields(directClassFile2, classDefItem4, fieldIds);
        processMethods(directClassFile2, cfOptions2, dexOptions2, classDefItem4, methodIds);
        ConstantPool constantPool = directClassFile2.getConstantPool();
        int size = constantPool.size();
        for (int i = 0; i < size; i++) {
            Constant orNull = constantPool.getOrNull(i);
            if (orNull instanceof CstMethodRef) {
                MethodIdItem intern = methodIds.intern((CstBaseMethodRef) orNull);
            } else if (orNull instanceof CstInterfaceMethodRef) {
                MethodIdItem intern2 = methodIds.intern(((CstInterfaceMethodRef) orNull).toMethodRef());
            } else if (orNull instanceof CstFieldRef) {
                FieldIdItem intern3 = fieldIds.intern((CstFieldRef) orNull);
            } else if (orNull instanceof CstEnumRef) {
                FieldIdItem intern4 = fieldIds.intern(((CstEnumRef) orNull).getFieldRef());
            } else if (orNull instanceof CstType) {
                TypeIdItem intern5 = typeIds.intern((CstType) orNull);
            }
        }
        return classDefItem4;
    }

    private static void updateDexStatistics(CfOptions cfOptions, DexOptions dexOptions, RopMethod ropMethod, RopMethod ropMethod2, LocalVariableInfo localVariableInfo, int i, int i2) {
        C06611 r15;
        CfOptions cfOptions2 = cfOptions;
        DexOptions dexOptions2 = dexOptions;
        RopMethod ropMethod3 = ropMethod2;
        LocalVariableInfo localVariableInfo2 = localVariableInfo;
        int i3 = i;
        int i4 = i2;
        DalvCode translate = RopTranslator.translate(ropMethod, cfOptions2.positionInfo, localVariableInfo2, i3, dexOptions2);
        DalvCode translate2 = RopTranslator.translate(ropMethod3, cfOptions2.positionInfo, localVariableInfo2, i3, dexOptions2);
        C06611 r10 = r15;
        C06611 r11 = new AssignIndicesCallback() {
            public int getIndex(Constant constant) {
                Constant constant2 = constant;
                return 0;
            }
        };
        C06611 r9 = r10;
        translate.assignIndices(r9);
        translate2.assignIndices(r9);
        CodeStatistics.updateDexStatistics(translate2, translate);
        CodeStatistics.updateOriginalByteCount(i4);
    }
}
