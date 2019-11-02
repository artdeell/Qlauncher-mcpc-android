package net.zhuoweizhang.boardwalk.com.android.p003dx.command.dexer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.dex.Dex;
import net.zhuoweizhang.boardwalk.com.android.dex.DexException;
import net.zhuoweizhang.boardwalk.com.android.dex.DexFormat;
import net.zhuoweizhang.boardwalk.com.android.dex.util.FileUtils;
import net.zhuoweizhang.boardwalk.com.android.p003dx.command.DxConsole;
import net.zhuoweizhang.boardwalk.com.android.p003dx.command.UsageException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.DexOptions;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.ClassDefItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.DexFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.EncodedMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.p005cf.CfOptions;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.p005cf.CfTranslator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.merge.CollisionPolicy;
import net.zhuoweizhang.boardwalk.com.android.p003dx.merge.DexMerger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.SimException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.ClassPathOpener;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.ClassPathOpener.Consumer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.ClassPathOpener.FileNameFilter;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.DirectClassFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.StdAttributeFactory;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotation;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationsList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main */
public class Main {
    static final /* synthetic */ boolean $assertionsDisabled = (!Main.class.desiredAssertionStatus());
    private static final Name CREATED_BY;
    private static final String DEX_EXTENSION = ".dex";
    private static final String DEX_PREFIX = "classes";
    private static final String IN_RE_CORE_CLASSES = "Ill-advised or mistaken usage of a core class (java.* or javax.*)\nwhen not building a core library.\n\nThis is often due to inadvertently including a core library file\nin your application's project, when using an IDE (such as\nEclipse). If you are sure you're not intentionally defining a\ncore class, then this is the most likely explanation of what's\ngoing on.\n\nHowever, you might actually be trying to define a class in a core\nnamespace, the source of which you may have taken, for example,\nfrom a non-Android virtual machine project. This will most\nassuredly not work. At a minimum, it jeopardizes the\ncompatibility of your app with future versions of the platform.\nIt is also often of questionable legality.\n\nIf you really intend to build a core library -- which is only\nappropriate as part of creating a full virtual machine\ndistribution, as opposed to compiling an application -- then use\nthe \"--core-library\" option to suppress this error message.\n\nIf you go ahead and use \"--core-library\" but are in fact\nbuilding an application, then be forewarned that your application\nwill still fail to build or run, at some point. Please be\nprepared for angry customers who find, for example, that your\napplication ceases to function once they upgrade their operating\nsystem. You will be to blame for this problem.\n\nIf you are legitimately using some code that happens to be in a\ncore package, then the easiest safe alternative you have is to\nrepackage that code. That is, move the classes in question into\nyour own package namespace. This means that they will never be in\nconflict with core system classes. JarJar is a tool that may help\nyou in this endeavor. If you find that you cannot do this, then\nthat is an indication that the path you are on will ultimately\nlead to pain, suffering, grief, and lamentation.\n";
    private static final String[] JAVAX_CORE;
    private static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    private static boolean anyFilesProcessed;
    /* access modifiers changed from: private */
    public static Arguments args;
    /* access modifiers changed from: private */
    public static Set<String> classesInMainDex = null;
    private static List<byte[]> dexOutputArrays;
    private static int errors = 0;
    private static OutputStreamWriter humanOutWriter = null;
    private static final List<byte[]> libraryDexBuffers;
    private static long minimumFileAge = 0;
    private static DexFile outputDex;
    private static TreeMap<String, byte[]> outputResources;
    /* access modifiers changed from: private */
    public static ExecutorService threadPool;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments */
    public static class Arguments {
        private static final String INCREMENTAL_OPTION = "--incremental";
        private static final String MAIN_DEX_LIST_OPTION = "--main-dex-list";
        private static final String MINIMAL_MAIN_DEX_OPTION = "--minimal-main-dex";
        private static final String MULTI_DEX_OPTION = "--multi-dex";
        private static final String NUM_THREADS_OPTION = "--num-threads";
        public CfOptions cfOptions;
        public boolean coreLibrary = false;
        public boolean debug = false;
        public DexOptions dexOptions;
        public String dontOptimizeListFile = null;
        public int dumpWidth = 0;
        public boolean emptyOk = false;
        public String[] fileNames;
        public boolean forceJumbo = false;
        public String humanOutName = null;
        public boolean incremental = false;
        public boolean jarOutput = false;
        public boolean keepClassesInJar = false;
        public boolean localInfo = true;
        public String mainDexListFile = null;
        /* access modifiers changed from: private */
        public int maxNumberOfIdxPerDex = 65536;
        public String methodToDump = null;
        public boolean minimalMainDex = false;
        public boolean multiDex = false;
        public int numThreads = 1;
        public boolean optimize = true;
        public String optimizeListFile = null;
        public String outName = null;
        public int positionInfo = 2;
        public boolean statistics;
        public boolean strictNameCheck = true;
        public boolean verbose = false;
        public boolean verboseDump = false;

        /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments$ArgumentsParser */
        private static class ArgumentsParser {
            private final String[] arguments;
            private String current;
            private int index = 0;
            private String lastValue;

            public ArgumentsParser(String[] strArr) {
                this.arguments = strArr;
            }

            private boolean getNextValue() {
                if (this.index >= this.arguments.length) {
                    return false;
                }
                this.current = this.arguments[this.index];
                this.index = 1 + this.index;
                return true;
            }

            public String getCurrent() {
                return this.current;
            }

            public String getLastValue() {
                return this.lastValue;
            }

            public boolean getNext() {
                if (this.index < this.arguments.length) {
                    this.current = this.arguments[this.index];
                    if (!this.current.equals("--") && this.current.startsWith("--")) {
                        this.index = 1 + this.index;
                        return true;
                    }
                }
                return false;
            }

            public String[] getRemaining() {
                int length = this.arguments.length - this.index;
                String[] strArr = new String[length];
                if (length > 0) {
                    System.arraycopy(this.arguments, this.index, strArr, 0, length);
                }
                return strArr;
            }

            public boolean isArg(String str) {
                StringBuilder sb;
                UsageException usageException;
                String str2 = str;
                int length = str2.length();
                if (length <= 0 || str2.charAt(length - 1) != '=') {
                    return this.current.equals(str2);
                }
                if (this.current.startsWith(str2)) {
                    this.lastValue = this.current.substring(length);
                    return true;
                }
                String substring = str2.substring(0, length - 1);
                if (!this.current.equals(substring)) {
                    return false;
                }
                if (getNextValue()) {
                    this.lastValue = this.current;
                    return true;
                }
                PrintStream printStream = System.err;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                printStream.println(sb2.append("Missing value after parameter ").append(substring).toString());
                UsageException usageException2 = usageException;
                UsageException usageException3 = new UsageException();
                throw usageException2;
            }
        }

        public Arguments() {
        }

        /* access modifiers changed from: private */
        public void makeOptionsObjects() {
            CfOptions cfOptions2;
            DexOptions dexOptions2;
            CfOptions cfOptions3 = cfOptions2;
            CfOptions cfOptions4 = new CfOptions();
            this.cfOptions = cfOptions3;
            this.cfOptions.positionInfo = this.positionInfo;
            this.cfOptions.localInfo = this.localInfo;
            this.cfOptions.strictNameCheck = this.strictNameCheck;
            this.cfOptions.optimize = this.optimize;
            this.cfOptions.optimizeListFile = this.optimizeListFile;
            this.cfOptions.dontOptimizeListFile = this.dontOptimizeListFile;
            this.cfOptions.statistics = this.statistics;
            this.cfOptions.warn = DxConsole.err;
            DexOptions dexOptions3 = dexOptions2;
            DexOptions dexOptions4 = new DexOptions();
            this.dexOptions = dexOptions3;
            this.dexOptions.forceJumbo = this.forceJumbo;
        }

