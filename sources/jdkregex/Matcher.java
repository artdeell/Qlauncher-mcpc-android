package jdkregex;

public final class Matcher implements MatchResult {
    static final int ENDANCHOR = 1;
    static final int NOANCHOR = 0;
    int acceptMode = 0;
    boolean anchoringBounds = true;
    int first = -1;
    int from;
    int[] groups;
    boolean hitEnd;
    int last = 0;
    int lastAppendPosition = 0;
    int[] locals;
    int lookbehindTo;
    int oldLast = -1;
    Pattern parentPattern;
    boolean requireEnd;
    CharSequence text;

    /* renamed from: to */
    int f23to;
    boolean transparentBounds = false;

    Matcher() {
    }

    Matcher(Pattern pattern, CharSequence charSequence) {
        Pattern pattern2 = pattern;
        CharSequence charSequence2 = charSequence;
        this.parentPattern = pattern2;
        this.text = charSequence2;
        this.groups = new int[(2 * Math.max(pattern2.capturingGroupCount, 10))];
        this.locals = new int[pattern2.localCount];
        Matcher reset = reset();
    }

    public static String quoteReplacement(String str) {
        StringBuilder sb;
        String str2 = str;
        if (str2.indexOf(92) == -1 && str2.indexOf(36) == -1) {
            return str2;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        for (int i = 0; i < str2.length(); i++) {
            char charAt = str2.charAt(i);
            if (charAt == '\\' || charAt == '$') {
                StringBuilder append = sb4.append('\\');
            }
            StringBuilder append2 = sb4.append(charAt);
        }
        return sb4.toString();
    }

    public Matcher appendReplacement(StringBuffer stringBuffer, String str) {
        StringBuilder sb;
        int i;
        IllegalArgumentException illegalArgumentException;
        int i2;
        int i3;
        StringBuilder sb2;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        IllegalArgumentException illegalArgumentException4;
        StringBuilder sb3;
        IllegalArgumentException illegalArgumentException5;
        StringBuilder sb4;
        IllegalStateException illegalStateException;
        StringBuffer stringBuffer2 = stringBuffer;
        String str2 = str;
        if (this.first < 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No match available");
            throw illegalStateException2;
        }
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = sb5;
        int i4 = 0;
        while (i4 < str2.length()) {
            char charAt = str2.charAt(i4);
            if (charAt == '\\') {
                int i5 = i4 + 1;
                StringBuilder append = sb7.append(str2.charAt(i5));
                i4 = i5 + 1;
            } else if (charAt == '$') {
                int i6 = i4 + 1;
                char charAt2 = str2.charAt(i6);
                if (charAt2 != '{') {
                    i = charAt2 - '0';
                    if (i >= 0 && i <= 9) {
                        i2 = i6 + 1;
                        boolean z = false;
                        while (!z && i2 < str2.length()) {
                            int charAt3 = 65488 + str2.charAt(i2);
                            if (charAt3 < 0 || charAt3 > 9) {
                                break;
                            }
                            int i7 = charAt3 + (i * 10);
                            if (groupCount() < i7) {
                                z = true;
                                i3 = i2;
                            } else {
                                i3 = i2 + 1;
                                i = i7;
                            }
                            i2 = i3;
                        }
                    } else {
                        IllegalArgumentException illegalArgumentException6 = illegalArgumentException;
                        IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("Illegal group reference");
                        throw illegalArgumentException6;
                    }
                } else {
                    int i8 = i6 + 1;
                    StringBuilder sb8 = sb2;
                    StringBuilder sb9 = new StringBuilder();
                    StringBuilder sb10 = sb8;
                    while (i8 < str2.length()) {
                        charAt2 = str2.charAt(i8);
                        if (!ASCII.isLower(charAt2) && !ASCII.isUpper(charAt2) && !ASCII.isDigit(charAt2)) {
                            break;
                        }
                        StringBuilder append2 = sb10.append(charAt2);
                        i8++;
                    }
                    if (sb10.length() == 0) {
                        IllegalArgumentException illegalArgumentException8 = illegalArgumentException2;
                        IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("named capturing group has 0 length name");
                        throw illegalArgumentException8;
                    } else if (charAt2 != '}') {
                        IllegalArgumentException illegalArgumentException10 = illegalArgumentException3;
                        IllegalArgumentException illegalArgumentException11 = new IllegalArgumentException("named capturing group is missing trailing '}'");
                        throw illegalArgumentException10;
                    } else {
                        String sb11 = sb10.toString();
                        if (ASCII.isDigit(sb11.charAt(0))) {
                            IllegalArgumentException illegalArgumentException12 = illegalArgumentException4;
                            StringBuilder sb12 = sb3;
                            StringBuilder sb13 = new StringBuilder();
                            IllegalArgumentException illegalArgumentException13 = new IllegalArgumentException(sb12.append("capturing group name {").append(sb11).append("} starts with digit character").toString());
                            throw illegalArgumentException12;
                        }
                        if (!this.parentPattern.namedGroups().containsKey(sb11)) {
                            IllegalArgumentException illegalArgumentException14 = illegalArgumentException5;
                            StringBuilder sb14 = sb4;
                            StringBuilder sb15 = new StringBuilder();
                            IllegalArgumentException illegalArgumentException15 = new IllegalArgumentException(sb14.append("No group with name {").append(sb11).append("}").toString());
                            throw illegalArgumentException14;
                        }
                        i2 = i8 + 1;
                        i = ((Integer) this.parentPattern.namedGroups().get(sb11)).intValue();
                    }
                }
                if (!(start(i) == -1 || end(i) == -1)) {
                    StringBuilder append3 = sb7.append(this.text, start(i), end(i));
                }
                i4 = i2;
            } else {
                StringBuilder append4 = sb7.append(charAt);
                i4++;
            }
        }
        StringBuffer append5 = stringBuffer2.append(this.text, this.lastAppendPosition, this.first);
        StringBuffer append6 = stringBuffer2.append(sb7);
        this.lastAppendPosition = this.last;
        return this;
    }

    public StringBuffer appendTail(StringBuffer stringBuffer) {
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer append = stringBuffer2.append(this.text, this.lastAppendPosition, getTextLength());
        return stringBuffer2;
    }

    /* access modifiers changed from: 0000 */
    public char charAt(int i) {
        return this.text.charAt(i);
    }

    public int end() {
        IllegalStateException illegalStateException;
        if (this.first >= 0) {
            return this.last;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("No match available");
        throw illegalStateException2;
    }

    public int end(int i) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        StringBuilder sb;
        IllegalStateException illegalStateException;
        int i2 = i;
        if (this.first < 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No match available");
            throw illegalStateException2;
        } else if (i2 <= groupCount()) {
            return this.groups[1 + (i2 * 2)];
        } else {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException(sb2.append("No group ").append(i2).toString());
            throw indexOutOfBoundsException2;
        }
    }

    public boolean find() {
        boolean z;
        int i = this.last;
        if (i == this.first) {
            i++;
        }
        if (i < this.from) {
            i = this.from;
        }
        if (i > this.f23to) {
            int i2 = 0;
            while (true) {
                z = false;
                if (i2 >= this.groups.length) {
                    break;
                }
                this.groups[i2] = -1;
                i2++;
            }
        } else {
            z = search(i);
        }
        return z;
    }

    public boolean find(int i) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i2 = i;
        int textLength = getTextLength();
        if (i2 < 0 || i2 > textLength) {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException("Illegal start index");
            throw indexOutOfBoundsException2;
        }
        Matcher reset = reset();
        return search(i2);
    }

