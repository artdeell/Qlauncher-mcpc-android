package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.dex.Leb128;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteOutput;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArrayAnnotatedOutput */
public final class ByteArrayAnnotatedOutput implements AnnotatedOutput, ByteOutput {
    private static final int DEFAULT_SIZE = 1000;
    private int annotationWidth;
    private ArrayList<Annotation> annotations;
    private int cursor;
    private byte[] data;
    private int hexCols;
    private final boolean stretchy;
    private boolean verbose;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArrayAnnotatedOutput$Annotation */
    private static class Annotation {
        private int end;
        private final int start;
        private final String text;

        public Annotation(int i, int i2, String str) {
            int i3 = i2;
            String str2 = str;
            this.start = i;
            this.end = i3;
            this.text = str2;
        }

        public Annotation(int i, String str) {
            this(i, IDirectInputDevice.DIPROPRANGE_NOMAX, str);
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }

        public String getText() {
            return this.text;
        }

        public void setEnd(int i) {
            int i2 = i;
            this.end = i2;
        }

        public void setEndIfUnset(int i) {
            int i2 = i;
            if (this.end == Integer.MAX_VALUE) {
                this.end = i2;
            }
        }
    }

    public ByteArrayAnnotatedOutput() {
        this((int) DEFAULT_SIZE);
    }

    public ByteArrayAnnotatedOutput(int i) {
        this(new byte[i], true);
    }

    public ByteArrayAnnotatedOutput(byte[] bArr) {
        this(bArr, false);
    }

    private ByteArrayAnnotatedOutput(byte[] bArr, boolean z) {
        NullPointerException nullPointerException;
        byte[] bArr2 = bArr;
        boolean z2 = z;
        if (bArr2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("data == null");
            throw nullPointerException2;
        }
        this.stretchy = z2;
        this.data = bArr2;
        this.cursor = 0;
        this.verbose = false;
        this.annotations = null;
        this.annotationWidth = 0;
        this.hexCols = 0;
    }

    private void ensureCapacity(int i) {
        int i2 = i;
        if (this.data.length < i2) {
            byte[] bArr = new byte[(DEFAULT_SIZE + (i2 * 2))];
            System.arraycopy(this.data, 0, bArr, 0, this.cursor);
            this.data = bArr;
        }
    }

    private static void throwBounds() {
        IndexOutOfBoundsException indexOutOfBoundsException;
        IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
        IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException("attempt to write past the end");
        throw indexOutOfBoundsException2;
    }

    public void alignTo(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        int i3 = i2 - 1;
        if (i2 < 0 || (i3 & i2) != 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bogus alignment");
            throw illegalArgumentException2;
        }
        int i4 = (i3 + this.cursor) & (i3 ^ -1);
        if (this.stretchy) {
            ensureCapacity(i4);
        } else if (i4 > this.data.length) {
            throwBounds();
            return;
        }
        this.cursor = i4;
    }

    public void annotate(int i, String str) {
        Annotation annotation;
        int i2 = i;
        String str2 = str;
        if (this.annotations != null) {
            endAnnotation();
            int size = this.annotations.size();
            int end = size == 0 ? 0 : ((Annotation) this.annotations.get(size - 1)).getEnd();
            if (end <= this.cursor) {
                end = this.cursor;
            }
            ArrayList<Annotation> arrayList = this.annotations;
            Annotation annotation2 = annotation;
            Annotation annotation3 = new Annotation(end, end + i2, str2);
            boolean add = arrayList.add(annotation2);
        }
    }

    public void annotate(String str) {
        Annotation annotation;
        String str2 = str;
        if (this.annotations != null) {
            endAnnotation();
            ArrayList<Annotation> arrayList = this.annotations;
            Annotation annotation2 = annotation;
            Annotation annotation3 = new Annotation(this.cursor, str2);
            boolean add = arrayList.add(annotation2);
        }
    }

    public boolean annotates() {
        return this.annotations != null;
    }