        public void parse(String[] strArr) {
            ArgumentsParser argumentsParser;
            File file;
            StringBuilder sb;
            UsageException usageException;
            UsageException usageException2;
            UsageException usageException3;
            UsageException usageException4;
            UsageException usageException5;
            StringBuilder sb2;
            UsageException usageException6;
            StringBuilder sb3;
            UsageException usageException7;
            File file2;
            StringBuilder sb4;
            UsageException usageException8;
            UsageException usageException9;
            UsageException usageException10;
            ArgumentsParser argumentsParser2 = argumentsParser;
            ArgumentsParser argumentsParser3 = new ArgumentsParser(strArr);
            ArgumentsParser argumentsParser4 = argumentsParser2;
            boolean z = false;
            boolean z2 = false;
            while (argumentsParser4.getNext()) {
                if (argumentsParser4.isArg("--debug")) {
                    this.debug = true;
                } else if (argumentsParser4.isArg("--verbose")) {
                    this.verbose = true;
                } else if (argumentsParser4.isArg("--verbose-dump")) {
                    this.verboseDump = true;
                } else if (argumentsParser4.isArg("--no-files")) {
                    this.emptyOk = true;
                } else if (argumentsParser4.isArg("--no-optimize")) {
                    this.optimize = false;
                } else if (argumentsParser4.isArg("--no-strict")) {
                    this.strictNameCheck = false;
                } else if (argumentsParser4.isArg("--core-library")) {
                    this.coreLibrary = true;
                } else if (argumentsParser4.isArg("--statistics")) {
                    this.statistics = true;
                } else if (argumentsParser4.isArg("--optimize-list=")) {
                    if (this.dontOptimizeListFile != null) {
                        System.err.println("--optimize-list and --no-optimize-list are incompatible.");
                        UsageException usageException11 = usageException10;
                        UsageException usageException12 = new UsageException();
                        throw usageException11;
                    }
                    this.optimize = true;
                    this.optimizeListFile = argumentsParser4.getLastValue();
                } else if (argumentsParser4.isArg("--no-optimize-list=")) {
                    if (this.dontOptimizeListFile != null) {
                        System.err.println("--optimize-list and --no-optimize-list are incompatible.");
                        UsageException usageException13 = usageException9;
                        UsageException usageException14 = new UsageException();
                        throw usageException13;
                    }
                    this.optimize = true;
                    this.dontOptimizeListFile = argumentsParser4.getLastValue();
                } else if (argumentsParser4.isArg("--keep-classes")) {
                    this.keepClassesInJar = true;
                } else if (argumentsParser4.isArg("--output=")) {
                    this.outName = argumentsParser4.getLastValue();
                    File file3 = file2;
                    File file4 = new File(this.outName);
                    if (file3.isDirectory()) {
                        this.jarOutput = false;
                        z2 = true;
                    } else if (FileUtils.hasArchiveSuffix(this.outName)) {
                        this.jarOutput = true;
                    } else if (this.outName.endsWith(Main.DEX_EXTENSION) || this.outName.equals("-")) {
                        this.jarOutput = false;
                        z = true;
                    } else {
                        PrintStream printStream = System.err;
                        StringBuilder sb5 = sb4;
                        StringBuilder sb6 = new StringBuilder();
                        printStream.println(sb5.append("unknown output extension: ").append(this.outName).toString());
                        UsageException usageException15 = usageException8;
                        UsageException usageException16 = new UsageException();
                        throw usageException15;
                    }
                } else if (argumentsParser4.isArg("--dump-to=")) {
                    this.humanOutName = argumentsParser4.getLastValue();
                } else if (argumentsParser4.isArg("--dump-width=")) {
                    this.dumpWidth = Integer.parseInt(argumentsParser4.getLastValue());
                } else if (argumentsParser4.isArg("--dump-method=")) {
                    this.methodToDump = argumentsParser4.getLastValue();
                    this.jarOutput = false;
                } else if (argumentsParser4.isArg("--positions=")) {
                    String intern = argumentsParser4.getLastValue().intern();
                    if (intern == "none") {
                        this.positionInfo = 1;
                    } else if (intern == "important") {
                        this.positionInfo = 3;
                    } else if (intern == "lines") {
                        this.positionInfo = 2;
                    } else {
                        PrintStream printStream2 = System.err;
                        StringBuilder sb7 = sb3;
                        StringBuilder sb8 = new StringBuilder();
                        printStream2.println(sb7.append("unknown positions option: ").append(intern).toString());
                        UsageException usageException17 = usageException7;
                        UsageException usageException18 = new UsageException();
                        throw usageException17;
                    }
                } else if (argumentsParser4.isArg("--no-locals")) {
                    this.localInfo = false;
                } else if (argumentsParser4.isArg("--num-threads=")) {
                    this.numThreads = Integer.parseInt(argumentsParser4.getLastValue());
                } else if (argumentsParser4.isArg(INCREMENTAL_OPTION)) {
                    this.incremental = true;
                } else if (argumentsParser4.isArg("--force-jumbo")) {
                    this.forceJumbo = true;
                } else if (argumentsParser4.isArg(MULTI_DEX_OPTION)) {
                    this.multiDex = true;
                } else if (argumentsParser4.isArg("--main-dex-list=")) {
                    this.mainDexListFile = argumentsParser4.getLastValue();
                } else if (argumentsParser4.isArg(MINIMAL_MAIN_DEX_OPTION)) {
                    this.minimalMainDex = true;
                } else if (argumentsParser4.isArg("--set-max-idx-number=")) {
                    this.maxNumberOfIdxPerDex = Integer.parseInt(argumentsParser4.getLastValue());
                } else {
                    PrintStream printStream3 = System.err;
                    StringBuilder sb9 = sb2;
                    StringBuilder sb10 = new StringBuilder();
                    printStream3.println(sb9.append("unknown option: ").append(argumentsParser4.getCurrent()).toString());
                    UsageException usageException19 = usageException6;
                    UsageException usageException20 = new UsageException();
                    throw usageException19;
                }
            }
            this.fileNames = argumentsParser4.getRemaining();
            if (this.fileNames.length == 0) {
                if (!this.emptyOk) {
                    System.err.println("no input files specified");
                    UsageException usageException21 = usageException5;
                    UsageException usageException22 = new UsageException();
                    throw usageException21;
                }
            } else if (this.emptyOk) {
                System.out.println("ignoring input files");
            }
            if (this.humanOutName == null && this.methodToDump != null) {
                this.humanOutName = "-";
            }
            if (this.mainDexListFile != null && !this.multiDex) {
                System.err.println("--main-dex-list is only supported in combination with --multi-dex");
                UsageException usageException23 = usageException4;
                UsageException usageException24 = new UsageException();
                throw usageException23;
            } else if (!this.minimalMainDex || (this.mainDexListFile != null && this.multiDex)) {
                if (this.multiDex && this.numThreads != 1) {
                    System.out.println("--num-threads is ignored when used with --multi-dex");
                    this.numThreads = 1;
                }
                if (this.multiDex && this.incremental) {
                    System.err.println("--incremental is not supported with --multi-dex");
                    UsageException usageException25 = usageException2;
                    UsageException usageException26 = new UsageException();
                    throw usageException25;
                } else if (!this.multiDex || !z) {
                    if (z2 && !this.multiDex) {
                        File file5 = file;
                        File file6 = new File(this.outName, DexFormat.DEX_IN_JAR_NAME);
                        this.outName = file5.getPath();
                    }
                    makeOptionsObjects();
                } else {
                    PrintStream printStream4 = System.err;
                    StringBuilder sb11 = sb;
                    StringBuilder sb12 = new StringBuilder();
                    printStream4.println(sb11.append("Unsupported output \"").append(this.outName).append("\". ").append(MULTI_DEX_OPTION).append(" supports only archive or directory output").toString());
                    UsageException usageException27 = usageException;
                    UsageException usageException28 = new UsageException();
                    throw usageException27;
                }
            } else {
                System.err.println("--minimal-main-dex is only supported in combination with --multi-dex and --main-dex-list");
                UsageException usageException29 = usageException3;
                UsageException usageException30 = new UsageException();
                throw usageException29;
            }
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$BestEffortMainDexListFilter */
    private static class BestEffortMainDexListFilter implements FileNameFilter {
        Map<String, List<String>> map;

        /* JADX WARNING: type inference failed for: r5v15, types: [java.util.List] */
        /* JADX WARNING: type inference failed for: r4v0 */
        /* JADX WARNING: type inference failed for: r5v16 */
        /* JADX WARNING: type inference failed for: r4v1 */
        /* JADX WARNING: type inference failed for: r5v17, types: [java.util.List] */
        /* JADX WARNING: type inference failed for: r8v1 */
        /* JADX WARNING: type inference failed for: r5v20 */
        /* JADX WARNING: type inference failed for: r4v2 */
        /* JADX WARNING: type inference failed for: r7v2, types: [java.lang.Object] */
        /* JADX WARNING: type inference failed for: r4v3 */
        /* JADX WARNING: type inference failed for: r4v4 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 9 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public BestEffortMainDexListFilter() {
            /*
                r9 = this;
                r0 = r9
                r5 = r0
                r5.<init>()
                r5 = r0
                java.util.HashMap r6 = new java.util.HashMap
                r8 = r6
                r6 = r8
                r7 = r8
                r7.<init>()
                r5.map = r6
                java.util.Set r5 = net.zhuoweizhang.boardwalk.com.android.p003dx.command.dexer.Main.classesInMainDex
                java.util.Iterator r5 = r5.iterator()
                r1 = r5
            L_0x0019:
                r5 = r1
                boolean r5 = r5.hasNext()
                if (r5 == 0) goto L_0x005a
                r5 = r1
                java.lang.Object r5 = r5.next()
                java.lang.String r5 = (java.lang.String) r5
                java.lang.String r5 = net.zhuoweizhang.boardwalk.com.android.p003dx.command.dexer.Main.fixPath(r5)
                r2 = r5
                r5 = r2
                java.lang.String r5 = getSimpleName(r5)
                r3 = r5
                r5 = r0
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> r5 = r5.map
                r6 = r3
                java.lang.Object r5 = r5.get(r6)
                java.util.List r5 = (java.util.List) r5
                r4 = r5
                r5 = r4
                if (r5 != 0) goto L_0x0053
                java.util.ArrayList r5 = new java.util.ArrayList
                r8 = r5
                r5 = r8
                r6 = r8
                r7 = 1
                r6.<init>(r7)
                r4 = r5
                r5 = r0
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> r5 = r5.map
                r6 = r3
                r7 = r4
                java.lang.Object r5 = r5.put(r6, r7)
            L_0x0053:
                r5 = r4
                r6 = r2
                boolean r5 = r5.add(r6)
                goto L_0x0019
            L_0x005a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.command.dexer.Main.BestEffortMainDexListFilter.<init>():void");
        }

        private static String getSimpleName(String str) {
            String str2 = str;
            int lastIndexOf = str2.lastIndexOf(47);
            if (lastIndexOf >= 0) {
                str2 = str2.substring(lastIndexOf + 1);
            }
            return str2;
        }

        public boolean accept(String str) {
            String str2 = str;
            if (!str2.endsWith(".class")) {
                return true;
            }
            String access$1000 = Main.fixPath(str2);
            List<String> list = (List) this.map.get(getSimpleName(access$1000));
            if (list != null) {
                for (String endsWith : list) {
                    if (access$1000.endsWith(endsWith)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$MainDexListFilter */
    private static class MainDexListFilter implements FileNameFilter {
        private MainDexListFilter() {
        }

        /* synthetic */ MainDexListFilter(C06571 r4) {
            C06571 r1 = r4;
            this();
        }

        public boolean accept(String str) {
            String str2 = str;
            if (!str2.endsWith(".class")) {
                return true;
            }
            return Main.classesInMainDex.contains(Main.fixPath(str2));
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$NotFilter */
    private static class NotFilter implements FileNameFilter {
        private final FileNameFilter filter;

        private NotFilter(FileNameFilter fileNameFilter) {
            this.filter = fileNameFilter;
        }

        /* synthetic */ NotFilter(FileNameFilter fileNameFilter, C06571 r7) {
            C06571 r2 = r7;
            this(fileNameFilter);
        }

        public boolean accept(String str) {
            return !this.filter.accept(str);
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$ParallelProcessor */
    private static class ParallelProcessor implements Runnable {
        byte[] bytes;
        long lastModified;
        String path;

        private ParallelProcessor(String str, long j, byte[] bArr) {
            long j2 = j;
            byte[] bArr2 = bArr;
            this.path = str;
            this.lastModified = j2;
            this.bytes = bArr2;
        }

        /* synthetic */ ParallelProcessor(String str, long j, byte[] bArr, C06571 r16) {
            C06571 r5 = r16;
            this(str, j, bArr);
        }

        public void run() {
            if (Main.processFileBytes(this.path, this.lastModified, this.bytes)) {
                boolean access$1202 = Main.access$1202(true);
            }
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$StopProcessing */
    private static class StopProcessing extends RuntimeException {
        private StopProcessing() {
        }

        /* synthetic */ StopProcessing(C06571 r4) {
            C06571 r1 = r4;
            this();
        }
    }

    static {
        Name name;
        ArrayList arrayList;
        ArrayList arrayList2;
        Name name2 = name;
        Name name3 = new Name("Created-By");
        CREATED_BY = name2;
        String[] strArr = new String[15];
        String[] strArr2 = strArr;
        strArr[0] = "accessibility";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "crypto";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = "imageio";
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[3] = "management";
        String[] strArr9 = strArr8;
        String[] strArr10 = strArr9;
        strArr9[4] = "naming";
        String[] strArr11 = strArr10;
        String[] strArr12 = strArr11;
        strArr11[5] = "net";
        String[] strArr13 = strArr12;
        String[] strArr14 = strArr13;
        strArr13[6] = "print";
        String[] strArr15 = strArr14;
        String[] strArr16 = strArr15;
        strArr15[7] = "rmi";
        String[] strArr17 = strArr16;
        String[] strArr18 = strArr17;
        strArr17[8] = "security";
        String[] strArr19 = strArr18;
        String[] strArr20 = strArr19;
        strArr19[9] = "sip";
        String[] strArr21 = strArr20;
        String[] strArr22 = strArr21;
        strArr21[10] = "sound";
        String[] strArr23 = strArr22;
        String[] strArr24 = strArr23;
        strArr23[11] = "sql";
        String[] strArr25 = strArr24;
        String[] strArr26 = strArr25;
        strArr25[12] = "swing";
        String[] strArr27 = strArr26;
        String[] strArr28 = strArr27;
        strArr27[13] = "transaction";
        String[] strArr29 = strArr28;
        String[] strArr30 = strArr29;
        strArr29[14] = "xml";
        JAVAX_CORE = strArr30;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = new ArrayList();
        libraryDexBuffers = arrayList3;
        ArrayList arrayList5 = arrayList2;
        ArrayList arrayList6 = new ArrayList();
        dexOutputArrays = arrayList5;
    }

    private Main() {
    }

    static /* synthetic */ boolean access$1202(boolean z) {
        boolean z2 = z;
        anyFilesProcessed = z2;
        return z2;
    }

    static /* synthetic */ int access$708() {
        int i = errors;
        errors = i + 1;
        return i;
    }

    private static void checkClassName(String str) {
        StringBuilder sb;
        StopProcessing stopProcessing;
        String str2 = str;
        boolean z = true;
        if (!str2.startsWith("java/")) {
            if (str2.startsWith("javax/")) {
                int indexOf = str2.indexOf(47, 6);
                if (indexOf != -1) {
                    if (Arrays.binarySearch(JAVAX_CORE, str2.substring(6, indexOf)) < 0) {
                        z = false;
                    }
                }
            } else {
                z = false;
            }
        }
        if (z) {
            PrintStream printStream = DxConsole.err;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("\ntrouble processing \"").append(str2).append("\":\n\n").append(IN_RE_CORE_CLASSES).toString());
            errors = 1 + errors;
            StopProcessing stopProcessing2 = stopProcessing;
            StopProcessing stopProcessing3 = new StopProcessing(null);
            throw stopProcessing2;
        }
    }

    private static void closeOutput(OutputStream outputStream) throws IOException {
        OutputStream outputStream2 = outputStream;
        if (outputStream2 != null) {
            outputStream2.flush();
            if (outputStream2 != System.out) {
                outputStream2.close();
            }
        }
    }

    private static void createDexFile() {
        DexFile dexFile;
        if (outputDex != null) {
            boolean add = dexOutputArrays.add(writeDex());
        }
        DexFile dexFile2 = dexFile;
        DexFile dexFile3 = new DexFile(args.dexOptions);
        outputDex = dexFile2;
        if (args.dumpWidth != 0) {
            outputDex.setDumpWidth(args.dumpWidth);
        }
    }

    private static boolean createJar(String str) {
        StringBuilder sb;
        OutputStream openOutput;
        JarOutputStream jarOutputStream;
        JarOutputStream jarOutputStream2;
        JarEntry jarEntry;
        StringBuilder sb2;
        String str2 = str;
        try {
            Manifest makeManifest = makeManifest();
            openOutput = openOutput(str2);
            JarOutputStream jarOutputStream3 = jarOutputStream;
            JarOutputStream jarOutputStream4 = new JarOutputStream(openOutput, makeManifest);
            jarOutputStream2 = jarOutputStream3;
            for (Entry entry : outputResources.entrySet()) {
                String str3 = (String) entry.getKey();
                byte[] bArr = (byte[]) entry.getValue();
                JarEntry jarEntry2 = jarEntry;
                JarEntry jarEntry3 = new JarEntry(str3);
                JarEntry jarEntry4 = jarEntry2;
                int length = bArr.length;
                if (args.verbose) {
                    PrintStream printStream = DxConsole.out;
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    printStream.println(sb3.append("writing ").append(str3).append("; size ").append(length).append("...").toString());
                }
                jarEntry4.setSize((long) length);
                jarOutputStream2.putNextEntry(jarEntry4);
                jarOutputStream2.write(bArr);
                jarOutputStream2.closeEntry();
            }
            jarOutputStream2.finish();
            jarOutputStream2.flush();
            closeOutput(openOutput);
            return true;
        } catch (Exception e) {
            Exception exc = e;
            if (args.debug) {
                DxConsole.err.println("\ntrouble writing output:");
                exc.printStackTrace(DxConsole.err);
            } else {
                PrintStream printStream2 = DxConsole.err;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                printStream2.println(sb5.append("\ntrouble writing output: ").append(exc.getMessage()).toString());
            }
            return false;
        } catch (Throwable th) {
            Throwable th2 = th;
            jarOutputStream2.finish();
            jarOutputStream2.flush();
            closeOutput(openOutput);
            throw th2;
        }
    }

    private static void dumpMethod(DexFile dexFile, String str, OutputStreamWriter outputStreamWriter) {
        StringBuilder sb;
        TreeMap treeMap;
        PrintWriter printWriter;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        DexFile dexFile2 = dexFile;
        String str2 = str;
        OutputStreamWriter outputStreamWriter2 = outputStreamWriter;
        boolean endsWith = str2.endsWith("*");
        int lastIndexOf = str2.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf == -1 + str2.length()) {
            PrintStream printStream = DxConsole.err;
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            printStream.println(sb8.append("bogus fully-qualified method name: ").append(str2).toString());
            return;
        }
        String replace = str2.substring(0, lastIndexOf).replace('.', ClassPathElement.SEPARATOR_CHAR);
        String substring = str2.substring(lastIndexOf + 1);
        ClassDefItem classOrNull = dexFile2.getClassOrNull(replace);
        if (classOrNull == null) {
            PrintStream printStream2 = DxConsole.err;
            StringBuilder sb10 = sb7;
            StringBuilder sb11 = new StringBuilder();
            printStream2.println(sb10.append("no such class: ").append(replace).toString());
            return;
        }
        String str3 = endsWith ? substring.substring(0, -1 + substring.length()) : substring;
        ArrayList methods = classOrNull.getMethods();
        TreeMap treeMap2 = treeMap;
        TreeMap treeMap3 = new TreeMap();
        TreeMap treeMap4 = treeMap2;
        Iterator it = methods.iterator();
        while (it.hasNext()) {
            EncodedMethod encodedMethod = (EncodedMethod) it.next();
            String string = encodedMethod.getName().getString();
            if ((endsWith && string.startsWith(str3)) || (!endsWith && string.equals(str3))) {
                Object put = treeMap4.put(encodedMethod.getRef().getNat(), encodedMethod);
            }
        }
        if (treeMap4.size() == 0) {
            PrintStream printStream3 = DxConsole.err;
            StringBuilder sb12 = sb6;
            StringBuilder sb13 = new StringBuilder();
            printStream3.println(sb12.append("no such method: ").append(str2).toString());
            return;
        }
        PrintWriter printWriter2 = printWriter;
        PrintWriter printWriter3 = new PrintWriter(outputStreamWriter2);
        PrintWriter printWriter4 = printWriter2;
        for (EncodedMethod encodedMethod2 : treeMap4.values()) {
            encodedMethod2.debugPrint(printWriter4, args.verboseDump);
            CstString sourceFile = classOrNull.getSourceFile();
            if (sourceFile != null) {
                PrintWriter printWriter5 = printWriter4;
                StringBuilder sb14 = sb5;
                StringBuilder sb15 = new StringBuilder();
                printWriter5.println(sb14.append("  source file: ").append(sourceFile.toQuoted()).toString());
            }
            Annotations methodAnnotations = classOrNull.getMethodAnnotations(encodedMethod2.getRef());
            AnnotationsList parameterAnnotations = classOrNull.getParameterAnnotations(encodedMethod2.getRef());
            if (methodAnnotations != null) {
                printWriter4.println("  method annotations:");
                for (Annotation annotation : methodAnnotations.getAnnotations()) {
                    PrintWriter printWriter6 = printWriter4;
                    StringBuilder sb16 = sb4;
                    StringBuilder sb17 = new StringBuilder();
                    printWriter6.println(sb16.append("    ").append(annotation).toString());
                }
            }
            if (parameterAnnotations != null) {
                printWriter4.println("  parameter annotations:");
                int size = parameterAnnotations.size();
                for (int i = 0; i < size; i++) {
                    PrintWriter printWriter7 = printWriter4;
                    StringBuilder sb18 = sb2;
                    StringBuilder sb19 = new StringBuilder();
                    printWriter7.println(sb18.append("    parameter ").append(i).toString());
                    for (Annotation annotation2 : parameterAnnotations.get(i).getAnnotations()) {
                        PrintWriter printWriter8 = printWriter4;
                        StringBuilder sb20 = sb3;
                        StringBuilder sb21 = new StringBuilder();
                        printWriter8.println(sb20.append("      ").append(annotation2).toString());
                    }
                }
            }
        }
        printWriter4.flush();
    }

    /* access modifiers changed from: private */
    public static String fixPath(String str) {
        String str2 = str;
        if (File.separatorChar == '\\') {
            str2 = str2.replace('\\', ClassPathElement.SEPARATOR_CHAR);
        }
        int lastIndexOf = str2.lastIndexOf("/./");
        if (lastIndexOf != -1) {
            str2 = str2.substring(lastIndexOf + 3);
        } else if (str2.startsWith("./")) {
            return str2.substring(2);
        }
        return str2;
    }

    private static String getDexFileName(int i) {
        StringBuilder sb;
        int i2 = i;
        if (i2 == 0) {
            return DexFormat.DEX_IN_JAR_NAME;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(DEX_PREFIX).append(i2 + 1).append(DEX_EXTENSION).toString();
    }

    public static String getTooManyIdsErrorMessage() {
        return args.multiDex ? "The list of classes given in --main-dex-list is too big and does not fit in the main dex." : "You may try using --multi-dex option.";
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Set<java.lang.String> loadMainDexListFile(java.lang.String r11) throws java.io.IOException {
        /*
            r0 = r11
            java.util.HashSet r5 = new java.util.HashSet
            r10 = r5
            r5 = r10
            r6 = r10
            r6.<init>()
            r1 = r5
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x0045 }
            r10 = r5
            r5 = r10
            r6 = r10
            java.io.FileReader r7 = new java.io.FileReader     // Catch:{ all -> 0x0045 }
            r10 = r7
            r7 = r10
            r8 = r10
            r9 = r0
            r8.<init>(r9)     // Catch:{ all -> 0x0045 }
            r6.<init>(r7)     // Catch:{ all -> 0x0045 }
            r2 = r5
        L_0x001c:
            r5 = r2
            java.lang.String r5 = r5.readLine()     // Catch:{ all -> 0x0030 }
            r4 = r5
            r5 = r4
            if (r5 == 0) goto L_0x003b
            r5 = r1
            r6 = r4
            java.lang.String r6 = fixPath(r6)     // Catch:{ all -> 0x0030 }
            boolean r5 = r5.add(r6)     // Catch:{ all -> 0x0030 }
            goto L_0x001c
        L_0x0030:
            r5 = move-exception
            r3 = r5
        L_0x0032:
            r5 = r2
            if (r5 == 0) goto L_0x0039
            r5 = r2
            r5.close()
        L_0x0039:
            r5 = r3
            throw r5
        L_0x003b:
            r5 = r2
            if (r5 == 0) goto L_0x0042
            r5 = r2
            r5.close()
        L_0x0042:
            r5 = r1
            r0 = r5
            return r0
        L_0x0045:
            r5 = move-exception
            r3 = r5
            r5 = 0
            r2 = r5
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.command.dexer.Main.loadMainDexListFile(java.lang.String):java.util.Set");
    }

    public static void main(String[] strArr) throws IOException {
        Arguments arguments;
        String[] strArr2 = strArr;
        Arguments arguments2 = arguments;
        Arguments arguments3 = new Arguments();
        Arguments arguments4 = arguments2;
        arguments4.parse(strArr2);
        int run = run(arguments4);
        if (run != 0) {
            System.exit(run);
        }
    }

    private static Manifest makeManifest() throws IOException {
        Manifest manifest;
        ByteArrayInputStream byteArrayInputStream;
        Manifest manifest2;
        Attributes mainAttributes;
        StringBuilder sb;
        String sb2;
        StringBuilder sb3;
        Manifest manifest3;
        byte[] bArr = (byte[]) outputResources.get(MANIFEST_NAME);
        if (bArr == null) {
            Manifest manifest4 = manifest3;
            Manifest manifest5 = new Manifest();
            manifest2 = manifest4;
            mainAttributes = manifest2.getMainAttributes();
            Object put = mainAttributes.put(Name.MANIFEST_VERSION, "1.0");
        } else {
            Manifest manifest6 = manifest;
            ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
            ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr);
            Manifest manifest7 = new Manifest(byteArrayInputStream2);
            manifest2 = manifest6;
            mainAttributes = manifest2.getMainAttributes();
            Object remove = outputResources.remove(MANIFEST_NAME);
        }
        String value = mainAttributes.getValue(CREATED_BY);
        if (value == null) {
            sb2 = LibrariesRepository.MOJANG_MAVEN_REPO;
        } else {
            StringBuilder sb4 = sb;
            StringBuilder sb5 = new StringBuilder();
            sb2 = sb4.append(value).append(" + ").toString();
        }
        StringBuilder sb6 = sb3;
        StringBuilder sb7 = new StringBuilder();
        Object put2 = mainAttributes.put(CREATED_BY, sb6.append(sb2).append("dx 1.8").toString());
        String putValue = mainAttributes.putValue("Dex-Location", DexFormat.DEX_IN_JAR_NAME);
        return manifest2;
    }

    private static byte[] mergeIncremental(byte[] bArr, File file) throws IOException {
        Dex dex;
        Dex dex2;
        DexMerger dexMerger;
        ByteArrayOutputStream byteArrayOutputStream;
        Dex dex3;
        Dex dex4;
        byte[] bArr2 = bArr;
        File file2 = file;
        if (bArr2 != null) {
            Dex dex5 = dex4;
            Dex dex6 = new Dex(bArr2);
            dex = dex5;
        } else {
            dex = null;
        }
        if (file2.exists()) {
            Dex dex7 = dex3;
            Dex dex8 = new Dex(file2);
            dex2 = dex7;
        } else {
            dex2 = null;
        }
        if (dex == null && dex2 == null) {
            return null;
        }
        if (dex == null) {
            dex = dex2;
        } else if (dex2 != null) {
            DexMerger dexMerger2 = dexMerger;
            DexMerger dexMerger3 = new DexMerger(dex, dex2, CollisionPolicy.KEEP_FIRST);
            dex = dexMerger2.merge();
        }
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
        dex.writeTo((OutputStream) byteArrayOutputStream4);
        return byteArrayOutputStream4.toByteArray();
    }

    private static byte[] mergeLibraryDexBuffers(byte[] bArr) throws IOException {
        DexMerger dexMerger;
        Dex dex;
        Dex dex2;
        byte[] bArr2 = bArr;
        for (byte[] bArr3 : libraryDexBuffers) {
            if (bArr2 == null) {
                bArr2 = bArr3;
            } else {
                DexMerger dexMerger2 = dexMerger;
                Dex dex3 = dex;
                Dex dex4 = new Dex(bArr2);
                Dex dex5 = dex2;
                Dex dex6 = new Dex(bArr3);
                DexMerger dexMerger3 = new DexMerger(dex3, dex5, CollisionPolicy.FAIL);
                bArr2 = dexMerger2.merge().getBytes();
            }
        }
        return bArr2;
    }

    private static OutputStream openOutput(String str) throws IOException {
        FileOutputStream fileOutputStream;
        String str2 = str;
        if (str2.equals("-") || str2.startsWith("-.")) {
            return System.out;
        }
        FileOutputStream fileOutputStream2 = fileOutputStream;
        FileOutputStream fileOutputStream3 = new FileOutputStream(str2);
        return fileOutputStream2;
    }

    /* JADX WARNING: type inference failed for: r16v2 */
    /* JADX WARNING: type inference failed for: r11v53 */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r14v1, types: [net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.ClassPathOpener$FileNameFilter] */
    /* JADX WARNING: type inference failed for: r12v28, types: [net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.ClassPathOpener$FileNameFilter] */
    /* JADX WARNING: type inference failed for: r16v5 */
    /* JADX WARNING: type inference failed for: r11v73 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean processAllFiles() {
        /*
            createDexFile()
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments r11 = args
            boolean r11 = r11.jarOutput
            if (r11 == 0) goto L_0x0016
            java.util.TreeMap r11 = new java.util.TreeMap
            r16 = r11
            r11 = r16
            r12 = r16
            r12.<init>()
            outputResources = r11
        L_0x0016:
            r11 = 0
            anyFilesProcessed = r11
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments r11 = args
            java.lang.String[] r11 = r11.fileNames
            r0 = r11
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments r11 = args
            int r11 = r11.numThreads
            r12 = 1
            if (r11 <= r12) goto L_0x002f
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments r11 = args
            int r11 = r11.numThreads
            java.util.concurrent.ExecutorService r11 = java.util.concurrent.Executors.newFixedThreadPool(r11)
            threadPool = r11
        L_0x002f:
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments r11 = args     // Catch:{ StopProcessing -> 0x006d }
            java.lang.String r11 = r11.mainDexListFile     // Catch:{ StopProcessing -> 0x006d }
            if (r11 == 0) goto L_0x016a
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments r11 = args     // Catch:{ StopProcessing -> 0x006d }
            boolean r11 = r11.strictNameCheck     // Catch:{ StopProcessing -> 0x006d }
            if (r11 == 0) goto L_0x0060
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$MainDexListFilter r11 = new net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$MainDexListFilter     // Catch:{ StopProcessing -> 0x006d }
            r16 = r11
            r11 = r16
            r12 = r16
            r13 = 0
            r12.<init>(r13)     // Catch:{ StopProcessing -> 0x006d }
            r8 = r11
        L_0x0048:
            r11 = 0
            r9 = r11
        L_0x004a:
            r11 = r9
            r12 = r0
            int r12 = r12.length     // Catch:{ StopProcessing -> 0x006d }
            if (r11 >= r12) goto L_0x00c3
            r11 = r0
            r12 = r9
            r11 = r11[r12]     // Catch:{ StopProcessing -> 0x006d }
            r12 = r8
            boolean r11 = processOne(r11, r12)     // Catch:{ StopProcessing -> 0x006d }
            if (r11 == 0) goto L_0x005d
            r11 = 1
            anyFilesProcessed = r11     // Catch:{ StopProcessing -> 0x006d }
        L_0x005d:
            int r9 = r9 + 1
            goto L_0x004a
        L_0x0060:
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$BestEffortMainDexListFilter r11 = new net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$BestEffortMainDexListFilter     // Catch:{ StopProcessing -> 0x006d }
            r16 = r11
            r11 = r16
            r12 = r16
            r12.<init>()     // Catch:{ StopProcessing -> 0x006d }
            r8 = r11
            goto L_0x0048
        L_0x006d:
            r11 = move-exception
            r1 = r11
        L_0x006f:
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments r11 = args
            int r11 = r11.numThreads
            r12 = 1
            if (r11 <= r12) goto L_0x0085
            java.util.concurrent.ExecutorService r11 = threadPool     // Catch:{ InterruptedException -> 0x011e }
            r11.shutdown()     // Catch:{ InterruptedException -> 0x011e }
            java.util.concurrent.ExecutorService r11 = threadPool     // Catch:{ InterruptedException -> 0x011e }
            r12 = 600(0x258, double:2.964E-321)
            java.util.concurrent.TimeUnit r14 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x011e }
            boolean r11 = r11.awaitTermination(r12, r14)     // Catch:{ InterruptedException -> 0x011e }
        L_0x0085:
            int r11 = errors
            if (r11 == 0) goto L_0x0133
            java.io.PrintStream r11 = net.zhuoweizhang.boardwalk.com.android.p003dx.command.DxConsole.err
            r2 = r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r16 = r11
            r11 = r16
            r12 = r16
            r12.<init>()
            int r12 = errors
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r12 = " error"
            java.lang.StringBuilder r11 = r11.append(r12)
            r3 = r11
            int r11 = errors
            r12 = 1
            if (r11 != r12) goto L_0x012e
            java.lang.String r11 = ""
            r4 = r11
        L_0x00ac:
            r11 = r2
            r12 = r3
            r13 = r4
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r13 = "; aborting"
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.println(r12)
            r11 = 0
            r0 = r11
        L_0x00c2:
            return r0
        L_0x00c3:
            java.util.List<byte[]> r11 = dexOutputArrays     // Catch:{ StopProcessing -> 0x006d }
            int r11 = r11.size()     // Catch:{ StopProcessing -> 0x006d }
            r12 = 1
            if (r11 <= r12) goto L_0x00da
            net.zhuoweizhang.boardwalk.com.android.dex.DexException r11 = new net.zhuoweizhang.boardwalk.com.android.dex.DexException     // Catch:{ StopProcessing -> 0x006d }
            r16 = r11
            r11 = r16
            r12 = r16
            java.lang.String r13 = "Too many classes in --main-dex-list, main dex capacity exceeded"
            r12.<init>(r13)     // Catch:{ StopProcessing -> 0x006d }
            throw r11     // Catch:{ StopProcessing -> 0x006d }
        L_0x00da:
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments r11 = args     // Catch:{ StopProcessing -> 0x006d }
            boolean r11 = r11.minimalMainDex     // Catch:{ StopProcessing -> 0x006d }
            if (r11 == 0) goto L_0x00e3
            createDexFile()     // Catch:{ StopProcessing -> 0x006d }
        L_0x00e3:
            r11 = 0
            r10 = r11
        L_0x00e5:
            r11 = r10
            r12 = r0
            int r12 = r12.length     // Catch:{ StopProcessing -> 0x006d }
            if (r11 >= r12) goto L_0x006f
            r11 = r0
            r12 = r10
            r11 = r11[r12]     // Catch:{ StopProcessing -> 0x006d }
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$NotFilter r12 = new net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$NotFilter     // Catch:{ StopProcessing -> 0x006d }
            r16 = r12
            r12 = r16
            r13 = r16
            r14 = r8
            r15 = 0
            r13.<init>(r14, r15)     // Catch:{ StopProcessing -> 0x006d }
            boolean r11 = processOne(r11, r12)     // Catch:{ StopProcessing -> 0x006d }
            if (r11 == 0) goto L_0x0104
            r11 = 1
            anyFilesProcessed = r11     // Catch:{ StopProcessing -> 0x006d }
        L_0x0104:
            int r10 = r10 + 1
            goto L_0x00e5
        L_0x0107:
            r11 = r7
            r12 = r0
            int r12 = r12.length     // Catch:{ StopProcessing -> 0x006d }
            if (r11 >= r12) goto L_0x006f
            r11 = r0
            r12 = r7
            r11 = r11[r12]     // Catch:{ StopProcessing -> 0x006d }
            net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.ClassPathOpener$FileNameFilter r12 = net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.ClassPathOpener.acceptAll     // Catch:{ StopProcessing -> 0x006d }
            boolean r11 = processOne(r11, r12)     // Catch:{ StopProcessing -> 0x006d }
            if (r11 == 0) goto L_0x011b
            r11 = 1
            anyFilesProcessed = r11     // Catch:{ StopProcessing -> 0x006d }
        L_0x011b:
            int r7 = r7 + 1
            goto L_0x0107
        L_0x011e:
            r11 = move-exception
            r5 = r11
            java.lang.RuntimeException r11 = new java.lang.RuntimeException
            r16 = r11
            r11 = r16
            r12 = r16
            java.lang.String r13 = "Timed out waiting for threads."
            r12.<init>(r13)
            throw r11
        L_0x012e:
            java.lang.String r11 = "s"
            r4 = r11
            goto L_0x00ac
        L_0x0133:
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments r11 = args
            boolean r11 = r11.incremental
            if (r11 == 0) goto L_0x0140
            boolean r11 = anyFilesProcessed
            if (r11 != 0) goto L_0x0140
            r11 = 1
            r0 = r11
            goto L_0x00c2
        L_0x0140:
            boolean r11 = anyFilesProcessed
            if (r11 != 0) goto L_0x0155
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments r11 = args
            boolean r11 = r11.emptyOk
            if (r11 != 0) goto L_0x0155
            java.io.PrintStream r11 = net.zhuoweizhang.boardwalk.com.android.p003dx.command.DxConsole.err
            java.lang.String r12 = "no classfiles specified"
            r11.println(r12)
            r11 = 0
            r0 = r11
            goto L_0x00c2
        L_0x0155:
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments r11 = args
            boolean r11 = r11.optimize
            if (r11 == 0) goto L_0x0166
            net.zhuoweizhang.boardwalk.com.android.dx.command.dexer.Main$Arguments r11 = args
            boolean r11 = r11.statistics
            if (r11 == 0) goto L_0x0166
            java.io.PrintStream r11 = net.zhuoweizhang.boardwalk.com.android.p003dx.command.DxConsole.out
            net.zhuoweizhang.boardwalk.com.android.p003dx.dex.p005cf.CodeStatistics.dumpStatistics(r11)
        L_0x0166:
            r11 = 1
            r0 = r11
            goto L_0x00c2
        L_0x016a:
            r11 = 0
            r7 = r11
            goto L_0x0107
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.command.dexer.Main.processAllFiles():boolean");
    }

    private static boolean processClass(String str, byte[] bArr) {
        DirectClassFile directClassFile;
        DexFile dexFile;
        String str2 = str;
        byte[] bArr2 = bArr;
        if (!args.coreLibrary) {
            checkClassName(str2);
        }
        DirectClassFile directClassFile2 = directClassFile;
        DirectClassFile directClassFile3 = new DirectClassFile(bArr2, str2, args.cfOptions.strictNameCheck);
        DirectClassFile directClassFile4 = directClassFile2;
        directClassFile4.setAttributeFactory(StdAttributeFactory.THE_ONE);
        int magic = directClassFile4.getMagic();
        int size = outputDex.getMethodIds().items().size();
        int size2 = outputDex.getFieldIds().items().size();
        int size3 = outputDex.getTypeIds().items().size();
        int size4 = directClassFile4.getConstantPool().size();
        if (args.multiDex && (size + size4 > args.maxNumberOfIdxPerDex || size2 + size4 > args.maxNumberOfIdxPerDex || 7 + size3 + size4 > args.maxNumberOfIdxPerDex)) {
            createDexFile();
        }
        try {
            ClassDefItem translate = CfTranslator.translate(directClassFile4, bArr2, args.cfOptions, args.dexOptions, outputDex);
            dexFile = outputDex;
            synchronized (dexFile) {
                outputDex.add(translate);
            }
            return true;
        } catch (ParseException e) {
            ParseException parseException = e;
            DxConsole.err.println("\ntrouble processing:");
            if (args.debug) {
                parseException.printStackTrace(DxConsole.err);
            } else {
                parseException.printContext(DxConsole.err);
            }
            errors = 1 + errors;
            return false;
        } catch (Throwable th) {
            Throwable th2 = th;
            DexFile dexFile2 = dexFile;
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    public static boolean processFileBytes(String str, long j, byte[] bArr) {
        StringBuilder sb;
        StringBuilder sb2;
        String str2 = str;
        long j2 = j;
        byte[] bArr2 = bArr;
        boolean endsWith = str2.endsWith(".class");
        boolean equals = str2.equals(DexFormat.DEX_IN_JAR_NAME);
        boolean z = outputResources != null;
        if (endsWith || equals || z) {
            if (args.verbose) {
                PrintStream printStream = DxConsole.out;
                StringBuilder sb3 = sb;
                StringBuilder sb4 = new StringBuilder();
                printStream.println(sb3.append("processing ").append(str2).append("...").toString());
            }
            String fixPath = fixPath(str2);
            if (endsWith) {
                if (z && args.keepClassesInJar) {
                    TreeMap<String, byte[]> treeMap = outputResources;
                    synchronized (treeMap) {
                        try {
                            Object put = outputResources.put(fixPath, bArr2);
                        } catch (Throwable th) {
                            while (true) {
                                Throwable th2 = th;
                                TreeMap<String, byte[]> treeMap2 = treeMap;
                                throw th2;
                            }
                        }
                    }
                }
                if (j2 < minimumFileAge) {
                    return true;
                }
                return processClass(fixPath, bArr2);
            } else if (equals) {
                List<byte[]> list = libraryDexBuffers;
                synchronized (list) {
                    try {
                        boolean add = libraryDexBuffers.add(bArr2);
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        List<byte[]> list2 = list;
                        throw th4;
                    }
                }
                return true;
            } else {
                TreeMap<String, byte[]> treeMap3 = outputResources;
                synchronized (treeMap3) {
                    try {
                        Object put2 = outputResources.put(fixPath, bArr2);
                    } catch (Throwable th5) {
                        Throwable th6 = th5;
                        TreeMap<String, byte[]> treeMap4 = treeMap3;
                        throw th6;
                    }
                }
                return true;
            }
        } else {
            if (args.verbose) {
                PrintStream printStream2 = DxConsole.out;
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                printStream2.println(sb5.append("ignored resource ").append(str2).toString());
            }
            return false;
        }
    }

    private static boolean processOne(String str, FileNameFilter fileNameFilter) {
        ClassPathOpener classPathOpener;
        C06571 r9;
        ClassPathOpener classPathOpener2 = classPathOpener;
        String str2 = str;
        FileNameFilter fileNameFilter2 = fileNameFilter;
        C06571 r7 = r9;
        C06571 r8 = new Consumer() {
            public void onException(Exception exc) {
                StringBuilder sb;
                Exception exc2 = exc;
                if (exc2 instanceof StopProcessing) {
                    throw ((StopProcessing) exc2);
                }
                if (exc2 instanceof SimException) {
                    DxConsole.err.println("\nEXCEPTION FROM SIMULATION:");
                    PrintStream printStream = DxConsole.err;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    printStream.println(sb2.append(exc2.getMessage()).append("\n").toString());
                    DxConsole.err.println(((SimException) exc2).getContext());
                } else {
                    DxConsole.err.println("\nUNEXPECTED TOP-LEVEL EXCEPTION:");
                    exc2.printStackTrace(DxConsole.err);
                }
                int access$708 = Main.access$708();
            }

            public void onProcessArchiveStart(File file) {
                StringBuilder sb;
                File file2 = file;
                if (Main.args.verbose) {
                    PrintStream printStream = DxConsole.out;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    printStream.println(sb2.append("processing archive ").append(file2).append("...").toString());
                }
            }

            public boolean processFileBytes(String str, long j, byte[] bArr) {
                ParallelProcessor parallelProcessor;
                String str2 = str;
                long j2 = j;
                byte[] bArr2 = bArr;
                if (Main.args.numThreads <= 1) {
                    return Main.processFileBytes(str2, j2, bArr2);
                }
                ExecutorService access$500 = Main.threadPool;
                ParallelProcessor parallelProcessor2 = parallelProcessor;
                ParallelProcessor parallelProcessor3 = new ParallelProcessor(str2, j2, bArr2, null);
                access$500.execute(parallelProcessor2);
                return false;
            }
        };
        ClassPathOpener classPathOpener3 = new ClassPathOpener(str2, false, fileNameFilter2, r7);
        return classPathOpener2.process();
    }

    /* JADX INFO: finally extract failed */
    public static int run(Arguments arguments) throws IOException {
        OutputStream outputStream;
        OutputStreamWriter outputStreamWriter;
        Arguments arguments2 = arguments;
        errors = 0;
        libraryDexBuffers.clear();
        args = arguments2;
        args.makeOptionsObjects();
        if (args.humanOutName != null) {
            OutputStream openOutput = openOutput(args.humanOutName);
            OutputStreamWriter outputStreamWriter2 = outputStreamWriter;
            OutputStreamWriter outputStreamWriter3 = new OutputStreamWriter(openOutput);
            humanOutWriter = outputStreamWriter2;
            outputStream = openOutput;
        } else {
            outputStream = null;
        }
        try {
            if (args.multiDex) {
                int runMultiDex = runMultiDex();
                closeOutput(outputStream);
                return runMultiDex;
            }
            int runMonoDex = runMonoDex();
            closeOutput(outputStream);
            return runMonoDex;
        } catch (Throwable th) {
            Throwable th2 = th;
            closeOutput(outputStream);
            throw th2;
        }
    }

    private static int runMonoDex() throws IOException {
        File file;
        byte[] bArr;
        File file2;
        if (!args.incremental) {
            file = null;
        } else if (args.outName == null) {
            System.err.println("error: no incremental output name specified");
            return -1;
        } else {
            File file3 = file2;
            File file4 = new File(args.outName);
            file = file3;
            if (file.exists()) {
                minimumFileAge = file.lastModified();
            }
        }
        if (!processAllFiles()) {
            return 1;
        }
        if (args.incremental && !anyFilesProcessed) {
            return 0;
        }
        if (!outputDex.isEmpty() || args.humanOutName != null) {
            bArr = writeDex();
            if (bArr == null) {
                return 2;
            }
        } else {
            bArr = null;
        }
        if (args.incremental) {
            bArr = mergeIncremental(bArr, file);
        }
        byte[] mergeLibraryDexBuffers = mergeLibraryDexBuffers(bArr);
        if (args.jarOutput) {
            outputDex = null;
            if (mergeLibraryDexBuffers != null) {
                Object put = outputResources.put(DexFormat.DEX_IN_JAR_NAME, mergeLibraryDexBuffers);
            }
            if (!createJar(args.outName)) {
                return 3;
            }
        } else if (!(mergeLibraryDexBuffers == null || args.outName == null)) {
            OutputStream openOutput = openOutput(args.outName);
            openOutput.write(mergeLibraryDexBuffers);
            closeOutput(openOutput);
        }
        return 0;
    }

    private static int runMultiDex() throws IOException {
        int i;
        File file;
        FileOutputStream fileOutputStream;
        File file2;
        AssertionError assertionError;
        DexException dexException;
        AssertionError assertionError2;
        AssertionError assertionError3;
        if (!$assertionsDisabled && args.incremental) {
            AssertionError assertionError4 = assertionError3;
            AssertionError assertionError5 = new AssertionError();
            throw assertionError4;
        } else if ($assertionsDisabled || args.numThreads == 1) {
            if (args.mainDexListFile != null) {
                classesInMainDex = loadMainDexListFile(args.mainDexListFile);
            }
            if (!processAllFiles()) {
                i = 1;
            } else if (!libraryDexBuffers.isEmpty()) {
                DexException dexException2 = dexException;
                DexException dexException3 = new DexException("Library dex files are not supported in multi-dex mode");
                throw dexException2;
            } else {
                if (outputDex != null) {
                    boolean add = dexOutputArrays.add(writeDex());
                    outputDex = null;
                }
                if (args.jarOutput) {
                    for (int i2 = 0; i2 < dexOutputArrays.size(); i2++) {
                        Object put = outputResources.put(getDexFileName(i2), dexOutputArrays.get(i2));
                    }
                    i = 0;
                    if (!createJar(args.outName)) {
                        return 3;
                    }
                } else {
                    i = 0;
                    if (args.outName != null) {
                        File file3 = file;
                        File file4 = new File(args.outName);
                        File file5 = file3;
                        if ($assertionsDisabled || file5.isDirectory()) {
                            int i3 = 0;
                            while (true) {
                                i = 0;
                                if (i3 >= dexOutputArrays.size()) {
                                    break;
                                }
                                FileOutputStream fileOutputStream2 = fileOutputStream;
                                File file6 = file2;
                                File file7 = new File(file5, getDexFileName(i3));
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file6);
                                FileOutputStream fileOutputStream4 = fileOutputStream2;
                                try {
                                    fileOutputStream4.write((byte[]) dexOutputArrays.get(i3));
                                    closeOutput(fileOutputStream4);
                                    i3++;
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    closeOutput(fileOutputStream4);
                                    throw th2;
                                }
                            }
                        } else {
                            AssertionError assertionError6 = assertionError;
                            AssertionError assertionError7 = new AssertionError();
                            throw assertionError6;
                        }
                    }
                }
            }
            return i;
        } else {
            AssertionError assertionError8 = assertionError2;
            AssertionError assertionError9 = new AssertionError();
            throw assertionError8;
        }
    }

    /* JADX INFO: finally extract failed */
    private static byte[] writeDex() {
        StringBuilder sb;
        byte[] dex;
        try {
            if (args.methodToDump != null) {
                byte[] dex2 = outputDex.toDex(null, false);
                dumpMethod(outputDex, args.methodToDump, humanOutWriter);
                dex = null;
            } else {
                dex = outputDex.toDex(humanOutWriter, args.verboseDump);
            }
            if (args.statistics) {
                DxConsole.out.println(outputDex.getStatistics().toHuman());
            }
            if (humanOutWriter != null) {
                humanOutWriter.flush();
            }
            return dex;
        } catch (Exception e) {
            Exception exc = e;
            if (args.debug) {
                DxConsole.err.println("\ntrouble writing output:");
                exc.printStackTrace(DxConsole.err);
            } else {
                PrintStream printStream = DxConsole.err;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                printStream.println(sb2.append("\ntrouble writing output: ").append(exc.getMessage()).toString());
            }
            return null;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (humanOutWriter != null) {
                humanOutWriter.flush();
            }
            throw th2;
        }
    }
}
