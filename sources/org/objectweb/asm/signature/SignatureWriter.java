package org.objectweb.asm.signature;

public class SignatureWriter extends SignatureVisitor {

    /* renamed from: a */
    private final StringBuffer f428a;

    /* renamed from: b */
    private boolean f429b;

    /* renamed from: c */
    private boolean f430c;

    /* renamed from: d */
    private int f431d;

    public SignatureWriter() {
        StringBuffer stringBuffer;
        super(262144);
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        this.f428a = stringBuffer2;
    }

    /* renamed from: a */
    private void m151a() {
        if (this.f429b) {
            this.f429b = false;
            StringBuffer append = this.f428a.append('>');
        }
    }

    /* renamed from: b */
    private void m152b() {
        if (this.f431d % 2 != 0) {
            StringBuffer append = this.f428a.append('>');
        }
        this.f431d /= 2;
    }

    public String toString() {
        return this.f428a.toString();
    }

    public SignatureVisitor visitArrayType() {
        StringBuffer append = this.f428a.append('[');
        return this;
    }

    public void visitBaseType(char c) {
        char c2 = c;
        StringBuffer append = this.f428a.append(c2);
    }

    public SignatureVisitor visitClassBound() {
        return this;
    }

    public void visitClassType(String str) {
        String str2 = str;
        StringBuffer append = this.f428a.append('L');
        StringBuffer append2 = this.f428a.append(str2);
        this.f431d = 2 * this.f431d;
    }

    public void visitEnd() {
        m152b();
        StringBuffer append = this.f428a.append(';');
    }

    public SignatureVisitor visitExceptionType() {
        StringBuffer append = this.f428a.append('^');
        return this;
    }

    public void visitFormalTypeParameter(String str) {
        String str2 = str;
        if (!this.f429b) {
            this.f429b = true;
            StringBuffer append = this.f428a.append('<');
        }
        StringBuffer append2 = this.f428a.append(str2);
        StringBuffer append3 = this.f428a.append(':');
    }

    public void visitInnerClassType(String str) {
        String str2 = str;
        m152b();
        StringBuffer append = this.f428a.append('.');
        StringBuffer append2 = this.f428a.append(str2);
        this.f431d = 2 * this.f431d;
    }

    public SignatureVisitor visitInterface() {
        return this;
    }

    public SignatureVisitor visitInterfaceBound() {
        StringBuffer append = this.f428a.append(':');
        return this;
    }

    public SignatureVisitor visitParameterType() {
        m151a();
        if (!this.f430c) {
            this.f430c = true;
            StringBuffer append = this.f428a.append('(');
        }
        return this;
    }

    public SignatureVisitor visitReturnType() {
        m151a();
        if (!this.f430c) {
            StringBuffer append = this.f428a.append('(');
        }
        StringBuffer append2 = this.f428a.append(')');
        return this;
    }

    public SignatureVisitor visitSuperclass() {
        m151a();
        return this;
    }

    public SignatureVisitor visitTypeArgument(char c) {
        char c2 = c;
        if (this.f431d % 2 == 0) {
            this.f431d = 1 + this.f431d;
            StringBuffer append = this.f428a.append('<');
        }
        if (c2 != '=') {
            StringBuffer append2 = this.f428a.append(c2);
        }
        return this;
    }

    public void visitTypeArgument() {
        if (this.f431d % 2 == 0) {
            this.f431d = 1 + this.f431d;
            StringBuffer append = this.f428a.append('<');
        }
        StringBuffer append2 = this.f428a.append('*');
    }

    public void visitTypeVariable(String str) {
        String str2 = str;
        StringBuffer append = this.f428a.append('T');
        StringBuffer append2 = this.f428a.append(str2);
        StringBuffer append3 = this.f428a.append(';');
    }
}
