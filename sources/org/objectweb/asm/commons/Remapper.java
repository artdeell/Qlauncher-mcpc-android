package org.objectweb.asm.commons;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Type;
import org.objectweb.asm.signature.SignatureReader;
import org.objectweb.asm.signature.SignatureVisitor;
import org.objectweb.asm.signature.SignatureWriter;

public abstract class Remapper {
    public Remapper() {
    }

    private Type mapType(Type type) {
        StringBuffer stringBuffer;
        Type type2 = type;
        switch (type2.getSort()) {
            case 9:
                String mapDesc = mapDesc(type2.getElementType().getDescriptor());
                for (int i = 0; i < type2.getDimensions(); i++) {
                    StringBuffer stringBuffer2 = stringBuffer;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    mapDesc = stringBuffer2.append('[').append(mapDesc).toString();
                }
                return Type.getType(mapDesc);
            case 10:
                String map = map(type2.getInternalName());
                if (map != null) {
                    return Type.getObjectType(map);
                }
                break;
            case 11:
                return Type.getMethodType(mapMethodDesc(type2.getDescriptor()));
        }
        return type2;
    }

    /* access modifiers changed from: protected */
    public SignatureVisitor createRemappingSignatureAdapter(SignatureVisitor signatureVisitor) {
        RemappingSignatureAdapter remappingSignatureAdapter;
        RemappingSignatureAdapter remappingSignatureAdapter2 = remappingSignatureAdapter;
        RemappingSignatureAdapter remappingSignatureAdapter3 = new RemappingSignatureAdapter(signatureVisitor, this);
        return remappingSignatureAdapter2;
    }

    public String map(String str) {
        return str;
    }

    public String mapDesc(String str) {
        StringBuffer stringBuffer;
        String mapDesc;
        StringBuffer stringBuffer2;
        String str2 = str;
        Type type = Type.getType(str2);
        switch (type.getSort()) {
            case 9:
                mapDesc = mapDesc(type.getElementType().getDescriptor());
                for (int i = 0; i < type.getDimensions(); i++) {
                    StringBuffer stringBuffer3 = stringBuffer2;
                    StringBuffer stringBuffer4 = new StringBuffer();
                    mapDesc = stringBuffer3.append('[').append(mapDesc).toString();
                }
                break;
            case 10:
                String map = map(type.getInternalName());
                if (map != null) {
                    StringBuffer stringBuffer5 = stringBuffer;
                    StringBuffer stringBuffer6 = new StringBuffer();
                    return stringBuffer5.append('L').append(map).append(';').toString();
                }
                break;
        }
        mapDesc = str2;
        return mapDesc;
    }

    public String mapFieldName(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str3;
        return str2;
    }

    public String mapInvokeDynamicMethodName(String str, String str2) {
        String str3 = str2;
        return str;
    }

    public String mapMethodDesc(String str) {
        StringBuffer stringBuffer;
        String str2 = str;
        if ("()V".equals(str2)) {
            return str2;
        }
        Type[] argumentTypes = Type.getArgumentTypes(str2);
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer("(");
        StringBuffer stringBuffer4 = stringBuffer2;
        for (int i = 0; i < argumentTypes.length; i++) {
            StringBuffer append = stringBuffer4.append(mapDesc(argumentTypes[i].getDescriptor()));
        }
        Type returnType = Type.getReturnType(str2);
        if (returnType == Type.VOID_TYPE) {
            StringBuffer append2 = stringBuffer4.append(")V");
            return stringBuffer4.toString();
        }
        StringBuffer append3 = stringBuffer4.append(')').append(mapDesc(returnType.getDescriptor()));
        return stringBuffer4.toString();
    }

    public String mapMethodName(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str3;
        return str2;
    }

    public String mapSignature(String str, boolean z) {
        SignatureReader signatureReader;
        SignatureWriter signatureWriter;
        String str2 = str;
        boolean z2 = z;
        if (str2 == null) {
            return null;
        }
        SignatureReader signatureReader2 = signatureReader;
        SignatureReader signatureReader3 = new SignatureReader(str2);
        SignatureReader signatureReader4 = signatureReader2;
        SignatureWriter signatureWriter2 = signatureWriter;
        SignatureWriter signatureWriter3 = new SignatureWriter();
        SignatureWriter signatureWriter4 = signatureWriter2;
        SignatureVisitor createRemappingSignatureAdapter = createRemappingSignatureAdapter(signatureWriter4);
        if (z2) {
            signatureReader4.acceptType(createRemappingSignatureAdapter);
        } else {
            signatureReader4.accept(createRemappingSignatureAdapter);
        }
        return signatureWriter4.toString();
    }

    public String mapType(String str) {
        String str2 = str;
        if (str2 == null) {
            return null;
        }
        return mapType(Type.getObjectType(str2)).getInternalName();
    }

    public String[] mapTypes(String[] strArr) {
        String[] strArr2 = strArr;
        boolean z = false;
        String[] strArr3 = null;
        for (int i = 0; i < strArr2.length; i++) {
            String str = strArr2[i];
            String map = map(str);
            if (map != null && strArr3 == null) {
                strArr3 = new String[strArr2.length];
                if (i > 0) {
                    System.arraycopy(strArr2, 0, strArr3, 0, i);
                }
                z = true;
            }
            if (z) {
                if (map != null) {
                    str = map;
                }
                strArr3[i] = str;
            }
        }
        return z ? strArr3 : strArr2;
    }

    public Object mapValue(Object obj) {
        Handle handle;
        Object obj2 = obj;
        if (obj2 instanceof Type) {
            obj2 = mapType((Type) obj2);
        } else if (obj2 instanceof Handle) {
            Handle handle2 = (Handle) obj2;
            Handle handle3 = handle;
            Handle handle4 = new Handle(handle2.getTag(), mapType(handle2.getOwner()), mapMethodName(handle2.getOwner(), handle2.getName(), handle2.getDesc()), mapMethodDesc(handle2.getDesc()));
            return handle3;
        }
        return obj2;
    }
}
