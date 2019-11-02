package android.support.p000v4.content;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

/* renamed from: android.support.v4.content.SharedPreferencesCompat */
public class SharedPreferencesCompat {

    /* renamed from: android.support.v4.content.SharedPreferencesCompat$EditorCompat */
    public static class EditorCompat {
        private static EditorCompat sInstance;
        private final Helper mHelper;

        /* renamed from: android.support.v4.content.SharedPreferencesCompat$EditorCompat$EditorHelperApi9Impl */
        private static class EditorHelperApi9Impl implements Helper {
            private EditorHelperApi9Impl() {
            }

            /* synthetic */ EditorHelperApi9Impl(C00401 r4) {
                C00401 r1 = r4;
                this();
            }

            public void apply(@NonNull Editor editor) {
                EditorCompatGingerbread.apply(editor);
            }
        }

        /* renamed from: android.support.v4.content.SharedPreferencesCompat$EditorCompat$EditorHelperBaseImpl */
        private static class EditorHelperBaseImpl implements Helper {
            private EditorHelperBaseImpl() {
            }

            /* synthetic */ EditorHelperBaseImpl(C00401 r4) {
                C00401 r1 = r4;
                this();
            }

            public void apply(@NonNull Editor editor) {
                boolean commit = editor.commit();
            }
        }

        /* renamed from: android.support.v4.content.SharedPreferencesCompat$EditorCompat$Helper */
        private interface Helper {
            void apply(@NonNull Editor editor);
        }

        private EditorCompat() {
            EditorHelperBaseImpl editorHelperBaseImpl;
            EditorHelperApi9Impl editorHelperApi9Impl;
            if (VERSION.SDK_INT >= 9) {
                EditorHelperApi9Impl editorHelperApi9Impl2 = editorHelperApi9Impl;
                EditorHelperApi9Impl editorHelperApi9Impl3 = new EditorHelperApi9Impl(null);
                this.mHelper = editorHelperApi9Impl2;
                return;
            }
            EditorHelperBaseImpl editorHelperBaseImpl2 = editorHelperBaseImpl;
            EditorHelperBaseImpl editorHelperBaseImpl3 = new EditorHelperBaseImpl(null);
            this.mHelper = editorHelperBaseImpl2;
        }

        public static EditorCompat getInstance() {
            EditorCompat editorCompat;
            if (sInstance == null) {
                EditorCompat editorCompat2 = editorCompat;
                EditorCompat editorCompat3 = new EditorCompat();
                sInstance = editorCompat2;
            }
            return sInstance;
        }

        public void apply(@NonNull Editor editor) {
            Editor editor2 = editor;
            this.mHelper.apply(editor2);
        }
    }

    public SharedPreferencesCompat() {
    }
}
