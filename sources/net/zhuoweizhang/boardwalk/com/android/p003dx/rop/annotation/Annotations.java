package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityControl;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.Annotations */
public final class Annotations extends MutabilityControl implements Comparable<Annotations> {
    public static final Annotations EMPTY;
    private final TreeMap<CstType, Annotation> annotations;

    static {
        Annotations annotations2;
        Annotations annotations3 = annotations2;
        Annotations annotations4 = new Annotations();
        EMPTY = annotations3;
        EMPTY.setImmutable();
    }

    public Annotations() {
        TreeMap<CstType, Annotation> treeMap;
        TreeMap<CstType, Annotation> treeMap2 = treeMap;
        TreeMap<CstType, Annotation> treeMap3 = new TreeMap<>();
        this.annotations = treeMap2;
    }

    public static Annotations combine(Annotations annotations2, Annotation annotation) {
        Annotations annotations3;
        Annotations annotations4 = annotations2;
        Annotation annotation2 = annotation;
        Annotations annotations5 = annotations3;
        Annotations annotations6 = new Annotations();
        Annotations annotations7 = annotations5;
        annotations7.addAll(annotations4);
        annotations7.add(annotation2);
        annotations7.setImmutable();
        return annotations7;
    }

    public static Annotations combine(Annotations annotations2, Annotations annotations3) {
        Annotations annotations4;
        Annotations annotations5 = annotations2;
        Annotations annotations6 = annotations3;
        Annotations annotations7 = annotations4;
        Annotations annotations8 = new Annotations();
        Annotations annotations9 = annotations7;
        annotations9.addAll(annotations5);
        annotations9.addAll(annotations6);
        annotations9.setImmutable();
        return annotations9;
    }

    public void add(Annotation annotation) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        NullPointerException nullPointerException;
        Annotation annotation2 = annotation;
        throwIfImmutable();
        if (annotation2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("annotation == null");
            throw nullPointerException2;
        }
        CstType type = annotation2.getType();
        if (this.annotations.containsKey(type)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("duplicate type: ").append(type.toHuman()).toString());
            throw illegalArgumentException2;
        }
        Object put = this.annotations.put(type, annotation2);
    }

    public void addAll(Annotations annotations2) {
        NullPointerException nullPointerException;
        Annotations annotations3 = annotations2;
        throwIfImmutable();
        if (annotations3 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("toAdd == null");
            throw nullPointerException2;
        }
        for (Annotation add : annotations3.annotations.values()) {
            add(add);
        }
    }

    public int compareTo(Annotations annotations2) {
        Annotations annotations3 = annotations2;
        Iterator it = this.annotations.values().iterator();
        Iterator it2 = annotations3.annotations.values().iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compareTo = ((Annotation) it.next()).compareTo((Annotation) it2.next());
            if (compareTo != 0) {
                return compareTo;
            }
        }
        if (it.hasNext()) {
            return 1;
        }
        return it2.hasNext() ? -1 : 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof Annotations)) {
            return false;
        }
        return this.annotations.equals(((Annotations) obj2).annotations);
    }

    public Collection<Annotation> getAnnotations() {
        return Collections.unmodifiableCollection(this.annotations.values());
    }

    public int hashCode() {
        return this.annotations.hashCode();
    }

    public int size() {
        return this.annotations.size();
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("annotations{");
        boolean z = true;
        for (Annotation annotation : this.annotations.values()) {
            if (z) {
                z = false;
            } else {
                StringBuilder append2 = sb4.append(", ");
            }
            StringBuilder append3 = sb4.append(annotation.toHuman());
        }
        StringBuilder append4 = sb4.append("}");
        return sb4.toString();
    }
}
