package java.awt.datatransfer;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

final class MimeTypeProcessor {
    private static MimeTypeProcessor instance;

    static final class MimeType implements Cloneable, Serializable {
        private static final long serialVersionUID = -6693571907475992044L;
        /* access modifiers changed from: private */
        public Hashtable<String, String> parameters;
        /* access modifiers changed from: private */
        public String primaryType;
        /* access modifiers changed from: private */
        public String subType;
        /* access modifiers changed from: private */
        public Hashtable<String, Object> systemParameters;

        MimeType() {
            this.primaryType = null;
            this.subType = null;
            this.parameters = null;
            this.systemParameters = null;
        }

        MimeType(String str, String str2) {
            Hashtable<String, String> hashtable;
            Hashtable<String, Object> hashtable2;
            String str3 = str2;
            this.primaryType = str;
            this.subType = str3;
            Hashtable<String, String> hashtable3 = hashtable;
            Hashtable<String, String> hashtable4 = new Hashtable<>();
            this.parameters = hashtable3;
            Hashtable<String, Object> hashtable5 = hashtable2;
            Hashtable<String, Object> hashtable6 = new Hashtable<>();
            this.systemParameters = hashtable5;
        }

        /* access modifiers changed from: 0000 */
        public boolean equals(MimeType mimeType) {
            MimeType mimeType2 = mimeType;
            if (mimeType2 == null) {
                return false;
            }
            return getFullType().equals(mimeType2.getFullType());
        }

        /* access modifiers changed from: 0000 */
        public String getPrimaryType() {
            return this.primaryType;
        }

        /* access modifiers changed from: 0000 */
        public String getSubType() {
            return this.subType;
        }

        /* access modifiers changed from: 0000 */
        public String getFullType() {
            StringBuffer stringBuffer;
            StringBuffer stringBuffer2;
            StringBuffer stringBuffer3 = stringBuffer;
            StringBuffer stringBuffer4 = new StringBuffer();
            StringBuffer stringBuffer5 = stringBuffer2;
            StringBuffer stringBuffer6 = new StringBuffer();
            return stringBuffer3.append(stringBuffer5.append(this.primaryType).append("/").toString()).append(this.subType).toString();
        }

        /* access modifiers changed from: 0000 */
        public String getParameter(String str) {
            return (String) this.parameters.get(str);
        }

        /* access modifiers changed from: 0000 */
        public void addParameter(String str, String str2) {
            String str3 = str;
            String str4 = str2;
            if (str4 != null) {
                if (str4.charAt(0) == '\"' && str4.charAt(str4.length() - 1) == '\"') {
                    str4 = str4.substring(1, str4.length() - 2);
                }
                if (str4.length() != 0) {
                    Object put = this.parameters.put(str3, str4);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void removeParameter(String str) {
            String str2 = str;
            Object remove = this.parameters.remove(str2);
        }

        /* access modifiers changed from: 0000 */
        public Object getSystemParameter(String str) {
            return this.systemParameters.get(str);
        }

        /* access modifiers changed from: 0000 */
        public void addSystemParameter(String str, Object obj) {
            String str2 = str;
            Object obj2 = obj;
            Object put = this.systemParameters.put(str2, obj2);
        }

        @SuppressWarnings("unchecked")
        @Override
        public Object clone() {
            MimeType mimeType;
            MimeType mimeType2 = mimeType;
            MimeType mimeType3 = new MimeType(this.primaryType, this.subType);
            MimeType mimeType4 = mimeType2;
            mimeType4.parameters = (Hashtable) this.parameters.clone();
            mimeType4.systemParameters = (Hashtable) this.systemParameters.clone();
            return mimeType4;
        }
    }

    private static final class StringPosition {

        /* renamed from: i */
        int f22i = 0;

        public StringPosition() {
        }
    }

    MimeTypeProcessor() {
    }

    static MimeType parse(String str) {
        MimeType mimeType;
        StringPosition stringPosition;
        MimeTypeProcessor mimeTypeProcessor;
        String str2 = str;
        if (instance == null) {
            MimeTypeProcessor mimeTypeProcessor2 = mimeTypeProcessor;
            MimeTypeProcessor mimeTypeProcessor3 = new MimeTypeProcessor();
            instance = mimeTypeProcessor2;
        }
        MimeType mimeType2 = mimeType;
        MimeType mimeType3 = new MimeType();
        MimeType mimeType4 = mimeType2;
        if (str2 != null) {
            StringPosition stringPosition2 = stringPosition;
            StringPosition stringPosition3 = new StringPosition();
            StringPosition stringPosition4 = stringPosition2;
            retrieveType(str2, mimeType4, stringPosition4);
            retrieveParams(str2, mimeType4, stringPosition4);
        }
        return mimeType4;
    }

    static String assemble(MimeType mimeType) {
        StringBuilder sb;
        MimeType mimeType2 = mimeType;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(mimeType2.getFullType());
        Enumeration keys = mimeType2.parameters.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            String str2 = (String) mimeType2.parameters.get(str);
            StringBuilder append2 = sb4.append("; ");
            StringBuilder append3 = sb4.append(str);
            StringBuilder append4 = sb4.append("=\"");
            StringBuilder append5 = sb4.append(str2);
            StringBuilder append6 = sb4.append('\"');
        }
        return sb4.toString();
    }

    private static void retrieveType(String str, MimeType mimeType, StringPosition stringPosition) {
        IllegalArgumentException illegalArgumentException;
        String str2 = str;
        MimeType mimeType2 = mimeType;
        StringPosition stringPosition2 = stringPosition;
        mimeType2.primaryType = retrieveToken(str2, stringPosition2).toLowerCase();
        stringPosition2.f22i = getNextMeaningfulIndex(str2, stringPosition2.f22i);
        if (stringPosition2.f22i >= str2.length() || str2.charAt(stringPosition2.f22i) != '/') {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        }
        StringPosition stringPosition3 = stringPosition2;
        stringPosition3.f22i++;
        mimeType2.subType = retrieveToken(str2, stringPosition2).toLowerCase();
    }

    private static void retrieveParams(String str, MimeType mimeType, StringPosition stringPosition) {
        Hashtable hashtable;
        Hashtable hashtable2;
        IllegalArgumentException illegalArgumentException;
        String str2 = str;
        MimeType mimeType2 = mimeType;
        StringPosition stringPosition2 = stringPosition;
        MimeType mimeType3 = mimeType2;
        Hashtable hashtable3 = hashtable;
        Hashtable hashtable4 = new Hashtable();
        mimeType3.parameters = hashtable3;
        MimeType mimeType4 = mimeType2;
        Hashtable hashtable5 = hashtable2;
        Hashtable hashtable6 = new Hashtable();
        mimeType4.systemParameters = hashtable5;
        while (true) {
            stringPosition2.f22i = getNextMeaningfulIndex(str2, stringPosition2.f22i);
            if (stringPosition2.f22i < str2.length()) {
                if (str2.charAt(stringPosition2.f22i) != ';') {
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
                    throw illegalArgumentException2;
                }
                StringPosition stringPosition3 = stringPosition2;
                stringPosition3.f22i++;
                retrieveParam(str2, mimeType2, stringPosition2);
            } else {
                return;
            }
        }
    }

    private static void retrieveParam(String str, MimeType mimeType, StringPosition stringPosition) {
        IllegalArgumentException illegalArgumentException;
        String retrieveToken;
        IllegalArgumentException illegalArgumentException2;
        String str2 = str;
        MimeType mimeType2 = mimeType;
        StringPosition stringPosition2 = stringPosition;
        String lowerCase = retrieveToken(str2, stringPosition2).toLowerCase();
        stringPosition2.f22i = getNextMeaningfulIndex(str2, stringPosition2.f22i);
        if (stringPosition2.f22i >= str2.length() || str2.charAt(stringPosition2.f22i) != '=') {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException();
            throw illegalArgumentException3;
        }
        StringPosition stringPosition3 = stringPosition2;
        stringPosition3.f22i++;
        stringPosition2.f22i = getNextMeaningfulIndex(str2, stringPosition2.f22i);
        if (stringPosition2.f22i >= str2.length()) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException();
            throw illegalArgumentException5;
        }
        if (str2.charAt(stringPosition2.f22i) == '\"') {
            retrieveToken = retrieveQuoted(str2, stringPosition2);
        } else {
            retrieveToken = retrieveToken(str2, stringPosition2);
        }
        Object put = mimeType2.parameters.put(lowerCase, retrieveToken);
    }

