package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassDef;
import net.zhuoweizhang.boardwalk.com.android.dex.Dex;
import net.zhuoweizhang.boardwalk.com.android.dex.FieldId;
import net.zhuoweizhang.boardwalk.com.android.dex.MethodId;
import net.zhuoweizhang.boardwalk.com.android.dex.ProtoId;
import net.zhuoweizhang.boardwalk.com.android.dex.TableOfContents;
import net.zhuoweizhang.boardwalk.com.android.dex.TableOfContents.Section;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.DexIndexPrinter */
public final class DexIndexPrinter {
    private final Dex dex;
    private final TableOfContents tableOfContents = this.dex.getTableOfContents();

    public DexIndexPrinter(File file) throws IOException {
        Dex dex2;
        Dex dex3 = dex2;
        Dex dex4 = new Dex(file);
        this.dex = dex3;
    }

    public static void main(String[] strArr) throws IOException {
        DexIndexPrinter dexIndexPrinter;
        File file;
        DexIndexPrinter dexIndexPrinter2 = dexIndexPrinter;
        File file2 = file;
        File file3 = new File(strArr[0]);
        DexIndexPrinter dexIndexPrinter3 = new DexIndexPrinter(file2);
        DexIndexPrinter dexIndexPrinter4 = dexIndexPrinter2;
        dexIndexPrinter4.printMap();
        dexIndexPrinter4.printStrings();
        dexIndexPrinter4.printTypeIds();
        dexIndexPrinter4.printProtoIds();
        dexIndexPrinter4.printFieldIds();
        dexIndexPrinter4.printMethodIds();
        dexIndexPrinter4.printTypeLists();
        dexIndexPrinter4.printClassDefs();
    }

    private void printClassDefs() {
        StringBuilder sb;
        int i = 0;
        for (ClassDef classDef : this.dex.classDefs()) {
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("class def ").append(i).append(": ").append(classDef).toString());
            i++;
        }
    }

    private void printFieldIds() throws IOException {
        StringBuilder sb;
        int i = 0;
        for (FieldId fieldId : this.dex.fieldIds()) {
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("field ").append(i).append(": ").append(fieldId).toString());
            i++;
        }
    }

    private void printMap() {
        StringBuilder sb;
        Section[] sectionArr = this.tableOfContents.sections;
        int length = sectionArr.length;
        for (int i = 0; i < length; i++) {
            Section section = sectionArr[i];
            if (section.off != -1) {
                PrintStream printStream = System.out;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                printStream.println(sb2.append("section ").append(Integer.toHexString(section.type)).append(" off=").append(Integer.toHexString(section.off)).append(" size=").append(Integer.toHexString(section.size)).append(" byteCount=").append(Integer.toHexString(section.byteCount)).toString());
            }
        }
    }

    private void printMethodIds() throws IOException {
        StringBuilder sb;
        int i = 0;
        for (MethodId methodId : this.dex.methodIds()) {
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("methodId ").append(i).append(": ").append(methodId).toString());
            i++;
        }
    }

    private void printProtoIds() throws IOException {
        StringBuilder sb;
        int i = 0;
        for (ProtoId protoId : this.dex.protoIds()) {
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("proto ").append(i).append(": ").append(protoId).toString());
            i++;
        }
    }

    private void printStrings() throws IOException {
        StringBuilder sb;
        int i = 0;
        for (String str : this.dex.strings()) {
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("string ").append(i).append(": ").append(str).toString());
            i++;
        }
    }

    private void printTypeIds() throws IOException {
        StringBuilder sb;
        int i = 0;
        for (Integer num : this.dex.typeIds()) {
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("type ").append(i).append(": ").append((String) this.dex.strings().get(num.intValue())).toString());
            i++;
        }
    }

    private void printTypeLists() throws IOException {
        StringBuilder sb;
        StringBuilder sb2;
        if (this.tableOfContents.typeLists.off == -1) {
            System.out.println("No type lists");
            return;
        }
        Dex.Section open = this.dex.open(this.tableOfContents.typeLists.off);
        for (int i = 0; i < this.tableOfContents.typeLists.size; i++) {
            int readInt = open.readInt();
            PrintStream printStream = System.out;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            printStream.print(sb3.append("Type list i=").append(i).append(", size=").append(readInt).append(", elements=").toString());
            for (int i2 = 0; i2 < readInt; i2++) {
                PrintStream printStream2 = System.out;
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                printStream2.print(sb5.append(" ").append((String) this.dex.typeNames().get(open.readShort())).toString());
            }
            if (readInt % 2 == 1) {
                short readShort = open.readShort();
            }
            System.out.println();
        }
    }
}
