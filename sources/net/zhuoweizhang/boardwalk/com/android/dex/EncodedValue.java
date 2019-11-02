package net.zhuoweizhang.boardwalk.com.android.dex;

import net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteArrayByteInput;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteInput;

public final class EncodedValue implements Comparable<EncodedValue> {
    private final byte[] data;

    public EncodedValue(byte[] bArr) {
        this.data = bArr;
    }

    public ByteInput asByteInput() {
        ByteArrayByteInput byteArrayByteInput;
        ByteArrayByteInput byteArrayByteInput2 = byteArrayByteInput;
        ByteArrayByteInput byteArrayByteInput3 = new ByteArrayByteInput(this.data);
        return byteArrayByteInput2;
    }

    public int compareTo(EncodedValue encodedValue) {
        EncodedValue encodedValue2 = encodedValue;
        int min = Math.min(this.data.length, encodedValue2.data.length);
        for (int i = 0; i < min; i++) {
            if (this.data[i] != encodedValue2.data[i]) {
                return (255 & this.data[i]) - (255 & encodedValue2.data[i]);
            }
        }
        return this.data.length - encodedValue2.data.length;
    }

    public byte[] getBytes() {
        return this.data;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(Integer.toHexString(255 & this.data[0])).append("...(").append(this.data.length).append(")").toString();
    }

    public void writeTo(Section section) {
        section.write(this.data);
    }
}
