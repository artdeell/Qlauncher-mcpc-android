package android.support.p000v4.speech.tts;

import android.content.Context;
import android.os.Build.VERSION;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;

/* renamed from: android.support.v4.speech.tts.TextToSpeechICS */
class TextToSpeechICS {
    private static final String TAG = "android.support.v4.speech.tts";

    TextToSpeechICS() {
    }

    static TextToSpeech construct(Context context, OnInitListener onInitListener, String str) {
        TextToSpeech textToSpeech;
        TextToSpeech textToSpeech2;
        TextToSpeech textToSpeech3;
        Context context2 = context;
        OnInitListener onInitListener2 = onInitListener;
        String str2 = str;
        if (VERSION.SDK_INT >= 14) {
            TextToSpeech textToSpeech4 = textToSpeech;
            TextToSpeech textToSpeech5 = new TextToSpeech(context2, onInitListener2, str2);
            return textToSpeech4;
        } else if (str2 == null) {
            TextToSpeech textToSpeech6 = textToSpeech3;
            TextToSpeech textToSpeech7 = new TextToSpeech(context2, onInitListener2);
            return textToSpeech6;
        } else {
            int w = Log.w(TAG, "Can't specify tts engine on this device");
            TextToSpeech textToSpeech8 = textToSpeech2;
            TextToSpeech textToSpeech9 = new TextToSpeech(context2, onInitListener2);
            return textToSpeech8;
        }
    }
}
