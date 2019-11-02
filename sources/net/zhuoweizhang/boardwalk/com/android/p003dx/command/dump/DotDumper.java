package net.zhuoweizhang.boardwalk.com.android.p003dx.command.dump;

import java.io.PrintStream;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ConcreteMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.Ropper;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.DirectClassFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.StdAttributeFactory;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Member;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Method;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseObserver;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.AccessFlags;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlockList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.DexTranslationAdvice;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.Optimizer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dump.DotDumper */
public class DotDumper implements ParseObserver {
    private final Args args;
    private final byte[] bytes;
    private DirectClassFile classFile;
    private final String filePath;
    private final boolean optimize;
    private final boolean strictParse;

    DotDumper(byte[] bArr, String str, Args args2) {
        String str2 = str;
        Args args3 = args2;
        this.bytes = bArr;
        this.filePath = str2;
        this.strictParse = args3.strictParse;
        this.optimize = args3.optimize;
        this.args = args3;
    }

    static void dump(byte[] bArr, String str, Args args2) {
        DotDumper dotDumper;
        DotDumper dotDumper2 = dotDumper;
        DotDumper dotDumper3 = new DotDumper(bArr, str, args2);
        dotDumper2.run();
    }

    private void run() {
        ByteArray byteArray;
        DirectClassFile directClassFile;
        DirectClassFile directClassFile2;
        ByteArray byteArray2 = byteArray;
        ByteArray byteArray3 = new ByteArray(this.bytes);
        ByteArray byteArray4 = byteArray2;
        DirectClassFile directClassFile3 = directClassFile;
        DirectClassFile directClassFile4 = new DirectClassFile(byteArray4, this.filePath, this.strictParse);
        this.classFile = directClassFile3;
        this.classFile.setAttributeFactory(StdAttributeFactory.THE_ONE);
        int magic = this.classFile.getMagic();
        DirectClassFile directClassFile5 = directClassFile2;
        DirectClassFile directClassFile6 = new DirectClassFile(byteArray4, this.filePath, this.strictParse);
        DirectClassFile directClassFile7 = directClassFile5;
        directClassFile7.setAttributeFactory(StdAttributeFactory.THE_ONE);
        directClassFile7.setObserver(this);
        int magic2 = directClassFile7.getMagic();
    }

    public void changeIndent(int i) {
    }

    public void endParsingMember(ByteArray byteArray, int i, String str, String str2, Member member) {
        ConcreteMethod concreteMethod;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        ByteArray byteArray2 = byteArray;
        int i2 = i;
        String str3 = str;
        String str4 = str2;
        Member member2 = member;
        if ((member2 instanceof Method) && shouldDumpMethod(str3)) {
            ConcreteMethod concreteMethod2 = concreteMethod;
            ConcreteMethod concreteMethod3 = new ConcreteMethod((Method) member2, this.classFile, true, true);
            ConcreteMethod concreteMethod4 = concreteMethod2;
            DexTranslationAdvice dexTranslationAdvice = DexTranslationAdvice.THE_ONE;
            RopMethod convert = Ropper.convert(concreteMethod4, dexTranslationAdvice);
            if (this.optimize) {
                boolean isStatic = AccessFlags.isStatic(concreteMethod4.getAccessFlags());
                convert = Optimizer.optimize(convert, BaseDumper.computeParamWidth(concreteMethod4, isStatic), isStatic, true, dexTranslationAdvice);
            }
            PrintStream printStream = System.out;
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            printStream.println(sb8.append("digraph ").append(str3).append("{").toString());
            PrintStream printStream2 = System.out;
            StringBuilder sb10 = sb2;
            StringBuilder sb11 = new StringBuilder();
            printStream2.println(sb10.append("\tfirst -> n").append(Hex.m51u2(convert.getFirstLabel())).append(";").toString());
            BasicBlockList blocks = convert.getBlocks();
            int size = blocks.size();
            for (int i3 = 0; i3 < size; i3++) {
                BasicBlock basicBlock = blocks.get(i3);
                int label = basicBlock.getLabel();
                IntList successors = basicBlock.getSuccessors();
                if (successors.size() == 0) {
                    PrintStream printStream3 = System.out;
                    StringBuilder sb12 = sb7;
                    StringBuilder sb13 = new StringBuilder();
                    printStream3.println(sb12.append("\tn").append(Hex.m51u2(label)).append(" -> returns;").toString());
                } else if (successors.size() == 1) {
                    PrintStream printStream4 = System.out;
                    StringBuilder sb14 = sb6;
                    StringBuilder sb15 = new StringBuilder();
                    printStream4.println(sb14.append("\tn").append(Hex.m51u2(label)).append(" -> n").append(Hex.m51u2(successors.get(0))).append(";").toString());
                } else {
                    PrintStream printStream5 = System.out;
                    StringBuilder sb16 = sb3;
                    StringBuilder sb17 = new StringBuilder();
                    printStream5.print(sb16.append("\tn").append(Hex.m51u2(label)).append(" -> {").toString());
                    for (int i4 = 0; i4 < successors.size(); i4++) {
                        int i5 = successors.get(i4);
                        if (i5 != basicBlock.getPrimarySuccessor()) {
                            PrintStream printStream6 = System.out;
                            StringBuilder sb18 = sb5;
                            StringBuilder sb19 = new StringBuilder();
                            printStream6.print(sb18.append(" n").append(Hex.m51u2(i5)).append(" ").toString());
                        }
                    }
                    System.out.println("};");
                    PrintStream printStream7 = System.out;
                    StringBuilder sb20 = sb4;
                    StringBuilder sb21 = new StringBuilder();
                    printStream7.println(sb20.append("\tn").append(Hex.m51u2(label)).append(" -> n").append(Hex.m51u2(basicBlock.getPrimarySuccessor())).append(" [label=\"primary\"];").toString());
                }
            }
            System.out.println("}");
        }
    }

    public void parsed(ByteArray byteArray, int i, int i2, String str) {
    }

    /* access modifiers changed from: protected */
    public boolean shouldDumpMethod(String str) {
        return this.args.method == null || this.args.method.equals(str);
    }

    public void startParsingMember(ByteArray byteArray, int i, String str, String str2) {
    }
}
