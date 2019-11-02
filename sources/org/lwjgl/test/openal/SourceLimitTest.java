package org.lwjgl.test.openal;

import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.OpenALException;

public class SourceLimitTest extends BasicTest {
    protected int sourcesToCreate = 64;

    public SourceLimitTest() {
    }

    public static void main(String[] strArr) {
        SourceLimitTest sourceLimitTest;
        String[] strArr2 = strArr;
        SourceLimitTest sourceLimitTest2 = sourceLimitTest;
        SourceLimitTest sourceLimitTest3 = new SourceLimitTest();
        sourceLimitTest2.execute(strArr2);
        System.exit(0);
    }

    /* access modifiers changed from: protected */
    public void CreateAllSources() {
        StringBuilder sb;
        StringBuilder sb2;
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(this.sourcesToCreate);
        try {
            Buffer limit = createIntBuffer.position(0).limit(this.sourcesToCreate);
            AL10.alGenSources(createIntBuffer);
            Buffer limit2 = createIntBuffer.position(0).limit(this.sourcesToCreate);
            AL10.alDeleteSources(createIntBuffer);
            PrintStream printStream = System.out;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            printStream.println(sb3.append("created ").append(this.sourcesToCreate).append(" sources successfully!").toString());
        } catch (OpenALException e) {
            OpenALException openALException = e;
            PrintStream printStream2 = System.out;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            printStream2.println(sb5.append("Unable to create ").append(this.sourcesToCreate).append(" sources").toString());
        }
    }

    /* access modifiers changed from: protected */
    public void CreateSourcesStep() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        int i = 0;
        IntBuffer[] intBufferArr = new IntBuffer[this.sourcesToCreate];
        int i2 = 0;
        while (i2 < this.sourcesToCreate) {
            try {
                intBufferArr[i2] = BufferUtils.createIntBuffer(1);
                Buffer limit = intBufferArr[i2].position(0).limit(1);
                AL10.alGenSources(intBufferArr[i2]);
                if (AL10.alGetError() != 0) {
                    break;
                }
                i++;
                i2++;
            } catch (OpenALException e) {
                OpenALException openALException = e;
                PrintStream printStream = System.out;
                StringBuilder sb4 = sb;
                StringBuilder sb5 = new StringBuilder();
                printStream.println(sb4.append("failed to create source: ").append(i + 1).toString());
            }
        }
        for (int i3 = 0; i3 < i; i3++) {
            Buffer limit2 = intBufferArr[i3].position(0).limit(1);
            AL10.alDeleteSources(intBufferArr[i3]);
        }
        if (i != this.sourcesToCreate) {
            PrintStream printStream2 = System.out;
            StringBuilder sb6 = sb3;
            StringBuilder sb7 = new StringBuilder();
            printStream2.println(sb6.append("created ").append(i).append(" sources before failing").toString());
            return;
        }
        PrintStream printStream3 = System.out;
        StringBuilder sb8 = sb2;
        StringBuilder sb9 = new StringBuilder();
        printStream3.println(sb8.append("created ").append(i).append(" sources successfully!").toString());
    }

    /* access modifiers changed from: protected */
    public void execute(String[] strArr) {
        StringBuilder sb;
        StringBuilder sb2;
        String[] strArr2 = strArr;
        if (strArr2.length > 0) {
            try {
                this.sourcesToCreate = Integer.parseInt(strArr2[0]);
            } catch (NumberFormatException e) {
                NumberFormatException numberFormatException = e;
                System.out.println("Unable to parse parameter to integer. Defaulting to 64 sources.");
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        printStream.print(sb3.append("Creating ").append(this.sourcesToCreate).append(" in one go...").toString());
        try {
            CreateAllSources();
        } catch (OpenALException e2) {
            e2.printStackTrace();
        }
        PrintStream printStream2 = System.out;
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = new StringBuilder();
        printStream2.print(sb5.append("Creating ").append(this.sourcesToCreate).append(" one at a time...").toString());
        try {
            CreateSourcesStep();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        alExit();
    }
}
