package org.objectweb.asm.signature;

public class SignatureReader {

    /* renamed from: a */
    private final String f427a;

    public SignatureReader(String str) {
        this.f427a = str;
    }

    /* renamed from: a */
    private static int m150a(String str, int i, SignatureVisitor signatureVisitor) {
        String str2 = str;
        int i2 = i;
        SignatureVisitor signatureVisitor2 = signatureVisitor;
        int i3 = i2 + 1;
        char charAt = str2.charAt(i2);
        switch (charAt) {
            case 'B':
            case 'C':
            case 'D':
            case 'F':
            case 'I':
            case 'J':
            case 'S':
            case 'V':
            case 'Z':
                signatureVisitor2.visitBaseType(charAt);
                return i3;
            case 'T':
                int indexOf = str2.indexOf(59, i3);
                signatureVisitor2.visitTypeVariable(str2.substring(i3, indexOf));
                return indexOf + 1;
            case '[':
                return m150a(str2, i3, signatureVisitor2.visitArrayType());
            default:
                boolean z = false;
                int i4 = i3;
                int i5 = i3;
                boolean z2 = false;
                while (true) {
                    int i6 = i5 + 1;
                    char charAt2 = str2.charAt(i5);
                    switch (charAt2) {
                        case '.':
                        case ';':
                            if (!z) {
                                String substring = str2.substring(i4, i6 - 1);
                                if (z2) {
                                    signatureVisitor2.visitInnerClassType(substring);
                                } else {
                                    signatureVisitor2.visitClassType(substring);
                                }
                            }
                            if (charAt2 != ';') {
                                z2 = true;
                                i4 = i6;
                                i5 = i6;
                                z = false;
                                break;
                            } else {
                                signatureVisitor2.visitEnd();
                                return i6;
                            }
                        case '<':
                            String substring2 = str2.substring(i4, i6 - 1);
                            if (z2) {
                                signatureVisitor2.visitInnerClassType(substring2);
                            } else {
                                signatureVisitor2.visitClassType(substring2);
                            }
                            int i7 = i6;
                            while (true) {
                                char charAt3 = str2.charAt(i7);
                                switch (charAt3) {
                                    case '*':
                                        i7++;
                                        signatureVisitor2.visitTypeArgument();
                                        break;
                                    case '+':
                                    case '-':
                                        i7 = m150a(str2, i7 + 1, signatureVisitor2.visitTypeArgument(charAt3));
                                        break;
                                    case '>':
                                        i5 = i7;
                                        z = true;
                                        continue;
                                    default:
                                        i7 = m150a(str2, i7, signatureVisitor2.visitTypeArgument(SignatureVisitor.INSTANCEOF));
                                        break;
                                }
                            }
                        default:
                            i5 = i6;
                            break;
                    }
                }
        }
    }

    public void accept(SignatureVisitor signatureVisitor) {
        int i;
        char charAt;
        SignatureVisitor signatureVisitor2 = signatureVisitor;
        String str = this.f427a;
        int length = str.length();
        int i2 = 0;
        if (str.charAt(0) == '<') {
            i2 = 2;
            do {
                int indexOf = str.indexOf(58, i2);
                signatureVisitor2.visitFormalTypeParameter(str.substring(i2 - 1, indexOf));
                int i3 = indexOf + 1;
                char charAt2 = str.charAt(i3);
                int a = (charAt2 == 'L' || charAt2 == '[' || charAt2 == 'T') ? m150a(str, i3, signatureVisitor2.visitClassBound()) : i3;
                while (true) {
                    int i4 = a;
                    i2 = i4 + 1;
                    charAt = str.charAt(i4);
                    if (charAt != ':') {
                        break;
                    }
                    a = m150a(str, i2, signatureVisitor2.visitInterfaceBound());
                }
            } while (charAt != '>');
        }
        if (str.charAt(i2) == '(') {
            int i5 = i2 + 1;
            while (true) {
                i = i5;
                if (str.charAt(i) == ')') {
                    break;
                }
                i5 = m150a(str, i, signatureVisitor2.visitParameterType());
            }
            int a2 = m150a(str, i + 1, signatureVisitor2.visitReturnType());
            while (true) {
                int i6 = a2;
                if (i6 < length) {
                    a2 = m150a(str, i6 + 1, signatureVisitor2.visitExceptionType());
                } else {
                    return;
                }
            }
        } else {
            int a3 = m150a(str, i2, signatureVisitor2.visitSuperclass());
            while (true) {
                int i7 = a3;
                if (i7 < length) {
                    a3 = m150a(str, i7, signatureVisitor2.visitInterface());
                } else {
                    return;
                }
            }
        }
    }

    public void acceptType(SignatureVisitor signatureVisitor) {
        SignatureVisitor signatureVisitor2 = signatureVisitor;
        int a = m150a(this.f427a, 0, signatureVisitor2);
    }
}
