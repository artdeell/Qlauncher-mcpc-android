package org.objectweb.asm;

import org.lwjgl.opengl.GL11;

final class Frame {

    /* renamed from: a */
    static final int[] f337a;

    /* renamed from: b */
    Label f338b;

    /* renamed from: c */
    int[] f339c;

    /* renamed from: d */
    int[] f340d;

    /* renamed from: e */
    private int[] f341e;

    /* renamed from: f */
    private int[] f342f;

    /* renamed from: g */
    private int f343g;

    /* renamed from: h */
    private int f344h;

    /* renamed from: i */
    private int[] f345i;

    static {
        int[] iArr = new int[202];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 65467 + "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i);
        }
        f337a = iArr;
    }

    Frame() {
    }

    /* renamed from: a */
    private int m98a() {
        if (this.f343g > 0) {
            int[] iArr = this.f342f;
            int i = -1 + this.f343g;
            this.f343g = i;
            return iArr[i];
        }
        Label label = this.f338b;
        int i2 = -1 + label.f370f;
        label.f370f = i2;
        return 50331648 | (-i2);
    }

    /* renamed from: a */
    private int m99a(int i) {
        int i2;
        int i3 = i;
        if (this.f341e == null || i3 >= this.f341e.length) {
            i2 = 33554432 | i3;
        } else {
            i2 = this.f341e[i3];
            if (i2 == 0) {
                int i4 = 33554432 | i3;
                this.f341e[i3] = i4;
                return i4;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private int m100a(ClassWriter classWriter, int i) {
        int c;
        ClassWriter classWriter2 = classWriter;
        int i2 = i;
        if (i2 == 16777222) {
            c = 24117248 | classWriter2.mo11155c(classWriter2.f294I);
        } else {
            if ((-1048576 & i2) == 25165824) {
                c = 24117248 | classWriter2.mo11155c(classWriter2.f293H[1048575 & i2].f360g);
            }
            return i2;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.f344h) {
                break;
            }
            int i4 = this.f345i[i3];
            int i5 = -268435456 & i4;
            int i6 = 251658240 & i4;
            if (i6 == 33554432) {
                i4 = i5 + this.f339c[i4 & 8388607];
            } else if (i6 == 50331648) {
                i4 = i5 + this.f340d[this.f340d.length - (i4 & 8388607)];
            }
            if (i2 == i4) {
                i2 = c;
                break;
            }
            i3++;
        }
        return i2;
    }

    /* renamed from: a */
    private void m101a(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.f341e == null) {
            this.f341e = new int[10];
        }
        int length = this.f341e.length;
        if (i3 >= length) {
            int[] iArr = new int[Math.max(i3 + 1, length * 2)];
            System.arraycopy(this.f341e, 0, iArr, 0, length);
            this.f341e = iArr;
        }
        this.f341e[i3] = i4;
    }

    /* renamed from: a */
    private void m102a(String str) {
        String str2 = str;
        char charAt = str2.charAt(0);
        if (charAt == '(') {
            m107c(-1 + (Type.getArgumentsAndReturnSizes(str2) >> 2));
        } else if (charAt == 'J' || charAt == 'D') {
            m107c(2);
        } else {
            m107c(1);
        }
    }

    /* renamed from: a */
    private void m103a(ClassWriter classWriter, String str) {
        int b = m105b(classWriter, str);
        if (b != 0) {
            m106b(b);
            if (b == 16777220 || b == 16777219) {
                m106b(16777216);
            }
        }
    }

    /* renamed from: a */
    private static boolean m104a(ClassWriter classWriter, int i, int[] iArr, int i2) {
        int i3;
        ClassWriter classWriter2 = classWriter;
        int i4 = i;
        int[] iArr2 = iArr;
        int i5 = i2;
        int i6 = iArr2[i5];
        if (i6 == i4) {
            return false;
        }
        if ((268435455 & i4) != 16777221) {
            i3 = i4;
        } else if (i6 == 16777221) {
            return false;
        } else {
            i3 = 16777221;
        }
        if (i6 == 0) {
            iArr2[i5] = i3;
            return true;
        }
        if ((i6 & 267386880) == 24117248 || (i6 & -268435456) != 0) {
            if (i3 == 16777221) {
                return false;
            }
            i3 = (-1048576 & i3) == (-1048576 & i6) ? (i6 & 267386880) == 24117248 ? 24117248 | (i3 & -268435456) | classWriter2.mo11142a(i3 & GL11.GL_ALL_ATTRIB_BITS, 1048575 & i6) : 24117248 | classWriter2.mo11155c("java/lang/Object") : ((i3 & 267386880) == 24117248 || (i3 & -268435456) != 0) ? 24117248 | classWriter2.mo11155c("java/lang/Object") : 16777216;
        } else if (i6 != 16777221) {
            i3 = 16777216;
        } else if ((i3 & 267386880) != 24117248 && (i3 & -268435456) == 0) {
            i3 = 16777216;
        }
        if (i6 == i3) {
            return false;
        }
        iArr2[i5] = i3;
        return true;
    }

    /* renamed from: b */
    private static int m105b(ClassWriter classWriter, String str) {
        ClassWriter classWriter2 = classWriter;
        String str2 = str;
        int i = 16777217;
        int i2 = str2.charAt(0) == '(' ? 1 + str2.indexOf(41) : 0;
        int i3 = 0;
        switch (str2.charAt(i2)) {
            case 'B':
            case 'C':
            case 'I':
            case 'S':
            case 'Z':
                i3 = 16777217;
                break;
            case 'D':
                return 16777219;
            case 'F':
                return 16777218;
            case 'J':
                return 16777220;
            case 'L':
                return 24117248 | classWriter2.mo11155c(str2.substring(i2 + 1, -1 + str2.length()));
            case 'V':
                break;
            default:
                int i4 = i2 + 1;
                while (str2.charAt(i4) == '[') {
                    i4++;
                }
                switch (str2.charAt(i4)) {
                    case 'B':
                        i = 16777226;
                        break;
                    case 'C':
                        i = 16777227;
                        break;
                    case 'D':
                        i = 16777219;
                        break;
                    case 'F':
                        i = 16777218;
                        break;
                    case 'I':
                        break;
                    case 'J':
                        i = 16777220;
                        break;
                    case 'S':
                        i = 16777228;
                        break;
                    case 'Z':
                        i = 16777225;
                        break;
                    default:
                        i = 24117248 | classWriter2.mo11155c(str2.substring(i4 + 1, -1 + str2.length()));
                        break;
                }
                return i | ((i4 - i2) << 28);
        }
        return i3;
    }

    /* renamed from: b */
    private void m106b(int i) {
        int i2 = i;
        if (this.f342f == null) {
            this.f342f = new int[10];
        }
        int length = this.f342f.length;
        if (this.f343g >= length) {
            int[] iArr = new int[Math.max(1 + this.f343g, length * 2)];
            System.arraycopy(this.f342f, 0, iArr, 0, length);
            this.f342f = iArr;
        }
        int[] iArr2 = this.f342f;
        int i3 = this.f343g;
        this.f343g = i3 + 1;
        iArr2[i3] = i2;
        int i4 = this.f338b.f370f + this.f343g;
        if (i4 > this.f338b.f371g) {
            this.f338b.f371g = i4;
        }
    }

    /* renamed from: c */
    private void m107c(int i) {
        int i2 = i;
        if (this.f343g >= i2) {
            this.f343g -= i2;
            return;
        }
        this.f338b.f370f -= i2 - this.f343g;
        this.f343g = 0;
    }

    /* renamed from: d */
    private void m108d(int i) {
        int i2 = i;
        if (this.f345i == null) {
            this.f345i = new int[2];
        }
        int length = this.f345i.length;
        if (this.f344h >= length) {
            int[] iArr = new int[Math.max(1 + this.f344h, length * 2)];
            System.arraycopy(this.f345i, 0, iArr, 0, length);
            this.f345i = iArr;
        }
        int[] iArr2 = this.f345i;
        int i3 = this.f344h;
        this.f344h = i3 + 1;
        iArr2[i3] = i2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11170a(int i, int i2, ClassWriter classWriter, Item item) {
        StringBuffer stringBuffer;
        RuntimeException runtimeException;
        int i3 = i;
        int i4 = i2;
        ClassWriter classWriter2 = classWriter;
        Item item2 = item;
        switch (i3) {
            case 0:
            case 116:
            case 117:
            case 118:
            case 119:
            case 145:
            case 146:
            case 147:
            case 167:
            case 177:
                return;
            case 1:
                m106b(16777221);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 16:
            case 17:
            case 21:
                m106b(16777217);
                return;
            case 9:
            case 10:
            case 22:
                m106b(16777220);
                m106b(16777216);
                return;
            case 11:
            case 12:
            case 13:
            case 23:
                m106b(16777218);
                return;
            case 14:
            case 15:
            case 24:
                m106b(16777219);
                m106b(16777216);
                return;
            case 18:
                switch (item2.f357b) {
                    case 3:
                        m106b(16777217);
                        return;
                    case 4:
                        m106b(16777218);
                        return;
                    case 5:
                        m106b(16777220);
                        m106b(16777216);
                        return;
                    case 6:
                        m106b(16777219);
                        m106b(16777216);
                        return;
                    case 7:
                        m106b(24117248 | classWriter2.mo11155c("java/lang/Class"));
                        return;
                    case 8:
                        m106b(24117248 | classWriter2.mo11155c("java/lang/String"));
                        return;
                    case 16:
                        m106b(24117248 | classWriter2.mo11155c("java/lang/invoke/MethodType"));
                        return;
                    default:
                        m106b(24117248 | classWriter2.mo11155c("java/lang/invoke/MethodHandle"));
                        return;
                }
            case 25:
                m106b(m99a(i4));
                return;
            case 46:
            case 51:
            case 52:
            case 53:
                m107c(2);
                m106b(16777217);
                return;
            case 47:
            case 143:
                m107c(2);
                m106b(16777220);
                m106b(16777216);
                return;
            case 48:
                m107c(2);
                m106b(16777218);
                return;
            case 49:
            case 138:
                m107c(2);
                m106b(16777219);
                m106b(16777216);
                return;
            case 50:
                m107c(1);
                m106b(-268435456 + m98a());
                return;
            case 54:
            case 56:
            case 58:
                m101a(i4, m98a());
                if (i4 > 0) {
                    int a = m99a(i4 - 1);
                    if (a == 16777220 || a == 16777219) {
                        m101a(i4 - 1, 16777216);
                        return;
                    } else if ((251658240 & a) != 16777216) {
                        m101a(i4 - 1, a | 8388608);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 55:
            case 57:
                m107c(1);
                m101a(i4, m98a());
                m101a(i4 + 1, 16777216);
                if (i4 > 0) {
                    int a2 = m99a(i4 - 1);
                    if (a2 == 16777220 || a2 == 16777219) {
                        m101a(i4 - 1, 16777216);
                        return;
                    } else if ((251658240 & a2) != 16777216) {
                        m101a(i4 - 1, a2 | 8388608);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 79:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
                m107c(3);
                return;
            case 80:
            case 82:
                m107c(4);
                return;
            case 87:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 170:
            case 171:
            case 172:
            case 174:
            case 176:
            case 191:
            case 194:
            case 195:
            case 198:
            case 199:
                m107c(1);
                return;
            case 88:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 173:
            case 175:
                m107c(2);
                return;
            case 89:
                int a3 = m98a();
                m106b(a3);
                m106b(a3);
                return;
            case 90:
                int a4 = m98a();
                int a5 = m98a();
                m106b(a4);
                m106b(a5);
                m106b(a4);
                return;
            case 91:
                int a6 = m98a();
                int a7 = m98a();
                int a8 = m98a();
                m106b(a6);
                m106b(a8);
                m106b(a7);
                m106b(a6);
                return;
            case 92:
                int a9 = m98a();
                int a10 = m98a();
                m106b(a10);
                m106b(a9);
                m106b(a10);
                m106b(a9);
                return;
            case 93:
                int a11 = m98a();
                int a12 = m98a();
                int a13 = m98a();
                m106b(a12);
                m106b(a11);
                m106b(a13);
                m106b(a12);
                m106b(a11);
                return;
            case 94:
                int a14 = m98a();
                int a15 = m98a();
                int a16 = m98a();
                int a17 = m98a();
                m106b(a15);
                m106b(a14);
                m106b(a17);
                m106b(a16);
                m106b(a15);
                m106b(a14);
                return;
            case 95:
                int a18 = m98a();
                int a19 = m98a();
                m106b(a18);
                m106b(a19);
                return;
            case 96:
            case 100:
            case 104:
            case 108:
            case 112:
            case 120:
            case 122:
            case 124:
            case 126:
            case 128:
            case 130:
            case 136:
            case 142:
            case 149:
            case 150:
                m107c(2);
                m106b(16777217);
                return;
            case 97:
            case 101:
            case 105:
            case 109:
            case 113:
            case 127:
            case 129:
            case 131:
                m107c(4);
                m106b(16777220);
                m106b(16777216);
                return;
            case 98:
            case 102:
            case 106:
            case 110:
            case 114:
            case 137:
            case 144:
                m107c(2);
                m106b(16777218);
                return;
            case 99:
            case 103:
            case 107:
            case 111:
            case 115:
                m107c(4);
                m106b(16777219);
                m106b(16777216);
                return;
            case 121:
            case 123:
            case 125:
                m107c(3);
                m106b(16777220);
                m106b(16777216);
                return;
            case 132:
                m101a(i4, 16777217);
                return;
            case 133:
            case 140:
                m107c(1);
                m106b(16777220);
                m106b(16777216);
                return;
            case 134:
                m107c(1);
                m106b(16777218);
                return;
            case 135:
            case 141:
                m107c(1);
                m106b(16777219);
                m106b(16777216);
                return;
            case 139:
            case 190:
            case 193:
                m107c(1);
                m106b(16777217);
                return;
            case 148:
            case 151:
            case 152:
                m107c(4);
                m106b(16777217);
                return;
            case 168:
            case 169:
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("JSR/RET are not supported with computeFrames option");
                throw runtimeException2;
            case 178:
                m103a(classWriter2, item2.f362i);
                return;
            case 179:
                m102a(item2.f362i);
                return;
            case 180:
                m107c(1);
                m103a(classWriter2, item2.f362i);
                return;
            case 181:
                m102a(item2.f362i);
                int a20 = m98a();
                return;
            case 182:
            case 183:
            case 184:
            case 185:
                m102a(item2.f362i);
                if (i3 != 184) {
                    int a21 = m98a();
                    if (i3 == 183 && item2.f361h.charAt(0) == '<') {
                        m108d(a21);
                    }
                }
                m103a(classWriter2, item2.f362i);
                return;
            case 186:
                m102a(item2.f361h);
                m103a(classWriter2, item2.f361h);
                return;
            case 187:
                m106b(25165824 | classWriter2.mo11143a(item2.f360g, i4));
                return;
            case 188:
                int a22 = m98a();
                switch (i4) {
                    case 4:
                        m106b(285212681);
                        return;
                    case 5:
                        m106b(285212683);
                        return;
                    case 6:
                        m106b(285212674);
                        return;
                    case 7:
                        m106b(285212675);
                        return;
                    case 8:
                        m106b(285212682);
                        return;
                    case 9:
                        m106b(285212684);
                        return;
                    case 10:
                        m106b(285212673);
                        return;
                    default:
                        m106b(285212676);
                        return;
                }
            case 189:
                String str = item2.f360g;
                int a23 = m98a();
                if (str.charAt(0) == '[') {
                    ClassWriter classWriter3 = classWriter2;
                    StringBuffer stringBuffer2 = stringBuffer;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    m103a(classWriter3, stringBuffer2.append('[').append(str).toString());
                    return;
                }
                m106b(292552704 | classWriter2.mo11155c(str));
                return;
            case 192:
                String str2 = item2.f360g;
                int a24 = m98a();
                if (str2.charAt(0) == '[') {
                    m103a(classWriter2, str2);
                    return;
                } else {
                    m106b(24117248 | classWriter2.mo11155c(str2));
                    return;
                }
            default:
                m107c(i4);
                m103a(classWriter2, item2.f360g);
                return;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11171a(ClassWriter classWriter, int i, Type[] typeArr, int i2) {
        int i3;
        ClassWriter classWriter2 = classWriter;
        int i4 = i;
        Type[] typeArr2 = typeArr;
        int i5 = i2;
        int i6 = 1;
        int i7 = 0;
        this.f339c = new int[i5];
        this.f340d = new int[0];
        if ((i4 & 8) != 0) {
            i6 = 0;
            i7 = 0;
        } else if ((262144 & i4) == 0) {
            this.f339c[0] = 24117248 | classWriter2.mo11155c(classWriter2.f294I);
        } else {
            this.f339c[0] = 16777222;
            i7 = 0;
        }
        while (i7 < typeArr2.length) {
            int b = m105b(classWriter2, typeArr2[i7].getDescriptor());
            int i8 = i3 + 1;
            this.f339c[i3] = b;
            if (b == 16777220 || b == 16777219) {
                i3 = i8 + 1;
                this.f339c[i8] = 16777216;
            } else {
                i3 = i8;
            }
            i7++;
        }
        while (i3 < i5) {
            int i9 = i3 + 1;
            this.f339c[i3] = 16777216;
            i3 = i9;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00b3 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo11172a(org.objectweb.asm.ClassWriter r36, org.objectweb.asm.Frame r37, int r38) {
        /*
            r35 = this;
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r38
            r29 = r2
            r0 = r29
            int[] r0 = r0.f339c
            r29 = r0
            r0 = r29
            int r0 = r0.length
            r29 = r0
            r6 = r29
            r29 = r2
            r0 = r29
            int[] r0 = r0.f340d
            r29 = r0
            r0 = r29
            int r0 = r0.length
            r29 = r0
            r7 = r29
            r29 = r4
            r0 = r29
            int[] r0 = r0.f339c
            r29 = r0
            r8 = r29
            r29 = 0
            r9 = r29
            r29 = r8
            if (r29 != 0) goto L_0x004c
            r29 = r4
            r30 = r6
            r0 = r30
            int[] r0 = new int[r0]
            r30 = r0
            r0 = r30
            r1 = r29
            r1.f339c = r0
            r29 = 1
            r9 = r29
        L_0x004c:
            r29 = 0
            r10 = r29
            r29 = r9
            r11 = r29
        L_0x0054:
            r29 = r10
            r30 = r6
            r0 = r29
            r1 = r30
            if (r0 >= r1) goto L_0x0159
            r29 = r2
            r0 = r29
            int[] r0 = r0.f341e
            r29 = r0
            if (r29 == 0) goto L_0x0149
            r29 = r10
            r30 = r2
            r0 = r30
            int[] r0 = r0.f341e
            r30 = r0
            r0 = r30
            int r0 = r0.length
            r30 = r0
            r0 = r29
            r1 = r30
            if (r0 >= r1) goto L_0x0149
            r29 = r2
            r0 = r29
            int[] r0 = r0.f341e
            r29 = r0
            r30 = r10
            r29 = r29[r30]
            r25 = r29
            r29 = r25
            if (r29 != 0) goto L_0x00ce
            r29 = r2
            r0 = r29
            int[] r0 = r0.f339c
            r29 = r0
            r30 = r10
            r29 = r29[r30]
            r25 = r29
        L_0x009d:
            r29 = r2
            r0 = r29
            int[] r0 = r0.f345i
            r29 = r0
            if (r29 == 0) goto L_0x00b3
            r29 = r2
            r30 = r3
            r31 = r25
            int r29 = r29.m100a(r30, r31)
            r25 = r29
        L_0x00b3:
            r29 = r11
            r30 = r3
            r31 = r25
            r32 = r4
            r0 = r32
            int[] r0 = r0.f339c
            r32 = r0
            r33 = r10
            boolean r30 = m104a(r30, r31, r32, r33)
            r29 = r29 | r30
            r11 = r29
            int r10 = r10 + 1
            goto L_0x0054
        L_0x00ce:
            r29 = -268435456(0xfffffffff0000000, float:-1.58456325E29)
            r30 = r25
            r29 = r29 & r30
            r26 = r29
            r29 = 251658240(0xf000000, float:6.3108872E-30)
            r30 = r25
            r29 = r29 & r30
            r27 = r29
            r29 = r27
            r30 = 16777216(0x1000000, float:2.3509887E-38)
            r0 = r29
            r1 = r30
            if (r0 == r1) goto L_0x009d
            r29 = r27
            r30 = 33554432(0x2000000, float:9.403955E-38)
            r0 = r29
            r1 = r30
            if (r0 != r1) goto L_0x012d
            r29 = r26
            r30 = r2
            r0 = r30
            int[] r0 = r0.f339c
            r30 = r0
            r31 = 8388607(0x7fffff, float:1.1754942E-38)
            r32 = r25
            r31 = r31 & r32
            r30 = r30[r31]
            int r29 = r29 + r30
            r28 = r29
        L_0x0109:
            r29 = r25
            r30 = 8388608(0x800000, float:1.17549435E-38)
            r29 = r29 & r30
            if (r29 == 0) goto L_0x0348
            r29 = r28
            r30 = 16777220(0x1000004, float:2.3509898E-38)
            r0 = r29
            r1 = r30
            if (r0 == r1) goto L_0x0127
            r29 = r28
            r30 = 16777219(0x1000003, float:2.3509895E-38)
            r0 = r29
            r1 = r30
            if (r0 != r1) goto L_0x0348
        L_0x0127:
            r29 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r29
            goto L_0x009d
        L_0x012d:
            r29 = r26
            r30 = r2
            r0 = r30
            int[] r0 = r0.f340d
            r30 = r0
            r31 = r7
            r32 = 8388607(0x7fffff, float:1.1754942E-38)
            r33 = r25
            r32 = r32 & r33
            int r31 = r31 - r32
            r30 = r30[r31]
            int r29 = r29 + r30
            r28 = r29
            goto L_0x0109
        L_0x0149:
            r29 = r2
            r0 = r29
            int[] r0 = r0.f339c
            r29 = r0
            r30 = r10
            r29 = r29[r30]
            r25 = r29
            goto L_0x009d
        L_0x0159:
            r29 = r5
            if (r29 <= 0) goto L_0x01d3
            r29 = 0
            r22 = r29
            r29 = r11
            r23 = r29
        L_0x0165:
            r29 = r22
            r30 = r6
            r0 = r29
            r1 = r30
            if (r0 >= r1) goto L_0x0198
            r29 = r23
            r30 = r3
            r31 = r2
            r0 = r31
            int[] r0 = r0.f339c
            r31 = r0
            r32 = r22
            r31 = r31[r32]
            r32 = r4
            r0 = r32
            int[] r0 = r0.f339c
            r32 = r0
            r33 = r22
            boolean r30 = m104a(r30, r31, r32, r33)
            r29 = r29 | r30
            r24 = r29
            int r22 = r22 + 1
            r29 = r24
            r23 = r29
            goto L_0x0165
        L_0x0198:
            r29 = r4
            r0 = r29
            int[] r0 = r0.f340d
            r29 = r0
            if (r29 != 0) goto L_0x01b6
            r29 = r4
            r30 = 1
            r0 = r30
            int[] r0 = new int[r0]
            r30 = r0
            r0 = r30
            r1 = r29
            r1.f340d = r0
            r29 = 1
            r23 = r29
        L_0x01b6:
            r29 = r23
            r30 = r3
            r31 = r5
            r32 = r4
            r0 = r32
            int[] r0 = r0.f340d
            r32 = r0
            r33 = 0
            boolean r30 = m104a(r30, r31, r32, r33)
            r29 = r29 | r30
            r15 = r29
        L_0x01ce:
            r29 = r15
            r2 = r29
            return r2
        L_0x01d3:
            r29 = r2
            r0 = r29
            int[] r0 = r0.f340d
            r29 = r0
            r0 = r29
            int r0 = r0.length
            r29 = r0
            r30 = r2
            r0 = r30
            org.objectweb.asm.Label r0 = r0.f338b
            r30 = r0
            r0 = r30
            int r0 = r0.f370f
            r30 = r0
            int r29 = r29 + r30
            r12 = r29
            r29 = r4
            r0 = r29
            int[] r0 = r0.f340d
            r29 = r0
            if (r29 != 0) goto L_0x0342
            r29 = r4
            r30 = r12
            r31 = r2
            r0 = r31
            int r0 = r0.f343g
            r31 = r0
            int r30 = r30 + r31
            r0 = r30
            int[] r0 = new int[r0]
            r30 = r0
            r0 = r30
            r1 = r29
            r1.f340d = r0
            r29 = 1
            r13 = r29
        L_0x021a:
            r29 = 0
            r14 = r29
            r29 = r13
            r15 = r29
        L_0x0222:
            r29 = r14
            r30 = r12
            r0 = r29
            r1 = r30
            if (r0 >= r1) goto L_0x026b
            r29 = r2
            r0 = r29
            int[] r0 = r0.f340d
            r29 = r0
            r30 = r14
            r29 = r29[r30]
            r21 = r29
            r29 = r2
            r0 = r29
            int[] r0 = r0.f345i
            r29 = r0
            if (r29 == 0) goto L_0x0250
            r29 = r2
            r30 = r3
            r31 = r21
            int r29 = r29.m100a(r30, r31)
            r21 = r29
        L_0x0250:
            r29 = r15
            r30 = r3
            r31 = r21
            r32 = r4
            r0 = r32
            int[] r0 = r0.f340d
            r32 = r0
            r33 = r14
            boolean r30 = m104a(r30, r31, r32, r33)
            r29 = r29 | r30
            r15 = r29
            int r14 = r14 + 1
            goto L_0x0222
        L_0x026b:
            r29 = 0
            r16 = r29
        L_0x026f:
            r29 = r16
            r30 = r2
            r0 = r30
            int r0 = r0.f343g
            r30 = r0
            r0 = r29
            r1 = r30
            if (r0 >= r1) goto L_0x01ce
            r29 = r2
            r0 = r29
            int[] r0 = r0.f342f
            r29 = r0
            r30 = r16
            r29 = r29[r30]
            r17 = r29
            r29 = -268435456(0xfffffffff0000000, float:-1.58456325E29)
            r30 = r17
            r29 = r29 & r30
            r18 = r29
            r29 = 251658240(0xf000000, float:6.3108872E-30)
            r30 = r17
            r29 = r29 & r30
            r19 = r29
            r29 = r19
            r30 = 16777216(0x1000000, float:2.3509887E-38)
            r0 = r29
            r1 = r30
            if (r0 != r1) goto L_0x02dc
        L_0x02a7:
            r29 = r2
            r0 = r29
            int[] r0 = r0.f345i
            r29 = r0
            if (r29 == 0) goto L_0x02bd
            r29 = r2
            r30 = r3
            r31 = r17
            int r29 = r29.m100a(r30, r31)
            r17 = r29
        L_0x02bd:
            r29 = r15
            r30 = r3
            r31 = r17
            r32 = r4
            r0 = r32
            int[] r0 = r0.f340d
            r32 = r0
            r33 = r12
            r34 = r16
            int r33 = r33 + r34
            boolean r30 = m104a(r30, r31, r32, r33)
            r29 = r29 | r30
            r15 = r29
            int r16 = r16 + 1
            goto L_0x026f
        L_0x02dc:
            r29 = r19
            r30 = 33554432(0x2000000, float:9.403955E-38)
            r0 = r29
            r1 = r30
            if (r0 != r1) goto L_0x0320
            r29 = r18
            r30 = r2
            r0 = r30
            int[] r0 = r0.f339c
            r30 = r0
            r31 = 8388607(0x7fffff, float:1.1754942E-38)
            r32 = r17
            r31 = r31 & r32
            r30 = r30[r31]
            int r29 = r29 + r30
            r20 = r29
        L_0x02fd:
            r29 = r17
            r30 = 8388608(0x800000, float:1.17549435E-38)
            r29 = r29 & r30
            if (r29 == 0) goto L_0x033c
            r29 = r20
            r30 = 16777220(0x1000004, float:2.3509898E-38)
            r0 = r29
            r1 = r30
            if (r0 == r1) goto L_0x031b
            r29 = r20
            r30 = 16777219(0x1000003, float:2.3509895E-38)
            r0 = r29
            r1 = r30
            if (r0 != r1) goto L_0x033c
        L_0x031b:
            r29 = 16777216(0x1000000, float:2.3509887E-38)
            r17 = r29
            goto L_0x02a7
        L_0x0320:
            r29 = r18
            r30 = r2
            r0 = r30
            int[] r0 = r0.f340d
            r30 = r0
            r31 = r7
            r32 = 8388607(0x7fffff, float:1.1754942E-38)
            r33 = r17
            r32 = r32 & r33
            int r31 = r31 - r32
            r30 = r30[r31]
            int r29 = r29 + r30
            r20 = r29
            goto L_0x02fd
        L_0x033c:
            r29 = r20
            r17 = r29
            goto L_0x02a7
        L_0x0342:
            r29 = r11
            r13 = r29
            goto L_0x021a
        L_0x0348:
            r29 = r28
            r25 = r29
            goto L_0x009d
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.Frame.mo11172a(org.objectweb.asm.ClassWriter, org.objectweb.asm.Frame, int):boolean");
    }
}
