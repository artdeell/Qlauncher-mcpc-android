package org.objectweb.asm.commons;

import org.objectweb.asm.signature.SignatureVisitor;

public class RemappingSignatureAdapter extends SignatureVisitor {
    private String className;
    private final Remapper remapper;

    /* renamed from: v */
    private final SignatureVisitor f426v;

    protected RemappingSignatureAdapter(int i, SignatureVisitor signatureVisitor, Remapper remapper2) {
        SignatureVisitor signatureVisitor2 = signatureVisitor;
        Remapper remapper3 = remapper2;
        super(i);
        this.f426v = signatureVisitor2;
        this.remapper = remapper3;
    }

    public RemappingSignatureAdapter(SignatureVisitor signatureVisitor, Remapper remapper2) {
        this(262144, signatureVisitor, remapper2);
    }

    public SignatureVisitor visitArrayType() {
        SignatureVisitor visitArrayType = this.f426v.visitArrayType();
        return this;
    }

    public void visitBaseType(char c) {
        char c2 = c;
        this.f426v.visitBaseType(c2);
    }

    public SignatureVisitor visitClassBound() {
        SignatureVisitor visitClassBound = this.f426v.visitClassBound();
        return this;
    }

    public void visitClassType(String str) {
        String str2 = str;
        this.className = str2;
        this.f426v.visitClassType(this.remapper.mapType(str2));
    }

    public void visitEnd() {
        this.f426v.visitEnd();
    }

    public SignatureVisitor visitExceptionType() {
        SignatureVisitor visitExceptionType = this.f426v.visitExceptionType();
        return this;
    }

    public void visitFormalTypeParameter(String str) {
        String str2 = str;
        this.f426v.visitFormalTypeParameter(str2);
    }

    public void visitInnerClassType(String str) {
        StringBuffer stringBuffer;
        String str2 = str;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        this.className = stringBuffer2.append(this.className).append('$').append(str2).toString();
        String mapType = this.remapper.mapType(this.className);
        this.f426v.visitInnerClassType(mapType.substring(1 + mapType.lastIndexOf(36)));
    }

    public SignatureVisitor visitInterface() {
        SignatureVisitor visitInterface = this.f426v.visitInterface();
        return this;
    }

    public SignatureVisitor visitInterfaceBound() {
        SignatureVisitor visitInterfaceBound = this.f426v.visitInterfaceBound();
        return this;
    }

    public SignatureVisitor visitParameterType() {
        SignatureVisitor visitParameterType = this.f426v.visitParameterType();
        return this;
    }

    public SignatureVisitor visitReturnType() {
        SignatureVisitor visitReturnType = this.f426v.visitReturnType();
        return this;
    }

    public SignatureVisitor visitSuperclass() {
        SignatureVisitor visitSuperclass = this.f426v.visitSuperclass();
        return this;
    }

    public SignatureVisitor visitTypeArgument(char c) {
        SignatureVisitor visitTypeArgument = this.f426v.visitTypeArgument(c);
        return this;
    }

    public void visitTypeArgument() {
        this.f426v.visitTypeArgument();
    }

    public void visitTypeVariable(String str) {
        String str2 = str;
        this.f426v.visitTypeVariable(str2);
    }
}
