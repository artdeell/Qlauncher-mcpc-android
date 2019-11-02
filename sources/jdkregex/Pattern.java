package jdkregex;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.Character.UnicodeBlock;
import java.lang.Character.UnicodeScript;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.NVPathRendering;

public final class Pattern implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Pattern.class.desiredAssertionStatus());
    public static final int CANON_EQ = 128;
    public static final int CASE_INSENSITIVE = 2;
    public static final int COMMENTS = 4;
    public static final int DOTALL = 32;
    static final int GREEDY = 0;
    static final int INDEPENDENT = 3;
    static final int LAZY = 1;
    public static final int LITERAL = 16;
    static final int MAX_REPS = Integer.MAX_VALUE;
    public static final int MULTILINE = 8;
    static final int POSSESSIVE = 2;
    public static final int UNICODE_CASE = 64;
    public static final int UNICODE_CHARACTER_CLASS = 256;
    public static final int UNIX_LINES = 1;
    static Node accept = null;
    static Node lastAccept = null;
    static Node lookbehindEnd = null;
    private static final long serialVersionUID = 5073258162644648461L;
    transient int[] buffer;
    transient int capturingGroupCount;
    private volatile transient boolean compiled = false;
    private transient int cursor;
    private int flags;
    transient GroupHead[] groupNodes;
    private transient boolean hasSupplementary;
    transient int localCount;
    transient Node matchRoot;
    volatile transient Map<String, Integer> namedGroups;
    private transient String normalizedPattern;
    private String pattern;
    private transient int patternLength;
    transient Node root;
    private transient int[] temp;

    static final class All extends CharProperty {
        All() {
            super(null);
        }

        /* access modifiers changed from: 0000 */
        public boolean isSatisfiedBy(int i) {
            int i2 = i;
            return true;
        }
    }

    static class BackRef extends Node {
        int groupIndex;

        BackRef(int i) {
            int i2 = i;
            this.groupIndex = i2 + i2;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int i3 = matcher2.groups[this.groupIndex];
            int i4 = matcher2.groups[1 + this.groupIndex] - i3;
            if (i3 >= 0) {
                if (i2 + i4 > matcher2.f23to) {
                    matcher2.hitEnd = true;
                    return false;
                }
                int i5 = 0;
                while (i5 < i4) {
                    if (charSequence2.charAt(i2 + i5) == charSequence2.charAt(i3 + i5)) {
                        i5++;
                    }
                }
                return this.next.match(matcher2, i2 + i4, charSequence2);
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            treeInfo2.maxValid = false;
            return this.next.study(treeInfo2);
        }
    }

    static final class Begin extends Node {
        Begin() {
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            if (i2 != (matcher2.anchoringBounds ? matcher2.from : 0) || !this.next.match(matcher2, i2, charSequence2)) {
                return false;
            }
            matcher2.first = i2;
            matcher2.groups[0] = i2;
            matcher2.groups[1] = matcher2.last;
            return true;
        }
    }

    static class Behind extends Node {
        Node cond;
        int rmax;
        int rmin;

        Behind(Node node, int i, int i2) {
            int i3 = i;
            int i4 = i2;
            this.cond = node;
            this.rmax = i3;
            this.rmin = i4;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int i3 = matcher2.from;
            int max = Math.max(i2 - this.rmax, !matcher2.transparentBounds ? matcher2.from : 0);
            int i4 = matcher2.lookbehindTo;
            matcher2.lookbehindTo = i2;
            if (matcher2.transparentBounds) {
                matcher2.from = 0;
            }
            int i5 = i2 - this.rmin;
            boolean z = false;
            while (!z && i5 >= max) {
                z = this.cond.match(matcher2, i5, charSequence2);
                i5--;
            }
            matcher2.from = i3;
            matcher2.lookbehindTo = i4;
            boolean z2 = false;
            if (z) {
                z2 = false;
                if (this.next.match(matcher2, i2, charSequence2)) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    static final class BehindS extends Behind {
        BehindS(Node node, int i, int i2) {
            super(node, i, i2);
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            boolean z;
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int access$300 = Pattern.countChars(charSequence2, i2, -this.rmax);
            int access$3002 = Pattern.countChars(charSequence2, i2, -this.rmin);
            int i3 = matcher2.from;
            int max = Math.max(i2 - access$300, !matcher2.transparentBounds ? matcher2.from : 0);
            int i4 = matcher2.lookbehindTo;
            matcher2.lookbehindTo = i2;
            if (matcher2.transparentBounds) {
                matcher2.from = 0;
            }
            int i5 = i2 - access$3002;
            boolean z2 = false;
            while (true) {
                z = z2;
                if (z || i5 < max) {
                    matcher2.from = i3;
                    matcher2.lookbehindTo = i4;
                } else {
                    boolean match = this.cond.match(matcher2, i5, charSequence2);
                    i5 -= i5 > max ? Pattern.countChars(charSequence2, i5, -1) : 1;
                    z2 = match;
                }
            }
            matcher2.from = i3;
            matcher2.lookbehindTo = i4;
            return z && this.next.match(matcher2, i2, charSequence2);
        }
    }

    private static final class BitClass extends BmpCharProperty {
        static final /* synthetic */ boolean $assertionsDisabled = (!Pattern.class.desiredAssertionStatus());
        final boolean[] bits;

        BitClass() {
            super(null);
            this.bits = new boolean[256];
        }

        private BitClass(boolean[] zArr) {
            boolean[] zArr2 = zArr;
            super(null);
            this.bits = zArr2;
        }

        /* access modifiers changed from: 0000 */
        public BitClass add(int i, int i2) {
            AssertionError assertionError;
            int i3 = i;
            int i4 = i2;
            if ($assertionsDisabled || (i3 >= 0 && i3 <= 255)) {
                if ((i4 & 2) != 0) {
                    if (ASCII.isAscii(i3)) {
                        this.bits[ASCII.toUpper(i3)] = true;
                        this.bits[ASCII.toLower(i3)] = true;
                    } else if ((i4 & 64) != 0) {
                        this.bits[Character.toLowerCase(i3)] = true;
                        this.bits[Character.toUpperCase(i3)] = true;
                    }
                }
                this.bits[i3] = true;
                return this;
            }
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError();
            throw assertionError2;
        }

        /* access modifiers changed from: 0000 */
        public boolean isSatisfiedBy(int i) {
            int i2 = i;
            return i2 < 256 && this.bits[i2];
        }
    }

    static final class Block extends CharProperty {
        final UnicodeBlock block;

        Block(UnicodeBlock unicodeBlock) {
            UnicodeBlock unicodeBlock2 = unicodeBlock;
            super(null);
            this.block = unicodeBlock2;
        }

        /* access modifiers changed from: 0000 */
        public boolean isSatisfiedBy(int i) {
            return this.block == UnicodeBlock.of(i);
        }
    }

    private static abstract class BmpCharProperty extends CharProperty {
        private BmpCharProperty() {
            super(null);
        }

        /* synthetic */ BmpCharProperty(C05561 r4) {
            C05561 r1 = r4;
            this();
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            if (i2 < matcher2.f23to) {
                return isSatisfiedBy(charSequence2.charAt(i2)) && this.next.match(matcher2, i2 + 1, charSequence2);
            }
            matcher2.hitEnd = true;
            return false;
        }
    }

    static class BnM extends Node {
        int[] buffer;
        int[] lastOcc;
        int[] optoSft;

        BnM(int[] iArr, int[] iArr2, int[] iArr3, Node node) {
            int[] iArr4 = iArr2;
            int[] iArr5 = iArr3;
            Node node2 = node;
            this.buffer = iArr;
            this.lastOcc = iArr4;
            this.optoSft = iArr5;
            this.next = node2;
        }

        static Node optimize(Node node) {
            BnM bnM;
            BnMS bnMS;
            Node node2 = node;
            if (node2 instanceof Slice) {
                int[] iArr = ((Slice) node2).buffer;
                int length = iArr.length;
                if (length >= 4) {
                    int[] iArr2 = new int[128];
                    int[] iArr3 = new int[length];
                    for (int i = 0; i < length; i++) {
                        iArr2[127 & iArr[i]] = i + 1;
                    }
                    for (int i2 = length; i2 > 0; i2--) {
                        int i3 = length - 1;
                        while (true) {
                            if (i3 >= i2) {
                                if (iArr[i3] != iArr[i3 - i2]) {
                                    break;
                                }
                                iArr3[i3 - 1] = i2;
                                i3--;
                            } else {
                                while (i3 > 0) {
                                    i3--;
                                    iArr3[i3] = i2;
                                }
                            }
                        }
                    }
                    iArr3[length - 1] = 1;
                    if (node2 instanceof SliceS) {
                        BnMS bnMS2 = bnMS;
                        BnMS bnMS3 = new BnMS(iArr, iArr2, iArr3, node2.next);
                        return bnMS2;
                    }
                    BnM bnM2 = bnM;
                    BnM bnM3 = new BnM(iArr, iArr2, iArr3, node2.next);
                    return bnM2;
                }
            }
            return node2;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int[] iArr = this.buffer;
            int length = iArr.length;
            int i3 = matcher2.f23to - length;
            while (i2 <= i3) {
                int i4 = length - 1;
                while (true) {
                    if (i4 >= 0) {
                        int charAt = charSequence2.charAt(i2 + i4);
                        if (charAt != iArr[i4]) {
                            i2 += Math.max((i4 + 1) - this.lastOcc[charAt & 127], this.optoSft[i4]);
                            break;
                        }
                        i4--;
                    } else {
                        matcher2.first = i2;
                        if (this.next.match(matcher2, i2 + length, charSequence2)) {
                            matcher2.first = i2;
                            matcher2.groups[0] = matcher2.first;
                            matcher2.groups[1] = matcher2.last;
                            return true;
                        }
                        i2++;
                    }
                }
            }
            matcher2.hitEnd = true;
            return false;
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            treeInfo2.minLength += this.buffer.length;
            treeInfo2.maxValid = false;
            return this.next.study(treeInfo2);
        }
    }

    static final class BnMS extends BnM {
        int lengthInChars;

        BnMS(int[] iArr, int[] iArr2, int[] iArr3, Node node) {
            super(iArr, iArr2, iArr3, node);
            for (int i = 0; i < this.buffer.length; i++) {
                this.lengthInChars += Character.charCount(this.buffer[i]);
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int[] iArr = this.buffer;
            int length = iArr.length;
            int i3 = matcher2.f23to - this.lengthInChars;
            while (i2 <= i3) {
                int access$300 = Pattern.countChars(charSequence2, i2, length);
                int i4 = length - 1;
                while (true) {
                    if (access$300 > 0) {
                        int codePointBefore = Character.codePointBefore(charSequence2, i2 + access$300);
                        if (codePointBefore != iArr[i4]) {
                            i2 += Pattern.countChars(charSequence2, i2, Math.max((i4 + 1) - this.lastOcc[codePointBefore & 127], this.optoSft[i4]));
                            break;
                        }
                        access$300 -= Character.charCount(codePointBefore);
                        i4--;
                    } else {
                        matcher2.first = i2;
                        if (this.next.match(matcher2, i2 + this.lengthInChars, charSequence2)) {
                            matcher2.first = i2;
                            matcher2.groups[0] = matcher2.first;
                            matcher2.groups[1] = matcher2.last;
                            return true;
                        }
                        i2 += Pattern.countChars(charSequence2, i2, 1);
                    }
                }
            }
            matcher2.hitEnd = true;
            return false;
        }
    }

    static final class Bound extends Node {
        static int BOTH = 3;
        static int LEFT = 1;
        static int NONE = 4;
        static int RIGHT = 2;
        int type;
        boolean useUWORD;

        Bound(int i, boolean z) {
            boolean z2 = z;
            this.type = i;
            this.useUWORD = z2;
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0073, code lost:
            if (jdkregex.Pattern.access$400(r1, r2, r3) != false) goto L_0x0075;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int check(jdkregex.Matcher r18, int r19, java.lang.CharSequence r20) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                r2 = r19
                r3 = r20
                r14 = r1
                int r14 = r14.from
                r4 = r14
                r14 = r1
                int r14 = r14.f23to
                r5 = r14
                r14 = r1
                boolean r14 = r14.transparentBounds
                if (r14 == 0) goto L_0x009c
                r14 = r1
                int r14 = r14.getTextLength()
                r7 = r14
                r14 = 0
                r6 = r14
            L_0x001d:
                r14 = r2
                r15 = r6
                if (r14 <= r15) goto L_0x0099
                r14 = r3
                r15 = r2
                int r14 = java.lang.Character.codePointBefore(r14, r15)
                r13 = r14
                r14 = r0
                r15 = r13
                boolean r14 = r14.isWord(r15)
                if (r14 != 0) goto L_0x0046
                r14 = r13
                int r14 = java.lang.Character.getType(r14)
                r15 = 6
                if (r14 != r15) goto L_0x0083
                r14 = r1
                r15 = r2
                r16 = 1
                int r15 = r15 + -1
                r16 = r3
                boolean r14 = jdkregex.Pattern.hasBaseCharacter(r14, r15, r16)
                if (r14 == 0) goto L_0x0083
            L_0x0046:
                r14 = 1
                r8 = r14
            L_0x0048:
                r14 = r2
                r15 = r7
                if (r14 >= r15) goto L_0x0086
                r14 = r3
                r15 = r2
                int r14 = java.lang.Character.codePointAt(r14, r15)
                r10 = r14
                r14 = r0
                r15 = r10
                boolean r14 = r14.isWord(r15)
                if (r14 != 0) goto L_0x0075
                r14 = r10
                int r14 = java.lang.Character.getType(r14)
                r11 = r14
                r14 = 0
                r9 = r14
                r14 = r11
                r15 = 6
                if (r14 != r15) goto L_0x0077
                r14 = r1
                r15 = r2
                r16 = r3
                boolean r14 = jdkregex.Pattern.hasBaseCharacter(r14, r15, r16)
                r12 = r14
                r14 = 0
                r9 = r14
                r14 = r12
                if (r14 == 0) goto L_0x0077
            L_0x0075:
                r14 = 1
                r9 = r14
            L_0x0077:
                r14 = r8
                r15 = r9
                r14 = r14 ^ r15
                if (r14 == 0) goto L_0x0095
                r14 = r9
                if (r14 == 0) goto L_0x0091
                int r14 = LEFT
                r0 = r14
            L_0x0082:
                return r0
            L_0x0083:
                r14 = 0
                r8 = r14
                goto L_0x0048
            L_0x0086:
                r14 = r1
                r15 = 1
                r14.hitEnd = r15
                r14 = r1
                r15 = 1
                r14.requireEnd = r15
                r14 = 0
                r9 = r14
                goto L_0x0077
            L_0x0091:
                int r14 = RIGHT
                r0 = r14
                goto L_0x0082
            L_0x0095:
                int r14 = NONE
                r0 = r14
                goto L_0x0082
            L_0x0099:
                r14 = 0
                r8 = r14
                goto L_0x0048
            L_0x009c:
                r14 = r4
                r6 = r14
                r14 = r5
                r7 = r14
                goto L_0x001d
            */
            throw new UnsupportedOperationException("Method not decompiled: jdkregex.Pattern.Bound.check(jdkregex.Matcher, int, java.lang.CharSequence):int");
        }

        /* access modifiers changed from: 0000 */
        public boolean isWord(int i) {
            int i2 = i;
            return this.useUWORD ? UnicodeProp.WORD.mo7641is(i2) : i2 == 95 || Character.isLetterOrDigit(i2);
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            return (check(matcher2, i2, charSequence2) & this.type) > 0 && this.next.match(matcher2, i2, charSequence2);
        }
    }

    static final class Branch extends Node {
        Node[] atoms = new Node[2];
        Node conn;
        int size = 2;

        Branch(Node node, Node node2, Node node3) {
            Node node4 = node;
            Node node5 = node2;
            Node node6 = node3;
            this.conn = node6;
            this.atoms[0] = node4;
            this.atoms[1] = node5;
        }

        /* access modifiers changed from: 0000 */
        public void add(Node node) {
            Node node2 = node;
            if (this.size >= this.atoms.length) {
                Node[] nodeArr = new Node[(2 * this.atoms.length)];
                System.arraycopy(this.atoms, 0, nodeArr, 0, this.atoms.length);
                this.atoms = nodeArr;
            }
            Node[] nodeArr2 = this.atoms;
            int i = this.size;
            this.size = i + 1;
            nodeArr2[i] = node2;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            boolean z;
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int i3 = 0;
            while (true) {
                z = false;
                if (i3 >= this.size) {
                    break;
                }
                if (this.atoms[i3] == null) {
                    if (this.conn.next.match(matcher2, i2, charSequence2)) {
                        z = true;
                        break;
                    }
                } else if (this.atoms[i3].match(matcher2, i2, charSequence2)) {
                    return true;
                }
                i3++;
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            int i = treeInfo2.minLength;
            int i2 = treeInfo2.maxLength;
            boolean z = treeInfo2.maxValid;
            int i3 = Integer.MAX_VALUE;
            int i4 = -1;
            for (int i5 = 0; i5 < this.size; i5++) {
                treeInfo2.reset();
                if (this.atoms[i5] != null) {
                    boolean study = this.atoms[i5].study(treeInfo2);
                }
                i3 = Math.min(i3, treeInfo2.minLength);
                i4 = Math.max(i4, treeInfo2.maxLength);
                z &= treeInfo2.maxValid;
            }
            int i6 = i + i3;
            int i7 = i4 + i2;
            treeInfo2.reset();
            boolean study2 = this.conn.next.study(treeInfo2);
            treeInfo2.minLength = i6 + treeInfo2.minLength;
            treeInfo2.maxLength = i7 + treeInfo2.maxLength;
            treeInfo2.maxValid = z & treeInfo2.maxValid;
            treeInfo2.deterministic = false;
            return false;
        }
    }

    static final class BranchConn extends Node {
        BranchConn() {
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            return this.next.match(matcher, i, charSequence);
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            return treeInfo.deterministic;
        }
    }

    static class CIBackRef extends Node {
        boolean doUnicodeCase;
        int groupIndex;

        CIBackRef(int i, boolean z) {
            int i2 = i;
            boolean z2 = z;
            this.groupIndex = i2 + i2;
            this.doUnicodeCase = z2;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int i3 = matcher2.groups[this.groupIndex];
            int i4 = matcher2.groups[1 + this.groupIndex] - i3;
            if (i3 >= 0) {
                if (i2 + i4 > matcher2.f23to) {
                    matcher2.hitEnd = true;
                    return false;
                }
                int i5 = i2;
                int i6 = i3;
                for (int i7 = 0; i7 < i4; i7++) {
                    int codePointAt = Character.codePointAt(charSequence2, i5);
                    int codePointAt2 = Character.codePointAt(charSequence2, i6);
                    if (codePointAt != codePointAt2) {
                        if (this.doUnicodeCase) {
                            int upperCase = Character.toUpperCase(codePointAt);
                            int upperCase2 = Character.toUpperCase(codePointAt2);
                            if (!(upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2))) {
                            }
                        } else if (ASCII.toLower(codePointAt) != ASCII.toLower(codePointAt2)) {
                            return false;
                        }
                    }
                    i5 += Character.charCount(codePointAt);
                    i6 += Character.charCount(codePointAt2);
                }
                return this.next.match(matcher2, i2 + i4, charSequence2);
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            treeInfo2.maxValid = false;
            return this.next.study(treeInfo2);
        }
    }

    static final class Caret extends Node {
        Caret() {
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
            if (r6 != 133) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
            if (r3.charAt(r2) == 10) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean match(jdkregex.Matcher r12, int r13, java.lang.CharSequence r14) {
            /*
                r11 = this;
                r0 = r11
                r1 = r12
                r2 = r13
                r3 = r14
                r7 = r1
                int r7 = r7.from
                r4 = r7
                r7 = r1
                int r7 = r7.f23to
                r5 = r7
                r7 = r1
                boolean r7 = r7.anchoringBounds
                if (r7 != 0) goto L_0x0019
                r7 = r1
                int r7 = r7.getTextLength()
                r5 = r7
                r7 = 0
                r4 = r7
            L_0x0019:
                r7 = r2
                r8 = r5
                if (r7 != r8) goto L_0x0024
                r7 = r1
                r8 = 1
                r7.hitEnd = r8
            L_0x0021:
                r7 = 0
                r0 = r7
            L_0x0023:
                return r0
            L_0x0024:
                r7 = r2
                r8 = r4
                if (r7 <= r8) goto L_0x0058
                r7 = r3
                r8 = r2
                r9 = 1
                int r8 = r8 + -1
                char r7 = r7.charAt(r8)
                r6 = r7
                r7 = r6
                r8 = 10
                if (r7 == r8) goto L_0x0049
                r7 = r6
                r8 = 13
                if (r7 == r8) goto L_0x0049
                r7 = r6
                r8 = 1
                r7 = r7 | 1
                r8 = 8233(0x2029, float:1.1537E-41)
                if (r7 == r8) goto L_0x0049
                r7 = r6
                r8 = 133(0x85, float:1.86E-43)
                if (r7 != r8) goto L_0x0021
            L_0x0049:
                r7 = r6
                r8 = 13
                if (r7 != r8) goto L_0x0058
                r7 = r3
                r8 = r2
                char r7 = r7.charAt(r8)
                r8 = 10
                if (r7 == r8) goto L_0x0021
            L_0x0058:
                r7 = r0
                jdkregex.Pattern$Node r7 = r7.next
                r8 = r1
                r9 = r2
                r10 = r3
                boolean r7 = r7.match(r8, r9, r10)
                r0 = r7
                goto L_0x0023
            */
            throw new UnsupportedOperationException("Method not decompiled: jdkregex.Pattern.Caret.match(jdkregex.Matcher, int, java.lang.CharSequence):boolean");
        }
    }

    static final class Category extends CharProperty {
        final int typeMask;

        Category(int i) {
            int i2 = i;
            super(null);
            this.typeMask = i2;
        }

        /* access modifiers changed from: 0000 */
        public boolean isSatisfiedBy(int i) {
            return (this.typeMask & (1 << Character.getType(i))) != 0;
        }
    }

    private static abstract class CharProperty extends Node {
        private CharProperty() {
        }

        /* synthetic */ CharProperty(C05561 r4) {
            C05561 r1 = r4;
            this();
        }

        /* access modifiers changed from: 0000 */
        public CharProperty complement() {
            C05631 r4;
            C05631 r1 = r4;
            C05631 r2 = new CharProperty(this) {
                final /* synthetic */ CharProperty this$0;

                {
                    this.this$0 = r5;
                }

                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return !this.this$0.isSatisfiedBy(i);
                }
            };
            return r1;
        }

        /* access modifiers changed from: 0000 */
        public abstract boolean isSatisfiedBy(int i);

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            if (i2 < matcher2.f23to) {
                int codePointAt = Character.codePointAt(charSequence2, i2);
                return isSatisfiedBy(codePointAt) && this.next.match(matcher2, i2 + Character.charCount(codePointAt), charSequence2);
            }
            matcher2.hitEnd = true;
            return false;
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            treeInfo2.minLength = 1 + treeInfo2.minLength;
            treeInfo2.maxLength = 1 + treeInfo2.maxLength;
            return this.next.study(treeInfo2);
        }
    }

    private static class CharPropertyNames {
        private static final HashMap<String, CharPropertyFactory> map;

        private static abstract class CharPropertyFactory {
            private CharPropertyFactory() {
            }

            /* synthetic */ CharPropertyFactory(C05561 r4) {
                C05561 r1 = r4;
                this();
            }

            /* access modifiers changed from: 0000 */
            public abstract CharProperty make();
        }

        private static abstract class CloneableProperty extends CharProperty implements Cloneable {
            private CloneableProperty() {
                super(null);
            }

            /* synthetic */ CloneableProperty(C05561 r4) {
                C05561 r1 = r4;
                this();
            }

            public CloneableProperty clone() {
                AssertionError assertionError;
                try {
                    return (CloneableProperty) super.clone();
                } catch (CloneNotSupportedException e) {
                    CloneNotSupportedException cloneNotSupportedException = e;
                    AssertionError assertionError2 = assertionError;
                    AssertionError assertionError3 = new AssertionError(cloneNotSupportedException);
                    throw assertionError2;
                }
            }
        }

        static {
            HashMap<String, CharPropertyFactory> hashMap;
            C05825 r4;
            C05836 r42;
            C05847 r43;
            C05858 r44;
            C05869 r45;
            C056510 r46;
            C056611 r47;
            C056712 r48;
            C056813 r49;
            C056914 r410;
            C057015 r411;
            C057116 r412;
            C057217 r413;
            C057318 r414;
            C057419 r415;
            C057620 r416;
            C057721 r417;
            C057822 r418;
            C057923 r419;
            HashMap<String, CharPropertyFactory> hashMap2 = hashMap;
            HashMap<String, CharPropertyFactory> hashMap3 = new HashMap<>();
            map = hashMap2;
            defCategory("Cn", 1);
            defCategory("Lu", 2);
            defCategory("Ll", 4);
            defCategory("Lt", 8);
            defCategory("Lm", 16);
            defCategory("Lo", 32);
            defCategory("Mn", 64);
            defCategory("Me", 128);
            defCategory("Mc", 256);
            defCategory("Nd", 512);
            defCategory("Nl", 1024);
            defCategory("No", 2048);
            defCategory("Zs", 4096);
            defCategory("Zl", 8192);
            defCategory("Zp", 16384);
            defCategory("Cc", 32768);
            defCategory("Cf", 65536);
            defCategory("Co", 262144);
            defCategory("Cs", 524288);
            defCategory("Pd", 1048576);
            defCategory("Ps", 2097152);
            defCategory("Pe", NVPathRendering.GL_FONT_DESCENDER_NV);
            defCategory("Pc", 8388608);
            defCategory("Po", 16777216);
            defCategory("Sm", 33554432);
            defCategory("Sc", 67108864);
            defCategory("Sk", 134217728);
            defCategory("So", 268435456);
            defCategory("Pi", 536870912);
            defCategory("Pf", IDirectInputDevice.DIEP_NORESTART);
            defCategory("L", 62);
            defCategory("M", NativeDefinitions.KEY_DEL_EOL);
            defCategory("N", 3584);
            defCategory("Z", 28672);
            defCategory("C", 884736);
            defCategory("P", 1643118592);
            defCategory("S", 503316480);
            defCategory("LC", 14);
            defCategory("LD", 574);
            defRange("L1", 0, 255);
            C05825 r2 = r4;
            C05825 r3 = new CharPropertyFactory() {
                /* access modifiers changed from: 0000 */
                public CharProperty make() {
                    All all;
                    All all2 = all;
                    All all3 = new All();
                    return all2;
                }
            };
            Object put = map.put("all", r2);
            defRange("ASCII", 0, 127);
            defCtype("Alnum", GL11.GL_PASS_THROUGH_TOKEN);
            defCtype("Alpha", 768);
            defCtype("Blank", 16384);
            defCtype("Cntrl", 8192);
            defRange("Digit", 48, 57);
            defCtype("Graph", 5888);
            defRange("Lower", 97, 122);
            defRange("Print", 32, 126);
            defCtype("Punct", 4096);
            defCtype("Space", 2048);
            defRange("Upper", 65, 90);
            defCtype("XDigit", 32768);
            C05836 r1 = r42;
            C05836 r22 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isLowerCase(i);
                }
            };
            defClone("javaLowerCase", r1);
            C05847 r12 = r43;
            C05847 r23 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isUpperCase(i);
                }
            };
            defClone("javaUpperCase", r12);
            C05858 r13 = r44;
            C05858 r24 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isAlphabetic(i);
                }
            };
            defClone("javaAlphabetic", r13);
            C05869 r14 = r45;
            C05869 r25 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isIdeographic(i);
                }
            };
            defClone("javaIdeographic", r14);
            C056510 r15 = r46;
            C056510 r26 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isTitleCase(i);
                }
            };
            defClone("javaTitleCase", r15);
            C056611 r16 = r47;
            C056611 r27 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isDigit(i);
                }
            };
            defClone("javaDigit", r16);
            C056712 r17 = r48;
            C056712 r28 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isDefined(i);
                }
            };
            defClone("javaDefined", r17);
            C056813 r18 = r49;
            C056813 r29 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isLetter(i);
                }
            };
            defClone("javaLetter", r18);
            C056914 r19 = r410;
            C056914 r210 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isLetterOrDigit(i);
                }
            };
            defClone("javaLetterOrDigit", r19);
            C057015 r110 = r411;
            C057015 r211 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isJavaIdentifierStart(i);
                }
            };
            defClone("javaJavaIdentifierStart", r110);
            C057116 r111 = r412;
            C057116 r212 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isJavaIdentifierPart(i);
                }
            };
            defClone("javaJavaIdentifierPart", r111);
            C057217 r112 = r413;
            C057217 r213 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isUnicodeIdentifierStart(i);
                }
            };
            defClone("javaUnicodeIdentifierStart", r112);
            C057318 r113 = r414;
            C057318 r214 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isUnicodeIdentifierPart(i);
                }
            };
            defClone("javaUnicodeIdentifierPart", r113);
            C057419 r114 = r415;
            C057419 r215 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isIdentifierIgnorable(i);
                }
            };
            defClone("javaIdentifierIgnorable", r114);
            C057620 r115 = r416;
            C057620 r216 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isSpaceChar(i);
                }
            };
            defClone("javaSpaceChar", r115);
            C057721 r116 = r417;
            C057721 r217 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isWhitespace(i);
                }
            };
            defClone("javaWhitespace", r116);
            C057822 r117 = r418;
            C057822 r218 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isISOControl(i);
                }
            };
            defClone("javaISOControl", r117);
            C057923 r118 = r419;
            C057923 r219 = new CloneableProperty() {
                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    return Character.isMirrored(i);
                }
            };
            defClone("javaMirrored", r118);
        }

        private CharPropertyNames() {
        }

        static CharProperty charPropertyFor(String str) {
            CharPropertyFactory charPropertyFactory = (CharPropertyFactory) map.get(str);
            if (charPropertyFactory == null) {
                return null;
            }
            return charPropertyFactory.make();
        }

        private static void defCategory(String str, int i) {
            C05641 r7;
            String str2 = str;
            int i2 = i;
            HashMap<String, CharPropertyFactory> hashMap = map;
            String str3 = str2;
            C05641 r4 = r7;
            final int i3 = i2;
            C05641 r5 = new CharPropertyFactory() {
                /* access modifiers changed from: 0000 */
                public CharProperty make() {
                    Category category;
                    Category category2 = category;
                    Category category3 = new Category(i3);
                    return category2;
                }
            };
            Object put = hashMap.put(str3, r4);
        }

        private static void defClone(String str, CloneableProperty cloneableProperty) {
            C05814 r7;
            String str2 = str;
            CloneableProperty cloneableProperty2 = cloneableProperty;
            HashMap<String, CharPropertyFactory> hashMap = map;
            String str3 = str2;
            C05814 r4 = r7;
            final CloneableProperty cloneableProperty3 = cloneableProperty2;
            C05814 r5 = new CharPropertyFactory() {
                /* access modifiers changed from: 0000 */
                public CharProperty make() {
                    return cloneableProperty3.clone();
                }
            };
            Object put = hashMap.put(str3, r4);
        }

        private static void defCtype(String str, int i) {
            C05803 r7;
            String str2 = str;
            int i2 = i;
            HashMap<String, CharPropertyFactory> hashMap = map;
            String str3 = str2;
            C05803 r4 = r7;
            final int i3 = i2;
            C05803 r5 = new CharPropertyFactory() {
                /* access modifiers changed from: 0000 */
                public CharProperty make() {
                    Ctype ctype;
                    Ctype ctype2 = ctype;
                    Ctype ctype3 = new Ctype(i3);
                    return ctype2;
                }
            };
            Object put = hashMap.put(str3, r4);
        }

        private static void defRange(String str, int i, int i2) {
            C05752 r9;
            String str2 = str;
            int i3 = i;
            int i4 = i2;
            HashMap<String, CharPropertyFactory> hashMap = map;
            String str3 = str2;
            C05752 r5 = r9;
            final int i5 = i3;
            final int i6 = i4;
            C05752 r6 = new CharPropertyFactory() {
                {
                    int i = r7;
                }

                /* access modifiers changed from: 0000 */
                public CharProperty make() {
                    return Pattern.rangeFor(i5, i6);
                }
            };
            Object put = hashMap.put(str3, r5);
        }
    }

    static final class Conditional extends Node {
        Node cond;
        Node not;
        Node yes;

        Conditional(Node node, Node node2, Node node3) {
            Node node4 = node2;
            Node node5 = node3;
            this.cond = node;
            this.yes = node4;
            this.not = node5;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            return this.cond.match(matcher2, i2, charSequence2) ? this.yes.match(matcher2, i2, charSequence2) : this.not.match(matcher2, i2, charSequence2);
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            int i = treeInfo2.minLength;
            int i2 = treeInfo2.maxLength;
            boolean z = treeInfo2.maxValid;
            treeInfo2.reset();
            boolean study = this.yes.study(treeInfo2);
            int i3 = treeInfo2.minLength;
            int i4 = treeInfo2.maxLength;
            boolean z2 = treeInfo2.maxValid;
            treeInfo2.reset();
            boolean study2 = this.not.study(treeInfo2);
            treeInfo2.minLength = i + Math.min(i3, treeInfo2.minLength);
            treeInfo2.maxLength = i2 + Math.max(i4, treeInfo2.maxLength);
            treeInfo2.maxValid = z & z2 & treeInfo2.maxValid;
            treeInfo2.deterministic = false;
            return this.next.study(treeInfo2);
        }
    }

    static final class Ctype extends BmpCharProperty {
        final int ctype;

        Ctype(int i) {
            int i2 = i;
            super(null);
            this.ctype = i2;
        }

        /* access modifiers changed from: 0000 */
        public boolean isSatisfiedBy(int i) {
            int i2 = i;
            return i2 < 128 && ASCII.isType(i2, this.ctype);
        }
    }

    static final class Curly extends Node {
        Node atom;
        int cmax;
        int cmin;
        int type;

        Curly(Node node, int i, int i2, int i3) {
            int i4 = i;
            int i5 = i2;
            int i6 = i3;
            this.atom = node;
            this.type = i6;
            this.cmin = i4;
            this.cmax = i5;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            boolean match0;
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int i3 = 0;
            while (true) {
                if (i3 < this.cmin) {
                    match0 = false;
                    if (!this.atom.match(matcher2, i2, charSequence2)) {
                        break;
                    }
                    i2 = matcher2.last;
                    i3++;
                } else if (this.type != 0) {
                    return this.type == 1 ? match1(matcher2, i2, i3, charSequence2) : match2(matcher2, i2, i3, charSequence2);
                } else {
                    match0 = match0(matcher2, i2, i3, charSequence2);
                }
            }
            return match0;
        }

        /* access modifiers changed from: 0000 */
        public boolean match0(Matcher matcher, int i, int i2, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i3 = i;
            int i4 = i2;
            CharSequence charSequence2 = charSequence;
            if (i4 >= this.cmax) {
                return this.next.match(matcher2, i3, charSequence2);
            }
            if (this.atom.match(matcher2, i3, charSequence2)) {
                int i5 = matcher2.last - i3;
                if (i5 != 0) {
                    int i6 = matcher2.last;
                    int i7 = i4 + 1;
                    while (true) {
                        if (i7 >= this.cmax || !this.atom.match(matcher2, i6, charSequence2)) {
                            break;
                        } else if (i6 + i5 == matcher2.last) {
                            i6 += i5;
                            i7++;
                        } else if (match0(matcher2, matcher2.last, i7 + 1, charSequence2)) {
                            return true;
                        }
                    }
                    while (i7 >= i4) {
                        if (this.next.match(matcher2, i6, charSequence2)) {
                            return true;
                        }
                        i6 -= i5;
                        i7--;
                    }
                    return false;
                }
            }
            return this.next.match(matcher2, i3, charSequence2);
        }

        /* access modifiers changed from: 0000 */
        public boolean match1(Matcher matcher, int i, int i2, CharSequence charSequence) {
            boolean z;
            Matcher matcher2 = matcher;
            int i3 = i;
            int i4 = i2;
            CharSequence charSequence2 = charSequence;
            while (true) {
                if (!this.next.match(matcher2, i3, charSequence2)) {
                    z = false;
                    if (i4 >= this.cmax) {
                        break;
                    }
                    z = false;
                    if (!this.atom.match(matcher2, i3, charSequence2)) {
                        break;
                    }
                    z = false;
                    if (i3 == matcher2.last) {
                        break;
                    }
                    i3 = matcher2.last;
                    i4++;
                } else {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        public boolean match2(Matcher matcher, int i, int i2, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i3 = i;
            CharSequence charSequence2 = charSequence;
            for (int i4 = i2; i4 < this.cmax && this.atom.match(matcher2, i3, charSequence2) && i3 != matcher2.last; i4++) {
                i3 = matcher2.last;
            }
            return this.next.match(matcher2, i3, charSequence2);
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            int i = treeInfo2.minLength;
            int i2 = treeInfo2.maxLength;
            boolean z = treeInfo2.maxValid;
            boolean z2 = treeInfo2.deterministic;
            treeInfo2.reset();
            boolean study = this.atom.study(treeInfo2);
            int i3 = i + (treeInfo2.minLength * this.cmin);
            if (i3 < i) {
                i3 = 268435455;
            }
            treeInfo2.minLength = i3;
            if (z && treeInfo2.maxValid) {
                int i4 = i2 + (treeInfo2.maxLength * this.cmax);
                treeInfo2.maxLength = i4;
                if (i4 < i2) {
                    treeInfo2.maxValid = false;
                }
            } else {
                treeInfo2.maxValid = false;
            }
            if (!treeInfo2.deterministic || this.cmin != this.cmax) {
                treeInfo2.deterministic = false;
            } else {
                treeInfo2.deterministic = z2;
            }
            return this.next.study(treeInfo2);
        }
    }

    static final class Dollar extends Node {
        boolean multiline;

        Dollar(boolean z) {
            this.multiline = z;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int textLength = matcher2.anchoringBounds ? matcher2.f23to : matcher2.getTextLength();
            if (!this.multiline) {
                if (i2 < textLength - 2) {
                    return false;
                }
                if (i2 == textLength - 2) {
                    if (charSequence2.charAt(i2) != 13) {
                        return false;
                    }
                    if (charSequence2.charAt(i2 + 1) != 10) {
                        return false;
                    }
                }
            }
            if (i2 < textLength) {
                char charAt = charSequence2.charAt(i2);
                if (charAt == 10) {
                    if (i2 > 0 && charSequence2.charAt(i2 - 1) == 13) {
                        return false;
                    }
                    if (this.multiline) {
                        return this.next.match(matcher2, i2, charSequence2);
                    }
                } else if (charAt != 13 && charAt != 133 && (charAt | 1) != 8233) {
                    return false;
                } else {
                    if (this.multiline) {
                        return this.next.match(matcher2, i2, charSequence2);
                    }
                }
            }
            matcher2.hitEnd = true;
            matcher2.requireEnd = true;
            return this.next.match(matcher2, i2, charSequence2);
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            boolean study = this.next.study(treeInfo2);
            return treeInfo2.deterministic;
        }
    }

    static final class Dot extends CharProperty {
        Dot() {
            super(null);
        }

        /* access modifiers changed from: 0000 */
        public boolean isSatisfiedBy(int i) {
            int i2 = i;
            return (i2 == 10 || i2 == 13 || (i2 | 1) == 8233 || i2 == 133) ? false : true;
        }
    }

    static final class End extends Node {
        End() {
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            if (i2 != (matcher2.anchoringBounds ? matcher2.f23to : matcher2.getTextLength())) {
                return false;
            }
            matcher2.hitEnd = true;
            return this.next.match(matcher2, i2, charSequence2);
        }
    }

    static final class First extends Node {
        Node atom;

        First(Node node) {
            this.atom = BnM.optimize(node);
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            if (this.atom instanceof BnM) {
                return this.atom.match(matcher2, i2, charSequence2) && this.next.match(matcher2, matcher2.last, charSequence2);
            }
            while (i2 <= matcher2.f23to) {
                if (this.atom.match(matcher2, i2, charSequence2)) {
                    return this.next.match(matcher2, matcher2.last, charSequence2);
                }
                i2 += Pattern.countChars(charSequence2, i2, 1);
                matcher2.first = 1 + matcher2.first;
            }
            matcher2.hitEnd = true;
            return false;
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            boolean study = this.atom.study(treeInfo2);
            treeInfo2.maxValid = false;
            treeInfo2.deterministic = false;
            return this.next.study(treeInfo2);
        }
    }

    static final class GroupCurly extends Node {
        Node atom;
        boolean capture;
        int cmax;
        int cmin;
        int groupIndex;
        int localIndex;
        int type;

        GroupCurly(Node node, int i, int i2, int i3, int i4, int i5, boolean z) {
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            int i10 = i5;
            boolean z2 = z;
            this.atom = node;
            this.type = i8;
            this.cmin = i6;
            this.cmax = i7;
            this.localIndex = i9;
            this.groupIndex = i10;
            this.capture = z2;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            int i2;
            int i3;
            boolean z;
            Matcher matcher2 = matcher;
            int i4 = i;
            CharSequence charSequence2 = charSequence;
            int[] iArr = matcher2.groups;
            int[] iArr2 = matcher2.locals;
            int i5 = iArr2[this.localIndex];
            if (this.capture) {
                i3 = iArr[this.groupIndex];
                i2 = iArr[1 + this.groupIndex];
            } else {
                i2 = 0;
                i3 = 0;
            }
            iArr2[this.localIndex] = -1;
            int i6 = 0;
            while (true) {
                if (i6 >= this.cmin) {
                    z = true;
                    break;
                }
                z = false;
                if (!this.atom.match(matcher2, i4, charSequence2)) {
                    break;
                }
                if (this.capture) {
                    iArr[this.groupIndex] = i4;
                    iArr[1 + this.groupIndex] = matcher2.last;
                }
                i4 = matcher2.last;
                i6++;
            }
            if (z) {
                z = this.type == 0 ? match0(matcher2, i4, this.cmin, charSequence2) : this.type == 1 ? match1(matcher2, i4, this.cmin, charSequence2) : match2(matcher2, i4, this.cmin, charSequence2);
            }
            if (!z) {
                iArr2[this.localIndex] = i5;
                if (this.capture) {
                    iArr[this.groupIndex] = i3;
                    iArr[1 + this.groupIndex] = i2;
                }
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        public boolean match0(Matcher matcher, int i, int i2, CharSequence charSequence) {
            int i3;
            int i4;
            Matcher matcher2 = matcher;
            int i5 = i;
            int i6 = i2;
            CharSequence charSequence2 = charSequence;
            int[] iArr = matcher2.groups;
            if (this.capture) {
                i4 = iArr[this.groupIndex];
                i3 = iArr[1 + this.groupIndex];
            } else {
                i3 = 0;
                i4 = 0;
            }
            if (i6 < this.cmax && this.atom.match(matcher2, i5, charSequence2)) {
                int i7 = matcher2.last - i5;
                if (i7 <= 0) {
                    if (this.capture) {
                        iArr[this.groupIndex] = i5;
                        iArr[1 + this.groupIndex] = i5 + i7;
                    }
                    i5 += i7;
                } else {
                    while (true) {
                        if (this.capture) {
                            iArr[this.groupIndex] = i5;
                            iArr[1 + this.groupIndex] = i5 + i7;
                        }
                        i5 += i7;
                        i6++;
                        if (i6 >= this.cmax || !this.atom.match(matcher2, i5, charSequence2)) {
                            break;
                        } else if (i5 + i7 != matcher2.last) {
                            if (match0(matcher2, i5, i6, charSequence2)) {
                                return true;
                            }
                        }
                    }
                    while (i6 > this.cmin) {
                        if (this.next.match(matcher2, i5, charSequence2)) {
                            if (this.capture) {
                                iArr[1 + this.groupIndex] = i5;
                                iArr[this.groupIndex] = i5 - i7;
                            }
                            int i8 = i5 - i7;
                            return true;
                        }
                        if (this.capture) {
                            iArr[1 + this.groupIndex] = i5;
                            iArr[this.groupIndex] = i5 - i7;
                        }
                        i5 -= i7;
                        i6--;
                    }
                }
            }
            if (this.capture) {
                iArr[this.groupIndex] = i4;
                iArr[1 + this.groupIndex] = i3;
            }
            return this.next.match(matcher2, i5, charSequence2);
        }

        /* access modifiers changed from: 0000 */
        public boolean match1(Matcher matcher, int i, int i2, CharSequence charSequence) {
            boolean z;
            Matcher matcher2 = matcher;
            int i3 = i;
            int i4 = i2;
            CharSequence charSequence2 = charSequence;
            while (true) {
                if (!this.next.match(matcher2, i3, charSequence2)) {
                    z = false;
                    if (i4 >= this.cmax) {
                        break;
                    }
                    z = false;
                    if (!this.atom.match(matcher2, i3, charSequence2)) {
                        break;
                    }
                    z = false;
                    if (i3 == matcher2.last) {
                        break;
                    }
                    if (this.capture) {
                        matcher2.groups[this.groupIndex] = i3;
                        matcher2.groups[1 + this.groupIndex] = matcher2.last;
                    }
                    i3 = matcher2.last;
                    i4++;
                } else {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        public boolean match2(Matcher matcher, int i, int i2, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i3 = i;
            CharSequence charSequence2 = charSequence;
            for (int i4 = i2; i4 < this.cmax && this.atom.match(matcher2, i3, charSequence2); i4++) {
                if (this.capture) {
                    matcher2.groups[this.groupIndex] = i3;
                    matcher2.groups[1 + this.groupIndex] = matcher2.last;
                }
                if (i3 == matcher2.last) {
                    break;
                }
                i3 = matcher2.last;
            }
            return this.next.match(matcher2, i3, charSequence2);
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            int i = treeInfo2.minLength;
            int i2 = treeInfo2.maxLength;
            boolean z = treeInfo2.maxValid;
            boolean z2 = treeInfo2.deterministic;
            treeInfo2.reset();
            boolean study = this.atom.study(treeInfo2);
            int i3 = i + (treeInfo2.minLength * this.cmin);
            if (i3 < i) {
                i3 = 268435455;
            }
            treeInfo2.minLength = i3;
            if (z && treeInfo2.maxValid) {
                int i4 = i2 + (treeInfo2.maxLength * this.cmax);
                treeInfo2.maxLength = i4;
                if (i4 < i2) {
                    treeInfo2.maxValid = false;
                }
            } else {
                treeInfo2.maxValid = false;
            }
            if (!treeInfo2.deterministic || this.cmin != this.cmax) {
                treeInfo2.deterministic = false;
            } else {
                treeInfo2.deterministic = z2;
            }
            return this.next.study(treeInfo2);
        }
    }

    static final class GroupHead extends Node {
        int localIndex;

        GroupHead(int i) {
            this.localIndex = i;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int i3 = matcher2.locals[this.localIndex];
            matcher2.locals[this.localIndex] = i2;
            boolean match = this.next.match(matcher2, i2, charSequence2);
            matcher2.locals[this.localIndex] = i3;
            return match;
        }

        /* access modifiers changed from: 0000 */
        public boolean matchRef(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int i3 = matcher2.locals[this.localIndex];
            matcher2.locals[this.localIndex] = i2 ^ -1;
            boolean match = this.next.match(matcher2, i2, charSequence2);
            matcher2.locals[this.localIndex] = i3;
            return match;
        }
    }

    static final class GroupRef extends Node {
        GroupHead head;

        GroupRef(GroupHead groupHead) {
            this.head = groupHead;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            CharSequence charSequence2 = charSequence;
            return this.head.matchRef(matcher2, i, charSequence2) && this.next.match(matcher2, matcher2.last, charSequence2);
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            treeInfo2.maxValid = false;
            treeInfo2.deterministic = false;
            return this.next.study(treeInfo2);
        }
    }

    static final class GroupTail extends Node {
        int groupIndex;
        int localIndex;

        GroupTail(int i, int i2) {
            int i3 = i2;
            this.localIndex = i;
            this.groupIndex = i3 + i3;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int i3 = matcher2.locals[this.localIndex];
            if (i3 >= 0) {
                int i4 = matcher2.groups[this.groupIndex];
                int i5 = matcher2.groups[1 + this.groupIndex];
                matcher2.groups[this.groupIndex] = i3;
                matcher2.groups[1 + this.groupIndex] = i2;
                if (this.next.match(matcher2, i2, charSequence2)) {
                    return true;
                }
                matcher2.groups[this.groupIndex] = i4;
                matcher2.groups[1 + this.groupIndex] = i5;
                return false;
            }
            matcher2.last = i2;
            return true;
        }
    }

    static final class LastMatch extends Node {
        LastMatch() {
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            if (i2 != matcher2.oldLast) {
                return false;
            }
            return this.next.match(matcher2, i2, charSequence2);
        }
    }

    static class LastNode extends Node {
        LastNode() {
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            if (matcher2.acceptMode == 1 && i2 != matcher2.f23to) {
                return false;
            }
            matcher2.last = i2;
            matcher2.groups[0] = matcher2.first;
            matcher2.groups[1] = matcher2.last;
            return true;
        }
    }

    static final class LazyLoop extends Loop {
        LazyLoop(int i, int i2) {
            super(i, i2);
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            boolean match;
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            if (i2 <= matcher2.locals[this.beginIndex]) {
                return this.next.match(matcher2, i2, charSequence2);
            }
            int i3 = matcher2.locals[this.countIndex];
            if (i3 < this.cmin) {
                matcher2.locals[this.countIndex] = i3 + 1;
                match = this.body.match(matcher2, i2, charSequence2);
                if (!match) {
                    matcher2.locals[this.countIndex] = i3;
                }
            } else if (this.next.match(matcher2, i2, charSequence2)) {
                return true;
            } else {
                if (i3 >= this.cmax) {
                    return false;
                }
                matcher2.locals[this.countIndex] = i3 + 1;
                match = this.body.match(matcher2, i2, charSequence2);
                if (!match) {
                    matcher2.locals[this.countIndex] = i3;
                    return match;
                }
            }
            return match;
        }

        /* access modifiers changed from: 0000 */
        public boolean matchInit(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            boolean z = true;
            int i3 = matcher2.locals[this.countIndex];
            if (this.cmin > 0) {
                matcher2.locals[this.countIndex] = 1;
                z = this.body.match(matcher2, i2, charSequence2);
            } else if (!this.next.match(matcher2, i2, charSequence2)) {
                if (this.cmax > 0) {
                    matcher2.locals[this.countIndex] = 1;
                    z = this.body.match(matcher2, i2, charSequence2);
                } else {
                    z = false;
                }
            }
            matcher2.locals[this.countIndex] = i3;
            return z;
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            treeInfo2.maxValid = false;
            treeInfo2.deterministic = false;
            return false;
        }
    }

    static class Loop extends Node {
        int beginIndex;
        Node body;
        int cmax;
        int cmin;
        int countIndex;

        Loop(int i, int i2) {
            int i3 = i2;
            this.countIndex = i;
            this.beginIndex = i3;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            if (i2 > matcher2.locals[this.beginIndex]) {
                int i3 = matcher2.locals[this.countIndex];
                if (i3 < this.cmin) {
                    matcher2.locals[this.countIndex] = i3 + 1;
                    boolean match = this.body.match(matcher2, i2, charSequence2);
                    if (!match) {
                        matcher2.locals[this.countIndex] = i3;
                    }
                    return match;
                } else if (i3 < this.cmax) {
                    matcher2.locals[this.countIndex] = i3 + 1;
                    if (this.body.match(matcher2, i2, charSequence2)) {
                        return true;
                    }
                    matcher2.locals[this.countIndex] = i3;
                }
            }
            return this.next.match(matcher2, i2, charSequence2);
        }

        /* access modifiers changed from: 0000 */
        public boolean matchInit(Matcher matcher, int i, CharSequence charSequence) {
            boolean match;
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int i3 = matcher2.locals[this.countIndex];
            if (this.cmin > 0) {
                matcher2.locals[this.countIndex] = 1;
                match = this.body.match(matcher2, i2, charSequence2);
            } else if (this.cmax > 0) {
                matcher2.locals[this.countIndex] = 1;
                match = this.body.match(matcher2, i2, charSequence2);
                if (!match) {
                    match = this.next.match(matcher2, i2, charSequence2);
                }
            } else {
                match = this.next.match(matcher2, i2, charSequence2);
            }
            matcher2.locals[this.countIndex] = i3;
            return match;
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            treeInfo2.maxValid = false;
            treeInfo2.deterministic = false;
            return false;
        }
    }

    static final class Neg extends Node {
        Node cond;

        Neg(Node node) {
            this.cond = node;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            boolean z;
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int i3 = matcher2.f23to;
            if (matcher2.transparentBounds) {
                matcher2.f23to = matcher2.getTextLength();
            }
            try {
                if (i2 < matcher2.f23to) {
                    z = !this.cond.match(matcher2, i2, charSequence2);
                } else {
                    matcher2.requireEnd = true;
                    z = !this.cond.match(matcher2, i2, charSequence2);
                }
                matcher2.f23to = i3;
                return z && this.next.match(matcher2, i2, charSequence2);
            } catch (Throwable th) {
                Throwable th2 = th;
                matcher2.f23to = i3;
                throw th2;
            }
        }
    }

    static class Node {
        Node next = Pattern.accept;

        Node() {
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            CharSequence charSequence2 = charSequence;
            matcher2.last = i;
            matcher2.groups[0] = matcher2.first;
            matcher2.groups[1] = matcher2.last;
            return true;
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            return this.next != null ? this.next.study(treeInfo2) : treeInfo2.deterministic;
        }
    }

    static class NotBehind extends Node {
        Node cond;
        int rmax;
        int rmin;

        NotBehind(Node node, int i, int i2) {
            int i3 = i;
            int i4 = i2;
            this.cond = node;
            this.rmax = i3;
            this.rmin = i4;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int i3 = matcher2.lookbehindTo;
            int i4 = matcher2.from;
            int max = Math.max(i2 - this.rmax, !matcher2.transparentBounds ? matcher2.from : 0);
            matcher2.lookbehindTo = i2;
            if (matcher2.transparentBounds) {
                matcher2.from = 0;
            }
            int i5 = i2 - this.rmin;
            boolean z = false;
            while (!z && i5 >= max) {
                z = this.cond.match(matcher2, i5, charSequence2);
                i5--;
            }
            matcher2.from = i4;
            matcher2.lookbehindTo = i3;
            boolean z2 = false;
            if (!z) {
                z2 = false;
                if (this.next.match(matcher2, i2, charSequence2)) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    static final class NotBehindS extends NotBehind {
        NotBehindS(Node node, int i, int i2) {
            super(node, i, i2);
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            boolean z;
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int access$300 = Pattern.countChars(charSequence2, i2, -this.rmax);
            int access$3002 = Pattern.countChars(charSequence2, i2, -this.rmin);
            int i3 = matcher2.from;
            int i4 = matcher2.lookbehindTo;
            int max = Math.max(i2 - access$300, !matcher2.transparentBounds ? matcher2.from : 0);
            matcher2.lookbehindTo = i2;
            if (matcher2.transparentBounds) {
                matcher2.from = 0;
            }
            int i5 = i2 - access$3002;
            boolean z2 = false;
            while (true) {
                z = z2;
                if (z || i5 < max) {
                    matcher2.from = i3;
                    matcher2.lookbehindTo = i4;
                } else {
                    boolean match = this.cond.match(matcher2, i5, charSequence2);
                    i5 -= i5 > max ? Pattern.countChars(charSequence2, i5, -1) : 1;
                    z2 = match;
                }
            }
            matcher2.from = i3;
            matcher2.lookbehindTo = i4;
            return !z && this.next.match(matcher2, i2, charSequence2);
        }
    }

    static final class Pos extends Node {
        Node cond;

        Pos(Node node) {
            this.cond = node;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            boolean z;
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int i3 = matcher2.f23to;
            if (matcher2.transparentBounds) {
                matcher2.f23to = matcher2.getTextLength();
            }
            try {
                th = this.cond.match(matcher2, i2, charSequence2);
                return z && this.next.match(matcher2, i2, charSequence2);
            } finally {
                z = th;
                matcher2.f23to = i3;
                boolean z2 = z;
            }
        }
    }

    static final class Prolog extends Node {
        Loop loop;

        Prolog(Loop loop2) {
            this.loop = loop2;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            return this.loop.matchInit(matcher, i, charSequence);
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            return this.loop.study(treeInfo);
        }
    }

    static final class Ques extends Node {
        Node atom;
        int type;

        Ques(Node node, int i) {
            int i2 = i;
            this.atom = node;
            this.type = i2;
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
            if (r0.next.match(r1, r2, r3) != false) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0085, code lost:
            if (r0.next.match(r1, r1.last, r3) != false) goto L_0x0087;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean match(jdkregex.Matcher r14, int r15, java.lang.CharSequence r16) {
            /*
                r13 = this;
                r0 = r13
                r1 = r14
                r2 = r15
                r3 = r16
                r9 = 1
                r4 = r9
                r9 = r0
                int r9 = r9.type
                switch(r9) {
                    case 0: goto L_0x002c;
                    case 1: goto L_0x0059;
                    case 2: goto L_0x008a;
                    default: goto L_0x000d;
                }
            L_0x000d:
                r9 = r0
                jdkregex.Pattern$Node r9 = r9.atom
                r10 = r1
                r11 = r2
                r12 = r3
                boolean r9 = r9.match(r10, r11, r12)
                if (r9 == 0) goto L_0x00a6
                r9 = r0
                jdkregex.Pattern$Node r9 = r9.next
                r10 = r1
                r11 = r1
                int r11 = r11.last
                r12 = r3
                boolean r9 = r9.match(r10, r11, r12)
                if (r9 == 0) goto L_0x00a6
            L_0x0027:
                r9 = r4
                r6 = r9
            L_0x0029:
                r9 = r6
                r0 = r9
            L_0x002b:
                return r0
            L_0x002c:
                r9 = r0
                jdkregex.Pattern$Node r9 = r9.atom
                r10 = r1
                r11 = r2
                r12 = r3
                boolean r9 = r9.match(r10, r11, r12)
                if (r9 == 0) goto L_0x0046
                r9 = r0
                jdkregex.Pattern$Node r9 = r9.next
                r10 = r1
                r11 = r1
                int r11 = r11.last
                r12 = r3
                boolean r9 = r9.match(r10, r11, r12)
                if (r9 != 0) goto L_0x0056
            L_0x0046:
                r9 = r0
                jdkregex.Pattern$Node r9 = r9.next
                r10 = r1
                r11 = r2
                r12 = r3
                boolean r9 = r9.match(r10, r11, r12)
                r8 = r9
                r9 = 0
                r6 = r9
                r9 = r8
                if (r9 == 0) goto L_0x0029
            L_0x0056:
                r9 = r4
                r0 = r9
                goto L_0x002b
            L_0x0059:
                r9 = r0
                jdkregex.Pattern$Node r9 = r9.next
                r10 = r1
                r11 = r2
                r12 = r3
                boolean r9 = r9.match(r10, r11, r12)
                if (r9 != 0) goto L_0x0087
                r9 = r0
                jdkregex.Pattern$Node r9 = r9.atom
                r10 = r1
                r11 = r2
                r12 = r3
                boolean r9 = r9.match(r10, r11, r12)
                r5 = r9
                r9 = 0
                r6 = r9
                r9 = r5
                if (r9 == 0) goto L_0x0029
                r9 = r0
                jdkregex.Pattern$Node r9 = r9.next
                r10 = r1
                r11 = r1
                int r11 = r11.last
                r12 = r3
                boolean r9 = r9.match(r10, r11, r12)
                r7 = r9
                r9 = 0
                r6 = r9
                r9 = r7
                if (r9 == 0) goto L_0x0029
            L_0x0087:
                r9 = r4
                r0 = r9
                goto L_0x002b
            L_0x008a:
                r9 = r0
                jdkregex.Pattern$Node r9 = r9.atom
                r10 = r1
                r11 = r2
                r12 = r3
                boolean r9 = r9.match(r10, r11, r12)
                if (r9 == 0) goto L_0x009a
                r9 = r1
                int r9 = r9.last
                r2 = r9
            L_0x009a:
                r9 = r0
                jdkregex.Pattern$Node r9 = r9.next
                r10 = r1
                r11 = r2
                r12 = r3
                boolean r9 = r9.match(r10, r11, r12)
                r0 = r9
                goto L_0x002b
            L_0x00a6:
                r9 = 0
                r4 = r9
                goto L_0x0027
            */
            throw new UnsupportedOperationException("Method not decompiled: jdkregex.Pattern.Ques.match(jdkregex.Matcher, int, java.lang.CharSequence):boolean");
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            if (this.type != 3) {
                int i = treeInfo2.minLength;
                boolean study = this.atom.study(treeInfo2);
                treeInfo2.minLength = i;
                treeInfo2.deterministic = false;
                return this.next.study(treeInfo2);
            }
            boolean study2 = this.atom.study(treeInfo2);
            return this.next.study(treeInfo2);
        }
    }

    static final class Script extends CharProperty {
        final UnicodeScript script;

        Script(UnicodeScript unicodeScript) {
            UnicodeScript unicodeScript2 = unicodeScript;
            super(null);
            this.script = unicodeScript2;
        }

        /* access modifiers changed from: 0000 */
        public boolean isSatisfiedBy(int i) {
            return this.script == UnicodeScript.of(i);
        }
    }

    static final class Single extends BmpCharProperty {

        /* renamed from: c */
        final int f24c;

        Single(int i) {
            int i2 = i;
            super(null);
            this.f24c = i2;
        }

        /* access modifiers changed from: 0000 */
        public boolean isSatisfiedBy(int i) {
            return i == this.f24c;
        }
    }

    static final class SingleI extends BmpCharProperty {
        final int lower;
        final int upper;

        SingleI(int i, int i2) {
            int i3 = i;
            int i4 = i2;
            super(null);
            this.lower = i3;
            this.upper = i4;
        }

        /* access modifiers changed from: 0000 */
        public boolean isSatisfiedBy(int i) {
            int i2 = i;
            return i2 == this.lower || i2 == this.upper;
        }
    }

    static final class SingleS extends CharProperty {

        /* renamed from: c */
        final int f25c;

        SingleS(int i) {
            int i2 = i;
            super(null);
            this.f25c = i2;
        }

        /* access modifiers changed from: 0000 */
        public boolean isSatisfiedBy(int i) {
            return i == this.f25c;
        }
    }

    static final class SingleU extends CharProperty {
        final int lower;

        SingleU(int i) {
            int i2 = i;
            super(null);
            this.lower = i2;
        }

        /* access modifiers changed from: 0000 */
        public boolean isSatisfiedBy(int i) {
            int i2 = i;
            return this.lower == i2 || this.lower == Character.toLowerCase(Character.toUpperCase(i2));
        }
    }

    static final class Slice extends SliceNode {
        Slice(int[] iArr) {
            super(iArr);
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int[] iArr = this.buffer;
            int length = iArr.length;
            int i3 = 0;
            while (i3 < length) {
                if (i2 + i3 >= matcher2.f23to) {
                    matcher2.hitEnd = true;
                } else if (iArr[i3] == charSequence2.charAt(i2 + i3)) {
                    i3++;
                }
                return false;
            }
            return this.next.match(matcher2, i2 + length, charSequence2);
        }
    }

    static class SliceI extends SliceNode {
        SliceI(int[] iArr) {
            super(iArr);
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int[] iArr = this.buffer;
            int length = iArr.length;
            int i3 = 0;
            while (i3 < length) {
                if (i2 + i3 >= matcher2.f23to) {
                    matcher2.hitEnd = true;
                } else {
                    int charAt = charSequence2.charAt(i2 + i3);
                    if (iArr[i3] == charAt || iArr[i3] == ASCII.toLower(charAt)) {
                        i3++;
                    }
                }
                return false;
            }
            return this.next.match(matcher2, i2 + length, charSequence2);
        }
    }

    static class SliceIS extends SliceNode {
        SliceIS(int[] iArr) {
            super(iArr);
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int[] iArr = this.buffer;
            int i3 = 0;
            while (i3 < iArr.length) {
                if (i2 >= matcher2.f23to) {
                    matcher2.hitEnd = true;
                } else {
                    int codePointAt = Character.codePointAt(charSequence2, i2);
                    if (iArr[i3] == codePointAt || iArr[i3] == toLower(codePointAt)) {
                        i2 += Character.charCount(codePointAt);
                        if (i2 > matcher2.f23to) {
                            matcher2.hitEnd = true;
                            return false;
                        }
                        i3++;
                    }
                }
                return false;
            }
            return this.next.match(matcher2, i2, charSequence2);
        }

        /* access modifiers changed from: 0000 */
        public int toLower(int i) {
            return ASCII.toLower(i);
        }
    }

    static class SliceNode extends Node {
        int[] buffer;

        SliceNode(int[] iArr) {
            this.buffer = iArr;
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            treeInfo2.minLength += this.buffer.length;
            treeInfo2.maxLength += this.buffer.length;
            return this.next.study(treeInfo2);
        }
    }

    static final class SliceS extends SliceNode {
        SliceS(int[] iArr) {
            super(iArr);
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int[] iArr = this.buffer;
            int i3 = 0;
            while (i3 < iArr.length) {
                if (i2 >= matcher2.f23to) {
                    matcher2.hitEnd = true;
                } else {
                    int codePointAt = Character.codePointAt(charSequence2, i2);
                    if (iArr[i3] == codePointAt) {
                        i2 += Character.charCount(codePointAt);
                        if (i2 > matcher2.f23to) {
                            matcher2.hitEnd = true;
                            return false;
                        }
                        i3++;
                    }
                }
                return false;
            }
            return this.next.match(matcher2, i2, charSequence2);
        }
    }

    static final class SliceU extends SliceNode {
        SliceU(int[] iArr) {
            super(iArr);
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int[] iArr = this.buffer;
            int length = iArr.length;
            int i3 = 0;
            while (i3 < length) {
                if (i2 + i3 >= matcher2.f23to) {
                    matcher2.hitEnd = true;
                } else {
                    int charAt = charSequence2.charAt(i2 + i3);
                    if (iArr[i3] == charAt || iArr[i3] == Character.toLowerCase(Character.toUpperCase(charAt))) {
                        i3++;
                    }
                }
                return false;
            }
            return this.next.match(matcher2, i2 + length, charSequence2);
        }
    }

    static final class SliceUS extends SliceIS {
        SliceUS(int[] iArr) {
            super(iArr);
        }

        /* access modifiers changed from: 0000 */
        public int toLower(int i) {
            return Character.toLowerCase(Character.toUpperCase(i));
        }
    }

    static class Start extends Node {
        int minLength;

        Start(Node node) {
            TreeInfo treeInfo;
            this.next = node;
            TreeInfo treeInfo2 = treeInfo;
            TreeInfo treeInfo3 = new TreeInfo();
            TreeInfo treeInfo4 = treeInfo2;
            boolean study = this.next.study(treeInfo4);
            this.minLength = treeInfo4.minLength;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            if (i2 > matcher2.f23to - this.minLength) {
                matcher2.hitEnd = true;
                return false;
            }
            int i3 = matcher2.f23to - this.minLength;
            while (i2 <= i3) {
                if (this.next.match(matcher2, i2, charSequence2)) {
                    matcher2.first = i2;
                    matcher2.groups[0] = matcher2.first;
                    matcher2.groups[1] = matcher2.last;
                    return true;
                }
                i2++;
            }
            matcher2.hitEnd = true;
            return false;
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            boolean study = this.next.study(treeInfo2);
            treeInfo2.maxValid = false;
            treeInfo2.deterministic = false;
            return false;
        }
    }

    static final class StartS extends Start {
        StartS(Node node) {
            super(node);
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            if (i2 > matcher2.f23to - this.minLength) {
                matcher2.hitEnd = true;
                return false;
            }
            int i3 = matcher2.f23to - this.minLength;
            while (i2 <= i3) {
                if (this.next.match(matcher2, i2, charSequence2)) {
                    matcher2.first = i2;
                    matcher2.groups[0] = matcher2.first;
                    matcher2.groups[1] = matcher2.last;
                    return true;
                } else if (i2 == i3) {
                    break;
                } else {
                    int i4 = i2 + 1;
                    i2 = (!Character.isHighSurrogate(charSequence2.charAt(i2)) || i4 >= charSequence2.length() || !Character.isLowSurrogate(charSequence2.charAt(i4))) ? i4 : i4 + 1;
                }
            }
            matcher2.hitEnd = true;
            return false;
        }
    }

    static final class TreeInfo {
        boolean deterministic;
        int maxLength;
        boolean maxValid;
        int minLength;

        TreeInfo() {
            reset();
        }

        /* access modifiers changed from: 0000 */
        public void reset() {
            this.minLength = 0;
            this.maxLength = 0;
            this.maxValid = true;
            this.deterministic = true;
        }
    }

    static final class UnixCaret extends Node {
        UnixCaret() {
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int i3 = matcher2.from;
            int i4 = matcher2.f23to;
            if (!matcher2.anchoringBounds) {
                i4 = matcher2.getTextLength();
                i3 = 0;
            }
            if (i2 == i4) {
                matcher2.hitEnd = true;
            } else if (i2 <= i3 || charSequence2.charAt(i2 - 1) == 10) {
                return this.next.match(matcher2, i2, charSequence2);
            }
            return false;
        }
    }

    static final class UnixDollar extends Node {
        boolean multiline;

        UnixDollar(boolean z) {
            this.multiline = z;
        }

        /* access modifiers changed from: 0000 */
        public boolean match(Matcher matcher, int i, CharSequence charSequence) {
            Matcher matcher2 = matcher;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            int textLength = matcher2.anchoringBounds ? matcher2.f23to : matcher2.getTextLength();
            if (i2 < textLength) {
                if (charSequence2.charAt(i2) != 10 || (!this.multiline && i2 != textLength - 1)) {
                    return false;
                }
                if (this.multiline) {
                    return this.next.match(matcher2, i2, charSequence2);
                }
            }
            matcher2.hitEnd = true;
            matcher2.requireEnd = true;
            return this.next.match(matcher2, i2, charSequence2);
        }

        /* access modifiers changed from: 0000 */
        public boolean study(TreeInfo treeInfo) {
            TreeInfo treeInfo2 = treeInfo;
            boolean study = this.next.study(treeInfo2);
            return treeInfo2.deterministic;
        }
    }

    static final class UnixDot extends CharProperty {
        UnixDot() {
            super(null);
        }

        /* access modifiers changed from: 0000 */
        public boolean isSatisfiedBy(int i) {
            return i != 10;
        }
    }

    static final class Utype extends CharProperty {
        final UnicodeProp uprop;

        Utype(UnicodeProp unicodeProp) {
            UnicodeProp unicodeProp2 = unicodeProp;
            super(null);
            this.uprop = unicodeProp2;
        }

        /* access modifiers changed from: 0000 */
        public boolean isSatisfiedBy(int i) {
            return this.uprop.mo7641is(i);
        }
    }

    static {
        C05594 r3;
        Node node;
        LastNode lastNode;
        C05594 r1 = r3;
        C05594 r2 = new Node() {
            /* access modifiers changed from: 0000 */
            public boolean match(Matcher matcher, int i, CharSequence charSequence) {
                CharSequence charSequence2 = charSequence;
                return i == matcher.lookbehindTo;
            }
        };
        lookbehindEnd = r1;
        Node node2 = node;
        Node node3 = new Node();
        accept = node2;
        LastNode lastNode2 = lastNode;
        LastNode lastNode3 = new LastNode();
        lastAccept = lastNode2;
    }

    private Pattern(String str, int i) {
        Start start;
        String str2 = str;
        int i2 = i;
        this.pattern = str2;
        this.flags = i2;
        if ((256 & this.flags) != 0) {
            this.flags = 64 | this.flags;
        }
        this.capturingGroupCount = 1;
        this.localCount = 0;
        if (this.pattern.length() > 0) {
            compile();
            return;
        }
        Start start2 = start;
        Start start3 = new Start(lastAccept);
        this.root = start2;
        this.matchRoot = lastAccept;
    }

    private void RemoveQEQuoting() {
        int i;
        boolean z;
        int i2;
        int i3 = this.patternLength;
        int i4 = 0;
        while (i4 < i3 - 1) {
            if (this.temp[i4] == 92) {
                if (this.temp[i4 + 1] == 81) {
                    break;
                }
                i4 += 2;
            } else {
                i4++;
            }
        }
        if (i4 < i3 - 1) {
            int i5 = i4 + 2;
            int[] iArr = new int[(2 + i4 + (2 * (i3 - i5)))];
            System.arraycopy(this.temp, 0, iArr, 0, i4);
            int i6 = i5;
            boolean z2 = true;
            while (true) {
                boolean z3 = z2;
                if (i6 < i3) {
                    int i7 = i6 + 1;
                    int i8 = this.temp[i6];
                    if (!ASCII.isAscii(i8) || ASCII.isAlnum(i8)) {
                        int i9 = i4 + 1;
                        iArr[i4] = i8;
                        i4 = i9;
                        z = z3;
                        i = i7;
                    } else if (i8 != 92) {
                        if (z3) {
                            i2 = i4 + 1;
                            iArr[i4] = 92;
                        } else {
                            i2 = i4;
                        }
                        i4 = i2 + 1;
                        iArr[i2] = i8;
                        z = z3;
                        i = i7;
                    } else if (z3) {
                        if (this.temp[i7] == 69) {
                            i = i7 + 1;
                            z = false;
                        } else {
                            int i10 = i4 + 1;
                            iArr[i4] = 92;
                            i4 = i10 + 1;
                            iArr[i10] = 92;
                            z = z3;
                            i = i7;
                        }
                    } else {
                        if (this.temp[i7] == 81) {
                            i = i7 + 1;
                            z = true;
                        } else {
                            int i11 = i4 + 1;
                            iArr[i4] = i8;
                            if (i7 != i3) {
                                i4 = i11 + 1;
                                int i12 = i7 + 1;
                                iArr[i11] = this.temp[i7];
                                z = z3;
                                i = i12;
                            } else {
                                i4 = i11;
                                z = z3;
                                i = i7;
                            }
                        }
                    }
                    i6 = i;
                    z2 = z;
                } else {
                    this.patternLength = i4;
                    this.temp = Arrays.copyOf(iArr, i4 + 2);
                    return;
                }
            }
        }
    }

    private void accept(int i, String str) {
        int i2 = i;
        String str2 = str;
        int[] iArr = this.temp;
        int i3 = this.cursor;
        this.cursor = i3 + 1;
        int i4 = iArr[i3];
        if (has(4)) {
            i4 = parsePastWhitespace(i4);
        }
        if (i2 != i4) {
            throw error(str2);
        }
    }

    private void addFlag() {
        int peek = peek();
        while (true) {
            switch (peek) {
                case 45:
                    int next = next();
                    subFlag();
                    return;
                case 85:
                    this.flags = 320 | this.flags;
                    break;
                case 99:
                    this.flags = 128 | this.flags;
                    break;
                case 100:
                    this.flags = 1 | this.flags;
                    break;
                case 105:
                    this.flags = 2 | this.flags;
                    break;
                case 109:
                    this.flags = 8 | this.flags;
                    break;
                case 115:
                    this.flags = 32 | this.flags;
                    break;
                case 117:
                    this.flags = 64 | this.flags;
                    break;
                case 120:
                    this.flags = 4 | this.flags;
                    break;
                default:
                    return;
            }
            peek = next();
        }
    }

    private void append(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (i4 >= this.buffer.length) {
            int[] iArr = new int[(i4 + i4)];
            System.arraycopy(this.buffer, 0, iArr, 0, i4);
            this.buffer = iArr;
        }
        this.buffer[i4] = i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
        if (r4 <= 0) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0064, code lost:
        unread();
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        if (r7 != 80) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0070, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        if (next() == 123) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        unread();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0088, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008b, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
        r3 = r0.cursor;
        append(r2, r4);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0025, code lost:
        if (isSupplementary(r2) == false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0027, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return family(r1, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0029, code lost:
        r2 = next();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private jdkregex.Pattern.Node atom() {
        /*
            r17 = this;
            r0 = r17
            r13 = 1
            r1 = r13
            r13 = r0
            int r13 = r13.peek()
            r2 = r13
            r13 = -1
            r3 = r13
            r13 = 0
            r4 = r13
            r13 = 0
            r5 = r13
        L_0x0010:
            r13 = r2
            switch(r13) {
                case 0: goto L_0x00d6;
                case 36: goto L_0x004e;
                case 40: goto L_0x004e;
                case 41: goto L_0x004e;
                case 42: goto L_0x0030;
                case 43: goto L_0x0030;
                case 46: goto L_0x004e;
                case 63: goto L_0x0030;
                case 91: goto L_0x004e;
                case 92: goto L_0x0051;
                case 94: goto L_0x004e;
                case 123: goto L_0x0030;
                case 124: goto L_0x004e;
                default: goto L_0x0014;
            }
        L_0x0014:
            r13 = r0
            int r13 = r13.cursor
            r3 = r13
            r13 = r0
            r14 = r2
            r15 = r4
            r13.append(r14, r15)
            int r4 = r4 + 1
            r13 = r2
            boolean r13 = isSupplementary(r13)
            if (r13 == 0) goto L_0x0029
            r13 = r1
            r5 = r13
        L_0x0029:
            r13 = r0
            int r13 = r13.next()
            r2 = r13
            goto L_0x0010
        L_0x0030:
            r13 = r4
            r14 = r1
            if (r13 <= r14) goto L_0x00f3
            r13 = r0
            r14 = r3
            r13.cursor = r14
            r13 = r4
            r14 = 1
            int r13 = r13 + -1
            r6 = r13
        L_0x003d:
            r13 = r6
            r14 = r1
            if (r13 != r14) goto L_0x00e2
            r13 = r0
            r14 = r0
            int[] r14 = r14.buffer
            r15 = 0
            r14 = r14[r15]
            jdkregex.Pattern$CharProperty r13 = r13.newSingle(r14)
            r0 = r13
        L_0x004d:
            return r0
        L_0x004e:
            r13 = r4
            r6 = r13
            goto L_0x003d
        L_0x0051:
            r13 = r0
            int r13 = r13.nextEscaped()
            r7 = r13
            r13 = r7
            r14 = 112(0x70, float:1.57E-43)
            if (r13 == r14) goto L_0x0061
            r13 = r7
            r14 = 80
            if (r13 != r14) goto L_0x008e
        L_0x0061:
            r13 = r4
            if (r13 <= 0) goto L_0x006b
            r13 = r0
            r13.unread()
            r13 = r4
            r6 = r13
            goto L_0x003d
        L_0x006b:
            r13 = r7
            r14 = 80
            if (r13 != r14) goto L_0x0088
            r13 = r1
            r8 = r13
        L_0x0072:
            r13 = r0
            int r13 = r13.next()
            r14 = 123(0x7b, float:1.72E-43)
            if (r13 == r14) goto L_0x008b
            r13 = r0
            r13.unread()
        L_0x007f:
            r13 = r0
            r14 = r1
            r15 = r8
            jdkregex.Pattern$CharProperty r13 = r13.family(r14, r15)
            r0 = r13
            goto L_0x004d
        L_0x0088:
            r13 = 0
            r8 = r13
            goto L_0x0072
        L_0x008b:
            r13 = 0
            r1 = r13
            goto L_0x007f
        L_0x008e:
            r13 = r0
            r13.unread()
            r13 = r0
            int r13 = r13.cursor
            r3 = r13
            r13 = r4
            if (r13 != 0) goto L_0x00c3
            r13 = r1
            r9 = r13
        L_0x009b:
            r13 = r0
            r14 = 0
            r15 = r9
            int r13 = r13.escape(r14, r15)
            r10 = r13
            r13 = r10
            if (r13 < 0) goto L_0x00c6
            r13 = r0
            r14 = r10
            r15 = r4
            r13.append(r14, r15)
            int r4 = r4 + 1
            r13 = r10
            boolean r13 = isSupplementary(r13)
            if (r13 == 0) goto L_0x00f0
            r13 = r1
            r11 = r13
        L_0x00b7:
            r13 = r0
            int r13 = r13.peek()
            r12 = r13
            r13 = r11
            r5 = r13
            r13 = r12
            r2 = r13
            goto L_0x0010
        L_0x00c3:
            r13 = 0
            r9 = r13
            goto L_0x009b
        L_0x00c6:
            r13 = r4
            if (r13 != 0) goto L_0x00ce
            r13 = r0
            jdkregex.Pattern$Node r13 = r13.root
            r0 = r13
            goto L_0x004d
        L_0x00ce:
            r13 = r0
            r14 = r3
            r13.cursor = r14
            r13 = r4
            r6 = r13
            goto L_0x003d
        L_0x00d6:
            r13 = r0
            int r13 = r13.cursor
            r14 = r0
            int r14 = r14.patternLength
            if (r13 < r14) goto L_0x0014
            r13 = r4
            r6 = r13
            goto L_0x003d
        L_0x00e2:
            r13 = r0
            r14 = r0
            int[] r14 = r14.buffer
            r15 = r6
            r16 = r5
            jdkregex.Pattern$Node r13 = r13.newSlice(r14, r15, r16)
            r0 = r13
            goto L_0x004d
        L_0x00f0:
            r13 = r5
            r11 = r13
            goto L_0x00b7
        L_0x00f3:
            r13 = r4
            r6 = r13
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: jdkregex.Pattern.atom():jdkregex.Pattern$Node");
    }

    private CharProperty bitsOrSingle(BitClass bitClass, int i) {
        int i2 = i;
        return (i2 >= 256 || (has(2) && has(64) && (i2 == 255 || i2 == 181 || i2 == 73 || i2 == 105 || i2 == 83 || i2 == 115 || i2 == 75 || i2 == 107 || i2 == 197 || i2 == 229))) ? newSingle(i2) : bitClass.add(i2, flags());
    }

    /* renamed from: c */
    private int m22c() {
        if (this.cursor < this.patternLength) {
            return 64 ^ read();
        }
        throw error("Illegal control escape sequence");
    }

    private CharProperty caseInsensitiveRangeFor(int i, int i2) {
        C05583 r8;
        C05572 r82;
        int i3 = i;
        int i4 = i2;
        if (has(64)) {
            C05572 r3 = r82;
            final int i5 = i3;
            final int i6 = i4;
            C05572 r4 = new CharProperty(this) {
                final /* synthetic */ Pattern this$0;

                {
                    int i = r8;
                    int i2 = r9;
                    this.this$0 = r7;
                }

                /* access modifiers changed from: 0000 */
                public boolean isSatisfiedBy(int i) {
                    int i2 = i;
                    if (!Pattern.inRange(i5, i2, i6)) {
                        int upperCase = Character.toUpperCase(i2);
                        if (!Pattern.inRange(i5, upperCase, i6) && !Pattern.inRange(i5, Character.toLowerCase(upperCase), i6)) {
                            return false;
                        }
                    }
                    return true;
                }
            };
            return r3;
        }
        C05583 r32 = r8;
        final int i7 = i3;
        final int i8 = i4;
        C05583 r42 = new CharProperty(this) {
            final /* synthetic */ Pattern this$0;

            {
                int i = r8;
                int i2 = r9;
                this.this$0 = r7;
            }

            /* access modifiers changed from: 0000 */
            public boolean isSatisfiedBy(int i) {
                int i2 = i;
                return Pattern.inRange(i7, i2, i8) || (ASCII.isAscii(i2) && (Pattern.inRange(i7, ASCII.toUpper(i2), i8) || Pattern.inRange(i7, ASCII.toLower(i2), i8)));
            }
        };
        return r32;
    }

    private CharProperty charPropertyNodeFor(String str) {
        StringBuilder sb;
        String str2 = str;
        CharProperty charPropertyFor = CharPropertyNames.charPropertyFor(str2);
        if (charPropertyFor != null) {
            return charPropertyFor;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        throw error(sb2.append("Unknown character property name {").append(str2).append("}").toString());
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private jdkregex.Pattern.CharProperty clazz(boolean r23) {
        /*
            r22 = this;
            r2 = r22
            r3 = r23
            jdkregex.Pattern$BitClass r18 = new jdkregex.Pattern$BitClass
            r21 = r18
            r18 = r21
            r19 = r21
            r19.<init>()
            r4 = r18
            r18 = r2
            int r18 = r18.next()
            r5 = r18
            r18 = 1
            r6 = r18
            r18 = 1
            r7 = r18
            r18 = 0
            r8 = r18
            r18 = 0
            r9 = r18
        L_0x0029:
            r18 = r5
            switch(r18) {
                case 0: goto L_0x0179;
                case 38: goto L_0x00cd;
                case 91: goto L_0x009a;
                case 93: goto L_0x0198;
                case 94: goto L_0x0059;
                default: goto L_0x002e;
            }
        L_0x002e:
            r18 = 0
            r10 = r18
        L_0x0032:
            r18 = r2
            r19 = r4
            jdkregex.Pattern$CharProperty r18 = r18.range(r19)
            r8 = r18
            r18 = r7
            if (r18 == 0) goto L_0x01c1
            r18 = r9
            if (r18 != 0) goto L_0x01ab
            r18 = r8
            r11 = r18
        L_0x0048:
            r18 = r2
            int r18 = r18.peek()
            r5 = r18
            r18 = r11
            r9 = r18
            r18 = r10
            r6 = r18
            goto L_0x0029
        L_0x0059:
            r18 = r6
            if (r18 == 0) goto L_0x01f7
            r18 = r2
            r0 = r18
            int[] r0 = r0.temp
            r18 = r0
            r19 = -1
            r20 = r2
            r0 = r20
            int r0 = r0.cursor
            r20 = r0
            int r19 = r19 + r20
            r18 = r18[r19]
            r19 = 91
            r0 = r18
            r1 = r19
            if (r0 == r1) goto L_0x0080
            r18 = r6
            r10 = r18
            goto L_0x0032
        L_0x0080:
            r18 = r2
            int r18 = r18.next()
            r5 = r18
            r18 = r7
            if (r18 != 0) goto L_0x0095
            r18 = 1
            r17 = r18
        L_0x0090:
            r18 = r17
            r7 = r18
            goto L_0x0029
        L_0x0095:
            r18 = 0
            r17 = r18
            goto L_0x0090
        L_0x009a:
            r18 = r2
            r19 = 1
            jdkregex.Pattern$CharProperty r18 = r18.clazz(r19)
            r15 = r18
            r18 = r9
            if (r18 != 0) goto L_0x00c2
            r18 = r15
            r16 = r18
        L_0x00ac:
            r18 = r2
            int r18 = r18.peek()
            r5 = r18
            r18 = r15
            r8 = r18
            r18 = r16
            r9 = r18
            r18 = 0
            r6 = r18
            goto L_0x0029
        L_0x00c2:
            r18 = r9
            r19 = r15
            jdkregex.Pattern$CharProperty r18 = union(r18, r19)
            r16 = r18
            goto L_0x00ac
        L_0x00cd:
            r18 = r2
            int r18 = r18.next()
            r19 = 38
            r0 = r18
            r1 = r19
            if (r0 != r1) goto L_0x016e
            r18 = r2
            int r18 = r18.next()
            r5 = r18
            r18 = 0
            r13 = r18
        L_0x00e7:
            r18 = r5
            r19 = 93
            r0 = r18
            r1 = r19
            if (r0 == r1) goto L_0x013d
            r18 = r5
            r19 = 38
            r0 = r18
            r1 = r19
            if (r0 == r1) goto L_0x013d
            r18 = r5
            r19 = 91
            r0 = r18
            r1 = r19
            if (r0 != r1) goto L_0x012d
            r18 = r13
            if (r18 != 0) goto L_0x011c
            r18 = r2
            r19 = 1
            jdkregex.Pattern$CharProperty r18 = r18.clazz(r19)
            r13 = r18
        L_0x0113:
            r18 = r2
            int r18 = r18.peek()
            r5 = r18
            goto L_0x00e7
        L_0x011c:
            r18 = r13
            r19 = r2
            r20 = 1
            jdkregex.Pattern$CharProperty r19 = r19.clazz(r20)
            jdkregex.Pattern$CharProperty r18 = union(r18, r19)
            r13 = r18
            goto L_0x0113
        L_0x012d:
            r18 = r2
            r18.unread()
            r18 = r2
            r19 = 0
            jdkregex.Pattern$CharProperty r18 = r18.clazz(r19)
            r13 = r18
            goto L_0x0113
        L_0x013d:
            r18 = r13
            if (r18 == 0) goto L_0x01f1
            r18 = r13
            r14 = r18
        L_0x0145:
            r18 = r9
            if (r18 != 0) goto L_0x0156
            r18 = r13
            if (r18 != 0) goto L_0x0160
            r18 = r2
            java.lang.String r19 = "Bad class syntax"
            jdkregex.PatternSyntaxException r18 = r18.error(r19)
            throw r18
        L_0x0156:
            r18 = r9
            r19 = r14
            jdkregex.Pattern$CharProperty r18 = intersection(r18, r19)
            r13 = r18
        L_0x0160:
            r18 = r14
            r8 = r18
            r18 = r13
            r9 = r18
            r18 = 0
            r6 = r18
            goto L_0x0029
        L_0x016e:
            r18 = r2
            r18.unread()
            r18 = 0
            r10 = r18
            goto L_0x0032
        L_0x0179:
            r18 = r2
            r0 = r18
            int r0 = r0.cursor
            r18 = r0
            r19 = r2
            r0 = r19
            int r0 = r0.patternLength
            r19 = r0
            r0 = r18
            r1 = r19
            if (r0 < r1) goto L_0x01eb
            r18 = r2
            java.lang.String r19 = "Unclosed character class"
            jdkregex.PatternSyntaxException r18 = r18.error(r19)
            throw r18
        L_0x0198:
            r18 = r9
            if (r18 == 0) goto L_0x01eb
            r18 = r3
            if (r18 == 0) goto L_0x01a6
            r18 = r2
            int r18 = r18.next()
        L_0x01a6:
            r18 = r9
            r2 = r18
            return r2
        L_0x01ab:
            r18 = r9
            r19 = r8
            r0 = r18
            r1 = r19
            if (r0 == r1) goto L_0x01e5
            r18 = r9
            r19 = r8
            jdkregex.Pattern$CharProperty r18 = union(r18, r19)
            r11 = r18
            goto L_0x0048
        L_0x01c1:
            r18 = r9
            if (r18 != 0) goto L_0x01cf
            r18 = r8
            jdkregex.Pattern$CharProperty r18 = r18.complement()
            r11 = r18
            goto L_0x0048
        L_0x01cf:
            r18 = r9
            r19 = r8
            r0 = r18
            r1 = r19
            if (r0 == r1) goto L_0x01e5
            r18 = r9
            r19 = r8
            jdkregex.Pattern$CharProperty r18 = setDifference(r18, r19)
            r11 = r18
            goto L_0x0048
        L_0x01e5:
            r18 = r9
            r11 = r18
            goto L_0x0048
        L_0x01eb:
            r18 = 0
            r10 = r18
            goto L_0x0032
        L_0x01f1:
            r18 = r8
            r14 = r18
            goto L_0x0145
        L_0x01f7:
            r18 = r6
            r10 = r18
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: jdkregex.Pattern.clazz(boolean):jdkregex.Pattern$CharProperty");
    }

    private Node closure(Node node) {
        Curly curly;
        Curly curly2;
        Curly curly3;
        Curly curly4;
        Curly curly5;
        Curly curly6;
        Curly curly7;
        Curly curly8;
        Curly curly9;
        Ques ques;
        Ques ques2;
        Ques ques3;
        Node node2 = node;
        int i = Integer.MAX_VALUE;
        switch (peek()) {
            case 42:
                int next = next();
                if (next == 63) {
                    int next2 = next();
                    Curly curly10 = curly9;
                    Curly curly11 = new Curly(node2, 0, Integer.MAX_VALUE, 1);
                    return curly10;
                } else if (next == 43) {
                    int next3 = next();
                    Curly curly12 = curly8;
                    Curly curly13 = new Curly(node2, 0, Integer.MAX_VALUE, 2);
                    return curly12;
                } else {
                    Curly curly14 = curly7;
                    Curly curly15 = new Curly(node2, 0, Integer.MAX_VALUE, 0);
                    return curly14;
                }
            case 43:
                int next4 = next();
                if (next4 == 63) {
                    int next5 = next();
                    Curly curly16 = curly6;
                    Curly curly17 = new Curly(node2, 1, Integer.MAX_VALUE, 1);
                    return curly16;
                } else if (next4 == 43) {
                    int next6 = next();
                    Curly curly18 = curly5;
                    Curly curly19 = new Curly(node2, 1, Integer.MAX_VALUE, 2);
                    return curly18;
                } else {
                    Curly curly20 = curly4;
                    Curly curly21 = new Curly(node2, 1, Integer.MAX_VALUE, 0);
                    return curly20;
                }
            case 63:
                int next7 = next();
                if (next7 == 63) {
                    int next8 = next();
                    Ques ques4 = ques3;
                    Ques ques5 = new Ques(node2, 1);
                    return ques4;
                } else if (next7 == 43) {
                    int next9 = next();
                    Ques ques6 = ques2;
                    Ques ques7 = new Ques(node2, 2);
                    return ques6;
                } else {
                    Ques ques8 = ques;
                    Ques ques9 = new Ques(node2, 0);
                    return ques8;
                }
            case 123:
                int i2 = this.temp[1 + this.cursor];
                if (ASCII.isDigit(i2)) {
                    int skip = skip();
                    int i3 = i2;
                    int i4 = 0;
                    do {
                        i4 = (i4 * 10) + (i3 - 48);
                        i3 = read();
                    } while (ASCII.isDigit(i3));
                    if (i3 == 44) {
                        i3 = read();
                        if (i3 != 125) {
                            int i5 = i3;
                            int i6 = 0;
                            while (ASCII.isDigit(i5)) {
                                i6 = (i6 * 10) + (i5 - 48);
                                i5 = read();
                            }
                            i3 = i5;
                            i = i6;
                        }
                    } else {
                        i = i4;
                    }
                    if (i3 != 125) {
                        throw error("Unclosed counted closure");
                    } else if ((i4 | i | (i - i4)) < 0) {
                        throw error("Illegal repetition range");
                    } else {
                        int peek = peek();
                        if (peek == 63) {
                            int next10 = next();
                            Curly curly22 = curly3;
                            Curly curly23 = new Curly(node2, i4, i, 1);
                            return curly22;
                        } else if (peek == 43) {
                            int next11 = next();
                            Curly curly24 = curly2;
                            Curly curly25 = new Curly(node2, i4, i, 2);
                            return curly24;
                        } else {
                            Curly curly26 = curly;
                            Curly curly27 = new Curly(node2, i4, i, 0);
                            return curly26;
                        }
                    }
                } else {
                    throw error("Illegal repetition");
                }
            default:
                return node2;
        }
    }

    public static Pattern compile(String str) {
        Pattern pattern2;
        Pattern pattern3 = pattern2;
        Pattern pattern4 = new Pattern(str, 0);
        return pattern3;
    }

    public static Pattern compile(String str, int i) {
        Pattern pattern2;
        Pattern pattern3 = pattern2;
        Pattern pattern4 = new Pattern(str, i);
        return pattern3;
    }

    /* JADX WARNING: type inference failed for: r13v0 */
    /* JADX WARNING: type inference failed for: r8v40 */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r9v30, types: [jdkregex.Pattern$Node] */
    /* JADX WARNING: type inference failed for: r13v1 */
    /* JADX WARNING: type inference failed for: r8v43 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r13v2 */
    /* JADX WARNING: type inference failed for: r8v55 */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r9v43, types: [jdkregex.Pattern$Node] */
    /* JADX WARNING: type inference failed for: r13v3 */
    /* JADX WARNING: type inference failed for: r8v58 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 12 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void compile() {
        /*
            r14 = this;
            r0 = r14
            r8 = r0
            r9 = 128(0x80, float:1.794E-43)
            boolean r8 = r8.has(r9)
            if (r8 == 0) goto L_0x0066
            r8 = r0
            r9 = 16
            boolean r8 = r8.has(r9)
            if (r8 != 0) goto L_0x0066
            r8 = r0
            r8.normalize()
        L_0x0017:
            r8 = r0
            r9 = r0
            java.lang.String r9 = r9.normalizedPattern
            int r9 = r9.length()
            r8.patternLength = r9
            r8 = r0
            r9 = 2
            r10 = r0
            int r10 = r10.patternLength
            int r9 = r9 + r10
            int[] r9 = new int[r9]
            r8.temp = r9
            r8 = r0
            r9 = 0
            r8.hasSupplementary = r9
            r8 = 0
            r1 = r8
            r8 = 0
            r2 = r8
        L_0x0033:
            r8 = r1
            r9 = r0
            int r9 = r9.patternLength
            if (r8 >= r9) goto L_0x006d
            r8 = r0
            java.lang.String r8 = r8.normalizedPattern
            r9 = r1
            int r8 = r8.codePointAt(r9)
            r5 = r8
            r8 = r5
            boolean r8 = isSupplementary(r8)
            if (r8 == 0) goto L_0x004d
            r8 = r0
            r9 = 1
            r8.hasSupplementary = r9
        L_0x004d:
            r8 = r0
            int[] r8 = r8.temp
            r6 = r8
            r8 = r2
            r9 = 1
            int r8 = r8 + 1
            r7 = r8
            r8 = r6
            r9 = r2
            r10 = r5
            r8[r9] = r10
            r8 = r1
            r9 = r5
            int r9 = java.lang.Character.charCount(r9)
            int r8 = r8 + r9
            r1 = r8
            r8 = r7
            r2 = r8
            goto L_0x0033
        L_0x0066:
            r8 = r0
            r9 = r0
            java.lang.String r9 = r9.pattern
            r8.normalizedPattern = r9
            goto L_0x0017
        L_0x006d:
            r8 = r0
            r9 = r2
            r8.patternLength = r9
            r8 = r0
            r9 = 16
            boolean r8 = r8.has(r9)
            if (r8 != 0) goto L_0x007e
            r8 = r0
            r8.RemoveQEQuoting()
        L_0x007e:
            r8 = r0
            r9 = 32
            int[] r9 = new int[r9]
            r8.buffer = r9
            r8 = r0
            r9 = 10
            jdkregex.Pattern$GroupHead[] r9 = new jdkregex.Pattern.GroupHead[r9]
            r8.groupNodes = r9
            r8 = r0
            r9 = 0
            r8.namedGroups = r9
            r8 = r0
            r9 = 16
            boolean r8 = r8.has(r9)
            if (r8 == 0) goto L_0x00f4
            r8 = r0
            r9 = r0
            r10 = r0
            int[] r10 = r10.temp
            r11 = r0
            int r11 = r11.patternLength
            r12 = r0
            boolean r12 = r12.hasSupplementary
            jdkregex.Pattern$Node r9 = r9.newSlice(r10, r11, r12)
            r8.matchRoot = r9
            r8 = r0
            jdkregex.Pattern$Node r8 = r8.matchRoot
            jdkregex.Pattern$Node r9 = lastAccept
            r8.next = r9
        L_0x00b1:
            r8 = r0
            jdkregex.Pattern$Node r8 = r8.matchRoot
            boolean r8 = r8 instanceof jdkregex.Pattern.Slice
            if (r8 == 0) goto L_0x012c
            r8 = r0
            r9 = r0
            jdkregex.Pattern$Node r9 = r9.matchRoot
            jdkregex.Pattern$Node r9 = jdkregex.Pattern.BnM.optimize(r9)
            r8.root = r9
            r8 = r0
            jdkregex.Pattern$Node r8 = r8.root
            r9 = r0
            jdkregex.Pattern$Node r9 = r9.matchRoot
            if (r8 != r9) goto L_0x00df
            r8 = r0
            boolean r8 = r8.hasSupplementary
            if (r8 == 0) goto L_0x011f
            jdkregex.Pattern$StartS r8 = new jdkregex.Pattern$StartS
            r13 = r8
            r8 = r13
            r9 = r13
            r10 = r0
            jdkregex.Pattern$Node r10 = r10.matchRoot
            r9.<init>(r10)
            r4 = r8
        L_0x00db:
            r8 = r0
            r9 = r4
            r8.root = r9
        L_0x00df:
            r8 = r0
            r9 = 0
            r8.temp = r9
            r8 = r0
            r9 = 0
            r8.buffer = r9
            r8 = r0
            r9 = 0
            r8.groupNodes = r9
            r8 = r0
            r9 = 0
            r8.patternLength = r9
            r8 = r0
            r9 = 1
            r8.compiled = r9
            return
        L_0x00f4:
            r8 = r0
            r9 = r0
            jdkregex.Pattern$Node r10 = lastAccept
            jdkregex.Pattern$Node r9 = r9.expr(r10)
            r8.matchRoot = r9
            r8 = r0
            int r8 = r8.patternLength
            r9 = r0
            int r9 = r9.cursor
            if (r8 == r9) goto L_0x00b1
            r8 = r0
            int r8 = r8.peek()
            r9 = 41
            if (r8 != r9) goto L_0x0117
            r8 = r0
            java.lang.String r9 = "Unmatched closing ')'"
            jdkregex.PatternSyntaxException r8 = r8.error(r9)
            throw r8
        L_0x0117:
            r8 = r0
            java.lang.String r9 = "Unexpected internal error"
            jdkregex.PatternSyntaxException r8 = r8.error(r9)
            throw r8
        L_0x011f:
            jdkregex.Pattern$Start r8 = new jdkregex.Pattern$Start
            r13 = r8
            r8 = r13
            r9 = r13
            r10 = r0
            jdkregex.Pattern$Node r10 = r10.matchRoot
            r9.<init>(r10)
            r4 = r8
            goto L_0x00db
        L_0x012c:
            r8 = r0
            jdkregex.Pattern$Node r8 = r8.matchRoot
            boolean r8 = r8 instanceof jdkregex.Pattern.Begin
            if (r8 != 0) goto L_0x013a
            r8 = r0
            jdkregex.Pattern$Node r8 = r8.matchRoot
            boolean r8 = r8 instanceof jdkregex.Pattern.First
            if (r8 == 0) goto L_0x0141
        L_0x013a:
            r8 = r0
            r9 = r0
            jdkregex.Pattern$Node r9 = r9.matchRoot
            r8.root = r9
            goto L_0x00df
        L_0x0141:
            r8 = r0
            boolean r8 = r8.hasSupplementary
            if (r8 == 0) goto L_0x0157
            jdkregex.Pattern$StartS r8 = new jdkregex.Pattern$StartS
            r13 = r8
            r8 = r13
            r9 = r13
            r10 = r0
            jdkregex.Pattern$Node r10 = r10.matchRoot
            r9.<init>(r10)
            r3 = r8
        L_0x0152:
            r8 = r0
            r9 = r3
            r8.root = r9
            goto L_0x00df
        L_0x0157:
            jdkregex.Pattern$Start r8 = new jdkregex.Pattern$Start
            r13 = r8
            r8 = r13
            r9 = r13
            r10 = r0
            jdkregex.Pattern$Node r10 = r10.matchRoot
            r9.<init>(r10)
            r3 = r8
            goto L_0x0152
        */
        throw new UnsupportedOperationException("Method not decompiled: jdkregex.Pattern.compile():void");
    }

    private String composeOneStep(String str) {
        StringBuilder sb;
        String str2 = str;
        int countChars = countChars(str2, 0, 2);
        String substring = str2.substring(0, countChars);
        String normalize = Normalizer.normalize(substring, Form.NFC);
        if (normalize.equals(substring)) {
            return null;
        }
        String substring2 = str2.substring(countChars);
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(normalize).append(substring2).toString();
    }

    /* access modifiers changed from: private */
    public static final int countChars(CharSequence charSequence, int i, int i2) {
        AssertionError assertionError;
        int i3;
        AssertionError assertionError2;
        AssertionError assertionError3;
        CharSequence charSequence2 = charSequence;
        int i4 = i;
        int i5 = i2;
        int i6 = 1;
        int i7 = 0;
        if (i5 != 1 || Character.isHighSurrogate(charSequence2.charAt(i4))) {
            int length = charSequence2.length();
            if (i5 >= 0) {
                if ($assertionsDisabled || (i4 >= 0 && i4 < length)) {
                    int i8 = i4;
                    while (true) {
                        i3 = i8;
                        if (i3 >= length || i7 >= i5) {
                            i6 = i3 - i4;
                        } else {
                            int i9 = i3 + 1;
                            if (Character.isHighSurrogate(charSequence2.charAt(i3)) && i9 < length && Character.isLowSurrogate(charSequence2.charAt(i9))) {
                                i9++;
                            }
                            i7++;
                            i8 = i9;
                        }
                    }
                    i6 = i3 - i4;
                } else {
                    AssertionError assertionError4 = assertionError2;
                    AssertionError assertionError5 = new AssertionError();
                    throw assertionError4;
                }
            } else if (!$assertionsDisabled && (i4 < 0 || i4 > length)) {
                AssertionError assertionError6 = assertionError;
                AssertionError assertionError7 = new AssertionError();
                throw assertionError6;
            } else if (i4 == 0) {
                return 0;
            } else {
                int i10 = -i5;
                int i11 = i4;
                while (i11 > 0 && i7 < i10) {
                    i11--;
                    if (Character.isLowSurrogate(charSequence2.charAt(i11)) && i11 > 0 && Character.isHighSurrogate(charSequence2.charAt(i11 - 1))) {
                        i11--;
                    }
                    i7++;
                }
                return i4 - i11;
            }
        } else if (!$assertionsDisabled && (i4 < 0 || i4 >= charSequence2.length())) {
            AssertionError assertionError8 = assertionError3;
            AssertionError assertionError9 = new AssertionError();
            throw assertionError8;
        }
        return i6;
    }

    private static final int countCodePoints(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        int i = 0;
        int length = charSequence2.length();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return i3;
            }
            int i4 = i3 + 1;
            int i5 = i + 1;
            if (!Character.isHighSurrogate(charSequence2.charAt(i)) || i5 >= length || !Character.isLowSurrogate(charSequence2.charAt(i5))) {
                i = i5;
                i2 = i4;
            } else {
                i = i5 + 1;
                i2 = i4;
            }
        }
    }

    private Node createGroup(boolean z) {
        GroupHead groupHead;
        GroupTail groupTail;
        boolean z2 = z;
        int i = this.localCount;
        this.localCount = i + 1;
        int i2 = 0;
        if (!z2) {
            i2 = this.capturingGroupCount;
            this.capturingGroupCount = i2 + 1;
        }
        GroupHead groupHead2 = groupHead;
        GroupHead groupHead3 = new GroupHead(i);
        GroupHead groupHead4 = groupHead2;
        GroupTail groupTail2 = groupTail;
        GroupTail groupTail3 = new GroupTail(i, i2);
        this.root = groupTail2;
        if (!z2 && i2 < 10) {
            this.groupNodes[i2] = groupHead4;
        }
        return groupHead4;
    }

    private int cursor() {
        return this.cursor;
    }

    private PatternSyntaxException error(String str) {
        PatternSyntaxException patternSyntaxException;
        PatternSyntaxException patternSyntaxException2 = patternSyntaxException;
        PatternSyntaxException patternSyntaxException3 = new PatternSyntaxException(str, this.normalizedPattern, -1 + this.cursor);
        return patternSyntaxException2;
    }

    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r11v14 */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r12v4, types: [jdkregex.Pattern$Node] */
    /* JADX WARNING: type inference failed for: r17v2 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r17v3 */
    /* JADX WARNING: type inference failed for: r11v27 */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r12v8, types: [jdkregex.Pattern$Node] */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r11v30 */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r17v8 */
    /* JADX WARNING: type inference failed for: r11v58 */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r12v28, types: [jdkregex.Pattern$Node] */
    /* JADX WARNING: type inference failed for: r17v9 */
    /* JADX WARNING: type inference failed for: r11v61 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 18 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int escape(boolean r19, boolean r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r11 = r0
            int r11 = r11.skip()
            r3 = r11
            r11 = r3
            switch(r11) {
                case 48: goto L_0x0013;
                case 49: goto L_0x001a;
                case 50: goto L_0x001a;
                case 51: goto L_0x001a;
                case 52: goto L_0x001a;
                case 53: goto L_0x001a;
                case 54: goto L_0x001a;
                case 55: goto L_0x001a;
                case 56: goto L_0x001a;
                case 57: goto L_0x001a;
                case 58: goto L_0x0010;
                case 59: goto L_0x0010;
                case 60: goto L_0x0010;
                case 61: goto L_0x0010;
                case 62: goto L_0x0010;
                case 63: goto L_0x0010;
                case 64: goto L_0x0010;
                case 65: goto L_0x0038;
                case 66: goto L_0x004f;
                case 67: goto L_0x001d;
                case 68: goto L_0x006f;
                case 69: goto L_0x001d;
                case 70: goto L_0x001d;
                case 71: goto L_0x00a8;
                case 72: goto L_0x001d;
                case 73: goto L_0x001d;
                case 74: goto L_0x001d;
                case 75: goto L_0x001d;
                case 76: goto L_0x001d;
                case 77: goto L_0x001d;
                case 78: goto L_0x001d;
                case 79: goto L_0x001d;
                case 80: goto L_0x001d;
                case 81: goto L_0x001d;
                case 82: goto L_0x001d;
                case 83: goto L_0x00c0;
                case 84: goto L_0x001d;
                case 85: goto L_0x001d;
                case 86: goto L_0x001d;
                case 87: goto L_0x00f9;
                case 88: goto L_0x001d;
                case 89: goto L_0x001d;
                case 90: goto L_0x0133;
                case 91: goto L_0x0010;
                case 92: goto L_0x0010;
                case 93: goto L_0x0010;
                case 94: goto L_0x0010;
                case 95: goto L_0x0010;
                case 96: goto L_0x0010;
                case 97: goto L_0x0164;
                case 98: goto L_0x0168;
                case 99: goto L_0x0189;
                case 100: goto L_0x0191;
                case 101: goto L_0x01c2;
                case 102: goto L_0x01c7;
                case 103: goto L_0x001d;
                case 104: goto L_0x001d;
                case 105: goto L_0x001d;
                case 106: goto L_0x001d;
                case 107: goto L_0x01cc;
                case 108: goto L_0x001d;
                case 109: goto L_0x001d;
                case 110: goto L_0x0270;
                case 111: goto L_0x001d;
                case 112: goto L_0x001d;
                case 113: goto L_0x001d;
                case 114: goto L_0x0275;
                case 115: goto L_0x027a;
                case 116: goto L_0x02ab;
                case 117: goto L_0x02b0;
                case 118: goto L_0x02b8;
                case 119: goto L_0x02bd;
                case 120: goto L_0x02ef;
                case 121: goto L_0x001d;
                case 122: goto L_0x02f7;
                default: goto L_0x0010;
            }
        L_0x0010:
            r11 = r3
            r0 = r11
        L_0x0012:
            return r0
        L_0x0013:
            r11 = r0
            int r11 = r11.m23o()
            r0 = r11
            goto L_0x0012
        L_0x001a:
            r11 = r1
            if (r11 == 0) goto L_0x0025
        L_0x001d:
            r11 = r0
            java.lang.String r12 = "Illegal/unsupported escape sequence"
            jdkregex.PatternSyntaxException r11 = r11.error(r12)
            throw r11
        L_0x0025:
            r11 = r2
            if (r11 == 0) goto L_0x0035
            r11 = r0
            r12 = r0
            r13 = r3
            r14 = 48
            int r13 = r13 + -48
            jdkregex.Pattern$Node r12 = r12.ref(r13)
            r11.root = r12
        L_0x0035:
            r11 = -1
            r0 = r11
            goto L_0x0012
        L_0x0038:
            r11 = r1
            if (r11 != 0) goto L_0x001d
            r11 = r2
            if (r11 == 0) goto L_0x004c
            r11 = r0
            jdkregex.Pattern$Begin r12 = new jdkregex.Pattern$Begin
            r17 = r12
            r12 = r17
            r13 = r17
            r13.<init>()
            r11.root = r12
        L_0x004c:
            r11 = -1
            r0 = r11
            goto L_0x0012
        L_0x004f:
            r11 = r1
            if (r11 != 0) goto L_0x001d
            r11 = r2
            if (r11 == 0) goto L_0x006c
            r11 = r0
            jdkregex.Pattern$Bound r12 = new jdkregex.Pattern$Bound
            r17 = r12
            r12 = r17
            r13 = r17
            int r14 = jdkregex.Pattern.Bound.NONE
            r15 = r0
            r16 = 256(0x100, float:3.59E-43)
            boolean r15 = r15.has(r16)
            r13.<init>(r14, r15)
            r11.root = r12
        L_0x006c:
            r11 = -1
            r0 = r11
            goto L_0x0012
        L_0x006f:
            r11 = r2
            if (r11 == 0) goto L_0x0091
            r11 = r0
            r12 = 256(0x100, float:3.59E-43)
            boolean r11 = r11.has(r12)
            if (r11 == 0) goto L_0x0095
            jdkregex.Pattern$Utype r11 = new jdkregex.Pattern$Utype
            r17 = r11
            r11 = r17
            r12 = r17
            jdkregex.UnicodeProp r13 = jdkregex.UnicodeProp.DIGIT
            r12.<init>(r13)
            jdkregex.Pattern$CharProperty r11 = r11.complement()
            r10 = r11
        L_0x008d:
            r11 = r0
            r12 = r10
            r11.root = r12
        L_0x0091:
            r11 = -1
            r0 = r11
            goto L_0x0012
        L_0x0095:
            jdkregex.Pattern$Ctype r11 = new jdkregex.Pattern$Ctype
            r17 = r11
            r11 = r17
            r12 = r17
            r13 = 1024(0x400, float:1.435E-42)
            r12.<init>(r13)
            jdkregex.Pattern$CharProperty r11 = r11.complement()
            r10 = r11
            goto L_0x008d
        L_0x00a8:
            r11 = r1
            if (r11 != 0) goto L_0x001d
            r11 = r2
            if (r11 == 0) goto L_0x00bc
            r11 = r0
            jdkregex.Pattern$LastMatch r12 = new jdkregex.Pattern$LastMatch
            r17 = r12
            r12 = r17
            r13 = r17
            r13.<init>()
            r11.root = r12
        L_0x00bc:
            r11 = -1
            r0 = r11
            goto L_0x0012
        L_0x00c0:
            r11 = r2
            if (r11 == 0) goto L_0x00e2
            r11 = r0
            r12 = 256(0x100, float:3.59E-43)
            boolean r11 = r11.has(r12)
            if (r11 == 0) goto L_0x00e6
            jdkregex.Pattern$Utype r11 = new jdkregex.Pattern$Utype
            r17 = r11
            r11 = r17
            r12 = r17
            jdkregex.UnicodeProp r13 = jdkregex.UnicodeProp.WHITE_SPACE
            r12.<init>(r13)
            jdkregex.Pattern$CharProperty r11 = r11.complement()
            r9 = r11
        L_0x00de:
            r11 = r0
            r12 = r9
            r11.root = r12
        L_0x00e2:
            r11 = -1
            r0 = r11
            goto L_0x0012
        L_0x00e6:
            jdkregex.Pattern$Ctype r11 = new jdkregex.Pattern$Ctype
            r17 = r11
            r11 = r17
            r12 = r17
            r13 = 2048(0x800, float:2.87E-42)
            r12.<init>(r13)
            jdkregex.Pattern$CharProperty r11 = r11.complement()
            r9 = r11
            goto L_0x00de
        L_0x00f9:
            r11 = r2
            if (r11 == 0) goto L_0x011b
            r11 = r0
            r12 = 256(0x100, float:3.59E-43)
            boolean r11 = r11.has(r12)
            if (r11 == 0) goto L_0x011f
            jdkregex.Pattern$Utype r11 = new jdkregex.Pattern$Utype
            r17 = r11
            r11 = r17
            r12 = r17
            jdkregex.UnicodeProp r13 = jdkregex.UnicodeProp.WORD
            r12.<init>(r13)
            jdkregex.Pattern$CharProperty r11 = r11.complement()
            r8 = r11
        L_0x0117:
            r11 = r0
            r12 = r8
            r11.root = r12
        L_0x011b:
            r11 = -1
            r0 = r11
            goto L_0x0012
        L_0x011f:
            jdkregex.Pattern$Ctype r11 = new jdkregex.Pattern$Ctype
            r17 = r11
            r11 = r17
            r12 = r17
            r13 = 67328(0x10700, float:9.4347E-41)
            r12.<init>(r13)
            jdkregex.Pattern$CharProperty r11 = r11.complement()
            r8 = r11
            goto L_0x0117
        L_0x0133:
            r11 = r1
            if (r11 != 0) goto L_0x001d
            r11 = r2
            if (r11 == 0) goto L_0x0150
            r11 = r0
            r12 = 1
            boolean r11 = r11.has(r12)
            if (r11 == 0) goto L_0x0154
            r11 = r0
            jdkregex.Pattern$UnixDollar r12 = new jdkregex.Pattern$UnixDollar
            r17 = r12
            r12 = r17
            r13 = r17
            r14 = 0
            r13.<init>(r14)
            r11.root = r12
        L_0x0150:
            r11 = -1
            r0 = r11
            goto L_0x0012
        L_0x0154:
            r11 = r0
            jdkregex.Pattern$Dollar r12 = new jdkregex.Pattern$Dollar
            r17 = r12
            r12 = r17
            r13 = r17
            r14 = 0
            r13.<init>(r14)
            r11.root = r12
            goto L_0x0150
        L_0x0164:
            r11 = 7
            r0 = r11
            goto L_0x0012
        L_0x0168:
            r11 = r1
            if (r11 != 0) goto L_0x001d
            r11 = r2
            if (r11 == 0) goto L_0x0185
            r11 = r0
            jdkregex.Pattern$Bound r12 = new jdkregex.Pattern$Bound
            r17 = r12
            r12 = r17
            r13 = r17
            int r14 = jdkregex.Pattern.Bound.BOTH
            r15 = r0
            r16 = 256(0x100, float:3.59E-43)
            boolean r15 = r15.has(r16)
            r13.<init>(r14, r15)
            r11.root = r12
        L_0x0185:
            r11 = -1
            r0 = r11
            goto L_0x0012
        L_0x0189:
            r11 = r0
            int r11 = r11.m22c()
            r0 = r11
            goto L_0x0012
        L_0x0191:
            r11 = r2
            if (r11 == 0) goto L_0x01af
            r11 = r0
            r12 = 256(0x100, float:3.59E-43)
            boolean r11 = r11.has(r12)
            if (r11 == 0) goto L_0x01b3
            jdkregex.Pattern$Utype r11 = new jdkregex.Pattern$Utype
            r17 = r11
            r11 = r17
            r12 = r17
            jdkregex.UnicodeProp r13 = jdkregex.UnicodeProp.DIGIT
            r12.<init>(r13)
            r7 = r11
        L_0x01ab:
            r11 = r0
            r12 = r7
            r11.root = r12
        L_0x01af:
            r11 = -1
            r0 = r11
            goto L_0x0012
        L_0x01b3:
            jdkregex.Pattern$Ctype r11 = new jdkregex.Pattern$Ctype
            r17 = r11
            r11 = r17
            r12 = r17
            r13 = 1024(0x400, float:1.435E-42)
            r12.<init>(r13)
            r7 = r11
            goto L_0x01ab
        L_0x01c2:
            r11 = 27
            r0 = r11
            goto L_0x0012
        L_0x01c7:
            r11 = 12
            r0 = r11
            goto L_0x0012
        L_0x01cc:
            r11 = r1
            if (r11 != 0) goto L_0x001d
            r11 = r0
            int r11 = r11.read()
            r12 = 60
            if (r11 == r12) goto L_0x01e0
            r11 = r0
            java.lang.String r12 = "\\k is not followed by '<' for named capturing group"
            jdkregex.PatternSyntaxException r11 = r11.error(r12)
            throw r11
        L_0x01e0:
            r11 = r0
            r12 = r0
            int r12 = r12.read()
            java.lang.String r11 = r11.groupname(r12)
            r6 = r11
            r11 = r0
            java.util.Map r11 = r11.namedGroups()
            r12 = r6
            boolean r11 = r11.containsKey(r12)
            if (r11 != 0) goto L_0x021d
            r11 = r0
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r17 = r12
            r12 = r17
            r13 = r17
            r13.<init>()
            java.lang.String r13 = "(named capturing group <"
            java.lang.StringBuilder r12 = r12.append(r13)
            r13 = r6
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r13 = "> does not exit"
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            jdkregex.PatternSyntaxException r11 = r11.error(r12)
            throw r11
        L_0x021d:
            r11 = r2
            if (r11 == 0) goto L_0x024d
            r11 = r0
            r12 = 2
            boolean r11 = r11.has(r12)
            if (r11 == 0) goto L_0x0251
            r11 = r0
            jdkregex.Pattern$CIBackRef r12 = new jdkregex.Pattern$CIBackRef
            r17 = r12
            r12 = r17
            r13 = r17
            r14 = r0
            java.util.Map r14 = r14.namedGroups()
            r15 = r6
            java.lang.Object r14 = r14.get(r15)
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            r15 = r0
            r16 = 64
            boolean r15 = r15.has(r16)
            r13.<init>(r14, r15)
            r11.root = r12
        L_0x024d:
            r11 = -1
            r0 = r11
            goto L_0x0012
        L_0x0251:
            r11 = r0
            jdkregex.Pattern$BackRef r12 = new jdkregex.Pattern$BackRef
            r17 = r12
            r12 = r17
            r13 = r17
            r14 = r0
            java.util.Map r14 = r14.namedGroups()
            r15 = r6
            java.lang.Object r14 = r14.get(r15)
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            r13.<init>(r14)
            r11.root = r12
            goto L_0x024d
        L_0x0270:
            r11 = 10
            r0 = r11
            goto L_0x0012
        L_0x0275:
            r11 = 13
            r0 = r11
            goto L_0x0012
        L_0x027a:
            r11 = r2
            if (r11 == 0) goto L_0x0298
            r11 = r0
            r12 = 256(0x100, float:3.59E-43)
            boolean r11 = r11.has(r12)
            if (r11 == 0) goto L_0x029c
            jdkregex.Pattern$Utype r11 = new jdkregex.Pattern$Utype
            r17 = r11
            r11 = r17
            r12 = r17
            jdkregex.UnicodeProp r13 = jdkregex.UnicodeProp.WHITE_SPACE
            r12.<init>(r13)
            r5 = r11
        L_0x0294:
            r11 = r0
            r12 = r5
            r11.root = r12
        L_0x0298:
            r11 = -1
            r0 = r11
            goto L_0x0012
        L_0x029c:
            jdkregex.Pattern$Ctype r11 = new jdkregex.Pattern$Ctype
            r17 = r11
            r11 = r17
            r12 = r17
            r13 = 2048(0x800, float:2.87E-42)
            r12.<init>(r13)
            r5 = r11
            goto L_0x0294
        L_0x02ab:
            r11 = 9
            r0 = r11
            goto L_0x0012
        L_0x02b0:
            r11 = r0
            int r11 = r11.m24u()
            r0 = r11
            goto L_0x0012
        L_0x02b8:
            r11 = 11
            r0 = r11
            goto L_0x0012
        L_0x02bd:
            r11 = r2
            if (r11 == 0) goto L_0x02db
            r11 = r0
            r12 = 256(0x100, float:3.59E-43)
            boolean r11 = r11.has(r12)
            if (r11 == 0) goto L_0x02df
            jdkregex.Pattern$Utype r11 = new jdkregex.Pattern$Utype
            r17 = r11
            r11 = r17
            r12 = r17
            jdkregex.UnicodeProp r13 = jdkregex.UnicodeProp.WORD
            r12.<init>(r13)
            r4 = r11
        L_0x02d7:
            r11 = r0
            r12 = r4
            r11.root = r12
        L_0x02db:
            r11 = -1
            r0 = r11
            goto L_0x0012
        L_0x02df:
            jdkregex.Pattern$Ctype r11 = new jdkregex.Pattern$Ctype
            r17 = r11
            r11 = r17
            r12 = r17
            r13 = 67328(0x10700, float:9.4347E-41)
            r12.<init>(r13)
            r4 = r11
            goto L_0x02d7
        L_0x02ef:
            r11 = r0
            int r11 = r11.m25x()
            r0 = r11
            goto L_0x0012
        L_0x02f7:
            r11 = r1
            if (r11 != 0) goto L_0x001d
            r11 = r2
            if (r11 == 0) goto L_0x030b
            r11 = r0
            jdkregex.Pattern$End r12 = new jdkregex.Pattern$End
            r17 = r12
            r12 = r17
            r13 = r17
            r13.<init>()
            r11.root = r12
        L_0x030b:
            r11 = -1
            r0 = r11
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: jdkregex.Pattern.escape(boolean, boolean):int");
    }

    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r17v0 */
    /* JADX WARNING: type inference failed for: r12v19 */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r12v21 */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r12v35 */
    /* JADX WARNING: type inference failed for: r0v1, types: [jdkregex.Pattern$Node] */
    /* JADX WARNING: type inference failed for: r12v39 */
    /* JADX WARNING: type inference failed for: r12v42 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private jdkregex.Pattern.Node expr(jdkregex.Pattern.Node r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r12 = 0
            r2 = r12
            r12 = 0
            r3 = r12
            r12 = 0
            r4 = r12
        L_0x000a:
            r12 = r0
            r13 = r1
            jdkregex.Pattern$Node r12 = r12.sequence(r13)
            r5 = r12
            r12 = r0
            jdkregex.Pattern$Node r12 = r12.root
            r6 = r12
            r12 = r4
            if (r12 != 0) goto L_0x0028
            r12 = r6
            r11 = r12
            r12 = r5
            r10 = r12
        L_0x001c:
            r12 = r0
            int r12 = r12.peek()
            r13 = 124(0x7c, float:1.74E-43)
            if (r12 == r13) goto L_0x007d
            r12 = r10
            r0 = r12
            return r0
        L_0x0028:
            r12 = r2
            if (r12 != 0) goto L_0x0087
            jdkregex.Pattern$BranchConn r12 = new jdkregex.Pattern$BranchConn
            r17 = r12
            r12 = r17
            r13 = r17
            r13.<init>()
            r7 = r12
            r12 = r7
            r13 = r1
            r12.next = r13
        L_0x003b:
            r12 = r5
            r13 = r1
            if (r12 != r13) goto L_0x0054
            r12 = 0
            r5 = r12
        L_0x0041:
            r12 = r4
            boolean r12 = r12 instanceof jdkregex.Pattern.Branch
            if (r12 == 0) goto L_0x0059
            r12 = r4
            jdkregex.Pattern$Branch r12 = (jdkregex.Pattern.Branch) r12
            r13 = r5
            r12.add(r13)
            r12 = r7
            r2 = r12
            r12 = r4
            r10 = r12
            r12 = r3
            r11 = r12
            goto L_0x001c
        L_0x0054:
            r12 = r6
            r13 = r7
            r12.next = r13
            goto L_0x0041
        L_0x0059:
            r12 = r4
            r13 = r1
            if (r12 != r13) goto L_0x0076
            r12 = 0
            r8 = r12
        L_0x005f:
            jdkregex.Pattern$Branch r12 = new jdkregex.Pattern$Branch
            r17 = r12
            r12 = r17
            r13 = r17
            r14 = r8
            r15 = r5
            r16 = r7
            r13.<init>(r14, r15, r16)
            r9 = r12
            r12 = r7
            r2 = r12
            r12 = r9
            r10 = r12
            r12 = r3
            r11 = r12
            goto L_0x001c
        L_0x0076:
            r12 = r3
            r13 = r7
            r12.next = r13
            r12 = r4
            r8 = r12
            goto L_0x005f
        L_0x007d:
            r12 = r0
            int r12 = r12.next()
            r12 = r11
            r3 = r12
            r12 = r10
            r4 = r12
            goto L_0x000a
        L_0x0087:
            r12 = r2
            r7 = r12
            goto L_0x003b
        */
        throw new UnsupportedOperationException("Method not decompiled: jdkregex.Pattern.expr(jdkregex.Pattern$Node):jdkregex.Pattern$Node");
    }

    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: type inference failed for: r19v31 */
    /* JADX WARNING: type inference failed for: r19v32 */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r19v34, types: [jdkregex.Pattern$CharProperty] */
    /* JADX WARNING: type inference failed for: r12v1 */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r26v1 */
    /* JADX WARNING: type inference failed for: r19v40 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r19v47 */
    /* JADX WARNING: type inference failed for: r12v4 */
    /* JADX WARNING: type inference failed for: r19v48 */
    /* JADX WARNING: type inference failed for: r19v50, types: [jdkregex.Pattern$CharProperty] */
    /* JADX WARNING: type inference failed for: r12v5 */
    /* JADX WARNING: type inference failed for: r19v52, types: [jdkregex.Pattern$CharProperty] */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r26v2 */
    /* JADX WARNING: type inference failed for: r19v54 */
    /* JADX WARNING: type inference failed for: r12v7 */
    /* JADX WARNING: type inference failed for: r19v56, types: [jdkregex.Pattern$CharProperty] */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r12v9 */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r19v58 */
    /* JADX WARNING: type inference failed for: r2v1, types: [jdkregex.Pattern$CharProperty] */
    /* JADX WARNING: type inference failed for: r19v59 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r19v61, types: [jdkregex.Pattern$CharProperty] */
    /* JADX WARNING: type inference failed for: r19v62, types: [jdkregex.Pattern$CharProperty] */
    /* JADX WARNING: type inference failed for: r12v11 */
    /* JADX WARNING: type inference failed for: r19v64 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r19v74, types: [jdkregex.Pattern$CharProperty] */
    /* JADX WARNING: type inference failed for: r12v12 */
    /* JADX WARNING: type inference failed for: r19v80, types: [jdkregex.Pattern$CharProperty] */
    /* JADX WARNING: type inference failed for: r12v13 */
    /* JADX WARNING: type inference failed for: r19v86, types: [jdkregex.Pattern$CharProperty] */
    /* JADX WARNING: type inference failed for: r12v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 25 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private jdkregex.Pattern.CharProperty family(boolean r28, boolean r29) {
        /*
            r27 = this;
            r2 = r27
            r3 = r28
            r4 = r29
            r19 = r2
            int r19 = r19.next()
            r19 = r3
            if (r19 == 0) goto L_0x00e1
            r19 = r2
            r0 = r19
            int[] r0 = r0.temp
            r19 = r0
            r20 = r2
            r0 = r20
            int r0 = r0.cursor
            r20 = r0
            r19 = r19[r20]
            r18 = r19
            r19 = r18
            boolean r19 = java.lang.Character.isSupplementaryCodePoint(r19)
            if (r19 != 0) goto L_0x00c0
            r19 = r18
            r0 = r19
            char r0 = (char) r0
            r19 = r0
            java.lang.String r19 = java.lang.String.valueOf(r19)
            r8 = r19
        L_0x0039:
            r19 = r2
            int r19 = r19.read()
        L_0x003f:
            r19 = r8
            r20 = 61
            int r19 = r19.indexOf(r20)
            r9 = r19
            r19 = r9
            r20 = -1
            r0 = r19
            r1 = r20
            if (r0 == r1) goto L_0x01de
            r19 = r8
            r20 = r9
            r21 = 1
            int r20 = r20 + 1
            java.lang.String r19 = r19.substring(r20)
            r16 = r19
            r19 = r8
            r20 = 0
            r21 = r9
            java.lang.String r19 = r19.substring(r20, r21)
            java.util.Locale r20 = java.util.Locale.ENGLISH
            java.lang.String r19 = r19.toLowerCase(r20)
            r17 = r19
            java.lang.String r19 = "sc"
            r20 = r17
            boolean r19 = r19.equals(r20)
            if (r19 != 0) goto L_0x0087
            java.lang.String r19 = "script"
            r20 = r17
            boolean r19 = r19.equals(r20)
            if (r19 == 0) goto L_0x0164
        L_0x0087:
            r19 = r2
            r20 = r16
            jdkregex.Pattern$CharProperty r19 = r19.unicodeScriptPropertyFor(r20)
            r12 = r19
        L_0x0091:
            r19 = r4
            if (r19 == 0) goto L_0x00bb
            r19 = r12
            r0 = r19
            boolean r0 = r0 instanceof jdkregex.Pattern.Category
            r19 = r0
            if (r19 != 0) goto L_0x00a9
            r19 = r12
            r0 = r19
            boolean r0 = r0 instanceof jdkregex.Pattern.Block
            r19 = r0
            if (r19 == 0) goto L_0x00b3
        L_0x00a9:
            r19 = r2
            r20 = 1
            r0 = r20
            r1 = r19
            r1.hasSupplementary = r0
        L_0x00b3:
            r19 = r12
            jdkregex.Pattern$CharProperty r19 = r19.complement()
            r12 = r19
        L_0x00bb:
            r19 = r12
            r2 = r19
            return r2
        L_0x00c0:
            java.lang.String r19 = new java.lang.String
            r26 = r19
            r19 = r26
            r20 = r26
            r21 = r2
            r0 = r21
            int[] r0 = r0.temp
            r21 = r0
            r22 = r2
            r0 = r22
            int r0 = r0.cursor
            r22 = r0
            r23 = 1
            r20.<init>(r21, r22, r23)
            r8 = r19
            goto L_0x0039
        L_0x00e1:
            r19 = r2
            r0 = r19
            int r0 = r0.cursor
            r19 = r0
            r6 = r19
            r19 = r2
            r20 = 125(0x7d, float:1.75E-43)
            r19.mark(r20)
        L_0x00f2:
            r19 = r2
            int r19 = r19.read()
            r20 = 125(0x7d, float:1.75E-43)
            r0 = r19
            r1 = r20
            if (r0 != r1) goto L_0x00f2
            r19 = r2
            r20 = 0
            r19.mark(r20)
            r19 = r2
            r0 = r19
            int r0 = r0.cursor
            r19 = r0
            r7 = r19
            r19 = r7
            r20 = r2
            r0 = r20
            int r0 = r0.patternLength
            r20 = r0
            r0 = r19
            r1 = r20
            if (r0 <= r1) goto L_0x012a
            r19 = r2
            java.lang.String r20 = "Unclosed character family"
            jdkregex.PatternSyntaxException r19 = r19.error(r20)
            throw r19
        L_0x012a:
            r19 = r6
            r20 = 1
            int r19 = r19 + 1
            r20 = r7
            r0 = r19
            r1 = r20
            if (r0 < r1) goto L_0x0141
            r19 = r2
            java.lang.String r20 = "Empty character family"
            jdkregex.PatternSyntaxException r19 = r19.error(r20)
            throw r19
        L_0x0141:
            java.lang.String r19 = new java.lang.String
            r26 = r19
            r19 = r26
            r20 = r26
            r21 = r2
            r0 = r21
            int[] r0 = r0.temp
            r21 = r0
            r22 = r6
            r23 = -1
            r24 = r7
            r25 = r6
            int r24 = r24 - r25
            int r23 = r23 + r24
            r20.<init>(r21, r22, r23)
            r8 = r19
            goto L_0x003f
        L_0x0164:
            java.lang.String r19 = "blk"
            r20 = r17
            boolean r19 = r19.equals(r20)
            if (r19 != 0) goto L_0x0178
            java.lang.String r19 = "block"
            r20 = r17
            boolean r19 = r19.equals(r20)
            if (r19 == 0) goto L_0x0184
        L_0x0178:
            r19 = r2
            r20 = r16
            jdkregex.Pattern$CharProperty r19 = r19.unicodeBlockPropertyFor(r20)
            r12 = r19
            goto L_0x0091
        L_0x0184:
            java.lang.String r19 = "gc"
            r20 = r17
            boolean r19 = r19.equals(r20)
            if (r19 != 0) goto L_0x0198
            java.lang.String r19 = "general_category"
            r20 = r17
            boolean r19 = r19.equals(r20)
            if (r19 == 0) goto L_0x01a4
        L_0x0198:
            r19 = r2
            r20 = r16
            jdkregex.Pattern$CharProperty r19 = r19.charPropertyNodeFor(r20)
            r12 = r19
            goto L_0x0091
        L_0x01a4:
            r19 = r2
            java.lang.StringBuilder r20 = new java.lang.StringBuilder
            r26 = r20
            r20 = r26
            r21 = r26
            r21.<init>()
            java.lang.String r21 = "Unknown Unicode property {name=<"
            java.lang.StringBuilder r20 = r20.append(r21)
            r21 = r17
            java.lang.StringBuilder r20 = r20.append(r21)
            java.lang.String r21 = ">, "
            java.lang.StringBuilder r20 = r20.append(r21)
            java.lang.String r21 = "value=<"
            java.lang.StringBuilder r20 = r20.append(r21)
            r21 = r16
            java.lang.StringBuilder r20 = r20.append(r21)
            java.lang.String r21 = ">}"
            java.lang.StringBuilder r20 = r20.append(r21)
            java.lang.String r20 = r20.toString()
            jdkregex.PatternSyntaxException r19 = r19.error(r20)
            throw r19
        L_0x01de:
            r19 = r8
            java.lang.String r20 = "In"
            boolean r19 = r19.startsWith(r20)
            if (r19 == 0) goto L_0x01fa
            r19 = r2
            r20 = r8
            r21 = 2
            java.lang.String r20 = r20.substring(r21)
            jdkregex.Pattern$CharProperty r19 = r19.unicodeBlockPropertyFor(r20)
            r12 = r19
            goto L_0x0091
        L_0x01fa:
            r19 = r8
            java.lang.String r20 = "Is"
            boolean r19 = r19.startsWith(r20)
            if (r19 == 0) goto L_0x0245
            r19 = r8
            r20 = 2
            java.lang.String r19 = r19.substring(r20)
            r14 = r19
            r19 = r14
            jdkregex.UnicodeProp r19 = jdkregex.UnicodeProp.forName(r19)
            r15 = r19
            r19 = r15
            if (r19 == 0) goto L_0x028c
            jdkregex.Pattern$Utype r19 = new jdkregex.Pattern$Utype
            r26 = r19
            r19 = r26
            r20 = r26
            r21 = r15
            r20.<init>(r21)
            r12 = r19
        L_0x0229:
            r19 = r12
            if (r19 != 0) goto L_0x0235
            r19 = r14
            jdkregex.Pattern$CharProperty r19 = jdkregex.Pattern.CharPropertyNames.charPropertyFor(r19)
            r12 = r19
        L_0x0235:
            r19 = r12
            if (r19 != 0) goto L_0x0091
            r19 = r2
            r20 = r14
            jdkregex.Pattern$CharProperty r19 = r19.unicodeScriptPropertyFor(r20)
            r12 = r19
            goto L_0x0091
        L_0x0245:
            r19 = r2
            r20 = 256(0x100, float:3.59E-43)
            boolean r19 = r19.has(r20)
            r10 = r19
            r19 = 0
            r11 = r19
            r19 = r10
            if (r19 == 0) goto L_0x0276
            r19 = r8
            jdkregex.UnicodeProp r19 = jdkregex.UnicodeProp.forPOSIXName(r19)
            r13 = r19
            r19 = 0
            r11 = r19
            r19 = r13
            if (r19 == 0) goto L_0x0276
            jdkregex.Pattern$Utype r19 = new jdkregex.Pattern$Utype
            r26 = r19
            r19 = r26
            r20 = r26
            r21 = r13
            r20.<init>(r21)
            r11 = r19
        L_0x0276:
            r19 = r11
            if (r19 != 0) goto L_0x0286
            r19 = r2
            r20 = r8
            jdkregex.Pattern$CharProperty r19 = r19.charPropertyNodeFor(r20)
            r12 = r19
            goto L_0x0091
        L_0x0286:
            r19 = r11
            r12 = r19
            goto L_0x0091
        L_0x028c:
            r19 = 0
            r12 = r19
            goto L_0x0229
        */
        throw new UnsupportedOperationException("Method not decompiled: jdkregex.Pattern.family(boolean, boolean):jdkregex.Pattern$CharProperty");
    }

    private boolean findSupplementary(int i, int i2) {
        int i3 = i2;
        for (int i4 = i; i4 < i3; i4++) {
            if (isSupplementary(this.temp[i4])) {
                return true;
            }
        }
        return false;
    }

    private int getClass(int i) {
        int i2 = i;
        return 0;
    }

    /* JADX WARNING: type inference failed for: r42v1 */
    /* JADX WARNING: type inference failed for: r33v36 */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: type inference failed for: r35v5, types: [jdkregex.Pattern$Loop] */
    /* JADX WARNING: type inference failed for: r33v40 */
    /* JADX WARNING: type inference failed for: r1v8, types: [jdkregex.Pattern$Loop] */
    /* JADX WARNING: type inference failed for: r33v41 */
    /* JADX WARNING: type inference failed for: r1v9, types: [jdkregex.Pattern$Loop] */
    /* JADX WARNING: type inference failed for: r33v42 */
    /* JADX WARNING: type inference failed for: r1v10, types: [jdkregex.Pattern$Loop] */
    /* JADX WARNING: type inference failed for: r34v23 */
    /* JADX WARNING: type inference failed for: r0v33, types: [jdkregex.Pattern$Node] */
    /* JADX WARNING: type inference failed for: r34v24 */
    /* JADX WARNING: type inference failed for: r0v34, types: [jdkregex.Pattern$Node] */
    /* JADX WARNING: type inference failed for: r42v3 */
    /* JADX WARNING: type inference failed for: r33v47 */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r42v10 */
    /* JADX WARNING: type inference failed for: r33v126 */
    /* JADX WARNING: type inference failed for: r22v1 */
    /* JADX WARNING: type inference failed for: r22v2 */
    /* JADX WARNING: type inference failed for: r33v127 */
    /* JADX WARNING: type inference failed for: r21v1 */
    /* JADX WARNING: type inference failed for: r42v11 */
    /* JADX WARNING: type inference failed for: r33v130 */
    /* JADX WARNING: type inference failed for: r22v3 */
    /* JADX WARNING: type inference failed for: r42v12 */
    /* JADX WARNING: type inference failed for: r33v133 */
    /* JADX WARNING: type inference failed for: r22v4 */
    /* JADX WARNING: type inference failed for: r22v5 */
    /* JADX WARNING: type inference failed for: r33v134 */
    /* JADX WARNING: type inference failed for: r21v2 */
    /* JADX WARNING: type inference failed for: r42v13 */
    /* JADX WARNING: type inference failed for: r33v137 */
    /* JADX WARNING: type inference failed for: r22v6 */
    /* JADX WARNING: type inference failed for: r42v14 */
    /* JADX WARNING: type inference failed for: r33v144 */
    /* JADX WARNING: type inference failed for: r22v7 */
    /* JADX WARNING: type inference failed for: r33v145 */
    /* JADX WARNING: type inference failed for: r21v3 */
    /* JADX WARNING: type inference failed for: r42v15 */
    /* JADX WARNING: type inference failed for: r33v152 */
    /* JADX WARNING: type inference failed for: r22v8 */
    /* JADX WARNING: type inference failed for: r33v153 */
    /* JADX WARNING: type inference failed for: r21v4 */
    /* JADX WARNING: type inference failed for: r42v16 */
    /* JADX WARNING: type inference failed for: r33v156 */
    /* JADX WARNING: type inference failed for: r22v9 */
    /* JADX WARNING: type inference failed for: r33v157 */
    /* JADX WARNING: type inference failed for: r21v5 */
    /* JADX WARNING: type inference failed for: r22v13 */
    /* JADX WARNING: type inference failed for: r22v14 */
    /* JADX WARNING: type inference failed for: r22v15 */
    /* JADX WARNING: type inference failed for: r22v16 */
    /* JADX WARNING: type inference failed for: r22v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 40 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private jdkregex.Pattern.Node group0() {
        /*
            r43 = this;
            r2 = r43
            r33 = 0
            r3 = r33
            r33 = r2
            r0 = r33
            int r0 = r0.flags
            r33 = r0
            r4 = r33
            r33 = r2
            r34 = 0
            r0 = r34
            r1 = r33
            r1.root = r0
            r33 = r2
            int r33 = r33.next()
            r34 = 63
            r0 = r33
            r1 = r34
            if (r0 != r1) goto L_0x0360
            r33 = r2
            int r33 = r33.skip()
            r18 = r33
            r33 = r18
            switch(r33) {
                case 33: goto L_0x00bc;
                case 36: goto L_0x031a;
                case 58: goto L_0x0056;
                case 60: goto L_0x0153;
                case 61: goto L_0x00bc;
                case 62: goto L_0x0118;
                case 64: goto L_0x031a;
                default: goto L_0x0035;
            }
        L_0x0035:
            r33 = r2
            r33.unread()
            r33 = r2
            r33.addFlag()
            r33 = r2
            int r33 = r33.read()
            r32 = r33
            r33 = r32
            r34 = 41
            r0 = r33
            r1 = r34
            if (r0 != r1) goto L_0x0323
            r33 = 0
            r2 = r33
        L_0x0055:
            return r2
        L_0x0056:
            r33 = r2
            r34 = 1
            jdkregex.Pattern$Node r33 = r33.createGroup(r34)
            r21 = r33
            r33 = r2
            r0 = r33
            jdkregex.Pattern$Node r0 = r0.root
            r33 = r0
            r22 = r33
            r33 = r21
            r34 = r2
            r35 = r22
            jdkregex.Pattern$Node r34 = r34.expr(r35)
            r0 = r34
            r1 = r33
            r1.next = r0
        L_0x007a:
            r33 = r22
            r6 = r33
            r33 = r3
            r7 = r33
            r33 = r21
            r5 = r33
        L_0x0086:
            r33 = r2
            r34 = 41
            java.lang.String r35 = "Unclosed group"
            r33.accept(r34, r35)
            r33 = r2
            r34 = r4
            r0 = r34
            r1 = r33
            r1.flags = r0
            r33 = r2
            r34 = r5
            jdkregex.Pattern$Node r33 = r33.closure(r34)
            r8 = r33
            r33 = r8
            r34 = r5
            r0 = r33
            r1 = r34
            if (r0 != r1) goto L_0x038a
            r33 = r2
            r34 = r6
            r0 = r34
            r1 = r33
            r1.root = r0
            r33 = r8
            r2 = r33
            goto L_0x0055
        L_0x00bc:
            r33 = r2
            r34 = 1
            jdkregex.Pattern$Node r33 = r33.createGroup(r34)
            r31 = r33
            r33 = r31
            r34 = r2
            r35 = r2
            r0 = r35
            jdkregex.Pattern$Node r0 = r0.root
            r35 = r0
            jdkregex.Pattern$Node r34 = r34.expr(r35)
            r0 = r34
            r1 = r33
            r1.next = r0
            r33 = r18
            r34 = 61
            r0 = r33
            r1 = r34
            if (r0 != r1) goto L_0x00ff
            jdkregex.Pattern$Pos r33 = new jdkregex.Pattern$Pos
            r42 = r33
            r33 = r42
            r34 = r42
            r35 = r31
            r34.<init>(r35)
            r22 = r33
            r33 = r22
            r21 = r33
            r33 = 0
            r3 = r33
            goto L_0x007a
        L_0x00ff:
            jdkregex.Pattern$Neg r33 = new jdkregex.Pattern$Neg
            r42 = r33
            r33 = r42
            r34 = r42
            r35 = r31
            r34.<init>(r35)
            r22 = r33
            r33 = r22
            r21 = r33
            r33 = 0
            r3 = r33
            goto L_0x007a
        L_0x0118:
            r33 = r2
            r34 = 1
            jdkregex.Pattern$Node r33 = r33.createGroup(r34)
            r30 = r33
            r33 = r30
            r34 = r2
            r35 = r2
            r0 = r35
            jdkregex.Pattern$Node r0 = r0.root
            r35 = r0
            jdkregex.Pattern$Node r34 = r34.expr(r35)
            r0 = r34
            r1 = r33
            r1.next = r0
            jdkregex.Pattern$Ques r33 = new jdkregex.Pattern$Ques
            r42 = r33
            r33 = r42
            r34 = r42
            r35 = r30
            r36 = 3
            r34.<init>(r35, r36)
            r22 = r33
            r33 = r22
            r21 = r33
            r33 = 0
            r3 = r33
            goto L_0x007a
        L_0x0153:
            r33 = r2
            int r33 = r33.read()
            r19 = r33
            r33 = r19
            boolean r33 = jdkregex.ASCII.isLower(r33)
            if (r33 != 0) goto L_0x016b
            r33 = r19
            boolean r33 = jdkregex.ASCII.isUpper(r33)
            if (r33 == 0) goto L_0x01f1
        L_0x016b:
            r33 = r2
            r34 = r19
            java.lang.String r33 = r33.groupname(r34)
            r20 = r33
            r33 = r2
            java.util.Map r33 = r33.namedGroups()
            r34 = r20
            boolean r33 = r33.containsKey(r34)
            if (r33 == 0) goto L_0x01ab
            r33 = r2
            java.lang.StringBuilder r34 = new java.lang.StringBuilder
            r42 = r34
            r34 = r42
            r35 = r42
            r35.<init>()
            java.lang.String r35 = "Named capturing group <"
            java.lang.StringBuilder r34 = r34.append(r35)
            r35 = r20
            java.lang.StringBuilder r34 = r34.append(r35)
            java.lang.String r35 = "> is already defined"
            java.lang.StringBuilder r34 = r34.append(r35)
            java.lang.String r34 = r34.toString()
            jdkregex.PatternSyntaxException r33 = r33.error(r34)
            throw r33
        L_0x01ab:
            r33 = r2
            r34 = 0
            jdkregex.Pattern$Node r33 = r33.createGroup(r34)
            r21 = r33
            r33 = r2
            r0 = r33
            jdkregex.Pattern$Node r0 = r0.root
            r33 = r0
            r22 = r33
            r33 = r2
            java.util.Map r33 = r33.namedGroups()
            r34 = r20
            r35 = -1
            r36 = r2
            r0 = r36
            int r0 = r0.capturingGroupCount
            r36 = r0
            int r35 = r35 + r36
            java.lang.Integer r35 = java.lang.Integer.valueOf(r35)
            java.lang.Object r33 = r33.put(r34, r35)
            r33 = r21
            r34 = r2
            r35 = r22
            jdkregex.Pattern$Node r34 = r34.expr(r35)
            r0 = r34
            r1 = r33
            r1.next = r0
            r33 = 1
            r3 = r33
            goto L_0x007a
        L_0x01f1:
            r33 = r2
            r0 = r33
            int r0 = r0.cursor
            r33 = r0
            r24 = r33
            r33 = r2
            r34 = 1
            jdkregex.Pattern$Node r33 = r33.createGroup(r34)
            r25 = r33
            r33 = r2
            r0 = r33
            jdkregex.Pattern$Node r0 = r0.root
            r33 = r0
            r26 = r33
            r33 = r25
            r34 = r2
            r35 = r26
            jdkregex.Pattern$Node r34 = r34.expr(r35)
            r0 = r34
            r1 = r33
            r1.next = r0
            r33 = r26
            jdkregex.Pattern$Node r34 = lookbehindEnd
            r0 = r34
            r1 = r33
            r1.next = r0
            jdkregex.Pattern$TreeInfo r33 = new jdkregex.Pattern$TreeInfo
            r42 = r33
            r33 = r42
            r34 = r42
            r34.<init>()
            r27 = r33
            r33 = r25
            r34 = r27
            boolean r33 = r33.study(r34)
            r33 = r27
            r0 = r33
            boolean r0 = r0.maxValid
            r33 = r0
            if (r33 != 0) goto L_0x0251
            r33 = r2
            java.lang.String r34 = "Look-behind group does not have an obvious maximum length"
            jdkregex.PatternSyntaxException r33 = r33.error(r34)
            throw r33
        L_0x0251:
            r33 = r2
            r34 = r24
            r35 = r2
            r0 = r35
            int r0 = r0.patternLength
            r35 = r0
            boolean r33 = r33.findSupplementary(r34, r35)
            r29 = r33
            r33 = r19
            r34 = 61
            r0 = r33
            r1 = r34
            if (r0 != r1) goto L_0x02ba
            r33 = r29
            if (r33 == 0) goto L_0x029a
            jdkregex.Pattern$BehindS r33 = new jdkregex.Pattern$BehindS
            r42 = r33
            r33 = r42
            r34 = r42
            r35 = r25
            r36 = r27
            r0 = r36
            int r0 = r0.maxLength
            r36 = r0
            r37 = r27
            r0 = r37
            int r0 = r0.minLength
            r37 = r0
            r34.<init>(r35, r36, r37)
            r22 = r33
        L_0x0290:
            r33 = r22
            r21 = r33
            r33 = 0
            r3 = r33
            goto L_0x007a
        L_0x029a:
            jdkregex.Pattern$Behind r33 = new jdkregex.Pattern$Behind
            r42 = r33
            r33 = r42
            r34 = r42
            r35 = r25
            r36 = r27
            r0 = r36
            int r0 = r0.maxLength
            r36 = r0
            r37 = r27
            r0 = r37
            int r0 = r0.minLength
            r37 = r0
            r34.<init>(r35, r36, r37)
            r22 = r33
            goto L_0x0290
        L_0x02ba:
            r33 = r19
            r34 = 33
            r0 = r33
            r1 = r34
            if (r0 != r1) goto L_0x0311
            r33 = r29
            if (r33 == 0) goto L_0x02f1
            jdkregex.Pattern$NotBehindS r33 = new jdkregex.Pattern$NotBehindS
            r42 = r33
            r33 = r42
            r34 = r42
            r35 = r25
            r36 = r27
            r0 = r36
            int r0 = r0.maxLength
            r36 = r0
            r37 = r27
            r0 = r37
            int r0 = r0.minLength
            r37 = r0
            r34.<init>(r35, r36, r37)
            r22 = r33
        L_0x02e7:
            r33 = r22
            r21 = r33
            r33 = 0
            r3 = r33
            goto L_0x007a
        L_0x02f1:
            jdkregex.Pattern$NotBehind r33 = new jdkregex.Pattern$NotBehind
            r42 = r33
            r33 = r42
            r34 = r42
            r35 = r25
            r36 = r27
            r0 = r36
            int r0 = r0.maxLength
            r36 = r0
            r37 = r27
            r0 = r37
            int r0 = r0.minLength
            r37 = r0
            r34.<init>(r35, r36, r37)
            r22 = r33
            goto L_0x02e7
        L_0x0311:
            r33 = r2
            java.lang.String r34 = "Unknown look-behind group"
            jdkregex.PatternSyntaxException r33 = r33.error(r34)
            throw r33
        L_0x031a:
            r33 = r2
            java.lang.String r34 = "Unknown group type"
            jdkregex.PatternSyntaxException r33 = r33.error(r34)
            throw r33
        L_0x0323:
            r33 = r32
            r34 = 58
            r0 = r33
            r1 = r34
            if (r0 == r1) goto L_0x0336
            r33 = r2
            java.lang.String r34 = "Unknown inline modifier"
            jdkregex.PatternSyntaxException r33 = r33.error(r34)
            throw r33
        L_0x0336:
            r33 = r2
            r34 = 1
            jdkregex.Pattern$Node r33 = r33.createGroup(r34)
            r21 = r33
            r33 = r2
            r0 = r33
            jdkregex.Pattern$Node r0 = r0.root
            r33 = r0
            r22 = r33
            r33 = r21
            r34 = r2
            r35 = r22
            jdkregex.Pattern$Node r34 = r34.expr(r35)
            r0 = r34
            r1 = r33
            r1.next = r0
            r33 = 0
            r3 = r33
            goto L_0x007a
        L_0x0360:
            r33 = r2
            r34 = 0
            jdkregex.Pattern$Node r33 = r33.createGroup(r34)
            r5 = r33
            r33 = r2
            r0 = r33
            jdkregex.Pattern$Node r0 = r0.root
            r33 = r0
            r6 = r33
            r33 = r5
            r34 = r2
            r35 = r6
            jdkregex.Pattern$Node r34 = r34.expr(r35)
            r0 = r34
            r1 = r33
            r1.next = r0
            r33 = 1
            r7 = r33
            goto L_0x0086
        L_0x038a:
            r33 = r5
            r34 = r6
            r0 = r33
            r1 = r34
            if (r0 != r1) goto L_0x03a4
            r33 = r2
            r34 = r8
            r0 = r34
            r1 = r33
            r1.root = r0
            r33 = r8
            r2 = r33
            goto L_0x0055
        L_0x03a4:
            r33 = r8
            r0 = r33
            boolean r0 = r0 instanceof jdkregex.Pattern.Ques
            r33 = r0
            if (r33 == 0) goto L_0x0432
            r33 = r8
            jdkregex.Pattern$Ques r33 = (jdkregex.Pattern.Ques) r33
            r15 = r33
            r33 = r15
            r0 = r33
            int r0 = r0.type
            r33 = r0
            r34 = 2
            r0 = r33
            r1 = r34
            if (r0 != r1) goto L_0x03d4
            r33 = r2
            r34 = r8
            r0 = r34
            r1 = r33
            r1.root = r0
            r33 = r8
            r2 = r33
            goto L_0x0055
        L_0x03d4:
            r33 = r6
            jdkregex.Pattern$BranchConn r34 = new jdkregex.Pattern$BranchConn
            r42 = r34
            r34 = r42
            r35 = r42
            r35.<init>()
            r0 = r34
            r1 = r33
            r1.next = r0
            r33 = r6
            r0 = r33
            jdkregex.Pattern$Node r0 = r0.next
            r33 = r0
            r16 = r33
            r33 = r15
            r0 = r33
            int r0 = r0.type
            r33 = r0
            if (r33 != 0) goto L_0x041e
            jdkregex.Pattern$Branch r33 = new jdkregex.Pattern$Branch
            r42 = r33
            r33 = r42
            r34 = r42
            r35 = r5
            r36 = 0
            r37 = r16
            r34.<init>(r35, r36, r37)
            r17 = r33
        L_0x040e:
            r33 = r2
            r34 = r16
            r0 = r34
            r1 = r33
            r1.root = r0
            r33 = r17
            r2 = r33
            goto L_0x0055
        L_0x041e:
            jdkregex.Pattern$Branch r33 = new jdkregex.Pattern$Branch
            r42 = r33
            r33 = r42
            r34 = r42
            r35 = 0
            r36 = r5
            r37 = r16
            r34.<init>(r35, r36, r37)
            r17 = r33
            goto L_0x040e
        L_0x0432:
            r33 = r8
            r0 = r33
            boolean r0 = r0 instanceof jdkregex.Pattern.Curly
            r33 = r0
            if (r33 == 0) goto L_0x0578
            r33 = r8
            jdkregex.Pattern$Curly r33 = (jdkregex.Pattern.Curly) r33
            r9 = r33
            r33 = r9
            r0 = r33
            int r0 = r0.type
            r33 = r0
            r34 = 2
            r0 = r33
            r1 = r34
            if (r0 != r1) goto L_0x0462
            r33 = r2
            r34 = r8
            r0 = r34
            r1 = r33
            r1.root = r0
            r33 = r8
            r2 = r33
            goto L_0x0055
        L_0x0462:
            r33 = r5
            jdkregex.Pattern$TreeInfo r34 = new jdkregex.Pattern$TreeInfo
            r42 = r34
            r34 = r42
            r35 = r42
            r35.<init>()
            boolean r33 = r33.study(r34)
            if (r33 == 0) goto L_0x04cc
            r33 = r6
            jdkregex.Pattern$GroupTail r33 = (jdkregex.Pattern.GroupTail) r33
            jdkregex.Pattern$GroupCurly r33 = new jdkregex.Pattern$GroupCurly
            r42 = r33
            r33 = r42
            r34 = r42
            r35 = r5
            r0 = r35
            jdkregex.Pattern$Node r0 = r0.next
            r35 = r0
            r36 = r9
            r0 = r36
            int r0 = r0.cmin
            r36 = r0
            r37 = r9
            r0 = r37
            int r0 = r0.cmax
            r37 = r0
            r38 = r9
            r0 = r38
            int r0 = r0.type
            r38 = r0
            r39 = r6
            jdkregex.Pattern$GroupTail r39 = (jdkregex.Pattern.GroupTail) r39
            r0 = r39
            int r0 = r0.localIndex
            r39 = r0
            r40 = r6
            jdkregex.Pattern$GroupTail r40 = (jdkregex.Pattern.GroupTail) r40
            r0 = r40
            int r0 = r0.groupIndex
            r40 = r0
            r41 = r7
            r34.<init>(r35, r36, r37, r38, r39, r40, r41)
            r14 = r33
            r33 = r2
            r34 = r14
            r0 = r34
            r1 = r33
            r1.root = r0
            r33 = r14
            r2 = r33
            goto L_0x0055
        L_0x04cc:
            r33 = r5
            jdkregex.Pattern$GroupHead r33 = (jdkregex.Pattern.GroupHead) r33
            r0 = r33
            int r0 = r0.localIndex
            r33 = r0
            r10 = r33
            r33 = r9
            r0 = r33
            int r0 = r0.type
            r33 = r0
            if (r33 != 0) goto L_0x0560
            jdkregex.Pattern$Loop r33 = new jdkregex.Pattern$Loop
            r42 = r33
            r33 = r42
            r34 = r42
            r35 = r2
            r0 = r35
            int r0 = r0.localCount
            r35 = r0
            r36 = r10
            r34.<init>(r35, r36)
            r11 = r33
        L_0x04f9:
            jdkregex.Pattern$Prolog r33 = new jdkregex.Pattern$Prolog
            r42 = r33
            r33 = r42
            r34 = r42
            r35 = r11
            r34.<init>(r35)
            r12 = r33
            r33 = r2
            r34 = 1
            r35 = r2
            r0 = r35
            int r0 = r0.localCount
            r35 = r0
            int r34 = r34 + r35
            r0 = r34
            r1 = r33
            r1.localCount = r0
            r33 = r11
            r34 = r9
            r0 = r34
            int r0 = r0.cmin
            r34 = r0
            r0 = r34
            r1 = r33
            r1.cmin = r0
            r33 = r11
            r34 = r9
            r0 = r34
            int r0 = r0.cmax
            r34 = r0
            r0 = r34
            r1 = r33
            r1.cmax = r0
            r33 = r11
            r34 = r5
            r0 = r34
            r1 = r33
            r1.body = r0
            r33 = r6
            r34 = r11
            r0 = r34
            r1 = r33
            r1.next = r0
            r33 = r2
            r34 = r11
            r0 = r34
            r1 = r33
            r1.root = r0
            r33 = r12
            r2 = r33
            goto L_0x0055
        L_0x0560:
            jdkregex.Pattern$LazyLoop r33 = new jdkregex.Pattern$LazyLoop
            r42 = r33
            r33 = r42
            r34 = r42
            r35 = r2
            r0 = r35
            int r0 = r0.localCount
            r35 = r0
            r36 = r10
            r34.<init>(r35, r36)
            r11 = r33
            goto L_0x04f9
        L_0x0578:
            r33 = r2
            java.lang.String r34 = "Internal logic error"
            jdkregex.PatternSyntaxException r33 = r33.error(r34)
            throw r33
        */
        throw new UnsupportedOperationException("Method not decompiled: jdkregex.Pattern.group0():jdkregex.Pattern$Node");
    }

    private String groupname(int i) {
        StringBuilder sb;
        int read;
        int i2 = i;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(Character.toChars(i2));
        while (true) {
            read = read();
            if (!ASCII.isLower(read) && !ASCII.isUpper(read) && !ASCII.isDigit(read)) {
                break;
            }
            StringBuilder append2 = sb4.append(Character.toChars(read));
        }
        if (sb4.length() == 0) {
            throw error("named capturing group has 0 length name");
        } else if (read == 62) {
            return sb4.toString();
        } else {
            throw error("named capturing group is missing trailing '>'");
        }
    }

    private boolean has(int i) {
        return (i & this.flags) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean hasBaseCharacter(Matcher matcher, int i, CharSequence charSequence) {
        boolean z;
        Matcher matcher2 = matcher;
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        int i3 = !matcher2.transparentBounds ? matcher2.from : 0;
        while (true) {
            z = false;
            if (i2 < i3) {
                break;
            }
            int codePointAt = Character.codePointAt(charSequence2, i2);
            if (!Character.isLetterOrDigit(codePointAt)) {
                z = false;
                if (Character.getType(codePointAt) != 6) {
                    break;
                }
                i2--;
            } else {
                z = true;
                break;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public static boolean inRange(int i, int i2, int i3) {
        int i4 = i2;
        return i <= i4 && i4 <= i3;
    }

    private static CharProperty intersection(CharProperty charProperty, CharProperty charProperty2) {
        C05616 r6;
        C05616 r2 = r6;
        final CharProperty charProperty3 = charProperty;
        final CharProperty charProperty4 = charProperty2;
        C05616 r3 = new CharProperty() {
            {
                CharProperty charProperty = r7;
            }

            /* access modifiers changed from: 0000 */
            public boolean isSatisfiedBy(int i) {
                int i2 = i;
                return charProperty3.isSatisfiedBy(i2) && charProperty4.isSatisfiedBy(i2);
            }
        };
        return r2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r1 == 133) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isLineSeparator(int r6) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            r3 = r0
            r4 = 1
            boolean r3 = r3.has(r4)
            if (r3 == 0) goto L_0x0015
            r3 = r1
            r4 = 10
            if (r3 != r4) goto L_0x0012
            r3 = 1
            r0 = r3
        L_0x0011:
            return r0
        L_0x0012:
            r3 = 0
            r0 = r3
            goto L_0x0011
        L_0x0015:
            r3 = r1
            r4 = 10
            if (r3 == r4) goto L_0x002e
            r3 = r1
            r4 = 13
            if (r3 == r4) goto L_0x002e
            r3 = r1
            r4 = 1
            r3 = r3 | 1
            r4 = 8233(0x2029, float:1.1537E-41)
            if (r3 == r4) goto L_0x002e
            r3 = 0
            r2 = r3
            r3 = r1
            r4 = 133(0x85, float:1.86E-43)
            if (r3 != r4) goto L_0x0030
        L_0x002e:
            r3 = 1
            r2 = r3
        L_0x0030:
            r3 = r2
            r0 = r3
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: jdkregex.Pattern.isLineSeparator(int):boolean");
    }

    private static final boolean isSupplementary(int i) {
        int i2 = i;
        return i2 >= 65536 || Character.isSurrogate((char) i2);
    }

    private void mark(int i) {
        this.temp[this.patternLength] = i;
    }

    public static boolean matches(String str, CharSequence charSequence) {
        return compile(str).matcher(charSequence).matches();
    }

    private CharProperty newSingle(int i) {
        Single single;
        SingleS singleS;
        SingleI singleI;
        SingleU singleU;
        int i2 = i;
        if (has(2)) {
            if (has(64)) {
                int upperCase = Character.toUpperCase(i2);
                int lowerCase = Character.toLowerCase(upperCase);
                if (upperCase != lowerCase) {
                    SingleU singleU2 = singleU;
                    SingleU singleU3 = new SingleU(lowerCase);
                    return singleU2;
                }
            } else if (ASCII.isAscii(i2)) {
                int lower = ASCII.toLower(i2);
                int upper = ASCII.toUpper(i2);
                if (lower != upper) {
                    SingleI singleI2 = singleI;
                    SingleI singleI3 = new SingleI(lower, upper);
                    return singleI2;
                }
            }
        }
        if (isSupplementary(i2)) {
            SingleS singleS2 = singleS;
            SingleS singleS3 = new SingleS(i2);
            return singleS2;
        }
        Single single2 = single;
        Single single3 = new Single(i2);
        return single2;
    }

    private Node newSlice(int[] iArr, int i, boolean z) {
        Slice slice;
        SliceS sliceS;
        SliceI sliceI;
        SliceIS sliceIS;
        SliceU sliceU;
        SliceUS sliceUS;
        int[] iArr2 = iArr;
        int i2 = i;
        boolean z2 = z;
        int[] iArr3 = new int[i2];
        if (has(2)) {
            int i3 = 0;
            if (has(64)) {
                while (i3 < i2) {
                    iArr3[i3] = Character.toLowerCase(Character.toUpperCase(iArr2[i3]));
                    i3++;
                }
                if (z2) {
                    SliceUS sliceUS2 = sliceUS;
                    SliceUS sliceUS3 = new SliceUS(iArr3);
                    return sliceUS2;
                }
                SliceU sliceU2 = sliceU;
                SliceU sliceU3 = new SliceU(iArr3);
                return sliceU2;
            }
            while (i3 < i2) {
                iArr3[i3] = ASCII.toLower(iArr2[i3]);
                i3++;
            }
            if (z2) {
                SliceIS sliceIS2 = sliceIS;
                SliceIS sliceIS3 = new SliceIS(iArr3);
                return sliceIS2;
            }
            SliceI sliceI2 = sliceI;
            SliceI sliceI3 = new SliceI(iArr3);
            return sliceI2;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            iArr3[i4] = iArr2[i4];
        }
        if (z2) {
            SliceS sliceS2 = sliceS;
            SliceS sliceS3 = new SliceS(iArr3);
            return sliceS2;
        }
        Slice slice2 = slice;
        Slice slice3 = new Slice(iArr3);
        return slice2;
    }

    private int next() {
        int[] iArr = this.temp;
        int i = 1 + this.cursor;
        this.cursor = i;
        int i2 = iArr[i];
        if (has(4)) {
            i2 = peekPastWhitespace(i2);
        }
        return i2;
    }

    private int nextEscaped() {
        int[] iArr = this.temp;
        int i = 1 + this.cursor;
        this.cursor = i;
        return iArr[i];
    }

    private void normalize() {
        StringBuilder sb;
        int i;
        StringBuilder sb2;
        this.normalizedPattern = Normalizer.normalize(this.pattern, Form.NFD);
        this.patternLength = this.normalizedPattern.length();
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder(this.patternLength);
        StringBuilder sb5 = sb3;
        int i2 = 0;
        int i3 = -1;
        while (i2 < this.patternLength) {
            int codePointAt = this.normalizedPattern.codePointAt(i2);
            if (Character.getType(codePointAt) == 6 && i3 != -1) {
                StringBuilder sb6 = sb2;
                StringBuilder sb7 = new StringBuilder();
                StringBuilder sb8 = sb6;
                StringBuilder appendCodePoint = sb8.appendCodePoint(i3);
                StringBuilder appendCodePoint2 = sb8.appendCodePoint(codePointAt);
                i = i2;
                int i4 = codePointAt;
                while (Character.getType(i4) == 6) {
                    i += Character.charCount(i4);
                    if (i >= this.patternLength) {
                        break;
                    }
                    i4 = this.normalizedPattern.codePointAt(i);
                    StringBuilder appendCodePoint3 = sb8.appendCodePoint(i4);
                }
                String produceEquivalentAlternation = produceEquivalentAlternation(sb8.toString());
                sb5.setLength(sb5.length() - Character.charCount(i3));
                StringBuilder append = sb5.append("(?:").append(produceEquivalentAlternation).append(")");
                i3 = i4;
            } else if (codePointAt != 91 || i3 == 92) {
                StringBuilder appendCodePoint4 = sb5.appendCodePoint(codePointAt);
                i3 = codePointAt;
                i = i2;
            } else {
                i3 = codePointAt;
                i = normalizeCharClass(sb5, i2);
            }
            i2 = i + Character.charCount(i3);
        }
        this.normalizedPattern = sb5.toString();
    }

    private int normalizeCharClass(StringBuilder sb, int i) {
        StringBuilder sb2;
        StringBuilder sb3;
        int i2;
        StringBuilder sb4;
        StringBuilder sb5;
        String sb6;
        StringBuilder sb7;
        StringBuilder sb8 = sb;
        int i3 = i;
        StringBuilder sb9 = sb2;
        StringBuilder sb10 = new StringBuilder();
        StringBuilder sb11 = sb9;
        int i4 = i3 + 1;
        StringBuilder append = sb11.append("[");
        int i5 = -1;
        StringBuilder sb12 = null;
        while (true) {
            StringBuilder sb13 = sb12;
            int codePointAt = this.normalizedPattern.codePointAt(i4);
            if (codePointAt != 93 || i5 == 92) {
                if (Character.getType(codePointAt) == 6) {
                    StringBuilder sb14 = sb4;
                    StringBuilder sb15 = new StringBuilder();
                    StringBuilder sb16 = sb14;
                    StringBuilder appendCodePoint = sb16.appendCodePoint(i5);
                    while (Character.getType(codePointAt) == 6) {
                        StringBuilder appendCodePoint2 = sb16.appendCodePoint(codePointAt);
                        i4 += Character.charCount(codePointAt);
                        if (i4 >= this.normalizedPattern.length()) {
                            break;
                        }
                        codePointAt = this.normalizedPattern.codePointAt(i4);
                    }
                    String produceEquivalentAlternation = produceEquivalentAlternation(sb16.toString());
                    sb11.setLength(sb11.length() - Character.charCount(i5));
                    if (sb13 == null) {
                        StringBuilder sb17 = sb5;
                        StringBuilder sb18 = new StringBuilder();
                        sb13 = sb17;
                    }
                    StringBuilder append2 = sb13.append('|');
                    StringBuilder append3 = sb13.append(produceEquivalentAlternation);
                    sb3 = sb13;
                    i2 = codePointAt;
                } else {
                    StringBuilder appendCodePoint3 = sb11.appendCodePoint(codePointAt);
                    i4++;
                    sb3 = sb13;
                    i2 = codePointAt;
                }
                if (i4 == this.normalizedPattern.length()) {
                    throw error("Unclosed character class");
                }
                i5 = i2;
                sb12 = sb3;
            } else {
                StringBuilder append4 = sb11.append((char) codePointAt);
                if (sb13 != null) {
                    StringBuilder sb19 = sb7;
                    StringBuilder sb20 = new StringBuilder();
                    sb6 = sb19.append("(?:").append(sb11.toString()).append(sb13.toString()).append(")").toString();
                } else {
                    sb6 = sb11.toString();
                }
                StringBuilder append5 = sb8.append(sb6);
                return i4;
            }
        }
    }

    /* renamed from: o */
    private int m23o() {
        int read = read();
        if (((read - 48) | (55 - read)) >= 0) {
            int read2 = read();
            if (((read2 - 48) | (55 - read2)) >= 0) {
                int read3 = read();
                if (((read3 - 48) | (55 - read3)) >= 0 && ((read - 48) | (51 - read)) >= 0) {
                    return (64 * (read - 48)) + (8 * (read2 - 48)) + (read3 - 48);
                }
                unread();
                return (8 * (read - 48)) + (read2 - 48);
            }
            unread();
            return read - 48;
        }
        throw error("Illegal octal escape sequence");
    }

    private int parsePastLine() {
        int i;
        int[] iArr = this.temp;
        int i2 = this.cursor;
        this.cursor = i2 + 1;
        int i3 = iArr[i2];
        while (true) {
            i = i3;
            if (i != 0 && !isLineSeparator(i)) {
                int[] iArr2 = this.temp;
                int i4 = this.cursor;
                this.cursor = i4 + 1;
                i3 = iArr2[i4];
            }
        }
        return i;
    }

    private int parsePastWhitespace(int i) {
        int i2 = i;
        while (true) {
            if (!ASCII.isSpace(i2) && i2 != 35) {
                return i2;
            }
            while (ASCII.isSpace(i2)) {
                int[] iArr = this.temp;
                int i3 = this.cursor;
                this.cursor = i3 + 1;
                i2 = iArr[i3];
            }
            if (i2 == 35) {
                i2 = parsePastLine();
            }
        }
    }

    private int peek() {
        int i = this.temp[this.cursor];
        if (has(4)) {
            i = peekPastWhitespace(i);
        }
        return i;
    }

    private int peekPastLine() {
        int i;
        int[] iArr = this.temp;
        int i2 = 1 + this.cursor;
        this.cursor = i2;
        int i3 = iArr[i2];
        while (true) {
            i = i3;
            if (i != 0 && !isLineSeparator(i)) {
                int[] iArr2 = this.temp;
                int i4 = 1 + this.cursor;
                this.cursor = i4;
                i3 = iArr2[i4];
            }
        }
        return i;
    }

    private int peekPastWhitespace(int i) {
        int i2 = i;
        while (true) {
            if (!ASCII.isSpace(i2) && i2 != 35) {
                return i2;
            }
            while (ASCII.isSpace(i2)) {
                int[] iArr = this.temp;
                int i3 = 1 + this.cursor;
                this.cursor = i3;
                i2 = iArr[i3];
            }
            if (i2 == 35) {
                i2 = peekPastLine();
            }
        }
    }

    private static void printObjectTree(Node node) {
        StringBuilder sb;
        Node node2 = node;
        while (node2 != null) {
            if (node2 instanceof Prolog) {
                System.out.println(node2);
                printObjectTree(((Prolog) node2).loop);
                System.out.println("**** end contents prolog loop");
            } else if (node2 instanceof Loop) {
                System.out.println(node2);
                printObjectTree(((Loop) node2).body);
                System.out.println("**** end contents Loop body");
            } else if (node2 instanceof Curly) {
                System.out.println(node2);
                printObjectTree(((Curly) node2).atom);
                System.out.println("**** end contents Curly body");
            } else if (node2 instanceof GroupCurly) {
                System.out.println(node2);
                printObjectTree(((GroupCurly) node2).atom);
                System.out.println("**** end contents GroupCurly body");
            } else if (node2 instanceof GroupTail) {
                System.out.println(node2);
                PrintStream printStream = System.out;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                printStream.println(sb2.append("Tail next is ").append(node2.next).toString());
                return;
            } else {
                System.out.println(node2);
            }
            node2 = node2.next;
            if (node2 != null) {
                System.out.println("->next:");
            }
            if (node2 == accept) {
                System.out.println("Accept Node");
                node2 = null;
            }
        }
    }

    private String produceEquivalentAlternation(String str) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        String str2 = str;
        int countChars = countChars(str2, 0, 1);
        if (str2.length() == countChars) {
            return str2;
        }
        String substring = str2.substring(0, countChars);
        String[] producePermutations = producePermutations(str2.substring(countChars));
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder(str2);
        StringBuilder sb7 = sb5;
        for (int i = 0; i < producePermutations.length; i++) {
            StringBuilder sb8 = sb2;
            StringBuilder sb9 = new StringBuilder();
            String sb10 = sb8.append(substring).append(producePermutations[i]).toString();
            if (i > 0) {
                StringBuilder sb11 = sb7;
                StringBuilder sb12 = sb4;
                StringBuilder sb13 = new StringBuilder();
                StringBuilder append = sb11.append(sb12.append("|").append(sb10).toString());
            }
            String composeOneStep = composeOneStep(sb10);
            if (composeOneStep != null) {
                StringBuilder sb14 = sb7;
                StringBuilder sb15 = sb3;
                StringBuilder sb16 = new StringBuilder();
                StringBuilder append2 = sb14.append(sb15.append("|").append(produceEquivalentAlternation(composeOneStep)).toString());
            }
        }
        return sb7.toString();
    }

    private String[] producePermutations(String str) {
        String[] strArr;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        String str2 = str;
        if (str2.length() == countChars(str2, 0, 1)) {
            strArr = new String[1];
            strArr[0] = str2;
        } else {
            if (str2.length() == countChars(str2, 0, 2)) {
                int codePointAt = Character.codePointAt(str2, 0);
                int codePointAt2 = Character.codePointAt(str2, Character.charCount(codePointAt));
                if (getClass(codePointAt2) == getClass(codePointAt)) {
                    String[] strArr2 = new String[1];
                    String[] strArr3 = strArr2;
                    strArr2[0] = str2;
                    return strArr3;
                }
                StringBuilder sb4 = sb3;
                StringBuilder sb5 = new StringBuilder(2);
                StringBuilder sb6 = sb4;
                StringBuilder appendCodePoint = sb6.appendCodePoint(codePointAt2);
                StringBuilder appendCodePoint2 = sb6.appendCodePoint(codePointAt);
                return new String[]{str2, sb6.toString()};
            }
            int i = 1;
            int countCodePoints = countCodePoints(str2);
            for (int i2 = 1; i2 < countCodePoints; i2++) {
                i *= i2 + 1;
            }
            String[] strArr4 = new String[i];
            int[] iArr = new int[countCodePoints];
            int i3 = 0;
            for (int i4 = 0; i4 < countCodePoints; i4++) {
                int codePointAt3 = Character.codePointAt(str2, i3);
                iArr[i4] = getClass(codePointAt3);
                i3 += Character.charCount(codePointAt3);
            }
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < countCodePoints; i7++) {
                int countChars = countChars(str2, i5, 1);
                int i8 = i7 - 1;
                while (true) {
                    if (i8 >= 0) {
                        if (iArr[i8] == iArr[i7]) {
                            break;
                        }
                        i8--;
                    } else {
                        StringBuilder sb7 = sb;
                        StringBuilder sb8 = new StringBuilder(str2);
                        String[] producePermutations = producePermutations(sb7.delete(i5, i5 + countChars).toString());
                        String substring = str2.substring(i5, i5 + countChars);
                        int i9 = 0;
                        while (i9 < producePermutations.length) {
                            int i10 = i6 + 1;
                            String[] strArr5 = strArr4;
                            int i11 = i6;
                            StringBuilder sb9 = sb2;
                            StringBuilder sb10 = new StringBuilder();
                            strArr5[i11] = sb9.append(substring).append(producePermutations[i9]).toString();
                            i9++;
                            i6 = i10;
                        }
                    }
                }
                i5 += countChars;
            }
            strArr = new String[i6];
            for (int i12 = 0; i12 < i6; i12++) {
                strArr[i12] = strArr4[i12];
            }
        }
        return strArr;
    }

    public static String quote(String str) {
        StringBuilder sb;
        StringBuilder sb2;
        String str2 = str;
        if (str2.indexOf("\\E") == -1) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            return sb3.append("\\Q").append(str2).append("\\E").toString();
        }
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder(2 * str2.length());
        StringBuilder sb7 = sb5;
        StringBuilder append = sb7.append("\\Q");
        int i = 0;
        while (true) {
            int indexOf = str2.indexOf("\\E", i);
            if (indexOf != -1) {
                StringBuilder append2 = sb7.append(str2.substring(i, indexOf));
                i = indexOf + 2;
                StringBuilder append3 = sb7.append("\\E\\\\E\\Q");
            } else {
                StringBuilder append4 = sb7.append(str2.substring(i, str2.length()));
                StringBuilder append5 = sb7.append("\\E");
                return sb7.toString();
            }
        }
    }

    private CharProperty range(BitClass bitClass) {
        int i;
        StringBuilder sb;
        BitClass bitClass2 = bitClass;
        boolean z = true;
        if (peek() == 92) {
            int nextEscaped = nextEscaped();
            if (nextEscaped == 112 || nextEscaped == 80) {
                boolean z2 = nextEscaped == 80;
                if (next() != 123) {
                    unread();
                } else {
                    z = false;
                }
                return family(z, z2);
            }
            unread();
            i = escape(true, true);
            if (i == -1) {
                return (CharProperty) this.root;
            }
        } else {
            i = single();
        }
        if (i >= 0) {
            if (peek() == 45) {
                int i2 = this.temp[1 + this.cursor];
                if (i2 == 91) {
                    return bitsOrSingle(bitClass2, i);
                }
                if (i2 != 93) {
                    int next = next();
                    int single = single();
                    if (single >= i) {
                        return has(2) ? caseInsensitiveRangeFor(i, single) : rangeFor(i, single);
                    }
                    throw error("Illegal character range");
                }
            }
            return bitsOrSingle(bitClass2, i);
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        throw error(sb2.append("Unexpected character '").append((char) i).append("'").toString());
    }

    /* access modifiers changed from: private */
    public static CharProperty rangeFor(int i, int i2) {
        C05561 r6;
        C05561 r2 = r6;
        final int i3 = i;
        final int i4 = i2;
        C05561 r3 = new CharProperty() {
            {
                int i = r7;
            }

            /* access modifiers changed from: 0000 */
            public boolean isSatisfiedBy(int i) {
                return Pattern.inRange(i3, i, i4);
            }
        };
        return r2;
    }

    private int read() {
        int[] iArr = this.temp;
        int i = this.cursor;
        this.cursor = i + 1;
        int i2 = iArr[i];
        if (has(4)) {
            i2 = parsePastWhitespace(i2);
        }
        return i2;
    }

    private int readEscaped() {
        int[] iArr = this.temp;
        int i = this.cursor;
        this.cursor = i + 1;
        return iArr[i];
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Start start;
        objectInputStream.defaultReadObject();
        this.capturingGroupCount = 1;
        this.localCount = 0;
        this.compiled = false;
        if (this.pattern.length() == 0) {
            Start start2 = start;
            Start start3 = new Start(lastAccept);
            this.root = start2;
            this.matchRoot = lastAccept;
            this.compiled = true;
        }
    }

    private Node ref(int i) {
        BackRef backRef;
        CIBackRef cIBackRef;
        boolean z = false;
        int i2 = i;
        while (!z) {
            int peek = peek();
            switch (peek) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    int i3 = (i2 * 10) + (peek - 48);
                    if (-1 + this.capturingGroupCount >= i3) {
                        int read = read();
                        i2 = i3;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                default:
                    z = true;
                    break;
            }
        }
        if (has(2)) {
            CIBackRef cIBackRef2 = cIBackRef;
            CIBackRef cIBackRef3 = new CIBackRef(i2, has(64));
            return cIBackRef2;
        }
        BackRef backRef2 = backRef;
        BackRef backRef3 = new BackRef(i2);
        return backRef2;
    }

    /* JADX WARNING: type inference failed for: r17v17, types: [jdkregex.Pattern$Node] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r21v1 */
    /* JADX WARNING: type inference failed for: r17v25 */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r21v2 */
    /* JADX WARNING: type inference failed for: r17v27 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r21v3 */
    /* JADX WARNING: type inference failed for: r17v29 */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r21v4 */
    /* JADX WARNING: type inference failed for: r17v35 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r21v5 */
    /* JADX WARNING: type inference failed for: r17v37 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r21v6 */
    /* JADX WARNING: type inference failed for: r17v43 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r21v7 */
    /* JADX WARNING: type inference failed for: r17v47 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r21v8 */
    /* JADX WARNING: type inference failed for: r17v49 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r17v59, types: [jdkregex.Pattern$CharProperty] */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r17v66, types: [jdkregex.Pattern$Node] */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r17v68, types: [jdkregex.Pattern$CharProperty] */
    /* JADX WARNING: type inference failed for: r7v11 */
    /* JADX WARNING: type inference failed for: r7v12 */
    /* JADX WARNING: type inference failed for: r18v30, types: [jdkregex.Pattern$Node] */
    /* JADX WARNING: type inference failed for: r17v85, types: [jdkregex.Pattern$Node] */
    /* JADX WARNING: type inference failed for: r7v13 */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        r7 = atom();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0021, code lost:
        r8 = closure(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01fd, code lost:
        r4.next = r8;
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002d, code lost:
        if (r5 != null) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        r4 = r8;
        r5 = r8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 23 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private jdkregex.Pattern.Node sequence(jdkregex.Pattern.Node r23) {
        /*
            r22 = this;
            r2 = r22
            r3 = r23
            r17 = 0
            r4 = r17
            r17 = 0
            r5 = r17
        L_0x000c:
            r17 = r2
            int r17 = r17.peek()
            r6 = r17
            r17 = r6
            switch(r17) {
                case 0: goto L_0x01de;
                case 36: goto L_0x011c;
                case 40: goto L_0x0038;
                case 41: goto L_0x01f4;
                case 42: goto L_0x01ab;
                case 43: goto L_0x01ab;
                case 46: goto L_0x015a;
                case 63: goto L_0x01ab;
                case 91: goto L_0x0062;
                case 92: goto L_0x006d;
                case 93: goto L_0x01a1;
                case 94: goto L_0x00d5;
                case 124: goto L_0x01f4;
                case 125: goto L_0x01a1;
                default: goto L_0x0019;
            }
        L_0x0019:
            r17 = r2
            jdkregex.Pattern$Node r17 = r17.atom()
            r7 = r17
        L_0x0021:
            r17 = r2
            r18 = r7
            jdkregex.Pattern$Node r17 = r17.closure(r18)
            r8 = r17
            r17 = r5
            if (r17 != 0) goto L_0x01fd
            r17 = r8
            r4 = r17
            r17 = r8
            r5 = r17
            goto L_0x000c
        L_0x0038:
            r17 = r2
            jdkregex.Pattern$Node r17 = r17.group0()
            r16 = r17
            r17 = r16
            if (r17 == 0) goto L_0x000c
            r17 = r5
            if (r17 != 0) goto L_0x0057
            r17 = r16
            r5 = r17
        L_0x004c:
            r17 = r2
            r0 = r17
            jdkregex.Pattern$Node r0 = r0.root
            r17 = r0
            r4 = r17
            goto L_0x000c
        L_0x0057:
            r17 = r4
            r18 = r16
            r0 = r18
            r1 = r17
            r1.next = r0
            goto L_0x004c
        L_0x0062:
            r17 = r2
            r18 = 1
            jdkregex.Pattern$CharProperty r17 = r17.clazz(r18)
            r7 = r17
            goto L_0x0021
        L_0x006d:
            r17 = r2
            int r17 = r17.nextEscaped()
            r13 = r17
            r17 = r13
            r18 = 112(0x70, float:1.57E-43)
            r0 = r17
            r1 = r18
            if (r0 == r1) goto L_0x0089
            r17 = r13
            r18 = 80
            r0 = r17
            r1 = r18
            if (r0 != r1) goto L_0x00c6
        L_0x0089:
            r17 = r13
            r18 = 80
            r0 = r17
            r1 = r18
            if (r0 != r1) goto L_0x00bc
            r17 = 1
            r14 = r17
        L_0x0097:
            r17 = r2
            int r17 = r17.next()
            r18 = 123(0x7b, float:1.72E-43)
            r0 = r17
            r1 = r18
            if (r0 == r1) goto L_0x00c1
            r17 = r2
            r17.unread()
            r17 = 1
            r15 = r17
        L_0x00ae:
            r17 = r2
            r18 = r15
            r19 = r14
            jdkregex.Pattern$CharProperty r17 = r17.family(r18, r19)
            r7 = r17
            goto L_0x0021
        L_0x00bc:
            r17 = 0
            r14 = r17
            goto L_0x0097
        L_0x00c1:
            r17 = 0
            r15 = r17
            goto L_0x00ae
        L_0x00c6:
            r17 = r2
            r17.unread()
            r17 = r2
            jdkregex.Pattern$Node r17 = r17.atom()
            r7 = r17
            goto L_0x0021
        L_0x00d5:
            r17 = r2
            int r17 = r17.next()
            r17 = r2
            r18 = 8
            boolean r17 = r17.has(r18)
            if (r17 == 0) goto L_0x010d
            r17 = r2
            r18 = 1
            boolean r17 = r17.has(r18)
            if (r17 == 0) goto L_0x00fe
            jdkregex.Pattern$UnixCaret r17 = new jdkregex.Pattern$UnixCaret
            r21 = r17
            r17 = r21
            r18 = r21
            r18.<init>()
            r7 = r17
            goto L_0x0021
        L_0x00fe:
            jdkregex.Pattern$Caret r17 = new jdkregex.Pattern$Caret
            r21 = r17
            r17 = r21
            r18 = r21
            r18.<init>()
            r7 = r17
            goto L_0x0021
        L_0x010d:
            jdkregex.Pattern$Begin r17 = new jdkregex.Pattern$Begin
            r21 = r17
            r17 = r21
            r18 = r21
            r18.<init>()
            r7 = r17
            goto L_0x0021
        L_0x011c:
            r17 = r2
            int r17 = r17.next()
            r17 = r2
            r18 = 1
            boolean r17 = r17.has(r18)
            if (r17 == 0) goto L_0x0143
            jdkregex.Pattern$UnixDollar r17 = new jdkregex.Pattern$UnixDollar
            r21 = r17
            r17 = r21
            r18 = r21
            r19 = r2
            r20 = 8
            boolean r19 = r19.has(r20)
            r18.<init>(r19)
            r7 = r17
            goto L_0x0021
        L_0x0143:
            jdkregex.Pattern$Dollar r17 = new jdkregex.Pattern$Dollar
            r21 = r17
            r17 = r21
            r18 = r21
            r19 = r2
            r20 = 8
            boolean r19 = r19.has(r20)
            r18.<init>(r19)
            r7 = r17
            goto L_0x0021
        L_0x015a:
            r17 = r2
            int r17 = r17.next()
            r17 = r2
            r18 = 32
            boolean r17 = r17.has(r18)
            if (r17 == 0) goto L_0x0179
            jdkregex.Pattern$All r17 = new jdkregex.Pattern$All
            r21 = r17
            r17 = r21
            r18 = r21
            r18.<init>()
            r7 = r17
            goto L_0x0021
        L_0x0179:
            r17 = r2
            r18 = 1
            boolean r17 = r17.has(r18)
            if (r17 == 0) goto L_0x0192
            jdkregex.Pattern$UnixDot r17 = new jdkregex.Pattern$UnixDot
            r21 = r17
            r17 = r21
            r18 = r21
            r18.<init>()
            r7 = r17
            goto L_0x0021
        L_0x0192:
            jdkregex.Pattern$Dot r17 = new jdkregex.Pattern$Dot
            r21 = r17
            r17 = r21
            r18 = r21
            r18.<init>()
            r7 = r17
            goto L_0x0021
        L_0x01a1:
            r17 = r2
            jdkregex.Pattern$Node r17 = r17.atom()
            r7 = r17
            goto L_0x0021
        L_0x01ab:
            r17 = r2
            int r17 = r17.next()
            r17 = r2
            java.lang.StringBuilder r18 = new java.lang.StringBuilder
            r21 = r18
            r18 = r21
            r19 = r21
            r19.<init>()
            java.lang.String r19 = "Dangling meta character '"
            java.lang.StringBuilder r18 = r18.append(r19)
            r19 = r6
            r0 = r19
            char r0 = (char) r0
            r19 = r0
            java.lang.StringBuilder r18 = r18.append(r19)
            java.lang.String r19 = "'"
            java.lang.StringBuilder r18 = r18.append(r19)
            java.lang.String r18 = r18.toString()
            jdkregex.PatternSyntaxException r17 = r17.error(r18)
            throw r17
        L_0x01de:
            r17 = r2
            r0 = r17
            int r0 = r0.cursor
            r17 = r0
            r18 = r2
            r0 = r18
            int r0 = r0.patternLength
            r18 = r0
            r0 = r17
            r1 = r18
            if (r0 < r1) goto L_0x0019
        L_0x01f4:
            r17 = r5
            if (r17 != 0) goto L_0x020d
            r17 = r3
            r2 = r17
        L_0x01fc:
            return r2
        L_0x01fd:
            r17 = r4
            r18 = r8
            r0 = r18
            r1 = r17
            r1.next = r0
            r17 = r8
            r4 = r17
            goto L_0x000c
        L_0x020d:
            r17 = r4
            r18 = r3
            r0 = r18
            r1 = r17
            r1.next = r0
            r17 = r2
            r18 = r4
            r0 = r18
            r1 = r17
            r1.root = r0
            r17 = r5
            r2 = r17
            goto L_0x01fc
        */
        throw new UnsupportedOperationException("Method not decompiled: jdkregex.Pattern.sequence(jdkregex.Pattern$Node):jdkregex.Pattern$Node");
    }

    private static CharProperty setDifference(CharProperty charProperty, CharProperty charProperty2) {
        C05627 r6;
        C05627 r2 = r6;
        final CharProperty charProperty3 = charProperty2;
        final CharProperty charProperty4 = charProperty;
        C05627 r3 = new CharProperty() {
            {
                CharProperty charProperty = r7;
            }

            /* access modifiers changed from: 0000 */
            public boolean isSatisfiedBy(int i) {
                int i2 = i;
                return !charProperty3.isSatisfiedBy(i2) && charProperty4.isSatisfiedBy(i2);
            }
        };
        return r2;
    }

    private void setcursor(int i) {
        int i2 = i;
        this.cursor = i2;
    }

    private int single() {
        int peek = peek();
        switch (peek) {
            case 92:
                return escape(true, false);
            default:
                int next = next();
                return peek;
        }
    }

    private int skip() {
        int i = this.cursor;
        int i2 = this.temp[i + 1];
        this.cursor = i + 2;
        return i2;
    }

    private void subFlag() {
        int peek = peek();
        while (true) {
            switch (peek) {
                case 85:
                    this.flags = -321 & this.flags;
                    return;
                case 99:
                    this.flags = -129 & this.flags;
                    break;
                case 100:
                    this.flags = -2 & this.flags;
                    break;
                case 105:
                    this.flags = -3 & this.flags;
                    break;
                case 109:
                    this.flags = -9 & this.flags;
                    break;
                case 115:
                    this.flags = -33 & this.flags;
                    break;
                case 117:
                    this.flags = -65 & this.flags;
                    break;
                case 120:
                    this.flags = -5 & this.flags;
                    break;
                default:
                    return;
            }
            peek = next();
        }
    }

    /* renamed from: u */
    private int m24u() {
        int uxxxx = uxxxx();
        if (Character.isHighSurrogate((char) uxxxx)) {
            int cursor2 = cursor();
            if (read() == 92 && read() == 117) {
                int uxxxx2 = uxxxx();
                if (Character.isLowSurrogate((char) uxxxx2)) {
                    uxxxx = Character.toCodePoint((char) uxxxx, (char) uxxxx2);
                }
            }
            setcursor(cursor2);
            return uxxxx;
        }
        return uxxxx;
    }

    private CharProperty unicodeBlockPropertyFor(String str) {
        StringBuilder sb;
        Block block;
        String str2 = str;
        try {
            Block block2 = block;
            Block block3 = new Block(UnicodeBlock.forName(str2));
            return block2;
        } catch (IllegalArgumentException e) {
            IllegalArgumentException illegalArgumentException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            throw error(sb2.append("Unknown character block name {").append(str2).append("}").toString());
        }
    }

    private CharProperty unicodeScriptPropertyFor(String str) {
        StringBuilder sb;
        Script script;
        String str2 = str;
        try {
            Script script2 = script;
            Script script3 = new Script(UnicodeScript.forName(str2));
            return script2;
        } catch (IllegalArgumentException e) {
            IllegalArgumentException illegalArgumentException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            throw error(sb2.append("Unknown character script name {").append(str2).append("}").toString());
        }
    }

    private static CharProperty union(CharProperty charProperty, CharProperty charProperty2) {
        C05605 r6;
        C05605 r2 = r6;
        final CharProperty charProperty3 = charProperty;
        final CharProperty charProperty4 = charProperty2;
        C05605 r3 = new CharProperty() {
            {
                CharProperty charProperty = r7;
            }

            /* access modifiers changed from: 0000 */
            public boolean isSatisfiedBy(int i) {
                int i2 = i;
                return charProperty3.isSatisfiedBy(i2) || charProperty4.isSatisfiedBy(i2);
            }
        };
        return r2;
    }

    private void unread() {
        this.cursor = -1 + this.cursor;
    }

    private int uxxxx() {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int read = read();
            if (!ASCII.isHexDigit(read)) {
                throw error("Illegal Unicode escape sequence");
            }
            i = (i * 16) + ASCII.toDigit(read);
        }
        return i;
    }

    /* renamed from: x */
    private int m25x() {
        int i;
        int read = read();
        if (ASCII.isHexDigit(read)) {
            int read2 = read();
            if (ASCII.isHexDigit(read2)) {
                i = (16 * ASCII.toDigit(read)) + ASCII.toDigit(read2);
            }
            throw error("Illegal hexadecimal escape sequence");
        }
        if (read == 123 && ASCII.isHexDigit(peek())) {
            i = 0;
            do {
                int read3 = read();
                if (ASCII.isHexDigit(read3)) {
                    i = (i << 4) + ASCII.toDigit(read3);
                } else if (read3 != 125) {
                    throw error("Unclosed hexadecimal escape sequence");
                }
            } while (i <= 1114111);
            throw error("Hexadecimal codepoint is too big");
        }
        throw error("Illegal hexadecimal escape sequence");
        return i;
    }

    public int flags() {
        return this.flags;
    }

    public Matcher matcher(CharSequence charSequence) {
        Matcher matcher;
        CharSequence charSequence2 = charSequence;
        if (!this.compiled) {
            synchronized (this) {
                try {
                    if (!this.compiled) {
                        compile();
                    }
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                        throw th2;
                    }
                }
            }
        }
        Matcher matcher2 = matcher;
        Matcher matcher3 = new Matcher(this, charSequence2);
        return matcher2;
    }

    /* access modifiers changed from: 0000 */
    public Map<String, Integer> namedGroups() {
        HashMap hashMap;
        if (this.namedGroups == null) {
            HashMap hashMap2 = hashMap;
            HashMap hashMap3 = new HashMap(2);
            this.namedGroups = hashMap2;
        }
        return this.namedGroups;
    }

    public String pattern() {
        return this.pattern;
    }

    public String[] split(CharSequence charSequence) {
        return split(charSequence, 0);
    }

    public String[] split(CharSequence charSequence, int i) {
        ArrayList arrayList;
        CharSequence charSequence2 = charSequence;
        int i2 = i;
        boolean z = i2 > 0;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        Matcher matcher = matcher(charSequence2);
        int i3 = 0;
        while (matcher.find()) {
            if (!z || arrayList4.size() < i2 - 1) {
                boolean add = arrayList4.add(charSequence2.subSequence(i3, matcher.start()).toString());
                i3 = matcher.end();
            } else if (arrayList4.size() == i2 - 1) {
                boolean add2 = arrayList4.add(charSequence2.subSequence(i3, charSequence2.length()).toString());
                i3 = matcher.end();
            }
        }
        if (i3 == 0) {
            return new String[]{charSequence2.toString()};
        }
        if (!z || arrayList4.size() < i2) {
            boolean add3 = arrayList4.add(charSequence2.subSequence(i3, charSequence2.length()).toString());
        }
        int size = arrayList4.size();
        if (i2 == 0) {
            int i4 = size;
            while (i4 > 0 && ((String) arrayList4.get(i4 - 1)).equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                i4--;
            }
            size = i4;
        }
        return (String[]) arrayList4.subList(0, size).toArray(new String[size]);
    }

    public String toString() {
        return this.pattern;
    }
}