    public void assertCursor(int i) {
        ExceptionWithContext exceptionWithContext;
        StringBuilder sb;
        int i2 = i;
        if (this.cursor != i2) {
            ExceptionWithContext exceptionWithContext2 = exceptionWithContext;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            ExceptionWithContext exceptionWithContext3 = new ExceptionWithContext(sb2.append("expected cursor ").append(i2).append("; actual value: ").append(this.cursor).toString());
            throw exceptionWithContext2;
        }
    }

    public void enableAnnotations(int i, boolean z) {
        RuntimeException runtimeException;
        ArrayList<Annotation> arrayList;
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        boolean z2 = z;
        int i3 = 6;
        if (this.annotations != null || this.cursor != 0) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("cannot enable annotations");
            throw runtimeException2;
        } else if (i2 < 40) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("annotationWidth < 40");
            throw illegalArgumentException2;
        } else {
            int i4 = -2 & (1 + ((i2 - 7) / 15));
            if (i4 >= 6) {
                i3 = i4 > 10 ? 10 : i4;
            }
            ArrayList<Annotation> arrayList2 = arrayList;
            ArrayList<Annotation> arrayList3 = new ArrayList<>(DEFAULT_SIZE);
            this.annotations = arrayList2;
            this.annotationWidth = i2;
            this.hexCols = i3;
            this.verbose = z2;
        }
    }

    public void endAnnotation() {
        if (this.annotations != null) {
            int size = this.annotations.size();
            if (size != 0) {
                ((Annotation) this.annotations.get(size - 1)).setEndIfUnset(this.cursor);
            }
        }
    }

    public void finishAnnotating() {
        endAnnotation();
        if (this.annotations != null) {
            int size = this.annotations.size();
            while (size > 0) {
                Annotation annotation = (Annotation) this.annotations.get(size - 1);
                if (annotation.getStart() > this.cursor) {
                    Object remove = this.annotations.remove(size - 1);
                    size--;
                } else if (annotation.getEnd() > this.cursor) {
                    annotation.setEnd(this.cursor);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public int getAnnotationWidth() {
        return this.annotationWidth - ((8 + (2 * this.hexCols)) + (this.hexCols / 2));
    }

    public byte[] getArray() {
        return this.data;
    }

    public int getCursor() {
        return this.cursor;
    }

    public boolean isVerbose() {
        return this.verbose;
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[this.cursor];
        System.arraycopy(this.data, 0, bArr, 0, this.cursor);
        return bArr;
    }

    public void write(ByteArray byteArray) {
        ByteArray byteArray2 = byteArray;
        int size = byteArray2.size();
        int i = this.cursor;
        int i2 = size + i;
        if (this.stretchy) {
            ensureCapacity(i2);
        } else if (i2 > this.data.length) {
            throwBounds();
            return;
        }
        byteArray2.getBytes(this.data, i);
        this.cursor = i2;
    }

    public void write(byte[] bArr) {
        byte[] bArr2 = bArr;
        write(bArr2, 0, bArr2.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        StringBuilder sb;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        int i5 = this.cursor;
        int i6 = i5 + i4;
        int i7 = i3 + i4;
        if ((i6 | i3 | i4) < 0 || i7 > bArr2.length) {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException(sb2.append("bytes.length ").append(bArr2.length).append("; ").append(i3).append("..!").append(i6).toString());
            throw indexOutOfBoundsException2;
        }
        if (this.stretchy) {
            ensureCapacity(i6);
        } else if (i6 > this.data.length) {
            throwBounds();
            return;
        }
        System.arraycopy(bArr2, i3, this.data, i5, i4);
        this.cursor = i6;
    }

    public void writeAnnotationsTo(Writer writer) throws IOException {
        TwoColumnOutput twoColumnOutput;
        int i;
        String text;
        Writer writer2 = writer;
        int annotationWidth2 = getAnnotationWidth();
        TwoColumnOutput twoColumnOutput2 = twoColumnOutput;
        TwoColumnOutput twoColumnOutput3 = new TwoColumnOutput(writer2, -1 + (this.annotationWidth - annotationWidth2), annotationWidth2, "|");
        TwoColumnOutput twoColumnOutput4 = twoColumnOutput2;
        Writer left = twoColumnOutput4.getLeft();
        Writer right = twoColumnOutput4.getRight();
        int size = this.annotations.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i >= this.cursor || i2 >= size) {
            } else {
                Annotation annotation = (Annotation) this.annotations.get(i2);
                int start = annotation.getStart();
                if (i < start) {
                    text = LibrariesRepository.MOJANG_MAVEN_REPO;
                } else {
                    int end = annotation.getEnd();
                    i2++;
                    text = annotation.getText();
                    i = start;
                    start = end;
                }
                left.write(Hex.dump(this.data, i, start - i, i, this.hexCols, 6));
                right.write(text);
                twoColumnOutput4.flush();
                i3 = start;
            }
        }
        if (i < this.cursor) {
            left.write(Hex.dump(this.data, i, this.cursor - i, i, this.hexCols, 6));
        }
        while (i2 < size) {
            right.write(((Annotation) this.annotations.get(i2)).getText());
            i2++;
        }
        twoColumnOutput4.flush();
    }

    public void writeByte(int i) {
        int i2 = i;
        int i3 = this.cursor;
        int i4 = i3 + 1;
        if (this.stretchy) {
            ensureCapacity(i4);
        } else if (i4 > this.data.length) {
            throwBounds();
            return;
        }
        this.data[i3] = (byte) i2;
        this.cursor = i4;
    }

    public void writeInt(int i) {
        int i2 = i;
        int i3 = this.cursor;
        int i4 = i3 + 4;
        if (this.stretchy) {
            ensureCapacity(i4);
        } else if (i4 > this.data.length) {
            throwBounds();
            return;
        }
        this.data[i3] = (byte) i2;
        this.data[i3 + 1] = (byte) (i2 >> 8);
        this.data[i3 + 2] = (byte) (i2 >> 16);
        this.data[i3 + 3] = (byte) (i2 >> 24);
        this.cursor = i4;
    }

    public void writeLong(long j) {
        long j2 = j;
        int i = this.cursor;
        int i2 = i + 8;
        if (this.stretchy) {
            ensureCapacity(i2);
        } else if (i2 > this.data.length) {
            throwBounds();
            return;
        }
        int i3 = (int) j2;
        this.data[i] = (byte) i3;
        this.data[i + 1] = (byte) (i3 >> 8);
        this.data[i + 2] = (byte) (i3 >> 16);
        this.data[i + 3] = (byte) (i3 >> 24);
        int i4 = (int) (j2 >> 32);
        this.data[i + 4] = (byte) i4;
        this.data[i + 5] = (byte) (i4 >> 8);
        this.data[i + 6] = (byte) (i4 >> 16);
        this.data[i + 7] = (byte) (i4 >> 24);
        this.cursor = i2;
    }

    public void writeShort(int i) {
        int i2 = i;
        int i3 = this.cursor;
        int i4 = i3 + 2;
        if (this.stretchy) {
            ensureCapacity(i4);
        } else if (i4 > this.data.length) {
            throwBounds();
            return;
        }
        this.data[i3] = (byte) i2;
        this.data[i3 + 1] = (byte) (i2 >> 8);
        this.cursor = i4;
    }

    public int writeSleb128(int i) {
        int i2 = i;
        if (this.stretchy) {
            ensureCapacity(5 + this.cursor);
        }
        int i3 = this.cursor;
        Leb128.writeSignedLeb128(this, i2);
        return this.cursor - i3;
    }

    public int writeUleb128(int i) {
        int i2 = i;
        if (this.stretchy) {
            ensureCapacity(5 + this.cursor);
        }
        int i3 = this.cursor;
        Leb128.writeUnsignedLeb128(this, i2);
        return this.cursor - i3;
    }

    public void writeZeroes(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("count < 0");
            throw illegalArgumentException2;
        }
        int i3 = i2 + this.cursor;
        if (this.stretchy) {
            ensureCapacity(i3);
        } else if (i3 > this.data.length) {
            throwBounds();
            return;
        }
        this.cursor = i3;
    }
}
