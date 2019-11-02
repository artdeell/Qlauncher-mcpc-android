package com.tonicsystems.jarjar;

import com.tonicsystems.jarjar.util.EntryStruct;
import com.tonicsystems.jarjar.util.JarProcessor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.commons.RemappingClassAdapter;

class KeepProcessor extends Remapper implements JarProcessor {
    private byte[] buf = new byte[8192];
    private Set<String> curSet;

    /* renamed from: cv */
    private final ClassVisitor f15cv;
    private final Map<String, Set<String>> depend;
    private final List<String> roots;
    private final List<Wildcard> wildcards;

    public KeepProcessor(List<Keep> list) {
        RemappingClassAdapter remappingClassAdapter;
        EmptyClassVisitor emptyClassVisitor;
        ArrayList arrayList;
        HashMap hashMap;
        List<Keep> list2 = list;
        RemappingClassAdapter remappingClassAdapter2 = remappingClassAdapter;
        EmptyClassVisitor emptyClassVisitor2 = emptyClassVisitor;
        EmptyClassVisitor emptyClassVisitor3 = new EmptyClassVisitor();
        RemappingClassAdapter remappingClassAdapter3 = new RemappingClassAdapter(emptyClassVisitor2, this);
        this.f15cv = remappingClassAdapter2;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.roots = arrayList2;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.depend = hashMap2;
        this.wildcards = PatternElement.createWildcards(list2);
    }

    private void closureHelper(Set<String> set, Collection<String> collection) {
        Set<String> set2 = set;
        Collection<String> collection2 = collection;
        if (collection2 != null) {
            for (String str : collection2) {
                if (set2.add(str)) {
                    closureHelper(set2, (Collection) this.depend.get(str));
                }
            }
        }
    }

    private static boolean isForName(String str) {
        String str2 = str;
        if (!str2.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
            int i = 0;
            int length = str2.length();
            while (i < length) {
                char charAt = str2.charAt(i);
                if (charAt == '.' || Character.isJavaIdentifierPart(charAt)) {
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    public Set<String> getExcludes() {
        HashSet hashSet;
        HashSet hashSet2;
        HashSet hashSet3 = hashSet;
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = hashSet3;
        closureHelper(hashSet5, this.roots);
        HashSet hashSet6 = hashSet2;
        HashSet hashSet7 = new HashSet(this.depend.keySet());
        HashSet hashSet8 = hashSet6;
        boolean removeAll = hashSet8.removeAll(hashSet5);
        return hashSet8;
    }

    public boolean isEnabled() {
        return !this.wildcards.isEmpty();
    }

    public String map(String str) {
        String str2 = str;
        if (str2.startsWith("java/") || str2.startsWith("javax/")) {
            return null;
        }
        boolean add = this.curSet.add(str2);
        return null;
    }

    public Object mapValue(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof String)) {
            return super.mapValue(obj2);
        }
        String str = (String) obj2;
        if (PackageRemapper.isArrayForName(str)) {
            String mapDesc = mapDesc(str.replace('.', ClassPathElement.SEPARATOR_CHAR));
        } else if (isForName(str)) {
            String map = map(str.replace('.', ClassPathElement.SEPARATOR_CHAR));
            return obj2;
        }
        return obj2;
    }

    public boolean process(EntryStruct entryStruct) throws IOException {
        StringBuilder sb;
        HashSet hashSet;
        ClassReader classReader;
        ByteArrayInputStream byteArrayInputStream;
        EntryStruct entryStruct2 = entryStruct;
        try {
            if (entryStruct2.name.endsWith(".class")) {
                String substring = entryStruct2.name.substring(0, -6 + entryStruct2.name.length());
                for (Wildcard matches : this.wildcards) {
                    if (matches.matches(substring)) {
                        boolean add = this.roots.add(substring);
                    }
                }
                Map<String, Set<String>> map = this.depend;
                HashSet hashSet2 = hashSet;
                HashSet hashSet3 = new HashSet();
                HashSet hashSet4 = hashSet2;
                this.curSet = hashSet4;
                Object put = map.put(substring, hashSet4);
                ClassReader classReader2 = classReader;
                ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(entryStruct2.data);
                ClassReader classReader3 = new ClassReader((InputStream) byteArrayInputStream2);
                classReader2.accept(this.f15cv, 8);
                boolean remove = this.curSet.remove(substring);
            }
        } catch (Exception e) {
            Exception exc = e;
            PrintStream printStream = System.err;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("Error reading ").append(entryStruct2.name).append(": ").append(exc.getMessage()).toString());
        }
        return true;
    }
}