    /* access modifiers changed from: 0000 */
    public CharSequence getSubSequence(int i, int i2) {
        return this.text.subSequence(i, i2);
    }

    /* access modifiers changed from: 0000 */
    public int getTextLength() {
        return this.text.length();
    }

    public String group() {
        return group(0);
    }

    public String group(int i) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        StringBuilder sb;
        IllegalStateException illegalStateException;
        int i2 = i;
        if (this.first < 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No match found");
            throw illegalStateException2;
        } else if (i2 < 0 || i2 > groupCount()) {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException(sb2.append("No group ").append(i2).toString());
            throw indexOutOfBoundsException2;
        } else if (this.groups[i2 * 2] == -1 || this.groups[1 + (i2 * 2)] == -1) {
            return null;
        } else {
            return getSubSequence(this.groups[i2 * 2], this.groups[1 + (i2 * 2)]).toString();
        }
    }

    public String group(String str) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalStateException illegalStateException;
        NullPointerException nullPointerException;
        String str2 = str;
        if (str2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("Null group name");
            throw nullPointerException2;
        } else if (this.first < 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No match found");
            throw illegalStateException2;
        } else if (!this.parentPattern.namedGroups().containsKey(str2)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("No group with name <").append(str2).append(">").toString());
            throw illegalArgumentException2;
        } else {
            int intValue = ((Integer) this.parentPattern.namedGroups().get(str2)).intValue();
            if (this.groups[intValue * 2] == -1 || this.groups[1 + (intValue * 2)] == -1) {
                return null;
            }
            return getSubSequence(this.groups[intValue * 2], this.groups[1 + (intValue * 2)]).toString();
        }
    }

    public int groupCount() {
        return -1 + this.parentPattern.capturingGroupCount;
    }

    public boolean hasAnchoringBounds() {
        return this.anchoringBounds;
    }

    public boolean hasTransparentBounds() {
        return this.transparentBounds;
    }

    public boolean hitEnd() {
        return this.hitEnd;
    }

    public boolean lookingAt() {
        return match(this.from, 0);
    }

    /* access modifiers changed from: 0000 */
    public boolean match(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        this.hitEnd = false;
        this.requireEnd = false;
        if (i3 < 0) {
            i3 = 0;
        }
        this.first = i3;
        this.oldLast = this.oldLast < 0 ? i3 : this.oldLast;
        for (int i5 = 0; i5 < this.groups.length; i5++) {
            this.groups[i5] = -1;
        }
        this.acceptMode = i4;
        boolean match = this.parentPattern.matchRoot.match(this, i3, this.text);
        if (!match) {
            this.first = -1;
        }
        this.oldLast = this.last;
        return match;
    }

    public boolean matches() {
        return match(this.from, 1);
    }

    public Pattern pattern() {
        return this.parentPattern;
    }

    public Matcher region(int i, int i2) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        IndexOutOfBoundsException indexOutOfBoundsException2;
        IndexOutOfBoundsException indexOutOfBoundsException3;
        int i3 = i;
        int i4 = i2;
        if (i3 < 0 || i3 > getTextLength()) {
            IndexOutOfBoundsException indexOutOfBoundsException4 = indexOutOfBoundsException;
            IndexOutOfBoundsException indexOutOfBoundsException5 = new IndexOutOfBoundsException("start");
            throw indexOutOfBoundsException4;
        } else if (i4 < 0 || i4 > getTextLength()) {
            IndexOutOfBoundsException indexOutOfBoundsException6 = indexOutOfBoundsException2;
            IndexOutOfBoundsException indexOutOfBoundsException7 = new IndexOutOfBoundsException("end");
            throw indexOutOfBoundsException6;
        } else if (i3 > i4) {
            IndexOutOfBoundsException indexOutOfBoundsException8 = indexOutOfBoundsException3;
            IndexOutOfBoundsException indexOutOfBoundsException9 = new IndexOutOfBoundsException("start > end");
            throw indexOutOfBoundsException8;
        } else {
            Matcher reset = reset();
            this.from = i3;
            this.f23to = i4;
            return this;
        }
    }

    public int regionEnd() {
        return this.f23to;
    }

    public int regionStart() {
        return this.from;
    }

    public String replaceAll(String str) {
        StringBuffer stringBuffer;
        String str2 = str;
        Matcher reset = reset();
        if (!find()) {
            return this.text.toString();
        }
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = stringBuffer2;
        do {
            Matcher appendReplacement = appendReplacement(stringBuffer4, str2);
        } while (find());
        StringBuffer appendTail = appendTail(stringBuffer4);
        return stringBuffer4.toString();
    }

    public String replaceFirst(String str) {
        StringBuffer stringBuffer;
        NullPointerException nullPointerException;
        String str2 = str;
        if (str2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("replacement");
            throw nullPointerException2;
        }
        Matcher reset = reset();
        if (!find()) {
            return this.text.toString();
        }
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = stringBuffer2;
        Matcher appendReplacement = appendReplacement(stringBuffer4, str2);
        StringBuffer appendTail = appendTail(stringBuffer4);
        return stringBuffer4.toString();
    }

    public boolean requireEnd() {
        return this.requireEnd;
    }

    public Matcher reset() {
        this.first = -1;
        this.last = 0;
        this.oldLast = -1;
        for (int i = 0; i < this.groups.length; i++) {
            this.groups[i] = -1;
        }
        for (int i2 = 0; i2 < this.locals.length; i2++) {
            this.locals[i2] = -1;
        }
        this.lastAppendPosition = 0;
        this.from = 0;
        this.f23to = getTextLength();
        return this;
    }

    public Matcher reset(CharSequence charSequence) {
        this.text = charSequence;
        return reset();
    }

    /* access modifiers changed from: 0000 */
    public boolean search(int i) {
        int i2 = i;
        this.hitEnd = false;
        this.requireEnd = false;
        if (i2 < 0) {
            i2 = 0;
        }
        this.first = i2;
        this.oldLast = this.oldLast < 0 ? i2 : this.oldLast;
        for (int i3 = 0; i3 < this.groups.length; i3++) {
            this.groups[i3] = -1;
        }
        this.acceptMode = 0;
        boolean match = this.parentPattern.root.match(this, i2, this.text);
        if (!match) {
            this.first = -1;
        }
        this.oldLast = this.last;
        return match;
    }

    public int start() {
        IllegalStateException illegalStateException;
        if (this.first >= 0) {
            return this.first;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("No match available");
        throw illegalStateException2;
    }

    public int start(int i) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        StringBuilder sb;
        IllegalStateException illegalStateException;
        int i2 = i;
        if (this.first < 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No match available");
            throw illegalStateException2;
        } else if (i2 <= groupCount()) {
            return this.groups[i2 * 2];
        } else {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException(sb2.append("No group ").append(i2).toString());
            throw indexOutOfBoundsException2;
        }
    }

    public MatchResult toMatchResult() {
        Matcher matcher;
        Matcher matcher2 = matcher;
        Matcher matcher3 = new Matcher(this.parentPattern, this.text.toString());
        Matcher matcher4 = matcher2;
        matcher4.first = this.first;
        matcher4.last = this.last;
        matcher4.groups = (int[]) this.groups.clone();
        return matcher4;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4 = sb;
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = sb4;
        StringBuilder append = sb6.append("jdkregex.Matcher");
        StringBuilder sb7 = sb6;
        StringBuilder sb8 = sb2;
        StringBuilder sb9 = new StringBuilder();
        StringBuilder append2 = sb7.append(sb8.append("[pattern=").append(pattern()).toString());
        StringBuilder append3 = sb6.append(" region=");
        StringBuilder sb10 = sb6;
        StringBuilder sb11 = sb3;
        StringBuilder sb12 = new StringBuilder();
        StringBuilder append4 = sb10.append(sb11.append(regionStart()).append(",").append(regionEnd()).toString());
        StringBuilder append5 = sb6.append(" lastmatch=");
        if (this.first >= 0 && group() != null) {
            StringBuilder append6 = sb6.append(group());
        }
        StringBuilder append7 = sb6.append("]");
        return sb6.toString();
    }

    public Matcher useAnchoringBounds(boolean z) {
        this.anchoringBounds = z;
        return this;
    }

    public Matcher usePattern(Pattern pattern) {
        int i;
        IllegalArgumentException illegalArgumentException;
        Pattern pattern2 = pattern;
        if (pattern2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Pattern cannot be null");
            throw illegalArgumentException2;
        }
        this.parentPattern = pattern2;
        this.groups = new int[(2 * Math.max(pattern2.capturingGroupCount, 10))];
        this.locals = new int[pattern2.localCount];
        int i2 = 0;
        while (true) {
            if (i2 >= this.groups.length) {
                break;
            }
            this.groups[i2] = -1;
            i2++;
        }
        for (i = 0; i < this.locals.length; i++) {
            this.locals[i] = -1;
        }
        return this;
    }

    public Matcher useTransparentBounds(boolean z) {
        this.transparentBounds = z;
        return this;
    }
}
