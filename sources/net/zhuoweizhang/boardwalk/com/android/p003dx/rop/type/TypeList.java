package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeList */
public interface TypeList {
    Type getType(int i);

    int getWordCount();

    boolean isMutable();

    int size();

    TypeList withAddedType(Type type);
}
