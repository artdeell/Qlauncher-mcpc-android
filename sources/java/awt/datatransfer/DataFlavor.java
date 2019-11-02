package java.awt.datatransfer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.apache.harmony.awt.internal.nls.Messages;

public class DataFlavor implements Externalizable, Cloneable {
    public static final DataFlavor javaFileListFlavor;
    public static final String javaJVMLocalObjectMimeType = "application/x-java-jvm-local-objectref";
    public static final String javaRemoteObjectMimeType = "application/x-java-remote-object";
    public static final String javaSerializedObjectMimeType = "application/x-java-serialized-object";
    @Deprecated
    public static final DataFlavor plainTextFlavor;
    private static DataFlavor plainUnicodeFlavor = null;
    private static final long serialVersionUID = 8367026044764648243L;
    private static final String[] sortedTextFlavors;
    public static final DataFlavor stringFlavor;
    private String humanPresentableName;
    private MimeType mimeInfo;
    private Class<?> representationClass;

    static {
        DataFlavor dataFlavor;
        DataFlavor dataFlavor2;
        DataFlavor dataFlavor3;
        DataFlavor dataFlavor4 = dataFlavor;
        DataFlavor dataFlavor5 = new DataFlavor("text/plain; charset=unicode; class=java.io.InputStream", "Plain Text");
        plainTextFlavor = dataFlavor4;
        DataFlavor dataFlavor6 = dataFlavor2;
        DataFlavor dataFlavor7 = new DataFlavor("application/x-java-serialized-object; class=java.lang.String", "Unicode String");
        stringFlavor = dataFlavor6;
        DataFlavor dataFlavor8 = dataFlavor3;
        DataFlavor dataFlavor9 = new DataFlavor("application/x-java-file-list; class=java.util.List", "application/x-java-file-list");
        javaFileListFlavor = dataFlavor8;
        String[] strArr = new String[16];
        String[] strArr2 = strArr;
        strArr[0] = "text/sgml";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "text/xml";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = "text/html";
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[3] = "text/rtf";
        String[] strArr9 = strArr8;
        String[] strArr10 = strArr9;
        strArr9[4] = "text/enriched";
        String[] strArr11 = strArr10;
        String[] strArr12 = strArr11;
        strArr11[5] = "text/richtext";
        String[] strArr13 = strArr12;
        String[] strArr14 = strArr13;
        strArr13[6] = "text/uri-list";
        String[] strArr15 = strArr14;
        String[] strArr16 = strArr15;
        strArr15[7] = "text/tab-separated-values";
        String[] strArr17 = strArr16;
        String[] strArr18 = strArr17;
        strArr17[8] = "text/t140";
        String[] strArr19 = strArr18;
        String[] strArr20 = strArr19;
        strArr19[9] = "text/rfc822-headers";
        String[] strArr21 = strArr20;
        String[] strArr22 = strArr21;
        strArr21[10] = "text/parityfec";
        String[] strArr23 = strArr22;
        String[] strArr24 = strArr23;
        strArr23[11] = "text/directory";
        String[] strArr25 = strArr24;
        String[] strArr26 = strArr25;
        strArr25[12] = "text/css";
        String[] strArr27 = strArr26;
        String[] strArr28 = strArr27;
        strArr27[13] = "text/calendar";
        String[] strArr29 = strArr28;
        String[] strArr30 = strArr29;
        strArr29[14] = javaSerializedObjectMimeType;
        String[] strArr31 = strArr30;
        String[] strArr32 = strArr31;
        strArr31[15] = "text/plain";
        sortedTextFlavors = strArr32;
    }

    public static final DataFlavor getTextPlainUnicodeFlavor() {
        DataFlavor dataFlavor;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        if (plainUnicodeFlavor == null) {
            DataFlavor dataFlavor2 = dataFlavor;
            StringBuffer stringBuffer3 = stringBuffer;
            StringBuffer stringBuffer4 = new StringBuffer();
            StringBuffer stringBuffer5 = stringBuffer2;
            StringBuffer stringBuffer6 = new StringBuffer();
            DataFlavor dataFlavor3 = new DataFlavor(stringBuffer3.append(stringBuffer5.append("text/plain").append("; charset=unicode").toString()).append("; class=java.io.InputStream").toString(), "Plain Text");
            plainUnicodeFlavor = dataFlavor2;
        }
        return plainUnicodeFlavor;
    }