    private static String retrieveQuoted(String str, StringPosition stringPosition) {
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException;
        String str2 = str;
        StringPosition stringPosition2 = stringPosition;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        boolean z = true;
        StringPosition stringPosition3 = stringPosition2;
        stringPosition3.f22i++;
        do {
            if (str2.charAt(stringPosition2.f22i) != '\"' || !z) {
                String str3 = str2;
                StringPosition stringPosition4 = stringPosition2;
                StringPosition stringPosition5 = stringPosition4;
                int i = stringPosition4.f22i;
                int i2 = i;
                stringPosition5.f22i = i + 1;
                char charAt = str3.charAt(i2);
                if (!z) {
                    z = true;
                } else if (charAt == '\\') {
                    z = false;
                }
                if (z) {
                    StringBuilder append = sb4.append(charAt);
                }
            } else {
                StringPosition stringPosition6 = stringPosition2;
                stringPosition6.f22i++;
                return sb4.toString();
            }
        } while (stringPosition2.f22i != str2.length());
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
        throw illegalArgumentException2;
    }

    private static String retrieveToken(String str, StringPosition stringPosition) {
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException;
        String str2 = str;
        StringPosition stringPosition2 = stringPosition;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        stringPosition2.f22i = getNextMeaningfulIndex(str2, stringPosition2.f22i);
        if (stringPosition2.f22i >= str2.length() || isTSpecialChar(str2.charAt(stringPosition2.f22i))) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        }
        do {
            StringBuilder sb5 = sb4;
            String str3 = str2;
            StringPosition stringPosition3 = stringPosition2;
            StringPosition stringPosition4 = stringPosition3;
            int i = stringPosition3.f22i;
            int i2 = i;
            stringPosition4.f22i = i + 1;
            StringBuilder append = sb5.append(str3.charAt(i2));
            if (stringPosition2.f22i >= str2.length() || !isMeaningfulChar(str2.charAt(stringPosition2.f22i))) {
            }
        } while (!isTSpecialChar(str2.charAt(stringPosition2.f22i)));
        return sb4.toString();
    }

    private static int getNextMeaningfulIndex(String str, int i) {
        String str2 = str;
        int i2 = i;
        while (i2 < str2.length() && !isMeaningfulChar(str2.charAt(i2))) {
            i2++;
        }
        return i2;
    }

    private static boolean isTSpecialChar(char c) {
        char c2 = c;
        return c2 == '(' || c2 == ')' || c2 == '[' || c2 == ']' || c2 == '<' || c2 == '>' || c2 == '@' || c2 == ',' || c2 == ';' || c2 == ':' || c2 == '\\' || c2 == '\"' || c2 == '/' || c2 == '?' || c2 == '=';
    }

    private static boolean isMeaningfulChar(char c) {
        char c2 = c;
        return c2 >= '!' && c2 <= '~';
    }
}
