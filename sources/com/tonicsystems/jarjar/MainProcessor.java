package com.tonicsystems.jarjar;

import com.tonicsystems.jarjar.util.EntryStruct;
import com.tonicsystems.jarjar.util.JarProcessor;
import com.tonicsystems.jarjar.util.JarProcessorChain;
import com.tonicsystems.jarjar.util.JarTransformerChain;
import com.tonicsystems.jarjar.util.RemappingClassTransformer;
import com.tonicsystems.jarjar.util.StandaloneJarProcessor;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MainProcessor implements JarProcessor {
    private final JarProcessorChain chain;

    /* renamed from: kp */
    private final KeepProcessor f16kp;
    private final Map<String, String> renames;
    private final boolean verbose;

    public MainProcessor(List<PatternElement> list, boolean z, boolean z2) {
        HashMap hashMap;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        PackageRemapper packageRemapper;
        KeepProcessor keepProcessor;
        KeepProcessor keepProcessor2;
        ArrayList arrayList4;
        ZapProcessor zapProcessor;
        RemappingClassTransformer remappingClassTransformer;
        JarTransformerChain jarTransformerChain;
        ResourceProcessor resourceProcessor;
        JarProcessorChain jarProcessorChain;
        List<PatternElement> list2 = list;
        boolean z3 = z;
        boolean z4 = z2;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.renames = hashMap2;
        this.verbose = z3;
        ArrayList arrayList5 = arrayList;
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = arrayList5;
        ArrayList arrayList8 = arrayList2;
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = arrayList8;
        ArrayList arrayList11 = arrayList3;
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = arrayList11;
        for (PatternElement patternElement : list2) {
            if (patternElement instanceof Zap) {
                boolean add = arrayList7.add((Zap) patternElement);
            } else if (patternElement instanceof Rule) {
                boolean add2 = arrayList10.add((Rule) patternElement);
            } else if (patternElement instanceof Keep) {
                boolean add3 = arrayList13.add((Keep) patternElement);
            }
        }
        PackageRemapper packageRemapper2 = packageRemapper;
        PackageRemapper packageRemapper3 = new PackageRemapper(arrayList10, z3);
        PackageRemapper packageRemapper4 = packageRemapper2;
        if (arrayList13.isEmpty()) {
            keepProcessor2 = null;
        } else {
            KeepProcessor keepProcessor3 = keepProcessor;
            KeepProcessor keepProcessor4 = new KeepProcessor(arrayList13);
            keepProcessor2 = keepProcessor3;
        }
        this.f16kp = keepProcessor2;
        ArrayList arrayList14 = arrayList4;
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = arrayList14;
        if (z4) {
            boolean add4 = arrayList16.add(ManifestProcessor.getInstance());
        }
        if (this.f16kp != null) {
            boolean add5 = arrayList16.add(this.f16kp);
        }
        ArrayList arrayList17 = arrayList16;
        ZapProcessor zapProcessor2 = zapProcessor;
        ZapProcessor zapProcessor3 = new ZapProcessor(arrayList7);
        boolean add6 = arrayList17.add(zapProcessor2);
        RemappingClassTransformer[] remappingClassTransformerArr = new RemappingClassTransformer[1];
        RemappingClassTransformer[] remappingClassTransformerArr2 = remappingClassTransformerArr;
        RemappingClassTransformer remappingClassTransformer2 = remappingClassTransformer;
        RemappingClassTransformer remappingClassTransformer3 = new RemappingClassTransformer(packageRemapper4);
        remappingClassTransformerArr2[0] = remappingClassTransformer2;
        ArrayList arrayList18 = arrayList16;
        JarTransformerChain jarTransformerChain2 = jarTransformerChain;
        JarTransformerChain jarTransformerChain3 = new JarTransformerChain(remappingClassTransformerArr);
        boolean add7 = arrayList18.add(jarTransformerChain2);
        ArrayList arrayList19 = arrayList16;
        ResourceProcessor resourceProcessor2 = resourceProcessor;
        ResourceProcessor resourceProcessor3 = new ResourceProcessor(packageRemapper4);
        boolean add8 = arrayList19.add(resourceProcessor2);
        JarProcessorChain jarProcessorChain2 = jarProcessorChain;
        JarProcessorChain jarProcessorChain3 = new JarProcessorChain((JarProcessor[]) arrayList16.toArray(new JarProcessor[arrayList16.size()]));
        this.chain = jarProcessorChain2;
    }

    private Set<String> getExcludes() {
        HashSet hashSet;
        StringBuilder sb;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        for (String str : this.f16kp.getExcludes()) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            String sb4 = sb2.append(str).append(".class").toString();
            String str2 = (String) this.renames.get(sb4);
            if (str2 == null) {
                str2 = sb4;
            }
            boolean add = hashSet4.add(str2);
        }
        return hashSet4;
    }

    public boolean process(EntryStruct entryStruct) throws IOException {
        StringBuilder sb;
        StringBuilder sb2;
        EntryStruct entryStruct2 = entryStruct;
        String str = entryStruct2.name;
        boolean process = this.chain.process(entryStruct2);
        if (process) {
            if (!str.equals(entryStruct2.name)) {
                if (this.f16kp != null) {
                    Object put = this.renames.put(str, entryStruct2.name);
                }
                if (this.verbose) {
                    PrintStream printStream = System.err;
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    printStream.println(sb3.append("Renamed ").append(str).append(" -> ").append(entryStruct2.name).toString());
                }
            }
        } else if (this.verbose) {
            PrintStream printStream2 = System.err;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            printStream2.println(sb5.append("Removed ").append(str).toString());
            return process;
        }
        return process;
    }

    public void strip(File file) throws IOException {
        ExcludeProcessor excludeProcessor;
        File file2 = file;
        if (this.f16kp != null) {
            Set excludes = getExcludes();
            if (!excludes.isEmpty()) {
                File file3 = file2;
                File file4 = file2;
                ExcludeProcessor excludeProcessor2 = excludeProcessor;
                ExcludeProcessor excludeProcessor3 = new ExcludeProcessor(excludes, this.verbose);
                StandaloneJarProcessor.run(file3, file4, excludeProcessor2);
            }
        }
    }
}
