package com.tonicsystems.jarjar;

import java.util.ArrayList;
import java.util.List;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public abstract class PatternElement {
    private String pattern;

    public PatternElement() {
    }

    static List<Wildcard> createWildcards(List<? extends PatternElement> list) {
        ArrayList arrayList;
        IllegalArgumentException illegalArgumentException;
        Wildcard wildcard;
        List<? extends PatternElement> list2 = list;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (PatternElement patternElement : list2) {
            String str = patternElement instanceof Rule ? ((Rule) patternElement).getResult() : LibrariesRepository.MOJANG_MAVEN_REPO;
            String pattern2 = patternElement.getPattern();
            if (pattern2.indexOf(47) >= 0) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Patterns cannot contain slashes");
                throw illegalArgumentException2;
            }
            ArrayList arrayList5 = arrayList4;
            Wildcard wildcard2 = wildcard;
            Wildcard wildcard3 = new Wildcard(pattern2.replace('.', ClassPathElement.SEPARATOR_CHAR), str);
            boolean add = arrayList5.add(wildcard2);
        }
        return arrayList4;
    }

    public String getPattern() {
        return this.pattern;
    }

    public void setPattern(String str) {
        String str2 = str;
        this.pattern = str2;
    }
}
