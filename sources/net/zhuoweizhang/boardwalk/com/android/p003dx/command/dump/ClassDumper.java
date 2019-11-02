package net.zhuoweizhang.boardwalk.com.android.p003dx.command.dump;

import java.io.PrintStream;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.DirectClassFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.StdAttributeFactory;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dump.ClassDumper */
public final class ClassDumper extends BaseDumper {
    private ClassDumper(byte[] bArr, PrintStream printStream, String str, Args args) {
        super(bArr, printStream, str, args);
    }

    public static void dump(byte[] bArr, PrintStream printStream, String str, Args args) {
        ClassDumper classDumper;
        ClassDumper classDumper2 = classDumper;
        ClassDumper classDumper3 = new ClassDumper(bArr, printStream, str, args);
        classDumper2.dump();
    }

    public void dump() {
        ByteArray byteArray;
        DirectClassFile directClassFile;
        byte[] bytes = getBytes();
        ByteArray byteArray2 = byteArray;
        ByteArray byteArray3 = new ByteArray(bytes);
        ByteArray byteArray4 = byteArray2;
        DirectClassFile directClassFile2 = directClassFile;
        DirectClassFile directClassFile3 = new DirectClassFile(byteArray4, getFilePath(), getStrictParse());
        DirectClassFile directClassFile4 = directClassFile2;
        directClassFile4.setAttributeFactory(StdAttributeFactory.THE_ONE);
        directClassFile4.setObserver(this);
        int magic = directClassFile4.getMagic();
        int at = getAt();
        if (at != bytes.length) {
            parsed(byteArray4, at, bytes.length - at, "<extra data at end of file>");
        }
    }
}
