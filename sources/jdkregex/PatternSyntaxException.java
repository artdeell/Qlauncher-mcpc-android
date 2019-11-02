package jdkregex;

public class PatternSyntaxException extends IllegalArgumentException {

    /* renamed from: nl */
    private static final String f26nl = "\n";
    private static final long serialVersionUID = -3864639126226059218L;
    private final String desc;
    private final int index;
    private final String pattern;

    public PatternSyntaxException(String str, String str2, int i) {
        String str3 = str2;
        int i2 = i;
        this.desc = str;
        this.pattern = str3;
        this.index = i2;
    }

    public String getDescription() {
        return this.desc;
    }

    public int getIndex() {
        return this.index;
    }

    public String getMessage() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append(this.desc);
        if (this.index >= 0) {
            StringBuffer append2 = stringBuffer4.append(" near index ");
            StringBuffer append3 = stringBuffer4.append(this.index);
        }
        StringBuffer append4 = stringBuffer4.append(f26nl);
        StringBuffer append5 = stringBuffer4.append(this.pattern);
        if (this.index >= 0) {
            StringBuffer append6 = stringBuffer4.append(f26nl);
            for (int i = 0; i < this.index; i++) {
                StringBuffer append7 = stringBuffer4.append(' ');
            }
            StringBuffer append8 = stringBuffer4.append('^');
        }
        return stringBuffer4.toString();
    }

    public String getPattern() {
        return this.pattern;
    }
}
