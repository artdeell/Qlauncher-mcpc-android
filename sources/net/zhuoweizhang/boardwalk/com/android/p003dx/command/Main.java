package net.zhuoweizhang.boardwalk.com.android.p003dx.command;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.Main */
public class Main {
    private static String USAGE_MESSAGE = "usage:\n  dx --dex [--debug] [--verbose] [--positions=<style>] [--no-locals]\n  [--no-optimize] [--statistics] [--[no-]optimize-list=<file>] [--no-strict]\n  [--keep-classes] [--output=<file>] [--dump-to=<file>] [--dump-width=<n>]\n  [--dump-method=<name>[*]] [--verbose-dump] [--no-files] [--core-library]\n  [--num-threads=<n>] [--incremental] [--force-jumbo]\n  [--multi-dex [--main-dex-list=<file> [--minimal-main-dex]]\n  [<file>.class | <file>.{zip,jar,apk} | <directory>] ...\n    Convert a set of classfiles into a dex file, optionally embedded in a\n    jar/zip. Output name must end with one of: .dex .jar .zip .apk or be a directory.\n    Positions options: none, important, lines.\n    --multi-dex: allows to generate several dex files if needed. This option is \n    exclusive with --incremental, causes --num-threads to be ignored and only\n    supports folder or archive output.\n    --main-dex-list=<file>: <file> is a list of class file names, classes defined by\n    those class files are put in classes.dex.\n    --minimal-main-dex: only classes selected by --main-dex-list are to be put in\n    the main dex.\n  dx --annotool --annotation=<class> [--element=<element types>]\n  [--print=<print types>]\n  dx --dump [--debug] [--strict] [--bytes] [--optimize]\n  [--basic-blocks | --rop-blocks | --ssa-blocks | --dot] [--ssa-step=<step>]\n  [--width=<n>] [<file>.class | <file>.txt] ...\n    Dump classfiles, or transformations thereof, in a human-oriented format.\n  dx --find-usages <file.dex> <declaring type> <member>\n    Find references and declarations to a field or method.\n    declaring type: a class name in internal form, like Ljava/lang/Object;\n    member: a field or method name, like hashCode\n  dx -J<option> ... <arguments, in one of the above forms>\n    Pass VM-specific options to the virtual machine that runs dx.\n  dx --version\n    Print the version of this tool (1.8).\n  dx --help\n    Print this message.";

