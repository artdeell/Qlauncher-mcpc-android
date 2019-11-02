package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Prototype;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.ProtoIdItem */
public final class ProtoIdItem extends IndexedItem {
    private TypeListItem parameterTypes;
    private final Prototype prototype;
    private final CstString shortForm;

    public ProtoIdItem(Prototype prototype2) {
        TypeListItem typeListItem;
        TypeListItem typeListItem2;
        NullPointerException nullPointerException;
        Prototype prototype3 = prototype2;
        if (prototype3 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("prototype == null");
            throw nullPointerException2;
        }
        this.prototype = prototype3;
        this.shortForm = makeShortForm(prototype3);
        StdTypeList parameterTypes2 = prototype3.getParameterTypes();
        if (parameterTypes2.size() == 0) {
            typeListItem2 = null;
        } else {
            TypeListItem typeListItem3 = typeListItem;
            TypeListItem typeListItem4 = new TypeListItem(parameterTypes2);
            typeListItem2 = typeListItem3;
        }
        this.parameterTypes = typeListItem2;
    }

    private static CstString makeShortForm(Prototype prototype2) {
        StringBuilder sb;
        CstString cstString;
        Prototype prototype3 = prototype2;
        StdTypeList parameterTypes2 = prototype3.getParameterTypes();
        int size = parameterTypes2.size();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(size + 1);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(shortFormCharFor(prototype3.getReturnType()));
        for (int i = 0; i < size; i++) {
            StringBuilder append2 = sb4.append(shortFormCharFor(parameterTypes2.getType(i)));
        }
        CstString cstString2 = cstString;
        CstString cstString3 = new CstString(sb4.toString());
        return cstString2;
    }

    private static char shortFormCharFor(Type type) {
        char charAt = type.getDescriptor().charAt(0);
        if (charAt == '[') {
            charAt = 'L';
        }
        return charAt;
    }

    public void addContents(DexFile dexFile) {
        DexFile dexFile2 = dexFile;
        StringIdsSection stringIds = dexFile2.getStringIds();
        TypeIdsSection typeIds = dexFile2.getTypeIds();
        MixedItemSection typeLists = dexFile2.getTypeLists();
        TypeIdItem intern = typeIds.intern(this.prototype.getReturnType());
        StringIdItem intern2 = stringIds.intern(this.shortForm);
        if (this.parameterTypes != null) {
            this.parameterTypes = (TypeListItem) typeLists.intern(this.parameterTypes);
        }
    }

    public ItemType itemType() {
        return ItemType.TYPE_PROTO_ID_ITEM;
    }

    public int writeSize() {
        return 12;
    }

    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int indexOf = dexFile2.getStringIds().indexOf(this.shortForm);
        int indexOf2 = dexFile2.getTypeIds().indexOf(this.prototype.getReturnType());
        int absoluteOffsetOr0 = OffsettedItem.getAbsoluteOffsetOr0(this.parameterTypes);
        if (annotatedOutput2.annotates()) {
            StringBuilder sb6 = sb;
            StringBuilder sb7 = new StringBuilder();
            StringBuilder sb8 = sb6;
            StringBuilder append = sb8.append(this.prototype.getReturnType().toHuman());
            StringBuilder append2 = sb8.append(" proto(");
            StdTypeList parameterTypes2 = this.prototype.getParameterTypes();
            int size = parameterTypes2.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    StringBuilder append3 = sb8.append(", ");
                }
                StringBuilder append4 = sb8.append(parameterTypes2.getType(i).toHuman());
            }
            StringBuilder append5 = sb8.append(")");
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb9 = sb2;
            StringBuilder sb10 = new StringBuilder();
            annotatedOutput3.annotate(0, sb9.append(indexString()).append(' ').append(sb8.toString()).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb11 = sb3;
            StringBuilder sb12 = new StringBuilder();
            annotatedOutput4.annotate(4, sb11.append("  shorty_idx:      ").append(Hex.m53u4(indexOf)).append(" // ").append(this.shortForm.toQuoted()).toString());
            AnnotatedOutput annotatedOutput5 = annotatedOutput2;
            StringBuilder sb13 = sb4;
            StringBuilder sb14 = new StringBuilder();
            annotatedOutput5.annotate(4, sb13.append("  return_type_idx: ").append(Hex.m53u4(indexOf2)).append(" // ").append(this.prototype.getReturnType().toHuman()).toString());
            AnnotatedOutput annotatedOutput6 = annotatedOutput2;
            StringBuilder sb15 = sb5;
            StringBuilder sb16 = new StringBuilder();
            annotatedOutput6.annotate(4, sb15.append("  parameters_off:  ").append(Hex.m53u4(absoluteOffsetOr0)).toString());
        }
        annotatedOutput2.writeInt(indexOf);
        annotatedOutput2.writeInt(indexOf2);
        annotatedOutput2.writeInt(absoluteOffsetOr0);
    }
}
