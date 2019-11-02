package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityControl;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ToHuman;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.Annotation */
public final class Annotation extends MutabilityControl implements Comparable<Annotation>, ToHuman {
    private final TreeMap<CstString, NameValuePair> elements;
    private final CstType type;
    private final AnnotationVisibility visibility;

    public Annotation(CstType cstType, AnnotationVisibility annotationVisibility) {
        TreeMap<CstString, NameValuePair> treeMap;
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        CstType cstType2 = cstType;
        AnnotationVisibility annotationVisibility2 = annotationVisibility;
        if (cstType2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("type == null");
            throw nullPointerException3;
        } else if (annotationVisibility2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("visibility == null");
            throw nullPointerException5;
        } else {
            this.type = cstType2;
            this.visibility = annotationVisibility2;
            TreeMap<CstString, NameValuePair> treeMap2 = treeMap;
            TreeMap<CstString, NameValuePair> treeMap3 = new TreeMap<>();
            this.elements = treeMap2;
        }
    }

    public void add(NameValuePair nameValuePair) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        NullPointerException nullPointerException;
        NameValuePair nameValuePair2 = nameValuePair;
        throwIfImmutable();
        if (nameValuePair2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("pair == null");
            throw nullPointerException2;
        }
        CstString name = nameValuePair2.getName();
        if (this.elements.get(name) != null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("name already added: ").append(name).toString());
            throw illegalArgumentException2;
        }
        Object put = this.elements.put(name, nameValuePair2);
    }

    public int compareTo(Annotation annotation) {
        Annotation annotation2 = annotation;
        int compareTo = this.type.compareTo((Constant) annotation2.type);
        if (compareTo == 0) {
            compareTo = this.visibility.compareTo(annotation2.visibility);
            if (compareTo == 0) {
                Iterator it = this.elements.values().iterator();
                Iterator it2 = annotation2.elements.values().iterator();
                while (it.hasNext() && it2.hasNext()) {
                    int compareTo2 = ((NameValuePair) it.next()).compareTo((NameValuePair) it2.next());
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                }
                if (it.hasNext()) {
                    return 1;
                }
                return it2.hasNext() ? -1 : 0;
            }
        }
        return compareTo;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof Annotation) {
            Annotation annotation = (Annotation) obj2;
            if (this.type.equals(annotation.type) && this.visibility == annotation.visibility) {
                return this.elements.equals(annotation.elements);
            }
        }
        return false;
    }

    public Collection<NameValuePair> getNameValuePairs() {
        return Collections.unmodifiableCollection(this.elements.values());
    }

    public CstType getType() {
        return this.type;
    }

    public AnnotationVisibility getVisibility() {
        return this.visibility;
    }

    public int hashCode() {
        return (31 * ((31 * this.type.hashCode()) + this.elements.hashCode())) + this.visibility.hashCode();
    }

    public void put(NameValuePair nameValuePair) {
        NullPointerException nullPointerException;
        NameValuePair nameValuePair2 = nameValuePair;
        throwIfImmutable();
        if (nameValuePair2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("pair == null");
            throw nullPointerException2;
        }
        Object put = this.elements.put(nameValuePair2.getName(), nameValuePair2);
    }

    public String toHuman() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(this.visibility.toHuman());
        StringBuilder append2 = sb4.append("-annotation ");
        StringBuilder append3 = sb4.append(this.type.toHuman());
        StringBuilder append4 = sb4.append(" {");
        boolean z = true;
        for (NameValuePair nameValuePair : this.elements.values()) {
            if (z) {
                z = false;
            } else {
                StringBuilder append5 = sb4.append(", ");
            }
            StringBuilder append6 = sb4.append(nameValuePair.getName().toHuman());
            StringBuilder append7 = sb4.append(": ");
            StringBuilder append8 = sb4.append(nameValuePair.getValue().toHuman());
        }
        StringBuilder append9 = sb4.append("}");
        return sb4.toString();
    }

    public String toString() {
        return toHuman();
    }
}
