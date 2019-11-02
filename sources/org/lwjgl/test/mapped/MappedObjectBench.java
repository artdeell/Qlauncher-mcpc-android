package org.lwjgl.test.mapped;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.lwjgl.MemoryUtil;
import org.lwjgl.util.mapped.MappedHelper;

public class MappedObjectBench {

    static class ArrayVec3 {

        /* renamed from: a */
        float[] f204a;

        /* renamed from: i */
        int f205i;

        ArrayVec3() {
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append("ArrayVec3[").append(this.f204a[0 + (3 * this.f205i)]).append(", ").append(this.f204a[1 + (3 * this.f205i)]).append(", ").append(this.f204a[2 + (3 * this.f205i)]).append("]").toString();
        }
    }

    static class InstanceVec3 {

        /* renamed from: x */
        float f206x;

        /* renamed from: y */
        float f207y;

        /* renamed from: z */
        float f208z;

        InstanceVec3() {
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append("InstanceVec3[").append(this.f206x).append(", ").append(this.f207y).append(", ").append(this.f208z).append("]").toString();
        }
    }

    public MappedObjectBench() {
    }

    static void benchmarkDirectArray() {
        StringBuilder sb;
        float[] fArr = new float[200];
        long[] jArr = new long[64];
        for (int i = 0; i < 64; i++) {
            long nanoTime = System.nanoTime();
            for (int i2 = 0; i2 < 65536; i2++) {
                fArr[3] = 13.0f;
                fArr[4] = fArr[4] + 0.3f + (fArr[4] * fArr[3]);
                fArr[5] = fArr[5] + 0.3f + fArr[7] + fArr[3];
                fArr[8] = fArr[8] + fArr[7] + fArr[3];
                fArr[11] = fArr[11] + fArr[8] + fArr[7];
            }
            jArr[i] = System.nanoTime() - nanoTime;
        }
        Arrays.sort(jArr);
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("array2 took: ").append(jArr[jArr.length / 2] / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).append("us").toString());
        System.out.println(fArr);
    }

    static void benchmarkIndirectArray() {
        ArrayVec3 arrayVec3;
        ArrayVec3 arrayVec32;
        ArrayVec3 arrayVec33;
        StringBuilder sb;
        float[] fArr = new float[200];
        ArrayVec3 arrayVec34 = arrayVec3;
        ArrayVec3 arrayVec35 = new ArrayVec3();
        ArrayVec3 arrayVec36 = arrayVec34;
        ArrayVec3 arrayVec37 = arrayVec32;
        ArrayVec3 arrayVec38 = new ArrayVec3();
        ArrayVec3 arrayVec39 = arrayVec37;
        ArrayVec3 arrayVec310 = arrayVec33;
        ArrayVec3 arrayVec311 = new ArrayVec3();
        ArrayVec3 arrayVec312 = arrayVec310;
        arrayVec36.f204a = fArr;
        arrayVec39.f204a = fArr;
        arrayVec312.f204a = fArr;
        arrayVec36.f205i = 0;
        arrayVec39.f205i = 1;
        arrayVec312.f205i = 2;
        long[] jArr = new long[64];
        for (int i = 0; i < 64; i++) {
            long nanoTime = System.nanoTime();
            for (int i2 = 0; i2 < 65536; i2++) {
                arrayVec36.f204a[0 + (3 * arrayVec36.f205i)] = 13.0f;
                float[] fArr2 = arrayVec36.f204a;
                int i3 = 1 + (3 * arrayVec36.f205i);
                fArr2[i3] = fArr2[i3] + 0.3f + (arrayVec36.f204a[1 + (3 * arrayVec36.f205i)] * arrayVec36.f204a[0 + (3 * arrayVec36.f205i)]);
                float[] fArr3 = arrayVec36.f204a;
                int i4 = 2 + (3 * arrayVec36.f205i);
                fArr3[i4] = fArr3[i4] + 0.3f + arrayVec39.f204a[1 + (3 * arrayVec39.f205i)] + arrayVec36.f204a[0 + (3 * arrayVec36.f205i)];
                float[] fArr4 = arrayVec39.f204a;
                int i5 = 2 + (3 * arrayVec39.f205i);
                fArr4[i5] = fArr4[i5] + arrayVec39.f204a[1 + (3 * arrayVec39.f205i)] + arrayVec36.f204a[0 + (3 * arrayVec36.f205i)];
                float[] fArr5 = arrayVec312.f204a;
                int i6 = 2 + (3 * arrayVec312.f205i);
                fArr5[i6] = fArr5[i6] + arrayVec39.f204a[2 + (3 * arrayVec39.f205i)] + arrayVec39.f204a[1 + (3 * arrayVec39.f205i)];
            }
            jArr[i] = System.nanoTime() - nanoTime;
        }
        Arrays.sort(jArr);
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("array took: ").append(jArr[jArr.length / 2] / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).append("us").toString());
        System.out.println(arrayVec36);
        System.out.println(arrayVec39);
        System.out.println(arrayVec312);
        System.out.println(fArr);
    }

    static void benchmarkInstances() {
        InstanceVec3 instanceVec3;
        InstanceVec3 instanceVec32;
        InstanceVec3 instanceVec33;
        StringBuilder sb;
        InstanceVec3 instanceVec34 = instanceVec3;
        InstanceVec3 instanceVec35 = new InstanceVec3();
        InstanceVec3 instanceVec36 = instanceVec34;
        InstanceVec3 instanceVec37 = instanceVec32;
        InstanceVec3 instanceVec38 = new InstanceVec3();
        InstanceVec3 instanceVec39 = instanceVec37;
        InstanceVec3 instanceVec310 = instanceVec33;
        InstanceVec3 instanceVec311 = new InstanceVec3();
        InstanceVec3 instanceVec312 = instanceVec310;
        long[] jArr = new long[64];
        for (int i = 0; i < 64; i++) {
            long nanoTime = System.nanoTime();
            for (int i2 = 0; i2 < 65536; i2++) {
                instanceVec36.f206x = 13.0f;
                instanceVec36.f207y += 0.3f + (instanceVec36.f207y * instanceVec36.f206x);
                instanceVec36.f208z += 0.3f + instanceVec39.f207y + instanceVec36.f206x;
                instanceVec39.f208z += instanceVec39.f207y + instanceVec36.f206x;
                instanceVec312.f208z += instanceVec39.f208z + instanceVec36.f207y;
            }
            jArr[i] = System.nanoTime() - nanoTime;
        }
        Arrays.sort(jArr);
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("instance took: ").append(jArr[jArr.length / 2] / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).append("us").toString());
        System.out.println(instanceVec36);
        System.out.println(instanceVec39);
        System.out.println(instanceVec312);
    }

    static void benchmarkMapped() {
        StringBuilder sb;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(200);
        MappedVec3 mappedVec3 = (MappedVec3) MappedVec3.map(allocateDirect);
        MappedVec3 mappedVec32 = (MappedVec3) mappedVec3.dup();
        MappedVec3 mappedVec33 = (MappedVec3) mappedVec3.dup();
        MappedVec3 mappedVec34 = (MappedVec3) mappedVec3.dup();
        mappedVec32.view = 0;
        mappedVec33.view = 1;
        mappedVec34.view = 2;
        long[] jArr = new long[64];
        for (int i = 0; i < 64; i++) {
            long nanoTime = System.nanoTime();
            for (int i2 = 0; i2 < 65536; i2 += 2) {
                mappedVec32.f214x = 13.0f;
                mappedVec32.f215y += 0.3f + (mappedVec32.f215y * mappedVec32.f214x);
                mappedVec32.f216z += 0.3f + mappedVec33.f215y + mappedVec32.f214x;
                mappedVec33.f216z += mappedVec33.f215y + mappedVec32.f214x;
                mappedVec34.f216z += mappedVec33.f216z + mappedVec32.f215y;
                mappedVec32.f214x = 13.0f;
                mappedVec32.f215y += 0.3f + (mappedVec32.f215y * mappedVec32.f214x);
                mappedVec32.f216z += 0.3f + mappedVec33.f215y + mappedVec32.f214x;
                mappedVec33.f216z += mappedVec33.f215y + mappedVec32.f214x;
                mappedVec34.f216z += mappedVec33.f216z + mappedVec32.f215y;
            }
            jArr[i] = System.nanoTime() - nanoTime;
        }
        Arrays.sort(jArr);
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("mapped took: ").append(jArr[jArr.length / 2] / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).append("us").toString());
        System.out.println(mappedVec32);
        System.out.println(mappedVec33);
        System.out.println(mappedVec34);
        System.out.println(allocateDirect);
    }

    static void benchmarkUnsafe() {
        StringBuilder sb;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(200);
        long address = MemoryUtil.getAddress(allocateDirect);
        long[] jArr = new long[64];
        for (int i = 0; i < 64; i++) {
            long nanoTime = System.nanoTime();
            for (int i2 = 0; i2 < 65536; i2++) {
                MappedHelper.fput(13.0f, 12 + address);
                MappedHelper.fput(0.3f + MappedHelper.fget(16 + address) + (MappedHelper.fget(16 + address) * MappedHelper.fget(12 + address)), 16 + address);
                MappedHelper.fput(0.3f + MappedHelper.fget(20 + address) + MappedHelper.fget(28 + address) + MappedHelper.fget(12 + address), 20 + address);
                MappedHelper.fput(MappedHelper.fget(32 + address) + MappedHelper.fget(28 + address) + MappedHelper.fget(12 + address), 32 + address);
                MappedHelper.fput(MappedHelper.fget(44 + address) + MappedHelper.fget(32 + address) + MappedHelper.fget(28 + address), 44 + address);
            }
            jArr[i] = System.nanoTime() - nanoTime;
        }
        Arrays.sort(jArr);
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("unsafe took: ").append(jArr[jArr.length / 2] / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).append("us").toString());
        System.out.println(allocateDirect);
    }
}
