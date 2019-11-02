package android.support.p000v4.content;

import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;

/* renamed from: android.support.v4.content.EditorCompatGingerbread */
class EditorCompatGingerbread {
    EditorCompatGingerbread() {
    }

    public static void apply(@NonNull Editor editor) {
        Editor editor2 = editor;
        try {
            editor2.apply();
        } catch (AbstractMethodError e) {
            AbstractMethodError abstractMethodError = e;
            boolean commit = editor2.commit();
        }
    }
}