    protected static final Class<?> tryToLoadClass(String str, ClassLoader classLoader) throws ClassNotFoundException {
        String str2 = str;
        ClassLoader classLoader2 = classLoader;
        try {
            return Class.forName(str2);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            try {
                return ClassLoader.getSystemClassLoader().loadClass(str2);
            } catch (ClassNotFoundException e2) {
                ClassNotFoundException classNotFoundException2 = e2;
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader != null) {
                    try {
                        return contextClassLoader.loadClass(str2);
                    } catch (ClassNotFoundException e3) {
                        ClassNotFoundException classNotFoundException3 = e3;
                        return classLoader2.loadClass(str2);
                    }
                }
                return classLoader2.loadClass(str2);
            }
        }
    }

    private static boolean isCharsetSupported(String str) {
        try {
            return Charset.isSupported(str);
        } catch (IllegalCharsetNameException e) {
            IllegalCharsetNameException illegalCharsetNameException = e;
            return false;
        }
    }

    public DataFlavor() {
        this.mimeInfo = null;
        this.humanPresentableName = null;
        this.representationClass = null;
    }

    public DataFlavor(Class<?> cls, String str) {
        MimeType mimeType;
        Class<?> cls2 = cls;
        String str2 = str;
        MimeType mimeType2 = mimeType;
        MimeType mimeType3 = new MimeType("application", "x-java-serialized-object");
        this.mimeInfo = mimeType2;
        if (str2 != null) {
            this.humanPresentableName = str2;
        } else {
            this.humanPresentableName = javaSerializedObjectMimeType;
        }
        this.mimeInfo.addParameter("class", cls2.getName());
        this.representationClass = cls2;
    }

    public DataFlavor(String str, String str2) {
        IllegalArgumentException illegalArgumentException;
        try {
            init(str, str2, null);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(Messages.getString("awt.16C", (Object) this.mimeInfo.getParameter("class")), classNotFoundException);
            throw illegalArgumentException2;
        }
    }

    public DataFlavor(String str) throws ClassNotFoundException {
        init(str, null, null);
    }

    public DataFlavor(String str, String str2, ClassLoader classLoader) throws ClassNotFoundException {
        init(str, str2, classLoader);
    }

    private void init(String str, String str2, ClassLoader classLoader) throws ClassNotFoundException {
        IllegalArgumentException illegalArgumentException;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        Class<?> loadClass;
        String str3 = str;
        String str4 = str2;
        ClassLoader classLoader2 = classLoader;
        try {
            this.mimeInfo = MimeTypeProcessor.parse(str3);
            if (str4 != null) {
                this.humanPresentableName = str4;
            } else {
                StringBuffer stringBuffer3 = stringBuffer;
                StringBuffer stringBuffer4 = new StringBuffer();
                StringBuffer stringBuffer5 = stringBuffer2;
                StringBuffer stringBuffer6 = new StringBuffer();
                this.humanPresentableName = stringBuffer3.append(stringBuffer5.append(this.mimeInfo.getPrimaryType()).append(ClassPathElement.SEPARATOR_CHAR).toString()).append(this.mimeInfo.getSubType()).toString();
            }
            String parameter = this.mimeInfo.getParameter("class");
            if (parameter == null) {
                parameter = "java.io.InputStream";
                this.mimeInfo.addParameter("class", parameter);
            }
            if (classLoader2 == null) {
                loadClass = Class.forName(parameter);
            } else {
                loadClass = classLoader2.loadClass(parameter);
            }
            this.representationClass = loadClass;
        } catch (IllegalArgumentException e) {
            IllegalArgumentException illegalArgumentException2 = e;
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(Messages.getString("awt.16D", (Object) str3));
            throw illegalArgumentException3;
        }
    }

    private String getCharset() {
        if (this.mimeInfo == null || isCharsetRedundant()) {
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        String parameter = this.mimeInfo.getParameter("charset");
        if (isCharsetRequired() && (parameter == null || parameter.length() == 0)) {
            return "unicode";
        }
        if (parameter == null) {
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        return parameter;
    }

    private boolean isCharsetRequired() {
        String fullType = this.mimeInfo.getFullType();
        return fullType.equals("text/sgml") || fullType.equals("text/xml") || fullType.equals("text/html") || fullType.equals("text/enriched") || fullType.equals("text/richtext") || fullType.equals("text/uri-list") || fullType.equals("text/directory") || fullType.equals("text/css") || fullType.equals("text/calendar") || fullType.equals(javaSerializedObjectMimeType) || fullType.equals("text/plain");
    }

    private boolean isCharsetRedundant() {
        String fullType = this.mimeInfo.getFullType();
        return fullType.equals("text/rtf") || fullType.equals("text/tab-separated-values") || fullType.equals("text/t140") || fullType.equals("text/rfc822-headers") || fullType.equals("text/parityfec");
    }

    /* access modifiers changed from: 0000 */
    public MimeType getMimeInfo() {
        return this.mimeInfo;
    }

    public String getPrimaryType() {
        return this.mimeInfo != null ? this.mimeInfo.getPrimaryType() : null;
    }

    public String getSubType() {
        return this.mimeInfo != null ? this.mimeInfo.getSubType() : null;
    }

    public String getMimeType() {
        return this.mimeInfo != null ? MimeTypeProcessor.assemble(this.mimeInfo) : null;
    }

    public String getParameter(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("humanpresentablename")) {
            return this.humanPresentableName;
        }
        return this.mimeInfo != null ? this.mimeInfo.getParameter(lowerCase) : null;
    }

    public String getHumanPresentableName() {
        return this.humanPresentableName;
    }

    public void setHumanPresentableName(String str) {
        String str2 = str;
        this.humanPresentableName = str2;
    }

    public Class<?> getRepresentationClass() {
        return this.representationClass;
    }

    public final Class<?> getDefaultRepresentationClass() {
        NoClassDefFoundError noClassDefFoundError;
        try {
            return Class.forName("java.io.InputStream");
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError(classNotFoundException.getMessage());
            throw noClassDefFoundError2;
        }
    }

    public final String getDefaultRepresentationClassAsString() {
        return getDefaultRepresentationClass().getName();
    }

    public boolean isRepresentationClassSerializable() {
        NoClassDefFoundError noClassDefFoundError;
        try {
            return Class.forName("java.io.Serializable").isAssignableFrom(this.representationClass);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError(classNotFoundException.getMessage());
            throw noClassDefFoundError2;
        }
    }

    public boolean isRepresentationClassRemote() {
        return false;
    }

    public boolean isRepresentationClassReader() {
        NoClassDefFoundError noClassDefFoundError;
        try {
            return Class.forName("java.io.Reader").isAssignableFrom(this.representationClass);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError(classNotFoundException.getMessage());
            throw noClassDefFoundError2;
        }
    }

    public boolean isRepresentationClassInputStream() {
        NoClassDefFoundError noClassDefFoundError;
        try {
            return Class.forName("java.io.InputStream").isAssignableFrom(this.representationClass);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError(classNotFoundException.getMessage());
            throw noClassDefFoundError2;
        }
    }

    public boolean isRepresentationClassCharBuffer() {
        NoClassDefFoundError noClassDefFoundError;
        try {
            return Class.forName("java.nio.CharBuffer").isAssignableFrom(this.representationClass);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError(classNotFoundException.getMessage());
            throw noClassDefFoundError2;
        }
    }

    public boolean isRepresentationClassByteBuffer() {
        NoClassDefFoundError noClassDefFoundError;
        try {
            return Class.forName("java.nio.ByteBuffer").isAssignableFrom(this.representationClass);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError(classNotFoundException.getMessage());
            throw noClassDefFoundError2;
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public String normalizeMimeTypeParameter(String str, String str2) {
        String str3 = str;
        return str2;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public String normalizeMimeType(String str) {
        return str;
    }

    public final boolean isMimeTypeEqual(DataFlavor dataFlavor) {
        DataFlavor dataFlavor2 = dataFlavor;
        boolean z = this.mimeInfo != null ? this.mimeInfo.equals(dataFlavor2.mimeInfo) : dataFlavor2.mimeInfo == null;
        return z;
    }

    public boolean isMimeTypeEqual(String str) {
        try {
            return this.mimeInfo.equals(MimeTypeProcessor.parse(str));
        } catch (IllegalArgumentException e) {
            IllegalArgumentException illegalArgumentException = e;
            return false;
        }
    }

    public synchronized void writeExternal(ObjectOutput objectOutput) throws IOException {
        ObjectOutput objectOutput2 = objectOutput;
        synchronized (this) {
            objectOutput2.writeObject(this.humanPresentableName);
            objectOutput2.writeObject(this.mimeInfo);
        }
    }

    public synchronized void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        ObjectInput objectInput2 = objectInput;
        synchronized (this) {
            this.humanPresentableName = (String) objectInput2.readObject();
            this.mimeInfo = (MimeType) objectInput2.readObject();
            this.representationClass = this.mimeInfo != null ? Class.forName(this.mimeInfo.getParameter("class")) : null;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DataFlavor dataFlavor;
        DataFlavor dataFlavor2 = dataFlavor;
        DataFlavor dataFlavor3 = new DataFlavor();
        DataFlavor dataFlavor4 = dataFlavor2;
        dataFlavor4.humanPresentableName = this.humanPresentableName;
        dataFlavor4.representationClass = this.representationClass;
        dataFlavor4.mimeInfo = this.mimeInfo != null ? (MimeType) this.mimeInfo.clone() : null;
        return dataFlavor4;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        StringBuffer stringBuffer4;
        StringBuffer stringBuffer5;
        StringBuffer stringBuffer6 = stringBuffer;
        StringBuffer stringBuffer7 = new StringBuffer();
        StringBuffer stringBuffer8 = stringBuffer2;
        StringBuffer stringBuffer9 = new StringBuffer();
        StringBuffer stringBuffer10 = stringBuffer3;
        StringBuffer stringBuffer11 = new StringBuffer();
        StringBuffer stringBuffer12 = stringBuffer4;
        StringBuffer stringBuffer13 = new StringBuffer();
        StringBuffer stringBuffer14 = stringBuffer5;
        StringBuffer stringBuffer15 = new StringBuffer();
        return stringBuffer6.append(stringBuffer8.append(stringBuffer10.append(stringBuffer12.append(stringBuffer14.append(getClass().getName()).append("[MimeType=(").toString()).append(getMimeType()).toString()).append(");humanPresentableName=").toString()).append(this.humanPresentableName).toString()).append("]").toString();
    }

    public boolean isMimeTypeSerializedObject() {
        return isMimeTypeEqual(javaSerializedObjectMimeType);
    }

    @Override
    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 == null || !(obj2 instanceof DataFlavor)) {
            return false;
        }
        return equals((DataFlavor) obj2);
    }

    public boolean equals(DataFlavor dataFlavor) {
        DataFlavor dataFlavor2 = dataFlavor;
        if (dataFlavor2 == this) {
            return true;
        }
        if (dataFlavor2 == null) {
            return false;
        }
        if (this.mimeInfo == null) {
            return dataFlavor2.mimeInfo == null;
        } else if (!this.mimeInfo.equals(dataFlavor2.mimeInfo) || !this.representationClass.equals(dataFlavor2.representationClass)) {
            return false;
        } else {
            if (!this.mimeInfo.getPrimaryType().equals("text") || isUnicodeFlavor()) {
                return true;
            }
            String charset = getCharset();
            String charset2 = dataFlavor2.getCharset();
            if (!isCharsetSupported(charset) || !isCharsetSupported(charset2)) {
                return charset.equalsIgnoreCase(charset2);
            }
            return Charset.forName(charset).equals(Charset.forName(charset2));
        }
    }

    @Deprecated
    public boolean equals(String str) {
        String str2 = str;
        if (str2 == null) {
            return false;
        }
        return isMimeTypeEqual(str2);
    }

    public boolean match(DataFlavor dataFlavor) {
        return equals(dataFlavor);
    }

    @Override
    public int hashCode() {
        return getKeyInfo().hashCode();
    }

    private String getKeyInfo() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        StringBuffer stringBuffer4;
        StringBuffer stringBuffer5 = stringBuffer;
        StringBuffer stringBuffer6 = new StringBuffer();
        StringBuffer stringBuffer7 = stringBuffer2;
        StringBuffer stringBuffer8 = new StringBuffer();
        String stringBuffer9 = stringBuffer5.append(stringBuffer7.append(this.mimeInfo.getFullType()).append(";class=").toString()).append(this.representationClass.getName()).toString();
        if (!this.mimeInfo.getPrimaryType().equals("text") || isUnicodeFlavor()) {
            return stringBuffer9;
        }
        StringBuffer stringBuffer10 = stringBuffer3;
        StringBuffer stringBuffer11 = new StringBuffer();
        StringBuffer stringBuffer12 = stringBuffer4;
        StringBuffer stringBuffer13 = new StringBuffer();
        return stringBuffer10.append(stringBuffer12.append(stringBuffer9).append(";charset=").toString()).append(getCharset().toLowerCase()).toString();
    }

    public boolean isFlavorSerializedObjectType() {
        return isMimeTypeSerializedObject() && isRepresentationClassSerializable();
    }

    public boolean isFlavorRemoteObjectType() {
        return isMimeTypeEqual(javaRemoteObjectMimeType) && isRepresentationClassRemote();
    }

    public boolean isFlavorJavaFileListType() {
        NoClassDefFoundError noClassDefFoundError;
        try {
            return Class.forName("java.util.List").isAssignableFrom(this.representationClass) && isMimeTypeEqual(javaFileListFlavor);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError(classNotFoundException.getMessage());
            throw noClassDefFoundError2;
        }
    }

    public boolean isFlavorTextType() {
        if (equals(stringFlavor) || equals(plainTextFlavor)) {
            return true;
        }
        if (this.mimeInfo != null && !this.mimeInfo.getPrimaryType().equals("text")) {
            return false;
        }
        String charset = getCharset();
        if (!isByteCodeFlavor()) {
            return isUnicodeFlavor();
        }
        if (charset.length() != 0) {
            return isCharsetSupported(charset);
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: type inference failed for: r7v22 */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r7v24 */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r9v7, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r9v8, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r7v32, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r7v33, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 10 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.Reader getReaderForText(java.awt.datatransfer.Transferable r13) throws java.awt.datatransfer.UnsupportedFlavorException, java.io.IOException {
        /*
            r12 = this;
            r0 = r12
            r1 = r13
            r7 = r1
            r8 = r0
            java.lang.Object r7 = r7.getTransferData(r8)
            r3 = r7
            r7 = r3
            if (r7 != 0) goto L_0x001b
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r11 = r7
            r7 = r11
            r8 = r11
            java.lang.String r9 = "awt.16E"
            java.lang.String r9 = org.apache.harmony.awt.internal.nls.Messages.getString(r9)
            r8.<init>(r9)
            throw r7
        L_0x001b:
            r7 = r3
            boolean r7 = r7 instanceof java.io.Reader
            if (r7 == 0) goto L_0x002b
            r7 = r3
            java.io.Reader r7 = (java.io.Reader) r7
            r4 = r7
            r7 = r4
            r7.reset()
            r7 = r4
            r0 = r7
        L_0x002a:
            return r0
        L_0x002b:
            r7 = r3
            boolean r7 = r7 instanceof java.lang.String
            if (r7 == 0) goto L_0x003d
            java.io.StringReader r7 = new java.io.StringReader
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = r3
            java.lang.String r9 = (java.lang.String) r9
            r8.<init>(r9)
            r0 = r7
            goto L_0x002a
        L_0x003d:
            r7 = r3
            boolean r7 = r7 instanceof java.nio.CharBuffer
            if (r7 == 0) goto L_0x0053
            java.io.CharArrayReader r7 = new java.io.CharArrayReader
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = r3
            java.nio.CharBuffer r9 = (java.nio.CharBuffer) r9
            char[] r9 = r9.array()
            r8.<init>(r9)
            r0 = r7
            goto L_0x002a
        L_0x0053:
            r7 = r3
            boolean r7 = r7 instanceof char[]
            if (r7 == 0) goto L_0x0065
            java.io.CharArrayReader r7 = new java.io.CharArrayReader
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = r3
            char[] r9 = (char[]) r9
            r8.<init>(r9)
            r0 = r7
            goto L_0x002a
        L_0x0065:
            r7 = r0
            java.lang.String r7 = r7.getCharset()
            r4 = r7
            r7 = r3
            boolean r7 = r7 instanceof java.io.InputStream
            if (r7 == 0) goto L_0x008b
            r7 = r3
            java.io.InputStream r7 = (java.io.InputStream) r7
            r5 = r7
            r7 = r5
            r7.reset()
        L_0x0078:
            r7 = r4
            int r7 = r7.length()
            r8 = 0
            if (r7 != r8) goto L_0x00c2
            java.io.InputStreamReader r7 = new java.io.InputStreamReader
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = r5
            r8.<init>(r9)
            r0 = r7
            goto L_0x002a
        L_0x008b:
            r7 = r3
            boolean r7 = r7 instanceof java.nio.ByteBuffer
            if (r7 == 0) goto L_0x00a1
            java.io.ByteArrayInputStream r7 = new java.io.ByteArrayInputStream
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = r3
            java.nio.ByteBuffer r9 = (java.nio.ByteBuffer) r9
            byte[] r9 = r9.array()
            r8.<init>(r9)
            r5 = r7
            goto L_0x0078
        L_0x00a1:
            r7 = r3
            boolean r7 = r7 instanceof byte[]
            if (r7 == 0) goto L_0x00b3
            java.io.ByteArrayInputStream r7 = new java.io.ByteArrayInputStream
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = r3
            byte[] r9 = (byte[]) r9
            r8.<init>(r9)
            r5 = r7
            goto L_0x0078
        L_0x00b3:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r11 = r7
            r7 = r11
            r8 = r11
            java.lang.String r9 = "awt.16F"
            java.lang.String r9 = org.apache.harmony.awt.internal.nls.Messages.getString(r9)
            r8.<init>(r9)
            throw r7
        L_0x00c2:
            java.io.InputStreamReader r7 = new java.io.InputStreamReader
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = r5
            r10 = r4
            r8.<init>(r9, r10)
            r0 = r7
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.datatransfer.DataFlavor.getReaderForText(java.awt.datatransfer.Transferable):java.io.Reader");
    }

    public static final DataFlavor selectBestTextFlavor(DataFlavor[] dataFlavorArr) {
        LinkedList linkedList;
        DataFlavor[] dataFlavorArr2 = dataFlavorArr;
        if (dataFlavorArr2 == null) {
            return null;
        }
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList(Arrays.asList(dataFlavorArr2));
        List sortTextFlavorsByType = sortTextFlavorsByType(linkedList2);
        if (sortTextFlavorsByType.isEmpty()) {
            return null;
        }
        List list = (List) sortTextFlavorsByType.get(0);
        if (list.size() == 1) {
            return (DataFlavor) list.get(0);
        }
        if (((DataFlavor) list.get(0)).getCharset().length() == 0) {
            return selectBestFlavorWOCharset(list);
        }
        return selectBestFlavorWCharset(list);
    }

    private static DataFlavor selectBestFlavorWCharset(List<DataFlavor> list) {
        NoClassDefFoundError noClassDefFoundError;
        NoClassDefFoundError noClassDefFoundError2;
        NoClassDefFoundError noClassDefFoundError3;
        NoClassDefFoundError noClassDefFoundError4;
        List<DataFlavor> list2 = list;
        try {
            List flavors = getFlavors(list2, Class.forName("java.io.Reader"));
            if (flavors != null) {
                return (DataFlavor) flavors.get(0);
            }
            try {
                List flavors2 = getFlavors(list2, Class.forName("java.lang.String"));
                if (flavors2 != null) {
                    return (DataFlavor) flavors2.get(0);
                }
                try {
                    List flavors3 = getFlavors(list2, Class.forName("java.nio.CharBuffer"));
                    if (flavors3 != null) {
                        return (DataFlavor) flavors3.get(0);
                    }
                    try {
                        List flavors4 = getFlavors(list2, Class.forName("[C"));
                        if (flavors4 != null) {
                            return (DataFlavor) flavors4.get(0);
                        }
                        return selectBestByCharset(list2);
                    } catch (ClassNotFoundException e) {
                        ClassNotFoundException classNotFoundException = e;
                        NoClassDefFoundError noClassDefFoundError5 = noClassDefFoundError4;
                        NoClassDefFoundError noClassDefFoundError6 = new NoClassDefFoundError(classNotFoundException.getMessage());
                        throw noClassDefFoundError5;
                    }
                } catch (ClassNotFoundException e2) {
                    ClassNotFoundException classNotFoundException2 = e2;
                    NoClassDefFoundError noClassDefFoundError7 = noClassDefFoundError3;
                    NoClassDefFoundError noClassDefFoundError8 = new NoClassDefFoundError(classNotFoundException2.getMessage());
                    throw noClassDefFoundError7;
                }
            } catch (ClassNotFoundException e3) {
                ClassNotFoundException classNotFoundException3 = e3;
                NoClassDefFoundError noClassDefFoundError9 = noClassDefFoundError2;
                NoClassDefFoundError noClassDefFoundError10 = new NoClassDefFoundError(classNotFoundException3.getMessage());
                throw noClassDefFoundError9;
            }
        } catch (ClassNotFoundException e4) {
            ClassNotFoundException classNotFoundException4 = e4;
            NoClassDefFoundError noClassDefFoundError11 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError12 = new NoClassDefFoundError(classNotFoundException4.getMessage());
            throw noClassDefFoundError11;
        }
    }

    private static DataFlavor selectBestByCharset(List<DataFlavor> list) {
        List<DataFlavor> list2 = list;
        List<DataFlavor> list3 = list2;
        String[] strArr = new String[4];
        String[] strArr2 = strArr;
        strArr[0] = "UTF-16";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "UTF-8";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = "UTF-16BE";
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[3] = "UTF-16LE";
        List flavors = getFlavors(list3, strArr8);
        if (flavors == null) {
            List<DataFlavor> list4 = list2;
            String[] strArr9 = new String[1];
            String[] strArr10 = strArr9;
            strArr9[0] = "unicode";
            flavors = getFlavors(list4, strArr10);
            if (flavors == null) {
                List<DataFlavor> list5 = list2;
                String[] strArr11 = new String[1];
                String[] strArr12 = strArr11;
                strArr11[0] = "US-ASCII";
                flavors = getFlavors(list5, strArr12);
                if (flavors == null) {
                    flavors = selectBestByAlphabet(list2);
                }
            }
        }
        if (flavors == null) {
            return null;
        }
        if (flavors.size() == 1) {
            return (DataFlavor) flavors.get(0);
        }
        return selectBestFlavorWOCharset(flavors);
    }

    private static List<DataFlavor> selectBestByAlphabet(List<DataFlavor> list) {
        LinkedList linkedList;
        LinkedList linkedList2;
        List<DataFlavor> list2 = list;
        String[] strArr = new String[list2.size()];
        LinkedList linkedList3 = linkedList;
        LinkedList linkedList4 = new LinkedList();
        LinkedList linkedList5 = linkedList3;
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = ((DataFlavor) list2.get(i)).getCharset();
        }
        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        for (DataFlavor dataFlavor : list2) {
            if (strArr[0].equalsIgnoreCase(dataFlavor.getCharset())) {
                boolean add = linkedList5.add(dataFlavor);
            }
        }
        if (linkedList5.isEmpty()) {
            linkedList2 = null;
        } else {
            linkedList2 = linkedList5;
        }
        return linkedList2;
    }

    private static List<DataFlavor> getFlavors(List<DataFlavor> list, String[] strArr) {
        LinkedList linkedList;
        List<DataFlavor> list2;
        List<DataFlavor> list3 = list;
        String[] strArr2 = strArr;
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = linkedList2;
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            DataFlavor dataFlavor = (DataFlavor) it.next();
            if (isCharsetSupported(dataFlavor.getCharset())) {
                String[] strArr3 = strArr2;
                for (int i = 0; i < strArr3.length; i++) {
                    if (Charset.forName(strArr3[i]).equals(Charset.forName(dataFlavor.getCharset()))) {
                        boolean add = linkedList4.add(dataFlavor);
                    }
                }
            } else {
                it.remove();
            }
        }
        if (linkedList4.isEmpty()) {
            list2 = null;
        } else {
            list2 = list3;
        }
        return list2;
    }

    private static DataFlavor selectBestFlavorWOCharset(List<DataFlavor> list) {
        NoClassDefFoundError noClassDefFoundError;
        NoClassDefFoundError noClassDefFoundError2;
        NoClassDefFoundError noClassDefFoundError3;
        List<DataFlavor> list2 = list;
        try {
            List flavors = getFlavors(list2, Class.forName("java.io.InputStream"));
            if (flavors != null) {
                return (DataFlavor) flavors.get(0);
            }
            try {
                List flavors2 = getFlavors(list2, Class.forName("java.nio.ByteBuffer"));
                if (flavors2 != null) {
                    return (DataFlavor) flavors2.get(0);
                }
                try {
                    List flavors3 = getFlavors(list2, Class.forName("[B"));
                    if (flavors3 != null) {
                        return (DataFlavor) flavors3.get(0);
                    }
                    return (DataFlavor) list2.get(0);
                } catch (ClassNotFoundException e) {
                    ClassNotFoundException classNotFoundException = e;
                    NoClassDefFoundError noClassDefFoundError4 = noClassDefFoundError3;
                    NoClassDefFoundError noClassDefFoundError5 = new NoClassDefFoundError(classNotFoundException.getMessage());
                    throw noClassDefFoundError4;
                }
            } catch (ClassNotFoundException e2) {
                ClassNotFoundException classNotFoundException2 = e2;
                NoClassDefFoundError noClassDefFoundError6 = noClassDefFoundError2;
                NoClassDefFoundError noClassDefFoundError7 = new NoClassDefFoundError(classNotFoundException2.getMessage());
                throw noClassDefFoundError6;
            }
        } catch (ClassNotFoundException e3) {
            ClassNotFoundException classNotFoundException3 = e3;
            NoClassDefFoundError noClassDefFoundError8 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError9 = new NoClassDefFoundError(classNotFoundException3.getMessage());
            throw noClassDefFoundError8;
        }
    }

    private static List<DataFlavor> getFlavors(List<DataFlavor> list, Class<?> cls) {
        LinkedList linkedList;
        List<DataFlavor> list2;
        List<DataFlavor> list3 = list;
        Class<?> cls2 = cls;
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = linkedList2;
        for (DataFlavor dataFlavor : list3) {
            if (dataFlavor.representationClass.equals(cls2)) {
                boolean add = linkedList4.add(dataFlavor);
            }
        }
        if (linkedList4.isEmpty()) {
            list2 = null;
        } else {
            list2 = list3;
        }
        return list2;
    }

    private static List<List<DataFlavor>> sortTextFlavorsByType(List<DataFlavor> list) {
        LinkedList linkedList;
        List<DataFlavor> list2 = list;
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = linkedList2;
        String[] strArr = sortedTextFlavors;
        for (int i = 0; i < strArr.length; i++) {
            List fetchTextFlavors = fetchTextFlavors(list2, strArr[i]);
            if (fetchTextFlavors != null) {
                linkedList4.addLast(fetchTextFlavors);
            }
        }
        if (!list2.isEmpty()) {
            linkedList4.addLast(list2);
        }
        return linkedList4;
    }

    private static List<DataFlavor> fetchTextFlavors(List<DataFlavor> list, String str) {
        LinkedList linkedList;
        LinkedList linkedList2;
        List<DataFlavor> list2 = list;
        String str2 = str;
        LinkedList linkedList3 = linkedList;
        LinkedList linkedList4 = new LinkedList();
        LinkedList linkedList5 = linkedList3;
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            DataFlavor dataFlavor = (DataFlavor) it.next();
            if (!dataFlavor.isFlavorTextType()) {
                it.remove();
            } else if (dataFlavor.mimeInfo.getFullType().equals(str2)) {
                if (!linkedList5.contains(dataFlavor)) {
                    boolean add = linkedList5.add(dataFlavor);
                }
                it.remove();
            }
        }
        if (linkedList5.isEmpty()) {
            linkedList2 = null;
        } else {
            linkedList2 = linkedList5;
        }
        return linkedList2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        if (r0.representationClass.equals(java.lang.Class.forName("[C")) == false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isUnicodeFlavor() {
        /*
            r13 = this;
            r0 = r13
            r7 = r0
            java.lang.Class<?> r7 = r7.representationClass
            if (r7 == 0) goto L_0x0042
            r7 = r0
            java.lang.Class<?> r7 = r7.representationClass
            java.lang.String r8 = "java.io.Reader"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x0045 }
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0085
            r7 = r0
            java.lang.Class<?> r7 = r7.representationClass
            java.lang.String r8 = "java.lang.String"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x0055 }
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0085
            r7 = r0
            java.lang.Class<?> r7 = r7.representationClass
            java.lang.String r8 = "java.nio.CharBuffer"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x0065 }
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0085
            r7 = r0
            java.lang.Class<?> r7 = r7.representationClass
            java.lang.String r8 = "[C"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x0075 }
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0085
        L_0x0042:
            r7 = 0
        L_0x0043:
            r0 = r7
            return r0
        L_0x0045:
            r7 = move-exception
            r2 = r7
            java.lang.NoClassDefFoundError r7 = new java.lang.NoClassDefFoundError
            r12 = r7
            r7 = r12
            r8 = r12
            r9 = r2
            java.lang.String r9 = r9.getMessage()
            r8.<init>(r9)
            throw r7
        L_0x0055:
            r7 = move-exception
            r3 = r7
            java.lang.NoClassDefFoundError r7 = new java.lang.NoClassDefFoundError
            r12 = r7
            r7 = r12
            r8 = r12
            r9 = r3
            java.lang.String r9 = r9.getMessage()
            r8.<init>(r9)
            throw r7
        L_0x0065:
            r7 = move-exception
            r4 = r7
            java.lang.NoClassDefFoundError r7 = new java.lang.NoClassDefFoundError
            r12 = r7
            r7 = r12
            r8 = r12
            r9 = r4
            java.lang.String r9 = r9.getMessage()
            r8.<init>(r9)
            throw r7
        L_0x0075:
            r7 = move-exception
            r5 = r7
            java.lang.NoClassDefFoundError r7 = new java.lang.NoClassDefFoundError
            r12 = r7
            r7 = r12
            r8 = r12
            r9 = r5
            java.lang.String r9 = r9.getMessage()
            r8.<init>(r9)
            throw r7
        L_0x0085:
            r7 = 1
            goto L_0x0043
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.datatransfer.DataFlavor.isUnicodeFlavor():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r0.representationClass.equals(java.lang.Class.forName("[B")) == false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isByteCodeFlavor() {
        /*
            r12 = this;
            r0 = r12
            r6 = r0
            java.lang.Class<?> r6 = r6.representationClass
            if (r6 == 0) goto L_0x0033
            r6 = r0
            java.lang.Class<?> r6 = r6.representationClass
            java.lang.String r7 = "java.io.InputStream"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x0036 }
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0066
            r6 = r0
            java.lang.Class<?> r6 = r6.representationClass
            java.lang.String r7 = "java.nio.ByteBuffer"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x0046 }
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0066
            r6 = r0
            java.lang.Class<?> r6 = r6.representationClass
            java.lang.String r7 = "[B"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x0056 }
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0066
        L_0x0033:
            r6 = 0
        L_0x0034:
            r0 = r6
            return r0
        L_0x0036:
            r6 = move-exception
            r2 = r6
            java.lang.NoClassDefFoundError r6 = new java.lang.NoClassDefFoundError
            r11 = r6
            r6 = r11
            r7 = r11
            r8 = r2
            java.lang.String r8 = r8.getMessage()
            r7.<init>(r8)
            throw r6
        L_0x0046:
            r6 = move-exception
            r3 = r6
            java.lang.NoClassDefFoundError r6 = new java.lang.NoClassDefFoundError
            r11 = r6
            r6 = r11
            r7 = r11
            r8 = r3
            java.lang.String r8 = r8.getMessage()
            r7.<init>(r8)
            throw r6
        L_0x0056:
            r6 = move-exception
            r4 = r6
            java.lang.NoClassDefFoundError r6 = new java.lang.NoClassDefFoundError
            r11 = r6
            r6 = r11
            r7 = r11
            r8 = r4
            java.lang.String r8 = r8.getMessage()
            r7.<init>(r8)
            throw r6
        L_0x0066:
            r6 = 1
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.datatransfer.DataFlavor.isByteCodeFlavor():boolean");
    }
}