    private Main() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r15) {
        /*
            r0 = r15
            r13 = 0
            r1 = r13
            r13 = 0
            r2 = r13
        L_0x0005:
            r13 = r2
            r14 = r0
            int r14 = r14.length     // Catch:{ UsageException -> 0x00c3, RuntimeException -> 0x00cb, Throwable -> 0x00e2 }
            if (r13 >= r14) goto L_0x0119
            r13 = r0
            r14 = r2
            r13 = r13[r14]     // Catch:{ UsageException -> 0x00c3, RuntimeException -> 0x00cb, Throwable -> 0x00e2 }
            r9 = r13
            r13 = r9
            java.lang.String r14 = "--"
            boolean r13 = r13.equals(r14)     // Catch:{ UsageException -> 0x00c3, RuntimeException -> 0x00cb, Throwable -> 0x00e2 }
            if (r13 != 0) goto L_0x0023
            r13 = r9
            java.lang.String r14 = "--"
            boolean r13 = r13.startsWith(r14)     // Catch:{ UsageException -> 0x00c3, RuntimeException -> 0x00cb, Throwable -> 0x00e2 }
            r10 = r13
            r13 = r10
            if (r13 != 0) goto L_0x0040
        L_0x0023:
            r13 = 0
            r8 = r13
            r13 = 1
            r5 = r13
        L_0x0027:
            r13 = r8
            r4 = r13
        L_0x0029:
            r13 = r4
            if (r13 != 0) goto L_0x0035
            java.io.PrintStream r13 = java.lang.System.err
            java.lang.String r14 = "error: no command specified"
            r13.println(r14)
            r13 = 1
            r5 = r13
        L_0x0035:
            r13 = r5
            if (r13 == 0) goto L_0x003f
            usage()
            r13 = 1
            java.lang.System.exit(r13)
        L_0x003f:
            return
        L_0x0040:
            r13 = r9
            java.lang.String r14 = "--dex"
            boolean r13 = r13.equals(r14)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            if (r13 == 0) goto L_0x0057
            r13 = r0
            r14 = r2
            java.lang.String[] r13 = without(r13, r14)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            net.zhuoweizhang.boardwalk.com.android.p003dx.command.dexer.Main.main(r13)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            r13 = 1
            r8 = r13
            r13 = 0
            r5 = r13
            goto L_0x0027
        L_0x0057:
            r13 = r9
            java.lang.String r14 = "--dump"
            boolean r13 = r13.equals(r14)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            if (r13 == 0) goto L_0x006e
            r13 = r0
            r14 = r2
            java.lang.String[] r13 = without(r13, r14)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            net.zhuoweizhang.boardwalk.com.android.p003dx.command.dump.Main.main(r13)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            r13 = 1
            r8 = r13
            r13 = 0
            r5 = r13
            goto L_0x0027
        L_0x006e:
            r13 = r9
            java.lang.String r14 = "--annotool"
            boolean r13 = r13.equals(r14)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            if (r13 == 0) goto L_0x0085
            r13 = r0
            r14 = r2
            java.lang.String[] r13 = without(r13, r14)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            net.zhuoweizhang.boardwalk.com.android.p003dx.command.annotool.Main.main(r13)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            r13 = 1
            r8 = r13
            r13 = 0
            r5 = r13
            goto L_0x0027
        L_0x0085:
            r13 = r9
            java.lang.String r14 = "--find-usages"
            boolean r13 = r13.equals(r14)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            if (r13 == 0) goto L_0x009c
            r13 = r0
            r14 = r2
            java.lang.String[] r13 = without(r13, r14)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            net.zhuoweizhang.boardwalk.com.android.p003dx.command.findusages.Main.main(r13)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            r13 = 1
            r8 = r13
            r13 = 0
            r5 = r13
            goto L_0x0027
        L_0x009c:
            r13 = r9
            java.lang.String r14 = "--version"
            boolean r13 = r13.equals(r14)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            if (r13 == 0) goto L_0x00ae
            version()     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            r13 = 1
            r8 = r13
            r13 = 0
            r5 = r13
            goto L_0x0027
        L_0x00ae:
            r13 = r9
            java.lang.String r14 = "--help"
            boolean r13 = r13.equals(r14)     // Catch:{ UsageException -> 0x0114, RuntimeException -> 0x010f, Throwable -> 0x010a }
            r12 = r13
            r13 = r12
            if (r13 == 0) goto L_0x00bf
            r13 = 1
            r5 = r13
            r13 = 1
            r8 = r13
            goto L_0x0027
        L_0x00bf:
            int r2 = r2 + 1
            goto L_0x0005
        L_0x00c3:
            r13 = move-exception
            r7 = r13
        L_0x00c5:
            r13 = r1
            r4 = r13
            r13 = 1
            r5 = r13
            goto L_0x0029
        L_0x00cb:
            r13 = move-exception
            r6 = r13
            r13 = 0
            r4 = r13
        L_0x00cf:
            java.io.PrintStream r13 = java.lang.System.err
            java.lang.String r14 = "\nUNEXPECTED TOP-LEVEL EXCEPTION:"
            r13.println(r14)
            r13 = r6
            r13.printStackTrace()
            r13 = 2
            java.lang.System.exit(r13)
            r13 = 0
            r5 = r13
            goto L_0x0029
        L_0x00e2:
            r13 = move-exception
            r3 = r13
            r13 = 0
            r4 = r13
        L_0x00e6:
            java.io.PrintStream r13 = java.lang.System.err
            java.lang.String r14 = "\nUNEXPECTED TOP-LEVEL ERROR:"
            r13.println(r14)
            r13 = r3
            r13.printStackTrace()
            r13 = r3
            boolean r13 = r13 instanceof java.lang.NoClassDefFoundError
            if (r13 != 0) goto L_0x00fb
            r13 = r3
            boolean r13 = r13 instanceof java.lang.NoSuchMethodError
            if (r13 == 0) goto L_0x0102
        L_0x00fb:
            java.io.PrintStream r13 = java.lang.System.err
            java.lang.String r14 = "Note: You may be using an incompatible virtual machine or class library.\n(This program is known to be incompatible with recent releases of GCJ.)"
            r13.println(r14)
        L_0x0102:
            r13 = 3
            java.lang.System.exit(r13)
            r13 = 0
            r5 = r13
            goto L_0x0029
        L_0x010a:
            r13 = move-exception
            r3 = r13
            r13 = 1
            r4 = r13
            goto L_0x00e6
        L_0x010f:
            r13 = move-exception
            r6 = r13
            r13 = 1
            r4 = r13
            goto L_0x00cf
        L_0x0114:
            r13 = move-exception
            r11 = r13
            r13 = 1
            r1 = r13
            goto L_0x00c5
        L_0x0119:
            r13 = 0
            r5 = r13
            r13 = 0
            r8 = r13
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.command.Main.main(java.lang.String[]):void");
    }

    private static void usage() {
        System.err.println(USAGE_MESSAGE);
    }

    private static void version() {
        System.err.println("dx version 1.8");
        System.exit(0);
    }

    private static String[] without(String[] strArr, int i) {
        String[] strArr2 = strArr;
        int i2 = i;
        int length = -1 + strArr2.length;
        String[] strArr3 = new String[length];
        System.arraycopy(strArr2, 0, strArr3, 0, i2);
        System.arraycopy(strArr2, i2 + 1, strArr3, i2, length - i2);
        return strArr3;
    }
}
